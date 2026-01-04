package p805yb;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.sync.R$drawable;
import com.huawei.hicloud.sync.R$string;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0213f;
import p015ak.C0235t;
import p015ak.C0238w;
import p514o9.C11839m;

/* renamed from: yb.d */
/* loaded from: classes3.dex */
public class C13934d {

    /* renamed from: c */
    public static final Object f62488c = new Object();

    /* renamed from: d */
    public static C13934d f62489d;

    /* renamed from: a */
    public NotificationManager f62490a;

    /* renamed from: b */
    public Context f62491b;

    public C13934d() {
        this.f62490a = null;
        Context contextM1377a = C0213f.m1377a();
        this.f62491b = contextM1377a;
        this.f62490a = (NotificationManager) contextM1377a.getSystemService("notification");
    }

    /* renamed from: b */
    public static C13934d m83693b() {
        C13934d c13934d;
        synchronized (f62488c) {
            try {
                if (f62489d == null) {
                    f62489d = new C13934d();
                }
                c13934d = f62489d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c13934d;
    }

    /* renamed from: a */
    public void m83694a() {
        StatusBarNotification[] activeNotifications;
        C11839m.m70688i("NPSNotificationManager", "cancel nps notification");
        NotificationManager notificationManager = this.f62490a;
        if (notificationManager == null || (activeNotifications = notificationManager.getActiveNotifications()) == null || activeNotifications.length <= 0) {
            return;
        }
        for (int i10 = 0; i10 < activeNotifications.length; i10++) {
            if (activeNotifications[i10].getNotification() == null) {
                C11839m.m70688i("NPSNotificationManager", "nps notification is null");
            } else if (activeNotifications[i10].getNotification().getGroup() == null) {
                C11839m.m70688i("NPSNotificationManager", "nps Notification group is null");
            } else if ("com.huawei.android.hicloud".equals(activeNotifications[i10].getNotification().getGroup()) && activeNotifications[i10].getId() == 388) {
                this.f62490a.cancel(388);
            }
        }
    }

    /* renamed from: c */
    public final PendingIntent m83695c() {
        Context contextM1377a = C0213f.m1377a();
        Intent intentM83684q = C13933c.m83668n().m83684q();
        intentM83684q.putExtra(BackupNotification.FROM_NOTIFICATION, true);
        return PendingIntent.getActivity(contextM1377a, 0, intentM83684q, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    /* renamed from: d */
    public void m83696d(String str, String str2) {
        NotificationCompat.Builder builderM1668i;
        C11839m.m70688i("NPSNotificationManager", "show notification");
        if (this.f62491b == null) {
            this.f62491b = C0213f.m1377a();
        }
        m83694a();
        Bundle bundle = new Bundle();
        Resources resources = this.f62491b.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        if (NotifyUtil.isSilentNotifyTime()) {
            C0235t c0235tM1645e = C0235t.m1645e();
            Context context = this.f62491b;
            builderM1668i = c0235tM1645e.m1647f(context, "com.huawei.android.hicloud", "2", context.getString(com.huawei.hicloud.account.R$string.app_name));
        } else {
            builderM1668i = C0238w.m1663f().m1668i(this.f62491b, "com.huawei.android.hicloud");
        }
        builderM1668i.m3803c(bundle);
        this.f62490a.notify(388, builderM1668i.m3824y(R$drawable.ic_about_cloud_app).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3799B(this.f62491b.getResources().getString(i10)).m3811l(str).m3810k(str2).m3809j(m83695c()).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d());
    }
}
