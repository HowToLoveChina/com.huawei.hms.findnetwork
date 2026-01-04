package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class AopInfo {

    @SerializedName("campaignId")
    private String campaignId;

    @SerializedName("purchaseScene")
    private String purchaseScene;

    public String getCampaignId() {
        return this.campaignId;
    }

    public String getPurchaseScene() {
        return this.purchaseScene;
    }

    public void setCampaignId(String str) {
        this.campaignId = str;
    }

    public void setPurchaseScene(String str) {
        this.purchaseScene = str;
    }
}
