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

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class UnitParsingTest extends ExtendedHtmlConversionITextTest {
    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/UnitParsingTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/UnitParsingTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void validWidthUnitValueTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("validWidthUnitValue", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void invalidWidthUnitValueTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("invalidWidthUnitValue", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void invalidMinWidthUnitValueTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("invalidMinWidthUnitValue", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void invalidMaxWidthUnitValueTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("invalidMaxWidthUnitValue", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void invalidHeightUnitValueTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("invalidHeightUnitValue", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void invalidMinHeightUnitValueTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("invalidMinHeightUnitValue", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void invalidMaxHeightUnitValueTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("invalidMaxHeightUnitValue", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
