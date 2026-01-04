package com.huawei.hms.hatool;

import android.text.TextUtils;
import eu.C9560a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.w0 */
/* loaded from: classes8.dex */
public class C5574w0 {
    /* renamed from: a */
    private static void m32804a(String str, String str2) {
        C5517b0.m32447a().m32450a(new C5542j1(str, str2));
    }

    /* renamed from: b */
    public static void m32806b(String str, String str2) {
        C5553n0 c5553n0M32799a;
        String str3;
        String strReplace = "{url}/getPublicKey?keytype=4".replace("{url}", AbstractC5515a1.m32431f(str, str2));
        String strM32712f = AbstractC5562q0.m32712f();
        HashMap map = new HashMap();
        map.put("App-Id", strM32712f);
        try {
            c5553n0M32799a = AbstractC5573w.m32799a(strReplace, new byte[0], map);
        } catch (Exception e10) {
            C5571v.m32796e("GetPublicKey", "get pubKey response Exception :" + e10.getMessage());
            c5553n0M32799a = null;
        }
        if (c5553n0M32799a == null) {
            str3 = "get pubKey response is null";
        } else if (c5553n0M32799a.m32656b() == 200) {
            if (TextUtils.isEmpty(c5553n0M32799a.m32655a())) {
                return;
            }
            m32808d(c5553n0M32799a.m32655a(), str2);
            return;
        } else {
            str3 = "get pubKey fail HttpCode :" + c5553n0M32799a.m32656b();
        }
        C5571v.m32796e("GetPublicKey", str3);
    }

    /* renamed from: c */
    public static String m32807c(String str, String str2) {
        String strM32724o;
        String strM32706c = AbstractC5562q0.m32706c();
        if (TextUtils.isEmpty(strM32706c)) {
            strM32706c = C5522d.m32476a(AbstractC5562q0.m32718i(), "Privacy_MY", "public_key_version", "");
            AbstractC5562q0.m32715g(strM32706c);
        }
        if (!"2.0".equals(strM32706c)) {
            m32804a(str, str2);
            return null;
        }
        if ("maint".equals(str2)) {
            strM32724o = AbstractC5562q0.m32723n();
            if (TextUtils.isEmpty(strM32724o)) {
                strM32724o = C9560a.m59677f("HiAnalytics_Sdk_Public_Sp_Key", C5522d.m32476a(AbstractC5562q0.m32718i(), "Privacy_MY", "public_key_maint", ""));
                AbstractC5562q0.m32709d(strM32724o);
            }
        } else {
            strM32724o = AbstractC5562q0.m32724o();
            if (TextUtils.isEmpty(strM32724o)) {
                strM32724o = C9560a.m59677f("HiAnalytics_Sdk_Public_Sp_Key", C5522d.m32476a(AbstractC5562q0.m32718i(), "Privacy_MY", "public_key_oper", ""));
                AbstractC5562q0.m32711e(strM32724o);
            }
        }
        if (!TextUtils.isEmpty(strM32724o) && !m32805a()) {
            return strM32724o;
        }
        m32804a(str, str2);
        return null;
    }

    /* renamed from: d */
    private static void m32808d(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("publicKey");
            String strOptString2 = jSONObject.optString("publicKeyOM");
            String strOptString3 = jSONObject.optString("pubkey_version");
            String str3 = System.currentTimeMillis() + "";
            String strOptString4 = jSONObject.optString("timeInterval");
            C5522d.m32481b(AbstractC5562q0.m32718i(), "Privacy_MY", "public_key_oper", C9560a.m59680i("HiAnalytics_Sdk_Public_Sp_Key", strOptString));
            C5522d.m32481b(AbstractC5562q0.m32718i(), "Privacy_MY", "public_key_maint", C9560a.m59680i("HiAnalytics_Sdk_Public_Sp_Key", strOptString2));
            C5522d.m32481b(AbstractC5562q0.m32718i(), "Privacy_MY", "public_key_time_interval", strOptString4);
            C5522d.m32481b(AbstractC5562q0.m32718i(), "Privacy_MY", "public_key_version", strOptString3);
            C5522d.m32481b(AbstractC5562q0.m32718i(), "Privacy_MY", "public_key_time_last", str3);
            AbstractC5562q0.m32711e(strOptString);
            AbstractC5562q0.m32709d(strOptString2);
            AbstractC5562q0.m32715g(strOptString3);
            AbstractC5562q0.m32707c(str3);
            AbstractC5562q0.m32713f(strOptString4);
        } catch (JSONException e10) {
            C5571v.m32796e("GetPublicKey", "get pubKey parse json JSONException :" + e10.getMessage());
        }
    }

    /* renamed from: a */
    public static boolean m32805a() throws NumberFormatException {
        String strM32702a = AbstractC5562q0.m32702a();
        if (TextUtils.isEmpty(strM32702a)) {
            strM32702a = C5522d.m32476a(AbstractC5562q0.m32718i(), "Privacy_MY", "public_key_time_interval", "");
            AbstractC5562q0.m32713f(strM32702a);
        }
        String strM32722m = AbstractC5562q0.m32722m();
        if (TextUtils.isEmpty(strM32722m)) {
            strM32722m = C5522d.m32476a(AbstractC5562q0.m32718i(), "Privacy_MY", "public_key_time_last", "");
            AbstractC5562q0.m32707c(strM32722m);
        }
        if (!TextUtils.isEmpty(strM32702a) && !TextUtils.isEmpty(strM32722m)) {
            try {
                return System.currentTimeMillis() - Long.parseLong(strM32722m) > ((long) Integer.parseInt(strM32702a));
            } catch (NumberFormatException e10) {
                C5571v.m32796e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e10.getMessage());
            }
        }
        return true;
    }
}
