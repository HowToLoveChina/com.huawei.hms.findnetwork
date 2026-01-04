package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class AppInfo {

    @SerializedName("agChannel")
    private String agChannel;

    @SerializedName("appVersionCode")
    private String appVersionCode;

    @SerializedName("appVersionName")
    private String appVersionName;

    @SerializedName("bundleName")
    private String bundleName;

    @SerializedName("extendInfo")
    private String extendInfo;

    public String getAgChannel() {
        return this.agChannel;
    }

    public String getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    public String getBundleName() {
        return this.bundleName;
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }

    public void setAgChannel(String str) {
        this.agChannel = str;
    }

    public void setAppVersionCode(String str) {
        this.appVersionCode = str;
    }

    public void setAppVersionName(String str) {
        this.appVersionName = str;
    }

    public void setBundleName(String str) {
        this.bundleName = str;
    }

    public void setExtendInfo(String str) {
        this.extendInfo = str;
    }
}
