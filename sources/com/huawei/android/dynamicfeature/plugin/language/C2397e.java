package com.huawei.android.dynamicfeature.plugin.language;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.android.dynamicfeature.plugin.language.e */
/* loaded from: classes2.dex */
public class C2397e {

    /* renamed from: a */
    public static final ThreadPoolExecutor f11478a;

    /* renamed from: com.huawei.android.dynamicfeature.plugin.language.e$b */
    public static final class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "LanguagePluginBackgroundThread");
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());
        f11478a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /* renamed from: a */
    public static Executor m14993a() {
        return f11478a;
    }
}
