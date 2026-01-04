package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.hp */
/* loaded from: classes8.dex */
public class C7186hp {

    /* renamed from: a */
    private static InterfaceC7199ht f33089a = C7200hu.m43876a();

    /* renamed from: d */
    private String f33092d;

    /* renamed from: b */
    private int f33090b = 4;

    /* renamed from: c */
    private Integer f33091c = null;

    /* renamed from: e */
    private boolean f33093e = false;

    /* renamed from: c */
    private C7201hv m43830c(int i10, String str, String str2) {
        C7201hv c7201hv = new C7201hv(this.f33092d, i10, str);
        c7201hv.m43880a((C7201hv) str2);
        return c7201hv;
    }

    /* renamed from: a */
    public void m43831a(int i10, String str, String str2) {
        this.f33090b = i10;
        this.f33092d = str2;
        f33089a.mo43809a(str, "HiAdSDKLog");
        this.f33093e = true;
    }

    /* renamed from: b */
    public void m43837b(int i10, String str, String str2) {
        if (m43836a(i10)) {
            String str3 = "HiAdSDK." + str;
            f33089a.mo43810a(m43830c(i10, str3, str2), i10, str3);
        }
    }

    /* renamed from: a */
    public void m43832a(int i10, String str, String str2, Throwable th2) {
        if (th2 != null) {
            m43836a(i10);
        }
    }

    /* renamed from: a */
    public void m43833a(int i10, String str, Throwable th2) {
        if (th2 != null) {
            m43836a(i10);
        }
    }

    /* renamed from: a */
    public void m43834a(Integer num) {
        this.f33091c = num;
    }

    /* renamed from: a */
    public void m43835a(String str, String str2) {
        f33089a.mo43810a(m43830c(4, str, str2), 4, str);
    }

    /* renamed from: a */
    public boolean m43836a(int i10) {
        Integer num = this.f33091c;
        return num == null ? this.f33093e && i10 >= this.f33090b : this.f33093e && i10 >= num.intValue();
    }
}
