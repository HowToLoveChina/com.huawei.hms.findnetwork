package com.huawei.hms.network.embedded;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.network.embedded.tb */
/* loaded from: classes8.dex */
public final class C6105tb implements InterfaceC5882cb {

    /* renamed from: a */
    public final C5868bb f28437a = new C5868bb();

    /* renamed from: b */
    public final InterfaceC6170yb f28438b;

    /* renamed from: c */
    public boolean f28439c;

    /* renamed from: com.huawei.hms.network.embedded.tb$a */
    public class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            C6105tb.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            C6105tb c6105tb = C6105tb.this;
            if (c6105tb.f28439c) {
                return;
            }
            c6105tb.flush();
        }

        public String toString() {
            return C6105tb.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            C6105tb c6105tb = C6105tb.this;
            if (c6105tb.f28439c) {
                throw new IOException("closed");
            }
            c6105tb.f28437a.writeByte((int) ((byte) i10));
            C6105tb.this.mo33955d();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            C6105tb c6105tb = C6105tb.this;
            if (c6105tb.f28439c) {
                throw new IOException("closed");
            }
            c6105tb.f28437a.write(bArr, i10, i11);
            C6105tb.this.mo33955d();
        }
    }

    public C6105tb(InterfaceC6170yb interfaceC6170yb) {
        if (interfaceC6170yb == null) {
            throw new NullPointerException("sink == null");
        }
        this.f28438b = interfaceC6170yb;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public long mo33922a(InterfaceC6183zb interfaceC6183zb) throws IOException {
        if (interfaceC6183zb == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long j11 = interfaceC6183zb.read(this.f28437a, 8192L);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
            mo33955d();
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: b */
    public InterfaceC5882cb mo33947b(int i10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33947b(i10);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: c */
    public InterfaceC5882cb mo33954c() throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        long jM33913B = this.f28437a.m33913B();
        if (jM33913B > 0) {
            this.f28438b.write(this.f28437a, jM33913B);
        }
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws Throwable {
        if (this.f28439c) {
            return;
        }
        try {
            C5868bb c5868bb = this.f28437a;
            long j10 = c5868bb.f26524b;
            if (j10 > 0) {
                this.f28438b.write(c5868bb, j10);
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f28438b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f28439c = true;
        if (th != null) {
            C5883cc.m34089a(th);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: d */
    public InterfaceC5882cb mo33955d() throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        long jM33984t = this.f28437a.m33984t();
        if (jM33984t > 0) {
            this.f28438b.write(this.f28437a, jM33984t);
        }
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb, com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
    public void flush() throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        C5868bb c5868bb = this.f28437a;
        long j10 = c5868bb.f26524b;
        if (j10 > 0) {
            this.f28438b.write(c5868bb, j10);
        }
        this.f28438b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f28439c;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
    public C5855ac timeout() {
        return this.f28438b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f28438b + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f28437a.write(byteBuffer);
        mo33955d();
        return iWrite;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public InterfaceC5882cb writeByte(int i10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.writeByte(i10);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public InterfaceC5882cb writeInt(int i10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.writeInt(i10);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public InterfaceC5882cb writeLong(long j10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.writeLong(j10);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public InterfaceC5882cb writeShort(int i10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.writeShort(i10);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public C5868bb mo33924a() {
        return this.f28437a;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: b */
    public InterfaceC5882cb mo33948b(long j10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33948b(j10);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: c */
    public InterfaceC5882cb mo33952c(int i10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33952c(i10);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public InterfaceC5882cb write(byte[] bArr) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.write(bArr);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public InterfaceC5882cb mo33925a(int i10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33925a(i10);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: b */
    public OutputStream mo33950b() {
        return new a();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: c */
    public InterfaceC5882cb mo33953c(long j10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33953c(j10);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    public InterfaceC5882cb write(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.write(bArr, i10, i11);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public InterfaceC5882cb mo33926a(long j10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33926a(j10);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
    public void write(C5868bb c5868bb, long j10) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.write(c5868bb, j10);
        mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public InterfaceC5882cb mo33928a(C5910eb c5910eb) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33928a(c5910eb);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public InterfaceC5882cb mo33938a(InterfaceC6183zb interfaceC6183zb, long j10) throws IOException {
        while (j10 > 0) {
            long j11 = interfaceC6183zb.read(this.f28437a, j10);
            if (j11 == -1) {
                throw new EOFException();
            }
            j10 -= j11;
            mo33955d();
        }
        return this;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public InterfaceC5882cb mo33934a(String str) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33934a(str);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public InterfaceC5882cb mo33935a(String str, int i10, int i11) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33935a(str, i10, i11);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public InterfaceC5882cb mo33936a(String str, int i10, int i11, Charset charset) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33936a(str, i10, i11, charset);
        return mo33955d();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5882cb
    /* renamed from: a */
    public InterfaceC5882cb mo33937a(String str, Charset charset) throws IOException {
        if (this.f28439c) {
            throw new IllegalStateException("closed");
        }
        this.f28437a.mo33937a(str, charset);
        return mo33955d();
    }
}
