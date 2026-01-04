package com.huawei.cloud.base.util;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.huawei.cloud.base.util.v */
/* loaded from: classes.dex */
public final class C4654v implements InterfaceC4631c0 {

    /* renamed from: a */
    public final InterfaceC4631c0 f21341a;

    /* renamed from: b */
    public final int f21342b;

    /* renamed from: c */
    public final C4650r f21343c;

    public C4654v(InterfaceC4631c0 interfaceC4631c0, C4650r c4650r, int i10) {
        this.f21341a = interfaceC4631c0;
        this.f21343c = c4650r;
        this.f21342b = i10;
    }

    @Override // com.huawei.cloud.base.util.InterfaceC4631c0
    /* renamed from: a */
    public void mo28157a(OutputStream outputStream) throws IOException {
        C4653u c4653u = new C4653u(outputStream, this.f21343c, this.f21342b);
        try {
            this.f21341a.mo28157a(c4653u);
            c4653u.m28494s().close();
            outputStream.flush();
        } catch (Throwable th2) {
            c4653u.m28494s().close();
            throw th2;
        }
    }
}
