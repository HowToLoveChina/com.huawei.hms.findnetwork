package p022ay;

import com.huawei.hms.network.embedded.C5929g4;
import java.io.IOException;
import java.io.InputStream;
import p692uw.C13267j;

/* renamed from: ay.m */
/* loaded from: classes9.dex */
public class C1063m implements InterfaceC1076z {

    /* renamed from: a */
    public final InputStream f5150a;

    /* renamed from: b */
    public final C1050a0 f5151b;

    public C1063m(InputStream inputStream, C1050a0 c1050a0) {
        C13267j.m79677e(inputStream, "input");
        C13267j.m79677e(c1050a0, "timeout");
        this.f5150a = inputStream;
        this.f5151b = c1050a0;
    }

    @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5150a.close();
    }

    @Override // p022ay.InterfaceC1076z
    public long read(C1054d c1054d, long j10) throws IOException {
        C13267j.m79677e(c1054d, "sink");
        if (j10 == 0) {
            return 0L;
        }
        if (j10 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        try {
            this.f5151b.throwIfReached();
            C1071u c1071uM6335Y = c1054d.m6335Y(1);
            int i10 = this.f5150a.read(c1071uM6335Y.f5167a, c1071uM6335Y.f5169c, (int) Math.min(j10, 8192 - c1071uM6335Y.f5169c));
            if (i10 != -1) {
                c1071uM6335Y.f5169c += i10;
                long j11 = i10;
                c1054d.m6321H(c1054d.m6322J() + j11);
                return j11;
            }
            if (c1071uM6335Y.f5168b != c1071uM6335Y.f5169c) {
                return -1L;
            }
            c1054d.f5125a = c1071uM6335Y.m6435b();
            C1072v.m6440b(c1071uM6335Y);
            return -1L;
        } catch (AssertionError e10) {
            if (C1064n.m6404c(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        }
    }

    @Override // p022ay.InterfaceC1076z
    public C1050a0 timeout() {
        return this.f5151b;
    }

    public String toString() {
        return "source(" + this.f5150a + C5929g4.f26850l;
    }
}
