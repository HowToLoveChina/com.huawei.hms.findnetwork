package ky;

import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hms.network.embedded.C6130va;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import ly.C11368b;
import ly.C11370d;
import ly.C11373g;

/* renamed from: ky.b */
/* loaded from: classes9.dex */
public class C11202b implements Closeable {

    /* renamed from: f */
    public static final short[] f52529f = {96, 128, 160, 192, 224, 256, 288, 320, 353, 417, 481, 545, 610, 738, 866, 994, 1123, 1379, 1635, 1891, 2148, 2660, 3172, 3684, 4197, 5221, 6245, 7269, 112};

    /* renamed from: g */
    public static final int[] f52530g = {16, 32, 48, 64, 81, 113, 146, 210, 275, 403, 532, 788, 1045, 1557, 2070, 3094, 4119, 6167, 8216, 12312, 16409, 24601, 32794, 49178, 65563, 98331, 131100, 196636, 262173, 393245, 524318, 786462};

    /* renamed from: h */
    public static final int[] f52531h = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};

    /* renamed from: i */
    public static final int[] f52532i;

    /* renamed from: j */
    public static final int[] f52533j;

    /* renamed from: a */
    public boolean f52534a;

    /* renamed from: b */
    public c f52535b;

    /* renamed from: c */
    public C11368b f52536c;

    /* renamed from: d */
    public final InputStream f52537d;

    /* renamed from: e */
    public final d f52538e;

    /* renamed from: ky.b$b */
    public static final class b {

        /* renamed from: a */
        public final int f52539a;

        /* renamed from: b */
        public int f52540b;

        /* renamed from: c */
        public b f52541c;

        /* renamed from: d */
        public b f52542d;

        /* renamed from: a */
        public void m67232a(int i10) {
            this.f52540b = i10;
            this.f52541c = null;
            this.f52542d = null;
        }

        /* renamed from: b */
        public b m67233b() {
            if (this.f52541c == null && this.f52540b == -1) {
                this.f52541c = new b(this.f52539a + 1);
            }
            return this.f52541c;
        }

        /* renamed from: c */
        public b m67234c() {
            if (this.f52542d == null && this.f52540b == -1) {
                this.f52542d = new b(this.f52539a + 1);
            }
            return this.f52542d;
        }

        public b(int i10) {
            this.f52540b = -1;
            this.f52539a = i10;
        }
    }

    /* renamed from: ky.b$c */
    public static abstract class c {
        public c() {
        }

        /* renamed from: a */
        public abstract int mo67235a() throws IOException;

        /* renamed from: b */
        public abstract boolean mo67236b();

        /* renamed from: c */
        public abstract int mo67237c(byte[] bArr, int i10, int i11) throws IOException;

        /* renamed from: d */
        public abstract EnumC11203c mo67238d();
    }

    /* renamed from: ky.b$e */
    public final class e extends c {

        /* renamed from: a */
        public boolean f52547a;

        /* renamed from: b */
        public final EnumC11203c f52548b;

        /* renamed from: c */
        public final b f52549c;

        /* renamed from: d */
        public final b f52550d;

        /* renamed from: e */
        public int f52551e;

        /* renamed from: f */
        public byte[] f52552f;

        /* renamed from: g */
        public int f52553g;

        public e(EnumC11203c enumC11203c, int[] iArr, int[] iArr2) {
            super();
            this.f52552f = C11370d.f53098a;
            this.f52548b = enumC11203c;
            this.f52549c = C11202b.m67225w(iArr);
            this.f52550d = C11202b.m67225w(iArr2);
        }

        @Override // ky.C11202b.c
        /* renamed from: a */
        public int mo67235a() {
            return this.f52553g - this.f52551e;
        }

        @Override // ky.C11202b.c
        /* renamed from: b */
        public boolean mo67236b() {
            return !this.f52547a;
        }

        @Override // ky.C11202b.c
        /* renamed from: c */
        public int mo67237c(byte[] bArr, int i10, int i11) throws IOException {
            if (i11 == 0) {
                return 0;
            }
            return m67244f(bArr, i10, i11);
        }

        @Override // ky.C11202b.c
        /* renamed from: d */
        public EnumC11203c mo67238d() {
            return this.f52547a ? EnumC11203c.INITIAL : this.f52548b;
        }

        /* renamed from: e */
        public final int m67243e(byte[] bArr, int i10, int i11) {
            int i12 = this.f52553g - this.f52551e;
            if (i12 <= 0) {
                return 0;
            }
            int iMin = Math.min(i11, i12);
            System.arraycopy(this.f52552f, this.f52551e, bArr, i10, iMin);
            this.f52551e += iMin;
            return iMin;
        }

        /* renamed from: f */
        public final int m67244f(byte[] bArr, int i10, int i11) throws IOException {
            if (this.f52547a) {
                return -1;
            }
            int iM67243e = m67243e(bArr, i10, i11);
            while (true) {
                if (iM67243e < i11) {
                    int iM67214A = C11202b.m67214A(C11202b.this.f52536c, this.f52549c);
                    if (iM67214A >= 256) {
                        if (iM67214A <= 256) {
                            this.f52547a = true;
                            break;
                        }
                        short s10 = C11202b.f52529f[iM67214A - 257];
                        int iM68222a = C11373g.m68222a(s10 >>> 5, C11202b.this.m67227C(s10 & 31));
                        int i12 = C11202b.f52530g[C11202b.m67214A(C11202b.this.f52536c, this.f52550d)];
                        int iM68222a2 = C11373g.m68222a(i12 >>> 4, C11202b.this.m67227C(i12 & 15));
                        if (this.f52552f.length < iM68222a) {
                            this.f52552f = new byte[iM68222a];
                        }
                        this.f52553g = iM68222a;
                        this.f52551e = 0;
                        C11202b.this.f52538e.m67242d(iM68222a2, iM68222a, this.f52552f);
                        iM67243e += m67243e(bArr, i10 + iM67243e, i11 - iM67243e);
                    } else {
                        bArr[iM67243e + i10] = C11202b.this.f52538e.m67239a((byte) iM67214A);
                        iM67243e++;
                    }
                } else {
                    break;
                }
            }
            return iM67243e;
        }
    }

    /* renamed from: ky.b$f */
    public static final class f extends c {
        public f() {
            super();
        }

        @Override // ky.C11202b.c
        /* renamed from: a */
        public int mo67235a() {
            return 0;
        }

        @Override // ky.C11202b.c
        /* renamed from: b */
        public boolean mo67236b() {
            return false;
        }

        @Override // ky.C11202b.c
        /* renamed from: c */
        public int mo67237c(byte[] bArr, int i10, int i11) throws IOException {
            if (i11 == 0) {
                return 0;
            }
            throw new IllegalStateException("Cannot read in this state");
        }

        @Override // ky.C11202b.c
        /* renamed from: d */
        public EnumC11203c mo67238d() {
            return EnumC11203c.INITIAL;
        }
    }

    /* renamed from: ky.b$g */
    public final class g extends c {

        /* renamed from: a */
        public final long f52555a;

        /* renamed from: b */
        public long f52556b;

        @Override // ky.C11202b.c
        /* renamed from: a */
        public int mo67235a() throws IOException {
            return (int) Math.min(this.f52555a - this.f52556b, C11202b.this.f52536c.m68210t() / 8);
        }

        @Override // ky.C11202b.c
        /* renamed from: b */
        public boolean mo67236b() {
            return this.f52556b < this.f52555a;
        }

        @Override // ky.C11202b.c
        /* renamed from: c */
        public int mo67237c(byte[] bArr, int i10, int i11) throws IOException {
            int i12;
            int i13 = 0;
            if (i11 == 0) {
                return 0;
            }
            int iMin = (int) Math.min(this.f52555a - this.f52556b, i11);
            while (i13 < iMin) {
                if (C11202b.this.f52536c.m68211u() > 0) {
                    bArr[i10 + i13] = C11202b.this.f52538e.m67239a((byte) C11202b.this.m67227C(8));
                    i12 = 1;
                } else {
                    int i14 = i10 + i13;
                    i12 = C11202b.this.f52537d.read(bArr, i14, iMin - i13);
                    if (i12 == -1) {
                        throw new EOFException("Truncated Deflate64 Stream");
                    }
                    C11202b.this.f52538e.m67240b(bArr, i14, i12);
                }
                this.f52556b += i12;
                i13 += i12;
            }
            return iMin;
        }

        @Override // ky.C11202b.c
        /* renamed from: d */
        public EnumC11203c mo67238d() {
            return this.f52556b < this.f52555a ? EnumC11203c.STORED : EnumC11203c.INITIAL;
        }

        public g(long j10) {
            super();
            this.f52555a = j10;
        }
    }

    static {
        int[] iArr = new int[288];
        f52532i = iArr;
        Arrays.fill(iArr, 0, RecommendCardConstants.Num.PICTURE_SECOND_HEIGHT, 8);
        Arrays.fill(iArr, RecommendCardConstants.Num.PICTURE_SECOND_HEIGHT, 256, 9);
        Arrays.fill(iArr, 256, 280, 7);
        Arrays.fill(iArr, 280, 288, 8);
        int[] iArr2 = new int[32];
        f52533j = iArr2;
        Arrays.fill(iArr2, 5);
    }

    public C11202b(InputStream inputStream) {
        this.f52538e = new d();
        this.f52536c = new C11368b(inputStream, ByteOrder.LITTLE_ENDIAN);
        this.f52537d = inputStream;
        this.f52535b = new f();
    }

    /* renamed from: A */
    public static int m67214A(C11368b c11368b, b bVar) throws IOException {
        while (bVar != null && bVar.f52540b == -1) {
            bVar = m67216D(c11368b, 1) == 0 ? bVar.f52541c : bVar.f52542d;
        }
        if (bVar != null) {
            return bVar.f52540b;
        }
        return -1;
    }

    /* renamed from: B */
    public static void m67215B(C11368b c11368b, int[] iArr, int[] iArr2) throws IOException {
        long jM67216D;
        int iM67216D = (int) (m67216D(c11368b, 4) + 4);
        int[] iArr3 = new int[19];
        for (int i10 = 0; i10 < iM67216D; i10++) {
            iArr3[f52531h[i10]] = (int) m67216D(c11368b, 3);
        }
        b bVarM67225w = m67225w(iArr3);
        int length = iArr.length + iArr2.length;
        int[] iArr4 = new int[length];
        int i11 = -1;
        int i12 = 0;
        int iM67216D2 = 0;
        while (i12 < length) {
            if (iM67216D2 > 0) {
                iArr4[i12] = i11;
                iM67216D2--;
                i12++;
            } else {
                int iM67214A = m67214A(c11368b, bVarM67225w);
                if (iM67214A < 16) {
                    iArr4[i12] = iM67214A;
                    i12++;
                    i11 = iM67214A;
                } else {
                    long j10 = 3;
                    switch (iM67214A) {
                        case 16:
                            iM67216D2 = (int) (m67216D(c11368b, 2) + 3);
                            continue;
                        case 17:
                            jM67216D = m67216D(c11368b, 3);
                            break;
                        case 18:
                            jM67216D = m67216D(c11368b, 7);
                            j10 = 11;
                            break;
                    }
                    iM67216D2 = (int) (jM67216D + j10);
                    i11 = 0;
                }
            }
        }
        System.arraycopy(iArr4, 0, iArr, 0, iArr.length);
        System.arraycopy(iArr4, iArr.length, iArr2, 0, iArr2.length);
    }

    /* renamed from: D */
    public static long m67216D(C11368b c11368b, int i10) throws IOException {
        long jM68216z = c11368b.m68216z(i10);
        if (jM68216z != -1) {
            return jM68216z;
        }
        throw new EOFException("Truncated Deflate64 Stream");
    }

    /* renamed from: w */
    public static b m67225w(int[] iArr) {
        int[] iArrM67226z = m67226z(iArr);
        int i10 = 0;
        b bVar = new b(i10);
        while (i10 < iArr.length) {
            int i11 = iArr[i10];
            if (i11 != 0) {
                int i12 = i11 - 1;
                int i13 = iArrM67226z[i12];
                b bVarM67233b = bVar;
                for (int i14 = i12; i14 >= 0; i14--) {
                    bVarM67233b = ((1 << i14) & i13) == 0 ? bVarM67233b.m67233b() : bVarM67233b.m67234c();
                    if (bVarM67233b == null) {
                        throw new IllegalStateException("node doesn't exist in Huffman tree");
                    }
                }
                bVarM67233b.m67232a(i10);
                iArrM67226z[i12] = iArrM67226z[i12] + 1;
            }
            i10++;
        }
        return bVar;
    }

    /* renamed from: z */
    public static int[] m67226z(int[] iArr) {
        int[] iArr2 = new int[65];
        int iMax = 0;
        for (int i10 : iArr) {
            if (i10 < 0 || i10 > 64) {
                throw new IllegalArgumentException("Invalid code " + i10 + " in literal table");
            }
            iMax = Math.max(iMax, i10);
            iArr2[i10] = iArr2[i10] + 1;
        }
        int i11 = iMax + 1;
        int[] iArrCopyOf = Arrays.copyOf(iArr2, i11);
        int[] iArr3 = new int[i11];
        int i12 = 0;
        for (int i13 = 0; i13 <= iMax; i13++) {
            i12 = (i12 + iArrCopyOf[i13]) << 1;
            iArr3[i13] = i12;
        }
        return iArr3;
    }

    /* renamed from: C */
    public final long m67227C(int i10) throws IOException {
        return m67216D(this.f52536c, i10);
    }

    /* renamed from: E */
    public final int[][] m67228E() throws IOException {
        int[][] iArr = {new int[(int) (m67227C(5) + 257)], new int[(int) (m67227C(5) + 1)]};
        m67215B(this.f52536c, iArr[0], iArr[1]);
        return iArr;
    }

    /* renamed from: F */
    public final void m67229F() throws IOException {
        this.f52536c.m68209s();
        long jM67227C = m67227C(16);
        if ((C6130va.f28792s & (jM67227C ^ C6130va.f28792s)) != m67227C(16)) {
            throw new IllegalStateException("Illegal LEN / NLEN values");
        }
        this.f52535b = new g(jM67227C);
    }

    public int available() throws IOException {
        return this.f52535b.mo67235a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f52535b = new f();
        this.f52536c = null;
    }

    /* renamed from: x */
    public int m67230x(byte[] bArr, int i10, int i11) throws IOException {
        while (true) {
            if (this.f52534a && !this.f52535b.mo67236b()) {
                return -1;
            }
            if (this.f52535b.mo67238d() == EnumC11203c.INITIAL) {
                this.f52534a = m67227C(1) == 1;
                int iM67227C = (int) m67227C(2);
                if (iM67227C == 0) {
                    m67229F();
                } else if (iM67227C == 1) {
                    this.f52535b = new e(EnumC11203c.FIXED_CODES, f52532i, f52533j);
                } else {
                    if (iM67227C != 2) {
                        throw new IllegalStateException("Unsupported compression: " + iM67227C);
                    }
                    int[][] iArrM67228E = m67228E();
                    this.f52535b = new e(EnumC11203c.DYNAMIC_CODES, iArrM67228E[0], iArrM67228E[1]);
                }
            } else {
                int iMo67237c = this.f52535b.mo67237c(bArr, i10, i11);
                if (iMo67237c != 0) {
                    return iMo67237c;
                }
            }
        }
    }

    /* renamed from: y */
    public long m67231y() {
        return this.f52536c.m68214x();
    }

    /* renamed from: ky.b$d */
    public static final class d {

        /* renamed from: a */
        public final byte[] f52543a;

        /* renamed from: b */
        public final int f52544b;

        /* renamed from: c */
        public int f52545c;

        /* renamed from: d */
        public boolean f52546d;

        public d() {
            this(16);
        }

        /* renamed from: a */
        public byte m67239a(byte b10) {
            byte[] bArr = this.f52543a;
            int i10 = this.f52545c;
            bArr[i10] = b10;
            this.f52545c = m67241c(i10);
            return b10;
        }

        /* renamed from: b */
        public void m67240b(byte[] bArr, int i10, int i11) {
            for (int i12 = i10; i12 < i10 + i11; i12++) {
                m67239a(bArr[i12]);
            }
        }

        /* renamed from: c */
        public final int m67241c(int i10) {
            int i11 = (i10 + 1) & this.f52544b;
            if (!this.f52546d && i11 < i10) {
                this.f52546d = true;
            }
            return i11;
        }

        /* renamed from: d */
        public void m67242d(int i10, int i11, byte[] bArr) {
            if (i10 > this.f52543a.length) {
                throw new IllegalStateException("Illegal distance parameter: " + i10);
            }
            int i12 = this.f52545c;
            int iM67241c = (i12 - i10) & this.f52544b;
            if (!this.f52546d && iM67241c >= i12) {
                throw new IllegalStateException("Attempt to read beyond memory: dist=" + i10);
            }
            int i13 = 0;
            while (i13 < i11) {
                bArr[i13] = m67239a(this.f52543a[iM67241c]);
                i13++;
                iM67241c = m67241c(iM67241c);
            }
        }

        public d(int i10) {
            byte[] bArr = new byte[1 << i10];
            this.f52543a = bArr;
            this.f52544b = bArr.length - 1;
        }
    }
}
