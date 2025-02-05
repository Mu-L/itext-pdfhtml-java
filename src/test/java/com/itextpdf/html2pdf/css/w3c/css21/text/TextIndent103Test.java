/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2025 Apryse Group NV
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
package com.itextpdf.html2pdf.css.w3c.css21.text;

import com.itextpdf.html2pdf.css.w3c.W3CCssTest;
import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.test.annotations.LogMessage;
import com.itextpdf.test.annotations.LogMessages;

@LogMessages(messages = {@LogMessage(messageTemplate = Html2PdfLogMessageConstant.CSS_PROPERTY_IN_PERCENTS_NOT_SUPPORTED),
        @LogMessage(messageTemplate = Html2PdfLogMessageConstant.MARGIN_VALUE_IN_PERCENT_NOT_SUPPORTED)})
public class TextIndent103Test extends W3CCssTest {
    // TODO DEVSIX-1101, DEVSIX-1989: margins and text-indent in percents not supported
    // TODO DEVSIX-1880: negative margins are poorly supported in some cases
    @Override
    protected String getHtmlFileName() {
        return "text-indent-103.xht";
    }
}
