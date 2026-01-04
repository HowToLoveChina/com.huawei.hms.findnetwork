package py;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import my.C11562e;
import p538oy.InterfaceC12057a;

/* renamed from: py.f */
/* loaded from: classes9.dex */
public abstract class AbstractC12253f extends FilterInputStream {
    public AbstractC12253f(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        try {
            return super.available();
        } catch (IOException e10) {
            this.m73504f(e10);
            return 0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C11562e.m69025f(((FilterInputStream) this).in, new InterfaceC12057a() { // from class: py.e
            @Override // p538oy.InterfaceC12057a
            public final void accept(Object obj) throws IOException {
                this.f56655a.m73504f((IOException) obj);
            }
        });
    }

    /* renamed from: d */
    public void mo73501d(int i10) throws IOException {
    }

    /* renamed from: e */
    public void m73503e(int i10) throws IOException {
    }

    /* renamed from: f */
    public void m73504f(IOException iOException) throws IOException {
        throw iOException;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        ((FilterInputStream) this).in.mark(i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10 = 1;
        try {
            m73503e(1);
            int i11 = ((FilterInputStream) this).in.read();
            if (i11 == -1) {
                i10 = -1;
            }
            mo73501d(i10);
            return i11;
        } catch (IOException e10) {
            m73504f(e10);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            ((FilterInputStream) this).in.reset();
        } catch (IOException e10) {
            m73504f(e10);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        try {
            return ((FilterInputStream) this).in.skip(j10);
        } catch (IOException e10) {
            this.m73504f(e10);
            return 0L;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            m73503e(C11562e.m69033n(bArr));
            int i10 = ((FilterInputStream) this).in.read(bArr);
            mo73501d(i10);
            return i10;
        } catch (IOException e10) {
            m73504f(e10);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        try {
            m73503e(i11);
            int i12 = ((FilterInputStream) this).in.read(bArr, i10, i11);
            mo73501d(i12);
            return i12;
        } catch (IOException e10) {
            m73504f(e10);
            return -1;
        }
    }
}
