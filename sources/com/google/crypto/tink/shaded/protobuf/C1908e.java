package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.C1900b0;
import com.google.crypto.tink.shaded.protobuf.C1958u1;
import com.google.flatbuffers.reflection.BaseType;
import java.io.IOException;

/* renamed from: com.google.crypto.tink.shaded.protobuf.e */
/* loaded from: classes.dex */
public final class C1908e {

    /* renamed from: com.google.crypto.tink.shaded.protobuf.e$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9114a;

        static {
            int[] iArr = new int[C1958u1.b.values().length];
            f9114a = iArr;
            try {
                iArr[C1958u1.b.f9287c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9114a[C1958u1.b.f9288d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9114a[C1958u1.b.f9289e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9114a[C1958u1.b.f9290f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9114a[C1958u1.b.f9291g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9114a[C1958u1.b.f9299o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9114a[C1958u1.b.f9292h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9114a[C1958u1.b.f9302r.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9114a[C1958u1.b.f9293i.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9114a[C1958u1.b.f9301q.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9114a[C1958u1.b.f9294j.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9114a[C1958u1.b.f9303s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9114a[C1958u1.b.f9304t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9114a[C1958u1.b.f9300p.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f9114a[C1958u1.b.f9298n.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f9114a[C1958u1.b.f9295k.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f9114a[C1958u1.b.f9296l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f9114a[C1958u1.b.f9297m.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.e$b */
    public static final class b {

        /* renamed from: a */
        public int f9115a;

        /* renamed from: b */
        public long f9116b;

        /* renamed from: c */
        public Object f9117c;

        /* renamed from: d */
        public final C1944q f9118d;

        public b(C1944q c1944q) {
            c1944q.getClass();
            this.f9118d = c1944q;
        }
    }

