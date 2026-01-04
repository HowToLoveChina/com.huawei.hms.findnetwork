package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.jsb.C5091a;
import com.huawei.openalliance.p169ad.inter.data.C7306i;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;

/* renamed from: com.huawei.openalliance.ad.av */
/* loaded from: classes8.dex */
public class C6944av extends AbstractC6912ag {
    public C6944av() {
        super("pps.download.progress");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        C7306i c7306iM38795d = m38795d(context, str);
        AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, 1000, Integer.valueOf(c7306iM38795d != null ? C5091a.m30359a(context).m30361a().mo42484f(context, c7306iM38795d) : 0), true);
    }
}
