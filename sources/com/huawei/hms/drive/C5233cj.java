package com.huawei.hms.drive;

import com.huawei.hms.drive.C5201bf;
import com.huawei.hms.drive.C5203bh;
import com.huawei.hms.drive.InterfaceC5196ba;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.IOException;
import java.util.List;
import p022ay.C1061k;
import p022ay.C1064n;

/* renamed from: com.huawei.hms.drive.cj */
/* loaded from: classes8.dex */
public final class C5233cj implements InterfaceC5196ba {

    /* renamed from: a */
    private final InterfaceC5185ar f24207a;

    public C5233cj(InterfaceC5185ar interfaceC5185ar) {
        this.f24207a = interfaceC5185ar;
    }

    @Override // com.huawei.hms.drive.InterfaceC5196ba
    /* renamed from: a */
    public C5203bh mo31030a(InterfaceC5196ba.a aVar) throws IOException {
        C5201bf c5201bfMo31031a = aVar.mo31031a();
        C5201bf.a aVarM31114g = c5201bfMo31031a.m31114g();
        AbstractC5202bg abstractC5202bgM31111d = c5201bfMo31031a.m31111d();
        if (abstractC5202bgM31111d != null) {
            C5197bb c5197bbContentType = abstractC5202bgM31111d.contentType();
            if (c5197bbContentType != null) {
                aVarM31114g.m31122a("Content-Type", c5197bbContentType.toString());
            }
            long jContentLength = abstractC5202bgM31111d.contentLength();
            if (jContentLength != -1) {
                aVarM31114g.m31122a("Content-Length", Long.toString(jContentLength));
                aVarM31114g.m31124b("Transfer-Encoding");
            } else {
                aVarM31114g.m31122a("Transfer-Encoding", "chunked");
                aVarM31114g.m31124b("Content-Length");
            }
        }
        boolean z10 = false;
        if (c5201bfMo31031a.m31108a(FeedbackWebConstants.HOST) == null) {
            aVarM31114g.m31122a(FeedbackWebConstants.HOST, C5210bo.m31178a(c5201bfMo31031a.m31107a(), false));
        }
        if (c5201bfMo31031a.m31108a("Connection") == null) {
            aVarM31114g.m31122a("Connection", "Keep-Alive");
        }
        if (c5201bfMo31031a.m31108a(C5966j2.f27080v) == null && c5201bfMo31031a.m31108a("Range") == null) {
            aVarM31114g.m31122a(C5966j2.f27080v, Constants.GZIP);
            z10 = true;
        }
        List<C5184aq> listMo30879a = this.f24207a.mo30879a(c5201bfMo31031a.m31107a());
        if (!listMo30879a.isEmpty()) {
            aVarM31114g.m31122a("Cookie", m31395a(listMo30879a));
        }
        if (c5201bfMo31031a.m31108a("User-Agent") == null) {
            aVarM31114g.m31122a("User-Agent", C5211bp.m31211a());
        }
        C5203bh c5203bhMo31032a = aVar.mo31032a(aVarM31114g.m31123a());
        C5237cn.m31413a(this.f24207a, c5201bfMo31031a.m31107a(), c5203bhMo31032a.m31132e());
        C5203bh.a aVarM31146a = c5203bhMo31032a.m31134g().m31146a(c5201bfMo31031a);
        if (z10 && Constants.GZIP.equalsIgnoreCase(c5203bhMo31032a.m31127a("Content-Encoding")) && C5237cn.m31415b(c5203bhMo31032a)) {
            C1061k c1061k = new C1061k(c5203bhMo31032a.m31133f().mo31161c());
            aVarM31146a.m31144a(c5203bhMo31032a.m31132e().m30924b().m30931b("Content-Encoding").m30931b("Content-Length").m30930a());
            aVarM31146a.m31148a(new C5240cq(c5203bhMo31032a.m31127a("Content-Type"), -1L, C1064n.m6403b(c1061k)));
        }
        return aVarM31146a.m31151a();
    }

    /* renamed from: a */
    private String m31395a(List<C5184aq> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                sb2.append("; ");
            }
            C5184aq c5184aq = list.get(i10);
            sb2.append(c5184aq.m30876a());
            sb2.append('=');
            sb2.append(c5184aq.m30878b());
        }
        return sb2.toString();
    }
}
