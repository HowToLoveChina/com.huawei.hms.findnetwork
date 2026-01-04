package com.huawei.android.hicloud.sync.service.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService;
import md.C11440c;

/* loaded from: classes3.dex */
public class ICSService extends Service {
    private final ICSRemoteService.Stub mbinder = new ICSRemoteService.Stub() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICSService.1
        @Override // com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService
        public void doAbort() {
            C11440c.m68526b(false, 2024);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService
        public void doSyncContact(SyncType syncType) throws RemoteException {
            CloudSync.getInstance().doAutoSyncContact(syncType);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService
        public void doSyncWlan(SyncType syncType) throws RemoteException {
            CloudSync.getInstance().doAutoSyncWlan(syncType);
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mbinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 2;
    }
}
