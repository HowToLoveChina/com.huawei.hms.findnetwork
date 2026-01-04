package p504o;

import java.util.Arrays;

/* renamed from: o.a */
/* loaded from: classes.dex */
public class C11768a extends AbstractC11769b {

    /* renamed from: a */
    public final double[] f54367a;

    /* renamed from: b */
    public a[] f54368b;

    /* renamed from: c */
    public boolean f54369c = true;

    /* renamed from: o.a$a */
    public static class a {

        /* renamed from: s */
        public static double[] f54370s = new double[91];

        /* renamed from: a */
        public double[] f54371a;

        /* renamed from: b */
        public double f54372b;

        /* renamed from: c */
        public double f54373c;

        /* renamed from: d */
        public double f54374d;

        /* renamed from: e */
        public double f54375e;

        /* renamed from: f */
        public double f54376f;

        /* renamed from: g */
        public double f54377g;

        /* renamed from: h */
        public double f54378h;

        /* renamed from: i */
        public double f54379i;

        /* renamed from: j */
        public double f54380j;

        /* renamed from: k */
        public double f54381k;

        /* renamed from: l */
        public double f54382l;

        /* renamed from: m */
        public double f54383m;

        /* renamed from: n */
        public double f54384n;

        /* renamed from: o */
        public double f54385o;

        /* renamed from: p */
        public double f54386p;

        /* renamed from: q */
        public boolean f54387q;

        /* renamed from: r */
        public boolean f54388r;

        public a(int i10, double d10, double d11, double d12, double d13, double d14, double d15) {
            this.f54388r = false;
            double d16 = d14 - d12;
            double d17 = d15 - d13;
            if (i10 == 1) {
                this.f54387q = true;
            } else if (i10 == 4) {
                this.f54387q = d17 > 0.0d;
            } else if (i10 != 5) {
                this.f54387q = false;
            } else {
                this.f54387q = d17 < 0.0d;
            }
            this.f54373c = d10;
            this.f54374d = d11;
            this.f54379i = 1.0d / (d11 - d10);
            if (3 == i10) {
                this.f54388r = true;
            }
            if (!this.f54388r && Math.abs(d16) >= 0.001d && Math.abs(d17) >= 0.001d) {
                this.f54371a = new double[101];
                boolean z10 = this.f54387q;
                this.f54380j = d16 * (z10 ? -1 : 1);
                this.f54381k = d17 * (z10 ? 1 : -1);
                this.f54382l = z10 ? d14 : d12;
                this.f54383m = z10 ? d13 : d15;
                m70103a(d12, d13, d14, d15);
                this.f54384n = this.f54372b * this.f54379i;
                return;
            }
            this.f54388r = true;
            this.f54375e = d12;
            this.f54376f = d14;
            this.f54377g = d13;
            this.f54378h = d15;
            double dHypot = Math.hypot(d17, d16);
            this.f54372b = dHypot;
            this.f54384n = dHypot * this.f54379i;
            double d18 = this.f54374d;
            double d19 = this.f54373c;
            this.f54382l = d16 / (d18 - d19);
            this.f54383m = d17 / (d18 - d19);
        }

        /* renamed from: a */
        public final void m70103a(double d10, double d11, double d12, double d13) {
            double dHypot;
            double d14 = d12 - d10;
            double d15 = d11 - d13;
            int i10 = 0;
            double d16 = 0.0d;
            double d17 = 0.0d;
            double d18 = 0.0d;
            while (true) {
                if (i10 >= f54370s.length) {
                    break;
                }
                double d19 = d16;
                double radians = Math.toRadians((i10 * 90.0d) / (r15.length - 1));
                double dSin = Math.sin(radians) * d14;
                double dCos = Math.cos(radians) * d15;
                if (i10 > 0) {
                    dHypot = Math.hypot(dSin - d17, dCos - d18) + d19;
                    f54370s[i10] = dHypot;
                } else {
                    dHypot = d19;
                }
                i10++;
                d18 = dCos;
                d16 = dHypot;
                d17 = dSin;
            }
            double d20 = d16;
            this.f54372b = d20;
            int i11 = 0;
            while (true) {
                double[] dArr = f54370s;
                if (i11 >= dArr.length) {
                    break;
                }
                dArr[i11] = dArr[i11] / d20;
                i11++;
            }
            int i12 = 0;
            while (true) {
                if (i12 >= this.f54371a.length) {
                    return;
                }
                double length = i12 / (r1.length - 1);
                int iBinarySearch = Arrays.binarySearch(f54370s, length);
                if (iBinarySearch >= 0) {
                    this.f54371a[i12] = iBinarySearch / (f54370s.length - 1);
                } else if (iBinarySearch == -1) {
                    this.f54371a[i12] = 0.0d;
                } else {
                    int i13 = -iBinarySearch;
                    int i14 = i13 - 2;
                    double[] dArr2 = f54370s;
                    double d21 = dArr2[i14];
                    this.f54371a[i12] = (i14 + ((length - d21) / (dArr2[i13 - 1] - d21))) / (dArr2.length - 1);
                }
                i12++;
            }
        }

