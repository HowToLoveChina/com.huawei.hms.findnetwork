package com.huawei.android.remotecontrol.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.huawei.android.remotecontrol.sdk.R$drawable;
import com.huawei.android.remotecontrol.sdk.R$string;
import p015ak.C0238w;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class PhoneFinderNotificationMgr {

    /* renamed from: a */
    public final Context f19981a;

    /* renamed from: b */
    public final NotificationManager f19982b;

    public PhoneFinderNotificationMgr(Context context) {
        this.f19981a = context;
        this.f19982b = (NotificationManager) context.getSystemService("notification");
    }

    /* renamed from: a */
    public void m26376a(int i10) {
        C13981a.m83989i("PhoneFinderNotificationMgr", "cancelNotify");
        try {
            this.f19982b.cancel(i10);
            this.f19982b.cancel(573);
        } catch (Exception e10) {
            C13981a.m83988e("PhoneFinderNotificationMgr", "cancelNotify, err: " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public void m26377b() {
        C13981a.m83989i("PhoneFinderNotificationMgr", "createNotificationGroup");
        if (this.f19982b.getActiveNotifications().length < 1) {
            return;
        }
        String string = this.f19981a.getString(R$string.start_finder_phone_new);
        NotificationCompat.Builder builderM1666g = C0238w.m1663f().m1666g(this.f19981a, string);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", string);
        bundle.putBoolean("hw_enable_small_icon", true);
        builderM1666g.m3823x(true);
        this.f19982b.notify(573, builderM1666g.m3824y(R$drawable.ic_findmyphone_new).m3803c(bundle).m3800C(System.currentTimeMillis()).m3817r("com.huawei.android.findphone").m3818s(true).m3807h(true).m3804d());
    }

    /* renamed from: c */
    public void m26378c(int i10, Notification notification) {
        C13981a.m83989i("PhoneFinderNotificationMgr", "sendNotify");
        m26377b();
        this.f19982b.notify(i10, notification);
    }

    /* renamed from: d */
    public void m26379d(String str, int i10, Notification notification) {
        C13981a.m83989i("PhoneFinderNotificationMgr", "sendNotify with tag");
        m26377b();
        this.f19982b.notify(str, i10, notification);
    }
}
