package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;

/* loaded from: classes6.dex */
public class HicloudPushGuidPopConfig {

    @SerializedName("activityType")
    private String activityType;

    @SerializedName("giftPackageMode")
    private String giftPackageMode;

    @SerializedName(SyncProtocol.Constant.GUID)
    private String guid;

    @SerializedName("mainText")
    private String mainText;

    @SerializedName("maxPopTimes")
    private String maxPopTimes;

    @SerializedName("packageDesc")
    private String packageDesc;

    @SerializedName("restable")
    private String restable;

    @SerializedName("title")
    private String title;

    public String getActivityType() {
        return this.activityType;
    }

    public String getGiftPackageMode() {
        return this.giftPackageMode;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getMainText() {
        return this.mainText;
    }

    public String getMaxPopTimes() {
        return this.maxPopTimes;
    }

    public String getPackageDesc() {
        return this.packageDesc;
    }

    public String getRestable() {
        return this.restable;
    }

    public String getTitle() {
        return this.title;
    }

    public void setActivityType(String str) {
        this.activityType = str;
    }

    public void setGiftPackageMode(String str) {
        this.giftPackageMode = str;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setMainText(String str) {
        this.mainText = str;
    }

    public void setMaxPopTimes(String str) {
        this.maxPopTimes = str;
    }

    public void setPackageDesc(String str) {
        this.packageDesc = str;
    }

    public void setRestable(String str) {
        this.restable = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
