package p780xm;

import cn.C1462b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p780xm.C13834f;

/* renamed from: xm.f */
/* loaded from: classes6.dex */
public class C13834f<T> extends FutureTask<b<T>> {

    /* renamed from: e */
    public static final Executor f62047e = new C13836h(5, 10, 100, "promise");

    /* renamed from: a */
    public final ConcurrentLinkedQueue<InterfaceC13829a<b<T>>> f62048a;

    /* renamed from: b */
    public final Executor f62049b;

    /* renamed from: c */
    public boolean f62050c;

    /* renamed from: d */
    public final Object f62051d;

    /* renamed from: xm.f$a */
    public static class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C13834f.this.set(new b(2, null));
            C13834f.this.cancel(false);
        }
    }

    /* renamed from: xm.f$b */
    public static class b<T> {

        /* renamed from: a */
        public final int f62053a;

        /* renamed from: b */
        public final T f62054b;

        public b(int i10, T t10) {
            this.f62053a = i10;
            this.f62054b = t10;
        }

        /* renamed from: a */
        public int m82983a() {
            return this.f62053a;
        }

        /* renamed from: b */
        public T m82984b() {
            return this.f62054b;
        }

        public String toString() {
            return "Result{code=" + this.f62053a + '}';
        }
    }

    public C13834f() {
        this(null);
    }

    /* renamed from: h */
    public static /* synthetic */ void m82973h(InterfaceC13829a interfaceC13829a, C13834f c13834f, b bVar) {
        interfaceC13829a.accept(bVar);
        c13834f.m82976e(new b<>(0, null));
    }

    /* renamed from: k */
    public static <U> C13834f<U> m82974k(Callable<U> callable, Executor executor) {
        return m82975l(callable, executor, null, -1L);
    }

    /* renamed from: l */
    public static <U> C13834f<U> m82975l(Callable<U> callable, Executor executor, Timer timer, long j10) {
        C13834f<U> c13834f = new C13834f<>(callable, executor);
        c13834f.m82977f().execute(c13834f);
        if (timer != null && j10 >= 0) {
            timer.schedule(new a(), j10);
        }
        return c13834f;
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        final ArrayList arrayList;
        synchronized (this.f62051d) {
            this.f62050c = true;
            arrayList = new ArrayList(this.f62048a);
            this.f62048a.clear();
        }
        this.f62049b.execute(new Runnable() { // from class: xm.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f62043a.m82978g(arrayList);
            }
        });
    }

    /* renamed from: e */
    public void m82976e(b<T> bVar) {
        set(bVar);
    }

    /* renamed from: f */
    public final Executor m82977f() {
        return this.f62049b;
    }

    /* renamed from: g */
    public final /* synthetic */ void m82978g(ArrayList arrayList) {
        b<T> bVarM82979i = m82979i();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC13829a) it.next()).accept(bVarM82979i);
        }
    }

    /* renamed from: i */
    public b<T> m82979i() {
        try {
            return get();
        } catch (InterruptedException e10) {
            C1462b.m8362f("Promise", "result() failed, InterruptedException: " + e10.getMessage());
            return new b<>(1, null);
        } catch (CancellationException e11) {
            C1462b.m8362f("Promise", "result() failed, CancellationException: " + e11.getMessage());
            return new b<>(3, null);
        } catch (ExecutionException e12) {
            C1462b.m8362f("Promise", "result() failed, ExecutionException: " + e12.getMessage());
            return new b<>(1, null);
        }
    }

    /* renamed from: j */
    public b<T> m82980j(long j10) {
        try {
            return get(j10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            C1462b.m8362f("Promise", "result with timeout, InterruptedException");
            return new b<>(1, null);
        } catch (CancellationException unused2) {
            C1462b.m8362f("Promise", "result with timeout, CancellationException");
            return new b<>(3, null);
        } catch (ExecutionException unused3) {
            C1462b.m8362f("Promise", "result with timeout, ExecutionException");
            return new b<>(1, null);
        } catch (TimeoutException unused4) {
            C1462b.m8362f("Promise", "result with timeout, TimeoutException");
            return new b<>(2, null);
        }
    }

    /* renamed from: m */
    public C13834f<Void> m82981m(InterfaceC13829a<b<T>> interfaceC13829a) {
        C13834f<Void> c13834f = new C13834f<>(this.f62049b);
        if (m82982n(interfaceC13829a, c13834f)) {
            return c13834f;
        }
        interfaceC13829a.accept(m82979i());
        c13834f.m82976e(new b<>(0, null));
        return c13834f;
    }

    /* renamed from: n */
    public final boolean m82982n(final InterfaceC13829a<b<T>> interfaceC13829a, final C13834f<Void> c13834f) {
        synchronized (this.f62051d) {
            try {
                if (this.f62050c) {
                    return false;
                }
                this.f62048a.add(new InterfaceC13829a() { // from class: xm.e
                    @Override // p780xm.InterfaceC13829a
                    public final void accept(Object obj) {
                        C13834f.m82973h(interfaceC13829a, c13834f, (C13834f.b) obj);
                    }
                });
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public C13834f(Callable<T> callable, Executor executor) {
        super(new CallableC13831c(callable));
        this.f62048a = new ConcurrentLinkedQueue<>();
        this.f62050c = false;
        this.f62051d = new Object();
        this.f62049b = executor == null ? f62047e : executor;
    }

    public C13834f(Executor executor) {
        this(new CallableC13830b(), executor);
    }
}
