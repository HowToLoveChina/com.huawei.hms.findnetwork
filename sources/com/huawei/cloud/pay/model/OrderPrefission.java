package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class OrderPrefission {
    private String activityCode;
    private String activityName;
    private Integer activitySource;
    private OrderPrefissionQuest quest;

    public String getActivityCode() {
        return this.activityCode;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public Integer getActivitySource() {
        return this.activitySource;
    }

    public OrderPrefissionQuest getQuest() {
        return this.quest;
    }

    public void setActivityCode(String str) {
        this.activityCode = str;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public void setActivitySource(Integer num) {
        this.activitySource = num;
    }

    public void setQuest(OrderPrefissionQuest orderPrefissionQuest) {
        this.quest = orderPrefissionQuest;
    }
}
