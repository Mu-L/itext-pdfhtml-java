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
