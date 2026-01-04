package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetCertifiedCredentialResp extends BaseResp {
    private String credential;

    public GetCertifiedCredentialResp(String str) throws JSONException {
        this.credential = new JSONObject(str).getString("credential");
    }

    public String getCredential() {
        return this.credential;
    }

    public void setCredential(String str) {
        this.credential = str;
    }

    public String toString() {
        return "GetCertifiedCredentialResp{credential=" + this.credential + '}';
    }
}
