package com.huawei.uikit.hwswitch.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.Log;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.Switch;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwswitch.C8739R;
import java.util.Locale;

/* loaded from: classes5.dex */
public class HwSwitch extends Switch {

    /* renamed from: A */
    private static final int f44361A = 2;

    /* renamed from: B */
    private static final float f44362B = 0.5f;

    /* renamed from: C */
    private static final int f44363C = 2;

    /* renamed from: D */
    private static final int f44364D = 1000;

    /* renamed from: E */
    private static final float f44365E = 0.1f;

    /* renamed from: F */
    private static final float f44366F = 1.0f;

    /* renamed from: G */
    private static final float f44367G = 0.9f;

    /* renamed from: H */
    private static final float f44368H = 1.0f;

    /* renamed from: I */
    private static final float f44369I = 0.5f;

    /* renamed from: J */
    private static final int f44370J = -1;

    /* renamed from: K */
    private static final int f44371K = 15;

    /* renamed from: L */
    private static final Property<HwSwitch, Float> f44372L = new bzrwd("thumbPos");

    /* renamed from: t */
    private static final String f44373t = "HwSwitch";

    /* renamed from: u */
    private static final int f44374u = -14331913;

    /* renamed from: v */
    private static final String f44375v = "getOpticalInsets";

    /* renamed from: w */
    private static final int f44376w = 200;

    /* renamed from: x */
    private static final int f44377x = 2;

    /* renamed from: y */
    private static final int f44378y = 0;

    /* renamed from: z */
    private static final int f44379z = 1;

    /* renamed from: a */
    private ObjectAnimator f44380a;

    /* renamed from: b */
    private Drawable f44381b;

    /* renamed from: c */
    private int f44382c;

    /* renamed from: d */
    private int f44383d;

    /* renamed from: e */
    private int f44384e;

    /* renamed from: f */
    private int f44385f;

    /* renamed from: g */
    private int f44386g;

    /* renamed from: h */
    private int f44387h;

    /* renamed from: i */
    private int f44388i;

    /* renamed from: j */
    private int f44389j;

    /* renamed from: k */
    private int f44390k;

    /* renamed from: l */
    private int f44391l;

    /* renamed from: m */
    private float f44392m;
    protected Drawable mTrackDrawable;

    /* renamed from: n */
    private float f44393n;

    /* renamed from: o */
    private float f44394o;

    /* renamed from: p */
    private int f44395p;

    /* renamed from: q */
    private VelocityTracker f44396q;

    /* renamed from: r */
    private final Rect f44397r;

    /* renamed from: s */
    private int f44398s;

