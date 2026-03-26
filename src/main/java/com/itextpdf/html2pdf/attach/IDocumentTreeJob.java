/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2026 Apryse Group NV
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
