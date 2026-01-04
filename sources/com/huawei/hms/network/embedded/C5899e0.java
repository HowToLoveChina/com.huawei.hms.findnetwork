package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.AbstractRunnableC5912f0;
import com.huawei.hms.network.embedded.C6093t;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.e0 */
/* loaded from: classes8.dex */
public class C5899e0 extends AbstractRunnableC5912f0 {

    /* renamed from: h */
    public static final String f26670h = "DNKeeperResolver";

    public C5899e0(String str, AbstractRunnableC5912f0.a aVar) {
        super(str, 1, "dns_sync_query", aVar);
    }

    @Override // com.huawei.hms.network.embedded.AbstractRunnableC5912f0
    /* renamed from: c */
    public C6003m0 mo34108c() {
        String strM35372b;
        int iM35369a;
        Logger.m32144v(f26670h, "Resolve to DNKeeper, host: %s", this.f26718a);
        C6003m0 c6003m0 = new C6003m0();
        InterfaceC5990l0 interfaceC5990l0M35349c = C6093t.m35329m().m35349c();
        if (interfaceC5990l0M35349c != null) {
            C6093t.i iVarM35345b = C6093t.m35329m().m35345b(this.f26718a);
            if (iVarM35345b != null) {
                strM35372b = iVarM35345b.m35372b();
                iM35369a = iVarM35345b.m35369a();
            } else {
                strM35372b = null;
                iM35369a = 0;
            }
            c6003m0 = interfaceC5990l0M35349c.mo34635a(this.f26718a, strM35372b, iM35369a);
            c6003m0.m34743b(1);
            C6093t.m35329m().m35338a(this.f26718a);
        }
        if (C6158y.m35829b(c6003m0)) {
            Logger.m32147w(f26670h, "Resolve from DNKeeper is null, host: %s", this.f26718a);
            return c6003m0;
        }
        List<String> listM34749d = c6003m0.m34749d();
        if (!listM34749d.isEmpty()) {
            c6003m0.m34746b(listM34749d);
        }
        Logger.m32143v(f26670h, this.f26718a + " Resolve to DNKeeper, result: " + c6003m0);
        return c6003m0;
    }
}
