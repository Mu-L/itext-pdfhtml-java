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

import com.itextpdf.html2pdf.html.TagConstants;
import com.itextpdf.styledxmlparser.node.INameContainer;

/**
 * Utility class for handling operations related to labels
 */
public final class LabelUtil {

    private LabelUtil() {
        // Utility class, no instances allowed
    }

    /**
     * Determines whether the provided element can be labeled.
     *
     * @param element element to be checked
     * @return true if the element can be labeled; false otherwise
     */
    public static boolean isLabelable(INameContainer element) {
        return TagConstants.INPUT.equals(element.name())
                || TagConstants.TEXTAREA.equals(element.name())
                || TagConstants.SELECT.equals(element.name())
                || TagConstants.BUTTON.equals(element.name());
    }
}
