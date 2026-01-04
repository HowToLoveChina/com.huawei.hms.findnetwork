package com.huawei.uikit.hwdotspageindicator.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.uikit.hwdotspageindicator.C8711R;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation;
import com.huawei.uikit.hwdotspageindicator.widget.HwWatchDotsPageIndicatorAnimation;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;

/* loaded from: classes7.dex */
class bzrwd extends View {
    protected static final int CURSOR_IN_DOT_INDEX = -1;

    /* renamed from: j */
    private static final float f42652j = 700.0f;

    /* renamed from: k */
    private static final float f42653k = 800.0f;

    /* renamed from: l */
    private static final float f42654l = 0.47f;

    /* renamed from: m */
    private static final long f42655m = 250;

    /* renamed from: n */
    private static final long f42656n = 250;

    /* renamed from: o */
    private static final long f42657o = 250;

    /* renamed from: p */
    private static final long f42658p = 300;

    /* renamed from: q */
    private static final long f42659q = 100;

    /* renamed from: r */
    private static final long f42660r = 150;

    /* renamed from: s */
    private static final long f42661s = 400;

    /* renamed from: a */
    private float f42662a;

    /* renamed from: b */
    private TimeInterpolator f42663b;

    /* renamed from: c */
    private TimeInterpolator f42664c;

    /* renamed from: d */
    private TimeInterpolator f42665d;

    /* renamed from: e */
    private TimeInterpolator f42666e;

    /* renamed from: f */
    private TimeInterpolator f42667f;

    /* renamed from: g */
    private TimeInterpolator f42668g;

    /* renamed from: h */
    private TimeInterpolator f42669h;

    /* renamed from: i */
    private TimeInterpolator f42670i;
    protected HwDotsPageIndicatorAnimation mAnimator;
    protected com.huawei.uikit.hwdotspageindicator.widget.aauaf mOptions;
    protected float mSpringDamping;
    protected float mSpringStiffness;
    protected HwWatchDotsPageIndicatorAnimation mWatchAnimator;
    protected HwWatchDotsPageIndicatorOptions mWatchOptions;
    protected float mWatchSpringDamping;
    protected float mWatchSpringStiffness;

    public class aauaf extends HwDotsPageIndicatorAnimation.AnimationStateListener {

        /* renamed from: a */
        final /* synthetic */ int f42671a;

        /* renamed from: b */
        final /* synthetic */ View f42672b;

        public aauaf(int i10, View view) {
            this.f42671a = i10;
            this.f42672b = view;
        }

        @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
        /* renamed from: b */
        public void mo54434b() {
            bzrwd.this.mOptions.m54567m(this.f42671a);
            bzrwd.this.mAnimator.m54461d(this.f42671a);
            this.f42672b.invalidate();
        }
    }

    public static class akxao {

        /* renamed from: a */
        boolean f42674a;

        /* renamed from: b */
        float f42675b;

        /* renamed from: c */
        float f42676c;

        /* renamed from: d */
        float f42677d;

        /* renamed from: e */
        float f42678e;

        public akxao(boolean z10, float f10, float f11, float f12, float f13) {
            this.f42674a = z10;
            this.f42675b = f10;
            this.f42676c = f11;
            this.f42677d = f12;
            this.f42678e = f13;
        }
    }

    public class bqmxo extends HwDotsPageIndicatorAnimation.AnimationStateListener {

        /* renamed from: a */
        final /* synthetic */ View f42679a;

        public bqmxo(View view) {
            this.f42679a = view;
        }

        @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
        /* renamed from: a */
        public void mo54486a() {
            bzrwd.this.m54624a(this.f42679a);
        }

        @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
        /* renamed from: b */
        public void mo54434b() {
            bzrwd.this.m54624a(this.f42679a);
        }
    }

    /* renamed from: com.huawei.uikit.hwdotspageindicator.widget.bzrwd$bzrwd */
    public class C14498bzrwd extends HwDotsPageIndicatorAnimation.AnimationStateListener {

        /* renamed from: a */
        final /* synthetic */ int f42681a;

        public C14498bzrwd(int i10) {
            this.f42681a = i10;
        }

