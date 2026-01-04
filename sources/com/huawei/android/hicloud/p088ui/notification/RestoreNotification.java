package com.huawei.android.hicloud.p088ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.service.BackupRestoreControlService;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.OperationWebViewActivity;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import com.huawei.android.hicloud.p088ui.temporarybackup.C4012a;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.bean.FirstTimeOverview;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0224k0;
import p015ak.C0238w;
import p514o9.C11839m;
import p581qk.AbstractC12369f;
import p616rk.C12515a;
import p709vj.C13452e;
import p711vl.C13462b;

/* loaded from: classes3.dex */
public class RestoreNotification {
    private static final String GROUP_NAME_CLOUD_BACKUP = "com.huawei.android.hicloud.cloudbackup";
    private static final int NOTIFICATION_DEFAULT = 0;
    private static final int NOTIFICATION_RESTOREDEND = 2;
    private static final int NOTIFICATION_RESTORE_NET_ERR = 3;
    private static final int NOTIFICATION_RESTORING = 1;
    private static final String TAG = "RestoreLastNotification";
    private static BackupNotificationManager mNotifyManager;
    private static RestoreNotification notification = new RestoreNotification();
    private NotificationCompat.Builder builder;
    private boolean isRunning = false;
    private AbstractC12369f oobeCheckTask = new OOBECheckTask();
    private int status = 0;
    private boolean waitOOBEFinish = false;

    public class OOBECheckTask extends AbstractC12369f {
        private static final long PERIOD = 5;

        public OOBECheckTask() {
            super(0L, 5L);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            RestoreNotification.this.isRunning = true;
            if (RestoreNotification.this.inOOBE()) {
                return;
            }
            RestoreNotification.this.updateNotificationStatus();
            cancel();
            RestoreNotification.this.isRunning = false;
        }
    }

    private static Context getContext() {
        return C0213f.m1377a();
    }

    public static RestoreNotification getInstance() {
        mNotifyManager = new BackupNotificationManager(getContext());
        return notification;
    }

    private String getNetCauseTip() {
        return getContext().getString(R$string.notification_restore_pause);
    }

