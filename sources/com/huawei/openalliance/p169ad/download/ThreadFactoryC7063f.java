package com.huawei.openalliance.p169ad.download;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.openalliance.ad.download.f */
/* loaded from: classes2.dex */
public class ThreadFactoryC7063f implements ThreadFactory {

    /* renamed from: a */
    private static final AtomicInteger f32527a = new AtomicInteger(1);

    /* renamed from: c */
    private final AtomicInteger f32529c = new AtomicInteger(1);

    /* renamed from: b */
    private final ThreadGroup f32528b = Thread.currentThread().getThreadGroup();

    /* renamed from: d */
    private final String f32530d = "PPS-download-pool-" + f32527a.getAndIncrement() + "-thread-";

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f32528b, runnable, this.f32530d + this.f32529c.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        thread.setPriority(1);
        return thread;
    }
}
