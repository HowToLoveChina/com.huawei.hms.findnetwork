package com.huawei.uikit.hwprogressbar.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import com.huawei.uikit.animations.drawable.HwGravitationalLoadingDrawable;
import com.huawei.uikit.animations.drawable.HwLowFrameLoadingDrawable;
import com.huawei.uikit.animations.drawable.HwSeekableGravitationalLoadingDrawable;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwprogressbar.C8718R;
import com.huawei.uikit.hwprogressbar.graphics.drawable.HwFlickerDrawable;
import com.huawei.uikit.hwprogressbar.graphics.drawable.HwLoadingDrawableImpl;
import com.huawei.uikit.hwprogressbar.graphics.drawable.HwProgressRingDrawable;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes2.dex */
public class HwProgressBar extends ProgressBar {

    /* renamed from: A */
    private static final int f43114A = 2;

    /* renamed from: B */
    private static final String f43115B = "hw_sc.platform.ux_level";

    /* renamed from: C */
    private static final String f43116C = "android.os.SystemProperties";

    /* renamed from: E */
    private static final String f43118E = "getInt";

    /* renamed from: F */
    private static final int f43119F = 200;

    /* renamed from: G */
    private static final int f43120G = 200;

    /* renamed from: H */
    private static Method f43121H = null;

    /* renamed from: I */
    private static final int f43122I = 10000;

    /* renamed from: J */
    private static final int f43123J = 1728053247;

    /* renamed from: K */
    private static final int f43124K = 300;

    /* renamed from: L */
    private static final float f43125L = 0.8f;

    /* renamed from: N */
    private static final float f43127N = 1.0f;

    /* renamed from: O */
    private static final int f43128O = 2000;

    /* renamed from: P */
    private static final int f43129P = 5000;

    /* renamed from: s */
    private static final String f43130s = "HwProgressBar";

    /* renamed from: t */
    private static final int f43131t = 15;

    /* renamed from: u */
    private static final int f43132u = -11711155;

    /* renamed from: v */
    private static final float f43133v = 0.38f;

    /* renamed from: w */
    private static final float f43134w = 0.1f;

    /* renamed from: x */
    private static final float f43135x = 0.0f;

    /* renamed from: y */
    private static final float f43136y = 0.93f;

    /* renamed from: z */
    private static final int f43137z = 0;

    /* renamed from: a */
    private int f43138a;

    /* renamed from: b */
    private int f43139b;

    /* renamed from: c */
    private int f43140c;

    /* renamed from: d */
    private int f43141d;

    /* renamed from: e */
    private int f43142e;

    /* renamed from: f */
    private HwProgressRingDrawable f43143f;

    /* renamed from: g */
    private HwFlickerDrawable f43144g;

    /* renamed from: h */
    private boolean f43145h;

    /* renamed from: i */
    private float f43146i;

    /* renamed from: j */
    private ObjectAnimator f43147j;

    /* renamed from: k */
    private Method f43148k;

    /* renamed from: l */
    private Field f43149l;

    /* renamed from: m */
    private HwGravitationalLoadingDrawable.ParamsBundle f43150m;
    protected int mFillColor;

    /* renamed from: n */
    private int f43151n;

    /* renamed from: o */
    private long f43152o;

    /* renamed from: p */
    private OnVisualProgressChangedListener f43153p;

    /* renamed from: q */
    private OnSetProgressAnimationDurationListener f43154q;

    /* renamed from: r */
    private final Property<HwProgressBar, Float> f43155r;

    /* renamed from: D */
    private static final int f43117D = reflectGetUxLevel();

    /* renamed from: M */
    private static final DecelerateInterpolator f43126M = new DecelerateInterpolator(0.8f);

    public interface OnSetProgressAnimationDurationListener {
        long getAnimationDuration(float f10);
    }

    public interface OnVisualProgressChangedListener {
        void onVisualProgressChanged(HwProgressBar hwProgressBar, float f10);
    }

