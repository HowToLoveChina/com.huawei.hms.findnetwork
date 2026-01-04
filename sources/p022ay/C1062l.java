package p022ay;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import p692uw.C13267j;

/* renamed from: ay.l */
/* loaded from: classes9.dex */
public final class C1062l implements InterfaceC1076z {

    /* renamed from: a */
    public final InterfaceC1056f f5146a;

    /* renamed from: b */
    public final Inflater f5147b;

    /* renamed from: c */
    public int f5148c;

    /* renamed from: d */
    public boolean f5149d;

    public C1062l(InterfaceC1056f interfaceC1056f, Inflater inflater) {
        C13267j.m79677e(interfaceC1056f, "source");
        C13267j.m79677e(inflater, "inflater");
        this.f5146a = interfaceC1056f;
        this.f5147b = inflater;
    }

    /* renamed from: b */
    public final long m6399b(C1054d c1054d, long j10) throws DataFormatException, IOException {
        C13267j.m79677e(c1054d, "sink");
        if (j10 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (!(!this.f5149d)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j10 == 0) {
            return 0L;
        }
        try {
            C1071u c1071uM6335Y = c1054d.m6335Y(1);
            int iMin = (int) Math.min(j10, 8192 - c1071uM6335Y.f5169c);
            m6400s();
            int iInflate = this.f5147b.inflate(c1071uM6335Y.f5167a, c1071uM6335Y.f5169c, iMin);
            m6401t();
            if (iInflate > 0) {
                c1071uM6335Y.f5169c += iInflate;
                long j11 = iInflate;
                c1054d.m6321H(c1054d.m6322J() + j11);
                return j11;
            }
            if (c1071uM6335Y.f5168b == c1071uM6335Y.f5169c) {
                c1054d.f5125a = c1071uM6335Y.m6435b();
                C1072v.m6440b(c1071uM6335Y);
            }
            return 0L;
        } catch (DataFormatException e10) {
            throw new IOException(e10);
        }
    }

    @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f5149d) {
            return;
        }
        this.f5147b.end();
        this.f5149d = true;
        this.f5146a.close();
    }

    @Override // p022ay.InterfaceC1076z
    public long read(C1054d c1054d, long j10) throws DataFormatException, IOException {
        C13267j.m79677e(c1054d, "sink");
        do {
            long jM6399b = m6399b(c1054d, j10);
            if (jM6399b > 0) {
                return jM6399b;
            }
            if (this.f5147b.finished() || this.f5147b.needsDictionary()) {
                return -1L;
            }
        } while (!this.f5146a.mo6325M());
        throw new EOFException("source exhausted prematurely");
    }

    /* renamed from: s */
    public final boolean m6400s() throws IOException {
        if (!this.f5147b.needsInput()) {
            return false;
        }
        if (this.f5146a.mo6325M()) {
            return true;
        }
        C1071u c1071u = this.f5146a.mo6324L().f5125a;
        C13267j.m79674b(c1071u);
        int i10 = c1071u.f5169c;
        int i11 = c1071u.f5168b;
        int i12 = i10 - i11;
        this.f5148c = i12;
        this.f5147b.setInput(c1071u.f5167a, i11, i12);
        return false;
    }

    /* renamed from: t */
    public final void m6401t() throws IOException {
        int i10 = this.f5148c;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.f5147b.getRemaining();
        this.f5148c -= remaining;
        this.f5146a.skip(remaining);
    }

    @Override // p022ay.InterfaceC1076z
    public C1050a0 timeout() {
        return this.f5146a.timeout();
    }
}
