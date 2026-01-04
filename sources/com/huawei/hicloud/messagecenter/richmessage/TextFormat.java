package com.huawei.hicloud.messagecenter.richmessage;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import com.huawei.hicloud.notification.log.NotifyLogger;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes6.dex */
public class TextFormat {
    private static final String COLOR = "color";
    private static final String FONT_SIZE = "font_size";
    private static final String ITALIC = "italic";
    private static final String STRONG = "strong";
    private static final String TAG = "TextFormat";
    public static final String TEXT_FORMAT = "text_format";
    private static final String TRUE = "true";
    private static final String UNDERLINE = "underline";
    private String color;
    private String fontSize;
    private boolean isBold = false;
    private boolean isItalic = false;
    private boolean isUnderline = false;
    private int startIndex;
    private String text;

    private void setAttributes(XmlPullParser xmlPullParser) {
        for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
            if ("color".equals(xmlPullParser.getAttributeName(i10))) {
                this.color = xmlPullParser.getAttributeValue(i10);
            } else if (FONT_SIZE.equals(xmlPullParser.getAttributeName(i10))) {
                this.fontSize = xmlPullParser.getAttributeValue(i10);
            } else if (STRONG.equals(xmlPullParser.getAttributeName(i10))) {
                if ("true".equals(xmlPullParser.getAttributeValue(i10))) {
                    this.isBold = true;
                }
            } else if (ITALIC.equals(xmlPullParser.getAttributeName(i10))) {
                if ("true".equals(xmlPullParser.getAttributeValue(i10))) {
                    this.isItalic = true;
                }
            } else if (UNDERLINE.equals(xmlPullParser.getAttributeName(i10)) && "true".equals(xmlPullParser.getAttributeValue(i10))) {
                this.isUnderline = true;
            }
        }
    }

    private int sp2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public SpannableStringBuilder format(TextView textView, SpannableStringBuilder spannableStringBuilder, String str) {
        if (!TextUtils.isEmpty(str) && str.length() > this.startIndex && !TextUtils.isEmpty(this.text)) {
            int length = this.startIndex + this.text.length();
            if (this.isBold) {
                spannableStringBuilder.setSpan(new StyleSpan(1), this.startIndex, length, 33);
            }
            if (this.isItalic) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.startIndex, length, 33);
            }
            if (this.isUnderline) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.startIndex, length, 33);
            }
            if (!TextUtils.isEmpty(this.fontSize) && this.fontSize.endsWith(TextItem.f22621SP)) {
                try {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(sp2px(textView.getContext(), Float.valueOf(this.fontSize.split(TextItem.f22621SP)[0]).floatValue())), this.startIndex, length, 33);
                } catch (NumberFormatException unused) {
                    NotifyLogger.m29914e(TAG, "format:NumberFormatException, fontSize:" + this.fontSize);
                }
            }
            if (!TextUtils.isEmpty(this.color)) {
                try {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(this.color)), this.startIndex, length, 33);
                } catch (IllegalArgumentException unused2) {
                    NotifyLogger.m29914e(TAG, "format:IllegalArgumentException, color:" + this.color);
                }
            }
        }
        return spannableStringBuilder;
    }

    public String getText() {
        return this.text;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parse(org.xmlpull.v1.XmlPullParser r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r6 = this;
            if (r7 == 0) goto L3b
            r6.setAttributes(r7)
            r7.next()
            int r0 = r7.getEventType()
            r1 = 1
            r2 = r1
        Le:
            if (r2 == 0) goto L3b
            java.lang.String r3 = r7.getName()
            r4 = 0
            if (r0 == r1) goto L33
            r5 = 3
            if (r0 == r5) goto L25
            r3 = 4
            if (r0 == r3) goto L1e
            goto L34
        L1e:
            java.lang.String r3 = r7.getText()
            r6.text = r3
            goto L34
        L25:
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L34
            java.lang.String r5 = "text_format"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L34
        L33:
            r2 = r4
        L34:
            if (r2 == 0) goto Le
            int r0 = r7.next()
            goto Le
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.messagecenter.richmessage.TextFormat.parse(org.xmlpull.v1.XmlPullParser):void");
    }

    public void setStartIndex(int i10) {
        this.startIndex = i10;
    }
}
