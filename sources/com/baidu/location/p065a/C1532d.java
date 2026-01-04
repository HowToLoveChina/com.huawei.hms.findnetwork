package com.baidu.location.p065a;

import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.baidu.location.a.d */
/* loaded from: classes.dex */
public class C1532d {

    /* renamed from: a */
    private static C1532d f6618a;

    /* renamed from: b */
    private static final double[][] f6619b;

    /* renamed from: c */
    private LinkedList<b> f6620c;

    /* renamed from: com.baidu.location.a.d$a */
    public class a {

        /* renamed from: a */
        double f6621a;

        /* renamed from: b */
        double f6622b;

        public a(double d10, double d11) {
            this.f6621a = d10;
            this.f6622b = d11;
        }
    }

    /* renamed from: com.baidu.location.a.d$b */
    public class b {

        /* renamed from: a */
        a f6624a;

        /* renamed from: b */
        a f6625b;

        public b(a aVar, a aVar2) {
            this.f6624a = aVar;
            this.f6625b = aVar2;
        }

        /* renamed from: a */
        public double m8705a(a aVar) {
            C1532d c1532d = C1532d.this;
            a aVar2 = this.f6625b;
            double d10 = aVar2.f6621a;
            a aVar3 = this.f6624a;
            a aVar4 = c1532d.new a(d10 - aVar3.f6621a, aVar2.f6622b - aVar3.f6622b);
            C1532d c1532d2 = C1532d.this;
            double d11 = aVar.f6621a;
            a aVar5 = this.f6624a;
            a aVar6 = c1532d2.new a(d11 - aVar5.f6621a, aVar.f6622b - aVar5.f6622b);
            return (aVar4.f6621a * aVar6.f6622b) - (aVar4.f6622b * aVar6.f6621a);
        }

        /* renamed from: b */
        public boolean m8706b(a aVar) {
            return C1532d.this.m8703a(m8705a(aVar)) == 0 && aVar.f6621a < Math.max(this.f6624a.f6621a, this.f6625b.f6621a) + 1.0E-8d && aVar.f6621a > Math.min(this.f6624a.f6621a, this.f6625b.f6621a) - 1.0E-8d && aVar.f6622b < Math.max(this.f6624a.f6622b, this.f6625b.f6622b) + 1.0E-8d && aVar.f6622b > Math.min(this.f6624a.f6622b, this.f6625b.f6622b) - 1.0E-8d;
        }
    }

    static {
        double[] dArr = new double[2];
        // fill-array-data instruction
        dArr[0] = 98.44114544032976d;
        dArr[1] = 27.28076394915907d;
        f6619b = new double[][]{new double[]{120.0618433387417d, 52.99310228080341d}, new double[]{114.4030602114635d, 47.79652316426919d}, new double[]{119.3643163114595d, 47.0727538006688d}, new double[]{111.7970645774334d, 45.24511711870672d}, new double[]{104.9683464256928d, 41.86250415619769d}, new double[]{97.59908065334047d, 43.22977087596662d}, new double[]{90.17261155579693d, 47.84045461669d}, new double[]{87.0887631003547d, 49.35214107249469d}, new double[]{83.03712288618132d, 47.19159646925913d}, new double[]{72.99264485060895d, 39.20573694893438d}, new double[]{78.45303593116243d, 31.72421462055291d}, new double[]{85.9177987174293d, 27.93063907621388d}, new double[]{92.09912961486889d, 27.71669293109786d}, new double[]{95.27333193620382d, 28.98784762533811d}, dArr, new double[]{97.50681546607404d, 24.71427385929992d}, new double[]{97.52260341956044d, 23.71326829445317d}, new double[]{100.0708944887605d, 21.1767365339876d}, new double[]{101.9206763604854d, 21.13303015980818d}, new double[]{105.2746400703396d, 23.11902125989214d}, new double[]{107.2643282303716d, 21.45413888071461d}, new double[]{108.3761342632019d, 17.31459516935326d}, new double[]{113.0483020881062d, 16.81442875978696d}, new double[]{122.2284167146931d, 21.66374045582697d}, new double[]{123.9556508773411d, 35.66412873804383d}, new double[]{124.2746994608336d, 39.77355430531934d}, new double[]{130.842836734007d, 42.33514430285174d}, new double[]{132.9368688827846d, 44.59499883995769d}, new double[]{135.3461562047301d, 48.60080399436555d}, new double[]{131.7265723825281d, 48.00330291274656d}, new double[]{124.4850194031389d, 54.244770450984d}, new double[]{120.0618433387417d, 52.99310228080341d}};
    }

    private C1532d() {
        this.f6620c = null;
        double[][] dArr = f6619b;
        int length = dArr.length;
        C1534f.m8725c("isinchina line size = " + dArr.length);
        this.f6620c = new LinkedList<>();
        int i10 = 0;
        while (i10 < length - 1) {
            LinkedList<b> linkedList = this.f6620c;
            double[][] dArr2 = f6619b;
            double[] dArr3 = dArr2[i10];
            a aVar = new a(dArr3[0] * 100000.0d, dArr3[1] * 100000.0d);
            i10++;
            double[] dArr4 = dArr2[i10];
            linkedList.add(new b(aVar, new a(dArr4[0] * 100000.0d, dArr4[1] * 100000.0d)));
        }
    }

    /* renamed from: a */
    public int m8703a(double d10) {
        if (d10 < -1.0E-8d) {
            return -1;
        }
        return d10 > 1.0E-8d ? 1 : 0;
    }

    /* renamed from: a */
    public static C1532d m8702a() {
        if (f6618a == null) {
            f6618a = new C1532d();
        }
        return f6618a;
    }

    /* renamed from: a */
    public boolean m8704a(double d10, double d11) {
        try {
            a aVar = new a(d10 * 100000.0d, d11 * 100000.0d);
            Iterator<b> it = this.f6620c.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                b next = it.next();
                if (next.m8706b(aVar)) {
                    return true;
                }
                int iM8703a = m8703a(next.m8705a(aVar));
                int iM8703a2 = m8703a(next.f6624a.f6622b - aVar.f6622b);
                int iM8703a3 = m8703a(next.f6625b.f6622b - aVar.f6622b);
                if (iM8703a > 0 && iM8703a2 <= 0 && iM8703a3 > 0) {
                    i10++;
                }
                if (iM8703a < 0 && iM8703a3 <= 0 && iM8703a2 > 0) {
                    i10--;
                }
            }
            z = i10 != 0;
            C1534f.m8725c("isinchina num = " + i10);
        } catch (Exception e10) {
            if (C1534f.f6655a) {
                e10.printStackTrace();
            }
        }
        return z;
    }
}
