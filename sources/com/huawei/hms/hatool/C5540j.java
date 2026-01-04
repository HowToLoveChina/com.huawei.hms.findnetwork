package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.util.UUID;
import p237du.C9310c;

/* renamed from: com.huawei.hms.hatool.j */
/* loaded from: classes8.dex */
public class C5540j {

    /* renamed from: b */
    private static C5540j f25217b;

    /* renamed from: a */
    private Context f25218a;

    /* renamed from: com.huawei.hms.hatool.j$a */
    public static class a extends AbstractC5526e0 {

        /* renamed from: a */
        String f25219a;

        /* renamed from: b */
        String f25220b;

        public a(String str, String str2) {
            this.f25219a = str;
            this.f25220b = str2;
        }

        @Override // com.huawei.hms.hatool.AbstractC5526e0
        /* renamed from: a */
        public String mo32498a() {
            return AbstractC5579z.m32831d(this.f25219a, this.f25220b);
        }

        @Override // com.huawei.hms.hatool.AbstractC5526e0
        /* renamed from: b */
        public String mo32500b() {
            return AbstractC5579z.m32834g(this.f25219a, this.f25220b);
        }

        @Override // com.huawei.hms.hatool.AbstractC5526e0
        /* renamed from: c */
        public String mo32501c() {
            return AbstractC5579z.m32837j(this.f25219a, this.f25220b);
        }

        @Override // com.huawei.hms.hatool.AbstractC5526e0
        /* renamed from: d */
        public int mo32502d() {
            return (AbstractC5579z.m32835h(this.f25219a, this.f25220b) ? 1 : 0) | (AbstractC5579z.m32838k(this.f25219a, this.f25220b) ? 4 : 0) | (AbstractC5579z.m32832e(this.f25219a, this.f25220b) ? 2 : 0);
        }

        @Override // com.huawei.hms.hatool.AbstractC5526e0
        /* renamed from: a */
        public String mo32499a(String str) {
            return C9310c.m58618b(str);
        }
    }

    /* renamed from: a */
    public static C5540j m32576a() {
        C5540j c5540j;
        synchronized (C5540j.class) {
            try {
                if (f25217b == null) {
                    f25217b = new C5540j();
                }
                c5540j = f25217b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c5540j;
    }

    /* renamed from: b */
    public String m32580b(String str, String str2) {
        return AbstractC5538i0.m32572b(this.f25218a, str, str2);
    }

    /* renamed from: c */
    public C5537i m32581c(String str, String str2) {
        return new a(str, str2).m32497a(this.f25218a);
    }

    /* renamed from: d */
    public String m32582d(String str, String str2) {
        return AbstractC5530f1.m32513b(str, str2);
    }

    /* renamed from: e */
    public Pair<String, String> m32583e(String str, String str2) {
        if (!AbstractC5579z.m32833f(str, str2)) {
            return new Pair<>("", "");
        }
        String strM32553p = C5565s.m32733c().m32738b().m32553p();
        String strM32555q = C5565s.m32733c().m32738b().m32555q();
        if (!TextUtils.isEmpty(strM32553p) && !TextUtils.isEmpty(strM32555q)) {
            return new Pair<>(strM32553p, strM32555q);
        }
        Pair<String, String> pairM32820e = C5576x0.m32820e(this.f25218a);
        C5565s.m32733c().m32738b().m32544k((String) pairM32820e.first);
        C5565s.m32733c().m32738b().m32546l((String) pairM32820e.second);
        return pairM32820e;
    }

    /* renamed from: f */
    public String m32584f(String str, String str2) {
        return AbstractC5530f1.m32512a(str, str2);
    }

    /* renamed from: a */
    public String m32577a(String str, String str2) {
        return AbstractC5538i0.m32571a(this.f25218a, str, str2);
    }

    /* renamed from: a */
    public String m32578a(boolean z10) {
        if (!z10) {
            return "";
        }
        String strM32710e = AbstractC5562q0.m32710e();
        if (TextUtils.isEmpty(strM32710e)) {
            strM32710e = C5522d.m32476a(this.f25218a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(strM32710e)) {
                strM32710e = UUID.randomUUID().toString().replace("-", "");
                C5522d.m32481b(this.f25218a, "global_v2", "uuid", strM32710e);
            }
            AbstractC5562q0.m32717h(strM32710e);
        }
        return strM32710e;
    }

    /* renamed from: a */
    public void m32579a(Context context) {
        if (this.f25218a == null) {
            this.f25218a = context;
        }
    }
}
