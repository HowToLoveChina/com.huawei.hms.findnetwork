package p356i3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p325h3.C10089a;

/* renamed from: i3.o */
/* loaded from: classes.dex */
public class C10434o {

    /* renamed from: a */
    @Deprecated
    public float f50355a;

    /* renamed from: b */
    @Deprecated
    public float f50356b;

    /* renamed from: c */
    @Deprecated
    public float f50357c;

    /* renamed from: d */
    @Deprecated
    public float f50358d;

    /* renamed from: e */
    @Deprecated
    public float f50359e;

    /* renamed from: f */
    @Deprecated
    public float f50360f;

    /* renamed from: g */
    public final List<f> f50361g = new ArrayList();

    /* renamed from: h */
    public final List<g> f50362h = new ArrayList();

    /* renamed from: i */
    public boolean f50363i;

    /* renamed from: i3.o$a */
    public class a extends g {

        /* renamed from: b */
        public final /* synthetic */ List f50364b;

        /* renamed from: c */
        public final /* synthetic */ Matrix f50365c;

        public a(List list, Matrix matrix) {
            this.f50364b = list;
            this.f50365c = matrix;
        }

        @Override // p356i3.C10434o.g
        /* renamed from: a */
        public void mo64141a(Matrix matrix, C10089a c10089a, int i10, Canvas canvas) {
            Iterator it = this.f50364b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).mo64141a(this.f50365c, c10089a, i10, canvas);
            }
        }
    }

    /* renamed from: i3.o$b */
    public static class b extends g {

        /* renamed from: b */
        public final d f50367b;

        public b(d dVar) {
            this.f50367b = dVar;
        }

        @Override // p356i3.C10434o.g
        /* renamed from: a */
        public void mo64141a(Matrix matrix, C10089a c10089a, int i10, Canvas canvas) {
            c10089a.m62883a(canvas, matrix, new RectF(this.f50367b.m64153k(), this.f50367b.m64157o(), this.f50367b.m64154l(), this.f50367b.m64152j()), i10, this.f50367b.m64155m(), this.f50367b.m64156n());
        }
    }

    /* renamed from: i3.o$c */
    public static class c extends g {

        /* renamed from: b */
        public final e f50368b;

        /* renamed from: c */
        public final float f50369c;

        /* renamed from: d */
        public final float f50370d;

        public c(e eVar, float f10, float f11) {
            this.f50368b = eVar;
            this.f50369c = f10;
            this.f50370d = f11;
        }

        @Override // p356i3.C10434o.g
        /* renamed from: a */
        public void mo64141a(Matrix matrix, C10089a c10089a, int i10, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f50368b.f50379c - this.f50370d, this.f50368b.f50378b - this.f50369c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f50369c, this.f50370d);
            matrix2.preRotate(m64142c());
            c10089a.m62884b(canvas, matrix2, rectF, i10);
        }

        /* renamed from: c */
        public float m64142c() {
            return (float) Math.toDegrees(Math.atan((this.f50368b.f50379c - this.f50370d) / (this.f50368b.f50378b - this.f50369c)));
        }
    }

    /* renamed from: i3.o$d */
    public static class d extends f {

        /* renamed from: h */
        public static final RectF f50371h = new RectF();

        /* renamed from: b */
        @Deprecated
        public float f50372b;

        /* renamed from: c */
        @Deprecated
        public float f50373c;

        /* renamed from: d */
        @Deprecated
        public float f50374d;

        /* renamed from: e */
        @Deprecated
        public float f50375e;

        /* renamed from: f */
        @Deprecated
        public float f50376f;

        /* renamed from: g */
        @Deprecated
        public float f50377g;

        public d(float f10, float f11, float f12, float f13) {
            m64159q(f10);
            m64163u(f11);
            m64160r(f12);
            m64158p(f13);
        }

        @Override // p356i3.C10434o.f
        /* renamed from: a */
        public void mo64151a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f50380a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f50371h;
            rectF.set(m64153k(), m64157o(), m64154l(), m64152j());
            path.arcTo(rectF, m64155m(), m64156n(), false);
            path.transform(matrix);
        }

        /* renamed from: j */
        public final float m64152j() {
            return this.f50375e;
        }

        /* renamed from: k */
        public final float m64153k() {
            return this.f50372b;
        }

        /* renamed from: l */
        public final float m64154l() {
            return this.f50374d;
        }

        /* renamed from: m */
        public final float m64155m() {
            return this.f50376f;
        }

        /* renamed from: n */
        public final float m64156n() {
            return this.f50377g;
        }

        /* renamed from: o */
        public final float m64157o() {
            return this.f50373c;
        }

        /* renamed from: p */
        public final void m64158p(float f10) {
            this.f50375e = f10;
        }

        /* renamed from: q */
        public final void m64159q(float f10) {
            this.f50372b = f10;
        }

        /* renamed from: r */
        public final void m64160r(float f10) {
            this.f50374d = f10;
        }

        /* renamed from: s */
        public final void m64161s(float f10) {
            this.f50376f = f10;
        }

        /* renamed from: t */
        public final void m64162t(float f10) {
            this.f50377g = f10;
        }

        /* renamed from: u */
        public final void m64163u(float f10) {
            this.f50373c = f10;
        }
    }

    /* renamed from: i3.o$e */
    public static class e extends f {

        /* renamed from: b */
        public float f50378b;

        /* renamed from: c */
        public float f50379c;

        @Override // p356i3.C10434o.f
        /* renamed from: a */
        public void mo64151a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f50380a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f50378b, this.f50379c);
            path.transform(matrix);
        }
    }

    /* renamed from: i3.o$f */
    public static abstract class f {

        /* renamed from: a */
        public final Matrix f50380a = new Matrix();

        /* renamed from: a */
        public abstract void mo64151a(Matrix matrix, Path path);
    }

    /* renamed from: i3.o$g */
    public static abstract class g {

        /* renamed from: a */
        public static final Matrix f50381a = new Matrix();

        /* renamed from: a */
        public abstract void mo64141a(Matrix matrix, C10089a c10089a, int i10, Canvas canvas);

        /* renamed from: b */
        public final void m64168b(C10089a c10089a, int i10, Canvas canvas) {
            mo64141a(f50381a, c10089a, i10, canvas);
        }
    }

    public C10434o() {
        m64133n(0.0f, 0.0f);
    }

    /* renamed from: a */
    public void m64120a(float f10, float f11, float f12, float f13, float f14, float f15) {
        d dVar = new d(f10, f11, f12, f13);
        dVar.m64161s(f14);
        dVar.m64162t(f15);
        this.f50361g.add(dVar);
        b bVar = new b(dVar);
        float f16 = f14 + f15;
        boolean z10 = f15 < 0.0f;
        if (z10) {
            f14 = (f14 + 180.0f) % 360.0f;
        }
        m64122c(bVar, f14, z10 ? (180.0f + f16) % 360.0f : f16);
        double d10 = f16;
        m64137r(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        m64138s(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    /* renamed from: b */
    public final void m64121b(float f10) {
        if (m64126g() == f10) {
            return;
        }
        float fM64126g = ((f10 - m64126g()) + 360.0f) % 360.0f;
        if (fM64126g > 180.0f) {
            return;
        }
        d dVar = new d(m64128i(), m64129j(), m64128i(), m64129j());
        dVar.m64161s(m64126g());
        dVar.m64162t(fM64126g);
        this.f50362h.add(new b(dVar));
        m64135p(f10);
    }

    /* renamed from: c */
    public final void m64122c(g gVar, float f10, float f11) {
        m64121b(f10);
        this.f50362h.add(gVar);
        m64135p(f11);
    }

    /* renamed from: d */
    public void m64123d(Matrix matrix, Path path) {
        int size = this.f50361g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f50361g.get(i10).mo64151a(matrix, path);
        }
    }

    /* renamed from: e */
    public boolean m64124e() {
        return this.f50363i;
    }

    /* renamed from: f */
    public g m64125f(Matrix matrix) {
        m64121b(m64127h());
        return new a(new ArrayList(this.f50362h), new Matrix(matrix));
    }

    /* renamed from: g */
    public final float m64126g() {
        return this.f50359e;
    }

    /* renamed from: h */
    public final float m64127h() {
        return this.f50360f;
    }

    /* renamed from: i */
    public float m64128i() {
        return this.f50357c;
    }

    /* renamed from: j */
    public float m64129j() {
        return this.f50358d;
    }

    /* renamed from: k */
    public float m64130k() {
        return this.f50355a;
    }

    /* renamed from: l */
    public float m64131l() {
        return this.f50356b;
    }

    /* renamed from: m */
    public void m64132m(float f10, float f11) {
        e eVar = new e();
        eVar.f50378b = f10;
        eVar.f50379c = f11;
        this.f50361g.add(eVar);
        c cVar = new c(eVar, m64128i(), m64129j());
        m64122c(cVar, cVar.m64142c() + 270.0f, cVar.m64142c() + 270.0f);
        m64137r(f10);
        m64138s(f11);
    }

    /* renamed from: n */
    public void m64133n(float f10, float f11) {
        m64134o(f10, f11, 270.0f, 0.0f);
    }

    /* renamed from: o */
    public void m64134o(float f10, float f11, float f12, float f13) {
        m64139t(f10);
        m64140u(f11);
        m64137r(f10);
        m64138s(f11);
        m64135p(f12);
        m64136q((f12 + f13) % 360.0f);
        this.f50361g.clear();
        this.f50362h.clear();
        this.f50363i = false;
    }

    /* renamed from: p */
    public final void m64135p(float f10) {
        this.f50359e = f10;
    }

    /* renamed from: q */
    public final void m64136q(float f10) {
        this.f50360f = f10;
    }

    /* renamed from: r */
    public final void m64137r(float f10) {
        this.f50357c = f10;
    }

    /* renamed from: s */
    public final void m64138s(float f10) {
        this.f50358d = f10;
    }

    /* renamed from: t */
    public final void m64139t(float f10) {
        this.f50355a = f10;
    }

    /* renamed from: u */
    public final void m64140u(float f10) {
        this.f50356b = f10;
    }
}
