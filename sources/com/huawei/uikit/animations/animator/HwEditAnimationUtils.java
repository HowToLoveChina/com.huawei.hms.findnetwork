package com.huawei.uikit.animations.animator;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AnimationUtils;
import com.huawei.uikit.hwanimations.C8701R;

/* loaded from: classes6.dex */
public class HwEditAnimationUtils {

    /* renamed from: a */
    private static final long f40721a = 350;

    /* renamed from: b */
    private static final float f40722b = 0.0f;

    /* renamed from: c */
    private static final float f40723c = 1.0f;

    private HwEditAnimationUtils() {
    }

    public static ValueAnimator getAlphaAnimator(Context context, boolean z10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(z10 ? 1.0f : 0.0f, z10 ? 0.0f : 1.0f);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, C8701R.interpolator.cubic_bezier_interpolator_type_33_33));
        valueAnimatorOfFloat.setDuration(f40721a);
        return valueAnimatorOfFloat;
    }

    public static AnimatorSet getEditAnimator(Context context, boolean z10, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener2) {
        ValueAnimator transAnimator = getTransAnimator(context, z10);
        if (animatorUpdateListener2 != null) {
            transAnimator.addUpdateListener(animatorUpdateListener2);
        }
        ValueAnimator alphaAnimator = getAlphaAnimator(context, z10);
        if (animatorUpdateListener != null) {
            alphaAnimator.addUpdateListener(animatorUpdateListener);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alphaAnimator, transAnimator);
        return animatorSet;
    }

    public static ValueAnimator getTransAnimator(Context context, boolean z10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(z10 ? 1.0f : 0.0f, z10 ? 0.0f : 1.0f);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.loadInterpolator(context, C8701R.interpolator.cubic_bezier_interpolator_type_20_80));
        valueAnimatorOfFloat.setDuration(f40721a);
        return valueAnimatorOfFloat;
    }
}
