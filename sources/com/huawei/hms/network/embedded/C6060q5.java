package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.ThreadPoolExcutorEnhance;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.q5 */
/* loaded from: classes8.dex */
public class C6060q5 {

    /* renamed from: c */
    public static final String f27848c = "ThreadManager";

    /* renamed from: a */
    public RejectedExecutionHandler f27849a;

    /* renamed from: b */
    public ThreadPoolExecutor f27850b;

    /* renamed from: com.huawei.hms.network.embedded.q5$b */
    public static class b {

        /* renamed from: a */
        public static final C6060q5 f27851a = new C6060q5();
    }

    /* renamed from: com.huawei.hms.network.embedded.q5$c */
    public static class c implements Runnable {

        /* renamed from: a */
        public Runnable f27852a;

        public c(Runnable runnable) {
            this.f27852a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f27852a.run();
            } catch (Throwable th2) {
                Logger.m32139e(C6060q5.f27848c, "task exception!", th2);
                HianalyticsHelper.getInstance().reportException(th2, CrashHianalyticsData.EVENT_ID_CRASH);
            }
        }
    }

    public C6060q5() {
        this.f27849a = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExcutorEnhance threadPoolExcutorEnhance = new ThreadPoolExcutorEnhance(1, 1, 300, TimeUnit.SECONDS, new LinkedBlockingQueue(48), ExecutorsUtils.createThreadFactory("NetworkKit_Netdiag"), this.f27849a);
        this.f27850b = threadPoolExcutorEnhance;
        threadPoolExcutorEnhance.allowCoreThreadTimeOut(true);
    }

    /* renamed from: a */
    public static C6060q5 m35062a() {
        return b.f27851a;
    }

    /* renamed from: a */
    public void m35063a(Runnable runnable) {
        try {
            this.f27850b.execute(new c(runnable));
        } catch (Throwable th2) {
            Logger.m32139e(f27848c, "task exception!", th2);
            HianalyticsHelper.getInstance().reportException(th2, CrashHianalyticsData.EVENT_ID_CRASH);
        }
    }
}
