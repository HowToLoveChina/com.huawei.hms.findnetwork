package com.huawei.hms.support.api.entity.tss.base;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class KmsBaseRequ extends BaseRequ {
    private static final String TAG = "KmsBaseRequ";

    @Packed
    public String alias;

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public String toJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alias", this.alias);
            jSONObject.put("caller", str);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "KmsBaseRequ toJson failed");
        }
        return jSONObject.toString();
    }
}
