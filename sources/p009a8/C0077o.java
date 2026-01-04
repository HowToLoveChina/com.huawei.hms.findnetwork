package p009a8;

import com.huawei.hms.network.embedded.C6068r0;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p031b7.C1120a;

/* renamed from: a8.o */
/* loaded from: classes2.dex */
public class C0077o {

    /* renamed from: b */
    public static final Object f293b = new Object();

    /* renamed from: c */
    public static final C0077o f294c = new C0077o();

    /* renamed from: a */
    public ExecutorService f295a = null;

    /* renamed from: b */
    public static C0077o m632b() {
        return f294c;
    }

    /* renamed from: a */
    public <T> T m633a(Callable<T> callable, long j10, TimeUnit timeUnit) {
        m634c();
        Future<T> futureSubmit = this.f295a.submit(callable);
        try {
            return (j10 == 0 || timeUnit == null) ? futureSubmit.get() : futureSubmit.get(j10, timeUnit);
        } catch (Exception e10) {
            futureSubmit.cancel(true);
            C1120a.m6676e(C6068r0.f27961f, "execute error: " + e10.toString());
            return null;
        }
    }

    /* renamed from: c */
    public final void m634c() {
        synchronized (f293b) {
            try {
                ExecutorService executorService = this.f295a;
                if (executorService == null || executorService.isShutdown()) {
                    this.f295a = Executors.newFixedThreadPool(2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
