package com.huawei.dynamicanimation;

import android.util.Log;
import p524oj.C11907b;

/* renamed from: com.huawei.dynamicanimation.c */
/* loaded from: classes5.dex */
public class C4673c extends AbstractC4679i {

    /* renamed from: i */
    public float f21541i;

    /* renamed from: j */
    public float f21542j;

    /* renamed from: k */
    public float f21543k;

    /* renamed from: l */
    public float f21544l;

    /* renamed from: m */
    public float f21545m;

    /* renamed from: n */
    public float f21546n;

    /* renamed from: o */
    public boolean f21547o;

    public C4673c(float f10, float f11) {
        this(f10, f11, 0.75f);
    }

    /* renamed from: d */
    public final void m28677d() {
        if (this.f21547o) {
            m28678e();
            float fLog = ((float) (Math.log(this.mVelocityThreshold / this.f21541i) / this.f21542j)) * 1000.0f;
            this.f21543k = fLog;
            float fMax = Math.max(fLog, 0.0f);
            this.f21543k = fMax;
            this.f21544l = getPosition(fMax / 1000.0f);
            this.f21547o = false;
            Log.i("FlingModelBase", "reset: estimateTime=" + this.f21543k + ",estimateValue=" + this.f21544l);
        }
    }

    /* renamed from: e */
    public void m28678e() {
        if (C11907b.m71441a(this.f21541i)) {
            throw new UnsupportedOperationException("InitVelocity should be set and can not be 0!!");
        }
        if (C11907b.m71441a(this.f21542j)) {
            throw new UnsupportedOperationException("Friction should be set and can not be 0!!");
        }
    }

    /* renamed from: f */
    public final <T extends AbstractC4679i> T m28679f(float f10) {
        this.f21542j = f10 * (-4.2f);
        this.f21547o = true;
        return this;
    }

    /* renamed from: g */
    public final <T extends AbstractC4679i> T m28680g(float f10) {
        this.f21541i = Math.abs(f10);
        this.f21546n = Math.signum(f10);
        this.f21547o = true;
        return this;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getAcceleration() {
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getEndPosition() {
        m28677d();
        return this.f21544l;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getEstimatedDuration() {
        m28677d();
        return this.f21543k;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getMaxAbsX() {
        m28677d();
        return this.f21544l;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getPosition(float f10) {
        this.f21545m = f10;
        float f11 = this.f21546n;
        float f12 = this.f21541i;
        float f13 = this.f21542j;
        return f11 * ((float) ((f12 / f13) * (Math.exp(f13 * f10) - 1.0d)));
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getVelocity(float f10) {
        return this.f21546n * ((float) (this.f21541i * Math.exp(this.f21542j * f10)));
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public boolean isAtEquilibrium(float f10) {
        return false;
    }

    public C4673c(float f10, float f11, float f12) {
        this.f21545m = 0.0f;
        this.f21547o = true;
        super.setValueThreshold(f12);
        m28680g(f10);
        m28679f(f11);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getAcceleration(float f10) {
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getVelocity() {
        return getVelocity(this.f21545m);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public boolean isAtEquilibrium() {
        return this.f21541i < this.mVelocityThreshold;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public final AbstractC4679i setValueThreshold(float f10) {
        super.setValueThreshold(f10);
        this.f21547o = true;
        return this;
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public float getPosition() {
        return getPosition(this.f21545m);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4679i
    public boolean isAtEquilibrium(float f10, float f11) {
        return Math.abs(f10 - getEndPosition()) < this.mValueThreshold && Math.abs(f11) < this.mVelocityThreshold;
    }
}
