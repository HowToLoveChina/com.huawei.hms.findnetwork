package com.huawei.android.hicloud.sync.protocol;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.sync.protocol.a */
/* loaded from: classes3.dex */
public abstract class AbstractCallableC2922a<V> implements Callable<V> {

    /* renamed from: a */
    public boolean f12945a = false;

    /* renamed from: b */
    public boolean f12946b = false;

    /* renamed from: c */
    public Future<?> f12947c;

    /* renamed from: a */
    public void mo17735a() {
        this.f12946b = true;
    }

    /* renamed from: b */
    public void m17736b(boolean z10) throws InterruptedException {
        mo17735a();
        try {
            C11839m.m70686d("BaseDownloadCallable", "thread sleep 500ms");
            Thread.sleep(500L);
        } catch (InterruptedException unused) {
            C11839m.m70689w("BaseDownloadCallable", "InterruptedException");
        }
        Future<?> future = this.f12947c;
        if (future != null) {
            future.cancel(z10);
        }
        mo17739e();
    }

    /* renamed from: c */
    public abstract V mo17737c();

    @Override // java.util.concurrent.Callable
    public V call() throws Exception {
        try {
            try {
                this.f12945a = true;
                return mo17737c();
            } catch (Exception e10) {
                C11839m.m70687e("BaseDownloadCallable", e10.toString());
                mo17739e();
                this.f12945a = false;
                return null;
            }
        } finally {
            mo17739e();
            this.f12945a = false;
        }
    }

    /* renamed from: d */
    public boolean m17738d() {
        return this.f12946b;
    }

    /* renamed from: e */
    public abstract void mo17739e();

    /* renamed from: f */
    public void m17740f(Future<?> future) {
        this.f12947c = future;
    }
}
