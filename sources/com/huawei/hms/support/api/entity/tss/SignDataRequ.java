package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SignDataRequ extends BaseRequ {
    private static final String TAG = "SignDataRequ";

    @Packed
    private String algorithm;

    @Packed
    private String alias;

    @Packed
    private String data;

    @Packed
    private int eccKeyLen;

    @Packed
    private int keyType;

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getData() {
        return this.data;
    }

    public int getEccKeyLen() {
        return this.eccKeyLen;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setEccKeyLen(int i10) {
        this.eccKeyLen = i10;
    }

    public void setKeyType(int i10) {
        this.keyType = i10;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keyType", this.keyType);
            jSONObject.put("algorithm", this.algorithm);
            jSONObject.put("alias", this.alias);
            jSONObject.put("data", this.data);
            jSONObject.put("eccKeyLen", this.eccKeyLen);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "toJson failed");
        }
        return jSONObject.toString();
    }
}
