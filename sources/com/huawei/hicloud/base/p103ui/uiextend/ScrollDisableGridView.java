package com.huawei.hicloud.base.p103ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: classes6.dex */
public class ScrollDisableGridView extends GridView {
    public ScrollDisableGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public ScrollDisableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
