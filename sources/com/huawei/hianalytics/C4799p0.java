package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import cu.C8952a;
import eu.C9560a;
import gu.C10048b;
import gu.C10049c;
import java.io.UnsupportedEncodingException;
import p237du.AbstractC9309b;

/* renamed from: com.huawei.hianalytics.p0 */
/* loaded from: classes5.dex */
public class C4799p0 {

    /* renamed from: a */
    public static C4799p0 f21891a;

    /* renamed from: a */
    public static final Object f21892a = new Object();

    /* renamed from: b */
    public static final Object f21893b = new Object();

    /* renamed from: a */
    public String f21894a;

    /* renamed from: a */
    public byte[] f21895a;

    /* renamed from: b */
    public String f21896b;

    /* renamed from: a */
    public String m28984a() {
        if (TextUtils.isEmpty(this.f21896b)) {
            synchronized (f21892a) {
                m28986a();
            }
        }
        return this.f21896b;
    }

    /* renamed from: b */
    public final String m28989b() {
        if (TextUtils.isEmpty(this.f21894a)) {
            synchronized (f21893b) {
                m28990b();
            }
        }
        return this.f21894a;
    }

    /* renamed from: a */
    public final String m28985a(String str) {
        if (!m28988a()) {
            return C8952a.m56690l(str, m28989b());
        }
        HiLog.m28809i("RootKeyManager", "load work key encrypt is gcm ks");
        return C9560a.m59680i("analytics_keystore_formal", str);
    }

    /* renamed from: b */
    public final void m28990b() throws Throwable {
        String strM62473e;
        String strM62473e2;
        String strM62473e3;
        String strM62473e4;
        if (TextUtils.isEmpty(this.f21894a)) {
            C4797o0 c4797o0 = new C4797o0();
            long jM28896a = C4785j.m28896a("Privacy_MY", "assemblyFlash", -1L);
            if (jM28896a != -1 && System.currentTimeMillis() - jM28896a <= 31536000000L) {
                strM62473e = c4797o0.m28978b("aprpap");
                strM62473e2 = c4797o0.m28978b("febdoc");
                strM62473e3 = c4797o0.m28978b("marfil");
                strM62473e4 = c4797o0.m28978b("maywnj");
            } else {
                strM62473e = C10048b.m62473e(128);
                c4797o0.m28976a("aprpap", strM62473e);
                strM62473e2 = C10048b.m62473e(128);
                c4797o0.m28976a("febdoc", strM62473e2);
                strM62473e3 = C10048b.m62473e(128);
                c4797o0.m28976a("marfil", strM62473e3);
                strM62473e4 = C10048b.m62473e(128);
                c4797o0.m28976a("maywnj", strM62473e4);
                C4785j.m28917a("Privacy_MY", "assemblyFlash", System.currentTimeMillis());
            }
            byte[] bArrM62477b = C10049c.m62477b(strM62473e);
            byte[] bArrM62477b2 = C10049c.m62477b(strM62473e2);
            byte[] bArrM62477b3 = C10049c.m62477b(strM62473e3);
            byte[] bArrM62477b4 = C10049c.m62477b("f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc");
            int length = bArrM62477b.length;
            if (length > bArrM62477b2.length) {
                length = bArrM62477b2.length;
            }
            if (length > bArrM62477b3.length) {
                length = bArrM62477b3.length;
            }
            if (length > bArrM62477b4.length) {
                length = bArrM62477b4.length;
            }
            char[] cArr = new char[length];
            for (int i10 = 0; i10 < length; i10++) {
                cArr[i10] = (char) (((bArrM62477b[i10] ^ bArrM62477b2[i10]) ^ bArrM62477b3[i10]) ^ bArrM62477b4[i10]);
            }
            this.f21894a = C10049c.m62476a(AbstractC9309b.m58615b(cArr, C10049c.m62477b(strM62473e4), 10000, 128));
        }
    }

    /* renamed from: a */
    public final void m28987a(String str) {
        HiLog.m28810si("RootKeyManager", "refresh local key to the sp");
        C4785j.m28918a("Privacy_MY", "PrivacyData", str);
        C4785j.m28917a("Privacy_MY", "flashKeyTime", System.currentTimeMillis());
    }

    /* renamed from: a */
    public final boolean m28988a() {
        return true;
    }

    /* renamed from: a */
    public static C4799p0 m28983a() {
        if (f21891a == null) {
            synchronized (C4799p0.class) {
                if (f21891a == null) {
                    f21891a = new C4799p0();
                }
            }
        }
        return f21891a;
    }

    /* renamed from: a */
    public final void m28986a() throws UnsupportedEncodingException {
        String strM56686h;
        if (TextUtils.isEmpty(this.f21896b)) {
            String strM28908a = C4785j.m28908a("Privacy_MY", "PrivacyData", "");
            if (TextUtils.isEmpty(strM28908a)) {
                strM56686h = C10048b.m62473e(16);
                m28987a(m28985a(strM56686h));
            } else {
                String strM59677f = m28988a() ? C9560a.m59677f("analytics_keystore_formal", strM28908a) : "";
                if (TextUtils.isEmpty(strM59677f)) {
                    HiLog.m28809i("RootKeyManager", "decrypt work key first");
                    strM56686h = C8952a.m56686h(strM28908a, m28989b());
                    if (TextUtils.isEmpty(strM56686h)) {
                        strM56686h = C10048b.m62473e(16);
                        m28987a(m28985a(strM56686h));
                        if (m28988a()) {
                            C4797o0.m28973a();
                        }
                    } else if (m28988a()) {
                        m28987a(m28985a(strM56686h));
                        C4797o0.m28973a();
                    }
                } else {
                    strM56686h = strM59677f;
                }
            }
            this.f21896b = strM56686h;
        }
    }
}
