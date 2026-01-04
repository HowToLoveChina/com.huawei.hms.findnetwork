package com.huawei.hms.hatool;

import gu.C10048b;

/* renamed from: com.huawei.hms.hatool.m1 */
/* loaded from: classes8.dex */
public class C5551m1 {

    /* renamed from: b */
    private static C5551m1 f25258b = new C5551m1();

    /* renamed from: a */
    private a f25259a = new a();

    /* renamed from: com.huawei.hms.hatool.m1$a */
    public class a {

        /* renamed from: a */
        String f25260a;

        /* renamed from: b */
        String f25261b;

        /* renamed from: c */
        long f25262c = 0;

        public a() {
        }

        /* renamed from: a */
        public void m32648a(long j10) {
            C5551m1.this.f25259a.f25262c = j10;
        }

        /* renamed from: b */
        public void m32650b(String str) {
            C5551m1.this.f25259a.f25260a = str;
        }

        /* renamed from: a */
        public void m32649a(String str) {
            C5551m1.this.f25259a.f25261b = str;
        }
    }

    /* renamed from: d */
    public static C5551m1 m32643d() {
        return f25258b;
    }

    /* renamed from: b */
    public long m32646b() {
        return this.f25259a.f25262c;
    }

    /* renamed from: c */
    public String m32647c() {
        return this.f25259a.f25260a;
    }

    /* renamed from: a */
    public String m32644a() {
        return this.f25259a.f25261b;
    }

    /* renamed from: a */
    public void m32645a(String str, String str2) {
        long jM32646b = m32646b();
        String strM32807c = C5574w0.m32807c(str, str2);
        if (strM32807c == null || strM32807c.isEmpty()) {
            C5571v.m32796e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (jM32646b == 0) {
            jM32646b = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - jM32646b <= 43200000) {
            return;
        }
        String strM62473e = C10048b.m62473e(16);
        String strM32560a = C5535h0.m32560a(strM32807c, strM62473e);
        this.f25259a.m32648a(jM32646b);
        this.f25259a.m32650b(strM62473e);
        this.f25259a.m32649a(strM32560a);
    }
}
