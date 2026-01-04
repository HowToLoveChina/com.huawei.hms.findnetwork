package p022ay;

import com.huawei.hms.network.embedded.C5929g4;
import java.io.IOException;
import p692uw.C13267j;

/* renamed from: ay.i */
/* loaded from: classes9.dex */
public abstract class AbstractC1059i implements InterfaceC1076z {
    private final InterfaceC1076z delegate;

    public AbstractC1059i(InterfaceC1076z interfaceC1076z) {
        C13267j.m79677e(interfaceC1076z, "delegate");
        this.delegate = interfaceC1076z;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final InterfaceC1076z m85640deprecated_delegate() {
        return this.delegate;
    }

    @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final InterfaceC1076z delegate() {
        return this.delegate;
    }

    @Override // p022ay.InterfaceC1076z
    public long read(C1054d c1054d, long j10) throws IOException {
        C13267j.m79677e(c1054d, "sink");
        return this.delegate.read(c1054d, j10);
    }

    @Override // p022ay.InterfaceC1076z
    public C1050a0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + C5929g4.f26849k + this.delegate + C5929g4.f26850l;
    }
}
