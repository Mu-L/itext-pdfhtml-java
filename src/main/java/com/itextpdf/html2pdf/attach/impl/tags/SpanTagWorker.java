/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2025 Apryse Group NV
    Authors: Apryse Software.

    This program is offered under a commercial and under the AGPL license.
    For commercial licensing, contact us at https://itextpdf.com/sales.  For AGPL licensing, see below.

    AGPL licensing:
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.itextpdf.html2pdf.attach.impl.tags;

import com.itextpdf.html2pdf.attach.ITagWorker;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.attach.impl.layout.Html2PdfProperty;
import com.itextpdf.html2pdf.attach.util.AccessiblePropHelper;
import com.itextpdf.html2pdf.attach.util.WaitingInlineElementsHelper;
import com.itextpdf.html2pdf.attach.wrapelement.SpanWrapper;
import com.itextpdf.html2pdf.css.CssConstants;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.ILeafElement;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.tagging.IAccessibleElement;
import com.itextpdf.styledxmlparser.node.IElementNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TagWorker class for the {@code span} tag.
 */
public class SpanTagWorker implements ITagWorker, IDisplayAware {

    /** The span wrapper. */
    SpanWrapper spanWrapper;

    // TODO DEVSIX-2445. Ideally, this should be refactored. For now, I don't see a beautiful way
    //  of passing this information to other workers.
    // Also, we probably should wait a bit until the display support is more or less stable
    Map<IPropertyContainer, String> childrenDisplayMap = new HashMap<>();

    /** A list of elements belonging to the span. */
    private List<IPropertyContainer> elements;

    /** The own leaf elements. */
    private List<IPropertyContainer> ownLeafElements = new ArrayList<>();

    /** The helper object for waiting inline elements. */
    private WaitingInlineElementsHelper inlineHelper;

    /** The display value. */
    private final String display;

    /** The text-transform value. */
    private final String textTransform;

    /**
     * Creates a new {@link SpanTagWorker} instance.
     *
     * @param element the element
     * @param context the processor context
     */
    public SpanTagWorker(IElementNode element, ProcessorContext context) {
        spanWrapper = new SpanWrapper();
        Map<String, String> styles = element.getStyles();
        inlineHelper = new WaitingInlineElementsHelper(styles == null ? null : styles.get(CssConstants.WHITE_SPACE), styles == null ? null : styles.get(CssConstants.TEXT_TRANSFORM));
        display = styles == null ? null : styles.get(CssConstants.DISPLAY);
        textTransform = styles == null ? null : styles.get(CssConstants.TEXT_TRANSFORM);
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#processEnd(com.itextpdf.html2pdf.html.node.IElementNode, com.itextpdf.html2pdf.attach.ProcessorContext)
     */
    @Override
    public void processEnd(IElementNode element, ProcessorContext context) {
        if (inlineHelper.getWaitingLeaves().isEmpty() && spanWrapper.getElements().isEmpty()) {
            inlineHelper.add("");
        }
        flushInlineHelper();
        elements = spanWrapper.getElements();

        for (IPropertyContainer elem : elements) {
            if (elem instanceof IAccessibleElement) {
                AccessiblePropHelper.trySetLangAttribute((IAccessibleElement) elem, element);
            }
        }
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#processContent(java.lang.String, com.itextpdf.html2pdf.attach.ProcessorContext)
     */
    @Override
    public boolean processContent(String content, ProcessorContext context) {
        inlineHelper.add(content);
        return true;
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#processTagChild(com.itextpdf.html2pdf.attach.ITagWorker, com.itextpdf.html2pdf.attach.ProcessorContext)
     */
    @Override
    public boolean processTagChild(ITagWorker childTagWorker, ProcessorContext context) {
        IPropertyContainer element = childTagWorker.getElementResult();
        if (element instanceof ILeafElement) {
            flushInlineHelper();
            spanWrapper.add((ILeafElement) element);
            ownLeafElements.add(element);
            return true;
        } else if (childTagWorker instanceof SpanTagWorker) {
            flushInlineHelper();
            spanWrapper.add(((SpanTagWorker) childTagWorker).spanWrapper);
            childrenDisplayMap.putAll(((SpanTagWorker) childTagWorker).childrenDisplayMap);
            return true;
        } else if (childTagWorker.getElementResult() instanceof IBlockElement) {
            if (childTagWorker instanceof IDisplayAware) {
                String display = ((IDisplayAware) childTagWorker).getDisplay();
                childrenDisplayMap.put(childTagWorker.getElementResult(), display);
            }
            flushInlineHelper();
            spanWrapper.add((IBlockElement) childTagWorker.getElementResult());
            return true;
        }

        return false;
    }

    /**
     * Gets all the elements in the span.
     *
     * @return a list of elements
     */
    public List<IPropertyContainer> getAllElements() {
        return elements;
    }

    /**
     * Gets the span's own leaf elements.
     *
     * @return the own leaf elements
     */
    public List<IPropertyContainer> getOwnLeafElements() {
        return ownLeafElements;
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.ITagWorker#getElementResult()
     */
    @Override
    public IPropertyContainer getElementResult() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.itextpdf.html2pdf.attach.impl.tags.IDisplayAware#getDisplay()
     */
    @Override
    public String getDisplay() {
        return display;
    }

    /**
     * The child shall be one from {@link #getAllElements()} list.
     */
    String getElementDisplay(IPropertyContainer child) {
        return childrenDisplayMap.get(child);
    }

    /**
     * Flushes the waiting leaf elements.
     */
    private void flushInlineHelper() {
        Collection<IElement> waitingLeaves = inlineHelper.getWaitingLeaves();
        setCapitalizeProperty(waitingLeaves);
        spanWrapper.addAll(waitingLeaves);
        ownLeafElements.addAll(waitingLeaves);
        inlineHelper.clearWaitingLeaves();
    }

    /**
     * Sets property that indicates whether the element should be capitalized, for {@link Text} elements only.
     *
     * @param elements elements to which properties will be added
     */
    private void setCapitalizeProperty(Collection<IElement> elements) {
        for (IElement iElement : elements) {
            if (iElement instanceof Text) {
                if (!iElement.hasOwnProperty(Html2PdfProperty.CAPITALIZE_ELEMENT)
                        && CssConstants.CAPITALIZE.equals(textTransform)) {
                    iElement.setProperty(Html2PdfProperty.CAPITALIZE_ELEMENT, true);
                } else {
                    iElement.setProperty(Html2PdfProperty.CAPITALIZE_ELEMENT, false);
                }
            }
        }
    }
}
