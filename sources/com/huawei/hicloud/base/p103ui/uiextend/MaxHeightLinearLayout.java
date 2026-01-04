package com.huawei.hicloud.base.p103ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes6.dex */
public class MaxHeightLinearLayout extends LinearLayout {

    /* renamed from: a */
    public Context f22159a;

    public MaxHeightLinearLayout(Context context) {
        super(context);
        this.f22159a = context;
    }

    public int getMaxHeight() {
        return ((this.f22159a.getResources().getDisplayMetrics().heightPixels - (C12806c.m76818i(this.f22159a) ? C12809f.m76835h(this.f22159a) : 0)) * 8) / 10;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int maxHeight = getMaxHeight();
        if (getMeasuredHeight() > maxHeight) {
            i11 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
    }

    public MaxHeightLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22159a = context;
    }
}
