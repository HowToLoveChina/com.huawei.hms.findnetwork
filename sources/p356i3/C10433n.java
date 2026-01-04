package p356i3;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* renamed from: i3.n */
/* loaded from: classes.dex */
public class C10433n {

    /* renamed from: a */
    public final C10434o[] f50337a = new C10434o[4];

    /* renamed from: b */
    public final Matrix[] f50338b = new Matrix[4];

    /* renamed from: c */
    public final Matrix[] f50339c = new Matrix[4];

    /* renamed from: d */
    public final PointF f50340d = new PointF();

    /* renamed from: e */
    public final Path f50341e = new Path();

    /* renamed from: f */
    public final Path f50342f = new Path();

    /* renamed from: g */
    public final C10434o f50343g = new C10434o();

    /* renamed from: h */
    public final float[] f50344h = new float[2];

    /* renamed from: i */
    public final float[] f50345i = new float[2];

    /* renamed from: j */
    public final Path f50346j = new Path();

    /* renamed from: k */
    public final Path f50347k = new Path();

    /* renamed from: l */
    public boolean f50348l = true;

    /* renamed from: i3.n$a */
    public static class a {

        /* renamed from: a */
        public static final C10433n f50349a = new C10433n();
    }

    /* renamed from: i3.n$b */
    public interface b {
        /* renamed from: a */
        void mo64036a(C10434o c10434o, Matrix matrix, int i10);

        /* renamed from: b */
        void mo64037b(C10434o c10434o, Matrix matrix, int i10);
    }

    /* renamed from: i3.n$c */
    public static final class c {

        /* renamed from: a */
        public final C10432m f50350a;

        /* renamed from: b */
        public final Path f50351b;

        /* renamed from: c */
        public final RectF f50352c;

        /* renamed from: d */
        public final b f50353d;

        /* renamed from: e */
        public final float f50354e;

        public c(C10432m c10432m, float f10, RectF rectF, b bVar, Path path) {
            this.f50353d = bVar;
            this.f50350a = c10432m;
            this.f50354e = f10;
            this.f50352c = rectF;
            this.f50351b = path;
        }
    }

