package p384j4;

import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p308g4.RunnableC9882f;
import p308g4.ThreadFactoryC9880d;
import p405jt.AbstractC10915a;

/* renamed from: j4.a */
/* loaded from: classes.dex */
public abstract class AbstractC10702a {

    /* renamed from: a */
    public static final Map<InterfaceC10704c, ExecutorService> f51344a = new HashMap();

    /* renamed from: b */
    public static a f51345b = new a();

    /* renamed from: j4.a$a */
    public static class a {
        /* renamed from: b */
        public final ExecutorService m65331b(InterfaceC10704c interfaceC10704c) {
            ThreadPoolExecutor threadPoolExecutor;
            AbstractC10915a.m65973e("ExecutorFactory", "createExecutorService for type %s", interfaceC10704c);
            if (interfaceC10704c == b.IO) {
                threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC9880d("IO"));
            } else if (interfaceC10704c == b.NETWORK) {
                threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC9880d("Net"));
            } else {
                if (interfaceC10704c != b.CALCULATION) {
                    return interfaceC10704c == b.SEQUENCE ? new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC9880d("Seq")) : interfaceC10704c == b.SYNC_CALL ? new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC9880d("SyncCall", 10)) : interfaceC10704c == b.SEQUENCE_IO ? new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC9880d("SeqIO")) : m65332c(interfaceC10704c);
                }
                threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC9880d("Cal"));
            }
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        }

        /* renamed from: c */
        public ExecutorService m65332c(InterfaceC10704c interfaceC10704c) {
            return null;
        }
    }

    /* renamed from: j4.a$b */
    public enum b implements InterfaceC10704c {
        IO,
        NETWORK,
        CALCULATION,
        SEQUENCE,
        SYNC_CALL,
        SEQUENCE_IO
    }

    /* renamed from: a */
    public static <V> Future<V> m65322a(Callable<V> callable, InterfaceC10704c interfaceC10704c) {
        ExecutorService executorServiceM65325d = m65325d(interfaceC10704c);
        if (executorServiceM65325d != null) {
            return executorServiceM65325d.submit(callable);
        }
        AbstractC10915a.m65979k("AsyncExec", "no executor for type: %s", interfaceC10704c);
        return null;
    }

    /* renamed from: b */
    public static void m65323b(InterfaceC10704c interfaceC10704c, ExecutorService executorService) {
        if (interfaceC10704c == null || executorService == null) {
            return;
        }
        f51344a.put(interfaceC10704c, executorService);
    }

    /* renamed from: c */
    public static boolean m65324c() {
        Looper mainLooper = Looper.getMainLooper();
        return mainLooper != null && Thread.currentThread() == mainLooper.getThread();
    }

    /* renamed from: d */
    public static ExecutorService m65325d(InterfaceC10704c interfaceC10704c) {
        ExecutorService executorService = f51344a.get(interfaceC10704c);
        if (executorService != null) {
            return executorService;
        }
        a aVar = f51345b;
        if (aVar == null) {
            AbstractC10915a.m65978j("AsyncExec", "no executor factory found");
            return null;
        }
        ExecutorService executorServiceM65331b = aVar.m65331b(interfaceC10704c);
        m65323b(interfaceC10704c, executorServiceM65331b);
        return executorServiceM65331b;
    }

    /* renamed from: e */
    public static void m65326e(a aVar) {
        f51345b = aVar;
    }

    /* renamed from: f */
    public static void m65327f(Runnable runnable, InterfaceC10704c interfaceC10704c) {
        m65328g(runnable, interfaceC10704c, false);
    }

    /* renamed from: g */
    public static void m65328g(Runnable runnable, InterfaceC10704c interfaceC10704c, boolean z10) {
        if (runnable == null) {
            return;
        }
        if (z10 && !m65324c()) {
            new RunnableC9882f(runnable).run();
            return;
        }
        ExecutorService executorServiceM65325d = m65325d(interfaceC10704c);
        if (executorServiceM65325d != null) {
            executorServiceM65325d.execute(new RunnableC9882f(runnable));
        } else {
            AbstractC10915a.m65979k("AsyncExec", "no executor for type: %s", interfaceC10704c);
        }
    }

    /* renamed from: h */
    public static void m65329h(Runnable runnable) {
        m65327f(runnable, b.SEQUENCE_IO);
    }
}
