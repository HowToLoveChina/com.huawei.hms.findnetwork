package com.huawei.android.p069cg.request.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.android.cg.request.threadpool.d */
/* loaded from: classes2.dex */
public final class C2323d {
    /* renamed from: a */
    public static Object m14597a(Future<Object> future, long j10) throws ExecutionException, InterruptedException, TimeoutException {
        return j10 == -1 ? future.get() : future.get(j10, TimeUnit.MILLISECONDS);
    }
}
