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
package com.itextpdf.html2pdf.attach.impl.tags;

import com.itextpdf.html2pdf.attach.ITagWorker;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.attach.impl.layout.RunningElementContainer;
import com.itextpdf.html2pdf.attach.impl.layout.RunningElement;
import com.itextpdf.html2pdf.css.CssConstants;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.styledxmlparser.node.IElementNode;

/**
 * TagWorker class for the running elements taken out of the normal flow.
 */
public class RunningElementTagWorker implements ITagWorker, IDisplayAware {
    private RunningElement runningElement;

    public RunningElementTagWorker(RunningElementContainer runningElementContainer) {
        runningElement = new RunningElement(runningElementContainer);
    }

    @Override
    public void processEnd(IElementNode element, ProcessorContext context) {

    }

    @Override
    public boolean processContent(String content, ProcessorContext context) {
        return false;
    }

    @Override
    public boolean processTagChild(ITagWorker childTagWorker, ProcessorContext context) {
        return false;
    }

    @Override
    public IPropertyContainer getElementResult() {
        return runningElement;
    }

    @Override
    public String getDisplay() {
        return CssConstants.INLINE_BLOCK;
    }
}
