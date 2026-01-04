package com.huawei.uikit.hwscrollbarview.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Interpolator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwcommon.utils.HwVibrateUtil;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwscrollbarview.C8733R;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import p757x.C13669a;

/* loaded from: classes5.dex */
public class HwScrollbarView extends View {

    /* renamed from: A */
    private static final int f44040A = 1750;

    /* renamed from: B */
    private static final int f44041B = 250;

    /* renamed from: C */
    private static final int f44042C = 50;

    /* renamed from: D */
    private static final int f44043D = 0;

    /* renamed from: E */
    private static final int f44044E = 1;

    /* renamed from: F */
    private static final int f44045F = 2;

    /* renamed from: G */
    private static final int f44046G = 48;

    /* renamed from: H */
    private static final int f44047H = 16;
    protected static final float HALF_FACTOR = 0.5f;

    /* renamed from: I */
    private static final int f44048I = 255;

    /* renamed from: J */
    private static final int f44049J = 192;

    /* renamed from: K */
    private static final int f44050K = 48;

    /* renamed from: L */
    private static final float f44051L = 35.0f;

    /* renamed from: M */
    private static final float f44052M = 110.0f;

    /* renamed from: N */
    private static final int f44053N = 0;

    /* renamed from: O */
    private static final HwScrollBind f44054O = new HwScrollBindApi23Impl();

    /* renamed from: P */
    private static Method f44055P = null;

    /* renamed from: Q */
    private static Method f44056Q = null;

    /* renamed from: R */
    private static Method f44057R = null;
    protected static final float REVERSE_FACTOR = -1.0f;
    protected static final String TAG = "HwScrollbarView";
    protected static final int THUMB_TYPE_ARC = 1;
    protected static final int THUMB_TYPE_LINE = 0;

    /* renamed from: w */
    private static final int f44058w = 15;

    /* renamed from: x */
    private static final int f44059x = -1;

    /* renamed from: y */
    private static final int f44060y = 16777215;

    /* renamed from: z */
    private static final int f44061z = 1750;

    /* renamed from: a */
    private int f44062a;

    /* renamed from: b */
    private int f44063b;

    /* renamed from: c */
    private int f44064c;

    /* renamed from: d */
    private int f44065d;

    /* renamed from: e */
    private int f44066e;

    /* renamed from: f */
    private float f44067f;

    /* renamed from: g */
    private boolean f44068g;

    /* renamed from: h */
    private int f44069h;

    /* renamed from: i */
    private View f44070i;

    /* renamed from: j */
    private WeakReference<ViewTreeObserver> f44071j;

    /* renamed from: k */
    private OnFastScrollListener f44072k;

    /* renamed from: l */
    private boolean f44073l;

    /* renamed from: m */
    private boolean f44074m;
    protected int mMinThumbLength;
    protected float mStartAngle;
    protected float mSweepAngle;
    protected int mThumbAlpha;
    protected Drawable mThumbDrawable;
    protected int mThumbLength;
    protected int mThumbOffset;
    protected Rect mThumbRect;
    protected int mThumbTint;
    protected Rect mThumbTouchHotRect;
    protected int mThumbTouchHotWidth;
    protected int mThumbType;
    protected int mThumbWidth;
    protected Drawable mTrackDrawable;
    protected int mTrackLength;
    protected Rect mTrackRect;
    protected int mTrackTint;
    protected int mTrackWidth;

    /* renamed from: n */
    private boolean f44075n;

    /* renamed from: o */
    private HwOverScrollProxy f44076o;

    /* renamed from: p */
    private boolean f44077p;

    /* renamed from: q */
    private int f44078q;

    /* renamed from: r */
    private int f44079r;

    /* renamed from: s */
    private int f44080s;

    /* renamed from: t */
    private akxao f44081t;

    /* renamed from: u */
    private View.OnTouchListener f44082u;

    /* renamed from: v */
    private ViewTreeObserver.OnGlobalLayoutListener f44083v;

    public interface OnFastScrollListener {
        void onFastScrollChanged(int i10, int i11, float f10);
    }

    @Deprecated
    public interface OnTouchOffsetListener {
        void onTouchOffset(int i10, int i11, boolean z10);
    }

