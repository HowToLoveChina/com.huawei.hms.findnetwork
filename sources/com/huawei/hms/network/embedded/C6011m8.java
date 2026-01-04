package com.huawei.hms.network.embedded;

import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.m8 */
/* loaded from: classes8.dex */
public class C6011m8 extends AbstractC5936gb {

    /* renamed from: b */
    public boolean f27526b;

    public C6011m8(InterfaceC6170yb interfaceC6170yb) {
        super(interfaceC6170yb);
    }

    /* renamed from: a */
    public void mo34694a(IOException iOException) {
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5936gb, com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.f27526b) {
            return;
        }
        try {
            super.close();
        } catch (IOException e10) {
            this.f27526b = true;
            mo34694a(e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5936gb, com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
    public void flush() throws IOException {
        if (this.f27526b) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e10) {
            this.f27526b = true;
            mo34694a(e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5936gb, com.huawei.hms.network.embedded.InterfaceC6170yb
    public void write(C5868bb c5868bb, long j10) throws IOException {
        if (this.f27526b) {
            c5868bb.skip(j10);
            return;
        }
        try {
            super.write(c5868bb, j10);
        } catch (IOException e10) {
            this.f27526b = true;
            mo34694a(e10);
        }
    }
}
