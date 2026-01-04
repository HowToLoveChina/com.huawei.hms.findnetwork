package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.support.api.entity.tss.base.BaseResp;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetKeyVersionResp extends BaseResp {
    private static final String TAG = "GetKeyVersionResp";
    private int componentVersion;
    private int soVersion;

    public GetKeyVersionResp(String str) throws JSONException {
        this.componentVersion = -1;
        this.soVersion = -1;
        JSONObject jSONObject = new JSONObject(str);
        this.componentVersion = jSONObject.getInt("componentVersion");
        this.soVersion = jSONObject.getInt("soVersion");
    }

    public int getComponentVersion() {
        return this.componentVersion;
    }

    public int getSoVersion() {
        return this.soVersion;
    }

    public void setComponentVersion(int i10) {
        this.componentVersion = i10;
    }

    public void setSoVersion(int i10) {
        this.soVersion = i10;
    }
}
