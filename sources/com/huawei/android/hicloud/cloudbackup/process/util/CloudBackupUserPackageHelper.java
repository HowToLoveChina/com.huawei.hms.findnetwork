package com.huawei.android.hicloud.cloudbackup.process.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.cloud.pay.model.UserPackage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p341hj.C10250n0;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class CloudBackupUserPackageHelper {
    private static final long PACKAGE_55GB = 59055800320L;
    private static final long PACKAGE_5GB = 5368709120L;
    private static final String TAG = "CloudBackupUserPackageHelper";
    private static boolean isInit = false;
    private static volatile CloudBackupUserPackageHelper sInstance;
    private UserPackage userPackage;

    private CloudBackupUserPackageHelper(String str) {
        this.userPackage = null;
        this.userPackage = getUserPackage(str);
        isInit = true;
    }

    public static void clearCache() {
        if (sInstance == null) {
            return;
        }
        sInstance = null;
        isInit = false;
    }

    public static CloudBackupUserPackageHelper getInstance(String str) {
        synchronized (CloudBackupUserPackageHelper.class) {
            try {
                if (sInstance == null && !isInit) {
                    sInstance = new CloudBackupUserPackageHelper(str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return sInstance;
    }

    private UserPackage getUserPackage(String str) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        C11060c c11060c = new C11060c();
        c11060c.m66636B("06008");
        c11060c.m66643I(C11058a.m66627b("06008"));
        new C10250n0(new Handler(Looper.getMainLooper()) { // from class: com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupUserPackageHelper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 != 2001) {
                    if (i10 != 2101) {
                        if (i10 != 2131) {
                            if (i10 != 7019) {
                                C11839m.m70688i(CloudBackupUserPackageHelper.TAG, "getUserPackageInfo other recall");
                                countDownLatch.countDown();
                                return;
                            }
                        }
                    }
                    C11839m.m70688i(CloudBackupUserPackageHelper.TAG, "getUserPackageInfo failed");
                    countDownLatch.countDown();
                    return;
                }
                C11839m.m70688i(CloudBackupUserPackageHelper.TAG, "getUserPackageInfo success");
                CloudBackupUserPackageHelper cloudBackupUserPackageHelper = CloudBackupUserPackageHelper.this;
                cloudBackupUserPackageHelper.userPackage = cloudBackupUserPackageHelper.processUserPackageInfo(message);
                countDownLatch.countDown();
            }
        }, c11060c, true, "cloudBackup_" + str).m63381g();
        try {
            if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                C11839m.m70686d(TAG, "getUserPackage wait not finish");
            }
        } catch (InterruptedException unused) {
            C11839m.m70689w(TAG, "getUserPackage syncLock wait catch InterruptedException.");
        }
        return this.userPackage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserPackage processUserPackageInfo(Message message) {
        if (message == null) {
            C11839m.m70687e(TAG, "processGetActivityEntrySuccess entry success, but msg is null");
            return null;
        }
        Object obj = message.obj;
        if (!(obj instanceof UserPackage)) {
            C11839m.m70687e(TAG, "process get activity entry success, but msg obj is not GetActivityEntryResp");
            return null;
        }
        UserPackage userPackage = (UserPackage) obj;
        if (userPackage.getResultCode() == 0) {
            return userPackage;
        }
        return null;
    }

    public boolean is50gCloudPackageUser() {
        UserPackage userPackage = this.userPackage;
        return userPackage != null && userPackage.getTotalCapacity() > PACKAGE_5GB && this.userPackage.getTotalCapacity() <= PACKAGE_55GB;
    }

    public boolean is5gCloudPackageUser() {
        UserPackage userPackage = this.userPackage;
        return userPackage != null && userPackage.getTotalCapacity() <= PACKAGE_5GB;
    }

    public boolean isLargeCloudPackageUser() {
        UserPackage userPackage = this.userPackage;
        return userPackage != null && userPackage.getTotalCapacity() > PACKAGE_55GB;
    }

    public boolean isQueryUserPackageSuccess() {
        return this.userPackage != null && isInit;
    }
}
