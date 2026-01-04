package com.huawei.android.hicloud.cloudbackup.process.util;

import com.huawei.android.hicloud.connect.progress.ICallback;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class ProgressCallback implements ICallback {
    private static final String TAG = "ProgressCallback";
    private boolean abort = false;
    private boolean pause = false;

    public void abort() {
        this.abort = true;
    }

    public boolean onPause() throws InterruptedException {
        if (this.pause) {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e10) {
                C11839m.m70687e(TAG, "pause task error." + e10.toString());
            }
            this.pause = false;
        }
        return this.pause;
    }

    @Override // com.huawei.android.hicloud.connect.progress.ICallback
    public void onProgress(long j10, long j11) {
    }

    @Override // com.huawei.android.hicloud.connect.progress.ICallback
    public boolean onStop() throws InterruptedException {
        onPause();
        return this.abort;
    }

    public void pause() {
        this.pause = true;
    }
}
