package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.C0524f;
import androidx.appcompat.widget.C0532j;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.C1760a;
import com.google.android.material.internal.C1773d;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;
import p004a3.C0020b;
import p004a3.InterfaceC0019a;
import p027b3.C1106d;
import p243e0.C9373h;
import p273f0.C9603h0;
import p276f3.C9649c;
import p325h3.InterfaceC10090b;
import p356i3.C10432m;
import p356i3.InterfaceC10435p;
import p416k3.C10981a;
import p666u2.C13117h;
import p666u2.InterfaceC13120k;
import p757x.C13669a;

/* loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements InterfaceC0019a, InterfaceC10435p, CoordinatorLayout.InterfaceC0591b {

    /* renamed from: r */
    public static final int f8104r = R$style.Widget_Design_FloatingActionButton;

    /* renamed from: b */
    public ColorStateList f8105b;

    /* renamed from: c */
    public PorterDuff.Mode f8106c;

    /* renamed from: d */
    public ColorStateList f8107d;

    /* renamed from: e */
    public PorterDuff.Mode f8108e;

    /* renamed from: f */
    public ColorStateList f8109f;

    /* renamed from: g */
    public int f8110g;

    /* renamed from: h */
    public int f8111h;

    /* renamed from: i */
    public int f8112i;

    /* renamed from: j */
    public int f8113j;

    /* renamed from: k */
    public int f8114k;

    /* renamed from: l */
    public boolean f8115l;

    /* renamed from: m */
    public final Rect f8116m;

    /* renamed from: n */
    public final Rect f8117n;

    /* renamed from: o */
    public final C0532j f8118o;

    /* renamed from: p */
    public final C0020b f8119p;

    /* renamed from: q */
    public C1760a f8120q;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: E */
        public /* bridge */ /* synthetic */ boolean mo3728b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.mo3728b(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: H */
        public /* bridge */ /* synthetic */ boolean mo3734h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.mo3734h(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: I */
        public /* bridge */ /* synthetic */ boolean mo3738l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            return super.mo3738l(coordinatorLayout, floatingActionButton, i10);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: g */
        public /* bridge */ /* synthetic */ void mo3733g(CoordinatorLayout.C0594e c0594e) {
            super.mo3733g(c0594e);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$a */
    public class C1756a implements C1760a.j {

        /* renamed from: a */
        public final /* synthetic */ AbstractC1757b f8124a;

        public C1756a(AbstractC1757b abstractC1757b) {
            this.f8124a = abstractC1757b;
        }

        @Override // com.google.android.material.floatingactionbutton.C1760a.j
        /* renamed from: a */
        public void mo10482a() {
            this.f8124a.mo9796b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.C1760a.j
        /* renamed from: b */
        public void mo10483b() {
            this.f8124a.mo9795a(FloatingActionButton.this);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$b */
    public static abstract class AbstractC1757b {
        /* renamed from: a */
        public void mo9795a(FloatingActionButton floatingActionButton) {
        }

        /* renamed from: b */
        public void mo9796b(FloatingActionButton floatingActionButton) {
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$c */
    public class C1758c implements InterfaceC10090b {
        public C1758c() {
        }

        @Override // p325h3.InterfaceC10090b
        /* renamed from: a */
        public void mo10484a(int i10, int i11, int i12, int i13) {
            FloatingActionButton.this.f8116m.set(i10, i11, i12, i13);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i10 + floatingActionButton.f8113j, i11 + FloatingActionButton.this.f8113j, i12 + FloatingActionButton.this.f8113j, i13 + FloatingActionButton.this.f8113j);
        }

        @Override // p325h3.InterfaceC10090b
        /* renamed from: b */
        public boolean mo10485b() {
            return FloatingActionButton.this.f8115l;
        }

        @Override // p325h3.InterfaceC10090b
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButton$d */
    public class C1759d<T extends FloatingActionButton> implements C1760a.i {

        /* renamed from: a */
        public final InterfaceC13120k<T> f8127a;

        public C1759d(InterfaceC13120k<T> interfaceC13120k) {
            this.f8127a = interfaceC13120k;
        }

        @Override // com.google.android.material.floatingactionbutton.C1760a.i
        /* renamed from: a */
        public void mo10486a() {
            this.f8127a.mo9791b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.C1760a.i
        /* renamed from: b */
        public void mo10487b() {
            this.f8127a.mo9790a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof C1759d) && ((C1759d) obj).f8127a.equals(this.f8127a);
        }

        public int hashCode() {
            return this.f8127a.hashCode();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private C1760a getImpl() {
        if (this.f8120q == null) {
            this.f8120q = m10461h();
        }
        return this.f8120q;
    }

    /* renamed from: r */
    public static int m10457r(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i10, size);
        }
        if (mode == 0) {
            return i10;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    @Override // p004a3.InterfaceC0019a
    /* renamed from: a */
    public boolean mo75a() {
        return this.f8119p.m78c();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo6575D(getDrawableState());
    }

    /* renamed from: e */
    public void m10458e(Animator.AnimatorListener animatorListener) {
        getImpl().m10515e(animatorListener);
    }

    /* renamed from: f */
    public void m10459f(Animator.AnimatorListener animatorListener) {
        getImpl().m10517f(animatorListener);
    }

    /* renamed from: g */
    public void m10460g(InterfaceC13120k<? extends FloatingActionButton> interfaceC13120k) {
        getImpl().m10519g(new C1759d(interfaceC13120k));
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f8105b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f8106c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.InterfaceC0591b
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().mo6584m();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().m10528p();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().m10530s();
    }

    public Drawable getContentBackground() {
        return getImpl().m10525l();
    }

    public int getCustomSize() {
        return this.f8112i;
    }

    public int getExpandedComponentIdHint() {
        return this.f8119p.m77b();
    }

    public C13117h getHideMotionSpec() {
        return getImpl().m10527o();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f8109f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f8109f;
    }

    public C10432m getShapeAppearanceModel() {
        return (C10432m) C9373h.m58745f(getImpl().m10531t());
    }

    public C13117h getShowMotionSpec() {
        return getImpl().m10532u();
    }

    public int getSize() {
        return this.f8111h;
    }

    public int getSizeDimension() {
        return m10464k(this.f8111h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f8107d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f8108e;
    }

    public boolean getUseCompatPadding() {
        return this.f8115l;
    }

    /* renamed from: h */
    public final C1760a m10461h() {
        return new C1106d(this, new C1758c());
    }

    @Deprecated
    /* renamed from: i */
    public boolean m10462i(Rect rect) {
        if (!C9603h0.m59864T(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        m10469p(rect);
        return true;
    }

    /* renamed from: j */
    public void m10463j(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        m10469p(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo6587z();
    }

    /* renamed from: k */
    public final int m10464k(int i10) {
        int i11 = this.f8112i;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        return i10 != -1 ? i10 != 1 ? resources.getDimensionPixelSize(R$dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R$dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? m10464k(1) : m10464k(0);
    }

    /* renamed from: l */
    public void m10465l(AbstractC1757b abstractC1757b) {
        m10466m(abstractC1757b, true);
    }

    /* renamed from: m */
    public void m10466m(AbstractC1757b abstractC1757b, boolean z10) {
        getImpl().m10533v(m10473u(abstractC1757b), z10);
    }

    /* renamed from: n */
    public boolean m10467n() {
        return getImpl().m10534x();
    }

    /* renamed from: o */
    public boolean m10468o() {
        return getImpl().m10535y();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m10492A();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m10493C();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        this.f8113j = (sizeDimension - this.f8114k) / 2;
        getImpl().m10516e0();
        int iMin = Math.min(m10457r(sizeDimension, i10), m10457r(sizeDimension, i11));
        Rect rect = this.f8116m;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.f8119p.m79d((Bundle) C9373h.m58745f(extendableSavedState.f8689d.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        extendableSavedState.f8689d.put("expandableWidgetHelper", this.f8119p.m80e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && m10462i(this.f8117n) && !this.f8117n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: p */
    public final void m10469p(Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.f8116m;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    /* renamed from: q */
    public final void m10470q() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f8107d;
        if (colorStateList == null) {
            C13669a.m82220a(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f8108e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(C0524f.m2969e(colorForState, mode));
    }

    /* renamed from: s */
    public void m10471s(AbstractC1757b abstractC1757b) {
        m10472t(abstractC1757b, true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f8105b != colorStateList) {
            this.f8105b = colorStateList;
            getImpl().m10498K(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f8106c != mode) {
            this.f8106c = mode;
            getImpl().m10499L(mode);
        }
    }

    public void setCompatElevation(float f10) {
        getImpl().m10500M(f10);
    }

    public void setCompatElevationResource(int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        getImpl().m10503P(f10);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        getImpl().m10507T(f10);
    }

    public void setCompatPressedTranslationZResource(int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i10 != this.f8112i) {
            this.f8112i = i10;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        getImpl().m10518f0(f10);
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().m10526n()) {
            getImpl().m10501N(z10);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i10) {
        this.f8119p.m81f(i10);
    }

    public void setHideMotionSpec(C13117h c13117h) {
        getImpl().m10502O(c13117h);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(C13117h.m78898d(getContext(), i10));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().m10514d0();
            if (this.f8107d != null) {
                m10470q();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        this.f8118o.m3043i(i10);
        m10470q();
    }

    public void setMaxImageSize(int i10) {
        this.f8114k = i10;
        getImpl().m10505R(i10);
    }

    public void setRippleColor(int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        super.setScaleX(f10);
        getImpl().m10496H();
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        super.setScaleY(f10);
        getImpl().m10496H();
    }

    public void setShadowPaddingEnabled(boolean z10) {
        getImpl().m10508V(z10);
    }

    @Override // p356i3.InterfaceC10435p
    public void setShapeAppearanceModel(C10432m c10432m) {
        getImpl().m10509W(c10432m);
    }

    public void setShowMotionSpec(C13117h c13117h) {
        getImpl().m10510X(c13117h);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(C13117h.m78898d(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f8112i = 0;
        if (i10 != this.f8111h) {
            this.f8111h = i10;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f8107d != colorStateList) {
            this.f8107d = colorStateList;
            m10470q();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f8108e != mode) {
            this.f8108e = mode;
            m10470q();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        super.setTranslationX(f10);
        getImpl().m10497I();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        super.setTranslationY(f10);
        getImpl().m10497I();
    }

    @Override // android.view.View
    public void setTranslationZ(float f10) {
        super.setTranslationZ(f10);
        getImpl().m10497I();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f8115l != z10) {
            this.f8115l = z10;
            getImpl().mo6574B();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    /* renamed from: t */
    public void m10472t(AbstractC1757b abstractC1757b, boolean z10) {
        getImpl().m10513b0(m10473u(abstractC1757b), z10);
    }

    /* renamed from: u */
    public final C1760a.j m10473u(AbstractC1757b abstractC1757b) {
        if (abstractC1757b == null) {
            return null;
        }
        return new C1756a(abstractC1757b);
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a */
        public Rect f8121a;

        /* renamed from: b */
        public AbstractC1757b f8122b;

        /* renamed from: c */
        public boolean f8123c;

        public BaseBehavior() {
            this.f8123c = true;
        }

        /* renamed from: F */
        private static boolean m10474F(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0594e) {
                return ((CoordinatorLayout.C0594e) layoutParams).m3761f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean mo3728b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f8116m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: G */
        public final void m10476G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f8116m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.C0594e c0594e = (CoordinatorLayout.C0594e) floatingActionButton.getLayoutParams();
            int i10 = 0;
            int i11 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) c0594e).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) c0594e).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) c0594e).bottomMargin) {
                i10 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) c0594e).topMargin) {
                i10 = -rect.top;
            }
            if (i10 != 0) {
                C9603h0.m59872a0(floatingActionButton, i10);
            }
            if (i11 != 0) {
                C9603h0.m59870Z(floatingActionButton, i11);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean mo3734h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m10480K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!m10474F(view)) {
                return false;
            }
            m10481L(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean mo3738l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            List<View> listM3718v = coordinatorLayout.m3718v(floatingActionButton);
            int size = listM3718v.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = listM3718v.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (m10474F(view) && m10481L(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (m10480K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.m3698M(floatingActionButton, i10);
            m10476G(coordinatorLayout, floatingActionButton);
            return true;
        }

        /* renamed from: J */
        public final boolean m10479J(View view, FloatingActionButton floatingActionButton) {
            return this.f8123c && ((CoordinatorLayout.C0594e) floatingActionButton.getLayoutParams()).m3760e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        /* renamed from: K */
        public final boolean m10480K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m10479J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f8121a == null) {
                this.f8121a = new Rect();
            }
            Rect rect = this.f8121a;
            C1773d.m10677a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m10466m(this.f8122b, false);
                return true;
            }
            floatingActionButton.m10472t(this.f8122b, false);
            return true;
        }

        /* renamed from: L */
        public final boolean m10481L(View view, FloatingActionButton floatingActionButton) {
            if (!m10479J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.C0594e) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.m10466m(this.f8122b, false);
                return true;
            }
            floatingActionButton.m10472t(this.f8122b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: g */
        public void mo3733g(CoordinatorLayout.C0594e c0594e) {
            if (c0594e.f3281h == 0) {
                c0594e.f3281h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.f8123c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f8109f != colorStateList) {
            this.f8109f = colorStateList;
            getImpl().mo6578U(this.f8109f);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        int i11 = f8104r;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f8116m = new Rect();
        this.f8117n = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.FloatingActionButton, i10, i11, new int[0]);
        this.f8105b = C9649c.m60265a(context2, typedArrayM10770h, R$styleable.FloatingActionButton_backgroundTint);
        this.f8106c = C1788s.m10789j(typedArrayM10770h.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.f8109f = C9649c.m60265a(context2, typedArrayM10770h, R$styleable.FloatingActionButton_rippleColor);
        this.f8111h = typedArrayM10770h.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.f8112i = typedArrayM10770h.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.f8110g = typedArrayM10770h.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayM10770h.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayM10770h.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayM10770h.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f8115l = typedArrayM10770h.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayM10770h.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0));
        C13117h c13117hM78897c = C13117h.m78897c(context2, typedArrayM10770h, R$styleable.FloatingActionButton_showMotionSpec);
        C13117h c13117hM78897c2 = C13117h.m78897c(context2, typedArrayM10770h, R$styleable.FloatingActionButton_hideMotionSpec);
        C10432m c10432mM64093m = C10432m.m64051g(context2, attributeSet, i10, i11, C10432m.f50312m).m64093m();
        boolean z10 = typedArrayM10770h.getBoolean(R$styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayM10770h.getBoolean(R$styleable.FloatingActionButton_android_enabled, true));
        typedArrayM10770h.recycle();
        C0532j c0532j = new C0532j(this);
        this.f8118o = c0532j;
        c0532j.m3041g(attributeSet, i10);
        this.f8119p = new C0020b(this);
        getImpl().m10509W(c10432mM64093m);
        getImpl().mo6586w(this.f8105b, this.f8106c, this.f8109f, this.f8110g);
        getImpl().m10506S(dimensionPixelSize);
        getImpl().m10500M(dimension);
        getImpl().m10503P(dimension2);
        getImpl().m10507T(dimension3);
        getImpl().m10510X(c13117hM78897c);
        getImpl().m10502O(c13117hM78897c2);
        getImpl().m10501N(z10);
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
