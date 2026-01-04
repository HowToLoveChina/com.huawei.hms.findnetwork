package com.huawei.uikit.animations.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable;
import com.huawei.uikit.hwanimations.C8701R;
import p322h0.C10076a;

/* loaded from: classes6.dex */
public class HwSeekableGravitationalLoadingDrawable extends HwGravitationalLoadingDrawable {
    public static final float MAX_DRAWABLE_LEVEL = 10000.0f;

    /* renamed from: N */
    private static final String f40996N = "HwSeekableLoadingAnim";

    /* renamed from: O */
    private static final float f40997O = -8.0f;

    /* renamed from: P */
    private static final float f40998P = 15.0f;

    /* renamed from: Q */
    private static final float f40999Q = 0.4f;

    /* renamed from: I */
    private ValueAnimator f41000I;

    /* renamed from: J */
    private ValueAnimator f41001J;

    /* renamed from: K */
    private ValueAnimator f41002K;

    /* renamed from: L */
    private boolean f41003L;

    /* renamed from: M */
    private boolean f41004M;

    public class aauaf implements ValueAnimator.AnimatorUpdateListener {
        public aauaf() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwSeekableGravitationalLoadingDrawable.f40996N, "onAnimationUpdate: null animator");
            } else {
                HwSeekableGravitationalLoadingDrawable.this.f40810b.m53710a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                HwSeekableGravitationalLoadingDrawable.this.invalidateSelf();
            }
        }
    }

    public class bqmxo extends AnimatorListenerAdapter {
        public bqmxo() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HwSeekableGravitationalLoadingDrawable.this.f41002K.start();
            HwSeekableGravitationalLoadingDrawable.super.m53645a(false);
        }
    }

    public class bzrwd implements ValueAnimator.AnimatorUpdateListener {
        public bzrwd() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.e(HwSeekableGravitationalLoadingDrawable.f40996N, "onAnimationUpdate:null animator");
            } else {
                HwSeekableGravitationalLoadingDrawable.this.f40810b.m53713b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                HwSeekableGravitationalLoadingDrawable.this.invalidateSelf();
            }
        }
    }

    public HwSeekableGravitationalLoadingDrawable(HwGravitationalLoadingDrawable.awsks awsksVar, HwGravitationalLoadingDrawable.brnby brnbyVar, int i10, float f10) {
        super(awsksVar, brnbyVar, i10, f10);
        this.f41003L = true;
        this.f41004M = false;
        m53776b();
        this.f40810b.m53713b(0.0f);
    }

    /* renamed from: b */
    private void m53776b() {
        m53777c();
        m53779d();
        m53780e();
    }

    /* renamed from: c */
    private void m53777c() {
        this.f41000I = akxao.m53781a(f40997O, 15.0f);
    }

    public static HwSeekableGravitationalLoadingDrawable create(int i10, HwGravitationalLoadingDrawable.ParamsBundle paramsBundle, DisplayMetrics displayMetrics, int i11) {
        if (i11 <= 0) {
            i11 = 1200;
        }
        int iM53633a = HwGravitationalLoadingDrawable.m53633a(i10);
        return new HwSeekableGravitationalLoadingDrawable(HwGravitationalLoadingDrawable.m53640b(iM53633a, paramsBundle), HwGravitationalLoadingDrawable.m53637a(iM53633a, paramsBundle), i11, displayMetrics.density);
    }

    /* renamed from: d */
    private void m53779d() {
        ValueAnimator valueAnimatorM53783b = akxao.m53783b(15.0f, 35.0f);
        this.f41001J = valueAnimatorM53783b;
        valueAnimatorM53783b.addUpdateListener(new aauaf());
        this.f41001J.addListener(new bqmxo());
    }

    /* renamed from: e */
    private void m53780e() {
        ValueAnimator valueAnimatorM53782a = akxao.m53782a(60.0f, 480L);
        this.f41002K = valueAnimatorM53782a;
        valueAnimatorM53782a.addUpdateListener(new bzrwd());
    }

    public void disableRotation() {
        stop();
        this.f41003L = false;
    }

    public void enableAndStartRotation() {
        this.f41003L = true;
        setLevel(10000);
        start();
    }

    @Override // com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable, android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f41004M;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        if (isRunning()) {
            return false;
        }
        m53778c(i10 / 10000.0f);
        return true;
    }

    @Override // com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable, android.graphics.drawable.Animatable
    public void start() {
        if (!isRunning() && this.f41003L) {
            this.f41001J.start();
            this.f41004M = true;
        }
    }

    @Override // com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable, android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.f41001J.cancel();
            this.f41002K.cancel();
            this.f40810b.m53713b(0.0f);
            this.f41004M = false;
            super.stop();
        }
    }

    /* renamed from: c */
    private void m53778c(float f10) {
        this.f41000I.setCurrentPlayTime((long) (f10 * r0.getDuration()));
        this.f40809a.m53689a(((Float) this.f41000I.getAnimatedValue("scale")).floatValue());
        this.f40810b.m53710a(((Float) this.f41000I.getAnimatedValue("degrees")).floatValue());
        invalidateSelf();
    }

    public static class akxao {

        /* renamed from: a */
        private static final float f41006a = 0.6f;

        /* renamed from: b */
        private static final float f41007b = 0.2f;

        /* renamed from: c */
        private static final float f41008c = 1.0f;

        /* renamed from: d */
        private static final float f41009d = 1.0f;

        /* renamed from: e */
        private static final int f41010e = 100;

        /* renamed from: f */
        private static final float f41011f = 0.5f;

        /* renamed from: g */
        private static final float f41012g = 1.0f;

        /* renamed from: a */
        public static ValueAnimator m53781a(float f10, float f11) {
            return ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("scale", f41011f, 1.0f), PropertyValuesHolder.ofFloat("degrees", f10, f11));
        }

        /* renamed from: b */
        public static ValueAnimator m53783b(float f10, float f11) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
            valueAnimatorOfFloat.setInterpolator(C10076a.m62701a(0.6f, 0.2f, 1.0f, 1.0f));
            valueAnimatorOfFloat.setDuration(100L);
            return valueAnimatorOfFloat;
        }

        /* renamed from: a */
        public static ValueAnimator m53782a(float f10, long j10) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f10);
            valueAnimatorOfFloat.setDuration(j10);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            return valueAnimatorOfFloat;
        }
    }

    public static HwSeekableGravitationalLoadingDrawable create(Context context, boolean z10, int i10) {
        return create(i10, HwGravitationalLoadingDrawable.m53634a(context, z10, i10), context.getResources().getDisplayMetrics(), 1200);
    }

    public static HwSeekableGravitationalLoadingDrawable create(Context context) {
        return create(context, false, context.getResources().getColor(C8701R.color.emui_color_progress));
    }

    public static HwSeekableGravitationalLoadingDrawable create(Context context, boolean z10) {
        return create(context, z10, context.getResources().getColor(C8701R.color.emui_color_progress));
    }

    public static HwSeekableGravitationalLoadingDrawable create(Context context, int i10) {
        return create(context, false, i10);
    }
}
