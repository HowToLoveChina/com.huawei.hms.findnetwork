package com.huawei.hicloud.messagecenter.richmessage;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes6.dex */
public class TextItem extends BaseItem {
    private static final String ALIGN = "align";
    public static final String CENTER = "center";
    private static final String COLOR = "color";

    /* renamed from: DP */
    public static final String f22620DP = "dp";
    private static final String FONT_SIZE = "font_size";
    private static final String ITALIC = "italic";
    private static final float ITALIC_DEFALT_VALUE = -0.25f;
    private static final String LINE_SPACE_DP = "line_space_dp";
    private static final String LINE_SPACE_MULTIPLE = "line_space_multiple";
    public static final String MARGIN_BOTTOM = "margin_bottom";
    public static final String MARGIN_LEFT = "margin_left";
    public static final String MARGIN_RIGHT = "margin_right";
    public static final String MARGIN_TOP = "margin_top";
    public static final String RIGHT = "right";

    /* renamed from: SP */
    public static final String f22621SP = "sp";
    private static final String STRONG = "strong";
    private static final String TAG = "TextItem";
    public static final String TEXT_ITEM = "text_item";
    public static final String TEXT_KEY = "text_key";
    public static final String TEXT_VALUE = "text_value";
    private static final String TRUE = "true";
    private static final String UNDERLINE = "underline";
    private static final String WIDTH = "width";
    private String align;
    private String color;
    private String content;
    private String fontSize;
    private boolean isBold = false;
    private boolean isItalic = false;
    private boolean isUnderline = false;
    private String lineSpaceExtra;
    private String lineSpaceMultiple;
    private List<TextFormat> textFormatList;
    private String width;

    private boolean isContinue(String str) {
        return (TEXT_ITEM.equals(str) || TEXT_KEY.equals(str) || TEXT_VALUE.equals(str)) ? false : true;
    }

    private void setContent(TextView textView) {
        List<TextFormat> list = this.textFormatList;
        if (list == null || list.size() == 0) {
            textView.setText(this.content);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.content);
        Iterator<TextFormat> it = this.textFormatList.iterator();
        while (it.hasNext()) {
            spannableStringBuilder = it.next().format(textView, spannableStringBuilder, this.content);
        }
        textView.setText(spannableStringBuilder);
    }

    private void setStyleAttribute(XmlPullParser xmlPullParser, int i10) {
        if (FONT_SIZE.equals(xmlPullParser.getAttributeName(i10))) {
            this.fontSize = xmlPullParser.getAttributeValue(i10);
            return;
        }
        if ("color".equals(xmlPullParser.getAttributeName(i10))) {
            this.color = xmlPullParser.getAttributeValue(i10);
            return;
        }
        if (ITALIC.equals(xmlPullParser.getAttributeName(i10))) {
            if ("true".equals(xmlPullParser.getAttributeValue(i10))) {
                this.isItalic = true;
            }
        } else if (STRONG.equals(xmlPullParser.getAttributeName(i10))) {
            if ("true".equals(xmlPullParser.getAttributeValue(i10))) {
                this.isBold = true;
            }
        } else if (UNDERLINE.equals(xmlPullParser.getAttributeName(i10)) && "true".equals(xmlPullParser.getAttributeValue(i10))) {
            this.isUnderline = true;
        }
    }

    @TargetApi(17)
    private void setTextAlignment(TextView textView) {
        textView.setTextAlignment(CENTER.equals(this.align) ? 4 : RIGHT.equals(this.align) ? 3 : 2);
    }

    private void setTextColor(TextView textView) {
        if (TextUtils.isEmpty(this.color)) {
            return;
        }
        try {
            textView.setTextColor(Color.parseColor(this.color));
        } catch (IllegalArgumentException unused) {
            NotifyLogger.m29914e(TAG, "setTextColor:IllegalArgumentException, color:" + this.color);
        }
    }

    private void setTextFontSize(TextView textView) {
        if (TextUtils.isEmpty(this.fontSize)) {
            return;
        }
        try {
            if (this.fontSize.endsWith(f22621SP)) {
                textView.setTextSize(2, Integer.parseInt(this.fontSize.split(f22621SP)[0]));
            } else if (this.fontSize.endsWith(f22620DP)) {
                textView.setTextSize(1, Integer.parseInt(this.fontSize.split(f22620DP)[0]));
            }
        } catch (NumberFormatException unused) {
            NotifyLogger.m29914e(TAG, "setTextFontSize:NumberFormatException, fontSize:" + this.fontSize);
        }
    }

