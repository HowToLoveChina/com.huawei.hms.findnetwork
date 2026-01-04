package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class CommonStringResp extends BaseResp {

    @Packed
    private String result;

    public CommonStringResp(String str) throws JSONException {
        this.result = new JSONObject(str).getString("result");
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
