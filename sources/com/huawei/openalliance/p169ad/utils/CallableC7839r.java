package com.huawei.openalliance.p169ad.utils;

import android.util.Log;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.openalliance.ad.utils.r */
/* loaded from: classes2.dex */
public class CallableC7839r<V> implements Callable<V> {

    /* renamed from: a */
    private Callable<V> f36142a;

    public CallableC7839r(Callable<V> callable) {
        this.f36142a = callable;
    }

    @Override // java.util.concurrent.Callable
    public V call() {
        Callable<V> callable = this.f36142a;
        if (callable != null) {
            try {
                try {
                    return callable.call();
                } catch (Throwable unused) {
                    Log.e("SafeCallable", "Exception in CallableWrapper");
                }
            } finally {
                this.f36142a = null;
            }
        }
        return null;
    }
}
