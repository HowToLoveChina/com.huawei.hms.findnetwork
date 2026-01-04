package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class SilenceDurationBean {

    @SerializedName("endTime")
    private String endTime;

    @SerializedName("startTime")
    private String startTime;

    public String getEndTime() {
        return this.endTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }
}
