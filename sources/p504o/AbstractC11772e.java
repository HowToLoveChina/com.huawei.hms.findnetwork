package p504o;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: o.e */
/* loaded from: classes.dex */
public abstract class AbstractC11772e {

    /* renamed from: a */
    public AbstractC11769b f54401a;

    /* renamed from: b */
    public b f54402b;

    /* renamed from: c */
    public String f54403c;

    /* renamed from: d */
    public int f54404d = 0;

    /* renamed from: e */
    public String f54405e = null;

    /* renamed from: f */
    public int f54406f = 0;

    /* renamed from: g */
    public ArrayList<c> f54407g = new ArrayList<>();

    /* renamed from: o.e$a */
    public class a implements Comparator<c> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            return Integer.compare(cVar.f54425a, cVar2.f54425a);
        }
    }

    /* renamed from: o.e$b */
    public static class b {

        /* renamed from: a */
        public final int f54409a;

        /* renamed from: b */
        public C11775h f54410b;

        /* renamed from: c */
        public final int f54411c;

        /* renamed from: d */
        public final int f54412d;

        /* renamed from: e */
        public final int f54413e;

        /* renamed from: f */
        public float[] f54414f;

        /* renamed from: g */
        public double[] f54415g;

        /* renamed from: h */
        public float[] f54416h;

        /* renamed from: i */
        public float[] f54417i;

        /* renamed from: j */
        public float[] f54418j;

        /* renamed from: k */
        public float[] f54419k;

        /* renamed from: l */
        public int f54420l;

        /* renamed from: m */
        public AbstractC11769b f54421m;

        /* renamed from: n */
        public double[] f54422n;

        /* renamed from: o */
        public double[] f54423o;

        /* renamed from: p */
        public float f54424p;

        public b(int i10, String str, int i11, int i12) {
            C11775h c11775h = new C11775h();
            this.f54410b = c11775h;
            this.f54411c = 0;
            this.f54412d = 1;
            this.f54413e = 2;
            this.f54420l = i10;
            this.f54409a = i11;
            c11775h.m70146g(i10, str);
            this.f54414f = new float[i12];
            this.f54415g = new double[i12];
            this.f54416h = new float[i12];
            this.f54417i = new float[i12];
            this.f54418j = new float[i12];
            this.f54419k = new float[i12];
        }

        /* renamed from: a */
        public double m70132a(float f10) {
            AbstractC11769b abstractC11769b = this.f54421m;
            if (abstractC11769b != null) {
                double d10 = f10;
                abstractC11769b.mo70101g(d10, this.f54423o);
                this.f54421m.mo70098d(d10, this.f54422n);
            } else {
                double[] dArr = this.f54423o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d11 = f10;
            double dM70144e = this.f54410b.m70144e(d11, this.f54422n[1]);
            double dM70143d = this.f54410b.m70143d(d11, this.f54422n[1], this.f54423o[1]);
            double[] dArr2 = this.f54423o;
            return dArr2[0] + (dM70144e * dArr2[2]) + (dM70143d * this.f54422n[2]);
        }

        /* renamed from: b */
        public double m70133b(float f10) {
            AbstractC11769b abstractC11769b = this.f54421m;
            if (abstractC11769b != null) {
                abstractC11769b.mo70098d(f10, this.f54422n);
            } else {
                double[] dArr = this.f54422n;
                dArr[0] = this.f54417i[0];
                dArr[1] = this.f54418j[0];
                dArr[2] = this.f54414f[0];
            }
            double[] dArr2 = this.f54422n;
            return dArr2[0] + (this.f54410b.m70144e(f10, dArr2[1]) * this.f54422n[2]);
        }

        /* renamed from: c */
        public void m70134c(int i10, int i11, float f10, float f11, float f12, float f13) {
            this.f54415g[i10] = i11 / 100.0d;
            this.f54416h[i10] = f10;
            this.f54417i[i10] = f11;
            this.f54418j[i10] = f12;
            this.f54414f[i10] = f13;
        }

        /* renamed from: d */
        public void m70135d(float f10) {
            this.f54424p = f10;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.f54415g.length, 3);
            float[] fArr = this.f54414f;
            this.f54422n = new double[fArr.length + 2];
            this.f54423o = new double[fArr.length + 2];
            if (this.f54415g[0] > 0.0d) {
                this.f54410b.m70140a(0.0d, this.f54416h[0]);
            }
            double[] dArr2 = this.f54415g;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f54410b.m70140a(1.0d, this.f54416h[length]);
            }
            for (int i10 = 0; i10 < dArr.length; i10++) {
                double[] dArr3 = dArr[i10];
                dArr3[0] = this.f54417i[i10];
                dArr3[1] = this.f54418j[i10];
                dArr3[2] = this.f54414f[i10];
                this.f54410b.m70140a(this.f54415g[i10], this.f54416h[i10]);
            }
            this.f54410b.m70145f();
            double[] dArr4 = this.f54415g;
            if (dArr4.length > 1) {
                this.f54421m = AbstractC11769b.m70114a(0, dArr4, dArr);
            } else {
                this.f54421m = null;
            }
        }
    }

    /* renamed from: o.e$c */
    public static class c {

        /* renamed from: a */
        public int f54425a;

        /* renamed from: b */
        public float f54426b;

        /* renamed from: c */
        public float f54427c;

        /* renamed from: d */
        public float f54428d;

        /* renamed from: e */
        public float f54429e;

        public c(int i10, float f10, float f11, float f12, float f13) {
            this.f54425a = i10;
            this.f54426b = f13;
            this.f54427c = f11;
            this.f54428d = f10;
            this.f54429e = f12;
        }
    }

    /* renamed from: a */
    public float m70123a(float f10) {
        return (float) this.f54402b.m70133b(f10);
    }

    /* renamed from: b */
    public float m70124b(float f10) {
        return (float) this.f54402b.m70132a(f10);
    }

    /* renamed from: c */
    public void mo70125c(Object obj) {
    }

    /* renamed from: d */
    public void m70126d(int i10, int i11, String str, int i12, float f10, float f11, float f12, float f13) {
        this.f54407g.add(new c(i10, f10, f11, f12, f13));
        if (i12 != -1) {
            this.f54406f = i12;
        }
        this.f54404d = i11;
        this.f54405e = str;
    }

    /* renamed from: e */
    public void m70127e(int i10, int i11, String str, int i12, float f10, float f11, float f12, float f13, Object obj) {
        this.f54407g.add(new c(i10, f10, f11, f12, f13));
        if (i12 != -1) {
            this.f54406f = i12;
        }
        this.f54404d = i11;
        mo70125c(obj);
        this.f54405e = str;
    }

    /* renamed from: f */
    public void m70128f(String str) {
        this.f54403c = str;
    }

    /* renamed from: g */
    public void m70129g(float f10) {
        int size = this.f54407g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f54407g, new a());
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.f54402b = new b(this.f54404d, this.f54405e, this.f54406f, size);
        Iterator<c> it = this.f54407g.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            c next = it.next();
            float f11 = next.f54428d;
            dArr[i10] = f11 * 0.01d;
            double[] dArr3 = dArr2[i10];
            float f12 = next.f54426b;
            dArr3[0] = f12;
            float f13 = next.f54427c;
            dArr3[1] = f13;
            float f14 = next.f54429e;
            dArr3[2] = f14;
            this.f54402b.m70134c(i10, next.f54425a, f11, f13, f14, f12);
            i10++;
        }
        this.f54402b.m70135d(f10);
        this.f54401a = AbstractC11769b.m70114a(0, dArr, dArr2);
    }

    /* renamed from: h */
    public boolean m70130h() {
        return this.f54406f == 1;
    }

    public String toString() {
        String str = this.f54403c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<c> it = this.f54407g.iterator();
        while (it.hasNext()) {
            str = str + "[" + it.next().f54425a + " , " + decimalFormat.format(r2.f54426b) + "] ";
        }
        return str;
    }
}
