package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetActivityEntryRequest extends Request {
    private int campaignSource;
    private UserTags tags;

    public GetActivityEntryRequest(UserTags userTags, int i10) {
        super("getActivityEntry");
        this.campaignSource = i10;
        this.tags = userTags;
    }

    public int getCampaignSource() {
        return this.campaignSource;
    }

    public UserTags getTags() {
        return this.tags;
    }

    public void setCampaignSource(int i10) {
        this.campaignSource = i10;
    }

    public void setTags(UserTags userTags) {
        this.tags = userTags;
    }
}
