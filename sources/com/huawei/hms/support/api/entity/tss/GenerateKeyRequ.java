package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.api.entity.tss.kms.KmsKeyCtx;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GenerateKeyRequ extends BaseRequ {
    private static final String TAG = "GenerateKeyRequ";

    @Packed
    private KmsKeyCtx keyCtx;

    public KmsKeyCtx getKeyCtx() {
        return this.keyCtx;
    }

    public void setKeyCtx(KmsKeyCtx kmsKeyCtx) {
        this.keyCtx = kmsKeyCtx;
    }

    public String toJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            KmsKeyCtx kmsKeyCtx = this.keyCtx;
            if (kmsKeyCtx != null) {
                jSONObject.put("keyCtx", kmsKeyCtx.toJson());
            }
            jSONObject.put("caller", str);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "GenerateKeyRequ toJson failed");
        }
        return jSONObject.toString();
    }
}
