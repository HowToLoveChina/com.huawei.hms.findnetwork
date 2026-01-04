package com.huawei.android.hicloud.cloudbackup.process.task;

import fk.C9721b;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* loaded from: classes2.dex */
public abstract class BackupSingleTask extends AbstractRunnableC12516b {
    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        execute();
    }

    public abstract void execute() throws C9721b;

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.BACKUP_SINGLE;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
        C12515a.m75110o().m75165a1(this);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
