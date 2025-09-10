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
package com.itextpdf.html2pdf.attach.impl;

import com.itextpdf.html2pdf.attach.DocumentTreeUtil;
import com.itextpdf.html2pdf.attach.IDocumentTreeJob;
import com.itextpdf.html2pdf.html.AttributeConstants;
import com.itextpdf.html2pdf.html.TagConstants;
import com.itextpdf.styledxmlparser.node.IElementNode;
import com.itextpdf.styledxmlparser.node.INode;
import com.itextpdf.styledxmlparser.node.ITextNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class keeps track of labels attached to applicable elements that present in the document.
 * After elements are proccessed, the DOM tree is scanned and labels are attached to corresponding objects.
 * This object in the {@link com.itextpdf.html2pdf.attach.ProcessorContext}.
 * <p>
 * This class is not reusable, and a new instance shall be created for every new conversion process.
 */
public class LabelContext implements IDocumentTreeJob {
    private final Map<String, String> idToDesc = new HashMap<>();
    private final Map<String, IElementNode> idToElement = new HashMap<>();
    private final LabelIdGenerator idGenerator = new LabelIdGenerator();

    /**
     * Creates new label context.
     */
    public LabelContext() {
        // Empty constructor, nothing to initialize
    }

    /**
     * Gets the alternate description for the element by id.
     *
     * @param id id of the element
     * @return alternate description
     */
    public String getAltDescription(String id) {
        String desc = idToDesc.get(id);
        return desc == null ? getTextRepresentation(idToElement.get(id)) : desc;
    }

    /**
     * Processes a given node to analyze and store potential labels.
     *
     * @param node the node to process
     * @param level the level of the node within the document tree
     */
    @Override
    public void process(INode node, int level) {
        if (node instanceof IElementNode) {
            IElementNode elem = (IElementNode) node;
            if (elem.getAttribute(AttributeConstants.ID) != null) {
                idToElement.put(((IElementNode) node).getAttribute(AttributeConstants.ID), (IElementNode) node);
            }
            if (TagConstants.LABEL.equals(elem.name())) {
                parseLabelDesc(elem);
            }
        }
    }

    private void parseLabelDesc(IElementNode elem) {
        if (elem.getAttribute(AttributeConstants.FOR) != null) {
            idToDesc.put(elem.getAttribute(AttributeConstants.FOR), getTextRepresentation(elem));
        } else {
            ImplicitLabelTextNodeCollector collector = new ImplicitLabelTextNodeCollector();
            DocumentTreeUtil.traverse(elem, Collections.singletonList((IDocumentTreeJob) collector));
            if (collector.getLabeledElement() != null) {
                String id = generateIdIfNotExists(collector.getLabeledElement());
                idToDesc.put(id, collector.getText());
            }
        }
    }

    private String generateIdIfNotExists(IElementNode labeledElement) {
        String id = labeledElement.getAttribute(AttributeConstants.ID);
        if (id == null) {
            String generatedId = idGenerator.generateId();
            labeledElement.getAttributes().setAttribute(AttributeConstants.ID, generatedId);
            return generatedId;
        }
        return id;
    }

    private static String getTextRepresentation(IElementNode elem) {
        if (elem == null) {
            return null;
        }
        SimpleTextNodeCollector collector = new SimpleTextNodeCollector();
        DocumentTreeUtil.traverse(elem, Collections.singletonList((IDocumentTreeJob)collector));
        return collector.getText();
    }

    /**
     * Class that collects all children text nodes of given node to a string.
     */
    private static final class SimpleTextNodeCollector implements IDocumentTreeJob {

        private final StringBuilder textBuilder = new StringBuilder();

        /**
         * Creates a new simple text node collector
         */
        public SimpleTextNodeCollector() {}

        @Override
        public void process(INode node, int level) {
            if (node instanceof ITextNode) {
                String text = ((ITextNode) node).wholeText();
                if (onlySpacesOrNewlines(text)) {
                    return;
                }
                textBuilder.append(text).append(' ');
            }
        }

        public String getText() {
            return textBuilder.toString();
        }

        private static boolean onlySpacesOrNewlines(String s) {
            if (s == null) {
                return true;
            }
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c != ' ' && c != '\n' && c != '\r'){
                    return false;
                }
            }
            return true;
        }

    }

    /**
     * Class that collects all children text nodes of the given node to a string except for the first encountered
     * labelable element.
     */
    private static final class ImplicitLabelTextNodeCollector implements IDocumentTreeJob {
        private IElementNode labeledElement = null;
        //3 states: -1 - labeled element not initialized, 0 - labeled element initialized,
        // > 0 - stack size snapshot before labeledElement processing
        private int stackSize = -1;
        private final SimpleTextNodeCollector collector = new SimpleTextNodeCollector();

        /**
         * Creates new text node collector for implicit labels.
         */
        public ImplicitLabelTextNodeCollector() {
        }

        @Override
        public void process(INode iNode, int level) {
            if (stackSize == level) {
                stackSize = -1;
            }
            if (stackSize == 0) {
                stackSize = level - labeledElement.childNodes().size();
            }
            if (stackSize >= 0) {
                return;
            }
            if (labeledElement == null
                    && iNode instanceof IElementNode
                    && LabelUtil.isLabelable((IElementNode) iNode)) {
                labeledElement = (IElementNode)iNode;
                if (labeledElement.childNodes().isEmpty()) {
                    return;
                }
                stackSize = 0;
                return;
            }
            collector.process(iNode, level);
        }

        public String getText() {
            return collector.getText();
        }

        public IElementNode getLabeledElement() {
            return labeledElement;
        }
    }

    /**
     * Class that generate ids for labelable elements which don't have assigned id
     */
    private static final class LabelIdGenerator {
        private int counter = 0;

        /**
         * Creates new label id generator.
         */
        public LabelIdGenerator() {}

        public String generateId() {
            return "idForLabel" + Integer.toString(counter++);
        }
    }
}
