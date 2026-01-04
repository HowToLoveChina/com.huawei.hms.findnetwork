package com.huawei.android.hicloud.p088ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupDetailStateActivity;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.temporarybackup.C4012a;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupSelectSpaceView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0223k;
import p015ak.C0226l0;
import p015ak.C0238w;
import p015ak.C0241z;
import p495nm.C11731l;
import p514o9.C11839m;
import p514o9.C11841o;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p618rm.C12600v1;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13462b;
import tl.C13029h;

/* loaded from: classes3.dex */
public class BackupNotification {
    private static final String ACTION_SERVICE_NOTIFICATION = "com.huawei.hicloud.cloudbackup.service.notification";
    public static final String CANCEL_NOTIFICATION_ID = "cancel_notification_id";
    public static final String FROM_NOTIFICATION = "from_notification";
    public static final String IS_COMPLETE = "is_complete";
    public static final String KEY_IS_FOREGROUND = "isForeground";
    public static final String NEED_CHECK_GRADE = "need_check_grade";
    private static final int PER_PROGRESS = 1;
    private static final long PROGRESS_DURATION = 2000;
    private static final String TAG = "BackupNotification";
    private boolean isCloseNotification;
    private String lastEventId;
    private float lastProgress;
    private long lastSendProgressTime;
    private NotificationManager mManager;
    private BackupNotificationManager mNotifyManager;

    public static class Holder {
        private static final BackupNotification INSTANCE = new BackupNotification();

        private Holder() {
        }
    }

    private NotificationCompat.Builder buildNotification(String str, String str2, PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        Resources resources = getContext().getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        NotificationCompat.Builder builderM1669j = C0238w.m1663f().m1669j(getContext(), str);
        builderM1669j.m3824y(R$drawable.logo_about_system).m3825z(new NotificationCompat.C0605b()).m3799B(getContext().getResources().getString(i10)).m3811l(str).m3810k(str2).m3809j(pendingIntent).m3815p(bundle).m3817r("com.huawei.android.hicloud.cloudbackup").m3823x(true).m3800C(System.currentTimeMillis());
        return builderM1669j;
    }

    private String getContentTitle(C13029h c13029h, boolean z10) {
        String string = getContext().getString(R$string.backup_failed_notification_content);
        int iM1685c = c13029h != null ? C0241z.m1685c(c13029h.m78474q().replace("001_", "")) : 0;
        if (iM1685c == 3001) {
            return z10 ? getContext().getString(R$string.temp_backup_notification_pause_not_enough) : string;
        }
        switch (iM1685c) {
            case 1034:
                return getContext().getString(R$string.backup_failed_sdcard_error);
            case 1035:
                C11731l c11731lM70010h = C11731l.m70010h(c13029h.m78484v());
                return c11731lM70010h != null ? getContext().getString(R$string.backup_failed_file_read_error_notify, C12590s0.m75903t(C12590s0.m75770M(getContext(), c11731lM70010h.m70012b()))) : string;
            case 1036:
                return getContext().getString(R$string.cloud_backup_no_data);
            default:
                return string;
        }
    }

    private Context getContext() {
        return C0213f.m1377a();
    }

    public static BackupNotification getInstance() {
        return Holder.INSTANCE;
    }

