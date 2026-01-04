package com.huawei.hicloud.cloudbackup.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class CloudBackupNotificationService extends Service {

    /* renamed from: a */
    public static final String f22297a = "CloudBackupNotificationService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C11839m.m70688i(f22297a, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70688i(f22297a, "onDestroy");
        stopForeground(true);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent == null) {
            return 2;
        }
        boolean booleanExtra = new HiCloudSafeIntent(intent).getBooleanExtra(BackupNotification.KEY_IS_FOREGROUND, false);
        C11839m.m70688i(f22297a, "onStartCommand isForeground=" + booleanExtra);
        if (booleanExtra) {
            startForeground(26, BackupNotification.getInstance().buildPrepareNotification());
            return 2;
        }
        stopForeground(false);
        return 2;
    }
}
