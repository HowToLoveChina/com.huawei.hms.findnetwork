package com.huawei.uikit.animations.drawable;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes6.dex */
public class HwRoundRectEclipseClipDrawable extends HwEclipseClipDrawable {

    /* renamed from: p */
    private static final String f40965p = "HwRoundRectEclipseClipDrawable";

    /* renamed from: q */
    private static final int f40966q = 10000;

    /* renamed from: r */
    private static final int f40967r = 90;

    /* renamed from: s */
    private static final int f40968s = 270;

    /* renamed from: t */
    private static final int f40969t = 180;

    /* renamed from: u */
    private static final int f40970u = -180;

    /* renamed from: v */
    private static final float f40971v = 1.0f;

    /* renamed from: w */
    private static final int f40972w = 2;

    /* renamed from: i */
    private float f40973i;

    /* renamed from: j */
    private float f40974j;

    /* renamed from: k */
    private Path f40975k;

    /* renamed from: l */
    private RectF f40976l;

    /* renamed from: m */
    private RectF f40977m;

    /* renamed from: n */
    private Rect f40978n;

    /* renamed from: o */
    private float f40979o;

    public HwRoundRectEclipseClipDrawable(Drawable drawable, int i10, int i11) {
        super(drawable, i10, i11);
        this.f40975k = new Path();
        this.f40976l = new RectF();
        this.f40977m = new RectF();
        m53765e();
    }

    /* renamed from: a */
    private float m53761a(float f10) {
        return f10 / 2.0f;
    }

    /* renamed from: b */
    private void m53762b(float f10) {
        this.f40975k.reset();
        this.f40975k.addArc(this.f40976l, 90.0f, 180.0f);
        Rect rect = this.f40978n;
        float f11 = rect.left + this.f40979o;
        float fWidth = rect.width() * f10;
        Rect rect2 = this.f40978n;
        this.f40975k.addRect(f11, rect2.top, fWidth + rect2.left, rect2.bottom, Path.Direction.CCW);
    }

    /* renamed from: c */
    private void m53763c(float f10) {
        this.f40975k.reset();
        this.f40975k.addArc(this.f40976l, 90.0f, 180.0f);
        float progressRatioLeftRoundEnd = Float.compare(getProgressRatioLeftRoundEnd(), 0.0f) != 0 ? (f10 / getProgressRatioLeftRoundEnd()) * this.f40979o : 0.0f;
        Rect rect = this.f40978n;
        RectF rectF = this.f40977m;
        Rect rect2 = this.f40978n;
        rectF.set(rect2.left + progressRatioLeftRoundEnd, rect2.top, (rect.left + rect.height()) - progressRatioLeftRoundEnd, rect2.bottom);
        this.f40975k.addArc(this.f40977m, 270.0f, -180.0f);
    }

    /* renamed from: d */
    private void m53764d(float f10) {
        this.f40973i = f10;
    }

    /* renamed from: e */
    private void m53765e() {
        Rect bounds = getBounds();
        this.f40978n = bounds;
        m53768a(bounds.left, bounds.top, r1 + bounds.height(), this.f40978n.bottom);
        this.f40979o = m53761a(this.f40978n.height());
    }

    /* renamed from: f */
    private void m53767f(float f10) {
        this.f40975k.reset();
        this.f40975k.addArc(this.f40976l, 90.0f, 180.0f);
        float f11 = this.f40978n.right - this.f40979o;
        if (Float.compare(getProgressRatioLeftRoundEnd(), getProgressRationRightRoundBegin()) != 0) {
            Path path = this.f40975k;
            Rect rect = this.f40978n;
            path.addRect(this.f40979o + rect.left, rect.top, f11, rect.bottom, Path.Direction.CCW);
        }
        float progressRationRightRoundBegin = Float.compare(getProgressRatioLeftRoundEnd(), 0.0f) != 0 ? ((f10 - getProgressRationRightRoundBegin()) / getProgressRatioLeftRoundEnd()) * this.f40979o : 0.0f;
        Rect rect2 = this.f40978n;
        this.f40977m.set(f11 - progressRationRightRoundBegin, rect2.top, f11 + progressRationRightRoundBegin, rect2.bottom);
        this.f40975k.addArc(this.f40977m, 270.0f, 180.0f);
    }

    @Override // com.huawei.uikit.animations.drawable.HwEclipseClipDrawable
    public Path getClipPath(int i10) {
        float f10 = i10 / 10000.0f;
        if (Float.compare(f10, getProgressRatioLeftRoundEnd()) < 0) {
            m53763c(f10);
        } else if (Float.compare(f10, getProgressRationRightRoundBegin()) < 0) {
            m53762b(f10);
        } else {
            m53767f(f10);
        }
        return this.f40975k;
    }

    public float getProgressRatioLeftRoundEnd() {
        return this.f40973i;
    }

    public float getProgressRationRightRoundBegin() {
        return this.f40974j;
    }

    @Override // com.huawei.uikit.animations.drawable.HwEclipseClipDrawable, android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        m53769a(i10, i11, i12, i13);
        int i14 = i12 - i10;
        if (i14 != 0) {
            m53764d(this.f40979o / i14);
            m53766e(1.0f - getProgressRatioLeftRoundEnd());
        }
    }

    /* renamed from: a */
    public void m53768a(float f10, float f11, float f12, float f13) {
        this.f40976l.set(f10, f11, f12, f13);
    }

    /* renamed from: a */
    public void m53769a(int i10, int i11, int i12, int i13) {
        this.f40978n.set(i10, i11, i12, i13);
        m53768a(i10, i11, i10 + r4, i13);
        this.f40979o = m53761a(i13 - i11);
    }

    /* renamed from: e */
    private void m53766e(float f10) {
        this.f40974j = f10;
    }
}
