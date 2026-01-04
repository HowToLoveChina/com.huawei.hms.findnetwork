package com.huawei.openalliance.p169ad;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;

/* renamed from: com.huawei.openalliance.ad.lj */
/* loaded from: classes8.dex */
public abstract class AbstractC7400lj {

    /* renamed from: a */
    protected Context f34416a;

    /* renamed from: b */
    NotificationManager f34417b;

    public AbstractC7400lj(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f34416a = applicationContext;
        this.f34417b = (NotificationManager) applicationContext.getSystemService("notification");
    }

    /* renamed from: g */
    private Notification.Builder m45595g() {
        Notification.Builder builder = new Notification.Builder(this.f34416a);
        builder.setContentTitle(mo45480c());
        builder.setContentText(mo45482e());
        builder.setWhen(System.currentTimeMillis());
        builder.setShowWhen(true);
        builder.setContentIntent(mo45483f());
        builder.setAutoCancel(true);
        ApplicationInfo applicationInfo = this.f34416a.getApplicationInfo();
        if (applicationInfo != null) {
            builder.setSmallIcon(applicationInfo.icon);
        }
        return builder;
    }

    /* renamed from: h */
    private String m45596h() {
        return "hwpps";
    }

    /* renamed from: a */
    public abstract int mo45477a();

    /* renamed from: a */
    public abstract void mo45478a(Notification.Builder builder);

    /* renamed from: b */
    public void mo45479b() {
        Notification.Builder builderM45595g = m45595g();
        mo45478a(builderM45595g);
        NotificationChannel notificationChannel = new NotificationChannel(m45596h(), mo45481d(), 3);
        notificationChannel.setShowBadge(false);
        notificationChannel.enableLights(false);
        builderM45595g.setChannelId(m45596h());
        this.f34417b.createNotificationChannel(notificationChannel);
        this.f34417b.notify(mo45477a(), builderM45595g.build());
    }

    /* renamed from: c */
    public abstract String mo45480c();

    /* renamed from: d */
    public String mo45481d() {
        return "BaseNotification";
    }

    /* renamed from: e */
    public abstract String mo45482e();

    /* renamed from: f */
    public abstract PendingIntent mo45483f();
}
