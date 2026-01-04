package com.huawei.android.hicloud.p088ui.views.status;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes3.dex */
public class ImageScanningView extends View {

    /* renamed from: a */
    public Bitmap f19601a;

    /* renamed from: b */
    public Bitmap f19602b;

    /* renamed from: c */
    public Paint f19603c;

    /* renamed from: d */
    public PorterDuffXfermode f19604d;

    /* renamed from: e */
    public float f19605e;

    /* renamed from: f */
    public float f19606f;

    /* renamed from: g */
    public float f19607g;

    public ImageScanningView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m25853a() {
        Paint paint = new Paint(1);
        this.f19603c = paint;
        paint.setDither(true);
        this.f19603c.setFilterBitmap(true);
        this.f19604d = new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
    }

    public Bitmap getSrcBitmap() {
        return this.f19601a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.f19603c, 31);
        Bitmap bitmap = this.f19602b;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f19605e, 0.0f, this.f19603c);
        }
        if (this.f19601a != null) {
            this.f19603c.setXfermode(this.f19604d);
            canvas.drawBitmap(this.f19601a, 0.0f, 0.0f, this.f19603c);
            this.f19603c.setXfermode(null);
        }
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        float f10 = -i10;
        this.f19606f = f10;
        this.f19605e = f10;
        this.f19607g = i10;
    }

    public void setLightBitmap(Bitmap bitmap) {
        this.f19602b = bitmap;
    }

    public void setSrcBitmap(Bitmap bitmap) {
        this.f19601a = bitmap;
    }

    public ImageScanningView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageScanningView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m25853a();
    }
}
