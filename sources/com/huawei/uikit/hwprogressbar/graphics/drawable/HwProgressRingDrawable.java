package com.huawei.uikit.hwprogressbar.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;

/* loaded from: classes2.dex */
public class HwProgressRingDrawable extends Drawable {
    public static final int FILLED_RING_TYPE = 1;
    public static final int TICK_RING_TYPE = 2;

    /* renamed from: l */
    private static final String f43097l = "HwProgressRingDrawable";

    /* renamed from: m */
    private static final int f43098m = 360;

    /* renamed from: n */
    private static final int f43099n = -90;

    /* renamed from: o */
    private static final int f43100o = 120;

    /* renamed from: p */
    private static final float f43101p = 0.5f;

    /* renamed from: q */
    private static final float f43102q = 3.0f;

    /* renamed from: a */
    private int f43103a;

    /* renamed from: b */
    private int f43104b;

    /* renamed from: c */
    private int f43105c;

    /* renamed from: d */
    private int f43106d;

    /* renamed from: e */
    private int f43107e;

    /* renamed from: f */
    private float f43108f;

    /* renamed from: g */
    private RectF f43109g;

    /* renamed from: h */
    private Paint f43110h;

    /* renamed from: i */
    private Paint f43111i;

    /* renamed from: j */
    private ColorStateList f43112j;

    /* renamed from: k */
    private ColorStateList f43113k;

    public HwProgressRingDrawable() {
        Paint paint = new Paint(1);
        this.f43111i = paint;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        this.f43111i.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.f43110h = paint2;
        paint2.setStrokeCap(cap);
        this.f43109g = new RectF();
    }

    /* renamed from: a */
    private boolean m54749a() {
        boolean z10;
        int colorForState;
        int colorForState2;
        int[] state = getState();
        ColorStateList colorStateList = this.f43112j;
        boolean z11 = true;
        if (colorStateList == null || (colorForState2 = colorStateList.getColorForState(state, this.f43106d)) == this.f43106d) {
            z10 = false;
        } else {
            this.f43106d = colorForState2;
            z10 = true;
        }
        ColorStateList colorStateList2 = this.f43113k;
        if (colorStateList2 == null || (colorForState = colorStateList2.getColorForState(state, this.f43107e)) == this.f43107e) {
            z11 = z10;
        } else {
            this.f43107e = colorForState;
        }
        if (z11) {
            invalidateSelf();
        }
        return z11;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f43109g == null) {
            return;
        }
        canvas.save();
        int i10 = this.f43103a;
        if (i10 == 1) {
            Paint paint = this.f43111i;
            if (paint != null) {
                float f10 = this.f43108f * 360.0f;
                paint.setColor(this.f43107e);
                canvas.drawArc(this.f43109g, f10 - 90.0f, 360.0f - f10, false, this.f43111i);
                this.f43111i.setColor(this.f43106d);
                canvas.drawArc(this.f43109g, -90.0f, f10, false, this.f43111i);
            }
        } else if (i10 == 2 && this.f43110h != null) {
            int iRound = Math.round(this.f43108f * 120.0f);
            RectF rectF = this.f43109g;
            float f11 = (rectF.left + rectF.right) * f43101p;
            float f12 = (rectF.top + rectF.bottom) * f43101p;
            for (int i11 = 0; i11 < 120; i11++) {
                if (i11 < iRound) {
                    this.f43110h.setColor(this.f43106d);
                } else {
                    this.f43110h.setColor(this.f43107e);
                }
                float f13 = this.f43104b;
                float f14 = this.f43105c * f43101p;
                canvas.drawLine(f11, f13 + f14, f11, f14, this.f43110h);
                canvas.rotate(f43102q, f11, f12);
            }
        }
        canvas.restore();
    }

    public ColorStateList getFillColor() {
        return this.f43112j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getRatio() {
        return this.f43108f;
    }

    public int getRingWidth() {
        return this.f43104b;
    }

    public int getTickWidth() {
        return this.f43105c;
    }

    public ColorStateList getTrackColor() {
        return this.f43113k;
    }

    public int getType() {
        return this.f43103a;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        RectF rectF = this.f43109g;
        float f10 = rect.left;
        float f11 = this.f43104b * f43101p;
        rectF.left = f10 + f11;
        rectF.top = rect.top + f11;
        rectF.right = rect.right - f11;
        rectF.bottom = rect.bottom - f11;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return m54749a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setFillColor(int i10) {
        this.f43112j = ColorStateList.valueOf(i10);
        m54749a();
    }

    public void setRatio(float f10) {
        if (Float.floatToIntBits(f10) != Float.floatToIntBits(this.f43108f)) {
            this.f43108f = f10;
            invalidateSelf();
        }
    }

    public void setRingWidth(int i10) {
        if (i10 != this.f43104b) {
            this.f43104b = i10;
            this.f43111i.setStrokeWidth(i10);
            invalidateSelf();
        }
    }

    public void setTickWidth(int i10) {
        if (i10 != this.f43105c) {
            this.f43105c = i10;
            this.f43110h.setStrokeWidth(i10);
            invalidateSelf();
        }
    }

    public void setTrackColor(int i10) {
        this.f43113k = ColorStateList.valueOf(i10);
        m54749a();
    }

    public void setType(int i10) {
        if (i10 != this.f43103a) {
            this.f43103a = i10;
            invalidateSelf();
        }
    }

    public void setFillColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            Log.e(f43097l, "Null fillColorStateList in setFillColor.");
        } else {
            this.f43112j = colorStateList;
            m54749a();
        }
    }

    public void setTrackColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            Log.e(f43097l, "Null trackColorStateList in setFillColor.");
        } else {
            this.f43113k = colorStateList;
            m54749a();
        }
    }
}
