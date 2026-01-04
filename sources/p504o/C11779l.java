package p504o;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/* renamed from: o.l */
/* loaded from: classes.dex */
public class C11779l extends C11770c {

    /* renamed from: d */
    public C11774g f54466d;

    public C11779l(String str) {
        this.f54393a = str;
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i10 = 0;
        while (iIndexOf2 != -1) {
            dArr[i10] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i10++;
        }
        dArr[i10] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        this.f54466d = m70161d(Arrays.copyOf(dArr, i10 + 1));
    }

    /* renamed from: d */
    public static C11774g m70161d(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d10 = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            double d11 = dArr[i10];
            int i11 = i10 + length2;
            dArr2[i11][0] = d11;
            double d12 = i10 * d10;
            dArr3[i11] = d12;
            if (i10 > 0) {
                int i12 = (length2 * 2) + i10;
                dArr2[i12][0] = d11 + 1.0d;
                dArr3[i12] = d12 + 1.0d;
                int i13 = i10 - 1;
                dArr2[i13][0] = (d11 - 1.0d) - d10;
                dArr3[i13] = (d12 - 1.0d) - d10;
            }
        }
        C11774g c11774g = new C11774g(dArr3, dArr2);
        PrintStream printStream = System.out;
        printStream.println(" 0 " + c11774g.mo70097c(0.0d, 0));
        printStream.println(" 1 " + c11774g.mo70097c(1.0d, 0));
        return c11774g;
    }

    @Override // p504o.C11770c
    /* renamed from: a */
    public double mo70117a(double d10) {
        return this.f54466d.mo70097c(d10, 0);
    }

    @Override // p504o.C11770c
    /* renamed from: b */
    public double mo70118b(double d10) {
        return this.f54466d.mo70100f(d10, 0);
    }
}
