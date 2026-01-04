package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.l */
/* loaded from: classes8.dex */
public class C7380l extends AbstractC7326j {
    public C7380l() {
        super("pps.click.share");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        int i10;
        AbstractC7185ho.m43817a("JsbClickShare", "start");
        String strOptString = new JSONObject(str).optString(JsbMapKeyNames.H5_CSHARE_URL, "");
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b != null) {
            AbstractC7185ho.m43817a("JsbClickShare", "start dialog activity");
            C7302e c7302eM46699a = C7570pd.m46699a(context, contentRecordM45224b, true);
            c7302eM46699a.m44788X(strOptString);
            C6980bx.m41138a(context, c7302eM46699a, contentRecordM45224b);
            i10 = 1000;
        } else {
            AbstractC7185ho.m43817a("JsbClickShare", "ad not exist");
            i10 = SNSCode.Status.GET_FRIEND_LIST_FAIL;
        }
        AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, i10, null, true);
    }
}
