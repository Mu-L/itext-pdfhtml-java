<p align="center">
    <img src="./assets/iText_Logo_Small.png" alt="Logo iText">
</p>


[![Maven Central](https://img.shields.io/maven-central/v/com.itextpdf/html2pdf)](https://mvnrepository.com/artifact/com.itextpdf/html2pdf)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](https://github.com/itext/itext-pdfhtml-java/blob/develop/LICENSE.md)
[![GitHub all releases](https://img.shields.io/github/downloads/itext/itext-pdfhtml-java/total)](https://github.com/itext/itext-pdfhtml-java/releases/latest)
![GitHub commit activity (branch)](https://img.shields.io/github/commit-activity/m/itext/itext-pdfhtml-java)

html2PDF is an iText Core add-on available for Java and C# (.NET) that allows you to easily convert HTML and CSS into
standards
compliant PDFs that are accessible, searchable and usable for indexing.

### The key features of html2PDF are:

* Converting XML/HTML & CSS to PDF or PDF/A
* Convert XML/HTML & CSS to iText objects
* Good default support for HTML5 and CSS3
* Easily configurable and extensible when needed
* Not based on any browser engine implementation

For the full list of supported\unsupported features please refer to [Supported\Unsupported featues](https://kb.itextpdf.com/itext/what-features-are-supported-or-unsupported-in-pdfh)


Want to discover what's possible? Head over to
our [Demo Lab](https://itextpdf.com/demos/convert-html-css-to-pdf-free-online)! It contains a collection of
demo applications ready to use online!

### Getting started

The easiest way to get started is to use Maven, just add the following entries to your pom.xml file:

```html

<properties>
    <html2pdf.version>REPLACE_WITH_DESIRED_VERSION</html2pdf.version>
    <pdfua.version>REPLACE_WITH_DESIRED_VERSION</pdfua.version>
</properties>
<dependencies>
    <dependency>
        <groupId>com.itextpdf</groupId>
        <artifactId>html2pdf</artifactId>
        <version>${html2pdf.version}</version>
    </dependency>
</dependencies>
```

For more advanced use cases, please refer to
the [Installation guidelines](https://kb.itextpdf.com/home/it7kb/installation-guidelines).
You can also [build iText Community from source][building].

### Hello html2PDF!

The following code snippet shows how to convert HTML to PDF using the `HtmlConverter` class:

```java
package com.itextpdf.hellohtml2pdf;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.FileInputStream;
import java.io.IOException;

public class Html2PdfApp {

    public static void main(String[] args) throws IOException {
        //Convert from String
        HtmlConverter.convertToPdf("<h1>Hello world</h1>", new PdfWriter("./out.pdf"));
        //Convert from File
        HtmlConverter.convertToPdf(new FileInputStream("./path-to-html-file.html"),
                new PdfWriter("./out2.pdf"));
    }
}
```

### Examples

| Description                                           | Link                                                                                                                                                                                                                                                                                         |
|-------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Convert HTML to PDF/A-3B compliant document           | [Java](https://github.com/itext/itext-publications-examples-java/blob/master/src/main/java/com/itextpdf/samples/sandbox/pdfhtml/HtmlToPdfA3Convert.java), [PDF](https://github.com/itext/itext-publications-examples-java/blob/master/cmpfiles/sandbox/pdfhtml/cmp_HtmlToPdfA3Convert.pdf)   |
| Convert HTML with custom QR code tags to PDF          | [Java](https://github.com/itext/itext-publications-examples-java/blob/master/src/main/java/com/itextpdf/samples/sandbox/pdfhtml/ParseHtmlQRcode.java), [PDF](https://github.com/itext/itext-publications-examples-java/blob/master/cmpfiles/sandbox/pdfhtml/cmp_qrcode.pdf)                  |
| Create accessible tagged PDF from HTML content        | [Java](https://github.com/itext/itext-publications-examples-java/blob/master/src/main/java/com/itextpdf/samples/sandbox/pdfhtml/CreateAccessiblePDF.java), [PDF](https://github.com/itext/itext-publications-examples-java/blob/master/cmpfiles/sandbox/pdfhtml/cmp_Accessibility.pdf)       |
| Convert HTML to PDF simulating color blindness vision | [Java](https://github.com/itext/itext-publications-examples-java/blob/master/src/main/java/com/itextpdf/samples/sandbox/pdfhtml/ParseHtmlColorBlind.java), [PDF](https://github.com/itext/itext-publications-examples-java/blob/master/cmpfiles/sandbox/pdfhtml/cmp_rainbow_colourBlind.pdf) |
| Register custom fonts for HTML to PDF                 | [Java](https://github.com/itext/itext-publications-examples-java/blob/master/src/main/java/com/itextpdf/samples/sandbox/pdfhtml/UsingCustomFonts.java)                                                                                                                                       |
| Convert HTML forms to tagged PDF with custom roles    | [Java](https://github.com/itext/itext-publications-examples-java/blob/master/src/main/java/com/itextpdf/samples/sandbox/pdfhtml/PdfHtmlFormTagging.java), [PDF](https://github.com/itext/itext-publications-examples-java/blob/master/cmpfiles/sandbox/pdfhtml/cmp_changeFormRole.pdf)       |
| Convert HTML file with assets                         | [Java](https://github.com/itext/i7js-examples/blob/master/src/main/java/com/itextpdf/samples/sandbox/layout/ParagraphTextWithStyle.java), [PDF](https://github.com/itext/i7js-examples/blob/master/cmpfiles/sandbox/layout/cmp_paragraphTextWithStyle.pdf)                                   |
| Enable formfield interactivity                        | [Java](https://github.com/itext/i7js-examples/blob/master/src/main/java/com/itextpdf/samples/sandbox/layout/ParagraphTextWithStyle.java), [PDF](https://github.com/itext/i7js-examples/blob/master/cmpfiles/sandbox/layout/cmp_paragraphTextWithStyle.pdf)                                   |
| Convert HTML containing arabic and hebrew             | [Java](https://kb.itextpdf.com/itext/how-to-convert-html-containing-arabic-hebrew-chara), [PDF](https://github.com/itext/i7js-examples/blob/master/cmpfiles/sandbox/layout/cmp_paragraphTextWithStyle.pdf)                                                                                   |

### FAQs, tutorials, etc. ###
Check out the [iText Knowledge Base](https://kb.itextpdf.com) for the [iText Jump-start tutorial](https://kb.itextpdf.com/home/it7kb/ebooks/itext-jump-start-tutorial-for-java) and other tutorials, [FAQs](https://kb.itextpdf.com/home/it7kb/faq) and more.

Many common questions have already been answered
on [Stack Overflow](https://stackoverflow.com/questions/tagged/itext+html2pdf), so make sure to also check there.

### Contributing

Many people have contributed to **iText Community** over the years. If you've found a bug, a mistake in documentation, or have a hot new feature you want to implement, we welcome your contributions.

Small changes or fixes can be submitted as a [Pull Request](https://github.com/itext/itext-pdfhtml-java/pulls), while for major changes we request you contact us at community@apryse.com so we can better coordinate our efforts and prevent duplication of work.

Please read our [Contribution Guidelines][contributing] for details on code submissions, coding rules, and more.

### Licensing

**html2Pdf** is dual licensed as [AGPL][agpl]/[Commercial software][sales].

AGPL is a free/open-source software license, however, this doesn't mean the software is [gratis][gratis]!

The AGPL is a copyleft license, which means that any derivative work must also be licensed under the same terms. If you’re using iText in software or a service which cannot comply with the AGPL terms, we have a commercial license available that exempts you from such obligations.

Contact [Sales] for more info.

[agpl]: LICENSE.md

[building]: BUILDING.md

[contributing]: CONTRIBUTING.md

[sales]: https://itextpdf.com/sales

[gratis]: https://en.wikipedia.org/wiki/Gratis_versus_libre
