package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.InterfaceC6023n7;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.t8 */
/* loaded from: classes8.dex */
public final class C6102t8 implements InterfaceC6023n7 {

    /* renamed from: a */
    public final C6062q7 f28410a;

    public C6102t8(C6062q7 c6062q7) {
        this.f28410a = c6062q7;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7
    public C6127v7 intercept(InterfaceC6023n7.a aVar) throws IOException {
        C5986k9 c5986k9 = (C5986k9) aVar;
        C6101t7 c6101t7Request = c5986k9.request();
        C5894d9 c5894d9M34629f = c5986k9.m34629f();
        return c5986k9.m34621a(c6101t7Request, c5894d9M34629f, c5894d9M34629f.newExchange(aVar, !c6101t7Request.m35420h().equals("GET")));
    }
}
