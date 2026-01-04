package p479n;

import java.util.Arrays;
import p479n.C11572b;

/* renamed from: n.a */
/* loaded from: classes.dex */
public class C11571a implements C11572b.a {

    /* renamed from: l */
    public static float f53638l = 0.001f;

    /* renamed from: b */
    public final C11572b f53640b;

    /* renamed from: c */
    public final C11573c f53641c;

    /* renamed from: a */
    public int f53639a = 0;

    /* renamed from: d */
    public int f53642d = 8;

    /* renamed from: e */
    public C11579i f53643e = null;

    /* renamed from: f */
    public int[] f53644f = new int[8];

    /* renamed from: g */
    public int[] f53645g = new int[8];

    /* renamed from: h */
    public float[] f53646h = new float[8];

    /* renamed from: i */
    public int f53647i = -1;

    /* renamed from: j */
    public int f53648j = -1;

    /* renamed from: k */
    public boolean f53649k = false;

    public C11571a(C11572b c11572b, C11573c c11573c) {
        this.f53640b = c11572b;
        this.f53641c = c11573c;
    }

    @Override // p479n.C11572b.a
    /* renamed from: a */
    public void mo69044a(C11579i c11579i, float f10, boolean z10) {
        float f11 = f53638l;
        if (f10 <= (-f11) || f10 >= f11) {
            int i10 = this.f53647i;
            if (i10 == -1) {
                this.f53647i = 0;
                this.f53646h[0] = f10;
                this.f53644f[0] = c11579i.f53700c;
                this.f53645g[0] = -1;
                c11579i.f53710m++;
                c11579i.m69129a(this.f53640b);
                this.f53639a++;
                if (this.f53649k) {
                    return;
                }
                int i11 = this.f53648j + 1;
                this.f53648j = i11;
                int[] iArr = this.f53644f;
                if (i11 >= iArr.length) {
                    this.f53649k = true;
                    this.f53648j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.f53639a; i13++) {
                int i14 = this.f53644f[i10];
                int i15 = c11579i.f53700c;
                if (i14 == i15) {
                    float[] fArr = this.f53646h;
                    float f12 = fArr[i10] + f10;
                    float f13 = f53638l;
                    if (f12 > (-f13) && f12 < f13) {
                        f12 = 0.0f;
                    }
                    fArr[i10] = f12;
                    if (f12 == 0.0f) {
                        if (i10 == this.f53647i) {
                            this.f53647i = this.f53645g[i10];
                        } else {
                            int[] iArr2 = this.f53645g;
                            iArr2[i12] = iArr2[i10];
                        }
                        if (z10) {
                            c11579i.m69131f(this.f53640b);
                        }
                        if (this.f53649k) {
                            this.f53648j = i10;
                        }
                        c11579i.f53710m--;
                        this.f53639a--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i12 = i10;
                }
                i10 = this.f53645g[i10];
            }
            int length = this.f53648j;
            int i16 = length + 1;
            if (this.f53649k) {
                int[] iArr3 = this.f53644f;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i16;
            }
            int[] iArr4 = this.f53644f;
            if (length >= iArr4.length && this.f53639a < iArr4.length) {
                int i17 = 0;
                while (true) {
                    int[] iArr5 = this.f53644f;
                    if (i17 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i17] == -1) {
                        length = i17;
                        break;
                    }
                    i17++;
                }
            }
            int[] iArr6 = this.f53644f;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i18 = this.f53642d * 2;
                this.f53642d = i18;
                this.f53649k = false;
                this.f53648j = length - 1;
                this.f53646h = Arrays.copyOf(this.f53646h, i18);
                this.f53644f = Arrays.copyOf(this.f53644f, this.f53642d);
                this.f53645g = Arrays.copyOf(this.f53645g, this.f53642d);
            }
            this.f53644f[length] = c11579i.f53700c;
            this.f53646h[length] = f10;
            if (i12 != -1) {
                int[] iArr7 = this.f53645g;
                iArr7[length] = iArr7[i12];
                iArr7[i12] = length;
            } else {
                this.f53645g[length] = this.f53647i;
                this.f53647i = length;
            }
            c11579i.f53710m++;
            c11579i.m69129a(this.f53640b);
            this.f53639a++;
            if (!this.f53649k) {
                this.f53648j++;
            }
            int i19 = this.f53648j;
            int[] iArr8 = this.f53644f;
            if (i19 >= iArr8.length) {
                this.f53649k = true;
                this.f53648j = iArr8.length - 1;
            }
        }
    }

