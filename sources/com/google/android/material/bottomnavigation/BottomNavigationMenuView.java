package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import com.google.android.material.R$dimen;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {

    /* renamed from: E */
    public final int f7574E;

    /* renamed from: F */
    public final int f7575F;

    /* renamed from: G */
    public final int f7576G;

    /* renamed from: H */
    public final int f7577H;

    /* renamed from: I */
    public boolean f7578I;

    /* renamed from: J */
    public int[] f7579J;

    public BottomNavigationMenuView(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f7574E = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_max_width);
        this.f7575F = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_item_min_width);
        this.f7576G = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_max_width);
        this.f7577H = resources.getDimensionPixelSize(R$dimen.design_bottom_navigation_active_item_min_width);
        this.f7579J = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    /* renamed from: g */
    public NavigationBarItemView mo9812g(Context context) {
        return new BottomNavigationItemView(context);
    }

    /* renamed from: n */
    public boolean m9813n() {
        return this.f7578I;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int measuredWidth = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                if (C9603h0.m59832A(this) == 1) {
                    int i17 = i14 - measuredWidth;
                    childAt.layout(i17 - childAt.getMeasuredWidth(), 0, i17, i15);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i15);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i10);
        int size2 = menu.m2342G().size();
        int childCount = getChildCount();
        int size3 = View.MeasureSpec.getSize(i11);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        if (m10824h(getLabelVisibilityMode(), size2) && m9813n()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int iMax = this.f7577H;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f7576G, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i12 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.f7575F * i12), Math.min(iMax, this.f7576G));
            int i13 = size - iMin;
            int iMin2 = Math.min(i13 / (i12 == 0 ? 1 : i12), this.f7574E);
            int i14 = i13 - (i12 * iMin2);
            int i15 = 0;
            while (i15 < childCount) {
                if (getChildAt(i15).getVisibility() != 8) {
                    this.f7579J[i15] = i15 == getSelectedItemPosition() ? iMin : iMin2;
                    if (i14 > 0) {
                        int[] iArr = this.f7579J;
                        iArr[i15] = iArr[i15] + 1;
                        i14--;
                    }
                } else {
                    this.f7579J[i15] = 0;
                }
                i15++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 != 0 ? size2 : 1), this.f7576G);
            int i16 = size - (size2 * iMin3);
            for (int i17 = 0; i17 < childCount; i17++) {
                if (getChildAt(i17).getVisibility() != 8) {
                    int[] iArr2 = this.f7579J;
                    iArr2[i17] = iMin3;
                    if (i16 > 0) {
                        iArr2[i17] = iMin3 + 1;
                        i16--;
                    }
                } else {
                    this.f7579J[i17] = 0;
                }
            }
        }
        int measuredWidth = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.f7579J[i18], 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), View.resolveSizeAndState(size3, i11, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        this.f7578I = z10;
    }
}
