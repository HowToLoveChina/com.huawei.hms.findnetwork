package p260ek;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p399jk.AbstractC10896a;

/* renamed from: ek.a */
/* loaded from: classes6.dex */
public class C9499a {
    /* renamed from: a */
    public static JSONArray m59433a(String str, String str2) {
        try {
            return new JSONObject(str).optJSONArray(str2);
        } catch (JSONException unused) {
            AbstractC10896a.m65886e("JsonUtil", "parseArray JSONException");
            return null;
        }
    }

    /* renamed from: b */
    public static int m59434b(String str, String str2) {
        try {
            return new JSONObject(str).optInt(str2);
        } catch (JSONException unused) {
            AbstractC10896a.m65886e("JsonUtil", "parseInt JSONException");
            return 0;
        }
    }

    /* renamed from: c */
    public static int m59435c(String str, String str2, int i10) {
        try {
            return new JSONObject(str).optInt(str2, i10);
        } catch (JSONException unused) {
            AbstractC10896a.m65886e("JsonUtil", "parseIntWithFallback JSONException");
            return i10;
        }
    }

    /* renamed from: d */
    public static String m59436d(String str, String str2) {
        try {
            return new JSONObject(str).optString(str2);
        } catch (JSONException unused) {
            AbstractC10896a.m65886e("JsonUtil", "parseString JSONException");
            return "";
        }
    }
}
