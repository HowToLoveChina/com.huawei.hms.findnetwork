package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p439l0.AbstractC11216b;
import p439l0.C11218d;
import p439l0.C11219e;
import p439l0.C11220f;

/* loaded from: classes7.dex */
class HwDotsPageIndicatorAnimation implements Animator.AnimatorListener {

    /* renamed from: l */
    private static final String f42392l = "DotIndicatorAnimation";

    /* renamed from: m */
    private static final boolean f42393m = false;

    /* renamed from: n */
    private static final int f42394n = 2;

    /* renamed from: a */
    private ValueAnimator f42395a;

    /* renamed from: b */
    private ValueAnimator f42396b;

    /* renamed from: c */
    private ConcurrentHashMap<Integer, ValueAnimator> f42397c;

    /* renamed from: d */
    private ConcurrentHashMap<Integer, ValueAnimator> f42398d;

    /* renamed from: e */
    private ValueAnimator f42399e;

    /* renamed from: f */
    private ValueAnimator f42400f;

    /* renamed from: g */
    private ValueAnimator f42401g;

    /* renamed from: h */
    private ValueAnimator f42402h;

    /* renamed from: i */
    private ValueAnimator f42403i;

    /* renamed from: j */
    private C11219e f42404j;

    /* renamed from: k */
    private final ConcurrentHashMap<Animator, List<AnimationStateListener>> f42405k = new ConcurrentHashMap<>();

    public static abstract class AnimationStateListener {
        /* renamed from: a */
        public void mo54486a() {
        }

        /* renamed from: b */
        public void mo54434b() {
        }

        /* renamed from: c */
        public void m54487c() {
        }

        /* renamed from: a */
        public void mo54435a(float f10) {
        }
    }

    public interface AnimationUpdateListener {
        void onAnimationUpdate(com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar);

        void onDotCenterChanged(float[] fArr);

        void onFocusDotChanged(boolean z10, float f10);

        void onFocusSingleScaled(RectF rectF);

        void onSingleScaled(boolean z10, int i10, float f10);

        void onSpringAnimationUpdate(boolean z10, float f10);
    }

    public static class Options {

        /* renamed from: a */
        private final com.huawei.uikit.hwdotspageindicator.widget.aauaf f42406a;

        /* renamed from: b */
        private final com.huawei.uikit.hwdotspageindicator.widget.aauaf f42407b;

        /* renamed from: c */
        private final float f42408c;

        /* renamed from: d */
        private final float f42409d;

        /* renamed from: e */
        private final float[] f42410e;

        /* renamed from: f */
        private final float[] f42411f;

        /* renamed from: g */
        private final float f42412g;

        /* renamed from: h */
        private final float f42413h;

        /* renamed from: i */
        private final RectF f42414i;

        /* renamed from: j */
        private final RectF f42415j;

        /* renamed from: k */
        private final float f42416k;

        /* renamed from: l */
        private final float f42417l;

        /* renamed from: m */
        private final long f42418m;

        /* renamed from: n */
        private final TimeInterpolator f42419n;

        /* renamed from: o */
        private final AnimationUpdateListener f42420o;

        /* renamed from: p */
        private final AnimationStateListener f42421p;

        public static class Builder {

            /* renamed from: a */
            private float f42422a;

            /* renamed from: b */
            private float f42423b;

            /* renamed from: c */
            private float[] f42424c;

            /* renamed from: d */
            private float[] f42425d;

            /* renamed from: e */
            private float f42426e;

            /* renamed from: f */
            private float f42427f;

            /* renamed from: g */
            private float f42428g;

            /* renamed from: h */
            private float f42429h;

            /* renamed from: i */
            private long f42430i;

            /* renamed from: j */
            private RectF f42431j;

            /* renamed from: k */
            private RectF f42432k;

            /* renamed from: l */
            private com.huawei.uikit.hwdotspageindicator.widget.aauaf f42433l;

            /* renamed from: m */
            private com.huawei.uikit.hwdotspageindicator.widget.aauaf f42434m;

            /* renamed from: n */
            private TimeInterpolator f42435n;

            /* renamed from: o */
            private AnimationUpdateListener f42436o;

            /* renamed from: p */
            private AnimationStateListener f42437p;

            public Options create() {
                return new Options(this);
            }

            public float getDamping() {
                return this.f42429h;
            }

            public long getDuration() {
                return this.f42430i;
            }