    public HwProgressBar(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    private void m54763b(Context context, AttributeSet attributeSet, int i10) {
        int i11 = C8718R.style.Widget_Emui_HwProgressBar;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8718R.styleable.HwGravitationalLoadingAnimation, i10, i11);
        this.f43151n = typedArrayObtainStyledAttributes.getInteger(C8718R.styleable.HwGravitationalLoadingAnimation_hwProgressBarDuration, 1200);
        this.f43150m = typedArrayObtainStyledAttributes.getBoolean(C8718R.styleable.HwGravitationalLoadingAnimation_hwProgressBarGlowingEnabled, false) ? HwGravitationalLoadingDrawable.ParamsBundle.parseForNightMode(context, attributeSet, i10, i11) : HwGravitationalLoadingDrawable.ParamsBundle.parse(context, attributeSet, i10, i11);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: c */
    private void m54764c() {
        this.f43148k = null;
        this.f43149l = null;
    }

    /* renamed from: d */
    private void m54767d(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8718R.styleable.HwLowFrameLoadingDrawable, i10, C8718R.style.Widget_Emui_HwProgressBar);
        int integer = typedArrayObtainStyledAttributes.getInteger(C8718R.styleable.HwLowFrameLoadingDrawable_hwLowFrameLoadingDuration, 600);
        int integer2 = typedArrayObtainStyledAttributes.getInteger(C8718R.styleable.HwLowFrameLoadingDrawable_hwDrawableBitmapSize, 50);
        typedArrayObtainStyledAttributes.recycle();
        setIndeterminateDrawable(new HwLowFrameLoadingDrawable(getResources(), integer2, integer));
    }

