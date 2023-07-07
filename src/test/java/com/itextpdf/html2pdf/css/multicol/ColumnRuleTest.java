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
public class ColumnRuleTest extends ExtendedHtmlConversionITextTest {
    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/multicol/ColumnRuleTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/multicol/ColumnRuleTest/";

    @BeforeClass
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void convertRuleStyleNoneTest() throws IOException, InterruptedException {
        runTest("ruleStyleNoneTest");
    }

    @Test
    public void convertRuleStyleDottedTest() throws IOException, InterruptedException {
        runTest("ruleStyleDottedTest");
    }

    @Test
    public void convertRuleStyleSolidTest() throws IOException, InterruptedException {
        runTest("ruleStyleSolidTest");
    }

    @Test
    public void convertRuleStyleDoubleTest() throws IOException, InterruptedException {
        runTest("ruleStyleDoubleTest");
    }

    @Test
    public void convertRuleStyleRidgeTest() throws IOException, InterruptedException {
        runTest("ruleStyleRidgeTest");
    }

    @Test
    public void convertRuleStyleManyColumnsTest() throws IOException, InterruptedException {
        runTest("ruleStyleManyColumnsTest");
    }

    @Test
    public void convertRuleStyleMultipageColumnsTest() throws IOException, InterruptedException {
        runTest("ruleStyleMultipageColumnsTest");
    }

    @Test
    public void convertRuleWidthThinTest() throws IOException, InterruptedException {
        runTest("ruleWidthThinTest");
    }

    @Test
    public void convertRuleWidthMediumTest() throws IOException, InterruptedException {
        runTest("ruleWidthMediumTest");
    }

    @Test
    public void convertRuleWidthThickTest() throws IOException, InterruptedException {
        runTest("ruleWidthThickTest");
    }

    @Test
    public void convertRuleWidthDifferentWidthValuesTest() throws IOException, InterruptedException {
        runTest("ruleWidthDifferentWidthValuesTest");
    }

    @Test
    public void convertRuleWidthHugeColumnsTest() throws IOException, InterruptedException {
        runTest("ruleWidthHugeColumnsTest");
    }

    @Test
    public void convertRuleWidthIncorrectValuesTest() throws IOException, InterruptedException {
        runTest("ruleWidthIncorrectValuesTest");
    }

    @Test
    public void convertRuleColorTest() throws IOException, InterruptedException {
        runTest("ruleColorTest");
    }

    @Test
    public void convertRuleColorRgbTest() throws IOException, InterruptedException {
        runTest("ruleColorRgbTest");
    }

    @Test
    public void convertRuleColorHslaTest() throws IOException, InterruptedException {
        runTest("ruleColorHslaTest");
    }

    @Test
    public void convertRuleColorCurrentColorTest() throws IOException, InterruptedException {
        runTest("ruleColorCurrentColorTest");
    }

    @Test
    public void convertRuleShorthandTest() throws IOException, InterruptedException {
        runTest("ruleShorthandTest");
    }
    
    private void runTest(String testName) throws IOException, InterruptedException {
        convertToPdfAndCompare(testName,
                SOURCE_FOLDER, DESTINATION_FOLDER, false,
                new ConverterProperties().setMulticolEnabled(true).setBaseUri(SOURCE_FOLDER));
    }
}
