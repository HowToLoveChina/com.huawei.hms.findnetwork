package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.inter.data.C7306i;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;

/* renamed from: com.huawei.openalliance.ad.ah */
/* loaded from: classes8.dex */
public class C6913ah extends AbstractC6912ag {
    public C6913ah() {
        super("pps.download.cancel");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        C7306i c7306iM38795d = m38795d(context, str);
        if (c7306iM38795d == null) {
            AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, SNSCode.Status.GET_FRIEND_LIST_FAIL, null, true);
        } else {
            m38796e(context, str).mo42482d(context, c7306iM38795d);
            m45225b(remoteCallResultCallback, true);
        }
    }
}
