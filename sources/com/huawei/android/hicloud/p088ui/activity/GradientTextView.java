package com.huawei.android.hicloud.p088ui.activity;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class GradientTextView extends TextView {
    public GradientTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            getPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, -16098825, -16716122, Shader.TileMode.REPEAT));
        }
    }

    public GradientTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GradientTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
