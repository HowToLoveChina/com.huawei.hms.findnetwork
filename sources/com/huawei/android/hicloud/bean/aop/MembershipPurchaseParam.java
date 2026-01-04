package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class MembershipPurchaseParam {

    @SerializedName("campaignId")
    private String campaignId;

    @SerializedName("encryptedExtInfo")
    private String encryptedExtInfo;

    @SerializedName("extendInfo")
    private String extendInfo;

    @SerializedName("pageId")
    private String pageId;

    public String getCampaignId() {
        return this.campaignId;
    }

    public String getEncryptedExtInfo() {
        return this.encryptedExtInfo;
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }

    public String getPageId() {
        return this.pageId;
    }

    public void setCampaignId(String str) {
        this.campaignId = str;
    }

    public void setEncryptedExtInfo(String str) {
        this.encryptedExtInfo = str;
    }

    public void setExtendInfo(String str) {
        this.extendInfo = str;
    }

    public void setPageId(String str) {
        this.pageId = str;
    }
}
