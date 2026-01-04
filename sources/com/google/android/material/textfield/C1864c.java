package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import p356i3.C10427h;
import p356i3.C10432m;

/* renamed from: com.google.android.material.textfield.c */
/* loaded from: classes.dex */
public class C1864c extends C10427h {

    /* renamed from: A */
    public final RectF f8911A;

    /* renamed from: z */
    public final Paint f8912z;

    public C1864c(C10432m c10432m) {
        super(c10432m == null ? new C10432m() : c10432m);
        this.f8912z = new Paint(1);
        m11285u0();
        this.f8911A = new RectF();
    }

    /* renamed from: q0 */
    public boolean m11280q0() {
        return !this.f8911A.isEmpty();
    }

    @Override // p356i3.C10427h
    /* renamed from: r */
    public void mo11281r(Canvas canvas) {
        if (this.f8911A.isEmpty()) {
            super.mo11281r(canvas);
            return;
        }
        canvas.save();
        canvas.clipOutRect(this.f8911A);
        super.mo11281r(canvas);
        canvas.restore();
    }

    /* renamed from: r0 */
    public void m11282r0() {
        m11283s0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* renamed from: s0 */
    public void m11283s0(float f10, float f11, float f12, float f13) {
        RectF rectF = this.f8911A;
        if (f10 == rectF.left && f11 == rectF.top && f12 == rectF.right && f13 == rectF.bottom) {
            return;
        }
        rectF.set(f10, f11, f12, f13);
        invalidateSelf();
    }

    /* renamed from: t0 */
    public void m11284t0(RectF rectF) {
        m11283s0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* renamed from: u0 */
    public final void m11285u0() {
        this.f8912z.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f8912z.setColor(-1);
        this.f8912z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public C1864c() {
        this(null);
    }
}
