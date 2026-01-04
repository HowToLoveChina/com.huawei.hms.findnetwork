package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.hatool.b0 */
/* loaded from: classes8.dex */
public class C5517b0 {

    /* renamed from: b */
    private static C5517b0 f25148b;

    /* renamed from: c */
    private static C5517b0 f25149c;

    /* renamed from: d */
    private static C5517b0 f25150d;

    /* renamed from: a */
    private ThreadPoolExecutor f25151a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    /* renamed from: com.huawei.hms.hatool.b0$a */
    public static class a implements Runnable {

        /* renamed from: a */
        private Runnable f25152a;

        public a(Runnable runnable) {
            this.f25152a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f25152a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    C5571v.m32796e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.hatool.b0$b */
    public static class b implements ThreadFactory {

        /* renamed from: d */
        private static final AtomicInteger f25153d = new AtomicInteger(1);

        /* renamed from: a */
        private final ThreadGroup f25154a;

        /* renamed from: b */
        private final AtomicInteger f25155b = new AtomicInteger(1);

        /* renamed from: c */
        private final String f25156c;

        public b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f25154a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f25156c = "FormalHASDK-base-" + f25153d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f25154a, runnable, this.f25156c + this.f25155b.getAndIncrement(), 0L);
        }
    }

    static {
        new C5517b0();
        new C5517b0();
        f25148b = new C5517b0();
        f25149c = new C5517b0();
        f25150d = new C5517b0();
    }

    private C5517b0() {
    }

    /* renamed from: a */
    public static C5517b0 m32447a() {
        return f25150d;
    }

    /* renamed from: b */
    public static C5517b0 m32448b() {
        return f25149c;
    }

    /* renamed from: c */
    public static C5517b0 m32449c() {
        return f25148b;
    }

    /* renamed from: a */
    public void m32450a(InterfaceRunnableC5531g interfaceRunnableC5531g) {
        try {
            this.f25151a.execute(new a(interfaceRunnableC5531g));
        } catch (RejectedExecutionException unused) {
            C5571v.m32796e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
