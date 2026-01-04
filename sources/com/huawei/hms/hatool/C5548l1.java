package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.l1 */
/* loaded from: classes8.dex */
public class C5548l1 {

    /* renamed from: a */
    private C5566s0 f25249a;

    /* renamed from: b */
    private C5566s0 f25250b;

    /* renamed from: c */
    private C5566s0 f25251c;

    /* renamed from: d */
    private C5566s0 f25252d;

    public C5548l1(String str) {
    }

    /* renamed from: a */
    public C5566s0 m32626a() {
        return this.f25251c;
    }

    /* renamed from: b */
    public C5566s0 m32629b() {
        return this.f25249a;
    }

    /* renamed from: c */
    public C5566s0 m32631c() {
        return this.f25250b;
    }

    /* renamed from: d */
    public C5566s0 m32632d() {
        return this.f25252d;
    }

    /* renamed from: a */
    public C5566s0 m32627a(String str) {
        if (str.equals("oper")) {
            return m32631c();
        }
        if (str.equals("maint")) {
            return m32629b();
        }
        if (str.equals("diffprivacy")) {
            return m32626a();
        }
        if (str.equals("preins")) {
            return m32632d();
        }
        C5571v.m32797f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    /* renamed from: b */
    public void m32630b(C5566s0 c5566s0) {
        this.f25250b = c5566s0;
    }

    /* renamed from: a */
    public void m32628a(C5566s0 c5566s0) {
        this.f25249a = c5566s0;
    }
}
