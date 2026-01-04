package com.huawei.openalliance.p169ad;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;

/* renamed from: com.huawei.openalliance.ad.ee */
/* loaded from: classes8.dex */
public class C7089ee {

    /* renamed from: a */
    private final C7088ed f32632a;

    /* renamed from: b */
    private EGLSurface f32633b;

    public C7089ee(C7088ed c7088ed, Surface surface) {
        this.f32632a = c7088ed;
        this.f32633b = c7088ed.m42880a(surface);
    }

    /* renamed from: a */
    public int m42886a() {
        return this.f32632a.m42879a(this.f32633b, 12375);
    }

    /* renamed from: b */
    public int m42887b() {
        return this.f32632a.m42879a(this.f32633b, 12374);
    }

    /* renamed from: c */
    public void m42888c() {
        this.f32632a.m42884b(this.f32633b);
    }

    /* renamed from: d */
    public void m42889d() {
        this.f32632a.m42885c(this.f32633b);
    }

    /* renamed from: e */
    public void m42890e() {
        this.f32632a.m42882a(this.f32633b);
        this.f32633b = EGL14.EGL_NO_SURFACE;
    }
}
