package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class AppHistoryBean {
    public static final int STATUS_SHOW = 1;

    @SerializedName("appId")
    private String appId;

    @SerializedName("status")
    private int status;

    @SerializedName("time")
    private long time;

    public AppHistoryBean(String str, int i10, long j10) {
        this.appId = str;
        this.status = i10;
        this.time = j10;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTime() {
        return this.time;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setTime(long j10) {
        this.time = j10;
    }

    public AppHistoryBean() {
    }
}
