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
public class FlexOrderTest extends ExtendedHtmlConversionITextTest {

    //TODO DEVSIX-9402: Update cmp files
    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/flex/FlexOrderTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/flex/FlexOrderTest/";


    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 36)
    })
    public void decimalAlignContentWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("decimalAlignContentWrap", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 36)
    })
    public void decimalAlignContentWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("decimalAlignContentWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 16),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION),
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER)
    })
    public void decimalAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("decimalAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 8)
    })
    public void decimalAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("decimalAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 4)
    })
    public void decimalsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("decimals", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 9)
    })
    public void decimalsNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("decimalsNested", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 10)
    })
    public void decimalsDuplicatedValuesTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("decimalsDuplicatedValues", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 18),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void dirColumnTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("dirColumn", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 12)
    })
    public void dirColumnLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("dirColumnLong", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 18),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void dirColumnReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("dirColumnReverse", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 18),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void dirRowTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("dirRow", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 18),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void dirRowReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("dirRowReverse", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 6)
    })
    public void dirRowWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("dirRowWide", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 18),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void flexBasisTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexBasis", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 14),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void flexGrowTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexGrow", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 14),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void flexShrinkTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexShrink", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 18),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void flowColumnWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flowColumnWrap", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 18),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void flowRowWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flowRowWrap", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void inheritTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("inherit", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 7)
    })
    public void inheritNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("inheritNested", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 2),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void initialTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("initial", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 35),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN, count = 7)
    })
    public void initialAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("initialAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 5)
    })
    public void negativeTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("negative", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 18),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.INVALID_CSS_PROPERTY_DECLARATION, count = 5)
    })
    public void noWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("noWrap", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void revertTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("revert", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.RULE_IS_NOT_SUPPORTED, count = 2)
    })
    public void revertLayerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("revertLayer", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 3)
    })
    public void unsetTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("unset", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 18),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void wrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("wrap", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 18),
            @LogMessage(messageTemplate = StyledXmlParserLogMessageConstant.DEFAULT_VALUE_OF_CSS_PROPERTY_UNKNOWN)
    })
    public void wrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("wrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER, true);
    }
}
