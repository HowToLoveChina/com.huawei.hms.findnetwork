package com.huawei.android.brotli.dec;

/* renamed from: com.huawei.android.brotli.dec.a */
/* loaded from: classes.dex */
public class C2161a {
    /* renamed from: a */
    public static void m13223a(C2167g c2167g, int i10) {
        byte[] bArr = c2167g.f9837f;
        int i11 = i10 >> 2;
        int[] iArr = c2167g.f9839g;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 4;
            iArr[i12] = ((bArr[i13 + 3] & 255) << 24) | (bArr[i13] & 255) | ((bArr[i13 + 1] & 255) << 8) | ((bArr[i13 + 2] & 255) << 16);
        }
    }

    /* renamed from: b */
    public static void m13224b(C2167g c2167g, int i10) {
        if (c2167g.f9852s == 0) {
            return;
        }
        int i11 = ((c2167g.f9850q << 2) + ((c2167g.f9849p + 7) >> 3)) - 8;
        int i12 = c2167g.f9851r;
        if (i11 > i12) {
            throw new C2163c("Read after end");
        }
        if (i10 != 0 && i11 != i12) {
            throw new C2163c("Unused bytes after end");
        }
    }

    /* renamed from: c */
    public static void m13225c(C2167g c2167g, byte[] bArr, int i10, int i11) {
        if ((c2167g.f9849p & 7) != 0) {
            throw new C2163c("Unaligned copyBytes");
        }
        while (c2167g.f9849p != 64 && i11 != 0) {
            bArr[i10] = (byte) m13232j(c2167g);
            c2167g.f9849p += 8;
            i11--;
            i10++;
        }
        if (i11 == 0) {
            return;
        }
        int iMin = Math.min(m13229g(c2167g), i11 >> 2);
        if (iMin > 0) {
            int i12 = iMin << 2;
            System.arraycopy(c2167g.f9837f, c2167g.f9850q << 2, bArr, i10, i12);
            i10 += i12;
            i11 -= i12;
            c2167g.f9850q += iMin;
        }
        if (i11 == 0) {
            return;
        }
        if (m13229g(c2167g) <= 0) {
            while (i11 > 0) {
                int iM13277f = C2169i.m13277f(c2167g.f9840g0, bArr, i10, i11);
                if (iM13277f == -1) {
                    throw new C2163c("Unexpected end of input");
                }
                i10 += iM13277f;
                i11 -= iM13277f;
            }
            return;
        }
        m13228f(c2167g);
        while (i11 != 0) {
            bArr[i10] = (byte) m13232j(c2167g);
            c2167g.f9849p += 8;
            i11--;
            i10++;
        }
        m13224b(c2167g, 0);
    }

    /* renamed from: d */
    public static void m13226d(C2167g c2167g) {
        int[] iArr = c2167g.f9839g;
        c2167g.f9850q = c2167g.f9850q + 1;
        c2167g.f9846m = (iArr[r1] << 32) | (c2167g.f9846m >>> 32);
        c2167g.f9849p -= 32;
    }

    /* renamed from: e */
    public static void m13227e(C2167g c2167g) {
        if (c2167g.f9852s != 0) {
            if (m13229g(c2167g) < -2) {
                throw new C2163c("No more input");
            }
            return;
        }
        int i10 = c2167g.f9850q << 2;
        int i11 = 4096 - i10;
        C2169i.m13273b(c2167g.f9837f, 0, i10, 4096);
        c2167g.f9850q = 0;
        while (true) {
            if (i11 >= 4096) {
                break;
            }
            int iM13277f = C2169i.m13277f(c2167g.f9840g0, c2167g.f9837f, i11, 4096 - i11);
            if (iM13277f <= 0) {
                c2167g.f9852s = 1;
                c2167g.f9851r = i11;
                i11 += 3;
                break;
            }
            i11 += iM13277f;
        }
        m13223a(c2167g, i11);
    }

    /* renamed from: f */
    public static void m13228f(C2167g c2167g) {
        int i10 = c2167g.f9849p;
        if (i10 >= 32) {
            int[] iArr = c2167g.f9839g;
            c2167g.f9850q = c2167g.f9850q + 1;
            c2167g.f9846m = (iArr[r3] << 32) | (c2167g.f9846m >>> 32);
            c2167g.f9849p = i10 - 32;
        }
    }

    /* renamed from: g */
    public static int m13229g(C2167g c2167g) {
        return (c2167g.f9852s != 0 ? (c2167g.f9851r + 3) >> 2 : 1024) - c2167g.f9850q;
    }

    /* renamed from: h */
    public static void m13230h(C2167g c2167g) {
        c2167g.f9837f = new byte[4160];
        c2167g.f9846m = 0L;
        c2167g.f9839g = new int[1040];
        c2167g.f9849p = 64;
        c2167g.f9850q = 1024;
        c2167g.f9852s = 0;
        m13233k(c2167g);
    }

    /* renamed from: i */
    public static void m13231i(C2167g c2167g) {
        int i10 = (64 - c2167g.f9849p) & 7;
        if (i10 != 0 && m13235m(c2167g, i10) != 0) {
            throw new C2163c("Corrupted padding bits");
        }
    }

    /* renamed from: j */
    public static int m13232j(C2167g c2167g) {
        return (int) (c2167g.f9846m >>> c2167g.f9849p);
    }

    /* renamed from: k */
    public static void m13233k(C2167g c2167g) {
        m13236n(c2167g);
        m13224b(c2167g, 0);
        m13226d(c2167g);
        m13226d(c2167g);
    }

    /* renamed from: l */
    public static int m13234l(C2167g c2167g, int i10) {
        return m13235m(c2167g, i10);
    }

    /* renamed from: m */
    public static int m13235m(C2167g c2167g, int i10) {
        int iM13232j = m13232j(c2167g) & ((1 << i10) - 1);
        c2167g.f9849p += i10;
        return iM13232j;
    }

    /* renamed from: n */
    public static void m13236n(C2167g c2167g) {
        if (c2167g.f9850q > 1015) {
            m13227e(c2167g);
        }
    }

    /* renamed from: o */
    public static void m13237o(C2167g c2167g) {
        if (c2167g.f9849p == 64) {
            m13233k(c2167g);
        }
    }
}
