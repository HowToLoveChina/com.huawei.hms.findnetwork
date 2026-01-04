package com.huawei.cloud.pay.model;

import com.google.gson.Gson;

/* loaded from: classes5.dex */
public class CampaignConfigInfo {
    private String adId;
    private String cId;
    private String cType;
    private CampaignStatus campaignStatus;

    public String getAdId() {
        return this.adId;
    }

    public CampaignStatus getCampaignStatus() {
        return this.campaignStatus;
    }

    public String getcId() {
        return this.cId;
    }

    public String getcType() {
        return this.cType;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setCampaignStatus(CampaignStatus campaignStatus) {
        this.campaignStatus = campaignStatus;
    }

    public void setcId(String str) {
        this.cId = str;
    }

    public void setcType(String str) {
        this.cType = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
