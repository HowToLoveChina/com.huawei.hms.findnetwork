package p022ay;

import com.huawei.hms.network.embedded.C5929g4;
import java.io.IOException;
import p692uw.C13267j;

/* renamed from: ay.h */
/* loaded from: classes9.dex */
public abstract class AbstractC1058h implements InterfaceC1074x {
    private final InterfaceC1074x delegate;

    public AbstractC1058h(InterfaceC1074x interfaceC1074x) {
        C13267j.m79677e(interfaceC1074x, "delegate");
        this.delegate = interfaceC1074x;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final InterfaceC1074x m85639deprecated_delegate() {
        return this.delegate;
    }

    @Override // p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final InterfaceC1074x delegate() {
        return this.delegate;
    }

    @Override // p022ay.InterfaceC1074x, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // p022ay.InterfaceC1074x
    public C1050a0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + C5929g4.f26849k + this.delegate + C5929g4.f26850l;
    }

    @Override // p022ay.InterfaceC1074x
    public void write(C1054d c1054d, long j10) throws IOException {
        C13267j.m79677e(c1054d, "source");
        this.delegate.write(c1054d, j10);
    }
}
