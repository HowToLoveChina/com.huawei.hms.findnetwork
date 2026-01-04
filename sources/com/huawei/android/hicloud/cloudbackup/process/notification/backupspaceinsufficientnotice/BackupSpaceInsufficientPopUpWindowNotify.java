package com.huawei.android.hicloud.cloudbackup.process.notification.backupspaceinsufficientnotice;

import android.content.Context;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.manager.NoticeFreqControlManager;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import p015ak.C0209d;
import p015ak.C0213f;
import p457ln.C11321f;
import p514o9.C11839m;
import p571q9.C12295b;

/* loaded from: classes2.dex */
public class BackupSpaceInsufficientPopUpWindowNotify extends C11321f {
    private static final int DIALOG_DEFAULT_BUTTON_NUM = 2;
    private static final String TAG = "BackupSpaceInsufficientPopUpWindowNotify";
    private boolean autoBackup;
    private C12295b backupNoticeNeedInfo;
    private BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData;
    private String gradeCode;
    private BaseSpaceNotifyBean notification;
    private Context mContext = C0213f.m1377a();
    private BackupSpaceInsufficientNotifyUtil notifyUtil = new BackupSpaceInsufficientNotifyUtil();

    public BackupSpaceInsufficientPopUpWindowNotify(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, BaseSpaceNotifyBean baseSpaceNotifyBean, C12295b c12295b) {
        this.autoBackup = c12295b.m73875c();
        this.backupSpaceNotEnoughNeedData = backupSpaceNotEnoughNeedData;
        this.notification = baseSpaceNotifyBean;
        this.backupNoticeNeedInfo = c12295b;
        this.gradeCode = c12295b.m73880h();
    }

    private void execIncentiveAutoBackupFailNotify(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, BaseSpaceNotifyBean baseSpaceNotifyBean) {
        C11839m.m70688i(TAG, "execIncentiveAutoBackupFailNotify, type = " + baseSpaceNotifyBean.getActivityType());
        if (C0209d.m1265i1(this.mContext) || this.notifyUtil.isBackupForeground() || C0209d.m1245d1(this.mContext, MainActivity.class.getName())) {
            this.notifyUtil.execBackupSpaceInsuffFailNotify(this.mContext, backupSpaceNotEnoughNeedData, c12295b, baseSpaceNotifyBean);
        } else {
            this.notifyUtil.setSpaceInsufficientScreenListener(this.mContext, backupSpaceNotEnoughNeedData, c12295b, baseSpaceNotifyBean);
        }
    }

    private void execNormalAutoBackupFailNotify(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, BaseSpaceNotifyBean baseSpaceNotifyBean) {
        C11839m.m70688i(TAG, "execNormalAutoBackupFailNotify, type = " + baseSpaceNotifyBean.getActivityType());
        if (C0209d.m1265i1(this.mContext) || this.notifyUtil.isBackupForeground() || C0209d.m1245d1(this.mContext, MainActivity.class.getName())) {
            this.notifyUtil.execBackupSpaceInsuffFailNotify(this.mContext, backupSpaceNotEnoughNeedData, c12295b, baseSpaceNotifyBean);
        } else {
            this.notifyUtil.setSpaceInsufficientScreenListener(this.mContext, backupSpaceNotEnoughNeedData, c12295b, baseSpaceNotifyBean);
        }
    }

    public boolean isSupportBackupSpaceInsufficientNewPopup() {
        if (this.notification == null) {
            return false;
        }
        C11839m.m70688i(TAG, "isSupportBackupNotEnoughSpaceNewPopup: " + this.notification.getEnableNewCard());
        return this.notification.getEnableNewCard() == 2;
    }

    @Override // p457ln.C11321f, p457ln.InterfaceC11317b
    public void sendNotify() {
        if (!isSupportBackupSpaceInsufficientNewPopup()) {
            C11839m.m70688i(TAG, "no support new popup window");
            return;
        }
        int activityType = this.notification.getActivityType();
        this.backupNoticeNeedInfo.m73873J(2);
        this.backupNoticeNeedInfo.m73896y(this.notification.getEnableNewCard());
        this.backupNoticeNeedInfo.m73865B(this.gradeCode);
        this.backupNoticeNeedInfo.m73892u(this.autoBackup);
        if (activityType == 0) {
            execNormalAutoBackupFailNotify(this.backupSpaceNotEnoughNeedData, this.backupNoticeNeedInfo, this.notification);
        } else if (activityType == 1 || activityType == 4) {
            execIncentiveAutoBackupFailNotify(this.backupSpaceNotEnoughNeedData, this.backupNoticeNeedInfo, this.notification);
        }
        if (this.autoBackup) {
            this.notifyUtil.recordDialogShowFrequency(C0213f.m1377a());
            NoticeFreqControlManager.getInstance().recordLevelNoticeShow(this.notification.getRemindPurposes(), "desk_popup");
        }
    }
}
