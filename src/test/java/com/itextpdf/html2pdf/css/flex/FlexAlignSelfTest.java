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
import com.itextpdf.io.logs.IoLogMessageConstant;
import com.itextpdf.test.LogLevelConstants;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class FlexAlignSelfTest extends ExtendedHtmlConversionITextTest {
    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/flex/FlexAlignSelfTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/flex/FlexAlignSelfTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void startFlexDirRowFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startFlexDirRowFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void startFlexDirRowReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startFlexDirRowReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void startFlexDirColumnFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startFlexDirColumnFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void startFlexDirColumnReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startFlexDirColumnReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 84, logLevel = LogLevelConstants.WARN)
    })
    // TODO DEVSIX-9436 Flex: alignment doesn't work correctly with direction: rtl
    public void startFlexDirColumnFlexWrapDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("startFlexDirColumnFlexWrapDirTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void endFlexDirRowFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("endFlexDirRowFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void endFlexDirRowReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("endFlexDirRowReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void endFlexDirColumnFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("endFlexDirColumnFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 84, logLevel = LogLevelConstants.WARN)
    })
    public void endFlexDirColumnFlexWrapDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("endFlexDirColumnFlexWrapDirTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void endFlexDirColumnReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("endFlexDirColumnReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void centerFlexDirRowFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("centerFlexDirRowFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void centerFlexDirRowReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("centerFlexDirRowReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void centerFlexDirColumnFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("centerFlexDirColumnFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void centerFlexDirColumnReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("centerFlexDirColumnReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexStartFlexDirRowFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexStartFlexDirRowFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexStartFlexDirRowReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexStartFlexDirRowReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexStartFlexDirColumnFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexStartFlexDirColumnFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexStartFlexDirColumnReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexStartFlexDirColumnReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 84, logLevel = LogLevelConstants.WARN)
    })
    // TODO DEVSIX-9436 Flex: alignment doesn't work correctly with direction: rtl
    public void flexStartFlexDirColumnFlexWrapDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexStartFlexDirColumnFlexWrapDirTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexEndFlexDirRowFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexEndFlexDirRowFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexEndFlexDirRowReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexEndFlexDirRowReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexEndFlexDirColumnFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexEndFlexDirColumnFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexEndFlexDirColumnReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexEndFlexDirColumnReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 84, logLevel = LogLevelConstants.WARN)
    })
    public void flexEndFlexDirColumnReverseFlexWrapDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexEndFlexDirColumnReverseFlexWrapDirTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    // TODO DEVSIX-5167 Support baseline value for align-items and align-self
    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 12)
    })
    public void baselineFlexDirRowFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("baselineFlexDirRowFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    // TODO DEVSIX-5167 Support baseline value for align-items and align-self
    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 12)
    })
    public void baselineFlexDirRowReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("baselineFlexDirRowReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    // TODO DEVSIX-5167 Support baseline value for align-items and align-self
    // TODO DEVSIX-9435 Flex: fix items align-self in case of flex-wrap: wrap-reverse
    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 12)
    })
    public void baselineFlexDirColumnFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("baselineFlexDirColumnFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    // TODO DEVSIX-5167 Support baseline value for align-items and align-self
    // TODO DEVSIX-9435 Flex: fix items align-self in case of flex-wrap: wrap-reverse
    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 12)
    })
    public void baselineFlexDirColumnReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("baselineFlexDirColumnReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void autoFlexDirRowFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("autoFlexDirRowFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    // TODO DEVSIX-9435 Flex: fix items align-self in case of flex-wrap: wrap-reverse
    @Test
    public void normalFlexDirRowFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("normalFlexDirRowFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 84, logLevel = LogLevelConstants.WARN)
    })
    // TODO DEVSIX-9436 Flex: alignment doesn't work correctly with direction: rtl
    public void selfStartFlexDirColumnFlexWrapDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("selfStartFlexDirColumnFlexWrapDirTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 84, logLevel = LogLevelConstants.WARN)
    })
    // TODO DEVSIX-9436 Flex: alignment doesn't work correctly with direction: rtl
    public void selfStartFlexDirColumnReverseFlexWrapDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("selfStartFlexDirColumnReverseFlexWrapDirTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 108, logLevel = LogLevelConstants.WARN)
    })
    // TODO DEVSIX-9436 Flex: alignment doesn't work correctly with direction: rtl
    public void selfStartFlexDirRowFlexWrapDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("selfStartFlexDirRowFlexWrapDirTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 84, logLevel = LogLevelConstants.WARN)
    })
    // TODO DEVSIX-9436 Flex: alignment doesn't work correctly with direction: rtl
    public void selfEndFlexDirColumnFlexWrapDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("selfEndFlexDirColumnFlexWrapDirTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    // TODO DEVSIX-9435 Flex: fix items align-self in case of flex-wrap: wrap-reverse
    @Test
    public void stretchFlexDirRowFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("stretchFlexDirRowFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    // TODO DEVSIX-9435 Flex: fix items align-self in case of flex-wrap: wrap-reverse
    @Test
    public void stretchFlexDirRowReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("stretchFlexDirRowReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    // TODO DEVSIX-9435 Flex: fix items align-self in case of flex-wrap: wrap-reverse
    @Test
    public void stretchFlexDirColumnFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("stretchFlexDirColumnFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    // TODO DEVSIX-9435 Flex: fix items align-self in case of flex-wrap: wrap-reverse
    @Test
    public void stretchFlexDirColumnReverseFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("stretchFlexDirColumnReverseFlexWrapTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
