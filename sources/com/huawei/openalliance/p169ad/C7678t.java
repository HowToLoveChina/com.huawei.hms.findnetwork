package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.t */
/* loaded from: classes8.dex */
class C7678t extends AbstractC7326j {
    public C7678t() {
        super("pps.process.whythisad");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        ContentRecord contentRecordM45224b = m45224b(context, str);
        String str2 = this.f34112a;
        if (contentRecordM45224b == null) {
            AbstractC7326j.m45216a(remoteCallResultCallback, str2, SNSCode.Status.GET_FRIEND_LIST_FAIL, null, true);
        } else {
            AbstractC7326j.m45216a(remoteCallResultCallback, str2, 1000, Integer.valueOf(AbstractC7741ao.m47548a(context, contentRecordM45224b) ? 0 : -1), true);
        }
    }
}