    @Override // p479n.C11572b.a
    /* renamed from: b */
    public float mo69045b(C11572b c11572b, boolean z10) {
        float fMo69048e = mo69048e(c11572b.f53650a);
        mo69054k(c11572b.f53650a, z10);
        C11572b.a aVar = c11572b.f53654e;
        int iMo69047d = aVar.mo69047d();
        for (int i10 = 0; i10 < iMo69047d; i10++) {
            C11579i c11579iMo69049f = aVar.mo69049f(i10);
            mo69044a(c11579iMo69049f, aVar.mo69048e(c11579iMo69049f) * fMo69048e, z10);
        }
        return fMo69048e;
    }

    @Override // p479n.C11572b.a
    /* renamed from: c */
    public final void mo69046c(C11579i c11579i, float f10) {
        if (f10 == 0.0f) {
            mo69054k(c11579i, true);
            return;
        }
        int i10 = this.f53647i;
        if (i10 == -1) {
            this.f53647i = 0;
            this.f53646h[0] = f10;
            this.f53644f[0] = c11579i.f53700c;
            this.f53645g[0] = -1;
            c11579i.f53710m++;
            c11579i.m69129a(this.f53640b);
            this.f53639a++;
            if (this.f53649k) {
                return;
            }
            int i11 = this.f53648j + 1;
            this.f53648j = i11;
            int[] iArr = this.f53644f;
            if (i11 >= iArr.length) {
                this.f53649k = true;
                this.f53648j = iArr.length - 1;
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f53639a; i13++) {
            int i14 = this.f53644f[i10];
            int i15 = c11579i.f53700c;
            if (i14 == i15) {
                this.f53646h[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i12 = i10;
            }
            i10 = this.f53645g[i10];
        }
        int length = this.f53648j;
        int i16 = length + 1;
        if (this.f53649k) {
            int[] iArr2 = this.f53644f;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i16;
        }
        int[] iArr3 = this.f53644f;
        if (length >= iArr3.length && this.f53639a < iArr3.length) {
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.f53644f;
                if (i17 >= iArr4.length) {
                    break;
                }
                if (iArr4[i17] == -1) {
                    length = i17;
                    break;
                }
                i17++;
            }
        }
        int[] iArr5 = this.f53644f;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i18 = this.f53642d * 2;
            this.f53642d = i18;
            this.f53649k = false;
            this.f53648j = length - 1;
            this.f53646h = Arrays.copyOf(this.f53646h, i18);
            this.f53644f = Arrays.copyOf(this.f53644f, this.f53642d);
            this.f53645g = Arrays.copyOf(this.f53645g, this.f53642d);
        }
        this.f53644f[length] = c11579i.f53700c;
        this.f53646h[length] = f10;
        if (i12 != -1) {
            int[] iArr6 = this.f53645g;
            iArr6[length] = iArr6[i12];
            iArr6[i12] = length;
        } else {
            this.f53645g[length] = this.f53647i;
            this.f53647i = length;
        }
        c11579i.f53710m++;
        c11579i.m69129a(this.f53640b);
        int i19 = this.f53639a + 1;
        this.f53639a = i19;
        if (!this.f53649k) {
            this.f53648j++;
        }
        int[] iArr7 = this.f53644f;
        if (i19 >= iArr7.length) {
            this.f53649k = true;
        }
        if (this.f53648j >= iArr7.length) {
            this.f53649k = true;
            this.f53648j = iArr7.length - 1;
        }
    }

