package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.d8 */
/* loaded from: classes8.dex */
public abstract class AbstractRunnableC5893d8 implements Runnable {

    /* renamed from: a */
    public final String f26648a;

    public AbstractRunnableC5893d8(String str, Object... objArr) {
        this.f26648a = C5920f8.m34236a(str, objArr);
    }

    /* renamed from: b */
    public abstract void mo34106b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f26648a);
        try {
            mo34106b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
