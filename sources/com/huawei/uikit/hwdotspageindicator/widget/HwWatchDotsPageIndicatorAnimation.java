package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import p439l0.AbstractC11216b;
import p439l0.C11218d;
import p439l0.C11219e;
import p439l0.C11220f;

/* loaded from: classes7.dex */
public class HwWatchDotsPageIndicatorAnimation implements Animator.AnimatorListener {

    /* renamed from: d */
    private static final float f42473d = 0.0f;

    /* renamed from: e */
    private static final float f42474e = 1.0f;

    /* renamed from: a */
    private ValueAnimator f42475a;

    /* renamed from: b */
    private ValueAnimator f42476b;

    /* renamed from: c */
    private C11219e f42477c;

    public interface AnimationUpdateListener {
        void onAnimationUpdate(HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions);

        void onSpringAnimationUpdate(boolean z10, float f10);
    }

    public static class Options {

        /* renamed from: a */
        private final HwWatchDotsPageIndicatorOptions f42478a;

        /* renamed from: b */
        private final HwWatchDotsPageIndicatorOptions f42479b;

        /* renamed from: c */
        private final float f42480c;

        /* renamed from: d */
        private final float f42481d;

        /* renamed from: e */
        private final float[] f42482e;

        /* renamed from: f */
        private final float[] f42483f;

        /* renamed from: g */
        private final float f42484g;

        /* renamed from: h */
        private final float f42485h;

        /* renamed from: i */
        private final float f42486i;

        /* renamed from: j */
        private final float f42487j;

        /* renamed from: k */
        private final long f42488k;

        /* renamed from: l */
        private final TimeInterpolator f42489l;

        /* renamed from: m */
        private final AnimationUpdateListener f42490m;

        public static class Builder {

            /* renamed from: a */
            private float f42491a;

            /* renamed from: b */
            private float f42492b;

            /* renamed from: c */
            private float[] f42493c;

            /* renamed from: d */
            private float[] f42494d;

            /* renamed from: e */
            private float f42495e;

            /* renamed from: f */
            private float f42496f;

            /* renamed from: g */
            private long f42497g;

            /* renamed from: h */
            private float f42498h;

            /* renamed from: i */
            private float f42499i;

            /* renamed from: j */
            private HwWatchDotsPageIndicatorOptions f42500j;

            /* renamed from: k */
            private HwWatchDotsPageIndicatorOptions f42501k;

            /* renamed from: l */
            private TimeInterpolator f42502l;

            /* renamed from: m */
            private AnimationUpdateListener f42503m;

            public Options create() {
                return new Options(this);
            }

            public float getDamping() {
                return this.f42496f;
            }

            public long getDuration() {
                return this.f42497g;
            }

            public HwWatchDotsPageIndicatorOptions getEndEntity() {
                return this.f42501k;
            }

            public TimeInterpolator getInterpolator() {
                return this.f42502l;
            }

            public float[] getStartAngles() {
                return this.f42493c;
            }

            public HwWatchDotsPageIndicatorOptions getStartEntity() {
                return this.f42500j;
            }

            public float getStartFocusStartAngle() {
                return this.f42498h;
            }

            public float getStartRadius() {
                return this.f42491a;
            }

            public float getStiffness() {
                return this.f42495e;
            }

            public float[] getTargetAngles() {
                return this.f42494d;
            }

            public float getTargetFocusStartAngle() {
                return this.f42499i;
            }

            public float getTargetRadius() {
                return this.f42492b;
            }

            public AnimationUpdateListener getUpdateListener() {
                return this.f42503m;
            }

            public Builder setDamping(float f10) {
                this.f42496f = f10;
                return this;
            }

            public Builder setDuration(long j10) {
                this.f42497g = j10;
                return this;
            }

            public Builder setEndEntity(HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions) {
                this.f42501k = hwWatchDotsPageIndicatorOptions;
                return this;
            }

            public Builder setInterpolator(TimeInterpolator timeInterpolator) {
                this.f42502l = timeInterpolator;
                return this;
            }

            public Builder setStartEntity(HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions) {
                this.f42500j = hwWatchDotsPageIndicatorOptions;
                return this;
            }

            public Builder setStartFocusStartAngle(float f10) {
                this.f42498h = f10;
                return this;
            }

            public Builder setStiffness(float f10) {
                this.f42495e = f10;
                return this;
            }

            public Builder setTargetAngles(float[] fArr) {
                this.f42494d = fArr;
                return this;
            }

            public Builder setTargetFocusStartAngle(float f10) {
                this.f42499i = f10;
                return this;
            }

