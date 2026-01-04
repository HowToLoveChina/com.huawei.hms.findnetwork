package com.huawei.android.remotecontrol.sharing.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class PerDeviceSummary {

    @SerializedName("deviceName")
    private String deviceName;

    @SerializedName("iconUrl")
    private String iconUrl;

    @SerializedName("perDeviceType")
    private String perDeviceType;

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getPerDeviceType() {
        return this.perDeviceType;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setPerDeviceType(String str) {
        this.perDeviceType = str;
    }
}
