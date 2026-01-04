package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class ListRightGiftReq extends Request {
    private CampaignInfo campaignInfo;

    public ListRightGiftReq(CampaignInfo campaignInfo) {
        super("listRightGift");
        this.campaignInfo = campaignInfo;
    }

    public CampaignInfo getCampaignInfo() {
        return this.campaignInfo;
    }

    public void setCampaignInfo(CampaignInfo campaignInfo) {
        this.campaignInfo = campaignInfo;
    }
}
