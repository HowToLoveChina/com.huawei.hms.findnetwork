package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.AbstractRunnableC5912f0;
import com.huawei.hms.network.embedded.C6093t;
import org.json.JSONException;

/* renamed from: com.huawei.hms.network.embedded.j0 */
/* loaded from: classes8.dex */
public class C5964j0 extends AbstractRunnableC5912f0 {

    /* renamed from: h */
    public static final String f27070h = "HttpDnsResolver";

    public C5964j0(String str, @C6093t.k String str2, AbstractRunnableC5912f0.a aVar) {
        super(str, 3, str2, aVar);
    }

    @Override // com.huawei.hms.network.embedded.AbstractRunnableC5912f0
    /* renamed from: c */
    public C6003m0 mo34108c() throws JSONException {
        C6003m0 c6003m0 = new C6003m0();
        C6016n0 c6016n0M35356e = C6093t.m35329m().m35356e();
        if (c6016n0M35356e != null) {
            c6003m0 = c6016n0M35356e.m34875a(this.f26718a);
        }
        if (C6158y.m35829b(c6003m0)) {
            Logger.m32147w(f27070h, "Resolve from HttpDns is null, host: %s", this.f26718a);
        }
        return c6003m0;
    }
}
