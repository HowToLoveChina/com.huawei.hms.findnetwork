package com.huawei.cloud.pay.model;

import java.util.Map;

/* loaded from: classes5.dex */
public class CheckCampStatusReq extends Request {
    private Map<String, String> campaignInfo;
    private int campaignSource;

    public CheckCampStatusReq(Map<String, String> map, int i10) {
        super("checkCampStatus");
        this.campaignInfo = map;
        this.campaignSource = i10;
    }

    public Map<String, String> getCampaignInfo() {
        return this.campaignInfo;
    }

    public int getCampaignSource() {
        return this.campaignSource;
    }

    public void setCampaignInfo(Map<String, String> map) {
        this.campaignInfo = map;
    }

    public void setCampaignSource(int i10) {
        this.campaignSource = i10;
    }
}
