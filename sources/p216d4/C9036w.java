package p216d4;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p405jt.AbstractC10915a;

/* renamed from: d4.w */
/* loaded from: classes.dex */
public class C9036w {
    /* renamed from: a */
    public static JSONArray m56987a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONArray(str);
        } catch (JSONException unused) {
            AbstractC10915a.m65978j("JsonOpUtil", "create json array err");
            return null;
        }
    }

    /* renamed from: b */
    public static void m56988b(JSONObject jSONObject, String str, int i10) throws JSONException {
        try {
            jSONObject.put(str, i10);
        } catch (JSONException e10) {
            AbstractC10915a.m65978j("JsonOpUtil", "put int " + e10.getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public static void m56989c(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e10) {
            AbstractC10915a.m65978j("JsonOpUtil", "put obj " + e10.getClass().getSimpleName());
        }
    }

    /* renamed from: d */
    public static JSONObject m56990d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            AbstractC10915a.m65978j("JsonOpUtil", "create json obj err");
            return null;
        }
    }
}
