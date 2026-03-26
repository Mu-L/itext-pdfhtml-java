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
package com.itextpdf.html2pdf;

import com.itextpdf.commons.utils.MessageFormatUtil;
import com.itextpdf.html2pdf.exceptions.Html2PdfException;
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.io.logs.IoLogMessageConstant;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.exceptions.PdfException;
import com.itextpdf.kernel.pdf.PdfAConformance;
import com.itextpdf.kernel.pdf.PdfConformance;
import com.itextpdf.kernel.pdf.PdfUAConformance;
import com.itextpdf.kernel.pdf.PdfVersion;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WellTaggedPdfConformance;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.pdfua.exceptions.PdfUAExceptionMessageConstants;
import com.itextpdf.pdfua.logs.PdfUALogMessageConstants;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import com.itextpdf.test.pdfa.VeraPdfValidator;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileInputStream;
import java.io.IOException;

@Tag("IntegrationTest")
public class HtmlConverterWithConformanceTest extends ExtendedITextTest {

    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf" +
            "/HtmlConverterWithConformanceTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/HtmlConverterWithConformanceTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    public static List<PdfConformance> conformanceLevels() {
        return Arrays.asList(
                PdfConformance.PDF_UA_1,
                PdfConformance.PDF_UA_2,
                PdfConformance.WELL_TAGGED_PDF_FOR_ACCESSIBILITY,
                PdfConformance.WELL_TAGGED_PDF_FOR_REUSE
        );
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void simpleLinkTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "simpleLink.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "simpleLink", null, true, null);
    }


    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void backwardLinkTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "backwardLink.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "backwardLink", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void longLinkBrokenAcrossPagesTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "longLinkBrokenAcrossPages.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "longLinkBrokenAcrossPages", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void imageLinkTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "imageLink.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "imageLink", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void externalLinkTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "externalLink.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "externalLink", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void simpleOutlineTest(PdfConformance conformance) throws IOException, InterruptedException {
        if (conformance == PdfConformance.PDF_UA_1) {
            String sourceHtmlUa1 = SOURCE_FOLDER + "simpleOutlineUa1.html";
            convertToUaAndCheckCompliance(conformance, sourceHtmlUa1, "simpleOutline", null, true, null);
        } else {
            String sourceHtmlUa2 = SOURCE_FOLDER + "simpleOutlineUa2.html";
            convertToUaAndCheckCompliance(conformance, sourceHtmlUa2, "simpleOutline", null, true, null);
        }
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void unsupportedGlyphTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "unsupportedGlyph.html";
        String expectedUaMessage = MessageFormatUtil.format(
                PdfUAExceptionMessageConstants.GLYPH_IS_NOT_DEFINED_OR_WITHOUT_UNICODE, '中');

        convertToUaAndCheckCompliance(conformance, sourceHtml, "unsupportedGlyph", null, false,
                expectedUaMessage);

    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void emptyElementsTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "emptyElements.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "emptyElements", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void boxSizingInlineBlockTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "boxSizingInlineBlock.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "boxSizingInlineBlock", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void divInButtonTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "divInButton.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "divInButton", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void headingInButtonTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "headingInButton.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "headingInButton", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void paragraphsInHeadingsTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "paragraphsInHeadings.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "paragraphsInHeadings", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void pageBreakAfterAvoidTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "pageBreakAfterAvoid.html";

        if (conformance == PdfConformance.PDF_UA_1) {
            convertToUaAndCheckCompliance(conformance, sourceHtml, "pageBreakAfterAvoid", null, true, null);
        } else {
            // Both structure destination and page destination are not created, because content is not rendered.
            convertToUaAndCheckCompliance(conformance, sourceHtml, "pageBreakAfterAvoid", null, false, null);
        }
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    @LogMessages(messages = {@LogMessage(messageTemplate = IoLogMessageConstant.NAME_ALREADY_EXISTS_IN_THE_NAME_TREE)})
    public void linkWithPageBreakBeforeTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "linkWithPageBreakBefore.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "linkWithPageBreakBefore", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void emptyHtmlTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "emptyHtml.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "emptyHtml", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void inputWithTitleTagTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "inputWithTitleTag.html";
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setCreateAcroForm(true);

        if (conformance == PdfConformance.PDF_UA_1) {
            convertToUaAndCheckCompliance(conformance, sourceHtml, "inputWithTitleTag", converterProperties,
                    true, null);
        } else {
            convertToUaAndCheckCompliance(conformance, sourceHtml, "inputWithTitleTag", converterProperties,
                    true, null);
        }
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void svgBase64Test(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "svgBase64.html";
        if (conformance == PdfConformance.PDF_UA_1) {
            convertToUaAndCheckCompliance(conformance, sourceHtml, "svgBase64", null, true, null);
        } else {
            convertToUaAndCheckCompliance(conformance, sourceHtml, "svgBase64", null, true, null);
        }
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    // TODO DEVSIX-9580 current VeraPdf version behaves incorrectly.
    public void pngInDivStyleTest(PdfConformance conformance) throws IOException, InterruptedException {
        // Investigate why VeraPdf doesn't complain about the missing tag.
        String sourceHtml = SOURCE_FOLDER + "pngInDivStyle.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "pngInDivStyle", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void svgAlternativeDescription(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "svgSimpleAlternateDescription.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "svgSimpleAlternateDescription", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    @LogMessages(messages = {@LogMessage(messageTemplate = PdfUALogMessageConstants.PAGE_FLUSHING_DISABLED),
            @LogMessage(messageTemplate = IoLogMessageConstant.NAME_ALREADY_EXISTS_IN_THE_NAME_TREE, count = 12)})
    public void extensiveRepairTaggingStructRepairTest(PdfConformance conformance)
            throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "tagStructureFixes.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "tagStructureFixes", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void inputFieldsUA2Test(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "input.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "input", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void flexTagsUA2Test(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "flexTagsUA2.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "flexTags", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    @LogMessages(messages = {@LogMessage(messageTemplate = PdfUALogMessageConstants.PAGE_FLUSHING_DISABLED, count = 1)})
    public void tableUa2Test(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "table.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "table", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void complexParagraphStructure(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "complexParagraphStructure.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "complexParagraphStructure", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void emptyTableDataCellTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "emptyTableDataCell.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "emptyTableDataCell", null, true, null);
    }

    @ParameterizedTest
    @MethodSource("conformanceLevels")
    public void zeroFontSizeTest(PdfConformance conformance) throws IOException, InterruptedException {
        String sourceHtml = SOURCE_FOLDER + "zeroFontSize.html";
        convertToUaAndCheckCompliance(conformance, sourceHtml, "zeroFontSize", null, true, null);
    }

    @Test
    public void duplicateConformanceLevelAAndUAThrows() {
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setPdfUAConformance(PdfUAConformance.PDF_UA_1);
        converterProperties.setPdfAConformance(PdfAConformance.PDF_A_4);
        PdfWriter dummy = new PdfWriter(new ByteArrayOutputStream());
        Exception e = Assertions.assertThrows(Html2PdfException.class, () -> {
            HtmlConverter.convertToPdf("<h1>Let's gooooo</h1>", dummy, converterProperties);
        });
        Assertions.assertEquals(Html2PdfLogMessageConstant.PDF_A_AND_PDF_UA_CONFORMANCE_CANNOT_BE_USED_TOGETHER,
                e.getMessage());
    }


    @Test
    public void duplicateConformanceLevelWtpdfandUAThrows() {
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setPdfUAConformance(PdfUAConformance.PDF_UA_1);
        converterProperties.setWtPdfConformance(WellTaggedPdfConformance.FOR_REUSE);
        PdfWriter dummy = new PdfWriter(new ByteArrayOutputStream());
        Exception e = Assertions.assertThrows(Html2PdfException.class, () -> {
            HtmlConverter.convertToPdf("<h1>Let's gooooo</h1>", dummy, converterProperties);
        });
        Assertions.assertEquals(Html2PdfLogMessageConstant.PDF_A_AND_PDF_UA_CONFORMANCE_CANNOT_BE_USED_TOGETHER,
                e.getMessage());
    }

    private void convertToUaAndCheckCompliance(PdfConformance conformance, String sourceHtml, String fileName,
            ConverterProperties converterProperties,
            boolean isExpectedOk, String expectedErrorMessage)
            throws IOException, InterruptedException {

        if (converterProperties == null) {
            converterProperties = new ConverterProperties();
        }
        if (conformance.isWtpdf()) {
            converterProperties.setWtPdfConformance(conformance.getWtpdfConformances().get(0));
        } else {
            converterProperties.setPdfUAConformance(conformance.getUAConformance());
        }
        converterProperties.setBaseUri(SOURCE_FOLDER);

        WriterProperties writerProperties = new WriterProperties();
        if (conformance.conformsTo(PdfConformance.PDF_UA_2,
                PdfConformance.WELL_TAGGED_PDF_FOR_ACCESSIBILITY, PdfConformance.WELL_TAGGED_PDF_FOR_REUSE)) {
            writerProperties.setPdfVersion(PdfVersion.PDF_2_0);
        }
        String destinationPdf = DESTINATION_FOLDER + fileName + ".pdf";
        String postFix = "";
        if (conformance.isWtpdf()) {
            postFix = "_wtpdf_" + conformance.getWtpdfConformances().get(0).name();
        } else {
            postFix = "Ua" + conformance.getUAConformance().getPart();
        }
        String cmpPdf = SOURCE_FOLDER + "cmp_" + fileName + postFix + ".pdf";
        FileInputStream fileInputStream = new FileInputStream(sourceHtml);
        try (PdfWriter pdfWriter = new PdfWriter(destinationPdf, writerProperties)) {
            if (expectedErrorMessage == null) {
                HtmlConverter.convertToPdf(fileInputStream, pdfWriter, converterProperties);
                compareAndCheckCompliance(destinationPdf, cmpPdf, isExpectedOk);
                return;
            }
            ConverterProperties finalConverterProperties = converterProperties;
            Exception e = Assertions.assertThrows(PdfException.class, () -> {
                HtmlConverter.convertToPdf(fileInputStream, pdfWriter, finalConverterProperties);
            });
            Assertions.assertEquals(expectedErrorMessage, e.getMessage());
        }
    }

    private static void compareAndCheckCompliance(String destinationPdf, String cmpPdf, boolean isExpectedOk)
            throws IOException, InterruptedException {
        if (isExpectedOk) {
            Assertions.assertNull(new VeraPdfValidator().validate(destinationPdf));
        } else {
            new VeraPdfValidator().validateFailure(destinationPdf);
        }
        Assertions.assertNull(
                new CompareTool().compareByContent(destinationPdf, cmpPdf, DESTINATION_FOLDER, "diff_simple_"));
        Assertions.assertNull(new CompareTool().compareXmp(destinationPdf, cmpPdf, true));
    }

}
