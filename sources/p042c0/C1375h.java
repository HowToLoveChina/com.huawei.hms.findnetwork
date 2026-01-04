package p042c0;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p243e0.InterfaceC9366a;

/* renamed from: c0.h */
/* loaded from: classes.dex */
public class C1375h {

    /* renamed from: c0.h$a */
    public static class a implements ThreadFactory {

        /* renamed from: a */
        public String f5912a;

        /* renamed from: b */
        public int f5913b;

        /* renamed from: c0.h$a$a, reason: collision with other inner class name */
        public static class C14415a extends Thread {

            /* renamed from: a */
            public final int f5914a;

            public C14415a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f5914a = i10;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(this.f5914a);
                super.run();
            }
        }

        public a(String str, int i10) {
            this.f5912a = str;
            this.f5913b = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C14415a(runnable, this.f5912a, this.f5913b);
        }
    }

    /* renamed from: c0.h$b */
    public static class b<T> implements Runnable {

        /* renamed from: a */
        public Callable<T> f5915a;

        /* renamed from: b */
        public InterfaceC9366a<T> f5916b;

        /* renamed from: c */
        public Handler f5917c;

        /* renamed from: c0.h$b$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ InterfaceC9366a f5918a;

            /* renamed from: b */
            public final /* synthetic */ Object f5919b;

            public a(InterfaceC9366a interfaceC9366a, Object obj) {
                this.f5918a = interfaceC9366a;
                this.f5919b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f5918a.accept(this.f5919b);
            }
        }

        public b(Handler handler, Callable<T> callable, InterfaceC9366a<T> interfaceC9366a) {
            this.f5915a = callable;
            this.f5916b = interfaceC9366a;
            this.f5917c = handler;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            T tCall;
            try {
                tCall = this.f5915a.call();
            } catch (Exception unused) {
                tCall = null;
            }
            this.f5917c.post(new a(this.f5916b, tCall));
        }
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m7910a(String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: b */
    public static <T> void m7911b(Executor executor, Callable<T> callable, InterfaceC9366a<T> interfaceC9366a) {
        executor.execute(new b(C1369b.m7869a(), callable, interfaceC9366a));
    }

    /* renamed from: c */
    public static <T> T m7912c(ExecutorService executorService, Callable<T> callable, int i10) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw e10;
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
