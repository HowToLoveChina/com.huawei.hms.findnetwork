package p780xm;

import cn.C1462b;
import java.util.concurrent.Callable;
import p780xm.C13834f;

/* renamed from: xm.c */
/* loaded from: classes6.dex */
public class CallableC13831c<T> implements Callable<C13834f.b<T>> {

    /* renamed from: a */
    public final Callable<T> f62042a;

    public CallableC13831c(Callable<T> callable) {
        this.f62042a = callable;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public C13834f.b<T> call() throws Exception {
        try {
            return new C13834f.b<>(0, this.f62042a.call());
        } catch (Exception e10) {
            C1462b.m8362f("ExceptionSafeCallable", "exception in callable: " + e10.getMessage());
            return new C13834f.b<>(1, null);
        }
    }
}
