package p306g2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import p003a2.InterfaceC0007b;

/* renamed from: g2.x */
/* loaded from: classes.dex */
public class C9872x extends FilterInputStream {

    /* renamed from: a */
    public volatile byte[] f48484a;

    /* renamed from: b */
    public int f48485b;

    /* renamed from: c */
    public int f48486c;

    /* renamed from: d */
    public int f48487d;

    /* renamed from: e */
    public int f48488e;

    /* renamed from: f */
    public final InterfaceC0007b f48489f;

    /* renamed from: g2.x$a */
    public static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public a(String str) {
            super(str);
        }
    }

    public C9872x(InputStream inputStream, InterfaceC0007b interfaceC0007b) {
        this(inputStream, interfaceC0007b, 65536);
    }

    /* renamed from: u */
    public static IOException m61312u() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f48484a == null || inputStream == null) {
            throw m61312u();
        }
        return (this.f48485b - this.f48488e) + inputStream.available();
    }

    /* renamed from: b */
    public final int m61313b(InputStream inputStream, byte[] bArr) throws IOException {
        int i10 = this.f48487d;
        if (i10 != -1) {
            int i11 = this.f48488e - i10;
            int i12 = this.f48486c;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.f48485b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f48489f.mo10c(i12, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f48484a = bArr2;
                    this.f48489f.put(bArr);
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy(bArr, i10, bArr, 0, bArr.length - i10);
                }
                int i13 = this.f48488e - this.f48487d;
                this.f48488e = i13;
                this.f48487d = 0;
                this.f48485b = 0;
                int i14 = inputStream.read(bArr, i13, bArr.length - i13);
                int i15 = this.f48488e;
                if (i14 > 0) {
                    i15 += i14;
                }
                this.f48485b = i15;
                return i14;
            }
        }
        int i16 = inputStream.read(bArr);
        if (i16 > 0) {
            this.f48487d = -1;
            this.f48488e = 0;
            this.f48485b = i16;
        }
        return i16;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f48484a != null) {
            this.f48489f.put(this.f48484a);
            this.f48484a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.f48486c = Math.max(this.f48486c, i10);
        this.f48487d = this.f48488e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f48484a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw m61312u();
        }
        if (this.f48488e >= this.f48485b && m61313b(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f48484a && (bArr = this.f48484a) == null) {
            throw m61312u();
        }
        int i10 = this.f48485b;
        int i11 = this.f48488e;
        if (i10 - i11 <= 0) {
            return -1;
        }
        this.f48488e = i11 + 1;
        return bArr[i11] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f48484a == null) {
            throw new IOException("Stream is closed");
        }
        int i10 = this.f48487d;
        if (-1 == i10) {
            throw new a("Mark has been invalidated, pos: " + this.f48488e + " markLimit: " + this.f48486c);
        }
        this.f48488e = i10;
    }

    /* renamed from: s */
    public synchronized void m61314s() {
        this.f48486c = this.f48484a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) throws IOException {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.f48484a;
        if (bArr == null) {
            throw m61312u();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw m61312u();
        }
        int i10 = this.f48485b;
        int i11 = this.f48488e;
        if (i10 - i11 >= j10) {
            this.f48488e = (int) (i11 + j10);
            return j10;
        }
        long j11 = i10 - i11;
        this.f48488e = i10;
        if (this.f48487d == -1 || j10 > this.f48486c) {
            long jSkip = inputStream.skip(j10 - j11);
            if (jSkip > 0) {
                this.f48487d = -1;
            }
            return j11 + jSkip;
        }
        if (m61313b(inputStream, bArr) == -1) {
            return j11;
        }
        int i12 = this.f48485b;
        int i13 = this.f48488e;
        if (i12 - i13 >= j10 - j11) {
            this.f48488e = (int) ((i13 + j10) - j11);
            return j10;
        }
        long j12 = (j11 + i12) - i13;
        this.f48488e = i12;
        return j12;
    }

    /* renamed from: t */
    public synchronized void m61315t() {
        if (this.f48484a != null) {
            this.f48489f.put(this.f48484a);
            this.f48484a = null;
        }
    }

    public C9872x(InputStream inputStream, InterfaceC0007b interfaceC0007b, int i10) {
        super(inputStream);
        this.f48487d = -1;
        this.f48489f = interfaceC0007b;
        this.f48484a = (byte[]) interfaceC0007b.mo10c(i10, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13;
        byte[] bArr2 = this.f48484a;
        if (bArr2 == null) {
            throw m61312u();
        }
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i14 = this.f48488e;
            int i15 = this.f48485b;
            if (i14 < i15) {
                int i16 = i15 - i14 >= i11 ? i11 : i15 - i14;
                System.arraycopy(bArr2, i14, bArr, i10, i16);
                this.f48488e += i16;
                if (i16 == i11 || inputStream.available() == 0) {
                    return i16;
                }
                i10 += i16;
                i12 = i11 - i16;
            } else {
                i12 = i11;
            }
            while (true) {
                if (this.f48487d == -1 && i12 >= bArr2.length) {
                    i13 = inputStream.read(bArr, i10, i12);
                    if (i13 == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                } else {
                    if (m61313b(inputStream, bArr2) == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                    if (bArr2 != this.f48484a && (bArr2 = this.f48484a) == null) {
                        throw m61312u();
                    }
                    int i17 = this.f48485b;
                    int i18 = this.f48488e;
                    i13 = i17 - i18 >= i12 ? i12 : i17 - i18;
                    System.arraycopy(bArr2, i18, bArr, i10, i13);
                    this.f48488e += i13;
                }
                i12 -= i13;
                if (i12 == 0) {
                    return i11;
                }
                if (inputStream.available() == 0) {
                    return i11 - i12;
                }
                i10 += i13;
            }
        } else {
            throw m61312u();
        }
    }
}
