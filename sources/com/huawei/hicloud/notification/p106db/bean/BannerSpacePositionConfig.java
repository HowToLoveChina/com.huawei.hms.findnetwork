package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;

/* loaded from: classes6.dex */
public class BannerSpacePositionConfig {

    @SerializedName("activitys")
    private BannerSpacePositionConfigActivity[] activities;

    @SerializedName(NotifyConstants.TextLinkConst.ENTRANCE_KEY)
    private String entrance;

    @SerializedName("notifyBarDay")
    private int notifyBarDay;

    @SerializedName("notifyBarTimes")
    private int notifyBarTimes;

    @SerializedName("redDotDay")
    private int redDotDay;

    @SerializedName("redDotTimes")
    private int redDotTimes;

    public BannerSpacePositionConfigActivity[] getActivities() {
        return this.activities;
    }

    public String getEntrance() {
        return this.entrance;
    }

    public int getNotifyBarDay() {
        return this.notifyBarDay;
    }

    public int getNotifyBarTimes() {
        return this.notifyBarTimes;
    }

    public int getRedDotDay() {
        return this.redDotDay;
    }

    public int getRedDotTimes() {
        return this.redDotTimes;
    }

    public void setActivities(BannerSpacePositionConfigActivity[] bannerSpacePositionConfigActivityArr) {
        this.activities = bannerSpacePositionConfigActivityArr;
    }

    public void setEntrance(String str) {
        this.entrance = str;
    }

    public void setNotifyBarDay(int i10) {
        this.notifyBarDay = i10;
    }

    public void setNotifyBarTimes(int i10) {
        this.notifyBarTimes = i10;
    }

    public void setRedDotDay(int i10) {
        this.redDotDay = i10;
    }

    public void setRedDotTimes(int i10) {
        this.redDotTimes = i10;
    }
}
