package cn.com.miaozhen.mobile.tracking.viewability.origin.p060f;

import com.huawei.openalliance.p169ad.constant.Constants;
import ijiami_release01.NCall;
import java.util.List;

/* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.f.a */
/* loaded from: classes.dex */
public class C1510a {

    /* renamed from: d */
    private int f6476d;

    /* renamed from: e */
    private int f6477e;

    /* renamed from: a */
    private b f6473a = new b(310);

    /* renamed from: b */
    private c[] f6474b = new c[310];

    /* renamed from: c */
    private d[] f6475c = new d[310];

    /* renamed from: f */
    private double[] f6478f = new double[310];

    /* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.f.a$b */
    public class b {

        /* renamed from: a */
        a[] f6479a;

        /* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.f.a$b$a */
        public class a {

            /* renamed from: a */
            int f6481a;

            /* renamed from: b */
            int f6482b;

            /* renamed from: c */
            int f6483c;

            /* renamed from: d */
            double f6484d;

            public a() {
            }

            /* renamed from: a */
            public double m8599a() {
                return NCall.m64612ID(new Object[]{272, this});
            }

            /* renamed from: b */
            public int m8601b() {
                return NCall.m64614II(new Object[]{274, this});
            }

            /* renamed from: a */
            public void m8600a(int i10, int i11) {
                NCall.m64618IV(new Object[]{273, this, Integer.valueOf(i10), Integer.valueOf(i11)});
            }
        }

        public b(int i10) {
            int i11 = i10 * 3;
            this.f6479a = new a[i11];
            for (int i12 = 1; i12 < i11; i12++) {
                this.f6479a[i12] = new a();
            }
        }

        /* renamed from: a */
        public void m8596a(int i10) {
            NCall.m64618IV(new Object[]{268, this, Integer.valueOf(i10)});
        }

        /* renamed from: a */
        public void m8597a(int i10, int i11, int i12) {
            NCall.m64618IV(new Object[]{269, this, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)});
        }

        /* renamed from: a */
        public void m8598a(int i10, int i11, int i12, int i13) {
            NCall.m64618IV(new Object[]{Integer.valueOf(Constants.INTERSTITIAL_WIDTH), this, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
        }
    }

    /* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.f.a$c */
    public class c implements Comparable<c> {

        /* renamed from: a */
        int f6486a;

        /* renamed from: b */
        int f6487b;

        /* renamed from: c */
        int f6488c;

        /* renamed from: d */
        double f6489d;

        private c() {
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return NCall.m64614II(new Object[]{271, this, cVar});
        }
    }

    /* renamed from: cn.com.miaozhen.mobile.tracking.viewability.origin.f.a$d */
    public class d implements Comparable<d> {

        /* renamed from: a */
        int f6491a;

        /* renamed from: b */
        double f6492b;

        private d() {
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return NCall.m64614II(new Object[]{275, this, dVar});
        }
    }

    public C1510a() {
        for (int i10 = 0; i10 <= 300; i10 += 2) {
            this.f6474b[i10] = new c();
            int i11 = i10 + 1;
            this.f6474b[i11] = new c();
            this.f6475c[i10] = new d();
            this.f6475c[i11] = new d();
        }
    }

    /* renamed from: b */
    private void m8594b(List<C1511b> list) {
        NCall.m64618IV(new Object[]{277, this, list});
    }

    /* renamed from: a */
    public double m8595a(List<C1511b> list) {
        return NCall.m64612ID(new Object[]{278, this, list});
    }

    /* renamed from: a */
    private void m8592a() {
        NCall.m64618IV(new Object[]{276, this});
    }
}
