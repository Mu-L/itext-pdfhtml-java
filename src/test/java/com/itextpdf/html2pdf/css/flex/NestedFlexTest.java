package com.itextpdf.html2pdf.css.flex;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Tag("IntegrationTest")
public class NestedFlexTest extends ExtendedHtmlConversionITextTest {

    private static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/flex/NestedFlexTest/";
    private static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/flex/NestedFlexTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void nestedFlexWithTable() throws IOException, InterruptedException {
        convertToPdfAndCompare("nestedFlexWithTable", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void nestedFlexWithDiv() throws IOException, InterruptedException {
        convertToPdfAndCompare("nestedFlexWithDiv", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void nestedFlexWithParagraph() throws IOException, InterruptedException {
        convertToPdfAndCompare("nestedFlexWithParagraph", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
