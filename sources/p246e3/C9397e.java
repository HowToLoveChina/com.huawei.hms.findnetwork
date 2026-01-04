package p246e3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import p002a1.AbstractC0002a;
import p246e3.AbstractC9394b;
import p439l0.AbstractC11217c;
import p439l0.C11219e;
import p439l0.C11220f;
import p760x2.C13689a;

/* renamed from: e3.e */
/* loaded from: classes.dex */
public final class C9397e<S extends AbstractC9394b> extends AbstractC9398f {

    /* renamed from: u */
    public static final AbstractC11217c<C9397e> f46943u = new a("indicatorLevel");

    /* renamed from: p */
    public AbstractC9399g<S> f46944p;

    /* renamed from: q */
    public final C11220f f46945q;

    /* renamed from: r */
    public final C11219e f46946r;

    /* renamed from: s */
    public float f46947s;

    /* renamed from: t */
    public boolean f46948t;

    /* renamed from: e3.e$a */
    public class a extends AbstractC11217c<C9397e> {
        public a(String str) {
            super(str);
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float mo58907a(C9397e c9397e) {
            return c9397e.m58904x() * 10000.0f;
        }

        @Override // p439l0.AbstractC11217c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void mo58908b(C9397e c9397e, float f10) {
            c9397e.m58906z(f10 / 10000.0f);
        }
    }

    public C9397e(Context context, AbstractC9394b abstractC9394b, AbstractC9399g<S> abstractC9399g) {
        super(context, abstractC9394b);
        this.f46948t = false;
        m58905y(abstractC9399g);
        C11220f c11220f = new C11220f();
        this.f46945q = c11220f;
        c11220f.m67410d(1.0f);
        c11220f.m67412f(50.0f);
        C11219e c11219e = new C11219e(this, f46943u);
        this.f46946r = c11219e;
        c11219e.m67405s(c11220f);
        m58919m(1.0f);
    }

    /* renamed from: u */
    public static C9397e<CircularProgressIndicatorSpec> m58893u(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new C9397e<>(context, circularProgressIndicatorSpec, new C9395c(circularProgressIndicatorSpec));
    }

    /* renamed from: v */
    public static C9397e<LinearProgressIndicatorSpec> m58894v(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new C9397e<>(context, linearProgressIndicatorSpec, new C9402j(linearProgressIndicatorSpec));
    }

    /* renamed from: A */
    public void m58895A(float f10) {
        setLevel((int) (f10 * 10000.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f46944p.m58925g(canvas, m58917g());
            this.f46944p.mo58862c(canvas, this.f46962m);
            this.f46944p.mo58861b(canvas, this.f46962m, 0.0f, m58904x(), C13689a.m82287a(this.f46951b.f46920c[0], getAlpha()));
            canvas.restore();
        }
    }

    @Override // p246e3.AbstractC9398f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f46944p.mo58863d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f46944p.mo58864e();
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

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f46946r.m67406t();
        m58906z(getLevel() / 10000.0f);
    }

    @Override // p246e3.AbstractC9398f
    /* renamed from: l */
    public /* bridge */ /* synthetic */ void mo58899l(AbstractC0002a abstractC0002a) {
        super.mo58899l(abstractC0002a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        if (this.f46948t) {
            this.f46946r.m67406t();
            m58906z(i10 / 10000.0f);
            return true;
        }
        this.f46946r.m67367k(m58904x() * 10000.0f);
        this.f46946r.m67401o(i10);
        return true;
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
        float fM58855a = this.f46952c.m58855a(this.f46950a.getContentResolver());
        if (fM58855a == 0.0f) {
            this.f46948t = true;
        } else {
            this.f46948t = false;
            this.f46945q.m67412f(50.0f / fM58855a);
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

    /* renamed from: w */
    public AbstractC9399g<S> m58903w() {
        return this.f46944p;
    }

    /* renamed from: x */
    public final float m58904x() {
        return this.f46947s;
    }

    /* renamed from: y */
    public void m58905y(AbstractC9399g<S> abstractC9399g) {
        this.f46944p = abstractC9399g;
        abstractC9399g.m58924f(this);
    }

    /* renamed from: z */
    public final void m58906z(float f10) {
        this.f46947s = f10;
        invalidateSelf();
    }
}