    @Override // p479n.C11572b.a
    public final void clear() {
        int i10 = this.f53647i;
        for (int i11 = 0; i10 != -1 && i11 < this.f53639a; i11++) {
            C11579i c11579i = this.f53641c.f53659d[this.f53644f[i10]];
            if (c11579i != null) {
                c11579i.m69131f(this.f53640b);
            }
            i10 = this.f53645g[i10];
        }
        this.f53647i = -1;
        this.f53648j = -1;
        this.f53649k = false;
        this.f53639a = 0;
    }

    @Override // p479n.C11572b.a
    /* renamed from: d */
    public int mo69047d() {
        return this.f53639a;
    }

    @Override // p479n.C11572b.a
    /* renamed from: e */
    public final float mo69048e(C11579i c11579i) {
        int i10 = this.f53647i;
        for (int i11 = 0; i10 != -1 && i11 < this.f53639a; i11++) {
            if (this.f53644f[i10] == c11579i.f53700c) {
                return this.f53646h[i10];
            }
            i10 = this.f53645g[i10];
        }
        return 0.0f;
    }

    @Override // p479n.C11572b.a
    /* renamed from: f */
    public C11579i mo69049f(int i10) {
        int i11 = this.f53647i;
        for (int i12 = 0; i11 != -1 && i12 < this.f53639a; i12++) {
            if (i12 == i10) {
                return this.f53641c.f53659d[this.f53644f[i11]];
            }
            i11 = this.f53645g[i11];
        }
        return null;
    }

    @Override // p479n.C11572b.a
    /* renamed from: g */
    public void mo69050g() {
        int i10 = this.f53647i;
        for (int i11 = 0; i10 != -1 && i11 < this.f53639a; i11++) {
            float[] fArr = this.f53646h;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f53645g[i10];
        }
    }

    @Override // p479n.C11572b.a
    /* renamed from: h */
    public float mo69051h(int i10) {
        int i11 = this.f53647i;
        for (int i12 = 0; i11 != -1 && i12 < this.f53639a; i12++) {
            if (i12 == i10) {
                return this.f53646h[i11];
            }
            i11 = this.f53645g[i11];
        }
        return 0.0f;
    }

    @Override // p479n.C11572b.a
    /* renamed from: i */
    public boolean mo69052i(C11579i c11579i) {
        int i10 = this.f53647i;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f53639a; i11++) {
            if (this.f53644f[i10] == c11579i.f53700c) {
                return true;
            }
            i10 = this.f53645g[i10];
        }
        return false;
    }

    @Override // p479n.C11572b.a
    /* renamed from: j */
    public void mo69053j(float f10) {
        int i10 = this.f53647i;
        for (int i11 = 0; i10 != -1 && i11 < this.f53639a; i11++) {
            float[] fArr = this.f53646h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f53645g[i10];
        }
    }

    @Override // p479n.C11572b.a
    /* renamed from: k */
    public final float mo69054k(C11579i c11579i, boolean z10) {
        if (this.f53643e == c11579i) {
            this.f53643e = null;
        }
        int i10 = this.f53647i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f53639a) {
            if (this.f53644f[i10] == c11579i.f53700c) {
                if (i10 == this.f53647i) {
                    this.f53647i = this.f53645g[i10];
                } else {
                    int[] iArr = this.f53645g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    c11579i.m69131f(this.f53640b);
                }
                c11579i.f53710m--;
                this.f53639a--;
                this.f53644f[i10] = -1;
                if (this.f53649k) {
                    this.f53648j = i10;
                }
                return this.f53646h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f53645g[i10];
        }
        return 0.0f;
    }

    public String toString() {
        int i10 = this.f53647i;
        String str = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f53639a; i11++) {
            str = ((str + " -> ") + this.f53646h[i10] + " : ") + this.f53641c.f53659d[this.f53644f[i10]];
            i10 = this.f53645g[i10];
        }
        return str;
    }
}
