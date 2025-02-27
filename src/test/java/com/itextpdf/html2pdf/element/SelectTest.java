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
package com.itextpdf.html2pdf.element;

import com.itextpdf.forms.logs.FormsLogMessageConstants;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.io.logs.IoLogMessageConstant;
import com.itextpdf.io.util.UrlUtil;
import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.layout.logs.LayoutLogMessageConstant;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

@Tag("IntegrationTest")
public class SelectTest extends ExtendedITextTest {

    private static final String sourceFolder = "./src/test/resources/com/itextpdf/html2pdf/element/SelectTest/";
    private static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/element/SelectTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(destinationFolder);
    }

    @Test
    public void selectBasicTest01() throws IOException, InterruptedException {
        runTest("selectBasicTest01");
    }

    @Test
    public void selectBasicTest02() throws IOException, InterruptedException {
        runTest("selectBasicTest02");
    }

    @Test
    public void selectBasicTest03() throws IOException, InterruptedException {
        runTest("selectBasicTest03");
    }

    @Test
    public void selectBasicTest04() throws IOException, InterruptedException {
        runTest("selectBasicTest04");
    }

    @Test
    public void selectBasicTest05() throws IOException, InterruptedException {
        runTest("selectBasicTest05");
    }

    @Test
    public void selectBasicTest06() throws IOException, InterruptedException {
        runTest("selectBasicTest06");
    }

    @Test
    public void selectBasicTest07() throws IOException, InterruptedException {
        runTest("selectBasicTest07");
    }

    @Test
    public void selectBasicTest08() throws IOException, InterruptedException {
        runTest("selectBasicTest08");
    }

    @Test
    public void selectBasicTest09() throws IOException, InterruptedException {
        runTest("selectBasicTest09");
    }

    @Test
    public void selectBasicTest10() throws IOException, InterruptedException {
        runTest("selectBasicTest10");
    }

    @Test
    public void selectEmptyTest01() throws IOException, InterruptedException {
        runTest("selectEmptyTest01");
    }

    @Test
    public void selectMultipleSizeTest01() throws IOException, InterruptedException {
        runTest("selectMultipleSizeTest01");
    }


    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = FormsLogMessageConstants.DUPLICATE_EXPORT_VALUE, count = 2),
    })
    public void selectPlaceholderTest01() throws IOException, InterruptedException {
        runTest("selectPlaceholderTest01");
    }

    @Test
    public void selectStylesTest01() throws IOException, InterruptedException {
        runTest("selectStylesTest01");
    }

    @Test
    public void selectStylesTest02() throws IOException, InterruptedException {
        runTest("selectStylesTest02");
    }

    @Test
    public void selectWidthTest01() throws IOException, InterruptedException {
        runTest("selectWidthTest01");
    }

    @Test
    public void selectWidthTest02() throws IOException, InterruptedException {
        runTest("selectWidthTest02");
    }

    @Test
    public void selectWidthTest03() throws IOException, InterruptedException {
        runTest("selectWidthTest03");
    }

    @Test
    public void selectWidthTest04() throws IOException, InterruptedException {
        runTest("selectWidthTest04");
    }

    @Test
    public void selectWidthTest05() throws IOException, InterruptedException {
        runTest("selectWidthTest05");
    }

    @Test
    public void selectRelativeWidthTest01() throws IOException, InterruptedException {
        runTest("selectRelativeWidthTest01");
    }

    @Test
    public void selectRelativeWidthTest02() throws IOException, InterruptedException {
        runTest("selectRelativeWidthTest02");
    }

    @Test
    public void selectMinMaxWidthCalculationTest01() throws IOException, InterruptedException {
        runTest("selectMinMaxWidthCalculationTest01");
    }

    @Test
    public void selectHeightTest01() throws IOException, InterruptedException {
        runTest("selectHeightTest01");
    }

    @Test
    public void selectOverflowTest01() throws IOException, InterruptedException {
        runTest("selectOverflowTest01");
    }

    @Test
    public void selectOverflowTest02() throws IOException, InterruptedException {
        runTest("selectOverflowTest02");
    }

    @Test
    public void selectOverflowTest03() throws IOException, InterruptedException {
        runTest("selectOverflowTest03");
    }

    @Test
    public void selectOverflowTest04() throws IOException, InterruptedException {
        runTest("selectOverflowTest04");
    }

    @Test
    public void selectOverflowTest05() throws IOException, InterruptedException {
        runTest("selectOverflowTest05");
    }

    @Test
    public void selectOverflowTest06() throws IOException, InterruptedException {
        runTest("selectOverflowTest06");
    }

    @Test
    public void selectSizeBasedHeightTest01() throws IOException, InterruptedException {
        runTest("selectSizeBasedHeightTest01");
    }

    @Test
    public void selectSizeBasedHeightTest02() throws IOException, InterruptedException {
        runTest("selectSizeBasedHeightTest02");
    }

    @Test
    public void selectSizeBasedHeightTest03() throws IOException, InterruptedException {
        // TODO DEVSIX-1895: height of fourth select element differs from the browser rendering due to incorrect resolving of max-height/height properties
        runTest("selectSizeBasedHeightTest03");
    }

    @Test
    public void selectSizeBasedHeightTest04() throws IOException, InterruptedException {
        runTest("selectSizeBasedHeightTest04");
    }

    @Test
    public void selectSizeBasedHeightTest05() throws IOException, InterruptedException {
        runTest("selectSizeBasedHeightTest05");
    }

    @Test
    public void selectSizeBasedHeightTest06() throws IOException, InterruptedException {
        runTest("selectSizeBasedHeightTest06");
    }

    @Test
    public void selectSizeBasedHeightTest07() throws IOException, InterruptedException {
        runTest("selectSizeBasedHeightTest07");
    }

    @Test
    public void selectSizeBasedHeightTest08() throws IOException, InterruptedException {
        runTest("selectSizeBasedHeightTest08");
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 2))
    public void selectPseudoTest01() throws IOException, InterruptedException {
        // pseudo elements are not supported for select element. The same behaviour is in Mozilla Firefox.
        runTest("selectPseudoTest01");
    }

    @Test
    public void selectNotFittingTest01() throws IOException, InterruptedException {
        runTest("selectNotFittingTest01");
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = LayoutLogMessageConstant.ELEMENT_DOES_NOT_FIT_AREA))
    public void selectNotFittingTest02() throws IOException, InterruptedException {
        runTest("selectNotFittingTest02");
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = LayoutLogMessageConstant.ELEMENT_DOES_NOT_FIT_AREA))
    public void selectNotFittingTest03() throws IOException, InterruptedException {
        runTest("selectNotFittingTest03");
    }

    private void runTest(String name) throws IOException, InterruptedException {
        String htmlPath = sourceFolder + name + ".html";
        String outPdfPath = destinationFolder + name + ".pdf";
        String cmpPdfPath = sourceFolder + "cmp_" + name + ".pdf";
        String diff = "diff_" + name + "_";
        System.out.println("html: " + UrlUtil.getNormalizedFileUriString(htmlPath) + "\n");

        HtmlConverter.convertToPdf(new File(htmlPath), new File(outPdfPath));
        Assertions.assertNull(new CompareTool().compareByContent(outPdfPath, cmpPdfPath, destinationFolder, diff));
    }
}
