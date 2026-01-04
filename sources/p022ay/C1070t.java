package p022ay;

import ax.C1032b;
import com.huawei.hms.network.embedded.C5929g4;
import cy.C8962a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import p692uw.C13267j;

/* renamed from: ay.t */
/* loaded from: classes9.dex */
public final class C1070t implements InterfaceC1056f {

    /* renamed from: a */
    public final InterfaceC1076z f5162a;

    /* renamed from: b */
    public final C1054d f5163b;

    /* renamed from: c */
    public boolean f5164c;

    public C1070t(InterfaceC1076z interfaceC1076z) {
        C13267j.m79677e(interfaceC1076z, "source");
        this.f5162a = interfaceC1076z;
        this.f5163b = new C1054d();
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: C0 */
    public long mo6315C0() throws EOFException {
        byte bM6359y;
        mo6357w0(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!m6433u(i11)) {
                break;
            }
            bM6359y = this.f5163b.m6359y(i10);
            if ((bM6359y < 48 || bM6359y > 57) && ((bM6359y < 97 || bM6359y > 102) && (bM6359y < 65 || bM6359y > 70))) {
                break;
            }
            i10 = i11;
        }
        if (i10 == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(bM6359y, C1032b.m6238a(C1032b.m6238a(16)));
            C13267j.m79676d(string, "toString(this, checkRadix(radix))");
            sb2.append(string);
            throw new NumberFormatException(sb2.toString());
        }
        return this.f5163b.mo6315C0();
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: E0 */
    public InputStream mo6318E0() {
        return new a();
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: L */
    public C1054d mo6324L() {
        return this.f5163b;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: M */
    public boolean mo6325M() {
        if (!this.f5164c) {
            return this.f5163b.mo6325M() && this.f5162a.read(this.f5163b, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: O */
    public String mo6327O(long j10) throws EOFException {
        if (j10 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j10).toString());
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long jM6430c = m6430c((byte) 10, 0L, j11);
        if (jM6430c != -1) {
            return C8962a.m56716b(this.f5163b, jM6430c);
        }
        if (j11 < Long.MAX_VALUE && m6433u(j11) && this.f5163b.m6359y(j11 - 1) == 13 && m6433u(1 + j11) && this.f5163b.m6359y(j11) == 10) {
            return C8962a.m56716b(this.f5163b, j11);
        }
        C1054d c1054d = new C1054d();
        C1054d c1054d2 = this.f5163b;
        c1054d2.m6356w(c1054d, 0L, Math.min(32, c1054d2.m6322J()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f5163b.m6322J(), j10) + " content=" + c1054d.m6313B().mo6384u() + (char) 8230);
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: S */
    public int mo6330S(C1067q c1067q) throws EOFException {
        C13267j.m79677e(c1067q, "options");
        if (!(!this.f5164c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int iM56717c = C8962a.m56717c(this.f5163b, c1067q, true);
            if (iM56717c != -2) {
                if (iM56717c != -1) {
                    this.f5163b.skip(c1067q.m6421d()[iM56717c].m6370E());
                    return iM56717c;
                }
            } else if (this.f5162a.read(this.f5163b, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: T */
    public String mo6331T(Charset charset) throws IOException {
        C13267j.m79677e(charset, "charset");
        this.f5163b.mo6328P(this.f5162a);
        return this.f5163b.mo6331T(charset);
    }

    /* renamed from: b */
    public long m6429b(byte b10) {
        return m6430c(b10, 0L, Long.MAX_VALUE);
    }

    /* renamed from: c */
    public long m6430c(byte b10, long j10, long j11) {
        if (!(!this.f5164c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (0 > j10 || j10 > j11) {
            throw new IllegalArgumentException(("fromIndex=" + j10 + " toIndex=" + j11).toString());
        }
        while (j10 < j11) {
            long jM6361z = this.f5163b.m6361z(b10, j10, j11);
            if (jM6361z != -1) {
                return jM6361z;
            }
            long jM6322J = this.f5163b.m6322J();
            if (jM6322J >= j11 || this.f5162a.read(this.f5163b, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, jM6322J);
        }
        return -1L;
    }

    @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f5164c) {
            return;
        }
        this.f5164c = true;
        this.f5162a.close();
        this.f5163b.m6352s();
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: f0 */
    public String mo6341f0() {
        return mo6327O(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f5164c;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: l */
    public C1057g mo6345l(long j10) throws EOFException {
        mo6357w0(j10);
        return this.f5163b.mo6345l(j10);
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: l0 */
    public byte[] mo6346l0(long j10) throws EOFException {
        mo6357w0(j10);
        return this.f5163b.mo6346l0(j10);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        C13267j.m79677e(byteBuffer, "sink");
        if (this.f5163b.m6322J() == 0 && this.f5162a.read(this.f5163b, 8192L) == -1) {
            return -1;
        }
        return this.f5163b.read(byteBuffer);
    }

    @Override // p022ay.InterfaceC1056f
    public byte readByte() throws EOFException {
        mo6357w0(1L);
        return this.f5163b.readByte();
    }

    @Override // p022ay.InterfaceC1056f
    public void readFully(byte[] bArr) throws EOFException {
        C13267j.m79677e(bArr, "sink");
        try {
            mo6357w0(bArr.length);
            this.f5163b.readFully(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (this.f5163b.m6322J() > 0) {
                C1054d c1054d = this.f5163b;
                int i11 = c1054d.read(bArr, i10, (int) c1054d.m6322J());
                if (i11 == -1) {
                    throw new AssertionError();
                }
                i10 += i11;
            }
            throw e10;
        }
    }

    @Override // p022ay.InterfaceC1056f
    public int readInt() throws EOFException {
        mo6357w0(4L);
        return this.f5163b.readInt();
    }

    @Override // p022ay.InterfaceC1056f
    public short readShort() throws EOFException {
        mo6357w0(2L);
        return this.f5163b.readShort();
    }

    /* renamed from: s */
    public int m6431s() throws EOFException {
        mo6357w0(4L);
        return this.f5163b.m6314C();
    }

    @Override // p022ay.InterfaceC1056f
    public void skip(long j10) throws EOFException {
        if (!(!this.f5164c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j10 > 0) {
            if (this.f5163b.m6322J() == 0 && this.f5162a.read(this.f5163b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, this.f5163b.m6322J());
            this.f5163b.skip(jMin);
            j10 -= jMin;
        }
    }

    /* renamed from: t */
    public short m6432t() throws EOFException {
        mo6357w0(2L);
        return this.f5163b.m6316D();
    }

    @Override // p022ay.InterfaceC1076z
    public C1050a0 timeout() {
        return this.f5162a.timeout();
    }

    public String toString() {
        return "buffer(" + this.f5162a + C5929g4.f26850l;
    }

    /* renamed from: u */
    public boolean m6433u(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (!(!this.f5164c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.f5163b.m6322J() < j10) {
            if (this.f5162a.read(this.f5163b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // p022ay.InterfaceC1056f
    /* renamed from: w0 */
    public void mo6357w0(long j10) throws EOFException {
        if (!m6433u(j10)) {
            throw new EOFException();
        }
    }

    @Override // p022ay.InterfaceC1076z
    public long read(C1054d c1054d, long j10) {
        C13267j.m79677e(c1054d, "sink");
        if (j10 >= 0) {
            if (!(!this.f5164c)) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f5163b.m6322J() == 0 && this.f5162a.read(this.f5163b, 8192L) == -1) {
                return -1L;
            }
            return this.f5163b.read(c1054d, Math.min(j10, this.f5163b.m6322J()));
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
    }

    /* renamed from: ay.t$a */
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            C1070t c1070t = C1070t.this;
            if (c1070t.f5164c) {
                throw new IOException("closed");
            }
            return (int) Math.min(c1070t.f5163b.m6322J(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C1070t.this.close();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            C13267j.m79677e(bArr, "data");
            if (C1070t.this.f5164c) {
                throw new IOException("closed");
            }
            C1051b.m6294b(bArr.length, i10, i11);
            if (C1070t.this.f5163b.m6322J() == 0) {
                C1070t c1070t = C1070t.this;
                if (c1070t.f5162a.read(c1070t.f5163b, 8192L) == -1) {
                    return -1;
                }
            }
            return C1070t.this.f5163b.read(bArr, i10, i11);
        }

        public String toString() {
            return C1070t.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            C1070t c1070t = C1070t.this;
            if (!c1070t.f5164c) {
                if (c1070t.f5163b.m6322J() == 0) {
                    C1070t c1070t2 = C1070t.this;
                    if (c1070t2.f5162a.read(c1070t2.f5163b, 8192L) == -1) {
                        return -1;
                    }
                }
                return C1070t.this.f5163b.readByte() & 255;
            }
            throw new IOException("closed");
        }
    }
}
