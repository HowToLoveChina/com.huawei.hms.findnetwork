package com.huawei.android.hicloud.cloudbackup.manager;

import java.util.concurrent.Future;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public abstract class CloudBackupBaseTask implements Runnable {
    private static final String TAG = "CloudBackupBaseTask";
    private Future<?> future;
    protected boolean isRunning = false;
    protected boolean abort = false;

    public void abort() {
        this.abort = true;
    }

    public abstract void call();

    public void cancel(boolean z10) {
        Future<?> future = this.future;
        if (future != null) {
            future.cancel(z10);
        }
        abort();
        release();
    }

    public boolean isAbort() {
        return this.abort;
    }

    public abstract void release();

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                this.isRunning = true;
                call();
            } catch (Exception e10) {
                C11839m.m70687e(TAG, e10.toString());
            }
        } finally {
            release();
            this.isRunning = false;
        }
    }

    public void setFuture(Future<?> future) {
        this.future = future;
    }
}
