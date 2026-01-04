package com.huawei.android.hicloud.cloudbackup.process.task;

import fk.C9721b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* loaded from: classes2.dex */
public class ReadOmConfigFileTask extends AbstractC12367d {
    private static final String TAG = "ReadOmConfigFileTask";

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        try {
            C11839m.m70688i(TAG, "ReadOmConfigFileTask  start");
            new QueryOmAppBackupScopeTask().readConfigFile();
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "CloudBackupManager init QueryOmAppBackupScopeTask, error: " + e10.getMessage());
        }
    }
}
