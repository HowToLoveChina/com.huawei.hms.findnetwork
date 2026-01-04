package p022ay;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: ay.x */
/* loaded from: classes9.dex */
public interface InterfaceC1074x extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    C1050a0 timeout();

    void write(C1054d c1054d, long j10) throws IOException;
}
