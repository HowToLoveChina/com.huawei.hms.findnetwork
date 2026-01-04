package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SupportMkRequ extends BaseRequ {
    private static final String TAG = "SupportMkRequ";

    public String toJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("caller", str);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "SupportMkRequ toJson failed");
        }
        return jSONObject.toString();
    }
}
