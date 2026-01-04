package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SupportMkResp extends BaseResp {
    private boolean isSupportMk;

    public SupportMkResp(String str) throws JSONException {
        this.isSupportMk = new JSONObject(str).getBoolean("isSupportMk");
    }

    public boolean isSupportMk() {
        return this.isSupportMk;
    }

    public void setSupportMk(boolean z10) {
        this.isSupportMk = z10;
    }

    public String toString() {
        return "SupportMkResp{isSupportMk=" + this.isSupportMk + '}';
    }
}
