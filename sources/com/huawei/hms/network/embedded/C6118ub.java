package com.huawei.hms.network.embedded;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.network.embedded.ub */
/* loaded from: classes8.dex */
public final class C6118ub implements InterfaceC5896db {

    /* renamed from: a */
    public final C5868bb f28602a = new C5868bb();

    /* renamed from: b */
    public final InterfaceC6183zb f28603b;

    /* renamed from: c */
    public boolean f28604c;

    /* renamed from: com.huawei.hms.network.embedded.ub$a */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            C6118ub c6118ub = C6118ub.this;
            if (c6118ub.f28604c) {
                throw new IOException("closed");
            }
            return (int) Math.min(c6118ub.f28602a.f26524b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C6118ub.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            C6118ub c6118ub = C6118ub.this;
            if (c6118ub.f28604c) {
                throw new IOException("closed");
            }
            C5868bb c5868bb = c6118ub.f28602a;
            if (c5868bb.f26524b == 0 && c6118ub.f28603b.read(c5868bb, 8192L) == -1) {
                return -1;
            }
            return C6118ub.this.f28602a.readByte() & 255;
        }

        public String toString() {
            return C6118ub.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (C6118ub.this.f28604c) {
                throw new IOException("closed");
            }
            C5883cc.m34088a(bArr.length, i10, i11);
            C6118ub c6118ub = C6118ub.this;
            C5868bb c5868bb = c6118ub.f28602a;
            if (c5868bb.f26524b == 0 && c6118ub.f28603b.read(c5868bb, 8192L) == -1) {
                return -1;
            }
            return C6118ub.this.f28602a.read(bArr, i10, i11);
        }
    }

    public C6118ub(InterfaceC6183zb interfaceC6183zb) {
        if (interfaceC6183zb == null) {
            throw new NullPointerException("source == null");
        }
        this.f28603b = interfaceC6183zb;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public int mo33915a(C6053pb c6053pb) throws IOException {
        if (this.f28604c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iM33916a = this.f28602a.m33916a(c6053pb, true);
            if (iM33916a == -1) {
                return -1;
            }
            if (iM33916a != -2) {
                this.f28602a.skip(c6053pb.f27791a[iM33916a].mo34192j());
                return iM33916a;
            }
        } while (this.f28603b.read(this.f28602a, 8192L) != -1);
        return -1;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: b */
    public long mo33944b(C5910eb c5910eb) throws IOException {
        return mo33920a(c5910eb, 0L);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: c */
    public long mo33951c(C5910eb c5910eb) throws IOException {
        return mo33945b(c5910eb, 0L);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
    public void close() throws IOException {
        if (this.f28604c) {
            return;
        }
        this.f28604c = true;
        this.f28603b.close();
        this.f28602a.m33983s();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: d */
    public C5910eb mo33957d(long j10) throws IOException {
        mo33970i(j10);
        return this.f28602a.mo33957d(j10);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: e */
    public int mo33959e() throws IOException {
        mo33970i(4L);
        return this.f28602a.mo33959e();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: f */
    public long mo33963f() throws IOException {
        mo33970i(8L);
        return this.f28602a.mo33963f();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: g */
    public C5868bb mo33966g() {
        return this.f28602a;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: h */
    public int mo33968h() throws IOException {
        long j10;
        mo33970i(1L);
        byte bM33972j = this.f28602a.m33972j(0L);
        if ((bM33972j & 224) == 192) {
            j10 = 2;
        } else {
            if ((bM33972j & 240) != 224) {
                if ((bM33972j & 248) == 240) {
                    j10 = 4;
                }
                return this.f28602a.mo33968h();
            }
            j10 = 3;
        }
        mo33970i(j10);
        return this.f28602a.mo33968h();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: i */
    public void mo33970i(long j10) throws IOException {
        if (!mo33969h(j10)) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f28604c;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: j */
    public short mo33973j() throws IOException {
        mo33970i(2L);
        return this.f28602a.mo33973j();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: k */
    public long mo33974k() throws IOException {
        byte bM33972j;
        mo33970i(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!mo33969h(i11)) {
                break;
            }
            bM33972j = this.f28602a.m33972j(i10);
            if ((bM33972j < 48 || bM33972j > 57) && ((bM33972j < 97 || bM33972j > 102) && (bM33972j < 65 || bM33972j > 70))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bM33972j)));
        }
        return this.f28602a.mo33974k();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: l */
    public String mo33976l() throws IOException {
        long jMo33917a = mo33917a((byte) 10);
        if (jMo33917a != -1) {
            return this.f28602a.m33975k(jMo33917a);
        }
        long j10 = this.f28602a.f26524b;
        if (j10 != 0) {
            return mo33965f(j10);
        }
        return null;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: m */
    public InputStream mo33977m() {
        return new a();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: n */
    public String mo33978n() throws IOException {
        return mo33962e(Long.MAX_VALUE);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: o */
    public String mo33979o() throws IOException {
        this.f28602a.mo33922a(this.f28603b);
        return this.f28602a.mo33979o();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0027, code lost:
    
        if (r0 == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x003d, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9] or '-' character but was %#x", java.lang.Byte.valueOf(r2)));
     */
    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo33980p() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 1
            r5.mo33970i(r0)
            r0 = 0
        L6:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.mo33969h(r2)
            if (r2 == 0) goto L3e
            com.huawei.hms.network.embedded.bb r2 = r5.f28602a
            long r3 = (long) r0
            byte r2 = r2.m33972j(r3)
            r3 = 48
            if (r2 < r3) goto L1e
            r3 = 57
            if (r2 <= r3) goto L25
        L1e:
            if (r0 != 0) goto L27
            r3 = 45
            if (r2 == r3) goto L25
            goto L27
        L25:
            r0 = r1
            goto L6
        L27:
            if (r0 == 0) goto L2a
            goto L3e
        L2a:
            java.lang.NumberFormatException r5 = new java.lang.NumberFormatException
            java.lang.Byte r0 = java.lang.Byte.valueOf(r2)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.<init>(r0)
            throw r5
        L3e:
            com.huawei.hms.network.embedded.bb r5 = r5.f28602a
            long r0 = r5.mo33980p()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6118ub.mo33980p():long");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public InterfaceC5896db peek() {
        return C6040ob.m34934a(new C6066qb(this));
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: q */
    public byte[] mo33981q() throws IOException {
        this.f28602a.mo33922a(this.f28603b);
        return this.f28602a.mo33981q();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: r */
    public C5910eb mo33982r() throws IOException {
        this.f28602a.mo33922a(this.f28603b);
        return this.f28602a.mo33982r();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        C5868bb c5868bb = this.f28602a;
        if (c5868bb.f26524b == 0 && this.f28603b.read(c5868bb, 8192L) == -1) {
            return -1;
        }
        return this.f28602a.read(byteBuffer);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public byte readByte() throws IOException {
        mo33970i(1L);
        return this.f28602a.readByte();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public void readFully(byte[] bArr) throws IOException {
        try {
            mo33970i(bArr.length);
            this.f28602a.readFully(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (true) {
                C5868bb c5868bb = this.f28602a;
                long j10 = c5868bb.f26524b;
                if (j10 <= 0) {
                    throw e10;
                }
                int i11 = c5868bb.read(bArr, i10, (int) j10);
                if (i11 == -1) {
                    throw new AssertionError();
                }
                i10 += i11;
            }
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public int readInt() throws IOException {
        mo33970i(4L);
        return this.f28602a.readInt();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public long readLong() throws IOException {
        mo33970i(8L);
        return this.f28602a.readLong();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public short readShort() throws IOException {
        mo33970i(2L);
        return this.f28602a.readShort();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public void skip(long j10) throws IOException {
        if (this.f28604c) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            C5868bb c5868bb = this.f28602a;
            if (c5868bb.f26524b == 0 && this.f28603b.read(c5868bb, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, this.f28602a.m33913B());
            this.f28602a.skip(jMin);
            j10 -= jMin;
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
    public C5855ac timeout() {
        return this.f28603b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f28603b + ")";
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public long mo33917a(byte b10) throws IOException {
        return mo33919a(b10, 0L, Long.MAX_VALUE);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: b */
    public long mo33945b(C5910eb c5910eb, long j10) throws IOException {
        if (this.f28604c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jMo33945b = this.f28602a.mo33945b(c5910eb, j10);
            if (jMo33945b != -1) {
                return jMo33945b;
            }
            C5868bb c5868bb = this.f28602a;
            long j11 = c5868bb.f26524b;
            if (this.f28603b.read(c5868bb, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, j11);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: e */
    public String mo33962e(long j10) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j10);
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long jMo33919a = mo33919a((byte) 10, 0L, j11);
        if (jMo33919a != -1) {
            return this.f28602a.m33975k(jMo33919a);
        }
        if (j11 < Long.MAX_VALUE && mo33969h(j11) && this.f28602a.m33972j(j11 - 1) == 13 && mo33969h(1 + j11) && this.f28602a.m33972j(j11) == 10) {
            return this.f28602a.m33975k(j11);
        }
        C5868bb c5868bb = new C5868bb();
        C5868bb c5868bb2 = this.f28602a;
        c5868bb2.m33927a(c5868bb, 0L, Math.min(32L, c5868bb2.m33913B()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f28602a.m33913B(), j10) + " content=" + c5868bb.mo33982r().mo34181d() + (char) 8230);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: f */
    public String mo33965f(long j10) throws IOException {
        mo33970i(j10);
        return this.f28602a.mo33965f(j10);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: g */
    public byte[] mo33967g(long j10) throws IOException {
        mo33970i(j10);
        return this.f28602a.mo33967g(j10);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: h */
    public boolean mo33969h(long j10) throws IOException {
        C5868bb c5868bb;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f28604c) {
            throw new IllegalStateException("closed");
        }
        do {
            c5868bb = this.f28602a;
            if (c5868bb.f26524b >= j10) {
                return true;
            }
        } while (this.f28603b.read(c5868bb, 8192L) != -1);
        return false;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: i */
    public boolean mo33971i() throws IOException {
        if (this.f28604c) {
            throw new IllegalStateException("closed");
        }
        return this.f28602a.mo33971i() && this.f28603b.read(this.f28602a, 8192L) == -1;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public long mo33918a(byte b10, long j10) throws IOException {
        return mo33919a(b10, j10, Long.MAX_VALUE);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        long j10 = i11;
        C5883cc.m34088a(bArr.length, i10, j10);
        C5868bb c5868bb = this.f28602a;
        if (c5868bb.f26524b == 0 && this.f28603b.read(c5868bb, 8192L) == -1) {
            return -1;
        }
        return this.f28602a.read(bArr, i10, (int) Math.min(j10, this.f28602a.f26524b));
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public long mo33919a(byte b10, long j10, long j11) throws IOException {
        if (this.f28604c) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j10), Long.valueOf(j11)));
        }
        while (j10 < j11) {
            long jMo33919a = this.f28602a.mo33919a(b10, j10, j11);
            if (jMo33919a != -1) {
                return jMo33919a;
            }
            C5868bb c5868bb = this.f28602a;
            long j12 = c5868bb.f26524b;
            if (j12 >= j11 || this.f28603b.read(c5868bb, 8192L) == -1) {
                break;
            }
            j10 = Math.max(j10, j12);
        }
        return -1L;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
    public long read(C5868bb c5868bb, long j10) throws IOException {
        if (c5868bb == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f28604c) {
            throw new IllegalStateException("closed");
        }
        C5868bb c5868bb2 = this.f28602a;
        if (c5868bb2.f26524b == 0 && this.f28603b.read(c5868bb2, 8192L) == -1) {
            return -1L;
        }
        return this.f28602a.read(c5868bb, Math.min(j10, this.f28602a.f26524b));
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public long mo33920a(C5910eb c5910eb, long j10) throws IOException {
        if (this.f28604c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jMo33920a = this.f28602a.mo33920a(c5910eb, j10);
            if (jMo33920a != -1) {
                return jMo33920a;
            }
            C5868bb c5868bb = this.f28602a;
            long j11 = c5868bb.f26524b;
            if (this.f28603b.read(c5868bb, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, (j11 - c5910eb.mo34192j()) + 1);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public long mo33921a(InterfaceC6170yb interfaceC6170yb) throws IOException {
        if (interfaceC6170yb == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j10 = 0;
        while (this.f28603b.read(this.f28602a, 8192L) != -1) {
            long jM33984t = this.f28602a.m33984t();
            if (jM33984t > 0) {
                j10 += jM33984t;
                interfaceC6170yb.write(this.f28602a, jM33984t);
            }
        }
        if (this.f28602a.m33913B() <= 0) {
            return j10;
        }
        long jM33913B = j10 + this.f28602a.m33913B();
        C5868bb c5868bb = this.f28602a;
        interfaceC6170yb.write(c5868bb, c5868bb.m33913B());
        return jM33913B;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db, com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public C5868bb mo33924a() {
        return this.f28602a;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public String mo33939a(long j10, Charset charset) throws IOException {
        mo33970i(j10);
        if (charset != null) {
            return this.f28602a.mo33939a(j10, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public String mo33940a(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f28602a.mo33922a(this.f28603b);
        return this.f28602a.mo33940a(charset);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public void mo33941a(C5868bb c5868bb, long j10) throws IOException {
        try {
            mo33970i(j10);
            this.f28602a.mo33941a(c5868bb, j10);
        } catch (EOFException e10) {
            c5868bb.mo33922a((InterfaceC6183zb) this.f28602a);
            throw e10;
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public boolean mo33942a(long j10, C5910eb c5910eb) throws IOException {
        return mo33943a(j10, c5910eb, 0, c5910eb.mo34192j());
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5896db
    /* renamed from: a */
    public boolean mo33943a(long j10, C5910eb c5910eb, int i10, int i11) throws IOException {
        if (this.f28604c) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || i10 < 0 || i11 < 0 || c5910eb.mo34192j() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            long j11 = i12 + j10;
            if (!mo33969h(1 + j11) || this.f28602a.m33972j(j11) != c5910eb.mo34159a(i10 + i12)) {
                return false;
            }
        }
        return true;
    }
}
