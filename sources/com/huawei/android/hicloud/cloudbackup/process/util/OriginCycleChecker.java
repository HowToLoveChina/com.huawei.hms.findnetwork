package com.huawei.android.hicloud.cloudbackup.process.util;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p711vl.C13464d;

/* loaded from: classes2.dex */
public class OriginCycleChecker implements ICycleChecker {
    private static final String TAG = "OriginCycleChecker";
    private long backupCycle;
    private final Context context;
    private final boolean isMainProcess;
    private long lastSuccessTime;
    private long timeAdvanced;

    public OriginCycleChecker() {
        Context contextM1377a = C0213f.m1377a();
        this.context = contextM1377a;
        this.isMainProcess = C0209d.m1309t1(contextM1377a);
    }

    private void initAutoBackupCheckInfo() {
        if (this.isMainProcess) {
            this.lastSuccessTime = new SettingOperator().querylastsuccesstime();
            this.backupCycle = r0.queryFinalBackupCycle();
            this.timeAdvanced = 0L;
            return;
        }
        C13464d c13464dM81030f = C13464d.m81030f(C0213f.m1377a());
        this.lastSuccessTime = c13464dM81030f.m81037h("lastsuccesstime");
        this.backupCycle = c13464dM81030f.m81035e();
        this.timeAdvanced = c13464dM81030f.m81037h("timeAdvanced") * 60000;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public long getTargetBackupTime() {
        initAutoBackupCheckInfo();
        C11839m.m70688i(TAG, "getTargetBackupTime  lastSuccessTime: " + this.lastSuccessTime + ", backupCycle: " + this.backupCycle);
        return (this.lastSuccessTime + (this.backupCycle * 86400000)) - this.timeAdvanced;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public String getType() {
        return "3";
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isCycleSatisfy() {
        return isCycleSatisfy(System.currentTimeMillis());
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isSameCycle(long j10, long j11) {
        boolean z10 = j10 > 0 && j11 > 0 && j11 > j10 && j11 - j10 <= 86400000;
        C11839m.m70686d(TAG, "isSameCycle beforeTime: " + j10 + " ,afterTime: " + j11 + " ,result: " + z10);
        return z10;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isValid() {
        return true;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isCycleSatisfy(long j10) {
        initAutoBackupCheckInfo();
        long j11 = j10 - this.lastSuccessTime;
        C11839m.m70688i(TAG, "backup interval millis = " + j11 + ", lastSuccessTime: " + this.lastSuccessTime + ", backupCycle: " + this.backupCycle);
        return j11 >= (this.backupCycle * 86400000) - this.timeAdvanced;
    }
}
