package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class ReportCampaignResp extends Response {
    private String campaignName;
    private CampaignStatus campaignStatus;

    public String getCampaignName() {
        return this.campaignName;
    }

    public CampaignStatus getCampaignStatus() {
        return this.campaignStatus;
    }

    public void setCampaignName(String str) {
        this.campaignName = str;
    }

    public void setCampaignStatus(CampaignStatus campaignStatus) {
        this.campaignStatus = campaignStatus;
    }
}
