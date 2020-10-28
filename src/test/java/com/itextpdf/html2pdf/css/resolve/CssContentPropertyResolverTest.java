/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2020 iText Group NV
    Authors: iText Software.

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
package com.itextpdf.html2pdf.css.resolve;

import com.itextpdf.html2pdf.LogMessageConstant;
import com.itextpdf.html2pdf.css.CssConstants;
import com.itextpdf.html2pdf.css.resolve.func.counter.PageTargetCountElementNode;
import com.itextpdf.styledxmlparser.node.INode;
import com.itextpdf.test.ExtendedITextTest;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;
import com.itextpdf.test.annotations.type.UnitTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Category(UnitTest.class)
public class CssContentPropertyResolverTest extends ExtendedITextTest {

    @Test
    public void resolveContentTargetCounterEnabledTest() {
        Map<String, String> styles = new HashMap<>();
        styles.put(CssConstants.CONTENT, "target-counter(url('#some_target'), page)");
        CssContext context = new CssContext();
        context.setTargetCounterEnabled(true);
        List<INode> result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertTrue(result.get(0) instanceof PageTargetCountElementNode);
        Assert.assertEquals("#some_target", ((PageTargetCountElementNode) result.get(0)).getTarget());
    }

    @Test
    public void resolveContentTargetCounterNotPageTest() {
        Map<String, String> styles = new HashMap<>();
        styles.put(CssConstants.CONTENT, "target-counter(url('#some_target'), some_counter)");
        CssContext context = new CssContext();
        context.setTargetCounterEnabled(true);
        List<INode> result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = LogMessageConstant.CONTENT_PROPERTY_INVALID, count = 2))
    public void resolveContentTargetCountersDisabledTest() {
        Map<String, String> styles = new HashMap<>();
        styles.put(CssConstants.CONTENT, "target-counter(url('#some_target'), some_counter)");
        CssContext context = new CssContext();
        context.setTargetCounterEnabled(false);
        List<INode> result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNull(result);

        styles.put(CssConstants.CONTENT, "target-counter(url('#some_target'), some_counter, 'a')");
        result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNull(result);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = LogMessageConstant.CONTENT_PROPERTY_INVALID, count = 4))
    public void resolveContentInvalidParamsTest() {
        Map<String, String> styles = new HashMap<>();
        styles.put(CssConstants.CONTENT, "target-counter(url('#some_target'))");
        CssContext context = new CssContext();
        context.setTargetCounterEnabled(true);
        List<INode> result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNull(result);

        styles.put(CssConstants.CONTENT, "target-counters(url('#some_target'), some_counter)");
        result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNull(result);

        styles.put(CssConstants.CONTENT, "counter()");
        result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNull(result);

        styles.put(CssConstants.CONTENT, "counters(some_counter)");
        result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNull(result);
    }

    @Test
    @LogMessages(messages = @LogMessage(messageTemplate = LogMessageConstant.CONTENT_PROPERTY_INVALID, count = 2))
    public void resolveContentPagesTargetCountersTest() {
        Map<String, String> styles = new HashMap<>();
        styles.put(CssConstants.CONTENT, "target-counter(url('#some_target'), pages)");
        CssContext context = new CssContext();
        context.setTargetCounterEnabled(true);
        List<INode> result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNull(result);

        styles.put(CssConstants.CONTENT, "target-counters(url('#some_target'), pages, '.')");
        result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNull(result);
    }

    @Test
    public void resolveContentCounterNotPageTest() {
        Map<String, String> styles = new HashMap<>();
        styles.put(CssConstants.CONTENT, "counter(some_counter)");
        CssContext context = new CssContext();
        context.setTargetCounterEnabled(true);
        List<INode> result = CssContentPropertyResolver.resolveContent(styles, null, context);
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }
}