            public Builder setTargetRadius(float f10) {
                this.f42492b = f10;
                return this;
            }

            public Builder setUpdateListener(AnimationUpdateListener animationUpdateListener) {
                this.f42503m = animationUpdateListener;
                return this;
            }
        }

        public Options(Builder builder) {
            this.f42478a = builder.getStartEntity();
            this.f42479b = builder.getEndEntity();
            this.f42480c = builder.getStartRadius();
            this.f42481d = builder.getTargetRadius();
            this.f42482e = builder.getStartAngles();
            this.f42483f = builder.getTargetAngles();
            this.f42484g = builder.getStartFocusStartAngle();
            this.f42485h = builder.getTargetFocusStartAngle();
            this.f42486i = builder.getStiffness();
            this.f42487j = builder.getDamping();
            this.f42488k = builder.getDuration();
            this.f42489l = builder.getInterpolator();
            this.f42490m = builder.getUpdateListener();
        }

        public TimeInterpolator getInterpolator() {
            return this.f42489l;
        }

        public HwWatchDotsPageIndicatorOptions getStartEntity() {
            return this.f42478a;
        }

        public float getStartFocusStartAngle() {
            return this.f42484g;
        }

        public HwWatchDotsPageIndicatorOptions getTargetEntity() {
            return this.f42479b;
        }

        public float getTargetFocusStartAngle() {
            return this.f42485h;
        }

        public AnimationUpdateListener getUpdateListener() {
            return this.f42490m;
        }

        public float getWatchDamping() {
            return this.f42487j;
        }

        public long getWatchDuration() {
            return this.f42488k;
        }

        public float getWatchStiffness() {
            return this.f42486i;
        }
    }

    public class aauaf implements AbstractC11216b.r {

        /* renamed from: a */
        final /* synthetic */ Options f42504a;

        /* renamed from: b */
        final /* synthetic */ boolean f42505b;

        public aauaf(Options options, boolean z10) {
            this.f42504a = options;
            this.f42505b = z10;
        }

        @Override // p439l0.AbstractC11216b.r
        public void onAnimationUpdate(AbstractC11216b abstractC11216b, float f10, float f11) {
            if (abstractC11216b == null || this.f42504a.getUpdateListener() == null) {
                return;
            }
            this.f42504a.getUpdateListener().onSpringAnimationUpdate(this.f42505b, f10);
        }
    }

    public class bzrwd implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ Options f42507a;

        /* renamed from: b */
        final /* synthetic */ HwWatchDotsPageIndicatorOptions f42508b;

        /* renamed from: c */
        final /* synthetic */ ArgbEvaluator f42509c;

