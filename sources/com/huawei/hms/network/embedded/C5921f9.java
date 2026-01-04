package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6127v7;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: com.huawei.hms.network.embedded.f9 */
/* loaded from: classes8.dex */
public final class C5921f9 implements InterfaceC6023n7 {

    /* renamed from: a */
    public final boolean f26781a;

    public C5921f9(boolean z10) {
        this.f26781a = z10;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7
    public C6127v7 intercept(InterfaceC6023n7.a aVar) throws IOException {
        boolean z10;
        C6127v7.a aVarM35574D;
        AbstractC6140w7 abstractC6140w7M35613a;
        C5986k9 c5986k9 = (C5986k9) aVar;
        C6128v8 c6128v8M34628e = c5986k9.m34628e();
        C6101t7 c6101t7Request = c5986k9.request();
        long jCurrentTimeMillis = System.currentTimeMillis();
        c6128v8M34628e.m35617a(c6101t7Request);
        C6127v7.a aVarM35612a = null;
        if (!C5973j9.m34546b(c6101t7Request.m35420h()) || c6101t7Request.m35413b() == null) {
            c6128v8M34628e.m35627i();
            z10 = false;
        } else {
            if ("100-continue".equalsIgnoreCase(c6101t7Request.m35411a("Expect"))) {
                c6128v8M34628e.m35623e();
                c6128v8M34628e.m35628j();
                aVarM35612a = c6128v8M34628e.m35612a(true);
                z10 = true;
            } else {
                z10 = false;
            }
            if (aVarM35612a != null) {
                c6128v8M34628e.m35627i();
                if (!c6128v8M34628e.m35619b().m35863g()) {
                    c6128v8M34628e.m35626h();
                }
            } else if (c6101t7Request.m35413b().isDuplex()) {
                c6128v8M34628e.m35623e();
                c6101t7Request.m35413b().writeTo(C6040ob.m34933a(c6128v8M34628e.m35614a(c6101t7Request, true)));
            } else {
                InterfaceC5882cb interfaceC5882cbM34933a = C6040ob.m34933a(c6128v8M34628e.m35614a(c6101t7Request, false));
                c6101t7Request.m35413b().writeTo(interfaceC5882cbM34933a);
                interfaceC5882cbM34933a.close();
            }
        }
        if (c6101t7Request.m35413b() == null || !c6101t7Request.m35413b().isDuplex()) {
            c6128v8M34628e.m35622d();
        }
        if (!z10) {
            c6128v8M34628e.m35628j();
        }
        if (aVarM35612a == null) {
            aVarM35612a = c6128v8M34628e.m35612a(false);
        }
        C6127v7 c6127v7M35605a = aVarM35612a.m35600a(c6101t7Request).m35597a(c6128v8M34628e.m35619b().mo35836a()).m35607b(jCurrentTimeMillis).m35596a(System.currentTimeMillis()).m35605a();
        int iM35589w = c6127v7M35605a.m35589w();
        if (iM35589w == 100) {
            c6127v7M35605a = c6128v8M34628e.m35612a(false).m35600a(c6101t7Request).m35597a(c6128v8M34628e.m35619b().mo35836a()).m35607b(jCurrentTimeMillis).m35596a(System.currentTimeMillis()).m35605a();
            iM35589w = c6127v7M35605a.m35589w();
        }
        c6128v8M34628e.m35620b(c6127v7M35605a);
        if (this.f26781a && iM35589w == 101) {
            aVarM35574D = c6127v7M35605a.m35574D();
            abstractC6140w7M35613a = C5920f8.f26772d;
        } else {
            aVarM35574D = c6127v7M35605a.m35574D();
            abstractC6140w7M35613a = c6128v8M34628e.m35613a(c6127v7M35605a);
        }
        C6127v7 c6127v7M35605a2 = aVarM35574D.m35602a(abstractC6140w7M35613a).m35605a();
        if ("close".equalsIgnoreCase(c6127v7M35605a2.m35578H().m35411a("Connection")) || "close".equalsIgnoreCase(c6127v7M35605a2.m35582b("Connection"))) {
            c6128v8M34628e.m35626h();
        }
        if ((iM35589w != 204 && iM35589w != 205) || c6127v7M35605a2.m35585s().mo34710v() <= 0) {
            return c6127v7M35605a2;
        }
        throw new ProtocolException("HTTP " + iM35589w + " had non-zero Content-Length: " + c6127v7M35605a2.m35585s().mo34710v());
    }
}