    private PendingIntent getPendingIntent(String str, boolean z10) {
        Context context = getContext();
        Intent intent = new Intent(context, (Class<?>) RestoreMainActivity.class);
        Bundle bundle = new Bundle();
        int iM80916g0 = C13452e.m80781L().m80916g0();
        bundle.putInt("current_status", 2);
        bundle.putInt("restore_status", iM80916g0);
        bundle.putBoolean("is_form_notification", true);
        bundle.putBoolean("isNewBmRecord", z10);
        intent.putExtras(bundle);
        C0216g0.m1402e(context).m1408F(intent, str);
        return C0209d.m1248e0(context, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    private PendingIntent getSubscribePendingIntentToDetail(Context context, String str, boolean z10) {
        Intent intent = new Intent(context, (Class<?>) OperationWebViewActivity.class);
        intent.putExtra("title", context.getString(R$string.HiCloud_app_name));
        intent.putExtra("url", str);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("launch_web_type", -1);
        intent.putExtra("notify_cancel_manual", true);
        intent.putExtra("notify_id", 788);
        intent.putExtra("entry_source", "entry_backup_notify");
        intent.putExtra("notify_type", "subscribe_restore_success_notify_click");
        intent.putExtra(BackupNotification.FROM_NOTIFICATION, true);
        C0216g0.m1402e(context).m1408F(intent, z10 ? "SOURCE_ID_OOBE_RESTORE" : "SOURCE_ID_RESTORE_SUCCESS");
        return C0209d.m1248e0(context, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    public boolean inOOBE() throws Settings.SettingNotFoundException {
        int i10;
        int i11;
        try {
            ContentResolver contentResolver = getContext().getContentResolver();
            i10 = Settings.Secure.getInt(contentResolver, C0224k0.f834b);
            i11 = Settings.Secure.getInt(contentResolver, "device_provisioned");
            C11839m.m70686d(TAG, "userSetupComplete = " + i10 + " ,deviceProvisioned = " + i11);
        } catch (Settings.SettingNotFoundException e10) {
            C11839m.m70687e(TAG, "deviceProvisioned not found error: " + e10.toString());
        }
        return (i10 == 1 && i11 == 1) ? false : true;
    }

    public synchronized void updateNotificationStatus() {
        try {
            C11839m.m70688i(TAG, "OOBE check over notification status = " + this.status);
            int i10 = this.status;
            if (i10 == 1) {
                sendRestoreNotification();
            } else if (i10 == 2) {
                completedNotification(C13452e.m80781L().m80911f0(), this.status);
            } else if (i10 == 3) {
                showNetErrNotification(C13452e.m80781L().m80911f0());
            }
            this.status = 0;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void cancelNotification() {
        C11839m.m70688i(TAG, " RestoreNotification cancelNotification ");
        this.status = 0;
        mNotifyManager.cancelNotification(23);
        this.builder = null;
        this.isRunning = false;
        AbstractC12369f abstractC12369f = this.oobeCheckTask;
        if (abstractC12369f != null) {
            abstractC12369f.cancel();
        }
    }

    public synchronized void completedNotification(float f10, int i10) {
        completedNotification(f10, i10, -1, RestoreUtil.isNewBmRecord());
    }

    public PendingIntent goOnService() {
        C11839m.m70688i(TAG, "resume all paused apks.");
        Intent intent = new Intent(getContext(), (Class<?>) BackupRestoreControlService.class);
        intent.putExtra(CommonNotifyReceiver.COMMAND_KEY, 5);
        getInstance().cancelNotification();
        return PendingIntent.getService(getContext(), 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    public synchronized boolean isNetErr() {
        return this.status == 3;
    }

    public void notifyRestore() {
        if (this.isRunning) {
            return;
        }
        C12515a.m75110o().m75172d(this.oobeCheckTask);
    }

    public synchronized void sendRestoreNotification() {
        C11839m.m70688i(TAG, "sendRestoreNotification start");
        this.status = 0;
        Context context = getContext();
        if (C0209d.m1173G1(context)) {
            C11839m.m70688i(TAG, "sendRestoreNotification, isPrivacyUser, now exit Cloud!");
            return;
        }
        PendingIntent pendingIntent = getPendingIntent("SOURCE_ID_BACKUP_RESTORING_NOTIFY", RestoreUtil.isNewBmRecord());
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", context.getResources().getString(R$string.backup_notification_title));
        this.builder = C0238w.m1663f().m1669j(context, GROUP_NAME_CLOUD_BACKUP);
        if (C0209d.m1253f1()) {
            this.builder.m3811l(context.getString(R$string.notification_restoring_data));
            this.builder.m3810k(String.format(getContext().getString(R$string.restore_new_completed_part), C0209d.m1236b0(C2783d.m16085H(0.0f))));
        } else {
            this.builder.m3811l(context.getString(R$string.restore_new_restoring_data));
        }
        this.builder.m3807h(false).m3819t(true);
        this.builder.m3824y(R$drawable.logo_about_system);
        this.builder.m3809j(pendingIntent).m3803c(bundle).m3822w(100, 0, false).m3818s(false).m3817r(GROUP_NAME_CLOUD_BACKUP).m3823x(false);
        Notification notificationM3804d = this.builder.m3804d();
        notificationM3804d.flags |= 32;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.cancel(25);
        notificationManager.notify(23, notificationM3804d);
        C11839m.m70688i(TAG, "sendRestoreNotification end ");
    }

    public synchronized boolean sendSubscribeRestoreSuccessNotification(FirstTimeOverview firstTimeOverview, boolean z10) {
        try {
            C11839m.m70688i(TAG, "sendSubscribeRestoreSuccessNotification start");
            Context context = getContext();
            if (context != null && firstTimeOverview != null) {
                String titleKey = firstTimeOverview.getTitleKey();
                String contentKey = firstTimeOverview.getContentKey();
                String url = firstTimeOverview.getUrl();
                String strM24662s = C4012a.m24662s(titleKey, context.getString(R$string.subscribe_restore_success_notify_title_new), new Object[0]);
                String strM24662s2 = C4012a.m24662s(contentKey, context.getString(R$string.subscribe_restore_success_notify_content_new), new Object[0]);
                PendingIntent subscribePendingIntentToDetail = getSubscribePendingIntentToDetail(context, url, z10);
                Bundle bundle = new Bundle();
                Resources resources = context.getResources();
                int i10 = R$string.HiCloud_app_name;
                bundle.putString("android.substName", resources.getString(i10));
                NotificationCompat.Builder builderM1669j = C0238w.m1663f().m1669j(context, strM24662s);
                builderM1669j.m3824y(R$drawable.logo_about_system).m3825z(new NotificationCompat.C0605b()).m3799B(getContext().getResources().getString(i10)).m3811l(strM24662s).m3810k(strM24662s2).m3809j(subscribePendingIntentToDetail).m3815p(bundle).m3817r(GROUP_NAME_CLOUD_BACKUP).m3823x(true).m3800C(System.currentTimeMillis());
                new BackupNotificationManager(context).cancelNotification(23);
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                mNotifyManager.cancelNotification(23);
                notificationManager.notify(788, builderM1669j.m3807h(true).m3819t(true).m3804d());
                C13462b.m81015c().m81020f("needSendRestoreNotify", false);
                C13462b.m81015c().m81020f("isOObeRestoreNotify", false);
                RestoreUtil.reportBackupSubscribeNotify("subscribe_restore_success_notify", z10 ? "oobeRestore" : "restoreSuccess");
                C11839m.m70688i(TAG, " sendSubscribeRestoreSuccessNotification end ");
                return true;
            }
            C11839m.m70688i(TAG, "params invalid.");
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void showNetErrNotification(float f10) {
        try {
            this.status = 3;
            if (inOOBE()) {
                return;
            }
            C11839m.m70688i(TAG, " RestoreNotification update progress ");
            if (this.builder == null) {
                return;
            }
            Context context = getContext();
            String netCauseTip = getNetCauseTip();
            String strM16085H = C2783d.m16085H(f10);
            this.builder.m3805e();
            this.builder.m3822w(0, 0, false);
            if (C0209d.m1253f1()) {
                this.builder.m3811l(netCauseTip);
                this.builder.m3810k(context.getString(R$string.restore_new_net_error, strM16085H));
                this.builder.m3801a(0, context.getString(R$string.set_net), getPendingIntent("SOURCE_ID_BACKUP_RESTORING_NOTIFY", RestoreUtil.isNewBmRecord()));
            } else {
                String str = String.format(getContext().getString(R$string.restore_new_completed_part), C0209d.m1236b0(strM16085H));
                this.builder.m3811l(context.getString(R$string.restore_net_disconnet));
                this.builder.m3798A(str);
            }
            Notification notificationM3804d = this.builder.m3804d();
            notificationM3804d.flags |= 32;
            ((NotificationManager) context.getSystemService("notification")).notify(23, notificationM3804d);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void updateNotification(Bundle bundle) {
        if (this.status == 3) {
            C11839m.m70688i(TAG, "status is NET_ERR");
            return;
        }
        boolean z10 = true;
        this.status = 1;
        if (inOOBE()) {
            C11839m.m70688i(TAG, "current process is inOOBE");
            return;
        }
        if (this.builder != null && bundle != null) {
            String string = bundle.getString("title");
            String string2 = bundle.getString("text");
            if (TextUtils.isEmpty(string)) {
                C11839m.m70687e(TAG, "title is null");
                return;
            }
            Context context = getContext();
            float f10 = bundle.getFloat(VastAttribute.PROGRESS);
            if (C0209d.m1253f1()) {
                this.builder.m3810k(string2);
                this.builder.m3811l(string);
            } else {
                this.builder.m3811l(string);
                this.builder.m3798A(context.getString(R$string.restore_new_completed_part, C2783d.m16085H(f10)));
            }
            this.builder.m3822w(100, (int) f10, false);
            Notification notificationM3804d = this.builder.m3804d();
            notificationM3804d.flags |= 32;
            ((NotificationManager) context.getSystemService("notification")).notify(23, notificationM3804d);
            C11839m.m70686d(TAG, "app notify end");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("builder is null:");
        sb2.append(this.builder == null);
        sb2.append(", or bundle is null:");
        if (bundle != null) {
            z10 = false;
        }
        sb2.append(z10);
        C11839m.m70687e(TAG, sb2.toString());
    }

    public synchronized void completedNotification(float f10, int i10, int i11, boolean z10) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        if (this.status == 2 && !this.waitOOBEFinish) {
            C11839m.m70688i(TAG, "restore has completed, status is " + this.status);
            return;
        }
        this.status = 2;
        if (inOOBE()) {
            this.waitOOBEFinish = true;
            C11839m.m70688i(TAG, "Because it is in the OOBE phase, notifications are terminated. ");
            return;
        }
        this.waitOOBEFinish = false;
        if (RestoreUtil.sendSubscribeRestoreSuccessNotify()) {
            return;
        }
        C11839m.m70688i(TAG, " completedNotification start ");
        Context context = getContext();
        NotificationCompat.Builder builderM1669j = C0238w.m1663f().m1669j(context, GROUP_NAME_CLOUD_BACKUP);
        builderM1669j.m3805e();
        PendingIntent pendingIntent = getPendingIntent("SOURCE_ID_BACKUP_RESTORE_COMPLETE_NOTIFY", z10);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", context.getResources().getString(R$string.backup_notification_title));
        int i12 = R$drawable.logo_about_system;
        builderM1669j.m3824y(i12).m3809j(pendingIntent).m3803c(bundle).m3823x(false).m3807h(true);
        String strM16085H = C2783d.m16085H(f10);
        Context context2 = getContext();
        int i13 = R$string.restore_new_completed_part;
        String str = String.format(context2.getString(i13), C0209d.m1236b0(strM16085H));
        if (i10 == 2 || i10 == 3) {
            List<CloudRestoreItem> itemList = RestoreProgress.getItemList();
            int failCount = RestoreUtil.getFailCount(0, itemList);
            C11839m.m70688i(TAG, "completedNotification failedCount = " + failCount);
            int succeedCount = RestoreUtil.getSucceedCount(0, itemList);
            C11839m.m70688i(TAG, "completedNotification succeedCount = " + succeedCount);
            if (C0209d.m1253f1()) {
                if (failCount > 0 && succeedCount > 0) {
                    string3 = context.getString(R$string.restore_new_recovery_completed_part);
                } else if (succeedCount > 0) {
                    string3 = context.getString(R$string.notification_restore_new_recovery_completed_show);
                } else if (failCount > 0) {
                    string3 = context.getString(R$string.restore_new_recovery_completed_failed);
                } else {
                    string = null;
                    string4 = getContext().getString(R$string.notification_restore_more_detail);
                }
                string = string3;
                string4 = getContext().getString(R$string.notification_restore_more_detail);
            } else {
                if (failCount > 0 && succeedCount > 0) {
                    string2 = context.getString(R$string.notification_restore_partial_completed);
                } else if (succeedCount > 0) {
                    string2 = context.getString(R$string.restore_new_recovery_completed_show);
                } else if (failCount > 0) {
                    string2 = context.getString(R$string.notification_restore_failed);
                } else {
                    string = null;
                    string4 = null;
                }
                string = string2;
                string4 = null;
            }
        } else if (i10 == 4 || i10 == 5) {
            Integer restoreErrCode = RestoreUtil.getRestoreErrCode();
            if (restoreErrCode != null && restoreErrCode.intValue() == 1007) {
                if (C0209d.m1253f1()) {
                    string = context.getString(R$string.restore_new_recovery_completed_failed);
                    string4 = getContext().getString(R$string.notification_restore_fail_local_space_tip);
                } else {
                    string = context.getString(R$string.notification_restore_fail_local_space_tip);
                    string4 = null;
                }
            } else if (restoreErrCode != null && restoreErrCode.intValue() == 1004) {
                if (C0209d.m1253f1()) {
                    string = context.getString(R$string.notification_restore_pause);
                    string4 = getContext().getString(R$string.restore_low_power, RestoreUtil.getPauseBattery());
                } else {
                    string = String.format(getContext().getString(i13), C0209d.m1236b0(strM16085H));
                    string5 = getContext().getString(R$string.restore_low_power, RestoreUtil.getPauseBattery());
                    String str2 = string;
                    string = string5;
                    string4 = str2;
                }
            } else if (C0209d.m1253f1()) {
                string = context.getString(R$string.restore_new_recovery_completed_failed);
                string4 = getContext().getString(R$string.notification_restore_more_detail);
            } else {
                string = context.getString(R$string.notification_restore_failed);
                string4 = null;
            }
        } else if (i10 != 7) {
            string4 = str;
            string = null;
        } else {
            string = context.getString(R$string.restore_pause_resume_subtitle_new);
            if (C0209d.m1253f1()) {
                string5 = context.getString(R$string.restore_new_recovery_completed_pause_manual);
                builderM1669j.m3801a(i12, context.getString(R$string.restore_continue), goOnService());
                String str22 = string;
                string = string5;
                string4 = str22;
            } else {
                string4 = String.format(getContext().getString(i13), C0209d.m1236b0(strM16085H));
            }
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (C0209d.m1253f1()) {
            builderM1669j.m3811l(string);
            builderM1669j.m3810k(string4);
        } else {
            builderM1669j.m3811l(string);
            builderM1669j.m3798A(string4);
        }
        Notification notificationM3804d = builderM1669j.m3804d();
        notificationM3804d.flags |= 32;
        notificationManager.notify(23, notificationM3804d);
        this.builder = null;
        C11839m.m70688i(TAG, " completedNotification end ");
    }
}
