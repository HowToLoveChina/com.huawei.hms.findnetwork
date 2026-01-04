package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.inner.AdEventReport;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;

/* renamed from: com.huawei.openalliance.ad.bf */
/* loaded from: classes8.dex */
public class C6962bf extends AbstractC6950ba {
    public C6962bf() {
        super("pps.event.show");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        AbstractC7185ho.m43817a("JsbReportShowEvent", "start");
        AdEventReport adEventReport = (AdEventReport) AbstractC7758be.m47722a(str, AdEventReport.class, new Class[0]);
        InterfaceC7615qq interfaceC7615qqM39244d = m39244d(context, str);
        if (interfaceC7615qqM39244d != null && adEventReport != null) {
            interfaceC7615qqM39244d.mo46608b(adEventReport.m39313e() == null ? 0L : adEventReport.m39313e().longValue(), adEventReport.m39314f() != null ? adEventReport.m39314f().longValue() : 0L, adEventReport.m39315g() == null ? 0 : adEventReport.m39315g().intValue(), adEventReport.m39316h() != null ? adEventReport.m39316h().intValue() : 0);
        }
        m45225b(remoteCallResultCallback, true);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC6950ba
    /* renamed from: b */
    public String mo39243b() {
        return null;
    }
}
