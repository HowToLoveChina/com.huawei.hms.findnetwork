package com.huawei.hms.findnetwork.threadpool;

import com.huawei.hms.findnetwork.util.HmsFindSDKLog;

/* loaded from: classes8.dex */
public class TaskWrapper implements Runnable {
    private static final String TAG = "TaskWrapper";
    private String mModuleName;
    private Runnable mRunnable;

    public TaskWrapper(String str, Runnable runnable) {
        this.mRunnable = runnable;
        this.mModuleName = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.mRunnable;
        if (runnable == null) {
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th2) {
            HmsFindSDKLog.m32126e(TAG, "run exception = " + th2.getMessage());
        }
    }
}
