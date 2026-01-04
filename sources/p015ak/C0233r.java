package p015ak;

import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p399jk.AbstractC10896a;
import p780xm.C13834f;

/* renamed from: ak.r */
/* loaded from: classes6.dex */
public class C0233r {

    /* renamed from: a */
    public final AtomicBoolean f857a;

    /* renamed from: b */
    public C13834f<Boolean> f858b;

    /* renamed from: c */
    public ExecutorService f859c;

    /* renamed from: ak.r$b */
    public static class b {

        /* renamed from: a */
        public static C0233r f860a = new C0233r();
    }

    /* renamed from: b */
    public static C0233r m1618b() {
        return b.f860a;
    }

    /* renamed from: c */
    public C13834f<Boolean> m1619c() {
        if (this.f858b.isDone()) {
            AbstractC10896a.m65887i("Initializer", "init done");
            return this.f858b;
        }
        this.f859c.submit(new Callable() { // from class: ak.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f856a.m1621e();
            }
        });
        return this.f858b;
    }

    /* renamed from: d */
    public void m1620d() {
        this.f857a.compareAndSet(false, true);
    }

    /* renamed from: e */
    public final /* synthetic */ C13834f m1621e() throws Exception {
        while (!this.f857a.get()) {
            SystemClock.sleep(200L);
        }
        this.f858b.m82976e(new C13834f.b<>(0, Boolean.TRUE));
        return this.f858b;
    }

    public C0233r() {
        this.f857a = new AtomicBoolean(false);
        this.f858b = new C13834f<>();
        this.f859c = new ThreadPoolExecutor(5, 20, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadPoolExecutor.DiscardOldestPolicy());
    }
}
