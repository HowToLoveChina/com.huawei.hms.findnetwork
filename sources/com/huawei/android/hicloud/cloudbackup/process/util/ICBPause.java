package com.huawei.android.hicloud.cloudbackup.process.util;

import p514o9.C11839m;

/* loaded from: classes2.dex */
public class ICBPause {
    private static final long SLEEP_TIMES = 10000;
    private static final String TAG = "ICBPause";
    private static ICBPause instance = new ICBPause();
    private boolean isPause = false;

    public static ICBPause getInstance() {
        return instance;
    }

    public void doPause() throws InterruptedException {
        if (this.isPause) {
            try {
                C11839m.m70688i(TAG, "thread start sleep 10s.");
                Thread.sleep(10000L);
            } catch (InterruptedException unused) {
                C11839m.m70689w(TAG, "InterruptedException");
            }
            setPause(false);
        }
    }

    public boolean isPause() {
        return this.isPause;
    }

    public void setPause(boolean z10) {
        this.isPause = z10;
    }
}
