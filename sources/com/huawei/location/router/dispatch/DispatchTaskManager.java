package com.huawei.location.router.dispatch;

import as.C1016d;
import com.huawei.location.router.entity.IRouterResponse;
import com.huawei.location.router.entity.RouterRequest;
import es.C9539d;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes8.dex */
public class DispatchTaskManager {
    private static final long KEEP_ALIVE_TIME = 60;
    private static final String LOCATION_DISPATCH_TASK_MANAGER = "Location_DispatchTaskManager";
    private static final int THREAD_CORE = Runtime.getRuntime().availableProcessors();
    private static final int THREAD_TIME_OUT_SECONDS = 3;
    private ThreadPoolExecutor mExecutorService;

    /* renamed from: com.huawei.location.router.dispatch.DispatchTaskManager$a */
    public static class C6809a {

        /* renamed from: a */
        public static final DispatchTaskManager f31399a = new DispatchTaskManager();
    }

    private DispatchTaskManager() {
        init();
    }

    public static DispatchTaskManager getInstance() {
        return C6809a.f31399a;
    }

    private void init() {
        int i10 = THREAD_CORE;
        DispatchThreadPoolExecutor dispatchThreadPoolExecutor = new DispatchThreadPoolExecutor(i10, i10 * 2, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), C9539d.m59580a(LOCATION_DISPATCH_TASK_MANAGER));
        this.mExecutorService = dispatchThreadPoolExecutor;
        dispatchThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public void dispatchTask(RouterRequest routerRequest) {
        ThreadPoolExecutor threadPoolExecutor = this.mExecutorService;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new DispatchRunnable(routerRequest));
        }
    }

    public IRouterResponse executeTask(RouterRequest routerRequest) {
        ThreadPoolExecutor threadPoolExecutor = this.mExecutorService;
        if (threadPoolExecutor == null) {
            return null;
        }
        try {
            return (IRouterResponse) threadPoolExecutor.submit(new DispatchCallable(routerRequest)).get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            C1016d.m6183c("DispatchTaskManager", "enqueue task failed");
            return null;
        }
    }
}
