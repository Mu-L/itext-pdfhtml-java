/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2022 iText Group NV
    Authors: Bruno Lowagie, Paulo Soares, et al.
    
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License version 3
    as published by the Free Software Foundation with the addition of the
    following permission added to Section 15 as permitted in Section 7(a):
    FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
    ITEXT GROUP. ITEXT GROUP DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
    OF THIRD PARTY RIGHTS
    
    This program is distributed in the hope that it will be useful, but
    WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
    or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU Affero General Public License for more details.
    You should have received a copy of the GNU Affero General Public License
    along with this program; if not, see http://www.gnu.org/licenses or write to
    the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
    Boston, MA, 02110-1301 USA, or download the license from the following URL:
    http://itextpdf.com/terms-of-use/
    
    The interactive user interfaces in modified source and object code versions
    of this program must display Appropriate Legal Notices, as required under
    Section 5 of the GNU Affero General Public License.
    
    In accordance with Section 7(b) of the GNU Affero General Public License,
    a covered work must retain the producer line in every PDF that is created
    or manipulated using iText.
    
    You can be released from the requirements of the license by purchasing
    a commercial license. Buying such a license is mandatory as soon as you
    develop commercial activities involving the iText software without
    disclosing the source code of your own applications.
    These activities include: offering paid services to customers as an ASP,
    serving PDFs on the fly in a web application, shipping iText with a closed
    source product.
    
    For more information, please contact iText Software Corp. at this
    address: sales@itextpdf.com
 */
package com.itextpdf.html2pdf.css.apply.util;

import com.itextpdf.html2pdf.logs.Html2PdfLogMessageConstant;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.css.CssConstants;
import com.itextpdf.commons.utils.MessageFormatUtil;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.colors.gradients.StrategyBasedLinearGradientBuilder;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.kernel.pdf.xobject.PdfXObject;
import com.itextpdf.layout.IPropertyContainer;
import com.itextpdf.layout.properties.Background;
import com.itextpdf.layout.properties.BackgroundImage;
import com.itextpdf.layout.properties.BackgroundPosition;
import com.itextpdf.layout.properties.BackgroundBox;
import com.itextpdf.layout.properties.BackgroundRepeat;
import com.itextpdf.layout.properties.BlendMode;
import com.itextpdf.layout.properties.BackgroundRepeat.BackgroundRepeatValue;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.TransparentColor;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.styledxmlparser.css.util.CssBackgroundUtils;
import com.itextpdf.styledxmlparser.css.util.CssGradientUtil;
import com.itextpdf.styledxmlparser.css.util.CssDimensionParsingUtils;
import com.itextpdf.styledxmlparser.css.util.CssUtils;
import com.itextpdf.styledxmlparser.exceptions.StyledXMLParserException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utilities class to apply backgrounds.
 */