    /* renamed from: e */
    private boolean m54768e() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: f */
    private void m54769f() {
        int max = getMax() - (getBuildSdkVersion() >= 26 ? getMin() : 0);
        float progress = max > 0 ? (getProgress() - r2) / max : 0.0f;
        float fFloatValue = this.f43155r.get(this).floatValue();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, this.f43155r, Float.compare(fFloatValue, 1.0f) != 0 ? fFloatValue : 0.0f, progress);
        this.f43147j = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setAutoCancel(true);
        this.f43147j.setDuration(m54753a(progress));
        this.f43147j.setInterpolator(f43126M);
        this.f43147j.start();
    }

    /* renamed from: g */
    private void m54770g() {
        Drawable progressLayerDrawable;
        if (this.f43144g == null || (progressLayerDrawable = getProgressLayerDrawable()) == null) {
            return;
        }
        Rect bounds = progressLayerDrawable.getBounds();
        int iM54752a = m54752a(progressLayerDrawable);
        int i10 = ((bounds.top + bounds.bottom) - iM54752a) / 2;
        this.f43144g.setBounds(bounds.left, i10, bounds.right, iM54752a + i10);
    }

    private int getBuildSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    private Drawable getProgressLayerDrawable() {
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable == null || !(progressDrawable instanceof LayerDrawable)) {
            return null;
        }
        return ((LayerDrawable) progressDrawable).findDrawableByLayerId(R.id.progress);
    }

    private int getVisualProgress() {
        Drawable progressLayerDrawable = getProgressLayerDrawable();
        if (progressLayerDrawable != null) {
            return progressLayerDrawable.getLevel();
        }
        return 0;
    }

    /* renamed from: h */
    private void m54771h() {
        HwFlickerDrawable hwFlickerDrawable;
        if (isFlickerEnable() && (hwFlickerDrawable = this.f43144g) != null) {
            hwFlickerDrawable.start();
            setFlickerLevel(getVisualProgress());
        }
    }

    /* renamed from: i */
    private void m54772i() {
        HwFlickerDrawable hwFlickerDrawable;
        if (isFlickerEnable() && (hwFlickerDrawable = this.f43144g) != null) {
            hwFlickerDrawable.pause();
        }
    }

    public static HwProgressBar instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwProgressBar.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwProgressBar.class);
        if (objInstantiate instanceof HwProgressBar) {
            return (HwProgressBar) objInstantiate;
        }
        return null;
    }

    public static int reflectGetUxLevel() {
        if (f43121H == null) {
            f43121H = HwReflectUtil.getMethod(f43118E, new Class[]{String.class, Integer.TYPE}, f43116C);
        }
        Method method = f43121H;
        if (method == null) {
            return 200;
        }
        Object objInvokeMethod = HwReflectUtil.invokeMethod(null, method, new Object[]{f43115B, 200});
        if (objInvokeMethod instanceof Integer) {
            return ((Integer) objInvokeMethod).intValue();
        }
        return 200;
    }

    private void setFlickerLevel(int i10) {
        HwFlickerDrawable hwFlickerDrawable = this.f43144g;
        if (hwFlickerDrawable == null || !hwFlickerDrawable.isRunning()) {
            return;
        }
        this.f43144g.setLevel(i10);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public CharSequence getAccessibilityClassName() {
        return !isIndeterminate() ? ProgressBar.class.getName() : "";
    }

    public int getFlickerColor() {
        return this.f43142e;
    }

    public void initEmuiStyle() {
        if (f43117D >= 200) {
            setIndeterminateDrawable(HwSeekableGravitationalLoadingDrawable.create(this.mFillColor, this.f43150m, getResources().getDisplayMetrics(), this.f43151n));
        } else {
            setIndeterminateDrawable(new HwLoadingDrawableImpl(getResources(), getMinimumWidth() > getMinimumHeight() ? getMinimumHeight() : getMinimumWidth(), this.mFillColor));
        }
        setInterpolator(new HwCubicBezierInterpolator(0.38f, 0.1f, 0.0f, f43136y));
    }

    public synchronized void initialize(Context context, AttributeSet attributeSet, int i10) {
        if (m54761a(context, attributeSet, i10)) {
            m54767d(context, attributeSet, i10);
            return;
        }
        m54763b(context, attributeSet, i10);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8718R.styleable.HwProgressBar, i10, C8718R.style.Widget_Emui_HwProgressBar);
        try {
            this.f43138a = typedArrayObtainStyledAttributes.getInt(C8718R.styleable.HwProgressBar_hwProgressBarRingType, 0);
            this.mFillColor = typedArrayObtainStyledAttributes.getColor(C8718R.styleable.HwProgressBar_hwFillColor, f43132u);
            this.f43141d = typedArrayObtainStyledAttributes.getColor(C8718R.styleable.HwProgressBar_hwProgressBarRingTrackColor, getResources().getColor(C8718R.color.emui_control_normal_dark));
            this.f43139b = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8718R.styleable.HwProgressBar_hwProgressBarRingWidth, 0);
            this.f43140c = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8718R.styleable.HwProgressBar_hwProgressBarTickWidth, 0);
            this.f43142e = typedArrayObtainStyledAttributes.getColor(C8718R.styleable.HwProgressBar_hwFlickerColor, f43123J);
            this.f43145h = typedArrayObtainStyledAttributes.getBoolean(C8718R.styleable.HwProgressBar_hwFlickerEnable, false);
            initEmuiStyle();
            m54766d();
            m54762b();
            if (this.f43149l == null && this.f43148k == null) {
                m54764c();
            }
        } catch (Resources.NotFoundException unused) {
            Log.e(f43130s, "Resource not found in initialize.");
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        if (drawable == this.f43144g) {
            invalidate();
        }
    }

    public boolean isFlickerEnable() {
        return this.f43145h;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        try {
            if (this.f43143f != null) {
                m54755a();
            } else {
                super.onDraw(canvas);
                m54759a(canvas);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (isIndeterminate()) {
                return;
            }
            accessibilityNodeInfo.setFocusable(true);
            accessibilityNodeInfo.setContentDescription(String.format(Locale.ROOT, "%d%%", Integer.valueOf(getProgress())));
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        m54770g();
    }

    public synchronized void setFillColor(int i10) {
        this.mFillColor = i10;
        HwProgressRingDrawable hwProgressRingDrawable = this.f43143f;
        if (hwProgressRingDrawable != null) {
            hwProgressRingDrawable.setFillColor(i10);
        }
    }

    public void setFlickerColor(int i10) {
        this.f43142e = i10;
        HwFlickerDrawable hwFlickerDrawable = this.f43144g;
        if (hwFlickerDrawable != null) {
            hwFlickerDrawable.setFlickerColor(i10);
        }
    }

    public void setFlickerEnable(boolean z10) {
        setFlickerEnable(z10, false);
    }

    public void setOnSetProgressAnimationDurationListener(OnSetProgressAnimationDurationListener onSetProgressAnimationDurationListener) {
        this.f43154q = onSetProgressAnimationDurationListener;
    }

    public void setOnVisualProgressChangedListener(OnVisualProgressChangedListener onVisualProgressChangedListener) {
        this.f43153p = onVisualProgressChangedListener;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i10) {
        super.setProgress(i10);
        m54758a(i10, false);
    }

    public synchronized void setRingTrackColor(int i10) {
        this.f43141d = i10;
        HwProgressRingDrawable hwProgressRingDrawable = this.f43143f;
        if (hwProgressRingDrawable != null) {
            hwProgressRingDrawable.setTrackColor(i10);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f43144g;
    }

    public class bzrwd extends Property<HwProgressBar, Float> {
        public bzrwd(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(HwProgressBar hwProgressBar, Float f10) {
            if (hwProgressBar == null) {
                return;
            }
            hwProgressBar.m54756a(R.id.progress, f10.floatValue());
            hwProgressBar.f43146i = f10.floatValue();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(HwProgressBar hwProgressBar) {
            return Float.valueOf(hwProgressBar.f43146i);
        }
    }

    public HwProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8718R.attr.hwProgressBarStyle);
    }

    public void setFlickerEnable(boolean z10, boolean z11) {
        if (this.f43145h == z10) {
            return;
        }
        this.f43145h = z10;
        HwFlickerDrawable hwFlickerDrawable = this.f43144g;
        if (hwFlickerDrawable == null) {
            return;
        }
        if (z10) {
            m54771h();
        } else if (z11) {
            hwFlickerDrawable.stop();
        } else {
            hwFlickerDrawable.pause();
        }
    }

    public HwProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(m54754a(context, i10), attributeSet, i10);
        this.f43145h = false;
        this.f43152o = 0L;
        this.f43155r = new bzrwd(Float.class, "visual_progress");
        m54765c(super.getContext(), attributeSet, i10);
    }

    /* renamed from: c */
    private void m54765c(Context context, AttributeSet attributeSet, int i10) {
        initialize(context, attributeSet, i10);
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i10, boolean z10) {
        super.setProgress(i10, z10);
        if (z10) {
            m54769f();
        }
        m54758a(i10, z10);
    }

    /* renamed from: a */
    private void m54758a(int i10, boolean z10) {
        int max;
        if (this.f43143f != null) {
            m54755a();
        }
        int min = getBuildSdkVersion() >= 26 ? getMin() : 0;
        if (i10 > min && i10 < getMax()) {
            m54771h();
        } else {
            m54772i();
        }
        if (z10 || !isFlickerEnable() || (max = getMax() - min) == 0) {
            return;
        }
        setFlickerLevel((int) (((i10 - min) / max) * 10000.0f));
    }

    /* renamed from: d */
    private void m54766d() {
        int i10 = this.f43138a;
        if (i10 == 1 || i10 == 2) {
            int max = getMax();
            if (max == 0) {
                Log.e(f43130s, "The max is 0 in initRingDrawable.");
                return;
            }
            HwProgressRingDrawable hwProgressRingDrawable = new HwProgressRingDrawable();
            this.f43143f = hwProgressRingDrawable;
            hwProgressRingDrawable.setType(this.f43138a);
            this.f43143f.setFillColor(this.mFillColor);
            this.f43143f.setTrackColor(this.f43141d);
            this.f43143f.setRingWidth(this.f43139b);
            this.f43143f.setTickWidth(this.f43140c);
            this.f43143f.setRatio(getProgress() / max);
            setBackground(this.f43143f);
        }
    }

    /* renamed from: b */
    private void m54762b() {
        if (f43117D < 200) {
            return;
        }
        HwFlickerDrawable hwFlickerDrawable = new HwFlickerDrawable();
        this.f43144g = hwFlickerDrawable;
        hwFlickerDrawable.setFlickerColor(this.f43142e);
        this.f43144g.setCallback(this);
        m54770g();
        if (getProgress() <= (getBuildSdkVersion() >= 26 ? getMin() : 0) || getProgress() >= getMax() || !isFlickerEnable()) {
            return;
        }
        this.f43144g.setLevel(getVisualProgress());
        this.f43144g.start();
    }

    /* renamed from: a */
    private void m54757a(int i10, int i11) throws IllegalAccessException, IllegalArgumentException {
        if (isIndeterminate()) {
            return;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i11 > getMax()) {
            i11 = getMax();
        }
        if (i11 != getProgress()) {
            if (this.f43149l == null && this.f43148k == null) {
                m54764c();
            }
            Field field = this.f43149l;
            if (field != null) {
                try {
                    field.set(this, Integer.valueOf(i11));
                } catch (IllegalAccessException unused) {
                    Log.e(f43130s, "Field IllegalAccessException");
                }
            }
            Method method = this.f43148k;
            if (method != null) {
                HwReflectUtil.invokeMethod(this, method, new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Boolean.FALSE});
            }
        }
    }

    /* renamed from: a */
    private long m54753a(float f10) {
        OnSetProgressAnimationDurationListener onSetProgressAnimationDurationListener = this.f43154q;
        if (onSetProgressAnimationDurationListener != null) {
            return onSetProgressAnimationDurationListener.getAnimationDuration(f10);
        }
        long jAbs = Float.compare(f10, this.f43146i) != 0 ? (long) Math.abs((f10 - this.f43146i) * 2000.0f) : 0L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Float.compare(f10, 1.0f) == 0) {
            jAbs = Math.min(300L, jAbs);
        } else if (this.f43152o != 0 && Float.compare(f10, 0.0f) > 0) {
            jAbs = Math.min(Math.max(jAbs, jCurrentTimeMillis - this.f43152o), 5000L);
        }
        this.f43152o = jCurrentTimeMillis;
        return jAbs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m54756a(int i10, float f10) {
        this.f43146i = f10;
        Drawable progressDrawable = getProgressDrawable();
        if ((progressDrawable instanceof LayerDrawable) && (progressDrawable = ((LayerDrawable) progressDrawable).findDrawableByLayerId(i10)) == null) {
            progressDrawable = getProgressDrawable();
        }
        int i11 = (int) (10000.0f * f10);
        setFlickerLevel(i11);
        if (progressDrawable != null) {
            progressDrawable.setLevel(i11);
        } else {
            invalidate();
        }
        OnVisualProgressChangedListener onVisualProgressChangedListener = this.f43153p;
        if (onVisualProgressChangedListener != null) {
            onVisualProgressChangedListener.onVisualProgressChanged(this, f10);
        }
    }

    /* renamed from: a */
    private void m54759a(Canvas canvas) {
        if ((isFlickerEnable() || this.f43144g != null) && !isIndeterminate()) {
            if (this.f43144g == null) {
                m54762b();
            }
            int iSave = canvas.save();
            if (m54768e()) {
                canvas.translate(getWidth() - getPaddingRight(), getPaddingTop());
                canvas.scale(-1.0f, 1.0f);
            } else {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            HwFlickerDrawable hwFlickerDrawable = this.f43144g;
            if (hwFlickerDrawable != null) {
                hwFlickerDrawable.draw(canvas);
            }
            canvas.restoreToCount(iSave);
        }
    }

    /* renamed from: a */
    private static Context m54754a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8718R.style.Theme_Emui_HwProgressBar);
    }

    /* renamed from: a */
    private boolean m54761a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8718R.styleable.HwProgressBar, i10, C8718R.style.Widget_Emui_HwProgressBar);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(C8718R.styleable.HwProgressBar_hwLowFrameLoading, false);
        typedArrayObtainStyledAttributes.recycle();
        return z10;
    }

    /* renamed from: a */
    private void m54755a() {
        int max = getMax();
        if (max == 0) {
            Log.e(f43130s, "The max is 0 in setProgress.");
        } else {
            this.f43143f.setRatio(getProgress() / max);
        }
    }

    /* renamed from: a */
    private int m54752a(Drawable drawable) {
        if (drawable == null) {
            return 0;
        }
        Rect bounds = drawable.getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            return 0;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bounds.right, bounds.bottom, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int level = drawable.getLevel();
        drawable.setLevel(10000);
        drawable.draw(canvas);
        drawable.setLevel(level);
        int i10 = 0;
        for (int i11 = 0; i11 < bitmapCreateBitmap.getHeight(); i11++) {
            if (bitmapCreateBitmap.getPixel(bounds.right / 2, i11) != 0) {
                i10++;
            }
        }
        return i10;
    }
}
