package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class ForcedUpgradeNotifications {
    private static final String TAG = "ForcedUpgradeNotifications";

    /* renamed from: id */
    @SerializedName("id")
    private int f22646id;

    @SerializedName("notify_mode")
    private String[] notifyModes;

    @SerializedName("priority")
    private int priority;

    @SerializedName("upgrade_action")
    private int upgradeAction;

    @SerializedName("detail_content")
    private UpgradeDetailContent upgradeDetailContent;

    @SerializedName("notice_content")
    private UpgradeNoticeContent upgradeNoticeContent;

    @SerializedName("pop_content")
    private UpgradePopContent upgradePopContent;

    @SerializedName("upgrade_type")
    private int upgradeType;

    @SerializedName("upgrade_version")
    private UpgradeVersionConfig upgradeVersionConfig;

    public int getId() {
        return this.f22646id;
    }

    public String[] getNotifyModes() {
        String[] strArr = this.notifyModes;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public int getPriority() {
        return this.priority;
    }

    public int getUpgradeAction() {
        return this.upgradeAction;
    }

    public UpgradeDetailContent getUpgradeDetailContent() {
        return this.upgradeDetailContent;
    }

    public UpgradeNoticeContent getUpgradeNoticeContent() {
        return this.upgradeNoticeContent;
    }

    public UpgradePopContent getUpgradePopContent() {
        return this.upgradePopContent;
    }

    public int getUpgradeType() {
        return this.upgradeType;
    }

    public UpgradeVersionConfig getUpgradeVersionConfig() {
        return this.upgradeVersionConfig;
    }

    public void setId(int i10) {
        this.f22646id = i10;
    }

    public void setNotifyModes(String[] strArr) {
        if (strArr != null) {
            this.notifyModes = (String[]) strArr.clone();
        } else {
            this.notifyModes = null;
        }
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setUpgradeAction(int i10) {
        this.upgradeAction = i10;
    }

    public void setUpgradeDetailContent(UpgradeDetailContent upgradeDetailContent) {
        this.upgradeDetailContent = upgradeDetailContent;
    }

    public void setUpgradeNoticeContent(UpgradeNoticeContent upgradeNoticeContent) {
        this.upgradeNoticeContent = upgradeNoticeContent;
    }

    public void setUpgradePopContent(UpgradePopContent upgradePopContent) {
        this.upgradePopContent = upgradePopContent;
    }

    public void setUpgradeType(int i10) {
        this.upgradeType = i10;
    }

    public void setUpgradeVersionConfig(UpgradeVersionConfig upgradeVersionConfig) {
        this.upgradeVersionConfig = upgradeVersionConfig;
    }
}
