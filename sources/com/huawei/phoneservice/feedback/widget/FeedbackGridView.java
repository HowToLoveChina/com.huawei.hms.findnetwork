package com.huawei.phoneservice.feedback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: classes5.dex */
public class FeedbackGridView extends GridView {
    public FeedbackGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public FeedbackGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeedbackGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
