package p022ay;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: ay.z */
/* loaded from: classes9.dex */
public interface InterfaceC1076z extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long read(C1054d c1054d, long j10) throws IOException;

    C1050a0 timeout();
}
