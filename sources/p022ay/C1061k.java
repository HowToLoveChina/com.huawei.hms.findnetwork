package p022ay;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import p692uw.C13267j;

/* renamed from: ay.k */
/* loaded from: classes9.dex */
public final class C1061k implements InterfaceC1076z {

    /* renamed from: a */
    public byte f5141a;

    /* renamed from: b */
    public final C1070t f5142b;

    /* renamed from: c */
    public final Inflater f5143c;

    /* renamed from: d */
    public final C1062l f5144d;

    /* renamed from: e */
    public final CRC32 f5145e;

    public C1061k(InterfaceC1076z interfaceC1076z) {
        C13267j.m79677e(interfaceC1076z, "source");
        C1070t c1070t = new C1070t(interfaceC1076z);
        this.f5142b = c1070t;
        Inflater inflater = new Inflater(true);
        this.f5143c = inflater;
        this.f5144d = new C1062l(c1070t, inflater);
        this.f5145e = new CRC32();
    }

    /* renamed from: b */
    public final void m6395b(String str, int i10, int i11) throws IOException {
        if (i11 == i10) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i11), Integer.valueOf(i10)}, 3));
        C13267j.m79676d(str2, "format(this, *args)");
        throw new IOException(str2);
    }

    @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5144d.close();
    }

    @Override // p022ay.InterfaceC1076z
    public long read(C1054d c1054d, long j10) throws DataFormatException, IOException {
        C13267j.m79677e(c1054d, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.f5141a == 0) {
            m6396s();
            this.f5141a = (byte) 1;
        }
        if (this.f5141a == 1) {
            long jM6322J = c1054d.m6322J();
            long j11 = this.f5144d.read(c1054d, j10);
            if (j11 != -1) {
                m6398u(c1054d, jM6322J, j11);
                return j11;
            }
            this.f5141a = (byte) 2;
        }
        if (this.f5141a == 2) {
            m6397t();
            this.f5141a = (byte) 3;
            if (!this.f5142b.mo6325M()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    /* renamed from: s */
    public final void m6396s() throws IOException {
        this.f5142b.mo6357w0(10L);
        byte bM6359y = this.f5142b.f5163b.m6359y(3L);
        boolean z10 = ((bM6359y >> 1) & 1) == 1;
        if (z10) {
            m6398u(this.f5142b.f5163b, 0L, 10L);
        }
        m6395b("ID1ID2", 8075, this.f5142b.readShort());
        this.f5142b.skip(8L);
        if (((bM6359y >> 2) & 1) == 1) {
            this.f5142b.mo6357w0(2L);
            if (z10) {
                m6398u(this.f5142b.f5163b, 0L, 2L);
            }
            long jM6316D = this.f5142b.f5163b.m6316D() & 65535;
            this.f5142b.mo6357w0(jM6316D);
            if (z10) {
                m6398u(this.f5142b.f5163b, 0L, jM6316D);
            }
            this.f5142b.skip(jM6316D);
        }
        if (((bM6359y >> 3) & 1) == 1) {
            long jM6429b = this.f5142b.m6429b((byte) 0);
            if (jM6429b == -1) {
                throw new EOFException();
            }
            if (z10) {
                m6398u(this.f5142b.f5163b, 0L, jM6429b + 1);
            }
            this.f5142b.skip(jM6429b + 1);
        }
        if (((bM6359y >> 4) & 1) == 1) {
            long jM6429b2 = this.f5142b.m6429b((byte) 0);
            if (jM6429b2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                m6398u(this.f5142b.f5163b, 0L, jM6429b2 + 1);
            }
            this.f5142b.skip(jM6429b2 + 1);
        }
        if (z10) {
            m6395b("FHCRC", this.f5142b.m6432t(), (short) this.f5145e.getValue());
            this.f5145e.reset();
        }
    }

    /* renamed from: t */
    public final void m6397t() throws IOException {
        m6395b("CRC", this.f5142b.m6431s(), (int) this.f5145e.getValue());
        m6395b("ISIZE", this.f5142b.m6431s(), (int) this.f5143c.getBytesWritten());
    }

    @Override // p022ay.InterfaceC1076z
    public C1050a0 timeout() {
        return this.f5142b.timeout();
    }

    /* renamed from: u */
    public final void m6398u(C1054d c1054d, long j10, long j11) {
        C1071u c1071u = c1054d.f5125a;
        C13267j.m79674b(c1071u);
        while (true) {
            int i10 = c1071u.f5169c;
            int i11 = c1071u.f5168b;
            if (j10 < i10 - i11) {
                break;
            }
            j10 -= i10 - i11;
            c1071u = c1071u.f5172f;
            C13267j.m79674b(c1071u);
        }
        while (j11 > 0) {
            int iMin = (int) Math.min(c1071u.f5169c - r6, j11);
            this.f5145e.update(c1071u.f5167a, (int) (c1071u.f5168b + j10), iMin);
            j11 -= iMin;
            c1071u = c1071u.f5172f;
            C13267j.m79674b(c1071u);
            j10 = 0;
        }
    }
}
