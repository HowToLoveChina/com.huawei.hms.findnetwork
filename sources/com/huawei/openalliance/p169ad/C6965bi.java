package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.inner.AdEventReport;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;

/* renamed from: com.huawei.openalliance.ad.bi */
/* loaded from: classes8.dex */
public class C6965bi extends AbstractC6950ba {
    public C6965bi() {
        super("pps.event.show");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        AbstractC7185ho.m43817a("JsbReportPlayTimeEvent", "start");
        AdEventReport adEventReport = (AdEventReport) AbstractC7758be.m47722a(str, AdEventReport.class, new Class[0]);
        InterfaceC7615qq interfaceC7615qqM39244d = m39244d(context, str);
        if (interfaceC7615qqM39244d != null) {
            interfaceC7615qqM39244d.mo46580a(adEventReport.m39323o() == null ? 0L : adEventReport.m39323o().longValue());
        }
        m45225b(remoteCallResultCallback, true);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC6950ba
    /* renamed from: b */
    public String mo39243b() {
        return null;
    }
}
