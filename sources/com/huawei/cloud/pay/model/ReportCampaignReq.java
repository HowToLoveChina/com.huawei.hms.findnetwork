package com.huawei.cloud.pay.model;

import java.util.Map;

/* loaded from: classes5.dex */
public class ReportCampaignReq extends Request {
    private Map<String, String> campaignInfo;

    public ReportCampaignReq(Map<String, String> map) {
        super("reportCampaign");
        this.campaignInfo = map;
    }

    public Map<String, String> getCampaignInfo() {
        return this.campaignInfo;
    }

    public void setCampaignInfo(Map<String, String> map) {
        this.campaignInfo = map;
    }
}
