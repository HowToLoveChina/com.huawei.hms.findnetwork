package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetPublicKeyResp extends BaseResp {
    private String publicKey;

    public GetPublicKeyResp(String str) throws JSONException {
        this.publicKey = new JSONObject(str).getString("publicKey");
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    public String toString() {
        return "GetPublicKeyResp{publicKey=" + this.publicKey + '}';
    }
}
