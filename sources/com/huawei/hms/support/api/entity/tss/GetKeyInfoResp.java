package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetKeyInfoResp extends BaseResp {
    private String keyCtx;

    public GetKeyInfoResp(String str) throws JSONException {
        this.keyCtx = new JSONObject(str).getString("keyCtx");
    }

    public String getKeyCtx() {
        return this.keyCtx;
    }

    public void setKeyCtx(String str) {
        this.keyCtx = str;
    }

    public String toString() {
        return "GetKeyInfoResp{keyCtx=" + this.keyCtx + '}';
    }
}
