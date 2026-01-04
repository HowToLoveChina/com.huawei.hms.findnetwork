package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes6.dex */
public class ForcedUpgradeNotifyConfig {

    @SerializedName(CallLogCons.DATE)
    private String date;

    @SerializedName("notifications")
    private ForcedUpgradeNotifications[] notification;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private UpgradeConfigLanguage upgradeConfigLanguage;

    @SerializedName("version")
    private String version;

    public String getDate() {
        return this.date;
    }

    public ForcedUpgradeNotifications[] getNotification() {
        ForcedUpgradeNotifications[] forcedUpgradeNotificationsArr = this.notification;
        return forcedUpgradeNotificationsArr != null ? (ForcedUpgradeNotifications[]) forcedUpgradeNotificationsArr.clone() : new ForcedUpgradeNotifications[0];
    }

    public UpgradeConfigLanguage getUpgradeConfigLanguage() {
        return this.upgradeConfigLanguage;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setNotification(ForcedUpgradeNotifications[] forcedUpgradeNotificationsArr) {
        if (forcedUpgradeNotificationsArr != null) {
            this.notification = (ForcedUpgradeNotifications[]) forcedUpgradeNotificationsArr.clone();
        } else {
            this.notification = null;
        }
    }

    public void setUpgradeConfigLanguage(UpgradeConfigLanguage upgradeConfigLanguage) {
        this.upgradeConfigLanguage = upgradeConfigLanguage;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
