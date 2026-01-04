package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class CommonCard extends BaseCardBean {

    @SerializedName("activityId")
    private String activityId;

    @SerializedName("activityType")
    private String activityType;

    @SerializedName("basicConfig")
    private BasicConfig basicConfig;

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public BasicConfig getBasicConfig() {
        return this.basicConfig;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityType(String str) {
        this.activityType = str;
    }

    public void setBasicConfig(BasicConfig basicConfig) {
        this.basicConfig = basicConfig;
    }
}
