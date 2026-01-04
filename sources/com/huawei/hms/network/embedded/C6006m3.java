package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6127v7;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.m3 */
/* loaded from: classes8.dex */
public class C6006m3 extends AbstractC5915f3 {

    /* renamed from: c */
    public static final String f27476c = "OnlyConnectCall";

    /* renamed from: com.huawei.hms.network.embedded.m3$a */
    public class a implements InterfaceC6023n7 {
        public a() {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6023n7
        public C6127v7 intercept(InterfaceC6023n7.a aVar) throws IOException {
            C6006m3.this.exchange = ((C5986k9) aVar).m34628e();
            return new C6127v7.a().m35600a(C6006m3.this.request).m35595a(200).m35599a(EnumC6075r7.HTTP_1_1).m35603a("connect success").m35602a(AbstractC6140w7.m35733a(C6036o7.m34922a("text/plain; charset=UTF-8"), "connect success")).m35605a();
        }
    }

    public C6006m3(C6062q7 c6062q7, C6101t7 c6101t7) {
        super(c6062q7, c6101t7);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5915f3
    public void addResponseInterceptor() {
        this.interceptors.add(new a());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5915f3
    /* renamed from: clone */
    public InterfaceC6100t6 mo85655clone() {
        return new C6006m3(this.client, this.request);
    }
}
