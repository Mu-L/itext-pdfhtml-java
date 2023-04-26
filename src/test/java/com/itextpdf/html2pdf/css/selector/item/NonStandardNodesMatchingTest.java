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
package com.itextpdf.html2pdf.css.selector.item;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.test.annotations.type.IntegrationTest;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class NonStandardNodesMatchingTest extends ExtendedHtmlConversionITextTest {

    public static final String sourceFolder = "./src/test/resources/com/itextpdf/html2pdf/css/selector/item/NonStandardNodesMatchingTest/";
    public static final String destinationFolder = "./target/test/com/itextpdf/html2pdf/css/selector/item/NonStandardNodesMatchingTest/";

    @BeforeClass
    public static void beforeClass() {
        createOrClearDestinationFolder(destinationFolder);
    }

    @Test
    public void pseudoElementMatchingTest01() throws IOException, InterruptedException {
        convertToPdfAndCompare("pseudoElementMatchingTest01", sourceFolder, destinationFolder);
    }

    @Test
    public void pseudoElementMatchingTest02() throws IOException, InterruptedException {
        convertToPdfAndCompare("pseudoElementMatchingTest02", sourceFolder, destinationFolder);
    }

    @Test
    public void documentNodeMatchingTest01() throws IOException, InterruptedException {
        convertToPdfAndCompare("documentNodeMatchingTest01", sourceFolder, destinationFolder);
    }
}
