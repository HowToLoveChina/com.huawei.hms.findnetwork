package com.huawei.hms.network.embedded;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.yb */
/* loaded from: classes8.dex */
public interface InterfaceC6170yb extends Closeable, Flushable {
    void close() throws IOException;

    @Override // java.io.Flushable
    void flush() throws IOException;

    C5855ac timeout();

    void write(C5868bb c5868bb, long j10) throws IOException;
}
