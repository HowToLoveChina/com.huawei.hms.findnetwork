package com.huawei.location.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import as.C1016d;
import com.huawei.secure.android.common.intent.SafeIntent;

/* loaded from: classes8.dex */
public class BackGroundService extends Service {
    private static final String TAG = "BackGroundService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        C1016d.m6186f(TAG, "BackGroundService onDestroy");
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        C1016d.m6186f(TAG, "BackGroundService onStartCommand");
        if (intent != null) {
            SafeIntent safeIntent = new SafeIntent(intent);
            int intExtra = safeIntent.getIntExtra("notificationId", 0);
            Notification notification = (Notification) safeIntent.getParcelableExtra("notification");
            if (intExtra == 0 || notification == null) {
                C1016d.m6186f(TAG, "notificationId or notification is empty");
            } else {
                startForeground(intExtra, notification);
            }
        }
        return 0;
    }
}