            public com.huawei.uikit.hwdotspageindicator.widget.aauaf getEndEntity() {
                return this.f42434m;
            }

            public TimeInterpolator getInterpolator() {
                return this.f42435n;
            }

            public float[] getStartCenterXs() {
                return this.f42424c;
            }

            public com.huawei.uikit.hwdotspageindicator.widget.aauaf getStartEntity() {
                return this.f42433l;
            }

            public RectF getStartFocusRectF() {
                return this.f42431j;
            }

            public float getStartLoc() {
                return this.f42426e;
            }

            public float getStartRadius() {
                return this.f42422a;
            }

            public AnimationStateListener getStateListener() {
                return this.f42437p;
            }

            public float getStiffness() {
                return this.f42428g;
            }

            public float[] getTargetCenterXs() {
                return this.f42425d;
            }

            public RectF getTargetFocusRectF() {
                return this.f42432k;
            }

            public float getTargetLoc() {
                return this.f42427f;
            }

            public float getTargetRadius() {
                return this.f42423b;
            }

            public AnimationUpdateListener getUpdateListener() {
                return this.f42436o;
            }

            public Builder setDamping(float f10) {
                this.f42429h = f10;
                return this;
            }

            public Builder setDuration(long j10) {
                this.f42430i = j10;
                return this;
            }

            public Builder setEndEntity(com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar) {
                this.f42434m = aauafVar;
                return this;
            }

            public Builder setInterpolator(TimeInterpolator timeInterpolator) {
                this.f42435n = timeInterpolator;
                return this;
            }

            public Builder setStartCenterXs(float[] fArr) {
                this.f42424c = fArr;
                return this;
            }

            public Builder setStartEntity(com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar) {
                this.f42433l = aauafVar;
                return this;
            }

            public Builder setStartFocusRectF(RectF rectF) {
                this.f42431j = rectF;
                return this;
            }

            public Builder setStartLoc(float f10) {
                this.f42426e = f10;
                return this;
            }

            public Builder setStartRadius(float f10) {
                this.f42422a = f10;
                return this;
            }

            public Builder setStateListener(AnimationStateListener animationStateListener) {
                this.f42437p = animationStateListener;
                return this;
            }

            public Builder setStiffness(float f10) {
                this.f42428g = f10;
                return this;
            }

            public Builder setTargetCenterXs(float[] fArr) {
                this.f42425d = fArr;
                return this;
            }

            public Builder setTargetFocusRectF(RectF rectF) {
                this.f42432k = rectF;
                return this;
            }

            public Builder setTargetLoc(float f10) {
                this.f42427f = f10;
                return this;
            }

            public Builder setTargetRadius(float f10) {
                this.f42423b = f10;
                return this;
            }

            public Builder setUpdateListener(AnimationUpdateListener animationUpdateListener) {
                this.f42436o = animationUpdateListener;
                return this;
            }
        }

        public Options(Builder builder) {
            this.f42406a = builder.getStartEntity();
            this.f42407b = builder.getEndEntity();
            this.f42408c = builder.getStartRadius();
            this.f42409d = builder.getTargetRadius();
            this.f42410e = builder.getStartCenterXs();
            this.f42411f = builder.getTargetCenterXs();
            this.f42412g = builder.getStartLoc();
            this.f42413h = builder.getTargetLoc();
            this.f42414i = builder.getStartFocusRectF();
            this.f42415j = builder.getTargetFocusRectF();
            this.f42416k = builder.getStiffness();
            this.f42417l = builder.getDamping();
            this.f42418m = builder.getDuration();
            this.f42419n = builder.getInterpolator();
            this.f42420o = builder.getUpdateListener();
            this.f42421p = builder.getStateListener();
        }

        public float getDamping() {
            return this.f42417l;
        }

        public long getDuration() {
            return this.f42418m;
        }

        public TimeInterpolator getInterpolator() {
            return this.f42419n;
        }

        public float[] getStartCenterXs() {
            return this.f42410e;
        }

        public com.huawei.uikit.hwdotspageindicator.widget.aauaf getStartEntity() {
            return this.f42406a;
        }

        public RectF getStartFocusRectF() {
            return this.f42414i;
        }

        public float getStartLoc() {
            return this.f42412g;
        }

        public float getStartRadius() {
            return this.f42408c;
        }

        public AnimationStateListener getStateListener() {
            return this.f42421p;
        }

        public float getStiffness() {
            return this.f42416k;
        }

