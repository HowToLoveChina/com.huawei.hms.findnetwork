package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class MonthPayReq extends Request {
    private int scheme;
    private String subscriptionId;

    public MonthPayReq(String str) {
        super(str);
    }

    public int getScheme() {
        return this.scheme;
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public void setScheme(int i10) {
        this.scheme = i10;
    }

    public void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }
}
