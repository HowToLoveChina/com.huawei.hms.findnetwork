package ly;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import py.C12251d;

/* renamed from: ly.b */
/* loaded from: classes9.dex */
public class C11368b implements Closeable {

    /* renamed from: e */
    public static final long[] f53093e = new long[64];

    /* renamed from: a */
    public final C12251d f53094a;

    /* renamed from: b */
    public final ByteOrder f53095b;

    /* renamed from: c */
    public long f53096c;

    /* renamed from: d */
    public int f53097d;

    static {
        for (int i10 = 1; i10 <= 63; i10++) {
            long[] jArr = f53093e;
            jArr[i10] = (jArr[i10 - 1] << 1) + 1;
        }
    }

    public C11368b(InputStream inputStream, ByteOrder byteOrder) {
        this.f53094a = new C12251d(inputStream);
        this.f53095b = byteOrder;
    }

    /* renamed from: A */
    public final long m68208A(int i10) {
        long j10;
        if (this.f53095b == ByteOrder.LITTLE_ENDIAN) {
            long j11 = this.f53096c;
            j10 = f53093e[i10] & j11;
            this.f53096c = j11 >>> i10;
        } else {
            j10 = f53093e[i10] & (this.f53096c >> (this.f53097d - i10));
        }
        this.f53097d -= i10;
        return j10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f53094a.close();
    }

    /* renamed from: s */
    public void m68209s() {
        int i10 = this.f53097d % 8;
        if (i10 > 0) {
            m68208A(i10);
        }
    }

    /* renamed from: t */
    public long m68210t() throws IOException {
        return this.f53097d + (this.f53094a.available() * 8);
    }

    /* renamed from: u */
    public int m68211u() {
        return this.f53097d;
    }

    /* renamed from: v */
    public void m68212v() {
        this.f53096c = 0L;
        this.f53097d = 0;
    }

    /* renamed from: w */
    public final boolean m68213w(int i10) throws IOException {
        while (true) {
            int i11 = this.f53097d;
            if (i11 >= i10 || i11 >= 57) {
                return false;
            }
            long j10 = this.f53094a.read();
            if (j10 < 0) {
                return true;
            }
            if (this.f53095b == ByteOrder.LITTLE_ENDIAN) {
                this.f53096c = (j10 << this.f53097d) | this.f53096c;
            } else {
                this.f53096c = j10 | (this.f53096c << 8);
            }
            this.f53097d += 8;
        }
    }

    /* renamed from: x */
    public long m68214x() {
        return this.f53094a.m73502s();
    }

    /* renamed from: y */
    public final long m68215y(int i10) throws IOException {
        long j10;
        int i11 = i10 - this.f53097d;
        int i12 = 8 - i11;
        long j11 = this.f53094a.read();
        if (j11 < 0) {
            return j11;
        }
        if (this.f53095b == ByteOrder.LITTLE_ENDIAN) {
            long[] jArr = f53093e;
            this.f53096c = ((jArr[i11] & j11) << this.f53097d) | this.f53096c;
            j11 >>>= i11;
            j10 = jArr[i12];
        } else {
            long j12 = this.f53096c << i11;
            long[] jArr2 = f53093e;
            this.f53096c = j12 | ((j11 >>> i12) & jArr2[i11]);
            j10 = jArr2[i12];
        }
        long j13 = j11 & j10;
        long j14 = this.f53096c & f53093e[i10];
        this.f53096c = j13;
        this.f53097d = i12;
        return j14;
    }

    /* renamed from: z */
    public long m68216z(int i10) throws IOException {
        if (i10 < 0 || i10 > 63) {
            throw new IOException("count must not be negative or greater than 63");
        }
        if (m68213w(i10)) {
            return -1L;
        }
        return this.f53097d < i10 ? m68215y(i10) : m68208A(i10);
    }
}
