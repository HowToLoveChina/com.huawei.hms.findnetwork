package com.huawei.android.p069cg.request.threadpool;

/* renamed from: com.huawei.android.cg.request.threadpool.e */
/* loaded from: classes2.dex */
public abstract class AbstractC2324e {
    private Object object;

    public AbstractC2324e(Object obj) {
        this.object = obj;
    }

    public abstract void handle(Object obj);

    public String toString() {
        return "HandleCallable [o=" + this.object + "]";
    }
}
