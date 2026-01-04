package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.C11911b;
import okhttp3.C11926i0;
import okhttp3.C11945l;
import okhttp3.C11957x;
import okhttp3.C11958y;
import okhttp3.internal.connection.C11941o;
import p791xx.C13893h;
import sx.C12875e;

/* renamed from: okhttp3.internal.connection.k */
/* loaded from: classes9.dex */
public final class C11937k {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C12875e.m77239J("OkHttp ConnectionPool", true));
    boolean cleanupRunning;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    private final Runnable cleanupRunnable = new Runnable() { // from class: okhttp3.internal.connection.j
        @Override // java.lang.Runnable
        public final void run() throws IOException {
            this.f55431a.m71746l();
        }
    };
    private final Deque<C11935i> connections = new ArrayDeque();
    final C11938l routeDatabase = new C11938l();
    private final Deque<C11957x> http2Hosts = new ArrayDeque();
    private final Deque<WeakReference<C11945l.a>> listenerWrList = new ArrayDeque();

    public C11937k(int i10, long j10, TimeUnit timeUnit) {
        this.maxIdleConnections = i10;
        this.keepAliveDurationNs = timeUnit.toNanos(j10);
        if (j10 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j10);
    }

    /* renamed from: b */
    public synchronized void m71736b(C11935i c11935i) {
        try {
            C11957x c11957xM71742h = m71742h(c11935i.mo71709a().m71638a());
            if (c11957xM71742h == null) {
                c11957xM71742h = new C11957x(c11935i.mo71709a().m71638a());
                this.http2Hosts.push(c11957xM71742h);
            }
            c11957xM71742h.m71877a(c11935i);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: c */
    public synchronized void m71737c(C11945l.a aVar) {
        if (aVar == null) {
            return;
        }
        this.listenerWrList.add(new WeakReference<>(aVar));
    }

    /* renamed from: d */
    public long m71738d(long j10) throws IOException {
        synchronized (this) {
            try {
                C11935i c11935i = null;
                long j11 = Long.MIN_VALUE;
                int i10 = 0;
                int i11 = 0;
                for (C11935i c11935i2 : this.connections) {
                    if (m71748n(c11935i2, j10) <= 0 && (!c11935i2.m71724p() || j10 - c11935i2.f55430x >= 1000000000)) {
                        i10++;
                        long j12 = j10 - c11935i2.f55423q;
                        if (j12 > j11) {
                            c11935i = c11935i2;
                            j11 = j12;
                        }
                    }
                    i11++;
                }
                long j13 = this.keepAliveDurationNs;
                if (j11 < j13 && i10 <= this.maxIdleConnections) {
                    if (i10 > 0) {
                        return j13 - j11;
                    }
                    if (i11 > 0) {
                        return j13;
                    }
                    this.cleanupRunning = false;
                    return -1L;
                }
                this.connections.remove(c11935i);
                m71750p(c11935i);
                C12875e.m77251h(c11935i.m71731w());
                return 0L;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: e */
    public void m71739e(C11926i0 c11926i0, IOException iOException) {
        if (c11926i0.m71639b().type() != Proxy.Type.DIRECT) {
            C11911b c11911bM71638a = c11926i0.m71638a();
            c11911bM71638a.m71457j().connectFailed(c11911bM71638a.m71461n().m71897C(), c11926i0.m71639b().address(), iOException);
        }
        this.routeDatabase.m71753b(c11926i0);
    }

    /* renamed from: f */
    public boolean m71740f(C11935i c11935i) {
        if (!c11935i.f55417k && this.maxIdleConnections != 0) {
            notifyAll();
            return false;
        }
        this.connections.remove(c11935i);
        m71750p(c11935i);
        return true;
    }

    /* renamed from: g */
    public final C11935i m71741g(C11911b c11911b) {
        C11957x c11957xM71742h = m71742h(c11911b);
        if (c11957xM71742h != null) {
            return c11957xM71742h.m71879c();
        }
        return null;
    }

    /* renamed from: h */
    public final C11957x m71742h(C11911b c11911b) {
        for (C11957x c11957x : this.http2Hosts) {
            if (c11911b.equals(c11957x.m71878b())) {
                return c11957x;
            }
        }
        return null;
    }

    /* renamed from: i */
    public synchronized int m71743i(String str, int i10, String str2) {
        int i11;
        i11 = 0;
        for (C11935i c11935i : this.connections) {
            if (c11935i.m71724p() && str.equals(c11935i.mo71709a().m71638a().m71461n().m71904l()) && i10 == c11935i.mo71709a().m71638a().m71461n().m71909w() && str2.equals(c11935i.mo71709a().m71638a().m71461n().m71896B()) && !c11935i.f55417k && (c11935i.f55419m == 0 || c11935i.m71723o(true))) {
                i11++;
            }
        }
        return i11;
    }

    /* renamed from: j */
    public synchronized int m71744j(C11911b c11911b) {
        int i10;
        i10 = 0;
        for (C11935i c11935i : this.connections) {
            if (c11911b.equals(c11935i.mo71709a().m71638a()) && !c11935i.f55417k && c11935i.m71724p() && (c11935i.f55419m == 0 || c11935i.m71723o(true))) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: k */
    public synchronized boolean m71745k(String str, int i10, String str2) {
        for (C11935i c11935i : this.connections) {
            if (c11935i.m71724p() && str.equals(c11935i.mo71709a().m71638a().m71461n().m71904l()) && i10 == c11935i.mo71709a().m71638a().m71461n().m71909w() && str2.equals(c11935i.mo71709a().m71638a().m71461n().m71896B()) && !c11935i.f55417k && c11935i.m71723o(true)) {
                c11935i.f55430x = System.nanoTime();
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    public final /* synthetic */ void m71746l() throws IOException {
        while (true) {
            long jM71738d = m71738d(System.nanoTime());
            if (jM71738d == -1) {
                return;
            }
            if (jM71738d > 0) {
                long j10 = jM71738d / 1000000;
                long j11 = jM71738d - (1000000 * j10);
                synchronized (this) {
                    try {
                        wait(j10, (int) j11);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* renamed from: m */
    public final void m71747m(C11911b c11911b) {
        C11958y c11958yM71461n = c11911b.m71461n();
        Iterator<WeakReference<C11945l.a>> it = this.listenerWrList.iterator();
        while (it.hasNext()) {
            C11945l.a aVar = it.next().get();
            if (aVar != null) {
                aVar.mo71523a(c11958yM71461n.m71904l(), c11958yM71461n.m71909w(), c11958yM71461n.m71896B());
            } else {
                it.remove();
            }
        }
    }

    /* renamed from: n */
    public final int m71748n(C11935i c11935i, long j10) {
        List<Reference<C11941o>> list = c11935i.f55422p;
        int i10 = 0;
        while (i10 < list.size()) {
            Reference<C11941o> reference = list.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                C13893h.m83291l().mo83258t("A connection to " + c11935i.mo71709a().m71638a().m71461n() + " was leaked. Did you forget to close a response body?", ((C11941o.b) reference).f55470a);
                list.remove(i10);
                c11935i.f55417k = true;
                if (list.isEmpty()) {
                    c11935i.f55423q = j10 - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* renamed from: o */
    public void m71749o(C11935i c11935i) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(c11935i);
        if (c11935i.m71724p()) {
            m71736b(c11935i);
        }
    }

    /* renamed from: p */
    public final void m71750p(C11935i c11935i) {
        C11957x c11957xM71742h;
        if (c11935i == null || !c11935i.m71724p() || (c11957xM71742h = m71742h(c11935i.mo71709a().m71638a())) == null) {
            return;
        }
        c11957xM71742h.m71882f(c11935i);
        if (c11957xM71742h.m71881e()) {
            this.http2Hosts.remove(c11957xM71742h);
            m71747m(c11935i.mo71709a().m71638a());
        }
    }

    /* renamed from: q */
    public boolean m71751q(C11911b c11911b, C11941o c11941o, List<C11926i0> list, boolean z10) {
        C11935i c11935iM71741g = m71741g(c11911b);
        if (c11935iM71741g != null) {
            c11941o.acquireConnectionNoEvents(c11935iM71741g);
            return true;
        }
        for (C11935i c11935i : this.connections) {
            if (!z10 || c11935i.m71724p()) {
                if (c11935i.m71722n(c11911b, list)) {
                    c11941o.acquireConnectionNoEvents(c11935i);
                    return true;
                }
            }
        }
        return false;
    }
}
