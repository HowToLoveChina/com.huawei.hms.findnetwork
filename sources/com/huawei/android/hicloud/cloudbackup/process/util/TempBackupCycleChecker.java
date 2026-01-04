package com.huawei.android.hicloud.cloudbackup.process.util;

import p015ak.C0213f;
import p514o9.C11839m;
import p711vl.C13464d;

/* loaded from: classes2.dex */
public class TempBackupCycleChecker extends OriginCycleChecker {
    private static final String TAG = "TempBackupCycleChecker";

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.OriginCycleChecker, com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public String getType() {
        return "0";
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.OriginCycleChecker, com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isCycleSatisfy() {
        C11839m.m70688i(TAG, "isCycleSatisfy backupAction: interim backup");
        return true;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.OriginCycleChecker, com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isValid() {
        C13464d c13464dM81030f = C13464d.m81030f(C0213f.m1377a());
        String strM81039j = c13464dM81030f.m81039j("backupAction", "");
        String strM81039j2 = c13464dM81030f.m81039j("CACHED_GRADE_CODE", "");
        long jM81037h = c13464dM81030f.m81037h("expired_time");
        if ("interim".equals(strM81039j)) {
            return true;
        }
        C11839m.m70686d(TAG, "isValid false,backupAction:" + strM81039j + ",gradeCode:" + strM81039j2 + ",expiredTime:" + jM81037h);
        return false;
    }
}
