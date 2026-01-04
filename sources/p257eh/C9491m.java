package p257eh;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: eh.m */
/* loaded from: classes4.dex */
public class C9491m {

    /* renamed from: a */
    public static final ScheduledExecutorService f47265a;

    /* renamed from: eh.m$b */
    public static class b implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f47266a;

        public b() {
            this.f47266a = new AtomicInteger();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Core thread #" + this.f47266a.getAndIncrement());
        }
    }

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new b());
        scheduledThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        f47265a = scheduledThreadPoolExecutor;
    }

    /* renamed from: a */
    public static void m59354a(Runnable runnable, long j10) {
        f47265a.schedule(runnable, j10, TimeUnit.MILLISECONDS);
    }
}
