package com.huawei.hicloud.messagecenter.richmessage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes6.dex */
public class TextPair extends BaseItem {
    public static final String TEXT_PAIR = "text_pair";
    private TextItem keyTextItem;
    private TextItem valueTextItem;

    @Override // com.huawei.hicloud.messagecenter.richmessage.BaseItem
    public View onCreateView(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        setMargin(context, layoutParams);
        viewGroup.addView(linearLayout, layoutParams);
        TextItem textItem = this.keyTextItem;
        if (textItem != null) {
            textItem.onCreateView(context, linearLayout);
        }
        TextItem textItem2 = this.valueTextItem;
        if (textItem2 != null) {
            textItem2.onCreateView(context, linearLayout);
        }
        return linearLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    @Override // com.huawei.hicloud.messagecenter.richmessage.BaseItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parse(org.xmlpull.v1.XmlPullParser r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r6 = this;
            if (r7 == 0) goto L5a
            r6.setAttributes(r7)
            r7.next()
            int r0 = r7.getEventType()
            r1 = 1
            r2 = r1
        Le:
            if (r2 == 0) goto L5a
            java.lang.String r3 = r7.getName()
            r4 = 0
            if (r0 == r1) goto L2c
            r5 = 2
            if (r0 == r5) goto L2e
            r5 = 3
            if (r0 == r5) goto L1e
            goto L53
        L1e:
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L53
            java.lang.String r5 = "text_pair"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L53
        L2c:
            r2 = r4
            goto L53
        L2e:
            java.lang.String r4 = "text_key"
            boolean r4 = r4.equals(r3)
            if (r4 == 0) goto L41
            com.huawei.hicloud.messagecenter.richmessage.TextItem r3 = new com.huawei.hicloud.messagecenter.richmessage.TextItem
            r3.<init>()
            r6.keyTextItem = r3
            r3.parse(r7)
            goto L53
        L41:
            java.lang.String r4 = "text_value"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L53
            com.huawei.hicloud.messagecenter.richmessage.TextItem r3 = new com.huawei.hicloud.messagecenter.richmessage.TextItem
            r3.<init>()
            r6.valueTextItem = r3
            r3.parse(r7)
        L53:
            if (r2 == 0) goto Le
            int r0 = r7.next()
            goto Le
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.messagecenter.richmessage.TextPair.parse(org.xmlpull.v1.XmlPullParser):void");
    }

    @Override // com.huawei.hicloud.messagecenter.richmessage.BaseItem
    public void setAttributes(XmlPullParser xmlPullParser) {
        for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
            if (TextItem.MARGIN_LEFT.equals(xmlPullParser.getAttributeName(i10))) {
                this.marginLeft = xmlPullParser.getAttributeValue(i10);
            } else if (TextItem.MARGIN_TOP.equals(xmlPullParser.getAttributeName(i10))) {
                this.marginTop = xmlPullParser.getAttributeValue(i10);
            } else if (TextItem.MARGIN_RIGHT.equals(xmlPullParser.getAttributeName(i10))) {
                this.marginRight = xmlPullParser.getAttributeValue(i10);
            } else if (TextItem.MARGIN_BOTTOM.equals(xmlPullParser.getAttributeName(i10))) {
                this.marginBottom = xmlPullParser.getAttributeValue(i10);
            }
        }
    }
}
