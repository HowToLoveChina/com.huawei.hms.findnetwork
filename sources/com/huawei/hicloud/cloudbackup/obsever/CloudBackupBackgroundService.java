package com.huawei.hicloud.cloudbackup.obsever;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class CloudBackupBackgroundService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C11839m.m70688i("CloudBackupBackgroundService", "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i("CloudBackupBackgroundService", "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 2;
    }
}
