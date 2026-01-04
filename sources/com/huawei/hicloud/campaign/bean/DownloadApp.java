package com.huawei.hicloud.campaign.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class DownloadApp {

    @SerializedName("adSlotId")
    private String adSlotId;

    @SerializedName("appSource")
    private String appSource;

    public String getAppSource() {
        return this.appSource;
    }

    public void setAppSource(String str) {
        this.appSource = str;
    }
}
