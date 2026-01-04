package com.huawei.openalliance.p169ad.views.interfaces;

/* renamed from: com.huawei.openalliance.ad.views.interfaces.b */
/* loaded from: classes2.dex */
public class C8109b {

    /* renamed from: a */
    private boolean f37918a;

    /* renamed from: b */
    private boolean f37919b;

    /* renamed from: c */
    private String f37920c;

    /* renamed from: d */
    private Integer f37921d;

    /* renamed from: e */
    private Integer f37922e;

    public C8109b(boolean z10, boolean z11, String str) {
        this.f37922e = 0;
        this.f37918a = z10;
        this.f37919b = z11;
        this.f37920c = str;
    }

    /* renamed from: a */
    public void m50301a(Integer num) {
        this.f37922e = num;
    }

    /* renamed from: b */
    public boolean m50303b() {
        return this.f37919b;
    }

    /* renamed from: c */
    public String m50304c() {
        return this.f37920c;
    }

    /* renamed from: d */
    public Integer m50305d() {
        return this.f37921d;
    }

    /* renamed from: e */
    public Integer m50306e() {
        return this.f37922e;
    }

    public C8109b(boolean z10, boolean z11, String str, int i10) {
        this(z10, z11, str);
        this.f37921d = Integer.valueOf(i10);
    }

    /* renamed from: a */
    public boolean m50302a() {
        return this.f37918a;
    }
}
