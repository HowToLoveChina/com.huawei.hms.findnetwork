package com.huawei.hms.hatool;

import android.text.TextUtils;
import eu.C9560a;
import gu.C10048b;

/* renamed from: com.huawei.hms.hatool.o0 */
/* loaded from: classes8.dex */
public class C5556o0 {

    /* renamed from: c */
    private static C5556o0 f25267c;

    /* renamed from: a */
    private String f25268a;

    /* renamed from: b */
    private String f25269b;

    /* renamed from: b */
    private String m32674b(String str) {
        return m32679f() ? C9560a.m59680i("analytics_keystore", str) : C5552n.m32654b(str, m32678e());
    }

    /* renamed from: c */
    private String m32675c() {
        String strM32476a = C5522d.m32476a(AbstractC5562q0.m32718i(), "Privacy_MY", "PrivacyData", "");
        if (!TextUtils.isEmpty(strM32476a)) {
            return m32673a(strM32476a);
        }
        String strM62473e = C10048b.m62473e(16);
        m32676c(m32674b(strM62473e));
        return strM62473e;
    }

    /* renamed from: d */
    public static C5556o0 m32677d() {
        if (f25267c == null) {
            m32680g();
        }
        return f25267c;
    }

    /* renamed from: e */
    private String m32678e() {
        if (TextUtils.isEmpty(this.f25269b)) {
            this.f25269b = new C5575x().m32818a();
        }
        return this.f25269b;
    }

    /* renamed from: f */
    private boolean m32679f() {
        return true;
    }

    /* renamed from: g */
    private static synchronized void m32680g() {
        if (f25267c == null) {
            f25267c = new C5556o0();
        }
    }

    /* renamed from: a */
    public String m32681a() {
        if (TextUtils.isEmpty(this.f25268a)) {
            this.f25268a = m32675c();
        }
        return this.f25268a;
    }

    /* renamed from: a */
    private String m32673a(String str) {
        String strM59677f = m32679f() ? C9560a.m59677f("analytics_keystore", str) : "";
        if (TextUtils.isEmpty(strM59677f)) {
            C5571v.m32792c("hmsSdk", "deCrypt work key first");
            strM59677f = C5552n.m32652a(str, m32678e());
            if (TextUtils.isEmpty(strM59677f)) {
                strM59677f = C10048b.m62473e(16);
                m32676c(m32674b(strM59677f));
                if (m32679f()) {
                    C5575x.m32816c();
                }
            } else if (m32679f()) {
                m32676c(m32674b(strM59677f));
                C5575x.m32816c();
            }
        }
        return strM59677f;
    }

    /* renamed from: c */
    private boolean m32676c(String str) {
        C5571v.m32792c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            C5571v.m32792c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        C5522d.m32481b(AbstractC5562q0.m32718i(), "Privacy_MY", "PrivacyData", str);
        C5522d.m32480b(AbstractC5562q0.m32718i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    /* renamed from: b */
    public void m32682b() {
        String strM62473e = C10048b.m62473e(16);
        if (m32676c(m32674b(strM62473e))) {
            this.f25268a = strM62473e;
        }
    }
}
