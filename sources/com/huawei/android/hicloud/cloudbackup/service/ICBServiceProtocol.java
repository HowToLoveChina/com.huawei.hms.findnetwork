package com.huawei.android.hicloud.cloudbackup.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.android.hicloud.cloudbackup.service.IRemoteService;
import p015ak.C0213f;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class ICBServiceProtocol {
    private static final String TAG = "ICBServiceProtocol";
    private int count = 0;
    private boolean isBound;
    private ServiceConnection mConnection;
    private IRemoteService service;
    private static ICBServiceProtocol protocol = new ICBServiceProtocol();
    private static final Object LOCK = new Object();

    private ICBServiceProtocol() {
    }

    private void addService() {
        synchronized (LOCK) {
            this.count++;
        }
    }

    public static ICBServiceProtocol getInstance() {
        return protocol;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeService() {
        synchronized (LOCK) {
            this.count--;
        }
    }

    private void serviceConnection(final IServiceProtocol iServiceProtocol) {
        final Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e(TAG, "context is null");
            return;
        }
        this.mConnection = new ServiceConnection() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    C11839m.m70688i(ICBServiceProtocol.TAG, "ICBService connected");
                    if (ICBServiceProtocol.this.service == null) {
                        ICBServiceProtocol.this.service = IRemoteService.Stub.asInterface(iBinder);
                    }
                    try {
                        iServiceProtocol.execute();
                    } catch (RemoteException e10) {
                        C11839m.m70687e(ICBServiceProtocol.TAG, "ICBService: " + e10.toString());
                    }
                    ICBServiceProtocol.this.removeService();
                    if (ICBServiceProtocol.this.count == 0 && ICBServiceProtocol.this.isBound) {
                        contextM1377a.unbindService(ICBServiceProtocol.this.mConnection);
                        ICBServiceProtocol.this.isBound = false;
                        ICBServiceProtocol.this.service = null;
                    }
                } catch (Exception e11) {
                    C11839m.m70687e(ICBServiceProtocol.TAG, "service connection error." + e11.getMessage());
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                C11839m.m70688i(ICBServiceProtocol.TAG, "ICBService disconnected");
                ICBServiceProtocol.this.isBound = false;
            }
        };
        ComponentName componentName = new ComponentName(contextM1377a.getPackageName(), ICBService.class.getName());
        Intent intent = new Intent();
        intent.setComponent(componentName);
        boolean zBindService = contextM1377a.bindService(intent, this.mConnection, 1);
        this.isBound = zBindService;
        if (zBindService) {
            return;
        }
        C11839m.m70689w(TAG, "bind ICBService failed.");
    }

    public void callNotifyServer(final String str) {
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol.5
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                ICBServiceProtocol.this.service.callNotifyServer(str);
            }
        });
    }

    public void doAbort(final int i10) {
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol.7
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                ICBServiceProtocol.this.service.doAbort(i10);
            }
        });
    }

    public void doBackup() {
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol.2
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                ICBServiceProtocol.this.service.doBackup();
            }
        });
    }

    public void doBackupNotify() {
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol.4
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                ICBServiceProtocol.this.service.doBackupNotify();
            }
        });
    }

    public void doGetBackupOptions() {
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol.10
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                ICBServiceProtocol.this.service.doGetBackupOptions();
            }
        });
    }

    public boolean doNewBackup(final String str) {
        final boolean[] zArr = {false};
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol.3
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                zArr[0] = ICBServiceProtocol.this.service.doNewBackup(str);
            }
        });
        return zArr[0];
    }

    public void doNewBackupNotify(final long j10, final long j11) {
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol.6
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                ICBServiceProtocol.this.service.doNewBackupNotify(j10, j11);
            }
        });
    }

    public void doPause() {
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol.9
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                ICBServiceProtocol.this.service.doPause();
            }
        });
    }

    public void doRestore(final int i10) {
        addService();
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol.8
            @Override // com.huawei.android.hicloud.cloudbackup.service.IServiceProtocol
            public void execute() throws RemoteException {
                ICBServiceProtocol.this.service.doRestore(i10);
            }
        });
    }
}
