package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.constant.Constants;

/* loaded from: classes6.dex */
public class BannerSpacePositionConfigActivity {

    @SerializedName("activityId")
    private String activityId;

    @SerializedName("activityType")
    private String activityType;

    @SerializedName(Constants.AUTOCONTENT_CATEGORY)
    private String category;

    @SerializedName("fixed")
    private boolean fixed;

    @SerializedName("priority")
    private int priority;

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityType() {
        return this.activityType;
    }

    public String getCategory() {
        return this.category;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean isFixed() {
        return this.fixed;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityType(String str) {
        this.activityType = str;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setFixed(boolean z10) {
        this.fixed = z10;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }
}
