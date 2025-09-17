package com.itextpdf.html2pdf.css;

import com.itextpdf.html2pdf.ExtendedHtmlConversionITextTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Tag("IntegrationTest")
public class CssEscapedSelectorTest extends ExtendedHtmlConversionITextTest {
    public static final String SOURCE_FOLDER = "./src/test/resources/com/itextpdf/html2pdf/css/CssEscapedSelectorTest/";
    public static final String DESTINATION_FOLDER = "./target/test/com/itextpdf/html2pdf/css/CssEscapedSelectorTest/";

    @BeforeAll
    public static void beforeClass() {
        createOrClearDestinationFolder(DESTINATION_FOLDER);
    }

    @Test
    public void escapedDotTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("escapedDotTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void escapedHexTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("escapedHexTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void escapedAttributeTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("escapedAttributeTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }

    @Test
    public void escapedPseudoElementTest() throws IOException, InterruptedException {
        convertToPdfAndCompare("escapedPseudoElementTest", SOURCE_FOLDER, DESTINATION_FOLDER);
    }
}
