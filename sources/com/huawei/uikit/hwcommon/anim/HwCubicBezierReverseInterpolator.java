package com.huawei.uikit.hwcommon.anim;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

/* loaded from: classes7.dex */
public class HwCubicBezierReverseInterpolator extends HwCubicBezierInterpolator {
    public HwCubicBezierReverseInterpolator(float f10, float f11, float f12, float f13) {
        super(f10, f11, f12, f13);
    }

    @Override // com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return 1.0f - getCubicBezierY(m54203a(1.0f - f10) * 2.5E-4f);
    }

    public HwCubicBezierReverseInterpolator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HwCubicBezierReverseInterpolator(Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        super(resources, theme, attributeSet);
    }
}
