package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1955t1;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.crypto.tink.shaded.protobuf.l */
/* loaded from: classes.dex */
public abstract class AbstractC1929l extends AbstractC1917h {

    /* renamed from: c */
    public static final Logger f9211c = Logger.getLogger(AbstractC1929l.class.getName());

    /* renamed from: d */
    public static final boolean f9212d = C1952s1.m12146C();

    /* renamed from: a */
    public C1932m f9213a;

    /* renamed from: b */
    public boolean f9214b;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.l$b */
    public static class b extends AbstractC1929l {

        /* renamed from: e */
        public final byte[] f9215e;

        /* renamed from: f */
        public final int f9216f;

        /* renamed from: g */
        public final int f9217g;

        /* renamed from: h */
        public int f9218h;

        public b(byte[] bArr, int i10, int i11) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i12 = i10 + i11;
            if ((i10 | i11 | (bArr.length - i12)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            this.f9215e = bArr;
            this.f9216f = i10;
            this.f9218h = i10;
            this.f9217g = i12;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: A0 */
        public final void mo11926A0(int i10, InterfaceC1951s0 interfaceC1951s0, InterfaceC1919h1 interfaceC1919h1) throws IOException {
            mo11938M0(i10, 2);
            mo11940O0(((AbstractC1896a) interfaceC1951s0).m11457b(interfaceC1919h1));
            interfaceC1919h1.mo11671e(interfaceC1951s0, this.f9213a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: B0 */
        public final void mo11927B0(int i10, InterfaceC1951s0 interfaceC1951s0) throws IOException {
            mo11938M0(1, 3);
            mo11939N0(2, i10);
            m11969T0(3, interfaceC1951s0);
            mo11938M0(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: C0 */
        public final void mo11928C0(int i10, AbstractC1920i abstractC1920i) throws IOException {
            mo11938M0(1, 3);
            mo11939N0(2, i10);
            mo11950j0(3, abstractC1920i);
            mo11938M0(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: L0 */
        public final void mo11937L0(int i10, String str) throws IOException {
            mo11938M0(i10, 2);
            m11971V0(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: M0 */
        public final void mo11938M0(int i10, int i11) throws IOException {
            mo11940O0(C1958u1.m12259c(i10, i11));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: N0 */
        public final void mo11939N0(int i10, int i11) throws IOException {
            mo11938M0(i10, 0);
            mo11940O0(i11);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: O0 */
        public final void mo11940O0(int i10) throws IOException {
            if (!AbstractC1929l.f9212d || C1905d.m11514c() || mo11946f0() < 5) {
                while ((i10 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f9215e;
                        int i11 = this.f9218h;
                        this.f9218h = i11 + 1;
                        bArr[i11] = (byte) ((i10 & 127) | 128);
                        i10 >>>= 7;
                    } catch (IndexOutOfBoundsException e10) {
                        throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9218h), Integer.valueOf(this.f9217g), 1), e10);
                    }
                }
                byte[] bArr2 = this.f9215e;
                int i12 = this.f9218h;
                this.f9218h = i12 + 1;
                bArr2[i12] = (byte) i10;
                return;
            }
            if ((i10 & (-128)) == 0) {
                byte[] bArr3 = this.f9215e;
                int i13 = this.f9218h;
                this.f9218h = i13 + 1;
                C1952s1.m12151H(bArr3, i13, (byte) i10);
                return;
            }
            byte[] bArr4 = this.f9215e;
            int i14 = this.f9218h;
            this.f9218h = i14 + 1;
            C1952s1.m12151H(bArr4, i14, (byte) (i10 | 128));
            int i15 = i10 >>> 7;
            if ((i15 & (-128)) == 0) {
                byte[] bArr5 = this.f9215e;
                int i16 = this.f9218h;
                this.f9218h = i16 + 1;
                C1952s1.m12151H(bArr5, i16, (byte) i15);
                return;
            }
            byte[] bArr6 = this.f9215e;
            int i17 = this.f9218h;
            this.f9218h = i17 + 1;
            C1952s1.m12151H(bArr6, i17, (byte) (i15 | 128));
            int i18 = i10 >>> 14;
            if ((i18 & (-128)) == 0) {
                byte[] bArr7 = this.f9215e;
                int i19 = this.f9218h;
                this.f9218h = i19 + 1;
                C1952s1.m12151H(bArr7, i19, (byte) i18);
                return;
            }
            byte[] bArr8 = this.f9215e;
            int i20 = this.f9218h;
            this.f9218h = i20 + 1;
            C1952s1.m12151H(bArr8, i20, (byte) (i18 | 128));
            int i21 = i10 >>> 21;
            if ((i21 & (-128)) == 0) {
                byte[] bArr9 = this.f9215e;
                int i22 = this.f9218h;
                this.f9218h = i22 + 1;
                C1952s1.m12151H(bArr9, i22, (byte) i21);
                return;
            }
            byte[] bArr10 = this.f9215e;
            int i23 = this.f9218h;
            this.f9218h = i23 + 1;
            C1952s1.m12151H(bArr10, i23, (byte) (i21 | 128));
            byte[] bArr11 = this.f9215e;
            int i24 = this.f9218h;
            this.f9218h = i24 + 1;
            C1952s1.m12151H(bArr11, i24, (byte) (i10 >>> 28));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: P0 */
        public final void mo11941P0(int i10, long j10) throws IOException {
            mo11938M0(i10, 0);
            mo11942Q0(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: Q0 */
        public final void mo11942Q0(long j10) throws IOException {
            if (AbstractC1929l.f9212d && mo11946f0() >= 10) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.f9215e;
                    int i10 = this.f9218h;
                    this.f9218h = i10 + 1;
                    C1952s1.m12151H(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f9215e;
                int i11 = this.f9218h;
                this.f9218h = i11 + 1;
                C1952s1.m12151H(bArr2, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f9215e;
                    int i12 = this.f9218h;
                    this.f9218h = i12 + 1;
                    bArr3[i12] = (byte) ((((int) j10) & 127) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9218h), Integer.valueOf(this.f9217g), 1), e10);
                }
            }
            byte[] bArr4 = this.f9215e;
            int i13 = this.f9218h;
            this.f9218h = i13 + 1;
            bArr4[i13] = (byte) j10;
        }

        /* renamed from: R0 */
        public final void m11967R0(byte[] bArr, int i10, int i11) throws IOException {
            try {
                System.arraycopy(bArr, i10, this.f9215e, this.f9218h, i11);
                this.f9218h += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9218h), Integer.valueOf(this.f9217g), Integer.valueOf(i11)), e10);
            }
        }

        /* renamed from: S0 */
        public final void m11968S0(AbstractC1920i abstractC1920i) throws IOException {
            mo11940O0(abstractC1920i.size());
            abstractC1920i.mo11688E(this);
        }

        /* renamed from: T0 */
        public final void m11969T0(int i10, InterfaceC1951s0 interfaceC1951s0) throws IOException {
            mo11938M0(i10, 2);
            m11970U0(interfaceC1951s0);
        }

        /* renamed from: U0 */
        public final void m11970U0(InterfaceC1951s0 interfaceC1951s0) throws IOException {
            mo11940O0(interfaceC1951s0.mo12140i());
            interfaceC1951s0.mo12139f(this);
        }

        /* renamed from: V0 */
        public final void m11971V0(String str) throws IOException {
            int i10 = this.f9218h;
            try {
                int iM11895W = AbstractC1929l.m11895W(str.length() * 3);
                int iM11895W2 = AbstractC1929l.m11895W(str.length());
                if (iM11895W2 == iM11895W) {
                    int i11 = i10 + iM11895W2;
                    this.f9218h = i11;
                    int iM12215f = C1955t1.m12215f(str, this.f9215e, i11, mo11946f0());
                    this.f9218h = i10;
                    mo11940O0((iM12215f - i10) - iM11895W2);
                    this.f9218h = iM12215f;
                } else {
                    mo11940O0(C1955t1.m12216g(str));
                    this.f9218h = C1955t1.m12215f(str, this.f9215e, this.f9218h, mo11946f0());
                }
            } catch (C1955t1.d e10) {
                this.f9218h = i10;
                m11943b0(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new c(e11);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l, com.google.crypto.tink.shaded.protobuf.AbstractC1917h
        /* renamed from: a */
        public final void mo11666a(byte[] bArr, int i10, int i11) throws IOException {
            m11967R0(bArr, i10, i11);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: f0 */
        public final int mo11946f0() {
            return this.f9217g - this.f9218h;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: g0 */
        public final void mo11947g0(byte b10) throws IOException {
            try {
                byte[] bArr = this.f9215e;
                int i10 = this.f9218h;
                this.f9218h = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9218h), Integer.valueOf(this.f9217g), 1), e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: h0 */
        public final void mo11948h0(int i10, boolean z10) throws IOException {
            mo11938M0(i10, 0);
            mo11947g0(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: j0 */
        public final void mo11950j0(int i10, AbstractC1920i abstractC1920i) throws IOException {
            mo11938M0(i10, 2);
            m11968S0(abstractC1920i);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: o0 */
        public final void mo11955o0(int i10, int i11) throws IOException {
            mo11938M0(i10, 5);
            mo11956p0(i11);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: p0 */
        public final void mo11956p0(int i10) throws IOException {
            try {
                byte[] bArr = this.f9215e;
                int i11 = this.f9218h;
                bArr[i11] = (byte) (i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                bArr[i11 + 1] = (byte) ((i10 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                bArr[i11 + 2] = (byte) ((i10 >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                this.f9218h = i11 + 4;
                bArr[i11 + 3] = (byte) ((i10 >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            } catch (IndexOutOfBoundsException e10) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9218h), Integer.valueOf(this.f9217g), 1), e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: q0 */
        public final void mo11957q0(int i10, long j10) throws IOException {
            mo11938M0(i10, 1);
            mo11958r0(j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: r0 */
        public final void mo11958r0(long j10) throws IOException {
            try {
                byte[] bArr = this.f9215e;
                int i10 = this.f9218h;
                bArr[i10] = (byte) (((int) j10) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                bArr[i10 + 1] = (byte) (((int) (j10 >> 8)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                bArr[i10 + 2] = (byte) (((int) (j10 >> 16)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                bArr[i10 + 3] = (byte) (((int) (j10 >> 24)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                bArr[i10 + 4] = (byte) (((int) (j10 >> 32)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                bArr[i10 + 5] = (byte) (((int) (j10 >> 40)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                bArr[i10 + 6] = (byte) (((int) (j10 >> 48)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
                this.f9218h = i10 + 8;
                bArr[i10 + 7] = (byte) (((int) (j10 >> 56)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            } catch (IndexOutOfBoundsException e10) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f9218h), Integer.valueOf(this.f9217g), 1), e10);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: w0 */
        public final void mo11963w0(int i10, int i11) throws IOException {
            mo11938M0(i10, 0);
            mo11964x0(i11);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1929l
        /* renamed from: x0 */
        public final void mo11964x0(int i10) throws IOException {
            if (i10 >= 0) {
                mo11940O0(i10);
            } else {
                mo11942Q0(i10);
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.l$c */
    public static class c extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public c(Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th2);
        }

        public c(String str, Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th2);
        }
    }

    public /* synthetic */ AbstractC1929l(a aVar) {
        this();
    }

    /* renamed from: A */
    public static int m11873A(int i10, C1912f0 c1912f0) {
        return m11893U(i10) + m11874B(c1912f0);
    }

    /* renamed from: B */
    public static int m11874B(C1912f0 c1912f0) {
        return m11875C(c1912f0.m11635b());
    }

    /* renamed from: C */
    public static int m11875C(int i10) {
        return m11895W(i10) + i10;
    }

    /* renamed from: D */
    public static int m11876D(int i10, InterfaceC1951s0 interfaceC1951s0) {
        return (m11893U(1) * 2) + m11894V(2, i10) + m11877E(3, interfaceC1951s0);
    }

    /* renamed from: E */
    public static int m11877E(int i10, InterfaceC1951s0 interfaceC1951s0) {
        return m11893U(i10) + m11879G(interfaceC1951s0);
    }

    /* renamed from: F */
    public static int m11878F(int i10, InterfaceC1951s0 interfaceC1951s0, InterfaceC1919h1 interfaceC1919h1) {
        return m11893U(i10) + m11880H(interfaceC1951s0, interfaceC1919h1);
    }

    /* renamed from: G */
    public static int m11879G(InterfaceC1951s0 interfaceC1951s0) {
        return m11875C(interfaceC1951s0.mo12140i());
    }

    /* renamed from: H */
    public static int m11880H(InterfaceC1951s0 interfaceC1951s0, InterfaceC1919h1 interfaceC1919h1) {
        return m11875C(((AbstractC1896a) interfaceC1951s0).m11457b(interfaceC1919h1));
    }

    /* renamed from: I */
    public static int m11881I(int i10, AbstractC1920i abstractC1920i) {
        return (m11893U(1) * 2) + m11894V(2, i10) + m11906g(3, abstractC1920i);
    }

    @Deprecated
    /* renamed from: J */
    public static int m11882J(int i10) {
        return m11895W(i10);
    }

    /* renamed from: K */
    public static int m11883K(int i10, int i11) {
        return m11893U(i10) + m11884L(i11);
    }

    /* renamed from: L */
    public static int m11884L(int i10) {
        return 4;
    }

    /* renamed from: M */
    public static int m11885M(int i10, long j10) {
        return m11893U(i10) + m11886N(j10);
    }

    /* renamed from: N */
    public static int m11886N(long j10) {
        return 8;
    }

    /* renamed from: O */
    public static int m11887O(int i10, int i11) {
        return m11893U(i10) + m11888P(i11);
    }

    /* renamed from: P */
    public static int m11888P(int i10) {
        return m11895W(m11898Z(i10));
    }

    /* renamed from: Q */
    public static int m11889Q(int i10, long j10) {
        return m11893U(i10) + m11890R(j10);
    }

    /* renamed from: R */
    public static int m11890R(long j10) {
        return m11897Y(m11899a0(j10));
    }

    /* renamed from: S */
    public static int m11891S(int i10, String str) {
        return m11893U(i10) + m11892T(str);
    }

    /* renamed from: T */
    public static int m11892T(String str) {
        int length;
        try {
            length = C1955t1.m12216g(str);
        } catch (C1955t1.d unused) {
            length = str.getBytes(C1900b0.f9085a).length;
        }
        return m11875C(length);
    }

    /* renamed from: U */
    public static int m11893U(int i10) {
        return m11895W(C1958u1.m12259c(i10, 0));
    }

    /* renamed from: V */
    public static int m11894V(int i10, int i11) {
        return m11893U(i10) + m11895W(i11);
    }

    /* renamed from: W */
    public static int m11895W(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    /* renamed from: X */
    public static int m11896X(int i10, long j10) {
        return m11893U(i10) + m11897Y(j10);
    }

    /* renamed from: Y */
    public static int m11897Y(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    /* renamed from: Z */
    public static int m11898Z(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    /* renamed from: a0 */
    public static long m11899a0(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    /* renamed from: d */
    public static int m11901d(int i10, boolean z10) {
        return m11893U(i10) + m11903e(z10);
    }

    /* renamed from: d0 */
    public static AbstractC1929l m11902d0(byte[] bArr) {
        return m11904e0(bArr, 0, bArr.length);
    }

    /* renamed from: e */
    public static int m11903e(boolean z10) {
        return 1;
    }

    /* renamed from: e0 */
    public static AbstractC1929l m11904e0(byte[] bArr, int i10, int i11) {
        return new b(bArr, i10, i11);
    }

    /* renamed from: f */
    public static int m11905f(byte[] bArr) {
        return m11875C(bArr.length);
    }

    /* renamed from: g */
    public static int m11906g(int i10, AbstractC1920i abstractC1920i) {
        return m11893U(i10) + m11907h(abstractC1920i);
    }

    /* renamed from: h */
    public static int m11907h(AbstractC1920i abstractC1920i) {
        return m11875C(abstractC1920i.size());
    }

    /* renamed from: i */
    public static int m11908i(int i10, double d10) {
        return m11893U(i10) + m11909j(d10);
    }

    /* renamed from: j */
    public static int m11909j(double d10) {
        return 8;
    }

    /* renamed from: k */
    public static int m11910k(int i10, int i11) {
        return m11893U(i10) + m11911l(i11);
    }

    /* renamed from: l */
    public static int m11911l(int i10) {
        return m11922w(i10);
    }

    /* renamed from: m */
    public static int m11912m(int i10, int i11) {
        return m11893U(i10) + m11913n(i11);
    }

    /* renamed from: n */
    public static int m11913n(int i10) {
        return 4;
    }

    /* renamed from: o */
    public static int m11914o(int i10, long j10) {
        return m11893U(i10) + m11915p(j10);
    }

    /* renamed from: p */
    public static int m11915p(long j10) {
        return 8;
    }

    /* renamed from: q */
    public static int m11916q(int i10, float f10) {
        return m11893U(i10) + m11917r(f10);
    }

    /* renamed from: r */
    public static int m11917r(float f10) {
        return 4;
    }

    @Deprecated
    /* renamed from: s */
    public static int m11918s(int i10, InterfaceC1951s0 interfaceC1951s0, InterfaceC1919h1 interfaceC1919h1) {
        return (m11893U(i10) * 2) + m11920u(interfaceC1951s0, interfaceC1919h1);
    }

    @Deprecated
    /* renamed from: t */
    public static int m11919t(InterfaceC1951s0 interfaceC1951s0) {
        return interfaceC1951s0.mo12140i();
    }

    @Deprecated
    /* renamed from: u */
    public static int m11920u(InterfaceC1951s0 interfaceC1951s0, InterfaceC1919h1 interfaceC1919h1) {
        return ((AbstractC1896a) interfaceC1951s0).m11457b(interfaceC1919h1);
    }

    /* renamed from: v */
    public static int m11921v(int i10, int i11) {
        return m11893U(i10) + m11922w(i11);
    }

    /* renamed from: w */
    public static int m11922w(int i10) {
        if (i10 >= 0) {
            return m11895W(i10);
        }
        return 10;
    }

    /* renamed from: x */
    public static int m11923x(int i10, long j10) {
        return m11893U(i10) + m11924y(j10);
    }

    /* renamed from: y */
    public static int m11924y(long j10) {
        return m11897Y(j10);
    }

    /* renamed from: z */
    public static int m11925z(int i10, C1912f0 c1912f0) {
        return (m11893U(1) * 2) + m11894V(2, i10) + m11873A(3, c1912f0);
    }

    /* renamed from: A0 */
    public abstract void mo11926A0(int i10, InterfaceC1951s0 interfaceC1951s0, InterfaceC1919h1 interfaceC1919h1) throws IOException;

    /* renamed from: B0 */
    public abstract void mo11927B0(int i10, InterfaceC1951s0 interfaceC1951s0) throws IOException;

    /* renamed from: C0 */
    public abstract void mo11928C0(int i10, AbstractC1920i abstractC1920i) throws IOException;

    /* renamed from: D0 */
    public final void m11929D0(int i10, int i11) throws IOException {
        mo11955o0(i10, i11);
    }

    /* renamed from: E0 */
    public final void m11930E0(int i10) throws IOException {
        mo11956p0(i10);
    }

    /* renamed from: F0 */
    public final void m11931F0(int i10, long j10) throws IOException {
        mo11957q0(i10, j10);
    }

    /* renamed from: G0 */
    public final void m11932G0(long j10) throws IOException {
        mo11958r0(j10);
    }

    /* renamed from: H0 */
    public final void m11933H0(int i10, int i11) throws IOException {
        mo11939N0(i10, m11898Z(i11));
    }

    /* renamed from: I0 */
    public final void m11934I0(int i10) throws IOException {
        mo11940O0(m11898Z(i10));
    }

    /* renamed from: J0 */
    public final void m11935J0(int i10, long j10) throws IOException {
        mo11941P0(i10, m11899a0(j10));
    }

    /* renamed from: K0 */
    public final void m11936K0(long j10) throws IOException {
        mo11942Q0(m11899a0(j10));
    }

    /* renamed from: L0 */
    public abstract void mo11937L0(int i10, String str) throws IOException;

    /* renamed from: M0 */
    public abstract void mo11938M0(int i10, int i11) throws IOException;

    /* renamed from: N0 */
    public abstract void mo11939N0(int i10, int i11) throws IOException;

    /* renamed from: O0 */
    public abstract void mo11940O0(int i10) throws IOException;

    /* renamed from: P0 */
    public abstract void mo11941P0(int i10, long j10) throws IOException;

    /* renamed from: Q0 */
    public abstract void mo11942Q0(long j10) throws IOException;

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1917h
    /* renamed from: a */
    public abstract void mo11666a(byte[] bArr, int i10, int i11) throws IOException;

    /* renamed from: b0 */
    public final void m11943b0(String str, C1955t1.d dVar) throws IOException {
        f9211c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(C1900b0.f9085a);
        try {
            mo11940O0(bytes.length);
            mo11666a(bytes, 0, bytes.length);
        } catch (c e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new c(e11);
        }
    }

    /* renamed from: c */
    public final void m11944c() {
        if (mo11946f0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: c0 */
    public boolean m11945c0() {
        return this.f9214b;
    }

    /* renamed from: f0 */
    public abstract int mo11946f0();

    /* renamed from: g0 */
    public abstract void mo11947g0(byte b10) throws IOException;

    /* renamed from: h0 */
    public abstract void mo11948h0(int i10, boolean z10) throws IOException;

    /* renamed from: i0 */
    public final void m11949i0(boolean z10) throws IOException {
        mo11947g0(z10 ? (byte) 1 : (byte) 0);
    }

    /* renamed from: j0 */
    public abstract void mo11950j0(int i10, AbstractC1920i abstractC1920i) throws IOException;

    /* renamed from: k0 */
    public final void m11951k0(int i10, double d10) throws IOException {
        mo11957q0(i10, Double.doubleToRawLongBits(d10));
    }

    /* renamed from: l0 */
    public final void m11952l0(double d10) throws IOException {
        mo11958r0(Double.doubleToRawLongBits(d10));
    }

    /* renamed from: m0 */
    public final void m11953m0(int i10, int i11) throws IOException {
        mo11963w0(i10, i11);
    }

    /* renamed from: n0 */
    public final void m11954n0(int i10) throws IOException {
        mo11964x0(i10);
    }

    /* renamed from: o0 */
    public abstract void mo11955o0(int i10, int i11) throws IOException;

    /* renamed from: p0 */
    public abstract void mo11956p0(int i10) throws IOException;

    /* renamed from: q0 */
    public abstract void mo11957q0(int i10, long j10) throws IOException;

    /* renamed from: r0 */
    public abstract void mo11958r0(long j10) throws IOException;

    /* renamed from: s0 */
    public final void m11959s0(int i10, float f10) throws IOException {
        mo11955o0(i10, Float.floatToRawIntBits(f10));
    }

    /* renamed from: t0 */
    public final void m11960t0(float f10) throws IOException {
        mo11956p0(Float.floatToRawIntBits(f10));
    }

    @Deprecated
    /* renamed from: u0 */
    public final void m11961u0(int i10, InterfaceC1951s0 interfaceC1951s0, InterfaceC1919h1 interfaceC1919h1) throws IOException {
        mo11938M0(i10, 3);
        m11962v0(interfaceC1951s0, interfaceC1919h1);
        mo11938M0(i10, 4);
    }

    @Deprecated
    /* renamed from: v0 */
    public final void m11962v0(InterfaceC1951s0 interfaceC1951s0, InterfaceC1919h1 interfaceC1919h1) throws IOException {
        interfaceC1919h1.mo11671e(interfaceC1951s0, this.f9213a);
    }

    /* renamed from: w0 */
    public abstract void mo11963w0(int i10, int i11) throws IOException;

    /* renamed from: x0 */
    public abstract void mo11964x0(int i10) throws IOException;

    /* renamed from: y0 */
    public final void m11965y0(int i10, long j10) throws IOException {
        mo11941P0(i10, j10);
    }

    /* renamed from: z0 */
    public final void m11966z0(long j10) throws IOException {
        mo11942Q0(j10);
    }

    public AbstractC1929l() {
    }
}
