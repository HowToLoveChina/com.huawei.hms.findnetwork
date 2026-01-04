package p683um;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.huawei.hicloud.account.R$drawable;
import com.huawei.hicloud.account.R$string;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0207c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0235t;
import p015ak.C0238w;
import p399jk.AbstractC10896a;
import p709vj.C13452e;
import p742wj.C13612b;
import p846zj.C14303a;
import tn.InterfaceC13043a;

/* renamed from: um.a */
/* loaded from: classes6.dex */
public class C13220a extends C0207c {
    /* renamed from: d */
    public final void m79452d(boolean z10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null && this.f774a.getActiveNotifications().length >= 1) {
            NotificationCompat.Builder builderM1647f = z10 ? C0235t.m1645e().m1647f(contextM1377a, "com.huawei.android.hicloud", "2", contextM1377a.getString(R$string.app_name)) : C0238w.m1663f().m1668i(contextM1377a, "com.huawei.android.hicloud");
            Bundle bundle = new Bundle();
            bundle.putString("android.substName", contextM1377a.getResources().getString(R$string.HiCloud_app_name));
            builderM1647f.m3823x(true);
            this.f774a.notify(22, builderM1647f.m3824y(R$drawable.logo_about_system).m3803c(bundle).m3800C(System.currentTimeMillis()).m3817r("com.huawei.android.hicloud").m3818s(true).m3807h(true).m3804d());
            AbstractC10896a.m65887i("AccountNotificationManager", "notificationGroupDone");
        }
    }

    /* renamed from: e */
    public void m79453e() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            AbstractC10896a.m65887i("AccountNotificationManager", "context is null");
            return;
        }
        if (C0209d.m1173G1(contextM1377a)) {
            AbstractC10896a.m65887i("AccountNotificationManager", "sendSTInvalidNotification, isPrivacyUser, now exit Cloud!");
            return;
        }
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(contextM1377a, 0, C13612b.m81829B().m81898z(), HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
        String string = contextM1377a.getString(R$string.st_tips_notification_st_invalid);
        Bundle bundle = new Bundle();
        Resources resources = contextM1377a.getResources();
        int i10 = R$string.HiCloud_app_name;
        bundle.putString("android.substName", resources.getString(i10));
        String string2 = contextM1377a.getString(R$string.st_tips_notification_title);
        this.f774a.notify(275, C0238w.m1663f().m1668i(contextM1377a, string2).m3823x(true).m3825z(new NotificationCompat.C0605b()).m3801a(0, contextM1377a.getResources().getString(R$string.st_tips_relogin), pendingIntentM1248e0).m3799B(contextM1377a.getResources().getString(i10)).m3811l(string2).m3810k(string).m3809j(pendingIntentM1248e0).m3824y(R$drawable.logo_about_system).m3815p(bundle).m3817r("com.huawei.android.hicloud").m3800C(System.currentTimeMillis()).m3807h(true).m3804d());
        long jCurrentTimeMillis = System.currentTimeMillis();
        C14303a.m85185a().m85197m(jCurrentTimeMillis);
        AbstractC10896a.m65887i("AccountNotificationManager", "ST invalid or SIM Card lock notify, currentTime: " + jCurrentTimeMillis);
        m79452d(false);
        InterfaceC13043a interfaceC13043aM80810H = C13452e.m80781L().m80810H();
        if (interfaceC13043aM80810H != null) {
            interfaceC13043aM80810H.mo78694e(contextM1377a, "show_notification", "1");
            interfaceC13043aM80810H.mo78692c("PVC", "show_notification", "4", "4");
            interfaceC13043aM80810H.mo78690a(contextM1377a, "notification", "notification");
        }
    }
}
