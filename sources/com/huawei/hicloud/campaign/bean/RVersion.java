package com.huawei.hicloud.campaign.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class RVersion {

    @SerializedName("max")
    private String max;

    @SerializedName("min")
    private String min;

    public String getMax() {
        return this.max;
    }

    public String getMin() {
        return this.min;
    }

    public void setMax(String str) {
        this.max = str;
    }

    public void setMin(String str) {
        this.min = str;
    }
}
