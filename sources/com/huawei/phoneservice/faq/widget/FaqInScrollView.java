package com.huawei.phoneservice.faq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes4.dex */
public class FaqInScrollView extends ScrollView {
    public FaqInScrollView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ScrollView
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        return 0;
    }

    public FaqInScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaqInScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
