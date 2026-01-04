package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class AcceptSignGiftReq extends Request {
    private CampaignInfo campaignInfo;
    private long hmsVer;
    private int signMode;

    public AcceptSignGiftReq(String str, CampaignInfo campaignInfo, int i10, long j10) {
        super(str);
        this.campaignInfo = campaignInfo;
        this.signMode = i10;
        this.hmsVer = j10;
    }

    public CampaignInfo getCampaignInfo() {
        return this.campaignInfo;
    }

    public long getHmsVer() {
        return this.hmsVer;
    }

    public int getSignMode() {
        return this.signMode;
    }

    public void setCampaignInfo(CampaignInfo campaignInfo) {
        this.campaignInfo = campaignInfo;
    }

    public void setHmsVer(long j10) {
        this.hmsVer = j10;
    }

    public void setSignMode(int i10) {
        this.signMode = i10;
    }
}
