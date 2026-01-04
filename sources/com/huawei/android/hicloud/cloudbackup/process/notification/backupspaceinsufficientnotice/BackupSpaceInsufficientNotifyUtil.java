package com.huawei.android.hicloud.cloudbackup.process.notification.backupspaceinsufficientnotice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.BackupNotEnoughDlgInfo;
import com.huawei.android.hicloud.cloudbackup.bean.BackupNotEnoughDlgSpInfo;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupNotificationActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupDetailStateActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.hicloud.task.simple.C3033g;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.hicloud.router.R$string;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import gp.C10028c;
import id.C10471e;
import java.util.Random;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p514o9.C11839m;
import p571q9.C12295b;
import p616rk.C12515a;
import p620rp.InterfaceC12614b;
import p711vl.C13464d;
import p778xk.C13823d;

/* loaded from: classes2.dex */
public class BackupSpaceInsufficientNotifyUtil {
    private static final String TAG = "BackupSpaceInsufficientNotifyUtil";
    public static final int USER_TYPE_INCENTIVE = 1;
    public static final int USER_TYPE_NORMAL = 0;
    public static final int USER_TYPE_TASK = 4;

    public class SpaceInsufficientScreenStateListener implements ScreenListener.ScreenStateListener {
        private C12295b backupNoticeNeedInfo;
        private boolean isAutoBackup;
        private BackupSpaceNotEnoughNeedData mBackupSpaceNotEnoughNeedData;
        private Context mContext;
        private BaseSpaceNotifyBean notification;

