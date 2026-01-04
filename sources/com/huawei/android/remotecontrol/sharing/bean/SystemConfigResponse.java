package com.huawei.android.remotecontrol.sharing.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.remotecontrol.http.BaseResponse;

/* loaded from: classes4.dex */
public class SystemConfigResponse extends BaseResponse {

    @SerializedName("params")
    private SystemConfig params;

    public SystemConfigResponse(int i10, String str) {
        super(i10, str);
    }

    public SystemConfig getParams() {
        return this.params;
    }

    public void setParams(SystemConfig systemConfig) {
        this.params = systemConfig;
    }
}
