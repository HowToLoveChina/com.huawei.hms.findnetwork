package p246e3;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import p760x2.C13689a;

/* renamed from: e3.j */
/* loaded from: classes.dex */
public final class C9402j extends AbstractC9399g<LinearProgressIndicatorSpec> {

    /* renamed from: c */
    public float f46973c;

    /* renamed from: d */
    public float f46974d;

    /* renamed from: e */
    public float f46975e;

    public C9402j(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f46973c = 300.0f;
    }

    @Override // p246e3.AbstractC9399g
    /* renamed from: a */
    public void mo58860a(Canvas canvas, float f10) {
        Rect clipBounds = canvas.getClipBounds();
        this.f46973c = clipBounds.width();
        float f11 = ((LinearProgressIndicatorSpec) this.f46966a).f46918a;
        canvas.translate(clipBounds.left + (clipBounds.width() / 2.0f), clipBounds.top + (clipBounds.height() / 2.0f) + Math.max(0.0f, (clipBounds.height() - ((LinearProgressIndicatorSpec) this.f46966a).f46918a) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f46966a).f8552i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f46967b.mo58898j() && ((LinearProgressIndicatorSpec) this.f46966a).f46922e == 1) || (this.f46967b.mo58897i() && ((LinearProgressIndicatorSpec) this.f46966a).f46923f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f46967b.mo58898j() || this.f46967b.mo58897i()) {
            canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.f46966a).f46918a * (f10 - 1.0f)) / 2.0f);
        }
        float f12 = this.f46973c;
        canvas.clipRect((-f12) / 2.0f, (-f11) / 2.0f, f12 / 2.0f, f11 / 2.0f);
        S s10 = this.f46966a;
        this.f46974d = ((LinearProgressIndicatorSpec) s10).f46918a * f10;
        this.f46975e = ((LinearProgressIndicatorSpec) s10).f46919b * f10;
    }

    @Override // p246e3.AbstractC9399g
    /* renamed from: b */
    public void mo58861b(Canvas canvas, Paint paint, float f10, float f11, int i10) {
        if (f10 == f11) {
            return;
        }
        float f12 = this.f46973c;
        float f13 = this.f46975e;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i10);
        float f14 = this.f46974d;
        RectF rectF = new RectF(((-f12) / 2.0f) + (f10 * (f12 - (f13 * 2.0f))), (-f14) / 2.0f, ((-f12) / 2.0f) + (f11 * (f12 - (f13 * 2.0f))) + (f13 * 2.0f), f14 / 2.0f);
        float f15 = this.f46975e;
        canvas.drawRoundRect(rectF, f15, f15, paint);
    }

    @Override // p246e3.AbstractC9399g
    /* renamed from: c */
    public void mo58862c(Canvas canvas, Paint paint) {
        int iM82287a = C13689a.m82287a(((LinearProgressIndicatorSpec) this.f46966a).f46921d, this.f46967b.getAlpha());
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(iM82287a);
        float f10 = this.f46973c;
        float f11 = this.f46974d;
        RectF rectF = new RectF((-f10) / 2.0f, (-f11) / 2.0f, f10 / 2.0f, f11 / 2.0f);
        float f12 = this.f46975e;
        canvas.drawRoundRect(rectF, f12, f12, paint);
    }

    @Override // p246e3.AbstractC9399g
    /* renamed from: d */
    public int mo58863d() {
        return ((LinearProgressIndicatorSpec) this.f46966a).f46918a;
    }

    @Override // p246e3.AbstractC9399g
    /* renamed from: e */
    public int mo58864e() {
        return -1;
    }
}
