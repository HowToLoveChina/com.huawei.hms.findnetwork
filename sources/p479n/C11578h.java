package p479n;

import java.util.Arrays;
import java.util.Comparator;
import p479n.C11572b;

/* renamed from: n.h */
/* loaded from: classes.dex */
public class C11578h extends C11572b {

    /* renamed from: g */
    public int f53687g;

    /* renamed from: h */
    public C11579i[] f53688h;

    /* renamed from: i */
    public C11579i[] f53689i;

    /* renamed from: j */
    public int f53690j;

    /* renamed from: k */
    public b f53691k;

    /* renamed from: l */
    public C11573c f53692l;

    /* renamed from: n.h$a */
    public class a implements Comparator<C11579i> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C11579i c11579i, C11579i c11579i2) {
            return c11579i.f53700c - c11579i2.f53700c;
        }
    }

    /* renamed from: n.h$b */
    public class b {

        /* renamed from: a */
        public C11579i f53694a;

        /* renamed from: b */
        public C11578h f53695b;

        public b(C11578h c11578h) {
            this.f53695b = c11578h;
        }

        /* renamed from: a */
        public boolean m69123a(C11579i c11579i, float f10) {
            boolean z10 = true;
            if (!this.f53694a.f53698a) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float f11 = c11579i.f53706i[i10];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f10;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        this.f53694a.f53706i[i10] = f12;
                    } else {
                        this.f53694a.f53706i[i10] = 0.0f;
                    }
                }
                return true;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float[] fArr = this.f53694a.f53706i;
                float f13 = fArr[i11] + (c11579i.f53706i[i11] * f10);
                fArr[i11] = f13;
                if (Math.abs(f13) < 1.0E-4f) {
                    this.f53694a.f53706i[i11] = 0.0f;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                C11578h.this.m69121G(this.f53694a);
            }
            return false;
        }

        /* renamed from: b */
        public void m69124b(C11579i c11579i) {
            this.f53694a = c11579i;
        }

        /* renamed from: c */
        public final boolean m69125c() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f53694a.f53706i[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: d */
        public final boolean m69126d(C11579i c11579i) {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = c11579i.f53706i[i10];
                float f11 = this.f53694a.f53706i[i10];
                if (f11 != f10) {
                    return f11 < f10;
                }
            }
            return false;
        }

        /* renamed from: e */
        public void m69127e() {
            Arrays.fill(this.f53694a.f53706i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f53694a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f53694a.f53706i[i10] + " ";
                }
            }
            return str + "] " + this.f53694a;
        }
    }

    public C11578h(C11573c c11573c) {
        super(c11573c);
        this.f53687g = 128;
        this.f53688h = new C11579i[128];
        this.f53689i = new C11579i[128];
        this.f53690j = 0;
        this.f53691k = new b(this);
        this.f53692l = c11573c;
    }

    @Override // p479n.C11572b
    /* renamed from: B */
    public void mo69056B(C11574d c11574d, C11572b c11572b, boolean z10) {
        C11579i c11579i = c11572b.f53650a;
        if (c11579i == null) {
            return;
        }
        C11572b.a aVar = c11572b.f53654e;
        int iMo69047d = aVar.mo69047d();
        for (int i10 = 0; i10 < iMo69047d; i10++) {
            C11579i c11579iMo69049f = aVar.mo69049f(i10);
            float fMo69051h = aVar.mo69051h(i10);
            this.f53691k.m69124b(c11579iMo69049f);
            if (this.f53691k.m69123a(c11579i, fMo69051h)) {
                m69120F(c11579iMo69049f);
            }
            this.f53651b += c11572b.f53651b * fMo69051h;
        }
        m69121G(c11579i);
    }

    /* renamed from: F */
    public final void m69120F(C11579i c11579i) {
        int i10;
        int i11 = this.f53690j + 1;
        C11579i[] c11579iArr = this.f53688h;
        if (i11 > c11579iArr.length) {
            C11579i[] c11579iArr2 = (C11579i[]) Arrays.copyOf(c11579iArr, c11579iArr.length * 2);
            this.f53688h = c11579iArr2;
            this.f53689i = (C11579i[]) Arrays.copyOf(c11579iArr2, c11579iArr2.length * 2);
        }
        C11579i[] c11579iArr3 = this.f53688h;
        int i12 = this.f53690j;
        c11579iArr3[i12] = c11579i;
        int i13 = i12 + 1;
        this.f53690j = i13;
        if (i13 > 1 && c11579iArr3[i12].f53700c > c11579i.f53700c) {
            int i14 = 0;
            while (true) {
                i10 = this.f53690j;
                if (i14 >= i10) {
                    break;
                }
                this.f53689i[i14] = this.f53688h[i14];
                i14++;
            }
            Arrays.sort(this.f53689i, 0, i10, new a());
            for (int i15 = 0; i15 < this.f53690j; i15++) {
                this.f53688h[i15] = this.f53689i[i15];
            }
        }
        c11579i.f53698a = true;
        c11579i.m69129a(this);
    }

    /* renamed from: G */
    public final void m69121G(C11579i c11579i) {
        int i10 = 0;
        while (i10 < this.f53690j) {
            if (this.f53688h[i10] == c11579i) {
                while (true) {
                    int i11 = this.f53690j;
                    if (i10 >= i11 - 1) {
                        this.f53690j = i11 - 1;
                        c11579i.f53698a = false;
                        return;
                    } else {
                        C11579i[] c11579iArr = this.f53688h;
                        int i12 = i10 + 1;
                        c11579iArr[i10] = c11579iArr[i12];
                        i10 = i12;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    @Override // p479n.C11572b, p479n.C11574d.a
    /* renamed from: a */
    public void mo69059a(C11579i c11579i) {
        this.f53691k.m69124b(c11579i);
        this.f53691k.m69127e();
        c11579i.f53706i[c11579i.f53702e] = 1.0f;
        m69120F(c11579i);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // p479n.C11572b, p479n.C11574d.a
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p479n.C11579i mo69060b(p479n.C11574d r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = r5
        L3:
            int r2 = r4.f53690j
            if (r0 >= r2) goto L32
            n.i[] r2 = r4.f53688h
            r2 = r2[r0]
            int r3 = r2.f53700c
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2f
        L12:
            n.h$b r3 = r4.f53691k
            r3.m69124b(r2)
            if (r1 != r5) goto L22
            n.h$b r2 = r4.f53691k
            boolean r2 = r2.m69125c()
            if (r2 == 0) goto L2f
            goto L2e
        L22:
            n.h$b r2 = r4.f53691k
            n.i[] r3 = r4.f53688h
            r3 = r3[r1]
            boolean r2 = r2.m69126d(r3)
            if (r2 == 0) goto L2f
        L2e:
            r1 = r0
        L2f:
            int r0 = r0 + 1
            goto L3
        L32:
            if (r1 != r5) goto L36
            r4 = 0
            return r4
        L36:
            n.i[] r4 = r4.f53688h
            r4 = r4[r1]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p479n.C11578h.mo69060b(n.d, boolean[]):n.i");
    }

    @Override // p479n.C11572b, p479n.C11574d.a
    public void clear() {
        this.f53690j = 0;
        this.f53651b = 0.0f;
    }

    @Override // p479n.C11572b, p479n.C11574d.a
    public boolean isEmpty() {
        return this.f53690j == 0;
    }

    @Override // p479n.C11572b
    public String toString() {
        String str = " goal -> (" + this.f53651b + ") : ";
        for (int i10 = 0; i10 < this.f53690j; i10++) {
            this.f53691k.m69124b(this.f53688h[i10]);
            str = str + this.f53691k + " ";
        }
        return str;
    }
}
