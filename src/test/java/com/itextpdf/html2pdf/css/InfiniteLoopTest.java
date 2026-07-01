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
package com.itextpdf.html2pdf.css;

import com.itextpdf.commons.utils.FileUtil;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.exceptions.PdfException;
import com.itextpdf.kernel.pdf.DocumentProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.utils.LayoutInfiniteLoopResolver;
import com.itextpdf.test.ExtendedITextTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class InfiniteLoopTest extends ExtendedITextTest {
    private static final String SRC = "./src/test/resources/com/itextpdf/html2pdf/css/InfiniteLoopTest/";
    private static final String DEST = "./target/test/com/itextpdf/html2pdf/css/InfiniteLoopTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DEST);
    }

    @Test
    public void tooBigHtmlThrowsTest() {
        String testName = "tooBigHtml";
        DocumentProperties documentProperties = new DocumentProperties();
        documentProperties.registerDependency(LayoutInfiniteLoopResolver.class, () -> new LayoutInfiniteLoopResolver(9));

        Assertions.assertThrows(PdfException.class,
                () -> HtmlConverter.convertToPdf(FileUtil.getInputStreamForFile(SRC + testName + ".html"),
                        new PdfDocument(new PdfWriter(DEST + testName + ".pdf"), documentProperties)));
    }
}
