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
import com.itextpdf.io.logs.IoLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

@Tag("IntegrationTest")
public class FlexColumnTest extends ExtendedHtmlConversionITextTest {

    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/FlexColumnTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/FlexColumnTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignIItemsCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignIItemsCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsCenterJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsCenterJustifyContentCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsCenterJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsCenterJustifyContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsCenterJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsCenterJustifyContentFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsCenterJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsCenterJustifyContentFlexStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.NO_WORKER_FOUND_FOR_TAG, count = 3)
    })
    public void flexDirColumnAlignContentWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsCenterJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsCenterJustifyContentStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsEndJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsEndJustifyContentCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsEndJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsEndJustifyContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsEndJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsEndJustifyContentFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsEndJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsEndJustifyContentFlexStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsEndJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsEndJustifyContentStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexEndJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexEndJustifyContentCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexEndJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexEndJustifyContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexEndJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexEndJustifyContentFlexEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexEndJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexEndJustifyContentFlexStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexEndJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexEndJustifyContentStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexStartJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexStartJustifyContentCenter", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexStartJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexStartJustifyContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexStartJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexStartJustifyContentFlexEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexStartJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexStartJustifyContentFlexStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsFlexStartJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsFlexStartJustifyContentStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsStartJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsStartJustifyContentCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsStartJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsStartJustifyContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsStartJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsStartJustifyContentFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsStartJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsStartJustifyContentFlexStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnAlignItemsStartJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnAlignItemsStartJustifyContentStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnJustifyContentCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnJustifyContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnJustifyContentFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnJustifyContentFlexStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnJustifyContentStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnJustifyContentStartMaxSizeTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnJustifyContentStartMaxSize", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnJustifyContentStartMinSizeTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnJustifyContentStartMinSize", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnRelativeWidthHrChildTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ColumnRelativeWidthHrChild", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnRelativeWidthInInlineBlockHrChildTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ColumnRelativeWidthInInlineBlockHrChild", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnRelativeWidthDivWithContentChildTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ColumnRelativeWidthDivWithContentChild", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnFixedWidthDivWithContentChildTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ColumnFixedWidthDivWithContentChild", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 51)
    })
    public void flexDirColumnAlignContentBaselineTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-baseline", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-center", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void flexDirColumnAlignContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void flexDirColumnAlignContentFirstBaselineTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-first-baseline", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-flex-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentFlexEndTest2() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-flex-end-2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-flex-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentNormalTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-normal", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentSpaceAroundTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-space-around", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentSpaceAroundTest2() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-space-around-2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentSpaceBetweenTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-space-between", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentSpaceBetweenTest2() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-space-between-2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentSpaceEvenlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-space-evenly", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnAlignContentSpaceEvenlyTest2() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-space-evenly-2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void flexDirColumnAlignContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.ELEMENT_DOES_NOT_FIT_CURRENT_AREA)
    })
    public void flexDirColumnAlignContentStretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-align-content-stretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnNonPagingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-non-paging", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnPagingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-paging", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnPagingMultiColumnTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-paging-multi-column", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnPagingLargeElementTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-paging-large-element", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnPagingLargeElementFlexEndJustificationTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-paging-large-element-flex-end-justification", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnPagingLargeElementCenterJustificationTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-paging-large-element-center-justification", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnPagingLargeElementFixedHeightTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-paging-large-element-fixed-height", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnWrapReverseNonPagingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-wrap-reverse-non-paging", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT))
    public void columnPagingInDivTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-paging-in-div", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnPagingFixedHeightTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-paging-fixed-height", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnNoWrapPagingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-nowrap-paging", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnFlexShrinkPagingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-flex-shrink-paging", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnFlexGrowPagingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-flex-grow-paging", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnFlexGrowPaging2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-flex-grow-paging-2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void tableInFlexOnSplitTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("table-in-flex-on-split", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(
            messageTemplate = IoLogMessageConstant.TABLE_WIDTH_IS_MORE_THAN_EXPECTED_DUE_TO_MIN_WIDTH, count = 4))
    public void tableInFlexOnSplit2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("table-in-flex-on-split2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void tableInFlexColumnOnSplitTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("table-in-flex-column-on-split", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
