package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SupportKmsResp extends BaseResp {
    private boolean isSupportKms;

    public SupportKmsResp() {
    }

    public boolean isSupportKms() {
        return this.isSupportKms;
    }

    public void setSupportKms(boolean z10) {
        this.isSupportKms = z10;
    }

    public String toString() {
        return "SupportKmsResp{isSupportKms=" + this.isSupportKms + '}';
    }

    public SupportKmsResp(String str) throws JSONException {
        this.isSupportKms = new JSONObject(str).getBoolean("isSupportKms");
    }
}
