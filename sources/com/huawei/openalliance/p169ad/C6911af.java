package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.consent.constant.ConsentStatus;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.af */
/* loaded from: classes8.dex */
public class C6911af extends AbstractC7326j {
    public C6911af() {
        super("pps.set.consentstatus");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).setConsentStatus(ConsentStatus.forValue(new JSONObject(str).optInt(JsbMapKeyNames.H5_CONSENT_STATUS, ConsentStatus.UNKNOWN.getValue())));
        m45225b(remoteCallResultCallback, true);
    }
}
