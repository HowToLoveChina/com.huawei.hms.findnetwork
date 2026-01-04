package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class WrapContentHeightViewPager extends ViewPager {
    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i10, int i11) throws Resources.NotFoundException {
        int i12 = 0;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            childAt.measure(i10, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i12) {
                i12 = measuredHeight;
            }
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
