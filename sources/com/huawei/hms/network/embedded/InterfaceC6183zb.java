package com.huawei.hms.network.embedded;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.zb */
/* loaded from: classes8.dex */
public interface InterfaceC6183zb extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
    void close() throws IOException;

    long read(C5868bb c5868bb, long j10) throws IOException;

    C5855ac timeout();
}
