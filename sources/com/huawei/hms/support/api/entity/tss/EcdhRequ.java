package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.api.entity.tss.kms.KmsEcdhCtx;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class EcdhRequ extends BaseRequ {
    private static final String TAG = "EcdhRequ";

    @Packed
    private KmsEcdhCtx ecdhCtx;

    public KmsEcdhCtx getEcdhCtx() {
        return this.ecdhCtx;
    }

    public void setEcdhCtx(KmsEcdhCtx kmsEcdhCtx) {
        this.ecdhCtx = kmsEcdhCtx;
    }

    public String toJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            KmsEcdhCtx kmsEcdhCtx = this.ecdhCtx;
            if (kmsEcdhCtx != null) {
                jSONObject.put("ecdhCtx", kmsEcdhCtx.toJson());
            }
            jSONObject.put("caller", str);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "EcdhRequ toJson failed");
        }
        return jSONObject.toString();
    }
}
