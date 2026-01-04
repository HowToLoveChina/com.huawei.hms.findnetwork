package com.huawei.hms.network.embedded;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.hms.network.embedded.bb */
/* loaded from: classes8.dex */
public final class C5868bb implements InterfaceC5896db, InterfaceC5882cb, Cloneable, ByteChannel {

    /* renamed from: c */
    public static final byte[] f26521c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: d */
    public static final int f26522d = 65533;

    /* renamed from: a */
    public C6131vb f26523a;

    /* renamed from: b */
    public long f26524b;

    /* renamed from: com.huawei.hms.network.embedded.bb$a */
    public class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return C5868bb.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            C5868bb.this.writeByte((int) ((byte) i10));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            C5868bb.this.write(bArr, i10, i11);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.bb$b */
    public class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(C5868bb.this.f26524b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            C5868bb c5868bb = C5868bb.this;
            if (c5868bb.f26524b > 0) {
                return c5868bb.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return C5868bb.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            return C5868bb.this.read(bArr, i10, i11);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.bb$c */
    public static final class c implements Closeable {

        /* renamed from: a */
        public C5868bb f26527a;

        /* renamed from: b */
        public boolean f26528b;

        /* renamed from: c */
        public C6131vb f26529c;

        /* renamed from: e */
        public byte[] f26531e;

        /* renamed from: d */
        public long f26530d = -1;

        /* renamed from: f */
        public int f26532f = -1;

        /* renamed from: g */
        public int f26533g = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f26527a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f26527a = null;
            this.f26529c = null;
            this.f26530d = -1L;
            this.f26531e = null;
            this.f26532f = -1;
            this.f26533g = -1;
        }

        /* renamed from: d */
        public final long m33991d(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i10);
            }
            if (i10 > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i10);
            }
            C5868bb c5868bb = this.f26527a;
            if (c5868bb == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f26528b) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j10 = c5868bb.f26524b;
            C6131vb c6131vbM33961e = c5868bb.m33961e(i10);
            int i11 = 8192 - c6131vbM33961e.f28800c;
            c6131vbM33961e.f28800c = 8192;
            long j11 = i11;
            this.f26527a.f26524b = j10 + j11;
            this.f26529c = c6131vbM33961e;
            this.f26530d = j10;
            this.f26531e = c6131vbM33961e.f28798a;
            this.f26532f = 8192 - i11;
            this.f26533g = 8192;
            return j11;
        }

        /* renamed from: j */
        public final long m33992j(long j10) {
            C5868bb c5868bb = this.f26527a;
            if (c5868bb == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.f26528b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j11 = c5868bb.f26524b;
            if (j10 <= j11) {
                if (j10 < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + j10);
                }
                long j12 = j11 - j10;
                while (true) {
                    if (j12 <= 0) {
                        break;
                    }
                    C5868bb c5868bb2 = this.f26527a;
                    C6131vb c6131vb = c5868bb2.f26523a.f28804g;
                    int i10 = c6131vb.f28800c;
                    long j13 = i10 - c6131vb.f28799b;
                    if (j13 > j12) {
                        c6131vb.f28800c = (int) (i10 - j12);
                        break;
                    }
                    c5868bb2.f26523a = c6131vb.m35704b();
                    C6144wb.m35761a(c6131vb);
                    j12 -= j13;
                }
                this.f26529c = null;
                this.f26530d = j10;
                this.f26531e = null;
                this.f26532f = -1;
                this.f26533g = -1;
            } else if (j10 > j11) {
                long j14 = j10 - j11;
                boolean z10 = true;
                while (j14 > 0) {
                    C6131vb c6131vbM33961e = this.f26527a.m33961e(1);
                    int iMin = (int) Math.min(j14, 8192 - c6131vbM33961e.f28800c);
                    int i11 = c6131vbM33961e.f28800c + iMin;
                    c6131vbM33961e.f28800c = i11;
                    j14 -= iMin;
                    if (z10) {
                        this.f26529c = c6131vbM33961e;
                        this.f26530d = j11;
                        this.f26531e = c6131vbM33961e.f28798a;
                        this.f26532f = i11 - iMin;
                        this.f26533g = i11;
                        z10 = false;
                    }
                }
            }
            this.f26527a.f26524b = j10;
            return j11;
        }

        /* renamed from: k */
        public final int m33993k(long j10) {
            if (j10 >= -1) {
                C5868bb c5868bb = this.f26527a;
                long j11 = c5868bb.f26524b;
                if (j10 <= j11) {
                    if (j10 == -1 || j10 == j11) {
                        this.f26529c = null;
                        this.f26530d = j10;
                        this.f26531e = null;
                        this.f26532f = -1;
                        this.f26533g = -1;
                        return -1;
                    }
                    C6131vb c6131vb = c5868bb.f26523a;
                    C6131vb c6131vbM35701a = this.f26529c;
                    long j12 = 0;
                    if (c6131vbM35701a != null) {
                        long j13 = this.f26530d - (this.f26532f - c6131vbM35701a.f28799b);
                        if (j13 > j10) {
                            j11 = j13;
                            c6131vbM35701a = c6131vb;
                            c6131vb = c6131vbM35701a;
                        } else {
                            j12 = j13;
                        }
                    } else {
                        c6131vbM35701a = c6131vb;
                    }
                    if (j11 - j10 > j10 - j12) {
                        while (true) {
                            long j14 = (c6131vbM35701a.f28800c - c6131vbM35701a.f28799b) + j12;
                            if (j10 < j14) {
                                break;
                            }
                            c6131vbM35701a = c6131vbM35701a.f28803f;
                            j12 = j14;
                        }
                    } else {
                        while (j11 > j10) {
                            c6131vb = c6131vb.f28804g;
                            j11 -= c6131vb.f28800c - c6131vb.f28799b;
                        }
                        c6131vbM35701a = c6131vb;
                        j12 = j11;
                    }
                    if (this.f26528b && c6131vbM35701a.f28801d) {
                        C6131vb c6131vbM35706d = c6131vbM35701a.m35706d();
                        C5868bb c5868bb2 = this.f26527a;
                        if (c5868bb2.f26523a == c6131vbM35701a) {
                            c5868bb2.f26523a = c6131vbM35706d;
                        }
                        c6131vbM35701a = c6131vbM35701a.m35701a(c6131vbM35706d);
                        c6131vbM35701a.f28804g.m35704b();
                    }
                    this.f26529c = c6131vbM35701a;
                    this.f26530d = j10;
                    this.f26531e = c6131vbM35701a.f28798a;
                    int i10 = c6131vbM35701a.f28799b + ((int) (j10 - j12));
                    this.f26532f = i10;
                    int i11 = c6131vbM35701a.f28800c;
                    this.f26533g = i11;
                    return i11 - i10;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j10), Long.valueOf(this.f26527a.f26524b)));
        }

        /* renamed from: s */
        public final int m33994s() {
            long j10 = this.f26530d;
            if (j10 != this.f26527a.f26524b) {
                return m33993k(j10 == -1 ? 0L : j10 + (this.f26533g - this.f26532f));
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: A */
    public final C5910eb m33912A() {
        return m33911b("SHA-512");
    }

    /* renamed from: B */
    public final long m33913B() {
        return this.f26524b;
    }

    /* renamed from: C */
    public final C5910eb m33914C() {
        long j10 = this.f26524b;
        if (j10 <= 2147483647L) {
            return m33956d((int) j10);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f26524b);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public int mo33915a(C6053pb c6053pb) {
        int iM33916a = m33916a(c6053pb, false);
        if (iM33916a == -1) {
            return -1;
        }
        try {
            skip(c6053pb.f27791a[iM33916a].mo34192j());
            return iM33916a;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: b */
    public long mo33944b(C5910eb c5910eb) throws IOException {
        return mo33920a(c5910eb, 0L);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: c */
    public long mo33951c(C5910eb c5910eb) {
        return mo33945b(c5910eb, 0L);
    }

    /* renamed from: clone */
    public C5868bb m85653clone() {
        C5868bb c5868bb = new C5868bb();
        if (this.f26524b == 0) {
            return c5868bb;
        }
        C6131vb c6131vbM35705c = this.f26523a.m35705c();
        c5868bb.f26523a = c6131vbM35705c;
        c6131vbM35705c.f28804g = c6131vbM35705c;
        c6131vbM35705c.f28803f = c6131vbM35705c;
        C6131vb c6131vb = this.f26523a;
        while (true) {
            c6131vb = c6131vb.f28803f;
            if (c6131vb == this.f26523a) {
                c5868bb.f26524b = this.f26524b;
                return c5868bb;
            }
            c5868bb.f26523a.f28804g.m35701a(c6131vb.m35705c());
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
    public void close() {
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: d */
    public C5868bb mo33955d() {
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: e */
    public int mo33959e() {
        return C5883cc.m34085a(readInt());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5868bb)) {
            return false;
        }
        C5868bb c5868bb = (C5868bb) obj;
        long j10 = this.f26524b;
        if (j10 != c5868bb.f26524b) {
            return false;
        }
        long j11 = 0;
        if (j10 == 0) {
            return true;
        }
        C6131vb c6131vb = this.f26523a;
        C6131vb c6131vb2 = c5868bb.f26523a;
        int i10 = c6131vb.f28799b;
        int i11 = c6131vb2.f28799b;
        while (j11 < this.f26524b) {
            long jMin = Math.min(c6131vb.f28800c - i10, c6131vb2.f28800c - i11);
            int i12 = 0;
            while (i12 < jMin) {
                int i13 = i10 + 1;
                int i14 = i11 + 1;
                if (c6131vb.f28798a[i10] != c6131vb2.f28798a[i11]) {
                    return false;
                }
                i12++;
                i10 = i13;
                i11 = i14;
            }
            if (i10 == c6131vb.f28800c) {
                c6131vb = c6131vb.f28803f;
                i10 = c6131vb.f28799b;
            }
            if (i11 == c6131vb2.f28800c) {
                c6131vb2 = c6131vb2.f28803f;
                i11 = c6131vb2.f28799b;
            }
            j11 += jMin;
        }
        return true;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: f */
    public long mo33963f() {
        return C5883cc.m34086a(readLong());
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb, com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
    public void flush() {
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: g */
    public C5868bb mo33966g() {
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: h */
    public int mo33968h() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (this.f26524b == 0) {
            throw new EOFException();
        }
        byte bM33972j = m33972j(0L);
        if ((bM33972j & 128) == 0) {
            i10 = bM33972j & 127;
            i12 = 0;
            i11 = 1;
        } else if ((bM33972j & 224) == 192) {
            i10 = bM33972j & 31;
            i11 = 2;
            i12 = 128;
        } else if ((bM33972j & 240) == 224) {
            i10 = bM33972j & BaseType.Obj;
            i11 = 3;
            i12 = 2048;
        } else {
            if ((bM33972j & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i10 = bM33972j & 7;
            i11 = 4;
            i12 = 65536;
        }
        long j10 = i11;
        if (this.f26524b < j10) {
            throw new EOFException("size < " + i11 + ": " + this.f26524b + " (to read code point prefixed 0x" + Integer.toHexString(bM33972j) + ")");
        }
        for (int i13 = 1; i13 < i11; i13++) {
            long j11 = i13;
            byte bM33972j2 = m33972j(j11);
            if ((bM33972j2 & 192) != 128) {
                skip(j11);
                return 65533;
            }
            i10 = (i10 << 6) | (bM33972j2 & 63);
        }
        skip(j10);
        if (i10 > 1114111) {
            return 65533;
        }
        if ((i10 < 55296 || i10 > 57343) && i10 >= i12) {
            return i10;
        }
        return 65533;
    }

    public int hashCode() {
        C6131vb c6131vb = this.f26523a;
        if (c6131vb == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = c6131vb.f28800c;
            for (int i12 = c6131vb.f28799b; i12 < i11; i12++) {
                i10 = (i10 * 31) + c6131vb.f28798a[i12];
            }
            c6131vb = c6131vb.f28803f;
        } while (c6131vb != this.f26523a);
        return i10;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: i */
    public void mo33970i(long j10) throws EOFException {
        if (this.f26524b < j10) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    /* renamed from: j */
    public final byte m33972j(long j10) {
        int i10;
        C5883cc.m34088a(this.f26524b, j10, 1L);
        long j11 = this.f26524b;
        if (j11 - j10 <= j10) {
            long j12 = j10 - j11;
            C6131vb c6131vb = this.f26523a;
            do {
                c6131vb = c6131vb.f28804g;
                int i11 = c6131vb.f28800c;
                i10 = c6131vb.f28799b;
                j12 += i11 - i10;
            } while (j12 < 0);
            return c6131vb.f28798a[i10 + ((int) j12)];
        }
        C6131vb c6131vb2 = this.f26523a;
        while (true) {
            int i12 = c6131vb2.f28800c;
            int i13 = c6131vb2.f28799b;
            long j13 = i12 - i13;
            if (j10 < j13) {
                return c6131vb2.f28798a[i13 + ((int) j10)];
            }
            j10 -= j13;
            c6131vb2 = c6131vb2.f28803f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a2 A[EDGE_INSN: B:92:0x00a2->B:86:0x00a2 BREAK  A[LOOP:0: B:54:0x000b->B:94:?], SYNTHETIC] */
    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo33974k() {
        /*
            r14 = this;
            long r0 = r14.f26524b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto La9
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            com.huawei.hms.network.embedded.vb r6 = r14.f26523a
            byte[] r7 = r6.f28798a
            int r8 = r6.f28799b
            int r9 = r6.f28800c
        L13:
            if (r8 >= r9) goto L8e
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L37
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-87)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L6f
            r11 = 70
            if (r10 > r11) goto L6f
            int r11 = r10 + (-55)
        L37:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L47
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L47:
            com.huawei.hms.network.embedded.bb r14 = new com.huawei.hms.network.embedded.bb
            r14.<init>()
            com.huawei.hms.network.embedded.bb r14 = r14.mo33953c(r4)
            com.huawei.hms.network.embedded.bb r14 = r14.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r14 = r14.mo33979o()
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r0.<init>(r14)
            throw r0
        L6f:
            if (r0 == 0) goto L73
            r1 = 1
            goto L8e
        L73:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L8e:
            if (r8 != r9) goto L9a
            com.huawei.hms.network.embedded.vb r7 = r6.m35704b()
            r14.f26523a = r7
            com.huawei.hms.network.embedded.C6144wb.m35761a(r6)
            goto L9c
        L9a:
            r6.f28799b = r8
        L9c:
            if (r1 != 0) goto La2
            com.huawei.hms.network.embedded.vb r6 = r14.f26523a
            if (r6 != 0) goto Lb
        La2:
            long r1 = r14.f26524b
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f26524b = r1
            return r4
        La9:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "size == 0"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5868bb.mo33974k():long");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: l */
    public String mo33976l() throws EOFException {
        long jMo33917a = mo33917a((byte) 10);
        if (jMo33917a != -1) {
            return m33975k(jMo33917a);
        }
        long j10 = this.f26524b;
        if (j10 != 0) {
            return mo33965f(j10);
        }
        return null;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: m */
    public InputStream mo33977m() {
        return new b();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: n */
    public String mo33978n() throws EOFException {
        return mo33962e(Long.MAX_VALUE);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: o */
    public String mo33979o() {
        try {
            return mo33939a(this.f26524b, C5883cc.f26596a);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00ac A[EDGE_INSN: B:105:0x00ac->B:95:0x00ac BREAK  A[LOOP:0: B:62:0x000f->B:107:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00a8  */
    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo33980p() {
        /*
            r15 = this;
            long r0 = r15.f26524b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb7
            r0 = 0
            r4 = -7
            r1 = r0
            r5 = r4
            r3 = r2
            r2 = r1
        Lf:
            com.huawei.hms.network.embedded.vb r7 = r15.f26523a
            byte[] r8 = r7.f28798a
            int r9 = r7.f28799b
            int r10 = r7.f28800c
        L17:
            if (r9 >= r10) goto L98
            r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L69
            r12 = 57
            if (r11 > r12) goto L69
            int r12 = 48 - r11
            r13 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r13 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r13 < 0) goto L3c
            if (r13 != 0) goto L36
            long r13 = (long) r12
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 >= 0) goto L36
            goto L3c
        L36:
            r13 = 10
            long r3 = r3 * r13
            long r11 = (long) r12
            long r3 = r3 + r11
            goto L74
        L3c:
            com.huawei.hms.network.embedded.bb r15 = new com.huawei.hms.network.embedded.bb
            r15.<init>()
            com.huawei.hms.network.embedded.bb r15 = r15.mo33926a(r3)
            com.huawei.hms.network.embedded.bb r15 = r15.writeByte(r11)
            if (r1 != 0) goto L4e
            r15.readByte()
        L4e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r15 = r15.mo33979o()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L69:
            r12 = 45
            r13 = 1
            if (r11 != r12) goto L79
            if (r0 != 0) goto L79
            r11 = 1
            long r5 = r5 - r11
            r1 = r13
        L74:
            int r9 = r9 + 1
            int r0 = r0 + 1
            goto L17
        L79:
            if (r0 == 0) goto L7d
            r2 = r13
            goto L98
        L7d:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was 0x"
            r0.append(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r11)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L98:
            if (r9 != r10) goto La4
            com.huawei.hms.network.embedded.vb r8 = r7.m35704b()
            r15.f26523a = r8
            com.huawei.hms.network.embedded.C6144wb.m35761a(r7)
            goto La6
        La4:
            r7.f28799b = r9
        La6:
            if (r2 != 0) goto Lac
            com.huawei.hms.network.embedded.vb r7 = r15.f26523a
            if (r7 != 0) goto Lf
        Lac:
            long r5 = r15.f26524b
            long r7 = (long) r0
            long r5 = r5 - r7
            r15.f26524b = r5
            if (r1 == 0) goto Lb5
            goto Lb6
        Lb5:
            long r3 = -r3
        Lb6:
            return r3
        Lb7:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "size == 0"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5868bb.mo33980p():long");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public InterfaceC5896db peek() {
        return C6040ob.m34934a(new C6066qb(this));
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: q */
    public byte[] mo33981q() {
        try {
            return mo33967g(this.f26524b);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: r */
    public C5910eb mo33982r() {
        return new C5910eb(mo33981q());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        C6131vb c6131vb = this.f26523a;
        if (c6131vb == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), c6131vb.f28800c - c6131vb.f28799b);
        byteBuffer.put(c6131vb.f28798a, c6131vb.f28799b, iMin);
        int i10 = c6131vb.f28799b + iMin;
        c6131vb.f28799b = i10;
        this.f26524b -= iMin;
        if (i10 == c6131vb.f28800c) {
            this.f26523a = c6131vb.m35704b();
            C6144wb.m35761a(c6131vb);
        }
        return iMin;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public byte readByte() {
        long j10 = this.f26524b;
        if (j10 == 0) {
            throw new IllegalStateException("size == 0");
        }
        C6131vb c6131vb = this.f26523a;
        int i10 = c6131vb.f28799b;
        int i11 = c6131vb.f28800c;
        int i12 = i10 + 1;
        byte b10 = c6131vb.f28798a[i10];
        this.f26524b = j10 - 1;
        if (i12 == i11) {
            this.f26523a = c6131vb.m35704b();
            C6144wb.m35761a(c6131vb);
        } else {
            c6131vb.f28799b = i12;
        }
        return b10;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public void readFully(byte[] bArr) throws EOFException {
        int i10 = 0;
        while (i10 < bArr.length) {
            int i11 = read(bArr, i10, bArr.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public int readInt() {
        long j10 = this.f26524b;
        if (j10 < 4) {
            throw new IllegalStateException("size < 4: " + this.f26524b);
        }
        C6131vb c6131vb = this.f26523a;
        int i10 = c6131vb.f28799b;
        int i11 = c6131vb.f28800c;
        if (i11 - i10 < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = c6131vb.f28798a;
        int i12 = i10 + 3;
        int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
        int i14 = i10 + 4;
        int i15 = (bArr[i12] & 255) | i13;
        this.f26524b = j10 - 4;
        if (i14 == i11) {
            this.f26523a = c6131vb.m35704b();
            C6144wb.m35761a(c6131vb);
        } else {
            c6131vb.f28799b = i14;
        }
        return i15;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public long readLong() {
        long j10 = this.f26524b;
        if (j10 < 8) {
            throw new IllegalStateException("size < 8: " + this.f26524b);
        }
        C6131vb c6131vb = this.f26523a;
        int i10 = c6131vb.f28799b;
        int i11 = c6131vb.f28800c;
        if (i11 - i10 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = c6131vb.f28798a;
        int i12 = i10 + 7;
        long j11 = ((bArr[i10 + 1] & 255) << 48) | ((bArr[i10] & 255) << 56) | ((bArr[i10 + 2] & 255) << 40) | ((bArr[i10 + 3] & 255) << 32) | ((bArr[i10 + 4] & 255) << 24) | ((bArr[i10 + 5] & 255) << 16) | ((bArr[i10 + 6] & 255) << 8);
        int i13 = i10 + 8;
        long j12 = j11 | (bArr[i12] & 255);
        this.f26524b = j10 - 8;
        if (i13 == i11) {
            this.f26523a = c6131vb.m35704b();
            C6144wb.m35761a(c6131vb);
        } else {
            c6131vb.f28799b = i13;
        }
        return j12;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public short readShort() {
        long j10 = this.f26524b;
        if (j10 < 2) {
            throw new IllegalStateException("size < 2: " + this.f26524b);
        }
        C6131vb c6131vb = this.f26523a;
        int i10 = c6131vb.f28799b;
        int i11 = c6131vb.f28800c;
        if (i11 - i10 < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = c6131vb.f28798a;
        int i12 = i10 + 1;
        int i13 = (bArr[i10] & 255) << 8;
        int i14 = i10 + 2;
        int i15 = (bArr[i12] & 255) | i13;
        this.f26524b = j10 - 2;
        if (i14 == i11) {
            this.f26523a = c6131vb.m35704b();
            C6144wb.m35761a(c6131vb);
        } else {
            c6131vb.f28799b = i14;
        }
        return (short) i15;
    }

    /* renamed from: s */
    public final void m33983s() {
        try {
            skip(this.f26524b);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public void skip(long j10) throws EOFException {
        while (j10 > 0) {
            if (this.f26523a == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j10, r0.f28800c - r0.f28799b);
            long j11 = iMin;
            this.f26524b -= j11;
            j10 -= j11;
            C6131vb c6131vb = this.f26523a;
            int i10 = c6131vb.f28799b + iMin;
            c6131vb.f28799b = i10;
            if (i10 == c6131vb.f28800c) {
                this.f26523a = c6131vb.m35704b();
                C6144wb.m35761a(c6131vb);
            }
        }
    }

    /* renamed from: t */
    public final long m33984t() {
        long j10 = this.f26524b;
        if (j10 == 0) {
            return 0L;
        }
        C6131vb c6131vb = this.f26523a.f28804g;
        return (c6131vb.f28800c >= 8192 || !c6131vb.f28802e) ? j10 : j10 - (r2 - c6131vb.f28799b);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
    public C5855ac timeout() {
        return C5855ac.f26380d;
    }

    public String toString() {
        return m33914C().toString();
    }

    /* renamed from: u */
    public final C5910eb m33985u() {
        return m33911b("MD5");
    }

    /* renamed from: v */
    public final c m33986v() {
        return m33923a(new c());
    }

    /* renamed from: w */
    public final c m33987w() {
        return m33946b(new c());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            C6131vb c6131vbM33961e = m33961e(1);
            int iMin = Math.min(i10, 8192 - c6131vbM33961e.f28800c);
            byteBuffer.get(c6131vbM33961e.f28798a, c6131vbM33961e.f28800c, iMin);
            i10 -= iMin;
            c6131vbM33961e.f28800c += iMin;
        }
        this.f26524b += iRemaining;
        return iRemaining;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public C5868bb writeByte(int i10) {
        C6131vb c6131vbM33961e = m33961e(1);
        byte[] bArr = c6131vbM33961e.f28798a;
        int i11 = c6131vbM33961e.f28800c;
        c6131vbM33961e.f28800c = i11 + 1;
        bArr[i11] = (byte) i10;
        this.f26524b++;
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public C5868bb writeInt(int i10) {
        C6131vb c6131vbM33961e = m33961e(4);
        byte[] bArr = c6131vbM33961e.f28798a;
        int i11 = c6131vbM33961e.f28800c;
        bArr[i11] = (byte) ((i10 >>> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr[i11 + 3] = (byte) (i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        c6131vbM33961e.f28800c = i11 + 4;
        this.f26524b += 4;
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public C5868bb writeLong(long j10) {
        C6131vb c6131vbM33961e = m33961e(8);
        byte[] bArr = c6131vbM33961e.f28798a;
        int i10 = c6131vbM33961e.f28800c;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        bArr[i10 + 1] = (byte) ((j10 >>> 48) & 255);
        bArr[i10 + 2] = (byte) ((j10 >>> 40) & 255);
        bArr[i10 + 3] = (byte) ((j10 >>> 32) & 255);
        bArr[i10 + 4] = (byte) ((j10 >>> 24) & 255);
        bArr[i10 + 5] = (byte) ((j10 >>> 16) & 255);
        bArr[i10 + 6] = (byte) ((j10 >>> 8) & 255);
        bArr[i10 + 7] = (byte) (j10 & 255);
        c6131vbM33961e.f28800c = i10 + 8;
        this.f26524b += 8;
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public C5868bb writeShort(int i10) {
        C6131vb c6131vbM33961e = m33961e(2);
        byte[] bArr = c6131vbM33961e.f28798a;
        int i11 = c6131vbM33961e.f28800c;
        bArr[i11] = (byte) ((i10 >>> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        bArr[i11 + 1] = (byte) (i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        c6131vbM33961e.f28800c = i11 + 2;
        this.f26524b += 2;
        return this;
    }

    /* renamed from: x */
    public List<Integer> m33988x() {
        if (this.f26523a == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        C6131vb c6131vb = this.f26523a;
        arrayList.add(Integer.valueOf(c6131vb.f28800c - c6131vb.f28799b));
        C6131vb c6131vb2 = this.f26523a;
        while (true) {
            c6131vb2 = c6131vb2.f28803f;
            if (c6131vb2 == this.f26523a) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(c6131vb2.f28800c - c6131vb2.f28799b));
        }
    }

    /* renamed from: y */
    public final C5910eb m33989y() {
        return m33911b("SHA-1");
    }

    /* renamed from: z */
    public final C5910eb m33990z() {
        return m33911b("SHA-256");
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0055, code lost:
    
        if (r19 == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0057, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0058, code lost:
    
        return r9;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m33916a(com.huawei.hms.network.embedded.C6053pb r18, boolean r19) {
        /*
            r17 = this;
            r0 = r18
            r1 = r17
            com.huawei.hms.network.embedded.vb r1 = r1.f26523a
            r2 = -2
            if (r1 != 0) goto L13
            if (r19 == 0) goto Lc
            return r2
        Lc:
            com.huawei.hms.network.embedded.eb r1 = com.huawei.hms.network.embedded.C5910eb.f26711f
            int r0 = r0.indexOf(r1)
            return r0
        L13:
            byte[] r3 = r1.f28798a
            int r4 = r1.f28799b
            int r5 = r1.f28800c
            int[] r0 = r0.f27792b
            r6 = 0
            r7 = -1
            r10 = r1
            r8 = r6
            r9 = r7
        L20:
            int r11 = r8 + 1
            r12 = r0[r8]
            int r8 = r8 + 2
            r11 = r0[r11]
            if (r11 == r7) goto L2b
            r9 = r11
        L2b:
            if (r10 != 0) goto L2e
            goto L55
        L2e:
            r11 = 0
            if (r12 >= 0) goto L72
            int r12 = r12 * (-1)
            int r13 = r8 + r12
        L35:
            int r12 = r4 + 1
            r4 = r3[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r14 = r8 + 1
            r8 = r0[r8]
            if (r4 == r8) goto L42
            return r9
        L42:
            if (r14 != r13) goto L46
            r4 = 1
            goto L47
        L46:
            r4 = r6
        L47:
            if (r12 != r5) goto L62
            com.huawei.hms.network.embedded.vb r3 = r10.f28803f
            int r5 = r3.f28799b
            byte[] r8 = r3.f28798a
            int r10 = r3.f28800c
            if (r3 != r1) goto L5c
            if (r4 != 0) goto L59
        L55:
            if (r19 == 0) goto L58
            return r2
        L58:
            return r9
        L59:
            r3 = r8
            r8 = r11
            goto L65
        L5c:
            r16 = r8
            r8 = r3
            r3 = r16
            goto L65
        L62:
            r8 = r10
            r10 = r5
            r5 = r12
        L65:
            if (r4 == 0) goto L6d
            r4 = r0[r14]
            r13 = r5
            r5 = r10
            r10 = r8
            goto L94
        L6d:
            r4 = r5
            r5 = r10
            r10 = r8
            r8 = r14
            goto L35
        L72:
            int r13 = r4 + 1
            r4 = r3[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r14 = r8 + r12
        L7a:
            if (r8 != r14) goto L7d
            return r9
        L7d:
            r15 = r0[r8]
            if (r4 != r15) goto L9a
            int r8 = r8 + r12
            r4 = r0[r8]
            if (r13 != r5) goto L94
            com.huawei.hms.network.embedded.vb r10 = r10.f28803f
            int r3 = r10.f28799b
            byte[] r5 = r10.f28798a
            int r8 = r10.f28800c
            r13 = r3
            r3 = r5
            r5 = r8
            if (r10 != r1) goto L94
            r10 = r11
        L94:
            if (r4 < 0) goto L97
            return r4
        L97:
            int r8 = -r4
            r4 = r13
            goto L20
        L9a:
            int r8 = r8 + 1
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5868bb.m33916a(com.huawei.hms.network.embedded.pb, boolean):int");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: b */
    public long mo33945b(C5910eb c5910eb, long j10) {
        int i10;
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        C6131vb c6131vb = this.f26523a;
        if (c6131vb == null) {
            return -1L;
        }
        long j12 = this.f26524b;
        if (j12 - j10 < j10) {
            while (j12 > j10) {
                c6131vb = c6131vb.f28804g;
                j12 -= c6131vb.f28800c - c6131vb.f28799b;
            }
        } else {
            while (true) {
                long j13 = (c6131vb.f28800c - c6131vb.f28799b) + j11;
                if (j13 >= j10) {
                    break;
                }
                c6131vb = c6131vb.f28803f;
                j11 = j13;
            }
            j12 = j11;
        }
        if (c5910eb.mo34192j() == 2) {
            byte bMo34159a = c5910eb.mo34159a(0);
            byte bMo34159a2 = c5910eb.mo34159a(1);
            while (j12 < this.f26524b) {
                byte[] bArr = c6131vb.f28798a;
                i10 = (int) ((c6131vb.f28799b + j10) - j12);
                int i11 = c6131vb.f28800c;
                while (i10 < i11) {
                    byte b10 = bArr[i10];
                    if (b10 == bMo34159a || b10 == bMo34159a2) {
                        return (i10 - c6131vb.f28799b) + j12;
                    }
                    i10++;
                }
                j12 += c6131vb.f28800c - c6131vb.f28799b;
                c6131vb = c6131vb.f28803f;
                j10 = j12;
            }
            return -1L;
        }
        byte[] bArrMo34184e = c5910eb.mo34184e();
        while (j12 < this.f26524b) {
            byte[] bArr2 = c6131vb.f28798a;
            i10 = (int) ((c6131vb.f28799b + j10) - j12);
            int i12 = c6131vb.f28800c;
            while (i10 < i12) {
                byte b11 = bArr2[i10];
                for (byte b12 : bArrMo34184e) {
                    if (b11 == b12) {
                        return (i10 - c6131vb.f28799b) + j12;
                    }
                }
                i10++;
            }
            j12 += c6131vb.f28800c - c6131vb.f28799b;
            c6131vb = c6131vb.f28803f;
            j10 = j12;
        }
        return -1L;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: c */
    public C5868bb mo33952c(int i10) {
        int i11;
        int i12;
        if (i10 >= 128) {
            if (i10 < 2048) {
                i12 = (i10 >> 6) | 192;
            } else {
                if (i10 < 65536) {
                    if (i10 < 55296 || i10 > 57343) {
                        i11 = (i10 >> 12) | Constant.ERROR_WSS_INVALID;
                    } else {
                        writeByte(63);
                    }
                } else {
                    if (i10 > 1114111) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i10));
                    }
                    writeByte((i10 >> 18) | 240);
                    i11 = ((i10 >> 12) & 63) | 128;
                }
                writeByte(i11);
                i12 = ((i10 >> 6) & 63) | 128;
            }
            writeByte(i12);
            i10 = (i10 & 63) | 128;
            writeByte(i10);
        } else {
            writeByte(i10);
        }
        return this;
    }

    /* renamed from: e */
    public final C5910eb m33960e(C5910eb c5910eb) {
        return m33908a("HmacSHA256", c5910eb);
    }

    /* renamed from: f */
    public final C5910eb m33964f(C5910eb c5910eb) {
        return m33908a("HmacSHA512", c5910eb);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: g */
    public byte[] mo33967g(long j10) throws EOFException {
        C5883cc.m34088a(this.f26524b, 0L, j10);
        if (j10 <= 2147483647L) {
            byte[] bArr = new byte[(int) j10];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: h */
    public boolean mo33969h(long j10) {
        return this.f26524b >= j10;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: i */
    public boolean mo33971i() {
        return this.f26524b == 0;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: j */
    public short mo33973j() {
        return C5883cc.m34087a(readShort());
    }

    /* renamed from: k */
    public String m33975k(long j10) throws EOFException {
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (m33972j(j11) == 13) {
                String strMo33965f = mo33965f(j11);
                skip(2L);
                return strMo33965f;
            }
        }
        String strMo33965f2 = mo33965f(j10);
        skip(1L);
        return strMo33965f2;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public C5868bb write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public long mo33917a(byte b10) {
        return mo33919a(b10, 0L, Long.MAX_VALUE);
    }

    /* renamed from: b */
    public final c m33946b(c cVar) {
        if (cVar.f26527a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        cVar.f26527a = this;
        cVar.f26528b = false;
        return cVar;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: c */
    public C5868bb mo33953c(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j10)) / 4) + 1;
        C6131vb c6131vbM33961e = m33961e(iNumberOfTrailingZeros);
        byte[] bArr = c6131vbM33961e.f28798a;
        int i10 = c6131vbM33961e.f28800c;
        for (int i11 = (i10 + iNumberOfTrailingZeros) - 1; i11 >= i10; i11--) {
            bArr[i11] = f26521c[(int) (15 & j10)];
            j10 >>>= 4;
        }
        c6131vbM33961e.f28800c += iNumberOfTrailingZeros;
        this.f26524b += iNumberOfTrailingZeros;
        return this;
    }

    /* renamed from: d */
    public final C5910eb m33956d(int i10) {
        return i10 == 0 ? C5910eb.f26711f : new C6157xb(this, i10);
    }

    /* renamed from: e */
    public C6131vb m33961e(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException();
        }
        C6131vb c6131vb = this.f26523a;
        if (c6131vb != null) {
            C6131vb c6131vb2 = c6131vb.f28804g;
            return (c6131vb2.f28800c + i10 > 8192 || !c6131vb2.f28802e) ? c6131vb2.m35701a(C6144wb.m35760a()) : c6131vb2;
        }
        C6131vb c6131vbM35760a = C6144wb.m35760a();
        this.f26523a = c6131vbM35760a;
        c6131vbM35760a.f28804g = c6131vbM35760a;
        c6131vbM35760a.f28803f = c6131vbM35760a;
        return c6131vbM35760a;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: f */
    public String mo33965f(long j10) throws EOFException {
        return mo33939a(j10, C5883cc.f26596a);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public int read(byte[] bArr, int i10, int i11) {
        C5883cc.m34088a(bArr.length, i10, i11);
        C6131vb c6131vb = this.f26523a;
        if (c6131vb == null) {
            return -1;
        }
        int iMin = Math.min(i11, c6131vb.f28800c - c6131vb.f28799b);
        System.arraycopy(c6131vb.f28798a, c6131vb.f28799b, bArr, i10, iMin);
        int i12 = c6131vb.f28799b + iMin;
        c6131vb.f28799b = i12;
        this.f26524b -= iMin;
        if (i12 == c6131vb.f28800c) {
            this.f26523a = c6131vb.m35704b();
            C6144wb.m35761a(c6131vb);
        }
        return iMin;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public C5868bb write(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = i11;
        C5883cc.m34088a(bArr.length, i10, j10);
        int i12 = i11 + i10;
        while (i10 < i12) {
            C6131vb c6131vbM33961e = m33961e(1);
            int iMin = Math.min(i12 - i10, 8192 - c6131vbM33961e.f28800c);
            System.arraycopy(bArr, i10, c6131vbM33961e.f28798a, c6131vbM33961e.f28800c, iMin);
            i10 += iMin;
            c6131vbM33961e.f28800c += iMin;
        }
        this.f26524b += j10;
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public long mo33918a(byte b10, long j10) {
        return mo33919a(b10, j10, Long.MAX_VALUE);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: b */
    public C5868bb mo33947b(int i10) {
        return writeShort((int) C5883cc.m34087a((short) i10));
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: c */
    public InterfaceC5882cb mo33954c() {
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: d */
    public C5910eb mo33957d(long j10) throws EOFException {
        return new C5910eb(mo33967g(j10));
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: e */
    public String mo33962e(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j10);
        }
        long j11 = j10 != Long.MAX_VALUE ? j10 + 1 : Long.MAX_VALUE;
        long jMo33919a = mo33919a((byte) 10, 0L, j11);
        if (jMo33919a != -1) {
            return m33975k(jMo33919a);
        }
        if (j11 < m33913B() && m33972j(j11 - 1) == 13 && m33972j(j11) == 10) {
            return m33975k(j11);
        }
        C5868bb c5868bb = new C5868bb();
        m33927a(c5868bb, 0L, Math.min(32L, m33913B()));
        throw new EOFException("\\n not found: limit=" + Math.min(m33913B(), j10) + " content=" + c5868bb.mo33982r().mo34181d() + (char) 8230);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
    public long read(C5868bb c5868bb, long j10) {
        if (c5868bb == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        long j11 = this.f26524b;
        if (j11 == 0) {
            return -1L;
        }
        if (j10 > j11) {
            j10 = j11;
        }
        c5868bb.write(this, j10);
        return j10;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public long mo33919a(byte b10, long j10, long j11) {
        C6131vb c6131vb;
        long j12 = 0;
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f26524b), Long.valueOf(j10), Long.valueOf(j11)));
        }
        long j13 = this.f26524b;
        long j14 = j11 > j13 ? j13 : j11;
        if (j10 == j14 || (c6131vb = this.f26523a) == null) {
            return -1L;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                c6131vb = c6131vb.f28804g;
                j13 -= c6131vb.f28800c - c6131vb.f28799b;
            }
        } else {
            while (true) {
                long j15 = (c6131vb.f28800c - c6131vb.f28799b) + j12;
                if (j15 >= j10) {
                    break;
                }
                c6131vb = c6131vb.f28803f;
                j12 = j15;
            }
            j13 = j12;
        }
        C6131vb c6131vb2 = c6131vb;
        long j16 = j10;
        while (j13 < j14) {
            byte[] bArr = c6131vb2.f28798a;
            int iMin = (int) Math.min(c6131vb2.f28800c, (c6131vb2.f28799b + j14) - j13);
            for (int i10 = (int) ((c6131vb2.f28799b + j16) - j13); i10 < iMin; i10++) {
                if (bArr[i10] == b10) {
                    return (i10 - c6131vb2.f28799b) + j13;
                }
            }
            j13 += c6131vb2.f28800c - c6131vb2.f28799b;
            c6131vb2 = c6131vb2.f28803f;
            j16 = j13;
        }
        return -1L;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: b */
    public C5868bb mo33948b(long j10) {
        return writeLong(C5883cc.m34086a(j10));
    }

    /* renamed from: d */
    public final C5910eb m33958d(C5910eb c5910eb) {
        return m33908a("HmacSHA1", c5910eb);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public long mo33920a(C5910eb c5910eb, long j10) throws IOException {
        byte[] bArr;
        if (c5910eb.mo34192j() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j11 = 0;
        if (j10 < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        C6131vb c6131vb = this.f26523a;
        long j12 = -1;
        if (c6131vb == null) {
            return -1L;
        }
        long j13 = this.f26524b;
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                c6131vb = c6131vb.f28804g;
                j13 -= c6131vb.f28800c - c6131vb.f28799b;
            }
        } else {
            while (true) {
                long j14 = (c6131vb.f28800c - c6131vb.f28799b) + j11;
                if (j14 >= j10) {
                    break;
                }
                c6131vb = c6131vb.f28803f;
                j11 = j14;
            }
            j13 = j11;
        }
        byte bMo34159a = c5910eb.mo34159a(0);
        int iMo34192j = c5910eb.mo34192j();
        long j15 = 1 + (this.f26524b - iMo34192j);
        long j16 = j10;
        C6131vb c6131vb2 = c6131vb;
        long j17 = j13;
        while (j17 < j15) {
            byte[] bArr2 = c6131vb2.f28798a;
            int iMin = (int) Math.min(c6131vb2.f28800c, (c6131vb2.f28799b + j15) - j17);
            int i10 = (int) ((c6131vb2.f28799b + j16) - j17);
            while (i10 < iMin) {
                if (bArr2[i10] == bMo34159a) {
                    bArr = bArr2;
                    if (m33910a(c6131vb2, i10 + 1, c5910eb, 1, iMo34192j)) {
                        return (i10 - c6131vb2.f28799b) + j17;
                    }
                } else {
                    bArr = bArr2;
                }
                i10++;
                bArr2 = bArr;
            }
            j17 += c6131vb2.f28800c - c6131vb2.f28799b;
            c6131vb2 = c6131vb2.f28803f;
            j16 = j17;
            j12 = -1;
        }
        return j12;
    }

    /* renamed from: b */
    public final C5868bb m33949b(OutputStream outputStream) throws IOException {
        return m33932a(outputStream, this.f26524b);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
    public void write(C5868bb c5868bb, long j10) {
        if (c5868bb == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (c5868bb == this) {
            throw new IllegalArgumentException("source == this");
        }
        C5883cc.m34088a(c5868bb.f26524b, 0L, j10);
        while (j10 > 0) {
            C6131vb c6131vb = c5868bb.f26523a;
            if (j10 < c6131vb.f28800c - c6131vb.f28799b) {
                C6131vb c6131vb2 = this.f26523a;
                C6131vb c6131vb3 = c6131vb2 != null ? c6131vb2.f28804g : null;
                if (c6131vb3 != null && c6131vb3.f28802e) {
                    if ((c6131vb3.f28800c + j10) - (c6131vb3.f28801d ? 0 : c6131vb3.f28799b) <= 8192) {
                        c6131vb.m35703a(c6131vb3, (int) j10);
                        c5868bb.f26524b -= j10;
                        this.f26524b += j10;
                        return;
                    }
                }
                c5868bb.f26523a = c6131vb.m35700a((int) j10);
            }
            C6131vb c6131vb4 = c5868bb.f26523a;
            long j11 = c6131vb4.f28800c - c6131vb4.f28799b;
            c5868bb.f26523a = c6131vb4.m35704b();
            C6131vb c6131vb5 = this.f26523a;
            if (c6131vb5 == null) {
                this.f26523a = c6131vb4;
                c6131vb4.f28804g = c6131vb4;
                c6131vb4.f28803f = c6131vb4;
            } else {
                c6131vb5.f28804g.m35701a(c6131vb4).m35702a();
            }
            c5868bb.f26524b -= j11;
            this.f26524b += j11;
            j10 -= j11;
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public long mo33921a(InterfaceC6170yb interfaceC6170yb) throws IOException {
        long j10 = this.f26524b;
        if (j10 > 0) {
            interfaceC6170yb.write(this, j10);
        }
        return j10;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public long mo33922a(InterfaceC6183zb interfaceC6183zb) throws IOException {
        if (interfaceC6183zb == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long j11 = interfaceC6183zb.read(this, 8192L);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
        }
    }

    /* renamed from: b */
    private C5910eb m33911b(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            C6131vb c6131vb = this.f26523a;
            if (c6131vb != null) {
                byte[] bArr = c6131vb.f28798a;
                int i10 = c6131vb.f28799b;
                messageDigest.update(bArr, i10, c6131vb.f28800c - i10);
                C6131vb c6131vb2 = this.f26523a;
                while (true) {
                    c6131vb2 = c6131vb2.f28803f;
                    if (c6131vb2 == this.f26523a) {
                        break;
                    }
                    byte[] bArr2 = c6131vb2.f28798a;
                    int i11 = c6131vb2.f28799b;
                    messageDigest.update(bArr2, i11, c6131vb2.f28800c - i11);
                }
            }
            return C5910eb.m34158e(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public final c m33923a(c cVar) {
        if (cVar.f26527a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        cVar.f26527a = this;
        cVar.f26528b = true;
        return cVar;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db, com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public C5868bb mo33924a() {
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: b */
    public OutputStream mo33950b() {
        return new a();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public C5868bb mo33925a(int i10) {
        return writeInt(C5883cc.m34085a(i10));
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public C5868bb mo33926a(long j10) {
        boolean z10;
        if (j10 == 0) {
            return writeByte(48);
        }
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return mo33934a("-9223372036854775808");
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
        C6131vb c6131vbM33961e = m33961e(i10);
        byte[] bArr = c6131vbM33961e.f28798a;
        int i11 = c6131vbM33961e.f28800c + i10;
        while (j10 != 0) {
            i11--;
            bArr[i11] = f26521c[(int) (j10 % 10)];
            j10 /= 10;
        }
        if (z10) {
            bArr[i11 - 1] = 45;
        }
        c6131vbM33961e.f28800c += i10;
        this.f26524b += i10;
        return this;
    }

    /* renamed from: a */
    public final C5868bb m33927a(C5868bb c5868bb, long j10, long j11) {
        if (c5868bb == null) {
            throw new IllegalArgumentException("out == null");
        }
        C5883cc.m34088a(this.f26524b, j10, j11);
        if (j11 == 0) {
            return this;
        }
        c5868bb.f26524b += j11;
        C6131vb c6131vb = this.f26523a;
        while (true) {
            long j12 = c6131vb.f28800c - c6131vb.f28799b;
            if (j10 < j12) {
                break;
            }
            j10 -= j12;
            c6131vb = c6131vb.f28803f;
        }
        while (j11 > 0) {
            C6131vb c6131vbM35705c = c6131vb.m35705c();
            int i10 = (int) (c6131vbM35705c.f28799b + j10);
            c6131vbM35705c.f28799b = i10;
            c6131vbM35705c.f28800c = Math.min(i10 + ((int) j11), c6131vbM35705c.f28800c);
            C6131vb c6131vb2 = c5868bb.f26523a;
            if (c6131vb2 == null) {
                c6131vbM35705c.f28804g = c6131vbM35705c;
                c6131vbM35705c.f28803f = c6131vbM35705c;
                c5868bb.f26523a = c6131vbM35705c;
            } else {
                c6131vb2.f28804g.m35701a(c6131vbM35705c);
            }
            j11 -= c6131vbM35705c.f28800c - c6131vbM35705c.f28799b;
            c6131vb = c6131vb.f28803f;
            j10 = 0;
        }
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public C5868bb mo33928a(C5910eb c5910eb) {
        if (c5910eb == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        c5910eb.mo34166a(this);
        return this;
    }

    /* renamed from: a */
    public final C5868bb m33929a(InputStream inputStream) throws IOException {
        m33909a(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    /* renamed from: a */
    public final C5868bb m33930a(InputStream inputStream, long j10) throws IOException {
        if (j10 >= 0) {
            m33909a(inputStream, j10, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j10);
    }

    /* renamed from: a */
    public final C5868bb m33931a(OutputStream outputStream) throws IOException {
        return m33933a(outputStream, 0L, this.f26524b);
    }

    /* renamed from: a */
    public final C5868bb m33932a(OutputStream outputStream, long j10) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        C5883cc.m34088a(this.f26524b, 0L, j10);
        C6131vb c6131vb = this.f26523a;
        while (j10 > 0) {
            int iMin = (int) Math.min(j10, c6131vb.f28800c - c6131vb.f28799b);
            outputStream.write(c6131vb.f28798a, c6131vb.f28799b, iMin);
            int i10 = c6131vb.f28799b + iMin;
            c6131vb.f28799b = i10;
            long j11 = iMin;
            this.f26524b -= j11;
            j10 -= j11;
            if (i10 == c6131vb.f28800c) {
                C6131vb c6131vbM35704b = c6131vb.m35704b();
                this.f26523a = c6131vbM35704b;
                C6144wb.m35761a(c6131vb);
                c6131vb = c6131vbM35704b;
            }
        }
        return this;
    }

    /* renamed from: a */
    public final C5868bb m33933a(OutputStream outputStream, long j10, long j11) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        C5883cc.m34088a(this.f26524b, j10, j11);
        if (j11 == 0) {
            return this;
        }
        C6131vb c6131vb = this.f26523a;
        while (true) {
            long j12 = c6131vb.f28800c - c6131vb.f28799b;
            if (j10 < j12) {
                break;
            }
            j10 -= j12;
            c6131vb = c6131vb.f28803f;
        }
        while (j11 > 0) {
            int iMin = (int) Math.min(c6131vb.f28800c - r8, j11);
            outputStream.write(c6131vb.f28798a, (int) (c6131vb.f28799b + j10), iMin);
            j11 -= iMin;
            c6131vb = c6131vb.f28803f;
            j10 = 0;
        }
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public C5868bb mo33934a(String str) {
        return mo33935a(str, 0, str.length());
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public C5868bb mo33935a(String str, int i10, int i11) {
        char cCharAt;
        int i12;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        }
        while (i10 < i11) {
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 < 128) {
                C6131vb c6131vbM33961e = m33961e(1);
                byte[] bArr = c6131vbM33961e.f28798a;
                int i13 = c6131vbM33961e.f28800c - i10;
                int iMin = Math.min(i11, 8192 - i13);
                int i14 = i10 + 1;
                bArr[i10 + i13] = (byte) cCharAt2;
                while (true) {
                    i10 = i14;
                    if (i10 >= iMin || (cCharAt = str.charAt(i10)) >= 128) {
                        break;
                    }
                    i14 = i10 + 1;
                    bArr[i10 + i13] = (byte) cCharAt;
                }
                int i15 = c6131vbM33961e.f28800c;
                int i16 = (i13 + i10) - i15;
                c6131vbM33961e.f28800c = i15 + i16;
                this.f26524b += i16;
            } else {
                if (cCharAt2 < 2048) {
                    i12 = (cCharAt2 >> 6) | 192;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    writeByte((cCharAt2 >> '\f') | Constant.ERROR_WSS_INVALID);
                    i12 = ((cCharAt2 >> 6) & 63) | 128;
                } else {
                    int i17 = i10 + 1;
                    char cCharAt3 = i17 < i11 ? str.charAt(i17) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        writeByte(63);
                        i10 = i17;
                    } else {
                        int i18 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        writeByte((i18 >> 18) | 240);
                        writeByte(((i18 >> 12) & 63) | 128);
                        writeByte(((i18 >> 6) & 63) | 128);
                        writeByte((i18 & 63) | 128);
                        i10 += 2;
                    }
                }
                writeByte(i12);
                writeByte((cCharAt2 & '?') | 128);
                i10++;
            }
        }
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public C5868bb mo33936a(String str, int i10, int i11, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 <= str.length()) {
            if (charset == null) {
                throw new IllegalArgumentException("charset == null");
            }
            if (charset.equals(C5883cc.f26596a)) {
                return mo33935a(str, i10, i11);
            }
            byte[] bytes = str.substring(i10, i11).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
        throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public C5868bb mo33937a(String str, Charset charset) {
        return mo33936a(str, 0, str.length(), charset);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public InterfaceC5882cb mo33938a(InterfaceC6183zb interfaceC6183zb, long j10) throws IOException {
        while (j10 > 0) {
            long j11 = interfaceC6183zb.read(this, j10);
            if (j11 == -1) {
                throw new EOFException();
            }
            j10 -= j11;
        }
        return this;
    }

    /* renamed from: a */
    private C5910eb m33908a(String str, C5910eb c5910eb) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(c5910eb.mo34195m(), str));
            C6131vb c6131vb = this.f26523a;
            if (c6131vb != null) {
                byte[] bArr = c6131vb.f28798a;
                int i10 = c6131vb.f28799b;
                mac.update(bArr, i10, c6131vb.f28800c - i10);
                C6131vb c6131vb2 = this.f26523a;
                while (true) {
                    c6131vb2 = c6131vb2.f28803f;
                    if (c6131vb2 == this.f26523a) {
                        break;
                    }
                    byte[] bArr2 = c6131vb2.f28798a;
                    int i11 = c6131vb2.f28799b;
                    mac.update(bArr2, i11, c6131vb2.f28800c - i11);
                }
            }
            return C5910eb.m34158e(mac.doFinal());
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public String mo33939a(long j10, Charset charset) throws EOFException {
        C5883cc.m34088a(this.f26524b, 0L, j10);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j10 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
        }
        if (j10 == 0) {
            return "";
        }
        C6131vb c6131vb = this.f26523a;
        int i10 = c6131vb.f28799b;
        if (i10 + j10 > c6131vb.f28800c) {
            return new String(mo33967g(j10), charset);
        }
        String str = new String(c6131vb.f28798a, i10, (int) j10, charset);
        int i11 = (int) (c6131vb.f28799b + j10);
        c6131vb.f28799b = i11;
        this.f26524b -= j10;
        if (i11 == c6131vb.f28800c) {
            this.f26523a = c6131vb.m35704b();
            C6144wb.m35761a(c6131vb);
        }
        return str;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public String mo33940a(Charset charset) {
        try {
            return mo33939a(this.f26524b, charset);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public void mo33941a(C5868bb c5868bb, long j10) throws EOFException {
        long j11 = this.f26524b;
        if (j11 >= j10) {
            c5868bb.write(this, j10);
        } else {
            c5868bb.write(this, j11);
            throw new EOFException();
        }
    }

    /* renamed from: a */
    private void m33909a(InputStream inputStream, long j10, boolean z10) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j10 <= 0 && !z10) {
                return;
            }
            C6131vb c6131vbM33961e = m33961e(1);
            int i10 = inputStream.read(c6131vbM33961e.f28798a, c6131vbM33961e.f28800c, (int) Math.min(j10, 8192 - c6131vbM33961e.f28800c));
            if (i10 == -1) {
                if (c6131vbM33961e.f28799b == c6131vbM33961e.f28800c) {
                    this.f26523a = c6131vbM33961e.m35704b();
                    C6144wb.m35761a(c6131vbM33961e);
                }
                if (!z10) {
                    throw new EOFException();
                }
                return;
            }
            c6131vbM33961e.f28800c += i10;
            long j11 = i10;
            this.f26524b += j11;
            j10 -= j11;
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public boolean mo33942a(long j10, C5910eb c5910eb) {
        return mo33943a(j10, c5910eb, 0, c5910eb.mo34192j());
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public boolean mo33943a(long j10, C5910eb c5910eb, int i10, int i11) {
        if (j10 < 0 || i10 < 0 || i11 < 0 || this.f26524b - j10 < i11 || c5910eb.mo34192j() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (m33972j(i12 + j10) != c5910eb.mo34159a(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m33910a(C6131vb c6131vb, int i10, C5910eb c5910eb, int i11, int i12) {
        int i13 = c6131vb.f28800c;
        byte[] bArr = c6131vb.f28798a;
        while (i11 < i12) {
            if (i10 == i13) {
                C6131vb c6131vb2 = c6131vb.f28803f;
                byte[] bArr2 = c6131vb2.f28798a;
                i10 = c6131vb2.f28799b;
                c6131vb = c6131vb2;
                i13 = c6131vb2.f28800c;
                bArr = bArr2;
            }
            if (bArr[i10] != c5910eb.mo34159a(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }
}
