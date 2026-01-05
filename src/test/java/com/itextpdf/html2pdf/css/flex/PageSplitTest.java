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
package com.itextpdf.html2pdf.css.flex;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.styledxmlparser.logs.StyledXmlParserLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Tag("IntegrationTest")
public class PageSplitTest extends ExtendedHtmlConversionITextTest {

    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/flex/PageSplitTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/flex/PageSplitTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void mixedSizesTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("mixedSizes", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignItemsFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignItemsFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentFlexStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentFlexStartWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentFlexStartWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentFlexEndWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentFlexEndWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9559 Fix align-content in case free space is negative
    public void alignContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9559 Fix align-content in case free space is negative
    public void alignContentCenterWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentCenterWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentStartWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentStartWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentEndWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentEndWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentStretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentStretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentStretchWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentStretchWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentSpaceBetweenTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentSpaceBetween", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentSpaceBetweenWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentSpaceBetweenWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentSpaceAroundTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentSpaceAround", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentSpaceAroundWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentSpaceAroundWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentSpaceEvenlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentSpaceEvenly", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void alignContentSpaceEvenlyWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("alignContentSpaceEvenlyWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentFlexStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentFlexStartWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentFlexStartWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentFlexEndWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentFlexEndWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9559 Fix align-content in case free space is negative
    public void rowRevAlignContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9559 Fix align-content in case free space is negative
    public void rowRevAlignContentCenterWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentCenterWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentStartWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentStartWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentEndWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentEndWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentStretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentStretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentStretchWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentStretchWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentSpaceBetweenTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentSpaceBetween", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentSpaceBetweenWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentSpaceBetweenWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentSpaceAroundTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentSpaceAround", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentSpaceAroundWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentSpaceAroundWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentSpaceEvenlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentSpaceEvenly", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void rowRevAlignContentSpaceEvenlyWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rowRevAlignContentSpaceEvenlyWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentFlexStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentFlexStartWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentFlexStartWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentFlexEndWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentFlexEndWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentCenterWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentCenterWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentStartWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentStartWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentEndWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentEndWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentStretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentStretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentStretchWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentStretchWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentSpaceBetweenTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentSpaceBetween", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentSpaceBetweenWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentSpaceBetweenWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentSpaceAroundTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentSpaceAround", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentSpaceAroundWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentSpaceAroundWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentSpaceEvenlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentSpaceEvenly", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colAlignContentSpaceEvenlyWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colAlignContentSpaceEvenlyWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentFlexStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentFlexStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentFlexStartWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentFlexStartWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentFlexEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentFlexEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentFlexEndWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentFlexEndWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentCenterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentCenter", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentCenterWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentCenterWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentStartTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentStart", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentStartWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentStartWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentEndTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentEnd", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentEndWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentEndWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentStretchTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentStretch", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentStretchWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentStretchWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentSpaceBetweenTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentSpaceBetween", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentSpaceBetweenWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentSpaceBetweenWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentSpaceAroundTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentSpaceAround", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentSpaceAroundWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentSpaceAroundWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentSpaceEvenlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentSpaceEvenly", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void colRevAlignContentSpaceEvenlyWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("colRevAlignContentSpaceEvenlyWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
