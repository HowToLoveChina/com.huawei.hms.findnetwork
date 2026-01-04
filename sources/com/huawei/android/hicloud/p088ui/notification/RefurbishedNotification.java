package com.huawei.android.hicloud.p088ui.notification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupDeviceInfo;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackupUserInfo;
import com.huawei.android.hicloud.cloudbackup.bean.RefurbishRestoreInfo;
import com.huawei.android.hicloud.cloudbackup.bean.RefurbishValidPeriod;
import com.huawei.android.hicloud.common.receiver.RefurbishNotificationAlarmReceiver;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupRecordsActivity;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import il.C10542o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0238w;
import p514o9.C11839m;
import p617rl.C12526j;
import p618rm.C12590s0;
import p709vj.C13452e;
import p711vl.C13467g;

/* loaded from: classes3.dex */
public class RefurbishedNotification {
    public static final int NORMAL_BACKUP_RECORD_SAVE_MAX_DAYS = 3;
    public static final int NORMAL_NOTIFICATION_FIRST_REMAINING_TIMES = 48;
    public static final int NORMAL_NOTIFICATION_SECOND_REMAINING_TIMES = 24;
    private static final int ONE_DAY_HOUR_TIME = 24;
    private static final long ONE_HOUR_TIME = 3600000;
    private static final String TAG = "RefurbishedNotification";
    private Context mContext = C0213f.m1377a();
    private NotificationManager mManager;

    private void checkNoRestoreNotification(long j10, int i10, int i11, int i12) throws Resources.NotFoundException {
        long j11 = ((i12 - i10) * 3600000) + j10;
        long j12 = ((i12 - i11) * 3600000) + j10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j13 = (i12 * 3600000) + j10;
        C11839m.m70688i(TAG, "checkNoRestoreNotification , refurbishTime = " + j10 + ", firstNotify = " + i10 + ", secondNotify = " + i11 + " , omTime = " + i12);
        if (jCurrentTimeMillis < j11) {
            long jAbs = Math.abs(j11 - System.currentTimeMillis());
            C11839m.m70688i(TAG, "checkNoRestoreNotification , low first  , trigger = " + jAbs);
            setRefurbishNotificationAlarm(jAbs);
            return;
        }
        if (jCurrentTimeMillis >= j11 && jCurrentTimeMillis < j12) {
            int i13 = i10 / 24;
            C11839m.m70688i(TAG, "checkNoRestoreNotification , between first second, day = " + i13);
            sendNotificationWithSilentNotifyTime(true, i13);
            return;
        }
        if (jCurrentTimeMillis < j12 || jCurrentTimeMillis >= j13) {
            return;
        }
        int i14 = i11 / 24;
        C11839m.m70688i(TAG, "checkNoRestoreNotification , high second, day = " + i14);
        sendNotificationWithSilentNotifyTime(true, i14);
    }

    private void checkNotificationRemainingPeriod(RefurbishValidPeriod refurbishValidPeriod, int i10, int i11, int i12) {
        if (refurbishValidPeriod != null && refurbishValidPeriod.checkValidityConfiguration(i10)) {
            i11 = refurbishValidPeriod.getRefurbishFirstRemainingPeriod();
            i12 = refurbishValidPeriod.getRefurbishSecondRemainingPeriod();
        }
        C11839m.m70688i(TAG, "checkNotificationRemainingPeriod , firstNotify = " + i11 + " , secondNotify = " + i12);
    }