    private PendingIntent getPendingIntentToDetail(String str, boolean z10, boolean z11, String str2) {
        Intent intent = new Intent();
        setJumpClass(intent, z11, C12591s1.m75931a().m75941k());
        intent.putExtra(KEY_IS_FOREGROUND, z10);
        intent.putExtra("entry_source", "entry_backup_notify");
        intent.putExtra("notify_type", str);
        intent.putExtra(FROM_NOTIFICATION, true);
        intent.putExtra(NEED_CHECK_GRADE, true);
        C0216g0.m1402e(getContext()).m1408F(intent, str2);
        return C0209d.m1248e0(getContext(), 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    private PendingIntent getPendingIntentToMHWRefurbish() {
        C11839m.m70688i(TAG, "buildPrepareNotification: getPendingIntentToMHWRefurbish");
        Intent intent = new Intent();
        intent.setAction("com.huawei.phoneservice.renovation.notification");
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        intent.putExtra("IntentSource", "cloudbackup");
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager != null && intent.resolveActivity(packageManager) != null) {
            return C0209d.m1248e0(getContext(), 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        }
        C11839m.m70687e(TAG, "buildPrepareNotification: packageManager is null");
        return getPendingIntentToMain("backup_prepare_notify_click_record");
    }

    private PendingIntent getPendingIntentToMain(String str) {
        Intent intent = new Intent();
        intent.setClass(getContext(), BackupMainActivity.class);
        intent.putExtra("entry_source", "entry_backup_notify");
        intent.putExtra("notify_type", str);
        C0216g0.m1402e(getContext()).m1408F(intent, "SOURCE_ID_BACKUP_PREPARE_DATA_NOTIFY");
        return C0209d.m1248e0(getContext(), 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    private PendingIntent getPendingIntentToTempActivity(Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        C11839m.m70688i(TAG, "getPendingIntentToTempActivity");
        intent.setClass(getContext(), CloudBackupDetailStateActivity.class);
        intent.putExtra("isTempBackup", true);
        intent.putExtra("entry_source", "entry_backup_notify");
        intent.putExtra(FROM_NOTIFICATION, true);
        return C0209d.m1248e0(getContext(), 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendBackupFailedNotification$0() {
        C11841o.m70707c(getContext(), R$string.cloud_backup_no_data, 0);
    }

    private void reportNotification(String str) {
        if (TextUtils.isEmpty(this.lastEventId) || !this.lastEventId.equals(str)) {
            this.lastEventId = str;
            C13225d.m79490f1().m79585f0(str, C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", str, "4", "78");
        }
    }

    private void setJumpClass(Intent intent, boolean z10, boolean z11) {
        if (intent != null) {
            boolean zM80791C0 = C13452e.m80781L().m80791C0();
            C11839m.m70686d(TAG, "getPendingIntentToDetail isRefurbishing " + z11 + " isBasicServer " + zM80791C0);
            if (zM80791C0) {
                intent.setClass(getContext(), BackupMainActivity.class);
                return;
            }
            if (z11) {
                intent.setClass(getContext(), CloudBackupDetailStateActivity.class);
            } else if (z10) {
                intent.setClass(getContext(), CloudBackupDetailStateActivity.class);
            } else {
                intent.setClass(getContext(), BackupMainActivity.class);
            }
        }
    }

    private void startNotificationService(boolean z10) {
        C11839m.m70688i(TAG, "startNotificationService");
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction(ACTION_SERVICE_NOTIFICATION);
        intent.putExtra(KEY_IS_FOREGROUND, z10);
        getContext().startService(intent);
    }

    public Notification buildPrepareNotification() {
        boolean zM75940j = C12591s1.m75931a().m75940j();
        C11839m.m70688i(TAG, "buildPrepareNotification: isRefurbish = " + zM75940j);
        String string = getContext().getString(R$string.main_cloudbackuping);
        String string2 = getContext().getString(R$string.backup_preparing_notification_content);
        PendingIntent pendingIntentToMHWRefurbish = zM75940j ? getPendingIntentToMHWRefurbish() : getPendingIntentToMain("backup_prepare_notify_click_record");
        if (C12600v1.m76047c().m76054e()) {
            pendingIntentToMHWRefurbish = getPendingIntentToTempActivity(null);
        }
        return buildNotification(string, string2, pendingIntentToMHWRefurbish).m3807h(false).m3819t(true).m3804d();
    }

    public void cancelBackupNotification() {
        C11839m.m70688i(TAG, " cancelBackupNotification ");
        this.isCloseNotification = true;
        this.mNotifyManager.cancelNotification(26);
        this.mNotifyManager.cancelNotification(306);
        this.mNotifyManager.cancelNotification(273);
        this.mNotifyManager.cancelNotify(775);
        stopNotificationService();
    }

    public void cancelBackupNotificationById(int i10) {
        C11839m.m70688i(TAG, "cancelBackupNotificationById = " + i10);
        if (i10 != -1) {
            this.mNotifyManager.cancelNotification(i10);
        }
    }

    public void sendBackupCompletedNotification(long j10, boolean z10) throws Resources.NotFoundException {
        C11839m.m70688i(TAG, "sendBackupCompletedNotification:");
        String string = getContext().getString(R$string.backup_completed_notification_title);
        PendingIntent pendingIntentToDetail = getPendingIntentToDetail("backup_complete_notify_click_record", false, true, "SOURCE_ID_BACKUP_COMPLETE_NOTIFY");
        String quantityString = !C13452e.m80781L().m80887a1() ? String.format(getContext().getString(R$string.backup_completed_notification_content), C0223k.m1524g(getContext(), j10)) : null;
        if (z10) {
            string = getContext().getString(R$string.temp_backup_action_bar_title);
            if (C12600v1.m76047c().m76053d() == TempBackupSelectSpaceView.EnumC4011b.SPACE_TYPE_USER_SPACE && C13452e.m80781L().m80907e1()) {
                quantityString = getContext().getString(R$string.temp_backup_notification_completed_vip);
            } else {
                int i10 = C12600v1.f57994d + C12600v1.f57996f;
                quantityString = getContext().getResources().getQuantityString(R$plurals.temp_backup_notification_complete, i10, Integer.valueOf(i10));
            }
            Intent intent = new Intent();
            intent.putExtra(IS_COMPLETE, true);
            pendingIntentToDetail = getPendingIntentToTempActivity(intent);
        }
        this.mManager.notify(26, buildNotification(string, quantityString, pendingIntentToDetail).m3807h(true).m3819t(true).m3804d());
        startNotificationService(false);
        reportNotification("backup_complete_notify_record");
    }

    public void sendBackupFailedNotification(boolean z10, boolean z11, C13029h c13029h, boolean z12) {
        PendingIntent pendingIntentToDetail;
        C11839m.m70688i(TAG, "sendBackupFailedNotification:");
        if (this.isCloseNotification) {
            C11839m.m70688i(TAG, "sendBackupFailedNotification: isCloseNotification return");
            return;
        }
        String string = getContext().getString(R$string.backup_failed_notification_title);
        String contentTitle = getContentTitle(c13029h, z12);
        if (c13029h == null || C0241z.m1685c(c13029h.m78474q().replace("001_", "")) != 1036) {
            pendingIntentToDetail = getPendingIntentToDetail("backup_incomplete_notify_click_record", false, z11, "SOURCE_ID_BACKUP_FAIL_NOTIFY");
        } else {
            C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.ui.notification.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18354a.lambda$sendBackupFailedNotification$0();
                }
            });
            string = getContext().getString(R$string.backup_completed_notification_title);
            pendingIntentToDetail = getPendingIntentToMain("backup_incomplete_notify_click_record");
            if (C12600v1.m76047c().m76054e()) {
                string = getContext().getString(R$string.temp_backup_action_bar_title);
                contentTitle = C12600v1.m76047c().m76053d() == TempBackupSelectSpaceView.EnumC4011b.SPACE_TYPE_USER_SPACE ? getContext().getString(R$string.temp_backup_notification_completed_vip) : getContext().getResources().getQuantityString(R$plurals.temp_backup_notification_complete, 30, 30);
            }
        }
        if (C12600v1.m76047c().m76054e()) {
            pendingIntentToDetail = getPendingIntentToTempActivity(null);
        }
        this.mManager.notify(26, buildNotification(string, contentTitle, pendingIntentToDetail).m3807h(true).m3819t(!z10).m3804d());
        startNotificationService(false);
        reportNotification("backup_incomplete_notify_record");
    }

    public void sendBackupPrepareNotification() {
        C11839m.m70688i(TAG, "sendBackupPrepareNotification:");
        this.lastProgress = -1.0f;
        this.isCloseNotification = false;
        this.mManager.notify(26, buildPrepareNotification());
        startNotificationService(true);
        reportNotification("backup_prepare_notify_record");
    }

    public void sendBackupProgressNotification(float f10) {
        String string;
        String str;
        C11839m.m70686d(TAG, "sendBackupProgressNotification");
        if (f10 - this.lastProgress > 1.0f || System.currentTimeMillis() - this.lastSendProgressTime > 2000) {
            this.lastSendProgressTime = System.currentTimeMillis();
            this.lastProgress = f10;
            if (C0209d.m1253f1()) {
                string = getContext().getString(R$string.main_cloudbackuping);
                str = String.format(getContext().getString(R$string.restore_new_completed_part), C0209d.m1236b0(C2783d.m16071A(f10)));
            } else {
                string = String.format(getContext().getString(R$string.backup_progress_notification_title), C0209d.m1236b0(C2783d.m16071A(f10)));
                str = "";
            }
            PendingIntent pendingIntentToDetail = getPendingIntentToDetail("backing_up_notify_click_record", true, true, "SOURCE_ID_BACKUP_PROGRESS_NOTIFY");
            if (C12600v1.m76047c().m76054e()) {
                pendingIntentToDetail = getPendingIntentToTempActivity(null);
            }
            this.mManager.notify(26, buildNotification(string, str, pendingIntentToDetail).m3822w(100, (int) f10, false).m3807h(false).m3819t(true).m3804d());
            reportNotification("backing_up_notify_record");
        }
    }

    public boolean sendFirstBackupCompletedNotification(String str, String str2) {
        C11839m.m70688i(TAG, "sendFirstBackupCompletedNotification start");
        Context context = getContext();
        if (context == null) {
            return false;
        }
        cancelBackupNotification();
        Intent intent = new Intent();
        intent.setClass(context, CloudSpaceUpgradeActivity.class);
        intent.putExtra("from_where", 17);
        intent.putExtra(KEY_IS_FOREGROUND, false);
        intent.putExtra(FROM_NOTIFICATION, true);
        intent.putExtra("notify_cancel_manual", true);
        intent.putExtra("notify_id", 787);
        intent.putExtra("entry_source", "entry_backup_notify");
        intent.putExtra("notify_type", "subscribe_first_backup_success_notify_click");
        C0216g0.m1402e(getContext()).m1408F(intent, "SOURCE_ID_FIRST_BACKUP");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(getContext(), 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        String strM24662s = C4012a.m24662s(str, context.getString(R$string.subscribe_backup_success_notify_title_new), new Object[0]);
        String strM24662s2 = C4012a.m24662s(str2, context.getString(R$string.subscribe_backup_success_notify_content_new), new Object[0]);
        this.mManager.notify(787, buildNotification(strM24662s, strM24662s2, pendingIntentM1248e0).m3807h(true).m3819t(true).m3801a(0, context.getString(R$string.cloudpay_subscribe_now), pendingIntentM1248e0).m3804d());
        C13462b.m81015c().m81020f("hasSentBackupNotify", true);
        RestoreUtil.reportBackupSubscribeNotify("subscribe_first_backup_success_notify", "firstBackup");
        C11839m.m70688i(TAG, "sendFirstBackupCompletedNotification end");
        return true;
    }

    public void sendTempPauseNotification(boolean z10) {
        C11839m.m70688i(TAG, "sendTempPauseNotification:");
        if (this.isCloseNotification) {
            C11839m.m70688i(TAG, "sendTempPauseNotification: isCloseNotification return");
            return;
        }
        this.mManager.notify(26, buildNotification(getContext().getString(R$string.temp_backup_action_bar_title), getContext().getString(R$string.temp_backup_notification_pause_normal), getPendingIntentToTempActivity(null)).m3807h(true).m3819t(!z10).m3804d());
        startNotificationService(false);
        reportNotification("backup_incomplete_notify_record");
    }

    public void stopNotificationService() {
        C11839m.m70688i(TAG, "stopNotificationService");
        Intent intent = new Intent();
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setAction(ACTION_SERVICE_NOTIFICATION);
        getContext().stopService(intent);
    }

    private BackupNotification() {
        this.lastEventId = "";
        this.lastProgress = -1.0f;
        this.isCloseNotification = false;
        this.mManager = (NotificationManager) getContext().getSystemService("notification");
        this.mNotifyManager = new BackupNotificationManager(getContext());
    }
}
