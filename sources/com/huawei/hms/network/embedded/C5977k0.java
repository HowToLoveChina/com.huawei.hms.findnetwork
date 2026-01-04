package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.AbstractRunnableC5912f0;
import com.huawei.hms.network.embedded.C6093t;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* renamed from: com.huawei.hms.network.embedded.k0 */
/* loaded from: classes8.dex */
public class C5977k0 extends AbstractRunnableC5912f0 {

    /* renamed from: h */
    public static final String f27230h = "LocalDNSResolver";

    public C5977k0(String str, @C6093t.k String str2, AbstractRunnableC5912f0.a aVar) {
        super(str, 2, str2, aVar);
    }

    @Override // com.huawei.hms.network.embedded.AbstractRunnableC5912f0
    /* renamed from: c */
    public C6003m0 mo34108c() {
        StringBuilder sb2;
        String str;
        C6003m0 c6003m0 = new C6003m0();
        try {
            c6003m0 = C6158y.m35818a(InetAddress.getAllByName(this.f26718a));
        } catch (IllegalArgumentException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "LocalDNSResolver query failed, IllegalArgumentException Exception: ";
            sb2.append(str);
            sb2.append(this.f26718a);
            Logger.m32146w(f27230h, sb2.toString(), e);
        } catch (NullPointerException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "LocalDNSResolver query failed, NullPointerException Exception: ";
            sb2.append(str);
            sb2.append(this.f26718a);
            Logger.m32146w(f27230h, sb2.toString(), e);
        } catch (UnknownHostException unused) {
            Logger.m32145w(f27230h, "LocalDNSResolver query failed,UnknownHostException:" + this.f26718a);
        }
        if (this.f26718a.equalsIgnoreCase(C6029o0.m34910e().m34912b())) {
            for (String str2 : C6029o0.m34910e().m34911a()) {
                if (!c6003m0.m34749d().contains(str2)) {
                    c6003m0.m34739a(str2);
                }
            }
        }
        c6003m0.m34743b(2);
        c6003m0.m34737a(0);
        return c6003m0;
    }
}
