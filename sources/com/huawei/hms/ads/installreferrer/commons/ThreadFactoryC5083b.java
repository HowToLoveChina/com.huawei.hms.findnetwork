package com.huawei.hms.ads.installreferrer.commons;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.ads.installreferrer.commons.b */
/* loaded from: classes8.dex */
public class ThreadFactoryC5083b implements ThreadFactory {

    /* renamed from: a */
    private final ThreadGroup f23223a;

    /* renamed from: b */
    private final AtomicInteger f23224b;

    /* renamed from: c */
    private final String f23225c;

    /* renamed from: d */
    private final int f23226d;

    public ThreadFactoryC5083b(String str) {
        this(str, 5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f23223a, runnable, this.f23225c + this.f23224b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int priority = thread.getPriority();
        int i10 = this.f23226d;
        if (priority != i10) {
            thread.setPriority(i10);
        }
        return thread;
    }

    public ThreadFactoryC5083b(String str, int i10) {
        this.f23224b = new AtomicInteger(1);
        this.f23226d = i10;
        this.f23223a = Thread.currentThread().getThreadGroup();
        this.f23225c = "PPS-" + str + "-pool-thread-";
    }
}
