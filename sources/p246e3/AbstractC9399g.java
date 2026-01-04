package p246e3;

import android.graphics.Canvas;
import android.graphics.Paint;
import p246e3.AbstractC9394b;

/* renamed from: e3.g */
/* loaded from: classes.dex */
public abstract class AbstractC9399g<S extends AbstractC9394b> {

    /* renamed from: a */
    public S f46966a;

    /* renamed from: b */
    public AbstractC9398f f46967b;

    public AbstractC9399g(S s10) {
        this.f46966a = s10;
    }

    /* renamed from: a */
    public abstract void mo58860a(Canvas canvas, float f10);

    /* renamed from: b */
    public abstract void mo58861b(Canvas canvas, Paint paint, float f10, float f11, int i10);

    /* renamed from: c */
    public abstract void mo58862c(Canvas canvas, Paint paint);

    /* renamed from: d */
    public abstract int mo58863d();

    /* renamed from: e */
    public abstract int mo58864e();

    /* renamed from: f */
    public void m58924f(AbstractC9398f abstractC9398f) {
        this.f46967b = abstractC9398f;
    }

    /* renamed from: g */
    public void m58925g(Canvas canvas, float f10) {
        this.f46966a.mo10893e();
        mo58860a(canvas, f10);
    }
}
