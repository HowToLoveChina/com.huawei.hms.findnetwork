package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class H5SpaceFullDialogInfo {

    @SerializedName("h5Url")
    private String h5Url;

    @SerializedName("period")
    private String period;

    public String getH5Url() {
        return this.h5Url;
    }

    public String getPeriod() {
        return this.period;
    }

    public void setH5Url(String str) {
        this.h5Url = str;
    }

    public void setPeriod(String str) {
        this.period = str;
    }
}