        @Override // com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicatorAnimation.AnimationStateListener
        /* renamed from: b */
        public void mo54434b() {
            bzrwd.this.mAnimator.m54458c(this.f42681a);
        }
    }

    public bzrwd(Context context, AttributeSet attributeSet, int i10) {
        super(m54623a(context, i10), attributeSet, i10);
        this.mOptions = new com.huawei.uikit.hwdotspageindicator.widget.aauaf();
        this.mWatchOptions = new HwWatchDotsPageIndicatorOptions();
        this.mSpringDamping = f42654l;
        this.mSpringStiffness = f42652j;
        this.mWatchSpringDamping = 0.2f;
        this.mWatchSpringStiffness = 800.0f;
    }

    public void checkThread(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalThreadStateException("Only main thread can call #" + str);
    }

    public TimeInterpolator getAccelerateInterpolator() {
        if (this.f42664c == null) {
            this.f42664c = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54593a();
        }
        return this.f42664c;
    }

    public TimeInterpolator getAlphaInterpolator() {
        if (this.f42663b == null) {
            this.f42663b = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54599b();
        }
        return this.f42663b;
    }

    public TimeInterpolator getDecelerateInterpolator() {
        if (this.f42665d == null) {
            this.f42665d = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54601c();
        }
        return this.f42665d;
    }

    public float getMaxDiffFraction() {
        if (this.f42662a == 0.0f) {
            this.f42662a = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54590a(getAccelerateInterpolator(), getDecelerateInterpolator());
        }
        return this.f42662a;
    }

    public TimeInterpolator getNavigationPointInterpolator() {
        if (this.f42666e == null) {
            this.f42666e = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54603e();
        }
        return this.f42666e;
    }

    public TimeInterpolator getScaleInterpolator() {
        if (this.f42670i == null) {
            this.f42670i = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54602d();
        }
        return this.f42670i;
    }

    public TimeInterpolator getWatchAccelerateInterpolator() {
        if (this.f42664c == null) {
            this.f42664c = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54604f();
        }
        return this.f42664c;
    }

    public TimeInterpolator getWatchDecelerateInterpolator() {
        if (this.f42665d == null) {
            this.f42665d = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54605g();
        }
        return this.f42665d;
    }

    public TimeInterpolator getWatchDotTouchAndSlideInterpolator() {
        if (this.f42669h == null) {
            this.f42669h = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54606h();
        }
        return this.f42669h;
    }

    public TimeInterpolator getWatchTouchFocusAccelerateInterpolator() {
        if (this.f42667f == null) {
            this.f42667f = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54607i();
        }
        return this.f42667f;
    }

    public TimeInterpolator getWatchTouchFocusDecelerateInterpolator() {
        if (this.f42668g == null) {
            this.f42668g = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54608j();
        }
        return this.f42668g;
    }

    public boolean isFocusAccelerateAnimationRunning() {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        return hwDotsPageIndicatorAnimation != null && hwDotsPageIndicatorAnimation.m54472k();
    }

    public boolean isSpringAnimationRunning() {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        return hwDotsPageIndicatorAnimation != null && hwDotsPageIndicatorAnimation.m54476o();
    }

    public boolean isWatchSpringAnimationRunning() {
        HwWatchDotsPageIndicatorAnimation hwWatchDotsPageIndicatorAnimation = this.mWatchAnimator;
        return hwWatchDotsPageIndicatorAnimation != null && hwWatchDotsPageIndicatorAnimation.isWatchSpringAnimationRunning();
    }

