/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2024 Apryse Group NV
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
package com.itextpdf.html2pdf.css.grid;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

@Tag("IntegrationTest")
public class GridTemplateRowTest extends ExtendedHtmlConversionITextTest {
    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/grid/GridTemplateRowTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/grid/GridTemplateRowTest/";

    //TODO DEVSIX-3340 change cmp files when GRID LAYOUT is supported

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void templateRowAutoTest() throws IOException, InterruptedException {
        runTest("template-rows-auto");
    }

    @Test
    public void autoRowFixedTest() throws IOException, InterruptedException {
        runTest("auto-rows-fixed");
    }

    @Test
    public void templateRowBordersTest() throws IOException, InterruptedException {
        runTest("template-rows-borders");
    }

    @Test
    // TODO DEVSIX-8126
    public void templateRowStartEndTest() throws IOException, InterruptedException {
        runTest("template-rows-start-end");
    }

    @Test
    // TODO DEVSIX-8324
    public void templateRowWidthUnitsTest() throws IOException, InterruptedException {
        runTest("template-rows-different-width-units");
    }

    @Test
    public void templateRowFitContentTest() throws IOException, InterruptedException {
        runTest("template-rows-fit-content");
    }

    @Test
    public void templateRowFitContentAutoTest() throws IOException, InterruptedException {
        runTest("template-rows-fit-content-auto");
    }

    @Test
    // TODO DEVSIX-8324
    public void templateRowFrTest() throws IOException, InterruptedException {
        runTest("template-rows-fr");
    }

    @Test
    // TODO DEVSIX-8126
    public void templateRowGridGapTest() throws IOException, InterruptedException {
        runTest("template-rows-grid-gap");
    }

    @Test
    public void templateRowHeightWidthTest() throws IOException, InterruptedException {
        runTest("template-rows-height-width");
    }

    @Test
    public void templateRowMarginTest() throws IOException, InterruptedException {
        runTest("template-rows-margin");
    }

    @Test
    // TODO DEVSIX-8324
    public void templateRowMinMaxTest() throws IOException, InterruptedException {
        runTest("template-rows-minmax");
    }

    @Test
    // TODO DEVSIX-8324
    public void templateRowMixedTest() throws IOException, InterruptedException {
        runTest("template-rows-mixed");
    }

    @Test
    // TODO DEVSIX-8331
    public void templateRowMultiPageTest() throws IOException, InterruptedException {
        runTest("template-rows-multipage");
    }

    @Test
    public void templateRowNestedTest() throws IOException, InterruptedException {
        runTest("template-rows-nested");
    }

    @Test
    public void templateRowPaddingTest() throws IOException, InterruptedException {
        runTest("template-rows-padding");
    }

    @Test
    // TODO DEVSIX-8324
    public void templateRowRepeatTest() throws IOException, InterruptedException {
        runTest("template-rows-repeat");
    }

    @Test
    // TODO DEVSIX-8324
    public void templateRowRepeatMinMaxTest() throws IOException, InterruptedException {
        runTest("template-rows-repeat-minmax");
    }

    @Test
    // TODO DEVSIX-8126
    public void templateRowRowGapTest() throws IOException, InterruptedException {
        runTest("template-rows-row-gap");
    }

    @Test
    public void templateRowBasicTest() throws IOException, InterruptedException {
        runTest("template-rows-without-other-props");
    }

    private void runTest(String testName) throws IOException, InterruptedException {
        convertToPdfAndCompare(testName,
                SOURCE_FOLDER, DESTINATION_FOLDER, false,
                new ConverterProperties().setBaseUri(SOURCE_FOLDER).setCssGridEnabled(true));
    }
}
