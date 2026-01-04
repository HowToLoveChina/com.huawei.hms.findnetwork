package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class DeeplinkRoute {

    @SerializedName("activityCode")
    private String activityCode;

    @SerializedName("params")
    private String params;

    @SerializedName("params2")
    private String paramsSec;

    @SerializedName("path")
    private String path;
    private String[] referrerPackage;

    @SerializedName("salChannel")
    private String salChannel;

    @SerializedName("srcChannel")
    private String srcChannel;
    private String[] startupSourceId;

    public String getActivityCode() {
        return this.activityCode;
    }

    public String getParams() {
        return this.params;
    }

    public String getParamsSec() {
        return this.paramsSec;
    }

    public String getPath() {
        return this.path;
    }

    public String[] getReferrerPackage() {
        return this.referrerPackage;
    }

    public String getSalChannel() {
        return this.salChannel;
    }

    public String getSrcChannel() {
        return this.srcChannel;
    }

    public String[] getStartupSourceId() {
        return this.startupSourceId;
    }

    public void setActivityCode(String str) {
        this.activityCode = str;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setParamsSec(String str) {
        this.paramsSec = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setReferrerPackage(String[] strArr) {
        this.referrerPackage = strArr;
    }

    public void setSalChannel(String str) {
        this.salChannel = str;
    }

    public void setSrcChannel(String str) {
        this.srcChannel = str;
    }

    public void setStartupSourceId(String[] strArr) {
        this.startupSourceId = strArr;
    }
}
