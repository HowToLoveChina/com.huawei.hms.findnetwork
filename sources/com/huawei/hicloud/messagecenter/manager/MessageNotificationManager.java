package com.huawei.hicloud.messagecenter.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import com.huawei.hicloud.notification.bean.NotifyMessageButtonData;
import com.huawei.hicloud.notification.bean.NotifyNeedData;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.notify.R$drawable;
import com.huawei.hicloud.notify.R$string;
import p015ak.C0213f;

/* loaded from: classes6.dex */
public class MessageNotificationManager {
    private static final int FLAG_REMOVBLE = 65536;
    private static final String TAG = "MessageNotificationManager";
    private NotificationManager mManager;

    public MessageNotificationManager(Context context) {
        if (context != null) {
            this.mManager = (NotificationManager) context.getSystemService("notification");
        } else {
            NotifyLogger.m29914e(TAG, "BackupNotificationManager ctx is null");
        }
    }

    public void cancelNotify(int i10) {
        boolean z10;
        int i11;
        StatusBarNotification[] activeNotifications = this.mManager.getActiveNotifications();
        boolean z11 = false;
        if (activeNotifications.length > 0) {
            z10 = false;
            i11 = 0;
            boolean z12 = false;
            for (int i12 = 0; i12 < activeNotifications.length; i12++) {
                if (activeNotifications[i12].getNotification() == null) {
                    NotifyLogger.m29915i(TAG, "notification is null");
                } else {
                    String group = activeNotifications[i12].getNotification().getGroup();
                    if (group == null) {
                        NotifyLogger.m29915i(TAG, "Notification group is null");
                    } else if ("com.huawei.android.hicloud.cloudbackup".equals(group) && activeNotifications[i12].getId() == i10) {
                        this.mManager.cancel(i10);
                        return;
                    } else if ("com.huawei.android.hicloud".equals(group)) {
                        i11++;
                        if (activeNotifications[i12].getId() == 22) {
                            z10 = true;
                        }
                        if (activeNotifications[i12].getId() == i10) {
                            z12 = true;
                        }
                    }
                }
            }
            z11 = z12;
        } else {
            z10 = false;
            i11 = 0;
        }
        NotifyLogger.m29915i(TAG, "cancelNotify needCancel is " + z11 + ", notifyId" + i10);
        if (z11) {
            this.mManager.cancel(i10);
            NotifyLogger.m29915i(TAG, "cancelNotify hiCloudNotiCount is " + i11 + ", containGroupID is " + z10);
            if (i11 == 2 && z10) {
                this.mManager.cancel(22);
            }
        }
    }

    public void notificationGroupDone(boolean z10, int i10, String str) {
        Context contextM1377a = C0213f.m1377a();
        if (this.mManager.getActiveNotifications().length < 1) {
            return;
        }
        NotificationCompat.Builder notificationBuilder = NotifyUtil.getNotificationBuilder(z10, "com.huawei.android.hicloud", i10, str);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", contextM1377a.getResources().getString(R$string.HiCloud_app_name));
        notificationBuilder.m3823x(true);
        this.mManager.notify(22, notificationBuilder.m3824y(R$drawable.logo_about_system).m3803c(bundle).m3800C(System.currentTimeMillis()).m3817r("com.huawei.android.hicloud").m3818s(true).m3807h(true).m3804d());
        NotifyLogger.m29915i(TAG, "notificationGroupDone");
    }

    public void sendNotification(NotificationCompat.Builder builder, NotifyNeedData notifyNeedData) {
        sendNotification(builder, notifyNeedData, 3, "reminder");
    }

    public void setNotifyMessageButton(NotificationCompat.Builder builder, NotifyNeedData notifyNeedData) {
        if (builder == null || notifyNeedData == null) {
            NotifyLogger.m29914e(TAG, "setNotifyDownloadButton notifyNeedData not exist");
            return;
        }
        NotifyMessageButtonData messageButtonData = notifyNeedData.getMessageButtonData();
        if (messageButtonData == null) {
            NotifyLogger.m29915i(TAG, "setNotifyDownloadButton buttonData not exist");
            return;
        }
        String firstButtonText = messageButtonData.getFirstButtonText();
        PendingIntent firstBtnIntent = messageButtonData.getFirstBtnIntent();
        if (messageButtonData.checkBtnIntegrity(firstButtonText, firstBtnIntent)) {
            NotifyLogger.m29915i(TAG, "setNotifyDownloadButton firstButton");
            builder.m3801a(notifyNeedData.getIconId(), firstButtonText, firstBtnIntent);
        }
        String secondButtonText = messageButtonData.getSecondButtonText();
        PendingIntent secondBtnIntent = messageButtonData.getSecondBtnIntent();
        if (messageButtonData.checkBtnIntegrity(secondButtonText, secondBtnIntent)) {
            NotifyLogger.m29915i(TAG, "setNotifyDownloadButton secondButton");
            builder.m3801a(notifyNeedData.getIconId(), secondButtonText, secondBtnIntent);
        }
    }

    public void sendNotification(NotificationCompat.Builder builder, NotifyNeedData notifyNeedData, int i10, String str) {
        if (notifyNeedData == null) {
            NotifyLogger.m29914e(TAG, "sendNotification, notiftyNeedData is null");
            return;
        }
        boolean zIsSilent = notifyNeedData.isSilent();
        CharSequence titleText = notifyNeedData.getTitleText();
        CharSequence mainText = notifyNeedData.getMainText();
        PendingIntent contentIntent = notifyNeedData.getContentIntent();
        PendingIntent cancelIntent = notifyNeedData.getCancelIntent();
        int iconId = notifyNeedData.getIconId();
        Bundle extraBundle = notifyNeedData.getExtraBundle();
        String groupKey = notifyNeedData.getGroupKey();
        boolean zIsAutoCancel = notifyNeedData.isAutoCancel();
        int id2 = notifyNeedData.getId();
        NotifyLogger.m29913d(TAG, "sendNotification, notifyId：" + id2);
        NotificationCompat.Builder notificationBuilder = builder == null ? NotifyUtil.getNotificationBuilder(zIsSilent, "com.huawei.android.hicloud", i10, str) : builder;
        notificationBuilder.m3823x(true);
        NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
        c0605b.m3839h(mainText);
        notificationBuilder.m3825z(c0605b);
        setNotifyMessageButton(notificationBuilder, notifyNeedData);
        if (notifyNeedData.isDelete()) {
            notificationBuilder.m3801a(iconId, notifyNeedData.getDeleteStr(), contentIntent);
        }
        Notification notificationM3804d = notificationBuilder.m3811l(titleText).m3810k(mainText).m3809j(contentIntent).m3814o(cancelIntent).m3824y(iconId).m3800C(System.currentTimeMillis()).m3815p(extraBundle).m3817r(groupKey).m3807h(zIsAutoCancel).m3804d();
        notificationM3804d.flags = 65536 | 16;
        this.mManager.notify(id2, notificationM3804d);
        if (notifyNeedData.isNeedGroup()) {
            notificationGroupDone(zIsSilent, i10, str);
        }
    }
}
