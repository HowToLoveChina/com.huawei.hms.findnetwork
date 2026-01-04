package com.huawei.cloud.pay.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes5.dex */
public class GetRecommendActivityResp extends Response {

    @SerializedName("activityInfo")
    private PayActivityInfo mPayActivityInfo;

    public PayActivityInfo getPayActivityInfo() {
        return this.mPayActivityInfo;
    }

    public void setPayActivityInfo(PayActivityInfo payActivityInfo) {
        this.mPayActivityInfo = payActivityInfo;
    }
}
