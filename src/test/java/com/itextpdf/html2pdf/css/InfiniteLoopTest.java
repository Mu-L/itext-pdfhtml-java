package com.itextpdf.html2pdf.css;

import com.itextpdf.commons.utils.FileUtil;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.exceptions.PdfException;
import com.itextpdf.kernel.pdf.DocumentProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.utils.LayoutInfiniteLoopResolver;
import com.itextpdf.test.ExtendedITextTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class InfiniteLoopTest extends ExtendedITextTest {
    private static final String SRC = "./src/test/resources/com/itextpdf/html2pdf/css/InfiniteLoopTest/";
    private static final String DEST = "./target/test/com/itextpdf/html2pdf/css/InfiniteLoopTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DEST);
    }

    @Test
    public void tooBigHtmlThrowsTest() {
        String testName = "tooBigHtml";
        DocumentProperties documentProperties = new DocumentProperties();
        documentProperties.registerDependency(LayoutInfiniteLoopResolver.class, () -> new LayoutInfiniteLoopResolver(9));

        Assertions.assertThrows(PdfException.class,
                () -> HtmlConverter.convertToPdf(FileUtil.getInputStreamForFile(SRC + testName + ".html"),
                        new PdfDocument(new PdfWriter(DEST + testName + ".pdf"), documentProperties)));
    }
}
