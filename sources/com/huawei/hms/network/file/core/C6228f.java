package com.huawei.hms.network.file.core;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.ThreadPoolExcutorEnhance;
import com.huawei.hms.network.file.api.GlobalRequestConfig;
import com.huawei.hms.network.file.core.util.FLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.file.core.f */
/* loaded from: classes8.dex */
public class C6228f {

    /* renamed from: f */
    private static final Object f29402f = new Object();

    /* renamed from: g */
    private static volatile ThreadPoolExecutor f29403g;

    /* renamed from: a */
    private GlobalRequestConfig f29404a;

    /* renamed from: b */
    ThreadPoolExecutor f29405b;

    /* renamed from: c */
    ExecutorService f29406c;

    /* renamed from: d */
    ExecutorService f29407d;

    /* renamed from: e */
    int f29408e;

    public C6228f(GlobalRequestConfig globalRequestConfig) {
        this.f29404a = globalRequestConfig;
    }

    /* renamed from: f */
    public static ThreadPoolExecutor m36213f() {
        if (f29403g == null) {
            synchronized (f29402f) {
                try {
                    if (f29403g == null) {
                        f29403g = new ThreadPoolExcutorEnhance(2, 2, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), ExecutorsUtils.createThreadFactory("initPoolThread"));
                    }
                } finally {
                }
            }
        }
        f29403g.allowCoreThreadTimeOut(true);
        return f29403g;
    }

    /* renamed from: g */
    private void m36214g() {
        int iM36184c = C6224b.m36184c();
        if (iM36184c <= 0) {
            iM36184c = Runtime.getRuntime().availableProcessors() * 2;
        }
        this.f29408e = iM36184c;
        GlobalRequestConfig globalRequestConfig = this.f29404a;
        if (globalRequestConfig != null && globalRequestConfig.getThreadPoolSize() != -100) {
            iM36184c = this.f29404a.getThreadPoolSize();
            this.f29408e = iM36184c;
            FLogger.m36353i("ThreadPoolManager", "use taskPoolSize executeCorePoolSize:" + iM36184c, new Object[0]);
        }
        int i10 = iM36184c;
        FLogger.m36353i("ThreadPoolManager", "executeCorePoolSize:" + i10 + ",maxThreadPoolSize:" + this.f29408e, new Object[0]);
        if (this.f29405b == null) {
            ThreadPoolExcutorEnhance threadPoolExcutorEnhance = new ThreadPoolExcutorEnhance(i10, this.f29408e, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), ExecutorsUtils.createThreadFactory("fileTaskPoolThread"));
            this.f29405b = threadPoolExcutorEnhance;
            threadPoolExcutorEnhance.allowCoreThreadTimeOut(true);
        }
        if (this.f29406c == null) {
            this.f29406c = ExecutorsUtils.newSingleThreadExecutor("fileRespPoolThread");
        }
        if (this.f29407d == null) {
            this.f29407d = ExecutorsUtils.newSingleThreadExecutor("fileExtraPoolThread");
        }
    }

    /* renamed from: a */
    public synchronized ExecutorService m36215a() {
        try {
            if (this.f29407d == null) {
                m36214g();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f29407d;
    }

    /* renamed from: b */
    public int m36216b() {
        return this.f29408e;
    }

    /* renamed from: c */
    public synchronized ExecutorService m36217c() {
        try {
            if (this.f29406c == null) {
                m36214g();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f29406c;
    }

    /* renamed from: d */
    public synchronized ThreadPoolExecutor m36218d() {
        try {
            if (this.f29405b == null) {
                m36214g();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f29405b;
    }

    /* renamed from: e */
    public synchronized void m36219e() {
        try {
            FLogger.m36353i("ThreadPoolManager", "shutdown executors", new Object[0]);
            ThreadPoolExecutor threadPoolExecutor = this.f29405b;
            if (threadPoolExecutor != null || this.f29406c != null || this.f29407d != null) {
                m36212a(threadPoolExecutor, this.f29406c, this.f29407d);
                this.f29405b = null;
                this.f29406c = null;
                this.f29407d = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    private void m36212a(ExecutorService... executorServiceArr) {
        for (ExecutorService executorService : executorServiceArr) {
            if (executorService != null && !executorService.isShutdown()) {
                executorService.shutdown();
            }
        }
    }
}
