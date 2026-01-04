package py;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: py.a */
/* loaded from: classes9.dex */
public class C12248a extends FilterInputStream {

    /* renamed from: a */
    public final long f56648a;

    /* renamed from: b */
    public long f56649b;

    /* renamed from: c */
    public long f56650c;

    /* renamed from: d */
    public boolean f56651d;

    public C12248a(InputStream inputStream, long j10) {
        super(inputStream);
        this.f56650c = -1L;
        this.f56651d = true;
        this.f56648a = j10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        if (!m73497u()) {
            return ((FilterInputStream) this).in.available();
        }
        m73498v(this.f56648a, this.f56649b);
        return 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f56651d) {
            ((FilterInputStream) this).in.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        ((FilterInputStream) this).in.mark(i10);
        this.f56650c = this.f56649b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (m73497u()) {
            m73498v(this.f56648a, this.f56649b);
            return -1;
        }
        int i10 = ((FilterInputStream) this).in.read();
        this.f56649b++;
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        ((FilterInputStream) this).in.reset();
        this.f56649b = this.f56650c;
    }

    /* renamed from: s */
    public long m73495s() {
        return this.f56649b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long j11 = this.f56648a;
        if (j11 >= 0) {
            j10 = Math.min(j10, j11 - this.f56649b);
        }
        long jSkip = ((FilterInputStream) this).in.skip(j10);
        this.f56649b += jSkip;
        return jSkip;
    }

    /* renamed from: t */
    public long m73496t() {
        return this.f56648a;
    }

    public String toString() {
        return ((FilterInputStream) this).in.toString();
    }

    /* renamed from: u */
    public final boolean m73497u() {
        long j10 = this.f56648a;
        return j10 >= 0 && this.f56649b >= j10;
    }

    /* renamed from: v */
    public void m73498v(long j10, long j11) throws IOException {
    }

    /* renamed from: w */
    public void m73499w(boolean z10) {
        this.f56651d = z10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (m73497u()) {
            m73498v(this.f56648a, this.f56649b);
            return -1;
        }
        long j10 = this.f56648a;
        int i12 = ((FilterInputStream) this).in.read(bArr, i10, (int) (j10 >= 0 ? Math.min(i11, j10 - this.f56649b) : i11));
        if (i12 == -1) {
            return -1;
        }
        this.f56649b += i12;
        return i12;
    }
}
