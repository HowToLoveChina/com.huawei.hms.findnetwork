package com.huawei.android.hicloud.cloudbackup.process.util;

import p015ak.C0213f;
import p514o9.C11839m;
import p711vl.C13464d;

/* loaded from: classes2.dex */
public class RefurbishmentCycleChecker extends OriginCycleChecker {
    private static final String TAG = "RefurbishmentCycleChecker";

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.OriginCycleChecker, com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public String getType() {
        return "1";
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.OriginCycleChecker, com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isCycleSatisfy() {
        C11839m.m70688i(TAG, "isCycleSatisfy backupAction: Refurbishment");
        return true;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.util.OriginCycleChecker, com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker
    public boolean isValid() {
        return "Refurbishment".equals(C13464d.m81030f(C0213f.m1377a()).m81039j("backupAction", ""));
    }
}
