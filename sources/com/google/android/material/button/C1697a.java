package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1788s;
import p273f0.C9603h0;
import p276f3.C9649c;
import p307g3.C9875a;
import p307g3.C9876b;
import p356i3.C10427h;
import p356i3.C10432m;
import p356i3.InterfaceC10435p;
import p757x.C13669a;
import p760x2.C13689a;

/* renamed from: com.google.android.material.button.a */
/* loaded from: classes.dex */
public class C1697a {

    /* renamed from: t */
    public static final boolean f7713t = true;

    /* renamed from: u */
    public static final boolean f7714u = false;

    /* renamed from: a */
    public final MaterialButton f7715a;

    /* renamed from: b */
    public C10432m f7716b;

    /* renamed from: c */
    public int f7717c;

    /* renamed from: d */
    public int f7718d;

    /* renamed from: e */
    public int f7719e;

    /* renamed from: f */
    public int f7720f;

    /* renamed from: g */
    public int f7721g;

    /* renamed from: h */
    public int f7722h;

    /* renamed from: i */
    public PorterDuff.Mode f7723i;

    /* renamed from: j */
    public ColorStateList f7724j;

    /* renamed from: k */
    public ColorStateList f7725k;

    /* renamed from: l */
    public ColorStateList f7726l;

    /* renamed from: m */
    public Drawable f7727m;

    /* renamed from: n */
    public boolean f7728n = false;

    /* renamed from: o */
    public boolean f7729o = false;

    /* renamed from: p */
    public boolean f7730p = false;

    /* renamed from: q */
    public boolean f7731q;

    /* renamed from: r */
    public LayerDrawable f7732r;

    /* renamed from: s */
    public int f7733s;

    public C1697a(MaterialButton materialButton, C10432m c10432m) {
        this.f7715a = materialButton;
        this.f7716b = c10432m;
    }

    /* renamed from: A */
    public void m9950A(ColorStateList colorStateList) {
        if (this.f7725k != colorStateList) {
            this.f7725k = colorStateList;
            m9957H();
        }
    }

    /* renamed from: B */
    public void m9951B(int i10) {
        if (this.f7722h != i10) {
            this.f7722h = i10;
            m9957H();
        }
    }

    /* renamed from: C */
    public void m9952C(ColorStateList colorStateList) {
        if (this.f7724j != colorStateList) {
            this.f7724j = colorStateList;
            if (m9964f() != null) {
                C13669a.m82228i(m9964f(), this.f7724j);
            }
        }
    }

    /* renamed from: D */
    public void m9953D(PorterDuff.Mode mode) {
        if (this.f7723i != mode) {
            this.f7723i = mode;
            if (m9964f() == null || this.f7723i == null) {
                return;
            }
            C13669a.m82229j(m9964f(), this.f7723i);
        }
    }

    /* renamed from: E */
    public final void m9954E(int i10, int i11) {
        int iM59842F = C9603h0.m59842F(this.f7715a);
        int paddingTop = this.f7715a.getPaddingTop();
        int iM59840E = C9603h0.m59840E(this.f7715a);
        int paddingBottom = this.f7715a.getPaddingBottom();
        int i12 = this.f7719e;
        int i13 = this.f7720f;
        this.f7720f = i11;
        this.f7719e = i10;
        if (!this.f7729o) {
            m9955F();
        }
        C9603h0.m59839D0(this.f7715a, iM59842F, (paddingTop + i10) - i12, iM59840E, (paddingBottom + i11) - i13);
    }

    /* renamed from: F */
    public final void m9955F() {
        this.f7715a.setInternalBackground(m9959a());
        C10427h c10427hM9964f = m9964f();
        if (c10427hM9964f != null) {
            c10427hM9964f.m64001a0(this.f7733s);
        }
    }

