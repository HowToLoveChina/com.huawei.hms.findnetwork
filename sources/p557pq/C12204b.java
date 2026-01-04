package p557pq;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p640sq.C12836o;

/* renamed from: pq.b */
/* loaded from: classes8.dex */
public class C12204b extends ThreadPoolExecutor {

    /* renamed from: a */
    public String f56579a;

    /* renamed from: b */
    public long f56580b;

    /* renamed from: c */
    public Map<String, Long> f56581c;

    /* renamed from: pq.b$a */
    public static class a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f56582a = new AtomicInteger(1);

        /* renamed from: b */
        public String f56583b;

        public a(String str) {
            this.f56583b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f56583b + this.f56582a.getAndIncrement());
        }
    }

    public C12204b(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, String str) {
        super(i10, i11, j10, timeUnit, blockingQueue);
        this.f56579a = str;
        setThreadFactory(new a(str));
        this.f56580b = System.currentTimeMillis();
        this.f56581c = new ConcurrentHashMap();
    }

    /* renamed from: a */
    public final void m73360a() {
        new C12207e().m73367a(getActiveCount()).m73368b(getCompletedTaskCount()).m73370d(getTaskCount()).m73369c(getCorePoolSize()).m73371e(getLargestPoolSize()).m73372f(getMaximumPoolSize()).m73373g(getQueue().size());
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th2) {
        m73361b(runnable);
        m73362c();
        super.afterExecute(runnable, th2);
    }

    /* renamed from: b */
    public final void m73361b(Runnable runnable) {
        Long lRemove = this.f56581c.remove(String.valueOf(runnable.hashCode()));
        long jLongValue = lRemove == null ? 0L : lRemove.longValue();
        C12836o.m77097b("ThreadPool", "afterExecute, time costs:" + (System.currentTimeMillis() - jLongValue) + "ms", true);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        this.f56581c.put(String.valueOf(runnable.hashCode()), Long.valueOf(System.currentTimeMillis()));
        if (System.currentTimeMillis() - this.f56580b >= 5000) {
            m73360a();
            m73362c();
            this.f56580b = System.currentTimeMillis();
        }
        super.beforeExecute(thread, runnable);
    }

    /* renamed from: c */
    public final void m73362c() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("thread dump:");
        sb2.append("poolName:" + this.f56579a + " activeCount:" + getActiveCount() + " completedTaskCount:" + getCompletedTaskCount() + " taskCount:" + getTaskCount() + " corePoolSize:" + getCorePoolSize() + " largestPoolSize:" + getLargestPoolSize() + " maximumPoolSize:" + getMaximumPoolSize() + " queueSize:" + getQueue().size() + " ");
        C12836o.m77097b("ThreadPool", sb2.toString(), true);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        C12836o.m77097b("ThreadPool", "shutdown", true);
        m73362c();
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        C12836o.m77097b("ThreadPool", "shutdownNow", true);
        m73362c();
        return super.shutdownNow();
    }
}
