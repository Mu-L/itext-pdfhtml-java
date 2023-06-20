/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2023 Apryse Group NV
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
package com.itextpdf.html2pdf.css.multicol;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.test.annotations.type.IntegrationTest;

import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class ColumnCountTest extends ExtendedHtmlConversionITextTest {
    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/multicol/ColumnCountTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/multicol/ColumnCountTest/";

    @BeforeClass
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void convertBasicArticleTest() throws IOException, InterruptedException {
        runTest("basicArticleTest");
    }

    @Test
    public void convertBasicDivTest() throws IOException, InterruptedException {
        runTest("basicDivTest");
    }

    @Test
    public void convertBasicDivWithImageTest() throws IOException, InterruptedException {
        runTest("basicDivWithImageTest");
    }

    @Test
    public void convertBasicPTest() throws IOException, InterruptedException {
        runTest("basicPTest");
    }

    @Test
    public void diffElementsInsidePTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("diffElementsInsidePTest", SOURCE_FOLDER, DESTINATION_FOLDER, false,
                new ConverterProperties().setMulticolEnabled(true).setBaseUri(SOURCE_FOLDER));
    }

    //TODO: DEVSIX-7591 support nested multicol layouting
    @Test
    public void convertBasicFormTest() throws IOException, InterruptedException {
        runTest("basicFormTest");
    }

    @Test
    public void convertBasicUlTest() throws IOException, InterruptedException {
        runTest("basicUlTest");
    }

    //TODO: DEVSIX-7591 Support nested multicol layouting
    @Test
    public void convertBasicOlTest() throws IOException, InterruptedException {
        runTest("basicOlTest");
    }

    @Test
    public void convertBasicTableTest() throws IOException, InterruptedException {
        runTest("basicTableTest");
    }

    @Test
    public void tableColspanTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("tableColspanTest",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    @Test
    public void tableRowspanTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("tableRowspanTest",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    @Test
    public void tableColspanRowspanTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("tableColspanRowspanTest",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    //TODO: DEVSIX-7591 Support nested multicol layouting
    @Test
    public void convertBasicSectionTest() throws IOException, InterruptedException {
        runTest("basicSectionTest");
    }

    //TODO: DEVSIX-7584 add multipage support
    @Test
    public void convertBasicDivMultiPageDocumentsTest() throws IOException, InterruptedException {
        runTest("basicDivMultiPageTest");
    }

    //TODO: DEVSIX-7584 add multipage support
    @Test
    public void convertBasicFormMultiPageDocumentsTest() throws IOException, InterruptedException {
        runTest("basicFormMultiPageTest");
    }

    @Test
    public void convertBasicDisplayPropertyTest() throws IOException, InterruptedException {
        runTest("basicDisplayPropertyTest");
    }

    //TODO: DEVSIX-7591 Support nested multicol layouting
    @Test
    public void convertBasicDisplayPropertyWithNestedColumnsTest() throws IOException, InterruptedException {
        runTest("basicDisplayPropertyWithNestedColumnsTest");
    }

    //TODO: DEVSIX-7556
    @Test
    public void convertBasicFloatPropertyTest() throws IOException, InterruptedException {
        runTest("basicFloatPropertyTest");
    }

    @Test
    public void convertBasicFlexPropertyTest() throws IOException, InterruptedException {
        runTest("basicFlexPropertyTest");
    }

    //TODO: DEVSIX-7587 adjust approximate height calculation
    @Test
    public void convertImagesWithDifferentColValuesTest() throws IOException, InterruptedException {
        runTest("imagesWithDifferentColValuesTest");
    }

    private void runTest(String testName) throws IOException, InterruptedException {
        convertToPdfAndCompare(testName,
                SOURCE_FOLDER, DESTINATION_FOLDER, false,
                new ConverterProperties().setMulticolEnabled(true).setBaseUri(SOURCE_FOLDER));
    }


    @Test
    public void paddingsMarginsBorderBackgrounds() throws IOException, InterruptedException {
        convertToPdfAndCompare("paddingsMarginsBorderBackgrounds",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }


    @Test
    public void borderOnlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("borderOnly",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }


    @Test
    public void paddingOnlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("paddingOnly",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }


    @Test
    public void marginOnlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("marginOnly",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }


    @Test
    public void splitInnerParagraphBetweenColumns() throws IOException, InterruptedException {
        convertToPdfAndCompare("splitInnerParagraphBetweenColumns",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    @Test
    public void splitInnerParagraphWithoutMarginBetweenColumns() throws IOException, InterruptedException {
        convertToPdfAndCompare("splitInnerParagraphWithoutMarginBetweenColumns",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    @Test
    public void splitEmptyBlockElementsBetweenColumns() throws IOException, InterruptedException {
        convertToPdfAndCompare("splitEmptyBlockElementsBetweenColumns",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }


    @Test
    public void splitEmptyParagraphElementsBetweenColumns() throws IOException, InterruptedException {
        convertToPdfAndCompare("splitEmptyParagraphElementsBetweenColumns",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    @Test
    public void splitEmptyContinuousBlockElementBetweenColumns() throws IOException, InterruptedException {
        convertToPdfAndCompare("splitEmptyContinuousBlockElementBetweenColumns",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    @Test
    public void basicHiTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("basicHiTest",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    @Test
    public void basicFooterHeaderTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("basicFooterHeaderTest",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    @Test
    public void basicDlTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("basicDlTest",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    @Test
    public void basicInlineElementsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("basicInlineElementsTest",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }

    @Test
    public void basicBlockquoteTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("basicBlockquoteTest",
                SOURCE_FOLDER, DESTINATION_FOLDER, false, new ConverterProperties().setMulticolEnabled(true));
    }
}
