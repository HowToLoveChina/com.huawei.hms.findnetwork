package com.huawei.android.hicloud.cloudbackup.bean;

import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.BackupSpaceInsuffNoticeV5Configuration;
import p571q9.C12295b;

/* loaded from: classes2.dex */
public class BackupNotEnoughDlgInfo {
    private BaseSpaceNotifyBean baseSpaceNotifyBean;
    private boolean isAutoBackup;
    private BackupSpaceNotEnoughNeedData mBackupSpaceNotEnoughNeedData;
    private C12295b needInfo;
    private NotEnoughDialogDataV5 notEnoughDialogDataV5;
    private SpaceNotification notification;
    private NotificationWithActivity notificationWithActivity;
    private int notifyType;
    private BackupSpaceInsuffNoticeV5Configuration spaceInsufficientV5;
    private long timeStamp;

    public BaseSpaceNotifyBean getBaseSpaceNotifyBean() {
        return this.baseSpaceNotifyBean;
    }

    public C12295b getNeedInfo() {
        return this.needInfo;
    }

    public NotEnoughDialogDataV5 getNotEnoughDialogDataV5() {
        return this.notEnoughDialogDataV5;
    }

    public SpaceNotification getNotification() {
        return this.notification;
    }

    public NotificationWithActivity getNotificationWithActivity() {
        return this.notificationWithActivity;
    }

    public int getNotifyType() {
        return this.notifyType;
    }

    public BackupSpaceInsuffNoticeV5Configuration getSpaceInsufficientV5() {
        return this.spaceInsufficientV5;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public BackupSpaceNotEnoughNeedData getmBackupSpaceNotEnoughNeedData() {
        return this.mBackupSpaceNotEnoughNeedData;
    }

    public boolean isAutoBackup() {
        return this.isAutoBackup;
    }

    public void setAutoBackup(boolean z10) {
        this.isAutoBackup = z10;
    }

    public void setBaseSpaceNotifyBean(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        this.baseSpaceNotifyBean = baseSpaceNotifyBean;
    }

    public void setNeedInfo(C12295b c12295b) {
        this.needInfo = c12295b;
    }

    public void setNotEnoughDialogDataV5(NotEnoughDialogDataV5 notEnoughDialogDataV5) {
        this.notEnoughDialogDataV5 = notEnoughDialogDataV5;
    }

    public void setNotification(SpaceNotification spaceNotification) {
        this.notification = spaceNotification;
    }

    public void setNotificationWithActivity(NotificationWithActivity notificationWithActivity) {
        this.notificationWithActivity = notificationWithActivity;
    }

    public void setNotifyType(int i10) {
        this.notifyType = i10;
    }

    public void setSpaceInsufficientV5(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        this.spaceInsufficientV5 = backupSpaceInsuffNoticeV5Configuration;
    }

    public void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }

    public void setmBackupSpaceNotEnoughNeedData(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        this.mBackupSpaceNotEnoughNeedData = backupSpaceNotEnoughNeedData;
    }
}