    public class aauaf implements ViewTreeObserver.OnGlobalLayoutListener {
        public aauaf() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
            int scrollableViewVerticalScrollRange = HwScrollbarView.this.getScrollableViewVerticalScrollRange();
            int scrollableViewVerticalScrollExtent = HwScrollbarView.this.getScrollableViewVerticalScrollExtent();
            HwScrollbarView.this.f44075n = scrollableViewVerticalScrollRange > scrollableViewVerticalScrollExtent;
        }
    }

    public static class akxao implements Runnable {

        /* renamed from: f */
        static final int f44085f = 0;

        /* renamed from: g */
        static final int f44086g = 1;

        /* renamed from: h */
        static final int f44087h = 2;

        /* renamed from: i */
        private static final int f44088i = 2;

        /* renamed from: j */
        private static final int f44089j = 1;

        /* renamed from: k */
        private static final float[] f44090k = {255.0f};

        /* renamed from: l */
        private static final float[] f44091l = {0.0f};

        /* renamed from: a */
        private HwScrollbarView f44092a;

        /* renamed from: b */
        private float[] f44093b;

        /* renamed from: c */
        private final Interpolator f44094c;

        /* renamed from: d */
        private long f44095d;

        /* renamed from: e */
        private int f44096e;

        private akxao() {
            this.f44093b = new float[1];
            this.f44094c = new Interpolator(1, 2);
            this.f44096e = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis >= this.f44095d) {
                int i10 = (int) jCurrentAnimationTimeMillis;
                Interpolator interpolator = this.f44094c;
                interpolator.setKeyFrame(0, i10, f44090k);
                interpolator.setKeyFrame(1, i10 + this.f44092a.f44062a, f44091l);
                this.f44096e = 2;
                this.f44092a.invalidate();
            }
        }

        public /* synthetic */ akxao(bzrwd bzrwdVar) {
            this();
        }
    }

    public class bqmxo implements Runnable {
        public bqmxo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwScrollbarView.this.m55481w();
        }
    }

    public class bzrwd implements View.OnTouchListener {
        public bzrwd() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (HwScrollbarView.this.m55470l()) {
                return true;
            }
            HwScrollbarView.this.m55449a(motionEvent);
            return false;
        }
    }

    static {
        try {
            f44055P = View.class.getDeclaredMethod("computeVerticalScrollRange", new Class[0]);
        } catch (NoSuchMethodException unused) {
            f44055P = null;
            Log.w(TAG, "NoSuchMethodException computeVerticalScrollRange");
        }
        try {
            f44056Q = View.class.getDeclaredMethod("computeVerticalScrollExtent", new Class[0]);
        } catch (NoSuchMethodException unused2) {
            f44056Q = null;
            Log.w(TAG, "NoSuchMethodException computeVerticalScrollExtent");
        }
        try {
            f44057R = View.class.getDeclaredMethod("computeVerticalScrollOffset", new Class[0]);
        } catch (NoSuchMethodException unused3) {
            f44057R = null;
            Log.w(TAG, "NoSuchMethodException computeVerticalScrollOffset");
        }
    }

    public HwScrollbarView(Context context) {
        this(context, null);
    }

    /* renamed from: d */
    private void m55461d() {
        int i10 = this.f44080s;
        if (i10 > 0) {
            m55462d(i10);
        } else {
            m55481w();
        }
    }

    /* renamed from: e */
    private void m55463e() {
        if (m55469k()) {
            setThumbShow(false);
            invalidate();
        }
    }

    /* renamed from: f */
    private void m55464f() {
        HwOverScrollProxy hwOverScrollProxy = this.f44076o;
        if (hwOverScrollProxy == null) {
            return;
        }
        if (hwOverScrollProxy.isOverScroll()) {
            if (this.f44077p) {
                return;
            }
            m55471m();
        } else if (this.f44077p) {
            m55472n();
        }
    }

    /* renamed from: g */
    private void m55465g() {
        m55479u();
        invalidate();
    }

    public static HwScrollBind getHwScrollBindImpl() {
        return f44054O;
    }

    private float getScrollProgress() {
        return (this.mThumbOffset * 1.0f) / (this.mTrackLength - this.mThumbLength);
    }

    /* renamed from: h */
    private boolean m55466h() {
        String language = Locale.getDefault().getLanguage();
        boolean z10 = true;
        boolean z11 = language.contains(Constants.AR_CACHE) || language.contains("fa") || language.contains("iw");
        if (!language.contains("ug") && !language.contains(Constants.URDU_LANG)) {
            z10 = false;
        }
        return z11 | z10;
    }

    /* renamed from: i */
    private boolean m55467i() {
        return this.f44069h != 0;
    }

    public static HwScrollbarView instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwScrollbarView.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwScrollbarView.class);
        if (objInstantiate instanceof HwScrollbarView) {
            return (HwScrollbarView) objInstantiate;
        }
        return null;
    }

    /* renamed from: j */
    private boolean m55468j() {
        akxao akxaoVar = this.f44081t;
        return akxaoVar != null && akxaoVar.f44096e == 0;
    }

    /* renamed from: k */
    private boolean m55469k() {
        return this.f44073l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public boolean m55470l() {
        return this.f44063b != 0;
    }

    /* renamed from: m */
    private void m55471m() {
        this.f44077p = true;
        this.f44079r = this.mThumbRect.height();
    }

    /* renamed from: n */
    private void m55472n() {
        m55475q();
    }

    /* renamed from: o */
    private void m55473o() {
        m55445a(1750);
    }

    /* renamed from: p */
    private void m55474p() {
        ViewTreeObserver viewTreeObserver;
        WeakReference<ViewTreeObserver> weakReference = this.f44071j;
        if (weakReference == null || this.f44083v == null || (viewTreeObserver = weakReference.get()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.f44083v);
    }

    /* renamed from: q */
    private void m55475q() {
        this.f44077p = false;
    }

    /* renamed from: r */
    private void m55476r() {
        removeCallbacks(this.f44081t);
        akxao akxaoVar = this.f44081t;
        if (akxaoVar != null) {
            akxaoVar.f44096e = 1;
        }
        if (!m55469k()) {
            setThumbShow(true);
        }
        m55465g();
    }

    /* renamed from: s */
    private void m55477s() {
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    private void setThumbShow(boolean z10) {
        this.f44073l = z10;
    }

    /* renamed from: t */
    private void m55478t() {
        updateTrackRect();
        m55479u();
    }

    /* renamed from: u */
    private void m55479u() {
        if (this.f44070i == null) {
            return;
        }
        m55446a(getScrollableViewVerticalScrollRange(), getScrollableViewVerticalScrollExtent(), getScrollableViewVerticalScrollOffset());
    }

    /* renamed from: v */
    private void m55480v() {
        int width = getWidth() - getPaddingRight();
        int paddingLeft = width - this.mThumbWidth;
        int paddingTop = getPaddingTop() + this.mThumbOffset;
        int i10 = this.mThumbLength + paddingTop;
        if (isScrollbarLayoutRtl()) {
            paddingLeft = getPaddingLeft();
            width = this.mThumbWidth + paddingLeft;
        }
        this.mThumbRect.set(paddingLeft, paddingTop, width, i10);
        updateThumbTouchHotRect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m55481w() {
        if (isHapticFeedbackEnabled()) {
            HwVibrateUtil.vibrator(this, 9, 0);
        }
    }

    public void adjustOverScrollThumbParameters() {
        int overScrollOffset;
        if (isOverScrolling() && (overScrollOffset = this.f44076o.getOverScrollOffset()) != 0) {
            int i10 = this.f44078q;
            int iAbs = this.f44079r - Math.abs(overScrollOffset);
            this.mThumbLength = iAbs;
            if (iAbs < i10) {
                this.mThumbLength = i10;
            }
            if (overScrollOffset > 0) {
                this.mThumbOffset = this.mTrackLength - this.mThumbLength;
            } else {
                this.mThumbOffset = 0;
            }
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m55477s();
    }

    public int getFadeTime() {
        return this.f44062a;
    }

    public HwOverScrollProxy getHwOverScrollProxy(HwOverScrollProxy hwOverScrollProxy) {
        return this.f44076o;
    }

    public View getScrollableView() {
        return this.f44070i;
    }

    public int getScrollableViewVerticalScrollExtent() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        if (this.f44070i != null && (method = f44056Q) != null) {
            try {
                method.setAccessible(true);
                Object objInvoke = f44056Q.invoke(this.f44070i, new Object[0]);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException unused) {
                Log.w(TAG, "IllegalAccessException computeVerticalScrollExtent");
            } catch (InvocationTargetException unused2) {
                Log.w(TAG, "InvocationTargetException computeVerticalScrollExtent");
            }
        }
        return -1;
    }

    public int getScrollableViewVerticalScrollOffset() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        if (this.f44070i != null && (method = f44057R) != null) {
            try {
                method.setAccessible(true);
                Object objInvoke = f44057R.invoke(this.f44070i, new Object[0]);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException unused) {
                Log.w(TAG, "IllegalAccessException computeVerticalScrollOffset");
            } catch (InvocationTargetException unused2) {
                Log.w(TAG, "InvocationTargetException computeVerticalScrollOffset");
            }
        }
        return -1;
    }

    public int getScrollableViewVerticalScrollRange() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        if (this.f44070i != null && (method = f44055P) != null) {
            try {
                method.setAccessible(true);
                Object objInvoke = f44055P.invoke(this.f44070i, new Object[0]);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException unused) {
                Log.w(TAG, "IllegalAccessException computeVerticalScrollRange");
            } catch (InvocationTargetException unused2) {
                Log.w(TAG, "InvocationTargetException computeVerticalScrollRange");
            }
        }
        return -1;
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public float getSweepAngle() {
        return this.mSweepAngle;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public int getThumbTint() {
        return this.mThumbTint;
    }

    public boolean isOverScrolling() {
        return this.f44077p;
    }

    public boolean isScrollbarLayoutRtl() {
        return getLayoutDirection() == 1 || m55466h();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m55444a();
        m55445a(1750);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m55474p();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f44075n) {
            m55456b(canvas);
            m55448a(canvas);
        }
    }

    public void onDrawArcThumb(Canvas canvas) {
    }

    public void onDrawLineThumb(Canvas canvas) {
        Drawable drawable = this.mThumbDrawable;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(this.mThumbRect);
        drawable.mutate().setAlpha(this.mThumbAlpha);
        drawable.draw(canvas);
    }

    public void onDrawThumb(Canvas canvas) {
        if (this.mThumbType == 1) {
            onDrawArcThumb(canvas);
        } else {
            onDrawLineThumb(canvas);
        }
    }

    public void onDrawTrack(Canvas canvas) {
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(this.mTrackRect);
        drawable.draw(canvas);
    }

    @Override // android.view.View
    public void onHoverChanged(boolean z10) {
        if (z10) {
            m55476r();
        } else {
            m55473o();
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            setHovered(true);
        } else if (action == 10) {
            setHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (z10) {
            m55478t();
        }
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            mode = 0;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), i11);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        m55455b(i10);
        super.onRtlPropertiesChanged(i10);
    }

    public void onScrollChanged() {
        if (getVisibility() != 0 || m55470l()) {
            return;
        }
        if (!this.f44074m) {
            this.f44074m = m55460c();
        }
        if (!this.f44074m) {
            m55463e();
            return;
        }
        m55464f();
        m55476r();
        m55473o();
    }

    public void onScrollableViewTouchEvent(View view, MotionEvent motionEvent) {
        if (this.f44070i == view && !m55470l()) {
            m55449a(motionEvent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            boolean r1 = r6.m55468j()
            if (r1 != 0) goto L81
            boolean r1 = r6.m55467i()
            if (r1 == 0) goto L12
            goto L81
        L12:
            float r1 = r7.getX()
            int r1 = (int) r1
            float r2 = r7.getY()
            int r2 = (int) r2
            int r7 = r7.getAction()
            r3 = 1
            if (r7 == 0) goto L66
            if (r7 == r3) goto L5a
            r1 = 2
            if (r7 == r1) goto L2c
            r1 = 3
            if (r7 == r1) goto L5a
            goto L7c
        L2c:
            int r7 = r6.f44064c
            int r7 = r2 - r7
            int r4 = r6.f44063b
            if (r4 != r3) goto L50
            int r4 = java.lang.Math.abs(r7)
            int r5 = r6.f44066e
            if (r4 < r5) goto L50
            r6.f44063b = r1
            android.view.ViewParent r4 = r6.getParent()
            if (r4 == 0) goto L47
            r4.requestDisallowInterceptTouchEvent(r3)
        L47:
            if (r7 <= 0) goto L4d
            int r4 = r6.f44066e
            int r4 = -r4
            goto L4f
        L4d:
            int r4 = r6.f44066e
        L4f:
            int r7 = r7 + r4
        L50:
            int r4 = r6.f44063b
            if (r4 != r1) goto L7c
            r6.f44064c = r2
            r6.m55459c(r7)
            goto L7c
        L5a:
            r6.setPressed(r0)
            r6.f44063b = r0
            r6.m55465g()
            r6.m55473o()
            goto L7c
        L66:
            boolean r7 = r6.m55451a(r1, r2)
            if (r7 == 0) goto L7c
            r6.f44063b = r3
            r6.f44064c = r2
            r6.m55475q()
            r6.setPressed(r3)
            r6.m55476r()
            r6.m55461d()
        L7c:
            int r6 = r6.f44063b
            if (r6 == 0) goto L81
            r0 = r3
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwscrollbarview.widget.HwScrollbarView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setFadeTime(int i10) {
        this.f44062a = i10;
    }

    public void setFastScrollable(boolean z10) {
        this.f44068g = z10;
    }

    public void setHwOverScrollProxy(HwOverScrollProxy hwOverScrollProxy) {
        this.f44076o = hwOverScrollProxy;
    }

    public void setOnFastScrollListener(OnFastScrollListener onFastScrollListener) {
        this.f44072k = onFastScrollListener;
    }

    @Deprecated
    public void setOnTouchOffsetListener(OnTouchOffsetListener onTouchOffsetListener) {
    }

    public void setScrollableView(View view, boolean z10) {
        if (view == null) {
            Log.w(TAG, "setScrollableView: view is null");
            return;
        }
        if (this.f44070i != null) {
            return;
        }
        this.f44070i = view;
        if (z10) {
            view.setOnTouchListener(this.f44082u);
        }
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
        if (this.f44070i.isAttachedToWindow()) {
            m55444a();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            Drawable drawableM82231l = C13669a.m82231l(drawable);
            this.mThumbDrawable = drawableM82231l;
            int i10 = this.mThumbTint;
            if (i10 != f44060y) {
                C13669a.m82227h(drawableM82231l, i10);
            }
            this.mThumbDrawable.setCallback(this);
        }
    }

    public void setThumbTint(int i10) {
        this.mThumbTint = i10;
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            Drawable drawableM82231l = C13669a.m82231l(drawable);
            this.mTrackDrawable = drawableM82231l;
            int i10 = this.mTrackTint;
            if (i10 != f44060y) {
                C13669a.m82227h(drawableM82231l, i10);
            }
            this.mTrackDrawable.setCallback(this);
        }
    }

    public void updateThumbTouchHotRect() {
        Rect rect = this.mThumbRect;
        int i10 = rect.right;
        int i11 = i10 - this.mThumbTouchHotWidth;
        if (isScrollbarLayoutRtl()) {
            i11 = rect.left;
            i10 = this.mThumbTouchHotWidth + i11;
        }
        this.mThumbTouchHotRect.set(i11, rect.top, i10, rect.bottom);
    }

    public void updateTrackRect() {
        int i10 = this.mTrackWidth;
        int width = getWidth() - getPaddingRight();
        int paddingLeft = width - i10;
        if (isScrollbarLayoutRtl()) {
            paddingLeft = getPaddingLeft();
            width = paddingLeft + i10;
        }
        this.mTrackLength = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        this.mTrackRect.set(paddingLeft, paddingTop, width, this.mTrackLength + paddingTop);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mThumbDrawable || drawable == this.mTrackDrawable || super.verifyDrawable(drawable);
    }

    public HwScrollbarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8733R.attr.hwScrollbarViewStyle);
    }

    /* renamed from: b */
    private void m55455b(int i10) {
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.setAutoMirrored(true);
            C13669a.m82226g(this.mThumbDrawable, i10);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setAutoMirrored(true);
            C13669a.m82226g(this.mTrackDrawable, i10);
        }
    }

    /* renamed from: c */
    private void m55459c(int i10) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (i10 == 0) {
            return;
        }
        int i11 = this.mThumbOffset + i10;
        int i12 = this.mTrackLength - this.mThumbLength;
        if (i11 < 0) {
            i11 = 0;
        }
        if (i11 <= i12) {
            i12 = i11;
        }
        this.mThumbOffset = i12;
        m55454b();
        m55480v();
        invalidate();
    }

    public HwScrollbarView(Context context, AttributeSet attributeSet, int i10) {
        super(m55443a(context, i10), attributeSet, i10);
        this.mThumbAlpha = 255;
        this.mTrackLength = 0;
        this.mThumbLength = 0;
        this.mThumbOffset = 0;
        this.mThumbWidth = 0;
        this.mTrackWidth = 0;
        this.mThumbTouchHotWidth = 0;
        this.mThumbRect = new Rect();
        this.mTrackRect = new Rect();
        this.mThumbTouchHotRect = new Rect();
        this.mThumbType = 0;
        this.f44062a = 250;
        this.f44063b = 0;
        this.f44067f = 0.0f;
        this.f44068g = true;
        this.f44069h = 0;
        this.f44073l = true;
        this.f44074m = true;
        this.f44075n = true;
        this.f44077p = false;
        this.f44078q = 0;
        this.f44079r = 0;
        this.f44080s = 0;
        this.f44082u = new bzrwd();
        this.f44083v = new aauaf();
        m55447a(super.getContext(), attributeSet, i10);
    }

    /* renamed from: a */
    private static Context m55443a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8733R.style.Theme_Emui_HwScrollbarView);
    }

    /* renamed from: d */
    private void m55462d(int i10) {
        postDelayed(new bqmxo(), i10);
    }

    /* renamed from: a */
    private void m55447a(Context context, AttributeSet attributeSet, int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8733R.styleable.HwScrollbarView, i10, C8733R.style.Widget_Emui_HwScrollbarView);
        this.f44066e = viewConfiguration.getScaledTouchSlop();
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8733R.styleable.HwScrollbarView_hwMinThumbLength, 48);
        this.mMinThumbLength = dimensionPixelSize;
        this.f44078q = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8733R.styleable.HwScrollbarView_hwOverScrollMinThumbLength, dimensionPixelSize);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8733R.styleable.HwScrollbarView_hwMinThumbWidth, 16);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8733R.styleable.HwScrollbarView_hwThumbWidth, dimensionPixelSize2);
        this.mThumbWidth = dimensionPixelSize3;
        if (dimensionPixelSize3 < dimensionPixelSize2) {
            this.mThumbWidth = dimensionPixelSize2;
        }
        this.mTrackWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8733R.styleable.HwScrollbarView_hwTrackWidth, this.mThumbWidth);
        this.mThumbTouchHotWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8733R.styleable.HwScrollbarView_hwThumbTouchHotWidth, 16);
        this.mThumbTint = typedArrayObtainStyledAttributes.getColor(C8733R.styleable.HwScrollbarView_hwScrollThumbTint, f44060y);
        this.mTrackTint = typedArrayObtainStyledAttributes.getColor(C8733R.styleable.HwScrollbarView_hwScrollTrackTint, f44060y);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C8733R.styleable.HwScrollbarView_hwScrollThumb);
        Drawable drawable2 = drawable;
        if (drawable == null) {
            HwScrollbarDrawable hwScrollbarDrawable = new HwScrollbarDrawable();
            hwScrollbarDrawable.inflate(context, attributeSet, i10);
            drawable2 = hwScrollbarDrawable;
        }
        setThumbDrawable(drawable2);
        setTrackDrawable(typedArrayObtainStyledAttributes.getDrawable(C8733R.styleable.HwScrollbarView_hwScrollTrack));
        this.mThumbType = typedArrayObtainStyledAttributes.getInt(C8733R.styleable.HwScrollbarView_hwThumbType, 0);
        this.mStartAngle = typedArrayObtainStyledAttributes.getFloat(C8733R.styleable.HwScrollbarView_hwStartAngle, f44051L);
        this.mSweepAngle = typedArrayObtainStyledAttributes.getFloat(C8733R.styleable.HwScrollbarView_hwSweepAngle, f44052M);
        this.f44080s = typedArrayObtainStyledAttributes.getInteger(C8733R.styleable.HwScrollbarView_hwVibrateDelayTime, 0);
        typedArrayObtainStyledAttributes.recycle();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        akxao akxaoVar = new akxao(null);
        this.f44081t = akxaoVar;
        akxaoVar.f44092a = this;
        if (isInEditMode()) {
            this.mThumbRect = new Rect(0, 0, 48, f44049J);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(2);
        }
    }

    /* renamed from: b */
    private void m55454b() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f44072k != null) {
            int scrollableViewVerticalScrollRange = getScrollableViewVerticalScrollRange();
            int scrollableViewVerticalScrollExtent = getScrollableViewVerticalScrollExtent();
            if (scrollableViewVerticalScrollRange == -1 || scrollableViewVerticalScrollExtent == -1) {
                return;
            }
            int scrollableViewVerticalScrollOffset = getScrollableViewVerticalScrollOffset();
            float scrollProgress = getScrollProgress();
            int i10 = ((int) ((scrollableViewVerticalScrollRange - scrollableViewVerticalScrollExtent) * scrollProgress)) - scrollableViewVerticalScrollOffset;
            int iCompare = Float.compare(scrollProgress - this.f44067f, 0.0f);
            if (iCompare > 0 && i10 < 0) {
                i10 = 0;
            }
            if (iCompare < 0 && i10 > 0) {
                i10 = 0;
            }
            if (i10 != 0) {
                this.f44072k.onFastScrollChanged(0, i10, scrollProgress);
            }
            this.f44067f = scrollProgress;
        }
    }

    /* renamed from: c */
    private boolean m55460c() {
        return this.f44070i != null && getScrollableViewVerticalScrollRange() > getScrollableViewVerticalScrollExtent();
    }

    /* renamed from: b */
    private void m55456b(Canvas canvas) {
        if (this.mTrackDrawable != null && m55469k() && this.mThumbType == 0) {
            onDrawTrack(canvas);
        }
    }

    /* renamed from: a */
    private void m55446a(int i10, int i11, int i12) {
        if (i10 > 0 && i10 > i11) {
            int i13 = this.mTrackLength;
            int i14 = (int) (((i11 * 1.0f) / i10) * i13);
            int i15 = this.mMinThumbLength;
            if (i14 < i15) {
                i14 = i15;
            }
            if (i14 > i13) {
                i14 = i13;
            }
            this.mThumbLength = i14;
            int i16 = i13 - i14;
            int i17 = (int) (((i12 * 1.0f) / (i10 - i11)) * i16);
            if (i17 <= i16) {
                i16 = i17;
            }
            this.mThumbOffset = i16;
            if (i16 == 0 || i16 >= i13 - this.f44079r) {
                adjustOverScrollThumbParameters();
            }
            m55480v();
            this.f44067f = getScrollProgress();
            return;
        }
        this.mThumbLength = 0;
        this.mThumbOffset = 0;
        this.mThumbRect.setEmpty();
        setThumbShow(false);
        this.f44074m = false;
    }

    /* renamed from: a */
    private void m55444a() {
        ViewTreeObserver viewTreeObserver;
        if (this.f44070i == null) {
            return;
        }
        if (this.f44071j == null) {
            this.f44071j = new WeakReference<>(this.f44070i.getViewTreeObserver());
        }
        if (this.f44083v == null || (viewTreeObserver = this.f44071j.get()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.f44083v);
    }

    /* renamed from: a */
    private boolean m55451a(int i10, int i11) {
        if (this.f44068g) {
            return this.mThumbTouchHotRect.contains(i10, i11);
        }
        return false;
    }

    /* renamed from: a */
    private void m55448a(Canvas canvas) {
        akxao akxaoVar;
        int i10;
        if (m55469k() && (i10 = (akxaoVar = this.f44081t).f44096e) != 0) {
            boolean z10 = false;
            if (i10 == 2) {
                float[] fArr = akxaoVar.f44093b;
                if (akxaoVar.f44094c.timeToValues(fArr) == Interpolator.Result.FREEZE_END) {
                    setThumbShow(false);
                    akxaoVar.f44096e = 0;
                } else {
                    this.mThumbAlpha = Math.round(fArr[0]);
                }
                z10 = true;
            } else {
                this.mThumbAlpha = 255;
            }
            onDrawThumb(canvas);
            if (z10) {
                postInvalidateDelayed(50L);
            }
        }
    }

    /* renamed from: a */
    private void m55445a(int i10) {
        if (m55469k()) {
            this.f44081t.f44095d = AnimationUtils.currentAnimationTimeMillis() + this.f44062a;
            this.f44081t.f44096e = 1;
            removeCallbacks(this.f44081t);
            postDelayed(this.f44081t, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m55449a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        int action = motionEvent.getAction();
        int y10 = (int) motionEvent.getY();
        if (action != 1) {
            if (action == 2) {
                if (this.f44069h == 0) {
                    this.f44065d = y10;
                    this.f44069h = 2;
                    if (m55460c()) {
                        this.f44074m = true;
                        m55476r();
                    } else {
                        this.f44074m = false;
                        setThumbShow(false);
                    }
                }
                if (!m55469k() || this.f44065d == y10) {
                    return;
                }
                this.f44065d = y10;
                m55476r();
                return;
            }
            if (action != 3) {
                return;
            }
        }
        this.f44069h = 0;
        m55473o();
    }
}
