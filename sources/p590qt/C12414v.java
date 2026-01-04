package p590qt;

import java.lang.reflect.Array;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;
import lt.InterfaceC11341a;
import mt.C11518e;
import mt.C11522i;
import p499nt.C11747a;
import p533ot.C12026a;
import p533ot.C12032g;
import p533ot.InterfaceC12031f;
import p689ut.C13248a;
import p689ut.C13252e;
import pt.C12212b;
import st.C12853c;
import st.C12854d;
import st.C12856f;
import st.C12857g;
import st.InterfaceC12858h;
import tt.C13069b;

/* renamed from: qt.v */
/* loaded from: classes5.dex */
public class C12414v implements InterfaceC11341a {

    /* renamed from: b */
    public double[] f57238b;

    /* renamed from: c */
    public List<C11518e> f57239c;

    /* renamed from: d */
    public boolean f57240d = true;

    /* renamed from: a */
    public final InterfaceC12031f f57237a = new C12032g();

    /* renamed from: e */
    public static double m74529e(double[] dArr, double[] dArr2) {
        if (dArr.length == 0 || dArr.length != dArr2.length) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "getWeightedAvg input illegal");
            return 0.0d;
        }
        double d10 = 0.0d;
        double d11 = 0.0d;
        for (int i10 = 0; i10 < dArr2.length; i10++) {
            double d12 = dArr[i10];
            double d13 = dArr2[i10];
            d11 += d12 * d13;
            d10 += d13;
        }
        if (d10 >= 1.0E-4d) {
            return d11 / d10;
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "sum of weight less than 0.0001");
        return 0.0d;
    }

    /* renamed from: f */
    public static long m74530f(long[] jArr) {
        if (jArr.length == 0) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "timeStamp has no data");
            return 0L;
        }
        long jMax = jArr[0];
        for (long j10 : jArr) {
            jMax = Math.max(jMax, j10);
        }
        return jMax;
    }

    /* renamed from: i */
    public static /* synthetic */ C12857g m74531i(double[][] dArr, double[] dArr2) {
        double[] dArr3 = new double[dArr.length];
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArr.length, 2);
        for (int i10 = 0; i10 < dArr.length; i10++) {
            double dM74532k = m74532k(dArr[i10], dArr2);
            dArr3[i10] = dM74532k;
            if (dM74532k <= 1.0E-5d) {
                double[] dArr5 = dArr4[i10];
                dArr5[0] = 1.0d;
                dArr5[1] = 1.0d;
            } else {
                double[] dArr6 = dArr4[i10];
                double d10 = dArr2[0];
                double[] dArr7 = dArr[i10];
                dArr6[0] = (d10 - dArr7[0]) / dM74532k;
                dArr6[1] = (dArr2[1] - dArr7[1]) / dM74532k;
            }
        }
        return new C12857g(dArr3, dArr4);
    }

    /* renamed from: k */
    public static double m74532k(double[] dArr, double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d));
    }

    /* renamed from: l */
    public static double[] m74533l(double[][] dArr) {
        double d10 = 0.0d;
        double d11 = 0.0d;
        for (double[] dArr2 : dArr) {
            d10 += dArr2[0];
            d11 += dArr2[1];
        }
        return dArr.length == 0 ? new double[2] : new double[]{d10 / dArr.length, d11 / dArr.length};
    }

    /* renamed from: m */
    public static double m74534m(double[][] dArr) {
        double[] dArrM74533l = m74533l(dArr);
        double dM74532k = 0.0d;
        for (double[] dArr2 : dArr) {
            dM74532k += m74532k(dArr2, dArrM74533l);
        }
        if (dArr.length == 0) {
            return 0.0d;
        }
        return Math.sqrt(dM74532k / dArr.length);
    }

    /* renamed from: o */
    public static /* synthetic */ boolean m74535o(C11522i c11522i, C11518e c11518e) {
        return Math.sqrt(C12026a.m72158c(c11518e, c11522i)) < 200.0d;
    }

    /* renamed from: q */
    public static double[][] m74536q(double[][] dArr) {
        int length = dArr.length;
        if (length == 0) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "transpose input row = 0");
            return (double[][]) Array.newInstance((Class<?>) Double.TYPE, 0, 0);
        }
        int length2 = dArr[0].length;
        if (length2 == 0) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "transpose input col = 0");
            return (double[][]) Array.newInstance((Class<?>) Double.TYPE, 0, 0);
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length2, length);
        for (int i10 = 0; i10 < length; i10++) {
            for (int i11 = 0; i11 < length2; i11++) {
                dArr2[i11][i10] = dArr[i10][i11];
            }
        }
        return dArr2;
    }

    /* renamed from: u */
    public static C11522i m74537u(C11518e c11518e) {
        double dM68750j = c11518e.m68734n().m68750j();
        double dM68747g = c11518e.m68734n().m68747g();
        long jM68739b = c11518e.m68730j().m68739b();
        C11522i c11522i = new C11522i(dM68750j, dM68747g, jM68739b, c11518e.m68731k(), c11518e.m68734n().m68741a());
        c11522i.m68785u(jM68739b);
        c11522i.m68777m(C13248a.f59940l);
        return c11522i;
    }

    /* renamed from: v */
    public static /* synthetic */ long m74538v(C11518e c11518e) {
        return c11518e.m68730j().m68739b();
    }

    @Override // lt.InterfaceC11341a
    /* renamed from: a */
    public C11522i mo68138a(InterfaceC11341a.a aVar, List<C11518e> list) throws C13069b {
        if (aVar == null) {
            return new C11522i(C13248a.f59938j);
        }
        C12410r.m74523d().m74524e(aVar);
        if (list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos is null or empty");
            return new C11522i(C13248a.f59932d);
        }
        C11518e.m68727t(list);
        m74548x(list);
        double[] dArrM74544r = m74544r(list);
        C12393a.m74479e(list, dArrM74544r);
        if (this.f57240d) {
            C13252e.m79641h(list);
        }
        C11522i c11522iM74542n = m74542n(list, m74537u(list.get(list.size() - 1)));
        C12393a.m74477c(list, dArrM74544r);
        C12393a.m74478d(c11522iM74542n, dArrM74544r);
        if (c11522iM74542n.m68766b() != C13248a.f59931c && c11522iM74542n.m68766b() != C13248a.f59939k) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "Algorithm failed.");
            return c11522iM74542n;
        }
        C11518e.m68727t(list);
        C12407o.m74513w(c11522iM74542n, list);
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", c11522iM74542n.m68775k());
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Location Aggregation Using Algorithm 1 (LM|AVG)");
        return c11522iM74542n;
    }

    /* renamed from: g */
    public final C11522i m74539g(double[] dArr, double[] dArr2, double[] dArr3, long[] jArr, InterfaceC12858h interfaceC12858h) {
        C12854d c12854d = new C12854d(interfaceC12858h, dArr, new double[]{0.0d, 0.0d}, dArr3, null);
        c12854d.m77188i(1000);
        c12854d.m77189j(1000);
        try {
            C12856f c12856fMo77166a = new C12853c().mo77166a(c12854d);
            double[] dArrM77190a = c12856fMo77166a.m77190a();
            double dM74529e = m74529e(dArr2, dArr3);
            return new C11522i(dArrM77190a[0], dArrM77190a[1], m74530f(jArr), m74529e(dArr3, dArr3), (float) (dM74529e + c12856fMo77166a.m77191b()));
        } catch (C13069b unused) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "TooManyEvaluationsException");
            return new C11522i(C13248a.f59936h);
        }
    }

    /* renamed from: h */
    public final C11522i m74540h(double[][] dArr, double[] dArr2, double[] dArr3, long[] jArr) {
        double[][] dArrM74536q = m74536q(dArr);
        double dM74529e = m74529e(dArrM74536q[0], dArr3);
        double dM74529e2 = m74529e(dArrM74536q[1], dArr3);
        double dM74529e3 = m74529e(dArr2, dArr3);
        return new C11522i(dM74529e, dM74529e2, m74530f(jArr), m74529e(dArr3, dArr3), (float) dM74529e3);
    }

    /* renamed from: j */
    public InterfaceC12858h m74541j(final double[][] dArr) {
        return new InterfaceC12858h() { // from class: qt.s
            @Override // st.InterfaceC12858h
            /* renamed from: a */
            public final C12857g mo74525a(double[] dArr2) {
                return C12414v.m74531i(dArr, dArr2);
            }
        };
    }

    /* renamed from: n */
    public final C11522i m74542n(List<C11518e> list, C11522i c11522i) throws C13069b {
        if (list.size() > 5000) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos size exceed limit");
            return c11522i.m68778n(C13248a.f59933e);
        }
        m74547w(list);
        if (!m74545s(list)) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "calculate confidence error");
            return c11522i.m68778n(C13248a.f59937i);
        }
        C13252e c13252e = new C13252e(list.size());
        List<C11518e> listM73385d = C12212b.m73385d(list, c13252e);
        this.f57239c = listM73385d;
        if (listM73385d.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "filteredInfos is empty");
            return c11522i.m68778n(C13248a.f59935g);
        }
        C11522i c11522iM74546t = m74546t(this.f57239c);
        if (C12409q.m74521e(list, this.f57239c, c11522iM74546t)) {
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Tag is moved");
            c11522i.m68773i().m68792g(true);
            c11522i.m68773i().m68791f(c13252e.m79644e());
            return c11522i.m68778n(C13248a.f59939k);
        }
        C11518e.m68727t(list);
        c11522iM74546t.m68785u(m74543p(list, c11522iM74546t));
        c11522iM74546t.m68773i().m68791f(c13252e.m79644e());
        return c11522iM74546t;
    }

    /* renamed from: p */
    public final long m74543p(List<C11518e> list, final C11522i c11522i) {
        return Math.max(list.stream().filter(new Predicate() { // from class: qt.t
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C12414v.m74535o(c11522i, (C11518e) obj);
            }
        }).mapToLong(new ToLongFunction() { // from class: qt.u
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return C12414v.m74538v((C11518e) obj);
            }
        }).max().orElse(0L), c11522i.m68774j());
    }

    /* renamed from: r */
    public final double[] m74544r(List<C11518e> list) {
        return new double[]{list.get(0).m68734n().m68750j(), list.get(0).m68734n().m68747g()};
    }

    /* renamed from: s */
    public final boolean m74545s(List<C11518e> list) {
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Calculating new confidence");
        C11747a c11747a = new C11747a();
        c11747a.m70064f(list);
        double dM70065g = 0.0d;
        for (int i10 = 0; i10 < list.size(); i10++) {
            list.get(i10).m68737q(c11747a.m70065g(i10));
            dM70065g += c11747a.m70065g(i10);
        }
        if (Double.compare(dM70065g, 0.0d) != 0) {
            return true;
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "All of new confidences are 0");
        return false;
    }

    /* renamed from: t */
    public final C11522i m74546t(List<C11518e> list) {
        C11522i c11522iM74540h;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, list.size(), 2);
        double[] dArr2 = new double[list.size()];
        double[] dArr3 = new double[list.size()];
        double[] dArr4 = new double[list.size()];
        long[] jArr = new long[list.size()];
        boolean z10 = false;
        for (int i10 = 0; i10 < list.size(); i10++) {
            C11518e c11518e = list.get(i10);
            dArr[i10][0] = c11518e.m68734n().m68750j();
            dArr[i10][1] = c11518e.m68734n().m68747g();
            dArr2[i10] = c11518e.m68734n().m68741a();
            dArr3[i10] = this.f57237a.mo72176a(c11518e.m68730j().m68738a());
            jArr[i10] = c11518e.m68730j().m68739b();
            double dM68735o = c11518e.m68735o();
            dArr4[i10] = dM68735o;
            dArr4[i10] = dM68735o * dM68735o;
            if (Double.compare(dArr3[i10], 0.0d) == 0) {
                z10 = true;
            }
        }
        this.f57238b = dArr4;
        if (list.size() <= 2 || m74534m(dArr) < 5.0d) {
            c11522iM74540h = m74540h(dArr, dArr2, dArr4, jArr);
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Using Weighted Avg Algorithm");
        } else {
            c11522iM74540h = m74539g(dArr3, dArr2, dArr4, jArr, m74541j(dArr));
            C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "Using Least Square Algorithm");
        }
        if (c11522iM74540h.m68766b() == C13248a.f59931c && z10) {
            C12410r.m74523d().mo57440b("ALG-PolarisTagPosition", "Rssi over limit");
            c11522iM74540h.m68777m(C13248a.f59934f);
        }
        return c11522iM74540h;
    }

    /* renamed from: w */
    public final void m74547w(List<C11518e> list) {
        for (C11518e c11518e : list) {
            if (c11518e.m68730j().m68738a() == 0) {
                c11518e.m68730j().m68740c(-100);
            }
        }
    }

    /* renamed from: x */
    public final void m74548x(List<C11518e> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            list.get(i10).m68736p(i10);
        }
    }
}
