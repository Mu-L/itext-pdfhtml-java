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
package com.itextpdf.html2pdf.css.apply.util;

import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.css.CssConstants;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.layout.properties.ClearPropertyValue;
import com.itextpdf.layout.properties.FloatPropertyValue;
import com.itextpdf.layout.properties.Property;

import java.util.Map;

/**
 * Utilities class to apply float values to elements.
 */
public class FloatApplierUtil {

    /**
     * Creates a new {@link FloatApplierUtil} instance.
     */
    private FloatApplierUtil() {
    }

    /**
     * Applies a float value (left, right, or both) to an element.
     *
     * @param cssProps the CSS properties
     * @param context the processor context
     * @param element the element
     */
    public static void applyFloating(Map<String, String> cssProps, ProcessorContext context, IPropertyContainer element) {
        String floatValue = cssProps.get(CssConstants.FLOAT);
        if (floatValue != null) {
            if (CssConstants.LEFT.equals(floatValue)) {
                element.setProperty(Property.FLOAT, FloatPropertyValue.LEFT);

            } else if (CssConstants.RIGHT.equals(floatValue)) {
                element.setProperty(Property.FLOAT, FloatPropertyValue.RIGHT);
            }
        }

        String clearValue = cssProps.get(CssConstants.CLEAR);
        if (clearValue != null) {
            if(CssConstants.LEFT.equals(clearValue)) {
                element.setProperty(Property.CLEAR, ClearPropertyValue.LEFT);
            } else if (CssConstants.RIGHT.equals(clearValue)) {
                element.setProperty(Property.CLEAR, ClearPropertyValue.RIGHT);
            } else if (CssConstants.BOTH.equals(clearValue)) {
                element.setProperty(Property.CLEAR, ClearPropertyValue.BOTH);
            }
        }
    }
}
