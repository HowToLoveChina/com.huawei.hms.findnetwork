package com.huawei.openalliance.p169ad.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.huawei.openalliance.p169ad.C6849R;

/* loaded from: classes2.dex */
public class RoundLinearLayout extends LinearLayout {

    /* renamed from: a */
    private final RectF f37358a;

    /* renamed from: b */
    private float f37359b;

    /* renamed from: c */
    private Path f37360c;

    public RoundLinearLayout(Context context) {
        super(context);
        this.f37358a = new RectF();
        this.f37359b = 0.0f;
        m49908a(context, null);
    }

    /* renamed from: a */
    private void m49907a() {
        this.f37360c.reset();
        Path path = this.f37360c;
        RectF rectF = this.f37358a;
        float f10 = this.f37359b;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f37359b > 0.01f) {
            canvas.clipPath(this.f37360c);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f37358a.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        m49907a();
    }

    public void setRectCornerRadius(float f10) {
        this.f37359b = f10;
        m49907a();
        postInvalidate();
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37358a = new RectF();
        this.f37359b = 0.0f;
        m49908a(context, attributeSet);
    }

    /* renamed from: a */
    private void m49908a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.PPSRoundCornerLayout)) != null) {
            try {
                this.f37359b = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6849R.styleable.PPSRoundCornerLayout_hiad_roundCorner, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        setWillNotDraw(false);
        this.f37360c = new Path();
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37358a = new RectF();
        this.f37359b = 0.0f;
        m49908a(context, attributeSet);
    }

    @TargetApi(21)
    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f37358a = new RectF();
        this.f37359b = 0.0f;
        m49908a(context, attributeSet);
    }
}
