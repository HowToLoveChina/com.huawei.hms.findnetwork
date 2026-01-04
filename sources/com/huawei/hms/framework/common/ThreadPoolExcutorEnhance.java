package com.huawei.hms.framework.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class ThreadPoolExcutorEnhance extends ThreadPoolExecutor {
    public ThreadPoolExcutorEnhance(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof RunnableEnhance) {
            String parentName = ((RunnableEnhance) runnable).getParentName();
            int iLastIndexOf = parentName.lastIndexOf(" ->");
            if (iLastIndexOf != -1) {
                parentName = StringUtils.substring(parentName, iLastIndexOf + 3);
            }
            String name = thread.getName();
            int iLastIndexOf2 = name.lastIndexOf(" ->");
            if (iLastIndexOf2 != -1) {
                name = StringUtils.substring(name, iLastIndexOf2 + 3);
            }
            thread.setName(parentName + " ->" + name);
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        super.execute(new RunnableEnhance(runnable));
    }

    public ThreadPoolExcutorEnhance(int i10, int i11, int i12, TimeUnit timeUnit, LinkedBlockingQueue<Runnable> linkedBlockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i10, i11, i12, timeUnit, linkedBlockingQueue, threadFactory, rejectedExecutionHandler);
    }
}
