package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class EcdhResp extends BaseResp {
    private String ecdhKey;

    public EcdhResp(String str) throws JSONException {
        this.ecdhKey = new JSONObject(str).optString("ecdhKey");
    }

    public String getEcdhKey() {
        return this.ecdhKey;
    }

    public void setEcdhKey(String str) {
        this.ecdhKey = str;
    }

    public String toString() {
        return "EcdhResp{ecdhKey=" + this.ecdhKey + '}';
    }
}
