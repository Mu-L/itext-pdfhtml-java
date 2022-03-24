/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2022 iText Group NV
    Authors: Bruno Lowagie, Paulo Soares, et al.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License version 3
    as published by the Free Software Foundation with the addition of the
    following permission added to Section 15 as permitted in Section 7(a):
    FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
    ITEXT GROUP. ITEXT GROUP DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
    OF THIRD PARTY RIGHTS

    This program is distributed in the hope that it will be useful, but
    WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
    or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU Affero General Public License for more details.
    You should have received a copy of the GNU Affero General Public License
    along with this program; if not, see http://www.gnu.org/licenses or write to
    the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
    Boston, MA, 02110-1301 USA, or download the license from the following URL:
    http://itextpdf.com/terms-of-use/

    The interactive user interfaces in modified source and object code versions
    of this program must display Appropriate Legal Notices, as required under
    Section 5 of the GNU Affero General Public License.

    In accordance with Section 7(b) of the GNU Affero General Public License,
    a covered work must retain the producer line in every PDF that is created
    or manipulated using iText.

    You can be released from the requirements of the license by purchasing
    a commercial license. Buying such a license is mandatory as soon as you
    develop commercial activities involving the iText software without
    disclosing the source code of your own applications.
    These activities include: offering paid services to customers as an ASP,
    serving PDFs on the fly in a web application, shipping iText with a closed
    source product.

    For more information, please contact iText Software Corp. at this
    address: sales@itextpdf.com
 */
package com.itextpdf.html2pdf.attach.impl.layout;

import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.tagging.StandardRoles;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.properties.Background;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.UnitValue;

import java.util.HashMap;
import java.util.Map;

/**
 * This handler draws backgrounds and borders for html, body and page-annotation styles.
 */
class HtmlBodyStylesApplierHandler implements IEventHandler {

    private final HtmlDocumentRenderer htmlDocumentRenderer;
    private final Map<Integer, PageStylesProperties> pageStylesPropertiesMap;
    private PdfCanvas pdfCanvas;

    /**
     * Constructor for HtmlBodyStylesApplierHandler.
     *
     * @param htmlDocumentRenderer {@link HtmlDocumentRenderer}
     * @param pageStylesPropertiesMap {@link PageStylesProperties} map that contains styles for html and body elements
     */
    public HtmlBodyStylesApplierHandler(HtmlDocumentRenderer htmlDocumentRenderer,
            Map<Integer, PageStylesProperties> pageStylesPropertiesMap) {
        this.htmlDocumentRenderer = htmlDocumentRenderer;
        this.pageStylesPropertiesMap = pageStylesPropertiesMap;
    }

    @Override
    public void handleEvent(Event event) {
        if (!(event instanceof PdfDocumentEvent)) {
            return;
        }
        PdfPage page = ((PdfDocumentEvent) event).getPage();
        int pageNumber = ((PdfDocumentEvent) event).getDocument().getPageNumber(page);
        processPage(page, pageNumber);
    }

    void processPage(PdfPage page, int pageNumber) {
        PageStylesProperties pageProperties = pageStylesPropertiesMap.get(pageNumber);
        if (pageProperties == null) {
            return;
        }
        PageContextProcessor contextProcessor = htmlDocumentRenderer.getPageProcessor(pageNumber);
        pdfCanvas = contextProcessor.drawPageBackground(page);
        applyHtmlBodyStyles(page, contextProcessor.computeLayoutMargins(), pageProperties.styles, pageNumber);
        pdfCanvas = null;
    }

    private void applyHtmlBodyStyles(PdfPage page, float[] margins, BodyHtmlStylesContainer[] styles, int pageNumber) {
        int firstBackground = applyFirstBackground(page, margins, styles, pageNumber);
        boolean htmlHasBackground = false;
        for (int i = 0; i < 2; i++) {
            if (styles[i] != null) {
                if (i == 1) {
                    htmlHasBackground = styles[0] != null && (styles[0].hasOwnProperty(Property.BACKGROUND)
                            || styles[0].hasOwnProperty(Property.BACKGROUND_IMAGE));
                }
                if (styles[i].hasContentToDraw()) {
                    drawSimulatedDiv(page, styles[i].properties, margins, firstBackground != i,
                            pageNumber, htmlHasBackground);
                }
                for (int j = 0; j < 4; j++) {
                    margins[j] += styles[i].getTotalWidth()[j];
                }
            }
        }
    }

