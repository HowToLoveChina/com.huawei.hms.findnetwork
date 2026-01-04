package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class GetRecommendActivityReq extends Request {
    private List<Integer> activityTypeList;
    private int campaignSource;

    public GetRecommendActivityReq(List<Integer> list, int i10) {
        super("getRecommendActivity");
        this.activityTypeList = list;
        this.campaignSource = i10;
    }

    public List<Integer> getActivityTypeList() {
        return this.activityTypeList;
    }

    public int getCampaignSource() {
        return this.campaignSource;
    }

    public void setActivityTypeList(List<Integer> list) {
        this.activityTypeList = list;
    }

    public void setCampaignSource(int i10) {
        this.campaignSource = i10;
    }
}
