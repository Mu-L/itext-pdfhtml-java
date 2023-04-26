/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2023 Apryse Group NV
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

import com.itextpdf.commons.actions.contexts.IMetaInfo;
import com.itextpdf.html2pdf.attach.ITagWorker;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.attach.impl.DefaultTagWorkerFactory;
import com.itextpdf.html2pdf.attach.impl.tags.DivTagWorker;
import com.itextpdf.html2pdf.html.TagConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.layout.LayoutContext;
import com.itextpdf.layout.layout.LayoutResult;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.renderer.DivRenderer;
import com.itextpdf.layout.renderer.IRenderer;
import com.itextpdf.layout.renderer.MetaInfoContainer;
import com.itextpdf.styledxmlparser.node.IElementNode;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.type.UnitTest;

import java.io.ByteArrayOutputStream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(UnitTest.class)
public class HtmlConverterMetaInfoTest extends ExtendedITextTest {

    @Test
    public void metaInfoShouldBePresentTest() {
        IMetaInfo o = new IMetaInfo() {};
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setEventMetaInfo(o);
        InvocationAssert invocationAssert = new InvocationAssert();
        converterProperties.setTagWorkerFactory(new AssertMetaInfoTagWorkerFactory(invocationAssert));

        Document document = HtmlConverter.convertToDocument("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "\n"
                        + "<body>\n"
                        + "<div>\n"
                        + "The content of the div\n"
                        + "</div>\n"
                        + "</body>\n"
                        + "\n"
                        + "</html>\n",
                new PdfDocument(new PdfWriter(new ByteArrayOutputStream())),
                converterProperties
        );

        document.close();
        Assert.assertTrue(invocationAssert.isInvoked());
    }

    private static class AssertMetaInfoTagWorkerFactory extends DefaultTagWorkerFactory {
        private final InvocationAssert invocationAssert;

        public AssertMetaInfoTagWorkerFactory(InvocationAssert invocationAssert) {
            this.invocationAssert = invocationAssert;
        }

        @Override
        public ITagWorker getCustomTagWorker(IElementNode tag, ProcessorContext context) {
            if (TagConstants.DIV.equals(tag.name())) {
                return new AssertMetaInfoDivTagWorker(tag, context, invocationAssert);
            }
            return super.getCustomTagWorker(tag, context);
        }
    }

    private static class AssertMetaInfoDivTagWorker extends DivTagWorker {
        private final InvocationAssert invocationAssert;

        public AssertMetaInfoDivTagWorker(IElementNode element, ProcessorContext context, InvocationAssert invocationAssert) {
            super(element, context);
            this.invocationAssert = invocationAssert;
        }

        @Override
        public IPropertyContainer getElementResult() {
            Div result = (Div) super.getElementResult();
            result.setNextRenderer(new AssertMetaInfoDivTagRenderer(result, invocationAssert));
            return result;
        }
    }

    private static class AssertMetaInfoDivTagRenderer extends DivRenderer {
        private final InvocationAssert invocationAssert;

        public AssertMetaInfoDivTagRenderer(Div modelElement, InvocationAssert invocationAssert) {
            super(modelElement);
            this.invocationAssert = invocationAssert;
        }

        @Override
        public LayoutResult layout(LayoutContext layoutContext) {
            Assert.assertNotNull(this.<MetaInfoContainer>getProperty(Property.META_INFO));
            invocationAssert.setInvoked(true);
            return super.layout(layoutContext);
        }

        @Override
        public IRenderer getNextRenderer() {
            return new AssertMetaInfoDivTagRenderer((Div) modelElement, invocationAssert);
        }
    }

    private static class InvocationAssert {
        private boolean invoked;

        public void setInvoked(boolean invoked) {
            this.invoked = invoked;
        }

        public boolean isInvoked() {
            return invoked;
        }
    }
}
