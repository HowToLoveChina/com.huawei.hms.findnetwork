package p829z1;

import android.os.Process;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import p630s2.C12676k;
import p759x1.InterfaceC13681f;
import p829z1.C14077p;

/* renamed from: z1.a */
/* loaded from: classes.dex */
public final class C14062a {

    /* renamed from: a */
    public final boolean f62851a;

    /* renamed from: b */
    public final Executor f62852b;

    /* renamed from: c */
    public final Map<InterfaceC13681f, c> f62853c;

    /* renamed from: d */
    public final ReferenceQueue<C14077p<?>> f62854d;

    /* renamed from: e */
    public C14077p.a f62855e;

    /* renamed from: f */
    public volatile boolean f62856f;

    /* renamed from: z1.a$a */
    public class a implements ThreadFactory {

        /* renamed from: z1.a$a$a, reason: collision with other inner class name */
        public class RunnableC14515a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Runnable f62857a;

            public RunnableC14515a(Runnable runnable) {
                this.f62857a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(10);
                this.f62857a.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC14515a(runnable), "glide-active-resources");
        }
    }

    /* renamed from: z1.a$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C14062a.this.m84273b();
        }
    }

    /* renamed from: z1.a$c */
    public static final class c extends WeakReference<C14077p<?>> {

        /* renamed from: a */
        public final InterfaceC13681f f62860a;

        /* renamed from: b */
        public final boolean f62861b;

        /* renamed from: c */
        public InterfaceC14083v<?> f62862c;

        public c(InterfaceC13681f interfaceC13681f, C14077p<?> c14077p, ReferenceQueue<? super C14077p<?>> referenceQueue, boolean z10) {
            super(c14077p, referenceQueue);
            this.f62860a = (InterfaceC13681f) C12676k.m76276d(interfaceC13681f);
            this.f62862c = (c14077p.m84396e() && z10) ? (InterfaceC14083v) C12676k.m76276d(c14077p.m84395d()) : null;
            this.f62861b = c14077p.m84396e();
        }

        /* renamed from: a */
        public void m84278a() {
            this.f62862c = null;
            clear();
        }
    }

    public C14062a(boolean z10) {
        this(z10, Executors.newSingleThreadExecutor(new a()));
    }

    /* renamed from: a */
    public synchronized void m84272a(InterfaceC13681f interfaceC13681f, C14077p<?> c14077p) {
        c cVarPut = this.f62853c.put(interfaceC13681f, new c(interfaceC13681f, c14077p, this.f62854d, this.f62851a));
        if (cVarPut != null) {
            cVarPut.m84278a();
        }
    }

    /* renamed from: b */
    public void m84273b() {
        while (!this.f62856f) {
            try {
                m84274c((c) this.f62854d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* renamed from: c */
    public void m84274c(c cVar) {
        InterfaceC14083v<?> interfaceC14083v;
        synchronized (this) {
            this.f62853c.remove(cVar.f62860a);
            if (cVar.f62861b && (interfaceC14083v = cVar.f62862c) != null) {
                this.f62855e.mo84358c(cVar.f62860a, new C14077p<>(interfaceC14083v, true, false, cVar.f62860a, this.f62855e));
            }
        }
    }

    /* renamed from: d */
    public synchronized void m84275d(InterfaceC13681f interfaceC13681f) {
        c cVarRemove = this.f62853c.remove(interfaceC13681f);
        if (cVarRemove != null) {
            cVarRemove.m84278a();
        }
    }

    /* renamed from: e */
    public synchronized C14077p<?> m84276e(InterfaceC13681f interfaceC13681f) {
        c cVar = this.f62853c.get(interfaceC13681f);
        if (cVar == null) {
            return null;
        }
        C14077p<?> c14077p = cVar.get();
        if (c14077p == null) {
            m84274c(cVar);
        }
        return c14077p;
    }

    /* renamed from: f */
    public void m84277f(C14077p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f62855e = aVar;
            }
        }
    }

    public C14062a(boolean z10, Executor executor) {
        this.f62853c = new HashMap();
        this.f62854d = new ReferenceQueue<>();
        this.f62851a = z10;
        this.f62852b = executor;
        executor.execute(new b());
    }
}
