package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6127v7;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.x8 */
/* loaded from: classes8.dex */
public final class C6154x8 implements InterfaceC6023n7 {

    /* renamed from: a */
    public final C6062q7 f29076a;

    public C6154x8(C6062q7 c6062q7) {
        this.f29076a = c6062q7;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7
    public C6127v7 intercept(InterfaceC6023n7.a aVar) throws IOException {
        C5986k9 c5986k9 = (C5986k9) aVar;
        C6101t7 c6101t7Request = c5986k9.request();
        c5986k9.m34629f().prepareToConnect(c6101t7Request);
        c5986k9.m34629f().getExchangeFinder().m35745a(this.f29076a, c6101t7Request);
        return new C6127v7.a().m35599a(EnumC6075r7.HTTP_2).m35603a("").m35602a(new C5999l9("", 1L, null)).m35595a(200).m35600a(c6101t7Request).m35605a();
    }
}
