package com.huawei.hicloud.base.p103ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class ExpandRecyclerView extends RecyclerView {
    public ExpandRecyclerView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public ExpandRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