    /* renamed from: G */
    public final void m9956G(C10432m c10432m) {
        if (f7714u && !this.f7729o) {
            int iM59842F = C9603h0.m59842F(this.f7715a);
            int paddingTop = this.f7715a.getPaddingTop();
            int iM59840E = C9603h0.m59840E(this.f7715a);
            int paddingBottom = this.f7715a.getPaddingBottom();
            m9955F();
            C9603h0.m59839D0(this.f7715a, iM59842F, paddingTop, iM59840E, paddingBottom);
            return;
        }
        if (m9964f() != null) {
            m9964f().setShapeAppearanceModel(c10432m);
        }
        if (m9972n() != null) {
            m9972n().setShapeAppearanceModel(c10432m);
        }
        if (m9963e() != null) {
            m9963e().setShapeAppearanceModel(c10432m);
        }
    }

    /* renamed from: H */
    public final void m9957H() {
        C10427h c10427hM9964f = m9964f();
        C10427h c10427hM9972n = m9972n();
        if (c10427hM9964f != null) {
            c10427hM9964f.m64017k0(this.f7722h, this.f7725k);
            if (c10427hM9972n != null) {
                c10427hM9972n.m64015j0(this.f7722h, this.f7728n ? C13689a.m82290d(this.f7715a, R$attr.colorSurface) : 0);
            }
        }
    }

    /* renamed from: I */
    public final InsetDrawable m9958I(Drawable drawable) {
        return new InsetDrawable(drawable, this.f7717c, this.f7719e, this.f7718d, this.f7720f);
    }

