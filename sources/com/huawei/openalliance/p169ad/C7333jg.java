package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.jg */
/* loaded from: classes8.dex */
public class C7333jg {

    /* renamed from: a */
    private boolean f34164a = false;

    /* renamed from: b */
    private boolean f34165b = false;

    /* renamed from: c */
    private long f34166c = 0;

    /* renamed from: d */
    private long f34167d = 0;

    /* renamed from: e */
    private String f34168e;

    public C7333jg(String str) {
        this.f34168e = "VideoMonitor_" + str;
    }

    /* renamed from: a */
    public void m45288a() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(this.f34168e, "onPlayStart");
        }
        if (this.f34165b) {
            return;
        }
        this.f34165b = true;
        this.f34167d = System.currentTimeMillis();
    }

    /* renamed from: b */
    public void m45289b() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(this.f34168e, "onBufferStart");
        }
        if (this.f34164a) {
            return;
        }
        this.f34164a = true;
        this.f34166c = System.currentTimeMillis();
    }

    /* renamed from: c */
    public void m45290c() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(this.f34168e, "onVideoEnd");
        }
        this.f34165b = false;
        this.f34164a = false;
        this.f34166c = 0L;
        this.f34167d = 0L;
    }

    /* renamed from: d */
    public long m45291d() {
        return this.f34166c;
    }

    /* renamed from: e */
    public long m45292e() {
        return this.f34167d;
    }
}