        /* renamed from: b */
        public double m70104b() {
            double d10 = this.f54380j * this.f54386p;
            double dHypot = this.f54384n / Math.hypot(d10, (-this.f54381k) * this.f54385o);
            if (this.f54387q) {
                d10 = -d10;
            }
            return d10 * dHypot;
        }

        /* renamed from: c */
        public double m70105c() {
            double d10 = this.f54380j * this.f54386p;
            double d11 = (-this.f54381k) * this.f54385o;
            double dHypot = this.f54384n / Math.hypot(d10, d11);
            return this.f54387q ? (-d11) * dHypot : d11 * dHypot;
        }

        /* renamed from: d */
        public double m70106d(double d10) {
            return this.f54382l;
        }

        /* renamed from: e */
        public double m70107e(double d10) {
            return this.f54383m;
        }

        /* renamed from: f */
        public double m70108f(double d10) {
            double d11 = (d10 - this.f54373c) * this.f54379i;
            double d12 = this.f54375e;
            return d12 + (d11 * (this.f54376f - d12));
        }

        /* renamed from: g */
        public double m70109g(double d10) {
            double d11 = (d10 - this.f54373c) * this.f54379i;
            double d12 = this.f54377g;
            return d12 + (d11 * (this.f54378h - d12));
        }

        /* renamed from: h */
        public double m70110h() {
            return this.f54382l + (this.f54380j * this.f54385o);
        }

        /* renamed from: i */
        public double m70111i() {
            return this.f54383m + (this.f54381k * this.f54386p);
        }

        /* renamed from: j */
        public double m70112j(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f54371a;
            double length = d10 * (dArr.length - 1);
            int i10 = (int) length;
            double d11 = length - i10;
            double d12 = dArr[i10];
            return d12 + (d11 * (dArr[i10 + 1] - d12));
        }

