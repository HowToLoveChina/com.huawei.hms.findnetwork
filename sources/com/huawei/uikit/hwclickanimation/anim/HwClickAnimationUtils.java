package com.huawei.uikit.hwclickanimation.anim;

import android.animation.AnimatorSet;
import android.view.View;
import p493nj.C11716c;

/* loaded from: classes7.dex */
public class HwClickAnimationUtils {
    public static final int EFFECT_HEAVY = 0;
    public static final int EFFECT_LIGHT = 2;
    public static final int EFFECT_MIDDLE = 1;

    /* renamed from: a */
    private static final float f41673a = 240.0f;

    /* renamed from: b */
    private static final float f41674b = 28.0f;

    /* renamed from: c */
    private static final float f41675c = 0.0f;

    /* renamed from: d */
    private static final float f41676d = 0.95f;

    /* renamed from: e */
    private static final float f41677e = 350.0f;

    /* renamed from: f */
    private static final float f41678f = 35.0f;

    /* renamed from: g */
    private static final float f41679g = 0.5f;

    /* renamed from: h */
    private static final float f41680h = 0.95f;

    /* renamed from: i */
    private static final float f41681i = 410.0f;

    /* renamed from: j */
    private static final float f41682j = 38.0f;

    /* renamed from: k */
    private static final float f41683k = 1.0f;

    /* renamed from: l */
    private static final float f41684l = 0.9f;

    /* renamed from: m */
    private static final float f41685m = 0.002f;

    private HwClickAnimationUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0009 A[PHI: r3
  0x0009: PHI (r3v5 float) = (r3v0 float), (r3v1 float) binds: [B:3:0x0007, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.animation.AnimatorSet m54088a(android.view.View r8, int r9, float r10) {
        /*
            r0 = 1
            r1 = 0
            r2 = 2
            r3 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r4 <= 0) goto Lb
        L9:
            r10 = r3
            goto L11
        Lb:
            r3 = 0
            int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r4 >= 0) goto L11
            goto L9
        L11:
            float r3 = r8.getScaleX()
            nj.c r9 = getSpringInterpolatorByType(r3, r10, r9)
            float r3 = r9.m69894b()
            long r3 = (long) r3
            float r5 = r8.getScaleX()
            float[] r6 = new float[r2]
            r6[r1] = r5
            r6[r0] = r10
            java.lang.String r5 = "scaleX"
            android.animation.ObjectAnimator r5 = android.animation.ObjectAnimator.ofFloat(r8, r5, r6)
            r5.setInterpolator(r9)
            r5.setDuration(r3)
            float r6 = r8.getScaleY()
            float[] r7 = new float[r2]
            r7[r1] = r6
            r7[r0] = r10
            java.lang.String r10 = "scaleY"
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r10, r7)
            r8.setInterpolator(r9)
            r8.setDuration(r3)
            android.animation.AnimatorSet r9 = new android.animation.AnimatorSet
            r9.<init>()
            android.animation.Animator[] r10 = new android.animation.Animator[r2]
            r10[r1] = r5
            r10[r0] = r8
            r9.playTogether(r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwclickanimation.anim.HwClickAnimationUtils.m54088a(android.view.View, int, float):android.animation.AnimatorSet");
    }

    public static AnimatorSet getActionDownAnimation(View view, int i10) {
        return m54088a(view, i10, (i10 == 0 || i10 == 1 || i10 != 2) ? 0.95f : 0.9f);
    }

    public static AnimatorSet getActionUpAnimation(View view, int i10) {
        return m54088a(view, i10, 1.0f);
    }

    public static C11716c getSpringInterpolatorByType(float f10, float f11, int i10) {
        float fAbs = Math.abs(f10 - f11);
        if (Float.compare(fAbs, 0.0f) == 0) {
            fAbs = 0.050000012f;
        }
        float f12 = fAbs;
        if (i10 == 0) {
            return new C11716c(f41673a, f41674b, f12, 0.0f, f41685m);
        }
        if (i10 != 1 && i10 == 2) {
            return new C11716c(f41681i, f41682j, f12, 1.0f, f41685m);
        }
        return new C11716c(f41677e, f41678f, f12, f41679g, f41685m);
    }

    public static AnimatorSet getActionDownAnimation(View view, int i10, float f10) {
        return m54088a(view, i10, f10);
    }
}
