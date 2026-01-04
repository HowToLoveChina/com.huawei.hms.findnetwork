package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* loaded from: classes2.dex */
public class AutoSizeTextView extends TextView {
    public AutoSizeTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int lineCount = getLineCount();
        int iM47570d = AbstractC7741ao.m47570d(getContext(), getTextSize());
        if (lineCount <= 1 || iM47570d <= 10) {
            return;
        }
        setTextSize(1, iM47570d - 1);
    }

    public AutoSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoSizeTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public AutoSizeTextView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
