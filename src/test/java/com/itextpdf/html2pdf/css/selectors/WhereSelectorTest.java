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
public class WhereSelectorTest extends ExtendedHtmlConversionITextTest {
    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/selectors/WhereSelectorTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/selectors/WhereSelectorTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereDeepNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereDeepNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereDeepNested2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereDeepNested2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR),
            @LogMessage(messageTemplate = "Cannot find pdfCalligraph module, which was implicitly required by one of the layout properties", count = 48)})
    public void whereFlexDirReadDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereFlexDirReadDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereFlexWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereFlexWrapAlignTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereFlexWrapAlign", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereGapJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereGapJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereLosesFromClassTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereLosesFromClass", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereNestedListsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereNestedLists", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereNestedListsFlexTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereNestedListsFlex", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 2)})
    public void whereNthChildTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereNthChild", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 2),
            @LogMessage(messageTemplate = "Cannot find pdfCalligraph module, which was implicitly required by one of the layout properties", count = 48)})
    public void whereReadDirFlexTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereReadDirFlex", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereSelectorBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereSelectorBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR)})
    public void whereSpecificOverrideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereSpecificOverride", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.ERROR_PARSING_CSS_SELECTOR, count = 3)})
    public void whereWithIdTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("whereWithId", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

}