        /* renamed from: k */
        public void m70113k(double d10) {
            double dM70112j = m70112j((this.f54387q ? this.f54374d - d10 : d10 - this.f54373c) * this.f54379i) * 1.5707963267948966d;
            this.f54385o = Math.sin(dM70112j);
            this.f54386p = Math.cos(dM70112j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e A[PHI: r9
  0x002e: PHI (r9v1 int) = (r9v0 int), (r9v3 int), (r9v4 int) binds: [B:6:0x001e, B:12:0x0028, B:14:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C11768a(int[] r25, double[] r26, double[][] r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r24.<init>()
            r2 = 1
            r0.f54369c = r2
            r0.f54367a = r1
            int r3 = r1.length
            int r3 = r3 - r2
            o.a$a[] r3 = new p504o.C11768a.a[r3]
            r0.f54368b = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L16:
            o.a$a[] r7 = r0.f54368b
            int r8 = r7.length
            if (r4 >= r8) goto L58
            r8 = r25[r4]
            r9 = 3
            if (r8 == 0) goto L2e
            if (r8 == r2) goto L37
            r10 = 2
            if (r8 == r10) goto L35
            if (r8 == r9) goto L30
            r9 = 4
            if (r8 == r9) goto L2e
            r9 = 5
            if (r8 == r9) goto L2e
            goto L39
        L2e:
            r6 = r9
            goto L39
        L30:
            if (r5 != r2) goto L37
            goto L35
        L33:
            r6 = r5
            goto L39
        L35:
            r5 = r10
            goto L33
        L37:
            r5 = r2
            goto L33
        L39:
            o.a$a r22 = new o.a$a
            r10 = r1[r4]
            int r23 = r4 + 1
            r12 = r1[r23]
            r8 = r27[r4]
            r14 = r8[r3]
            r16 = r8[r2]
            r8 = r27[r23]
            r18 = r8[r3]
            r20 = r8[r2]
            r8 = r22
            r9 = r6
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r22
            r4 = r23
            goto L16
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p504o.C11768a.<init>(int[], double[], double[][]):void");
    }

    @Override // p504o.AbstractC11769b
    /* renamed from: c */
    public double mo70097c(double d10, int i10) {
        double dM70109g;
        double dM70107e;
        double dM70111i;
        double dM70105c;
        double dM70109g2;
        double dM70107e2;
        int i11 = 0;
        if (this.f54369c) {
            a[] aVarArr = this.f54368b;
            a aVar = aVarArr[0];
            double d11 = aVar.f54373c;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (aVar.f54388r) {
                    if (i10 == 0) {
                        dM70109g2 = aVar.m70108f(d11);
                        dM70107e2 = this.f54368b[0].m70106d(d11);
                    } else {
                        dM70109g2 = aVar.m70109g(d11);
                        dM70107e2 = this.f54368b[0].m70107e(d11);
                    }
                    return dM70109g2 + (d12 * dM70107e2);
                }
                aVar.m70113k(d11);
                if (i10 == 0) {
                    dM70111i = this.f54368b[0].m70110h();
                    dM70105c = this.f54368b[0].m70104b();
                } else {
                    dM70111i = this.f54368b[0].m70111i();
                    dM70105c = this.f54368b[0].m70105c();
                }
                return dM70111i + (d12 * dM70105c);
            }
            if (d10 > aVarArr[aVarArr.length - 1].f54374d) {
                double d13 = aVarArr[aVarArr.length - 1].f54374d;
                double d14 = d10 - d13;
                int length = aVarArr.length - 1;
                if (i10 == 0) {
                    dM70109g = aVarArr[length].m70108f(d13);
                    dM70107e = this.f54368b[length].m70106d(d13);
                } else {
                    dM70109g = aVarArr[length].m70109g(d13);
                    dM70107e = this.f54368b[length].m70107e(d13);
                }
                return dM70109g + (d14 * dM70107e);
            }
        } else {
            a[] aVarArr2 = this.f54368b;
            double d15 = aVarArr2[0].f54373c;
            if (d10 < d15) {
                d10 = d15;
            } else if (d10 > aVarArr2[aVarArr2.length - 1].f54374d) {
                d10 = aVarArr2[aVarArr2.length - 1].f54374d;
            }
        }
        while (true) {
            a[] aVarArr3 = this.f54368b;
            if (i11 >= aVarArr3.length) {
                return Double.NaN;
            }
            a aVar2 = aVarArr3[i11];
            if (d10 <= aVar2.f54374d) {
                if (aVar2.f54388r) {
                    return i10 == 0 ? aVar2.m70108f(d10) : aVar2.m70109g(d10);
                }
                aVar2.m70113k(d10);
                return i10 == 0 ? this.f54368b[i11].m70110h() : this.f54368b[i11].m70111i();
            }
            i11++;
        }
    }

    @Override // p504o.AbstractC11769b
    /* renamed from: d */
    public void mo70098d(double d10, double[] dArr) {
        if (this.f54369c) {
            a[] aVarArr = this.f54368b;
            a aVar = aVarArr[0];
            double d11 = aVar.f54373c;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (aVar.f54388r) {
                    dArr[0] = aVar.m70108f(d11) + (this.f54368b[0].m70106d(d11) * d12);
                    dArr[1] = this.f54368b[0].m70109g(d11) + (d12 * this.f54368b[0].m70107e(d11));
                    return;
                } else {
                    aVar.m70113k(d11);
                    dArr[0] = this.f54368b[0].m70110h() + (this.f54368b[0].m70104b() * d12);
                    dArr[1] = this.f54368b[0].m70111i() + (d12 * this.f54368b[0].m70105c());
                    return;
                }
            }
            if (d10 > aVarArr[aVarArr.length - 1].f54374d) {
                double d13 = aVarArr[aVarArr.length - 1].f54374d;
                double d14 = d10 - d13;
                int length = aVarArr.length - 1;
                a aVar2 = aVarArr[length];
                if (aVar2.f54388r) {
                    dArr[0] = aVar2.m70108f(d13) + (this.f54368b[length].m70106d(d13) * d14);
                    dArr[1] = this.f54368b[length].m70109g(d13) + (d14 * this.f54368b[length].m70107e(d13));
                    return;
                } else {
                    aVar2.m70113k(d10);
                    dArr[0] = this.f54368b[length].m70110h() + (this.f54368b[length].m70104b() * d14);
                    dArr[1] = this.f54368b[length].m70111i() + (d14 * this.f54368b[length].m70105c());
                    return;
                }
            }
        } else {
            a[] aVarArr2 = this.f54368b;
            double d15 = aVarArr2[0].f54373c;
            if (d10 < d15) {
                d10 = d15;
            }
            if (d10 > aVarArr2[aVarArr2.length - 1].f54374d) {
                d10 = aVarArr2[aVarArr2.length - 1].f54374d;
            }
        }
        int i10 = 0;
        while (true) {
            a[] aVarArr3 = this.f54368b;
            if (i10 >= aVarArr3.length) {
                return;
            }
            a aVar3 = aVarArr3[i10];
            if (d10 <= aVar3.f54374d) {
                if (aVar3.f54388r) {
                    dArr[0] = aVar3.m70108f(d10);
                    dArr[1] = this.f54368b[i10].m70109g(d10);
                    return;
                } else {
                    aVar3.m70113k(d10);
                    dArr[0] = this.f54368b[i10].m70110h();
                    dArr[1] = this.f54368b[i10].m70111i();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // p504o.AbstractC11769b
    /* renamed from: e */
    public void mo70099e(double d10, float[] fArr) {
        if (this.f54369c) {
            a[] aVarArr = this.f54368b;
            a aVar = aVarArr[0];
            double d11 = aVar.f54373c;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (aVar.f54388r) {
                    fArr[0] = (float) (aVar.m70108f(d11) + (this.f54368b[0].m70106d(d11) * d12));
                    fArr[1] = (float) (this.f54368b[0].m70109g(d11) + (d12 * this.f54368b[0].m70107e(d11)));
                    return;
                } else {
                    aVar.m70113k(d11);
                    fArr[0] = (float) (this.f54368b[0].m70110h() + (this.f54368b[0].m70104b() * d12));
                    fArr[1] = (float) (this.f54368b[0].m70111i() + (d12 * this.f54368b[0].m70105c()));
                    return;
                }
            }
            if (d10 > aVarArr[aVarArr.length - 1].f54374d) {
                double d13 = aVarArr[aVarArr.length - 1].f54374d;
                double d14 = d10 - d13;
                int length = aVarArr.length - 1;
                a aVar2 = aVarArr[length];
                if (aVar2.f54388r) {
                    fArr[0] = (float) (aVar2.m70108f(d13) + (this.f54368b[length].m70106d(d13) * d14));
                    fArr[1] = (float) (this.f54368b[length].m70109g(d13) + (d14 * this.f54368b[length].m70107e(d13)));
                    return;
                } else {
                    aVar2.m70113k(d10);
                    fArr[0] = (float) this.f54368b[length].m70110h();
                    fArr[1] = (float) this.f54368b[length].m70111i();
                    return;
                }
            }
        } else {
            a[] aVarArr2 = this.f54368b;
            double d15 = aVarArr2[0].f54373c;
            if (d10 < d15) {
                d10 = d15;
            } else if (d10 > aVarArr2[aVarArr2.length - 1].f54374d) {
                d10 = aVarArr2[aVarArr2.length - 1].f54374d;
            }
        }
        int i10 = 0;
        while (true) {
            a[] aVarArr3 = this.f54368b;
            if (i10 >= aVarArr3.length) {
                return;
            }
            a aVar3 = aVarArr3[i10];
            if (d10 <= aVar3.f54374d) {
                if (aVar3.f54388r) {
                    fArr[0] = (float) aVar3.m70108f(d10);
                    fArr[1] = (float) this.f54368b[i10].m70109g(d10);
                    return;
                } else {
                    aVar3.m70113k(d10);
                    fArr[0] = (float) this.f54368b[i10].m70110h();
                    fArr[1] = (float) this.f54368b[i10].m70111i();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // p504o.AbstractC11769b
    /* renamed from: f */
    public double mo70100f(double d10, int i10) {
        a[] aVarArr = this.f54368b;
        int i11 = 0;
        double d11 = aVarArr[0].f54373c;
        if (d10 < d11) {
            d10 = d11;
        }
        if (d10 > aVarArr[aVarArr.length - 1].f54374d) {
            d10 = aVarArr[aVarArr.length - 1].f54374d;
        }
        while (true) {
            a[] aVarArr2 = this.f54368b;
            if (i11 >= aVarArr2.length) {
                return Double.NaN;
            }
            a aVar = aVarArr2[i11];
            if (d10 <= aVar.f54374d) {
                if (aVar.f54388r) {
                    return i10 == 0 ? aVar.m70106d(d10) : aVar.m70107e(d10);
                }
                aVar.m70113k(d10);
                return i10 == 0 ? this.f54368b[i11].m70104b() : this.f54368b[i11].m70105c();
            }
            i11++;
        }
    }

    @Override // p504o.AbstractC11769b
    /* renamed from: g */
    public void mo70101g(double d10, double[] dArr) {
        a[] aVarArr = this.f54368b;
        double d11 = aVarArr[0].f54373c;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > aVarArr[aVarArr.length - 1].f54374d) {
            d10 = aVarArr[aVarArr.length - 1].f54374d;
        }
        int i10 = 0;
        while (true) {
            a[] aVarArr2 = this.f54368b;
            if (i10 >= aVarArr2.length) {
                return;
            }
            a aVar = aVarArr2[i10];
            if (d10 <= aVar.f54374d) {
                if (aVar.f54388r) {
                    dArr[0] = aVar.m70106d(d10);
                    dArr[1] = this.f54368b[i10].m70107e(d10);
                    return;
                } else {
                    aVar.m70113k(d10);
                    dArr[0] = this.f54368b[i10].m70104b();
                    dArr[1] = this.f54368b[i10].m70105c();
                    return;
                }
            }
            i10++;
        }
    }

    @Override // p504o.AbstractC11769b
    /* renamed from: h */
    public double[] mo70102h() {
        return this.f54367a;
    }
}
