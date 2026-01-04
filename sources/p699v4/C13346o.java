package p699v4;

import com.huawei.android.backup.filelogic.utils.C2111d;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: v4.o */
/* loaded from: classes.dex */
public class C13346o {

    /* renamed from: a */
    public final ThreadPoolExecutor f60173a;

    /* renamed from: v4.o$b */
    public static class b implements Runnable {

        /* renamed from: a */
        public final Runnable f60174a;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f60174a.run();
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("ThreadExecutor", "IllegalArgumentException in thread.");
            } catch (Exception unused2) {
                C2111d.m12648d("ThreadExecutor", "Exception in thread.");
            }
        }

        public b(Runnable runnable) {
            this.f60174a = runnable;
        }
    }

    /* renamed from: v4.o$c */
    public static class c implements RejectedExecutionHandler {
        public c() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            C2111d.m12648d("ThreadExecutor", "ERROR!!! task queue full, task discarded");
        }
    }

    public C13346o(int i10, int i11, int i12) {
        this.f60173a = new ThreadPoolExecutor(i10, i11, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(i12), new c());
    }

    /* renamed from: a */
    public long m80075a() {
        return this.f60173a.getActiveCount();
    }

    /* renamed from: b */
    public List<Runnable> m80076b() {
        return this.f60173a.shutdownNow();
    }

    /* renamed from: c */
    public Future<?> m80077c(Runnable runnable) {
        return this.f60173a.submit(new b(runnable));
    }
}
