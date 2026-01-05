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
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfUAConformance;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.pdfua.PdfUAConfig;
import com.itextpdf.pdfua.PdfUADocument;
import com.itextpdf.pdfua.exceptions.PdfUAConformanceException;
import com.itextpdf.pdfua.exceptions.PdfUAExceptionMessageConstants;
import com.itextpdf.styledxmlparser.resolver.font.BasicFontProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Tag("IntegrationTest")
public class LabelTest extends ExtendedHtmlConversionITextTest {
    private static final String DESTINATION_FOLDER =  "./target/test/com/itextpdf/html2pdf/css/LabelTest/";
    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/LabelTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void implicitLabelTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "implicitLabel.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "implicit label", "en-US"))) {
            pdf.setTagged();
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "implicitLabel.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "implicitLabel.pdf", SOURCE_FOLDER + "cmp_implicitLabel.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void implicitLabelOnInputTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "implicitLabelOnInput.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "implicit label", "en-US"))) {
            pdf.setTagged();
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "implicitLabelOnInput.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "implicitLabelOnInput.pdf", SOURCE_FOLDER + "cmp_implicitLabelOnInput.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void implicitLabelOnSelectTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "implicitLabelOnSelect.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "implicit label", "en-US"))) {
            pdf.setTagged();
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "implicitLabelOnSelect.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "implicitLabelOnSelect.pdf", SOURCE_FOLDER + "cmp_implicitLabelOnSelect.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void implicitLabelOnAreaTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "implicitLabelOnArea.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "implicit label", "en-US"))) {
            pdf.setTagged();
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "implicitLabelOnArea.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "implicitLabelOnArea.pdf", SOURCE_FOLDER + "cmp_implicitLabelOnArea.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void labelledByTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "labelledBy.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "labeled by", "en-US"))) {
            pdf.setTagged();
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "labelledBy.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "labelledBy.pdf", SOURCE_FOLDER + "cmp_labelledBy.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void labelledByOrderTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "labelledByOrder.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "labeled by", "en-US"))) {
            pdf.setTagged();
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "labelledByOrder.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "labelledByOrder.pdf", SOURCE_FOLDER + "cmp_labelledByOrder.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void describedByTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "describedBy.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "described by", "en-US"))) {
            pdf.setTagged();
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "describedBy.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "describedBy.pdf", SOURCE_FOLDER + "cmp_describedBy.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void complexImplicitLabelTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "complexImplicitLabel.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "implicit label", "en-US"))) {
            pdf.setTagged();
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "complexImplicitLabel.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "complexImplicitLabel.pdf", SOURCE_FOLDER + "cmp_complexImplicitLabel.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void ariaLabelTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "ariaLabel.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "aria label", "en-US"))) {
            pdf.setTagged();
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "ariaLabel.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "ariaLabel.pdf", SOURCE_FOLDER + "cmp_ariaLabel.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void explicitLabelSimpleTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "explicitLabel.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "explicit label", "en-US"))) {
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "explicitLabel.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "explicitLabel.pdf", SOURCE_FOLDER + "cmp_explicitLabel.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void explicitLabelAfterElementTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "explicitLabelAfterElement.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "explicit label", "en-US"))) {
            HtmlConverter.convertToPdf(Files.newInputStream(Paths.get(SOURCE_FOLDER + "explicitLabelAfterElement.html")), pdf, properties);
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "explicitLabelAfterElement.pdf", SOURCE_FOLDER + "cmp_explicitLabelAfterElement.pdf", DESTINATION_FOLDER, "diff_"));
    }

    @Test
    public void invalidIdLabelTest() throws IOException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "invalidIdLabel.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "invalid label", "en-US"));
        try (InputStream input = Files.newInputStream(Paths.get(SOURCE_FOLDER + "invalidIdLabel.html"))) {
            Exception exception = Assertions.assertThrows(PdfUAConformanceException.class, () -> {
                HtmlConverter.convertToPdf(input, pdf, properties);
            });
            Assertions.assertEquals(PdfUAExceptionMessageConstants.MISSING_FORM_FIELD_DESCRIPTION, exception.getMessage());
        }
    }

    @Test
    public void invalidIdLabelledByTest() throws IOException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "invalidIdLabelledBy.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "invalid label", "en-US"));
        try (InputStream input = Files.newInputStream(Paths.get(SOURCE_FOLDER + "invalidIdLabelledBy.html"))) {
            Exception exception = Assertions.assertThrows(PdfUAConformanceException.class, () -> {
                HtmlConverter.convertToPdf(input, pdf, properties);
            });
            Assertions.assertEquals(PdfUAExceptionMessageConstants.MISSING_FORM_FIELD_DESCRIPTION, exception.getMessage());
        }
    }

    @Test
    public void invalidIdDescribedByTest() throws IOException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "invalidIdDescribedBy.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "invalid label", "en-US"));
        try (InputStream input = Files.newInputStream(Paths.get(SOURCE_FOLDER + "invalidIdDescribedBy.html"))) {
            Exception exception = Assertions.assertThrows(PdfUAConformanceException.class, () -> {
                HtmlConverter.convertToPdf(input, pdf, properties);
            });
            Assertions.assertEquals(PdfUAExceptionMessageConstants.MISSING_FORM_FIELD_DESCRIPTION, exception.getMessage());
        }
    }

    @Test
    public void emptyImplicitLabelTest() throws IOException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "emptyImplicitLabel.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "invalid label", "en-US"));
        try (InputStream input = Files.newInputStream(Paths.get(SOURCE_FOLDER + "emptyImplicitLabel.html"))) {
            Exception exception = Assertions.assertThrows(PdfUAConformanceException.class, () -> {
                HtmlConverter.convertToPdf(input, pdf, properties);
            });
            Assertions.assertEquals(PdfUAExceptionMessageConstants.MISSING_FORM_FIELD_DESCRIPTION, exception.getMessage());
        }
    }

    @Test
    public void emptyExplicitLabelTest() throws IOException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        PdfDocument pdf = new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "emptyExplicitLabel.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "invalid label", "en-US"));
        try (InputStream input = Files.newInputStream(Paths.get(SOURCE_FOLDER + "emptyExplicitLabel.html"))) {
            Exception exception = Assertions.assertThrows(PdfUAConformanceException.class, () -> {
                HtmlConverter.convertToPdf(input, pdf, properties);
            });
            Assertions.assertEquals(PdfUAExceptionMessageConstants.MISSING_FORM_FIELD_DESCRIPTION, exception.getMessage());
        }
    }

    @Test
    public void labelConvertToElementsTest() throws IOException, InterruptedException {
        ConverterProperties properties = new ConverterProperties().setCreateAcroForm(true).setFontProvider(new BasicFontProvider(false, true, false));
        try (Document document = new Document(new PdfUADocument(new PdfWriter(DESTINATION_FOLDER + "labelConvertToElements.pdf"), new PdfUAConfig(PdfUAConformance.PDF_UA_1, "label to elements", "en-US")))) {
            List<IElement> elements = HtmlConverter.convertToElements(Files.newInputStream(Paths.get(SOURCE_FOLDER + "labelConvertToElements.html")), properties);
            document.setProperty(Property.COLLAPSING_MARGINS, true);
            for (IElement elem : elements) {
                if (elem instanceof IBlockElement) {
                    document.add((IBlockElement) elem);
                } else if (elem instanceof Image) {
                    document.add((Image) elem);
                } else if (elem instanceof AreaBreak) {
                    document.add((AreaBreak) elem);
                } else {
                    Assertions.fail("The #convertToElements method gave element which is unsupported as root element, it's unexpected.");
                }
            }
        }
        Assertions.assertNull(new CompareTool().compareByContent(DESTINATION_FOLDER + "labelConvertToElements.pdf", SOURCE_FOLDER + "cmp_labelConvertToElements.pdf", DESTINATION_FOLDER, "diff_"));
    }

}
