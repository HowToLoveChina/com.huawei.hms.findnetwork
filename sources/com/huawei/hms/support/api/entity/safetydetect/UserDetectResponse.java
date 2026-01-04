package com.huawei.hms.support.api.entity.safetydetect;

import org.json.JSONObject;

/* loaded from: classes8.dex */
public class UserDetectResponse {
    private String responseToken;

    public UserDetectResponse(String str) {
        this.responseToken = new JSONObject(str).getString("responseToken");
    }

    public String getResponseToken() {
        return this.responseToken;
    }
}
