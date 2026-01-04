package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4627a0;
import com.huawei.cloud.base.util.InterfaceC4631c0;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.huawei.cloud.base.http.j */
/* loaded from: classes.dex */
public final class C4607j implements InterfaceC4631c0 {

    /* renamed from: a */
    public final InterfaceC4631c0 f21163a;

    /* renamed from: b */
    public final InterfaceC4606i f21164b;

    public C4607j(InterfaceC4631c0 interfaceC4631c0, InterfaceC4606i interfaceC4606i) {
        this.f21163a = (InterfaceC4631c0) C4627a0.m28391d(interfaceC4631c0);
        this.f21164b = (InterfaceC4606i) C4627a0.m28391d(interfaceC4606i);
    }

    @Override // com.huawei.cloud.base.util.InterfaceC4631c0
    /* renamed from: a */
    public void mo28157a(OutputStream outputStream) throws IOException {
        this.f21164b.mo28190a(this.f21163a, outputStream);
    }
}
