package com.huawei.uikit.hwrecyclerview.layoutmanager;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class HwFloatingBubblesAnimatorParams {

    /* renamed from: h */
    private static final int f43259h = 45;

    /* renamed from: i */
    private static final float f43260i = 1.5f;

    /* renamed from: j */
    private static final float f43261j = 0.0f;

    /* renamed from: k */
    private static final float f43262k = 1.05f;

    /* renamed from: l */
    private static final float f43263l = 0.6f;

    /* renamed from: m */
    private static final float f43264m = 3.0f;

    /* renamed from: a */
    private int f43265a = 45;

    /* renamed from: b */
    private float f43266b = f43260i;

    /* renamed from: c */
    private float f43267c = 0.0f;

    /* renamed from: d */
    private float f43268d = f43262k;

    /* renamed from: e */
    private float f43269e = 0.6f;

    /* renamed from: f */
    private int f43270f = 0;

    /* renamed from: g */
    private long f43271g = 0;

    /* renamed from: a */
    private float m54802a(float f10, float f11, float f12, float f13) {
        return (Float.compare(f10, f12) > 0 && Float.compare(f10, f13) < 0) ? f10 : f11;
    }

    public int getInitialCenterPosition() {
        return this.f43270f;
    }

    public float getMaxCoverFactor() {
        return this.f43267c;
    }

    public int getMaxMargin() {
        return this.f43265a;
    }

    public float getMaxScale() {
        return this.f43266b;
    }

    public float getSelectedScaleRelativeOther() {
        return this.f43268d;
    }

    public long getSelectedTime() {
        return this.f43271g;
    }

    public float getVisibleCriticalOffsetY() {
        return this.f43269e;
    }

    public void resetSelectedTime() {
        this.f43271g = SystemClock.uptimeMillis();
    }

    public void setCriticalOffsetFactors(float f10) {
        this.f43269e = m54802a(f10, 0.6f, 0.0f, 1.0f);
    }

    public void setInitialCenterPosition(int i10) {
        this.f43270f = i10;
    }

    public void setMaxCoverFactor(float f10) {
        this.f43267c = m54802a(f10, 0.0f, 0.0f, 1.0f);
    }

    public void setMaxMargin(int i10) {
        if (i10 <= 0) {
            i10 = 45;
        }
        this.f43265a = i10;
    }

    public void setMaxScale(float f10) {
        this.f43266b = m54802a(f10, f43260i, 1.0f, f43264m);
    }

    public void setSelectedScaleRelativeOther(float f10) {
        this.f43268d = m54802a(f10, f43262k, 1.0f, f43264m);
    }
}
