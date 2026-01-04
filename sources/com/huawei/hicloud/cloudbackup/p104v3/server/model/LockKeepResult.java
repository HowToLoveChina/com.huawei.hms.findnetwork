package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;
import p514o9.C11839m;

/* loaded from: classes6.dex */
public class LockKeepResult extends C11707b {
    public static final long DEFAULT_TASK_PERIOD = 480;
    private static final String TAG = "LockKeepResult";

    @InterfaceC4648p
    private Long lockKeepAlivePeriod;

    public long getLockKeepAlivePeriod() {
        Long l10 = this.lockKeepAlivePeriod;
        if (l10 != null && l10.longValue() > 0) {
            return this.lockKeepAlivePeriod.longValue();
        }
        C11839m.m70687e(TAG, "getLockKeepAlivePeriod error: " + this.lockKeepAlivePeriod);
        return 480L;
    }

    public void setLockKeepAlivePeriod(long j10) {
        this.lockKeepAlivePeriod = Long.valueOf(j10);
    }
}
