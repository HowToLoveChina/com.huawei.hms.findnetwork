package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.hms.ads.consent.bean.AdProvider;
import com.huawei.hms.ads.consent.constant.ConsentStatus;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.consent.inter.ConsentUpdateListener;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.openalliance.ad.ad */
/* loaded from: classes8.dex */
public class C6909ad extends AbstractC7326j {
    public C6909ad() {
        super("pps.consent.query");
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7326j, com.huawei.openalliance.p169ad.InterfaceC7143g
    /* renamed from: a */
    public void mo38573a(Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).requestConsentUpdate(new ConsentUpdateListener() { // from class: com.huawei.openalliance.ad.ad.1
            public void onFail(String str2) {
                AbstractC7326j.m45216a(remoteCallResultCallback, C6909ad.this.f34112a, SNSCode.Status.INVALID_PARAM, str2, true);
            }

            public void onSuccess(ConsentStatus consentStatus, boolean z10, List<AdProvider> list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(JsbMapKeyNames.H5_CONSENT_STATUS, consentStatus.getValue());
                    jSONObject.put(JsbMapKeyNames.H5_CONSENT_ISNEEDCONSENT, z10);
                    JSONArray jSONArray = new JSONArray();
                    if (!AbstractC7760bg.m47767a(list)) {
                        for (AdProvider adProvider : list) {
                            JSONObject jSONObject2 = new JSONObject();
                            if (adProvider != null) {
                                jSONObject2.put("id", adProvider.getId());
                                jSONObject2.put("name", adProvider.getName());
                                jSONObject2.put(JsbMapKeyNames.H5_PROVIDER_SERVICE, adProvider.getServiceArea());
                                jSONObject2.put(JsbMapKeyNames.H5_PROVIDER_URL, adProvider.getPrivacyPolicyUrl());
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put(JsbMapKeyNames.H5_CONSENT_ADPROVIDERS, jSONArray);
                    AbstractC7326j.m45216a(remoteCallResultCallback, C6909ad.this.f34112a, 1000, jSONObject.toString(), true);
                } catch (Throwable unused) {
                    AbstractC7326j.m45216a(remoteCallResultCallback, C6909ad.this.f34112a, SNSCode.Status.INVALID_PARAM, "consent info is null", true);
                }
            }
        });
    }
}
