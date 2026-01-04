package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.support.api.entity.safetydetect.base.BaseResp;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SysIntegrityResp extends BaseResp {
    private String result;

    public SysIntegrityResp() {
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public SysIntegrityResp(String str) {
        this.result = new JSONObject(str).optString("jwsResult");
    }
}
