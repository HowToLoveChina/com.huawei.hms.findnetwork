package com.huawei.android.hicloud.sync.service.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.android.hicloud.sync.service.aidl.ICSRemoteService;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class ICSServiceProtocol {
    private static final String TAG = "ICSServiceProtocol";
    private static ICSServiceProtocol protocol = new ICSServiceProtocol();
    private boolean isBound;
    private ServiceConnection mConnection;
    private Context mContext;
    private ICSRemoteService service;

    private ICSServiceProtocol() {
    }

    public static ICSServiceProtocol getInstance() {
        return protocol;
    }

    public void doAbort() {
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol.4
            @Override // com.huawei.android.hicloud.sync.service.aidl.IServiceProtocol
            public void execute() throws RemoteException {
                ICSServiceProtocol.this.service.doAbort();
            }
        });
    }

    public void doSyncContact(final SyncType syncType) {
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol.2
            @Override // com.huawei.android.hicloud.sync.service.aidl.IServiceProtocol
            public void execute() throws RemoteException {
                ICSServiceProtocol.this.service.doSyncContact(syncType);
            }
        });
    }

    public void doSyncWlan(final SyncType syncType) {
        serviceConnection(new IServiceProtocol() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol.3
            @Override // com.huawei.android.hicloud.sync.service.aidl.IServiceProtocol
            public void execute() throws RemoteException {
                ICSServiceProtocol.this.service.doSyncWlan(syncType);
            }
        });
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void serviceConnection(final IServiceProtocol iServiceProtocol) {
        this.mConnection = new ServiceConnection() { // from class: com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    C11839m.m70688i(ICSServiceProtocol.TAG, "ICSService connected");
                    if (ICSServiceProtocol.this.service == null) {
                        ICSServiceProtocol.this.service = ICSRemoteService.Stub.asInterface(iBinder);
                    }
                    try {
                        iServiceProtocol.execute();
                    } catch (RemoteException e10) {
                        C11839m.m70687e(ICSServiceProtocol.TAG, "ICSService: " + e10.toString());
                    }
                    if (ICSServiceProtocol.this.mContext != null) {
                        ICSServiceProtocol.this.mContext.unbindService(ICSServiceProtocol.this.mConnection);
                    }
                    ICSServiceProtocol.this.isBound = false;
                    ICSServiceProtocol.this.service = null;
                } catch (Exception e11) {
                    C11839m.m70687e(ICSServiceProtocol.TAG, "serviceConnection exception e = " + e11.toString());
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                C11839m.m70688i(ICSServiceProtocol.TAG, "ICBService disconnected");
                ICSServiceProtocol.this.isBound = false;
            }
        };
        ComponentName componentName = new ComponentName(this.mContext.getPackageName(), ICSService.class.getName());
        Intent intent = new Intent();
        intent.setComponent(componentName);
        boolean zBindService = this.mContext.bindService(intent, this.mConnection, 1);
        this.isBound = zBindService;
        if (zBindService) {
            return;
        }
        C11839m.m70689w(TAG, "bind ICBService failed.");
    }
}
