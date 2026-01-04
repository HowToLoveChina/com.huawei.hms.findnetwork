package es;

import as.C1016d;
import es.C9540e;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: es.e */
/* loaded from: classes8.dex */
public class C9540e {

    /* renamed from: a */
    public final ThreadPoolExecutor f47446a;

    /* renamed from: b */
    public final ScheduledThreadPoolExecutor f47447b;

    /* renamed from: es.e$b */
    public static class b {

        /* renamed from: a */
        public static final C9540e f47448a = new C9540e();
    }

    /* renamed from: es.e$c */
    public static class c implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f47449a = new AtomicInteger(1);

        /* renamed from: b */
        public final String f47450b;

        public c(String str) {
            this.f47450b = str;
        }

        /* renamed from: b */
        public static /* synthetic */ void m59587b(Thread thread, Throwable th2) {
            C1016d.m6183c("ExecutorUtil", "thread name:" + thread.getName() + ", uncaughtException.");
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f47450b + "-" + this.f47449a.getAndIncrement());
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: es.f
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread2, Throwable th2) {
                    C9540e.c.m59587b(thread2, th2);
                }
            });
            return thread;
        }
    }

    public C9540e() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 60L, timeUnit, new LinkedBlockingQueue(), new c("Location-Task"));
        this.f47446a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10, new c("Loc-Task-Delay"));
        this.f47447b = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, timeUnit);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /* renamed from: d */
    public static C9540e m59581d() {
        return b.f47448a;
    }

    /* renamed from: a */
    public void m59582a(Runnable runnable) {
        try {
            m59584c().execute(runnable);
        } catch (Throwable unused) {
            C1016d.m6185e("ExecutorUtil", "ExecutorUtil fatal error", true);
        }
    }

    /* renamed from: b */
    public void m59583b(FutureTask futureTask) {
        try {
            Thread thread = new Thread(futureTask);
            thread.setName(Thread.currentThread().getName());
            thread.start();
        } catch (Throwable unused) {
            C1016d.m6185e("ExecutorUtil", "ExecutorUtil futureTask error", true);
        }
    }

    /* renamed from: c */
    public ExecutorService m59584c() {
        return this.f47446a;
    }
}
