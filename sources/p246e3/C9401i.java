package p246e3;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import p002a1.AbstractC0002a;
import p246e3.AbstractC9394b;

/* renamed from: e3.i */
/* loaded from: classes.dex */
public final class C9401i<S extends AbstractC9394b> extends AbstractC9398f {

    /* renamed from: p */
    public AbstractC9399g<S> f46971p;

    /* renamed from: q */
    public AbstractC9400h<ObjectAnimator> f46972q;

    public C9401i(Context context, AbstractC9394b abstractC9394b, AbstractC9399g<S> abstractC9399g, AbstractC9400h<ObjectAnimator> abstractC9400h) {
        super(context, abstractC9394b);
        m58933x(abstractC9399g);
        m58932w(abstractC9400h);
    }

    /* renamed from: s */
    public static C9401i<CircularProgressIndicatorSpec> m58928s(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new C9401i<>(context, circularProgressIndicatorSpec, new C9395c(circularProgressIndicatorSpec), new C9396d(circularProgressIndicatorSpec));
    }

    /* renamed from: t */
    public static C9401i<LinearProgressIndicatorSpec> m58929t(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new C9401i<>(context, linearProgressIndicatorSpec, new C9402j(linearProgressIndicatorSpec), linearProgressIndicatorSpec.f8550g == 0 ? new C9403k(linearProgressIndicatorSpec) : new C9404l(context, linearProgressIndicatorSpec));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        this.f46971p.m58925g(canvas, m58917g());
        this.f46971p.mo58862c(canvas, this.f46962m);
        int i10 = 0;
        while (true) {
            AbstractC9400h<ObjectAnimator> abstractC9400h = this.f46972q;
            int[] iArr = abstractC9400h.f46970c;
            if (i10 >= iArr.length) {
                canvas.restore();
                return;
            }
            AbstractC9399g<S> abstractC9399g = this.f46971p;
            Paint paint = this.f46962m;
            float[] fArr = abstractC9400h.f46969b;
            int i11 = i10 * 2;
            abstractC9399g.mo58861b(canvas, paint, fArr[i11], fArr[i11 + 1], iArr[i10]);
            i10++;
        }
    }

    @Override // p246e3.AbstractC9398f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f46971p.mo58863d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f46971p.mo58864e();
    }

    @Override // p246e3.AbstractC9398f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // p246e3.AbstractC9398f
    /* renamed from: h */
    public /* bridge */ /* synthetic */ boolean mo58896h() {
        return super.mo58896h();
    }

    @Override // p246e3.AbstractC9398f
    /* renamed from: i */
    public /* bridge */ /* synthetic */ boolean mo58897i() {
        return super.mo58897i();
    }

    @Override // p246e3.AbstractC9398f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // p246e3.AbstractC9398f
    /* renamed from: j */
    public /* bridge */ /* synthetic */ boolean mo58898j() {
        return super.mo58898j();
    }

    @Override // p246e3.AbstractC9398f
    /* renamed from: l */
    public /* bridge */ /* synthetic */ void mo58899l(AbstractC0002a abstractC0002a) {
        super.mo58899l(abstractC0002a);
    }

    @Override // p246e3.AbstractC9398f
    /* renamed from: p */
    public /* bridge */ /* synthetic */ boolean mo58900p(boolean z10, boolean z11, boolean z12) {
        return super.mo58900p(z10, z11, z12);
    }

    @Override // p246e3.AbstractC9398f
    /* renamed from: q */
    public boolean mo58901q(boolean z10, boolean z11, boolean z12) {
        boolean zMo58901q = super.mo58901q(z10, z11, z12);
        if (!isRunning()) {
            this.f46972q.mo58873a();
        }
        this.f46952c.m58855a(this.f46950a.getContentResolver());
        if (z10 && z12) {
            this.f46972q.mo58877g();
        }
        return zMo58901q;
    }

    @Override // p246e3.AbstractC9398f
    /* renamed from: r */
    public /* bridge */ /* synthetic */ boolean mo58902r(AbstractC0002a abstractC0002a) {
        return super.mo58902r(abstractC0002a);
    }

    @Override // p246e3.AbstractC9398f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // p246e3.AbstractC9398f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // p246e3.AbstractC9398f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    @Override // p246e3.AbstractC9398f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // p246e3.AbstractC9398f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    /* renamed from: u */
    public AbstractC9400h<ObjectAnimator> m58930u() {
        return this.f46972q;
    }

    /* renamed from: v */
    public AbstractC9399g<S> m58931v() {
        return this.f46971p;
    }

    /* renamed from: w */
    public void m58932w(AbstractC9400h<ObjectAnimator> abstractC9400h) {
        this.f46972q = abstractC9400h;
        abstractC9400h.m58927e(this);
    }

    /* renamed from: x */
    public void m58933x(AbstractC9399g<S> abstractC9399g) {
        this.f46971p = abstractC9399g;
        abstractC9399g.m58924f(this);
    }
}
