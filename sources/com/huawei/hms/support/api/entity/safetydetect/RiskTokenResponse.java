package com.huawei.hms.support.api.entity.safetydetect;

import org.json.JSONObject;

/* loaded from: classes8.dex */
public class RiskTokenResponse {
    private String riskToken;

    public RiskTokenResponse(String str) {
        this.riskToken = new JSONObject(str).getString("riskToken");
    }

    public String getRiskToken() {
        return this.riskToken;
    }
}
