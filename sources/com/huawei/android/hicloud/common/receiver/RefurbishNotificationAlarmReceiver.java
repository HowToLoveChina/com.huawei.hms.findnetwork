package com.huawei.android.hicloud.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.hicloud.p088ui.notification.RefurbishedNotification;
import fk.C9721b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class RefurbishNotificationAlarmReceiver extends BroadcastReceiver {

    /* renamed from: com.huawei.android.hicloud.common.receiver.RefurbishNotificationAlarmReceiver$a */
    public static class C2761a extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            new RefurbishedNotification().checkRefurbishBackupRecords(null);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        C11839m.m70686d("RefurbishNotificationAlarmReceiver", "onReceive: " + intent.getAction());
        if ("com.huawei.hicloud.action.refurbishnotification".equals(intent.getAction())) {
            C12515a.m75110o().m75172d(new C2761a());
        }
    }
}
