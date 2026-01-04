package com.huawei.openalliance.p169ad.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.C6849R;

/* loaded from: classes2.dex */
public class CornerImageView extends ImageView {

    /* renamed from: a */
    private final RectF f36403a;

    /* renamed from: b */
    private float f36404b;

    /* renamed from: c */
    private Path f36405c;

    public CornerImageView(Context context) {
        super(context);
        this.f36403a = new RectF();
        this.f36404b = 0.0f;
        m48797a(context, null);
    }

    /* renamed from: a */
    private void m48796a() {
        this.f36405c.reset();
        Path path = this.f36405c;
        RectF rectF = this.f36403a;
        float f10 = this.f36404b;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f36404b > 0.01f) {
            canvas.clipPath(this.f36405c);
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f36403a.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        m48796a();
    }

    public void setRectCornerRadius(float f10) {
        this.f36404b = f10;
        m48796a();
        postInvalidate();
    }

    public CornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36403a = new RectF();
        this.f36404b = 0.0f;
        m48797a(context, attributeSet);
    }

    /* renamed from: a */
    private void m48797a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.PPSCornerImageView)) != null) {
            try {
                this.f36404b = typedArrayObtainStyledAttributes.getDimensionPixelSize(C6849R.styleable.PPSCornerImageView_hiad_ImageCorner, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        setWillNotDraw(false);
        this.f36405c = new Path();
    }

    public CornerImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36403a = new RectF();
        this.f36404b = 0.0f;
        m48797a(context, attributeSet);
    }

    @TargetApi(21)
    public CornerImageView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f36403a = new RectF();
        this.f36404b = 0.0f;
        m48797a(context, attributeSet);
    }
}
