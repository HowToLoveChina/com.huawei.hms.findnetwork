package com.huawei.hms.drive;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: com.huawei.hms.drive.ah */
/* loaded from: classes8.dex */
public final class C5175ah implements Closeable, Flushable {

    /* renamed from: a */
    final InterfaceC5216bu f23582a;

    /* renamed from: b */
    final C5215bt f23583b;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23583b.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f23583b.flush();
    }
}
