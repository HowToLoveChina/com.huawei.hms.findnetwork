package com.huawei.hms.support.api.entity.tss.kms;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class KeyProperty {
    private static final String TAG = "KeyProperty";

    @Packed
    private boolean isDeviceSyned;

    public boolean isDeviceSyned() {
        return this.isDeviceSyned;
    }

    public void setDeviceSyned(boolean z10) {
        this.isDeviceSyned = z10;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isDeviceSyned", this.isDeviceSyned);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "KeyProperty toJson failed.");
        }
        return jSONObject.toString();
    }
}
