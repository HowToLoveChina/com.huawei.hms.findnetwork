package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class ChannelInfo {
    private String activityCode;
    private String salChannel;
    private String srcAppId;
    private String srcChannel;

    public ChannelInfo() {
    }

    public String getActivityCode() {
        return this.activityCode;
    }

    public String getSalChannel() {
        return this.salChannel;
    }

    public String getSrcAppId() {
        return this.srcAppId;
    }

    public String getSrcChannel() {
        return this.srcChannel;
    }

    public void setActivityCode(String str) {
        this.activityCode = str;
    }

    public void setSalChannel(String str) {
        this.salChannel = str;
    }

    public void setSrcAppId(String str) {
        this.srcAppId = str;
    }

    public void setSrcChannel(String str) {
        this.srcChannel = str;
    }

    public String toString() {
        return "ChannelInfo{srcAppId='" + this.srcAppId + "', srcChannel='" + this.srcChannel + "', salChannel='" + this.salChannel + "', activityCode='" + this.activityCode + "'}";
    }

    public ChannelInfo(String str, String str2, String str3, String str4) {
        this.srcAppId = str;
        this.srcChannel = str2;
        this.salChannel = str3;
        this.activityCode = str4;
    }
}
