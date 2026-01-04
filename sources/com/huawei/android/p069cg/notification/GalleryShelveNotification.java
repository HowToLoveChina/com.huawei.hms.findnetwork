package com.huawei.android.p069cg.notification;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.huawei.android.p069cg.R$drawable;
import com.huawei.android.p069cg.R$plurals;
import com.huawei.android.p069cg.R$string;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.Calendar;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0238w;
import p031b7.C1122c;
import p031b7.C1136q;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p514o9.C11839m;
import p850zo.InterfaceC14350a;

/* loaded from: classes2.dex */
public class GalleryShelveNotification {

    /* renamed from: a */
    public int f11026a;

    /* renamed from: b */
    public boolean f11027b;

    /* renamed from: c */
    public Context f11028c;

    /* renamed from: d */
    public NotificationManager f11029d;

    /* renamed from: e */
    @SuppressLint({"HandlerLeak"})
    public Handler f11030e = new HandlerC2312b();

    /* renamed from: com.huawei.android.cg.notification.GalleryShelveNotification$a */
    public class C2311a implements InterfaceC14350a {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC9282a f11031a;

        public C2311a(InterfaceC9282a interfaceC9282a) {
            this.f11031a = interfaceC9282a;
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: a */
        public void mo13562a() {
            this.f11031a.mo58439l(GalleryShelveNotification.this.f11028c, 0, 0L);
            GalleryShelveNotification.this.f11027b = false;
            GalleryShelveNotification.this.f11030e.sendEmptyMessage(0);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: b */
        public void mo13563b() {
            GalleryShelveNotification.this.f11027b = false;
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: c */
        public void mo13564c() {
            this.f11031a.mo58439l(GalleryShelveNotification.this.f11028c, -1, 0L);
            GalleryShelveNotification.this.f11027b = false;
            GalleryShelveNotification.this.f11030e.sendEmptyMessage(0);
        }

        @Override // p850zo.InterfaceC14350a
        /* renamed from: d */
        public void mo13565d(int i10, int i11, long j10, int i12) {
            this.f11031a.mo58439l(GalleryShelveNotification.this.f11028c, 1, j10);
            GalleryShelveNotification.this.f11027b = true;
            GalleryShelveNotification galleryShelveNotification = GalleryShelveNotification.this;
            galleryShelveNotification.f11026a = C1122c.m6683B0(galleryShelveNotification.f11028c);
            GalleryShelveNotification.this.f11030e.sendEmptyMessage(0);
        }
    }

    /* renamed from: com.huawei.android.cg.notification.GalleryShelveNotification$b */
    public class HandlerC2312b extends Handler {
        public HandlerC2312b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            GalleryShelveNotification.this.m14548l();
        }
    }

    public GalleryShelveNotification(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f11028c = applicationContext;
        this.f11029d = (NotificationManager) applicationContext.getSystemService("notification");
    }

    /* renamed from: f */
    public void m14542f() {
        Context context = this.f11028c;
        if (context == null || !C0209d.m1333z1(context)) {
            return;
        }
        AlarmManager alarmManager = (AlarmManager) this.f11028c.getSystemService("alarm");
        Intent intent = new Intent(this.f11028c.getApplicationContext(), (Class<?>) GalleryShelveNotificationReceiver.class);
        intent.setAction("com.huawei.hidisk.gallery.shelvenotifyaction");
        alarmManager.cancel(PendingIntent.getBroadcast(this.f11028c, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK));
        try {
            this.f11029d.cancel(65593);
        } catch (Exception unused) {
            C11839m.m70687e("GalleryShelveNotification", "cancelNotifyTimer exception");
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryShelveNotification", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58443n(this.f11028c, false);
        }
    }

    /* renamed from: g */
    public void m14543g() {
        Context context = this.f11028c;
        if (context != null && C1136q.b.m7051d0(context)) {
            long jM7027T = C1136q.b.m7027T(this.f11028c);
            long jCurrentTimeMillis = (System.currentTimeMillis() - jM7027T) / 86400000;
            if (jCurrentTimeMillis < 7 && jCurrentTimeMillis >= 0) {
                m14546j(jM7027T);
            } else {
                if (C0209d.m1333z1(this.f11028c)) {
                    m14544h();
                    return;
                }
                this.f11026a = C1122c.m6683B0(this.f11028c);
                this.f11027b = C1136q.b.m7029U(this.f11028c) == 1;
                m14548l();
            }
        }
    }

    /* renamed from: h */
    public void m14544h() {
        if (this.f11028c == null) {
            return;
        }
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryShelveNotification", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58426g(new C2311a(interfaceC9282a));
        }
    }