    public C10433n() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f50337a[i10] = new C10434o();
            this.f50338b[i10] = new Matrix();
            this.f50339c[i10] = new Matrix();
        }
    }

    /* renamed from: k */
    public static C10433n m64106k() {
        return a.f50349a;
    }

    /* renamed from: a */
    public final float m64107a(int i10) {
        return (i10 + 1) * 90;
    }

    /* renamed from: b */
    public final void m64108b(c cVar, int i10) {
        this.f50344h[0] = this.f50337a[i10].m64130k();
        this.f50344h[1] = this.f50337a[i10].m64131l();
        this.f50338b[i10].mapPoints(this.f50344h);
        if (i10 == 0) {
            Path path = cVar.f50351b;
            float[] fArr = this.f50344h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f50351b;
            float[] fArr2 = this.f50344h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f50337a[i10].m64123d(this.f50338b[i10], cVar.f50351b);
        b bVar = cVar.f50353d;
        if (bVar != null) {
            bVar.mo64037b(this.f50337a[i10], this.f50338b[i10], i10);
        }
    }

    /* renamed from: c */
    public final void m64109c(c cVar, int i10) {
        int i11 = (i10 + 1) % 4;
        this.f50344h[0] = this.f50337a[i10].m64128i();
        this.f50344h[1] = this.f50337a[i10].m64129j();
        this.f50338b[i10].mapPoints(this.f50344h);
        this.f50345i[0] = this.f50337a[i11].m64130k();
        this.f50345i[1] = this.f50337a[i11].m64131l();
        this.f50338b[i11].mapPoints(this.f50345i);
        float f10 = this.f50344h[0];
        float[] fArr = this.f50345i;
        float fMax = Math.max(((float) Math.hypot(f10 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fM64115i = m64115i(cVar.f50352c, i10);
        this.f50343g.m64133n(0.0f, 0.0f);
        C10425f c10425fM64116j = m64116j(i10, cVar.f50350a);
        c10425fM64116j.mo9799d(fMax, fM64115i, cVar.f50354e, this.f50343g);
        this.f50346j.reset();
        this.f50343g.m64123d(this.f50339c[i10], this.f50346j);
        if (this.f50348l && (c10425fM64116j.mo63969c() || m64117l(this.f50346j, i10) || m64117l(this.f50346j, i11))) {
            Path path = this.f50346j;
            path.op(path, this.f50342f, Path.Op.DIFFERENCE);
            this.f50344h[0] = this.f50343g.m64130k();
            this.f50344h[1] = this.f50343g.m64131l();
            this.f50339c[i10].mapPoints(this.f50344h);
            Path path2 = this.f50341e;
            float[] fArr2 = this.f50344h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f50343g.m64123d(this.f50339c[i10], this.f50341e);
        } else {
            this.f50343g.m64123d(this.f50339c[i10], cVar.f50351b);
        }
        b bVar = cVar.f50353d;
        if (bVar != null) {
            bVar.mo64036a(this.f50343g, this.f50339c[i10], i10);
        }
    }

    /* renamed from: d */
    public void m64110d(C10432m c10432m, float f10, RectF rectF, Path path) {
        m64111e(c10432m, f10, rectF, null, path);
    }

    /* renamed from: e */
    public void m64111e(C10432m c10432m, float f10, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f50341e.rewind();
        this.f50342f.rewind();
        this.f50342f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(c10432m, f10, rectF, bVar, path);
        for (int i10 = 0; i10 < 4; i10++) {
            m64118m(cVar, i10);
            m64119n(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            m64108b(cVar, i11);
            m64109c(cVar, i11);
        }
        path.close();
        this.f50341e.close();
        if (this.f50341e.isEmpty()) {
            return;
        }
        path.op(this.f50341e, Path.Op.UNION);
    }

    /* renamed from: f */
    public final void m64112f(int i10, RectF rectF, PointF pointF) {
        if (i10 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i10 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i10 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    /* renamed from: g */
    public final InterfaceC10422c m64113g(int i10, C10432m c10432m) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? c10432m.m64064t() : c10432m.m64062r() : c10432m.m64055j() : c10432m.m64057l();
    }

    /* renamed from: h */
    public final C10423d m64114h(int i10, C10432m c10432m) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? c10432m.m64063s() : c10432m.m64061q() : c10432m.m64054i() : c10432m.m64056k();
    }

    /* renamed from: i */
    public final float m64115i(RectF rectF, int i10) {
        float[] fArr = this.f50344h;
        C10434o c10434o = this.f50337a[i10];
        fArr[0] = c10434o.f50357c;
        fArr[1] = c10434o.f50358d;
        this.f50338b[i10].mapPoints(fArr);
        return (i10 == 1 || i10 == 3) ? Math.abs(rectF.centerX() - this.f50344h[0]) : Math.abs(rectF.centerY() - this.f50344h[1]);
    }

    /* renamed from: j */
    public final C10425f m64116j(int i10, C10432m c10432m) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? c10432m.m64059o() : c10432m.m64060p() : c10432m.m64058n() : c10432m.m64053h();
    }

    /* renamed from: l */
    public final boolean m64117l(Path path, int i10) {
        this.f50347k.reset();
        this.f50337a[i10].m64123d(this.f50338b[i10], this.f50347k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f50347k.computeBounds(rectF, true);
        path.op(this.f50347k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    /* renamed from: m */
    public final void m64118m(c cVar, int i10) {
        m64114h(i10, cVar.f50350a).m63968b(this.f50337a[i10], 90.0f, cVar.f50354e, cVar.f50352c, m64113g(i10, cVar.f50350a));
        float fM64107a = m64107a(i10);
        this.f50338b[i10].reset();
        m64112f(i10, cVar.f50352c, this.f50340d);
        Matrix matrix = this.f50338b[i10];
        PointF pointF = this.f50340d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f50338b[i10].preRotate(fM64107a);
    }

    /* renamed from: n */
    public final void m64119n(int i10) {
        this.f50344h[0] = this.f50337a[i10].m64128i();
        this.f50344h[1] = this.f50337a[i10].m64129j();
        this.f50338b[i10].mapPoints(this.f50344h);
        float fM64107a = m64107a(i10);
        this.f50339c[i10].reset();
        Matrix matrix = this.f50339c[i10];
        float[] fArr = this.f50344h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f50339c[i10].preRotate(fM64107a);
    }
}
