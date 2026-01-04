package p410jy;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.ByteOrder;
import java.util.Arrays;
import ly.C11368b;
import p377iy.AbstractC10632a;
import py.C12249b;

/* renamed from: jy.a */
/* loaded from: classes9.dex */
public class C10959a extends AbstractC10632a {

    /* renamed from: b */
    public int f51893b;

    /* renamed from: c */
    public int f51894c;

    /* renamed from: d */
    public int f51895d;

    /* renamed from: e */
    public boolean f51896e;

    /* renamed from: f */
    public final C10960b f51897f;

    /* renamed from: g */
    public int f51898g;

    /* renamed from: h */
    public C11368b f51899h;

    /* renamed from: i */
    public final boolean f51900i;

    /* renamed from: j */
    public int f51901j;

    /* renamed from: k */
    public int f51902k;

    /* renamed from: l */
    public int f51903l;

    /* renamed from: m */
    public int f51904m;

    /* renamed from: n */
    public int f51905n;

    /* renamed from: o */
    public int f51906o;

    /* renamed from: p */
    public int f51907p;

    /* renamed from: q */
    public int f51908q;

    /* renamed from: r */
    public int f51909r;

    /* renamed from: s */
    public int f51910s;

    /* renamed from: t */
    public int f51911t;

    /* renamed from: u */
    public int f51912u;

    /* renamed from: v */
    public char f51913v;

    /* renamed from: w */
    public a f51914w;

    /* renamed from: jy.a$a */
    public static final class a {

        /* renamed from: a */
        public final boolean[] f51915a = new boolean[256];

        /* renamed from: b */
        public final byte[] f51916b = new byte[256];

        /* renamed from: c */
        public final byte[] f51917c = new byte[18002];

        /* renamed from: d */
        public final byte[] f51918d = new byte[18002];

        /* renamed from: e */
        public final int[] f51919e = new int[256];

        /* renamed from: f */
        public final int[][] f51920f;

        /* renamed from: g */
        public final int[][] f51921g;

        /* renamed from: h */
        public final int[][] f51922h;

        /* renamed from: i */
        public final int[] f51923i;

        /* renamed from: j */
        public final int[] f51924j;

        /* renamed from: k */
        public final char[] f51925k;

        /* renamed from: l */
        public final char[][] f51926l;

        /* renamed from: m */
        public final byte[] f51927m;

        /* renamed from: n */
        public int[] f51928n;

        /* renamed from: o */
        public final byte[] f51929o;

        public a(int i10) {
            Class cls = Integer.TYPE;
            this.f51920f = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
            this.f51921g = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
            this.f51922h = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
            this.f51923i = new int[6];
            this.f51924j = new int[257];
            this.f51925k = new char[256];
            this.f51926l = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 6, 258);
            this.f51927m = new byte[6];
            this.f51929o = new byte[i10 * 100000];
        }