        public SpaceInsufficientScreenStateListener(Context context, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, boolean z10, BaseSpaceNotifyBean baseSpaceNotifyBean) {
            this.mBackupSpaceNotEnoughNeedData = backupSpaceNotEnoughNeedData;
            this.backupNoticeNeedInfo = c12295b;
            this.isAutoBackup = z10;
            this.notification = baseSpaceNotifyBean;
            this.mContext = context;
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOff() {
            C11839m.m70688i(BackupSpaceInsufficientNotifyUtil.TAG, "SpaceScreenStateListener onScreenOff, isAutoBackup: " + this.isAutoBackup);
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOn() {
            C11839m.m70688i(BackupSpaceInsufficientNotifyUtil.TAG, "SpaceScreenStateListener screenOn, isAutoBackup: " + this.isAutoBackup);
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onUserPresent() {
            C11839m.m70688i(BackupSpaceInsufficientNotifyUtil.TAG, "SpaceScreenStateListener onUserPresent, isAutoBackup: " + this.isAutoBackup);
            if (C0209d.m1265i1(this.mContext) || BackupSpaceInsufficientNotifyUtil.this.isBackupForeground() || C0209d.m1245d1(this.mContext, MainActivity.class.getName())) {
                NotificationReportUtil.reportCloudBackupNoSpace("0001", "0018");
                C12515a.m75110o().m75175e(new C3033g(this.mContext, this.mBackupSpaceNotEnoughNeedData, this.backupNoticeNeedInfo, this.isAutoBackup, this.notification), true);
                return;
            }
            C11839m.m70688i(BackupSpaceInsufficientNotifyUtil.TAG, "start BackupFailCheckTimer");
            NotificationReportUtil.reportCloudBackupNoSpace("0001", "0019");
            C10471e.m64359p(this.mContext).cancel();
            C10471e.m64359p(this.mContext).m64349m(false);
            C10471e.m64359p(this.mContext).m64348l(this.mBackupSpaceNotEnoughNeedData);
            C10471e.m64359p(this.mContext).m64347k(this.backupNoticeNeedInfo);
            C10471e.m64359p(this.mContext).m64346j(this.isAutoBackup);
            C10471e.m64359p(this.mContext).m64361q(this.notification);
            C12515a.m75110o().m75175e(C10471e.m64359p(this.mContext), true);
            ScreenListener.m18023c(this.mContext).m18028g();
        }
    }

    private BackupNotEnoughDlgInfo buildDlgInfo(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, int i10, boolean z10) {
        BackupNotEnoughDlgInfo backupNotEnoughDlgInfo = new BackupNotEnoughDlgInfo();
        backupNotEnoughDlgInfo.setmBackupSpaceNotEnoughNeedData(backupSpaceNotEnoughNeedData);
        backupNotEnoughDlgInfo.setNeedInfo(c12295b);
        backupNotEnoughDlgInfo.setTimeStamp(System.currentTimeMillis());
        backupNotEnoughDlgInfo.setNotifyType(i10);
        backupNotEnoughDlgInfo.setAutoBackup(z10);
        return backupNotEnoughDlgInfo;
    }

    private String getAutoBackupDlgInfo(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, int i10, boolean z10, BaseSpaceNotifyBean baseSpaceNotifyBean) {
        BackupNotEnoughDlgInfo backupNotEnoughDlgInfoBuildDlgInfo = buildDlgInfo(backupSpaceNotEnoughNeedData, c12295b, i10, z10);
        backupNotEnoughDlgInfoBuildDlgInfo.setBaseSpaceNotifyBean(baseSpaceNotifyBean);
        return new Gson().toJson(backupNotEnoughDlgInfoBuildDlgInfo);
    }

    private int getAutoBackupDlgTaskId() {
        return new Random().nextInt(10000) + 1;
    }

    private boolean isShowBackupSpaceNotEnoughDlg() {
        Context contextM1377a = C0213f.m1377a();
        return C0209d.m1265i1(contextM1377a) || isBackupForeground() || C0209d.m1245d1(contextM1377a, MainActivity.class.getName());
    }

    private Intent setTypeApplicationIntent(Context context, Intent intent, String str) {
        if (NotifyConstants.BUY_MORE.equals(str)) {
            intent.setClass(context, CloudSpaceUpgradeActivity.class);
            intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
        } else if (NotifyConstants.HICLOUD_DLAPP.equals(str)) {
            getDlAppWebViewIntent(context, intent);
        } else if (NotifyConstants.HICLOUD_CENTER.equals(str)) {
            String strM82923g = C13823d.m82904y().m82923g(11);
            if (!TextUtils.isEmpty(strM82923g)) {
                intent.setData(Uri.parse(strM82923g));
            }
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            intent.setAction("android.intent.action.VIEW");
        } else {
            Class<?> cls = NotifyConstants.getGotoAppMapping().get(str);
            if (cls == null) {
                C11839m.m70687e(TAG, "no uri match, return null, uri is: " + str);
                return null;
            }
            intent.setClass(context, cls);
            intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        }
        return intent;
    }

    public void execBackupSpaceInsuffFailNotify(Context context, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, BaseSpaceNotifyBean baseSpaceNotifyBean) {
        C11839m.m70688i(TAG, "execBackupSpaceInsuffFailNotify");
        if (backupSpaceNotEnoughNeedData == null) {
            C11839m.m70687e(TAG, "execBackupSpaceInsuffFailNotify backupSpaceNotEnoughNeedData is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, BackupNotificationActivity.class);
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        intent.putExtra(NotifyConstants.BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY, backupSpaceNotEnoughNeedData);
        intent.putExtra("backup_space_not_enough_need_info_key", c12295b);
        intent.putExtra("backup_space_not_enough_notification_key", new Gson().toJson(baseSpaceNotifyBean));
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        context.startActivity(intent);
        try {
            InterfaceC12614b.get().clearConfigurable(BackupNotEnoughDlgSpInfo.class);
            if (TextUtils.isEmpty(C10028c.m62183d0(C0213f.m1377a()).m62398u())) {
                return;
            }
            C10028c.m62183d0(C0213f.m1377a()).m62239L1("");
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "clear DlgDelayInfo error, " + e10.toString());
        }
    }

    public Intent getDlAppWebViewIntent(Context context, Intent intent) {
        intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
        intent.putExtra("no_need_param", true);
        intent.putExtra("title", context.getString(R$string.HiCloud_app_name));
        intent.putExtra("isEnableJs", true);
        intent.putExtra("launch_web_type", 2);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
        return intent;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.Intent getGotoPopup(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.notification.backupspaceinsufficientnotice.BackupSpaceInsufficientNotifyUtil.getGotoPopup(android.content.Context, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    public String getNotificationReportScreenPresentChcekType(int i10) {
        return i10 != 1 ? i10 != 4 ? NotifyConstants.NotificationReport.VALUE_BACKUP_SCREEN_PRESENT_CHECK : NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_TASK_SCREEN_PRESENT_CHECK : NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_SCREEN_PRESENT_CHECK;
    }

    public String getNotificationReportTimerType(int i10) {
        return i10 != 1 ? i10 != 4 ? NotifyConstants.NotificationReport.VALUE_BACKUP_CHECK_TIMER : NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_TASK_CHECK_TIMER : NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_CHECK_TIMER;
    }

    public int getPopUpDialogType(int i10) {
        if (i10 != 1) {
            return i10 != 4 ? 1 : 3;
        }
        return 2;
    }

    public boolean isAutoBackupDlgCheckTaskExecuteNow() {
        if (((BackupNotEnoughDlgSpInfo) InterfaceC12614b.get().getConfigurable(BackupNotEnoughDlgSpInfo.class)) == null) {
            C11839m.m70688i(TAG, "backupNotEnoughDlgSpInfo is null");
            return false;
        }
        saveFrequencyControlInfo(C0213f.m1377a(), "autoBackupDlgCheckResult", true);
        C11839m.m70688i(TAG, "isAutoBackupDlgCheckTaskExecuteNow get backupNotEnoughDlgSpInfo success");
        if (isShowBackupSpaceNotEnoughDlg()) {
            C11839m.m70688i(TAG, "isShowBackupSpaceNotEnoughDlg is true");
            return true;
        }
        C11839m.m70688i(TAG, "isShowBackupSpaceNotEnoughDlg is false");
        return false;
    }

    public boolean isBackupForeground() {
        return C0209d.m1245d1(C0213f.m1377a(), BackupMainActivity.class.getName()) || C0209d.m1245d1(C0213f.m1377a(), CloudBackupDetailStateActivity.class.getName());
    }

    public void recordDialogShowFrequency(Context context) {
        C0212e0.m1370t(context, FrequencyManager.CHECKBACKUPFAILNOTIFYSP, FrequencyManager.CHECKBACKUPFAILDIALOGTIME, System.currentTimeMillis());
    }

    public void saveFrequencyControlInfo(Context context, String str, boolean z10) {
        C13464d.m81030f(context).m81045p(str, z10);
    }

    public void setSpaceInsufficientScreenListener(Context context, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, BaseSpaceNotifyBean baseSpaceNotifyBean) {
        c12295b.m73872I(getAutoBackupDlgTaskId());
        String autoBackupDlgInfo = getAutoBackupDlgInfo(backupSpaceNotEnoughNeedData, c12295b, getPopUpDialogType(baseSpaceNotifyBean.getActivityType()), true, baseSpaceNotifyBean);
        ScreenListener.m18023c(context).m18025b(new SpaceInsufficientScreenStateListener(context, backupSpaceNotEnoughNeedData, c12295b, true, baseSpaceNotifyBean));
        if (!TextUtils.isEmpty(C10028c.m62183d0(context).m62398u())) {
            C10028c.m62183d0(context).m62239L1("");
        }
        try {
            C10028c.m62183d0(context).m62239L1(autoBackupDlgInfo);
            BackupNotEnoughDlgSpInfo backupNotEnoughDlgSpInfo = new BackupNotEnoughDlgSpInfo();
            backupNotEnoughDlgSpInfo.setJsonInfo(autoBackupDlgInfo);
            InterfaceC12614b.get().saveConfigurable(BackupNotEnoughDlgSpInfo.class, backupNotEnoughDlgSpInfo);
        } catch (Throwable th2) {
            C11839m.m70687e(TAG, "saveBackupFailPopupDelayInfo error, " + th2.toString());
            NotificationReportUtil.reportCloudBackupNoSpaceWithInfo("0001", "0021", th2.toString());
        }
    }
}
