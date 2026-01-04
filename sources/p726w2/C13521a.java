package p726w2;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.card.MaterialCardView;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p273f0.C9603h0;
import p276f3.C9649c;
import p307g3.C9876b;
import p356i3.C10423d;
import p356i3.C10424e;
import p356i3.C10427h;
import p356i3.C10431l;
import p356i3.C10432m;
import p757x.C13669a;
import p760x2.C13689a;

/* renamed from: w2.a */
/* loaded from: classes.dex */
public class C13521a {

    /* renamed from: u */
    public static final double f60844u = Math.cos(Math.toRadians(45.0d));

    /* renamed from: v */
    public static final Drawable f60845v = null;

    /* renamed from: a */
    public final MaterialCardView f60846a;

    /* renamed from: c */
    public final C10427h f60848c;

    /* renamed from: d */
    public final C10427h f60849d;

    /* renamed from: e */
    public int f60850e;

    /* renamed from: f */
    public int f60851f;

    /* renamed from: g */
    public int f60852g;

    /* renamed from: h */
    public int f60853h;

    /* renamed from: i */
    public Drawable f60854i;

    /* renamed from: j */
    public Drawable f60855j;

    /* renamed from: k */
    public ColorStateList f60856k;

    /* renamed from: l */
    public ColorStateList f60857l;

    /* renamed from: m */
    public C10432m f60858m;

    /* renamed from: n */
    public ColorStateList f60859n;

    /* renamed from: o */
    public Drawable f60860o;

    /* renamed from: p */
    public LayerDrawable f60861p;

    /* renamed from: q */
    public C10427h f60862q;

    /* renamed from: r */
    public C10427h f60863r;

    /* renamed from: t */
    public boolean f60865t;

    /* renamed from: b */
    public final Rect f60847b = new Rect();

    /* renamed from: s */
    public boolean f60864s = false;

    /* renamed from: w2.a$a */
    public class a extends InsetDrawable {
        public a(Drawable drawable, int i10, int i11, int i12, int i13) {
            super(drawable, i10, i11, i12, i13);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public C13521a(MaterialCardView materialCardView, AttributeSet attributeSet, int i10, int i11) {
        this.f60846a = materialCardView;
        C10427h c10427h = new C10427h(materialCardView.getContext(), attributeSet, i10, i11);
        this.f60848c = c10427h;
        c10427h.m63992Q(materialCardView.getContext());
        c10427h.m64011h0(-12303292);
        C10432m.b bVarM64066v = c10427h.m63980E().m64066v();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i10, R$style.CardView);
        int i12 = R$styleable.CardView_cardCornerRadius;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            bVarM64066v.m64094o(typedArrayObtainStyledAttributes.getDimension(i12, 0.0f));
        }
        this.f60849d = new C10427h();
        m81337V(bVarM64066v.m64093m());
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: A */
    public Rect m81316A() {
        return this.f60847b;
    }

    /* renamed from: B */
    public final Drawable m81317B(Drawable drawable) {
        int iCeil;
        int iCeil2;
        if (this.f60846a.getUseCompatPadding()) {
            iCeil2 = (int) Math.ceil(m81348d());
            iCeil = (int) Math.ceil(m81346c());
        } else {
            iCeil = 0;
            iCeil2 = 0;
        }
        return new a(drawable, iCeil, iCeil2, iCeil, iCeil2);
    }

    /* renamed from: C */
    public boolean m81318C() {
        return this.f60864s;
    }

    /* renamed from: D */
    public boolean m81319D() {
        return this.f60865t;
    }

    /* renamed from: E */
    public final boolean m81320E() {
        return (this.f60852g & 80) == 80;
    }

    /* renamed from: F */
    public final boolean m81321F() {
        return (this.f60852g & 8388613) == 8388613;
    }

