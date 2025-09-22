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
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

@Tag("IntegrationTest")
public class FlexColumnReverseTest extends ExtendedHtmlConversionITextTest {

    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/flex/FlexColumnReverseTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/flex/FlexColumnReverseTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignIItemsCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignIItemsCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsCenterJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsCenterJustifyContentCenter", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsCenterJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsCenterJustifyContentEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsCenterJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsCenterJustifyContentFlexEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsCenterJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsCenterJustifyContentFlexStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsCenterJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsCenterJustifyContentStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsEndJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsEndJustifyContentCenter", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsEndJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsEndJustifyContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsEndJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsEndJustifyContentFlexEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsEndJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsEndJustifyContentFlexStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsEndJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsEndJustifyContentStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexEndJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexEndJustifyContentCenter", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexEndJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexEndJustifyContentEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexEndJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexEndJustifyContentFlexEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexEndJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexEndJustifyContentFlexStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexEndJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexEndJustifyContentStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexStartJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexStartJustifyContentCenter", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexStartJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexStartJustifyContentEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexStartJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexStartJustifyContentFlexEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexStartJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexStartJustifyContentFlexStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsFlexStartJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsFlexStartJustifyContentStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsStartJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsStartJustifyContentCenter", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsStartJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsStartJustifyContentEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsStartJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsStartJustifyContentFlexEnd", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsStartJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsStartJustifyContentFlexStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseAlignItemsStartJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseAlignItemsStartJustifyContentStart", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseJustifyContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseJustifyContentCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseJustifyContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseJustifyContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseJustifyContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseJustifyContentFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseJustifyContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseJustifyContentFlexStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseJustifyContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseJustifyContentStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseJustifyContentStartMaxSizeTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseJustifyContentStartMaxSize", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void ColumnReverseJustifyContentStartMinSizeTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("FlexDirColumnReverseJustifyContentStartMinSize", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 51)
    })
    public void flexDirColumnReverseAlignContentBaselineTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-baseline", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-center", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET)
    })
    public void flexDirColumnReverseAlignContentFirstBaselineTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-first-baseline", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-flex-end", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-flex-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentNormalTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-normal", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentSpaceAroundTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-space-around", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentSpaceBetweenTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-space-between", SOURCE_FOLDER,
                DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentFlexStartWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-flex-start-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentFlexEndWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-flex-end-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentFlexCenterWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-flex-center-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentSpaceAroundWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-space-around-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentSpaceEvenlyWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-space-evenly-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentSpaceBetweenWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-space-between-wrap-reverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentSpaceEvenlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-space-evenly", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexDirColumnReverseAlignContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-start", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.ELEMENT_DOES_NOT_FIT_CURRENT_AREA)
    })
    public void flexDirColumnReverseAlignContentStretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flex-dir-column-reverse-align-content-stretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnReverseNonPagingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-reverse-non-paging", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnReversePagingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-reverse-paging", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnReversePagingMultiColumnTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-reverse-paging-multi-column", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void columnReversePagingLargeElementTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("column-reverse-paging-large-element", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
