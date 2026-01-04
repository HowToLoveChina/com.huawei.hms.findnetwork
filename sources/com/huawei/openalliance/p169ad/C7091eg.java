package com.huawei.openalliance.p169ad;

import android.opengl.Matrix;

/* renamed from: com.huawei.openalliance.ad.eg */
/* loaded from: classes8.dex */
public class C7091eg {

    /* renamed from: a */
    private static final float[] f32642a;

    /* renamed from: b */
    private final C7090ef f32643b;

    /* renamed from: d */
    private float f32645d;

    /* renamed from: e */
    private float f32646e;

    /* renamed from: f */
    private float f32647f;

    /* renamed from: g */
    private float f32648g;

    /* renamed from: c */
    private int f32644c = -1;

    /* renamed from: h */
    private final float[] f32649h = new float[16];

    /* renamed from: i */
    private boolean f32650i = false;

    /* renamed from: j */
    private final float[] f32651j = new float[16];

    static {
        float[] fArr = new float[16];
        f32642a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public C7091eg(C7090ef c7090ef) {
        this.f32643b = c7090ef;
    }

    /* renamed from: a */
    private void m42898a() {
        float[] fArr = this.f32649h;
        Matrix.setIdentityM(fArr, 0);
        Matrix.translateM(fArr, 0, this.f32647f, this.f32648g, 0.0f);
        Matrix.scaleM(fArr, 0, this.f32645d, this.f32646e, 1.0f);
        this.f32650i = true;
    }

    /* renamed from: b */
    public void m42903b(float f10, float f11) {
        this.f32647f = f10;
        this.f32648g = f11;
        this.f32650i = false;
    }

    /* renamed from: b */
    private float[] m42899b() {
        if (!this.f32650i) {
            m42898a();
        }
        return this.f32649h;
    }

    /* renamed from: a */
    public void m42900a(float f10, float f11) {
        this.f32645d = f10;
        this.f32646e = f11;
        this.f32650i = false;
    }

    /* renamed from: a */
    public void m42901a(int i10) {
        this.f32644c = i10;
    }

    /* renamed from: a */
    public void m42902a(C7092eh c7092eh, float[] fArr) {
        Matrix.multiplyMM(this.f32651j, 0, fArr, 0, m42899b(), 0);
        c7092eh.m42916a(new C7093ei(this.f32651j, this.f32643b.m42892a(), 0, this.f32643b.m42894c(), this.f32643b.m42897f(), this.f32643b.m42895d(), f32642a, this.f32643b.m42893b(), this.f32644c, this.f32643b.m42896e()));
    }
}
