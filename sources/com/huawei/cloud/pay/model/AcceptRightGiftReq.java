package com.huawei.cloud.pay.model;

import java.util.Map;

/* loaded from: classes5.dex */
public class AcceptRightGiftReq extends Request {
    private Map<String, String> campaignInfo;

    public AcceptRightGiftReq(Map<String, String> map) {
        super("acceptRightGift");
        this.campaignInfo = map;
    }

    public Map<String, String> getCampaignInfo() {
        return this.campaignInfo;
    }

    public void setCampaignInfo(Map<String, String> map) {
        this.campaignInfo = map;
    }
}
