package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class UpgradeVersionConfig {

    @SerializedName("high")
    private String highestVersion;

    @SerializedName("low")
    private String lowestVersion;

    public String getHighestVersion() {
        return this.highestVersion;
    }

    public String getLowestVersion() {
        return this.lowestVersion;
    }

    public void setHighestVersion(String str) {
        this.highestVersion = str;
    }

    public void setLowestVersion(String str) {
        this.lowestVersion = str;
    }
}