    /* renamed from: G */
    public void m81322G(TypedArray typedArray) {
        ColorStateList colorStateListM60265a = C9649c.m60265a(this.f60846a.getContext(), typedArray, R$styleable.MaterialCardView_strokeColor);
        this.f60859n = colorStateListM60265a;
        if (colorStateListM60265a == null) {
            this.f60859n = ColorStateList.valueOf(-1);
        }
        this.f60853h = typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z10 = typedArray.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        this.f60865t = z10;
        this.f60846a.setLongClickable(z10);
        this.f60857l = C9649c.m60265a(this.f60846a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIconTint);
        m81329N(C9649c.m60269e(this.f60846a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIcon));
        m81332Q(typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0));
        m81331P(typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0));
        this.f60852g = typedArray.getInteger(R$styleable.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList colorStateListM60265a2 = C9649c.m60265a(this.f60846a.getContext(), typedArray, R$styleable.MaterialCardView_rippleColor);
        this.f60856k = colorStateListM60265a2;
        if (colorStateListM60265a2 == null) {
            this.f60856k = ColorStateList.valueOf(C13689a.m82290d(this.f60846a, R$attr.colorControlHighlight));
        }
        m81326K(C9649c.m60265a(this.f60846a.getContext(), typedArray, R$styleable.MaterialCardView_cardForegroundColor));
        m81355g0();
        m81349d0();
        m81357h0();
        this.f60846a.setBackgroundInternal(m81317B(this.f60848c));
        Drawable drawableM81367r = this.f60846a.isClickable() ? m81367r() : this.f60849d;
        this.f60854i = drawableM81367r;
        this.f60846a.setForeground(m81317B(drawableM81367r));
    }

