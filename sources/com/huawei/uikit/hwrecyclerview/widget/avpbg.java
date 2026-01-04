package com.huawei.uikit.hwrecyclerview.widget;

import android.view.animation.AnimationUtils;
import com.huawei.dynamicanimation.C4681k;

/* loaded from: classes4.dex */
class avpbg extends C4681k {

    /* renamed from: e */
    private static final float f43933e = 0.001f;

    /* renamed from: f */
    private static final float f43934f = 1.0f;

    /* renamed from: g */
    private static final float f43935g = 1000.0f;

    /* renamed from: h */
    private static final long f43936h = -1;

    /* renamed from: a */
    private float f43937a;

    /* renamed from: b */
    private long f43938b;

    /* renamed from: c */
    private float f43939c;

    /* renamed from: d */
    private float f43940d;

    public avpbg(float f10, float f11, float f12, float f13, float f14) {
        super(f10, f11, f43933e);
        this.f43939c = f12;
        this.f43940d = f12;
        this.f43937a = f14;
        setValueThreshold(1.0f);
        snap(0.0f);
        setEndPosition(f13 - this.f43939c, f14, -1L);
        this.f43938b = AnimationUtils.currentAnimationTimeMillis();
    }

    /* renamed from: a */
    public float m55350a() {
        return this.f43940d;
    }

    /* renamed from: b */
    public float m55352b() {
        return this.f43937a;
    }

    /* renamed from: c */
    public boolean m55353c() {
        float fCurrentAnimationTimeMillis = (AnimationUtils.currentAnimationTimeMillis() - this.f43938b) / f43935g;
        this.f43937a = getVelocity(fCurrentAnimationTimeMillis);
        float position = getPosition(fCurrentAnimationTimeMillis);
        float f10 = this.f43939c;
        float f11 = position + f10;
        this.f43940d = f11;
        if (!isAtEquilibrium(f11 - f10, this.f43937a)) {
            return false;
        }
        this.f43940d = getEndPosition() + this.f43939c;
        this.f43937a = 0.0f;
        return true;
    }

    /* renamed from: a */
    public void m55351a(long j10) {
        this.f43938b -= j10;
    }
}
