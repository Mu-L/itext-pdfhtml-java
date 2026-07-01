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
package com.itextpdf.html2pdf.css.selectors;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class WhereSelectorTest extends ExtendedHtmlConversionITextTest {
    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/selectors/WhereSelectorTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/selectors/WhereSelectorTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9519 display:flex is not supported with ul/ol elements.
    public void whereDeepNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereDeepNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereDeepNested2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereDeepNested2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereFlexDirReadDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereFlexDirReadDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereFlexWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereFlexWrapAlignTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereFlexWrapAlign", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereGapJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereGapJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereLosesFromClassTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereLosesFromClass", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9519 display:flex is not supported with ul/ol elements.
    public void whereNestedListsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereNestedLists", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9519 display:flex is not supported with ul/ol elements.
    public void whereNestedListsFlexTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereNestedListsFlex", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9519 display:flex is not supported with ul/ol elements.
    public void whereNthChildTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereNthChild", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereReadDirFlexTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereReadDirFlex", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereSelectorBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereSelectorBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereSpecificOverrideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereSpecificOverride", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void whereWithIdTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereWithId", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

}
