package p351hz;

import java.io.IOException;
import java.io.InputStream;
import kz.C11205b;
import p411jz.C10962a;
import p463lz.C11382d;

/* renamed from: hz.l */
/* loaded from: classes9.dex */
public class C10373l extends InputStream {

    /* renamed from: a */
    public InputStream f50137a;

    /* renamed from: b */
    public C10364c f50138b;

    /* renamed from: c */
    public C10962a f50139c;

    /* renamed from: d */
    public C11382d f50140d;

    /* renamed from: e */
    public C11205b f50141e;

    /* renamed from: i */
    public long f50145i;

    /* renamed from: f */
    public boolean f50142f = false;

    /* renamed from: g */
    public boolean f50143g = false;

    /* renamed from: h */
    public final byte[] f50144h = new byte[1];

    /* renamed from: j */
    public IOException f50146j = null;

    public C10373l(InputStream inputStream, long j10, byte b10, int i10) throws IOException {
        m63812w(inputStream, j10, b10, i10, null, C10364c.m63794b());
    }

    /* renamed from: t */
    public static int m63808t(int i10) {
        if (i10 < 0 || i10 > 2147483632) {
            throw new IllegalArgumentException("LZMA dictionary is too big for this implementation");
        }
        if (i10 < 4096) {
            i10 = 4096;
        }
        return (i10 + 15) & (-16);
    }

    /* renamed from: u */
    public static int m63809u(int i10, byte b10) throws C10377p, C10366e {
        if (i10 < 0 || i10 > 2147483632) {
            throw new C10377p("LZMA dictionary is too big for this implementation");
        }
        int i11 = b10 & 255;
        if (i11 > 224) {
            throw new C10366e("Invalid LZMA properties byte");
        }
        int i12 = i11 % 45;
        int i13 = i12 / 9;
        return m63810v(i10, i12 - (i13 * 9), i13);
    }

    /* renamed from: v */
    public static int m63810v(int i10, int i11, int i12) {
        if (i11 < 0 || i11 > 8 || i12 < 0 || i12 > 4) {
            throw new IllegalArgumentException("Invalid lc or lp");
        }
        return (m63808t(i10) / 1024) + 10 + ((1536 << (i11 + i12)) / 1024);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f50137a != null) {
            m63814y();
            try {
                this.f50137a.close();
            } finally {
                this.f50137a = null;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f50144h, 0, 1) == -1) {
            return -1;
        }
        return this.f50144h[0] & 255;
    }

    /* renamed from: s */
    public void m63811s() {
        this.f50143g = true;
    }

    /* renamed from: w */
    public final void m63812w(InputStream inputStream, long j10, byte b10, int i10, byte[] bArr, C10364c c10364c) throws IOException {
        if (j10 < -1) {
            throw new C10377p("Uncompressed size is too big");
        }
        int i11 = b10 & 255;
        if (i11 > 224) {
            throw new C10366e("Invalid LZMA properties byte");
        }
        int i12 = i11 / 45;
        int i13 = i11 - (i12 * 45);
        int i14 = i13 / 9;
        int i15 = i13 - (i14 * 9);
        if (i10 < 0 || i10 > 2147483632) {
            throw new C10377p("LZMA dictionary is too big for this implementation");
        }
        m63813x(inputStream, j10, i15, i14, i12, i10, bArr, c10364c);
    }

    /* renamed from: x */
    public final void m63813x(InputStream inputStream, long j10, int i10, int i11, int i12, int i13, byte[] bArr, C10364c c10364c) throws IOException {
        if (j10 < -1 || i10 < 0 || i10 > 8 || i11 < 0 || i11 > 4 || i12 < 0 || i12 > 4) {
            throw new IllegalArgumentException();
        }
        this.f50137a = inputStream;
        this.f50138b = c10364c;
        int iM63808t = m63808t(i13);
        if (j10 >= 0 && iM63808t > j10) {
            iM63808t = m63808t((int) j10);
        }
        this.f50139c = new C10962a(m63808t(iM63808t), bArr, c10364c);
        C11382d c11382d = new C11382d(inputStream);
        this.f50140d = c11382d;
        this.f50141e = new C11205b(this.f50139c, c11382d, i10, i11, i12);
        this.f50145i = j10;
    }

    /* renamed from: y */
    public final void m63814y() {
        C10962a c10962a = this.f50139c;
        if (c10962a != null) {
            c10962a.m66165g(this.f50138b);
            this.f50139c = null;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        if (i10 < 0 || i11 < 0 || (i12 = i10 + i11) < 0 || i12 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i13 = 0;
        if (i11 == 0) {
            return 0;
        }
        if (this.f50137a == null) {
            throw new C10379r("Stream closed");
        }
        IOException iOException = this.f50146j;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f50142f) {
            return -1;
        }
        while (i11 > 0) {
            try {
                long j10 = this.f50145i;
                this.f50139c.m66170l((j10 < 0 || j10 >= ((long) i11)) ? i11 : (int) j10);
                try {
                    this.f50141e.m67253e();
                } catch (C10366e e10) {
                    if (this.f50145i != -1 || !this.f50141e.m67256h()) {
                        throw e10;
                    }
                    this.f50142f = true;
                    this.f50140d.mo68244f();
                }
                int iM66160b = this.f50139c.m66160b(bArr, i10);
                i10 += iM66160b;
                i11 -= iM66160b;
                i13 += iM66160b;
                long j11 = this.f50145i;
                if (j11 >= 0) {
                    long j12 = j11 - iM66160b;
                    this.f50145i = j12;
                    if (j12 == 0) {
                        this.f50142f = true;
                    }
                }
                if (this.f50142f) {
                    if (this.f50139c.m66163e() || !(this.f50143g || this.f50140d.m68248g())) {
                        throw new C10366e();
                    }
                    m63814y();
                    if (i13 == 0) {
                        return -1;
                    }
                    return i13;
                }
            } catch (IOException e11) {
                this.f50146j = e11;
                throw e11;
            }
        }
        return i13;
    }
}
