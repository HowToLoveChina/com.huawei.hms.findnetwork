package com.huawei.android.hicloud.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupClearSuccessActivity;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.Random;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0238w;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class CleanNotifyManager {

    /* renamed from: a */
    public Context f12274a;

    /* renamed from: b */
    public NotificationManager f12275b;

    public CleanNotifyManager(Context context) {
        if (context == null) {
            C11839m.m70687e("CleanNotifyManager", "BackupNotificationManager ctx is null");
        } else {
            this.f12274a = context;
            this.f12275b = (NotificationManager) context.getSystemService("notification");
        }
    }

    /* renamed from: a */
    public static int m16514a() {
        int iNextInt = new Random().nextInt(1000) + 100;
        C11839m.m70686d("CleanNotifyManager", "randomNumber:" + iNextInt);
        return iNextInt;
    }

    /* renamed from: b */
    public void m16515b(Intent intent) {
        Bundle bundleExtra = new SafeIntent(intent).getBundleExtra("delete_notify_info");
        if (bundleExtra == null) {
            C11839m.m70687e("CleanNotifyManager", "bundle is null");
            return;
        }
        String string = bundleExtra.getString("delete_notify_info_title");
        C11839m.m70686d("CleanNotifyManager", "showNotify title:" + string);
        String string2 = this.f12274a.getString(R$string.see_details);
        int i10 = bundleExtra.getInt("delete_notify_info_number");
        long j10 = bundleExtra.getLong("delete_notify_info_size");
        int i11 = bundleExtra.getInt("source");
        C0238w c0238wM1663f = C0238w.m1663f();
        Context context = this.f12274a;
        int i12 = R$string.backup_category_title;
        NotificationCompat.Builder builderM1668i = c0238wM1663f.m1668i(context, context.getString(i12));
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", this.f12274a.getResources().getString(i12));
        NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
        c0605b.m3839h(string2);
        Intent intent2 = new Intent(CommonNotifyReceiver.COMMON_ACTION);
        intent2.setComponent(new ComponentName(this.f12274a, (Class<?>) CommonNotifyReceiver.class));
        C0209d.m1302r2(intent2, this.f12274a.getPackageName());
        intent2.putExtra(CommonNotifyReceiver.COMMAND_KEY, CommonNotifyReceiver.COMMAND_CANCAL);
        intent2.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "8");
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f12274a, 0, intent2, HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        Intent intent3 = new Intent();
        intent3.setClass(this.f12274a, CloudBackupClearSuccessActivity.class);
        intent3.putExtra("delete_notify_info_number", i10);
        intent3.putExtra("delete_notify_info_size", j10);
        intent3.putExtra("source", i11);
        C0216g0.m1402e(this.f12274a).m1408F(intent3, "SOURCE_ID_BACKUP_CLEAR_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.f12274a, m16514a(), intent3, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        builderM1668i.m3825z(c0605b);
        Notification notificationM3804d = builderM1668i.m3811l(string).m3810k(string2).m3809j(pendingIntentM1248e0).m3814o(broadcast).m3824y(R$drawable.ic_about_cloud_app).m3800C(System.currentTimeMillis()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3807h(true).m3804d();
        this.f12275b.notify(System.currentTimeMillis() + "", 22, notificationM3804d);
    }
}
