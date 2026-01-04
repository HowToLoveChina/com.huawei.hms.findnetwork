package p044c2;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: c2.a */
/* loaded from: classes.dex */
public final class ExecutorServiceC1380a implements ExecutorService {

    /* renamed from: b */
    public static final long f5921b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c */
    public static volatile int f5922c;

    /* renamed from: a */
    public final ExecutorService f5923a;

    /* renamed from: c2.a$b */
    public static final class b {

        /* renamed from: a */
        public final boolean f5924a;

        /* renamed from: b */
        public int f5925b;

        /* renamed from: c */
        public int f5926c;

        /* renamed from: d */
        public final ThreadFactory f5927d = new c();

        /* renamed from: e */
        public e f5928e = e.f5942d;

        /* renamed from: f */
        public String f5929f;

        /* renamed from: g */
        public long f5930g;

        public b(boolean z10) {
            this.f5924a = z10;
        }

        /* renamed from: a */
        public ExecutorServiceC1380a m7924a() {
            if (TextUtils.isEmpty(this.f5929f)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f5929f);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f5925b, this.f5926c, this.f5930g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d(this.f5927d, this.f5929f, this.f5928e, this.f5924a));
            if (this.f5930g != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new ExecutorServiceC1380a(threadPoolExecutor);
        }

        /* renamed from: b */
        public b m7925b(String str) {
            this.f5929f = str;
            return this;
        }

        /* renamed from: c */
        public b m7926c(int i10) {
            this.f5925b = i10;
            this.f5926c = i10;
            return this;
        }
    }

    /* renamed from: c2.a$c */
    public static final class c implements ThreadFactory {

        /* renamed from: c2.a$c$a */
        public class a extends Thread {
            public a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        public c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new a(runnable);
        }
    }

    /* renamed from: c2.a$d */
    public static final class d implements ThreadFactory {

        /* renamed from: a */
        public final ThreadFactory f5932a;

        /* renamed from: b */
        public final String f5933b;

        /* renamed from: c */
        public final e f5934c;

        /* renamed from: d */
        public final boolean f5935d;

        /* renamed from: e */
        public final AtomicInteger f5936e = new AtomicInteger();

        /* renamed from: c2.a$d$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Runnable f5937a;

            public a(Runnable runnable) {
                this.f5937a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f5935d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.f5937a.run();
                } catch (Throwable th2) {
                    d.this.f5934c.mo7927a(th2);
                }
            }
        }

        public d(ThreadFactory threadFactory, String str, e eVar, boolean z10) {
            this.f5932a = threadFactory;
            this.f5933b = str;
            this.f5934c = eVar;
            this.f5935d = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f5932a.newThread(new a(runnable));
            threadNewThread.setName("glide-" + this.f5933b + "-thread-" + this.f5936e.getAndIncrement());
            return threadNewThread;
        }
    }

    /* renamed from: c2.a$e */
    public interface e {

        /* renamed from: a */
        public static final e f5939a = new a();

        /* renamed from: b */
        public static final e f5940b;

        /* renamed from: c */
        public static final e f5941c;

        /* renamed from: d */
        public static final e f5942d;

        /* renamed from: c2.a$e$a */
        public class a implements e {
            @Override // p044c2.ExecutorServiceC1380a.e
            /* renamed from: a */
            public void mo7927a(Throwable th2) {
            }
        }

        /* renamed from: c2.a$e$b */
        public class b implements e {
            @Override // p044c2.ExecutorServiceC1380a.e
            /* renamed from: a */
            public void mo7927a(Throwable th2) {
                if (th2 == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th2);
            }
        }

        /* renamed from: c2.a$e$c */
        public class c implements e {
            @Override // p044c2.ExecutorServiceC1380a.e
            /* renamed from: a */
            public void mo7927a(Throwable th2) {
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        }

        static {
            b bVar = new b();
            f5940b = bVar;
            f5941c = new c();
            f5942d = bVar;
        }

        /* renamed from: a */
        void mo7927a(Throwable th2);
    }

    public ExecutorServiceC1380a(ExecutorService executorService) {
        this.f5923a = executorService;
    }

    /* renamed from: a */
    public static int m7916a() {
        if (f5922c == 0) {
            f5922c = Math.min(4, C1381b.m7928a());
        }
        return f5922c;
    }

    /* renamed from: b */
    public static b m7917b() {
        return new b(true).m7926c(m7916a() >= 4 ? 2 : 1).m7925b("animation");
    }

    /* renamed from: c */
    public static ExecutorServiceC1380a m7918c() {
        return m7917b().m7924a();
    }

    /* renamed from: d */
    public static b m7919d() {
        return new b(true).m7926c(1).m7925b("disk-cache");
    }

    /* renamed from: e */
    public static ExecutorServiceC1380a m7920e() {
        return m7919d().m7924a();
    }

    /* renamed from: f */
    public static b m7921f() {
        return new b(false).m7926c(m7916a()).m7925b("source");
    }

    /* renamed from: g */
    public static ExecutorServiceC1380a m7922g() {
        return m7921f().m7924a();
    }

    /* renamed from: h */
    public static ExecutorServiceC1380a m7923h() {
        return new ExecutorServiceC1380a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f5921b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(), "source-unlimited", e.f5942d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f5923a.awaitTermination(j10, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f5923a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f5923a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f5923a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f5923a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f5923a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f5923a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f5923a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f5923a.submit(runnable);
    }

    public String toString() {
        return this.f5923a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f5923a.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f5923a.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t10) {
        return this.f5923a.submit(runnable, t10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f5923a.submit(callable);
    }
}
