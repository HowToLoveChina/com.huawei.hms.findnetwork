package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C6127v7;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.n3 */
/* loaded from: classes8.dex */
public class C6019n3 extends AbstractC5915f3 {

    /* renamed from: c */
    public static final String f27569c = "SiteConnectCall";

    /* renamed from: d */
    public static final C6178z6 f27570d = new C6178z6(0, 1, TimeUnit.MILLISECONDS);

    /* renamed from: com.huawei.hms.network.embedded.n3$a */
    public class a implements InterfaceC6023n7 {
        public a() {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6023n7
        public C6127v7 intercept(InterfaceC6023n7.a aVar) throws IOException {
            C6019n3.this.exchange = ((C5986k9) aVar).m34628e();
            Logger.m32143v(C6019n3.f27569c, "Site connect success and return construct response");
            C6127v7.a aVarM35595a = new C6127v7.a().m35600a(C6019n3.this.request).m35595a(200);
            C6167y8 c6167y8 = C6019n3.this.transmitter.f26658i;
            return aVarM35595a.m35599a(c6167y8 == null ? EnumC6075r7.HTTP_1_1 : c6167y8.mo35839d()).m35603a("site detect success").m35602a(AbstractC6140w7.m35733a(C6036o7.m34922a("text/plain; charset=UTF-8"), "site detect success")).m35605a();
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.n3$b */
    public static final class b implements InterfaceC5919f7 {

        /* renamed from: b */
        public C6101t7 f27572b;

        public b(C6101t7 c6101t7) {
            this.f27572b = c6101t7;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC5919f7
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            Logger.m32144v(C6019n3.f27569c, "ConnectDetectDNS lookup %s and result %s", str, this.f27572b.m35422j());
            return (List) (this.f27572b.m35422j() == null ? Collections.EMPTY_LIST : this.f27572b.m35422j());
        }
    }

    public C6019n3(C6062q7 c6062q7, C6101t7 c6101t7) {
        super(c6062q7, c6101t7);
        this.client = c6062q7.m35096t().m35115a(f27570d).m35108a(new b(c6101t7)).m35125a();
        this.transmitter = new C5894d9(this.client, this);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5915f3
    public void addResponseInterceptor() {
        this.interceptors.add(new a());
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5915f3
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public InterfaceC6100t6 mo85655clone() {
        return new C6019n3(this.client, this.request);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC5915f3, com.huawei.hms.network.embedded.InterfaceC6100t6
    public C6101t7 request() {
        return this.request;
    }
}
