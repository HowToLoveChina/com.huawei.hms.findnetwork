package p022ay;

import com.huawei.hms.network.embedded.C5929g4;
import java.io.IOException;
import java.io.OutputStream;
import p692uw.C13267j;

/* renamed from: ay.r */
/* loaded from: classes9.dex */
public final class C1068r implements InterfaceC1074x {

    /* renamed from: a */
    public final OutputStream f5156a;

    /* renamed from: b */
    public final C1050a0 f5157b;

    public C1068r(OutputStream outputStream, C1050a0 c1050a0) {
        C13267j.m79677e(outputStream, "out");
        C13267j.m79677e(c1050a0, "timeout");
        this.f5156a = outputStream;
        this.f5157b = c1050a0;
    }

    @Override // p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5156a.close();
    }

    @Override // p022ay.InterfaceC1074x, java.io.Flushable
    public void flush() throws IOException {
        this.f5156a.flush();
    }

    @Override // p022ay.InterfaceC1074x
    public C1050a0 timeout() {
        return this.f5157b;
    }

    public String toString() {
        return "sink(" + this.f5156a + C5929g4.f26850l;
    }

    @Override // p022ay.InterfaceC1074x
    public void write(C1054d c1054d, long j10) throws IOException {
        C13267j.m79677e(c1054d, "source");
        C1051b.m6294b(c1054d.m6322J(), 0L, j10);
        while (j10 > 0) {
            this.f5157b.throwIfReached();
            C1071u c1071u = c1054d.f5125a;
            C13267j.m79674b(c1071u);
            int iMin = (int) Math.min(j10, c1071u.f5169c - c1071u.f5168b);
            this.f5156a.write(c1071u.f5167a, c1071u.f5168b, iMin);
            c1071u.f5168b += iMin;
            long j11 = iMin;
            j10 -= j11;
            c1054d.m6321H(c1054d.m6322J() - j11);
            if (c1071u.f5168b == c1071u.f5169c) {
                c1054d.f5125a = c1071u.m6435b();
                C1072v.m6440b(c1071u);
            }
        }
    }
}
