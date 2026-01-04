package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import p211d.C8968a;
import p356i3.C10428i;
import p356i3.C10432m;
import p356i3.InterfaceC10435p;
import p416k3.C10981a;
import p726w2.C13521a;

/* loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, InterfaceC10435p {

    /* renamed from: n */
    public static final int[] f7734n = {R.attr.state_checkable};

    /* renamed from: o */
    public static final int[] f7735o = {R.attr.state_checked};

    /* renamed from: p */
    public static final int[] f7736p = {R$attr.state_dragged};

    /* renamed from: q */
    public static final int f7737q = R$style.Widget_MaterialComponents_CardView;

    /* renamed from: j */
    public final C13521a f7738j;

    /* renamed from: k */
    public boolean f7739k;

    /* renamed from: l */
    public boolean f7740l;

    /* renamed from: m */
    public boolean f7741m;

    /* renamed from: com.google.android.material.card.MaterialCardView$a */
    public interface InterfaceC1698a {
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f7738j.m81359j().getBounds());
        return rectF;
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.f7738j.m81360k();
    }

    public ColorStateList getCardForegroundColor() {
        return this.f7738j.m81361l();
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f7738j.m81362m();
    }

    public int getCheckedIconGravity() {
        return this.f7738j.m81363n();
    }

    public int getCheckedIconMargin() {
        return this.f7738j.m81364o();
    }

    public int getCheckedIconSize() {
        return this.f7738j.m81365p();
    }

    public ColorStateList getCheckedIconTint() {
        return this.f7738j.m81366q();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f7738j.m81316A().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f7738j.m81316A().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f7738j.m81316A().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f7738j.m81316A().top;
    }

    public float getProgress() {
        return this.f7738j.m81370u();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f7738j.m81368s();
    }

    public ColorStateList getRippleColor() {
        return this.f7738j.m81371v();
    }

    public C10432m getShapeAppearanceModel() {
        return this.f7738j.m81372w();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f7738j.m81373x();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f7738j.m81374y();
    }

    public int getStrokeWidth() {
        return this.f7738j.m81375z();
    }

    /* renamed from: h */
    public final void m9986h() {
        this.f7738j.m81358i();
    }

    /* renamed from: i */
    public boolean m9987i() {
        C13521a c13521a = this.f7738j;
        return c13521a != null && c13521a.m81319D();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f7740l;
    }

    /* renamed from: j */
    public boolean m9988j() {
        return this.f7741m;
    }

    /* renamed from: k */
    public void m9989k(int i10, int i11, int i12, int i13) {
        super.m3213f(i10, i11, i12, i13);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10428i.m64044f(this, this.f7738j.m81359j());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 3);
        if (m9987i()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7734n);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7735o);
        }
        if (m9988j()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7736p);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(m9987i());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f7738j.m81323H(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f7739k) {
            if (!this.f7738j.m81318C()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f7738j.m81324I(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i10) {
        this.f7738j.m81325J(ColorStateList.valueOf(i10));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f10) {
        super.setCardElevation(f10);
        this.f7738j.m81349d0();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f7738j.m81326K(colorStateList);
    }

    public void setCheckable(boolean z10) {
        this.f7738j.m81327L(z10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f7740l != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f7738j.m81329N(drawable);
    }

    public void setCheckedIconGravity(int i10) {
        if (this.f7738j.m81363n() != i10) {
            this.f7738j.m81330O(i10);
        }
    }

    public void setCheckedIconMargin(int i10) {
        this.f7738j.m81331P(i10);
    }

    public void setCheckedIconMarginResource(int i10) {
        if (i10 != -1) {
            this.f7738j.m81331P(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconResource(int i10) {
        this.f7738j.m81329N(C8968a.m56743b(getContext(), i10));
    }

    public void setCheckedIconSize(int i10) {
        this.f7738j.m81332Q(i10);
    }

    public void setCheckedIconSizeResource(int i10) {
        if (i10 != 0) {
            this.f7738j.m81332Q(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f7738j.m81333R(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
        C13521a c13521a = this.f7738j;
        if (c13521a != null) {
            c13521a.m81345b0();
        }
    }

    public void setDragged(boolean z10) {
        if (this.f7741m != z10) {
            this.f7741m = z10;
            refreshDrawableState();
            m9986h();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f10) {
        super.setMaxCardElevation(f10);
        this.f7738j.m81353f0();
    }

    public void setOnCheckedChangeListener(InterfaceC1698a interfaceC1698a) {
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        this.f7738j.m81353f0();
        this.f7738j.m81347c0();
    }

    public void setProgress(float f10) {
        this.f7738j.m81335T(f10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f10) {
        super.setRadius(f10);
        this.f7738j.m81334S(f10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f7738j.m81336U(colorStateList);
    }

    public void setRippleColorResource(int i10) {
        this.f7738j.m81336U(C8968a.m56742a(getContext(), i10));
    }

    @Override // p356i3.InterfaceC10435p
    public void setShapeAppearanceModel(C10432m c10432m) {
        setClipToOutline(c10432m.m64065u(getBoundsAsRectF()));
        this.f7738j.m81337V(c10432m);
    }

    public void setStrokeColor(int i10) {
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeWidth(int i10) {
        this.f7738j.m81339X(i10);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        this.f7738j.m81353f0();
        this.f7738j.m81347c0();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (m9987i() && isEnabled()) {
            this.f7740l = !this.f7740l;
            refreshDrawableState();
            m9986h();
            this.f7738j.m81328M(this.f7740l);
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f7738j.m81325J(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f7738j.m81338W(colorStateList);
        invalidate();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f7737q;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f7740l = false;
        this.f7741m = false;
        this.f7739k = true;
        TypedArray typedArrayM10770h = C1784o.m10770h(getContext(), attributeSet, R$styleable.MaterialCardView, i10, i11, new int[0]);
        C13521a c13521a = new C13521a(this, attributeSet, i10, i11);
        this.f7738j = c13521a;
        c13521a.m81325J(super.getCardBackgroundColor());
        c13521a.m81340Y(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        c13521a.m81322G(typedArrayM10770h);
        typedArrayM10770h.recycle();
    }
}
