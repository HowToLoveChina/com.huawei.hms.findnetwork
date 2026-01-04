package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class QueryO2OActivityResp extends Response {
    private String activityLinkUrl;
    private int participateTimes;

    public String getActivityLinkUrl() {
        return this.activityLinkUrl;
    }

    public int getParticipateTimes() {
        return this.participateTimes;
    }

    public void setActivityLinkUrl(String str) {
        this.activityLinkUrl = str;
    }

    public void setParticipateTimes(int i10) {
        this.participateTimes = i10;
    }
}
