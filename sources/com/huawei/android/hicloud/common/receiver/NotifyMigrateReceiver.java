package com.huawei.android.hicloud.common.receiver;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0224k0;
import p015ak.C0238w;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class NotifyMigrateReceiver extends BroadcastReceiver {
    /* renamed from: a */
    public final void m15781a(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            for (int i10 = 1; i10 <= 4; i10++) {
                PendingIntent pendingIntentM15783c = m15783c(context, i10, 536870912);
                if (pendingIntentM15783c != null) {
                    alarmManager.cancel(pendingIntentM15783c);
                }
            }
        }
    }

    /* renamed from: b */
    public final void m15782b(Context context, int i10) {
        long j10;
        C11839m.m70688i("NotifyMigrateReceiver", "createMigrateAlarm time is " + i10);
        if (i10 == 1) {
            j10 = C5863b6.g.f26453g;
        } else if (i10 == 2) {
            j10 = 10800000;
        } else if (i10 == 3) {
            j10 = 21600000;
        } else if (i10 != 4) {
            return;
        } else {
            j10 = 86400000;
        }
        PendingIntent pendingIntentM15783c = m15783c(context, i10, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            alarmManager.setExact(0, System.currentTimeMillis() + j10, pendingIntentM15783c);
        }
    }

    /* renamed from: c */
    public final PendingIntent m15783c(Context context, int i10, int i11) {
        Intent intent = new Intent("com.huawei.hicloud.action.OOBE_NOTIFY_DATA_MIGRATE");
        intent.putExtra("notify_type", 0);
        intent.putExtra("notify_times", i10);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        return PendingIntent.getBroadcast(context, i10, intent, i11);
    }

    /* renamed from: d */
    public final PendingIntent m15784d(Context context) {
        Intent intent = new Intent("com.huawei.hicloud.action.OOBE_NOTIFY_DATA_MIGRATE");
        intent.putExtra("notify_type", 2);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        return PendingIntent.getBroadcast(context, 200, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    /* renamed from: e */
    public final PendingIntent m15785e(Context context, int i10) {
        Intent intent = new Intent("com.huawei.hicloud.action.OOBE_NOTIFY_DATA_MIGRATE");
        intent.putExtra("notify_type", 3);
        intent.putExtra("notify_times", i10 + 1);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        return PendingIntent.getBroadcast(context, i10 + 300, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    /* renamed from: f */
    public final PendingIntent m15786f(Context context) {
        Intent intent = new Intent("com.huawei.hicloud.action.OOBE_NOTIFY_DATA_MIGRATE");
        intent.putExtra("notify_type", 1);
        C0216g0.m1402e(context).m1408F(intent, "SOURCE_ID_SYNC_MIGRATE_NOTIFY");
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        return PendingIntent.getBroadcast(context, 100, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    /* renamed from: g */
    public final void m15787g(Context context, Intent intent) throws Resources.NotFoundException {
        SafeIntent safeIntent = new SafeIntent(intent);
        int intExtra = 99;
        try {
            intExtra = safeIntent.getIntExtra("notify_times", 99);
        } catch (RuntimeException e10) {
            C11839m.m70687e("NotifyMigrateReceiver", "getIntExtra error: " + e10.toString());
        }
        C11839m.m70688i("NotifyMigrateReceiver", "notify time is " + intExtra);
        if (intExtra == 1 && !C0209d.m1206R1(context)) {
            C11839m.m70688i("NotifyMigrateReceiver", "OOBEE not end");
            m15782b(context, 1);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", context.getResources().getString(R$string.data_migrate));
        String string = context.getResources().getString(R$string.migrate_your_data);
        NotificationCompat.Builder builderM1668i = C0238w.m1663f().m1668i(context, string);
        NotificationCompat.Builder builderM3811l = builderM1668i.m3823x(true).m3811l(string);
        Resources resources = context.getResources();
        int i10 = R$string.migrate_notification;
        builderM3811l.m3810k(resources.getString(i10)).m3825z(new NotificationCompat.C0605b().m3839h(context.getResources().getString(i10))).m3824y(R$drawable.ic_notification_form_data_transfor).m3801a(0, context.getResources().getString(R$string.migrate_begin), m15786f(context)).m3801a(0, context.getResources().getString(R$string.migrate_ignore), m15784d(context)).m3801a(0, context.getResources().getString(R$string.migrate_later), m15785e(context, intExtra)).m3821v(2).m3815p(bundle).m3809j(m15786f(context)).m3813n(3);
        ((NotificationManager) context.getSystemService("notification")).notify(274, builderM1668i.m3804d());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
        int intExtra;
        if (intent != null) {
            SafeIntent safeIntent = new SafeIntent(intent);
            int intExtra2 = 99;
            try {
                intExtra = safeIntent.getIntExtra("notify_type", 99);
                C11839m.m70688i("NotifyMigrateReceiver", "begin: notifyType is " + intExtra);
            } catch (RuntimeException e10) {
                C11839m.m70687e("NotifyMigrateReceiver", "getIntExtra error: " + e10.toString());
                intExtra = 99;
            }
            if (intExtra == 0) {
                m15787g(context, intent);
                return;
            }
            if (intExtra == 1) {
                ((NotificationManager) context.getSystemService("notification")).cancel(274);
                ComponentName componentName = new ComponentName("com.huawei.hicloud", "com.huawei.android.hicloud.oobe.ui.activity.OOBEMigrateActivity");
                Intent intent2 = new Intent();
                intent2.setComponent(componentName);
                Bundle bundle = new Bundle();
                bundle.putInt(FamilyShareConstants.ENTRY_TYPE, 2);
                intent2.putExtras(bundle);
                intent2.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                C0224k0.m1542L(context, intent2);
                return;
            }
            if (intExtra == 2) {
                ((NotificationManager) context.getSystemService("notification")).cancel(274);
                return;
            }
            if (intExtra != 3) {
                if (intExtra != 4) {
                    return;
                }
                m15781a(context);
                return;
            }
            ((NotificationManager) context.getSystemService("notification")).cancel(274);
            try {
                intExtra2 = safeIntent.getIntExtra("notify_times", 99);
            } catch (RuntimeException e11) {
                C11839m.m70687e("NotifyMigrateReceiver", "getExtra error: " + e11.toString());
            }
            m15782b(context, intExtra2);
        }
    }
}
