package com.huawei.hms.videokit.player;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* renamed from: com.huawei.hms.videokit.player.r0 */
/* loaded from: classes8.dex */
public final class C6596r0 {

    /* renamed from: b */
    private static volatile C6596r0 f30665b;

    /* renamed from: a */
    private ExecutorService f30666a;

    private C6596r0() {
        this.f30666a = null;
        this.f30666a = Executors.newCachedThreadPool();
    }

    /* renamed from: a */
    public static C6596r0 m37637a() {
        if (f30665b == null) {
            synchronized (C6596r0.class) {
                try {
                    if (f30665b == null) {
                        f30665b = new C6596r0();
                    }
                } finally {
                }
            }
        }
        return f30665b;
    }

    /* renamed from: a */
    public Future m37638a(Callable callable) {
        try {
            return this.f30666a.submit(callable);
        } catch (Exception e10) {
            C6550c1.m37258a("ThreadPoolUtils", "submit:", e10);
            return null;
        }
    }

    /* renamed from: a */
    public void m37639a(Future<?> future) {
        if (future != null) {
            future.cancel(true);
        }
    }
}
