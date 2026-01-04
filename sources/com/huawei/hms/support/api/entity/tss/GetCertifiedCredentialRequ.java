package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetCertifiedCredentialRequ extends BaseRequ {
    private static final String TAG = "GetCertifiedCredentialRequ";

    @Packed
    private int credentialsVersion;

    public int getCredentialsVersion() {
        return this.credentialsVersion;
    }

    public void setCredentialsVersion(int i10) {
        this.credentialsVersion = i10;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("credentialsVersion", this.credentialsVersion);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "toJson failed");
        }
        return jSONObject.toString();
    }
}
