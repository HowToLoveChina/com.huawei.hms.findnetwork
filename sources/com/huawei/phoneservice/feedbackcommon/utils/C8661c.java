package com.huawei.phoneservice.feedbackcommon.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.hms.framework.common.Logger;
import com.huawei.phoneservice.faq.base.util.FaqRefectUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.c */
/* loaded from: classes5.dex */
public class C8661c {
    /* renamed from: a */
    public static int m53397a(Context context, FaqRefectUtils.ResType resType, String str) {
        try {
            return context.getResources().getIdentifier(str, resType.toString(), context.getPackageName());
        } catch (Exception e10) {
            Logger.m32138e("XmlUtil", e10);
            return 0;
        }
    }

    /* renamed from: b */
    public static String m53398b(Context context, String str, String str2) throws Resources.NotFoundException {
        String str3;
        XmlResourceParser xml = context.getResources().getXml(m53397a(context, FaqRefectUtils.ResType.RES_TYPE_XML, str2));
        try {
            if (xml == null) {
                return "";
            }
            try {
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        if (str.equals(xml.getAttributeName(0)) && ExtractOWiFiHelper.STING_NODE.equals(name)) {
                            return xml.getAttributeValue(0);
                        }
                    }
                }
            } catch (IOException unused) {
                str3 = "getValueByAttributeName IOException";
                Logger.m32138e("XmlUtil", str3);
                return "";
            } catch (XmlPullParserException unused2) {
                str3 = "getValueByAttributeName XmlPullParserException ";
                Logger.m32138e("XmlUtil", str3);
                return "";
            } catch (Exception unused3) {
                str3 = "getValueByAttributeName Exception";
                Logger.m32138e("XmlUtil", str3);
                return "";
            }
            return "";
        } finally {
            xml.close();
        }
    }
}
