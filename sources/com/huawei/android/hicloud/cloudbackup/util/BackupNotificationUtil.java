package com.huawei.android.hicloud.cloudbackup.util;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupDetailStateActivity;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HiCloudNotificationManager;
import com.huawei.hicloud.notification.p106db.bean.NoticeBackUpSuccessGoto;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0238w;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import tl.C13026e;

/* loaded from: classes2.dex */
public class BackupNotificationUtil {
    private static final int ILLEGAL = -1;
    private static final String TAG = "BackupNotificationUtil";
    private static final String USER_TYPE_PAY = "pay";

    private static PendingIntent getAutoBackupSuccessPendingIntent(Context context, SpaceNotification spaceNotification, boolean z10, boolean z11) {
        Intent intentToBackupComplete;
        String notiType;
        String notiUri;
        Iterator<NoticeBackUpSuccessGoto> it = spaceNotification.getBackupGoto().iterator();
        while (true) {
            intentToBackupComplete = null;
            if (!it.hasNext()) {
                notiType = null;
                notiUri = null;
                break;
            }
            NoticeBackUpSuccessGoto next = it.next();
            if (C13452e.m80781L().m80897c1()) {
                if (next.getEnableDataBackup() != null && z10 == next.getEnableDataBackup().intValue()) {
                    notiType = next.getNotiType();
                    notiUri = next.getNotiUri();
                    break;
                }
            } else if (USER_TYPE_PAY.equalsIgnoreCase(next.getUserType())) {
                notiType = next.getNotiType();
                notiUri = next.getNotiUri();
                break;
            }
        }
        if (notiType == null || notiUri == null) {
            NotifyLogger.m29914e(TAG, "sendBackupSuccessNotice noticeType or noticeUrl is null");
            return null;
        }
        if ("application".equalsIgnoreCase(notiType)) {
            intentToBackupComplete = (NotifyConstants.BACKUP_COMPLETE.equals(notiUri) || C0209d.m1205R0(new C13026e().m78399w("thirdAppData"))) ? getIntentToBackupComplete(context, z10, z11) : getIntentToBackupOptionsDetail(context, z10, z11);
        }
        return C0209d.m1248e0(context, 0, intentToBackupComplete, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    private static Intent getIntentToBackupComplete(Context context, boolean z10, boolean z11) {
        Intent intent = new Intent();
        intent.setClass(context, "2".equalsIgnoreCase(new SettingOperator().queryUploadTargetStrategy()) ? CloudBackupDetailStateActivity.class : BackupMainActivity.class);
        intent.putExtra("entry_source", "entry_backup_notify");
        intent.putExtra("notify_type", "auto_backup_success_notify_click_record");
        intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        intent.putExtra("scene_id", "auto_backup_success_notify_click_record");
        intent.putExtra("is_auto_backup", String.valueOf(z11));
        intent.putExtra("click_text", NotifyConstants.BACKUP_COMPLETE);
        intent.putExtra("is_third_app_switch_open", String.valueOf(z10));
        return intent;
    }

    private static Intent getIntentToBackupOptionsDetail(Context context, boolean z10, boolean z11) {
        Intent intent = new Intent();
        intent.putExtra("entry_source", "entry_backup_notify");
        intent.putExtra("notify_type", "auto_backup_success_notify_click_record");
        intent.putExtra("direct_enter", true);
        intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        intent.putExtra("scene_id", "auto_backup_success_notify_click_record");
        intent.putExtra("is_auto_backup", String.valueOf(z11));
        intent.putExtra("click_text", NotifyConstants.APPLICATION_DATA);
        intent.putExtra("is_third_app_switch_open", String.valueOf(z10));
        intent.setClass(context, BackupOptionsActivity.class);
        return intent;
    }

    private static void reportBackupSuccessNotifyEvent(boolean z10, SpaceNotification spaceNotification, boolean z11) {
        String strValueOf;
        String strValueOf2;
        if (spaceNotification != null) {
            strValueOf = String.valueOf(spaceNotification.getId());
            strValueOf2 = String.valueOf(spaceNotification.getNoticeType());
        } else {
            strValueOf = "";
            strValueOf2 = "";
        }
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("notify_id", strValueOf);
        linkedHashMapM79497A.put("notify_type", strValueOf2);
        linkedHashMapM79497A.put("is_silent_noti", String.valueOf(true));
        linkedHashMapM79497A.put("is_auto_backup", String.valueOf(z10));
        linkedHashMapM79497A.put("is_third_app_switch_open", String.valueOf(z11));
        C13225d.m79490f1().m79591l0("backup_success_notify_record", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "backup_success_notify_record", "4", "70", linkedHashMapM79497A);
    }

    public static long sendBackupSuccessNotice(Context context, boolean z10, HiCloudNotificationManager hiCloudNotificationManager, SpaceNotification spaceNotification, String str, String str2) {
        if (context == null || hiCloudNotificationManager == null || spaceNotification == null) {
            NotifyLogger.m29914e(TAG, "sendBackupSuccessNotice mContext is null");
            return -1L;
        }
        boolean zM78395p = new C13026e().m78395p();
        PendingIntent autoBackupSuccessPendingIntent = getAutoBackupSuccessPendingIntent(context, spaceNotification, zM78395p, z10);
        if (autoBackupSuccessPendingIntent == null) {
            NotifyLogger.m29914e(TAG, "sendBackupSuccessNotice contentIntent is null");
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        Resources resources = context.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        Notification notificationM3804d = C0238w.m1663f().m1669j(context, "com.huawei.android.hicloud.cloudbackup.success").m3824y(R$drawable.logo_about_system).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(context.getResources().getString(i10)).m3811l(str).m3810k(str2).m3809j(autoBackupSuccessPendingIntent).m3815p(bundle).m3807h(true).m3817r("com.huawei.android.hicloud.cloudbackup.success").m3800C(jCurrentTimeMillis).m3804d();
        hiCloudNotificationManager.notificationProgressGroupDone(true);
        hiCloudNotificationManager.notify(306, notificationM3804d);
        NotifyLogger.m29915i(TAG, "sendBackupSuccessNotice notify end");
        reportBackupSuccessNotifyEvent(z10, spaceNotification, zM78395p);
        return jCurrentTimeMillis;
    }
}
