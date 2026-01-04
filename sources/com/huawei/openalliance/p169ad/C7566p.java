package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.analysis.C6928i;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.p */
/* loaded from: classes8.dex */
public class C7566p extends AbstractC7326j {
    public C7566p() {
        super("pps.feedback.toggle");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        int i10;
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("JsbFeedbackToggle", "start");
        }
        String strOptString = new JSONObject(str).optString(JsbMapKeyNames.FEEDBACK_CODE, "3");
        ContentRecord contentRecordM45224b = m45224b(context, str);
        if (contentRecordM45224b != null) {
            new C6928i(context).mo39222f(contentRecordM45224b, strOptString);
            i10 = 1000;
        } else {
            AbstractC7185ho.m43817a("JsbFeedbackToggle", "ad not exist");
            i10 = SNSCode.Status.GET_FRIEND_LIST_FAIL;
        }
        AbstractC7326j.m45216a(remoteCallResultCallback, this.f34112a, i10, null, true);
    }
}
