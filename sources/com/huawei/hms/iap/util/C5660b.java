package com.huawei.hms.iap.util;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.iap.util.b */
/* loaded from: classes8.dex */
public class C5660b {
    /* renamed from: a */
    public static String m33021a(String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            HMSLog.m36986e("IapJsonUtil", "appendJsonParam exception");
            return str;
        }
    }

    /* renamed from: b */
    public static boolean m33023b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).optBoolean(str2);
        } catch (JSONException unused) {
            HMSLog.m36986e("IapJsonUtil", "getBooleanValue JSONException");
            return false;
        }
    }

    /* renamed from: c */
    public static String m33024c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(str2);
        } catch (JSONException unused) {
            HMSLog.m36986e("IapJsonUtil", "getStringValue JSONException");
            return "";
        }
    }

    /* renamed from: a */
    public static <V> String m33022a(String str, String str2, V v10) throws JSONException {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put(str2, v10);
            return jSONObject.toString();
        } catch (JSONException unused) {
            HMSLog.m36986e("IapJsonUtil", "appendJsonParam, JSONException");
            return str;
        }
    }
}