    /* renamed from: A */
    public static int m11521A(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) {
        C1897a0 c1897a0 = (C1897a0) iVar;
        int iM11529I = m11529I(bArr, i11, bVar);
        c1897a0.m11471d(AbstractC1923j.m11719b(bVar.f9115a));
        while (iM11529I < i12) {
            int iM11529I2 = m11529I(bArr, iM11529I, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            iM11529I = m11529I(bArr, iM11529I2, bVar);
            c1897a0.m11471d(AbstractC1923j.m11719b(bVar.f9115a));
        }
        return iM11529I;
    }

    /* renamed from: B */
    public static int m11522B(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) {
        C1924j0 c1924j0 = (C1924j0) iVar;
        int iM11532L = m11532L(bArr, i11, bVar);
        c1924j0.m11766e(AbstractC1923j.m11720c(bVar.f9116b));
        while (iM11532L < i12) {
            int iM11529I = m11529I(bArr, iM11532L, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            iM11532L = m11532L(bArr, iM11529I, bVar);
            c1924j0.m11766e(AbstractC1923j.m11720c(bVar.f9116b));
        }
        return iM11532L;
    }

    /* renamed from: C */
    public static int m11523C(byte[] bArr, int i10, b bVar) throws C1903c0 {
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a;
        if (i11 < 0) {
            throw C1903c0.m11507g();
        }
        if (i11 == 0) {
            bVar.f9117c = "";
            return iM11529I;
        }
        bVar.f9117c = new String(bArr, iM11529I, i11, C1900b0.f9085a);
        return iM11529I + i11;
    }

    /* renamed from: D */
    public static int m11524D(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) throws C1903c0 {
        int iM11529I = m11529I(bArr, i11, bVar);
        int i13 = bVar.f9115a;
        if (i13 < 0) {
            throw C1903c0.m11507g();
        }
        if (i13 == 0) {
            iVar.add("");
        } else {
            iVar.add(new String(bArr, iM11529I, i13, C1900b0.f9085a));
            iM11529I += i13;
        }
        while (iM11529I < i12) {
            int iM11529I2 = m11529I(bArr, iM11529I, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            iM11529I = m11529I(bArr, iM11529I2, bVar);
            int i14 = bVar.f9115a;
            if (i14 < 0) {
                throw C1903c0.m11507g();
            }
            if (i14 == 0) {
                iVar.add("");
            } else {
                iVar.add(new String(bArr, iM11529I, i14, C1900b0.f9085a));
                iM11529I += i14;
            }
        }
        return iM11529I;
    }

    /* renamed from: E */
    public static int m11525E(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) throws C1903c0 {
        int iM11529I = m11529I(bArr, i11, bVar);
        int i13 = bVar.f9115a;
        if (i13 < 0) {
            throw C1903c0.m11507g();
        }
        if (i13 == 0) {
            iVar.add("");
        } else {
            int i14 = iM11529I + i13;
            if (!C1955t1.m12223n(bArr, iM11529I, i14)) {
                throw C1903c0.m11504d();
            }
            iVar.add(new String(bArr, iM11529I, i13, C1900b0.f9085a));
            iM11529I = i14;
        }
        while (iM11529I < i12) {
            int iM11529I2 = m11529I(bArr, iM11529I, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            iM11529I = m11529I(bArr, iM11529I2, bVar);
            int i15 = bVar.f9115a;
            if (i15 < 0) {
                throw C1903c0.m11507g();
            }
            if (i15 == 0) {
                iVar.add("");
            } else {
                int i16 = iM11529I + i15;
                if (!C1955t1.m12223n(bArr, iM11529I, i16)) {
                    throw C1903c0.m11504d();
                }
                iVar.add(new String(bArr, iM11529I, i15, C1900b0.f9085a));
                iM11529I = i16;
            }
        }
        return iM11529I;
    }

    /* renamed from: F */
    public static int m11526F(byte[] bArr, int i10, b bVar) throws C1903c0 {
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a;
        if (i11 < 0) {
            throw C1903c0.m11507g();
        }
        if (i11 == 0) {
            bVar.f9117c = "";
            return iM11529I;
        }
        bVar.f9117c = C1955t1.m12214e(bArr, iM11529I, i11);
        return iM11529I + i11;
    }

    /* renamed from: G */
    public static int m11527G(int i10, byte[] bArr, int i11, int i12, C1943p1 c1943p1, b bVar) throws C1903c0 {
        if (C1958u1.m12257a(i10) == 0) {
            throw C1903c0.m11503c();
        }
        int iM12258b = C1958u1.m12258b(i10);
        if (iM12258b == 0) {
            int iM11532L = m11532L(bArr, i11, bVar);
            c1943p1.m12100n(i10, Long.valueOf(bVar.f9116b));
            return iM11532L;
        }
        if (iM12258b == 1) {
            c1943p1.m12100n(i10, Long.valueOf(m11544j(bArr, i11)));
            return i11 + 8;
        }
        if (iM12258b == 2) {
            int iM11529I = m11529I(bArr, i11, bVar);
            int i13 = bVar.f9115a;
            if (i13 < 0) {
                throw C1903c0.m11507g();
            }
            if (i13 > bArr.length - iM11529I) {
                throw C1903c0.m11510l();
            }
            if (i13 == 0) {
                c1943p1.m12100n(i10, AbstractC1920i.f9147b);
            } else {
                c1943p1.m12100n(i10, AbstractC1920i.m11683g(bArr, iM11529I, i13));
            }
            return iM11529I + i13;
        }
        if (iM12258b != 3) {
            if (iM12258b != 5) {
                throw C1903c0.m11503c();
            }
            c1943p1.m12100n(i10, Integer.valueOf(m11542h(bArr, i11)));
            return i11 + 4;
        }
        C1943p1 c1943p1M12092l = C1943p1.m12092l();
        int i14 = (i10 & (-8)) | 4;
        int i15 = 0;
        while (true) {
            if (i11 >= i12) {
                break;
            }
            int iM11529I2 = m11529I(bArr, i11, bVar);
            int i16 = bVar.f9115a;
            if (i16 == i14) {
                i15 = i16;
                i11 = iM11529I2;
                break;
            }
            i15 = i16;
            i11 = m11527G(i16, bArr, iM11529I2, i12, c1943p1M12092l, bVar);
        }
        if (i11 > i12 || i15 != i14) {
            throw C1903c0.m11508h();
        }
        c1943p1.m12100n(i10, c1943p1M12092l);
        return i11;
    }

    /* renamed from: H */
    public static int m11528H(int i10, byte[] bArr, int i11, b bVar) {
        int i12 = i10 & 127;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            bVar.f9115a = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & 127) << 7);
        int i15 = i11 + 2;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            bVar.f9115a = i14 | (b11 << BaseType.Vector);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 14);
        int i17 = i11 + 3;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            bVar.f9115a = i16 | (b12 << 21);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 21);
        int i19 = i11 + 4;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            bVar.f9115a = i18 | (b13 << 28);
            return i19;
        }
        int i20 = i18 | ((b13 & 127) << 28);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] >= 0) {
                bVar.f9115a = i20;
                return i21;
            }
            i19 = i21;
        }
    }

    /* renamed from: I */
    public static int m11529I(byte[] bArr, int i10, b bVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return m11528H(b10, bArr, i11, bVar);
        }
        bVar.f9115a = b10;
        return i11;
    }

    /* renamed from: J */
    public static int m11530J(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) {
        C1897a0 c1897a0 = (C1897a0) iVar;
        int iM11529I = m11529I(bArr, i11, bVar);
        c1897a0.m11471d(bVar.f9115a);
        while (iM11529I < i12) {
            int iM11529I2 = m11529I(bArr, iM11529I, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            iM11529I = m11529I(bArr, iM11529I2, bVar);
            c1897a0.m11471d(bVar.f9115a);
        }
        return iM11529I;
    }

    /* renamed from: K */
    public static int m11531K(long j10, byte[] bArr, int i10, b bVar) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        long j11 = (j10 & 127) | ((b10 & 127) << 7);
        int i12 = 7;
        while (b10 < 0) {
            int i13 = i11 + 1;
            byte b11 = bArr[i11];
            i12 += 7;
            j11 |= (b11 & 127) << i12;
            i11 = i13;
            b10 = b11;
        }
        bVar.f9116b = j11;
        return i11;
    }

    /* renamed from: L */
    public static int m11532L(byte[] bArr, int i10, b bVar) {
        int i11 = i10 + 1;
        long j10 = bArr[i10];
        if (j10 < 0) {
            return m11531K(j10, bArr, i11, bVar);
        }
        bVar.f9116b = j10;
        return i11;
    }

    /* renamed from: M */
    public static int m11533M(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) {
        C1924j0 c1924j0 = (C1924j0) iVar;
        int iM11532L = m11532L(bArr, i11, bVar);
        c1924j0.m11766e(bVar.f9116b);
        while (iM11532L < i12) {
            int iM11529I = m11529I(bArr, iM11532L, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            iM11532L = m11532L(bArr, iM11529I, bVar);
            c1924j0.m11766e(bVar.f9116b);
        }
        return iM11532L;
    }

    /* renamed from: N */
    public static int m11534N(int i10, byte[] bArr, int i11, int i12, b bVar) throws C1903c0 {
        if (C1958u1.m12257a(i10) == 0) {
            throw C1903c0.m11503c();
        }
        int iM12258b = C1958u1.m12258b(i10);
        if (iM12258b == 0) {
            return m11532L(bArr, i11, bVar);
        }
        if (iM12258b == 1) {
            return i11 + 8;
        }
        if (iM12258b == 2) {
            return m11529I(bArr, i11, bVar) + bVar.f9115a;
        }
        if (iM12258b != 3) {
            if (iM12258b == 5) {
                return i11 + 4;
            }
            throw C1903c0.m11503c();
        }
        int i13 = (i10 & (-8)) | 4;
        int i14 = 0;
        while (i11 < i12) {
            i11 = m11529I(bArr, i11, bVar);
            i14 = bVar.f9115a;
            if (i14 == i13) {
                break;
            }
            i11 = m11534N(i14, bArr, i11, i12, bVar);
        }
        if (i11 > i12 || i14 != i13) {
            throw C1903c0.m11508h();
        }
        return i11;
    }

    /* renamed from: a */
    public static int m11535a(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) {
        C1914g c1914g = (C1914g) iVar;
        int iM11532L = m11532L(bArr, i11, bVar);
        c1914g.m11647e(bVar.f9116b != 0);
        while (iM11532L < i12) {
            int iM11529I = m11529I(bArr, iM11532L, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            iM11532L = m11532L(bArr, iM11529I, bVar);
            c1914g.m11647e(bVar.f9116b != 0);
        }
        return iM11532L;
    }

    /* renamed from: b */
    public static int m11536b(byte[] bArr, int i10, b bVar) throws C1903c0 {
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a;
        if (i11 < 0) {
            throw C1903c0.m11507g();
        }
        if (i11 > bArr.length - iM11529I) {
            throw C1903c0.m11510l();
        }
        if (i11 == 0) {
            bVar.f9117c = AbstractC1920i.f9147b;
            return iM11529I;
        }
        bVar.f9117c = AbstractC1920i.m11683g(bArr, iM11529I, i11);
        return iM11529I + i11;
    }

    /* renamed from: c */
    public static int m11537c(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) throws C1903c0 {
        int iM11529I = m11529I(bArr, i11, bVar);
        int i13 = bVar.f9115a;
        if (i13 < 0) {
            throw C1903c0.m11507g();
        }
        if (i13 > bArr.length - iM11529I) {
            throw C1903c0.m11510l();
        }
        if (i13 == 0) {
            iVar.add(AbstractC1920i.f9147b);
        } else {
            iVar.add(AbstractC1920i.m11683g(bArr, iM11529I, i13));
            iM11529I += i13;
        }
        while (iM11529I < i12) {
            int iM11529I2 = m11529I(bArr, iM11529I, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            iM11529I = m11529I(bArr, iM11529I2, bVar);
            int i14 = bVar.f9115a;
            if (i14 < 0) {
                throw C1903c0.m11507g();
            }
            if (i14 > bArr.length - iM11529I) {
                throw C1903c0.m11510l();
            }
            if (i14 == 0) {
                iVar.add(AbstractC1920i.f9147b);
            } else {
                iVar.add(AbstractC1920i.m11683g(bArr, iM11529I, i14));
                iM11529I += i14;
            }
        }
        return iM11529I;
    }

    /* renamed from: d */
    public static double m11538d(byte[] bArr, int i10) {
        return Double.longBitsToDouble(m11544j(bArr, i10));
    }

    /* renamed from: e */
    public static int m11539e(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) {
        C1935n c1935n = (C1935n) iVar;
        c1935n.m12041d(m11538d(bArr, i11));
        int i13 = i11 + 8;
        while (i13 < i12) {
            int iM11529I = m11529I(bArr, i13, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            c1935n.m12041d(m11538d(bArr, iM11529I));
            i13 = iM11529I + 8;
        }
        return i13;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: f */
    public static int m11540f(int i10, byte[] bArr, int i11, int i12, AbstractC1968z.c<?, ?> cVar, AbstractC1968z.e<?, ?> eVar, AbstractC1940o1<C1943p1, C1943p1> abstractC1940o1, b bVar) throws IOException {
        Object objM12272i;
        C1959v<AbstractC1968z.d> c1959v = cVar.extensions;
        int i13 = i10 >>> 3;
        if (eVar.f9432b.mo12286b0() && eVar.f9432b.mo12290o0()) {
            switch (a.f9114a[eVar.m12412a().ordinal()]) {
                case 1:
                    C1935n c1935n = new C1935n();
                    int iM11553s = m11553s(bArr, i11, c1935n, bVar);
                    c1959v.m12283w(eVar.f9432b, c1935n);
                    return iM11553s;
                case 2:
                    C1964x c1964x = new C1964x();
                    int iM11556v = m11556v(bArr, i11, c1964x, bVar);
                    c1959v.m12283w(eVar.f9432b, c1964x);
                    return iM11556v;
                case 3:
                case 4:
                    C1924j0 c1924j0 = new C1924j0();
                    int iM11560z = m11560z(bArr, i11, c1924j0, bVar);
                    c1959v.m12283w(eVar.f9432b, c1924j0);
                    return iM11560z;
                case 5:
                case 6:
                    C1897a0 c1897a0 = new C1897a0();
                    int iM11559y = m11559y(bArr, i11, c1897a0, bVar);
                    c1959v.m12283w(eVar.f9432b, c1897a0);
                    return iM11559y;
                case 7:
                case 8:
                    C1924j0 c1924j02 = new C1924j0();
                    int iM11555u = m11555u(bArr, i11, c1924j02, bVar);
                    c1959v.m12283w(eVar.f9432b, c1924j02);
                    return iM11555u;
                case 9:
                case 10:
                    C1897a0 c1897a02 = new C1897a0();
                    int iM11554t = m11554t(bArr, i11, c1897a02, bVar);
                    c1959v.m12283w(eVar.f9432b, c1897a02);
                    return iM11554t;
                case 11:
                    C1914g c1914g = new C1914g();
                    int iM11552r = m11552r(bArr, i11, c1914g, bVar);
                    c1959v.m12283w(eVar.f9432b, c1914g);
                    return iM11552r;
                case 12:
                    C1897a0 c1897a03 = new C1897a0();
                    int iM11557w = m11557w(bArr, i11, c1897a03, bVar);
                    c1959v.m12283w(eVar.f9432b, c1897a03);
                    return iM11557w;
                case 13:
                    C1924j0 c1924j03 = new C1924j0();
                    int iM11558x = m11558x(bArr, i11, c1924j03, bVar);
                    c1959v.m12283w(eVar.f9432b, c1924j03);
                    return iM11558x;
                case 14:
                    C1897a0 c1897a04 = new C1897a0();
                    int iM11559y2 = m11559y(bArr, i11, c1897a04, bVar);
                    C1943p1 c1943p1 = cVar.unknownFields;
                    C1943p1 c1943p12 = (C1943p1) C1925j1.m11829z(i13, c1897a04, eVar.f9432b.m12411b(), c1943p1 != C1943p1.m12088e() ? c1943p1 : null, abstractC1940o1);
                    if (c1943p12 != null) {
                        cVar.unknownFields = c1943p12;
                    }
                    c1959v.m12283w(eVar.f9432b, c1897a04);
                    return iM11559y2;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f9432b.mo12287c0());
            }
        }
        if (eVar.m12412a() != C1958u1.b.f9300p) {
            switch (a.f9114a[eVar.m12412a().ordinal()]) {
                case 1:
                    objValueOf = Double.valueOf(m11538d(bArr, i11));
                    i11 += 8;
                    break;
                case 2:
                    objValueOf = Float.valueOf(m11546l(bArr, i11));
                    i11 += 4;
                    break;
                case 3:
                case 4:
                    i11 = m11532L(bArr, i11, bVar);
                    objValueOf = Long.valueOf(bVar.f9116b);
                    break;
                case 5:
                case 6:
                    i11 = m11529I(bArr, i11, bVar);
                    objValueOf = Integer.valueOf(bVar.f9115a);
                    break;
                case 7:
                case 8:
                    objValueOf = Long.valueOf(m11544j(bArr, i11));
                    i11 += 8;
                    break;
                case 9:
                case 10:
                    objValueOf = Integer.valueOf(m11542h(bArr, i11));
                    i11 += 4;
                    break;
                case 11:
                    i11 = m11532L(bArr, i11, bVar);
                    objValueOf = Boolean.valueOf(bVar.f9116b != 0);
                    break;
                case 12:
                    i11 = m11529I(bArr, i11, bVar);
                    objValueOf = Integer.valueOf(AbstractC1923j.m11719b(bVar.f9115a));
                    break;
                case 13:
                    i11 = m11532L(bArr, i11, bVar);
                    objValueOf = Long.valueOf(AbstractC1923j.m11720c(bVar.f9116b));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i11 = m11536b(bArr, i11, bVar);
                    objValueOf = bVar.f9117c;
                    break;
                case 16:
                    i11 = m11523C(bArr, i11, bVar);
                    objValueOf = bVar.f9117c;
                    break;
                case 17:
                    i11 = m11548n(C1907d1.m11516a().m11519d(eVar.m12413b().getClass()), bArr, i11, i12, (i13 << 3) | 4, bVar);
                    objValueOf = bVar.f9117c;
                    break;
                case 18:
                    i11 = m11550p(C1907d1.m11516a().m11519d(eVar.m12413b().getClass()), bArr, i11, i12, bVar);
                    objValueOf = bVar.f9117c;
                    break;
            }
        } else {
            i11 = m11529I(bArr, i11, bVar);
            if (eVar.f9432b.m12411b().mo11497a(bVar.f9115a) == null) {
                C1943p1 c1943p1M12092l = cVar.unknownFields;
                if (c1943p1M12092l == C1943p1.m12088e()) {
                    c1943p1M12092l = C1943p1.m12092l();
                    cVar.unknownFields = c1943p1M12092l;
                }
                C1925j1.m11784L(i13, bVar.f9115a, c1943p1M12092l, abstractC1940o1);
                return i11;
            }
            objValueOf = Integer.valueOf(bVar.f9115a);
        }
        if (eVar.m12415d()) {
            c1959v.m12269a(eVar.f9432b, objValueOf);
        } else {
            int i14 = a.f9114a[eVar.m12412a().ordinal()];
            if ((i14 == 17 || i14 == 18) && (objM12272i = c1959v.m12272i(eVar.f9432b)) != null) {
                objValueOf = C1900b0.m11493h(objM12272i, objValueOf);
            }
            c1959v.m12283w(eVar.f9432b, objValueOf);
        }
        return i11;
    }

    /* renamed from: g */
    public static int m11541g(int i10, byte[] bArr, int i11, int i12, Object obj, InterfaceC1951s0 interfaceC1951s0, AbstractC1940o1<C1943p1, C1943p1> abstractC1940o1, b bVar) throws IOException {
        AbstractC1968z.e eVarM12104a = bVar.f9118d.m12104a(interfaceC1951s0, i10 >>> 3);
        if (eVarM12104a == null) {
            return m11527G(i10, bArr, i11, i12, C1960v0.m12310v(obj), bVar);
        }
        AbstractC1968z.c cVar = (AbstractC1968z.c) obj;
        cVar.m12409M();
        return m11540f(i10, bArr, i11, i12, cVar, eVarM12104a, abstractC1940o1, bVar);
    }

    /* renamed from: h */
    public static int m11542h(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    /* renamed from: i */
    public static int m11543i(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) {
        C1897a0 c1897a0 = (C1897a0) iVar;
        c1897a0.m11471d(m11542h(bArr, i11));
        int i13 = i11 + 4;
        while (i13 < i12) {
            int iM11529I = m11529I(bArr, i13, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            c1897a0.m11471d(m11542h(bArr, iM11529I));
            i13 = iM11529I + 4;
        }
        return i13;
    }

    /* renamed from: j */
    public static long m11544j(byte[] bArr, int i10) {
        return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }

    /* renamed from: k */
    public static int m11545k(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) {
        C1924j0 c1924j0 = (C1924j0) iVar;
        c1924j0.m11766e(m11544j(bArr, i11));
        int i13 = i11 + 8;
        while (i13 < i12) {
            int iM11529I = m11529I(bArr, i13, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            c1924j0.m11766e(m11544j(bArr, iM11529I));
            i13 = iM11529I + 8;
        }
        return i13;
    }

    /* renamed from: l */
    public static float m11546l(byte[] bArr, int i10) {
        return Float.intBitsToFloat(m11542h(bArr, i10));
    }

    /* renamed from: m */
    public static int m11547m(int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) {
        C1964x c1964x = (C1964x) iVar;
        c1964x.m12367d(m11546l(bArr, i11));
        int i13 = i11 + 4;
        while (i13 < i12) {
            int iM11529I = m11529I(bArr, i13, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            c1964x.m12367d(m11546l(bArr, iM11529I));
            i13 = iM11529I + 4;
        }
        return i13;
    }

    /* renamed from: n */
    public static int m11548n(InterfaceC1919h1 interfaceC1919h1, byte[] bArr, int i10, int i11, int i12, b bVar) throws IOException {
        C1960v0 c1960v0 = (C1960v0) interfaceC1919h1;
        Object objMo11675i = c1960v0.mo11675i();
        int iM12326c0 = c1960v0.m12326c0(objMo11675i, bArr, i10, i11, i12, bVar);
        c1960v0.mo11668b(objMo11675i);
        bVar.f9117c = objMo11675i;
        return iM12326c0;
    }

    /* renamed from: o */
    public static int m11549o(InterfaceC1919h1 interfaceC1919h1, int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) throws IOException {
        int i13 = (i10 & (-8)) | 4;
        int iM11548n = m11548n(interfaceC1919h1, bArr, i11, i12, i13, bVar);
        iVar.add(bVar.f9117c);
        while (iM11548n < i12) {
            int iM11529I = m11529I(bArr, iM11548n, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            iM11548n = m11548n(interfaceC1919h1, bArr, iM11529I, i12, i13, bVar);
            iVar.add(bVar.f9117c);
        }
        return iM11548n;
    }

    /* renamed from: p */
    public static int m11550p(InterfaceC1919h1 interfaceC1919h1, byte[] bArr, int i10, int i11, b bVar) throws IOException {
        int iM11528H = i10 + 1;
        int i12 = bArr[i10];
        if (i12 < 0) {
            iM11528H = m11528H(i12, bArr, iM11528H, bVar);
            i12 = bVar.f9115a;
        }
        int i13 = iM11528H;
        if (i12 < 0 || i12 > i11 - i13) {
            throw C1903c0.m11510l();
        }
        Object objMo11675i = interfaceC1919h1.mo11675i();
        int i14 = i12 + i13;
        interfaceC1919h1.mo11670d(objMo11675i, bArr, i13, i14, bVar);
        interfaceC1919h1.mo11668b(objMo11675i);
        bVar.f9117c = objMo11675i;
        return i14;
    }

    /* renamed from: q */
    public static int m11551q(InterfaceC1919h1<?> interfaceC1919h1, int i10, byte[] bArr, int i11, int i12, C1900b0.i<?> iVar, b bVar) throws IOException {
        int iM11550p = m11550p(interfaceC1919h1, bArr, i11, i12, bVar);
        iVar.add(bVar.f9117c);
        while (iM11550p < i12) {
            int iM11529I = m11529I(bArr, iM11550p, bVar);
            if (i10 != bVar.f9115a) {
                break;
            }
            iM11550p = m11550p(interfaceC1919h1, bArr, iM11529I, i12, bVar);
            iVar.add(bVar.f9117c);
        }
        return iM11550p;
    }

    /* renamed from: r */
    public static int m11552r(byte[] bArr, int i10, C1900b0.i<?> iVar, b bVar) throws IOException {
        C1914g c1914g = (C1914g) iVar;
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a + iM11529I;
        while (iM11529I < i11) {
            iM11529I = m11532L(bArr, iM11529I, bVar);
            c1914g.m11647e(bVar.f9116b != 0);
        }
        if (iM11529I == i11) {
            return iM11529I;
        }
        throw C1903c0.m11510l();
    }

    /* renamed from: s */
    public static int m11553s(byte[] bArr, int i10, C1900b0.i<?> iVar, b bVar) throws IOException {
        C1935n c1935n = (C1935n) iVar;
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a + iM11529I;
        while (iM11529I < i11) {
            c1935n.m12041d(m11538d(bArr, iM11529I));
            iM11529I += 8;
        }
        if (iM11529I == i11) {
            return iM11529I;
        }
        throw C1903c0.m11510l();
    }

    /* renamed from: t */
    public static int m11554t(byte[] bArr, int i10, C1900b0.i<?> iVar, b bVar) throws IOException {
        C1897a0 c1897a0 = (C1897a0) iVar;
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a + iM11529I;
        while (iM11529I < i11) {
            c1897a0.m11471d(m11542h(bArr, iM11529I));
            iM11529I += 4;
        }
        if (iM11529I == i11) {
            return iM11529I;
        }
        throw C1903c0.m11510l();
    }

    /* renamed from: u */
    public static int m11555u(byte[] bArr, int i10, C1900b0.i<?> iVar, b bVar) throws IOException {
        C1924j0 c1924j0 = (C1924j0) iVar;
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a + iM11529I;
        while (iM11529I < i11) {
            c1924j0.m11766e(m11544j(bArr, iM11529I));
            iM11529I += 8;
        }
        if (iM11529I == i11) {
            return iM11529I;
        }
        throw C1903c0.m11510l();
    }

    /* renamed from: v */
    public static int m11556v(byte[] bArr, int i10, C1900b0.i<?> iVar, b bVar) throws IOException {
        C1964x c1964x = (C1964x) iVar;
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a + iM11529I;
        while (iM11529I < i11) {
            c1964x.m12367d(m11546l(bArr, iM11529I));
            iM11529I += 4;
        }
        if (iM11529I == i11) {
            return iM11529I;
        }
        throw C1903c0.m11510l();
    }

    /* renamed from: w */
    public static int m11557w(byte[] bArr, int i10, C1900b0.i<?> iVar, b bVar) throws IOException {
        C1897a0 c1897a0 = (C1897a0) iVar;
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a + iM11529I;
        while (iM11529I < i11) {
            iM11529I = m11529I(bArr, iM11529I, bVar);
            c1897a0.m11471d(AbstractC1923j.m11719b(bVar.f9115a));
        }
        if (iM11529I == i11) {
            return iM11529I;
        }
        throw C1903c0.m11510l();
    }

    /* renamed from: x */
    public static int m11558x(byte[] bArr, int i10, C1900b0.i<?> iVar, b bVar) throws IOException {
        C1924j0 c1924j0 = (C1924j0) iVar;
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a + iM11529I;
        while (iM11529I < i11) {
            iM11529I = m11532L(bArr, iM11529I, bVar);
            c1924j0.m11766e(AbstractC1923j.m11720c(bVar.f9116b));
        }
        if (iM11529I == i11) {
            return iM11529I;
        }
        throw C1903c0.m11510l();
    }

    /* renamed from: y */
    public static int m11559y(byte[] bArr, int i10, C1900b0.i<?> iVar, b bVar) throws IOException {
        C1897a0 c1897a0 = (C1897a0) iVar;
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a + iM11529I;
        while (iM11529I < i11) {
            iM11529I = m11529I(bArr, iM11529I, bVar);
            c1897a0.m11471d(bVar.f9115a);
        }
        if (iM11529I == i11) {
            return iM11529I;
        }
        throw C1903c0.m11510l();
    }

    /* renamed from: z */
    public static int m11560z(byte[] bArr, int i10, C1900b0.i<?> iVar, b bVar) throws IOException {
        C1924j0 c1924j0 = (C1924j0) iVar;
        int iM11529I = m11529I(bArr, i10, bVar);
        int i11 = bVar.f9115a + iM11529I;
        while (iM11529I < i11) {
            iM11529I = m11532L(bArr, iM11529I, bVar);
            c1924j0.m11766e(bVar.f9116b);
        }
        if (iM11529I == i11) {
            return iM11529I;
        }
        throw C1903c0.m11510l();
    }
}
