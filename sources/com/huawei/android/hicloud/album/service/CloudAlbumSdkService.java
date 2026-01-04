package com.huawei.android.hicloud.album.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.huawei.android.hicloud.album.service.ICallbackHelper;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.android.p069cg.logic.manager.CloudAlbumManager;
import com.huawei.android.p069cg.p072vo.SettingsProp;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.secure.android.common.intent.SafeIntent;
import p009a8.C0078p;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1124e;
import p031b7.C1136q;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes2.dex */
public class CloudAlbumSdkService extends Service {

    /* renamed from: a */
    public RemoteCallbackList<ICloudAlbumSdkServiceCallback> f11502a;

    /* renamed from: b */
    public BinderC2417d f11503b;

    /* renamed from: c */
    public BinderC2407b f11504c;

    /* renamed from: d */
    public Context f11505d = null;

    /* renamed from: com.huawei.android.hicloud.album.service.CloudAlbumSdkService$a */
    public class C2406a extends AbstractC12367d {
        public C2406a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C1124e.m6877u(CloudAlbumSdkService.this.f11505d);
        }
    }

    /* renamed from: com.huawei.android.hicloud.album.service.CloudAlbumSdkService$b */
    public class BinderC2407b extends ICallbackHelper.AbstractBinderC2408a {

        /* renamed from: a */
        public RemoteCallbackList<ICloudAlbumSdkServiceCallback> f11507a;

        /* renamed from: b */
        public BinderC2417d f11508b;

        public BinderC2407b(RemoteCallbackList<ICloudAlbumSdkServiceCallback> remoteCallbackList, BinderC2417d binderC2417d) {
            this.f11507a = remoteCallbackList;
            this.f11508b = binderC2417d;
        }

        @Override // com.huawei.android.hicloud.album.service.ICallbackHelper
        public void invokeEvent(int i10, Bundle bundle) throws RemoteException {
            if (i10 <= 1000 || i10 >= 1100) {
                this.f11508b.invokeEvent(i10, bundle);
            } else if (bundle != null) {
                this.f11508b.m15087J(i10, bundle.getBoolean("State", true));
            }
        }

        @Override // com.huawei.android.hicloud.album.service.ICallbackHelper
        public boolean registerCallback(ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback) throws RemoteException {
            C1120a.m6677i("CloudAlbumSdkService", "registerCallback");
            if (iCloudAlbumSdkServiceCallback != null) {
                C1120a.m6677i("CloudAlbumSdkService", "register callback success");
                return this.f11507a.register(iCloudAlbumSdkServiceCallback);
            }
            C1120a.m6676e("CloudAlbumSdkService", "registerCallback fail");
            return false;
        }

        @Override // com.huawei.android.hicloud.album.service.ICallbackHelper
        public void sendMessage(int i10, Bundle bundle) throws RemoteException {
            this.f11508b.sendMessage(i10, bundle);
        }

        @Override // com.huawei.android.hicloud.album.service.ICallbackHelper
        public void unregisterCallback(ICloudAlbumSdkServiceCallback iCloudAlbumSdkServiceCallback) throws RemoteException {
            C1120a.m6677i("CloudAlbumSdkService", "unregisterCallback");
            if (iCloudAlbumSdkServiceCallback == null) {
                C1120a.m6676e("CloudAlbumSdkService", "unregisterCallback fail");
            } else {
                C1120a.m6677i("CloudAlbumSdkService", "unregister callback");
                this.f11507a.unregister(iCloudAlbumSdkServiceCallback);
            }
        }
    }

    /* renamed from: a */
    public final void m15029a() {
        C12515a.m75110o().m75175e(new C2406a(), false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C1120a.m6677i("CloudAlbumSdkService", "onBind");
        String action = new SafeIntent(intent).getAction();
        if (action != null) {
            C1120a.m6677i("CloudAlbumSdkService", "onBind, action: " + action);
            if (action.equals(CloudAlbumSdkService.class.getName())) {
                this.f11503b.getSyncStrategy().m60405K(false);
                C0078p.m636d().m641g();
                this.f11503b.m15121p0(true);
                boolean zM6717M1 = C1122c.m6717M1(this.f11505d);
                CloudAlbumSettings.m14363h().m14367D(zM6717M1);
                this.f11503b.getSyncStrategy().m60400F(!zM6717M1);
                return this.f11503b;
            }
            if (action.equals(ICallbackHelper.class.getName())) {
                return this.f11504c;
            }
        }
        return this.f11503b;
    }

    @Override // android.app.Service
    public void onCreate() {
        C1120a.m6677i("CloudAlbumSdkService", "onCreate");
        super.onCreate();
        this.f11505d = getApplicationContext();
        this.f11502a = new RemoteCallbackList<>();
        this.f11503b = new BinderC2417d(this.f11505d, this.f11502a);
        this.f11504c = new BinderC2407b(this.f11502a, this.f11503b);
        m15029a();
        SettingsProp settingsPropM7118a = C1136q.c.m7118a(this.f11505d);
        if (settingsPropM7118a.getThumbHeight() == 0 || settingsPropM7118a.getThumbWidth() == 0) {
            C1136q.c.m7122e(this.f11505d);
        }
        CloudAlbumManager.m14456v().m14487g(this.f11505d);
        C1122c.m6788h2("");
    }

    @Override // android.app.Service
    public void onDestroy() {
        C1120a.m6677i("CloudAlbumSdkService", "onDestroy");
        this.f11503b.m15136x();
        try {
            this.f11502a.kill();
        } catch (Exception unused) {
            C1120a.m6676e("CloudAlbumSdkService", "albumSdkCallbacks kill error");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        C1120a.m6677i("CloudAlbumSdkService", "onRebind");
        super.onRebind(intent);
        if (intent == null) {
            C1120a.m6678w("CloudAlbumSdkService", "intent is null.");
            return;
        }
        String action = intent.getAction();
        if (action != null) {
            C1120a.m6677i("CloudAlbumSdkService", "onRebind, action: " + action);
            if (action.equals(CloudAlbumSdkService.class.getName())) {
                this.f11503b.getSyncStrategy().m60405K(false);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        C1120a.m6677i("CloudAlbumSdkService", "begin onStartCommand");
        if (intent == null) {
            C1120a.m6676e("CloudAlbumSdkService", "onStartCommand, intent is null");
            return 2;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        int intExtra = hiCloudSafeIntent.getIntExtra("Command", 1000);
        this.f11503b.m15087J(intExtra, hiCloudSafeIntent.getBooleanExtra("State", true));
        C1120a.m6677i("CloudAlbumSdkService", "end onStartCommand, cmdId: " + intExtra);
        return super.onStartCommand(intent, i10, i11);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        C1120a.m6677i("CloudAlbumSdkService", "onUnbind");
        if (intent == null) {
            C1120a.m6678w("CloudAlbumSdkService", "intent is null.");
            return false;
        }
        String action = intent.getAction();
        if (action != null) {
            C1120a.m6677i("CloudAlbumSdkService", "onUnbind, intent action: " + action);
            if (action.equals("com.huawei.android.hicloud.album.service.CloudAlbumSdkService")) {
                this.f11503b.m15127s0();
                this.f11503b.m15121p0(false);
                C0078p.m636d().m640f(this.f11505d);
            }
        }
        return super.onUnbind(intent);
    }
}
