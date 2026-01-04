package com.huawei.android.hicloud.cloudbackup.process.clone;

import p514o9.C11839m;
import p847zk.C14316i;

/* loaded from: classes2.dex */
public class BaseLiveKeeper {
    private static final String DEFAULT_REASON = "user-cloudBackupClone_apply";
    private static final String TAG = "BaseLiveKeeper";
    private final long keepAliveTime;

    public BaseLiveKeeper(long j10) {
        this.keepAliveTime = j10;
    }

    public void applyForResourceUse(String str) {
        C11839m.m70688i(TAG, "applyForResourceUse : " + str);
        C14316i.m85291e().m85294c(str, this.keepAliveTime, DEFAULT_REASON);
    }

    public void unApplyForResourceUse(String str) {
        C11839m.m70688i(TAG, "unApplyForResourceUse : " + str);
        C14316i.m85291e().m85298h(str, DEFAULT_REASON);
    }
}
