package p479n;

import java.util.Arrays;
import p479n.C11572b;

/* renamed from: n.j */
/* loaded from: classes.dex */
public class C11580j implements C11572b.a {

    /* renamed from: n */
    public static float f53721n = 0.001f;

    /* renamed from: a */
    public final int f53722a = -1;

    /* renamed from: b */
    public int f53723b = 16;

    /* renamed from: c */
    public int f53724c = 16;

    /* renamed from: d */
    public int[] f53725d = new int[16];

    /* renamed from: e */
    public int[] f53726e = new int[16];

    /* renamed from: f */
    public int[] f53727f = new int[16];

    /* renamed from: g */
    public float[] f53728g = new float[16];

    /* renamed from: h */
    public int[] f53729h = new int[16];

    /* renamed from: i */
    public int[] f53730i = new int[16];

    /* renamed from: j */
    public int f53731j = 0;

    /* renamed from: k */
    public int f53732k = -1;

    /* renamed from: l */
    public final C11572b f53733l;

    /* renamed from: m */
    public final C11573c f53734m;

    public C11580j(C11572b c11572b, C11573c c11573c) {
        this.f53733l = c11572b;
        this.f53734m = c11573c;
        clear();
    }

    @Override // p479n.C11572b.a
    /* renamed from: a */
    public void mo69044a(C11579i c11579i, float f10, boolean z10) {
        float f11 = f53721n;
        if (f10 <= (-f11) || f10 >= f11) {
            int iM69141p = m69141p(c11579i);
            if (iM69141p == -1) {
                mo69046c(c11579i, f10);
                return;
            }
            float[] fArr = this.f53728g;
            float f12 = fArr[iM69141p] + f10;
            fArr[iM69141p] = f12;
            float f13 = f53721n;
            if (f12 <= (-f13) || f12 >= f13) {
                return;
            }
            fArr[iM69141p] = 0.0f;
            mo69054k(c11579i, z10);
        }
    }

    @Override // p479n.C11572b.a
    /* renamed from: b */
    public float mo69045b(C11572b c11572b, boolean z10) {
        float fMo69048e = mo69048e(c11572b.f53650a);
        mo69054k(c11572b.f53650a, z10);
        C11580j c11580j = (C11580j) c11572b.f53654e;
        int iMo69047d = c11580j.mo69047d();
        int i10 = 0;
        int i11 = 0;
        while (i10 < iMo69047d) {
            int i12 = c11580j.f53727f[i11];
            if (i12 != -1) {
                mo69044a(this.f53734m.f53659d[i12], c11580j.f53728g[i11] * fMo69048e, z10);
                i10++;
            }
            i11++;
        }
        return fMo69048e;
    }

