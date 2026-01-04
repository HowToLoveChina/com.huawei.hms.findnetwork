package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetCertificationKeyRequ extends BaseRequ {
    private static final String TAG = "GetCertificationKeyRequ";

    @Packed
    private String dataKey;

    @Packed
    private String kek;

    @Packed
    private String secretKey;

    public String getDataKey() {
        return this.dataKey;
    }

    public String getKek() {
        return this.kek;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public void setDataKey(String str) {
        this.dataKey = str;
    }

    public void setKek(String str) {
        this.kek = str;
    }

    public void setSecretKey(String str) {
        this.secretKey = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("secretKey", this.secretKey);
            jSONObject.put("dataKey", this.dataKey);
            jSONObject.put("kek", this.kek);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "toJson failed");
        }
        return jSONObject.toString();
    }
}
