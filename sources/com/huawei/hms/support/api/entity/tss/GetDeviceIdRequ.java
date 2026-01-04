package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetDeviceIdRequ extends BaseRequ {
    private static final String TAG = "GetDeviceIdRequ";

    @Packed
    private String imei;

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", this.imei);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "GetDeviceIdRequ toJson failed");
        }
        return jSONObject.toString();
    }
}
