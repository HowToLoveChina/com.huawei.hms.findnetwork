package com.huawei.android.hicloud.cloudbackup.process.util;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p292fn.C9733f;
import p514o9.C11839m;
import p618rm.C12590s0;
import p711vl.C13464d;
import p848zl.C14337f;
import tl.C13029h;

/* loaded from: classes2.dex */
public class ConditionLimitCycleChecker implements ICycleChecker {
    private static final String TAG = "ConditionLimitCycleChecker";
    private long beyondCycleTime;
    private final Context context;
    private boolean isMainProcess;
    private long lastCycle;
    private long nextBackupTime;

    public ConditionLimitCycleChecker() {
        Context contextM1377a = C0213f.m1377a();
        this.context = contextM1377a;
        this.isMainProcess = C0209d.m1309t1(contextM1377a);
    }

    private void initAutoBackupCheckInfo(long j10) {
        long jM81037h;
        long jM81035e;
        long jM81037h2;
        this.beyondCycleTime = 0L;
        this.nextBackupTime = 0L;
        if (this.isMainProcess) {
            SettingOperator settingOperator = new SettingOperator();
            jM81037h = settingOperator.querylastsuccesstime();
            jM81035e = settingOperator.queryFinalBackupCycle();
            jM81037h2 = 0;
        } else {
            C13464d c13464dM81030f = C13464d.m81030f(this.context);
            jM81037h = c13464dM81030f.m81037h("lastsuccesstime");
            jM81035e = c13464dM81030f.m81035e();
            jM81037h2 = c13464dM81030f.m81037h("timeAdvanced") * 60000;
        }
        long j11 = j10 - jM81037h;
        if (j11 < 0) {
            j11 = 0;
        }
        if (jM81035e < 0) {
            jM81035e = 7;
        }
        long j12 = jM81035e * 86400000;
        this.lastCycle = j11 / j12;
        long j13 = j11 % j12;
        this.beyondCycleTime = j13;
        long j14 = j13 > 0 ? (j12 - j13) - jM81037h2 : 0L;
        C11839m.m70686d(TAG, "initAutoBackupCheckInfo lastSuccessTime: " + jM81037h + " ,lastCycle: " + this.lastCycle + " ,beyondCycle: " + this.beyondCycleTime + " ,toNextCycleLeftTime: " + j14);
        this.nextBackupTime = j10 + (j14 >= 0 ? j14 : 0L);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public long getTargetBackupTime() {
        initAutoBackupCheckInfo(System.currentTimeMillis());
        return this.nextBackupTime;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public String getType() {
        return "2";
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isCycleSatisfy() {
        return isCycleSatisfy(System.currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isSameCycle(long r7, long r9) {
        /*
            r6 = this;
            r0 = 0
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 <= 0) goto L2a
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L2a
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 <= 0) goto L2a
            r6.initAutoBackupCheckInfo(r7)
            long r0 = r6.lastCycle
            boolean r2 = r6.isCycleSatisfy()
            r6.initAutoBackupCheckInfo(r9)
            boolean r3 = r6.isCycleSatisfy()
            long r4 = r6.lastCycle
            if (r2 == 0) goto L2a
            if (r3 == 0) goto L2a
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 != 0) goto L2a
            r6 = 1
            goto L2b
        L2a:
            r6 = 0
        L2b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isSameCycle beforeTime: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = " ,afterTime: "
            r0.append(r7)
            r0.append(r9)
            java.lang.String r7 = " ,result: "
            r0.append(r7)
            r0.append(r6)
            java.lang.String r7 = r0.toString()
            java.lang.String r8 = "ConditionLimitCycleChecker"
            p514o9.C11839m.m70686d(r8, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.util.ConditionLimitCycleChecker.isSameCycle(long, long):boolean");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isValid() {
        long jM81037h;
        int iM1685c;
        if (!C9733f.m60705z().m60720O("cloudBackupRetryByBackupPeriod")) {
            return false;
        }
        List<Integer> listM85498a = C14337f.m85498a();
        if (this.isMainProcess) {
            jM81037h = new SettingOperator().querylastsuccesstime();
            C13029h c13029hM75886o2 = C12590s0.m75886o2();
            iM1685c = c13029hM75886o2 != null ? C0241z.m1685c(c13029hM75886o2.m78474q().replace("001_", "")) : 0;
        } else {
            int iM1685c2 = C0241z.m1685c(C13464d.m81030f(this.context).m81039j("backup_end_code", "").replace("001_", ""));
            jM81037h = C13464d.m81030f(this.context).m81037h("lastsuccesstime");
            iM1685c = iM1685c2;
        }
        C11839m.m70686d(TAG, "backup errcode: " + iM1685c + " ,lastSuccessTime: " + jM81037h);
        if (jM81037h <= 0) {
            return false;
        }
        return listM85498a.contains(Integer.valueOf(iM1685c));
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isCycleSatisfy(long j10) {
        initAutoBackupCheckInfo(j10);
        long j11 = this.lastCycle;
        return (j11 == 0 && this.beyondCycleTime == 0) || (this.beyondCycleTime < 86400000 && j11 > 0);
    }
}
