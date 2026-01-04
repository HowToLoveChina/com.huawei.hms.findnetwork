package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.C0523e0;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import com.google.android.material.navigation.NavigationBarView;
import p273f0.C9603h0;
import p273f0.C9625s0;

/* loaded from: classes.dex */
public class NavigationRailView extends NavigationBarView {

    /* renamed from: f */
    public final int f8521f;

    /* renamed from: g */
    public View f8522g;

    /* renamed from: h */
    public Boolean f8523h;

    /* renamed from: i */
    public Boolean f8524i;

    /* renamed from: com.google.android.material.navigationrail.NavigationRailView$a */
    public class C1805a implements C1788s.e {
        public C1805a() {
        }

        @Override // com.google.android.material.internal.C1788s.e
        /* renamed from: a */
        public C9625s0 mo9794a(View view, C9625s0 c9625s0, C1788s.f fVar) {
            NavigationRailView navigationRailView = NavigationRailView.this;
            if (navigationRailView.m10873p(navigationRailView.f8523h)) {
                fVar.f8416b += c9625s0.m60154f(C9625s0.l.m60205c()).f60771b;
            }
            NavigationRailView navigationRailView2 = NavigationRailView.this;
            if (navigationRailView2.m10873p(navigationRailView2.f8524i)) {
                fVar.f8418d += c9625s0.m60154f(C9625s0.l.m60205c()).f60773d;
            }
            boolean z10 = C9603h0.m59832A(view) == 1;
            int iM60158j = c9625s0.m60158j();
            int iM60159k = c9625s0.m60159k();
            int i10 = fVar.f8415a;
            if (z10) {
                iM60158j = iM60159k;
            }
            fVar.f8415a = i10 + iM60158j;
            fVar.m10792a(view);
            return c9625s0;
        }
    }

    public NavigationRailView(Context context) {
        this(context, null);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    /* renamed from: k */
    private void m10866k() {
        C1788s.m10781b(this, new C1805a());
    }

    public View getHeaderView() {
        return this.f8522g;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    /* renamed from: i */
    public void m10867i(int i10) {
        m10868j(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this, false));
    }

    /* renamed from: j */
    public void m10868j(View view) {
        m10872o();
        this.f8522g = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f8521f;
        addView(view, 0, layoutParams);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public NavigationRailMenuView mo9814d(Context context) {
        return new NavigationRailMenuView(context);
    }

    /* renamed from: m */
    public final boolean m10870m() {
        View view = this.f8522g;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: n */
    public final int m10871n(int i10) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i10) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i10;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    /* renamed from: o */
    public void m10872o() {
        View view = this.f8522g;
        if (view != null) {
            removeView(view);
            this.f8522g = null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i14 = 0;
        if (m10870m()) {
            int bottom = this.f8522g.getBottom() + this.f8521f;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i14 = bottom - top;
            }
        } else if (navigationRailMenuView.m10858n()) {
            i14 = this.f8521f;
        }
        if (i14 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i14, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i14);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iM10871n = m10871n(i10);
        super.onMeasure(iM10871n, i11);
        if (m10870m()) {
            measureChild(getNavigationRailMenuView(), iM10871n, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f8522g.getMeasuredHeight()) - this.f8521f, Integer.MIN_VALUE));
        }
    }

    /* renamed from: p */
    public final boolean m10873p(Boolean bool) {
        return bool != null ? bool.booleanValue() : C9603h0.m59917x(this);
    }

    public void setItemMinimumHeight(int i10) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i10);
    }

    public void setMenuGravity(int i10) {
        getNavigationRailMenuView().setMenuGravity(i10);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationRailStyle);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R$style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f8523h = null;
        this.f8524i = null;
        this.f8521f = getResources().getDimensionPixelSize(R$dimen.mtrl_navigation_rail_margin);
        C0523e0 c0523e0M10771i = C1784o.m10771i(getContext(), attributeSet, R$styleable.NavigationRailView, i10, i11, new int[0]);
        int iM2960n = c0523e0M10771i.m2960n(R$styleable.NavigationRailView_headerLayout, 0);
        if (iM2960n != 0) {
            m10867i(iM2960n);
        }
        setMenuGravity(c0523e0M10771i.m2957k(R$styleable.NavigationRailView_menuGravity, 49));
        int i12 = R$styleable.NavigationRailView_itemMinHeight;
        if (c0523e0M10771i.m2965s(i12)) {
            setItemMinimumHeight(c0523e0M10771i.m2952f(i12, -1));
        }
        int i13 = R$styleable.NavigationRailView_paddingTopSystemWindowInsets;
        if (c0523e0M10771i.m2965s(i13)) {
            this.f8523h = Boolean.valueOf(c0523e0M10771i.m2947a(i13, false));
        }
        int i14 = R$styleable.NavigationRailView_paddingBottomSystemWindowInsets;
        if (c0523e0M10771i.m2965s(i14)) {
            this.f8524i = Boolean.valueOf(c0523e0M10771i.m2947a(i14, false));
        }
        c0523e0M10771i.m2966w();
        m10866k();
    }
}
