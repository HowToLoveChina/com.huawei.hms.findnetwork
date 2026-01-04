package com.huawei.android.hicloud.sync.service.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.android.hicloud.sync.service.aidl.ICDRemoteService;
import p015ak.C0213f;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class ICDServiceProtocol {
    private static final String TAG = "ICDServiceProtocol";
    private static ICDServiceProtocol protocol = new ICDServiceProtocol();
    private boolean isBound;
    private ServiceConnection mConnection;
    private Context mContext;
    private ICDRemoteService service;

    private ICDServiceProtocol() {
    }

    public static ICDServiceProtocol getInstance() {
        return protocol;
    }

    public void abort(final int i10) {
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICDServiceProtocol.6
            @Override // com.huawei.android.hicloud.sync.service.aidl.IServiceProtocol
            public void execute() throws RemoteException {
                ICDServiceProtocol.this.service.doAbort(i10);
            }
        });
    }

    public void doBackupCallog() {
        if (this.mContext == null) {
            this.mContext = C0213f.m1377a();
        }
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICDServiceProtocol.3
            @Override // com.huawei.android.hicloud.sync.service.aidl.IServiceProtocol
            public void execute() throws RemoteException {
                ICDServiceProtocol.this.service.doBackupCalllog();
            }
        });
    }

    public void doBackupPhoneManager() {
        if (this.mContext == null) {
            this.mContext = C0213f.m1377a();
        }
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICDServiceProtocol.5
            @Override // com.huawei.android.hicloud.sync.service.aidl.IServiceProtocol
            public void execute() throws RemoteException {
                ICDServiceProtocol.this.service.doBackupPhoneManager();
            }
        });
    }

    public void doBackupRecording() {
        if (this.mContext == null) {
            this.mContext = C0213f.m1377a();
        }
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICDServiceProtocol.4
            @Override // com.huawei.android.hicloud.sync.service.aidl.IServiceProtocol
            public void execute() throws RemoteException {
                ICDServiceProtocol.this.service.doBackupRecording();
            }
        });
    }

    public void doBackupSms() {
        if (this.mContext == null) {
            this.mContext = C0213f.m1377a();
        }
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICDServiceProtocol.2
            @Override // com.huawei.android.hicloud.sync.service.aidl.IServiceProtocol
            public void execute() throws RemoteException {
                ICDServiceProtocol.this.service.doBackupSms();
            }
        });
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void processBattery(final int i10) {
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICDServiceProtocol.7
            @Override // com.huawei.android.hicloud.sync.service.aidl.IServiceProtocol
            public void execute() throws RemoteException {
                ICDServiceProtocol.this.service.processBattery(i10);
            }
        });
    }

    public void serviceConnection(final IServiceProtocol iServiceProtocol) {
        this.mConnection = new ServiceConnection() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICDServiceProtocol.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    C11839m.m70688i(ICDServiceProtocol.TAG, "ICDService connected");
                    if (ICDServiceProtocol.this.service == null) {
                        ICDServiceProtocol.this.service = ICDRemoteService.Stub.asInterface(iBinder);
                    }
                    try {
                        iServiceProtocol.execute();
                    } catch (RemoteException e10) {
                        C11839m.m70687e(ICDServiceProtocol.TAG, "ICDService: " + e10.toString());
                    }
                    ICDServiceProtocol.this.mContext.unbindService(ICDServiceProtocol.this.mConnection);
                    ICDServiceProtocol.this.isBound = false;
                    ICDServiceProtocol.this.service = null;
                } catch (Exception e11) {
                    C11839m.m70687e(ICDServiceProtocol.TAG, "serviceConnection exception e = " + e11.toString());
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                C11839m.m70688i(ICDServiceProtocol.TAG, "ICDService disconnected");
                ICDServiceProtocol.this.isBound = false;
            }
        };
        ComponentName componentName = new ComponentName(this.mContext.getPackageName(), ICDService.class.getName());
        Intent intent = new Intent();
        intent.setComponent(componentName);
        boolean zBindService = this.mContext.bindService(intent, this.mConnection, 1);
        this.isBound = zBindService;
        if (zBindService) {
            return;
        }
        C11839m.m70689w(TAG, "bind ICDService failed.");
    }
}
