package p233dq;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: dq.a */
/* loaded from: classes8.dex */
public final class C9288a {

    /* renamed from: b */
    public static final C9288a f46611b = new C9288a();

    /* renamed from: c */
    public static final int f46612c;

    /* renamed from: d */
    public static final int f46613d;

    /* renamed from: e */
    public static final int f46614e;

    /* renamed from: a */
    public final Executor f46615a = new b();

    /* renamed from: dq.a$b */
    public static class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f46612c = iAvailableProcessors;
        f46613d = iAvailableProcessors + 1;
        f46614e = (iAvailableProcessors * 2) + 1;
    }

    /* renamed from: a */
    public static ExecutorService m58584a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f46613d, f46614e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: b */
    public static Executor m58585b() {
        return f46611b.f46615a;
    }
}
