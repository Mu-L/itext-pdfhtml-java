/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2025 Apryse Group NV
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
package com.itextpdf.html2pdf.css.flex;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.io.logs.IoLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class FlexContainerTest extends ExtendedHtmlConversionITextTest {

    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/flex/FlexContainerTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/flex/FlexContainerTest/";

    //TODO DEVSIX-7402: Update cmp / tests
    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void itemsHigherThanContainerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("itemsHigherThanContainer", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void aBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("aBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void aBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("aBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void aLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("aLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void aNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("aNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    public void aUlNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("aUlNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void aWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("aWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void articleBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("articleBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void articleBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("articleBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void articleLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("articleLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void articleNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("articleNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    public void articleUlNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("articleUlNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void articleWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("articleWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void buttonBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("buttonBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void buttonBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("buttonBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.ELEMENT_DOES_NOT_FIT_CURRENT_AREA))
    public void buttonLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("buttonLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void buttonNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("buttonNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void buttonWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("buttonWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void figureBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("figureBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void figureBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("figureBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void figureLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("figureLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void figureNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("figureNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void figureWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("figureWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void footerBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("footerBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void footerBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("footerBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void footerLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("footerLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void footerNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("footerNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void footerWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("footerWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void formBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("formBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void formBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("formBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void formLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("formLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void formNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("formNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void formWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("formWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void headerBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("headerBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void headerBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("headerBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void headerLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("headerLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void headerNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("headerNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void headerWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("headerWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void labelBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("labelBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void labelBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("labelBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void labelNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("labelNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void labelWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("labelWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void labelLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("labelLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void liBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("liBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void liBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("liBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void olBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("olBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void olBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("olBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void olLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("olLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void olNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("olNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void olWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("olWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void pBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("pBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 80))
    public void pLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("pLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages =
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 4))
    public void pNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("pNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 8))
    public void pWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("pWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void pBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("pBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void sectionBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("sectionBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void sectionBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("sectionBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void sectionLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("sectionLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void sectionNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("sectionNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void sectionWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("sectionWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    public void ulBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ulBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    public void ulBasic2ColTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ulBasic2Col", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    public void ulLongTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ulLong", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    public void ulNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ulNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    public void ulWideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ulWide", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void flexNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void deepNestingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("deepNesting", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    public void deepNesting2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("deepNesting2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void sectionButtonNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("sectionButtonNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void sectionFormNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("sectionFormNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 4))
    public void largeMarginTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("largeMargin", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 4))
    public void largeMarginsAndPaddingsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("largeMarginsAndPaddings", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 4))
    public void largePaddingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("largePadding", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void aJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("aJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void articleJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("articleJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    public void ulJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ulJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 36))
    public void pJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("pJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void sectionJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("sectionJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void olJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("olJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void liJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("liJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void headerJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("headerJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void formJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("formJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void footerJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("footerJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void figureJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("figureJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void buttonJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("buttonJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT, count = 6))
    public void articleAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("articleAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void aAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("aAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT, count = 6))
    public void ulAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("ulAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT, count = 6))
    public void olAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("olAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT))
    public void liAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("liAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT, count = 6))
    public void formAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("formAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT, count = 6))
    public void figureAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("figureAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void buttonAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("buttonAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 42))
    public void pAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("pAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT, count = 6))
    public void footerAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("footerAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT, count = 6))
    public void headerAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("headerAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT, count = 6))
    public void sectionAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("sectionAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 4))
    public void gapOnFlexTagsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapOnFlexTags", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 10),
            @LogMessage(messageTemplate = IoLogMessageConstant.CLIP_ELEMENT, count = 8)})
    public void flexTagAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexTagAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET),
            @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 5)})
    public void pAlignSelfTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("pAlignSelf", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.FLEX_PROPERTY_IS_NOT_SUPPORTED_YET, count = 10))
    public void flexTagAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexTagAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void pAlignItemsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("pAlignItems", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 4))
    public void gapOnFlexTags2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("gapOnFlexTags2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 4))
    public void flexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 4))
    public void flexNoWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexNoWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    //TODO DEVSIX-8730: Update after fix
    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = Html2PdfLogMessageConstant.WORKER_UNABLE_TO_PROCESS_OTHER_WORKER, count = 4))
    public void flexWrapReverseTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("flexWrapReverse", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void headerArticleNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("headerArticleNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
