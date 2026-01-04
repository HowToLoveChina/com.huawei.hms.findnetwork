package p246e3;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import p760x2.C13689a;

/* renamed from: e3.c */
/* loaded from: classes.dex */
public final class C9395c extends AbstractC9399g<CircularProgressIndicatorSpec> {

    /* renamed from: c */
    public int f46924c;

    /* renamed from: d */
    public float f46925d;

    /* renamed from: e */
    public float f46926e;

    /* renamed from: f */
    public float f46927f;

    public C9395c(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f46924c = 1;
    }

    @Override // p246e3.AbstractC9399g
    /* renamed from: a */
    public void mo58860a(Canvas canvas, float f10) {
        S s10 = this.f46966a;
        float f11 = (((CircularProgressIndicatorSpec) s10).f8546g / 2.0f) + ((CircularProgressIndicatorSpec) s10).f8547h;
        canvas.translate(f11, f11);
        canvas.rotate(-90.0f);
        float f12 = -f11;
        canvas.clipRect(f12, f12, f11, f11);
        this.f46924c = ((CircularProgressIndicatorSpec) this.f46966a).f8548i == 0 ? 1 : -1;
        this.f46925d = ((CircularProgressIndicatorSpec) r5).f46918a * f10;
        this.f46926e = ((CircularProgressIndicatorSpec) r5).f46919b * f10;
        this.f46927f = (((CircularProgressIndicatorSpec) r5).f8546g - ((CircularProgressIndicatorSpec) r5).f46918a) / 2.0f;
        if ((this.f46967b.mo58898j() && ((CircularProgressIndicatorSpec) this.f46966a).f46922e == 2) || (this.f46967b.mo58897i() && ((CircularProgressIndicatorSpec) this.f46966a).f46923f == 1)) {
            this.f46927f += ((1.0f - f10) * ((CircularProgressIndicatorSpec) this.f46966a).f46918a) / 2.0f;
        } else if ((this.f46967b.mo58898j() && ((CircularProgressIndicatorSpec) this.f46966a).f46922e == 1) || (this.f46967b.mo58897i() && ((CircularProgressIndicatorSpec) this.f46966a).f46923f == 2)) {
            this.f46927f -= ((1.0f - f10) * ((CircularProgressIndicatorSpec) this.f46966a).f46918a) / 2.0f;
        }
    }

    @Override // p246e3.AbstractC9399g
    /* renamed from: b */
    public void mo58861b(Canvas canvas, Paint paint, float f10, float f11, int i10) {
        if (f10 == f11) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i10);
        paint.setStrokeWidth(this.f46925d);
        int i11 = this.f46924c;
        float f12 = f10 * 360.0f * i11;
        float f13 = (f11 >= f10 ? f11 - f10 : (1.0f + f11) - f10) * 360.0f * i11;
        float f14 = this.f46927f;
        canvas.drawArc(new RectF(-f14, -f14, f14, f14), f12, f13, false, paint);
        if (this.f46926e <= 0.0f || Math.abs(f13) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        m58865h(canvas, paint, this.f46925d, this.f46926e, f12);
        m58865h(canvas, paint, this.f46925d, this.f46926e, f12 + f13);
    }

    @Override // p246e3.AbstractC9399g
    /* renamed from: c */
    public void mo58862c(Canvas canvas, Paint paint) {
        int iM82287a = C13689a.m82287a(((CircularProgressIndicatorSpec) this.f46966a).f46921d, this.f46967b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(iM82287a);
        paint.setStrokeWidth(this.f46925d);
        float f10 = this.f46927f;
        canvas.drawArc(new RectF(-f10, -f10, f10, f10), 0.0f, 360.0f, false, paint);
    }

    @Override // p246e3.AbstractC9399g
    /* renamed from: d */
    public int mo58863d() {
        return m58866i();
    }

    @Override // p246e3.AbstractC9399g
    /* renamed from: e */
    public int mo58864e() {
        return m58866i();
    }

    /* renamed from: h */
    public final void m58865h(Canvas canvas, Paint paint, float f10, float f11, float f12) {
        canvas.save();
        canvas.rotate(f12);
        float f13 = this.f46927f;
        float f14 = f10 / 2.0f;
        canvas.drawRoundRect(new RectF(f13 - f14, f11, f13 + f14, -f11), f11, f11, paint);
        canvas.restore();
    }

    /* renamed from: i */
    public final int m58866i() {
        S s10 = this.f46966a;
        return ((CircularProgressIndicatorSpec) s10).f8546g + (((CircularProgressIndicatorSpec) s10).f8547h * 2);
    }
}
