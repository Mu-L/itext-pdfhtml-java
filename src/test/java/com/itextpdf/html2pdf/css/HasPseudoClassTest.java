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
package com.itextpdf.html2pdf.css;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.styledxmlparser.logs.StyledXmlParserLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Tag("IntegrationTest")
public class HasPseudoClassTest extends ExtendedHtmlConversionITextTest {
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/HasPseudoClassTest/";
    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/HasPseudoClassTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void hasBasicSelectionTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasBasicSelectionTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void hasChildSelectorTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasChildSelectorTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void hasAdjacentSiblingSelectorTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasAdjacentSiblingSelectorTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void hasGeneralSiblingSelectorTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasGeneralSiblingSelectorTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void hasNegationTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasNegationTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //Nesting 'has' is not allowed in CSS
    @LogMessages(messages = @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 3))
    @Test
    public void hasNestedHasTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasNestedHasTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void hasWithPseudoElementsInteractionTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasWithPseudoElementsInteractionTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void hasWithDisplayVisibilityTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasWithDisplayVisibilityTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void hasWithBoxModelTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasWithBoxModelTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void hasWithPositioningTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasWithPositioningTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-4258: table body styling is not supported
    @Test
    public void hasWithTableStructuresTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasWithTableStructuresTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @LogMessages(messages = @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 2))
    //TODO DEVSIX-1440: support :invalid and :checked pseudo-classes
    @Test
    public void hasWithFormControlsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("hasWithFormControlsTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
