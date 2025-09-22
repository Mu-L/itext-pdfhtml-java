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
//TODO DEVSIX-5163: Update cmp files
public class FlexJustifyContentTest extends ExtendedHtmlConversionITextTest {

    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/flex/FlexJustifyContentTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/flex/FlexJustifyContentTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 8)
    })
    public void inheritFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("inheritFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 12)
    })
    public void inheritSpaceValuesTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("inheritSpaceValues", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION)
    })
    public void inheritWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("inheritWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 2)
    })
    public void initialSimpleTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("initialSimple", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void initialFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("initialFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION)
    })
    public void initialWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("initialWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = "Cannot find pdfCalligraph module, which was implicitly required by one of the layout properties", count = 24)
    })
    public void leftValueTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("leftValue", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 2)
    })
    public void multipleValuesTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("otherValues", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void simpleCombinedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("simpleCombined", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 4),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 2)
    })
    public void multipleValuesMarginAutoOverridesTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("otherValuesMarginAutoOverrides", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void startEndCenterValuesAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startEndCenterValuesAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void startEndCenterValuesWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startEndCenterValuesWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 7)
    })
    public void startEndCenterValuesNoWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startEndCenterValuesNoWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void startEndCenterValuesWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startEndCenterValuesWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void startEndCenterValuesWrapAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startEndCenterValuesWrapAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void centerAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("centerAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void centerAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("centerAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void centerRowWrapLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("centerRowWrapLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void startColumnWrapLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startColumnWrapLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexEndColumnReverseWrapLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexEndColumnReverseWrapLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexStartRowReverseWrapLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexStartRowReverseWrapLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 5),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION)
    })
    public void revertSimpleTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("revertSimple", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 8)
    })
    public void revertFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("revertFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 5),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION)
    })
    public void revertLayerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("revertLayer", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 8)
    })
    public void revertWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("revertWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 5)
    })
    public void safeCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("safeCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 12),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 2)
    })
    public void safeCenterWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("safeCenterWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 5)
    })
    public void unsafeCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("unSafeCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 15),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 3)
    })
    public void unsafeCenterWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("unsafeCenterWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 2)
    })
    public void stretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("stretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 8)
    })
    public void stretchFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("stretchFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION)
    })
    public void stretchWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("stretchWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void stretchAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("stretchAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void stretchAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("stretchAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 5)
    })
    public void stretchAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("stretchAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 2)
    })
    public void unsetTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("unset", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 8)
    })
    public void unsetFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("unsetFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION)
    })
    public void unsetWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("unsetWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void spaceAroundSimpleTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundSimple", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 4)
    })
    public void spaceAroundFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 5)
    })
    public void spaceAroundMarginAndAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundMarginAndAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void spaceAroundMarginAutoTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundMarginAuto", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void spaceAroundMarginAuto2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundMarginAuto2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 2)
    })
    public void spaceAroundMarginAutoOverrideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundMarginAutoOverride", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6)
    })
    public void spaceAroundAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6)
    })
    public void spaceAroundAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6)
    })
    public void spaceAroundAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void spaceAroundWrapLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundWrapLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void spaceAroundColumnWrapLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceAroundColumnWrapLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void spaceBetweenSimpleTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceBetweenSimple", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 4)
    })
    public void spaceBetweenFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceBetweenFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 5)
    })
    public void spaceBetweenMarginAndAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceBetweenMarginAndAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 2)
    })
    public void spaceBetweenMarginAutoOverrideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceBetweenMarginAutoOverride", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 4)
    })
    public void spaceBetweenAllMarginOptionsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceBetweenAllMarginOptions", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6)
    })
    public void spaceBetweenAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceBetweenAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6)
    })
    public void spaceBetweenAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceBetweenAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6)
    })
    public void spaceBetweenAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceBetweenAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void spaceBetweenColumnReverseWrapLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceBetweenColumnReverseWrapLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void spaceEvenlySimpleTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceEvenlySimple", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6)
    })
    public void spaceEvenlyAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceEvenlyAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6)
    })
    public void spaceEvenlyAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceEvenlyAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6)
    })
    public void spaceEvenlyAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceEvenlyAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 4)
    })
    public void spaceEvenlyFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceEvenlyFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 5)
    })
    public void spaceEvenlyMarginAndAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceEvenlyMarginAndAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 2)
    })
    public void spaceEvenlyMarginAutoOverrideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceEvenlyMarginAutoOverride", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 1)
    })
    public void spaceEvenlyColumnReverseWrapLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceEvenlyColumnReverseWrapLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void spaceValuesBorderAndMarginsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesBorderAndMargins", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 9)
    })
    public void spaceValuesFlexGrowTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesFlexGrow", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void spaceValuesPaddingBordersMarginTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesPaddingBordersMargin", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void spaceValuesSingleElementTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesSingleElement", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void spaceValuesWithBordersTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesWithBorders", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void spaceValuesWithMarginsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesWithMargins", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void spaceValuesWithPaddingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesWithPadding", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 9)
    })
    public void spaceValuesFlexShrinkTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesFlexShrink", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 3)
    })
    public void spaceValuesNoWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesNoWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void spaceValuesWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 12)
    })
    public void spaceValuesWrapAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesWrapAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void spaceValuesWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("spaceValuesWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
