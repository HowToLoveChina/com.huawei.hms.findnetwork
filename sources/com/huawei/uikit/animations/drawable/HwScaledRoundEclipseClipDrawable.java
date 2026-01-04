package com.huawei.uikit.animations.drawable;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;

/* loaded from: classes6.dex */
public class HwScaledRoundEclipseClipDrawable extends HwRoundEclipseClipDrawable {

    /* renamed from: E */
    private static final float f40980E = 0.5f;

    /* renamed from: F */
    private static final float f40981F = 1.0f;

    /* renamed from: G */
    private static final float f40982G = 0.7f;

    /* renamed from: H */
    private static final float f40983H = 1.4f;

    /* renamed from: I */
    private static final int f40984I = 10000;

    /* renamed from: J */
    private static final int f40985J = 2;

    /* renamed from: K */
    private static final int f40986K = 90;

    /* renamed from: L */
    private static final int f40987L = 270;

    /* renamed from: M */
    private static final int f40988M = 180;

    /* renamed from: N */
    private static final int f40989N = -180;

    /* renamed from: A */
    private RectF f40990A;

    /* renamed from: B */
    private Path f40991B;

    /* renamed from: C */
    private RectF f40992C;

    /* renamed from: D */
    private RectF f40993D;

    /* renamed from: y */
    private float f40994y;

    /* renamed from: z */
    private float f40995z;

    public HwScaledRoundEclipseClipDrawable(Drawable drawable, int i10, int i11) {
        super(drawable, i10, i11);
        this.f40995z = 0.7f;
        m53771e();
    }

    /* renamed from: c */
    private void m53770c(float f10) {
        this.f40991B.reset();
        this.f40991B.addArc(this.f40992C, 90.0f, 180.0f);
        float f11 = (f10 / f40980E) * this.f40994y;
        RectF rectF = this.f40993D;
        RectF rectF2 = this.f40990A;
        float f12 = rectF2.left;
        rectF.set(f12 + f11, rectF2.top, (f12 + rectF2.height()) - f11, this.f40990A.bottom);
        this.f40991B.addArc(this.f40993D, 270.0f, -180.0f);
    }

    /* renamed from: e */
    private void m53771e() {
        this.f40991B = new Path();
        this.f40994y = getBounds().height() / 2.0f;
        Rect bounds = getBounds();
        float f10 = ((1.0f - this.f40995z) / 2.0f) * this.f40994y;
        this.f40990A = new RectF(bounds.left + f10, bounds.top + f10, bounds.right - f10, bounds.bottom - f10);
        this.f40992C = new RectF(this.f40990A);
        this.f40993D = new RectF();
        m53773g(this.f40995z);
    }

    /* renamed from: f */
    private void m53772f(float f10) {
        this.f40991B.reset();
        this.f40991B.addArc(this.f40992C, 90.0f, 180.0f);
        float f11 = ((1.0f - f10) / f40980E) * this.f40994y;
        RectF rectF = this.f40993D;
        RectF rectF2 = this.f40990A;
        rectF.set(rectF2.left + f11, rectF2.top, rectF2.right - f11, rectF2.bottom);
        this.f40991B.addArc(this.f40993D, 270.0f, 180.0f);
    }

    /* renamed from: g */
    private void m53773g(float f10) {
        Rect bounds = getBounds();
        if (bounds.height() == 0 || bounds.width() == 0) {
            return;
        }
        float fWidth = ((1.0f - f10) / 2.0f) * bounds.width();
        this.f40990A.set(bounds.left + fWidth, bounds.top + fWidth, bounds.right - fWidth, bounds.bottom - fWidth);
        this.f40992C.set(this.f40990A);
        invalidateSelf();
    }

    @Override // com.huawei.uikit.animations.drawable.HwEclipseClipDrawable, android.graphics.drawable.ClipDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        setCircleRadiusRatio(this.f40995z);
        super.draw(canvas);
    }

    public float getCircleRadiusRatio() {
        return this.f40995z;
    }

    @Override // com.huawei.uikit.animations.drawable.HwRoundRectEclipseClipDrawable, com.huawei.uikit.animations.drawable.HwEclipseClipDrawable
    public Path getClipPath(int i10) {
        float f10 = i10 / 10000.0f;
        if (Float.compare(f10, f40980E) < 0) {
            m53770c(f10);
        } else {
            m53772f(f10);
        }
        return this.f40991B;
    }

    @Override // com.huawei.uikit.animations.drawable.HwRoundRectEclipseClipDrawable, com.huawei.uikit.animations.drawable.HwEclipseClipDrawable, android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        float f10 = (i13 - i11) / 2.0f;
        float f11 = this.f40995z;
        this.f40994y = f10 * f11;
        m53773g(f11);
        this.f40992C.set(this.f40990A);
    }

    public void setCircleRadiusRatio(float f10) {
        if (Float.compare(this.f40995z, f10) != 0) {
            this.f40995z = f10;
            this.f40994y = (getBounds().height() / 2.0f) * f10;
            m53773g(f10);
        }
    }

    public void startCircleExpandAnimation(int i10, Interpolator interpolator) {
        if (i10 <= 0) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "CircleRadiusRatio", this.f40995z, f40983H);
        objectAnimatorOfFloat.setDuration(i10);
        objectAnimatorOfFloat.setInterpolator(interpolator);
        objectAnimatorOfFloat.start();
    }
}
