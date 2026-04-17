package com.itextpdf.html2pdf.css.selectors;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class CombinedWhereIsSelectorTest extends ExtendedHtmlConversionITextTest {
    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/selectors/CombinedWhereIsSelectorTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/selectors/CombinedWhereIsSelectorTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 2)})
    public void isVsWhereTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isVsWhere", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void isWhereNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isWhereNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 2)})
    public void nestedSelectorsBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("nestedSelectorsBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereIsNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereIsNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 2)})
    public void whereIsWithJustifyAndAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereIsWithJustifyAndAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 2)})
    public void combinedDeepNestingTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("combinedDeepNesting", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 2)})
    public void combinedOverwriteChainTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("combinedOverwriteChain", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 2)})
    public void combinedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("combinedTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 2)})
    public void combinedTest2() throws IOException, InterruptedException {
        convertToPdfAndCompare("combinedTest2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
