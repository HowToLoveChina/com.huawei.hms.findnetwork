package p643t0;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: t0.a */
/* loaded from: classes.dex */
public abstract class AbstractC12912a<Params, Progress, Result> {

    /* renamed from: f */
    public static final ThreadFactory f58881f;

    /* renamed from: g */
    public static final BlockingQueue<Runnable> f58882g;

    /* renamed from: h */
    public static final Executor f58883h;

    /* renamed from: i */
    public static f f58884i;

    /* renamed from: j */
    public static volatile Executor f58885j;

    /* renamed from: a */
    public final h<Params, Result> f58886a;

    /* renamed from: b */
    public final FutureTask<Result> f58887b;

    /* renamed from: c */
    public volatile g f58888c = g.PENDING;

    /* renamed from: d */
    public final AtomicBoolean f58889d = new AtomicBoolean();

    /* renamed from: e */
    public final AtomicBoolean f58890e = new AtomicBoolean();

    /* renamed from: t0.a$a */
    public static class a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f58891a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f58891a.getAndIncrement());
        }
    }

    /* renamed from: t0.a$b */
    public class b extends h<Params, Result> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            AbstractC12912a.this.f58890e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) AbstractC12912a.this.mo5020c(this.f58901a);
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    }

    /* renamed from: t0.a$c */
    public class c extends FutureTask<Result> {
        public c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                AbstractC12912a.this.m77545n(get());
            } catch (InterruptedException e10) {
                Log.w("AsyncTask", e10);
            } catch (CancellationException unused) {
                AbstractC12912a.this.m77545n(null);
            } catch (ExecutionException e11) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e11.getCause());
            } catch (Throwable th2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th2);
            }
        }
    }

    /* renamed from: t0.a$d */
    public static /* synthetic */ class d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f58894a;

        static {
            int[] iArr = new int[g.values().length];
            f58894a = iArr;
            try {
                iArr[g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58894a[g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: t0.a$e */
    public static class e<Data> {

        /* renamed from: a */
        public final AbstractC12912a f58895a;

        /* renamed from: b */
        public final Data[] f58896b;

        public e(AbstractC12912a abstractC12912a, Data... dataArr) {
            this.f58895a = abstractC12912a;
            this.f58896b = dataArr;
        }
    }

    /* renamed from: t0.a$f */
    public static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i10 = message.what;
            if (i10 == 1) {
                eVar.f58895a.m77539e(eVar.f58896b[0]);
            } else {
                if (i10 != 2) {
                    return;
                }
                eVar.f58895a.m77543l(eVar.f58896b);
            }
        }
    }

    /* renamed from: t0.a$g */
    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: t0.a$h */
    public static abstract class h<Params, Result> implements Callable<Result> {

        /* renamed from: a */
        public Params[] f58901a;
    }

    static {
        a aVar = new a();
        f58881f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f58882g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f58883h = threadPoolExecutor;
        f58885j = threadPoolExecutor;
    }

    public AbstractC12912a() {
        b bVar = new b();
        this.f58886a = bVar;
        this.f58887b = new c(bVar);
    }

    /* renamed from: f */
    public static Handler m77536f() {
        f fVar;
        synchronized (AbstractC12912a.class) {
            try {
                if (f58884i == null) {
                    f58884i = new f();
                }
                fVar = f58884i;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }

    /* renamed from: a */
    public final boolean m77537a(boolean z10) {
        this.f58889d.set(true);
        return this.f58887b.cancel(z10);
    }

    /* renamed from: c */
    public abstract Result mo5020c(Params... paramsArr);

    /* renamed from: d */
    public final AbstractC12912a<Params, Progress, Result> m77538d(Executor executor, Params... paramsArr) {
        if (this.f58888c == g.PENDING) {
            this.f58888c = g.RUNNING;
            m77542k();
            this.f58886a.f58901a = paramsArr;
            executor.execute(this.f58887b);
            return this;
        }
        int i10 = d.f58894a[this.f58888c.ordinal()];
        if (i10 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i10 != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    /* renamed from: e */
    public void m77539e(Result result) {
        if (m77540g()) {
            mo5021i(result);
        } else {
            mo5022j(result);
        }
        this.f58888c = g.FINISHED;
    }

    /* renamed from: g */
    public final boolean m77540g() {
        return this.f58889d.get();
    }

    /* renamed from: h */
    public void m77541h() {
    }

    /* renamed from: i */
    public void mo5021i(Result result) {
        m77541h();
    }

    /* renamed from: j */
    public void mo5022j(Result result) {
    }

    /* renamed from: k */
    public void m77542k() {
    }

    /* renamed from: l */
    public void m77543l(Progress... progressArr) {
    }

    /* renamed from: m */
    public Result m77544m(Result result) {
        m77536f().obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: n */
    public void m77545n(Result result) {
        if (this.f58890e.get()) {
            return;
        }
        m77544m(result);
    }
}
