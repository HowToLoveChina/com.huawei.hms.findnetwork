package p308g4;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: g4.d */
/* loaded from: classes.dex */
public class ThreadFactoryC9880d implements ThreadFactory {

    /* renamed from: a */
    public final ThreadGroup f48511a;

    /* renamed from: b */
    public final AtomicInteger f48512b;

    /* renamed from: c */
    public final String f48513c;

    /* renamed from: d */
    public final int f48514d;

    public ThreadFactoryC9880d(String str) {
        this(str, 5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f48511a, runnable, this.f48513c + this.f48512b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int priority = thread.getPriority();
        int i10 = this.f48514d;
        if (priority != i10) {
            thread.setPriority(i10);
        }
        return thread;
    }

    public ThreadFactoryC9880d(String str, int i10) {
        this.f48512b = new AtomicInteger(1);
        this.f48514d = i10;
        SecurityManager securityManager = System.getSecurityManager();
        this.f48511a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f48513c = "PPS-" + str + "-threadpool-";
    }
}
