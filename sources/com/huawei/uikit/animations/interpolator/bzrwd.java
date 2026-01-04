package com.huawei.uikit.animations.interpolator;

import android.view.animation.Interpolator;

/* loaded from: classes6.dex */
abstract class bzrwd implements Interpolator {

    /* renamed from: c */
    private static final int f41036c = 2;

    /* renamed from: a */
    private final float[] f41037a;

    /* renamed from: b */
    private final float f41038b;

    public bzrwd(float[] fArr) {
        this.f41037a = fArr;
        if (fArr.length > 1) {
            this.f41038b = 1.0f / (fArr.length - 1);
        } else {
            this.f41038b = 0.0f;
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (Float.compare(f10, 1.0f) >= 0) {
            return 1.0f;
        }
        if (Float.compare(f10, 0.0f) <= 0) {
            return 0.0f;
        }
        float[] fArr = this.f41037a;
        if (fArr.length <= 1) {
            if (fArr.length > 0) {
                return fArr[0];
            }
            return 0.0f;
        }
        int length = (int) ((fArr.length - 1) * f10);
        int length2 = fArr.length - 2;
        if (length >= length2) {
            length = length2;
        }
        float f11 = this.f41038b;
        float f12 = Float.compare(f11, 0.0f) != 0 ? (f10 - (length * f11)) / this.f41038b : 0.0f;
        float[] fArr2 = this.f41037a;
        float f13 = fArr2[length];
        return f13 + (f12 * (fArr2[length + 1] - f13));
    }
}
