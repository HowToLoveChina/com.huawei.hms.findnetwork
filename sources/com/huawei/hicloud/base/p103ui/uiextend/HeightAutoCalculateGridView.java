package com.huawei.hicloud.base.p103ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: classes6.dex */
public class HeightAutoCalculateGridView extends GridView {
    public HeightAutoCalculateGridView(Context context) {
        super(context);
    }

    private int getTotalHeight() {
        int height;
        int childCount = getChildCount();
        int numColumns = getNumColumns();
        int verticalSpacing = getVerticalSpacing();
        if (childCount <= 0 || numColumns <= 0) {
            return 0;
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            int i14 = i13 / numColumns;
            if (i14 != i12) {
                i10 = i10 + i11 + verticalSpacing;
                i11 = 0;
                i12 = i14;
            }
            View childAt = getChildAt(i13);
            if (childAt != null && (height = childAt.getHeight()) > i11) {
                i11 = height;
            }
        }
        return i10 + i11;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        int totalHeight = getTotalHeight();
        if (totalHeight != 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(totalHeight, 1073741824);
        }
        super.onMeasure(i10, iMakeMeasureSpec);
    }

    public HeightAutoCalculateGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
