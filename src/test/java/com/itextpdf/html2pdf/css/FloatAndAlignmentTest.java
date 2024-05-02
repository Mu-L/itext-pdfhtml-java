/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2024 Apryse Group NV
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
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import java.io.IOException;

@Tag("IntegrationTest")
public class FloatAndAlignmentTest extends ExtendedHtmlConversionITextTest {

    public static final String sourceFolder = "./src/test/resources/com/itextpdf/html2pdf/css/FloatAndAlignmentTest/";
    public static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/css/FloatAndAlignmentTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(destinationFolder);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 2))
    public void singleBlockSingleParagraphRight() throws IOException, InterruptedException {
        /* this test shows different combinations of float values blocks and  paragraph align RIGHT within div container
        */
        //TODO: update test after ticket DEVSIX-1720  fix (WARN Invalid css property declaration: float: initial)
        convertToPdfAndCompare("singleBlockSingleParagraphRight", sourceFolder, destinationFolder);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 2))
    public void singleBlockSingleParagraphLeft() throws IOException, InterruptedException {
        //TODO: update test after ticket DEVSIX-1720  fix (WARN Invalid css property declaration: float: initial)
        convertToPdfAndCompare("singleBlockSingleParagraphLeft",sourceFolder, destinationFolder);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 2))
    public void singleBlockSingleParagraphJustify() throws IOException, InterruptedException {
        //TODO: update test after ticket DEVSIX-1720  fix (WARN Invalid css property declaration: float: initial)
        convertToPdfAndCompare("singleBlockSingleParagraphJustify", sourceFolder, destinationFolder);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 2))
    public void singleBlockSingleParagraphCenter() throws IOException, InterruptedException {
        //TODO: update test after ticket DEVSIX-1720  fix (WARN Invalid css property declaration: float: initial)
        convertToPdfAndCompare("singleBlockSingleParagraphCenter", sourceFolder, destinationFolder);
    }

    @Test
    public void severalBlocksSingleParagraph() throws IOException, InterruptedException {
        /* this test shows different combinations of 3 float values blocks and 1 paragraph aligns within div container
        */
        convertToPdfAndCompare("severalBlocksSingleParagraph", sourceFolder, destinationFolder);
    }

    @Test
    public void blocksInsideParagraph() throws IOException, InterruptedException {
        /* this test shows different combinations of 3 float values blocks and 1 paragraph aligns within div container
        * now it points not only incorrect alignment vs float positioning, but also incorrect float area
        */
        convertToPdfAndCompare("blocksInsideParagraph", sourceFolder, destinationFolder);
    }

    @Test
    public void inlineBlocksInsideParagraph() throws IOException, InterruptedException {
        convertToPdfAndCompare("inlineBlocksInsideParagraph", sourceFolder, destinationFolder);
    }

    @Test
    public void inlineFloatsWithTextAlignmentTest01() throws IOException, InterruptedException {
        convertToPdfAndCompare("inlineFloatsWithTextAlignmentTest01", sourceFolder, destinationFolder);
    }

    @Test
    public void inlineFloatsWithTextAlignmentTest02() throws IOException, InterruptedException {
        convertToPdfAndCompare("inlineFloatsWithTextAlignmentTest02", sourceFolder, destinationFolder);
    }

    @Test
    public void inlineFloatsWithTextAlignmentTest03() throws IOException, InterruptedException {
        convertToPdfAndCompare("inlineFloatsWithTextAlignmentTest03", sourceFolder, destinationFolder);
    }
}
