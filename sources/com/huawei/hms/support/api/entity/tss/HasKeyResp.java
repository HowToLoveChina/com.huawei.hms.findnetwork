package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class HasKeyResp extends BaseResp {
    private boolean hasKey;

    public HasKeyResp(String str) throws JSONException {
        this.hasKey = new JSONObject(str).getBoolean("hasKey");
    }

    public boolean isHasKey() {
        return this.hasKey;
    }

    public void setHasKey(boolean z10) {
        this.hasKey = z10;
    }

    public String toString() {
        return "HasKeyResp{hasKey=" + this.hasKey + '}';
    }
}
