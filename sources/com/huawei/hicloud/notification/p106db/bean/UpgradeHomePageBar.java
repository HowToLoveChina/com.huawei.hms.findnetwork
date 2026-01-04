package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.bean.NotifyJumpInfo;

/* loaded from: classes6.dex */
public class UpgradeHomePageBar {

    @SerializedName("homepageButton")
    private String homepageButton;

    @SerializedName("homepageText")
    private String homepageText;

    @SerializedName("homepageTitle")
    private String homepageTitle;

    @SerializedName("goto")
    private NotifyJumpInfo notifyJumpInfo;

    public String getHomepageButton() {
        return this.homepageButton;
    }

    public String getHomepageText() {
        return this.homepageText;
    }

    public String getHomepageTitle() {
        return this.homepageTitle;
    }

    public NotifyJumpInfo getNotifyJumpInfo() {
        return this.notifyJumpInfo;
    }

    public void setHomepageButton(String str) {
        this.homepageButton = str;
    }

    public void setHomepageText(String str) {
        this.homepageText = str;
    }

    public void setHomepageTitle(String str) {
        this.homepageTitle = str;
    }

    public void setNotifyJumpInfo(NotifyJumpInfo notifyJumpInfo) {
        this.notifyJumpInfo = notifyJumpInfo;
    }
}
