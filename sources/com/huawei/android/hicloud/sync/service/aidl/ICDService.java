package com.huawei.android.hicloud.sync.service.aidl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService;
import md.C11440c;
import p488n8.C11653a;

/* loaded from: classes3.dex */
public class ICDService extends Service {
    private Context context;
    private final ICDRemoteService.Stub mbinder = new ICDRemoteService.Stub() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICDService.1
        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void doAbort(int i10) throws RemoteException {
            C11440c.m68525a(false, i10);
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void doBackupCalllog() throws RemoteException {
            C11653a.m69582l().m69587c();
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void doBackupPhoneManager() throws RemoteException {
            C11653a.m69582l().m69588d();
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void doBackupRecording() throws RemoteException {
            C11653a.m69582l().m69589e();
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void doBackupSms() throws RemoteException {
            C11653a.m69582l().m69590f();
        }

        @Override // com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService
        public void processBattery(int i10) throws RemoteException {
            C11440c.m68535m(-14);
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mbinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
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
