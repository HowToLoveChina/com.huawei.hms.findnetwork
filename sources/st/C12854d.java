package st;

import java.util.Arrays;
import tt.C13069b;

/* renamed from: st.d */
/* loaded from: classes5.dex */
public class C12854d {

    /* renamed from: a */
    public int f58612a;

    /* renamed from: b */
    public int f58613b;

    /* renamed from: c */
    public final double[] f58614c;

    /* renamed from: d */
    public final double[] f58615d;

    /* renamed from: e */
    public final InterfaceC12858h f58616e;

    /* renamed from: f */
    public final double[] f58617f;

    public C12854d(InterfaceC12858h interfaceC12858h, double[] dArr, double[] dArr2, double[] dArr3, C12851a<C12852b> c12851a) {
        if (interfaceC12858h == null || dArr == null || dArr2 == null) {
            throw new C13069b("LocalLeastSquaresProblem input error", new Object[0]);
        }
        this.f58616e = interfaceC12858h;
        this.f58615d = dArr;
        this.f58617f = dArr2;
        if (dArr3 != null) {
            this.f58614c = m77180a(dArr3);
            return;
        }
        double[] dArr4 = new double[dArr.length];
        this.f58614c = dArr4;
        Arrays.fill(dArr4, 1.0d);
    }

    /* renamed from: a */
    public final double[] m77180a(double[] dArr) {
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr2[i10] = Math.sqrt(dArr[i10]);
        }
        return dArr2;
    }

    /* renamed from: b */
    public C12852b m77181b(double[] dArr) {
        if (dArr == null) {
            throw new C13069b("LocalLeastSquaresProblem evaluate error", new Object[0]);
        }
        double[] dArr2 = (double[]) dArr.clone();
        C12857g c12857gMo74525a = this.f58616e.mo74525a(dArr2);
        return new C12852b(c12857gMo74525a.m77193b(), c12857gMo74525a.m77192a(), this.f58615d, dArr2, this.f58614c);
    }

    /* renamed from: c */
    public C12851a<C12852b> m77182c() {
        return null;
    }

    /* renamed from: d */
    public int m77183d() {
        return this.f58612a;
    }

    /* renamed from: e */
    public int m77184e() {
        return this.f58613b;
    }

    /* renamed from: f */
    public int m77185f() {
        return this.f58615d.length;
    }

    /* renamed from: g */
    public int m77186g() {
        return this.f58617f.length;
    }

    /* renamed from: h */
    public double[] m77187h() {
        double[] dArr = this.f58617f;
        return dArr == null ? new double[0] : (double[]) dArr.clone();
    }

    /* renamed from: i */
    public void m77188i(int i10) {
        this.f58612a = i10;
    }

    /* renamed from: j */
    public void m77189j(int i10) {
        this.f58613b = i10;
    }
}
