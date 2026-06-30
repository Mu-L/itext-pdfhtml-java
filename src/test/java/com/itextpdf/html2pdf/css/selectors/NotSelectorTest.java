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
package com.itextpdf.html2pdf.css.selectors;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Tag("IntegrationTest")
public class NotSelectorTest extends ExtendedHtmlConversionITextTest {
    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/selectors/NotSelectorTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/selectors/NotSelectorTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void isFirstVsClassTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notFirstVsClass", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void notNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void notSelectorBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notSelectorBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 3)})
    public void notInvalidTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notInvalid", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void notSpecificityGreaterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notSpecificityGreater", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void complexNotSpecificityGreaterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("complexNotSpecificityGreater", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void notSpecificityLowerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notSpecificityLower", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