        /* renamed from: a */
        public int[] m66154a(int i10) {
            int[] iArr = this.f51928n;
            if (iArr != null && iArr.length >= i10) {
                return iArr;
            }
            int[] iArr2 = new int[i10];
            this.f51928n = iArr2;
            return iArr2;
        }
    }

    public C10959a(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    /* renamed from: k */
    public static boolean m66130k(C11368b c11368b) throws IOException {
        return m66133o(c11368b, 1) != 0;
    }

    /* renamed from: m */
    public static int m66131m(C11368b c11368b) throws IOException {
        return m66133o(c11368b, 32);
    }

    /* renamed from: n */
    public static char m66132n(C11368b c11368b) throws IOException {
        return (char) m66133o(c11368b, 8);
    }

    /* renamed from: o */
    public static int m66133o(C11368b c11368b, int i10) throws IOException {
        long jM68216z = c11368b.m68216z(i10);
        if (jM68216z >= 0) {
            return (int) jM68216z;
        }
        throw new IOException("Unexpected end of stream");
    }

    /* renamed from: p */
    public static void m66134p(int i10, int i11, String str) throws IOException {
        if (i10 < 0) {
            throw new IOException("Corrupted input, " + str + " value negative");
        }
        if (i10 < i11) {
            return;
        }
        throw new IOException("Corrupted input, " + str + " value too big");
    }

    /* renamed from: x */
    public static void m66135x(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i10, int i11, int i12) throws IOException {
        int i13 = 0;
        int i14 = 0;
        for (int i15 = i10; i15 <= i11; i15++) {
            for (int i16 = 0; i16 < i12; i16++) {
                if (cArr[i16] == i15) {
                    iArr3[i14] = i16;
                    i14++;
                }
            }
        }
        int i17 = 23;
        while (true) {
            i17--;
            if (i17 <= 0) {
                break;
            }
            iArr2[i17] = 0;
            iArr[i17] = 0;
        }
        for (int i18 = 0; i18 < i12; i18++) {
            char c10 = cArr[i18];
            m66134p(c10, 258, "length");
            int i19 = c10 + 1;
            iArr2[i19] = iArr2[i19] + 1;
        }
        int i20 = iArr2[0];
        for (int i21 = 1; i21 < 23; i21++) {
            i20 += iArr2[i21];
            iArr2[i21] = i20;
        }
        int i22 = iArr2[i10];
        int i23 = i10;
        while (i23 <= i11) {
            int i24 = i23 + 1;
            int i25 = iArr2[i24];
            int i26 = i13 + (i25 - i22);
            iArr[i23] = i26 - 1;
            i13 = i26 << 1;
            i23 = i24;
            i22 = i25;
        }
        for (int i27 = i10 + 1; i27 <= i11; i27++) {
            iArr2[i27] = ((iArr[i27 - 1] + 1) << 1) - iArr2[i27];
        }
    }

    /* renamed from: A */
    public final void m66136A() {
        a aVar = this.f51914w;
        boolean[] zArr = aVar.f51915a;
        byte[] bArr = aVar.f51916b;
        int i10 = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            if (zArr[i11]) {
                bArr[i10] = (byte) i11;
                i10++;
            }
        }
        this.f51898g = i10;
    }

    /* renamed from: B */
    public final int m66137B() throws IOException {
        switch (this.f51901j) {
            case 0:
                return -1;
            case 1:
                return m66140E();
            case 2:
                throw new IllegalStateException();
            case 3:
                return m66145J();
            case 4:
                return m66146V();
            case 5:
                throw new IllegalStateException();
            case 6:
                return m66142G();
            case 7:
                return m66143H();
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: C */
    public final int m66138C(C11368b c11368b) throws IOException {
        return (int) c11368b.m68216z(8);
    }

    /* renamed from: D */
    public final void m66139D() throws IOException {
        C11368b c11368b = this.f51899h;
        a aVar = this.f51914w;
        boolean[] zArr = aVar.f51915a;
        byte[] bArr = aVar.f51927m;
        byte[] bArr2 = aVar.f51917c;
        byte[] bArr3 = aVar.f51918d;
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            if (m66130k(c11368b)) {
                i10 |= 1 << i11;
            }
        }
        Arrays.fill(zArr, false);
        for (int i12 = 0; i12 < 16; i12++) {
            if (((1 << i12) & i10) != 0) {
                int i13 = i12 << 4;
                for (int i14 = 0; i14 < 16; i14++) {
                    if (m66130k(c11368b)) {
                        zArr[i13 + i14] = true;
                    }
                }
            }
        }
        m66136A();
        int i15 = this.f51898g + 2;
        int iM66133o = m66133o(c11368b, 3);
        int iM66133o2 = m66133o(c11368b, 15);
        if (iM66133o2 < 0) {
            throw new IOException("Corrupted input, nSelectors value negative");
        }
        m66134p(i15, 259, "alphaSize");
        m66134p(iM66133o, 7, "nGroups");
        for (int i16 = 0; i16 < iM66133o2; i16++) {
            int i17 = 0;
            while (m66130k(c11368b)) {
                i17++;
            }
            if (i16 < 18002) {
                bArr3[i16] = (byte) i17;
            }
        }
        int iMin = Math.min(iM66133o2, 18002);
        int i18 = iM66133o;
        while (true) {
            i18--;
            if (i18 < 0) {
                break;
            } else {
                bArr[i18] = (byte) i18;
            }
        }
        for (int i19 = 0; i19 < iMin; i19++) {
            int i20 = bArr3[i19] & 255;
            m66134p(i20, 6, "selectorMtf");
            byte b10 = bArr[i20];
            while (i20 > 0) {
                bArr[i20] = bArr[i20 - 1];
                i20--;
            }
            bArr[0] = b10;
            bArr2[i19] = b10;
        }
        char[][] cArr = aVar.f51926l;
        for (int i21 = 0; i21 < iM66133o; i21++) {
            int iM66133o3 = m66133o(c11368b, 5);
            char[] cArr2 = cArr[i21];
            for (int i22 = 0; i22 < i15; i22++) {
                while (m66130k(c11368b)) {
                    iM66133o3 += m66130k(c11368b) ? -1 : 1;
                }
                cArr2[i22] = (char) iM66133o3;
            }
        }
        m66148t(i15, iM66133o);
    }

    /* renamed from: E */
    public final int m66140E() throws IOException {
        a aVar;
        if (this.f51901j == 0 || (aVar = this.f51914w) == null) {
            return -1;
        }
        int[] iArr = aVar.f51924j;
        int i10 = this.f51893b + 1;
        int[] iArrM66154a = aVar.m66154a(i10);
        a aVar2 = this.f51914w;
        byte[] bArr = aVar2.f51929o;
        iArr[0] = 0;
        System.arraycopy(aVar2.f51919e, 0, iArr, 1, 256);
        int i11 = iArr[0];
        for (int i12 = 1; i12 <= 256; i12++) {
            i11 += iArr[i12];
            iArr[i12] = i11;
        }
        int i13 = this.f51893b;
        for (int i14 = 0; i14 <= i13; i14++) {
            int i15 = bArr[i14] & 255;
            int i16 = iArr[i15];
            iArr[i15] = i16 + 1;
            m66134p(i16, i10, "tt index");
            iArrM66154a[i16] = i14;
        }
        int i17 = this.f51894c;
        if (i17 < 0 || i17 >= iArrM66154a.length) {
            throw new IOException("Stream corrupted");
        }
        this.f51912u = iArrM66154a[i17];
        this.f51905n = 0;
        this.f51908q = 0;
        this.f51906o = 256;
        if (!this.f51896e) {
            return m66141F();
        }
        this.f51910s = 0;
        this.f51911t = 0;
        return m66144I();
    }

    /* renamed from: F */
    public final int m66141F() throws IOException {
        if (this.f51908q > this.f51893b) {
            this.f51901j = 5;
            m66149u();
            m66153z();
            return m66140E();
        }
        this.f51907p = this.f51906o;
        a aVar = this.f51914w;
        byte[] bArr = aVar.f51929o;
        int i10 = this.f51912u;
        int i11 = bArr[i10] & 255;
        this.f51906o = i11;
        m66134p(i10, aVar.f51928n.length, "su_tPos");
        this.f51912u = this.f51914w.f51928n[this.f51912u];
        this.f51908q++;
        this.f51901j = 6;
        this.f51897f.m66157c(i11);
        return i11;
    }

    /* renamed from: G */
    public final int m66142G() throws IOException {
        if (this.f51906o != this.f51907p) {
            this.f51905n = 1;
            return m66141F();
        }
        int i10 = this.f51905n + 1;
        this.f51905n = i10;
        if (i10 < 4) {
            return m66141F();
        }
        m66134p(this.f51912u, this.f51914w.f51929o.length, "su_tPos");
        a aVar = this.f51914w;
        byte[] bArr = aVar.f51929o;
        int i11 = this.f51912u;
        this.f51913v = (char) (bArr[i11] & 255);
        this.f51912u = aVar.f51928n[i11];
        this.f51909r = 0;
        return m66143H();
    }

    /* renamed from: H */
    public final int m66143H() throws IOException {
        if (this.f51909r >= this.f51913v) {
            this.f51908q++;
            this.f51905n = 0;
            return m66141F();
        }
        int i10 = this.f51906o;
        this.f51897f.m66157c(i10);
        this.f51909r++;
        this.f51901j = 7;
        return i10;
    }

    /* renamed from: I */
    public final int m66144I() throws IOException {
        if (this.f51908q > this.f51893b) {
            m66149u();
            m66153z();
            return m66140E();
        }
        this.f51907p = this.f51906o;
        a aVar = this.f51914w;
        byte[] bArr = aVar.f51929o;
        int i10 = this.f51912u;
        int i11 = bArr[i10] & 255;
        m66134p(i10, aVar.f51928n.length, "su_tPos");
        this.f51912u = this.f51914w.f51928n[this.f51912u];
        int i12 = this.f51910s;
        if (i12 == 0) {
            this.f51910s = C10961c.m66158a(this.f51911t) - 1;
            int i13 = this.f51911t + 1;
            this.f51911t = i13;
            if (i13 == 512) {
                this.f51911t = 0;
            }
        } else {
            this.f51910s = i12 - 1;
        }
        int i14 = i11 ^ (this.f51910s == 1 ? 1 : 0);
        this.f51906o = i14;
        this.f51908q++;
        this.f51901j = 3;
        this.f51897f.m66157c(i14);
        return i14;
    }

    /* renamed from: J */
    public final int m66145J() throws IOException {
        if (this.f51906o != this.f51907p) {
            this.f51901j = 2;
            this.f51905n = 1;
            return m66144I();
        }
        int i10 = this.f51905n + 1;
        this.f51905n = i10;
        if (i10 < 4) {
            this.f51901j = 2;
            return m66144I();
        }
        a aVar = this.f51914w;
        byte[] bArr = aVar.f51929o;
        int i11 = this.f51912u;
        this.f51913v = (char) (bArr[i11] & 255);
        m66134p(i11, aVar.f51928n.length, "su_tPos");
        this.f51912u = this.f51914w.f51928n[this.f51912u];
        int i12 = this.f51910s;
        if (i12 == 0) {
            this.f51910s = C10961c.m66158a(this.f51911t) - 1;
            int i13 = this.f51911t + 1;
            this.f51911t = i13;
            if (i13 == 512) {
                this.f51911t = 0;
            }
        } else {
            this.f51910s = i12 - 1;
        }
        this.f51909r = 0;
        this.f51901j = 4;
        if (this.f51910s == 1) {
            this.f51913v = (char) (this.f51913v ^ 1);
        }
        return m66146V();
    }

    /* renamed from: V */
    public final int m66146V() throws IOException {
        if (this.f51909r < this.f51913v) {
            this.f51897f.m66157c(this.f51906o);
            this.f51909r++;
            return this.f51906o;
        }
        this.f51901j = 2;
        this.f51908q++;
        this.f51905n = 0;
        return m66144I();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C11368b c11368b = this.f51899h;
        if (c11368b != null) {
            try {
                c11368b.close();
            } finally {
                this.f51914w = null;
                this.f51899h = null;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f51899h == null) {
            throw new IOException("Stream closed");
        }
        int iM66137B = m66137B();
        m65131d(iM66137B < 0 ? -1 : 1);
        return iM66137B;
    }

    /* renamed from: s */
    public final boolean m66147s() throws IOException {
        int iM66131m = m66131m(this.f51899h);
        this.f51903l = iM66131m;
        this.f51901j = 0;
        this.f51914w = null;
        if (iM66131m == this.f51904m) {
            return (this.f51900i && m66152y(false)) ? false : true;
        }
        throw new IOException("BZip2 CRC error");
    }

    /* renamed from: t */
    public final void m66148t(int i10, int i11) throws IOException {
        a aVar = this.f51914w;
        char[][] cArr = aVar.f51926l;
        int[] iArr = aVar.f51923i;
        int[][] iArr2 = aVar.f51920f;
        int[][] iArr3 = aVar.f51921g;
        int[][] iArr4 = aVar.f51922h;
        for (int i12 = 0; i12 < i11; i12++) {
            char[] cArr2 = cArr[i12];
            char c10 = ' ';
            int i13 = i10;
            char c11 = 0;
            while (true) {
                i13--;
                if (i13 >= 0) {
                    char c12 = cArr2[i13];
                    if (c12 > c11) {
                        c11 = c12;
                    }
                    if (c12 < c10) {
                        c10 = c12;
                    }
                }
            }
            m66135x(iArr2[i12], iArr3[i12], iArr4[i12], cArr[i12], c10, c11, i10);
            iArr[i12] = c10;
        }
    }

    /* renamed from: u */
    public final void m66149u() throws IOException {
        int iM66155a = this.f51897f.m66155a();
        int i10 = this.f51902k;
        if (i10 == iM66155a) {
            int i11 = this.f51904m;
            this.f51904m = iM66155a ^ ((i11 >>> 31) | (i11 << 1));
        } else {
            int i12 = this.f51903l;
            this.f51904m = ((i12 >>> 31) | (i12 << 1)) ^ i10;
            throw new IOException("BZip2 CRC error");
        }
    }

    /* renamed from: v */
    public final void m66150v() throws IOException {
        int i10;
        String str;
        char c10;
        int i11;
        C10959a c10959a = this;
        C11368b c11368b = c10959a.f51899h;
        c10959a.f51894c = m66133o(c11368b, 24);
        m66139D();
        a aVar = c10959a.f51914w;
        byte[] bArr = aVar.f51929o;
        int[] iArr = aVar.f51919e;
        byte[] bArr2 = aVar.f51917c;
        byte[] bArr3 = aVar.f51916b;
        char[] cArr = aVar.f51925k;
        int[] iArr2 = aVar.f51923i;
        int[][] iArr3 = aVar.f51920f;
        int[][] iArr4 = aVar.f51921g;
        int[][] iArr5 = aVar.f51922h;
        int i12 = c10959a.f51895d * 100000;
        int i13 = 256;
        while (true) {
            i13--;
            if (i13 < 0) {
                break;
            }
            cArr[i13] = (char) i13;
            iArr[i13] = 0;
        }
        int i14 = c10959a.f51898g + 1;
        int iM66151w = m66151w();
        int i15 = bArr2[0] & 255;
        m66134p(i15, 6, "zt");
        int[] iArr6 = iArr4[i15];
        int[] iArr7 = iArr3[i15];
        int[] iArr8 = iArr5[i15];
        int i16 = iArr2[i15];
        int i17 = iM66151w;
        int i18 = 49;
        int i19 = -1;
        int i20 = 0;
        while (i17 != i14) {
            int i21 = i14;
            String str2 = "groupNo";
            C11368b c11368b2 = c11368b;
            if (i17 == 0 || i17 == 1) {
                int[] iArr9 = iArr2;
                int i22 = i17;
                int i23 = i12;
                byte[] bArr4 = bArr;
                i17 = i22;
                int i24 = -1;
                int i25 = i18;
                int i26 = i20;
                int i27 = i16;
                int[] iArr10 = iArr8;
                int[] iArr11 = iArr7;
                int[] iArr12 = iArr6;
                int i28 = 1;
                while (true) {
                    if (i17 != 0) {
                        i10 = i19;
                        if (i17 != 1) {
                            break;
                        } else {
                            i24 += i28 << 1;
                        }
                    } else {
                        i24 += i28;
                        i10 = i19;
                    }
                    if (i25 == 0) {
                        int i29 = i26 + 1;
                        m66134p(i29, 18002, str2);
                        int i30 = bArr2[i29] & 255;
                        str = str2;
                        m66134p(i30, 6, "zt");
                        iArr12 = iArr4[i30];
                        iArr11 = iArr3[i30];
                        iArr10 = iArr5[i30];
                        i27 = iArr9[i30];
                        i26 = i29;
                        i25 = 49;
                    } else {
                        str = str2;
                        i25--;
                    }
                    int i31 = i27;
                    m66134p(i31, 258, "zn");
                    int iM66133o = m66133o(c11368b2, i31);
                    int i32 = i31;
                    while (iM66133o > iArr11[i32]) {
                        int i33 = i32 + 1;
                        m66134p(i33, 258, "zn");
                        iM66133o = (iM66133o << 1) | m66133o(c11368b2, 1);
                        i32 = i33;
                        iArr5 = iArr5;
                    }
                    int i34 = iM66133o - iArr12[i32];
                    m66134p(i34, 258, "zvec");
                    i28 <<= 1;
                    i17 = iArr10[i34];
                    i27 = i31;
                    i19 = i10;
                    str2 = str;
                    iArr5 = iArr5;
                }
                c10959a = this;
                int[][] iArr13 = iArr5;
                m66134p(i24, c10959a.f51914w.f51929o.length, "s");
                char c11 = cArr[0];
                m66134p(c11, 256, "yy");
                byte b10 = bArr3[c11];
                int i35 = b10 & 255;
                iArr[i35] = iArr[i35] + i24 + 1;
                int i36 = i10 + 1;
                int i37 = i24 + i36;
                m66134p(i37, c10959a.f51914w.f51929o.length, "lastShadow");
                Arrays.fill(bArr4, i36, i37 + 1, b10);
                if (i37 >= i23) {
                    throw new IOException("Block overrun while expanding RLE in MTF, " + i37 + " exceeds " + i23);
                }
                i19 = i37;
                iArr6 = iArr12;
                iArr7 = iArr11;
                iArr8 = iArr10;
                i16 = i27;
                i20 = i26;
                i14 = i21;
                i18 = i25;
                iArr2 = iArr9;
                bArr = bArr4;
                iArr5 = iArr13;
                i12 = i23;
                c11368b = c11368b2;
            } else {
                i19++;
                if (i19 >= i12) {
                    throw new IOException("Block overrun in MTF, " + i19 + " exceeds " + i12);
                }
                int i38 = i12;
                m66134p(i17, 257, "nextSym");
                int i39 = i17 - 1;
                char c12 = cArr[i39];
                int[] iArr14 = iArr2;
                m66134p(c12, 256, "yy");
                byte b11 = bArr3[c12];
                int i40 = b11 & 255;
                iArr[i40] = iArr[i40] + 1;
                bArr[i19] = b11;
                if (i17 <= 16) {
                    while (i39 > 0) {
                        int i41 = i39 - 1;
                        cArr[i39] = cArr[i41];
                        i39 = i41;
                    }
                    c10 = 0;
                } else {
                    c10 = 0;
                    System.arraycopy(cArr, 0, cArr, 1, i39);
                }
                cArr[c10] = c12;
                if (i18 == 0) {
                    int i42 = i20 + 1;
                    m66134p(i42, 18002, "groupNo");
                    int i43 = bArr2[i42] & 255;
                    m66134p(i43, 6, "zt");
                    int[] iArr15 = iArr4[i43];
                    int[] iArr16 = iArr3[i43];
                    int[] iArr17 = iArr5[i43];
                    i11 = iArr14[i43];
                    i20 = i42;
                    iArr6 = iArr15;
                    iArr7 = iArr16;
                    iArr8 = iArr17;
                    i18 = 49;
                } else {
                    i18--;
                    i11 = i16;
                }
                m66134p(i11, 258, "zn");
                int iM66133o2 = m66133o(c11368b2, i11);
                int i44 = i11;
                while (iM66133o2 > iArr7[i44]) {
                    i44++;
                    m66134p(i44, 258, "zn");
                    iM66133o2 = (iM66133o2 << 1) | m66133o(c11368b2, 1);
                }
                int i45 = iM66133o2 - iArr6[i44];
                m66134p(i45, 258, "zvec");
                i17 = iArr8[i45];
                i16 = i11;
                c11368b = c11368b2;
                i14 = i21;
                i12 = i38;
                iArr2 = iArr14;
                c10959a = this;
            }
        }
        c10959a.f51893b = i19;
    }

    /* renamed from: w */
    public final int m66151w() throws IOException {
        a aVar = this.f51914w;
        int i10 = aVar.f51917c[0] & 255;
        m66134p(i10, 6, "zt");
        int[] iArr = aVar.f51920f[i10];
        int i11 = aVar.f51923i[i10];
        m66134p(i11, 258, "zn");
        int iM66133o = m66133o(this.f51899h, i11);
        while (iM66133o > iArr[i11]) {
            i11++;
            m66134p(i11, 258, "zn");
            iM66133o = (iM66133o << 1) | m66133o(this.f51899h, 1);
        }
        int i12 = iM66133o - aVar.f51921g[i10][i11];
        m66134p(i12, 258, "zvec");
        return aVar.f51922h[i10][i12];
    }

    /* renamed from: y */
    public final boolean m66152y(boolean z10) throws IOException {
        C11368b c11368b = this.f51899h;
        if (c11368b == null) {
            throw new IOException("No InputStream");
        }
        if (!z10) {
            c11368b.m68212v();
        }
        int iM66138C = m66138C(this.f51899h);
        if (iM66138C == -1 && !z10) {
            return false;
        }
        int iM66138C2 = m66138C(this.f51899h);
        int iM66138C3 = m66138C(this.f51899h);
        if (iM66138C != 66 || iM66138C2 != 90 || iM66138C3 != 104) {
            throw new IOException(z10 ? "Stream is not in the BZip2 format" : "Garbage after a valid BZip2 stream");
        }
        int iM66138C4 = m66138C(this.f51899h);
        if (iM66138C4 < 49 || iM66138C4 > 57) {
            throw new IOException("BZip2 block size is invalid");
        }
        this.f51895d = iM66138C4 - 48;
        this.f51904m = 0;
        return true;
    }

    /* renamed from: z */
    public final void m66153z() throws IOException {
        C11368b c11368b = this.f51899h;
        do {
            char cM66132n = m66132n(c11368b);
            char cM66132n2 = m66132n(c11368b);
            char cM66132n3 = m66132n(c11368b);
            char cM66132n4 = m66132n(c11368b);
            char cM66132n5 = m66132n(c11368b);
            char cM66132n6 = m66132n(c11368b);
            if (cM66132n != 23 || cM66132n2 != 'r' || cM66132n3 != 'E' || cM66132n4 != '8' || cM66132n5 != 'P' || cM66132n6 != 144) {
                if (cM66132n != '1' || cM66132n2 != 'A' || cM66132n3 != 'Y' || cM66132n4 != '&' || cM66132n5 != 'S' || cM66132n6 != 'Y') {
                    this.f51901j = 0;
                    throw new IOException("Bad block header");
                }
                this.f51902k = m66131m(c11368b);
                this.f51896e = m66133o(c11368b, 1) == 1;
                if (this.f51914w == null) {
                    this.f51914w = new a(this.f51895d);
                }
                m66150v();
                this.f51897f.m66156b();
                this.f51901j = 1;
                return;
            }
        } while (!m66147s());
    }

    public C10959a(InputStream inputStream, boolean z10) throws IOException {
        this.f51897f = new C10960b();
        this.f51901j = 1;
        this.f51899h = new C11368b(inputStream == System.in ? C12249b.m73500g(inputStream) : inputStream, ByteOrder.BIG_ENDIAN);
        this.f51900i = z10;
        m66152y(true);
        m66153z();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("offs(" + i10 + ") < 0.");
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("len(" + i11 + ") < 0.");
        }
        int i12 = i10 + i11;
        if (i12 <= bArr.length) {
            if (this.f51899h == null) {
                throw new IOException("Stream closed");
            }
            if (i11 == 0) {
                return 0;
            }
            int i13 = i10;
            while (i13 < i12) {
                int iM66137B = m66137B();
                if (iM66137B < 0) {
                    break;
                }
                bArr[i13] = (byte) iM66137B;
                m65131d(1);
                i13++;
            }
            if (i13 == i10) {
                return -1;
            }
            return i13 - i10;
        }
        throw new IndexOutOfBoundsException("offs(" + i10 + ") + len(" + i11 + ") > dest.length(" + bArr.length + ").");
    }
}
