package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import p514o9.C11839m;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class FoldLineLinearLayout extends LinearLayout {

    /* renamed from: a */
    public final int f19455a;

    public FoldLineLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = View.MeasureSpec.getSize(i10);
        int childCount = getChildCount();
        if (childCount > 1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(0);
                int measuredWidth = childAt.getMeasuredWidth() + childAt.getPaddingLeft() + childAt.getPaddingRight();
                View childAt2 = getChildAt(1);
                int measuredWidth2 = childAt2.getMeasuredWidth() + childAt2.getPaddingLeft() + childAt2.getPaddingRight();
                C11839m.m70686d("FoldLineLinearLayout", "onMeasure oneWidth =" + measuredWidth + " twoWidth =" + measuredWidth2 + " widthSize =" + size);
                int i13 = measuredWidth + measuredWidth2;
                int i14 = this.f19455a;
                if (i13 + i14 >= size) {
                    setOrientation(1);
                    childAt2.setPadding(0, this.f19455a, 0, 0);
                } else {
                    childAt2.setPadding(i14, 0, 0, 0);
                    setOrientation(0);
                }
            }
        }
    }

    public FoldLineLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FoldLineLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19455a = C11842p.m70840n(context, 4);
    }
}
