package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;

/* renamed from: com.huawei.openalliance.ad.bj */
/* loaded from: classes8.dex */
public class C6966bj extends AbstractC6950ba {
    public C6966bj() {
        super("pps.event.praise");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        AbstractC7185ho.m43817a("JsbReportPraiseEvent", "start");
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b == null) {
            AbstractC7185ho.m43824c("JsbReportPraiseEvent", "%s: content is null", mo39243b());
        } else {
            m39242b(context).m39069a(contentRecordM45224b);
            m45225b(remoteCallResultCallback, true);
        }
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC6950ba
    /* renamed from: b */
    public String mo39243b() {
        return null;
    }
}
