package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5894d9;
import com.huawei.hms.network.embedded.C6178z6;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.z8 */
/* loaded from: classes8.dex */
public final class C6180z8 {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Executor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C5920f8.m34245a("OkHttp ConnectionPool", true));
    public boolean cleanupRunning;
    public final long keepAliveDurationNs;
    public final int maxIdleConnections;
    public final Runnable cleanupRunnable = new Runnable() { // from class: gq.i
        @Override // java.lang.Runnable
        public final void run() throws IOException {
            this.f49000a.m35920d();
        }
    };
    public final Deque<C6167y8> connections = new ArrayDeque();
    public final C5852a9 routeDatabase = new C5852a9();
    public final Deque<C5997l7> http2Hosts = new ArrayDeque();
    public final Deque<WeakReference<C6178z6.a>> listenerWrList = new ArrayDeque();

    public C6180z8(int i10, long j10, TimeUnit timeUnit) {
        this.maxIdleConnections = i10;
        this.keepAliveDurationNs = timeUnit.toNanos(j10);
        if (j10 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j10);
    }

    /* renamed from: b */
    private C6167y8 m35918b(C6048p6 c6048p6) {
        C5997l7 c5997l7M35919c = m35919c(c6048p6);
        if (c5997l7M35919c != null) {
            return c5997l7M35919c.m34666b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m35920d() throws IOException {
        while (true) {
            long jM35926a = m35926a(System.nanoTime());
            if (jM35926a == -1) {
                return;
            }
            if (jM35926a > 0) {
                long j10 = jM35926a / 1000000;
                long j11 = jM35926a - (1000000 * j10);
                synchronized (this) {
                    try {
                        wait(j10, (int) j11);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public synchronized int m35935c() {
        int i10;
        Iterator<C6167y8> it = this.connections.iterator();
        i10 = 0;
        while (it.hasNext()) {
            if (it.next().f29166p.isEmpty()) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: c */
    private C5997l7 m35919c(C6048p6 c6048p6) {
        for (C5997l7 c5997l7 : this.http2Hosts) {
            if (c6048p6.equals(c5997l7.m34664a())) {
                return c5997l7;
            }
        }
        return null;
    }

    /* renamed from: d */
    private void m35921d(C6048p6 c6048p6) {
        C6010m7 c6010m7M34990l = c6048p6.m34990l();
        Iterator<WeakReference<C6178z6.a>> it = this.listenerWrList.iterator();
        while (it.hasNext()) {
            C6178z6.a aVar = it.next().get();
            if (aVar != null) {
                aVar.mo35142a(c6010m7M34990l.m34797h(), c6010m7M34990l.m34803n(), c6010m7M34990l.m34808s());
            } else {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public synchronized int m35923a() {
        return this.connections.size();
    }

    /* renamed from: b */
    public void m35931b() {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<C6167y8> it = this.connections.iterator();
                while (it.hasNext()) {
                    C6167y8 next = it.next();
                    if (next.f29166p.isEmpty()) {
                        next.f29161k = true;
                        arrayList.add(next);
                        it.remove();
                        m35922d(next);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C5920f8.m34251a(((C6167y8) it2.next()).mo35838c());
        }
    }

    /* renamed from: d */
    private void m35922d(C6167y8 c6167y8) {
        C5997l7 c5997l7M35919c;
        if (c6167y8 == null || !c6167y8.m35863g() || (c5997l7M35919c = m35919c(c6167y8.mo35837b().m35787a())) == null) {
            return;
        }
        c5997l7M35919c.m34667b(c6167y8);
        if (c5997l7M35919c.m34668c()) {
            this.http2Hosts.remove(c5997l7M35919c);
            m35921d(c6167y8.mo35837b().m35787a());
        }
    }

    /* renamed from: a */
    public synchronized int m35924a(C6048p6 c6048p6) {
        int i10;
        i10 = 0;
        for (C6167y8 c6167y8 : this.connections) {
            if (c6048p6.equals(c6167y8.mo35837b().m35787a()) && !c6167y8.f29161k && c6167y8.m35863g() && (c6167y8.f29163m == 0 || c6167y8.m35860a(true))) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: b */
    public synchronized void m35932b(C6178z6.a aVar) {
        Iterator<WeakReference<C6178z6.a>> it = this.listenerWrList.iterator();
        while (it.hasNext()) {
            C6178z6.a aVar2 = it.next().get();
            if (aVar2 == null || aVar == aVar2) {
                it.remove();
            }
        }
    }

    /* renamed from: c */
    public void m35936c(C6167y8 c6167y8) {
        if (!this.cleanupRunning) {
            this.cleanupRunning = true;
            executor.execute(this.cleanupRunnable);
        }
        this.connections.add(c6167y8);
        if (c6167y8.m35863g()) {
            m35928a(c6167y8);
        }
    }

    /* renamed from: a */
    private int m35916a(C6167y8 c6167y8, long j10) {
        List<Reference<C5894d9>> list = c6167y8.f29166p;
        int i10 = 0;
        while (i10 < list.size()) {
            Reference<C5894d9> reference = list.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                C6013ma.m34863f().mo34332a("A connection to " + c6167y8.mo35837b().m35787a().m34990l() + " was leaked. Did you forget to close a response body?", ((C5894d9.b) reference).f26667a);
                list.remove(i10);
                c6167y8.f29161k = true;
                if (list.isEmpty()) {
                    c6167y8.f29167q = j10 - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* renamed from: b */
    public boolean m35933b(C6167y8 c6167y8) {
        if (!c6167y8.f29161k && this.maxIdleConnections != 0) {
            notifyAll();
            return false;
        }
        this.connections.remove(c6167y8);
        m35922d(c6167y8);
        return true;
    }

    /* renamed from: a */
    public synchronized int m35925a(String str, int i10, String str2) {
        int i11;
        i11 = 0;
        for (C6167y8 c6167y8 : this.connections) {
            if (c6167y8.m35863g() && str.equals(c6167y8.mo35837b().m35787a().m34990l().m34797h()) && i10 == c6167y8.mo35837b().m35787a().m34990l().m34803n() && str2.equals(c6167y8.mo35837b().m35787a().m34990l().m34808s()) && !c6167y8.f29161k && (c6167y8.f29163m == 0 || c6167y8.m35860a(true))) {
                i11++;
            }
        }
        return i11;
    }

    /* renamed from: b */
    public synchronized boolean m35934b(String str, int i10, String str2) {
        for (C6167y8 c6167y8 : this.connections) {
            if (c6167y8.m35863g() && str.equals(c6167y8.mo35837b().m35787a().m34990l().m34797h()) && i10 == c6167y8.mo35837b().m35787a().m34990l().m34803n() && str2.equals(c6167y8.mo35837b().m35787a().m34990l().m34808s()) && !c6167y8.f29161k && c6167y8.m35860a(true)) {
                c6167y8.f29174x = System.nanoTime();
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public long m35926a(long j10) throws IOException {
        synchronized (this) {
            try {
                C6167y8 c6167y8 = null;
                long j11 = Long.MIN_VALUE;
                int i10 = 0;
                int i11 = 0;
                for (C6167y8 c6167y82 : this.connections) {
                    if (m35916a(c6167y82, j10) <= 0 && (!c6167y82.m35863g() || j10 - c6167y82.f29174x >= 1000000000)) {
                        i10++;
                        long j12 = j10 - c6167y82.f29167q;
                        if (j12 > j11) {
                            c6167y8 = c6167y82;
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
                this.connections.remove(c6167y8);
                m35922d(c6167y8);
                C5920f8.m34251a(c6167y8.mo35838c());
                return 0L;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m35927a(C6153x7 c6153x7, IOException iOException) {
        if (c6153x7.m35788b().type() != Proxy.Type.DIRECT) {
            C6048p6 c6048p6M35787a = c6153x7.m35787a();
            c6048p6M35787a.m34987i().connectFailed(c6048p6M35787a.m34990l().m34810u(), c6153x7.m35788b().address(), iOException);
        }
        this.routeDatabase.m33828b(c6153x7);
    }

    /* renamed from: a */
    public synchronized void m35928a(C6167y8 c6167y8) {
        try {
            C5997l7 c5997l7M35919c = m35919c(c6167y8.mo35837b().m35787a());
            if (c5997l7M35919c == null) {
                c5997l7M35919c = new C5997l7(c6167y8.mo35837b().m35787a());
                this.http2Hosts.push(c5997l7M35919c);
            }
            c5997l7M35919c.m34665a(c6167y8);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m35929a(C6178z6.a aVar) {
        if (aVar == null) {
            return;
        }
        this.listenerWrList.add(new WeakReference<>(aVar));
    }

    /* renamed from: a */
    public boolean m35930a(C6048p6 c6048p6, C5894d9 c5894d9, List<C6153x7> list, boolean z10) {
        C6167y8 c6167y8M35918b = m35918b(c6048p6);
        if (c6167y8M35918b != null) {
            c5894d9.acquireConnectionNoEvents(c6167y8M35918b);
            return true;
        }
        for (C6167y8 c6167y8 : this.connections) {
            if (!z10 || c6167y8.m35863g()) {
                if (c6167y8.m35859a(c6048p6, list)) {
                    c5894d9.acquireConnectionNoEvents(c6167y8);
                    return true;
                }
            }
        }
        return false;
    }
}
