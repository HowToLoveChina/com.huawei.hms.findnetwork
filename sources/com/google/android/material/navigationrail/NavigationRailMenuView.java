package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* loaded from: classes.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {

    /* renamed from: E */
    public int f8519E;

    /* renamed from: F */
    public final FrameLayout.LayoutParams f8520F;

    public NavigationRailMenuView(Context context) {
        super(context);
        this.f8519E = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f8520F = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    /* renamed from: g */
    public NavigationBarItemView mo9812g(Context context) {
        return new NavigationRailItemView(context);
    }

    public int getItemMinimumHeight() {
        return this.f8519E;
    }

    public int getMenuGravity() {
        return this.f8520F.gravity;
    }

    /* renamed from: n */
    public boolean m10858n() {
        return (this.f8520F.gravity & 112) == 48;
    }

    /* renamed from: o */
    public final int m10859o(int i10, int i11, int i12) {
        int iMax = i11 / Math.max(1, i12);
        int size = this.f8519E;
        if (size == -1) {
            size = View.MeasureSpec.getSize(i10);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, iMax), 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                childAt.layout(0, i15, i14, measuredHeight);
                i15 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i11);
        int size2 = getMenu().m2342G().size();
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i10), i10, 0), View.resolveSizeAndState((size2 <= 1 || !m10824h(getLabelVisibilityMode(), size2)) ? m10861q(i10, size, size2, null) : m10862r(i10, size, size2), i11, 0));
    }

    /* renamed from: p */
    public final int m10860p(View view, int i10, int i11) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i10, i11);
        return view.getMeasuredHeight();
    }

    /* renamed from: q */
    public final int m10861q(int i10, int i11, int i12, View view) {
        m10859o(i10, i11, i12);
        int iM10859o = view == null ? m10859o(i10, i11, i12) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int iM10860p = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt != view) {
                iM10860p += m10860p(childAt, i10, iM10859o);
            }
        }
        return iM10860p;
    }

    /* renamed from: r */
    public final int m10862r(int i10, int i11, int i12) {
        int iM10860p;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            iM10860p = m10860p(childAt, i10, m10859o(i10, i11, i12));
            i11 -= iM10860p;
            i12--;
        } else {
            iM10860p = 0;
        }
        return iM10860p + m10861q(i10, i11, i12, childAt);
    }

    public void setItemMinimumHeight(int i10) {
        if (this.f8519E != i10) {
            this.f8519E = i10;
            requestLayout();
        }
    }

    public void setMenuGravity(int i10) {
        FrameLayout.LayoutParams layoutParams = this.f8520F;
        if (layoutParams.gravity != i10) {
            layoutParams.gravity = i10;
            setLayoutParams(layoutParams);
        }
    }
}
