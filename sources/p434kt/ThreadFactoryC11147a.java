package p434kt;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: kt.a */
/* loaded from: classes2.dex */
public class ThreadFactoryC11147a implements ThreadFactory {

    /* renamed from: a */
    public final ThreadGroup f52492a;

    /* renamed from: b */
    public final AtomicInteger f52493b;

    /* renamed from: c */
    public final String f52494c;

    /* renamed from: d */
    public final int f52495d;

    public ThreadFactoryC11147a(String str) {
        this(str, 5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f52492a, runnable, this.f52494c + this.f52493b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int priority = thread.getPriority();
        int i10 = this.f52495d;
        if (priority != i10) {
            thread.setPriority(i10);
        }
        return thread;
    }

    public ThreadFactoryC11147a(String str, int i10) {
        this.f52493b = new AtomicInteger(1);
        this.f52495d = i10;
        SecurityManager securityManager = System.getSecurityManager();
        this.f52492a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f52494c = "PPS-" + str + "-pool-thread-";
    }
}
