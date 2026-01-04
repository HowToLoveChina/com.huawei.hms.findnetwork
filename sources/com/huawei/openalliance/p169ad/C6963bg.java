package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;

/* renamed from: com.huawei.openalliance.ad.bg */
/* loaded from: classes8.dex */
public class C6963bg extends AbstractC6950ba {
    public C6963bg() {
        super("pps.event.show");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        AbstractC7185ho.m43817a("JsbReportPlayResumeEvent", "start");
        InterfaceC7615qq interfaceC7615qqM39244d = m39244d(context, str);
        if (interfaceC7615qqM39244d != null) {
            interfaceC7615qqM39244d.mo46623f();
        }
        m45225b(remoteCallResultCallback, true);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC6950ba
    /* renamed from: b */
    public String mo39243b() {
        return null;
    }
}
