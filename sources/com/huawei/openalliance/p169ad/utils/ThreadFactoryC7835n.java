package com.huawei.openalliance.p169ad.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.openalliance.ad.utils.n */
/* loaded from: classes2.dex */
public class ThreadFactoryC7835n implements ThreadFactory {

    /* renamed from: a */
    private final ThreadGroup f36131a;

    /* renamed from: b */
    private final AtomicInteger f36132b;

    /* renamed from: c */
    private final String f36133c;

    /* renamed from: d */
    private final int f36134d;

    public ThreadFactoryC7835n(String str) {
        this(str, 5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f36131a, runnable, this.f36133c + this.f36132b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int priority = thread.getPriority();
        int i10 = this.f36134d;
        if (priority != i10) {
            thread.setPriority(i10);
        }
        return thread;
    }

    public ThreadFactoryC7835n(String str, int i10) {
        this.f36132b = new AtomicInteger(1);
        this.f36134d = i10;
        this.f36131a = Thread.currentThread().getThreadGroup();
        this.f36133c = "PPS-" + str + "-pool-thread-";
    }
}
