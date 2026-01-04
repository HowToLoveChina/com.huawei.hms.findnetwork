package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.C0523e0;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import p273f0.C9603h0;
import p273f0.C9625s0;

/* loaded from: classes.dex */
public class BottomNavigationView extends NavigationBarView {

    /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationView$a */
    public class C1672a implements C1788s.e {
        public C1672a() {
        }

        @Override // com.google.android.material.internal.C1788s.e
        /* renamed from: a */
        public C9625s0 mo9794a(View view, C9625s0 c9625s0, C1788s.f fVar) {
            fVar.f8418d += c9625s0.m60157i();
            boolean z10 = C9603h0.m59832A(view) == 1;
            int iM60158j = c9625s0.m60158j();
            int iM60159k = c9625s0.m60159k();
            fVar.f8415a += z10 ? iM60159k : iM60158j;
            int i10 = fVar.f8417c;
            if (!z10) {
                iM60158j = iM60159k;
            }
            fVar.f8417c = i10 + iM60158j;
            fVar.m10792a(view);
            return c9625s0;
        }
    }

    @Deprecated
    /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationView$b */
    public interface InterfaceC1673b extends NavigationBarView.InterfaceC1798b {
    }

    @Deprecated
    /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationView$c */
    public interface InterfaceC1674c extends NavigationBarView.InterfaceC1799c {
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    /* renamed from: d */
    public NavigationBarMenuView mo9814d(Context context) {
        return new BottomNavigationMenuView(context);
    }

    /* renamed from: f */
    public final void m9815f(Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, R$color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    /* renamed from: g */
    public final void m9816g() {
        C1788s.m10781b(this, new C1672a());
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    /* renamed from: h */
    public final int m9817h(int i10) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i10) == 1073741824 || suggestedMinimumHeight <= 0) {
            return i10;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), suggestedMinimumHeight + getPaddingTop() + getPaddingBottom()), 1073741824);
    }

    /* renamed from: i */
    public final boolean m9818i() {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, m9817h(i11));
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.m9813n() != z10) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z10);
            getPresenter().mo2414b(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(InterfaceC1673b interfaceC1673b) {
        setOnItemReselectedListener(interfaceC1673b);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(InterfaceC1674c interfaceC1674c) {
        setOnItemSelectedListener(interfaceC1674c);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R$style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Context context2 = getContext();
        C0523e0 c0523e0M10771i = C1784o.m10771i(context2, attributeSet, R$styleable.BottomNavigationView, i10, i11, new int[0]);
        setItemHorizontalTranslationEnabled(c0523e0M10771i.m2947a(R$styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int i12 = R$styleable.BottomNavigationView_android_minHeight;
        if (c0523e0M10771i.m2965s(i12)) {
            setMinimumHeight(c0523e0M10771i.m2952f(i12, 0));
        }
        c0523e0M10771i.m2966w();
        if (m9818i()) {
            m9815f(context2);
        }
        m9816g();
    }
}
