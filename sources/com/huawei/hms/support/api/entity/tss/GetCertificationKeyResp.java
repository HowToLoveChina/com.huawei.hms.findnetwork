package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetCertificationKeyResp extends BaseResp {
    private String rawCredential;

    public GetCertificationKeyResp(String str) throws JSONException {
        this.rawCredential = new JSONObject(str).getString("rawCredential");
    }

    public String getRawCredential() {
        return this.rawCredential;
    }

    public void setRawCredential(String str) {
        this.rawCredential = str;
    }

    public String toString() {
        return "GetCertificationKeyResp{rawCredential=" + this.rawCredential + '}';
    }
}
