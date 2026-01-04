package com.huawei.android.p069cg.p071ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class SquareRoundRectImageView extends ImageView {
    public SquareRoundRectImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i10);
    }

    public SquareRoundRectImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareRoundRectImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
