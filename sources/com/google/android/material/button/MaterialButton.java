package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.C0669j;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p211d.C8968a;
import p273f0.C9603h0;
import p276f3.C9649c;
import p356i3.C10428i;
import p356i3.C10432m;
import p356i3.InterfaceC10435p;
import p416k3.C10981a;
import p757x.C13669a;

/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, InterfaceC10435p {

    /* renamed from: q */
    public static final int[] f7676q = {R.attr.state_checkable};

    /* renamed from: r */
    public static final int[] f7677r = {R.attr.state_checked};

    /* renamed from: s */
    public static final int f7678s = R$style.Widget_MaterialComponents_Button;

    /* renamed from: d */
    public final C1697a f7679d;

    /* renamed from: e */
    public final LinkedHashSet<InterfaceC1690a> f7680e;

    /* renamed from: f */
    public InterfaceC1691b f7681f;

    /* renamed from: g */
    public PorterDuff.Mode f7682g;

    /* renamed from: h */
    public ColorStateList f7683h;

    /* renamed from: i */
    public Drawable f7684i;

    /* renamed from: j */
    public int f7685j;

    /* renamed from: k */
    public int f7686k;

    /* renamed from: l */
    public int f7687l;

    /* renamed from: m */
    public int f7688m;

    /* renamed from: n */
    public boolean f7689n;

    /* renamed from: o */
    public boolean f7690o;

    /* renamed from: p */
    public int f7691p;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1689a();

        /* renamed from: d */
        public boolean f7692d;

        /* renamed from: com.google.android.material.button.MaterialButton$SavedState$a */
        public class C1689a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* renamed from: a */
        public final void m9917a(Parcel parcel) {
            this.f7692d = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f7692d ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            m9917a(parcel);
        }
    }

    /* renamed from: com.google.android.material.button.MaterialButton$a */
    public interface InterfaceC1690a {
        /* renamed from: a */
        void m9921a(MaterialButton materialButton, boolean z10);
    }

    /* renamed from: com.google.android.material.button.MaterialButton$b */
    public interface InterfaceC1691b {
        /* renamed from: a */
        void mo9922a(MaterialButton materialButton, boolean z10);
    }

    public MaterialButton(Context context) {
        this(context, null);
    }

    private String getA11yClassName() {
        return (m9908a() ? CompoundButton.class : Button.class).getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        return Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
    }

    /* renamed from: a */
    public boolean m9908a() {
        C1697a c1697a = this.f7679d;
        return c1697a != null && c1697a.m9974p();
    }

    /* renamed from: b */
    public final boolean m9909b() {
        int i10 = this.f7691p;
        return i10 == 3 || i10 == 4;
    }

    /* renamed from: c */
    public final boolean m9910c() {
        int i10 = this.f7691p;
        return i10 == 1 || i10 == 2;
    }

    /* renamed from: d */
    public final boolean m9911d() {
        int i10 = this.f7691p;
        return i10 == 16 || i10 == 32;
    }

    /* renamed from: e */
    public final boolean m9912e() {
        return C9603h0.m59832A(this) == 1;
    }

    /* renamed from: f */
    public final boolean m9913f() {
        C1697a c1697a = this.f7679d;
        return (c1697a == null || c1697a.m9973o()) ? false : true;
    }

    /* renamed from: g */
    public final void m9914g() {
        if (m9910c()) {
            C0669j.m4075i(this, this.f7684i, null, null, null);
        } else if (m9909b()) {
            C0669j.m4075i(this, null, null, this.f7684i, null);
        } else if (m9911d()) {
            C0669j.m4075i(this, null, this.f7684i, null, null);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (m9913f()) {
            return this.f7679d.m9960b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f7684i;
    }

    public int getIconGravity() {
        return this.f7691p;
    }

    public int getIconPadding() {
        return this.f7688m;
    }

    public int getIconSize() {
        return this.f7685j;
    }

    public ColorStateList getIconTint() {
        return this.f7683h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f7682g;
    }

    public int getInsetBottom() {
        return this.f7679d.m9961c();
    }

    public int getInsetTop() {
        return this.f7679d.m9962d();
    }

    public ColorStateList getRippleColor() {
        if (m9913f()) {
            return this.f7679d.m9966h();
        }
        return null;
    }

    public C10432m getShapeAppearanceModel() {
        if (m9913f()) {
            return this.f7679d.m9967i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (m9913f()) {
            return this.f7679d.m9968j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (m9913f()) {
            return this.f7679d.m9969k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return m9913f() ? this.f7679d.m9970l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return m9913f() ? this.f7679d.m9971m() : super.getSupportBackgroundTintMode();
    }

    /* renamed from: h */
    public final void m9915h(boolean z10) {
        Drawable drawable = this.f7684i;
        if (drawable != null) {
            Drawable drawableMutate = C13669a.m82231l(drawable).mutate();
            this.f7684i = drawableMutate;
            C13669a.m82228i(drawableMutate, this.f7683h);
            PorterDuff.Mode mode = this.f7682g;
            if (mode != null) {
                C13669a.m82229j(this.f7684i, mode);
            }
            int intrinsicWidth = this.f7685j;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f7684i.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f7685j;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f7684i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f7684i;
            int i10 = this.f7686k;
            int i11 = this.f7687l;
            drawable2.setBounds(i10, i11, intrinsicWidth + i10, intrinsicHeight + i11);
            this.f7684i.setVisible(true, z10);
        }
        if (z10) {
            m9914g();
            return;
        }
        Drawable[] drawableArrM4067a = C0669j.m4067a(this);
        Drawable drawable3 = drawableArrM4067a[0];
        Drawable drawable4 = drawableArrM4067a[1];
        Drawable drawable5 = drawableArrM4067a[2];
        if ((!m9910c() || drawable3 == this.f7684i) && ((!m9909b() || drawable5 == this.f7684i) && (!m9911d() || drawable4 == this.f7684i))) {
            return;
        }
        m9914g();
    }

    /* renamed from: i */
    public final void m9916i(int i10, int i11) {
        if (this.f7684i == null || getLayout() == null) {
            return;
        }
        if (!m9910c() && !m9909b()) {
            if (m9911d()) {
                this.f7686k = 0;
                if (this.f7691p == 16) {
                    this.f7687l = 0;
                    m9915h(false);
                    return;
                }
                int intrinsicHeight = this.f7685j;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f7684i.getIntrinsicHeight();
                }
                int textHeight = (((((i11 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f7688m) - getPaddingBottom()) / 2;
                if (this.f7687l != textHeight) {
                    this.f7687l = textHeight;
                    m9915h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f7687l = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i12 = this.f7691p;
        if (i12 == 1 || i12 == 3 || ((i12 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i12 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f7686k = 0;
            m9915h(false);
            return;
        }
        int intrinsicWidth = this.f7685j;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f7684i.getIntrinsicWidth();
        }
        int textWidth = ((((i10 - getTextWidth()) - C9603h0.m59840E(this)) - intrinsicWidth) - this.f7688m) - C9603h0.m59842F(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textWidth /= 2;
        }
        if (m9912e() != (this.f7691p == 4)) {
            textWidth = -textWidth;
        }
        if (this.f7686k != textWidth) {
            this.f7686k = textWidth;
            m9915h(false);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f7689n;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (m9913f()) {
            C10428i.m64044f(this, this.f7679d.m9964f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (m9908a()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7676q);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f7677r);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(m9908a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        m9916i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f7692d);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7692d = this.f7689n;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        m9916i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f7684i != null) {
            if (this.f7684i.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (m9913f()) {
            this.f7679d.m9976r(i10);
        } else {
            super.setBackgroundColor(i10);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!m9913f()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f7679d.m9977s();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i10) {
        setBackgroundDrawable(i10 != 0 ? C8968a.m56743b(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (m9913f()) {
            this.f7679d.m9978t(z10);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (m9908a() && isEnabled() && this.f7689n != z10) {
            this.f7689n = z10;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).m9936m(this, this.f7689n);
            }
            if (this.f7690o) {
                return;
            }
            this.f7690o = true;
            Iterator<InterfaceC1690a> it = this.f7680e.iterator();
            while (it.hasNext()) {
                it.next().m9921a(this, this.f7689n);
            }
            this.f7690o = false;
        }
    }

    public void setCornerRadius(int i10) {
        if (m9913f()) {
            this.f7679d.m9979u(i10);
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (m9913f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        if (m9913f()) {
            this.f7679d.m9964f().m64001a0(f10);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f7684i != drawable) {
            this.f7684i = drawable;
            m9915h(true);
            m9916i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.f7691p != i10) {
            this.f7691p = i10;
            m9916i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i10) {
        if (this.f7688m != i10) {
            this.f7688m = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        setIcon(i10 != 0 ? C8968a.m56743b(getContext(), i10) : null);
    }

    public void setIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f7685j != i10) {
            this.f7685j = i10;
            m9915h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f7683h != colorStateList) {
            this.f7683h = colorStateList;
            m9915h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f7682g != mode) {
            this.f7682g = mode;
            m9915h(false);
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(C8968a.m56742a(getContext(), i10));
    }

    public void setInsetBottom(int i10) {
        this.f7679d.m9980v(i10);
    }

    public void setInsetTop(int i10) {
        this.f7679d.m9981w(i10);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(InterfaceC1691b interfaceC1691b) {
        this.f7681f = interfaceC1691b;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        InterfaceC1691b interfaceC1691b = this.f7681f;
        if (interfaceC1691b != null) {
            interfaceC1691b.mo9922a(this, z10);
        }
        super.setPressed(z10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (m9913f()) {
            this.f7679d.m9982x(colorStateList);
        }
    }

    public void setRippleColorResource(int i10) {
        if (m9913f()) {
            setRippleColor(C8968a.m56742a(getContext(), i10));
        }
    }

    @Override // p356i3.InterfaceC10435p
    public void setShapeAppearanceModel(C10432m c10432m) {
        if (!m9913f()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f7679d.m9983y(c10432m);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (m9913f()) {
            this.f7679d.m9984z(z10);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (m9913f()) {
            this.f7679d.m9950A(colorStateList);
        }
    }

    public void setStrokeColorResource(int i10) {
        if (m9913f()) {
            setStrokeColor(C8968a.m56742a(getContext(), i10));
        }
    }

    public void setStrokeWidth(int i10) {
        if (m9913f()) {
            this.f7679d.m9951B(i10);
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (m9913f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (m9913f()) {
            this.f7679d.m9952C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (m9913f()) {
            this.f7679d.m9953D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i10) {
        super.setTextAlignment(i10);
        m9916i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f7689n);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f7678s;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f7680e = new LinkedHashSet<>();
        this.f7689n = false;
        this.f7690o = false;
        Context context2 = getContext();
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.MaterialButton, i10, i11, new int[0]);
        this.f7688m = typedArrayM10770h.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.f7682g = C1788s.m10789j(typedArrayM10770h.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f7683h = C9649c.m60265a(getContext(), typedArrayM10770h, R$styleable.MaterialButton_iconTint);
        this.f7684i = C9649c.m60269e(getContext(), typedArrayM10770h, R$styleable.MaterialButton_icon);
        this.f7691p = typedArrayM10770h.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.f7685j = typedArrayM10770h.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        C1697a c1697a = new C1697a(this, C10432m.m64049e(context2, attributeSet, i10, i11).m64093m());
        this.f7679d = c1697a;
        c1697a.m9975q(typedArrayM10770h);
        typedArrayM10770h.recycle();
        setCompoundDrawablePadding(this.f7688m);
        m9915h(this.f7684i != null);
    }
}