    /* renamed from: a */
    public final Drawable m9959a() {
        C10427h c10427h = new C10427h(this.f7716b);
        c10427h.m63992Q(this.f7715a.getContext());
        C13669a.m82228i(c10427h, this.f7724j);
        PorterDuff.Mode mode = this.f7723i;
        if (mode != null) {
            C13669a.m82229j(c10427h, mode);
        }
        c10427h.m64017k0(this.f7722h, this.f7725k);
        C10427h c10427h2 = new C10427h(this.f7716b);
        c10427h2.setTint(0);
        c10427h2.m64015j0(this.f7722h, this.f7728n ? C13689a.m82290d(this.f7715a, R$attr.colorSurface) : 0);
        if (f7713t) {
            C10427h c10427h3 = new C10427h(this.f7716b);
            this.f7727m = c10427h3;
            C13669a.m82227h(c10427h3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(C9876b.m61325d(this.f7726l), m9958I(new LayerDrawable(new Drawable[]{c10427h2, c10427h})), this.f7727m);
            this.f7732r = rippleDrawable;
            return rippleDrawable;
        }
        C9875a c9875a = new C9875a(this.f7716b);
        this.f7727m = c9875a;
        C13669a.m82228i(c9875a, C9876b.m61325d(this.f7726l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{c10427h2, c10427h, this.f7727m});
        this.f7732r = layerDrawable;
        return m9958I(layerDrawable);
    }

    /* renamed from: b */
    public int m9960b() {
        return this.f7721g;
    }

    /* renamed from: c */
    public int m9961c() {
        return this.f7720f;
    }

    /* renamed from: d */
    public int m9962d() {
        return this.f7719e;
    }

    /* renamed from: e */
    public InterfaceC10435p m9963e() {
        LayerDrawable layerDrawable = this.f7732r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f7732r.getNumberOfLayers() > 2 ? (InterfaceC10435p) this.f7732r.getDrawable(2) : (InterfaceC10435p) this.f7732r.getDrawable(1);
    }

    /* renamed from: f */
    public C10427h m9964f() {
        return m9965g(false);
    }

    /* renamed from: g */
    public final C10427h m9965g(boolean z10) {
        LayerDrawable layerDrawable = this.f7732r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f7713t ? (C10427h) ((LayerDrawable) ((InsetDrawable) this.f7732r.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0) : (C10427h) this.f7732r.getDrawable(!z10 ? 1 : 0);
    }

    /* renamed from: h */
    public ColorStateList m9966h() {
        return this.f7726l;
    }

    /* renamed from: i */
    public C10432m m9967i() {
        return this.f7716b;
    }

    /* renamed from: j */
    public ColorStateList m9968j() {
        return this.f7725k;
    }

    /* renamed from: k */
    public int m9969k() {
        return this.f7722h;
    }

    /* renamed from: l */
    public ColorStateList m9970l() {
        return this.f7724j;
    }

    /* renamed from: m */
    public PorterDuff.Mode m9971m() {
        return this.f7723i;
    }

    /* renamed from: n */
    public final C10427h m9972n() {
        return m9965g(true);
    }

    /* renamed from: o */
    public boolean m9973o() {
        return this.f7729o;
    }

    /* renamed from: p */
    public boolean m9974p() {
        return this.f7731q;
    }

    /* renamed from: q */
    public void m9975q(TypedArray typedArray) {
        this.f7717c = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        this.f7718d = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        this.f7719e = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        this.f7720f = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        int i10 = R$styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i10)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            this.f7721g = dimensionPixelSize;
            m9983y(this.f7716b.m64067w(dimensionPixelSize));
            this.f7730p = true;
        }
        this.f7722h = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        this.f7723i = C1788s.m10789j(typedArray.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f7724j = C9649c.m60265a(this.f7715a.getContext(), typedArray, R$styleable.MaterialButton_backgroundTint);
        this.f7725k = C9649c.m60265a(this.f7715a.getContext(), typedArray, R$styleable.MaterialButton_strokeColor);
        this.f7726l = C9649c.m60265a(this.f7715a.getContext(), typedArray, R$styleable.MaterialButton_rippleColor);
        this.f7731q = typedArray.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        this.f7733s = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        int iM59842F = C9603h0.m59842F(this.f7715a);
        int paddingTop = this.f7715a.getPaddingTop();
        int iM59840E = C9603h0.m59840E(this.f7715a);
        int paddingBottom = this.f7715a.getPaddingBottom();
        if (typedArray.hasValue(R$styleable.MaterialButton_android_background)) {
            m9977s();
        } else {
            m9955F();
        }
        C9603h0.m59839D0(this.f7715a, iM59842F + this.f7717c, paddingTop + this.f7719e, iM59840E + this.f7718d, paddingBottom + this.f7720f);
    }

    /* renamed from: r */
    public void m9976r(int i10) {
        if (m9964f() != null) {
            m9964f().setTint(i10);
        }
    }

    /* renamed from: s */
    public void m9977s() {
        this.f7729o = true;
        this.f7715a.setSupportBackgroundTintList(this.f7724j);
        this.f7715a.setSupportBackgroundTintMode(this.f7723i);
    }

    /* renamed from: t */
    public void m9978t(boolean z10) {
        this.f7731q = z10;
    }

    /* renamed from: u */
    public void m9979u(int i10) {
        if (this.f7730p && this.f7721g == i10) {
            return;
        }
        this.f7721g = i10;
        this.f7730p = true;
        m9983y(this.f7716b.m64067w(i10));
    }

    /* renamed from: v */
    public void m9980v(int i10) {
        m9954E(this.f7719e, i10);
    }

    /* renamed from: w */
    public void m9981w(int i10) {
        m9954E(i10, this.f7720f);
    }

    /* renamed from: x */
    public void m9982x(ColorStateList colorStateList) {
        if (this.f7726l != colorStateList) {
            this.f7726l = colorStateList;
            boolean z10 = f7713t;
            if (z10 && (this.f7715a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f7715a.getBackground()).setColor(C9876b.m61325d(colorStateList));
            } else {
                if (z10 || !(this.f7715a.getBackground() instanceof C9875a)) {
                    return;
                }
                ((C9875a) this.f7715a.getBackground()).setTintList(C9876b.m61325d(colorStateList));
            }
        }
    }

    /* renamed from: y */
    public void m9983y(C10432m c10432m) {
        this.f7716b = c10432m;
        m9956G(c10432m);
    }

    /* renamed from: z */
    public void m9984z(boolean z10) {
        this.f7728n = z10;
        m9957H();
    }
}
