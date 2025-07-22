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
