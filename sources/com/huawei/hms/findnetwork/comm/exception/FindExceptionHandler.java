package com.huawei.hms.findnetwork.comm.exception;

import com.huawei.hms.findnetwork.comm.log.HmsFindCommonLog;
import java.lang.Thread;

/* loaded from: classes8.dex */
public class FindExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "FindExceptionHandler";
    private String mModuleName;

    public FindExceptionHandler(String str) {
        this.mModuleName = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        HmsFindCommonLog.m31926w(TAG, "mModuleName:" + this.mModuleName + "Thread:" + thread.getName() + " UncaughtException: " + th2.getMessage());
    }
}