    public class bzrwd extends FloatProperty<HwSwitch> {
        public bzrwd(String str) {
            super(str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(HwSwitch hwSwitch) {
            if (hwSwitch == null) {
                return null;
            }
            return Float.valueOf(hwSwitch.f44392m);
        }

        @Override // android.util.FloatProperty
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void setValue(HwSwitch hwSwitch, float f10) {
            if (hwSwitch == null) {
                Log.w(HwSwitch.f44373t, "setValue: HwSwitch object is null!");
            } else {
                hwSwitch.setThumbPosition(f10);
            }
        }
    }

    public HwSwitch(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private float m55623a(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
    }

    /* renamed from: b */
    private void m55634b() {
        ObjectAnimator objectAnimator = this.f44380a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* renamed from: c */
    private void m55636c() {
        Drawable.Callback callback = this.f44381b.getCallback();
        this.f44381b.setCallback(null);
        this.f44381b.setBounds(0, 0, 0, 0);
        this.f44381b.setCallback(callback);
    }

    /* renamed from: d */
    private void m55638d() throws NoSuchFieldException, SecurityException {
        if (this.f44381b == null) {
            Object object = HwReflectUtil.getObject(this, "mThumbDrawable", Switch.class);
            if (object instanceof Drawable) {
                this.f44381b = (Drawable) object;
            }
        }
        if (this.mTrackDrawable == null) {
            Object object2 = HwReflectUtil.getObject(this, "mTrackDrawable", Switch.class);
            if (object2 instanceof Drawable) {
                this.mTrackDrawable = (Drawable) object2;
            }
        }
        Object object3 = HwReflectUtil.getObject(this, "mThumbWidth", Switch.class);
        if (object3 instanceof Integer) {
            this.f44383d = ((Integer) object3).intValue();
        }
    }

    /* renamed from: e */
    private void m55640e() throws NoSuchFieldException, SecurityException {
        Object object = HwReflectUtil.getObject(this, "mSwitchWidth", Switch.class);
        if (object instanceof Integer) {
            this.f44382c = ((Integer) object).intValue();
        }
        Object object2 = HwReflectUtil.getObject(this, "mSwitchHeight", Switch.class);
        if (object2 instanceof Integer) {
            this.f44395p = ((Integer) object2).intValue();
        }
    }

    /* renamed from: f */
    private boolean m55643f(MotionEvent motionEvent) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        float x10 = motionEvent.getX();
        int thumbScrollRange = getThumbScrollRange();
        float f10 = x10 - this.f44393n;
        float f11 = thumbScrollRange != 0 ? f10 / thumbScrollRange : f10 > 0.0f ? 1.0f : -1.0f;
        if (m55642f()) {
            f11 = -f11;
        }
        float fM55623a = m55623a(this.f44392m + f11, 0.0f, 1.0f);
        if (fM55623a == this.f44392m) {
            return true;
        }
        this.f44393n = x10;
        setThumbPosition(fM55623a);
        return true;
    }

    /* renamed from: g */
    private boolean m55644g() {
        String language = Locale.getDefault().getLanguage();
        return (language.contains(Constants.AR_CACHE) || language.contains("fa") || language.contains("iw")) || (language.contains("ug") || language.contains(Constants.URDU_LANG) || m55642f());
    }

    private int getThumbOffset() {
        return (int) (((!m55644g() ? this.f44392m : 1.0f - this.f44392m) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        Insets insets;
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f44397r;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f44381b;
        if (drawable2 != null) {
            Object objCallMethod = HwReflectUtil.callMethod(drawable2, f44375v, null, null, DrawableContainer.class);
            insets = objCallMethod instanceof Insets ? (Insets) objCallMethod : Insets.NONE;
        } else {
            insets = Insets.NONE;
        }
        Object object = HwReflectUtil.getObject(this, "mSwitchWidth", Switch.class);
        if (object instanceof Integer) {
            this.f44382c = ((Integer) object).intValue();
        }
        int i10 = ((((this.f44382c - this.f44383d) - rect.left) - rect.right) - insets.left) - insets.right;
        int i11 = this.f44388i;
        return i10 - (i11 + i11);
    }

    /* renamed from: h */
    private boolean m55645h() {
        return this.f44392m > 0.5f;
    }

    public static HwSwitch instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwSwitch.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwSwitch.class);
        if (objInstantiate instanceof HwSwitch) {
            return (HwSwitch) objInstantiate;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbPosition(float f10) {
        this.f44392m = f10;
        invalidate();
    }

    public int getFocusedPathColor() {
        return this.f44398s;
    }

    @Override // android.widget.Switch, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        m55638d();
        m55629a(canvas);
        super.onDraw(canvas);
        m55636c();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    @Override // android.widget.Switch, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) throws java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            r1 = this;
            super.onLayout(r2, r3, r4, r5, r6)
            r1.m55638d()
            r1.m55640e()
            android.graphics.drawable.Drawable r2 = r1.f44381b
            r3 = 0
            if (r2 == 0) goto L40
            android.graphics.Rect r2 = r1.f44397r
            android.graphics.drawable.Drawable r4 = r1.mTrackDrawable
            if (r4 == 0) goto L18
            r4.getPadding(r2)
            goto L1b
        L18:
            r2.setEmpty()
        L1b:
            android.graphics.drawable.Drawable r4 = r1.f44381b
            java.lang.String r5 = "getOpticalInsets"
            java.lang.Class<android.graphics.drawable.DrawableContainer> r6 = android.graphics.drawable.DrawableContainer.class
            r0 = 0
            java.lang.Object r4 = com.huawei.uikit.hwcommon.utils.HwReflectUtil.callMethod(r4, r5, r0, r0, r6)
            boolean r5 = r4 instanceof android.graphics.Insets
            if (r5 == 0) goto L40
            android.graphics.Insets r4 = (android.graphics.Insets) r4
            int r5 = r4.left
            int r6 = r2.left
            int r5 = r5 - r6
            if (r5 > 0) goto L34
            r5 = r3
        L34:
            int r4 = r4.right
            int r2 = r2.right
            int r4 = r4 - r2
            if (r4 > 0) goto L3c
            goto L3d
        L3c:
            r3 = r4
        L3d:
            r2 = r3
            r3 = r5
            goto L41
        L40:
            r2 = r3
        L41:
            r1.m55627a(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwswitch.widget.HwSwitch.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    @Override // android.widget.Switch, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) throws java.lang.NoSuchFieldException, java.lang.SecurityException {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto Lb
            java.lang.String r5 = "HwSwitch"
            java.lang.String r6 = "onTouchEvent: MotionEvent motionEvent is null!"
            android.util.Log.w(r5, r6)
            return r0
        Lb:
            android.view.VelocityTracker r1 = r5.f44396q
            r1.addMovement(r6)
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L3a
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L27
            if (r1 == r2) goto L20
            r4 = 3
            if (r1 == r4) goto L27
            goto L3d
        L20:
            boolean r0 = r5.m55635b(r6)
            if (r0 == 0) goto L3d
            return r3
        L27:
            int r1 = r5.f44389j
            if (r1 != r2) goto L32
            r5.m55639d(r6)
            super.onTouchEvent(r6)
            return r3
        L32:
            r5.f44389j = r0
            android.view.VelocityTracker r0 = r5.f44396q
            r0.clear()
            goto L3d
        L3a:
            r5.m55630a(r6)
        L3d:
            boolean r5 = super.onTouchEvent(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwswitch.widget.HwSwitch.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.Switch, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        super.setChecked(z10);
        boolean zIsChecked = isChecked();
        if (isAttachedToWindow() && isLaidOut()) {
            m55632a(zIsChecked);
        } else {
            m55634b();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    public void setFocusedPathColor(int i10) {
        this.f44398s = i10;
    }

    public void setSwitchWidth(int i10) {
        this.f44382c = i10;
    }

    public HwSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8739R.attr.hwSwitchStyle);
    }

    public HwSwitch(Context context, AttributeSet attributeSet, int i10) {
        super(m55625a(context, i10), attributeSet, i10);
        this.f44382c = 0;
        this.f44383d = 0;
        this.f44384e = 0;
        this.f44385f = 0;
        this.f44386g = 0;
        this.f44387h = 0;
        this.f44388i = 0;
        this.f44389j = 0;
        this.f44390k = 0;
        this.f44391l = 0;
        this.f44396q = VelocityTracker.obtain();
        this.f44397r = new Rect();
        m55628a(getContext(), attributeSet, i10);
    }

    /* renamed from: b */
    private boolean m55635b(MotionEvent motionEvent) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        int i10 = this.f44389j;
        if (i10 == 1) {
            return m55641e(motionEvent);
        }
        if (i10 != 2) {
            return false;
        }
        m55643f(motionEvent);
        return true;
    }

    /* renamed from: a */
    private static Context m55625a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8739R.style.Theme_Emui_HwSwitch);
    }

    /* renamed from: a */
    private void m55628a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8739R.styleable.HwSwitch, i10, C8739R.style.Widget_Emui_HwSwitch);
        this.f44388i = (int) typedArrayObtainStyledAttributes.getDimension(C8739R.styleable.HwSwitch_hwLayoutPadding, (getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
        this.f44398s = typedArrayObtainStyledAttributes.getColor(C8739R.styleable.HwSwitch_hwFocusedPathColor, f44374u);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        if (viewConfiguration != null) {
            this.f44390k = viewConfiguration.getScaledTouchSlop();
            this.f44391l = viewConfiguration.getScaledMinimumFlingVelocity();
        }
    }

    /* renamed from: c */
    private void m55637c(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: e */
    private boolean m55641e(MotionEvent motionEvent) throws NoSuchFieldException, SecurityException {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        Object object = HwReflectUtil.getObject(this, "mTouchSlop", Switch.class);
        if (object instanceof Integer) {
            this.f44390k = ((Integer) object).intValue();
        }
        if (Math.abs(x10 - this.f44393n) <= this.f44390k && Math.abs(y10 - this.f44394o) <= this.f44390k) {
            return false;
        }
        this.f44389j = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f44393n = x10;
        this.f44394o = y10;
        return true;
    }

    /* renamed from: f */
    private boolean m55642f() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: d */
    private void m55639d(MotionEvent motionEvent) throws NoSuchFieldException, SecurityException {
        this.f44389j = 0;
        boolean zM55645h = true;
        boolean z10 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z10) {
            this.f44396q.computeCurrentVelocity(1000);
            float xVelocity = this.f44396q.getXVelocity();
            Object object = HwReflectUtil.getObject(this, "mMinFlingVelocity", Switch.class);
            if (object instanceof Integer) {
                this.f44391l = ((Integer) object).intValue();
            }
            if (Math.abs(xVelocity) > this.f44391l) {
                if (!m55644g() ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    zM55645h = false;
                }
            } else {
                zM55645h = m55645h();
            }
        } else {
            zM55645h = zIsChecked;
        }
        if (zM55645h != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(zM55645h);
        m55637c(motionEvent);
    }

    /* renamed from: a */
    private void m55629a(Canvas canvas) throws NoSuchMethodException, SecurityException {
        Rect rect = this.f44397r;
        int i10 = this.f44384e;
        int i11 = this.f44385f;
        int i12 = this.f44387h;
        int thumbOffset = i10 + getThumbOffset() + this.f44388i;
        m55626a();
        Drawable drawable = this.f44381b;
        if (drawable != null) {
            drawable.getPadding(rect);
            int i13 = thumbOffset - rect.left;
            int i14 = thumbOffset + this.f44383d + rect.right;
            Drawable.Callback callback = this.f44381b.getCallback();
            this.f44381b.setCallback(null);
            this.f44381b.setBounds(i13, i11, i14, i12);
            this.f44381b.setCallback(callback);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i13, i11, i14, i12);
            }
        }
    }

    /* renamed from: a */
    private void m55626a() throws NoSuchMethodException, SecurityException {
        Insets insets;
        Rect rect = this.f44397r;
        int i10 = this.f44384e;
        int i11 = this.f44386g;
        int i12 = this.f44385f;
        int i13 = this.f44387h;
        Drawable drawable = this.f44381b;
        if (drawable != null) {
            Object objCallMethod = HwReflectUtil.callMethod(drawable, f44375v, null, null, DrawableContainer.class);
            if (objCallMethod instanceof Insets) {
                insets = (Insets) objCallMethod;
            } else {
                insets = Insets.NONE;
            }
        } else {
            insets = Insets.NONE;
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            if (insets != Insets.NONE) {
                int i14 = insets.left;
                int i15 = rect.left;
                if (i14 > i15) {
                    i10 += i14 - i15;
                }
                int i16 = insets.top;
                int i17 = rect.top;
                if (i16 > i17) {
                    i12 += i16 - i17;
                }
                int i18 = insets.right;
                int i19 = rect.right;
                if (i18 > i19) {
                    i11 -= i18 - i19;
                }
                int i20 = insets.bottom;
                int i21 = rect.bottom;
                if (i20 > i21) {
                    i13 -= i20 - i21;
                }
            }
            this.mTrackDrawable.setBounds(i10, i12, i11, i13);
        }
    }

    /* renamed from: a */
    private void m55627a(int i10, int i11) {
        if (m55642f()) {
            int paddingLeft = getPaddingLeft() + i10;
            this.f44384e = paddingLeft;
            this.f44386g = ((paddingLeft + this.f44382c) - i10) - i11;
        } else {
            int width = (getWidth() - getPaddingRight()) - i11;
            this.f44386g = width;
            this.f44384e = (width - this.f44382c) + i10 + i11;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            int i12 = this.f44395p;
            int i13 = paddingTop - (i12 / 2);
            this.f44385f = i13;
            this.f44387h = i13 + i12;
            return;
        }
        if (gravity == 48) {
            int paddingTop2 = getPaddingTop();
            this.f44385f = paddingTop2;
            this.f44387h = paddingTop2 + this.f44395p;
        } else if (gravity != 80) {
            this.f44385f = 0;
            this.f44387h = 0;
        } else {
            int height = getHeight() - getPaddingBottom();
            this.f44387h = height;
            this.f44385f = height - this.f44395p;
        }
    }

    /* renamed from: a */
    private void m55632a(boolean z10) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f44372L, z10 ? 1.0f : 0.0f);
        this.f44380a = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(200L);
        this.f44380a.setInterpolator(new HwCubicBezierInterpolator(0.1f, 1.0f, 0.9f, 1.0f));
        this.f44380a.setAutoCancel(true);
        this.f44380a.start();
    }

    /* renamed from: a */
    private boolean m55633a(float f10, float f11) throws NoSuchFieldException, SecurityException {
        if (this.f44381b == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f44381b.getPadding(this.f44397r);
        Object object = HwReflectUtil.getObject(this, "mTouchSlop", Switch.class);
        if (object instanceof Integer) {
            this.f44390k = ((Integer) object).intValue();
        }
        int i10 = this.f44385f;
        int i11 = this.f44390k;
        int i12 = i10 - i11;
        int i13 = (this.f44384e + thumbOffset) - i11;
        int i14 = this.f44383d + i13;
        Rect rect = this.f44397r;
        return f10 > ((float) i13) && f10 < ((float) (((i14 + rect.left) + rect.right) + i11)) && f11 > ((float) i12) && f11 < ((float) (this.f44387h + i11));
    }

    /* renamed from: a */
    private void m55630a(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (isEnabled() && m55633a(x10, y10)) {
            this.f44389j = 1;
            this.f44393n = x10;
            this.f44394o = y10;
        }
    }
}
