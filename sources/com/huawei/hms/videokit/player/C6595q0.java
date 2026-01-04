package com.huawei.hms.videokit.player;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.videokit.player.q0 */
/* loaded from: classes8.dex */
public final class C6595q0 {

    /* renamed from: a */
    private static final int f30662a;

    /* renamed from: b */
    private static final int f30663b;

    /* renamed from: c */
    private static final ThreadPoolExecutor f30664c;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f30662a = iAvailableProcessors;
        int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        f30663b = iMax;
        f30664c = new ThreadPoolExecutor(iMax, iMax, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    /* renamed from: a */
    public static void m37636a(Runnable runnable) {
        try {
            f30664c.submit(runnable);
        } catch (RejectedExecutionException unused) {
            C6550c1.m37262b("ThreadPoolUtil", "submit ");
        }
    }
}