    /**
     * If html doesn't have a background and the body has, then body background must be drawn on the whole page.
     * Also for case when html doesn't have a background, but has borders,
     * then body's background must be under the html's borders.
     */
    private int applyFirstBackground(PdfPage page, float[] margins, BodyHtmlStylesContainer[] styles, int pageNumber) {
        int firstBackground = -1;
        if (styles[0] != null && (styles[0].<Background>getOwnProperty(Property.BACKGROUND) != null ||
                styles[0].<Object>getOwnProperty(Property.BACKGROUND_IMAGE) != null)) {
            firstBackground = 0;
        } else if (styles[1] != null && (styles[1].<Background>getOwnProperty(Property.BACKGROUND) != null ||
                styles[1].<Object>getOwnProperty(Property.BACKGROUND_IMAGE) != null)) {
            firstBackground = 1;
        }
        if (firstBackground != -1) {
            HashMap<Integer, Object> background = new HashMap<>();
            background.put(Property.BACKGROUND, styles[firstBackground].<Background>getProperty(Property.BACKGROUND));
            background.put(Property.BACKGROUND_IMAGE,
                    styles[firstBackground].<Object>getProperty(Property.BACKGROUND_IMAGE));
            drawSimulatedDiv(page, background, margins, true, pageNumber, false);
        }
        return firstBackground;
    }

    private void drawSimulatedDiv(PdfPage page, Map<Integer, Object> styles, float[] margins,
            boolean drawBackground, int pageNumber, boolean recalculateBodyAreaForContentSize) {
        Div pageBordersSimulation = new Div().setFillAvailableArea(true);
        for (Map.Entry<Integer, Object> entry : styles.entrySet()) {
            if ((entry.getKey() == Property.BACKGROUND || entry.getKey() == Property.BACKGROUND_IMAGE)
                    && !drawBackground) {
                continue;
            }
            pageBordersSimulation.setProperty(entry.getKey(), entry.getValue());
        }
        pageBordersSimulation.getAccessibilityProperties().setRole(StandardRoles.ARTIFACT);
        Rectangle backgroundArea = new Rectangle(page.getTrimBox())
                .applyMargins(margins[0], margins[1], margins[2], margins[3], false);
        if (recalculateBodyAreaForContentSize) {
            if (pageStylesPropertiesMap.get(pageNumber).lowestAndHighest == null) {
                return;
            }
            LowestAndHighest lowestAndHighest = pageStylesPropertiesMap.get(pageNumber).lowestAndHighest;
            recalculateBackgroundAreaForBody(backgroundArea, pageBordersSimulation, lowestAndHighest);
        }

        if (pdfCanvas == null) {
            pdfCanvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), page.getDocument());
        }
        Canvas canvas = new Canvas(pdfCanvas, backgroundArea);
        canvas.enableAutoTagging(page);
        canvas.add(pageBordersSimulation);
        canvas.close();
    }

    private void recalculateBackgroundAreaForBody(Rectangle backgroundArea, Div pageBordersSimulation,
            LowestAndHighest lowestAndHighest) {
        UnitValue marginTop = pageBordersSimulation.<UnitValue>getOwnProperty(Property.MARGIN_TOP);
        UnitValue marginBottom = pageBordersSimulation.<UnitValue>getOwnProperty(Property.MARGIN_BOTTOM);
        float marginTopWidth = marginTop == null ? 0 : marginTop.getValue();
        float marginBottomWidth = marginBottom == null ? 0 : marginBottom.getValue();

        Border borderTop = pageBordersSimulation.<Border>getOwnProperty(Property.BORDER_TOP);
        Border borderBottom = pageBordersSimulation.<Border>getOwnProperty(Property.BORDER_BOTTOM);
        float borderTopWidth = borderTop == null ? 0 : borderTop.getWidth();
        float borderBottomWidth = borderBottom == null ? 0 : borderBottom.getWidth();

        UnitValue paddingTop = pageBordersSimulation.<UnitValue>getOwnProperty(Property.PADDING_TOP);
        UnitValue paddingBottom = pageBordersSimulation.<UnitValue>getOwnProperty(Property.PADDING_BOTTOM);
        float paddingTopWidth = paddingTop == null ? 0 : paddingTop.getValue();
        float paddingBottomWidth = paddingBottom == null ? 0 : paddingBottom.getValue();

        float oldHighest = backgroundArea.getY() + backgroundArea.getHeight();
        if (lowestAndHighest.lowest >= backgroundArea.getY()) {
            backgroundArea.setY(lowestAndHighest.lowest - paddingBottomWidth - borderBottomWidth - marginBottomWidth);
        }
        float newHighest = lowestAndHighest.highest - lowestAndHighest.lowest + paddingTopWidth + paddingBottomWidth
                + borderTopWidth + borderBottomWidth + marginTopWidth + marginBottomWidth + backgroundArea.getY();
        if (newHighest <= oldHighest) {
            backgroundArea.setHeight(newHighest - backgroundArea.getY());
        }
    }

    static class LowestAndHighest {
        float lowest;
        float highest;

        public LowestAndHighest(float lowest, float highest) {
            this.lowest = lowest;
            this.highest = highest;
        }
    }

    static class PageStylesProperties {
        BodyHtmlStylesContainer[] styles;
        LowestAndHighest lowestAndHighest;

        public PageStylesProperties(BodyHtmlStylesContainer[] styles) {
            this.styles = styles;
        }
    }
}