    public void perforWatchSpringAnimation(boolean z10, float f10, float f11, HwWatchDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mWatchAnimator != null) {
            this.mWatchAnimator.doSpringAnimationForWatch(z10, new HwWatchDotsPageIndicatorAnimation.Options.Builder().setStartFocusStartAngle(f10).setTargetFocusStartAngle(f11).setStiffness(this.mWatchSpringStiffness).setDamping(this.mWatchSpringDamping).setUpdateListener(animationUpdateListener).create());
        }
    }

    public void performDotCenterXsLayoutAnimation(float[] fArr, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.m54450a(new HwDotsPageIndicatorAnimation.Options.Builder().setStartCenterXs(this.mOptions.m54544e()).setTargetCenterXs(fArr).setDuration(400L).setInterpolator(getAccelerateInterpolator()).setUpdateListener(animationUpdateListener).create());
        }
    }

    public void performFocusAccelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.m54459c(new HwDotsPageIndicatorAnimation.Options.Builder().setStartLoc(f10).setTargetLoc(f11).setDuration(400L).setInterpolator(getAccelerateInterpolator()).setUpdateListener(animationUpdateListener).create());
        }
    }

    public void performFocusSingleZoomInAnimation(RectF rectF, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.m54451a(true, new HwDotsPageIndicatorAnimation.Options.Builder().setStartFocusRectF(this.mOptions.m54566m()).setTargetFocusRectF(rectF).setDuration(f42659q).setInterpolator(getAlphaInterpolator()).setUpdateListener(animationUpdateListener).create());
            this.mOptions.m54529b(true);
        }
    }

    public void performFocusSingleZoomOutAnimation(RectF rectF, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.m54451a(false, new HwDotsPageIndicatorAnimation.Options.Builder().setStartFocusRectF(this.mOptions.m54566m()).setTargetFocusRectF(rectF).setDuration(150L).setInterpolator(getAlphaInterpolator()).setUpdateListener(animationUpdateListener).create());
            this.mOptions.m54529b(false);
        }
    }

    public void performHotZoneInVisibleAnimation(boolean z10, com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar, View view, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.m54462d(new HwDotsPageIndicatorAnimation.Options.Builder().setStartEntity(this.mOptions.m54533c()).setEndEntity(aauafVar).setInterpolator(getAlphaInterpolator()).setDuration(z10 ? 250L : 300L).setUpdateListener(animationUpdateListener).setStateListener(new bqmxo(view)).create());
            this.mOptions.m54583u(-1);
            this.mOptions.m54529b(false);
            this.mOptions.m54524b();
        }
    }

    public void performHotZoneVisibleAnimation(com.huawei.uikit.hwdotspageindicator.widget.aauaf aauafVar, boolean z10, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.m54465e(new HwDotsPageIndicatorAnimation.Options.Builder().setStartEntity(this.mOptions.m54533c()).setEndEntity(aauafVar).setInterpolator(getAlphaInterpolator()).setDuration(250L).setUpdateListener(animationUpdateListener).setStateListener(animationStateListener).create());
        }
    }

    public void performHotZoneVisibleAnimationForWatch(HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions, HwWatchDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mWatchAnimator == null || hwWatchDotsPageIndicatorOptions == null) {
            return;
        }
        this.mWatchAnimator.doVisibleAnimation(new HwWatchDotsPageIndicatorAnimation.Options.Builder().setStartEntity(this.mWatchOptions.deepCopy()).setEndEntity(hwWatchDotsPageIndicatorOptions).setInterpolator(getAlphaInterpolator()).setDuration(250L).setUpdateListener(animationUpdateListener).create());
    }

    public void performSingleDotZoomInAnimation(int i10, float f10, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        if (hwDotsPageIndicatorAnimation != null) {
            hwDotsPageIndicatorAnimation.m54467f(i10);
            this.mAnimator.m54447a(i10, true, new HwDotsPageIndicatorAnimation.Options.Builder().setStartRadius(this.mOptions.m54549g()).setTargetRadius(f10).setDuration(f42659q).setInterpolator(getAlphaInterpolator()).setUpdateListener(animationUpdateListener).setStateListener(new C14498bzrwd(i10)).create());
        }
    }

    public void performSingleDotZoomOutAnimation(int i10, View view, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        HwDotsPageIndicatorAnimation hwDotsPageIndicatorAnimation = this.mAnimator;
        if (hwDotsPageIndicatorAnimation != null) {
            hwDotsPageIndicatorAnimation.m54464e(i10);
            this.mAnimator.m54447a(i10, false, new HwDotsPageIndicatorAnimation.Options.Builder().setStartRadius(this.mOptions.m54588z()).setTargetRadius(this.mOptions.m54549g()).setDuration(150L).setInterpolator(getAlphaInterpolator()).setUpdateListener(animationUpdateListener).setStateListener(new aauaf(i10, view)).create());
        }
    }

    public void performSpringAnimation(akxao akxaoVar, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.m54455b(akxaoVar.f42674a, new HwDotsPageIndicatorAnimation.Options.Builder().setStartLoc(akxaoVar.f42675b).setTargetLoc(akxaoVar.f42676c).setStiffness(akxaoVar.f42677d).setDamping(akxaoVar.f42678e).setUpdateListener(animationUpdateListener).create());
        }
    }

    public void performTargetAccelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.m54459c(new HwDotsPageIndicatorAnimation.Options.Builder().setStartLoc(f10).setTargetLoc(f11).setDuration(400L).setInterpolator(getAccelerateInterpolator()).setUpdateListener(animationUpdateListener).setStateListener(animationStateListener).create());
        }
    }

    public void performTargetDecelerateAnimation(float f10, float f11, HwDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener, HwDotsPageIndicatorAnimation.AnimationStateListener animationStateListener) {
        if (this.mAnimator != null) {
            this.mAnimator.m54454b(new HwDotsPageIndicatorAnimation.Options.Builder().setStartLoc(f10).setTargetLoc(f11).setDuration(400L).setInterpolator(getDecelerateInterpolator()).setUpdateListener(animationUpdateListener).setStateListener(animationStateListener).create());
        }
    }

    public void performWatchHotZoneInVisibleAnimation(HwWatchDotsPageIndicatorOptions hwWatchDotsPageIndicatorOptions, HwWatchDotsPageIndicatorAnimation.AnimationUpdateListener animationUpdateListener) {
        if (this.mWatchAnimator == null || hwWatchDotsPageIndicatorOptions == null) {
            return;
        }
        this.mWatchAnimator.doInvisibleAnimation(new HwWatchDotsPageIndicatorAnimation.Options.Builder().setStartEntity(this.mWatchOptions.deepCopy()).setEndEntity(hwWatchDotsPageIndicatorOptions).setInterpolator(getAlphaInterpolator()).setDuration(250L).setUpdateListener(animationUpdateListener).create());
        this.mWatchOptions.setScaledIndex(-1);
    }

    public void setAlphaInterpolator(TimeInterpolator timeInterpolator) {
        this.f42663b = timeInterpolator;
    }

    public void setDragAccelerateInterpolator(TimeInterpolator timeInterpolator) {
        this.f42664c = timeInterpolator;
        this.f42662a = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54590a(timeInterpolator, getDecelerateInterpolator());
    }

    public void setDragDecelerateInterpolator(TimeInterpolator timeInterpolator) {
        this.f42665d = timeInterpolator;
        this.f42662a = com.huawei.uikit.hwdotspageindicator.widget.bqmxo.m54590a(getAccelerateInterpolator(), this.f42665d);
    }

    public void setScaleInterpolator(TimeInterpolator timeInterpolator) {
        this.f42670i = timeInterpolator;
    }

    public void setSpringAnimationDamping(float f10) {
        if (f10 <= 0.0f) {
            f10 = this.mSpringDamping;
        }
        this.mSpringDamping = f10;
    }

    public void setSpringAnimationStiffness(float f10) {
        if (f10 <= 0.0f) {
            f10 = this.mSpringStiffness;
        }
        this.mSpringStiffness = f10;
    }

    public void stopSpringAnimation() {
        if (isSpringAnimationRunning()) {
            this.mAnimator.m54484w();
        }
    }

    public void stopWatchSpringAnimation() {
        if (isWatchSpringAnimationRunning()) {
            this.mWatchAnimator.stopWatchSpringAnimation();
        }
    }

    /* renamed from: a */
    private static Context m54623a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8711R.style.Theme_Emui_HwDotsPageIndicator);
    }

    /* renamed from: a */
    public void m54624a(View view) {
        if (this.mOptions.m54508F()) {
            return;
        }
        this.mOptions.m54524b();
        view.invalidate();
    }
}
