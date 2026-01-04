package com.huawei.hicloud.base.p103ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* loaded from: classes6.dex */
public class ScrollDisabledListView extends ListView {
    public ScrollDisabledListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public ScrollDisabledListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