    @Override // p479n.C11572b.a
    /* renamed from: c */
    public void mo69046c(C11579i c11579i, float f10) {
        float f11 = f53721n;
        if (f10 > (-f11) && f10 < f11) {
            mo69054k(c11579i, true);
            return;
        }
        if (this.f53731j == 0) {
            m69138m(0, c11579i, f10);
            m69137l(c11579i, 0);
            this.f53732k = 0;
            return;
        }
        int iM69141p = m69141p(c11579i);
        if (iM69141p != -1) {
            this.f53728g[iM69141p] = f10;
            return;
        }
        if (this.f53731j + 1 >= this.f53723b) {
            m69140o();
        }
        int i10 = this.f53731j;
        int i11 = this.f53732k;
        int i12 = -1;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = this.f53727f[i11];
            int i15 = c11579i.f53700c;
            if (i14 == i15) {
                this.f53728g[i11] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i11;
            }
            i11 = this.f53730i[i11];
            if (i11 == -1) {
                break;
            }
        }
        m69142q(i12, c11579i, f10);
    }

    @Override // p479n.C11572b.a
    public void clear() {
        int i10 = this.f53731j;
        for (int i11 = 0; i11 < i10; i11++) {
            C11579i c11579iMo69049f = mo69049f(i11);
            if (c11579iMo69049f != null) {
                c11579iMo69049f.m69131f(this.f53733l);
            }
        }
        for (int i12 = 0; i12 < this.f53723b; i12++) {
            this.f53727f[i12] = -1;
            this.f53726e[i12] = -1;
        }
        for (int i13 = 0; i13 < this.f53724c; i13++) {
            this.f53725d[i13] = -1;
        }
        this.f53731j = 0;
        this.f53732k = -1;
    }

    @Override // p479n.C11572b.a
    /* renamed from: d */
    public int mo69047d() {
        return this.f53731j;
    }

    @Override // p479n.C11572b.a
    /* renamed from: e */
    public float mo69048e(C11579i c11579i) {
        int iM69141p = m69141p(c11579i);
        if (iM69141p != -1) {
            return this.f53728g[iM69141p];
        }
        return 0.0f;
    }

    @Override // p479n.C11572b.a
    /* renamed from: f */
    public C11579i mo69049f(int i10) {
        int i11 = this.f53731j;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.f53732k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.f53734m.f53659d[this.f53727f[i12]];
            }
            i12 = this.f53730i[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // p479n.C11572b.a
    /* renamed from: g */
    public void mo69050g() {
        int i10 = this.f53731j;
        int i11 = this.f53732k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f53728g;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f53730i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // p479n.C11572b.a
    /* renamed from: h */
    public float mo69051h(int i10) {
        int i11 = this.f53731j;
        int i12 = this.f53732k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.f53728g[i12];
            }
            i12 = this.f53730i[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // p479n.C11572b.a
    /* renamed from: i */
    public boolean mo69052i(C11579i c11579i) {
        return m69141p(c11579i) != -1;
    }

    @Override // p479n.C11572b.a
    /* renamed from: j */
    public void mo69053j(float f10) {
        int i10 = this.f53731j;
        int i11 = this.f53732k;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f53728g;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.f53730i[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // p479n.C11572b.a
    /* renamed from: k */
    public float mo69054k(C11579i c11579i, boolean z10) {
        int iM69141p = m69141p(c11579i);
        if (iM69141p == -1) {
            return 0.0f;
        }
        m69143r(c11579i);
        float f10 = this.f53728g[iM69141p];
        if (this.f53732k == iM69141p) {
            this.f53732k = this.f53730i[iM69141p];
        }
        this.f53727f[iM69141p] = -1;
        int[] iArr = this.f53729h;
        int i10 = iArr[iM69141p];
        if (i10 != -1) {
            int[] iArr2 = this.f53730i;
            iArr2[i10] = iArr2[iM69141p];
        }
        int i11 = this.f53730i[iM69141p];
        if (i11 != -1) {
            iArr[i11] = iArr[iM69141p];
        }
        this.f53731j--;
        c11579i.f53710m--;
        if (z10) {
            c11579i.m69131f(this.f53733l);
        }
        return f10;
    }

    /* renamed from: l */
    public final void m69137l(C11579i c11579i, int i10) {
        int[] iArr;
        int i11 = c11579i.f53700c % this.f53724c;
        int[] iArr2 = this.f53725d;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.f53726e;
                int i13 = iArr[i12];
                if (i13 == -1) {
                    break;
                } else {
                    i12 = i13;
                }
            }
            iArr[i12] = i10;
        }
        this.f53726e[i10] = -1;
    }

    /* renamed from: m */
    public final void m69138m(int i10, C11579i c11579i, float f10) {
        this.f53727f[i10] = c11579i.f53700c;
        this.f53728g[i10] = f10;
        this.f53729h[i10] = -1;
        this.f53730i[i10] = -1;
        c11579i.m69129a(this.f53733l);
        c11579i.f53710m++;
        this.f53731j++;
    }

    /* renamed from: n */
    public final int m69139n() {
        for (int i10 = 0; i10 < this.f53723b; i10++) {
            if (this.f53727f[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: o */
    public final void m69140o() {
        int i10 = this.f53723b * 2;
        this.f53727f = Arrays.copyOf(this.f53727f, i10);
        this.f53728g = Arrays.copyOf(this.f53728g, i10);
        this.f53729h = Arrays.copyOf(this.f53729h, i10);
        this.f53730i = Arrays.copyOf(this.f53730i, i10);
        this.f53726e = Arrays.copyOf(this.f53726e, i10);
        for (int i11 = this.f53723b; i11 < i10; i11++) {
            this.f53727f[i11] = -1;
            this.f53726e[i11] = -1;
        }
        this.f53723b = i10;
    }

    /* renamed from: p */
    public int m69141p(C11579i c11579i) {
        if (this.f53731j != 0 && c11579i != null) {
            int i10 = c11579i.f53700c;
            int i11 = this.f53725d[i10 % this.f53724c];
            if (i11 == -1) {
                return -1;
            }
            if (this.f53727f[i11] == i10) {
                return i11;
            }
            do {
                i11 = this.f53726e[i11];
                if (i11 == -1) {
                    break;
                }
            } while (this.f53727f[i11] != i10);
            if (i11 != -1 && this.f53727f[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    /* renamed from: q */
    public final void m69142q(int i10, C11579i c11579i, float f10) {
        int iM69139n = m69139n();
        m69138m(iM69139n, c11579i, f10);
        if (i10 != -1) {
            this.f53729h[iM69139n] = i10;
            int[] iArr = this.f53730i;
            iArr[iM69139n] = iArr[i10];
            iArr[i10] = iM69139n;
        } else {
            this.f53729h[iM69139n] = -1;
            if (this.f53731j > 0) {
                this.f53730i[iM69139n] = this.f53732k;
                this.f53732k = iM69139n;
            } else {
                this.f53730i[iM69139n] = -1;
            }
        }
        int i11 = this.f53730i[iM69139n];
        if (i11 != -1) {
            this.f53729h[i11] = iM69139n;
        }
        m69137l(c11579i, iM69139n);
    }

    /* renamed from: r */
    public final void m69143r(C11579i c11579i) {
        int[] iArr;
        int i10;
        int i11 = c11579i.f53700c;
        int i12 = i11 % this.f53724c;
        int[] iArr2 = this.f53725d;
        int i13 = iArr2[i12];
        if (i13 == -1) {
            return;
        }
        if (this.f53727f[i13] == i11) {
            int[] iArr3 = this.f53726e;
            iArr2[i12] = iArr3[i13];
            iArr3[i13] = -1;
            return;
        }
        while (true) {
            iArr = this.f53726e;
            i10 = iArr[i13];
            if (i10 == -1 || this.f53727f[i10] == i11) {
                break;
            } else {
                i13 = i10;
            }
        }
        if (i10 == -1 || this.f53727f[i10] != i11) {
            return;
        }
        iArr[i13] = iArr[i10];
        iArr[i10] = -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i10 = this.f53731j;
        for (int i11 = 0; i11 < i10; i11++) {
            C11579i c11579iMo69049f = mo69049f(i11);
            if (c11579iMo69049f != null) {
                String str2 = str + c11579iMo69049f + " = " + mo69051h(i11) + " ";
                int iM69141p = m69141p(c11579iMo69049f);
                String str3 = str2 + "[p: ";
                String str4 = (this.f53729h[iM69141p] != -1 ? str3 + this.f53734m.f53659d[this.f53727f[this.f53729h[iM69141p]]] : str3 + "none") + ", n: ";
                str = (this.f53730i[iM69141p] != -1 ? str4 + this.f53734m.f53659d[this.f53727f[this.f53730i[iM69141p]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
