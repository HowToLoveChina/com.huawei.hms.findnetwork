package p684un;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import hu.C10343b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p399jk.AbstractC10896a;

/* renamed from: un.a */
/* loaded from: classes6.dex */
public class C13222a {
    /* renamed from: a */
    public static void m79459a(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            AbstractC10896a.m65888w("BICommonUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", str);
        linkedHashMap.put("value", str2);
        C13230i.m79504I().m79571T(linkedHashMap);
    }

    /* renamed from: b */
    public static void m79460b(Context context, String str, String str2, String str3, String str4) {
        if (str == null || str2 == null) {
            AbstractC10896a.m65888w("BICommonUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", str);
        linkedHashMap.put("value", str2);
        linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str4);
        linkedHashMap.put("uid", str3);
        linkedHashMap.put("phone_type", Build.MODEL);
        C13230i.m79504I().m79571T(linkedHashMap);
    }

    /* renamed from: c */
    public static void m79461c(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            AbstractC10896a.m65888w("BICommonUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    linkedHashMap.put(next, jSONObject.getString(next));
                }
            }
            if (linkedHashMap.isEmpty()) {
                return;
            }
            C13230i.m79504I().m79571T(linkedHashMap);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BICommonUtil", "collectEvent error occur, " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public static void m79462d(String str, String str2, String str3, String str4, String str5) {
        if (str == null || str2 == null) {
            AbstractC10896a.m65888w("BICommonUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", str);
        linkedHashMap.put("value", str2);
        linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str4);
        linkedHashMap.put("uid", str3);
        linkedHashMap.put("phone_type", Build.MODEL);
        linkedHashMap.put("gradeCode", str5);
        C13230i.m79504I().m79571T(linkedHashMap);
    }

    /* renamed from: e */
    public static void m79463e(String str, String str2, String str3, String str4, boolean z10, int i10) {
        if (str == null || str2 == null) {
            AbstractC10896a.m65888w("BICommonUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", str);
        linkedHashMap.put("value", str2);
        linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str4);
        linkedHashMap.put("uid", str3);
        linkedHashMap.put("phone_type", Build.MODEL);
        linkedHashMap.put("isAutoOpen", m79466h(z10));
        linkedHashMap.put("sourceType", m79467i(i10));
        C13224c.m79487f1().m79571T(linkedHashMap);
    }

    /* renamed from: f */
    public static JSONObject m79464f(Context context, String str, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", str);
            m79468j(jSONObject, "value", str2);
            m79468j(jSONObject, FaqConstants.FAQ_CHANNEL, str4);
            jSONObject.put("uid", str3);
            jSONObject.put("phone_type", Build.MODEL);
        } catch (Exception unused) {
            AbstractC10896a.m65886e("BICommonUtil", "ERROR OCCUR");
        }
        return jSONObject;
    }

    /* renamed from: g */
    public static String m79465g(Activity activity) {
        Intent intent;
        String stringExtra;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return "2";
        }
        try {
            stringExtra = intent.getStringExtra("channel_refer");
        } catch (Exception unused) {
            AbstractC10896a.m65886e("BICommonUtil", "getActivityChannel getStringExtra Exception");
            stringExtra = "2";
        }
        return TextUtils.isEmpty(stringExtra) ? "2" : stringExtra;
    }

    /* renamed from: h */
    public static String m79466h(boolean z10) {
        return z10 ? "1" : "0";
    }

    /* renamed from: i */
    public static String m79467i(int i10) {
        return i10 == 1 ? "Gallery" : i10 == 2 ? "FileManager" : "Cloud";
    }

    /* renamed from: j */
    public static void m79468j(JSONObject jSONObject, String str, String str2) throws JSONException {
        if ("null".equals(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    /* renamed from: k */
    public static void m79469k(Context context, String str, boolean z10) {
        if (z10) {
            m79459a(context, str, "1");
            UBAAnalyze.m29949J("CKC", str, "value", "1");
        } else {
            m79459a(context, str, "0");
            UBAAnalyze.m29949J("CKC", str, "value", "0");
        }
    }

    /* renamed from: l */
    public static void m79470l(Intent intent, String str) {
        if (intent == null) {
            return;
        }
        intent.putExtra("channel_refer", str);
    }

    /* renamed from: m */
    public static void m79471m(Intent intent, int i10) {
        if (intent == null) {
            return;
        }
        intent.putExtra("nav_source", i10);
    }

    /* renamed from: n */
    public static void m79472n(Intent intent, Bundle bundle) {
        if (intent == null || bundle == null) {
            return;
        }
        C10343b c10343b = new C10343b(bundle);
        int iM63687i = c10343b.m63687i("nav_source", 0);
        String strM63694p = c10343b.m63694p("nav_operation_path");
        intent.putExtra("nav_source", iM63687i);
        intent.putExtra("nav_operation_path", strM63694p);
    }
}
