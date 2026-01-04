package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.util.NotifyUtil;

/* loaded from: classes6.dex */
public class UpgradeNoticeContent {

    @SerializedName("dayonce")
    private float frequency;

    @SerializedName("limit_times")
    private int limitTimes;

    @SerializedName("goto")
    private UpgradeJumpObject upgradeJumpObject;

    @SerializedName(NotifyUtil.MAIN_TEXT_TYPE_DEFAULT)
    private String upgradeNoticeText;

    @SerializedName("title")
    private String upgradeNoticetitle;

    public float getFrequency() {
        return this.frequency;
    }

    public int getLimitTimes() {
        return this.limitTimes;
    }

    public UpgradeJumpObject getUpgradeJumpObject() {
        return this.upgradeJumpObject;
    }

    public String getUpgradeNoticeText() {
        return this.upgradeNoticeText;
    }

    public String getUpgradeNoticetitle() {
        return this.upgradeNoticetitle;
    }

    public void setFrequency(float f10) {
        this.frequency = f10;
    }

    public void setLimitTimes(int i10) {
        this.limitTimes = i10;
    }

    public void setUpgradeJumpObject(UpgradeJumpObject upgradeJumpObject) {
        this.upgradeJumpObject = upgradeJumpObject;
    }

    public void setUpgradeNoticeText(String str) {
        this.upgradeNoticeText = str;
    }

    public void setUpgradeNoticetitle(String str) {
        this.upgradeNoticetitle = str;
    }
}
