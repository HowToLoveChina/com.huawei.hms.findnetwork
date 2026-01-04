package p022ay;

import ax.C1034d;
import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import cy.C8962a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kw.C11175g;
import p692uw.C13267j;

/* renamed from: ay.d */
/* loaded from: classes9.dex */
public final class C1054d implements InterfaceC1056f, InterfaceC1055e, Cloneable, ByteChannel {

    /* renamed from: a */
    public C1071u f5125a;

    /* renamed from: b */
    public long f5126b;

    /* renamed from: ay.d$a */
    public static final class a implements Closeable {

        /* renamed from: a */
        public C1054d f5127a;

        /* renamed from: b */
        public C1071u f5128b;

        /* renamed from: d */
        public byte[] f5130d;

        /* renamed from: c */
        public long f5129c = -1;

        /* renamed from: e */
        public int f5131e = -1;

        /* renamed from: f */
        public int f5132f = -1;

        /* renamed from: b */
        public final void m6362b(C1071u c1071u) {
            this.f5128b = c1071u;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5127a == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.f5127a = null;
            m6362b(null);
            this.f5129c = -1L;
            this.f5130d = null;
            this.f5131e = -1;
            this.f5132f = -1;
        }
    }

    /* renamed from: A */
    public byte[] m6311A() {
        return mo6346l0(m6322J());
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: A0 */
    public OutputStream mo6312A0() {
        return new c();
    }

    /* renamed from: B */
    public C1057g m6313B() {
        return mo6345l(m6322J());
    }

    /* renamed from: C */
    public int m6314C() throws EOFException {
        return C1051b.m6296d(readInt());
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a7 A[EDGE_INSN: B:92:0x00a7->B:86:0x00a7 BREAK  A[LOOP:0: B:54:0x000d->B:94:?], SYNTHETIC] */
    @Override // p022ay.InterfaceC1056f
    /* renamed from: C0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo6315C0() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.m6322J()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb1
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            ay.u r6 = r14.f5125a
            p692uw.C13267j.m79674b(r6)
            byte[] r7 = r6.f5167a
            int r8 = r6.f5168b
            int r9 = r6.f5169c
        L18:
            if (r8 >= r9) goto L93
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L27
            r11 = 57
            if (r10 > r11) goto L27
            int r11 = r10 + (-48)
            goto L3c
        L27:
            r11 = 97
            if (r10 < r11) goto L32
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L32
            int r11 = r10 + (-87)
            goto L3c
        L32:
            r11 = 65
            if (r10 < r11) goto L74
            r11 = 70
            if (r10 > r11) goto L74
            int r11 = r10 + (-55)
        L3c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L4c:
            ay.d r14 = new ay.d
            r14.<init>()
            ay.d r14 = r14.mo6333W(r4)
            ay.d r14 = r14.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r14 = r14.m6319F()
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r0.<init>(r14)
            throw r0
        L74:
            if (r0 == 0) goto L78
            r1 = 1
            goto L93
        L78:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = p022ay.C1051b.m6298f(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L93:
            if (r8 != r9) goto L9f
            ay.u r7 = r6.m6435b()
            r14.f5125a = r7
            p022ay.C1072v.m6440b(r6)
            goto La1
        L9f:
            r6.f5168b = r8
        La1:
            if (r1 != 0) goto La7
            ay.u r6 = r14.f5125a
            if (r6 != 0) goto Ld
        La7:
            long r1 = r14.m6322J()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.m6321H(r1)
            return r4
        Lb1:
            java.io.EOFException r14 = new java.io.EOFException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: p022ay.C1054d.mo6315C0():long");
    }

    /* renamed from: D */
    public short m6316D() throws EOFException {
        return C1051b.m6297e(readShort());
    }

    /* renamed from: E */
    public String m6317E(long j10, Charset charset) throws EOFException {
        C13267j.m79677e(charset, "charset");
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (this.f5126b < j10) {
            throw new EOFException();
        }
        if (j10 == 0) {
            return "";
        }
        C1071u c1071u = this.f5125a;
        C13267j.m79674b(c1071u);
        int i10 = c1071u.f5168b;
        if (i10 + j10 > c1071u.f5169c) {
            return new String(mo6346l0(j10), charset);
        }
        int i11 = (int) j10;
        String str = new String(c1071u.f5167a, i10, i11, charset);
        int i12 = c1071u.f5168b + i11;
        c1071u.f5168b = i12;
        this.f5126b -= j10;
        if (i12 == c1071u.f5169c) {
            this.f5125a = c1071u.m6435b();
            C1072v.m6440b(c1071u);
        }
        return str;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: E0 */
    public InputStream mo6318E0() {
        return new b();
    }

    /* renamed from: F */
    public String m6319F() {
        return m6317E(this.f5126b, C1034d.f5099b);
    }

    /* renamed from: G */
    public String m6320G(long j10) throws EOFException {
        return m6317E(j10, C1034d.f5099b);
    }

    /* renamed from: H */
    public final void m6321H(long j10) {
        this.f5126b = j10;
    }

    /* renamed from: J */
    public final long m6322J() {
        return this.f5126b;
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: K */
    public C1054d mo6323K() {
        return this;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: L */
    public C1054d mo6324L() {
        return this;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: M */
    public boolean mo6325M() {
        return this.f5126b == 0;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: O */
    public String mo6327O(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j10).toString());
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long jM6361z = m6361z((byte) 10, 0L, j11);
        if (jM6361z != -1) {
            return C8962a.m56716b(this, jM6361z);
        }
        if (j11 < m6322J() && m6359y(j11 - 1) == 13 && m6359y(j11) == 10) {
            return C8962a.m56716b(this, j11);
        }
        C1054d c1054d = new C1054d();
        m6356w(c1054d, 0L, Math.min(32, m6322J()));
        throw new EOFException("\\n not found: limit=" + Math.min(m6322J(), j10) + " content=" + c1054d.m6313B().mo6384u() + (char) 8230);
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: P */
    public long mo6328P(InterfaceC1076z interfaceC1076z) throws IOException {
        C13267j.m79677e(interfaceC1076z, "source");
        long j10 = 0;
        while (true) {
            long j11 = interfaceC1076z.read(this, 8192L);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
        }
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: S */
    public int mo6330S(C1067q c1067q) throws EOFException {
        C13267j.m79677e(c1067q, "options");
        int iM56718d = C8962a.m56718d(this, c1067q, false, 2, null);
        if (iM56718d == -1) {
            return -1;
        }
        skip(c1067q.m6421d()[iM56718d].m6370E());
        return iM56718d;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: T */
    public String mo6331T(Charset charset) {
        C13267j.m79677e(charset, "charset");
        return m6317E(this.f5126b, charset);
    }

    /* renamed from: V */
    public final C1057g m6332V() {
        if (m6322J() <= 2147483647L) {
            return m6334X((int) m6322J());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + m6322J()).toString());
    }

    /* renamed from: X */
    public final C1057g m6334X(int i10) {
        if (i10 == 0) {
            return C1057g.f5136e;
        }
        C1051b.m6294b(m6322J(), 0L, i10);
        C1071u c1071u = this.f5125a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            C13267j.m79674b(c1071u);
            int i14 = c1071u.f5169c;
            int i15 = c1071u.f5168b;
            if (i14 == i15) {
                throw new AssertionError("s.limit == s.pos");
            }
            i12 += i14 - i15;
            i13++;
            c1071u = c1071u.f5172f;
        }
        byte[][] bArr = new byte[i13][];
        int[] iArr = new int[i13 * 2];
        C1071u c1071u2 = this.f5125a;
        int i16 = 0;
        while (i11 < i10) {
            C13267j.m79674b(c1071u2);
            bArr[i16] = c1071u2.f5167a;
            i11 += c1071u2.f5169c - c1071u2.f5168b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = c1071u2.f5168b;
            c1071u2.f5170d = true;
            i16++;
            c1071u2 = c1071u2.f5172f;
        }
        return new C1073w(bArr, iArr);
    }

    /* renamed from: Y */
    public final C1071u m6335Y(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        C1071u c1071u = this.f5125a;
        if (c1071u == null) {
            C1071u c1071uM6441c = C1072v.m6441c();
            this.f5125a = c1071uM6441c;
            c1071uM6441c.f5173g = c1071uM6441c;
            c1071uM6441c.f5172f = c1071uM6441c;
            return c1071uM6441c;
        }
        C13267j.m79674b(c1071u);
        C1071u c1071uM6436c = c1071u.f5173g;
        C13267j.m79674b(c1071uM6436c);
        if (c1071uM6436c.f5169c + i10 > 8192 || !c1071uM6436c.f5171e) {
            c1071uM6436c = c1071uM6436c.m6436c(C1072v.m6441c());
        }
        return c1071uM6436c;
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: Z */
    public C1054d mo6337a(C1057g c1057g) {
        C13267j.m79677e(c1057g, "byteString");
        c1057g.mo6375J(this, 0, c1057g.m6370E());
        return this;
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: a0 */
    public C1054d write(byte[] bArr) {
        C13267j.m79677e(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: b0 */
    public C1054d write(byte[] bArr, int i10, int i11) {
        C13267j.m79677e(bArr, "source");
        long j10 = i11;
        C1051b.m6294b(bArr.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            C1071u c1071uM6335Y = m6335Y(1);
            int iMin = Math.min(i12 - i10, 8192 - c1071uM6335Y.f5169c);
            int i13 = i10 + iMin;
            C11175g.m67143c(bArr, c1071uM6335Y.f5167a, c1071uM6335Y.f5169c, i10, i13);
            c1071uM6335Y.f5169c += iMin;
            i10 = i13;
        }
        m6321H(m6322J() + j10);
        return this;
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: c0 */
    public C1054d writeByte(int i10) {
        C1071u c1071uM6335Y = m6335Y(1);
        byte[] bArr = c1071uM6335Y.f5167a;
        int i11 = c1071uM6335Y.f5169c;
        c1071uM6335Y.f5169c = i11 + 1;
        bArr[i11] = (byte) i10;
        m6321H(m6322J() + 1);
        return this;
    }

    @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1054d) {
            C1054d c1054d = (C1054d) obj;
            if (m6322J() == c1054d.m6322J()) {
                if (m6322J() == 0) {
                    return true;
                }
                C1071u c1071u = this.f5125a;
                C13267j.m79674b(c1071u);
                C1071u c1071u2 = c1054d.f5125a;
                C13267j.m79674b(c1071u2);
                int i10 = c1071u.f5168b;
                int i11 = c1071u2.f5168b;
                long j10 = 0;
                while (j10 < m6322J()) {
                    long jMin = Math.min(c1071u.f5169c - i10, c1071u2.f5169c - i11);
                    long j11 = 0;
                    while (j11 < jMin) {
                        int i12 = i10 + 1;
                        int i13 = i11 + 1;
                        if (c1071u.f5167a[i10] == c1071u2.f5167a[i11]) {
                            j11++;
                            i10 = i12;
                            i11 = i13;
                        }
                    }
                    if (i10 == c1071u.f5169c) {
                        c1071u = c1071u.f5172f;
                        C13267j.m79674b(c1071u);
                        i10 = c1071u.f5168b;
                    }
                    if (i11 == c1071u2.f5169c) {
                        c1071u2 = c1071u2.f5172f;
                        C13267j.m79674b(c1071u2);
                        i11 = c1071u2.f5168b;
                    }
                    j10 += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: f0 */
    public String mo6341f0() throws EOFException {
        return mo6327O(Long.MAX_VALUE);
    }

    @Override // p022ay.InterfaceC1055e, p022ay.InterfaceC1074x, java.io.Flushable
    public void flush() {
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: g0 */
    public C1054d mo6360y0(long j10) {
        boolean z10;
        if (j10 == 0) {
            return writeByte(48);
        }
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return mo6329R("-9223372036854775808");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 >= 100000000) {
            i10 = j10 < 1000000000000L ? j10 < 10000000000L ? j10 < 1000000000 ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= 10000) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z10) {
            i10++;
        }
        C1071u c1071uM6335Y = m6335Y(i10);
        byte[] bArr = c1071uM6335Y.f5167a;
        int i11 = c1071uM6335Y.f5169c + i10;
        while (j10 != 0) {
            long j11 = 10;
            i11--;
            bArr[i11] = C8962a.m56715a()[(int) (j10 % j11)];
            j10 /= j11;
        }
        if (z10) {
            bArr[i11 - 1] = 45;
        }
        c1071uM6335Y.f5169c += i10;
        m6321H(m6322J() + i10);
        return this;
    }

    public int hashCode() {
        C1071u c1071u = this.f5125a;
        if (c1071u == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = c1071u.f5169c;
            for (int i12 = c1071u.f5168b; i12 < i11; i12++) {
                i10 = (i10 * 31) + c1071u.f5167a[i12];
            }
            c1071u = c1071u.f5172f;
            C13267j.m79674b(c1071u);
        } while (c1071u != this.f5125a);
        return i10;
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: i0 */
    public C1054d mo6333W(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        long j11 = (j10 >>> 1) | j10;
        long j12 = j11 | (j11 >>> 2);
        long j13 = j12 | (j12 >>> 4);
        long j14 = j13 | (j13 >>> 8);
        long j15 = j14 | (j14 >>> 16);
        long j16 = j15 | (j15 >>> 32);
        long j17 = j16 - ((j16 >>> 1) & 6148914691236517205L);
        long j18 = ((j17 >>> 2) & 3689348814741910323L) + (j17 & 3689348814741910323L);
        long j19 = ((j18 >>> 4) + j18) & 1085102592571150095L;
        long j20 = j19 + (j19 >>> 8);
        long j21 = j20 + (j20 >>> 16);
        int i10 = (int) ((((j21 & 63) + ((j21 >>> 32) & 63)) + 3) / 4);
        C1071u c1071uM6335Y = m6335Y(i10);
        byte[] bArr = c1071uM6335Y.f5167a;
        int i11 = c1071uM6335Y.f5169c;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = C8962a.m56715a()[(int) (15 & j10)];
            j10 >>>= 4;
        }
        c1071uM6335Y.f5169c += i10;
        m6321H(m6322J() + i10);
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: j0 */
    public C1054d writeInt(int i10) {
        C1071u c1071uM6335Y = m6335Y(4);
        byte[] bArr = c1071uM6335Y.f5167a;
        int i11 = c1071uM6335Y.f5169c;
        bArr[i11] = (byte) ((i10 >>> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr[i11 + 3] = (byte) (i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        c1071uM6335Y.f5169c = i11 + 4;
        m6321H(m6322J() + 4);
        return this;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: l */
    public C1057g mo6345l(long j10) throws EOFException {
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (m6322J() < j10) {
            throw new EOFException();
        }
        if (j10 < ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) {
            return new C1057g(mo6346l0(j10));
        }
        C1057g c1057gM6334X = m6334X((int) j10);
        skip(j10);
        return c1057gM6334X;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: l0 */
    public byte[] mo6346l0(long j10) throws EOFException {
        if (j10 < 0 || j10 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j10).toString());
        }
        if (m6322J() < j10) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j10];
        readFully(bArr);
        return bArr;
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: m0 */
    public C1054d writeShort(int i10) {
        C1071u c1071uM6335Y = m6335Y(2);
        byte[] bArr = c1071uM6335Y.f5167a;
        int i11 = c1071uM6335Y.f5169c;
        bArr[i11] = (byte) ((i10 >>> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr[i11 + 1] = (byte) (i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        c1071uM6335Y.f5169c = i11 + 2;
        m6321H(m6322J() + 2);
        return this;
    }

    /* renamed from: n0 */
    public C1054d m6348n0(String str, int i10, int i11, Charset charset) {
        C13267j.m79677e(str, ExtractOWiFiHelper.STING_NODE);
        C13267j.m79677e(charset, "charset");
        if (i10 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        if (i11 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + str.length()).toString());
        }
        if (C13267j.m79673a(charset, C1034d.f5099b)) {
            return m6350q0(str, i10, i11);
        }
        String strSubstring = str.substring(i10, i11);
        C13267j.m79676d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        C13267j.m79676d(bytes, "this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: o0 */
    public C1054d mo6329R(String str) {
        C13267j.m79677e(str, ExtractOWiFiHelper.STING_NODE);
        return m6350q0(str, 0, str.length());
    }

    /* renamed from: q0 */
    public C1054d m6350q0(String str, int i10, int i11) {
        char cCharAt;
        C13267j.m79677e(str, ExtractOWiFiHelper.STING_NODE);
        if (i10 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        if (i11 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + str.length()).toString());
        }
        while (i10 < i11) {
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 128) {
                C1071u c1071uM6335Y = m6335Y(1);
                byte[] bArr = c1071uM6335Y.f5167a;
                int i12 = c1071uM6335Y.f5169c - i10;
                int iMin = Math.min(i11, 8192 - i12);
                int i13 = i10 + 1;
                bArr[i10 + i12] = (byte) cCharAt2;
                while (true) {
                    i10 = i13;
                    if (i10 >= iMin || (cCharAt = str.charAt(i10)) >= 128) {
                        break;
                    }
                    i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) cCharAt;
                }
                int i14 = c1071uM6335Y.f5169c;
                int i15 = (i12 + i10) - i14;
                c1071uM6335Y.f5169c = i14 + i15;
                m6321H(m6322J() + i15);
            } else {
                if (cCharAt2 < 2048) {
                    C1071u c1071uM6335Y2 = m6335Y(2);
                    byte[] bArr2 = c1071uM6335Y2.f5167a;
                    int i16 = c1071uM6335Y2.f5169c;
                    bArr2[i16] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i16 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    c1071uM6335Y2.f5169c = i16 + 2;
                    m6321H(m6322J() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    C1071u c1071uM6335Y3 = m6335Y(3);
                    byte[] bArr3 = c1071uM6335Y3.f5167a;
                    int i17 = c1071uM6335Y3.f5169c;
                    bArr3[i17] = (byte) ((cCharAt2 >> '\f') | Constant.ERROR_WSS_INVALID);
                    bArr3[i17 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i17 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    c1071uM6335Y3.f5169c = i17 + 3;
                    m6321H(m6322J() + 3);
                } else {
                    int i18 = i10 + 1;
                    char cCharAt3 = i18 < i11 ? str.charAt(i18) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        writeByte(63);
                        i10 = i18;
                    } else {
                        int i19 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        C1071u c1071uM6335Y4 = m6335Y(4);
                        byte[] bArr4 = c1071uM6335Y4.f5167a;
                        int i20 = c1071uM6335Y4.f5169c;
                        bArr4[i20] = (byte) ((i19 >> 18) | 240);
                        bArr4[i20 + 1] = (byte) (((i19 >> 12) & 63) | 128);
                        bArr4[i20 + 2] = (byte) (((i19 >> 6) & 63) | 128);
                        bArr4[i20 + 3] = (byte) ((i19 & 63) | 128);
                        c1071uM6335Y4.f5169c = i20 + 4;
                        m6321H(m6322J() + 4);
                        i10 += 2;
                    }
                }
                i10++;
            }
        }
        return this;
    }

    /* renamed from: r0 */
    public C1054d m6351r0(int i10) {
        if (i10 < 128) {
            writeByte(i10);
        } else if (i10 < 2048) {
            C1071u c1071uM6335Y = m6335Y(2);
            byte[] bArr = c1071uM6335Y.f5167a;
            int i11 = c1071uM6335Y.f5169c;
            bArr[i11] = (byte) ((i10 >> 6) | 192);
            bArr[i11 + 1] = (byte) ((i10 & 63) | 128);
            c1071uM6335Y.f5169c = i11 + 2;
            m6321H(m6322J() + 2);
        } else if (55296 <= i10 && i10 < 57344) {
            writeByte(63);
        } else if (i10 < 65536) {
            C1071u c1071uM6335Y2 = m6335Y(3);
            byte[] bArr2 = c1071uM6335Y2.f5167a;
            int i12 = c1071uM6335Y2.f5169c;
            bArr2[i12] = (byte) ((i10 >> 12) | Constant.ERROR_WSS_INVALID);
            bArr2[i12 + 1] = (byte) (((i10 >> 6) & 63) | 128);
            bArr2[i12 + 2] = (byte) ((i10 & 63) | 128);
            c1071uM6335Y2.f5169c = i12 + 3;
            m6321H(m6322J() + 3);
        } else {
            if (i10 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + C1051b.m6299g(i10));
            }
            C1071u c1071uM6335Y3 = m6335Y(4);
            byte[] bArr3 = c1071uM6335Y3.f5167a;
            int i13 = c1071uM6335Y3.f5169c;
            bArr3[i13] = (byte) ((i10 >> 18) | 240);
            bArr3[i13 + 1] = (byte) (((i10 >> 12) & 63) | 128);
            bArr3[i13 + 2] = (byte) (((i10 >> 6) & 63) | 128);
            bArr3[i13 + 3] = (byte) ((i10 & 63) | 128);
            c1071uM6335Y3.f5169c = i13 + 4;
            m6321H(m6322J() + 4);
        }
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        C13267j.m79677e(byteBuffer, "sink");
        C1071u c1071u = this.f5125a;
        if (c1071u == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), c1071u.f5169c - c1071u.f5168b);
        byteBuffer.put(c1071u.f5167a, c1071u.f5168b, iMin);
        int i10 = c1071u.f5168b + iMin;
        c1071u.f5168b = i10;
        this.f5126b -= iMin;
        if (i10 == c1071u.f5169c) {
            this.f5125a = c1071u.m6435b();
            C1072v.m6440b(c1071u);
        }
        return iMin;
    }

    @Override // p022ay.InterfaceC1056f
    public byte readByte() throws EOFException {
        if (m6322J() == 0) {
            throw new EOFException();
        }
        C1071u c1071u = this.f5125a;
        C13267j.m79674b(c1071u);
        int i10 = c1071u.f5168b;
        int i11 = c1071u.f5169c;
        int i12 = i10 + 1;
        byte b10 = c1071u.f5167a[i10];
        m6321H(m6322J() - 1);
        if (i12 == i11) {
            this.f5125a = c1071u.m6435b();
            C1072v.m6440b(c1071u);
        } else {
            c1071u.f5168b = i12;
        }
        return b10;
    }

    @Override // p022ay.InterfaceC1056f
    public void readFully(byte[] bArr) throws EOFException {
        C13267j.m79677e(bArr, "sink");
        int i10 = 0;
        while (i10 < bArr.length) {
            int i11 = read(bArr, i10, bArr.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    @Override // p022ay.InterfaceC1056f
    public int readInt() throws EOFException {
        if (m6322J() < 4) {
            throw new EOFException();
        }
        C1071u c1071u = this.f5125a;
        C13267j.m79674b(c1071u);
        int i10 = c1071u.f5168b;
        int i11 = c1071u.f5169c;
        if (i11 - i10 < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = c1071u.f5167a;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        m6321H(m6322J() - 4);
        if (i14 == i11) {
            this.f5125a = c1071u.m6435b();
            C1072v.m6440b(c1071u);
        } else {
            c1071u.f5168b = i14;
        }
        return i15;
    }

    @Override // p022ay.InterfaceC1056f
    public short readShort() throws EOFException {
        if (m6322J() < 2) {
            throw new EOFException();
        }
        C1071u c1071u = this.f5125a;
        C13267j.m79674b(c1071u);
        int i10 = c1071u.f5168b;
        int i11 = c1071u.f5169c;
        if (i11 - i10 < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = c1071u.f5167a;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        m6321H(m6322J() - 2);
        if (i14 == i11) {
            this.f5125a = c1071u.m6435b();
            C1072v.m6440b(c1071u);
        } else {
            c1071u.f5168b = i14;
        }
        return (short) i15;
    }

    /* renamed from: s */
    public final void m6352s() throws EOFException {
        skip(m6322J());
    }

    @Override // p022ay.InterfaceC1056f
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            C1071u c1071u = this.f5125a;
            if (c1071u == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, c1071u.f5169c - c1071u.f5168b);
            long j11 = iMin;
            m6321H(m6322J() - j11);
            j10 -= j11;
            int i10 = c1071u.f5168b + iMin;
            c1071u.f5168b = i10;
            if (i10 == c1071u.f5169c) {
                this.f5125a = c1071u.m6435b();
                C1072v.m6440b(c1071u);
            }
        }
    }

    /* renamed from: t */
    public C1054d clone() {
        return m6355v();
    }

    @Override // p022ay.InterfaceC1076z
    public C1050a0 timeout() {
        return C1050a0.NONE;
    }

    public String toString() {
        return m6332V().toString();
    }

    /* renamed from: u */
    public final long m6354u() {
        long jM6322J = m6322J();
        if (jM6322J == 0) {
            return 0L;
        }
        C1071u c1071u = this.f5125a;
        C13267j.m79674b(c1071u);
        C1071u c1071u2 = c1071u.f5173g;
        C13267j.m79674b(c1071u2);
        if (c1071u2.f5169c < 8192 && c1071u2.f5171e) {
            jM6322J -= r2 - c1071u2.f5168b;
        }
        return jM6322J;
    }

    /* renamed from: v */
    public final C1054d m6355v() {
        C1054d c1054d = new C1054d();
        if (m6322J() != 0) {
            C1071u c1071u = this.f5125a;
            C13267j.m79674b(c1071u);
            C1071u c1071uM6437d = c1071u.m6437d();
            c1054d.f5125a = c1071uM6437d;
            c1071uM6437d.f5173g = c1071uM6437d;
            c1071uM6437d.f5172f = c1071uM6437d;
            for (C1071u c1071u2 = c1071u.f5172f; c1071u2 != c1071u; c1071u2 = c1071u2.f5172f) {
                C1071u c1071u3 = c1071uM6437d.f5173g;
                C13267j.m79674b(c1071u3);
                C13267j.m79674b(c1071u2);
                c1071u3.m6436c(c1071u2.m6437d());
            }
            c1054d.m6321H(m6322J());
        }
        return c1054d;
    }

    /* renamed from: w */
    public final C1054d m6356w(C1054d c1054d, long j10, long j11) {
        C13267j.m79677e(c1054d, "out");
        C1051b.m6294b(m6322J(), j10, j11);
        if (j11 != 0) {
            c1054d.m6321H(c1054d.m6322J() + j11);
            C1071u c1071u = this.f5125a;
            while (true) {
                C13267j.m79674b(c1071u);
                int i10 = c1071u.f5169c;
                int i11 = c1071u.f5168b;
                if (j10 < i10 - i11) {
                    break;
                }
                j10 -= i10 - i11;
                c1071u = c1071u.f5172f;
            }
            while (j11 > 0) {
                C13267j.m79674b(c1071u);
                C1071u c1071uM6437d = c1071u.m6437d();
                int i12 = c1071uM6437d.f5168b + ((int) j10);
                c1071uM6437d.f5168b = i12;
                c1071uM6437d.f5169c = Math.min(i12 + ((int) j11), c1071uM6437d.f5169c);
                C1071u c1071u2 = c1054d.f5125a;
                if (c1071u2 == null) {
                    c1071uM6437d.f5173g = c1071uM6437d;
                    c1071uM6437d.f5172f = c1071uM6437d;
                    c1054d.f5125a = c1071uM6437d;
                } else {
                    C13267j.m79674b(c1071u2);
                    C1071u c1071u3 = c1071u2.f5173g;
                    C13267j.m79674b(c1071u3);
                    c1071u3.m6436c(c1071uM6437d);
                }
                j11 -= c1071uM6437d.f5169c - c1071uM6437d.f5168b;
                c1071u = c1071u.f5172f;
                j10 = 0;
            }
        }
        return this;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: w0 */
    public void mo6357w0(long j10) throws EOFException {
        if (this.f5126b < j10) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        C13267j.m79677e(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            C1071u c1071uM6335Y = m6335Y(1);
            int iMin = Math.min(i10, 8192 - c1071uM6335Y.f5169c);
            byteBuffer.get(c1071uM6335Y.f5167a, c1071uM6335Y.f5169c, iMin);
            i10 -= iMin;
            c1071uM6335Y.f5169c += iMin;
        }
        this.f5126b += iRemaining;
        return iRemaining;
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: x */
    public C1054d mo6326N() {
        return this;
    }

    /* renamed from: y */
    public final byte m6359y(long j10) {
        C1051b.m6294b(m6322J(), j10, 1L);
        C1071u c1071u = this.f5125a;
        if (c1071u == null) {
            C13267j.m79674b(null);
            throw null;
        }
        if (m6322J() - j10 < j10) {
            long jM6322J = m6322J();
            while (jM6322J > j10) {
                c1071u = c1071u.f5173g;
                C13267j.m79674b(c1071u);
                jM6322J -= c1071u.f5169c - c1071u.f5168b;
            }
            C13267j.m79674b(c1071u);
            return c1071u.f5167a[(int) ((c1071u.f5168b + j10) - jM6322J)];
        }
        long j11 = 0;
        while (true) {
            long j12 = (c1071u.f5169c - c1071u.f5168b) + j11;
            if (j12 > j10) {
                C13267j.m79674b(c1071u);
                return c1071u.f5167a[(int) ((c1071u.f5168b + j10) - j11)];
            }
            c1071u = c1071u.f5172f;
            C13267j.m79674b(c1071u);
            j11 = j12;
        }
    }

    /* renamed from: z */
    public long m6361z(byte b10, long j10, long j11) {
        C1071u c1071u;
        int i10;
        long jM6322J = 0;
        if (0 > j10 || j10 > j11) {
            throw new IllegalArgumentException(("size=" + m6322J() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        if (j11 > m6322J()) {
            j11 = m6322J();
        }
        if (j10 == j11 || (c1071u = this.f5125a) == null) {
            return -1L;
        }
        if (m6322J() - j10 < j10) {
            jM6322J = m6322J();
            while (jM6322J > j10) {
                c1071u = c1071u.f5173g;
                C13267j.m79674b(c1071u);
                jM6322J -= c1071u.f5169c - c1071u.f5168b;
            }
            while (jM6322J < j11) {
                byte[] bArr = c1071u.f5167a;
                int iMin = (int) Math.min(c1071u.f5169c, (c1071u.f5168b + j11) - jM6322J);
                i10 = (int) ((c1071u.f5168b + j10) - jM6322J);
                while (i10 < iMin) {
                    if (bArr[i10] != b10) {
                        i10++;
                    }
                }
                jM6322J += c1071u.f5169c - c1071u.f5168b;
                c1071u = c1071u.f5172f;
                C13267j.m79674b(c1071u);
                j10 = jM6322J;
            }
            return -1L;
        }
        while (true) {
            long j12 = (c1071u.f5169c - c1071u.f5168b) + jM6322J;
            if (j12 > j10) {
                break;
            }
            c1071u = c1071u.f5172f;
            C13267j.m79674b(c1071u);
            jM6322J = j12;
        }
        while (jM6322J < j11) {
            byte[] bArr2 = c1071u.f5167a;
            int iMin2 = (int) Math.min(c1071u.f5169c, (c1071u.f5168b + j11) - jM6322J);
            i10 = (int) ((c1071u.f5168b + j10) - jM6322J);
            while (i10 < iMin2) {
                if (bArr2[i10] != b10) {
                    i10++;
                }
            }
            jM6322J += c1071u.f5169c - c1071u.f5168b;
            c1071u = c1071u.f5172f;
            C13267j.m79674b(c1071u);
            j10 = jM6322J;
        }
        return -1L;
        return (i10 - c1071u.f5168b) + jM6322J;
    }

    /* renamed from: ay.d$b */
    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(C1054d.this.m6322J(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            C13267j.m79677e(bArr, "sink");
            return C1054d.this.read(bArr, i10, i11);
        }

        public String toString() {
            return C1054d.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read() {
            if (C1054d.this.m6322J() > 0) {
                return C1054d.this.readByte() & 255;
            }
            return -1;
        }
    }

    /* renamed from: ay.d$c */
    public static final class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return C1054d.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            C13267j.m79677e(bArr, "data");
            C1054d.this.write(bArr, i10, i11);
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            C1054d.this.writeByte(i10);
        }
    }

    @Override // p022ay.InterfaceC1074x
    public void write(C1054d c1054d, long j10) {
        C1071u c1071u;
        C13267j.m79677e(c1054d, "source");
        if (c1054d != this) {
            C1051b.m6294b(c1054d.m6322J(), 0L, j10);
            while (j10 > 0) {
                C1071u c1071u2 = c1054d.f5125a;
                C13267j.m79674b(c1071u2);
                int i10 = c1071u2.f5169c;
                C13267j.m79674b(c1054d.f5125a);
                if (j10 < i10 - r1.f5168b) {
                    C1071u c1071u3 = this.f5125a;
                    if (c1071u3 != null) {
                        C13267j.m79674b(c1071u3);
                        c1071u = c1071u3.f5173g;
                    } else {
                        c1071u = null;
                    }
                    if (c1071u != null && c1071u.f5171e) {
                        if ((c1071u.f5169c + j10) - (c1071u.f5170d ? 0 : c1071u.f5168b) <= 8192) {
                            C1071u c1071u4 = c1054d.f5125a;
                            C13267j.m79674b(c1071u4);
                            c1071u4.m6439f(c1071u, (int) j10);
                            c1054d.m6321H(c1054d.m6322J() - j10);
                            m6321H(m6322J() + j10);
                            return;
                        }
                    }
                    C1071u c1071u5 = c1054d.f5125a;
                    C13267j.m79674b(c1071u5);
                    c1054d.f5125a = c1071u5.m6438e((int) j10);
                }
                C1071u c1071u6 = c1054d.f5125a;
                C13267j.m79674b(c1071u6);
                long j11 = c1071u6.f5169c - c1071u6.f5168b;
                c1054d.f5125a = c1071u6.m6435b();
                C1071u c1071u7 = this.f5125a;
                if (c1071u7 == null) {
                    this.f5125a = c1071u6;
                    c1071u6.f5173g = c1071u6;
                    c1071u6.f5172f = c1071u6;
                } else {
                    C13267j.m79674b(c1071u7);
                    C1071u c1071u8 = c1071u7.f5173g;
                    C13267j.m79674b(c1071u8);
                    c1071u8.m6436c(c1071u6).m6434a();
                }
                c1054d.m6321H(c1054d.m6322J() - j11);
                m6321H(m6322J() + j11);
                j10 -= j11;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public int read(byte[] bArr, int i10, int i11) {
        C13267j.m79677e(bArr, "sink");
        C1051b.m6294b(bArr.length, i10, i11);
        C1071u c1071u = this.f5125a;
        if (c1071u == null) {
            return -1;
        }
        int iMin = Math.min(i11, c1071u.f5169c - c1071u.f5168b);
        byte[] bArr2 = c1071u.f5167a;
        int i12 = c1071u.f5168b;
        C11175g.m67143c(bArr2, bArr, i10, i12, i12 + iMin);
        c1071u.f5168b += iMin;
        m6321H(m6322J() - iMin);
        if (c1071u.f5168b == c1071u.f5169c) {
            this.f5125a = c1071u.m6435b();
            C1072v.m6440b(c1071u);
        }
        return iMin;
    }

    @Override // p022ay.InterfaceC1076z
    public long read(C1054d c1054d, long j10) {
        C13267j.m79677e(c1054d, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (m6322J() == 0) {
            return -1L;
        }
        if (j10 > m6322J()) {
            j10 = m6322J();
        }
        c1054d.write(this, j10);
        return j10;
    }
}
