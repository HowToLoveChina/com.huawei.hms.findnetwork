package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1930l0;
import com.google.flatbuffers.reflection.BaseType;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.f */
/* loaded from: classes.dex */
public abstract class AbstractC1911f implements InterfaceC1916g1 {

    /* renamed from: com.google.crypto.tink.shaded.protobuf.f$b */
    public static final class b extends AbstractC1911f {

        /* renamed from: a */
        public final boolean f9125a;

        /* renamed from: b */
        public final byte[] f9126b;

        /* renamed from: c */
        public int f9127c;

        /* renamed from: d */
        public final int f9128d;

        /* renamed from: e */
        public int f9129e;

        /* renamed from: f */
        public int f9130f;

        /* renamed from: g */
        public int f9131g;

        public b(ByteBuffer byteBuffer, boolean z10) {
            super();
            this.f9125a = z10;
            this.f9126b = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f9127c = iArrayOffset;
            this.f9128d = iArrayOffset;
            this.f9129e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: A */
        public <T> T mo11570A(Class<T> cls, C1944q c1944q) throws IOException {
            m11608g0(2);
            return (T) m11593Y(C1907d1.m11516a().m11519d(cls), c1944q);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: B */
        public int mo11571B() throws IOException {
            if (m11586R()) {
                return Integer.MAX_VALUE;
            }
            int iM11598b0 = m11598b0();
            this.f9130f = iM11598b0;
            if (iM11598b0 == this.f9131g) {
                return Integer.MAX_VALUE;
            }
            return C1958u1.m12257a(iM11598b0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: C */
        public void mo11572C(List<String> list) throws IOException {
            m11596a0(list, false);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: D */
        public void mo11573D(List<String> list) throws IOException {
            m11596a0(list, true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: E */
        public AbstractC1920i mo11574E() throws IOException {
            m11608g0(2);
            int iM11598b0 = m11598b0();
            if (iM11598b0 == 0) {
                return AbstractC1920i.f9147b;
            }
            m11604e0(iM11598b0);
            AbstractC1920i abstractC1920iM11678D = this.f9125a ? AbstractC1920i.m11678D(this.f9126b, this.f9127c, iM11598b0) : AbstractC1920i.m11683g(this.f9126b, this.f9127c, iM11598b0);
            this.f9127c += iM11598b0;
            return abstractC1920iM11678D;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: F */
        public void mo11575F(List<Float> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1964x)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b == 2) {
                    int iM11598b0 = m11598b0();
                    m11618l0(iM11598b0);
                    int i12 = this.f9127c + iM11598b0;
                    while (this.f9127c < i12) {
                        list.add(Float.valueOf(Float.intBitsToFloat(m11590V())));
                    }
                    return;
                }
                if (iM12258b != 5) {
                    throw C1903c0.m11505e();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (m11586R()) {
                        return;
                    } else {
                        i10 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i10;
                return;
            }
            C1964x c1964x = (C1964x) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 == 2) {
                int iM11598b02 = m11598b0();
                m11618l0(iM11598b02);
                int i13 = this.f9127c + iM11598b02;
                while (this.f9127c < i13) {
                    c1964x.m12367d(Float.intBitsToFloat(m11590V()));
                }
                return;
            }
            if (iM12258b2 != 5) {
                throw C1903c0.m11505e();
            }
            do {
                c1964x.m12367d(readFloat());
                if (m11586R()) {
                    return;
                } else {
                    i11 = this.f9127c;
                }
            } while (m11598b0() == this.f9130f);
            this.f9127c = i11;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: G */
        public int mo11576G() throws IOException {
            m11608g0(0);
            return m11598b0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: H */
        public boolean mo11577H() throws IOException {
            int i10;
            if (m11586R() || (i10 = this.f9130f) == this.f9131g) {
                return false;
            }
            int iM12258b = C1958u1.m12258b(i10);
            if (iM12258b == 0) {
                m11614j0();
                return true;
            }
            if (iM12258b == 1) {
                m11610h0(8);
                return true;
            }
            if (iM12258b == 2) {
                m11610h0(m11598b0());
                return true;
            }
            if (iM12258b == 3) {
                m11612i0();
                return true;
            }
            if (iM12258b != 5) {
                throw C1903c0.m11505e();
            }
            m11610h0(4);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: I */
        public int mo11578I() throws IOException {
            m11608g0(5);
            return m11589U();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: J */
        public void mo11579J(List<AbstractC1920i> list) throws IOException {
            int i10;
            if (C1958u1.m12258b(this.f9130f) != 2) {
                throw C1903c0.m11505e();
            }
            do {
                list.add(mo11574E());
                if (m11586R()) {
                    return;
                } else {
                    i10 = this.f9127c;
                }
            } while (m11598b0() == this.f9130f);
            this.f9127c = i10;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: K */
        public <K, V> void mo11580K(Map<K, V> map, C1930l0.a<K, V> aVar, C1944q c1944q) throws IOException {
            m11608g0(2);
            int iM11598b0 = m11598b0();
            m11604e0(iM11598b0);
            int i10 = this.f9129e;
            this.f9129e = this.f9127c + iM11598b0;
            try {
                throw null;
            } catch (Throwable th2) {
                this.f9129e = i10;
                throw th2;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: L */
        public void mo11581L(List<Double> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1935n)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (m11586R()) {
                            return;
                        } else {
                            i10 = this.f9127c;
                        }
                    } while (m11598b0() == this.f9130f);
                    this.f9127c = i10;
                    return;
                }
                if (iM12258b != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b0 = m11598b0();
                m11620m0(iM11598b0);
                int i12 = this.f9127c + iM11598b0;
                while (this.f9127c < i12) {
                    list.add(Double.valueOf(Double.longBitsToDouble(m11592X())));
                }
                return;
            }
            C1935n c1935n = (C1935n) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 == 1) {
                do {
                    c1935n.m12041d(readDouble());
                    if (m11586R()) {
                        return;
                    } else {
                        i11 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i11;
                return;
            }
            if (iM12258b2 != 2) {
                throw C1903c0.m11505e();
            }
            int iM11598b02 = m11598b0();
            m11620m0(iM11598b02);
            int i13 = this.f9127c + iM11598b02;
            while (this.f9127c < i13) {
                c1935n.m12041d(Double.longBitsToDouble(m11592X()));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: M */
        public <T> void mo11582M(List<T> list, InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
            int i10;
            if (C1958u1.m12258b(this.f9130f) != 3) {
                throw C1903c0.m11505e();
            }
            int i11 = this.f9130f;
            do {
                list.add(m11588T(interfaceC1919h1, c1944q));
                if (m11586R()) {
                    return;
                } else {
                    i10 = this.f9127c;
                }
            } while (m11598b0() == i11);
            this.f9127c = i10;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: N */
        public long mo11583N() throws IOException {
            m11608g0(0);
            return m11600c0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: O */
        public String mo11584O() throws IOException {
            return m11594Z(true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: P */
        public void mo11585P(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1924j0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b == 1) {
                    do {
                        list.add(Long.valueOf(mo11601d()));
                        if (m11586R()) {
                            return;
                        } else {
                            i10 = this.f9127c;
                        }
                    } while (m11598b0() == this.f9130f);
                    this.f9127c = i10;
                    return;
                }
                if (iM12258b != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b0 = m11598b0();
                m11620m0(iM11598b0);
                int i12 = this.f9127c + iM11598b0;
                while (this.f9127c < i12) {
                    list.add(Long.valueOf(m11592X()));
                }
                return;
            }
            C1924j0 c1924j0 = (C1924j0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 == 1) {
                do {
                    c1924j0.m11766e(mo11601d());
                    if (m11586R()) {
                        return;
                    } else {
                        i11 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i11;
                return;
            }
            if (iM12258b2 != 2) {
                throw C1903c0.m11505e();
            }
            int iM11598b02 = m11598b0();
            m11620m0(iM11598b02);
            int i13 = this.f9127c + iM11598b02;
            while (this.f9127c < i13) {
                c1924j0.m11766e(m11592X());
            }
        }

        /* renamed from: R */
        public final boolean m11586R() {
            return this.f9127c == this.f9129e;
        }

        /* renamed from: S */
        public final byte m11587S() throws IOException {
            int i10 = this.f9127c;
            if (i10 == this.f9129e) {
                throw C1903c0.m11510l();
            }
            byte[] bArr = this.f9126b;
            this.f9127c = i10 + 1;
            return bArr[i10];
        }

        /* renamed from: T */
        public final <T> T m11588T(InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
            int i10 = this.f9131g;
            this.f9131g = C1958u1.m12259c(C1958u1.m12257a(this.f9130f), 4);
            try {
                T tMo11675i = interfaceC1919h1.mo11675i();
                interfaceC1919h1.mo11672f(tMo11675i, this, c1944q);
                interfaceC1919h1.mo11668b(tMo11675i);
                if (this.f9130f == this.f9131g) {
                    return tMo11675i;
                }
                throw C1903c0.m11508h();
            } finally {
                this.f9131g = i10;
            }
        }

        /* renamed from: U */
        public final int m11589U() throws IOException {
            m11604e0(4);
            return m11590V();
        }

        /* renamed from: V */
        public final int m11590V() {
            int i10 = this.f9127c;
            byte[] bArr = this.f9126b;
            this.f9127c = i10 + 4;
            return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24);
        }

        /* renamed from: W */
        public final long m11591W() throws IOException {
            m11604e0(8);
            return m11592X();
        }

        /* renamed from: X */
        public final long m11592X() {
            int i10 = this.f9127c;
            byte[] bArr = this.f9126b;
            this.f9127c = i10 + 8;
            return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
        }

        /* renamed from: Y */
        public final <T> T m11593Y(InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
            int iM11598b0 = m11598b0();
            m11604e0(iM11598b0);
            int i10 = this.f9129e;
            int i11 = this.f9127c + iM11598b0;
            this.f9129e = i11;
            try {
                T tMo11675i = interfaceC1919h1.mo11675i();
                interfaceC1919h1.mo11672f(tMo11675i, this, c1944q);
                interfaceC1919h1.mo11668b(tMo11675i);
                if (this.f9127c == i11) {
                    return tMo11675i;
                }
                throw C1903c0.m11508h();
            } finally {
                this.f9129e = i10;
            }
        }

        /* renamed from: Z */
        public String m11594Z(boolean z10) throws IOException {
            m11608g0(2);
            int iM11598b0 = m11598b0();
            if (iM11598b0 == 0) {
                return "";
            }
            m11604e0(iM11598b0);
            if (z10) {
                byte[] bArr = this.f9126b;
                int i10 = this.f9127c;
                if (!C1955t1.m12223n(bArr, i10, i10 + iM11598b0)) {
                    throw C1903c0.m11504d();
                }
            }
            String str = new String(this.f9126b, this.f9127c, iM11598b0, C1900b0.f9085a);
            this.f9127c += iM11598b0;
            return str;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: a */
        public int mo11595a() {
            return this.f9130f;
        }

        /* renamed from: a0 */
        public void m11596a0(List<String> list, boolean z10) throws IOException {
            int i10;
            int i11;
            if (C1958u1.m12258b(this.f9130f) != 2) {
                throw C1903c0.m11505e();
            }
            if (!(list instanceof InterfaceC1918h0) || z10) {
                do {
                    list.add(m11594Z(z10));
                    if (m11586R()) {
                        return;
                    } else {
                        i10 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i10;
                return;
            }
            InterfaceC1918h0 interfaceC1918h0 = (InterfaceC1918h0) list;
            do {
                interfaceC1918h0.mo11658V(mo11574E());
                if (m11586R()) {
                    return;
                } else {
                    i11 = this.f9127c;
                }
            } while (m11598b0() == this.f9130f);
            this.f9127c = i11;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: b */
        public void mo11597b(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1897a0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b != 0) {
                    if (iM12258b != 2) {
                        throw C1903c0.m11505e();
                    }
                    int iM11598b0 = this.f9127c + m11598b0();
                    while (this.f9127c < iM11598b0) {
                        list.add(Integer.valueOf(AbstractC1923j.m11719b(m11598b0())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(mo11629v()));
                    if (m11586R()) {
                        return;
                    } else {
                        i10 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i10;
                return;
            }
            C1897a0 c1897a0 = (C1897a0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 != 0) {
                if (iM12258b2 != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b02 = this.f9127c + m11598b0();
                while (this.f9127c < iM11598b02) {
                    c1897a0.m11471d(AbstractC1923j.m11719b(m11598b0()));
                }
                return;
            }
            do {
                c1897a0.m11471d(mo11629v());
                if (m11586R()) {
                    return;
                } else {
                    i11 = this.f9127c;
                }
            } while (m11598b0() == this.f9130f);
            this.f9127c = i11;
        }

        /* renamed from: b0 */
        public final int m11598b0() throws IOException {
            int i10;
            int i11 = this.f9127c;
            int i12 = this.f9129e;
            if (i12 == i11) {
                throw C1903c0.m11510l();
            }
            byte[] bArr = this.f9126b;
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 >= 0) {
                this.f9127c = i13;
                return b10;
            }
            if (i12 - i13 < 9) {
                return (int) m11602d0();
            }
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
                                            if (bArr[i16] < 0) {
                                                throw C1903c0.m11506f();
                                            }
                                            i14 = i21;
                                            i10 = i20;
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
            this.f9127c = i14;
            return i10;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: c */
        public long mo11599c() throws IOException {
            m11608g0(0);
            return m11600c0();
        }

        /* renamed from: c0 */
        public long m11600c0() throws IOException {
            long j10;
            long j11;
            long j12;
            int i10 = this.f9127c;
            int i11 = this.f9129e;
            if (i11 == i10) {
                throw C1903c0.m11510l();
            }
            byte[] bArr = this.f9126b;
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f9127c = i12;
                return b10;
            }
            if (i11 - i12 < 9) {
                return m11602d0();
            }
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
                                            if (bArr[i13] < 0) {
                                                throw C1903c0.m11506f();
                                            }
                                            i13 = i20;
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
            this.f9127c = i13;
            return j10;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: d */
        public long mo11601d() throws IOException {
            m11608g0(1);
            return m11591W();
        }

        /* renamed from: d0 */
        public final long m11602d0() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & 127) << i10;
                if ((m11587S() & 128) == 0) {
                    return j10;
                }
            }
            throw C1903c0.m11506f();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: e */
        public void mo11603e(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1897a0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b == 2) {
                    int iM11598b0 = m11598b0();
                    m11618l0(iM11598b0);
                    int i12 = this.f9127c + iM11598b0;
                    while (this.f9127c < i12) {
                        list.add(Integer.valueOf(m11590V()));
                    }
                    return;
                }
                if (iM12258b != 5) {
                    throw C1903c0.m11505e();
                }
                do {
                    list.add(Integer.valueOf(mo11578I()));
                    if (m11586R()) {
                        return;
                    } else {
                        i10 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i10;
                return;
            }
            C1897a0 c1897a0 = (C1897a0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 == 2) {
                int iM11598b02 = m11598b0();
                m11618l0(iM11598b02);
                int i13 = this.f9127c + iM11598b02;
                while (this.f9127c < i13) {
                    c1897a0.m11471d(m11590V());
                }
                return;
            }
            if (iM12258b2 != 5) {
                throw C1903c0.m11505e();
            }
            do {
                c1897a0.m11471d(mo11578I());
                if (m11586R()) {
                    return;
                } else {
                    i11 = this.f9127c;
                }
            } while (m11598b0() == this.f9130f);
            this.f9127c = i11;
        }

        /* renamed from: e0 */
        public final void m11604e0(int i10) throws IOException {
            if (i10 < 0 || i10 > this.f9129e - this.f9127c) {
                throw C1903c0.m11510l();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: f */
        public void mo11605f(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1924j0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b != 0) {
                    if (iM12258b != 2) {
                        throw C1903c0.m11505e();
                    }
                    int iM11598b0 = this.f9127c + m11598b0();
                    while (this.f9127c < iM11598b0) {
                        list.add(Long.valueOf(AbstractC1923j.m11720c(m11600c0())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(mo11630w()));
                    if (m11586R()) {
                        return;
                    } else {
                        i10 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i10;
                return;
            }
            C1924j0 c1924j0 = (C1924j0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 != 0) {
                if (iM12258b2 != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b02 = this.f9127c + m11598b0();
                while (this.f9127c < iM11598b02) {
                    c1924j0.m11766e(AbstractC1923j.m11720c(m11600c0()));
                }
                return;
            }
            do {
                c1924j0.m11766e(mo11630w());
                if (m11586R()) {
                    return;
                } else {
                    i11 = this.f9127c;
                }
            } while (m11598b0() == this.f9130f);
            this.f9127c = i11;
        }

        /* renamed from: f0 */
        public final void m11606f0(int i10) throws IOException {
            if (this.f9127c != i10) {
                throw C1903c0.m11510l();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: g */
        public void mo11607g(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1897a0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b != 0) {
                    if (iM12258b != 2) {
                        throw C1903c0.m11505e();
                    }
                    int iM11598b0 = this.f9127c + m11598b0();
                    while (this.f9127c < iM11598b0) {
                        list.add(Integer.valueOf(m11598b0()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(mo11619m()));
                    if (m11586R()) {
                        return;
                    } else {
                        i10 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i10;
                return;
            }
            C1897a0 c1897a0 = (C1897a0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 != 0) {
                if (iM12258b2 != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b02 = this.f9127c + m11598b0();
                while (this.f9127c < iM11598b02) {
                    c1897a0.m11471d(m11598b0());
                }
                return;
            }
            do {
                c1897a0.m11471d(mo11619m());
                if (m11586R()) {
                    return;
                } else {
                    i11 = this.f9127c;
                }
            } while (m11598b0() == this.f9130f);
            this.f9127c = i11;
        }

        /* renamed from: g0 */
        public final void m11608g0(int i10) throws IOException {
            if (C1958u1.m12258b(this.f9130f) != i10) {
                throw C1903c0.m11505e();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: h */
        public <T> void mo11609h(List<T> list, InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
            int i10;
            if (C1958u1.m12258b(this.f9130f) != 2) {
                throw C1903c0.m11505e();
            }
            int i11 = this.f9130f;
            do {
                list.add(m11593Y(interfaceC1919h1, c1944q));
                if (m11586R()) {
                    return;
                } else {
                    i10 = this.f9127c;
                }
            } while (m11598b0() == i11);
            this.f9127c = i10;
        }

        /* renamed from: h0 */
        public final void m11610h0(int i10) throws IOException {
            m11604e0(i10);
            this.f9127c += i10;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: i */
        public int mo11611i() throws IOException {
            m11608g0(5);
            return m11589U();
        }

        /* renamed from: i0 */
        public final void m11612i0() throws IOException {
            int i10 = this.f9131g;
            this.f9131g = C1958u1.m12259c(C1958u1.m12257a(this.f9130f), 4);
            while (mo11571B() != Integer.MAX_VALUE && mo11577H()) {
            }
            if (this.f9130f != this.f9131g) {
                throw C1903c0.m11508h();
            }
            this.f9131g = i10;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: j */
        public boolean mo11613j() throws IOException {
            m11608g0(0);
            return m11598b0() != 0;
        }

        /* renamed from: j0 */
        public final void m11614j0() throws IOException {
            int i10 = this.f9129e;
            int i11 = this.f9127c;
            if (i10 - i11 >= 10) {
                byte[] bArr = this.f9126b;
                int i12 = 0;
                while (i12 < 10) {
                    int i13 = i11 + 1;
                    if (bArr[i11] >= 0) {
                        this.f9127c = i13;
                        return;
                    } else {
                        i12++;
                        i11 = i13;
                    }
                }
            }
            m11616k0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: k */
        public long mo11615k() throws IOException {
            m11608g0(1);
            return m11591W();
        }

        /* renamed from: k0 */
        public final void m11616k0() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (m11587S() >= 0) {
                    return;
                }
            }
            throw C1903c0.m11506f();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: l */
        public void mo11617l(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1924j0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b == 0) {
                    do {
                        list.add(Long.valueOf(mo11599c()));
                        if (m11586R()) {
                            return;
                        } else {
                            i10 = this.f9127c;
                        }
                    } while (m11598b0() == this.f9130f);
                    this.f9127c = i10;
                    return;
                }
                if (iM12258b != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b0 = this.f9127c + m11598b0();
                while (this.f9127c < iM11598b0) {
                    list.add(Long.valueOf(m11600c0()));
                }
                m11606f0(iM11598b0);
                return;
            }
            C1924j0 c1924j0 = (C1924j0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 == 0) {
                do {
                    c1924j0.m11766e(mo11599c());
                    if (m11586R()) {
                        return;
                    } else {
                        i11 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i11;
                return;
            }
            if (iM12258b2 != 2) {
                throw C1903c0.m11505e();
            }
            int iM11598b02 = this.f9127c + m11598b0();
            while (this.f9127c < iM11598b02) {
                c1924j0.m11766e(m11600c0());
            }
            m11606f0(iM11598b02);
        }

        /* renamed from: l0 */
        public final void m11618l0(int i10) throws IOException {
            m11604e0(i10);
            if ((i10 & 3) != 0) {
                throw C1903c0.m11508h();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: m */
        public int mo11619m() throws IOException {
            m11608g0(0);
            return m11598b0();
        }

        /* renamed from: m0 */
        public final void m11620m0(int i10) throws IOException {
            m11604e0(i10);
            if ((i10 & 7) != 0) {
                throw C1903c0.m11508h();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: n */
        public void mo11621n(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1924j0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b == 0) {
                    do {
                        list.add(Long.valueOf(mo11583N()));
                        if (m11586R()) {
                            return;
                        } else {
                            i10 = this.f9127c;
                        }
                    } while (m11598b0() == this.f9130f);
                    this.f9127c = i10;
                    return;
                }
                if (iM12258b != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b0 = this.f9127c + m11598b0();
                while (this.f9127c < iM11598b0) {
                    list.add(Long.valueOf(m11600c0()));
                }
                m11606f0(iM11598b0);
                return;
            }
            C1924j0 c1924j0 = (C1924j0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 == 0) {
                do {
                    c1924j0.m11766e(mo11583N());
                    if (m11586R()) {
                        return;
                    } else {
                        i11 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i11;
                return;
            }
            if (iM12258b2 != 2) {
                throw C1903c0.m11505e();
            }
            int iM11598b02 = this.f9127c + m11598b0();
            while (this.f9127c < iM11598b02) {
                c1924j0.m11766e(m11600c0());
            }
            m11606f0(iM11598b02);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: o */
        public void mo11622o(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1924j0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b == 1) {
                    do {
                        list.add(Long.valueOf(mo11615k()));
                        if (m11586R()) {
                            return;
                        } else {
                            i10 = this.f9127c;
                        }
                    } while (m11598b0() == this.f9130f);
                    this.f9127c = i10;
                    return;
                }
                if (iM12258b != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b0 = m11598b0();
                m11620m0(iM11598b0);
                int i12 = this.f9127c + iM11598b0;
                while (this.f9127c < i12) {
                    list.add(Long.valueOf(m11592X()));
                }
                return;
            }
            C1924j0 c1924j0 = (C1924j0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 == 1) {
                do {
                    c1924j0.m11766e(mo11615k());
                    if (m11586R()) {
                        return;
                    } else {
                        i11 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i11;
                return;
            }
            if (iM12258b2 != 2) {
                throw C1903c0.m11505e();
            }
            int iM11598b02 = m11598b0();
            m11620m0(iM11598b02);
            int i13 = this.f9127c + iM11598b02;
            while (this.f9127c < i13) {
                c1924j0.m11766e(m11592X());
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: p */
        public void mo11623p(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1897a0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b == 0) {
                    do {
                        list.add(Integer.valueOf(mo11576G()));
                        if (m11586R()) {
                            return;
                        } else {
                            i10 = this.f9127c;
                        }
                    } while (m11598b0() == this.f9130f);
                    this.f9127c = i10;
                    return;
                }
                if (iM12258b != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b0 = this.f9127c + m11598b0();
                while (this.f9127c < iM11598b0) {
                    list.add(Integer.valueOf(m11598b0()));
                }
                m11606f0(iM11598b0);
                return;
            }
            C1897a0 c1897a0 = (C1897a0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 == 0) {
                do {
                    c1897a0.m11471d(mo11576G());
                    if (m11586R()) {
                        return;
                    } else {
                        i11 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i11;
                return;
            }
            if (iM12258b2 != 2) {
                throw C1903c0.m11505e();
            }
            int iM11598b02 = this.f9127c + m11598b0();
            while (this.f9127c < iM11598b02) {
                c1897a0.m11471d(m11598b0());
            }
            m11606f0(iM11598b02);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: q */
        public void mo11624q(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1897a0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b != 0) {
                    if (iM12258b != 2) {
                        throw C1903c0.m11505e();
                    }
                    int iM11598b0 = this.f9127c + m11598b0();
                    while (this.f9127c < iM11598b0) {
                        list.add(Integer.valueOf(m11598b0()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(mo11626s()));
                    if (m11586R()) {
                        return;
                    } else {
                        i10 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i10;
                return;
            }
            C1897a0 c1897a0 = (C1897a0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 != 0) {
                if (iM12258b2 != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b02 = this.f9127c + m11598b0();
                while (this.f9127c < iM11598b02) {
                    c1897a0.m11471d(m11598b0());
                }
                return;
            }
            do {
                c1897a0.m11471d(mo11626s());
                if (m11586R()) {
                    return;
                } else {
                    i11 = this.f9127c;
                }
            } while (m11598b0() == this.f9130f);
            this.f9127c = i11;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: r */
        public <T> T mo11625r(InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
            m11608g0(3);
            return (T) m11588T(interfaceC1919h1, c1944q);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        public double readDouble() throws IOException {
            m11608g0(1);
            return Double.longBitsToDouble(m11591W());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        public float readFloat() throws IOException {
            m11608g0(5);
            return Float.intBitsToFloat(m11589U());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: s */
        public int mo11626s() throws IOException {
            m11608g0(0);
            return m11598b0();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: t */
        public <T> T mo11627t(InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
            m11608g0(2);
            return (T) m11593Y(interfaceC1919h1, c1944q);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: u */
        public void mo11628u(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1897a0)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b == 2) {
                    int iM11598b0 = m11598b0();
                    m11618l0(iM11598b0);
                    int i12 = this.f9127c + iM11598b0;
                    while (this.f9127c < i12) {
                        list.add(Integer.valueOf(m11590V()));
                    }
                    return;
                }
                if (iM12258b != 5) {
                    throw C1903c0.m11505e();
                }
                do {
                    list.add(Integer.valueOf(mo11611i()));
                    if (m11586R()) {
                        return;
                    } else {
                        i10 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i10;
                return;
            }
            C1897a0 c1897a0 = (C1897a0) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 == 2) {
                int iM11598b02 = m11598b0();
                m11618l0(iM11598b02);
                int i13 = this.f9127c + iM11598b02;
                while (this.f9127c < i13) {
                    c1897a0.m11471d(m11590V());
                }
                return;
            }
            if (iM12258b2 != 5) {
                throw C1903c0.m11505e();
            }
            do {
                c1897a0.m11471d(mo11611i());
                if (m11586R()) {
                    return;
                } else {
                    i11 = this.f9127c;
                }
            } while (m11598b0() == this.f9130f);
            this.f9127c = i11;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: v */
        public int mo11629v() throws IOException {
            m11608g0(0);
            return AbstractC1923j.m11719b(m11598b0());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: w */
        public long mo11630w() throws IOException {
            m11608g0(0);
            return AbstractC1923j.m11720c(m11600c0());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: x */
        public <T> T mo11631x(Class<T> cls, C1944q c1944q) throws IOException {
            m11608g0(3);
            return (T) m11588T(C1907d1.m11516a().m11519d(cls), c1944q);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: y */
        public void mo11632y(List<Boolean> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1914g)) {
                int iM12258b = C1958u1.m12258b(this.f9130f);
                if (iM12258b != 0) {
                    if (iM12258b != 2) {
                        throw C1903c0.m11505e();
                    }
                    int iM11598b0 = this.f9127c + m11598b0();
                    while (this.f9127c < iM11598b0) {
                        list.add(Boolean.valueOf(m11598b0() != 0));
                    }
                    m11606f0(iM11598b0);
                    return;
                }
                do {
                    list.add(Boolean.valueOf(mo11613j()));
                    if (m11586R()) {
                        return;
                    } else {
                        i10 = this.f9127c;
                    }
                } while (m11598b0() == this.f9130f);
                this.f9127c = i10;
                return;
            }
            C1914g c1914g = (C1914g) list;
            int iM12258b2 = C1958u1.m12258b(this.f9130f);
            if (iM12258b2 != 0) {
                if (iM12258b2 != 2) {
                    throw C1903c0.m11505e();
                }
                int iM11598b02 = this.f9127c + m11598b0();
                while (this.f9127c < iM11598b02) {
                    c1914g.m11647e(m11598b0() != 0);
                }
                m11606f0(iM11598b02);
                return;
            }
            do {
                c1914g.m11647e(mo11613j());
                if (m11586R()) {
                    return;
                } else {
                    i11 = this.f9127c;
                }
            } while (m11598b0() == this.f9130f);
            this.f9127c = i11;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
        /* renamed from: z */
        public String mo11633z() throws IOException {
            return m11594Z(false);
        }
    }

    public /* synthetic */ AbstractC1911f(a aVar) {
        this();
    }

    /* renamed from: Q */
    public static AbstractC1911f m11569Q(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, z10);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public AbstractC1911f() {
    }
}
