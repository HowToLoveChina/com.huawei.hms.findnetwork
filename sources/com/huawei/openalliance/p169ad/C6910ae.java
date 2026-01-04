package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.ae */
/* loaded from: classes8.dex */
public class C6910ae extends AbstractC7326j {
    public C6910ae() {
        super("pps.set.consentpromise");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).setUnderAgeOfPromise(new JSONObject(str).optInt(JsbMapKeyNames.H5_CONSENT_PROMISE, 0) == 1);
        m45225b(remoteCallResultCallback, true);
    }
}
