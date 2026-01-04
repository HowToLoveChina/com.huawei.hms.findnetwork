package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.util.NotifyUtil;

/* loaded from: classes6.dex */
public class UpgradePopContent {

    @SerializedName("dayonce")
    private float frequency;

    @SerializedName("limit_times")
    private int limitTimes;

    @SerializedName("button1")
    private UpgradeFirstButton upgradeFirstButton;

    @SerializedName(NotifyUtil.MAIN_TEXT_TYPE_DEFAULT)
    private String upgradeNoticeText;

    @SerializedName("title")
    private String upgradeNoticetitle;

    @SerializedName("button2")
    private UpgradeSecondButton upgradeSecondButton;

    public float getFrequency() {
        return this.frequency;
    }

    public int getLimitTimes() {
        return this.limitTimes;
    }

    public UpgradeFirstButton getUpgradeFirstButton() {
        return this.upgradeFirstButton;
    }

    public String getUpgradeNoticeText() {
        return this.upgradeNoticeText;
    }

    public String getUpgradeNoticetitle() {
        return this.upgradeNoticetitle;
    }

    public UpgradeSecondButton getUpgradeSecondButton() {
        return this.upgradeSecondButton;
    }

    public void setFrequency(float f10) {
        this.frequency = f10;
    }

    public void setLimitTimes(int i10) {
        this.limitTimes = i10;
    }

    public void setUpgradeFirstButton(UpgradeFirstButton upgradeFirstButton) {
        this.upgradeFirstButton = upgradeFirstButton;
    }

    public void setUpgradeNoticeText(String str) {
        this.upgradeNoticeText = str;
    }

    public void setUpgradeNoticetitle(String str) {
        this.upgradeNoticetitle = str;
    }

    public void setUpgradeSecondButton(UpgradeSecondButton upgradeSecondButton) {
        this.upgradeSecondButton = upgradeSecondButton;
    }
}
