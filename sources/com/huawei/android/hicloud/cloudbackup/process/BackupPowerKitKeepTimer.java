package com.huawei.android.hicloud.cloudbackup.process;

import android.text.TextUtils;
import p015ak.C0219i;
import p514o9.C11839m;
import p847zk.C14316i;

/* loaded from: classes2.dex */
public class BackupPowerKitKeepTimer {
    private static final long EXPIRE_TIME = 600000;
    private static final BackupPowerKitKeepTimer INSTANCE = new BackupPowerKitKeepTimer();
    private static final long LOG_EXPIRE_TIME = 60000;
    private static final String TAG = "BackupPowerKitKeepTimer";
    private int count;
    private Long keepAliveTime = null;
    private long powerKitKeepLogTime = 0;

    public static BackupPowerKitKeepTimer getInstance() {
        return INSTANCE;
    }

    private void printKeepAliveLog(boolean z10, boolean z11) {
        if (System.currentTimeMillis() - this.powerKitKeepLogTime < 60000) {
            return;
        }
        this.powerKitKeepLogTime = System.currentTimeMillis();
        C11839m.m70688i(TAG, "powerkit keepAlive isRestore: " + z10 + " ,expire: " + z11);
    }

    public String getApplyType(boolean z10) {
        return z10 ? "auto-cloudBackup-backup_apply" : "user-cloudBackup_apply";
    }

    public void keepAlive() {
        keepAlive("user-cloudBackup_apply", true);
    }

    public void remove(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "cloud backup apply power kit error applyType is empty");
            return;
        }
        C14316i.m85291e().m85297g(str);
        this.keepAliveTime = null;
        this.count = 0;
        this.powerKitKeepLogTime = 0L;
        C11839m.m70688i(TAG, "cloud backup remove power kit, task release. applyType = " + str);
    }

    public void keepAlive(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e(TAG, "cloud backup apply power kit error applyType is empty");
            return;
        }
        if (!C0219i.f814b || !CBAccess.hasTaskWorking()) {
            C11839m.m70688i(TAG, "cloud backup apply power kit error, task release, applyType = " + str);
            return;
        }
        boolean z11 = this.keepAliveTime == null || System.currentTimeMillis() - this.keepAliveTime.longValue() >= 600000;
        printKeepAliveLog(z10, z11);
        if (!z11) {
            C11839m.m70686d(TAG, "cloud backup apply power kit, count = " + this.count + " applyType = " + str + " ,keepAliveTime: " + this.keepAliveTime);
            return;
        }
        C14316i.m85291e().m85292a(str);
        this.keepAliveTime = Long.valueOf(System.currentTimeMillis());
        this.count++;
        C11839m.m70688i(TAG, "cloud backup apply power kit, count = " + this.count + " applyType = " + str);
    }

    public void keepAlive(String str) {
        keepAlive(str, false);
    }
}
