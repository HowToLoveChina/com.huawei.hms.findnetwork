package com.huawei.android.hicloud.cloudbackup.process;

import android.content.ContentValues;
import p572qb.C12299b;
import p581qk.AbstractC12369f;

/* loaded from: classes2.dex */
public class AutoBackupKeepTimer extends AbstractC12369f {
    private static final long TWO_SECONDS = 120;

    public AutoBackupKeepTimer() {
        super(0L, 120L);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        if (CBAccess.inBackup()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("doBackupTime", Long.valueOf(System.currentTimeMillis()));
            C12299b.m73937s(contentValues);
        }
    }
}
