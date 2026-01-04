package com.huawei.hicloud.base.view.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;

/* loaded from: classes6.dex */
public class AdjustTextView extends HwTextView {
    public AdjustTextView(Context context) {
        super(context);
    }

    /* renamed from: c */
    public final float m29160c(Layout layout) {
        if (layout == null) {
            return getMeasuredWidth();
        }
        int lineCount = layout.getLineCount();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < lineCount; i10++) {
            fMax = Math.max(layout.getLineWidth(i10), fMax);
        }
        return fMax;
    }

    @Override // com.huawei.uikit.hwtextview.widget.HwTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension((int) Math.ceil(m29160c(getLayout())), getMeasuredHeight());
    }

    public AdjustTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdjustTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
