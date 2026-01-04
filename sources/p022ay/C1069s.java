package p022ay;

import com.huawei.android.hicloud.sync.wifi.datamanager.ExtractOWiFiHelper;
import com.huawei.hms.network.embedded.C5929g4;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import p692uw.C13267j;

/* renamed from: ay.s */
/* loaded from: classes9.dex */
public final class C1069s implements InterfaceC1055e {

    /* renamed from: a */
    public final InterfaceC1074x f5158a;

    /* renamed from: b */
    public final C1054d f5159b;

    /* renamed from: c */
    public boolean f5160c;

    public C1069s(InterfaceC1074x interfaceC1074x) {
        C13267j.m79677e(interfaceC1074x, "sink");
        this.f5158a = interfaceC1074x;
        this.f5159b = new C1054d();
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: A0 */
    public OutputStream mo6312A0() {
        return new a();
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: K */
    public C1054d mo6323K() {
        return this.f5159b;
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: N */
    public InterfaceC1055e mo6326N() throws IOException {
        if (!(!this.f5160c)) {
            throw new IllegalStateException("closed".toString());
        }
        long jM6354u = this.f5159b.m6354u();
        if (jM6354u > 0) {
            this.f5158a.write(this.f5159b, jM6354u);
        }
        return this;
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: P */
    public long mo6328P(InterfaceC1076z interfaceC1076z) throws IOException {
        C13267j.m79677e(interfaceC1076z, "source");
        long j10 = 0;
        while (true) {
            long j11 = interfaceC1076z.read(this.f5159b, 8192L);
            if (j11 == -1) {
                return j10;
            }
            j10 += j11;
            mo6326N();
        }
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: R */
    public InterfaceC1055e mo6329R(String str) {
        C13267j.m79677e(str, ExtractOWiFiHelper.STING_NODE);
        if (!(!this.f5160c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f5159b.mo6329R(str);
        return mo6326N();
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: W */
    public InterfaceC1055e mo6333W(long j10) {
        if (!(!this.f5160c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f5159b.mo6333W(j10);
        return mo6326N();
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: a */
    public InterfaceC1055e mo6337a(C1057g c1057g) {
        C13267j.m79677e(c1057g, "byteString");
        if (!(!this.f5160c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f5159b.mo6337a(c1057g);
        return mo6326N();
    }

    @Override // p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f5160c) {
            return;
        }
        try {
            if (this.f5159b.m6322J() > 0) {
                InterfaceC1074x interfaceC1074x = this.f5158a;
                C1054d c1054d = this.f5159b;
                interfaceC1074x.write(c1054d, c1054d.m6322J());
            }
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f5158a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f5160c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // p022ay.InterfaceC1055e, p022ay.InterfaceC1074x, java.io.Flushable
    public void flush() throws IOException {
        if (!(!this.f5160c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f5159b.m6322J() > 0) {
            InterfaceC1074x interfaceC1074x = this.f5158a;
            C1054d c1054d = this.f5159b;
            interfaceC1074x.write(c1054d, c1054d.m6322J());
        }
        this.f5158a.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f5160c;
    }

    @Override // p022ay.InterfaceC1074x
    public C1050a0 timeout() {
        return this.f5158a.timeout();
    }

    public String toString() {
        return "buffer(" + this.f5158a + C5929g4.f26850l;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        C13267j.m79677e(byteBuffer, "source");
        if (!(!this.f5160c)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f5159b.write(byteBuffer);
        mo6326N();
        return iWrite;
    }

    @Override // p022ay.InterfaceC1055e
    public InterfaceC1055e writeByte(int i10) {
        if (!(!this.f5160c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f5159b.writeByte(i10);
        return mo6326N();
    }

    @Override // p022ay.InterfaceC1055e
    public InterfaceC1055e writeInt(int i10) {
        if (!(!this.f5160c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f5159b.writeInt(i10);
        return mo6326N();
    }

    @Override // p022ay.InterfaceC1055e
    public InterfaceC1055e writeShort(int i10) {
        if (!(!this.f5160c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f5159b.writeShort(i10);
        return mo6326N();
    }

    @Override // p022ay.InterfaceC1055e
    /* renamed from: y0 */
    public InterfaceC1055e mo6360y0(long j10) {
        if (!(!this.f5160c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f5159b.mo6360y0(j10);
        return mo6326N();
    }

    /* renamed from: ay.s$a */
    public static final class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            C1069s.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            C1069s c1069s = C1069s.this;
            if (c1069s.f5160c) {
                return;
            }
            c1069s.flush();
        }

        public String toString() {
            return C1069s.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            C13267j.m79677e(bArr, "data");
            C1069s c1069s = C1069s.this;
            if (c1069s.f5160c) {
                throw new IOException("closed");
            }
            c1069s.f5159b.write(bArr, i10, i11);
            C1069s.this.mo6326N();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            C1069s c1069s = C1069s.this;
            if (!c1069s.f5160c) {
                c1069s.f5159b.writeByte((byte) i10);
                C1069s.this.mo6326N();
                return;
            }
            throw new IOException("closed");
        }
    }

    @Override // p022ay.InterfaceC1055e
    public InterfaceC1055e write(byte[] bArr) {
        C13267j.m79677e(bArr, "source");
        if (!this.f5160c) {
            this.f5159b.write(bArr);
            return mo6326N();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // p022ay.InterfaceC1055e
    public InterfaceC1055e write(byte[] bArr, int i10, int i11) {
        C13267j.m79677e(bArr, "source");
        if (!this.f5160c) {
            this.f5159b.write(bArr, i10, i11);
            return mo6326N();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // p022ay.InterfaceC1074x
    public void write(C1054d c1054d, long j10) throws IOException {
        C13267j.m79677e(c1054d, "source");
        if (!this.f5160c) {
            this.f5159b.write(c1054d, j10);
            mo6326N();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }
}
