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
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Tag("IntegrationTest")
public class VerticalTextLRTest extends ExtendedHtmlConversionITextTest {

    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/VerticalTextLRTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/VerticalTextLRTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.CSS_PROPERTY_IN_PERCENTS_NOT_SUPPORTED)})
    public void vertLrAbsolutePositioningTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrAbsolutePositioning", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrBackgroundDecorationTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrBackgroundDecoration", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrBlockquoteTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrBlockquote", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrCjkTextTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrCjkText", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrComboComplexTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrComboComplex", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrComboFlexMixedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrComboFlexMixed", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrComboSpacingDecorationOverflowTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrComboSpacingDecorationOverflow", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrComboWideDecoratedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrComboWideDecorated", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrCssColumnsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrCssColumns", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrFlexMinMaxTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrFlexMinMax", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrFloatTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrFloat", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrHeadingsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrHeadings", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrImageInlineBlockTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrImageInlineBlock", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrLetterSpacingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrLetterSpacing", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrLineHeightTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrLineHeight", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrListsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrLists", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrLongContainerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrLongContainer", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrLongTextTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrLongText", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrMixedFontsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrMixedFonts", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrNoSoftWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrNoSoftWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrOverflowTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrOverflow", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrSpacingRatioTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrSpacingRatio", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrTableCellTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrTableCell", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrTextAlignTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrTextAlign", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrTextCombineUprightTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrTextCombineUpright", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrTextDecorationTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrTextDecoration", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrUnderlinePositionTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrUnderlinePosition", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrVerticalAlignTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrVerticalAlign", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrWideMulticolumnTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrWideMulticolumn", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrWordSpacingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrWordSpacing", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void vertLrZeroNegativeDimensionsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("vertLrZeroNegativeDimensions", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
