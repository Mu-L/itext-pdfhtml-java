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
package com.itextpdf.html2pdf.css;


import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;


@Tag("IntegrationTest")
public class CssNthChildSelectorTest extends ExtendedHtmlConversionITextTest {
    public static final String sourceFolder = "./src/test/resources/com/itextpdf/html2pdf/css/CssNthChildSelectorTest/";
    public static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/css/CssNthChildSelectorTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(destinationFolder);
    }

    @Test
    public void nthChildEvenTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("resourceNthChildEvenTest", sourceFolder, destinationFolder);
    }

    @Test
    public void nthChildExpressionTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("resourceNthChildExpressionTest", sourceFolder, destinationFolder);
    }

    @Test
    public void nthOfTypeNegativeExpressionTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("resourceNthOfTypeNegativeExpressionTest", sourceFolder, destinationFolder);
    }

    @Test
    public void nthChildIntegerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("resourceNthChildIntegerTest", sourceFolder, destinationFolder);
    }

    @Test
    public void firstChildTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("resourceFirstChildTest", sourceFolder, destinationFolder);
    }

    @Test
    public void lastChildTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("resourceLastChildTest", sourceFolder, destinationFolder);
    }

    @Test
    public void notExpressionChildTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("resourceNotExpressionChildTest", sourceFolder, destinationFolder);
    }
}
