package com.huawei.hms.network.p129ai;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.ThreadPoolExcutorEnhance;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.ai.e */
/* loaded from: classes8.dex */
public class C5794e {

    /* renamed from: d */
    public static final C5794e f25814d = new C5794e();

    /* renamed from: e */
    public static final String f25815e = "AiTrain";

    /* renamed from: f */
    public static final String f25816f = "AiExec";

    /* renamed from: g */
    public static final int f25817g = 1;

    /* renamed from: h */
    public static final int f25818h = 1;

    /* renamed from: i */
    public static final int f25819i = 2;

    /* renamed from: j */
    public static final int f25820j = 5;

    /* renamed from: k */
    public static final int f25821k = 5;

    /* renamed from: l */
    public static final int f25822l = 64;

    /* renamed from: a */
    public RejectedExecutionHandler f25823a = new ThreadPoolExecutor.DiscardOldestPolicy();

    /* renamed from: b */
    public ThreadPoolExecutor f25824b;

    /* renamed from: c */
    public ThreadPoolExecutor f25825c;

    public C5794e() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f25824b = new ThreadPoolExcutorEnhance(1, 1, 5, timeUnit, new LinkedBlockingQueue(64), ExecutorsUtils.createThreadFactory(f25815e), this.f25823a);
        this.f25825c = new ThreadPoolExcutorEnhance(2, 5, 5L, timeUnit, new LinkedBlockingQueue(), ExecutorsUtils.createThreadFactory(f25816f));
        this.f25824b.allowCoreThreadTimeOut(true);
        this.f25825c.allowCoreThreadTimeOut(true);
    }

    /* renamed from: a */
    public static C5794e m33310a() {
        return f25814d;
    }

    /* renamed from: b */
    public void m33312b(Runnable runnable) {
        try {
            this.f25825c.execute(new RunnableC5806k(runnable));
        } catch (RejectedExecutionException unused) {
            Logger.m32136d("AIexecute", "executeUrgent meet RejectedExecutionException");
        }
    }

    /* renamed from: a */
    public void m33311a(Runnable runnable) {
        try {
            this.f25824b.execute(new RunnableC5806k(runnable));
        } catch (RejectedExecutionException unused) {
            Logger.m32136d("AIexecute", "executeTrain meet RejectedExecutionException");
        }
    }
}
