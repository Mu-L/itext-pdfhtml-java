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
package com.itextpdf.html2pdf.css;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class FlexRowReverseTest extends ExtendedHtmlConversionITextTest {

    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/FlexRowReverseTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/FlexRowReverseTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 51)
    })
    public void flexDirRowReverseAlignContentBaselineTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-baseline", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-center", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void flexDirRowReverseAlignContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void flexDirRowReverseAlignContentFirstBaselineTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-first-baseline", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-flex-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-flex-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignContentNormalTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-normal", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignContentSpaceAroundTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-space-around", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignContentSpaceBetweenTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-space-between", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignContentSpaceEvenlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-space-evenly", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void flexDirRowReverseAlignContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignContentStretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-content-stretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 51)
    })
    public void flexDirRowReverseAlignItemsBaselineTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-items-baseline", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignItemsCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-items-center", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignItemsEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-items-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignItemsFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-items-flex-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignItemsFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-items-flex-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignItemsSelfEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-items-self-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignItemsSelfStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-items-self-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignItemsStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-items-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowReverseAlignItemsStretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-reverse-align-items-stretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
