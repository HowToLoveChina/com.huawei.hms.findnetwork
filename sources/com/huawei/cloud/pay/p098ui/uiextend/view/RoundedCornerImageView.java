package com.huawei.cloud.pay.p098ui.uiextend.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

/* loaded from: classes5.dex */
public class RoundedCornerImageView extends ImageView {

    /* renamed from: a */
    public Paint f21474a;

    /* renamed from: b */
    public RectF f21475b;

    /* renamed from: c */
    public int f21476c;

    /* renamed from: d */
    public BitmapShader f21477d;

    public RoundedCornerImageView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public int m28599a(int i10) {
        return (int) TypedValue.applyDimension(1, i10, getResources().getDisplayMetrics());
    }

    /* renamed from: b */
    public final Bitmap m28600b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* renamed from: c */
    public final void m28601c() {
        Paint paint = new Paint();
        this.f21474a = paint;
        paint.setAntiAlias(true);
    }

    /* renamed from: d */
    public final void m28602d() {
        Bitmap bitmapM28600b = m28600b(getDrawable());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapM28600b, tileMode, tileMode);
        this.f21477d = bitmapShader;
        this.f21474a.setShader(bitmapShader);
    }

    public int getCornerRadius() {
        return this.f21476c;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        m28602d();
        this.f21474a.setColor(-65536);
        float fM28599a = m28599a(this.f21476c);
        canvas.drawRoundRect(this.f21475b, fM28599a, fM28599a, this.f21474a);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f21475b = new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setCornerRadius(int i10) {
        int iM28599a = m28599a(i10);
        if (this.f21476c != iM28599a) {
            this.f21476c = iM28599a;
            invalidate();
        }
    }

    public RoundedCornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedCornerImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21476c = 8;
        m28601c();
    }
}
