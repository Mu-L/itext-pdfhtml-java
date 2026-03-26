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
package com.itextpdf.html2pdf;

import com.itextpdf.commons.actions.NamespaceConstant;
import com.itextpdf.commons.actions.contexts.IMetaInfo;
import com.itextpdf.html2pdf.attach.util.AlternateDescriptionResolver;
import com.itextpdf.test.ExtendedITextTest;

import java.util.Map;
import java.util.function.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

@Tag("UnitTest")
public class ConverterPropertiesTest extends ExtendedITextTest {

    @Test
    public void getDefaultMetaInfoTest() {
        ConverterProperties properties = new ConverterProperties();

        IMetaInfo metaInfo = properties.getEventMetaInfo();

        Assertions.assertTrue(metaInfo.getClass().getName().startsWith(NamespaceConstant.PDF_HTML + "."));
    }

    @Test
    public void setEventMetaInfoAndGetTest() {
        ConverterProperties properties = new ConverterProperties();
        TestMetaInfo testMetaInfo = new TestMetaInfo();

        properties.setEventMetaInfo(testMetaInfo);
        IMetaInfo metaInfo = properties.getEventMetaInfo();

        Assertions.assertSame(testMetaInfo, metaInfo);
    }

    @Test
    public void checkDefaultsTest() {
        ConverterProperties properties = new ConverterProperties();

        Assertions.assertTrue(properties.isImmediateFlush());
        Assertions.assertFalse(properties.isCreateAcroForm());
        Assertions.assertEquals(10, properties.getLimitOfLayouts());

        properties.setImmediateFlush(false);
        properties.setCreateAcroForm(true);
        properties.setLimitOfLayouts(20);
        ConverterProperties propertiesCopied = new ConverterProperties(properties);

        Assertions.assertFalse(propertiesCopied.isImmediateFlush());
        Assertions.assertTrue(propertiesCopied.isCreateAcroForm());
        Assertions.assertEquals(20, propertiesCopied.getLimitOfLayouts());
    }

    @Test
    public void converterPropsSetDependencyWithNullInstance() {
        ConverterProperties converterProperties = new ConverterProperties();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            converterProperties.registerDependency(AlternateDescriptionResolver.class, null);
        });
    }

    @Test
    public void converterPropsSetDependencyWithNullType() {
        ConverterProperties converterProperties = new ConverterProperties();
        Supplier<Object> dummySupplier = () -> new Object();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            converterProperties.registerDependency(null, dummySupplier);
        });
    }

    @Test
    public void getDependenciesTest() {
        ConverterProperties converterProperties = new ConverterProperties();
        Object dummyObject = new Object();
        Supplier<Object> dummySupplier = () -> dummyObject;
        converterProperties.registerDependency(AlternateDescriptionResolver.class, dummySupplier);

        Map<Class<?>, Object> dependencies = converterProperties.getDependencies();
        Assertions.assertEquals(1, dependencies.size());
        Assertions.assertSame(dummyObject, dependencies.get(AlternateDescriptionResolver.class));
    }

    private static class TestMetaInfo implements IMetaInfo {
    }
}
