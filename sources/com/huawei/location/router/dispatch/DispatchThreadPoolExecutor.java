package com.huawei.location.router.dispatch;

import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.router.RouterTaskHandler;
import com.huawei.location.router.entity.RouterRequest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class DispatchThreadPoolExecutor extends ThreadPoolExecutor {
    public DispatchThreadPoolExecutor(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory);
    }

    private void processRequest(DispatchBaseRunnable dispatchBaseRunnable) {
        try {
            RouterRequest routerRequest = dispatchBaseRunnable.getRouterRequest();
            if (routerRequest == null) {
                throw new DispatchException(10002, "TaskApiEntity Object is Empty");
            }
            String str = RouterTaskHandler.getInstance().getApiRequestMap().get(routerRequest.getApiName());
            if (str == null) {
                throw new DispatchException(10001, "api interface not register");
            }
            try {
                try {
                    try {
                        try {
                            dispatchBaseRunnable.setApiRequest((BaseRouterTaskCallImpl) Class.forName(str).newInstance());
                        } catch (IllegalAccessException unused) {
                            throw new DispatchException(10003, "IllegalAccessException");
                        }
                    } catch (InstantiationException unused2) {
                        throw new DispatchException(10003, "InstantiationException");
                    }
                } catch (Exception unused3) {
                    throw new DispatchException(10003, "InstantiationException");
                }
            } catch (ClassNotFoundException unused4) {
                throw new DispatchException(10003, "class not found exception");
            }
        } catch (DispatchException e10) {
            dispatchBaseRunnable.onDispatchError(e10.getExceptionCode(), e10.getMessage());
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (runnable instanceof DispatchRunnable) {
            processRequest((DispatchRunnable) runnable);
        }
        if (runnable instanceof FutureDispatch) {
            Callable callable = ((FutureDispatch) runnable).getCallable();
            if (callable instanceof DispatchCallable) {
                processRequest((DispatchCallable) callable);
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new FutureDispatch(callable);
    }
}
