package com.huawei.hms.hatool;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.e */
/* loaded from: classes8.dex */
public class C5525e {

    /* renamed from: b */
    private static C5525e f25172b;

    /* renamed from: c */
    private static Map<String, Long> f25173c = new HashMap();

    /* renamed from: a */
    private Context f25174a;

    /* renamed from: a */
    public static C5525e m32484a() {
        return m32485b();
    }

    /* renamed from: b */
    private static synchronized C5525e m32485b() {
        try {
            if (f25172b == null) {
                f25172b = new C5525e();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f25172b;
    }

    /* renamed from: b */
    private void m32486b(Context context) throws PackageManager.NameNotFoundException {
        String str;
        String strM32672d = AbstractC5555o.m32672d(context);
        AbstractC5562q0.m32703a(strM32672d);
        if (C5563q1.m32725b().m32726a()) {
            String strM32476a = C5522d.m32476a(context, "global_v2", "app_ver", "");
            C5522d.m32481b(context, "global_v2", "app_ver", strM32672d);
            AbstractC5562q0.m32705b(strM32476a);
            if (!TextUtils.isEmpty(strM32476a)) {
                if (strM32476a.equals(strM32672d)) {
                    return;
                }
                C5571v.m32792c("hmsSdk", "the appVers are different!");
                m32484a().m32492a("", "alltype", strM32476a);
                return;
            }
            str = "app ver is first save!";
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        C5571v.m32792c("hmsSdk", str);
    }

    /* renamed from: a */
    public void m32487a(Context context) throws PackageManager.NameNotFoundException {
        this.f25174a = context;
        m32486b(context);
        C5565s.m32733c().m32738b().m32538h(AbstractC5555o.m32665a());
    }

    /* renamed from: a */
    public void m32488a(String str, int i10) {
        if (this.f25174a == null) {
            C5571v.m32796e("hmsSdk", "onReport() null context or SDK was not init.");
        } else {
            C5571v.m32786a("hmsSdk", "onReport: Before calling runtaskhandler()");
            m32492a(str, AbstractC5554n1.m32659a(i10), AbstractC5562q0.m32714g());
        }
    }

    /* renamed from: a */
    public void m32489a(String str, int i10, String str2, JSONObject jSONObject) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (2 == i10) {
            jCurrentTimeMillis = AbstractC5554n1.m32657a("yyyy-MM-dd", jCurrentTimeMillis);
        }
        C5517b0.m32449c().m32450a(new C5514a0(str2, jSONObject, str, AbstractC5554n1.m32659a(i10), jCurrentTimeMillis));
    }

    /* renamed from: a */
    public void m32490a(String str, int i10, String str2, JSONObject jSONObject, long j10) {
        new C5539i1(str, AbstractC5554n1.m32659a(i10), str2, jSONObject.toString(), j10).m32575a();
    }

    /* renamed from: a */
    public void m32491a(String str, String str2) {
        if (!AbstractC5515a1.m32426a(str, str2)) {
            C5571v.m32792c("hmsSdk", "auto report is closed tag:" + str);
            return;
        }
        long jM32435j = AbstractC5515a1.m32435j(str, str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jM32435j <= 30000) {
            C5571v.m32797f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        C5571v.m32786a("hmsSdk", "begin to call onReport!");
        AbstractC5515a1.m32425a(str, str2, jCurrentTimeMillis);
        m32492a(str, str2, AbstractC5562q0.m32714g());
    }

    /* renamed from: a */
    public void m32492a(String str, String str2, String str3) {
        Context context = this.f25174a;
        if (context == null) {
            C5571v.m32796e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String strM32730b = C5564r0.m32730b(context);
        if (AbstractC5515a1.m32430e(str, str2) && !"WIFI".equals(strM32730b)) {
            C5571v.m32792c("hmsSdk", "strNetworkType is :" + strM32730b);
            return;
        }
        if ("unknown".equals(strM32730b) || "none".equals(strM32730b) || "2G".equals(strM32730b)) {
            C5571v.m32796e("hmsSdk", "The network is bad.");
        } else {
            C5517b0.m32449c().m32450a(new C5572v0(str, str2, str3));
        }
    }
}
