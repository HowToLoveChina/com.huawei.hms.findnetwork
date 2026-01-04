package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class VerifySignatureRequ extends BaseRequ {
    private static final String TAG = "VerifySignatureRequ";

    @Packed
    private String algorithm;

    @Packed
    private String data;

    @Packed
    private int keyIndex;

    @Packed
    private int keyType;

    @Packed
    private String signature;

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getData() {
        return this.data;
    }

    public int getKeyIndex() {
        return this.keyIndex;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setKeyIndex(int i10) {
        this.keyIndex = i10;
    }

    public void setKeyType(int i10) {
        this.keyType = i10;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keyType", this.keyType);
            jSONObject.put("algorithm", this.algorithm);
            jSONObject.put("keyIndex", this.keyIndex);
            jSONObject.put("data", this.data);
            jSONObject.put("signature", this.signature);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "toJson failed");
        }
        return jSONObject.toString();
    }
}
