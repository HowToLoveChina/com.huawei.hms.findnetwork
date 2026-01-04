package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6101t7;
import com.huawei.hms.network.embedded.C6127v7;
import com.huawei.hms.network.embedded.InterfaceC6023n7;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.e9 */
/* loaded from: classes8.dex */
public final class C5908e9 implements InterfaceC6023n7 {

    /* renamed from: a */
    public final InterfaceC5878c7 f26707a;

    public C5908e9(InterfaceC5878c7 interfaceC5878c7) {
        this.f26707a = interfaceC5878c7;
    }

    /* renamed from: a */
    private String m34136a(List<C5864b7> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                sb2.append("; ");
            }
            C5864b7 c5864b7 = list.get(i10);
            sb2.append(c5864b7.m33876e());
            sb2.append('=');
            sb2.append(c5864b7.m33880i());
        }
        return sb2.toString();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6023n7
    public C6127v7 intercept(InterfaceC6023n7.a aVar) throws IOException {
        C6101t7 c6101t7Request = aVar.request();
        C6101t7.a aVarM35421i = c6101t7Request.m35421i();
        AbstractC6114u7 abstractC6114u7M35413b = c6101t7Request.m35413b();
        if (abstractC6114u7M35413b != null) {
            C6036o7 c6036o7ContentType = abstractC6114u7M35413b.contentType();
            if (c6036o7ContentType != null) {
                aVarM35421i.m35440b("Content-Type", c6036o7ContentType.toString());
            }
            long jContentLength = abstractC6114u7M35413b.contentLength();
            if (jContentLength != -1) {
                aVarM35421i.m35440b("Content-Length", Long.toString(jContentLength));
                aVarM35421i.m35439b("Transfer-Encoding");
            } else {
                aVarM35421i.m35440b("Transfer-Encoding", "chunked");
                aVarM35421i.m35439b("Content-Length");
            }
        }
        boolean z10 = false;
        if (c6101t7Request.m35411a(FeedbackWebConstants.HOST) == null) {
            aVarM35421i.m35440b(FeedbackWebConstants.HOST, C5920f8.m34233a(c6101t7Request.m35423k(), false));
        }
        if (c6101t7Request.m35411a("Connection") == null) {
            aVarM35421i.m35440b("Connection", "Keep-Alive");
        }
        if (c6101t7Request.m35411a(C5966j2.f27080v) == null && c6101t7Request.m35411a("Range") == null) {
            aVarM35421i.m35440b(C5966j2.f27080v, Constants.GZIP);
            z10 = true;
        }
        List<C5864b7> listMo34039a = this.f26707a.mo34039a(c6101t7Request.m35423k());
        if (!listMo34039a.isEmpty()) {
            aVarM35421i.m35440b("Cookie", m34136a(listMo34039a));
        }
        if (c6101t7Request.m35411a("User-Agent") == null) {
            aVarM35421i.m35440b("User-Agent", C5933g8.m34314a());
        }
        C6127v7 c6127v7Mo34620a = aVar.mo34620a(aVarM35421i.m35436a());
        C5960i9.m34409a(this.f26707a, c6101t7Request.m35423k(), c6127v7Mo34620a.m35591y());
        C6127v7.a aVarM35600a = c6127v7Mo34620a.m35574D().m35600a(c6101t7Request);
        if (z10 && Constants.GZIP.equalsIgnoreCase(c6127v7Mo34620a.m35582b("Content-Encoding")) && C5960i9.m34415b(c6127v7Mo34620a)) {
            C5988kb c5988kb = new C5988kb(c6127v7Mo34620a.m35585s().mo34712x());
            aVarM35600a.m35598a(c6127v7Mo34620a.m35591y().m34525c().m34542d("Content-Encoding").m34542d("Content-Length").m34535a());
            aVarM35600a.m35602a(new C5999l9(c6127v7Mo34620a.m35582b("Content-Type"), -1L, C6040ob.m34934a(c5988kb)));
        }
        return aVarM35600a.m35605a();
    }
}
