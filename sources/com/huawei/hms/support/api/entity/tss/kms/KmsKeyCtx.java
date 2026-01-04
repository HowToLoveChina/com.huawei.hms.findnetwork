package com.huawei.hms.support.api.entity.tss.kms;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class KmsKeyCtx {
    private static final String TAG = "KmsKeyCtx";

    @Packed
    private String alias;

    @Packed
    private int keyAlg;

    @Packed
    private int keyLen;

    @Packed
    private KeyProperty keyProperty;

    @Packed
    private int storeType;

    public String getAlias() {
        return this.alias;
    }

    public int getKeyAlg() {
        return this.keyAlg;
    }

    public int getKeyLen() {
        return this.keyLen;
    }

    public KeyProperty getKeyProperty() {
        return this.keyProperty;
    }

    public int getStoreType() {
        return this.storeType;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setKeyAlg(int i10) {
        this.keyAlg = i10;
    }

    public void setKeyLen(int i10) {
        this.keyLen = i10;
    }

    public void setKeyProperty(KeyProperty keyProperty) {
        this.keyProperty = keyProperty;
    }

    public void setStoreType(int i10) {
        this.storeType = i10;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alias", this.alias);
            jSONObject.put("storeType", this.storeType);
            jSONObject.put("keyAlg", this.keyAlg);
            jSONObject.put("keyLen", this.keyLen);
            if (this.keyProperty == null) {
                KeyProperty keyProperty = new KeyProperty();
                this.keyProperty = keyProperty;
                keyProperty.setDeviceSyned(false);
            }
            jSONObject.put("keyProperty", this.keyProperty.toJson());
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "KmsKeyCtx toJson failed.");
        }
        return jSONObject.toString();
    }
}