    /* renamed from: i */
    public void m14545i() {
        Context context = this.f11028c;
        if (context == null) {
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(10, 9);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        calendar.set(9, 0);
        Intent intent = new Intent(this.f11028c.getApplicationContext(), (Class<?>) GalleryShelveNotificationReceiver.class);
        intent.setAction("com.huawei.hidisk.gallery.shelvenotifyaction");
        alarmManager.setExact(0, calendar.getTimeInMillis() + 604800000, PendingIntent.getBroadcast(this.f11028c, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK));
    }

    /* renamed from: j */
    public void m14546j(long j10) {
        Context context = this.f11028c;
        if (context == null) {
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(this.f11028c.getApplicationContext(), (Class<?>) GalleryShelveNotificationReceiver.class);
        intent.setAction("com.huawei.hidisk.gallery.shelvenotifyaction");
        alarmManager.setExact(0, j10 + 604800000, PendingIntent.getBroadcast(this.f11028c, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK));
    }

    /* renamed from: k */
    public void m14547k(boolean z10, int i10) throws Resources.NotFoundException {
        if (C0209d.m1166E1() && this.f11028c != null && i10 > 0) {
            Intent intent = new Intent();
            intent.setAction(NotifyConstants.Action.ACTION_GALLERYDETAIL_ACTIVITY);
            C0209d.m1302r2(intent, "com.huawei.hidisk");
            C0216g0.m1402e(this.f11028c).m1408F(intent, "SOURCE_ID_GALLERY_SHELVE_NOTIFY");
            PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(this.f11028c, 0, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            String string = this.f11028c.getResources().getString(R$string.gallery_main_shelved_title);
            NotificationCompat.Builder builderM1668i = C0238w.m1663f().m1668i(this.f11028c, string);
            Bundle bundle = new Bundle();
            bundle.putString("android.substName", this.f11028c.getResources().getString(R$string.HiCloud_app_name));
            builderM1668i.m3823x(true);
            String quantityString = this.f11028c.getResources().getQuantityString(R$plurals.gallery_shelve_notification_content, i10, Integer.valueOf(i10));
            NotificationCompat.C0605b c0605b = new NotificationCompat.C0605b();
            c0605b.m3839h(quantityString);
            builderM1668i.m3825z(c0605b);
            builderM1668i.m3810k(quantityString);
            Notification notificationM3804d = builderM1668i.m3811l(string).m3810k(quantityString).m3799B(string).m3809j(pendingIntentM1248e0).m3824y(R$drawable.logo_about_system).m3800C(System.currentTimeMillis()).m3803c(bundle).m3817r("com.huawei.android.hicloud").m3804d();
            notificationM3804d.flags = 65536 | 16;
            if (z10) {
                m14545i();
            }
            this.f11029d.notify(65593, notificationM3804d);
            m14549m();
            InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
            if (interfaceC9282a == null) {
                C11839m.m70688i("GalleryShelveNotification", "cloudAlbumRouterImpl is null");
            } else {
                interfaceC9282a.mo58443n(this.f11028c, true);
            }
        }
    }

    /* renamed from: l */
    public final void m14548l() throws Resources.NotFoundException {
        Context context = this.f11028c;
        if (context == null) {
            return;
        }
        GalleryShelveNotification galleryShelveNotification = new GalleryShelveNotification(context);
        if (!this.f11027b) {
            galleryShelveNotification.m14542f();
            return;
        }
        int i10 = this.f11026a;
        if (i10 >= 7) {
            galleryShelveNotification.m14547k(true, i10);
            return;
        }
        galleryShelveNotification.m14542f();
        int i11 = this.f11026a;
        if (i11 > 0) {
            galleryShelveNotification.m14547k(false, i11);
        }
    }

    /* renamed from: m */
    public final void m14549m() {
        if (this.f11028c == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(10, 9);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.set(9, 0);
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryShelveNotification", "cloudAlbumRouterImpl is null");
        } else {
            interfaceC9282a.mo58443n(this.f11028c, true);
            interfaceC9282a.mo58424f0(this.f11028c, calendar.getTimeInMillis());
        }
    }
}