    private Notification generateNotification(boolean z10, int i10) throws Resources.NotFoundException {
        String string = this.mContext.getResources().getString(z10 ? R$string.refurbished_restore_tip_notification_des : R$string.refurbished_restore_failed_tip_notification_des, this.mContext.getResources().getQuantityString(R$plurals.gallery_shelve_left_days, i10, Integer.valueOf(i10)));
        Intent intent = new Intent();
        intent.setClass(this.mContext, CloudBackupRecordsActivity.class);
        intent.putExtra("come_from_refurbished_notification", true);
        intent.putExtra("moudle", "myHuawei");
        intent.putExtra(FamilyShareConstants.ENTRY_TYPE, 5);
        intent.putExtra("come_from_refurbished_type", z10);
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        Resources resources = this.mContext.getResources();
        int i11 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i11));
        String string2 = this.mContext.getResources().getString(R$string.refurbished_restore_tip_notification_title);
        Notification notificationM3804d = C0238w.m1663f().m1668i(this.mContext, string2).m3824y(R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(this.mContext.getResources().getString(i11)).m3811l(string2).m3810k(string).m3809j(pendingIntentM1248e0).m3802b(new NotificationCompat.C0604a(R$drawable.icon_noti_cloud, C0213f.m1377a().getString(R$string.view_details), pendingIntentM1248e0)).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3819t(true).m3804d();
        notificationM3804d.flags |= 32;
        return notificationM3804d;
    }

    private boolean isExistRefurbishFaildRecord(String str, RefurbishRestoreInfo refurbishRestoreInfo) {
        int status;
        return (!TextUtils.equals(str, refurbishRestoreInfo.getBackupId()) || (status = refurbishRestoreInfo.getStatus()) == 0 || status == 4) ? false : true;
    }

    private void sendNotification(boolean z10, int i10) throws Resources.NotFoundException {
        Context context = this.mContext;
        if (context != null) {
            this.mManager = (NotificationManager) context.getSystemService("notification");
        }
        if (this.mManager == null) {
            C11839m.m70688i(TAG, "mManager is null");
        } else {
            this.mManager.notify(390, generateNotification(z10, i10));
        }
    }

    private void setRefurbishNotificationAlarm(long j10) {
        AlarmManager alarmManager = (AlarmManager) C0213f.m1377a().getSystemService("alarm");
        if (alarmManager != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() + j10;
            C11839m.m70688i(TAG, "setRefurbishNotificationAlarm , alarm trigger at " + jCurrentTimeMillis);
            Intent intent = new Intent(C0213f.m1377a(), (Class<?>) RefurbishNotificationAlarmReceiver.class);
            intent.setAction("com.huawei.hicloud.action.refurbishnotification");
            alarmManager.set(0, jCurrentTimeMillis, PendingIntent.getBroadcast(C0213f.m1377a(), 0, intent, 1073741824));
        }
    }

    public void checkNeedRefurbishNotification(long j10, String str) throws Resources.NotFoundException {
        RefurbishRestoreInfo refurbishRestoreInfoM75866j2 = C12590s0.m75866j2();
        long restoreEndTime = refurbishRestoreInfoM75866j2.getRestoreEndTime();
        boolean zIsExistRefurbishFaildRecord = isExistRefurbishFaildRecord(str, refurbishRestoreInfoM75866j2);
        RefurbishValidPeriod refurbishValidPeriodM75426w0 = new C12526j().m75426w0();
        if (zIsExistRefurbishFaildRecord) {
            int iM81089d = C13467g.m81086c().m81089d("refurbish_backup_record_delay_refeffe_days", 3) * 24;
            checkNotificationRemainingPeriod(refurbishValidPeriodM75426w0, iM81089d, 48, 24);
            checkRestoreDelayNotification(restoreEndTime, 48, 24, iM81089d);
        } else {
            int iM81089d2 = C13467g.m81086c().m81089d("refurbish_backup_record_refeffe_days", 3) * 24;
            checkNotificationRemainingPeriod(refurbishValidPeriodM75426w0, iM81089d2, 48, 24);
            checkNoRestoreNotification(j10, 48, 24, iM81089d2);
        }
    }

    public void checkRefurbishBackupRecords(CloudBackupUserInfo cloudBackupUserInfo) {
        try {
            if (!C13467g.m81086c().m81087a("refurbish_restore_notify" + C11476b.m68626h(C13452e.m80781L().m80971t0()), true)) {
                C11839m.m70688i(TAG, "refurbish restore no need notify.");
                return;
            }
            boolean z10 = false;
            if (cloudBackupUserInfo == null) {
                cloudBackupUserInfo = new C10542o().m64685l1(true, true, false);
            }
            String backupId = "";
            Iterator<Map.Entry<String, CloudBackupDeviceInfo>> it = cloudBackupUserInfo.getDeviceInfoMap().entrySet().iterator();
            long j10 = 0;
            while (it.hasNext()) {
                List<CloudRecoveryItem> recoveryItems = it.next().getValue().getRecoveryItems();
                if (recoveryItems != null && recoveryItems.size() > 0) {
                    Iterator<CloudRecoveryItem> it2 = recoveryItems.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            CloudRecoveryItem next = it2.next();
                            if (next.isRefurbishment() && next.isCurrent()) {
                                long backupEndTime = next.getBackupEndTime();
                                z10 = true;
                                backupId = next.getBackupId();
                                j10 = backupEndTime;
                                break;
                            }
                        }
                    }
                }
            }
            if (z10) {
                checkNeedRefurbishNotification(j10, backupId);
            } else {
                C11839m.m70687e(TAG, "checkRefuibishBackupRecords isExistRefurbished no exit  , return");
                C12590s0.m75745F2();
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "checkRefuibishBackupRecords failed." + e10.toString());
        }
    }

    public void checkRestoreDelayNotification(long j10, int i10, int i11, int i12) throws Resources.NotFoundException {
        long j11 = ((i12 - i10) * 3600000) + j10;
        long j12 = ((i12 - i11) * 3600000) + j10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j13 = (i12 * 3600000) + j10;
        C11839m.m70688i(TAG, "checkRestoreDelayNotification , restoreFaildTime = " + j10 + ", firstNotify = " + i10 + ", secondNotify = " + i11 + " , omTime = " + i12);
        if (jCurrentTimeMillis < j11) {
            long jAbs = Math.abs(j11 - System.currentTimeMillis());
            C11839m.m70688i(TAG, "checkRestoreDelayNotification , low first  , trigger = " + jAbs);
            setRefurbishNotificationAlarm(jAbs);
            return;
        }
        if (jCurrentTimeMillis >= j11 && jCurrentTimeMillis < j12) {
            int i13 = i10 / 24;
            C11839m.m70688i(TAG, "checkRestoreDelayNotification , between first second, day = " + i13);
            sendNotificationWithSilentNotifyTime(false, i13);
            return;
        }
        if (jCurrentTimeMillis < j12 || jCurrentTimeMillis >= j13) {
            return;
        }
        int i14 = i11 / 24;
        C11839m.m70688i(TAG, "checkRestoreDelayNotification , high second, day = " + i14);
        sendNotificationWithSilentNotifyTime(false, i14);
    }

    public void sendNotificationWithSilentNotifyTime(boolean z10, int i10) throws Resources.NotFoundException {
        if (NotifyUtil.isSilentNotifyTime()) {
            setRefurbishNotificationAlarm(3600000L);
        } else {
            sendNotification(z10, i10);
        }
    }
}
