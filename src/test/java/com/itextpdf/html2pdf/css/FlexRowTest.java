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
public class FlexRowTest extends ExtendedHtmlConversionITextTest {

    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/FlexRowTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/FlexRowTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 51)
    })
    public void flexDirRowAlignContentBaselineTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-baseline", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-center", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void flexDirRowAlignContentFirstBaselineTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-first-baseline", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentFlexStartWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-flex-start-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentFlexEndWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-flex-end-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentFlexCenterWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-flex-center-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceAroundWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-around-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceEvenlyWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-evenly-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceBetweenWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-between-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-flex-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentFlexEndTest2() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-flex-end-2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-flex-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentNormalTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-normal", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceAroundTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-around", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceAroundTest2() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-around-2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceBetweenTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-between", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceBetweenTest2() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-between-2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceEvenlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-evenly", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceEvenlyTest2() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-evenly-2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceEvenlySplittingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-evenly-splitting", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceEvenlySplittingWithOneElementTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-evenly-splitting-one-element", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceBetweenSplittingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-between-splitting", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceBetweenSplittingOneElementTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-between-splitting-one-element", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceAroundSplittingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-around-splitting", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentSpaceAroundSplittingOneElementTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-space-around-splitting-one-element", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentFlexEndSplittingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-flex-end-splitting", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentFlexEndSplittingOneElementTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-flex-end-splitting-one-element", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentCenterSplittingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-center-splitting", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentCenterSplittingOneElementTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-center-splitting-one-element", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.NO_WORKER_FOUND_FOR_TAG, count = 3)
    })
    public void flexDirRowAlignContentWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignContentStretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-content-stretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 51)
    })
    public void flexDirRowAlignItemsBaselineTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-baseline", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 51)
    })
    public void flexDirRowAlignItemsBaseline2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-baseline2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-center", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsCenter2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-center2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-flex-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsFlexEnd2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-flex-end2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-flex-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsFlexStart2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-flex-start2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsSelfEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-self-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsSelfStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-self-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsStretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-stretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirRowAlignItemsStretch2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-row-align-items-stretch2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowNonPagingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("row-non-paging", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
