package com.huawei.cloud.pay.p098ui.uiextend;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.huawei.cloud.pay.R$drawable;

/* loaded from: classes5.dex */
public class LabelTextView extends TextView {

    /* renamed from: a */
    public float f21472a;

    public LabelTextView(Context context) {
        super(context);
        this.f21472a = -45.0f;
        setBackgroundByLayoutDirection(context);
    }

    private void setBackgroundByLayoutDirection(Context context) {
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            setBackgroundResource(R$drawable.icon_label_mirror);
            this.f21472a = 45.0f;
        } else {
            setBackgroundResource(R$drawable.icon_label);
            this.f21472a = -45.0f;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        float measuredWidth = getResources().getConfiguration().getLayoutDirection() == 1 ? getMeasuredWidth() / 2.0f : getMeasuredWidth() / 2.5f;
        canvas.rotate(this.f21472a, measuredWidth, getMeasuredHeight() / 2.0f);
        canvas.translate(0.0f, (-measuredWidth) / 3.0f);
        super.onDraw(canvas);
    }

    public LabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21472a = -45.0f;
        setBackgroundByLayoutDirection(context);
    }

    public LabelTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21472a = -45.0f;
        setBackgroundByLayoutDirection(context);
    }
}
