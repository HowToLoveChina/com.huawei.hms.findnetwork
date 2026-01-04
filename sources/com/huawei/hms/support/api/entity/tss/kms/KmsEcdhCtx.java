package com.huawei.hms.support.api.entity.tss.kms;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class KmsEcdhCtx {
    private static final String TAG = "KmsEcdhCtx";

    @Packed
    private String alias;

    @Packed
    private int newKeyAlg;

    @Packed
    private String newKeyAlias;

    @Packed
    private String peerKey;

    public String getAlias() {
        return this.alias;
    }

    public int getNewKeyAlg() {
        return this.newKeyAlg;
    }

    public String getNewKeyAlias() {
        return this.newKeyAlias;
    }

    public String getPeerKey() {
        return this.peerKey;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setNewKeyAlg(int i10) {
        this.newKeyAlg = i10;
    }

    public void setNewKeyAlias(String str) {
        this.newKeyAlias = str;
    }

    public void setPeerKey(String str) {
        this.peerKey = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alias", this.alias);
            jSONObject.put("peerKey", this.peerKey);
            jSONObject.put("newKeyAlias", this.newKeyAlias);
            jSONObject.put("newKeyAlg", this.newKeyAlg);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "KmsEcdhCtx toJson failed.");
        }
        return jSONObject.toString();
    }
}
