package p015ak;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.huawei.secure.android.common.intent.SafeIntent;
import p399jk.AbstractC10896a;

/* renamed from: ak.c */
/* loaded from: classes6.dex */
public class C0207c {

    /* renamed from: a */
    public NotificationManager f774a;

    public C0207c() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            this.f774a = (NotificationManager) contextM1377a.getSystemService("notification");
        } else {
            AbstractC10896a.m65886e("BaseNotificationManager", "BackupNotificationManager ctx is null");
        }
    }

    /* renamed from: a */
    public void m1136a(int i10, int i11, String str) {
        AbstractC10896a.m65887i("BaseNotificationManager", "cancelNotification, id = " + i10 + ", notifyGroupId = " + i11);
        if (this.f774a != null) {
            m1138c(i10, i11, str);
        }
    }

    /* renamed from: b */
    public void m1137b(Intent intent) {
        if (this.f774a == null) {
            AbstractC10896a.m65886e("BaseNotificationManager", "cancelNotificationWithIntent err, mManager not exist");
            return;
        }
        if (intent == null) {
            AbstractC10896a.m65886e("BaseNotificationManager", "cancelNotificationWithIntent err, intent not exist");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        if (!safeIntent.getBooleanExtra("notify_cancel_manual", false)) {
            AbstractC10896a.m65887i("BaseNotificationManager", "cancelNotificationWithIntent, isNotifyCancel false");
            return;
        }
        int intExtra = safeIntent.getIntExtra("notify_id", -1);
        AbstractC10896a.m65887i("BaseNotificationManager", "cancelNotificationWithIntent, notifyId is " + intExtra);
        m1138c(intExtra, 22, "com.huawei.android.hicloud");
    }

    /* renamed from: c */
    public final void m1138c(int i10, int i11, String str) {
        StatusBarNotification[] activeNotifications = this.f774a.getActiveNotifications();
        if (activeNotifications == null) {
            AbstractC10896a.m65886e("BaseNotificationManager", "doCancelNotification sta is null.");
            return;
        }
        if (activeNotifications.length == 2) {
            if (activeNotifications[0].getId() != i10 && activeNotifications[1].getId() != i10) {
                AbstractC10896a.m65886e("BaseNotificationManager", "cancel invalid notify id = " + i10);
                return;
            }
            this.f774a.cancel(i10);
            this.f774a.cancel(i11);
            AbstractC10896a.m65887i("BaseNotificationManager", "cancel notification finish");
        }
        int i12 = 0;
        boolean z10 = false;
        boolean z11 = false;
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            if (statusBarNotification.getNotification() == null) {
                AbstractC10896a.m65887i("BaseNotificationManager", "notification is null");
            } else if (statusBarNotification.getNotification().getGroup() == null) {
                AbstractC10896a.m65887i("BaseNotificationManager", "Notification group is null");
            } else if (!TextUtils.isEmpty(str) && str.equals(statusBarNotification.getNotification().getGroup())) {
                i12++;
                if (statusBarNotification.getId() == i10) {
                    z11 = true;
                }
                if (statusBarNotification.getId() == i11) {
                    z10 = true;
                }
            }
        }
        this.f774a.cancel(i10);
        if (i12 == 2 && z10 && z11) {
            this.f774a.cancel(i11);
        }
    }
}
