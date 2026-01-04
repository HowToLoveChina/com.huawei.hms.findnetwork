package com.huawei.uikit.hwcommon.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: classes7.dex */
public class HwFocusClickAnimatorUtil {

    /* renamed from: a */
    private static final String f42012a = "scaleY";

    /* renamed from: b */
    private static final String f42013b = "scaleX";

    /* renamed from: c */
    private static final int f42014c = 100;

    /* renamed from: d */
    private static final float f42015d = 1.05f;

    /* renamed from: e */
    private static final float f42016e = 1.0f;

    /* renamed from: f */
    private static final float f42017f = 0.95f;

    /* renamed from: g */
    private static final float f42018g = 0.2f;

    /* renamed from: h */
    private static final float f42019h = 0.0f;

    /* renamed from: i */
    private static final float f42020i = 0.2f;

    /* renamed from: j */
    private static final float f42021j = 1.0f;

    private HwFocusClickAnimatorUtil() {
    }

    public static AnimatorSet getClickAnimatorSet(View view) {
        return getClickAnimatorSet(view, f42015d, 0.95f);
    }

    public static ValueAnimator getEnterFocusedAnimator(View view) {
        return getEnterFocusedAnimator(view, f42015d);
    }

    public static ValueAnimator getExitFocusedAnimator(View view) {
        return getExitFocusedAnimator(view, f42015d);
    }

    public static HwCubicBezierInterpolator getFrictionInterpolator() {
        return new HwCubicBezierInterpolator(0.2f, 0.0f, 0.2f, 1.0f);
    }

    public static AnimatorSet getClickAnimatorSet(View view, float f10, float f11) {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("scaleX", f10, f11);
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("scaleY", f10, f11);
        PropertyValuesHolder propertyValuesHolderOfFloat3 = PropertyValuesHolder.ofFloat("scaleX", f11, f10);
        PropertyValuesHolder propertyValuesHolderOfFloat4 = PropertyValuesHolder.ofFloat("scaleY", f11, f10);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat2, propertyValuesHolderOfFloat);
        HwCubicBezierInterpolator frictionInterpolator = getFrictionInterpolator();
        objectAnimatorOfPropertyValuesHolder.setInterpolator(frictionInterpolator);
        objectAnimatorOfPropertyValuesHolder.setDuration(100L);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat4, propertyValuesHolderOfFloat3);
        objectAnimatorOfPropertyValuesHolder2.setInterpolator(frictionInterpolator);
        objectAnimatorOfPropertyValuesHolder2.setDuration(100L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfPropertyValuesHolder).before(objectAnimatorOfPropertyValuesHolder2);
        return animatorSet;
    }

    public static ValueAnimator getEnterFocusedAnimator(View view, float f10) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleY", 1.0f, f10), PropertyValuesHolder.ofFloat("scaleX", 1.0f, f10));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(getFrictionInterpolator());
        objectAnimatorOfPropertyValuesHolder.setDuration(100L);
        return objectAnimatorOfPropertyValuesHolder;
    }

    public static ValueAnimator getExitFocusedAnimator(View view, float f10) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("scaleY", f10, 1.0f), PropertyValuesHolder.ofFloat("scaleX", f10, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(getFrictionInterpolator());
        objectAnimatorOfPropertyValuesHolder.setDuration(100L);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
