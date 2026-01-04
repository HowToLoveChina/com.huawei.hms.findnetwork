package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetHuksTaAvailableResp extends BaseResp {
    private static final String TAG = "GetHuksTaAvailableResp";

    @Packed
    private boolean huksAvailable;

    public GetHuksTaAvailableResp(String str) throws JSONException {
        this.huksAvailable = false;
        this.huksAvailable = new JSONObject(str).getBoolean("huksAvailable");
    }

    public boolean isHuksAvailable() {
        return this.huksAvailable;
    }

    public void setHuksAvailable(boolean z10) {
        this.huksAvailable = z10;
    }

    public String toString() {
        return "GetHuksTaAvailableResp{huksAvailable=" + this.huksAvailable + '}';
    }
}
