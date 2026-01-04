package com.google.crypto.tink.shaded.protobuf;

import com.google.flatbuffers.reflection.BaseType;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.crypto.tink.shaded.protobuf.j */
/* loaded from: classes.dex */
public abstract class AbstractC1923j {

    /* renamed from: a */
    public int f9162a;

    /* renamed from: b */
    public int f9163b;

    /* renamed from: c */
    public int f9164c;

    /* renamed from: d */
    public C1926k f9165d;

    /* renamed from: e */
    public boolean f9166e;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.j$b */
    public static final class b extends AbstractC1923j {

        /* renamed from: f */
        public final byte[] f9167f;

        /* renamed from: g */
        public final boolean f9168g;

        /* renamed from: h */
        public int f9169h;

        /* renamed from: i */
        public int f9170i;

        /* renamed from: j */
        public int f9171j;

        /* renamed from: k */
        public int f9172k;

        /* renamed from: l */
        public int f9173l;

        /* renamed from: m */
        public boolean f9174m;

        /* renamed from: n */
        public int f9175n;

        public /* synthetic */ b(byte[] bArr, int i10, int i11, boolean z10, a aVar) {
            this(bArr, i10, i11, z10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: A */
        public int mo11724A() throws IOException {
            return m11752H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: B */
        public long mo11725B() throws IOException {
            return m11753I();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: C */
        public boolean mo11726C(int i10) throws IOException {
            int iM12258b = C1958u1.m12258b(i10);
            if (iM12258b == 0) {
                m11758N();
                return true;
            }
            if (iM12258b == 1) {
                m11757M(8);
                return true;
            }
            if (iM12258b == 2) {
                m11757M(m11752H());
                return true;
            }
            if (iM12258b == 3) {
                m11756L();
                mo11727a(C1958u1.m12259c(C1958u1.m12257a(i10), 4));
                return true;
            }
            if (iM12258b == 4) {
                return false;
            }
            if (iM12258b != 5) {
                throw C1903c0.m11505e();
            }
            m11757M(4);
            return true;
        }

        /* renamed from: D */
        public byte m11748D() throws IOException {
            int i10 = this.f9171j;
            if (i10 == this.f9169h) {
                throw C1903c0.m11510l();
            }
            byte[] bArr = this.f9167f;
            this.f9171j = i10 + 1;
            return bArr[i10];
        }

        /* renamed from: E */
        public byte[] m11749E(int i10) throws IOException {
            if (i10 > 0) {
                int i11 = this.f9169h;
                int i12 = this.f9171j;
                if (i10 <= i11 - i12) {
                    int i13 = i10 + i12;
                    this.f9171j = i13;
                    return Arrays.copyOfRange(this.f9167f, i12, i13);
                }
            }
            if (i10 > 0) {
                throw C1903c0.m11510l();
            }
            if (i10 == 0) {
                return C1900b0.f9087c;
            }
            throw C1903c0.m11507g();
        }

        /* renamed from: F */
        public int m11750F() throws IOException {
            int i10 = this.f9171j;
            if (this.f9169h - i10 < 4) {
                throw C1903c0.m11510l();
            }
            byte[] bArr = this.f9167f;
            this.f9171j = i10 + 4;
            return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24);
        }

        /* renamed from: G */
        public long m11751G() throws IOException {
            int i10 = this.f9171j;
            if (this.f9169h - i10 < 8) {
                throw C1903c0.m11510l();
            }
            byte[] bArr = this.f9167f;
            this.f9171j = i10 + 8;
            return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
        }

        /* renamed from: H */
        public int m11752H() throws IOException {
            int i10;
            int i11 = this.f9171j;
            int i12 = this.f9169h;
            if (i12 != i11) {
                byte[] bArr = this.f9167f;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f9171j = i13;
                    return b10;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i11 + 2;
                    int i15 = (bArr[i13] << 7) ^ b10;
                    if (i15 < 0) {
                        i10 = i15 ^ (-128);
                    } else {
                        int i16 = i11 + 3;
                        int i17 = (bArr[i14] << BaseType.Vector) ^ i15;
                        if (i17 >= 0) {
                            i10 = i17 ^ 16256;
                        } else {
                            int i18 = i11 + 4;
                            int i19 = i17 ^ (bArr[i16] << 21);
                            if (i19 < 0) {
                                i10 = (-2080896) ^ i19;
                            } else {
                                i16 = i11 + 5;
                                byte b11 = bArr[i18];
                                int i20 = (i19 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    i18 = i11 + 6;
                                    if (bArr[i16] < 0) {
                                        i16 = i11 + 7;
                                        if (bArr[i18] < 0) {
                                            i18 = i11 + 8;
                                            if (bArr[i16] < 0) {
                                                i16 = i11 + 9;
                                                if (bArr[i18] < 0) {
                                                    int i21 = i11 + 10;
                                                    if (bArr[i16] >= 0) {
                                                        i14 = i21;
                                                        i10 = i20;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i10 = i20;
                                }
                                i10 = i20;
                            }
                            i14 = i18;
                        }
                        i14 = i16;
                    }
                    this.f9171j = i14;
                    return i10;
                }
            }
            return (int) m11754J();
        }

        /* renamed from: I */
        public long m11753I() throws IOException {
            long j10;
            long j11;
            long j12;
            int i10 = this.f9171j;
            int i11 = this.f9169h;
            if (i11 != i10) {
                byte[] bArr = this.f9167f;
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.f9171j = i12;
                    return b10;
                }
                if (i11 - i12 >= 9) {
                    int i13 = i10 + 2;
                    int i14 = (bArr[i12] << 7) ^ b10;
                    if (i14 < 0) {
                        j10 = i14 ^ (-128);
                    } else {
                        int i15 = i10 + 3;
                        int i16 = (bArr[i13] << BaseType.Vector) ^ i14;
                        if (i16 >= 0) {
                            j10 = i16 ^ 16256;
                            i13 = i15;
                        } else {
                            int i17 = i10 + 4;
                            int i18 = i16 ^ (bArr[i15] << 21);
                            if (i18 < 0) {
                                long j13 = (-2080896) ^ i18;
                                i13 = i17;
                                j10 = j13;
                            } else {
                                long j14 = i18;
                                i13 = i10 + 5;
                                long j15 = j14 ^ (bArr[i17] << 28);
                                if (j15 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    int i19 = i10 + 6;
                                    long j16 = j15 ^ (bArr[i13] << 35);
                                    if (j16 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        i13 = i10 + 7;
                                        j15 = j16 ^ (bArr[i19] << 42);
                                        if (j15 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            i19 = i10 + 8;
                                            j16 = j15 ^ (bArr[i13] << 49);
                                            if (j16 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                i13 = i10 + 9;
                                                long j17 = (j16 ^ (bArr[i19] << 56)) ^ 71499008037633920L;
                                                if (j17 < 0) {
                                                    int i20 = i10 + 10;
                                                    if (bArr[i13] >= 0) {
                                                        i13 = i20;
                                                    }
                                                }
                                                j10 = j17;
                                            }
                                        }
                                    }
                                    j10 = j16 ^ j11;
                                    i13 = i19;
                                }
                                j10 = j15 ^ j12;
                            }
                        }
                    }
                    this.f9171j = i13;
                    return j10;
                }
            }
            return m11754J();
        }

        /* renamed from: J */
        public long m11754J() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & 127) << i10;
                if ((m11748D() & 128) == 0) {
                    return j10;
                }
            }
            throw C1903c0.m11506f();
        }

        /* renamed from: K */
        public final void m11755K() {
            int i10 = this.f9169h + this.f9170i;
            this.f9169h = i10;
            int i11 = i10 - this.f9172k;
            int i12 = this.f9175n;
            if (i11 <= i12) {
                this.f9170i = 0;
                return;
            }
            int i13 = i11 - i12;
            this.f9170i = i13;
            this.f9169h = i10 - i13;
        }

        /* renamed from: L */
        public void m11756L() throws IOException {
            int iMo11747z;
            do {
                iMo11747z = mo11747z();
                if (iMo11747z == 0) {
                    return;
                }
            } while (mo11726C(iMo11747z));
        }

        /* renamed from: M */
        public void m11757M(int i10) throws IOException {
            if (i10 >= 0) {
                int i11 = this.f9169h;
                int i12 = this.f9171j;
                if (i10 <= i11 - i12) {
                    this.f9171j = i12 + i10;
                    return;
                }
            }
            if (i10 >= 0) {
                throw C1903c0.m11510l();
            }
            throw C1903c0.m11507g();
        }

        /* renamed from: N */
        public final void m11758N() throws IOException {
            if (this.f9169h - this.f9171j >= 10) {
                m11759O();
            } else {
                m11760P();
            }
        }

        /* renamed from: O */
        public final void m11759O() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f9167f;
                int i11 = this.f9171j;
                this.f9171j = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw C1903c0.m11506f();
        }

        /* renamed from: P */
        public final void m11760P() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (m11748D() >= 0) {
                    return;
                }
            }
            throw C1903c0.m11506f();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: a */
        public void mo11727a(int i10) throws C1903c0 {
            if (this.f9173l != i10) {
                throw C1903c0.m11502b();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: d */
        public int mo11728d() {
            return this.f9171j - this.f9172k;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: e */
        public boolean mo11729e() throws IOException {
            return this.f9171j == this.f9169h;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: i */
        public void mo11730i(int i10) {
            this.f9175n = i10;
            m11755K();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: j */
        public int mo11731j(int i10) throws C1903c0 {
            if (i10 < 0) {
                throw C1903c0.m11507g();
            }
            int iMo11728d = i10 + mo11728d();
            int i11 = this.f9175n;
            if (iMo11728d > i11) {
                throw C1903c0.m11510l();
            }
            this.f9175n = iMo11728d;
            m11755K();
            return i11;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: k */
        public boolean mo11732k() throws IOException {
            return m11753I() != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: l */
        public AbstractC1920i mo11733l() throws IOException {
            int iM11752H = m11752H();
            if (iM11752H > 0) {
                int i10 = this.f9169h;
                int i11 = this.f9171j;
                if (iM11752H <= i10 - i11) {
                    AbstractC1920i abstractC1920iM11678D = (this.f9168g && this.f9174m) ? AbstractC1920i.m11678D(this.f9167f, i11, iM11752H) : AbstractC1920i.m11683g(this.f9167f, i11, iM11752H);
                    this.f9171j += iM11752H;
                    return abstractC1920iM11678D;
                }
            }
            return iM11752H == 0 ? AbstractC1920i.f9147b : AbstractC1920i.m11677C(m11749E(iM11752H));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: m */
        public double mo11734m() throws IOException {
            return Double.longBitsToDouble(m11751G());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: n */
        public int mo11735n() throws IOException {
            return m11752H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: o */
        public int mo11736o() throws IOException {
            return m11750F();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: p */
        public long mo11737p() throws IOException {
            return m11751G();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: q */
        public float mo11738q() throws IOException {
            return Float.intBitsToFloat(m11750F());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: r */
        public int mo11739r() throws IOException {
            return m11752H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: s */
        public long mo11740s() throws IOException {
            return m11753I();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: t */
        public int mo11741t() throws IOException {
            return m11750F();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: u */
        public long mo11742u() throws IOException {
            return m11751G();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: v */
        public int mo11743v() throws IOException {
            return AbstractC1923j.m11719b(m11752H());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: w */
        public long mo11744w() throws IOException {
            return AbstractC1923j.m11720c(m11753I());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: x */
        public String mo11745x() throws IOException {
            int iM11752H = m11752H();
            if (iM11752H > 0) {
                int i10 = this.f9169h;
                int i11 = this.f9171j;
                if (iM11752H <= i10 - i11) {
                    String str = new String(this.f9167f, i11, iM11752H, C1900b0.f9085a);
                    this.f9171j += iM11752H;
                    return str;
                }
            }
            if (iM11752H == 0) {
                return "";
            }
            if (iM11752H < 0) {
                throw C1903c0.m11507g();
            }
            throw C1903c0.m11510l();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: y */
        public String mo11746y() throws IOException {
            int iM11752H = m11752H();
            if (iM11752H > 0) {
                int i10 = this.f9169h;
                int i11 = this.f9171j;
                if (iM11752H <= i10 - i11) {
                    String strM12214e = C1955t1.m12214e(this.f9167f, i11, iM11752H);
                    this.f9171j += iM11752H;
                    return strM12214e;
                }
            }
            if (iM11752H == 0) {
                return "";
            }
            if (iM11752H <= 0) {
                throw C1903c0.m11507g();
            }
            throw C1903c0.m11510l();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1923j
        /* renamed from: z */
        public int mo11747z() throws IOException {
            if (mo11729e()) {
                this.f9173l = 0;
                return 0;
            }
            int iM11752H = m11752H();
            this.f9173l = iM11752H;
            if (C1958u1.m12257a(iM11752H) != 0) {
                return this.f9173l;
            }
            throw C1903c0.m11503c();
        }

        public b(byte[] bArr, int i10, int i11, boolean z10) {
            super();
            this.f9175n = Integer.MAX_VALUE;
            this.f9167f = bArr;
            this.f9169h = i11 + i10;
            this.f9171j = i10;
            this.f9172k = i10;
            this.f9168g = z10;
        }
    }

    public /* synthetic */ AbstractC1923j(a aVar) {
        this();
    }

    /* renamed from: b */
    public static int m11719b(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    /* renamed from: c */
    public static long m11720c(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    /* renamed from: f */
    public static AbstractC1923j m11721f(byte[] bArr) {
        return m11722g(bArr, 0, bArr.length);
    }

    /* renamed from: g */
    public static AbstractC1923j m11722g(byte[] bArr, int i10, int i11) {
        return m11723h(bArr, i10, i11, false);
    }

    /* renamed from: h */
    public static AbstractC1923j m11723h(byte[] bArr, int i10, int i11, boolean z10) {
        b bVar = new b(bArr, i10, i11, z10);
        try {
            bVar.mo11731j(i11);
            return bVar;
        } catch (C1903c0 e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    /* renamed from: A */
    public abstract int mo11724A() throws IOException;

    /* renamed from: B */
    public abstract long mo11725B() throws IOException;

    /* renamed from: C */
    public abstract boolean mo11726C(int i10) throws IOException;

    /* renamed from: a */
    public abstract void mo11727a(int i10) throws C1903c0;

    /* renamed from: d */
    public abstract int mo11728d();

    /* renamed from: e */
    public abstract boolean mo11729e() throws IOException;

    /* renamed from: i */
    public abstract void mo11730i(int i10);

    /* renamed from: j */
    public abstract int mo11731j(int i10) throws C1903c0;

    /* renamed from: k */
    public abstract boolean mo11732k() throws IOException;

    /* renamed from: l */
    public abstract AbstractC1920i mo11733l() throws IOException;

    /* renamed from: m */
    public abstract double mo11734m() throws IOException;

    /* renamed from: n */
    public abstract int mo11735n() throws IOException;

    /* renamed from: o */
    public abstract int mo11736o() throws IOException;

    /* renamed from: p */
    public abstract long mo11737p() throws IOException;

    /* renamed from: q */
    public abstract float mo11738q() throws IOException;

    /* renamed from: r */
    public abstract int mo11739r() throws IOException;

    /* renamed from: s */
    public abstract long mo11740s() throws IOException;

    /* renamed from: t */
    public abstract int mo11741t() throws IOException;

    /* renamed from: u */
    public abstract long mo11742u() throws IOException;

    /* renamed from: v */
    public abstract int mo11743v() throws IOException;

    /* renamed from: w */
    public abstract long mo11744w() throws IOException;

    /* renamed from: x */
    public abstract String mo11745x() throws IOException;

    /* renamed from: y */
    public abstract String mo11746y() throws IOException;

    /* renamed from: z */
    public abstract int mo11747z() throws IOException;

    public AbstractC1923j() {
        this.f9163b = 100;
        this.f9164c = Integer.MAX_VALUE;
        this.f9166e = false;
    }
}
