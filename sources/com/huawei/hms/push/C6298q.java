package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.push.q */
/* loaded from: classes8.dex */
public class C6298q {

    /* renamed from: a */
    private static final Object f29712a = new Object();

    /* renamed from: b */
    private static ThreadPoolExecutor f29713b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    public static ThreadPoolExecutor m36594a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (f29712a) {
            threadPoolExecutor = f29713b;
        }
        return threadPoolExecutor;
    }
}
