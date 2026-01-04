package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class KeyExportResp extends BaseResp {
    private String keyData;

    public KeyExportResp(String str) throws JSONException {
        this.keyData = new JSONObject(str).getString("keyData");
    }

    public String getKeyData() {
        return this.keyData;
    }

    public void setKeyData(String str) {
        this.keyData = str;
    }

    public String toString() {
        return "GetPublicKeyResp{keyData=" + this.keyData + '}';
    }
}
