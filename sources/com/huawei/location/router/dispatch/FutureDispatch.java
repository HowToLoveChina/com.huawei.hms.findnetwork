package com.huawei.location.router.dispatch;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes8.dex */
public class FutureDispatch<V> extends FutureTask<V> {
    private final Callable<V> callable;

    public FutureDispatch(Callable<V> callable) {
        super(callable);
        this.callable = callable;
    }

    public Callable<V> getCallable() {
        return this.callable;
    }
}