    /* renamed from: H */
    public void m81323H(int i10, int i11) {
        int iCeil;
        int iCeil2;
        int i12;
        int i13;
        if (this.f60861p != null) {
            if (this.f60846a.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(m81348d() * 2.0f);
                iCeil2 = (int) Math.ceil(m81346c() * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i14 = m81321F() ? ((i10 - this.f60850e) - this.f60851f) - iCeil2 : this.f60850e;
            int i15 = m81320E() ? this.f60850e : ((i11 - this.f60850e) - this.f60851f) - iCeil;
            int i16 = m81321F() ? this.f60850e : ((i10 - this.f60850e) - this.f60851f) - iCeil2;
            int i17 = m81320E() ? ((i11 - this.f60850e) - this.f60851f) - iCeil : this.f60850e;
            if (C9603h0.m59832A(this.f60846a) == 1) {
                i13 = i16;
                i12 = i14;
            } else {
                i12 = i16;
                i13 = i14;
            }
            this.f60861p.setLayerInset(2, i13, i17, i12, i15);
        }
    }

    /* renamed from: I */
    public void m81324I(boolean z10) {
        this.f60864s = z10;
    }

    /* renamed from: J */
    public void m81325J(ColorStateList colorStateList) {
        this.f60848c.m64002b0(colorStateList);
    }

    /* renamed from: K */
    public void m81326K(ColorStateList colorStateList) {
        C10427h c10427h = this.f60849d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        c10427h.m64002b0(colorStateList);
    }

    /* renamed from: L */
    public void m81327L(boolean z10) {
        this.f60865t = z10;
    }

    /* renamed from: M */
    public void m81328M(boolean z10) {
        Drawable drawable = this.f60855j;
        if (drawable != null) {
            drawable.setAlpha(z10 ? HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA : 0);
        }
    }

    /* renamed from: N */
    public void m81329N(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = C13669a.m82231l(drawable).mutate();
            this.f60855j = drawableMutate;
            C13669a.m82228i(drawableMutate, this.f60857l);
            m81328M(this.f60846a.isChecked());
        } else {
            this.f60855j = f60845v;
        }
        LayerDrawable layerDrawable = this.f60861p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, this.f60855j);
        }
    }

    /* renamed from: O */
    public void m81330O(int i10) {
        this.f60852g = i10;
        m81323H(this.f60846a.getMeasuredWidth(), this.f60846a.getMeasuredHeight());
    }

    /* renamed from: P */
    public void m81331P(int i10) {
        this.f60850e = i10;
    }

    /* renamed from: Q */
    public void m81332Q(int i10) {
        this.f60851f = i10;
    }

    /* renamed from: R */
    public void m81333R(ColorStateList colorStateList) {
        this.f60857l = colorStateList;
        Drawable drawable = this.f60855j;
        if (drawable != null) {
            C13669a.m82228i(drawable, colorStateList);
        }
    }

    /* renamed from: S */
    public void m81334S(float f10) {
        m81337V(this.f60858m.m64067w(f10));
        this.f60854i.invalidateSelf();
        if (m81343a0() || m81341Z()) {
            m81347c0();
        }
        if (m81343a0()) {
            m81353f0();
        }
    }

    /* renamed from: T */
    public void m81335T(float f10) {
        this.f60848c.m64003c0(f10);
        C10427h c10427h = this.f60849d;
        if (c10427h != null) {
            c10427h.m64003c0(f10);
        }
        C10427h c10427h2 = this.f60863r;
        if (c10427h2 != null) {
            c10427h2.m64003c0(f10);
        }
    }

    /* renamed from: U */
    public void m81336U(ColorStateList colorStateList) {
        this.f60856k = colorStateList;
        m81355g0();
    }

    /* renamed from: V */
    public void m81337V(C10432m c10432m) {
        this.f60858m = c10432m;
        this.f60848c.setShapeAppearanceModel(c10432m);
        this.f60848c.m64009g0(!r0.m63995T());
        C10427h c10427h = this.f60849d;
        if (c10427h != null) {
            c10427h.setShapeAppearanceModel(c10432m);
        }
        C10427h c10427h2 = this.f60863r;
        if (c10427h2 != null) {
            c10427h2.setShapeAppearanceModel(c10432m);
        }
        C10427h c10427h3 = this.f60862q;
        if (c10427h3 != null) {
            c10427h3.setShapeAppearanceModel(c10432m);
        }
    }

    /* renamed from: W */
    public void m81338W(ColorStateList colorStateList) {
        if (this.f60859n == colorStateList) {
            return;
        }
        this.f60859n = colorStateList;
        m81357h0();
    }

    /* renamed from: X */
    public void m81339X(int i10) {
        if (i10 == this.f60853h) {
            return;
        }
        this.f60853h = i10;
        m81357h0();
    }

    /* renamed from: Y */
    public void m81340Y(int i10, int i11, int i12, int i13) {
        this.f60847b.set(i10, i11, i12, i13);
        m81347c0();
    }

    /* renamed from: Z */
    public final boolean m81341Z() {
        return this.f60846a.getPreventCornerOverlap() && !m81350e();
    }

    /* renamed from: a */
    public final float m81342a() {
        return Math.max(Math.max(m81344b(this.f60858m.m64061q(), this.f60848c.m63985J()), m81344b(this.f60858m.m64063s(), this.f60848c.m63986K())), Math.max(m81344b(this.f60858m.m64056k(), this.f60848c.m64029t()), m81344b(this.f60858m.m64054i(), this.f60848c.m64028s())));
    }

    /* renamed from: a0 */
    public final boolean m81343a0() {
        return this.f60846a.getPreventCornerOverlap() && m81350e() && this.f60846a.getUseCompatPadding();
    }

    /* renamed from: b */
    public final float m81344b(C10423d c10423d, float f10) {
        if (c10423d instanceof C10431l) {
            return (float) ((1.0d - f60844u) * f10);
        }
        if (c10423d instanceof C10424e) {
            return f10 / 2.0f;
        }
        return 0.0f;
    }

    /* renamed from: b0 */
    public void m81345b0() {
        Drawable drawable = this.f60854i;
        Drawable drawableM81367r = this.f60846a.isClickable() ? m81367r() : this.f60849d;
        this.f60854i = drawableM81367r;
        if (drawable != drawableM81367r) {
            m81351e0(drawableM81367r);
        }
    }

    /* renamed from: c */
    public final float m81346c() {
        return this.f60846a.getMaxCardElevation() + (m81343a0() ? m81342a() : 0.0f);
    }

    /* renamed from: c0 */
    public void m81347c0() {
        int iM81342a = (int) (((m81341Z() || m81343a0()) ? m81342a() : 0.0f) - m81369t());
        MaterialCardView materialCardView = this.f60846a;
        Rect rect = this.f60847b;
        materialCardView.m9989k(rect.left + iM81342a, rect.top + iM81342a, rect.right + iM81342a, rect.bottom + iM81342a);
    }

    /* renamed from: d */
    public final float m81348d() {
        return (this.f60846a.getMaxCardElevation() * 1.5f) + (m81343a0() ? m81342a() : 0.0f);
    }

    /* renamed from: d0 */
    public void m81349d0() {
        this.f60848c.m64001a0(this.f60846a.getCardElevation());
    }

    /* renamed from: e */
    public final boolean m81350e() {
        return this.f60848c.m63995T();
    }

    /* renamed from: e0 */
    public final void m81351e0(Drawable drawable) {
        if (this.f60846a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.f60846a.getForeground()).setDrawable(drawable);
        } else {
            this.f60846a.setForeground(m81317B(drawable));
        }
    }

    /* renamed from: f */
    public final Drawable m81352f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        C10427h c10427hM81356h = m81356h();
        this.f60862q = c10427hM81356h;
        c10427hM81356h.m64002b0(this.f60856k);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.f60862q);
        return stateListDrawable;
    }

    /* renamed from: f0 */
    public void m81353f0() {
        if (!m81318C()) {
            this.f60846a.setBackgroundInternal(m81317B(this.f60848c));
        }
        this.f60846a.setForeground(m81317B(this.f60854i));
    }

    /* renamed from: g */
    public final Drawable m81354g() {
        if (!C9876b.f48499a) {
            return m81352f();
        }
        this.f60863r = m81356h();
        return new RippleDrawable(this.f60856k, null, this.f60863r);
    }

    /* renamed from: g0 */
    public final void m81355g0() {
        Drawable drawable;
        if (C9876b.f48499a && (drawable = this.f60860o) != null) {
            ((RippleDrawable) drawable).setColor(this.f60856k);
            return;
        }
        C10427h c10427h = this.f60862q;
        if (c10427h != null) {
            c10427h.m64002b0(this.f60856k);
        }
    }

    /* renamed from: h */
    public final C10427h m81356h() {
        return new C10427h(this.f60858m);
    }

    /* renamed from: h0 */
    public void m81357h0() {
        this.f60849d.m64017k0(this.f60853h, this.f60859n);
    }

    /* renamed from: i */
    public void m81358i() {
        Drawable drawable = this.f60860o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i10 = bounds.bottom;
            this.f60860o.setBounds(bounds.left, bounds.top, bounds.right, i10 - 1);
            this.f60860o.setBounds(bounds.left, bounds.top, bounds.right, i10);
        }
    }

    /* renamed from: j */
    public C10427h m81359j() {
        return this.f60848c;
    }

    /* renamed from: k */
    public ColorStateList m81360k() {
        return this.f60848c.m64033x();
    }

    /* renamed from: l */
    public ColorStateList m81361l() {
        return this.f60849d.m64033x();
    }

    /* renamed from: m */
    public Drawable m81362m() {
        return this.f60855j;
    }

    /* renamed from: n */
    public int m81363n() {
        return this.f60852g;
    }

    /* renamed from: o */
    public int m81364o() {
        return this.f60850e;
    }

    /* renamed from: p */
    public int m81365p() {
        return this.f60851f;
    }

    /* renamed from: q */
    public ColorStateList m81366q() {
        return this.f60857l;
    }

    /* renamed from: r */
    public final Drawable m81367r() {
        if (this.f60860o == null) {
            this.f60860o = m81354g();
        }
        if (this.f60861p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f60860o, this.f60849d, this.f60855j});
            this.f60861p = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.f60861p;
    }

    /* renamed from: s */
    public float m81368s() {
        return this.f60848c.m63985J();
    }

    /* renamed from: t */
    public final float m81369t() {
        if (this.f60846a.getPreventCornerOverlap() && this.f60846a.getUseCompatPadding()) {
            return (float) ((1.0d - f60844u) * this.f60846a.getCardViewRadius());
        }
        return 0.0f;
    }

    /* renamed from: u */
    public float m81370u() {
        return this.f60848c.m64034y();
    }

    /* renamed from: v */
    public ColorStateList m81371v() {
        return this.f60856k;
    }

    /* renamed from: w */
    public C10432m m81372w() {
        return this.f60858m;
    }

    /* renamed from: x */
    public int m81373x() {
        ColorStateList colorStateList = this.f60859n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* renamed from: y */
    public ColorStateList m81374y() {
        return this.f60859n;
    }

    /* renamed from: z */
    public int m81375z() {
        return this.f60853h;
    }
}
