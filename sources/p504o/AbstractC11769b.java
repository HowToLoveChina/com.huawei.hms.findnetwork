package p504o;

/* renamed from: o.b */
/* loaded from: classes.dex */
public abstract class AbstractC11769b {

    /* renamed from: o.b$a */
    public static class a extends AbstractC11769b {

        /* renamed from: a */
        public double f54389a;

        /* renamed from: b */
        public double[] f54390b;

        public a(double d10, double[] dArr) {
            this.f54389a = d10;
            this.f54390b = dArr;
        }

        @Override // p504o.AbstractC11769b
        /* renamed from: c */
        public double mo70097c(double d10, int i10) {
            return this.f54390b[i10];
        }

        @Override // p504o.AbstractC11769b
        /* renamed from: d */
        public void mo70098d(double d10, double[] dArr) {
            double[] dArr2 = this.f54390b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // p504o.AbstractC11769b
        /* renamed from: e */
        public void mo70099e(double d10, float[] fArr) {
            int i10 = 0;
            while (true) {
                double[] dArr = this.f54390b;
                if (i10 >= dArr.length) {
                    return;
                }
                fArr[i10] = (float) dArr[i10];
                i10++;
            }
        }

        @Override // p504o.AbstractC11769b
        /* renamed from: f */
        public double mo70100f(double d10, int i10) {
            return 0.0d;
        }

        @Override // p504o.AbstractC11769b
        /* renamed from: g */
        public void mo70101g(double d10, double[] dArr) {
            for (int i10 = 0; i10 < this.f54390b.length; i10++) {
                dArr[i10] = 0.0d;
            }
        }

        @Override // p504o.AbstractC11769b
        /* renamed from: h */
        public double[] mo70102h() {
            return new double[]{this.f54389a};
        }
    }

    /* renamed from: a */
    public static AbstractC11769b m70114a(int i10, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i10 = 2;
        }
        return i10 != 0 ? i10 != 2 ? new C11773f(dArr, dArr2) : new a(dArr[0], dArr2[0]) : new C11774g(dArr, dArr2);
    }

    /* renamed from: b */
    public static AbstractC11769b m70115b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new C11768a(iArr, dArr, dArr2);
    }

    /* renamed from: c */
    public abstract double mo70097c(double d10, int i10);

    /* renamed from: d */
    public abstract void mo70098d(double d10, double[] dArr);

    /* renamed from: e */
    public abstract void mo70099e(double d10, float[] fArr);

    /* renamed from: f */
    public abstract double mo70100f(double d10, int i10);

    /* renamed from: g */
    public abstract void mo70101g(double d10, double[] dArr);

    /* renamed from: h */
    public abstract double[] mo70102h();
}
