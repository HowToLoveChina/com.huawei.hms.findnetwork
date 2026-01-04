package com.huawei.openalliance.p169ad.views;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSHwRoundRectEclipseClipDrawable extends AbstractC8146p {

    /* renamed from: a */
    private float f36656a;

    /* renamed from: b */
    private float f36657b;

    /* renamed from: c */
    private Path f36658c;

    /* renamed from: d */
    private RectF f36659d;

    /* renamed from: e */
    private RectF f36660e;

    /* renamed from: f */
    private Rect f36661f;

    /* renamed from: g */
    private float f36662g;

    @OuterVisible
    public PPSHwRoundRectEclipseClipDrawable(Drawable drawable, int i10, int i11) {
        super(drawable, i10, i11);
        this.f36658c = new Path();
        this.f36659d = new RectF();
        this.f36660e = new RectF();
        m49055c();
    }

    /* renamed from: c */
    private void m49055c() {
        Rect bounds = getBounds();
        this.f36661f = bounds;
        m49062a(bounds.left, bounds.top, r1 + bounds.height(), this.f36661f.bottom);
        this.f36662g = m49059f(this.f36661f.height());
    }

    /* renamed from: d */
    private void m49057d(float f10) {
        this.f36658c.reset();
        this.f36658c.addArc(this.f36659d, 90.0f, 180.0f);
        Rect rect = this.f36661f;
        float f11 = rect.left + this.f36662g;
        float fWidth = rect.width() * f10;
        Rect rect2 = this.f36661f;
        this.f36658c.addRect(f11, rect2.top, fWidth + rect2.left, rect2.bottom, Path.Direction.CCW);
    }

    /* renamed from: e */
    private void m49058e(float f10) {
        this.f36658c.reset();
        this.f36658c.addArc(this.f36659d, 90.0f, 180.0f);
        float f11 = this.f36661f.right - this.f36662g;
        if (Float.compare(m49060a(), m49064b()) != 0) {
            Path path = this.f36658c;
            Rect rect = this.f36661f;
            path.addRect(this.f36662g + rect.left, rect.top, f11, rect.bottom, Path.Direction.CCW);
        }
        float fM49064b = Float.compare(m49060a(), 0.0f) != 0 ? ((f10 - m49064b()) / m49060a()) * this.f36662g : 0.0f;
        Rect rect2 = this.f36661f;
        this.f36660e.set(f11 - fM49064b, rect2.top, f11 + fM49064b, rect2.bottom);
        this.f36658c.addArc(this.f36660e, 270.0f, 180.0f);
    }

    /* renamed from: f */
    private float m49059f(float f10) {
        return f10 / 2.0f;
    }

    /* renamed from: a */
    public float m49060a() {
        return this.f36656a;
    }

    /* renamed from: b */
    public float m49064b() {
        return this.f36657b;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8146p, android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        m49063a(i10, i11, i12, i13);
        int i14 = i12 - i10;
        if (i14 != 0) {
            m49053a(this.f36662g / i14);
            m49054b(1.0f - m49060a());
        }
    }

    /* renamed from: b */
    private void m49054b(float f10) {
        this.f36657b = f10;
    }

    /* renamed from: c */
    private void m49056c(float f10) {
        this.f36658c.reset();
        this.f36658c.addArc(this.f36659d, 90.0f, 180.0f);
        float fM49060a = Float.compare(m49060a(), 0.0f) != 0 ? (f10 / m49060a()) * this.f36662g : 0.0f;
        Rect rect = this.f36661f;
        RectF rectF = this.f36660e;
        Rect rect2 = this.f36661f;
        rectF.set(rect2.left + fM49060a, rect2.top, (rect.left + rect.height()) - fM49060a, rect2.bottom);
        this.f36658c.addArc(this.f36660e, 270.0f, -180.0f);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8146p
    /* renamed from: a */
    public Path mo49061a(int i10) {
        float f10 = i10 / 10000.0f;
        if (Float.compare(f10, m49060a()) < 0) {
            m49056c(f10);
        } else if (Float.compare(f10, m49064b()) < 0) {
            m49057d(f10);
        } else {
            m49058e(f10);
        }
        return this.f36658c;
    }

    /* renamed from: a */
    private void m49053a(float f10) {
        this.f36656a = f10;
    }

    /* renamed from: a */
    public void m49062a(float f10, float f11, float f12, float f13) {
        this.f36659d.set(f10, f11, f12, f13);
    }

    /* renamed from: a */
    public void m49063a(int i10, int i11, int i12, int i13) {
        this.f36661f.set(i10, i11, i12, i13);
        m49062a(i10, i11, i10 + r4, i13);
        this.f36662g = m49059f(i13 - i11);
    }
}