        public bzrwd(Options options, HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions, ArgbEvaluator argbEvaluator) {
            this.f42507a = options;
            this.f42508b = hwWatchDotsPageIndicatorOptions;
            this.f42509c = argbEvaluator;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            HwWatchDotsPageIndicatorAnimation.this.m54493a(valueAnimator, this.f42507a, this.f42508b, this.f42509c);
        }
    }

    /* renamed from: a */
    private float m54491a(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public void doInvisibleAnimation(Options options) {
        if (options == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f42476b = valueAnimatorOfFloat;
        m54492a(valueAnimatorOfFloat, options);
    }

    public void doSpringAnimationForWatch(boolean z10, Options options) {
        if (options == null) {
            return;
        }
        C11219e c11219e = new C11219e(new C11218d(options.getStartFocusStartAngle()));
        this.f42477c = c11219e;
        c11219e.m67360c(new aauaf(options, z10));
        C11220f c11220f = new C11220f();
        c11220f.m67410d(options.getWatchDamping()).m67412f(options.getWatchStiffness()).m67411e(options.getTargetFocusStartAngle());
        this.f42477c.m67405s(c11220f);
        this.f42477c.mo67368l();
    }

    public void doVisibleAnimation(Options options) {
        if (options == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f42475a = valueAnimatorOfFloat;
        m54492a(valueAnimatorOfFloat, options);
    }

    public boolean isWatchInvisibleAnimationRunning() {
        ValueAnimator valueAnimator = this.f42476b;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean isWatchSpringAnimationRunning() {
        C11219e c11219e = this.f42477c;
        return c11219e != null && c11219e.m67365h();
    }

    public boolean isWatchVisibleAnimationRunning() {
        ValueAnimator valueAnimator = this.f42475a;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public void stopWatchInvisibleAnimation() {
        ValueAnimator valueAnimator;
        if (!isWatchInvisibleAnimationRunning() || (valueAnimator = this.f42476b) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public void stopWatchSpringAnimation() {
        C11219e c11219e;
        if (!isWatchSpringAnimationRunning() || (c11219e = this.f42477c) == null) {
            return;
        }
        c11219e.m67361d();
    }

    public void stopWatchVisibleAnimation() {
        ValueAnimator valueAnimator;
        if (!isWatchVisibleAnimationRunning() || (valueAnimator = this.f42475a) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54493a(ValueAnimator valueAnimator, Options options, HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions, ArgbEvaluator argbEvaluator) {
        HwWatchDotsPageIndicatorOptions startEntity = options.getStartEntity();
        HwWatchDotsPageIndicatorOptions targetEntity = options.getTargetEntity();
        float interpolation = options.getInterpolator().getInterpolation(((Float) valueAnimator.getAnimatedValue()).floatValue());
        hwWatchDotsPageIndicatorOptions.setHotZoneColor(((Integer) argbEvaluator.evaluate(interpolation, Integer.valueOf(startEntity.getHotZoneColor()), Integer.valueOf(targetEntity.getHotZoneColor()))).intValue());
        hwWatchDotsPageIndicatorOptions.setDotRadius(m54491a(startEntity.getDotRadius(), targetEntity.getDotRadius(), interpolation));
        hwWatchDotsPageIndicatorOptions.setScaleHotZoneStartAngle(m54491a(startEntity.getScaleHotZoneStartAngle(), targetEntity.getScaleHotZoneStartAngle(), interpolation));
        hwWatchDotsPageIndicatorOptions.setScaleHotZoneSweepAngle(m54491a(startEntity.getScaleHotZoneSweepAngle(), targetEntity.getScaleHotZoneSweepAngle(), interpolation));
        float fM54491a = m54491a(startEntity.getFocusDotStartAngle(), targetEntity.getFocusDotStartAngle(), interpolation);
        float fM54491a2 = m54491a(startEntity.getFocusDotSweepAngle(), targetEntity.getFocusDotSweepAngle(), interpolation);
        float fM54491a3 = m54491a(startEntity.getFocusDotEndAngle(), targetEntity.getFocusDotEndAngle(), interpolation);
        hwWatchDotsPageIndicatorOptions.setFocusDotStartAngle(fM54491a);
        hwWatchDotsPageIndicatorOptions.setFocusDotSweepAngle(fM54491a2);
        hwWatchDotsPageIndicatorOptions.setFocusDotEndAngle(fM54491a3);
        hwWatchDotsPageIndicatorOptions.setMarginScreen(m54491a(startEntity.getMarginScreen(), targetEntity.getMarginScreen(), interpolation));
        float[] fArr = new float[targetEntity.getDotAngles().length];
        for (int i10 = 0; i10 < targetEntity.getDotAngles().length; i10++) {
            fArr[i10] = m54491a(startEntity.getDotAngles()[i10], targetEntity.getDotAngles()[i10], interpolation);
        }
        hwWatchDotsPageIndicatorOptions.setDotAngles(fArr);
        if (options.getUpdateListener() != null) {
            options.getUpdateListener().onAnimationUpdate(hwWatchDotsPageIndicatorOptions);
        }
    }

    /* renamed from: a */
    private void m54492a(ValueAnimator valueAnimator, Options options) {
        if (valueAnimator == null || options == null) {
            return;
        }
        HwWatchDotsPageIndicatorOptions startEntity = options.getStartEntity();
        if (m54495a(startEntity, options.getTargetEntity(), options.getInterpolator())) {
            HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptionsDeepCopy = startEntity.deepCopy();
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new bzrwd(options, hwWatchDotsPageIndicatorOptionsDeepCopy, new ArgbEvaluator()));
            valueAnimator.addListener(this);
            valueAnimator.setDuration(options.getWatchDuration());
            valueAnimator.start();
        }
    }

    /* renamed from: a */
    private boolean m54495a(HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions, HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions2, TimeInterpolator timeInterpolator) {
        if (hwWatchDotsPageIndicatorOptions == null || hwWatchDotsPageIndicatorOptions2 == null || timeInterpolator == null) {
            return false;
        }
        float[] dotAngles = hwWatchDotsPageIndicatorOptions2.getDotAngles();
        float[] dotAngles2 = hwWatchDotsPageIndicatorOptions.getDotAngles();
        return (dotAngles == null || dotAngles2 == null || dotAngles.length != dotAngles2.length) ? false : true;
    }
}
