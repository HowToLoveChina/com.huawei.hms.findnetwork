package com.huawei.hicloud.cloudbackup.server.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class QueryDeviceDeleteSwitchResp extends BaseResponse {

    @SerializedName("switch")
    private int clearSwitch;

    @SerializedName("clearTime")
    private int clearTime;

    public int getClearSwitch() {
        return this.clearSwitch;
    }

    public int getClearTime() {
        return this.clearTime;
    }

    public void setClearSwitch(int i10) {
        this.clearSwitch = i10;
    }

    public void setClearTime(int i10) {
        this.clearTime = i10;
    }
}
