package com.huawei.hms.opendevice;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.huawei.hms.opendevice.c */
/* loaded from: classes8.dex */
public class ThreadFactoryC6265c implements ThreadFactory {

    /* renamed from: a */
    private final ThreadGroup f29575a;

    /* renamed from: b */
    private int f29576b = 1;

    /* renamed from: c */
    private final String f29577c;

    public ThreadFactoryC6265c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f29575a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f29577c = str + "-pool-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            this.f29576b++;
        }
        Thread thread = new Thread(this.f29575a, runnable, this.f29577c + this.f29576b, 0L);
        thread.setUncaughtExceptionHandler(null);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
