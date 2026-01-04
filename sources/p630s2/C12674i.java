package p630s2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: s2.i */
/* loaded from: classes.dex */
public class C12674i extends FilterInputStream {

    /* renamed from: a */
    public int f58184a;

    public C12674i(InputStream inputStream) {
        super(inputStream);
        this.f58184a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i10 = this.f58184a;
        return i10 == Integer.MIN_VALUE ? super.available() : Math.min(i10, super.available());
    }

    /* renamed from: j */
    public final long m76270j(long j10) {
        int i10 = this.f58184a;
        if (i10 == 0) {
            return -1L;
        }
        return (i10 == Integer.MIN_VALUE || j10 <= ((long) i10)) ? j10 : i10;
    }

    /* renamed from: k */
    public final void m76271k(long j10) {
        int i10 = this.f58184a;
        if (i10 == Integer.MIN_VALUE || j10 == -1) {
            return;
        }
        this.f58184a = (int) (i10 - j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        super.mark(i10);
        this.f58184a = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (m76270j(1L) == -1) {
            return -1;
        }
        int i10 = super.read();
        m76271k(1L);
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f58184a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long jM76270j = m76270j(j10);
        if (jM76270j == -1) {
            return 0L;
        }
        long jSkip = super.skip(jM76270j);
        m76271k(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int iM76270j = (int) m76270j(i11);
        if (iM76270j == -1) {
            return -1;
        }
        int i12 = super.read(bArr, i10, iM76270j);
        m76271k(i12);
        return i12;
    }
}
