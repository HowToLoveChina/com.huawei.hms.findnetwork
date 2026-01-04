package com.huawei.android.remotecontrol.http;

import android.content.Context;
import android.os.UserManager;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p521og.C11877j;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.http.e */
/* loaded from: classes4.dex */
public final class C4347e {

    /* renamed from: a */
    public static final String[] f19831a = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    /* renamed from: a */
    public static int m26230a(Iterator it) {
        int i10 = 0;
        while (it.hasNext()) {
            i10++;
            it.next();
        }
        return i10;
    }

    /* renamed from: b */
    public static int m26231b(JSONObject jSONObject, String str) throws JSONException {
        int i10 = -1;
        try {
            if (jSONObject.has(str)) {
                i10 = jSONObject.getInt(str);
            } else {
                C13981a.m83990w("HttpUtil", "getIntValue key not exist");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("HttpUtil", "getIntValue exception");
        }
        return i10;
    }

    /* renamed from: c */
    public static boolean m26232c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optBoolean("lostPatternFlag", false);
        }
        return false;
    }

    /* renamed from: d */
    public static int m26233d(String str) {
        int i10 = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(MapKeyNames.RESULT_CODE)) {
                i10 = jSONObject.getInt(MapKeyNames.RESULT_CODE);
            } else {
                C13981a.m83988e("HttpUtil", "getResultCode->json has no resultCode");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("HttpUtil", "getResultCode JSONException");
        }
        return i10;
    }

    /* renamed from: e */
    public static String m26234e(String str) throws JSONException {
        String string = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("resultDesc")) {
                string = jSONObject.getString("resultDesc");
            } else {
                C13981a.m83988e("HttpUtil", "getResultDesc->json has no resultDesc");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("HttpUtil", "getResultDesc JSONException");
        }
        return string;
    }

    /* renamed from: f */
    public static String m26235f(String str) throws JSONException {
        String string = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("deviceTicket")) {
                string = jSONObject.getString("deviceTicket");
            } else {
                C13981a.m83987d("HttpUtil", "getResultCode->json has no resultCode");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("HttpUtil", "getResultTicket JSONException");
        }
        if (TextUtils.isEmpty(string)) {
            C13981a.m83988e("HttpUtil", "deviceTicket is empty");
        }
        return string;
    }

    /* renamed from: g */
    public static String m26236g() {
        return C0209d.m1315v().replaceAll(" ", "").replaceAll("\\(", "").replaceAll("\\)", "");
    }

    /* renamed from: h */
    public static String m26237h(JSONObject jSONObject, String str) {
        String string = "";
        try {
            if (jSONObject.has(str)) {
                string = jSONObject.getString(str);
            } else {
                C13981a.m83990w("HttpUtil", "getStringValue key not exist");
            }
        } catch (JSONException unused) {
            C13981a.m83988e("HttpUtil", "getStringValue exception");
        }
        return string;
    }

    /* renamed from: i */
    public static boolean m26238i(Context context) {
        for (String str : f19831a) {
            if (context.checkSelfPermission(str) != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: j */
    public static boolean m26239j(Context context) {
        UserManager userManager;
        return (context == null || (userManager = (UserManager) context.getSystemService("user")) == null || userManager.isUserUnlocked()) ? false : true;
    }

    /* renamed from: k */
    public static void m26240k(Context context) {
        C11877j.m71280k1(context, C1443a.f6213a);
        C11877j.m71283l1(context, m26236g());
    }
}
