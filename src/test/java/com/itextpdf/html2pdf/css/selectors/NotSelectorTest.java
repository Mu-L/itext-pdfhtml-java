package com.itextpdf.html2pdf.css.selectors;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Tag("IntegrationTest")
public class NotSelectorTest extends ExtendedHtmlConversionITextTest {
    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/selectors/NotSelectorTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/selectors/NotSelectorTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void isFirstVsClassTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notFirstVsClass", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void notNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void notSelectorBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notSelectorBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 3)})
    public void notInvalidTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notInvalid", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void notSpecificityGreaterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notSpecificityGreater", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void complexNotSpecificityGreaterTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("complexNotSpecificityGreater", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void notSpecificityLowerTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("notSpecificityLower", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
