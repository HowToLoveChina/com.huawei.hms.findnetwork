package p696v1;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: v1.b */
/* loaded from: classes.dex */
public class C13326b implements Closeable {

    /* renamed from: a */
    public final InputStream f60135a;

    /* renamed from: b */
    public final Charset f60136b;

    /* renamed from: c */
    public byte[] f60137c;

    /* renamed from: d */
    public int f60138d;

    /* renamed from: e */
    public int f60139e;

    /* renamed from: v1.b$a */
    public class a extends ByteArrayOutputStream {
        public a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, C13326b.this.f60136b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public C13326b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f60135a) {
            try {
                if (this.f60137c != null) {
                    this.f60137c = null;
                    this.f60135a.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: s */
    public final void m79926s() throws IOException {
        InputStream inputStream = this.f60135a;
        byte[] bArr = this.f60137c;
        int i10 = inputStream.read(bArr, 0, bArr.length);
        if (i10 == -1) {
            throw new EOFException();
        }
        this.f60138d = 0;
        this.f60139e = i10;
    }

    /* renamed from: t */
    public boolean m79927t() {
        return this.f60139e == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m79928u() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f60135a
            monitor-enter(r0)
            byte[] r1 = r7.f60137c     // Catch: java.lang.Throwable -> L11
            if (r1 == 0) goto L83
            int r1 = r7.f60138d     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f60139e     // Catch: java.lang.Throwable -> L11
            if (r1 < r2) goto L14
            r7.m79926s()     // Catch: java.lang.Throwable -> L11
            goto L14
        L11:
            r7 = move-exception
            goto L8b
        L14:
            int r1 = r7.f60138d     // Catch: java.lang.Throwable -> L11
        L16:
            int r2 = r7.f60139e     // Catch: java.lang.Throwable -> L11
            r3 = 10
            if (r1 == r2) goto L45
            byte[] r2 = r7.f60137c     // Catch: java.lang.Throwable -> L11
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L11
            if (r4 != r3) goto L42
            int r3 = r7.f60138d     // Catch: java.lang.Throwable -> L11
            if (r1 == r3) goto L2f
            int r4 = r1 + (-1)
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L11
            r6 = 13
            if (r5 != r6) goto L2f
            goto L30
        L2f:
            r4 = r1
        L30:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L11
            int r4 = r4 - r3
            java.nio.charset.Charset r6 = r7.f60136b     // Catch: java.lang.Throwable -> L11
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L11
            r5.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L11
            int r1 = r1 + 1
            r7.f60138d = r1     // Catch: java.lang.Throwable -> L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            return r5
        L42:
            int r1 = r1 + 1
            goto L16
        L45:
            v1.b$a r1 = new v1.b$a     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f60139e     // Catch: java.lang.Throwable -> L11
            int r4 = r7.f60138d     // Catch: java.lang.Throwable -> L11
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L11
        L51:
            byte[] r2 = r7.f60137c     // Catch: java.lang.Throwable -> L11
            int r4 = r7.f60138d     // Catch: java.lang.Throwable -> L11
            int r5 = r7.f60139e     // Catch: java.lang.Throwable -> L11
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L11
            r2 = -1
            r7.f60139e = r2     // Catch: java.lang.Throwable -> L11
            r7.m79926s()     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f60138d     // Catch: java.lang.Throwable -> L11
        L63:
            int r4 = r7.f60139e     // Catch: java.lang.Throwable -> L11
            if (r2 == r4) goto L51
            byte[] r4 = r7.f60137c     // Catch: java.lang.Throwable -> L11
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L11
            if (r5 != r3) goto L80
            int r3 = r7.f60138d     // Catch: java.lang.Throwable -> L11
            if (r2 == r3) goto L76
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L11
        L76:
            int r2 = r2 + 1
            r7.f60138d = r2     // Catch: java.lang.Throwable -> L11
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            return r7
        L80:
            int r2 = r2 + 1
            goto L63
        L83:
            java.io.IOException r7 = new java.io.IOException     // Catch: java.lang.Throwable -> L11
            java.lang.String r1 = "LineReader is closed"
            r7.<init>(r1)     // Catch: java.lang.Throwable -> L11
            throw r7     // Catch: java.lang.Throwable -> L11
        L8b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p696v1.C13326b.m79928u():java.lang.String");
    }

    public C13326b(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 >= 0) {
            if (charset.equals(C13327c.f60141a)) {
                this.f60135a = inputStream;
                this.f60136b = charset;
                this.f60137c = new byte[i10];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
