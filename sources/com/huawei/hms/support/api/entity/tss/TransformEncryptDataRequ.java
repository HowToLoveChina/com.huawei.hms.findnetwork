package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class TransformEncryptDataRequ extends BaseRequ {
    private static final String TAG = "TransformEncryptDataRequ";

    @Packed
    private String alias;

    @Packed
    private String decryptAlgo;

    @Packed
    private String encryptAlgo;

    /* renamed from: iv */
    @Packed
    private String f29803iv;

    @Packed
    private String secret;

    @Packed
    private String tmpKey;

    public String getAlias() {
        return this.alias;
    }

    public String getDecryptAlgo() {
        return this.decryptAlgo;
    }

    public String getEncryptAlgo() {
        return this.encryptAlgo;
    }

    public String getIv() {
        return this.f29803iv;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getTmpKey() {
        return this.tmpKey;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setDecryptAlgo(String str) {
        this.decryptAlgo = str;
    }

    public void setEncryptAlgo(String str) {
        this.encryptAlgo = str;
    }

    public void setIv(String str) {
        this.f29803iv = str;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public void setTmpKey(String str) {
        this.tmpKey = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("decryptAlgo", this.decryptAlgo);
            jSONObject.put("encryptAlgo", this.encryptAlgo);
            jSONObject.put("alias", this.alias);
            jSONObject.put("secret", this.secret);
            jSONObject.put("iv", this.f29803iv);
            jSONObject.put("tmpKey", this.tmpKey);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "toJson failed");
        }
        return jSONObject.toString();
    }
}
