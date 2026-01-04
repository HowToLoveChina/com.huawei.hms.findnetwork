package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.support.api.entity.safetydetect.base.BaseResp;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class VerifyAppsCheckEnabledResp extends BaseResp {
    private boolean result;

    public VerifyAppsCheckEnabledResp(String str) {
        this.result = new JSONObject(str).optBoolean("result");
    }

    public boolean getResult() {
        return this.result;
    }

    public void setResult(boolean z10) {
        this.result = z10;
    }
}
