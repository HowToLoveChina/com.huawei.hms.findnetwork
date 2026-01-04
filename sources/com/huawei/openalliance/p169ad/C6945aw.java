package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.jsb.C5091a;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.C7306i;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;

/* renamed from: com.huawei.openalliance.ad.aw */
/* loaded from: classes8.dex */
public class C6945aw extends AbstractC6912ag {
    public C6945aw() {
        super("pps.download.status");
    }

    /* renamed from: a */
    private String m39238a(AppStatus appStatus) {
        return appStatus == null ? AppStatus.DOWNLOAD.toString() : appStatus.toString();
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        C7306i c7306iM38795d = m38795d(context, str);
        AppStatus appStatusMo42483e = AppStatus.DOWNLOAD;
        if (c7306iM38795d != null) {
            appStatusMo42483e = C5091a.m30359a(context).m30361a().mo42483e(context, c7306iM38795d);
        }
        AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, 1000, m39238a(appStatusMo42483e), true);
    }
}
