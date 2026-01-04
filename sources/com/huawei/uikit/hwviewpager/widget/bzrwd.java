package com.huawei.uikit.hwviewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.huawei.uikit.hwviewpager.C8744R;

/* loaded from: classes9.dex */
class bzrwd extends Drawable {

    /* renamed from: j */
    private static final int f44861j = 107;

    /* renamed from: k */
    private static final int f44862k = 300;

    /* renamed from: l */
    private static final int f44863l = 2;

    /* renamed from: a */
    private Paint f44864a;

    /* renamed from: b */
    private int f44865b;

    /* renamed from: c */
    private HwViewPager f44866c;

    /* renamed from: d */
    private Bitmap f44867d;

    /* renamed from: e */
    private int f44868e;

    /* renamed from: f */
    private int f44869f;

    /* renamed from: g */
    private int f44870g;

    /* renamed from: h */
    private int f44871h;

    /* renamed from: i */
    private int f44872i;

    public bzrwd(int i10, HwViewPager hwViewPager) throws Resources.NotFoundException {
        this.f44866c = hwViewPager;
        Paint paint = new Paint();
        this.f44864a = paint;
        paint.setColor(i10);
        this.f44864a.setMaskFilter(new BlurMaskFilter(107.0f, BlurMaskFilter.Blur.NORMAL));
        this.f44864a.setAntiAlias(true);
        Context context = hwViewPager.getContext();
        if (context != null) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(C8744R.dimen.hwviewpager_shadow_width);
            this.f44869f = dimensionPixelSize;
            this.f44870g = dimensionPixelSize / 2;
        }
        this.f44867d = Bitmap.createBitmap(this.f44869f, this.f44866c.getHeight(), Bitmap.Config.RGB_565);
        this.f44871h = this.f44866c.getTop();
        this.f44872i = this.f44866c.getBottom();
    }

    /* renamed from: a */
    private void m55945a(Canvas canvas, int i10) {
        canvas.clipRect(this.f44865b, this.f44871h, i10, this.f44872i);
        canvas.drawBitmap(this.f44867d, this.f44865b - this.f44870g, this.f44871h, this.f44864a);
    }

    /* renamed from: b */
    private void m55946b(Canvas canvas, int i10) {
        canvas.clipRect(i10, this.f44871h, canvas.getWidth() - this.f44865b, this.f44872i);
        canvas.drawBitmap(this.f44867d, (canvas.getWidth() - this.f44865b) - this.f44870g, this.f44871h, this.f44864a);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f44866c.getAdapter() == null) {
            return;
        }
        if (this.f44866c.isSupportLoop() || this.f44868e != r0.getCount() - 1) {
            if (!this.f44866c.getReverseDrawingOrder()) {
                if (this.f44866c.isRtlLayout()) {
                    m55945a(canvas, this.f44865b - 300);
                    return;
                } else {
                    m55946b(canvas, (canvas.getWidth() - this.f44865b) + 300);
                    return;
                }
            }
            if (this.f44865b > 0) {
                if (this.f44866c.isRtlLayout()) {
                    m55945a(canvas, this.f44865b + 300);
                } else {
                    m55946b(canvas, (canvas.getWidth() - this.f44865b) - 300);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f44864a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.f44867d = Bitmap.createBitmap(this.f44869f, this.f44866c.getHeight(), Bitmap.Config.RGB_565);
        this.f44871h = this.f44866c.getTop();
        this.f44872i = this.f44866c.getBottom();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f44864a.setColorFilter(colorFilter);
    }

    /* renamed from: a */
    public void m55947a(int i10, int i11) {
        this.f44868e = i10;
        if (this.f44866c.getReverseDrawingOrder() && i11 < 0) {
            this.f44865b = this.f44866c.getWidth() + i11;
        } else {
            this.f44865b = i11;
        }
        invalidateSelf();
    }
}