    private void setTextLineSpace(TextView textView) {
        try {
            textView.setLineSpacing((TextUtils.isEmpty(this.lineSpaceExtra) || !this.lineSpaceExtra.endsWith(f22620DP)) ? 0.0f : dip2px(textView.getContext(), Float.valueOf(this.lineSpaceExtra.split(f22620DP)[0]).floatValue()), !TextUtils.isEmpty(this.lineSpaceMultiple) ? Float.valueOf(this.lineSpaceMultiple).floatValue() : 1.0f);
        } catch (NumberFormatException unused) {
            NotifyLogger.m29914e(TAG, "setTextLineSpace:NumberFormatException, lineSpaceExtra:" + this.lineSpaceExtra + ",lineSpaceMultiple:" + this.lineSpaceMultiple);
        }
    }

    private void setTextStyle(TextView textView) {
        TextPaint paint = textView.getPaint();
        if (this.isBold) {
            paint.setFakeBoldText(true);
        }
        if (this.isItalic) {
            paint.setTextSkewX(ITALIC_DEFALT_VALUE);
        }
        if (this.isUnderline) {
            paint.setUnderlineText(true);
        }
    }

    private void setWidth(Context context, TextView textView) {
        if (TextUtils.isEmpty(this.width)) {
            return;
        }
        try {
            textView.setWidth(dip2px(context, Float.valueOf(this.width.split(f22620DP)[0]).floatValue()));
        } catch (NumberFormatException unused) {
            NotifyLogger.m29914e(TAG, "setWidth:NumberFormatException.width:" + this.width);
        }
    }

    @Override // com.huawei.hicloud.messagecenter.richmessage.BaseItem
    public View onCreateView(Context context, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(this.content)) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setSingleLine(false);
        setWidth(context, textView);
        setTextAlignment(textView);
        setTextLineSpace(textView);
        setTextColor(textView);
        setTextFontSize(textView);
        setTextStyle(textView);
        setContent(textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setMargin(context, layoutParams);
        viewGroup.addView(textView, layoutParams);
        return textView;
    }

    @Override // com.huawei.hicloud.messagecenter.richmessage.BaseItem
    public void parse(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser != null) {
            setAttributes(xmlPullParser);
            xmlPullParser.next();
            StringBuilder sb2 = new StringBuilder();
            int eventType = xmlPullParser.getEventType();
            boolean zIsContinue = true;
            while (zIsContinue) {
                String name = xmlPullParser.getName();
                if (eventType == 1) {
                    zIsContinue = false;
                } else if (eventType != 2) {
                    if (eventType != 3) {
                        if (eventType == 4) {
                            sb2.append(xmlPullParser.getText());
                        }
                    } else if (!TextUtils.isEmpty(name)) {
                        zIsContinue = isContinue(name);
                    }
                } else if (TextFormat.TEXT_FORMAT.equals(name)) {
                    TextFormat textFormat = new TextFormat();
                    textFormat.parse(xmlPullParser);
                    textFormat.setStartIndex(sb2.toString().length());
                    sb2.append(textFormat.getText());
                    if (this.textFormatList == null) {
                        this.textFormatList = new ArrayList();
                    }
                    this.textFormatList.add(textFormat);
                }
                if (zIsContinue) {
                    eventType = xmlPullParser.next();
                }
            }
            this.content = sb2.toString();
        }
    }

    @Override // com.huawei.hicloud.messagecenter.richmessage.BaseItem
    public void setAttributes(XmlPullParser xmlPullParser) {
        for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
            if ("width".equals(xmlPullParser.getAttributeName(i10))) {
                this.width = xmlPullParser.getAttributeValue(i10);
            } else if (MARGIN_LEFT.equals(xmlPullParser.getAttributeName(i10))) {
                this.marginLeft = xmlPullParser.getAttributeValue(i10);
            } else if (MARGIN_TOP.equals(xmlPullParser.getAttributeName(i10))) {
                this.marginTop = xmlPullParser.getAttributeValue(i10);
            } else if (MARGIN_RIGHT.equals(xmlPullParser.getAttributeName(i10))) {
                this.marginRight = xmlPullParser.getAttributeValue(i10);
            } else if (MARGIN_BOTTOM.equals(xmlPullParser.getAttributeName(i10))) {
                this.marginBottom = xmlPullParser.getAttributeValue(i10);
            } else if (ALIGN.equals(xmlPullParser.getAttributeName(i10))) {
                this.align = xmlPullParser.getAttributeValue(i10);
            } else if (LINE_SPACE_DP.equals(xmlPullParser.getAttributeName(i10))) {
                this.lineSpaceExtra = xmlPullParser.getAttributeValue(i10);
            } else if (LINE_SPACE_MULTIPLE.equals(xmlPullParser.getAttributeName(i10))) {
                this.lineSpaceMultiple = xmlPullParser.getAttributeValue(i10);
            } else {
                setStyleAttribute(xmlPullParser, i10);
            }
        }
    }
}
