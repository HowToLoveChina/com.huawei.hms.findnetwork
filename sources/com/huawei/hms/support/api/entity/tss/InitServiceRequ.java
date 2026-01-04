package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class InitServiceRequ extends BaseRequ {
    private static final String TAG = "InitServiceRequ";
    private String permission;

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String str) {
        this.permission = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("permission", this.permission);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "toJson failed");
        }
        return jSONObject.toString();
    }
}
