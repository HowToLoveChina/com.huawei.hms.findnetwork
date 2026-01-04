package com.huawei.openalliance.p169ad;

import android.view.animation.Interpolator;

/* renamed from: com.huawei.openalliance.ad.gq */
/* loaded from: classes8.dex */
public class InterpolatorC7160gq implements Interpolator {

    /* renamed from: a */
    float f32955a;

    /* renamed from: b */
    float f32956b;

    /* renamed from: c */
    float f32957c;

    /* renamed from: d */
    float f32958d;

    public InterpolatorC7160gq(float f10, float f11, float f12, float f13) {
        this.f32955a = f10;
        this.f32956b = f11;
        this.f32957c = f12;
        this.f32958d = f13;
        AbstractC7185ho.m43817a("CubicBezierInterpolator", toString());
    }

    /* renamed from: c */
    private float m43607c(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f11 * f12 * f10 * this.f32955a) + (f12 * f10 * f10 * this.f32957c) + (f10 * f10 * f10);
    }

    /* renamed from: a */
    public float m43608a(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f11 * f12 * f10 * this.f32956b) + (f12 * f10 * f10 * this.f32958d) + (f10 * f10 * f10);
    }

    /* renamed from: b */
    public long m43609b(float f10) {
        long j10 = 0;
        long j11 = 4000;
        while (j10 <= j11) {
            long j12 = (j10 + j11) >>> 1;
            float fM43607c = m43607c(j12 * 2.5E-4f);
            if (fM43607c < f10) {
                j10 = j12 + 1;
            } else {
                if (fM43607c <= f10) {
                    return j12;
                }
                j11 = j12 - 1;
            }
        }
        return j10;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return m43608a(m43609b(f10) * 2.5E-4f);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("CubicBezierInterpolator");
        stringBuffer.append("  mControlPoint1x = ");
        stringBuffer.append(this.f32955a);
        stringBuffer.append(", mControlPoint1y = ");
        stringBuffer.append(this.f32956b);
        stringBuffer.append(", mControlPoint2x = ");
        stringBuffer.append(this.f32957c);
        stringBuffer.append(", mControlPoint2y = ");
        stringBuffer.append(this.f32958d);
        return stringBuffer.toString();
    }
}
