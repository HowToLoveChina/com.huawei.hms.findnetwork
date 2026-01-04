package com.huawei.android.p069cg.request.threadpool;

import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;
import p031b7.C1120a;

/* renamed from: com.huawei.android.cg.request.threadpool.c */
/* loaded from: classes2.dex */
public class CallableC2322c implements Callable<Object> {

    /* renamed from: f */
    public static final Object f11050f = new Object();

    /* renamed from: a */
    public ExecutorService f11051a;

    /* renamed from: b */
    public ExecutorService f11052b;

    /* renamed from: c */
    public Vector<Map<String, Object>> f11053c;

    /* renamed from: d */
    public Vector<Map<String, Object>> f11054d;

    /* renamed from: e */
    public long f11055e;

    public CallableC2322c(ExecutorService executorService, ExecutorService executorService2, Vector<Map<String, Object>> vector, long j10) {
        this.f11054d = null;
        this.f11052b = executorService;
        this.f11051a = executorService2;
        this.f11053c = vector;
        this.f11055e = j10;
    }

    /* renamed from: a */
    public final void m14594a(Object obj, Exception exc, Map<String, Object> map, AbstractC2324e abstractC2324e) {
        if ((exc == null || (exc instanceof TimeoutException)) && exc != null) {
            return;
        }
        synchronized (f11050f) {
            try {
                Vector<Map<String, Object>> vector = this.f11054d;
                if (vector != null) {
                    vector.remove(map);
                }
                if (abstractC2324e != null) {
                    abstractC2324e.handle(obj);
                }
            } finally {
            }
        }
    }

    /* renamed from: b */
    public final void m14595b(Map<String, Object> map) {
        Vector<Map<String, Object>> vector = this.f11054d;
        if (vector != null) {
            vector.add(map);
        }
    }

    /* renamed from: c */
    public final void m14596c(Object obj, Map<String, Object> map, AbstractCallableC2320a abstractCallableC2320a, AbstractC2324e abstractC2324e) {
        if (abstractCallableC2320a.getCurrentRetry() >= abstractCallableC2320a.getRetry()) {
            Vector<Map<String, Object>> vector = this.f11054d;
            if (vector != null) {
                vector.remove(map);
            }
            if (abstractC2324e != null) {
                abstractC2324e.handle(obj);
                return;
            }
            return;
        }
        abstractCallableC2320a.setCurrentRetry(abstractCallableC2320a.getCurrentRetry() + 1);
        if (this.f11052b.isShutdown()) {
            return;
        }
        Vector<Map<String, Object>> vector2 = this.f11054d;
        if (vector2 != null) {
            vector2.remove(map);
        }
        this.f11053c.add(0, map);
        if (this.f11052b.submit(this) == null) {
            C1120a.m6675d("FixedCallable", "future fail");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0179 A[Catch: all -> 0x016f, TryCatch #8 {all -> 0x016f, blocks: (B:38:0x0131, B:40:0x0135, B:43:0x013a, B:45:0x013e, B:48:0x0173, B:50:0x0179, B:51:0x017c), top: B:66:0x0131 }] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object call() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.p069cg.request.threadpool.CallableC2322c.call():java.lang.Object");
    }

    public CallableC2322c(ExecutorService executorService, ExecutorService executorService2, Vector<Map<String, Object>> vector, Vector<Map<String, Object>> vector2, long j10) {
        this.f11052b = executorService;
        this.f11051a = executorService2;
        this.f11053c = vector;
        this.f11054d = vector2;
        this.f11055e = j10;
    }
}
