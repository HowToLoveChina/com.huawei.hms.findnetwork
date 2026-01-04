package com.huawei.hms.network.embedded;

import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.gb */
/* loaded from: classes8.dex */
public abstract class AbstractC5936gb implements InterfaceC6170yb {

    /* renamed from: a */
    public final InterfaceC6170yb f26888a;

    public AbstractC5936gb(InterfaceC6170yb interfaceC6170yb) {
        if (interfaceC6170yb == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f26888a = interfaceC6170yb;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.f26888a.close();
    }

    /* renamed from: e */
    public final InterfaceC6170yb m34343e() {
        return this.f26888a;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
    public void flush() throws IOException {
        this.f26888a.flush();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
    public C5855ac timeout() {
        return this.f26888a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f26888a.toString() + ")";
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
    public void write(C5868bb c5868bb, long j10) throws IOException {
        this.f26888a.write(c5868bb, j10);
    }
}
