package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.C0523e0;
import androidx.core.content.ContextCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1772c;
import com.google.android.material.internal.C1777h;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import p211d.C8968a;
import p273f0.C9603h0;
import p273f0.C9614n;
import p273f0.C9625s0;
import p276f3.C9649c;
import p307g3.C9876b;
import p356i3.C10427h;
import p356i3.C10428i;
import p356i3.C10432m;
import p356i3.C10433n;
import p416k3.C10981a;

/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* renamed from: r */
    public static final int[] f8499r = {R.attr.state_checked};

    /* renamed from: s */
    public static final int[] f8500s = {-16842910};

    /* renamed from: t */
    public static final int f8501t = R$style.Widget_Design_NavigationView;

    /* renamed from: f */
    public final NavigationMenu f8502f;

    /* renamed from: g */
    public final C1777h f8503g;

    /* renamed from: h */
    public final int f8504h;

    /* renamed from: i */
    public final int[] f8505i;

    /* renamed from: j */
    public MenuInflater f8506j;

    /* renamed from: k */
    public ViewTreeObserver.OnGlobalLayoutListener f8507k;

    /* renamed from: l */
    public boolean f8508l;

    /* renamed from: m */
    public boolean f8509m;

    /* renamed from: n */
    public int f8510n;

    /* renamed from: o */
    public int f8511o;

    /* renamed from: p */
    public Path f8512p;

    /* renamed from: q */
    public final RectF f8513q;

    /* renamed from: com.google.android.material.navigation.NavigationView$a */
    public class C1801a implements MenuBuilder.InterfaceC0398a {
        public C1801a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
        /* renamed from: a */
        public boolean mo2102a(MenuBuilder menuBuilder, MenuItem menuItem) {
            NavigationView.this.getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.InterfaceC0398a
        /* renamed from: b */
        public void mo2105b(MenuBuilder menuBuilder) {
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationView$b */
    public class ViewTreeObserverOnGlobalLayoutListenerC1802b implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC1802b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f8505i);
            boolean z10 = NavigationView.this.f8505i[1] == 0;
            NavigationView.this.f8503g.m10691C(z10);
            NavigationView navigationView2 = NavigationView.this;
            navigationView2.setDrawTopInsetForeground(z10 && navigationView2.m10852k());
            Activity activityM10676a = C1772c.m10676a(NavigationView.this.getContext());
            if (activityM10676a != null) {
                boolean z11 = activityM10676a.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight();
                boolean z12 = Color.alpha(activityM10676a.getWindow().getNavigationBarColor()) != 0;
                NavigationView navigationView3 = NavigationView.this;
                navigationView3.setDrawBottomInsetForeground(z11 && z12 && navigationView3.m10851j());
            }
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationView$c */
    public interface InterfaceC1803c {
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.f8506j == null) {
            this.f8506j = new SupportMenuInflater(getContext());
        }
        return this.f8506j;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    /* renamed from: a */
    public void mo10565a(C9625s0 c9625s0) {
        this.f8503g.m10713m(c9625s0);
    }

    /* renamed from: d */
    public final ColorStateList m10845d(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListM56742a = C8968a.m56742a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = colorStateListM56742a.getDefaultColor();
        int[] iArr = f8500s;
        return new ColorStateList(new int[][]{iArr, f8499r, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListM56742a.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f8512p == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.f8512p);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    /* renamed from: e */
    public final Drawable m10846e(C0523e0 c0523e0) {
        return m10847f(c0523e0, C9649c.m60266b(getContext(), c0523e0, R$styleable.NavigationView_itemShapeFillColor));
    }

    /* renamed from: f */
    public final Drawable m10847f(C0523e0 c0523e0, ColorStateList colorStateList) {
        C10427h c10427h = new C10427h(C10432m.m64046b(getContext(), c0523e0.m2960n(R$styleable.NavigationView_itemShapeAppearance, 0), c0523e0.m2960n(R$styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m64093m());
        c10427h.m64002b0(colorStateList);
        return new InsetDrawable((Drawable) c10427h, c0523e0.m2952f(R$styleable.NavigationView_itemShapeInsetStart, 0), c0523e0.m2952f(R$styleable.NavigationView_itemShapeInsetTop, 0), c0523e0.m2952f(R$styleable.NavigationView_itemShapeInsetEnd, 0), c0523e0.m2952f(R$styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    /* renamed from: g */
    public final boolean m10848g(C0523e0 c0523e0) {
        return c0523e0.m2965s(R$styleable.NavigationView_itemShapeAppearance) || c0523e0.m2965s(R$styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    public MenuItem getCheckedItem() {
        return this.f8503g.m10714n();
    }

    public int getDividerInsetEnd() {
        return this.f8503g.m10715o();
    }

    public int getDividerInsetStart() {
        return this.f8503g.m10716p();
    }

    public int getHeaderCount() {
        return this.f8503g.m10717q();
    }

    public Drawable getItemBackground() {
        return this.f8503g.m10718r();
    }

    public int getItemHorizontalPadding() {
        return this.f8503g.m10719s();
    }

    public int getItemIconPadding() {
        return this.f8503g.m10720t();
    }

    public ColorStateList getItemIconTintList() {
        return this.f8503g.m10723w();
    }

    public int getItemMaxLines() {
        return this.f8503g.m10721u();
    }

    public ColorStateList getItemTextColor() {
        return this.f8503g.m10722v();
    }

    public int getItemVerticalPadding() {
        return this.f8503g.m10724x();
    }

    public Menu getMenu() {
        return this.f8502f;
    }

    public int getSubheaderInsetEnd() {
        return this.f8503g.m10726z();
    }

    public int getSubheaderInsetStart() {
        return this.f8503g.m10689A();
    }

    /* renamed from: h */
    public View m10849h(int i10) {
        return this.f8503g.m10690B(i10);
    }

    /* renamed from: i */
    public void m10850i(int i10) {
        this.f8503g.m10710V(true);
        getMenuInflater().inflate(i10, this.f8502f);
        this.f8503g.m10710V(false);
        this.f8503g.mo2414b(false);
    }

    /* renamed from: j */
    public boolean m10851j() {
        return this.f8509m;
    }

    /* renamed from: k */
    public boolean m10852k() {
        return this.f8508l;
    }

    /* renamed from: l */
    public final void m10853l(int i10, int i11) {
        if (!(getParent() instanceof DrawerLayout) || this.f8511o <= 0 || !(getBackground() instanceof C10427h)) {
            this.f8512p = null;
            this.f8513q.setEmpty();
            return;
        }
        C10427h c10427h = (C10427h) getBackground();
        C10432m.b bVarM64066v = c10427h.m63980E().m64066v();
        if (C9614n.m60102b(this.f8510n, C9603h0.m59832A(this)) == 3) {
            bVarM64066v.m64091I(this.f8511o);
            bVarM64066v.m64105z(this.f8511o);
        } else {
            bVarM64066v.m64087E(this.f8511o);
            bVarM64066v.m64101v(this.f8511o);
        }
        c10427h.setShapeAppearanceModel(bVarM64066v.m64093m());
        if (this.f8512p == null) {
            this.f8512p = new Path();
        }
        this.f8512p.reset();
        this.f8513q.set(0.0f, 0.0f, i10, i11);
        C10433n.m64106k().m64110d(c10427h.m63980E(), c10427h.m64034y(), this.f8513q, this.f8512p);
        invalidate();
    }

    /* renamed from: m */
    public final void m10854m() {
        this.f8507k = new ViewTreeObserverOnGlobalLayoutListenerC1802b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f8507k);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10428i.m64043e(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f8507k);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), this.f8504h), 1073741824);
        } else if (mode == 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(this.f8504h, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8502f.m2354S(savedState.f8514d);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f8514d = bundle;
        this.f8502f.m2356U(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        m10853l(i10, i11);
    }

    public void setBottomInsetScrimEnabled(boolean z10) {
        this.f8509m = z10;
    }

    public void setCheckedItem(int i10) {
        MenuItem menuItemFindItem = this.f8502f.findItem(i10);
        if (menuItemFindItem != null) {
            this.f8503g.m10692D((C0411h) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i10) {
        this.f8503g.m10693E(i10);
    }

    public void setDividerInsetStart(int i10) {
        this.f8503g.m10694F(i10);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        C10428i.m64042d(this, f10);
    }

    public void setItemBackground(Drawable drawable) {
        this.f8503g.m10696H(drawable);
    }

    public void setItemBackgroundResource(int i10) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i10));
    }

    public void setItemHorizontalPadding(int i10) {
        this.f8503g.m10698J(i10);
    }

    public void setItemHorizontalPaddingResource(int i10) {
        this.f8503g.m10698J(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconPadding(int i10) {
        this.f8503g.m10699K(i10);
    }

    public void setItemIconPaddingResource(int i10) {
        this.f8503g.m10699K(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconSize(int i10) {
        this.f8503g.m10700L(i10);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f8503g.m10701M(colorStateList);
    }

    public void setItemMaxLines(int i10) {
        this.f8503g.m10702N(i10);
    }

    public void setItemTextAppearance(int i10) {
        this.f8503g.m10703O(i10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f8503g.m10704P(colorStateList);
    }

    public void setItemVerticalPadding(int i10) {
        this.f8503g.m10705Q(i10);
    }

    public void setItemVerticalPaddingResource(int i10) {
        this.f8503g.m10705Q(getResources().getDimensionPixelSize(i10));
    }

    public void setNavigationItemSelectedListener(InterfaceC1803c interfaceC1803c) {
    }

    @Override // android.view.View
    public void setOverScrollMode(int i10) {
        super.setOverScrollMode(i10);
        C1777h c1777h = this.f8503g;
        if (c1777h != null) {
            c1777h.m10706R(i10);
        }
    }

    public void setSubheaderInsetEnd(int i10) {
        this.f8503g.m10708T(i10);
    }

    public void setSubheaderInsetStart(int i10) {
        this.f8503g.m10708T(i10);
    }

    public void setTopInsetScrimEnabled(boolean z10) {
        this.f8508l = z10;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1800a();

        /* renamed from: d */
        public Bundle f8514d;

        /* renamed from: com.google.android.material.navigation.NavigationView$SavedState$a */
        public class C1800a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f8514d = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.f8514d);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R$attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(Context context, AttributeSet attributeSet, int i10) {
        ColorStateList colorStateListM10845d;
        int i11 = f8501t;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        C1777h c1777h = new C1777h();
        this.f8503g = c1777h;
        this.f8505i = new int[2];
        this.f8508l = true;
        this.f8509m = true;
        this.f8510n = 0;
        this.f8511o = 0;
        this.f8513q = new RectF();
        Context context2 = getContext();
        NavigationMenu navigationMenu = new NavigationMenu(context2);
        this.f8502f = navigationMenu;
        C0523e0 c0523e0M10771i = C1784o.m10771i(context2, attributeSet, R$styleable.NavigationView, i10, i11, new int[0]);
        int i12 = R$styleable.NavigationView_android_background;
        if (c0523e0M10771i.m2965s(i12)) {
            C9603h0.m59910t0(this, c0523e0M10771i.m2953g(i12));
        }
        this.f8511o = c0523e0M10771i.m2952f(R$styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.f8510n = c0523e0M10771i.m2957k(R$styleable.NavigationView_android_layout_gravity, 0);
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            C10432m c10432mM64093m = C10432m.m64049e(context2, attributeSet, i10, i11).m64093m();
            Drawable background = getBackground();
            C10427h c10427h = new C10427h(c10432mM64093m);
            if (background instanceof ColorDrawable) {
                c10427h.m64002b0(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            c10427h.m63992Q(context2);
            C9603h0.m59910t0(this, c10427h);
        }
        if (c0523e0M10771i.m2965s(R$styleable.NavigationView_elevation)) {
            setElevation(c0523e0M10771i.m2952f(r2, 0));
        }
        setFitsSystemWindows(c0523e0M10771i.m2947a(R$styleable.NavigationView_android_fitsSystemWindows, false));
        this.f8504h = c0523e0M10771i.m2952f(R$styleable.NavigationView_android_maxWidth, 0);
        int i13 = R$styleable.NavigationView_subheaderColor;
        ColorStateList colorStateListM2949c = c0523e0M10771i.m2965s(i13) ? c0523e0M10771i.m2949c(i13) : null;
        int i14 = R$styleable.NavigationView_subheaderTextAppearance;
        int iM2960n = c0523e0M10771i.m2965s(i14) ? c0523e0M10771i.m2960n(i14, 0) : 0;
        if (iM2960n == 0 && colorStateListM2949c == null) {
            colorStateListM2949c = m10845d(R.attr.textColorSecondary);
        }
        int i15 = R$styleable.NavigationView_itemIconTint;
        if (c0523e0M10771i.m2965s(i15)) {
            colorStateListM10845d = c0523e0M10771i.m2949c(i15);
        } else {
            colorStateListM10845d = m10845d(R.attr.textColorSecondary);
        }
        int i16 = R$styleable.NavigationView_itemTextAppearance;
        int iM2960n2 = c0523e0M10771i.m2965s(i16) ? c0523e0M10771i.m2960n(i16, 0) : 0;
        int i17 = R$styleable.NavigationView_itemIconSize;
        if (c0523e0M10771i.m2965s(i17)) {
            setItemIconSize(c0523e0M10771i.m2952f(i17, 0));
        }
        int i18 = R$styleable.NavigationView_itemTextColor;
        ColorStateList colorStateListM2949c2 = c0523e0M10771i.m2965s(i18) ? c0523e0M10771i.m2949c(i18) : null;
        if (iM2960n2 == 0 && colorStateListM2949c2 == null) {
            colorStateListM2949c2 = m10845d(R.attr.textColorPrimary);
        }
        Drawable drawableM2953g = c0523e0M10771i.m2953g(R$styleable.NavigationView_itemBackground);
        if (drawableM2953g == null && m10848g(c0523e0M10771i)) {
            drawableM2953g = m10846e(c0523e0M10771i);
            ColorStateList colorStateListM60266b = C9649c.m60266b(context2, c0523e0M10771i, R$styleable.NavigationView_itemRippleColor);
            if (colorStateListM60266b != null) {
                c1777h.m10697I(new RippleDrawable(C9876b.m61325d(colorStateListM60266b), null, m10847f(c0523e0M10771i, null)));
            }
        }
        int i19 = R$styleable.NavigationView_itemHorizontalPadding;
        if (c0523e0M10771i.m2965s(i19)) {
            setItemHorizontalPadding(c0523e0M10771i.m2952f(i19, 0));
        }
        int i20 = R$styleable.NavigationView_itemVerticalPadding;
        if (c0523e0M10771i.m2965s(i20)) {
            setItemVerticalPadding(c0523e0M10771i.m2952f(i20, 0));
        }
        setDividerInsetStart(c0523e0M10771i.m2952f(R$styleable.NavigationView_dividerInsetStart, 0));
        setDividerInsetEnd(c0523e0M10771i.m2952f(R$styleable.NavigationView_dividerInsetEnd, 0));
        setSubheaderInsetStart(c0523e0M10771i.m2952f(R$styleable.NavigationView_subheaderInsetStart, 0));
        setSubheaderInsetEnd(c0523e0M10771i.m2952f(R$styleable.NavigationView_subheaderInsetEnd, 0));
        setTopInsetScrimEnabled(c0523e0M10771i.m2947a(R$styleable.NavigationView_topInsetScrimEnabled, this.f8508l));
        setBottomInsetScrimEnabled(c0523e0M10771i.m2947a(R$styleable.NavigationView_bottomInsetScrimEnabled, this.f8509m));
        int iM2952f = c0523e0M10771i.m2952f(R$styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(c0523e0M10771i.m2957k(R$styleable.NavigationView_itemMaxLines, 1));
        navigationMenu.mo2357V(new C1801a());
        c1777h.m10695G(1);
        c1777h.mo2418g(context2, navigationMenu);
        if (iM2960n != 0) {
            c1777h.m10709U(iM2960n);
        }
        c1777h.m10707S(colorStateListM2949c);
        c1777h.m10701M(colorStateListM10845d);
        c1777h.m10706R(getOverScrollMode());
        if (iM2960n2 != 0) {
            c1777h.m10703O(iM2960n2);
        }
        c1777h.m10704P(colorStateListM2949c2);
        c1777h.m10696H(drawableM2953g);
        c1777h.m10699K(iM2952f);
        navigationMenu.m2364b(c1777h);
        addView((View) c1777h.m10725y(this));
        int i21 = R$styleable.NavigationView_menu;
        if (c0523e0M10771i.m2965s(i21)) {
            m10850i(c0523e0M10771i.m2960n(i21, 0));
        }
        int i22 = R$styleable.NavigationView_headerLayout;
        if (c0523e0M10771i.m2965s(i22)) {
            m10849h(c0523e0M10771i.m2960n(i22, 0));
        }
        c0523e0M10771i.m2966w();
        m10854m();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f8502f.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f8503g.m10692D((C0411h) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
