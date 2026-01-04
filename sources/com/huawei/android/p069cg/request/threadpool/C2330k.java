package com.huawei.android.p069cg.request.threadpool;

import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.huawei.android.cg.request.threadpool.k */
/* loaded from: classes2.dex */
public class C2330k {

    /* renamed from: a */
    public int f11056a;

    /* renamed from: b */
    public long f11057b;

    /* renamed from: c */
    public ExecutorService f11058c = null;

    /* renamed from: d */
    public ExecutorService f11059d = null;

    /* renamed from: e */
    public Vector<Map<String, Object>> f11060e = null;

    /* renamed from: f */
    public Vector<Map<String, Object>> f11061f = null;

    public C2330k(int i10, long j10) {
        this.f11056a = i10;
        this.f11057b = j10;
    }

    /* renamed from: a */
    public void m14598a() {
        ExecutorService executorService = this.f11058c;
        if (executorService == null || executorService.isShutdown()) {
            this.f11058c = Executors.newFixedThreadPool(this.f11056a);
        }
        ExecutorService executorService2 = this.f11059d;
        if (executorService2 == null || executorService2.isShutdown()) {
            this.f11059d = Executors.newFixedThreadPool(this.f11056a);
        }
        if (this.f11060e == null) {
            this.f11060e = new Vector<>();
        }
        if (this.f11061f == null) {
            this.f11061f = new Vector<>();
        }
    }

    /* renamed from: b */
    public Vector<Map<String, Object>> m14599b() {
        return this.f11061f;
    }

    /* renamed from: c */
    public Vector<Map<String, Object>> m14600c() {
        return this.f11060e;
    }

    /* renamed from: d */
    public long m14601d() {
        return this.f11057b;
    }

    /* renamed from: e */
    public ExecutorService m14602e() {
        return this.f11058c;
    }

    /* renamed from: f */
    public ExecutorService m14603f() {
        return this.f11059d;
    }
}