public final class BackgroundApplierUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(BackgroundApplierUtil.class);

    /**
     * Creates a new {@link BackgroundApplierUtil} instance.
     */
    private BackgroundApplierUtil() {
    }

    /**
     * Applies background to an element.
     *
     * @param cssProps the CSS properties
     * @param context  the processor context
     * @param element  the element
     */
    public static void applyBackground(Map<String, String> cssProps, ProcessorContext context,
                                       IPropertyContainer element) {
        final String backgroundColorStr = cssProps.get(CssConstants.BACKGROUND_COLOR);
        final String backgroundImagesStr = cssProps.get(CssConstants.BACKGROUND_IMAGE);
        final String backgroundRepeatStr = cssProps.get(CssConstants.BACKGROUND_REPEAT);
        final String backgroundSizeStr = cssProps.get(CssConstants.BACKGROUND_SIZE);
        final String backgroundPositionXStr = cssProps.get(CssConstants.BACKGROUND_POSITION_X);
        final String backgroundPositionYStr = cssProps.get(CssConstants.BACKGROUND_POSITION_Y);
        final String backgroundBlendModeStr = cssProps.get(CssConstants.BACKGROUND_BLEND_MODE);
        final String backgroundClipStr = cssProps.get(CssConstants.BACKGROUND_CLIP);
        final String backgroundOriginStr = cssProps.get(CssConstants.BACKGROUND_ORIGIN);

        final List<String> backgroundImagesArray = CssUtils.splitStringWithComma(backgroundImagesStr);
        final List<String> backgroundRepeatArray = CssUtils.splitStringWithComma(backgroundRepeatStr);
        final List<List<String>> backgroundSizeArray = backgroundSizeStr == null ? null
                : CssUtils.extractShorthandProperties(backgroundSizeStr);
        final List<String> backgroundPositionXArray = CssUtils.splitStringWithComma(backgroundPositionXStr);
        final List<String> backgroundPositionYArray = CssUtils.splitStringWithComma(backgroundPositionYStr);
        final List<String> backgroundBlendModeArray = CssUtils.splitStringWithComma(backgroundBlendModeStr);

        final String fontSize = cssProps.get(CssConstants.FONT_SIZE);
        final float em = fontSize == null ? 0 : CssDimensionParsingUtils.parseAbsoluteLength(fontSize);
        final float rem = context.getCssContext().getRootFontSize();

        final List<String> backgroundClipArray = CssUtils.splitStringWithComma(backgroundClipStr);
        final List<String> backgroundOriginArray = CssUtils.splitStringWithComma(backgroundOriginStr);

        final BackgroundBox clipForColor = getBackgroundBoxProperty(backgroundClipArray,
                backgroundImagesArray.isEmpty() ? 0 : (backgroundImagesArray.size() - 1), BackgroundBox.BORDER_BOX);
        applyBackgroundColor(backgroundColorStr, element, clipForColor);

        final List<BackgroundImage> backgroundImagesList = getBackgroundImagesList(backgroundImagesArray, context, em,
                rem, backgroundPositionXArray, backgroundPositionYArray, backgroundSizeArray, backgroundBlendModeArray,
                backgroundRepeatArray, backgroundClipArray, backgroundOriginArray);
        if (!backgroundImagesList.isEmpty()) {
            element.setProperty(Property.BACKGROUND_IMAGE, backgroundImagesList);
        }
    }

    private static List<BackgroundImage> getBackgroundImagesList(List<String> backgroundImagesArray,
            ProcessorContext context, float em, float rem,
            List<String> backgroundPositionXArray, List<String> backgroundPositionYArray,
            List<List<String>> backgroundSizeArray, List<String> backgroundBlendModeArray,
            List<String> backgroundRepeatArray, List<String> backgroundClipArray,
            List<String> backgroundOriginArray) {
        final List<BackgroundImage> backgroundImagesList = new ArrayList<>();

        for (int i = 0; i < backgroundImagesArray.size(); ++i) {
            final String backgroundImage = backgroundImagesArray.get(i);
            if (backgroundImage == null || CssConstants.NONE.equals(backgroundImage)) {
                continue;
            }
            final BackgroundPosition position =
                    applyBackgroundPosition(backgroundPositionXArray, backgroundPositionYArray, i, em, rem);
            final BlendMode blendMode = applyBackgroundBlendMode(backgroundBlendModeArray, i);
            boolean imageApplied = false;
            final BackgroundRepeat repeat = applyBackgroundRepeat(backgroundRepeatArray, i);

            final BackgroundBox clip = getBackgroundBoxProperty(backgroundClipArray, i,
                    BackgroundBox.BORDER_BOX);
            final BackgroundBox origin = getBackgroundBoxProperty(backgroundOriginArray, i,
                    BackgroundBox.PADDING_BOX);

            if (CssGradientUtil.isCssLinearGradientValue(backgroundImage)) {
                imageApplied = applyLinearGradient(backgroundImage, backgroundImagesList, blendMode, position, em, rem,
                        repeat, clip, origin);
            } else {
                final PdfXObject image = context.getResourceResolver().retrieveImage(
                        CssUtils.extractUrl(backgroundImage));
                imageApplied = applyBackgroundImage(image, backgroundImagesList, repeat, blendMode, position, clip,
                        origin);
            }
            if (imageApplied) {
                applyBackgroundSize(backgroundSizeArray, em, rem, i,
                        backgroundImagesList.get(backgroundImagesList.size() - 1));
            }
        }
        return backgroundImagesList;
    }

    private static BackgroundBox getBackgroundBoxProperty(final List<String> propertyArray,
            final int iteration, BackgroundBox defaultValue) {
        final int index = getBackgroundSidePropertyIndex(propertyArray.size(), iteration);
        if (index == -1) {
            return defaultValue;
        } else {
            return getBackgroundBoxPropertyByString(propertyArray.get(index));
        }
    }

    private static BackgroundBox getBackgroundBoxPropertyByString(String box) {
        if (CommonCssConstants.PADDING_BOX.equals(box)) {
            return BackgroundBox.PADDING_BOX;
        } else if (CommonCssConstants.CONTENT_BOX.equals(box)) {
            return BackgroundBox.CONTENT_BOX;
        } else {
            return BackgroundBox.BORDER_BOX;
        }
    }

    private static BlendMode applyBackgroundBlendMode(final List<String> backgroundBlendModeArray,
                                                      final int iteration) {
        String cssValue = null;
        if (backgroundBlendModeArray != null && !backgroundBlendModeArray.isEmpty()) {
            int actualValueIteration = Math.min(iteration, backgroundBlendModeArray.size() - 1);
            cssValue = backgroundBlendModeArray.get(actualValueIteration);
        }

        return CssUtils.parseBlendMode(cssValue);
    }

    private static BackgroundPosition applyBackgroundPosition(List<String> backgroundPositionXArray,
                                                              List<String> backgroundPositionYArray,
                                                              int i, float em, float rem) {
        final BackgroundPosition position = new BackgroundPosition();
        final int indexX = getBackgroundSidePropertyIndex(backgroundPositionXArray.size(), i);
        if (indexX != -1) {
            applyBackgroundPositionX(position, backgroundPositionXArray.get(indexX), em, rem);
        }
        final int indexY = getBackgroundSidePropertyIndex(backgroundPositionYArray.size(), i);
        if (indexY != -1) {
            applyBackgroundPositionY(position, backgroundPositionYArray.get(indexY), em, rem);
        }
        return position;
    }

    private static void applyBackgroundPositionX(BackgroundPosition position, String xPosition, float em, float rem) {
        for (final String value : xPosition.split(" ")) {
            switch (value) {
                case CommonCssConstants.LEFT:
                    position.setPositionX(BackgroundPosition.PositionX.LEFT);
                    break;
                case CommonCssConstants.RIGHT:
                    position.setPositionX(BackgroundPosition.PositionX.RIGHT);
                    break;
                case CommonCssConstants.CENTER:
                    position.setPositionX(BackgroundPosition.PositionX.CENTER);
                    break;
                default:
                    final UnitValue unitValue = CssDimensionParsingUtils.parseLengthValueToPt(value, em, rem);
                    if (unitValue != null) {
                        position.setXShift(unitValue);
                    }
            }
        }
    }

    private static void applyBackgroundPositionY(BackgroundPosition position, String yPosition, float em, float rem) {
        for (final String value : yPosition.split(" ")) {
            switch (value) {
                case CommonCssConstants.TOP:
                    position.setPositionY(BackgroundPosition.PositionY.TOP);
                    break;
                case CommonCssConstants.BOTTOM:
                    position.setPositionY(BackgroundPosition.PositionY.BOTTOM);
                    break;
                case CommonCssConstants.CENTER:
                    position.setPositionY(BackgroundPosition.PositionY.CENTER);
                    break;
                default:
                    final UnitValue unitValue = CssDimensionParsingUtils.parseLengthValueToPt(value, em, rem);
                    if (unitValue != null) {
                        position.setYShift(unitValue);
                    }
            }
        }
    }

    private static BackgroundRepeat applyBackgroundRepeat(List<String> backgroundRepeatArray, int iteration) {
        final int index = getBackgroundSidePropertyIndex(backgroundRepeatArray.size(), iteration);
        if (index != -1) {
            String[] repeatProps = backgroundRepeatArray.get(index).split(" ");
            if (repeatProps.length == 1) {
                if (CommonCssConstants.REPEAT_X.equals(repeatProps[0])) {
                    return new BackgroundRepeat(BackgroundRepeatValue.REPEAT, BackgroundRepeatValue.NO_REPEAT);
                } else if (CommonCssConstants.REPEAT_Y.equals(repeatProps[0])) {
                    return new BackgroundRepeat(BackgroundRepeatValue.NO_REPEAT, BackgroundRepeatValue.REPEAT);
                } else {
                    BackgroundRepeatValue value = CssBackgroundUtils.parseBackgroundRepeat(repeatProps[0]);
                    return new BackgroundRepeat(value);
                }
            } else if (repeatProps.length == 2) {
                return new BackgroundRepeat(CssBackgroundUtils.parseBackgroundRepeat(repeatProps[0]),
                        CssBackgroundUtils.parseBackgroundRepeat(repeatProps[1]));
            }
        }
        // Valid cases are processed by the block above, and in invalid
        // situations, the REPEAT property on both axes is used by default
        return new BackgroundRepeat();
    }

    private static int getBackgroundSidePropertyIndex(final int propertiesNumber, final int iteration) {
        if (propertiesNumber > 0) {
            return iteration % propertiesNumber;
        } else {
            return -1;
        }
    }

    private static void applyBackgroundColor(final String backgroundColorStr, final IPropertyContainer element,
            BackgroundBox clip) {
        if (backgroundColorStr != null && !CssConstants.TRANSPARENT.equals(backgroundColorStr)) {
            TransparentColor color = CssDimensionParsingUtils.parseColor(backgroundColorStr);
            final Background backgroundColor = new Background(color.getColor(), color.getOpacity(), clip);
            element.setProperty(Property.BACKGROUND, backgroundColor);
        }
    }

    private static boolean applyBackgroundImage(PdfXObject image, List<BackgroundImage> backgroundImagesList,
            BackgroundRepeat repeat, BlendMode backgroundBlendMode, BackgroundPosition position, BackgroundBox clip,
            BackgroundBox origin) {
        if (image == null) {
            return false;
        }
        if (image instanceof PdfImageXObject) {
            backgroundImagesList.add(new HtmlBackgroundImage((PdfImageXObject) image, repeat, position,
                    backgroundBlendMode, clip, origin));
            return true;
        } else if (image instanceof PdfFormXObject) {
            backgroundImagesList.add(new HtmlBackgroundImage((PdfFormXObject) image, repeat, position,
                    backgroundBlendMode, clip, origin));
            return true;
        } else {
            throw new IllegalStateException();
        }
    }

    private static boolean applyLinearGradient(String image, List<BackgroundImage> backgroundImagesList,
            BlendMode blendMode, BackgroundPosition position, float em, float rem, final BackgroundRepeat repeat,
            BackgroundBox clip, BackgroundBox origin) {
        try {
            StrategyBasedLinearGradientBuilder gradientBuilder =
                    CssGradientUtil.parseCssLinearGradient(image, em, rem);
            if (gradientBuilder != null) {
                backgroundImagesList.add(new BackgroundImage.Builder().setLinearGradientBuilder(gradientBuilder)
                        .setBackgroundBlendMode(blendMode).setBackgroundPosition(position).setBackgroundRepeat(repeat)
                        .setBackgroundClip(clip).setBackgroundOrigin(origin).build());
                return true;
            }
        } catch (StyledXMLParserException e) {
            LOGGER.warn(MessageFormatUtil.format(Html2PdfLogMessageConstant.INVALID_GRADIENT_DECLARATION, image));
        }
        return false;
    }

    private static void applyBackgroundSize(List<List<String>> backgroundProperties, float em, float rem,
            int imageIndex, BackgroundImage image) {
        if (backgroundProperties == null || backgroundProperties.isEmpty()) {
            return;
        }
        if (image.getForm() != null && (image.getImageHeight() == 0f || image.getImageWidth() == 0f)) {
            return;
        }
        List<String> backgroundSizeValues = backgroundProperties
                .get(getBackgroundSidePropertyIndex(backgroundProperties.size(), imageIndex));
        if (backgroundSizeValues.size() == 2 && CommonCssConstants.AUTO.equals(backgroundSizeValues.get(1))) {
            backgroundSizeValues.remove(1);
        }
        if (backgroundSizeValues.size() == 1) {
            String widthValue = backgroundSizeValues.get(0);
            applyBackgroundWidth(widthValue, image, em, rem);
        }
        if (backgroundSizeValues.size() == 2) {
            applyBackgroundWidthHeight(backgroundSizeValues, image, em, rem);
        }
    }

    private static void applyBackgroundWidth(final String widthValue, final BackgroundImage image,
            final float em, final float rem) {
        if (CommonCssConstants.BACKGROUND_SIZE_VALUES.contains(widthValue)) {
            if (widthValue.equals(CommonCssConstants.CONTAIN)) {
                image.getBackgroundSize().setBackgroundSizeToContain();
            }
            if (widthValue.equals(CommonCssConstants.COVER)) {
                image.getBackgroundSize().setBackgroundSizeToCover();
            }
            return;
        }
        image.getBackgroundSize().setBackgroundSizeToValues(
                CssDimensionParsingUtils.parseLengthValueToPt(widthValue, em, rem), null);
    }

    private static void applyBackgroundWidthHeight(final List<String> backgroundSizeValues,
            final BackgroundImage image, final float em, final float rem) {
        String widthValue = backgroundSizeValues.get(0);
        if (CommonCssConstants.BACKGROUND_SIZE_VALUES.contains(widthValue)) {
            if (widthValue.equals(CommonCssConstants.AUTO)) {
                UnitValue height = CssDimensionParsingUtils.parseLengthValueToPt(backgroundSizeValues.get(1), em, rem);
                if (height != null) {
                    image.getBackgroundSize().setBackgroundSizeToValues(null, height);
                }
            }
            return;
        }
        image.getBackgroundSize().setBackgroundSizeToValues(
                CssDimensionParsingUtils.parseLengthValueToPt(backgroundSizeValues.get(0), em, rem),
                CssDimensionParsingUtils.parseLengthValueToPt(backgroundSizeValues.get(1), em, rem));
    }

    /**
     * Implementation of the Image class when used in the context of HTML to PDF conversion.
     */
    private static class HtmlBackgroundImage extends BackgroundImage {

        private static final double PX_TO_PT_MULTIPLIER = 0.75;

        /**
         * In iText, we use user unit for the image sizes (and by default
         * one user unit = one point), whereas images are usually measured
         * in pixels.
         */
        private double dimensionMultiplier = 1;

        /**
         * Creates a new {@link HtmlBackgroundImage} instance.
         *
         * @param xObject   background-image property. {@link PdfImageXObject} instance.
         * @param repeat    background-repeat property. {@link BackgroundRepeat} instance.
         * @param position  background-position property. {@link BackgroundPosition} instance.
         * @param blendMode background-blend-mode property. {@link BlendMode} instance.
         * @param clip      background-clip property. {@link BackgroundBox} instance.
         * @param origin    background-origin property. {@link BackgroundBox} instance.
         */
        public HtmlBackgroundImage(PdfImageXObject xObject,
                BackgroundRepeat repeat, BackgroundPosition position, BlendMode blendMode,
                BackgroundBox clip, BackgroundBox origin) {
            super(new BackgroundImage.Builder().setImage(xObject).setBackgroundRepeat(repeat)
                    .setBackgroundPosition(position).setBackgroundBlendMode(blendMode).setBackgroundClip(clip)
                    .setBackgroundOrigin(origin).build());
            dimensionMultiplier = PX_TO_PT_MULTIPLIER;
        }

        /**
         * Creates a new {@link HtmlBackgroundImage} instance.
         *
         * @param xObject   background-image property. {@link PdfFormXObject} instance.
         * @param repeat    background-repeat property. {@link BackgroundRepeat} instance.
         * @param position  background-position property. {@link BackgroundPosition} instance.
         * @param blendMode background-blend-mode property. {@link BlendMode} instance.
         * @param clip background-clip property. {@link BackgroundBox} instance.
         * @param origin background-origin property. {@link BackgroundBox} instance.
         */
        public HtmlBackgroundImage(PdfFormXObject xObject,
                BackgroundRepeat repeat, BackgroundPosition position, BlendMode blendMode,
                BackgroundBox clip, BackgroundBox origin) {
            super(new BackgroundImage.Builder().setImage(xObject).setBackgroundRepeat(repeat)
                    .setBackgroundPosition(position).setBackgroundBlendMode(blendMode).setBackgroundClip(clip)
                    .setBackgroundOrigin(origin).build());
        }

        @Override
        public float getImageWidth() {
            return (float) (image.getWidth() * dimensionMultiplier);
        }

        @Override
        public float getImageHeight() {
            return (float) (image.getHeight() * dimensionMultiplier);
        }
    }
}
