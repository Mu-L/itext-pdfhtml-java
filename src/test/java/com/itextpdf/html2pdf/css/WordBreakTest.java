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
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.logs.IoLogMessageConstant;
import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.styledxmlparser.resolver.font.BasicFontProvider;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

@Tag("IntegrationTest")
public class WordBreakTest extends ExtendedITextTest {

    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/WordBreakTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/WordBreakTest/";
    private static final String FONTS_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/fonts/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void wordBreakCommonScenarioTest() throws IOException, InterruptedException {
        FontProvider fontProvider = new BasicFontProvider();
        fontProvider.addFont(FONTS_FOLDER + "NotoSansCJKjp-Regular.otf");

        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setFontProvider(fontProvider);

        HtmlConverter.convertToPdf(new File(SOURCE_FOLDER + "wordBreakCommonScenario.html"),
                new File(DESTINATION_FOLDER + "wordBreakCommonScenario.pdf"), converterProperties);
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "wordBreakCommonScenario.pdf",
                SOURCE_FOLDER + "cmp_wordBreakCommonScenario.pdf", DESTINATION_FOLDER));
    }

    @Test
    public void overflowXWordBreakTest() throws IOException, InterruptedException {
        FontProvider fontProvider = new BasicFontProvider();
        fontProvider.addFont(FONTS_FOLDER + "NotoSansCJKjp-Regular.otf");

        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setFontProvider(fontProvider);

        HtmlConverter.convertToPdf(new File(SOURCE_FOLDER + "overflowXWordBreak.html"),
                new File(DESTINATION_FOLDER + "overflowXWordBreak.pdf"), converterProperties);
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "overflowXWordBreak.pdf",
                SOURCE_FOLDER + "cmp_overflowXWordBreak.pdf", DESTINATION_FOLDER));
    }

    @Test
    public void whiteSpaceAndWordBreakTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(SOURCE_FOLDER + "whiteSpaceAndWordBreak.html"),
                new File(DESTINATION_FOLDER + "whiteSpaceAndWordBreak.pdf"));
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "whiteSpaceAndWordBreak.pdf",
                SOURCE_FOLDER + "cmp_whiteSpaceAndWordBreak.pdf", DESTINATION_FOLDER));
    }

    @Test
    public void wordBreakMidNumbersTest() throws IOException, InterruptedException {
        FontProvider fontProvider = new BasicFontProvider();
        fontProvider.addFont(FONTS_FOLDER + "NotoSansCJKjp-Regular.otf");

        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setFontProvider(fontProvider);

        HtmlConverter.convertToPdf(new File(SOURCE_FOLDER + "wordBreakMidNumbers.html"),
                new File(DESTINATION_FOLDER + "wordBreakMidNumbers.pdf"), converterProperties);
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "wordBreakMidNumbers.pdf",
                SOURCE_FOLDER + "cmp_wordBreakMidNumbers.pdf", DESTINATION_FOLDER));
    }

    @Test
    public void wordBreakMidPunctuationTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(SOURCE_FOLDER + "wordBreakMidPunctuation.html"),
                new File(DESTINATION_FOLDER + "wordBreakMidPunctuation.pdf"));
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "wordBreakMidPunctuation.pdf",
                SOURCE_FOLDER + "cmp_wordBreakMidPunctuation.pdf", DESTINATION_FOLDER));
    }

    @Test
    public void wordBreakAllAndFloatTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(SOURCE_FOLDER + "wordBreakAllAndFloat.html"),
                new File(DESTINATION_FOLDER + "wordBreakAllAndFloat.pdf"));
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "wordBreakAllAndFloat.pdf",
                SOURCE_FOLDER + "cmp_wordBreakAllAndFloat.pdf", DESTINATION_FOLDER));
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = IoLogMessageConstant
            .TABLE_WIDTH_IS_MORE_THAN_EXPECTED_DUE_TO_MIN_WIDTH, count = 3)})
    public void wordBreakTableScenarioTest() throws IOException, InterruptedException {
        HtmlConverter.convertToPdf(new File(SOURCE_FOLDER + "wordBreakTableScenario.html"),
                new File(DESTINATION_FOLDER + "wordBreakTableScenario.pdf"));
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "wordBreakTableScenario.pdf",
                SOURCE_FOLDER + "cmp_wordBreakTableScenario.pdf", DESTINATION_FOLDER));
    }
}
