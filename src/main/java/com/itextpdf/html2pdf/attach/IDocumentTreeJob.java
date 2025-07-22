package com.itextpdf.html2pdf.attach;

import com.itextpdf.styledxmlparser.node.INode;

/**
 * Interface for document tree jobs.
 */
@FunctionalInterface
public interface IDocumentTreeJob {
    /**
     * Processes a node within a document tree structure at a given level.
     * <br>
     * This method is used to perform specific operations on an {@link INode}
     * based on the context of its hierarchical position in the document tree.
     *
     * @param node the node to process
     * @param level the hierarchical level of the node in the document tree structure
     */
    void process(INode node, int level);
}
