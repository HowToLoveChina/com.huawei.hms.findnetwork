package com.huawei.hms.support.hwid.common.p146e;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.hms.support.hwid.common.C6462a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.huawei.hms.support.hwid.common.e.c */
/* loaded from: classes8.dex */
public class C6473c {
    /* renamed from: a */
    public static boolean m36871a(Context context) {
        C6477g.m36903a("BaseUtil", "enter networkIsAvaiable");
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("connectivity");
        if (systemService == null) {
            C6477g.m36903a("BaseUtil", "connectivity is null,so networkIsAvaiable is unaviable");
            return false;
        }
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) systemService).getAllNetworkInfo();
        if (allNetworkInfo == null || allNetworkInfo.length == 0) {
            C6477g.m36903a("BaseUtil", "NetworkInfo is null,so networkIsAvaiable is unaviable");
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        C6477g.m36903a("BaseUtil", "NetworkInfo  state is unaviable");
        return false;
    }

    /* renamed from: b */
    public static String m36873b(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().toLowerCase(Locale.getDefault());
    }

    /* renamed from: c */
    public static String m36874c(Context context) {
        return context.getResources().getConfiguration().locale.getCountry().toLowerCase(Locale.getDefault());
    }

    /* renamed from: d */
    public static String m36875d(Context context) {
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(m36878g(context))) {
            return m36873b(context) + "-" + m36874c(context).toUpperCase(Locale.getDefault());
        }
        return m36873b(context) + "-" + m36878g(context) + "-" + m36874c(context).toUpperCase(Locale.getDefault());
    }

    /* renamed from: e */
    public static List<String> m36876e(Context context) throws XmlPullParserException, Resources.NotFoundException, IOException {
        ArrayList arrayList = new ArrayList();
        XmlResourceParser xml = context.getResources().getXml(C6478h.m36908a(context, "usesdk_packagename"));
        if (xml == null) {
            return arrayList;
        }
        try {
            for (int eventType = xml.getEventType(); 1 != eventType; eventType = xml.next()) {
                String name = xml.getName();
                if (eventType == 2 && "package".equals(name)) {
                    arrayList.add(xml.nextText());
                }
            }
        } catch (IOException unused) {
            C6477g.m36905b("BaseUtil", "Parser xml exception: IOException");
        } catch (XmlPullParserException unused2) {
            C6477g.m36905b("BaseUtil", "Parser xml exception: XmlPullParserException");
        }
        return arrayList;
    }

    /* renamed from: f */
    public static boolean m36877f(Context context) {
        List<String> listM36876e;
        if (context == null) {
            C6477g.m36905b("BaseUtil", "context is null.");
            return true;
        }
        C6462a c6462aM36833a = C6462a.m36833a();
        if (c6462aM36833a.m36837c() == null) {
            try {
                listM36876e = m36876e(context);
            } catch (Exception unused) {
                listM36876e = null;
            }
            try {
                c6462aM36833a.m36835a(listM36876e);
            } catch (Exception unused2) {
                C6477g.m36905b("BaseUtil", "Exception");
                if (listM36876e == null) {
                }
            }
        } else {
            listM36876e = c6462aM36833a.m36837c();
        }
        return (listM36876e == null && listM36876e.contains(context.getPackageName())) ? false : true;
    }

    /* renamed from: g */
    private static String m36878g(Context context) {
        return context.getResources().getConfiguration().locale.getScript();
    }

    /* renamed from: a */
    public static String m36870a() {
        return "HwID_6.11.0.300";
    }

    /* renamed from: a */
    public static boolean m36872a(String str) {
        return (TextUtils.isEmpty(str) || str.equals("0") || str.equals("1") || str.equals("2") || str.equals("8")) ? false : true;
    }
}
