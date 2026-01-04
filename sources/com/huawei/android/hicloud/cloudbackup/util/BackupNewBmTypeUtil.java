package com.huawei.android.hicloud.cloudbackup.util;

import p514o9.C11839m;
import p618rm.C12590s0;
import p618rm.C12591s1;
import p709vj.C13452e;

/* loaded from: classes2.dex */
public class BackupNewBmTypeUtil {
    private static final String TAG = "BackupNewBmTypeUtil";

    public static boolean isBaseBusinessAndNotRef(Boolean bool) {
        return !isRefurbish(bool).booleanValue() && isBasicBusiness();
    }

    public static boolean isBasicBusiness() {
        return C13452e.m80781L().m80791C0();
    }

    public static boolean isNewBmUserBackupOnlyBaseData() {
        boolean z10 = C12590s0.m75861i1(C13452e.m80781L().m80790C()) || C12590s0.m75893q1();
        C11839m.m70688i(TAG, "isNewBmUserBackupOnlyBaseData:" + z10);
        return z10;
    }

    private static Boolean isRefurbish(Boolean bool) {
        return bool == null ? Boolean.valueOf(C12591s1.m75931a().m75941k()) : bool;
    }
}
