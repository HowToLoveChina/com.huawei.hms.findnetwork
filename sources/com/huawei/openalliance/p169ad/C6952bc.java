package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.inner.AdEventReport;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.bc */
/* loaded from: classes8.dex */
public class C6952bc extends AbstractC6950ba {
    public C6952bc() {
        super("pps.event.close");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        AbstractC7185ho.m43817a("JsbReportCloseEvent", "start");
        AdEventReport adEventReport = (AdEventReport) AbstractC7758be.m47722a(str, AdEventReport.class, new Class[0]);
        List<String> listM39320l = adEventReport != null ? adEventReport.m39320l() : null;
        InterfaceC7615qq interfaceC7615qqM39244d = m39244d(context, str);
        if (interfaceC7615qqM39244d != null) {
            interfaceC7615qqM39244d.mo46577a(0, 0, listM39320l);
        }
        m45225b(remoteCallResultCallback, true);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC6950ba
    /* renamed from: b */
    public String mo39243b() {
        return "JsbReportCloseEvent";
    }
}
