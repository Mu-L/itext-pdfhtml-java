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

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.layout.font.FontProvider;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class JapaneseLineBreakingRulesTest extends ExtendedHtmlConversionITextTest {
    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/JapaneseLineBreakingRulesTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/JapaneseLineBreakingRulesTest/";
    private static final String FONTS_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/fonts/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    // See https://www.w3.org/TR/jlreq/?lang=en#characters_not_starting_a_line
    @Test
    public void charsNotStartingLineTest() throws IOException, InterruptedException {
        FontProvider fontProvider = new FontProvider();
        fontProvider.addFont(FONTS_FOLDER + "NotoSansJP-Regular.ttf");

        ConverterProperties props = new ConverterProperties();
        props.setFontProvider(fontProvider);

        convertToPdfAndCompare("charsNotStartingLine", SOURCE_FOLDER, DESTINATION_FOLDER, false, props);
    }

    // See https://www.w3.org/TR/jlreq/?lang=en#characters_not_ending_a_line
    @Test
    public void charsNotEndingLineTest() throws IOException, InterruptedException {
        FontProvider fontProvider = new FontProvider();
        fontProvider.addFont(FONTS_FOLDER + "NotoSansJP-Regular.ttf");

        ConverterProperties props = new ConverterProperties();
        props.setFontProvider(fontProvider);

        // There is a bug in browsers that they handle left and right (double) quotes as same chars.
        // It's why browsers don't allow to start a line from '“' (Left Double Quotation Mark)
        convertToPdfAndCompare("charsNotEndingLine", SOURCE_FOLDER, DESTINATION_FOLDER, false, props);
    }

    // See https://www.w3.org/TR/jlreq/?lang=en#unbreakable_character_sequences
    @Test
    // TODO DEVSIX-4863 Layout splitting logic handles negative values incorrectly if they are not in the very beginning of Text element
    public void unseparableSequenceTest() throws IOException, InterruptedException {
        FontProvider fontProvider = new FontProvider();
        fontProvider.addFont(FONTS_FOLDER + "NotoSansJP-Regular.ttf");

        ConverterProperties props = new ConverterProperties();
        props.setFontProvider(fontProvider);

        convertToPdfAndCompare("unseparableSequence", SOURCE_FOLDER, DESTINATION_FOLDER, false, props);
    }
}
