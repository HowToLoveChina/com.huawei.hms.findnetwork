package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Opers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.huawei.hms.network.embedded.e1 */
/* loaded from: classes8.dex */
public final class C5900e1 {

    /* renamed from: b */
    public static final String f26671b = "RequestThreadPoolMgr";

    /* renamed from: a */
    public ExecutorService f26672a;

    /* renamed from: com.huawei.hms.network.embedded.e1$b */
    public static class b {
        public static final C5900e1 INSTANCE = new C5900e1();
    }

    public C5900e1() {
        this.f26672a = null;
        Logger.m32141i(f26671b, "ThreadPool init!");
        this.f26672a = Executors.newCachedThreadPool(ExecutorsUtils.createThreadFactory(TrackConstants$Opers.REQUEST));
    }

    public static C5900e1 getInstance() {
        return b.INSTANCE;
    }

    public void execute(Runnable runnable) {
        try {
            this.f26672a.execute(runnable);
        } catch (RejectedExecutionException unused) {
            Logger.m32138e(f26671b, "the runnable task cannot be accepted for execution");
        }
    }

    public void release() {
        Logger.m32141i(f26671b, "ThreadPool release!");
        ExecutorService executorService = this.f26672a;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        this.f26672a.shutdown();
    }

    public Future submit(Runnable runnable) {
        try {
            return this.f26672a.submit(runnable);
        } catch (RejectedExecutionException unused) {
            Logger.m32138e(f26671b, "the runnable task cannot be accepted for execution");
            return null;
        }
    }
}
