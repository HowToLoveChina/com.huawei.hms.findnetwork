package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.widget.C0669j;
import androidx.emoji2.text.C0688e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import p211d.C8968a;
import p273f0.C9603h0;
import p757x.C13669a;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: S */
    public static final Property<SwitchCompat, Float> f2150S = new C0502a(Float.class, "thumbPos");

    /* renamed from: T */
    public static final int[] f2151T = {R.attr.state_checked};

    /* renamed from: A */
    public int f2152A;

    /* renamed from: B */
    public int f2153B;

    /* renamed from: C */
    public int f2154C;

    /* renamed from: D */
    public int f2155D;

    /* renamed from: E */
    public int f2156E;

    /* renamed from: F */
    public int f2157F;

    /* renamed from: G */
    public int f2158G;

    /* renamed from: H */
    public boolean f2159H;

    /* renamed from: I */
    public final TextPaint f2160I;

    /* renamed from: J */
    public ColorStateList f2161J;

    /* renamed from: K */
    public Layout f2162K;

    /* renamed from: L */
    public Layout f2163L;

    /* renamed from: M */
    public TransformationMethod f2164M;

    /* renamed from: N */
    public ObjectAnimator f2165N;

    /* renamed from: O */
    public final C0540o f2166O;

    /* renamed from: P */
    public C0528h f2167P;

    /* renamed from: Q */
    public C0504c f2168Q;

    /* renamed from: R */
    public final Rect f2169R;

    /* renamed from: a */
    public Drawable f2170a;

    /* renamed from: b */
    public ColorStateList f2171b;

    /* renamed from: c */
    public PorterDuff.Mode f2172c;

    /* renamed from: d */
    public boolean f2173d;

    /* renamed from: e */
    public boolean f2174e;

    /* renamed from: f */
    public Drawable f2175f;

    /* renamed from: g */
    public ColorStateList f2176g;

    /* renamed from: h */
    public PorterDuff.Mode f2177h;

    /* renamed from: i */
    public boolean f2178i;

    /* renamed from: j */
    public boolean f2179j;

    /* renamed from: k */
    public int f2180k;

    /* renamed from: l */
    public int f2181l;

    /* renamed from: m */
    public int f2182m;

    /* renamed from: n */
    public boolean f2183n;

    /* renamed from: o */
    public CharSequence f2184o;

    /* renamed from: p */
    public CharSequence f2185p;

    /* renamed from: q */
    public CharSequence f2186q;

    /* renamed from: r */
    public CharSequence f2187r;

    /* renamed from: s */
    public boolean f2188s;

    /* renamed from: t */
    public int f2189t;

    /* renamed from: u */
    public int f2190u;

    /* renamed from: v */
    public float f2191v;

    /* renamed from: w */
    public float f2192w;

    /* renamed from: x */
    public VelocityTracker f2193x;

    /* renamed from: y */
    public int f2194y;

    /* renamed from: z */
    public float f2195z;

    /* renamed from: androidx.appcompat.widget.SwitchCompat$a */
    public class C0502a extends Property<SwitchCompat, Float> {
        public C0502a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f2195z);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f10) {
            switchCompat.setThumbPosition(f10.floatValue());
        }
    }

    /* renamed from: androidx.appcompat.widget.SwitchCompat$b */
    public static class C0503b {
        /* renamed from: a */
        public static void m2834a(ObjectAnimator objectAnimator, boolean z10) {
            objectAnimator.setAutoCancel(z10);
        }
    }

    /* renamed from: androidx.appcompat.widget.SwitchCompat$c */
    public static class C0504c extends C0688e.e {

        /* renamed from: a */
        public final Reference<SwitchCompat> f2196a;

        public C0504c(SwitchCompat switchCompat) {
            this.f2196a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.C0688e.e
        /* renamed from: a */
        public void mo2835a(Throwable th2) {
            SwitchCompat switchCompat = this.f2196a.get();
            if (switchCompat != null) {
                switchCompat.m2824j();
            }
        }

        @Override // androidx.emoji2.text.C0688e.e
        /* renamed from: b */
        public void mo2836b() {
            SwitchCompat switchCompat = this.f2196a.get();
            if (switchCompat != null) {
                switchCompat.m2824j();
            }
        }
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    /* renamed from: f */
    public static float m2815f(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
    }

    private C0528h getEmojiTextViewHelper() {
        if (this.f2167P == null) {
            this.f2167P = new C0528h(this);
        }
        return this.f2167P;
    }

    private boolean getTargetCheckedState() {
        return this.f2195z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((C0535k0.m3056b(this) ? 1.0f - this.f2195z : this.f2195z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f2175f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f2169R;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f2170a;
        Rect rectM3143d = drawable2 != null ? C0544s.m3143d(drawable2) : C0544s.f2414c;
        return ((((this.f2152A - this.f2154C) - rect.left) - rect.right) - rectM3143d.left) - rectM3143d.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f2186q = charSequence;
        this.f2187r = m2821g(charSequence);
        this.f2163L = null;
        if (this.f2188s) {
            m2830p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f2184o = charSequence;
        this.f2185p = m2821g(charSequence);
        this.f2162K = null;
        if (this.f2188s) {
            m2830p();
        }
    }

    /* renamed from: a */
    public final void m2816a(boolean z10) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f2150S, z10 ? 1.0f : 0.0f);
        this.f2165N = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        C0503b.m2834a(this.f2165N, true);
        this.f2165N.start();
    }

    /* renamed from: b */
    public final void m2817b() {
        Drawable drawable = this.f2170a;
        if (drawable != null) {
            if (this.f2173d || this.f2174e) {
                Drawable drawableMutate = C13669a.m82231l(drawable).mutate();
                this.f2170a = drawableMutate;
                if (this.f2173d) {
                    C13669a.m82228i(drawableMutate, this.f2171b);
                }
                if (this.f2174e) {
                    C13669a.m82229j(this.f2170a, this.f2172c);
                }
                if (this.f2170a.isStateful()) {
                    this.f2170a.setState(getDrawableState());
                }
            }
        }
    }

    /* renamed from: c */
    public final void m2818c() {
        Drawable drawable = this.f2175f;
        if (drawable != null) {
            if (this.f2178i || this.f2179j) {
                Drawable drawableMutate = C13669a.m82231l(drawable).mutate();
                this.f2175f = drawableMutate;
                if (this.f2178i) {
                    C13669a.m82228i(drawableMutate, this.f2176g);
                }
                if (this.f2179j) {
                    C13669a.m82229j(this.f2175f, this.f2177h);
                }
                if (this.f2175f.isStateful()) {
                    this.f2175f.setState(getDrawableState());
                }
            }
        }
    }

    /* renamed from: d */
    public final void m2819d() {
        ObjectAnimator objectAnimator = this.f2165N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i10;
        int i11;
        Rect rect = this.f2169R;
        int i12 = this.f2155D;
        int i13 = this.f2156E;
        int i14 = this.f2157F;
        int i15 = this.f2158G;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f2170a;
        Rect rectM3143d = drawable != null ? C0544s.m3143d(drawable) : C0544s.f2414c;
        Drawable drawable2 = this.f2175f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i16 = rect.left;
            thumbOffset += i16;
            if (rectM3143d != null) {
                int i17 = rectM3143d.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = rectM3143d.top;
                int i19 = rect.top;
                i10 = i18 > i19 ? (i18 - i19) + i13 : i13;
                int i20 = rectM3143d.right;
                int i21 = rect.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = rectM3143d.bottom;
                int i23 = rect.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                }
                this.f2175f.setBounds(i12, i10, i14, i11);
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.f2175f.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f2170a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i24 = thumbOffset - rect.left;
            int i25 = thumbOffset + this.f2154C + rect.right;
            this.f2170a.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                C13669a.m82225f(background, i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable = this.f2170a;
        if (drawable != null) {
            C13669a.m82224e(drawable, f10, f11);
        }
        Drawable drawable2 = this.f2175f;
        if (drawable2 != null) {
            C13669a.m82224e(drawable2, f10, f11);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2170a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f2175f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    /* renamed from: e */
    public final void m2820e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: g */
    public final CharSequence m2821g(CharSequence charSequence) {
        TransformationMethod transformationMethodM2999f = getEmojiTextViewHelper().m2999f(this.f2164M);
        return transformationMethodM2999f != null ? transformationMethodM2999f.getTransformation(charSequence, this) : charSequence;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!C0535k0.m3056b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f2152A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f2182m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (C0535k0.m3056b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f2152A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f2182m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return C0669j.m4082p(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f2188s;
    }

    public boolean getSplitTrack() {
        return this.f2183n;
    }

    public int getSwitchMinWidth() {
        return this.f2181l;
    }

    public int getSwitchPadding() {
        return this.f2182m;
    }

    public CharSequence getTextOff() {
        return this.f2186q;
    }

    public CharSequence getTextOn() {
        return this.f2184o;
    }

    public Drawable getThumbDrawable() {
        return this.f2170a;
    }

    public final float getThumbPosition() {
        return this.f2195z;
    }

    public int getThumbTextPadding() {
        return this.f2180k;
    }

    public ColorStateList getThumbTintList() {
        return this.f2171b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f2172c;
    }

    public Drawable getTrackDrawable() {
        return this.f2175f;
    }

    public ColorStateList getTrackTintList() {
        return this.f2176g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f2177h;
    }

    /* renamed from: h */
    public final boolean m2822h(float f10, float f11) {
        if (this.f2170a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f2170a.getPadding(this.f2169R);
        int i10 = this.f2156E;
        int i11 = this.f2190u;
        int i12 = i10 - i11;
        int i13 = (this.f2155D + thumbOffset) - i11;
        int i14 = this.f2154C + i13;
        Rect rect = this.f2169R;
        return f10 > ((float) i13) && f10 < ((float) (((i14 + rect.left) + rect.right) + i11)) && f11 > ((float) i12) && f11 < ((float) (this.f2158G + i11));
    }

    /* renamed from: i */
    public final Layout m2823i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.f2160I, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    /* renamed from: j */
    public void m2824j() {
        setTextOnInternal(this.f2184o);
        setTextOffInternal(this.f2186q);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2170a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2175f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f2165N;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f2165N.end();
        this.f2165N = null;
    }

    /* renamed from: k */
    public final void m2825k() throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f2186q;
            if (string == null) {
                string = getResources().getString(R$string.abc_capital_off);
            }
            C9603h0.m59845G0(this, string);
        }
    }

    /* renamed from: l */
    public final void m2826l() throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f2184o;
            if (string == null) {
                string = getResources().getString(R$string.abc_capital_on);
            }
            C9603h0.m59845G0(this, string);
        }
    }

    /* renamed from: m */
    public void m2827m(Context context, int i10) {
        C0523e0 c0523e0M2944t = C0523e0.m2944t(context, i10, R$styleable.TextAppearance);
        ColorStateList colorStateListM2949c = c0523e0M2944t.m2949c(R$styleable.TextAppearance_android_textColor);
        if (colorStateListM2949c != null) {
            this.f2161J = colorStateListM2949c;
        } else {
            this.f2161J = getTextColors();
        }
        int iM2952f = c0523e0M2944t.m2952f(R$styleable.TextAppearance_android_textSize, 0);
        if (iM2952f != 0) {
            float f10 = iM2952f;
            if (f10 != this.f2160I.getTextSize()) {
                this.f2160I.setTextSize(f10);
                requestLayout();
            }
        }
        m2829o(c0523e0M2944t.m2957k(R$styleable.TextAppearance_android_typeface, -1), c0523e0M2944t.m2957k(R$styleable.TextAppearance_android_textStyle, -1));
        if (c0523e0M2944t.m2947a(R$styleable.TextAppearance_textAllCaps, false)) {
            this.f2164M = new AllCapsTransformationMethod(getContext());
        } else {
            this.f2164M = null;
        }
        setTextOnInternal(this.f2184o);
        setTextOffInternal(this.f2186q);
        c0523e0M2944t.m2966w();
    }

    /* renamed from: n */
    public void m2828n(Typeface typeface, int i10) {
        if (i10 <= 0) {
            this.f2160I.setFakeBoldText(false);
            this.f2160I.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i10) : Typeface.create(typeface, i10);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i11 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i10;
            this.f2160I.setFakeBoldText((i11 & 1) != 0);
            this.f2160I.setTextSkewX((i11 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    /* renamed from: o */
    public final void m2829o(int i10, int i11) {
        m2828n(i10 != 1 ? i10 != 2 ? i10 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i11);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2151T);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f2169R;
        Drawable drawable = this.f2175f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i10 = this.f2156E;
        int i11 = this.f2158G;
        int i12 = i10 + rect.top;
        int i13 = i11 - rect.bottom;
        Drawable drawable2 = this.f2170a;
        if (drawable != null) {
            if (!this.f2183n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectM3143d = C0544s.m3143d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectM3143d.left;
                rect.right -= rectM3143d.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f2162K : this.f2163L;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f2161J;
            if (colorStateList != null) {
                this.f2160I.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f2160I.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i12 + i13) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f2184o : this.f2186q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(text);
            sb2.append(' ');
            sb2.append(charSequence);
            accessibilityNodeInfo.setText(sb2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int iMax;
        int width;
        int paddingLeft;
        int i14;
        int paddingTop;
        int height;
        super.onLayout(z10, i10, i11, i12, i13);
        int iMax2 = 0;
        if (this.f2170a != null) {
            Rect rect = this.f2169R;
            Drawable drawable = this.f2175f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectM3143d = C0544s.m3143d(this.f2170a);
            iMax = Math.max(0, rectM3143d.left - rect.left);
            iMax2 = Math.max(0, rectM3143d.right - rect.right);
        } else {
            iMax = 0;
        }
        if (C0535k0.m3056b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.f2152A + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.f2152A) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i14 = this.f2153B;
            paddingTop = paddingTop2 - (i14 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.f2153B;
                this.f2155D = paddingLeft;
                this.f2156E = paddingTop;
                this.f2158G = height;
                this.f2157F = width;
            }
            paddingTop = getPaddingTop();
            i14 = this.f2153B;
        }
        height = i14 + paddingTop;
        this.f2155D = paddingLeft;
        this.f2156E = paddingTop;
        this.f2158G = height;
        this.f2157F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f2188s) {
            if (this.f2162K == null) {
                this.f2162K = m2823i(this.f2185p);
            }
            if (this.f2163L == null) {
                this.f2163L = m2823i(this.f2187r);
            }
        }
        Rect rect = this.f2169R;
        Drawable drawable = this.f2170a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f2170a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f2170a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f2154C = Math.max(this.f2188s ? Math.max(this.f2162K.getWidth(), this.f2163L.getWidth()) + (this.f2180k * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f2175f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f2175f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f2170a;
        if (drawable3 != null) {
            Rect rectM3143d = C0544s.m3143d(drawable3);
            iMax = Math.max(iMax, rectM3143d.left);
            iMax2 = Math.max(iMax2, rectM3143d.right);
        }
        int iMax3 = this.f2159H ? Math.max(this.f2181l, (this.f2154C * 2) + iMax + iMax2) : this.f2181l;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f2152A = iMax3;
        this.f2153B = iMax4;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f2184o : this.f2186q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) throws android.content.res.Resources.NotFoundException {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f2193x
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9d
            r2 = 2
            if (r0 == r1) goto L89
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L89
            goto Lb7
        L16:
            int r0 = r6.f2189t
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f2191v
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3b
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L38
            r2 = r3
            goto L3b
        L38:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3b:
            boolean r0 = androidx.appcompat.widget.C0535k0.m3056b(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.f2195z
            float r0 = r0 + r2
            float r0 = m2815f(r0, r4, r3)
            float r2 = r6.f2195z
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f2191v = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f2191v
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f2190u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f2192w
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f2190u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f2189t = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f2191v = r0
            r6.f2192w = r3
            return r1
        L89:
            int r0 = r6.f2189t
            if (r0 != r2) goto L94
            r6.m2831q(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f2189t = r0
            android.view.VelocityTracker r0 = r6.f2193x
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.m2822h(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f2189t = r1
            r6.f2191v = r0
            r6.f2192w = r2
        Lb7:
            boolean r6 = super.onTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: p */
    public final void m2830p() {
        if (this.f2168Q == null && this.f2167P.m2995b() && C0688e.m4225h()) {
            C0688e c0688eM4221b = C0688e.m4221b();
            int iM4227d = c0688eM4221b.m4227d();
            if (iM4227d == 3 || iM4227d == 0) {
                C0504c c0504c = new C0504c(this);
                this.f2168Q = c0504c;
                c0688eM4221b.m4238s(c0504c);
            }
        }
    }

    /* renamed from: q */
    public final void m2831q(MotionEvent motionEvent) throws Resources.NotFoundException {
        this.f2189t = 0;
        boolean targetCheckedState = true;
        boolean z10 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z10) {
            this.f2193x.computeCurrentVelocity(1000);
            float xVelocity = this.f2193x.getXVelocity();
            if (Math.abs(xVelocity) <= this.f2194y) {
                targetCheckedState = getTargetCheckedState();
            } else if (!C0535k0.m3056b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        m2820e(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().m2997d(z10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) throws Resources.NotFoundException {
        super.setChecked(z10);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            m2826l();
        } else {
            m2825k();
        }
        if (getWindowToken() != null && C9603h0.m59864T(this)) {
            m2816a(zIsChecked);
        } else {
            m2819d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0669j.m4083q(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().m2998e(z10);
        setTextOnInternal(this.f2184o);
        setTextOffInternal(this.f2186q);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z10) {
        this.f2159H = z10;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().m2994a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.f2188s != z10) {
            this.f2188s = z10;
            requestLayout();
            if (z10) {
                m2830p();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f2183n = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f2181l = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f2182m = i10;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f2160I.getTypeface() == null || this.f2160I.getTypeface().equals(typeface)) && (this.f2160I.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f2160I.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        m2825k();
    }

    public void setTextOn(CharSequence charSequence) throws Resources.NotFoundException {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            m2826l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2170a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2170a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f10) {
        this.f2195z = f10;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(C8968a.m56743b(getContext(), i10));
    }

    public void setThumbTextPadding(int i10) {
        this.f2180k = i10;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f2171b = colorStateList;
        this.f2173d = true;
        m2817b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f2172c = mode;
        this.f2174e = true;
        m2817b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2175f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2175f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(C8968a.m56743b(getContext(), i10));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f2176g = colorStateList;
        this.f2178i = true;
        m2818c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f2177h = mode;
        this.f2179j = true;
        m2818c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() throws Resources.NotFoundException {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2170a || drawable == this.f2175f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.f2171b = null;
        this.f2172c = null;
        this.f2173d = false;
        this.f2174e = false;
        this.f2176g = null;
        this.f2177h = null;
        this.f2178i = false;
        this.f2179j = false;
        this.f2193x = VelocityTracker.obtain();
        this.f2159H = true;
        this.f2169R = new Rect();
        C0515a0.m2890a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f2160I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = R$styleable.SwitchCompat;
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, iArr, i10, 0);
        C9603h0.m59898n0(this, context, iArr, attributeSet, c0523e0M2946v.m2964r(), i10, 0);
        Drawable drawableM2953g = c0523e0M2946v.m2953g(R$styleable.SwitchCompat_android_thumb);
        this.f2170a = drawableM2953g;
        if (drawableM2953g != null) {
            drawableM2953g.setCallback(this);
        }
        Drawable drawableM2953g2 = c0523e0M2946v.m2953g(R$styleable.SwitchCompat_track);
        this.f2175f = drawableM2953g2;
        if (drawableM2953g2 != null) {
            drawableM2953g2.setCallback(this);
        }
        setTextOnInternal(c0523e0M2946v.m2962p(R$styleable.SwitchCompat_android_textOn));
        setTextOffInternal(c0523e0M2946v.m2962p(R$styleable.SwitchCompat_android_textOff));
        this.f2188s = c0523e0M2946v.m2947a(R$styleable.SwitchCompat_showText, true);
        this.f2180k = c0523e0M2946v.m2952f(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.f2181l = c0523e0M2946v.m2952f(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.f2182m = c0523e0M2946v.m2952f(R$styleable.SwitchCompat_switchPadding, 0);
        this.f2183n = c0523e0M2946v.m2947a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListM2949c = c0523e0M2946v.m2949c(R$styleable.SwitchCompat_thumbTint);
        if (colorStateListM2949c != null) {
            this.f2171b = colorStateListM2949c;
            this.f2173d = true;
        }
        PorterDuff.Mode modeM3144e = C0544s.m3144e(c0523e0M2946v.m2957k(R$styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f2172c != modeM3144e) {
            this.f2172c = modeM3144e;
            this.f2174e = true;
        }
        if (this.f2173d || this.f2174e) {
            m2817b();
        }
        ColorStateList colorStateListM2949c2 = c0523e0M2946v.m2949c(R$styleable.SwitchCompat_trackTint);
        if (colorStateListM2949c2 != null) {
            this.f2176g = colorStateListM2949c2;
            this.f2178i = true;
        }
        PorterDuff.Mode modeM3144e2 = C0544s.m3144e(c0523e0M2946v.m2957k(R$styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f2177h != modeM3144e2) {
            this.f2177h = modeM3144e2;
            this.f2179j = true;
        }
        if (this.f2178i || this.f2179j) {
            m2818c();
        }
        int iM2960n = c0523e0M2946v.m2960n(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (iM2960n != 0) {
            m2827m(context, iM2960n);
        }
        C0540o c0540o = new C0540o(this);
        this.f2166O = c0540o;
        c0540o.m3084m(attributeSet, i10);
        c0523e0M2946v.m2966w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2190u = viewConfiguration.getScaledTouchSlop();
        this.f2194y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().m2996c(attributeSet, i10);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
