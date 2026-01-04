package com.huawei.android.hicloud.p088ui.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.p088ui.activity.CloudDiskCallLogActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudDiskInterceptionActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudDiskNotepadActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudDiskRecordingActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudDiskSmsActivity;
import com.huawei.android.sync.R$drawable;
import com.huawei.android.sync.R$string;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.security.SecureRandom;
import p015ak.C0209d;
import p015ak.C0214f0;
import p015ak.C0216g0;
import p015ak.C0235t;
import p015ak.C0238w;
import p514o9.C11839m;
import p516ob.C11845a;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class CloudSyncNotificationManager {
    private static final int FLAG_REMOVBLE = 65536;
    private static final String TAG = "CloudSyncNotificationManager";
    private Context mContext;
    private NotificationManager mManager;

    public CloudSyncNotificationManager(Context context) {
        if (context == null) {
            C11839m.m70687e(TAG, "BackupNotificationManager ctx is null");
        } else {
            this.mContext = context;
            this.mManager = (NotificationManager) context.getSystemService("notification");
        }
    }

    public static long getSyncNotifyTime(Context context, String str) {
        if (context != null) {
            return C0214f0.m1382b(context, "sync_contact_spfile", 0).getLong(str, 0L);
        }
        C11839m.m70687e(TAG, "Context is null");
        return 0L;
    }

    private void notificationGroupDone(boolean z10) {
        notificationGroupDone(z10, 3, "reminder");
    }

    private void syncNotify(String str, Notification notification) {
        if ("addressbook".equals(str)) {
            this.mManager.notify(19, notification);
            return;
        }
        if ("wlan".equals(str)) {
            this.mManager.notify(261, notification);
            return;
        }
        if ("calendar".equals(str)) {
            this.mManager.notify(262, notification);
            return;
        }
        if ("notepad".equals(str)) {
            this.mManager.notify(263, notification);
            return;
        }
        if ("browser".equals(str)) {
            this.mManager.notify(Constant.ERROR_ROTATION_ANGLE_INVALID, notification);
            return;
        }
        int iNextInt = new SecureRandom().nextInt(100000) + 10000;
        this.mManager.notify(iNextInt, notification);
        C11839m.m70688i(TAG, "syncNotify, id = " + iNextInt + ", syncType: " + str);
    }

    public static void writeSyncNotifyTime(Context context, String str, long j10) {
        if (context == null) {
            C11839m.m70687e(TAG, "Context is null");
        } else {
            C0214f0.m1382b(context, "sync_contact_spfile", 0).edit().putLong(str, j10).commit();
        }
    }

    public void sendRestoreNotify(int i10, String str, String str2, String str3) throws NumberFormatException {
        String strM70926m;
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70687e(TAG, "sendRestoreNotify mContext is null");
            return;
        }
        if (C0209d.m1173G1(context)) {
            C11839m.m70688i(TAG, "sendRestoreNotify, isPrivacyUser, now exit Cloud!");
            return;
        }
        C11839m.m70688i(TAG, "sendRestoreNotify");
        NotificationCompat.Builder builderM1669j = C0238w.m1663f().m1669j(this.mContext, str2);
        Intent intent = new Intent();
        if (i10 != 517) {
            switch (i10) {
                case 257:
                    intent.setClass(this.mContext, CloudDiskSmsActivity.class);
                    break;
                case 258:
                    intent.setClass(this.mContext, CloudDiskCallLogActivity.class);
                    break;
                case 259:
                    intent.setClass(this.mContext, CloudDiskNotepadActivity.class);
                    break;
                case 260:
                    intent.setClass(this.mContext, CloudDiskRecordingActivity.class);
                    break;
            }
        } else {
            intent.setClass(this.mContext, CloudDiskInterceptionActivity.class);
        }
        C0216g0.m1402e(this.mContext).m1408F(intent, "SOURCE_ID_SYNC_UNSTRUCT_DATA_RESTORE_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, i10, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        builderM1669j.m3823x(true);
        Notification notificationM3804d = builderM1669j.m3799B(str2).m3811l(str2).m3810k(str3).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3809j(pendingIntentM1248e0).m3803c(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
        notificationM3804d.flags = 65536 | 16;
        if (str != null) {
            strM70926m = C11845a.m70926m(str);
            if (strM70926m == null) {
                C11845a.m70905B(str);
                strM70926m = C11845a.m70926m(str);
            }
            this.mManager.cancel(i10);
        } else {
            strM70926m = "";
        }
        try {
            this.mManager.notify(Integer.parseInt(i10 + strM70926m), notificationM3804d);
            notificationGroupDone(false, 3, VastAttribute.PROGRESS);
        } catch (NumberFormatException unused) {
            C11839m.m70687e(TAG, "notifyId numberFormatException.");
        }
    }

    public void setSyncActivityNotify(String str, String str2, String str3, String str4) throws Resources.NotFoundException {
        Intent intent;
        Context context = this.mContext;
        if (context == null) {
            C11839m.m70687e(TAG, "setSyncActivityNotify mContext is null");
            return;
        }
        if (C0209d.m1173G1(context)) {
            C11839m.m70688i(TAG, "setSyncActivityNotify, isPrivacyUser, now exit Cloud!");
            return;
        }
        C11839m.m70688i(TAG, "setSyncActivityNotify");
        NotificationCompat.Builder builderM1668i = C0238w.m1663f().m1668i(this.mContext, "com.huawei.android.hicloud");
        if ("addressbook".equals(str3)) {
            intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.APP_CONTACTS");
            C0209d.m1302r2(intent, C13843a.m83094p(this.mContext));
        } else if ("wlan".equals(str3)) {
            intent = new Intent("android.settings.WIFI_SETTINGS");
        } else if ("calendar".equals(str3)) {
            intent = new Intent();
            intent.setAction("huawei.intent.action.DeleteMultipleActivity");
            C0209d.m1302r2(intent, C13843a.m83093o(this.mContext));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setType("delete.multiple.activity/event");
            intent.putExtra("source_apk", "com.huawei.hidisk");
            int iM83080c0 = C13843a.m83080c0(this.mContext, intent);
            C11839m.m70688i(TAG, "setSyncActivityNotify: activityNum = " + iM83080c0);
            if (iM83080c0 <= 0) {
                intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.APP_CALENDAR");
                C0209d.m1302r2(intent, C13843a.m83093o(this.mContext));
            }
        } else if ("notepad".equals(str3)) {
            intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.DEFAULT");
            C0209d.m1302r2(intent, C13843a.m83050B(this.mContext));
        } else if ("browser".equals(str3)) {
            intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.DEFAULT");
            String strM83092n = C13843a.m83092n(this.mContext);
            if (strM83092n != null) {
                C0209d.m1302r2(intent, strM83092n);
            } else {
                C0209d.m1302r2(intent, "com.android.browser");
            }
        } else if (TextUtils.isEmpty(str4)) {
            intent = null;
        } else {
            Intent launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(str4);
            if ("com.huawei.hitouch".equals(str4)) {
                launchIntentForPackage = new Intent("com.huawei.hitouch.READ_LATER_CARD_ACTION");
                launchIntentForPackage.putExtra("FROM", "com.huawei.hidisk");
                C0209d.m1302r2(launchIntentForPackage, str4);
            }
            intent = launchIntentForPackage;
        }
        if (intent != null) {
            C11839m.m70686d(TAG, "notificationIntent != null");
            intent.setFlags(335544320);
        }
        C0216g0.m1402e(this.mContext).m1408F(intent, "SOURCE_ID_SYNC_EXCEED_LIMIT_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        Resources resources = this.mContext.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        builderM1668i.m3823x(true);
        NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
        c0605b.m3839h(str2);
        NotificationCompat.Builder builderM3799B = builderM1668i.m3799B(this.mContext.getResources().getString(i10));
        if (TextUtils.isEmpty(str)) {
            str = this.mContext.getResources().getString(i10);
        }
        Notification notificationM3804d = builderM3799B.m3811l(str).m3810k(str2).m3809j(pendingIntentM1248e0).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3803c(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3825z(c0605b).m3804d();
        notificationM3804d.flags = 65536 | 16;
        syncNotify(str3, notificationM3804d);
        notificationGroupDone(false);
    }

    private void notificationGroupDone(boolean z10, int i10, String str) {
        NotificationCompat.Builder builderM1670k;
        if (this.mManager.getActiveNotifications().length < 1) {
            return;
        }
        if (z10) {
            C0235t c0235tM1645e = C0235t.m1645e();
            Context context = this.mContext;
            builderM1670k = c0235tM1645e.m1649h(context, "com.huawei.android.hicloud", "2", context.getString(R$string.channel_backup_notification), i10, str);
        } else {
            builderM1670k = C0238w.m1663f().m1670k(this.mContext, "com.huawei.android.hicloud", i10, str);
        }
        Intent intent = new Intent();
        intent.setAction(NotifyConstants.Action.ACTION_MAIN_ACTIVITY);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.mContext, 1, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", this.mContext.getResources().getString(R$string.HiCloud_app_name));
        builderM1670k.m3823x(true);
        this.mManager.notify(22, builderM1670k.m3824y(R$drawable.logo_about_system).m3809j(pendingIntentM1248e0).m3803c(bundle).m3800C(System.currentTimeMillis()).m3817r("com.huawei.android.hicloud").m3818s(true).m3807h(true).m3804d());
        C11839m.m70688i(TAG, "notificationGroupDone");
    }

    public void setSyncActivityNotify(String str, String str2) throws Resources.NotFoundException {
        setSyncActivityNotify(null, str, str2, "");
    }

    public void setSyncActivityNotify(String str, String str2, String str3) throws Resources.NotFoundException {
        setSyncActivityNotify(str, str2, str3, "");
    }
}
