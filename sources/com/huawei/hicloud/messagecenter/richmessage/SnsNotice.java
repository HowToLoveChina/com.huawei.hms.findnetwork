package com.huawei.hicloud.messagecenter.richmessage;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes6.dex */
public class SnsNotice {
    private static final String HW_SNS_NOTICE = "hw_sns_notice";
    private static final String HW_SNS_NOTICE_TAG = "<hw_sns_notice>";
    private static final String TAG = "SnsNotice";
    private static final String UTF_8 = "UTF-8";
    private boolean isParseXmlSuccess = true;
    private List<BaseItem> itemList;
    private String xmlLayoutStr;

    public SnsNotice(String str) throws IOException {
        this.xmlLayoutStr = str;
        if (isNeedParse(str)) {
            parseXml();
        }
    }

    private boolean isNeedParse(String str) {
        return !TextUtils.isEmpty(str) && str.contains(HW_SNS_NOTICE_TAG);
    }

    private View onCreateView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        List<BaseItem> list = this.itemList;
        if (list != null) {
            for (BaseItem baseItem : list) {
                if (baseItem instanceof TextItem) {
                    ((TextItem) baseItem).onCreateView(context, linearLayout);
                } else if (baseItem instanceof TextPair) {
                    ((TextPair) baseItem).onCreateView(context, linearLayout);
                }
            }
        }
        return linearLayout;
    }

    private void parseXml() throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.xmlLayoutStr.getBytes("UTF-8"));
            try {
                XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                xmlPullParserNewPullParser.setInput(byteArrayInputStream, "UTF-8");
                for (int eventType = xmlPullParserNewPullParser.getEventType(); 1 != eventType; eventType = xmlPullParserNewPullParser.next()) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if (HW_SNS_NOTICE.equals(name)) {
                            this.itemList = new ArrayList();
                        }
                        BaseItem baseItemStartTag = startTag(xmlPullParserNewPullParser, name);
                        List<BaseItem> list = this.itemList;
                        if (list != null && baseItemStartTag != null) {
                            list.add(baseItemStartTag);
                        }
                    }
                }
                byteArrayInputStream.close();
            } finally {
            }
        } catch (IOException unused) {
            NotifyLogger.m29914e(TAG, "parseXml IOException");
            this.isParseXmlSuccess = false;
        } catch (XmlPullParserException unused2) {
            NotifyLogger.m29914e(TAG, "parseXml XmlPullParserException");
            this.isParseXmlSuccess = false;
        }
    }

    private BaseItem startTag(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        if (TextItem.TEXT_ITEM.equalsIgnoreCase(str)) {
            TextItem textItem = new TextItem();
            textItem.parse(xmlPullParser);
            return textItem;
        }
        if (!TextPair.TEXT_PAIR.equalsIgnoreCase(str)) {
            return null;
        }
        TextPair textPair = new TextPair();
        textPair.parse(xmlPullParser);
        return textPair;
    }

    public View getView(Context context) {
        if (TextUtils.isEmpty(this.xmlLayoutStr)) {
            return null;
        }
        if (isNeedParse(this.xmlLayoutStr) && this.isParseXmlSuccess) {
            return onCreateView(context);
        }
        TextView textView = new TextView(context);
        textView.setText(Html.fromHtml(this.xmlLayoutStr));
        return textView;
    }

    public boolean isParseSuccess() {
        return this.isParseXmlSuccess;
    }
}
