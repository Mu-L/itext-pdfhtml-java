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
package com.itextpdf.html2pdf.css.media.page;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class PageSelectorsTest extends ExtendedHtmlConversionITextTest {

    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/media/page/PageSelectorsTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/media/page/PageSelectorsTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void validSelectorOnlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("validSelectorOnly", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void twoValidSelectorsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("twoValidSelectors", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void invalidSelectorBetweenTwoValidSelectorsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("invalidSelectorBetweenTwoValidSelectors", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void invalidSelectorOnlyTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("invalidSelectorOnly", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void invalidSelectorAfterValidSelectorTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("invalidSelectorAfterValidSelector", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void invalidSelectorBeforeValidSelectorTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("invalidSelectorBeforeValidSelector", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
