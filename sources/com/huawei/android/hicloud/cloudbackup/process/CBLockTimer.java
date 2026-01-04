package com.huawei.android.hicloud.cloudbackup.process;

import com.huawei.hicloud.request.cbs.bean.CBSFullBackup;
import fk.C9721b;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p458lo.C11322a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p581qk.AbstractC12369f;
import p616rk.C12515a;

/* loaded from: classes2.dex */
public class CBLockTimer extends AbstractC12369f {
    private static final String TAG = "CBLockTimer";
    private static final long TASK_PERIOD = 600;
    private static final long TIMEOUT = 400;
    private List<String> clientActionList;
    private CountDownLatch countDownLatch;
    private String deviceId;
    private int deviceType;
    private C9721b exception;
    private boolean isCancel;
    private String lockId;
    private Integer lockInterval;
    private int lockType;
    private final String powerKitApplyType;
    private C11322a protocol;

    public static class CBUnLockTask extends AbstractC12367d {
        private static final String TAG = "CBUnLockTask";
        private String backupId;
        private String deviceId;
        private int deviceType;
        private int lockType;
        private C11322a protocol;

        public CBUnLockTask(C11322a c11322a, String str, int i10, int i11) {
            this.deviceId = str;
            this.protocol = c11322a;
            this.deviceType = i10;
            this.lockType = i11;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            try {
                this.protocol.m68013T(this.deviceId, this.backupId, this.deviceType, this.lockType);
            } catch (C9721b unused) {
                C11839m.m70689w(TAG, "unlock device backup error.");
            }
        }

        public void setBackupId(String str) {
            this.backupId = str;
        }
    }

    @Deprecated
    public CBLockTimer(String str, String str2, int i10, String str3) {
        super(0L, TASK_PERIOD);
        this.clientActionList = null;
        this.countDownLatch = new CountDownLatch(1);
        this.deviceId = str;
        this.deviceType = i10;
        this.lockType = 0;
        this.protocol = new C11322a(str2);
        this.powerKitApplyType = str3;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            BackupPowerKitKeepTimer.getInstance().keepAlive(this.powerKitApplyType);
            this.countDownLatch = new CountDownLatch(1);
            CBSFullBackup cBSFullBackupM68038z = this.protocol.m68038z(this.deviceId, this.deviceType, this.lockType);
            this.clientActionList = cBSFullBackupM68038z.getClientActions();
            this.lockId = cBSFullBackupM68038z.getLockId();
            this.lockInterval = cBSFullBackupM68038z.getLockInterval();
            this.countDownLatch.countDown();
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "lock device backup error.");
            if (e10.m60659c() == 3107) {
                this.exception = e10;
            }
            cancel();
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean cancel() {
        C12515a.m75110o().m75172d(new CBUnLockTask(this.protocol, this.deviceId, this.deviceType, this.lockType));
        this.isCancel = true;
        this.countDownLatch.countDown();
        if (!CBAccess.hasTaskWorking()) {
            BackupPowerKitKeepTimer.getInstance().remove(this.powerKitApplyType);
        }
        return super.cancel();
    }

    public void cancelTimer() {
        this.isCancel = true;
        this.countDownLatch.countDown();
        super.cancel();
    }

    public List<String> getClientActionList() throws C9721b {
        while (this.countDownLatch.getCount() > 0 && this.exception == null && !this.isCancel) {
            try {
                this.countDownLatch.await(400L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e10) {
                C11839m.m70687e(TAG, "getClientActionList wait error." + e10.toString());
            }
        }
        C9721b c9721b = this.exception;
        if (c9721b == null) {
            return this.clientActionList;
        }
        throw c9721b;
    }

    public String getLockId() {
        return this.lockId;
    }

    public Integer getLockInterval() {
        return this.lockInterval;
    }

    public CBLockTimer(String str, String str2, int i10, int i11, String str3) {
        super(0L, TASK_PERIOD);
        this.clientActionList = null;
        this.countDownLatch = new CountDownLatch(1);
        this.deviceId = str;
        this.deviceType = i10;
        this.lockType = i11;
        this.protocol = new C11322a(str2);
        this.powerKitApplyType = str3;
    }
}
