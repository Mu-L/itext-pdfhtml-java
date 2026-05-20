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
public class IsSelectorTest extends ExtendedHtmlConversionITextTest {
    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/selectors/IsSelectorTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/selectors/IsSelectorTest/";

    @BeforeAll
    public static void beforeClass() {
        createDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void isClassOverridesListTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isClassOverridesList", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9519 display:flex is not supported with ul/ol elements.
    public void isDeepNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isDeepNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isDeepNested2Test() throws IOException, InterruptedException {
        convertToPdfAndCompare("isDeepNested2", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isFirstVsClassTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isFirstVsClass", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isFlexDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isFlexDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = "Cannot find pdfCalligraph module, which was implicitly required by one of the layout properties", count = 48))
    public void isFlexDirReadDirTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isFlexDirReadDir", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isFlexWrapTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isFlexWrap", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isFlexWrapAlignTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isFlexWrapAlign", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isGapJustifyContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isGapJustifyContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isGroupedSelectorsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isGroupedSelectors", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isNestedTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isNested", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9519 display:flex is not supported with ul/ol elements.
    public void isNestedListsTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isNestedLists", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9519 display:flex is not supported with ul/ol elements.
    public void isNestedListsFlexTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isNestedListsFlex", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    // TODO DEVSIX-9519 display:flex is not supported with ul/ol elements.
    public void isNthChildTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isNthChild", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = "Cannot find pdfCalligraph module, which was implicitly required by one of the layout properties", count = 48))
    public void isReadDirFlexTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isReadDirFlex", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isSelectoreBasicTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isSelectoreBasic", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isSpecificOverrideTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isSpecificOverride", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isWinsFromClassTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isWinsFromClass", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isWithIdTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isWithId", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void isWithJustifyAndAlignContentTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("isWithJustifyAndAlignContent", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
