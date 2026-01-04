package com.huawei.hms.ads.installreferrer.commons;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.ads.installreferrer.commons.a */
/* loaded from: classes8.dex */
public class C5082a {
    /* renamed from: a */
    public static Uri m30326a(String str) {
        Uri uri = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String strM30334a = C5086e.m30334a(str);
            String strM30329c = m30328b(C5086e.m30334a(strM30334a)) ? (String) new JSONObject(C5086e.m30334a(strM30334a)).get("dplink") : strM30334a.contains("hw_dplink") ? m30329c(strM30334a) : null;
            if (strM30329c == null) {
                return null;
            }
            uri = Uri.parse(strM30329c);
            LogUtil.logInfo("AGReferrerDetails", "get deeplink url success");
            return uri;
        } catch (Throwable th2) {
            LogUtil.logError("AGReferrerDetails", "getDeeplinkUrl exception: " + th2.getClass().getSimpleName());
            return uri;
        }
    }

    /* renamed from: b */
    private static boolean m30328b(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c */
    private static String m30329c(String str) {
        int iIndexOf = str.indexOf("hw_dplink") + 10;
        int i10 = iIndexOf;
        while (i10 < str.length() && str.charAt(i10) != '&') {
            i10++;
        }
        return C5086e.m30334a(str.substring(iIndexOf, i10));
    }

    /* renamed from: a */
    public static String m30327a(Context context) throws Throwable {
        Cursor cursorQuery;
        Throwable th2;
        Uri uri = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {context.getPackageName()};
        String string = null;
        try {
            cursorQuery = contentResolver.query(uri, null, null, strArr, null);
            try {
                if (cursorQuery != null) {
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(5);
                } else {
                    LogUtil.logWarn("AGReferrerDetails", "referrer is null");
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return string;
            } catch (Throwable th3) {
                th2 = th3;
                if (cursorQuery == null) {
                    throw th2;
                }
                cursorQuery.close();
                throw th2;
            }
        } catch (Throwable th4) {
            cursorQuery = null;
            th2 = th4;
        }
    }
}
