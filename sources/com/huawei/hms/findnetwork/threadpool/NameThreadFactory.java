package com.huawei.hms.findnetwork.threadpool;

import com.huawei.hms.findnetwork.comm.exception.FindExceptionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public class NameThreadFactory implements ThreadFactory {
    private static final int ATOMIC_INITIAL_VALUE = 1;
    private final AtomicInteger mCounter = new AtomicInteger(1);
    private final String mPoolName;

    public NameThreadFactory(String str) {
        this.mPoolName = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.mPoolName + "-" + this.mCounter.getAndIncrement());
        thread.setUncaughtExceptionHandler(new FindExceptionHandler(thread.getName()));
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
