package com.huawei.hms.network.embedded;

import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.hb */
/* loaded from: classes8.dex */
public abstract class AbstractC5949hb implements InterfaceC6183zb {

    /* renamed from: a */
    public final InterfaceC6183zb f26979a;

    public AbstractC5949hb(InterfaceC6183zb interfaceC6183zb) {
        if (interfaceC6183zb == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f26979a = interfaceC6183zb;
    }

    /* renamed from: b */
    public final InterfaceC6183zb m34374b() {
        return this.f26979a;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
    public void close() throws IOException {
        this.f26979a.close();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
    public long read(C5868bb c5868bb, long j10) throws IOException {
        return this.f26979a.read(c5868bb, j10);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
    public C5855ac timeout() {
        return this.f26979a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f26979a.toString() + ")";
    }
}
