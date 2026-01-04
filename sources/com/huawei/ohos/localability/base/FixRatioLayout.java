package com.huawei.ohos.localability.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes8.dex */
public class FixRatioLayout extends RelativeLayout {
    public FixRatioLayout(Context context) {
        super(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i10), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (((r6 * 2) * 1.0d) / 3.0d), 1073741824));
    }

    public FixRatioLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixRatioLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
