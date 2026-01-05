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
import com.itextpdf.io.logs.IoLogMessageConstant;
import com.itextpdf.layout.logs.LayoutLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class AreaBreakTest extends ExtendedHtmlConversionITextTest {

    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/AreaBreakTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/AreaBreakTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void areaBreakDefaultTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("area-break-default-test", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void areaBreakFlexReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("area-break-flex-reverse-test", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void areaBreakFlexTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("area-break-flex-test", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void areaBreakNestedFlexTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("area-break-nested-flex-items", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {
            @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT),
            @LogMessage(messageTemplate = LayoutLogMessageConstant.AREA_BREAK_UNEXPECTED),
            @LogMessage(messageTemplate = IoLogMessageConstant .OCCUPIED_AREA_HAS_NOT_BEEN_INITIALIZED)
    })
    //TODO Change test files after DEVSIX-2024 is fixed
    public void areaBreakNestedFixedHeightTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("area-break-nested-fixed-height", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
