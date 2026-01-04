package com.huawei.hicloud.notification.config;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyConfig;
import java.util.List;

/* loaded from: classes6.dex */
public class CBPushNotificationObject {
    private String date;
    private CBPushConfigObject[] notification;
    private int priority;

    @SerializedName("notification_backup_restore")
    private List<RestoreNotifyConfig> restoreNotifyConfig;
    private String version;

    public String getDate() {
        return this.date;
    }

    public CBPushConfigObject[] getNotification() {
        CBPushConfigObject[] cBPushConfigObjectArr = this.notification;
        return cBPushConfigObjectArr != null ? (CBPushConfigObject[]) cBPushConfigObjectArr.clone() : new CBPushConfigObject[0];
    }

    public int getPriority() {
        return this.priority;
    }

    public List<RestoreNotifyConfig> getRestoreNotifyConfig() {
        return this.restoreNotifyConfig;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setNotification(CBPushConfigObject[] cBPushConfigObjectArr) {
        if (cBPushConfigObjectArr != null) {
            this.notification = (CBPushConfigObject[]) cBPushConfigObjectArr.clone();
        } else {
            this.notification = null;
        }
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
