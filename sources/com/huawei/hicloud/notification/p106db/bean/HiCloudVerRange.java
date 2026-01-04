package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class HiCloudVerRange {

    @SerializedName("beginVer")
    private String beginVer;

    @SerializedName("endVer")
    private String endVer;

    public String getBeginVer() {
        return this.beginVer;
    }

    public String getEndVer() {
        return this.endVer;
    }

    public void setBeginVer(String str) {
        this.beginVer = str;
    }

    public void setEndVer(String str) {
        this.endVer = str;
    }
}
