package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetTaVersionResp extends BaseResp {

    @Packed
    private int version;

    public GetTaVersionResp(String str) throws JSONException {
        this.version = new JSONObject(str).getInt("version");
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i10) {
        this.version = i10;
    }

    public String toString() {
        return super.toString() + ", version: " + this.version;
    }
}
