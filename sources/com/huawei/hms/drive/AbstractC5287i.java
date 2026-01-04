package com.huawei.hms.drive;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.huawei.hms.drive.i */
/* loaded from: classes8.dex */
public abstract class AbstractC5287i extends OutputStream {

    /* renamed from: a */
    private final OutputStream f24512a;

    public AbstractC5287i(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f24512a = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f24512a.close();
    }

    public final OutputStream delegate() {
        return this.f24512a;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f24512a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f24512a.toString() + ")";
    }
}
