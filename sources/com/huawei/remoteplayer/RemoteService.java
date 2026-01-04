package com.huawei.remoteplayer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.videokit.player.C6550c1;
import com.huawei.hms.videokit.player.C6554e;
import com.huawei.hms.videokit.player.internal.InterfaceC6576k;

/* loaded from: classes5.dex */
public class RemoteService extends Service {

    /* renamed from: a */
    public InterfaceC6576k f40459a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C6550c1.m37264c("RemoteService", "onBind");
        try {
            IBinder iBinderM37341a = C6554e.m37335a(this).m37341a("com.huawei.hms.videokit.player.IServiceBinderImp");
            if (iBinderM37341a == null) {
                return null;
            }
            InterfaceC6576k interfaceC6576kM37423a = InterfaceC6576k.a.m37423a(iBinderM37341a);
            this.f40459a = interfaceC6576kM37423a;
            if (interfaceC6576kM37423a == null) {
                return null;
            }
            C6550c1.m37264c("RemoteService", "getRemoteContext()" + C6554e.m37335a(this).m37343c());
            return this.f40459a.mo37421a(ObjectWrapper.wrap(this), ObjectWrapper.wrap(C6554e.m37335a(this).m37343c()), ObjectWrapper.wrap(intent));
        } catch (Exception e10) {
            C6550c1.m37258a("RemoteService", "create WisePlayerImp fail ", e10);
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        C6550c1.m37264c("RemoteService", "onCreate");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        C6550c1.m37264c("RemoteService", "onUnbind");
        super.onUnbind(intent);
        InterfaceC6576k interfaceC6576k = this.f40459a;
        if (interfaceC6576k == null) {
            return true;
        }
        try {
            interfaceC6576k.mo37422d();
            return true;
        } catch (Exception e10) {
            C6550c1.m37258a("RemoteService", "onUnbind:", e10);
            return true;
        }
    }
}
