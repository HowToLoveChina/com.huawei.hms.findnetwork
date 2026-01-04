package com.huawei.openalliance.p169ad;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.beans.vast.Creative;
import com.huawei.openalliance.p169ad.beans.vast.StaticResource;
import com.huawei.openalliance.p169ad.beans.vast.VastContent;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VastTag;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.huawei.openalliance.ad.rh */
/* loaded from: classes8.dex */
public class C7632rh {

    /* renamed from: a */
    private static final List<String> f35559a = Arrays.asList(VastTag.AD_SYSTEM, VastTag.AD_TITLE, VastTag.ADVERTISER, VastTag.DESCRIPTION, VastTag.IMPRESSION, VastTag.CREATIVES);

    /* renamed from: b */
    private static final List<String> f35560b = Arrays.asList(VastTag.AD_SYSTEM, VastTag.AD_TITLE, VastTag.ADVERTISER, VastTag.DESCRIPTION, VastTag.IMPRESSION, VastTag.CREATIVES);

    /* renamed from: com.huawei.openalliance.ad.rh$a */
    public interface a {
        /* renamed from: a */
        void mo47067a();
    }

    /* renamed from: a */
    public static String m47086a(String str) {
        if (str == null) {
            AbstractC7185ho.m43826d("ParseUtil", "Parse time failed, source is empty");
            return null;
        }
        try {
            return String.valueOf(m47089a(true).parse(str).getTime());
        } catch (ParseException unused) {
            try {
                return String.valueOf(m47089a(false).parse(str).getTime());
            } catch (ParseException e10) {
                AbstractC7185ho.m43827d("ParseUtil", "Parse time failed , time format is invalid", e10);
                return null;
            }
        }
    }

    /* renamed from: b */
    public static StaticResource m47094b(XmlPullParser xmlPullParser) {
        if (xmlPullParser == null) {
            return null;
        }
        AbstractC7185ho.m43817a("ParseUtil", "start read static resource");
        StaticResource staticResource = new StaticResource();
        staticResource.m41003a(m47088a(xmlPullParser, "creativeType"));
        staticResource.m41005b(m47087a(xmlPullParser));
        AbstractC7185ho.m43817a("ParseUtil", "read static resource finish");
        return staticResource;
    }

    /* renamed from: c */
    public static List<Creative> m47096c(XmlPullParser xmlPullParser, VastContent vastContent) throws XmlPullParserException, IOException {
        AbstractC7185ho.m43820b("ParseUtil", "read creatives");
        xmlPullParser.require(2, VastTag.NAMESPACE, VastTag.CREATIVES);
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        map.put(VastTag.CREATIVE, new C7636rl(vastContent, xmlPullParser, arrayList));
        m47093a(xmlPullParser, map, (List<String>) Collections.singletonList(VastTag.CREATIVE));
        return arrayList;
    }

    /* renamed from: a */
    public static String m47087a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser == null) {
            return null;
        }
        if (xmlPullParser.next() != 4) {
            return "";
        }
        String strTrim = xmlPullParser.getText().trim();
        xmlPullParser.nextTag();
        return strTrim;
    }

    /* renamed from: b */
    public static void m47095b(XmlPullParser xmlPullParser, VastContent vastContent) throws XmlPullParserException, IOException {
        m47092a(xmlPullParser, vastContent, VastTag.INLINE, f35559a);
    }

    /* renamed from: c */
    private static void m47097c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser == null || xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i10 = 1;
        while (i10 != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i10++;
            } else if (next == 3) {
                i10--;
            }
        }
    }

    /* renamed from: a */
    public static String m47088a(XmlPullParser xmlPullParser, String str) {
        if (xmlPullParser == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String attributeValue = xmlPullParser.getAttributeValue(VastTag.NAMESPACE, str);
        if (!AbstractC7806cz.m48165b(attributeValue)) {
            return attributeValue;
        }
        AbstractC7185ho.m43824c("ParseUtil", "missing required attribute: %s ", str);
        return null;
    }

    /* renamed from: a */
    private static SimpleDateFormat m47089a(boolean z10) {
        SimpleDateFormat simpleDateFormat = z10 ? new SimpleDateFormat(Constants.TIME_FORMAT_WITH_MILLS, Locale.ENGLISH) : new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(Constants.GMT_STANDARD_TIME_ZONE);
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    /* renamed from: a */
    private static void m47090a(Map<String, a> map, VastContent vastContent, XmlPullParser xmlPullParser) {
        if (map == null || vastContent == null || xmlPullParser == null) {
            return;
        }
        for (String str : f35559a) {
            map.put(str, new C7637rm(str, vastContent, xmlPullParser));
        }
    }

    /* renamed from: a */
    public static void m47091a(XmlPullParser xmlPullParser, VastContent vastContent) throws XmlPullParserException, IOException {
        m47092a(xmlPullParser, vastContent, VastTag.WRAPPER, f35560b);
    }

    /* renamed from: a */
    private static void m47092a(XmlPullParser xmlPullParser, VastContent vastContent, String str, List<String> list) throws XmlPullParserException, IOException {
        if (xmlPullParser == null || vastContent == null) {
            return;
        }
        xmlPullParser.require(2, VastTag.NAMESPACE, str);
        HashMap map = new HashMap();
        m47090a(map, vastContent, xmlPullParser);
        m47093a(xmlPullParser, map, list);
    }

    /* renamed from: a */
    public static void m47093a(XmlPullParser xmlPullParser, Map<String, a> map, List<String> list) throws XmlPullParserException, IOException {
        if (xmlPullParser == null || map == null || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        while (xmlPullParser.next() != 3 && xmlPullParser.getEventType() != 1) {
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                Iterator it = arrayList.iterator();
                while (it.hasNext() && !((String) it.next()).equalsIgnoreCase(name)) {
                }
                if (map.containsKey(name)) {
                    a aVar = map.get(name);
                    if (aVar != null) {
                        aVar.mo47067a();
                    }
                } else {
                    m47097c(xmlPullParser);
                }
            }
        }
    }
}
