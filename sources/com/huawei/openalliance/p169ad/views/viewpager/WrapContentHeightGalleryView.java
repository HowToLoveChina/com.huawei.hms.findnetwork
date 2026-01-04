package com.huawei.openalliance.p169ad.views.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
public class WrapContentHeightGalleryView extends C8160e {
    public WrapContentHeightGalleryView(Context context) {
        super(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.viewpager.C8160e, android.view.View
    public void onMeasure(int i10, int i11) {
        int iMax = 0;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            childAt.measure(i10, View.MeasureSpec.makeMeasureSpec(0, 0));
            iMax = Math.max(childAt.getMeasuredHeight(), iMax);
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(iMax, 1073741824));
    }

    public WrapContentHeightGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
