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

import com.itextpdf.styledxmlparser.node.IElementNode;

/**
 * {@link IOutlineMarkExtractor} interface is used to control what part of element will be a mark
 * witch will be used to create outline in {@link com.itextpdf.html2pdf.attach.impl.OutlineHandler}
 */
public interface IOutlineMarkExtractor {
    /**
     * Get element mark.
     *
     * @param element the element
     * @return returns string mark of the element
     */
    String getMark(IElementNode element);
}
