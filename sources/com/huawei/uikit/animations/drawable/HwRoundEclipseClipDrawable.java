package com.huawei.uikit.animations.drawable;

import android.graphics.drawable.Drawable;

/* loaded from: classes6.dex */
public class HwRoundEclipseClipDrawable extends HwRoundRectEclipseClipDrawable {

    /* renamed from: x */
    private static final float f40964x = 0.5f;

    public HwRoundEclipseClipDrawable(Drawable drawable, int i10, int i11) {
        super(drawable, i10, i11);
    }

    @Override // com.huawei.uikit.animations.drawable.HwRoundRectEclipseClipDrawable
    public float getProgressRatioLeftRoundEnd() {
        return f40964x;
    }

    @Override // com.huawei.uikit.animations.drawable.HwRoundRectEclipseClipDrawable
    public float getProgressRationRightRoundBegin() {
        return f40964x;
    }
}
