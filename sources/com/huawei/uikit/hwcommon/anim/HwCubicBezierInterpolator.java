package com.huawei.uikit.hwcommon.anim;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.Interpolator;
import com.huawei.uikit.hwcommon.C8709R;

/* loaded from: classes7.dex */
public class HwCubicBezierInterpolator implements Interpolator {

    /* renamed from: e */
    static final long f42001e = 4000;

    /* renamed from: f */
    static final float f42002f = 2.5E-4f;

    /* renamed from: g */
    private static final String f42003g = "HwCubicBezierInterpolator";

    /* renamed from: h */
    private static final int f42004h = 3;

    /* renamed from: a */
    float f42005a;

    /* renamed from: b */
    float f42006b;

    /* renamed from: c */
    float f42007c;

    /* renamed from: d */
    float f42008d;

    public HwCubicBezierInterpolator(float f10, float f11, float f12, float f13) {
        this.f42005a = f10;
        this.f42006b = f11;
        this.f42007c = f12;
        this.f42008d = f13;
    }

    /* renamed from: a */
    private float m54201a(TypedValue typedValue) {
        if (typedValue == null) {
            return 1.0f;
        }
        int i10 = typedValue.type;
        if (i10 == 6) {
            return TypedValue.complexToFloat(typedValue.data);
        }
        if (i10 == 4) {
            return typedValue.getFloat();
        }
        if (i10 < 16 || i10 > 31) {
            return 1.0f;
        }
        return typedValue.data;
    }

    /* renamed from: b */
    private float m54202b(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f11 * f12 * f10 * this.f42005a) + (f12 * f10 * f10 * this.f42007c) + (f10 * f10 * f10);
    }

    public float getCubicBezierY(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f11 * f12 * f10 * this.f42006b) + (f12 * f10 * f10 * this.f42008d) + (f10 * f10 * f10);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return getCubicBezierY(m54203a(f10) * f42002f);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(f42003g);
        stringBuffer.append("  mControlPoint1x = ");
        stringBuffer.append(this.f42005a);
        stringBuffer.append(", mControlPoint1y = ");
        stringBuffer.append(this.f42006b);
        stringBuffer.append(", mControlPoint2x = ");
        stringBuffer.append(this.f42007c);
        stringBuffer.append(", mControlPoint2y = ");
        stringBuffer.append(this.f42008d);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public long m54203a(float f10) {
        long j10 = 0;
        long j11 = f42001e;
        while (j10 <= j11) {
            long j12 = (j10 + j11) >>> 1;
            float fM54202b = m54202b(j12 * f42002f);
            if (fM54202b < f10) {
                j10 = j12 + 1;
            } else {
                if (fM54202b <= f10) {
                    return j12;
                }
                j11 = j12 - 1;
            }
        }
        return j10;
    }

    public HwCubicBezierInterpolator(Context context, AttributeSet attributeSet) {
        this(context.getResources(), context.getTheme(), attributeSet);
    }

    public HwCubicBezierInterpolator(Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes;
        this.f42005a = 0.0f;
        this.f42006b = 0.0f;
        this.f42007c = 0.0f;
        this.f42008d = 0.0f;
        if (theme != null) {
            typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, C8709R.styleable.HwTranslateAnimation, 0, 0);
        } else {
            typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, C8709R.styleable.HwTranslateAnimation);
        }
        this.f42005a = m54201a(typedArrayObtainAttributes.peekValue(C8709R.styleable.HwTranslateAnimation_hwFromXDelta));
        this.f42006b = m54201a(typedArrayObtainAttributes.peekValue(C8709R.styleable.HwTranslateAnimation_hwFromYDelta));
        this.f42007c = m54201a(typedArrayObtainAttributes.peekValue(C8709R.styleable.HwTranslateAnimation_hwToXDelta));
        this.f42008d = m54201a(typedArrayObtainAttributes.peekValue(C8709R.styleable.HwTranslateAnimation_hwToYDelta));
        typedArrayObtainAttributes.recycle();
    }
}
