package com.huawei.android.p069cg.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import p015ak.C0209d;
import p031b7.C1122c;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class GalleryShelveNotificationReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public Context f11034a;

    /* renamed from: b */
    public GalleryShelveNotification f11035b;

    /* renamed from: a */
    public final void m14550a() throws Resources.NotFoundException {
        int iM6683B0 = C1122c.m6683B0(this.f11034a);
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a == null) {
            C11839m.m70688i("GalleryShelveNotificationReceiver", "cloudAlbumRouterImpl is null");
        } else if (interfaceC9282a.mo58394T(this.f11034a) == 1) {
            if (iM6683B0 >= 7) {
                this.f11035b.m14547k(true, iM6683B0);
                return;
            }
            this.f11035b.m14542f();
            if (iM6683B0 > 0) {
                this.f11035b.m14547k(false, iM6683B0);
                return;
            }
            return;
        }
        this.f11035b.m14542f();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws Resources.NotFoundException {
        Context applicationContext = context.getApplicationContext();
        this.f11034a = applicationContext;
        this.f11035b = new GalleryShelveNotification(applicationContext);
        if (C0209d.m1333z1(this.f11034a)) {
            this.f11035b.m14544h();
        } else {
            m14550a();
        }
    }
}
