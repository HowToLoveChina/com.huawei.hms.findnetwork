package p780xm;

import android.os.Process;
import cn.C1462b;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p780xm.C13836h;

/* renamed from: xm.h */
/* loaded from: classes6.dex */
public class C13836h extends ThreadPoolExecutor {

    /* renamed from: xm.h$a */
    public static class a implements ThreadFactory {

        /* renamed from: e */
        public static final AtomicInteger f62056e = new AtomicInteger(1);

        /* renamed from: a */
        public final ThreadGroup f62057a;

        /* renamed from: b */
        public final AtomicInteger f62058b = new AtomicInteger(1);

        /* renamed from: c */
        public final String f62059c;

        /* renamed from: d */
        public final String f62060d;

        public a(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f62057a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f62059c = "thread-p-" + f62056e.getAndIncrement() + '-';
            this.f62060d = str;
        }

        /* renamed from: b */
        public static /* synthetic */ void m82988b(Runnable runnable) throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            Thread thread = new Thread(this.f62057a, new Runnable() { // from class: xm.g
                @Override // java.lang.Runnable
                public final void run() throws SecurityException, IllegalArgumentException {
                    C13836h.a.m82988b(runnable);
                }
            }, this.f62060d + '-' + this.f62059c + this.f62058b.getAndIncrement(), 0L);
            thread.setUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* renamed from: xm.h$b */
    public static class b<T> implements Callable<T> {

        /* renamed from: a */
        public final Callable<T> f62061a;

        public b(Callable<T> callable) {
            this.f62061a = callable;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            try {
                return this.f62061a.call();
            } catch (Exception e10) {
                C1462b.m8361b("ThreadExecutor", "Exception in thread: " + e10.getMessage());
                return null;
            }
        }
    }

    /* renamed from: xm.h$c */
    public static class c implements Runnable {

        /* renamed from: a */
        public final Runnable f62062a;

        public c(Runnable runnable) {
            this.f62062a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f62062a.run();
            } catch (Exception e10) {
                C1462b.m8361b("ThreadExecutor", "Exception in thread: " + e10.getMessage());
            }
        }
    }

    /* renamed from: xm.h$d */
    public static class d implements RejectedExecutionHandler {

        /* renamed from: a */
        public final String f62063a;

        public d(String str) {
            this.f62063a = str;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            C1462b.m8361b("ThreadExecutor", "ERROR!!! task queue full, task discarded. " + this.f62063a);
        }
    }

    public C13836h(int i10, int i11, int i12, String str) {
        super(i10, i11, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(i12), new a(str), new d(str));
        allowCoreThreadTimeOut(true);
    }

    /* renamed from: a */
    public <T> Callable<T> m82985a(Callable<T> callable) {
        return new b(callable);
    }

    /* renamed from: b */
    public Runnable m82986b(Runnable runnable) {
        return new c(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return super.submit(m82985a(callable));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return super.submit(m82986b(runnable));
    }
}
