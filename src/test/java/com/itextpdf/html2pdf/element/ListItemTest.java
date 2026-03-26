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
package com.itextpdf.html2pdf.element;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.logs.IoLogMessageConstant;
import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.layout.logs.LayoutLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import java.io.File;
import java.io.IOException;

@Tag("IntegrationTest")
public class ListItemTest extends ExtendedHtmlConversionITextTest {

	public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/element/ListItemTest/";
	public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/element/ListItemTest/";

	@BeforeAll
	public static void beforeClass() {
		createDestinationFolder(DESTINATION_FOLDER);
	}

	@Test
	@LogMessages(messages = {@LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 14)})
	public void rtlListItemInsideLtrOrderedListTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rtlListItemInsideLtrOrderedListTest", SOURCE_FOLDER, DESTINATION_FOLDER);
	}

	@Test
	@LogMessages(messages = {@LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 16)})
	public void listItemWithDifferentDirAndPositionInsideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("listItemWithDifferentDirAndPositionInsideTest", SOURCE_FOLDER, DESTINATION_FOLDER);
	}

	@Test
	@LogMessages(messages = {@LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 12)})
	public void rtlListItemInsideLtrUnorderedListTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rtlListItemInsideLtrUnorderedListTest", SOURCE_FOLDER, DESTINATION_FOLDER);
	}

	@Test
	@LogMessages(messages = {@LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 12)})
	public void drawBulletRtlTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("drawBulletRtl", SOURCE_FOLDER, DESTINATION_FOLDER);
	}

	@Test
	@LogMessages(messages = {@LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 16)})
	public void drawBulletLtrTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("drawBulletLtr", SOURCE_FOLDER, DESTINATION_FOLDER);
	}

	@Test
	@LogMessages(messages = {@LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 8)})
	public void bulletsAreNotDrawnAsTheyAreInPageMarginsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("bulletsAreNotDrawnAsTheyAreInPageMargins", SOURCE_FOLDER, DESTINATION_FOLDER);
	}

	@Test
	@LogMessages(messages = {@LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 20)})
	public void rltListItemWithDifferentMarginsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("rltListItemWithDifferentMargins", SOURCE_FOLDER, DESTINATION_FOLDER);
	}

	@Test
	@LogMessages(messages = {@LogMessage(messageTemplate = IoLogMessageConstant.TYPOGRAPHY_NOT_FOUND, count = 16)})
	public void diffListItemsInsideDiffListsWithDiffDirectionsWithoutWidthTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("diffListItemsInsideDiffListsWithDiffDirectionsWithoutWidth", SOURCE_FOLDER, DESTINATION_FOLDER);
	}

	@Test
	public void listItemWithBlockDisplayTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("listItemWithBlockDisplay", SOURCE_FOLDER, DESTINATION_FOLDER);
	}
}
