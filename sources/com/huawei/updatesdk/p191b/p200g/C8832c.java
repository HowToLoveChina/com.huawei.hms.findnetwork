package com.huawei.updatesdk.p191b.p200g;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.updatesdk.b.g.c */
/* loaded from: classes9.dex */
public class C8832c {

    /* renamed from: a */
    public static final ThreadPoolExecutor f45172a;

    /* renamed from: b */
    public static final ThreadPoolExecutor f45173b;

    /* renamed from: com.huawei.updatesdk.b.g.c$a */
    public static class a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f45174a = new AtomicInteger();

        /* renamed from: b */
        private final String f45175b;

        public a(String str) {
            this.f45175b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f45175b + "#" + this.f45174a.incrementAndGet());
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f45172a = new ThreadPoolExecutor(2, 2, 10L, timeUnit, new LinkedBlockingQueue(), new a("UpdateSDK-ServerTask"));
        f45173b = new ThreadPoolExecutor(3, 8, 5L, timeUnit, new LinkedBlockingQueue(), new a("UpdateSDK-CheckTask"));
    }
}
