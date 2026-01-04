package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.chip.C1708a;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import com.google.android.material.internal.InterfaceC1776g;
import java.util.List;
import p273f0.C9603h0;
import p276f3.AbstractC9652f;
import p276f3.C9650d;
import p304g0.C9832l;
import p307g3.C9876b;
import p356i3.C10428i;
import p356i3.C10432m;
import p356i3.InterfaceC10435p;
import p413k0.AbstractC10968a;
import p416k3.C10981a;
import p666u2.C13117h;

/* loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements C1708a.a, InterfaceC10435p, InterfaceC1776g<Chip> {

    /* renamed from: e */
    public C1708a f7751e;

    /* renamed from: f */
    public InsetDrawable f7752f;

    /* renamed from: g */
    public RippleDrawable f7753g;

    /* renamed from: h */
    public View.OnClickListener f7754h;

    /* renamed from: i */
    public CompoundButton.OnCheckedChangeListener f7755i;

    /* renamed from: j */
    public InterfaceC1776g.a<Chip> f7756j;

    /* renamed from: k */
    public boolean f7757k;

    /* renamed from: l */
    public boolean f7758l;

    /* renamed from: m */
    public boolean f7759m;

    /* renamed from: n */
    public boolean f7760n;

    /* renamed from: o */
    public boolean f7761o;

    /* renamed from: p */
    public int f7762p;

    /* renamed from: q */
    public int f7763q;

    /* renamed from: r */
    public CharSequence f7764r;

    /* renamed from: s */
    public final C1702d f7765s;

    /* renamed from: t */
    public boolean f7766t;

    /* renamed from: u */
    public final Rect f7767u;

    /* renamed from: v */
    public final RectF f7768v;

    /* renamed from: w */
    public final AbstractC9652f f7769w;

    /* renamed from: x */
    public static final int f7748x = R$style.Widget_MaterialComponents_Chip_Action;

    /* renamed from: y */
    public static final Rect f7749y = new Rect();

    /* renamed from: z */
    public static final int[] f7750z = {R.attr.state_selected};

    /* renamed from: A */
    public static final int[] f7747A = {R.attr.state_checkable};

    /* renamed from: com.google.android.material.chip.Chip$a */
    public class C1699a extends AbstractC9652f {
        public C1699a() {
        }

        @Override // p276f3.AbstractC9652f
        /* renamed from: a */
        public void mo10020a(int i10) {
        }

        @Override // p276f3.AbstractC9652f
        /* renamed from: b */
        public void mo10021b(Typeface typeface, boolean z10) {
            Chip chip = Chip.this;
            chip.setText(chip.f7751e.m10093R2() ? Chip.this.f7751e.m10142n1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* renamed from: com.google.android.material.chip.Chip$b */
    public class C1700b implements CompoundButton.OnCheckedChangeListener {
        public C1700b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (Chip.this.f7756j != null) {
                Chip.this.f7756j.mo10586a(Chip.this, z10);
            }
            if (Chip.this.f7755i != null) {
                Chip.this.f7755i.onCheckedChanged(compoundButton, z10);
            }
        }
    }

    /* renamed from: com.google.android.material.chip.Chip$c */
    public class C1701c extends ViewOutlineProvider {
        public C1701c() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f7751e != null) {
                Chip.this.f7751e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: com.google.android.material.chip.Chip$d */
    public class C1702d extends AbstractC10968a {
        public C1702d(Chip chip) {
            super(chip);
        }

        @Override // p413k0.AbstractC10968a
        /* renamed from: B */
        public void mo10022B(C9832l c9832l) {
            c9832l.m61063S(Chip.this.m10012s());
            c9832l.m61066V(Chip.this.isClickable());
            c9832l.m61065U(Chip.this.getAccessibilityClassName());
            c9832l.m61114w0(Chip.this.getText());
        }

        @Override // p413k0.AbstractC10968a
        /* renamed from: C */
        public void mo10023C(int i10, C9832l c9832l) {
            if (i10 != 1) {
                c9832l.m61069Y("");
                c9832l.m61060P(Chip.f7749y);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                c9832l.m61069Y(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i11 = R$string.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                c9832l.m61069Y(context.getString(i11, objArr).trim());
            }
            c9832l.m61060P(Chip.this.getCloseIconTouchBoundsInt());
            c9832l.m61073b(C9832l.a.f48299i);
            c9832l.m61074b0(Chip.this.isEnabled());
        }

        @Override // p413k0.AbstractC10968a
        /* renamed from: D */
        public void mo10024D(int i10, boolean z10) {
            if (i10 == 1) {
                Chip.this.f7760n = z10;
                Chip.this.refreshDrawableState();
            }
        }

        @Override // p413k0.AbstractC10968a
        /* renamed from: o */
        public int mo10025o(float f10, float f11) {
            return (Chip.this.m10008o() && Chip.this.getCloseIconTouchBounds().contains(f10, f11)) ? 1 : 0;
        }

        @Override // p413k0.AbstractC10968a
        /* renamed from: p */
        public void mo10026p(List<Integer> list) {
            list.add(0);
            if (Chip.this.m10008o() && Chip.this.m10013t() && Chip.this.f7754h != null) {
                list.add(1);
            }
        }

        @Override // p413k0.AbstractC10968a
        /* renamed from: y */
        public boolean mo10027y(int i10, int i11, Bundle bundle) {
            if (i11 != 16) {
                return false;
            }
            if (i10 == 0) {
                return Chip.this.performClick();
            }
            if (i10 == 1) {
                return Chip.this.m10014u();
            }
            return false;
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f7768v.setEmpty();
        if (m10008o() && this.f7754h != null) {
            this.f7751e.m10124e1(this.f7768v);
        }
        return this.f7768v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f7767u.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f7767u;
    }

    private C9650d getTextAppearance() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10144o1();
        }
        return null;
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f7759m != z10) {
            this.f7759m = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f7758l != z10) {
            this.f7758l = z10;
            refreshDrawableState();
        }
    }

    /* renamed from: A */
    public final void m9999A() {
        this.f7753g = new RippleDrawable(C9876b.m61325d(this.f7751e.m10138l1()), getBackgroundDrawable(), null);
        this.f7751e.m10090Q2(false);
        C9603h0.m59910t0(this, this.f7753g);
        m10000B();
    }

    /* renamed from: B */
    public final void m10000B() {
        C1708a c1708a;
        if (TextUtils.isEmpty(getText()) || (c1708a = this.f7751e) == null) {
            return;
        }
        int iM10085P0 = (int) (c1708a.m10085P0() + this.f7751e.m10146p1() + this.f7751e.m10165w0());
        int iM10100U0 = (int) (this.f7751e.m10100U0() + this.f7751e.m10149q1() + this.f7751e.m10154s0());
        if (this.f7752f != null) {
            Rect rect = new Rect();
            this.f7752f.getPadding(rect);
            iM10100U0 += rect.left;
            iM10085P0 += rect.right;
        }
        C9603h0.m59839D0(this, iM10100U0, getPaddingTop(), iM10085P0, getPaddingBottom());
    }

    /* renamed from: C */
    public final void m10001C() {
        TextPaint paint = getPaint();
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            paint.drawableState = c1708a.getState();
        }
        C9650d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.m60288n(getContext(), paint, this.f7769w);
        }
    }

    /* renamed from: D */
    public final void m10002D(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    @Override // com.google.android.material.chip.C1708a.a
    /* renamed from: a */
    public void mo10003a() {
        m10006m(this.f7763q);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f7766t ? super.dispatchHoverEvent(motionEvent) : this.f7765s.m66216i(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f7766t) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f7765s.m66217j(keyEvent) || this.f7765s.m66221n() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1708a c1708a = this.f7751e;
        if (c1708a != null && c1708a.m10163v1() && this.f7751e.m10153r2(m10005l())) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f7764r)) {
            return this.f7764r;
        }
        if (!m10012s()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).m10032h()) ? "android.widget.RadioButton" : "android.widget.CompoundButton";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f7752f;
        return insetDrawable == null ? this.f7751e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10073L0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10076M0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10079N0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return Math.max(0.0f, c1708a.m10082O0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f7751e;
    }

    public float getChipEndPadding() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10085P0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10088Q0();
        }
        return null;
    }

    public float getChipIconSize() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10091R0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10094S0();
        }
        return null;
    }

    public float getChipMinHeight() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10097T0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10100U0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10103V0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10106W0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10109X0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10112Y0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10114Z0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10116a1();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10118b1();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10122d1();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10130h1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f7766t && (this.f7765s.m66221n() == 1 || this.f7765s.m66218k() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public C13117h getHideMotionSpec() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10132i1();
        }
        return null;
    }

    public float getIconEndPadding() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10134j1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10136k1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10138l1();
        }
        return null;
    }

    public C10432m getShapeAppearanceModel() {
        return this.f7751e.m63980E();
    }

    public C13117h getShowMotionSpec() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10140m1();
        }
        return null;
    }

    public float getTextEndPadding() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10146p1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            return c1708a.m10149q1();
        }
        return 0.0f;
    }

    /* renamed from: k */
    public final void m10004k(C1708a c1708a) {
        c1708a.m10164v2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* renamed from: l */
    public final int[] m10005l() {
        ?? IsEnabled = isEnabled();
        int i10 = IsEnabled;
        if (this.f7760n) {
            i10 = IsEnabled + 1;
        }
        int i11 = i10;
        if (this.f7759m) {
            i11 = i10 + 1;
        }
        int i12 = i11;
        if (this.f7758l) {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (isChecked()) {
            i13 = i12 + 1;
        }
        int[] iArr = new int[i13];
        int i14 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i14 = 1;
        }
        if (this.f7760n) {
            iArr[i14] = 16842908;
            i14++;
        }
        if (this.f7759m) {
            iArr[i14] = 16843623;
            i14++;
        }
        if (this.f7758l) {
            iArr[i14] = 16842919;
            i14++;
        }
        if (isChecked()) {
            iArr[i14] = 16842913;
        }
        return iArr;
    }

    /* renamed from: m */
    public boolean m10006m(int i10) {
        this.f7763q = i10;
        if (!m10016w()) {
            if (this.f7752f != null) {
                m10015v();
            } else {
                m10019z();
            }
            return false;
        }
        int iMax = Math.max(0, i10 - this.f7751e.getIntrinsicHeight());
        int iMax2 = Math.max(0, i10 - this.f7751e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f7752f != null) {
                m10015v();
            } else {
                m10019z();
            }
            return false;
        }
        int i11 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i12 = iMax > 0 ? iMax / 2 : 0;
        if (this.f7752f != null) {
            Rect rect = new Rect();
            this.f7752f.getPadding(rect);
            if (rect.top == i12 && rect.bottom == i12 && rect.left == i11 && rect.right == i11) {
                m10019z();
                return true;
            }
        }
        if (getMinHeight() != i10) {
            setMinHeight(i10);
        }
        if (getMinWidth() != i10) {
            setMinWidth(i10);
        }
        m10011r(i11, i12, i11, i12);
        m10019z();
        return true;
    }

    /* renamed from: n */
    public final void m10007n() {
        if (getBackgroundDrawable() == this.f7752f && this.f7751e.getCallback() == null) {
            this.f7751e.setCallback(this.f7752f);
        }
    }

    /* renamed from: o */
    public final boolean m10008o() {
        C1708a c1708a = this.f7751e;
        return (c1708a == null || c1708a.m10109X0() == null) ? false : true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10428i.m64044f(this, this.f7751e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7750z);
        }
        if (m10012s()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7747A);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.f7766t) {
            this.f7765s.m66227x(z10, i10, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(m10012s());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            C9832l.m61042A0(accessibilityNodeInfo).m61068X(C9832l.c.m61127a(chipGroup.m10552b(this), 1, chipGroup.mo10030c() ? chipGroup.m10031g(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i10) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.f7762p != i10) {
            this.f7762p = i10;
            m10000B();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3b
            if (r0 == r2) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L41
        L21:
            boolean r0 = r5.f7758l
            if (r0 == 0) goto L41
            if (r1 != 0) goto L49
            r5.setCloseIconPressed(r3)
            goto L49
        L2b:
            boolean r0 = r5.f7758l
            if (r0 == 0) goto L34
            r5.m10014u()
            r0 = r2
            goto L35
        L34:
            r0 = r3
        L35:
            r5.setCloseIconPressed(r3)
            if (r0 != 0) goto L49
            goto L41
        L3b:
            if (r1 == 0) goto L41
            r5.setCloseIconPressed(r2)
            goto L49
        L41:
            boolean r5 = super.onTouchEvent(r6)
            if (r5 == 0) goto L48
            goto L49
        L48:
            r2 = r3
        L49:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: p */
    public final void m10009p(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayM10770h = C1784o.m10770h(context, attributeSet, R$styleable.Chip, i10, f7748x, new int[0]);
        this.f7761o = typedArrayM10770h.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.f7763q = (int) Math.ceil(typedArrayM10770h.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(C1788s.m10782c(getContext(), 48))));
        typedArrayM10770h.recycle();
    }

    /* renamed from: q */
    public final void m10010q() {
        setOutlineProvider(new C1701c());
    }

    /* renamed from: r */
    public final void m10011r(int i10, int i11, int i12, int i13) {
        this.f7752f = new InsetDrawable((Drawable) this.f7751e, i10, i11, i12, i13);
    }

    /* renamed from: s */
    public boolean m10012s() {
        C1708a c1708a = this.f7751e;
        return c1708a != null && c1708a.m10160u1();
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f7764r = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f7753g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f7753g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i10) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10050D1(z10);
        }
    }

    public void setCheckableResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10053E1(i10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        C1708a c1708a = this.f7751e;
        if (c1708a == null) {
            this.f7757k = z10;
        } else if (c1708a.m10160u1()) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10056F1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10059G1(i10);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10062H1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10065I1(i10);
        }
    }

    public void setCheckedIconVisible(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10068J1(i10);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10074L1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10077M1(i10);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10080N1(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10083O1(i10);
        }
    }

    public void setChipDrawable(C1708a c1708a) {
        C1708a c1708a2 = this.f7751e;
        if (c1708a2 != c1708a) {
            m10017x(c1708a2);
            this.f7751e = c1708a;
            c1708a.m10060G2(false);
            m10004k(this.f7751e);
            m10006m(this.f7763q);
        }
    }

    public void setChipEndPadding(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10086P1(f10);
        }
    }

    public void setChipEndPaddingResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10089Q1(i10);
        }
    }

    public void setChipIcon(Drawable drawable) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10092R1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10095S1(i10);
        }
    }

    public void setChipIconSize(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10098T1(f10);
        }
    }

    public void setChipIconSizeResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10101U1(i10);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10104V1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10107W1(i10);
        }
    }

    public void setChipIconVisible(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10110X1(i10);
        }
    }

    public void setChipMinHeight(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10115Z1(f10);
        }
    }

    public void setChipMinHeightResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10117a2(i10);
        }
    }

    public void setChipStartPadding(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10119b2(f10);
        }
    }

    public void setChipStartPaddingResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10121c2(i10);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10123d2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10125e2(i10);
        }
    }

    public void setChipStrokeWidth(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10127f2(f10);
        }
    }

    public void setChipStrokeWidthResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10129g2(i10);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(Drawable drawable) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10133i2(drawable);
        }
        m10018y();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10135j2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10137k2(f10);
        }
    }

    public void setCloseIconEndPaddingResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10139l2(i10);
        }
    }

    public void setCloseIconResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10141m2(i10);
        }
        m10018y();
    }

    public void setCloseIconSize(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10143n2(f10);
        }
    }

    public void setCloseIconSizeResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10145o2(i10);
        }
    }

    public void setCloseIconStartPadding(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10147p2(f10);
        }
    }

    public void setCloseIconStartPaddingResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10150q2(i10);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10156s2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10158t2(i10);
        }
    }

    public void setCloseIconVisible(int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i12 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m64001a0(f10);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f7751e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10167w2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f7761o = z10;
        m10006m(this.f7763q);
    }

    @Override // android.widget.TextView
    public void setGravity(int i10) {
        if (i10 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(C13117h c13117h) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10169x2(c13117h);
        }
    }

    public void setHideMotionSpecResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10171y2(i10);
        }
    }

    public void setIconEndPadding(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10173z2(f10);
        }
    }

    public void setIconEndPaddingResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10043A2(i10);
        }
    }

    public void setIconStartPadding(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10045B2(f10);
        }
    }

    public void setIconStartPaddingResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10048C2(i10);
        }
    }

    @Override // com.google.android.material.internal.InterfaceC1776g
    public void setInternalOnCheckedChangeListener(InterfaceC1776g.a<Chip> aVar) {
        this.f7756j = aVar;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        if (this.f7751e == null) {
            return;
        }
        super.setLayoutDirection(i10);
    }

    @Override // android.widget.TextView
    public void setLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i10);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i10) {
        super.setMaxWidth(i10);
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10051D2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i10) {
        if (i10 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i10);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f7755i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f7754h = onClickListener;
        m10018y();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10054E2(colorStateList);
        }
        if (this.f7751e.m10155s1()) {
            return;
        }
        m9999A();
    }

    public void setRippleColorResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10057F2(i10);
            if (this.f7751e.m10155s1()) {
                return;
            }
            m9999A();
        }
    }

    @Override // p356i3.InterfaceC10435p
    public void setShapeAppearanceModel(C10432m c10432m) {
        this.f7751e.setShapeAppearanceModel(c10432m);
    }

    public void setShowMotionSpec(C13117h c13117h) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10063H2(c13117h);
        }
    }

    public void setShowMotionSpecResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10066I2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z10) {
        if (!z10) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z10);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        C1708a c1708a = this.f7751e;
        if (c1708a == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(c1708a.m10093R2() ? null : charSequence, bufferType);
        C1708a c1708a2 = this.f7751e;
        if (c1708a2 != null) {
            c1708a2.m10069J2(charSequence);
        }
    }

    public void setTextAppearance(C9650d c9650d) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10072K2(c9650d);
        }
        m10001C();
    }

    public void setTextAppearanceResource(int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10078M2(f10);
        }
    }

    public void setTextEndPaddingResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10081N2(i10);
        }
    }

    public void setTextStartPadding(float f10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10084O2(f10);
        }
    }

    public void setTextStartPaddingResource(int i10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10087P2(i10);
        }
    }

    /* renamed from: t */
    public boolean m10013t() {
        C1708a c1708a = this.f7751e;
        return c1708a != null && c1708a.m10166w1();
    }

    /* renamed from: u */
    public boolean m10014u() {
        boolean z10 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f7754h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z10 = true;
        }
        if (this.f7766t) {
            this.f7765s.m66206J(1, 1);
        }
        return z10;
    }

    /* renamed from: v */
    public final void m10015v() {
        if (this.f7752f != null) {
            this.f7752f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            m10019z();
        }
    }

    /* renamed from: w */
    public boolean m10016w() {
        return this.f7761o;
    }

    /* renamed from: x */
    public final void m10017x(C1708a c1708a) {
        if (c1708a != null) {
            c1708a.m10164v2(null);
        }
    }

    /* renamed from: y */
    public final void m10018y() {
        if (m10008o() && m10013t() && this.f7754h != null) {
            C9603h0.m59902p0(this, this.f7765s);
            this.f7766t = true;
        } else {
            C9603h0.m59902p0(this, null);
            this.f7766t = false;
        }
    }

    /* renamed from: z */
    public final void m10019z() {
        if (C9876b.f48499a) {
            m9999A();
            return;
        }
        this.f7751e.m10090Q2(true);
        C9603h0.m59910t0(this, getBackgroundDrawable());
        m10000B();
        m10007n();
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10161u2(z10);
        }
        m10018y();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f7748x;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f7767u = new Rect();
        this.f7768v = new RectF();
        this.f7769w = new C1699a();
        Context context2 = getContext();
        m10002D(attributeSet);
        C1708a c1708aM10036B0 = C1708a.m10036B0(context2, attributeSet, i10, i11);
        m10009p(context2, attributeSet, i10);
        setChipDrawable(c1708aM10036B0);
        c1708aM10036B0.m64001a0(C9603h0.m59913v(this));
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.Chip, i10, i11, new int[0]);
        boolean zHasValue = typedArrayM10770h.hasValue(R$styleable.Chip_shapeAppearance);
        typedArrayM10770h.recycle();
        this.f7765s = new C1702d(this);
        m10018y();
        if (!zHasValue) {
            m10010q();
        }
        setChecked(this.f7757k);
        setText(c1708aM10036B0.m10142n1());
        setEllipsize(c1708aM10036B0.m10130h1());
        m10001C();
        if (!this.f7751e.m10093R2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        m10000B();
        if (m10016w()) {
            setMinHeight(this.f7763q);
        }
        this.f7762p = C9603h0.m59832A(this);
        super.setOnCheckedChangeListener(new C1700b());
    }

    public void setCheckedIconVisible(boolean z10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10071K1(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10113Y1(z10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10075L2(i10);
        }
        m10001C();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        C1708a c1708a = this.f7751e;
        if (c1708a != null) {
            c1708a.m10075L2(i10);
        }
        m10001C();
    }
}
