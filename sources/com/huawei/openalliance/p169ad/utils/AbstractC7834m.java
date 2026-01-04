package com.huawei.openalliance.p169ad.utils;

import android.os.Looper;
import com.huawei.android.hicloud.album.service.logic.callable.ReportRisksCallable;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.openalliance.ad.utils.m */
/* loaded from: classes2.dex */
public abstract class AbstractC7834m {

    /* renamed from: a */
    private static Map<a, ExecutorService> f36114a;

    /* renamed from: com.huawei.openalliance.ad.utils.m$a */
    public enum a {
        IO,
        NETWORK,
        NETWORK_SEQUENCE,
        CALCULATION,
        SEQUENCE,
        DOWNLOAD,
        EVENT,
        SYNC_CALL,
        SPLASH_NET,
        DISK_CACHE,
        DEVICE,
        WEBVIEW_PRELOAD,
        COLLECT_SEQUENCE,
        SOCKET,
        PARALLEL
    }

    static {
        m48478a();
    }

    /* renamed from: a */
    public static <T> List<Future<T>> m48476a(Collection<? extends Callable<T>> collection, long j10) {
        try {
            ExecutorService executorService = f36114a.get(a.PARALLEL);
            if (executorService != null) {
                return executorService.invokeAll(collection, j10, TimeUnit.MILLISECONDS);
            }
            return null;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("AsyncExec", "parallel tasks fail");
            return null;
        }
    }

    /* renamed from: b */
    public static void m48481b(Runnable runnable) {
        m48480a(runnable, a.NETWORK, false);
    }

    /* renamed from: c */
    public static void m48483c(Runnable runnable) {
        m48480a(runnable, a.NETWORK_SEQUENCE, false);
    }

    /* renamed from: d */
    public static void m48484d(Runnable runnable) {
        m48480a(runnable, a.DOWNLOAD, false);
    }

    /* renamed from: e */
    public static void m48485e(Runnable runnable) {
        m48480a(runnable, a.WEBVIEW_PRELOAD, false);
    }

    /* renamed from: f */
    public static void m48486f(Runnable runnable) {
        m48480a(runnable, a.CALCULATION, false);
    }

    /* renamed from: g */
    public static void m48487g(Runnable runnable) {
        m48480a(runnable, a.SEQUENCE, false);
    }

    /* renamed from: h */
    public static void m48488h(Runnable runnable) {
        m48480a(runnable, a.EVENT, false);
    }

    /* renamed from: i */
    public static void m48489i(Runnable runnable) {
        m48480a(runnable, a.DEVICE, false);
    }

    /* renamed from: j */
    public static void m48490j(Runnable runnable) {
        m48480a(runnable, a.COLLECT_SEQUENCE, false);
    }

    /* renamed from: k */
    public static void m48491k(Runnable runnable) {
        m48480a(runnable, a.SOCKET, false);
    }

    /* renamed from: a */
    public static <V> Future<V> m48477a(Callable<V> callable, a aVar) {
        return f36114a.get(aVar).submit(callable);
    }

    /* renamed from: b */
    private static boolean m48482b() {
        Looper mainLooper = Looper.getMainLooper();
        return mainLooper != null && Thread.currentThread() == mainLooper.getThread();
    }

    /* renamed from: a */
    private static synchronized void m48478a() {
        if (f36114a == null) {
            HashMap map = new HashMap();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n("PARALLEL", 10));
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(3, 3, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n("IO"));
            threadPoolExecutor2.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(3, 5, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n("Net"));
            threadPoolExecutor3.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(1, 1, 60L, timeUnit, new LinkedBlockingQueue(10), new ThreadFactoryC7835n("NetSeq"), new ThreadPoolExecutor.DiscardOldestPolicy());
            threadPoolExecutor4.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor5 = new ThreadPoolExecutor(1, 1, 60L, timeUnit, new LinkedBlockingQueue(10), new ThreadFactoryC7835n("Download"), new ThreadPoolExecutor.DiscardOldestPolicy());
            threadPoolExecutor5.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor6 = new ThreadPoolExecutor(1, 1, 60L, timeUnit, new LinkedBlockingQueue(10), new ThreadFactoryC7835n("WebViewDownload"), new ThreadPoolExecutor.DiscardOldestPolicy());
            threadPoolExecutor5.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor7 = new ThreadPoolExecutor(3, 3, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n("Cal"));
            threadPoolExecutor7.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor8 = new ThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n("Seq"));
            threadPoolExecutor8.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor9 = new ThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n(Event.TAG));
            threadPoolExecutor9.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor10 = new ThreadPoolExecutor(3, 3, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n("SyncCall", 10));
            threadPoolExecutor10.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor11 = new ThreadPoolExecutor(0, 3, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n("SplashNet", 10));
            threadPoolExecutor11.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor12 = new ThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n("DiskCache"));
            threadPoolExecutor8.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor13 = new ThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n("Device"));
            threadPoolExecutor13.allowCoreThreadTimeOut(true);
            ThreadPoolExecutor threadPoolExecutor14 = new ThreadPoolExecutor(0, 1, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n("ClctSeq"));
            ThreadPoolExecutor threadPoolExecutor15 = new ThreadPoolExecutor(0, 8, 60L, timeUnit, new LinkedBlockingQueue(), new ThreadFactoryC7835n(ReportRisksCallable.RISK_INFO_CREATE_KIND));
            threadPoolExecutor15.allowCoreThreadTimeOut(true);
            map.put(a.PARALLEL, threadPoolExecutor);
            map.put(a.IO, threadPoolExecutor2);
            map.put(a.NETWORK, threadPoolExecutor3);
            map.put(a.DOWNLOAD, threadPoolExecutor5);
            map.put(a.WEBVIEW_PRELOAD, threadPoolExecutor6);
            map.put(a.CALCULATION, threadPoolExecutor7);
            map.put(a.SEQUENCE, threadPoolExecutor8);
            map.put(a.EVENT, threadPoolExecutor9);
            map.put(a.SYNC_CALL, threadPoolExecutor10);
            map.put(a.SPLASH_NET, threadPoolExecutor11);
            map.put(a.DISK_CACHE, threadPoolExecutor12);
            map.put(a.DEVICE, threadPoolExecutor13);
            map.put(a.COLLECT_SEQUENCE, threadPoolExecutor14);
            map.put(a.SOCKET, threadPoolExecutor15);
            map.put(a.NETWORK_SEQUENCE, threadPoolExecutor4);
            f36114a = map;
        }
    }

    /* renamed from: a */
    public static void m48479a(Runnable runnable) {
        m48480a(runnable, a.IO, false);
    }

    /* renamed from: a */
    public static void m48480a(Runnable runnable, a aVar, boolean z10) {
        if (runnable == null) {
            return;
        }
        if (z10 && !m48482b()) {
            new RunnableC7813df(runnable).run();
            return;
        }
        ExecutorService executorService = f36114a.get(aVar);
        if (executorService != null) {
            executorService.execute(new RunnableC7813df(runnable));
        } else {
            AbstractC7185ho.m43824c("AsyncExec", "no executor for type: %s", aVar);
        }
    }
}
