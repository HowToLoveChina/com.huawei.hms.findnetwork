package com.huawei.remoteplayer;

import android.content.Intent;
import android.os.IBinder;
import com.huawei.hms.videokit.player.C6550c1;

/* loaded from: classes5.dex */
public class LocalService extends RemoteService {
    @Override // com.huawei.remoteplayer.RemoteService, android.app.Service
    public IBinder onBind(Intent intent) {
        C6550c1.m37264c("LocalService", "onBind");
        return super.onBind(intent);
    }

    @Override // com.huawei.remoteplayer.RemoteService, android.app.Service
    public void onCreate() {
        C6550c1.m37264c("LocalService", "onCreate");
        super.onCreate();
    }

    @Override // com.huawei.remoteplayer.RemoteService, android.app.Service
    public boolean onUnbind(Intent intent) {
        C6550c1.m37264c("LocalService", "onUnbind");
        return super.onUnbind(intent);
    }
}