        public float[] getTargetCenterXs() {
            return this.f42411f;
        }

        public com.huawei.uikit.hwdotspageindicator.widget.aauaf getTargetEntity() {
            return this.f42407b;
        }

        public RectF getTargetFocusRectF() {
            return this.f42415j;
        }

        public float getTargetLoc() {
            return this.f42413h;
        }

        public float getTargetRadius() {
            return this.f42409d;
        }

        public AnimationUpdateListener getUpdateListener() {
            return this.f42420o;
        }
    }

    public class aauaf implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ float f42438a;

        /* renamed from: b */
        final /* synthetic */ RectF f42439b;

        /* renamed from: c */
        final /* synthetic */ float f42440c;

        /* renamed from: d */
        final /* synthetic */ float f42441d;

        /* renamed from: e */
        final /* synthetic */ float f42442e;

        /* renamed from: f */
        final /* synthetic */ float f42443f;

        /* renamed from: g */
        final /* synthetic */ Options f42444g;

        public aauaf(float f10, RectF rectF, float f11, float f12, float f13, float f14, Options options) {
            this.f42438a = f10;
            this.f42439b = rectF;
            this.f42440c = f11;
            this.f42441d = f12;
            this.f42442e = f13;
            this.f42443f = f14;
            this.f42444g = options;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() - this.f42438a;
            RectF rectF = this.f42439b;
            float f10 = fFloatValue / 2.0f;
            rectF.top = this.f42440c - f10;
            rectF.left = this.f42441d - fFloatValue;
            rectF.right = this.f42442e + fFloatValue;
            rectF.bottom = this.f42443f + f10;
            if (this.f42444g.f42420o != null) {
                this.f42444g.f42420o.onFocusSingleScaled(this.f42439b);
            }
        }
    }

    public class akxao implements AbstractC11216b.r {

        /* renamed from: a */
        final /* synthetic */ Options f42446a;

        /* renamed from: b */
        final /* synthetic */ boolean f42447b;

        public akxao(Options options, boolean z10) {
            this.f42446a = options;
            this.f42447b = z10;
        }

        @Override // p439l0.AbstractC11216b.r
        public void onAnimationUpdate(AbstractC11216b abstractC11216b, float f10, float f11) {
            if (abstractC11216b == null || this.f42446a.getUpdateListener() == null) {
                return;
            }
            this.f42446a.getUpdateListener().onSpringAnimationUpdate(this.f42447b, f10);
        }
    }

    public class avpbg implements AbstractC11216b.q {

        /* renamed from: a */
        final /* synthetic */ Options f42449a;

        public avpbg(Options options) {
            this.f42449a = options;
        }

        @Override // p439l0.AbstractC11216b.q
        public void onAnimationEnd(AbstractC11216b abstractC11216b, boolean z10, float f10, float f11) {
            if (abstractC11216b == null) {
                return;
            }
            this.f42449a.getStateListener().mo54434b();
        }
    }

    public class blfhz implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ Options f42451a;

        /* renamed from: b */
        final /* synthetic */ float f42452b;

        /* renamed from: c */
        final /* synthetic */ float f42453c;

        public blfhz(Options options, float f10, float f11) {
            this.f42451a = options;
            this.f42452b = f10;
            this.f42453c = f11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            HwDotsPageIndicatorAnimation.this.m54441a(valueAnimator, fFloatValue);
            float interpolation = this.f42451a.getInterpolator().getInterpolation(fFloatValue);
            if (this.f42451a.getUpdateListener() != null) {
                this.f42451a.getUpdateListener().onFocusDotChanged(true, HwDotsPageIndicatorAnimation.this.m54438a(this.f42452b, this.f42453c, interpolation));
            }
        }
    }

    public class bqmxo implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ Options f42455a;

        /* renamed from: b */
        final /* synthetic */ boolean f42456b;

        /* renamed from: c */
        final /* synthetic */ int f42457c;

        public bqmxo(Options options, boolean z10, int i10) {
            this.f42455a = options;
            this.f42456b = z10;
            this.f42457c = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.f42455a.getUpdateListener() != null) {
                this.f42455a.getUpdateListener().onSingleScaled(this.f42456b, this.f42457c, fFloatValue);
            }
        }
    }

    public class brnby implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ Options f42459a;

        /* renamed from: b */
        final /* synthetic */ float f42460b;

        /* renamed from: c */
        final /* synthetic */ float f42461c;

        public brnby(Options options, float f10, float f11) {
            this.f42459a = options;
            this.f42460b = f10;
            this.f42461c = f11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float interpolation = this.f42459a.getInterpolator().getInterpolation(fFloatValue);
            float f10 = this.f42460b;
            float f11 = f10 + ((this.f42461c - f10) * interpolation);
            HwDotsPageIndicatorAnimation.this.m54441a(valueAnimator, fFloatValue);
            if (this.f42459a.getUpdateListener() != null) {
                this.f42459a.getUpdateListener().onFocusDotChanged(false, f11);
            }
        }
    }

    public class bxac implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ Options f42463a;

        /* renamed from: b */
        final /* synthetic */ float[] f42464b;

        /* renamed from: c */
        final /* synthetic */ float[] f42465c;

        public bxac(Options options, float[] fArr, float[] fArr2) {
            this.f42463a = options;
            this.f42464b = fArr;
            this.f42465c = fArr2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            float interpolation = this.f42463a.getInterpolator().getInterpolation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            float[] fArr = new float[this.f42464b.length];
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.f42464b;
                if (i10 >= fArr2.length) {
                    break;
                }
                float f10 = fArr2[i10];
                fArr[i10] = f10 + ((this.f42465c[i10] - f10) * interpolation);
                i10++;
            }
            if (this.f42463a.getUpdateListener() != null) {
                this.f42463a.getUpdateListener().onDotCenterChanged(fArr);
            }
        }
    }

    public class bzrwd implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ Options f42467a;

        /* renamed from: b */
        final /* synthetic */ ArgbEvaluator f42468b;

        /* renamed from: c */
        final /* synthetic */ com.huawei.uikit.hwdotspageindicator.widget.aauaf f42469c;

        /* renamed from: d */
        final /* synthetic */ com.huawei.uikit.hwdotspageindicator.widget.aauaf f42470d;

        /* renamed from: e */
        final /* synthetic */ com.huawei.uikit.hwdotspageindicator.widget.aauaf f42471e;

        public bzrwd(Options options, ArgbEvaluator argbEvaluator, com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar, com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar2, com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar3) {
            this.f42467a = options;
            this.f42468b = argbEvaluator;
            this.f42469c = aauafVar;
            this.f42470d = aauafVar2;
            this.f42471e = aauafVar3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            float interpolation = this.f42467a.getInterpolator().getInterpolation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f42471e.m54575q(((Integer) this.f42468b.evaluate(interpolation, Integer.valueOf(this.f42469c.m54585w()), Integer.valueOf(this.f42470d.m54585w()))).intValue());
            float fM54438a = HwDotsPageIndicatorAnimation.this.m54438a(this.f42469c.m54549g(), this.f42470d.m54549g(), interpolation);
            float fM54438a2 = HwDotsPageIndicatorAnimation.this.m54438a(this.f42469c.m54568n(), this.f42470d.m54568n(), interpolation);
            float fM54438a3 = HwDotsPageIndicatorAnimation.this.m54438a(this.f42469c.m54563l(), this.f42470d.m54563l(), interpolation);
            float fM54438a4 = HwDotsPageIndicatorAnimation.this.m54438a(this.f42469c.m54570o(), this.f42470d.m54570o(), interpolation);
            float fM54438a5 = HwDotsPageIndicatorAnimation.this.m54438a(this.f42469c.m54561k(), this.f42470d.m54561k(), interpolation);
            this.f42471e.m54526b(HwDotsPageIndicatorAnimation.this.m54438a(this.f42469c.m54580t().left, this.f42470d.m54580t().left, interpolation), HwDotsPageIndicatorAnimation.this.m54438a(this.f42469c.m54580t().top, this.f42470d.m54580t().top, interpolation), HwDotsPageIndicatorAnimation.this.m54438a(this.f42469c.m54580t().right, this.f42470d.m54580t().right, interpolation), HwDotsPageIndicatorAnimation.this.m54438a(this.f42469c.m54580t().bottom, this.f42470d.m54580t().bottom, interpolation));
            this.f42471e.m54540d(fM54438a);
            this.f42471e.m54513a(fM54438a2, fM54438a4, fM54438a3, fM54438a5);
            float[] fArr = new float[this.f42470d.m54544e().length];
            for (int i10 = 0; i10 < this.f42470d.m54544e().length; i10++) {
                fArr[i10] = HwDotsPageIndicatorAnimation.this.m54438a(this.f42469c.m54544e()[i10], this.f42470d.m54544e()[i10], interpolation);
            }
            this.f42471e.m54516a(fArr);
            this.f42471e.m54534c(this.f42470d.m54537d());
            if (this.f42467a.getUpdateListener() != null) {
                this.f42467a.getUpdateListener().onAnimationUpdate(this.f42471e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public float m54438a(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    /* renamed from: b */
    public boolean m54456b(int i10) {
        ValueAnimator valueAnimator;
        ConcurrentHashMap<Integer, ValueAnimator> concurrentHashMap = this.f42397c;
        return (concurrentHashMap == null || (valueAnimator = concurrentHashMap.get(Integer.valueOf(i10))) == null || !valueAnimator.isRunning()) ? false : true;
    }

    /* renamed from: c */
    public Animator m54457c() {
        return this.f42399e;
    }

    /* renamed from: d */
    public Animator m54460d() {
        return this.f42402h;
    }

    /* renamed from: e */
    public void m54464e(int i10) {
        if (m54452a(i10)) {
            this.f42398d.get(Integer.valueOf(i10)).cancel();
        }
    }

    /* renamed from: f */
    public Animator m54466f() {
        return this.f42396b;
    }

    /* renamed from: g */
    public C11219e m54468g() {
        return this.f42404j;
    }

    /* renamed from: h */
    public Animator m54469h() {
        return this.f42395a;
    }

    /* renamed from: i */
    public boolean m54470i() {
        ValueAnimator valueAnimator = this.f42400f;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* renamed from: j */
    public boolean m54471j() {
        ValueAnimator valueAnimator = this.f42401g;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* renamed from: k */
    public boolean m54472k() {
        ValueAnimator valueAnimator = this.f42399e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* renamed from: l */
    public boolean m54473l() {
        ValueAnimator valueAnimator = this.f42402h;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* renamed from: m */
    public boolean m54474m() {
        ValueAnimator valueAnimator = this.f42403i;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* renamed from: n */
    public boolean m54475n() {
        ValueAnimator valueAnimator = this.f42396b;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* renamed from: o */
    public boolean m54476o() {
        C11219e c11219e = this.f42404j;
        return c11219e != null && c11219e.m67365h();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        List<AnimationStateListener> listRemove;
        Set<Animator> setKeySet = this.f42405k.keySet();
        if (setKeySet == null || setKeySet.size() == 0) {
            return;
        }
        for (Animator animator2 : setKeySet) {
            if (animator2 == animator && (listRemove = this.f42405k.remove(animator2)) != null && listRemove.size() != 0) {
                Iterator<AnimationStateListener> it = listRemove.iterator();
                while (it.hasNext()) {
                    it.next().mo54486a();
                }
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        List<AnimationStateListener> listRemove;
        Set<Animator> setKeySet = this.f42405k.keySet();
        if (setKeySet == null || setKeySet.size() == 0) {
            return;
        }
        for (Animator animator2 : setKeySet) {
            if (animator2 == animator && (listRemove = this.f42405k.remove(animator2)) != null && listRemove.size() != 0) {
                Iterator<AnimationStateListener> it = listRemove.iterator();
                while (it.hasNext()) {
                    it.next().mo54434b();
                }
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        List<AnimationStateListener> list;
        Set<Animator> setKeySet = this.f42405k.keySet();
        if (setKeySet == null || setKeySet.size() == 0) {
            return;
        }
        for (Animator animator2 : setKeySet) {
            if (animator2 == animator && (list = this.f42405k.get(animator2)) != null && list.size() != 0) {
                Iterator<AnimationStateListener> it = list.iterator();
                while (it.hasNext()) {
                    it.next().m54487c();
                }
            }
        }
    }

    /* renamed from: p */
    public boolean m54477p() {
        ValueAnimator valueAnimator = this.f42395a;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    /* renamed from: q */
    public void m54478q() {
        if (m54470i()) {
            this.f42400f.cancel();
        }
    }

    /* renamed from: r */
    public void m54479r() {
        if (m54471j()) {
            this.f42401g.cancel();
        }
    }

    /* renamed from: s */
    public void m54480s() {
        if (m54472k()) {
            this.f42399e.cancel();
        }
    }

    /* renamed from: t */
    public void m54481t() {
        if (m54473l()) {
            this.f42402h.cancel();
        }
    }

    /* renamed from: u */
    public void m54482u() {
        if (m54474m()) {
            this.f42403i.cancel();
        }
    }

    /* renamed from: v */
    public void m54483v() {
        if (m54475n()) {
            this.f42396b.cancel();
        }
    }

    /* renamed from: w */
    public void m54484w() {
        if (m54476o()) {
            this.f42404j.m67361d();
        }
    }

    /* renamed from: x */
    public void m54485x() {
        if (m54477p()) {
            this.f42395a.cancel();
        }
    }

    /* renamed from: c */
    public void m54458c(int i10) {
        ConcurrentHashMap<Integer, ValueAnimator> concurrentHashMap = this.f42398d;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(i10));
        }
    }

    /* renamed from: d */
    public void m54462d(Options options) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f42396b = valueAnimatorOfFloat;
        m54442a(valueAnimatorOfFloat, options);
    }

    /* renamed from: f */
    public void m54467f(int i10) {
        if (m54456b(i10)) {
            this.f42397c.get(Integer.valueOf(i10)).cancel();
        }
    }

    /* renamed from: a */
    public boolean m54452a(int i10) {
        ValueAnimator valueAnimator;
        ConcurrentHashMap<Integer, ValueAnimator> concurrentHashMap = this.f42398d;
        return (concurrentHashMap == null || (valueAnimator = concurrentHashMap.get(Integer.valueOf(i10))) == null || !valueAnimator.isRunning()) ? false : true;
    }

    /* renamed from: b */
    public Animator m54453b() {
        return this.f42401g;
    }

    /* renamed from: c */
    public void m54459c(Options options) {
        if (options.getInterpolator() == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f42399e = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f42399e.setDuration(options.getDuration());
        this.f42399e.addListener(this);
        if (options.getStateListener() != null) {
            m54449a(this.f42399e, options.getStateListener());
        }
        this.f42399e.addUpdateListener(new blfhz(options, options.getStartLoc(), options.getTargetLoc()));
        this.f42399e.start();
    }

    /* renamed from: d */
    public void m54461d(int i10) {
        ConcurrentHashMap<Integer, ValueAnimator> concurrentHashMap = this.f42397c;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(i10));
        }
    }

    /* renamed from: e */
    public Animator m54463e() {
        return this.f42403i;
    }

    /* renamed from: b */
    private void m54445b(int i10, ValueAnimator valueAnimator) {
        if (this.f42397c == null) {
            this.f42397c = new ConcurrentHashMap<>();
        }
        this.f42397c.put(Integer.valueOf(i10), valueAnimator);
    }

    /* renamed from: e */
    public void m54465e(Options options) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f42395a = valueAnimatorOfFloat;
        m54442a(valueAnimatorOfFloat, options);
    }

    /* renamed from: a */
    private void m54442a(ValueAnimator valueAnimator, Options options) {
        com.huawei.uikit.hwdotspageindicator.widget.aauaf startEntity = options.getStartEntity();
        com.huawei.uikit.hwdotspageindicator.widget.aauaf targetEntity = options.getTargetEntity();
        if (m54444a(startEntity, targetEntity, options.getInterpolator())) {
            com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVarM54533c = startEntity.m54533c();
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new bzrwd(options, new ArgbEvaluator(), startEntity, targetEntity, aauafVarM54533c));
            valueAnimator.addListener(this);
            if (options.getStateListener() != null) {
                m54449a(valueAnimator, options.getStateListener());
            }
            valueAnimator.setDuration(options.getDuration());
            valueAnimator.start();
        }
    }

    /* renamed from: b */
    public void m54455b(boolean z10, Options options) {
        this.f42404j = new C11219e(new C11218d(options.getStartLoc()));
        float targetLoc = options.getTargetLoc();
        this.f42404j.m67360c(new akxao(options, z10));
        if (options.getStateListener() != null) {
            this.f42404j.m67359b(new avpbg(options));
        }
        C11220f c11220f = new C11220f();
        c11220f.m67410d(options.getDamping()).m67412f(options.getStiffness()).m67411e(targetLoc);
        this.f42404j.m67405s(c11220f);
        this.f42404j.mo67368l();
    }

    /* renamed from: a */
    private boolean m54444a(com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar, com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar2, TimeInterpolator timeInterpolator) {
        if (aauafVar == null || aauafVar2 == null || timeInterpolator == null || aauafVar.m54580t() == null || aauafVar2.m54580t() == null) {
            return false;
        }
        float[] fArrM54544e = aauafVar2.m54544e();
        float[] fArrM54544e2 = aauafVar.m54544e();
        return (fArrM54544e == null || fArrM54544e2 == null || fArrM54544e.length != fArrM54544e2.length) ? false : true;
    }

    /* renamed from: b */
    public void m54454b(Options options) {
        if (options.getInterpolator() == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f42400f = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f42400f.setDuration(options.f42418m);
        this.f42400f.addListener(this);
        if (options.f42421p != null) {
            m54449a(this.f42400f, options.f42421p);
        }
        this.f42400f.addUpdateListener(new brnby(options, options.getStartLoc(), options.getTargetLoc()));
        this.f42400f.start();
    }

    /* renamed from: a */
    public void m54451a(boolean z10, Options options) {
        RectF startFocusRectF = options.getStartFocusRectF();
        RectF targetFocusRectF = options.getTargetFocusRectF();
        if (startFocusRectF == null || targetFocusRectF == null || options.getInterpolator() == null) {
            return;
        }
        float f10 = startFocusRectF.left;
        float f11 = startFocusRectF.top;
        float f12 = startFocusRectF.right;
        float f13 = startFocusRectF.bottom;
        float f14 = f13 - f11;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f14, targetFocusRectF.bottom - targetFocusRectF.top);
        if (z10) {
            this.f42402h = valueAnimatorOfFloat;
        } else {
            this.f42403i = valueAnimatorOfFloat;
        }
        valueAnimatorOfFloat.setInterpolator(options.getInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new aauaf(f14, new RectF(), f11, f10, f12, f13, options));
        valueAnimatorOfFloat.start();
    }

    /* renamed from: a */
    public void m54447a(int i10, boolean z10, Options options) {
        if (options.getInterpolator() == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(options.getStartRadius(), options.getTargetRadius());
        if (z10) {
            m54440a(i10, valueAnimatorOfFloat);
        } else {
            m54445b(i10, valueAnimatorOfFloat);
        }
        valueAnimatorOfFloat.setDuration(options.getDuration());
        valueAnimatorOfFloat.setInterpolator(options.getInterpolator());
        valueAnimatorOfFloat.addListener(this);
        if (options.getStateListener() != null) {
            m54449a(valueAnimatorOfFloat, options.getStateListener());
        }
        valueAnimatorOfFloat.addUpdateListener(new bqmxo(options, z10, i10));
        valueAnimatorOfFloat.start();
    }

    /* renamed from: a */
    private void m54440a(int i10, ValueAnimator valueAnimator) {
        if (this.f42398d == null) {
            this.f42398d = new ConcurrentHashMap<>();
        }
        this.f42398d.put(Integer.valueOf(i10), valueAnimator);
    }

    /* renamed from: a */
    public void m54450a(Options options) {
        if (options.getInterpolator() == null) {
            return;
        }
        float[] startCenterXs = options.getStartCenterXs();
        float[] targetCenterXs = options.getTargetCenterXs();
        if (startCenterXs == null || targetCenterXs == null || startCenterXs.length != targetCenterXs.length) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f42401g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f42401g.setDuration(options.getDuration());
        this.f42401g.addListener(this);
        if (options.f42421p != null) {
            m54449a(this.f42401g, options.f42421p);
        }
        this.f42401g.addUpdateListener(new bxac(options, startCenterXs, targetCenterXs));
        this.f42401g.start();
    }

    /* renamed from: a */
    public void m54449a(Animator animator, AnimationStateListener animationStateListener) {
        List<AnimationStateListener> arrayList = this.f42405k.get(animator);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(animationStateListener);
        this.f42405k.put(animator, arrayList);
    }

    /* renamed from: a */
    public void m54448a(Animator animator) {
        this.f42405k.remove(animator);
    }

    /* renamed from: a */
    public void m54446a() {
        this.f42405k.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54441a(Animator animator, float f10) {
        List<AnimationStateListener> list;
        Set<Animator> setKeySet = this.f42405k.keySet();
        if (setKeySet == null || setKeySet.size() == 0) {
            return;
        }
        for (Animator animator2 : setKeySet) {
            if (animator2 == animator && (list = this.f42405k.get(animator2)) != null && list.size() != 0) {
                Iterator<AnimationStateListener> it = list.iterator();
                while (it.hasNext()) {
                    it.next().mo54435a(f10);
                }
            }
        }
    }
}
