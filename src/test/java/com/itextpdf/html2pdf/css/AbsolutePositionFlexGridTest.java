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

import com.itextpdf.io.logs.IoLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

@Tag("IntegrationTest")
public class AbsolutePositionFlexGridTest extends ExtendedHtmlConversionITextTest {

    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/AbsolutePositionFlexGridTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/AbsolutePositionFlexGridTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void absPosInFlexContainerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("absPosInFlexContainer", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.OCCUPIED_AREA_HAS_NOT_BEEN_INITIALIZED, count = 2))
    public void absPosInGridContainerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("absPosInGridContainer", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void absPosFlexJustifyAlignTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("absPosFlexJustifyAlign", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.OCCUPIED_AREA_HAS_NOT_BEEN_INITIALIZED))
    public void absPosFlexAlignContentWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("absPosFlexAlignContentWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void absPosGridJustifyItemsSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("absPosGridJustifyItemsSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.OCCUPIED_AREA_HAS_NOT_BEEN_INITIALIZED))
    public void absPosFlexGridSingleAxisTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("absPosFlexGridSingleAxis", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
