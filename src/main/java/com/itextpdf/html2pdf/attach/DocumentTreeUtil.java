package com.itextpdf.html2pdf.attach;

import com.itextpdf.styledxmlparser.node.INode;

import java.util.List;
import java.util.Stack;

/**
 * Utility class for document tree operations.
 */
public final class DocumentTreeUtil {

    private DocumentTreeUtil() {
        //Utility class should not be instantiated
    }

    /**
     * Traverses a document tree starting from a specified node and performs a collection of jobs on each node.
     *
     * @param node node of the document tree to traverse
     * @param jobs a collection of jobs to be executed on each node during the traversal
     */
    public static void traverse(INode node, List<IDocumentTreeJob> jobs) {
        Stack<INode> stk = new Stack<>();
        stk.push(node);
        while (!stk.isEmpty()) {
            INode n = stk.pop();
            for (IDocumentTreeJob job : jobs) {
                job.process(n, stk.size());
            }
            if (!n.childNodes().isEmpty()) {
                for (int i = n.childNodes().size() - 1; i >= 0; i--) {
                    stk.push(n.childNodes().get(i));
                }
            }
        }
    }
}
