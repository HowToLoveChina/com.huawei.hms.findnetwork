package com.huawei.uikit.animations.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.uikit.animations.interpolator.HwInterpolatorBuilder;

/* loaded from: classes6.dex */
public class HwHoverAnimationUtils {

    /* renamed from: a */
    private static final int f40724a = 250;

    /* renamed from: b */
    private static final int f40725b = 0;

    /* renamed from: c */
    private static final int f40726c = 255;

    private HwHoverAnimationUtils() {
    }

    public static ValueAnimator getAlphaAnimator(int i10, boolean z10) {
        return getAlphaAnimator(i10, z10 ? 0 : 255);
    }

    public static Animator getScaleAnimator(View view, float f10) {
        Interpolator interpolatorCreateFrictionCurveInterpolator = HwInterpolatorBuilder.createFrictionCurveInterpolator();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, TopAnimatorConfig.AnimatorType.SCALE_X, view.getScaleX(), f10);
        objectAnimatorOfFloat.setInterpolator(interpolatorCreateFrictionCurveInterpolator);
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.setAutoCancel(true);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, TopAnimatorConfig.AnimatorType.SCALE_Y, view.getScaleY(), f10);
        objectAnimatorOfFloat2.setInterpolator(interpolatorCreateFrictionCurveInterpolator);
        objectAnimatorOfFloat2.setDuration(250L);
        objectAnimatorOfFloat2.setAutoCancel(true);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        return animatorSet;
    }

    public static ValueAnimator getAlphaAnimator(int i10, int i11) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i10, i11);
        valueAnimatorOfInt.setInterpolator(HwInterpolatorBuilder.createFrictionCurveInterpolator());
        valueAnimatorOfInt.setDuration(250L);
        return valueAnimatorOfInt;
    }
}
