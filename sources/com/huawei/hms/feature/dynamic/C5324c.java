package com.huawei.hms.feature.dynamic;

import com.huawei.hms.common.util.Logger;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.feature.dynamic.c */
/* loaded from: classes8.dex */
public class C5324c {

    /* renamed from: a */
    public static final String f24700a = "ExecutorsManager";

    /* renamed from: b */
    public static final long f24701b = 60;

    /* renamed from: com.huawei.hms.feature.dynamic.c$a */
    public static class a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f24702a = new AtomicInteger(1);

        /* renamed from: b */
        public final String f24703b;

        /* renamed from: com.huawei.hms.feature.dynamic.c$a$a, reason: collision with other inner class name */
        public class C14438a implements Thread.UncaughtExceptionHandler {
            public C14438a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th2) {
                Logger.m30737e(C5324c.f24700a, thread.getName() + " : " + th2.getMessage());
            }
        }

        public a(String str) {
            this.f24703b = str + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f24703b + this.f24702a.getAndIncrement());
            thread.setUncaughtExceptionHandler(new C14438a());
            return thread;
        }
    }

    /* renamed from: a */
    public static ExecutorService m31883a(int i10, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
