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
package com.itextpdf.html2pdf.css.flex;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.styledxmlparser.logs.StyledXmlParserLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class FlexGapTest extends ExtendedHtmlConversionITextTest {

    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/flex/FlexGapTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/flex/FlexGapTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }


    @Test
    public void gapDecimalsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapDecimals", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapDecimalsDoubleDigitsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapDecimalsDoubleDigits", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapEmTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapEm", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9472 Support global values for column/row-gap property
    public void gapGlobalTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapGlobal", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapInheritTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapInherit", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapInitialTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapInitial", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION))
    // TODO DEVSIX-9472 Support vmin/vmax values for column/row-gap property
    public void gap3vminTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gap3vmin", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION))
    // TODO DEVSIX-9472 Support calc values for column/row-gap property
    public void gapCalcTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapCalc", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapZeroTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapZero", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapZeroColDecimalsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapZeroColDecimals", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapZeroRowDecimalsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapZeroRowDecimals", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapZeroWidthHeightTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapZeroWidthHeight", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9472 Support percentage values for column/row-gap property
    public void gapPercentageTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapPercentage", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapPhysUnitsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapPhysUnits", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapRemTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapRem", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION)})
    // TODO DEVSIX-9472 Support revert value for column/row-gap property
    public void gapRevertTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapRevert", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION)})
    // TODO DEVSIX-9472 Support revert-layer value for column/row-gap property
    public void gapRevertLayerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapRevertLayer", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapUnsetTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapUnset", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapNormalTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapNormal", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapNestedFlexContainerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapNestedFlexContainer", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapNestedFlexContainerColumnTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapNestedFlexContainerColumn", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9473 Fix issues on page split
    public void gapAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9473 Fix issues on page split
    public void gapAlignContentRowRevDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapAlignContentRowRevDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9473 Fix issues on page split
    public void gapAlignContentColumnDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapAlignContentColumnDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9473 Fix issues on page split
    public void gapAlignContentColumnRevDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapAlignContentColumnRevDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9473 Fix issues on page split
    public void gapAlignContentWrapRevTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapAlignContentWrapRev", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET))
    public void gapAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET))
    public void gapAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapGrowTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapGrow", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapJustifyContentRowRevTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapJustifyContentRowRev", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapJustifyContentColumnTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapJustifyContentColumn", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapJustifyContentColumnRevTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapJustifyContentColumnRev", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapJustifyContentWrapRevTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapJustifyContentWrapRev", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapLongMarginTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapLongMargin", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapLongMixedPropertiesTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapLongMixedProperties", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapLongPaddingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapLongPadding", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapMarginLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapMarginLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9472 Support percentage values for column/row-gap property
    public void gapMixedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapMixed", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapMixedSizesTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapMixedSizes", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapNegativeMarginsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapNegativeMargins", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapPaddingLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapPaddingLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapShrinkTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapShrink", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void gapFlexDirWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapFlexDirWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void nestedGapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("nestedGap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION))
    // TODO DEVSIX-9472 Support vmin/vmax values for column/row-gap property
    public void colGap3vminTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGap3vmin", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION))
    // TODO DEVSIX-9472 Support calc values for column/row-gap property
    public void colGapCalcTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapCalc", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapDecimalsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapDecimals", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapEmTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapEm", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9472 Support percentage values for column/row-gap property
    public void colGapPercentageTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapPercentage", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapPhysUnitsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapPhysUnits", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapRemTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapRem", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9473 Fix issues on page split
    public void colGapAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET))
    public void colGapAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET))
    public void colGapAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapLargeTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapLarge", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapMarginTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapMargin", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9477 Fix issue on page split: cross-size calculated incorrectly
    public void colGapMixedSizesTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapMixedSizes", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapNegativeMarginsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapNegativeMargins", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapPaddingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapPadding", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapTooBigTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapTooBig", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colGapWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colGapWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION))
    // TODO DEVSIX-9472 Support vmin/vmax values for column/row-gap property
    public void rowGap3vminTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGap3vmin", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION))
    // TODO DEVSIX-9472 Support calc values for column/row-gap property
    public void rowGapCalcTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapCalc", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapDecimalsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapDecimals", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapEmTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapEm", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9472 Support percentage values for column/row-gap property
    public void rowGapPercentageTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapPercentage", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapPhysUnitsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapPhysUnits", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapRemTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapRem", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapTooBigTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapTooBig", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9473 Fix issues on page split
    public void rowGapAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET))
    public void rowGapAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate =
            Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET))
    public void rowGapAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapLargeTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapLarge", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapMarginTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapMargin", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9477 Fix issue on page split: cross-size calculated incorrectly
    public void rowGapMixedSizesTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapMixedSizes", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapNegativeMarginsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapNegativeMargins", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowGapPaddingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowGapPadding", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

}
