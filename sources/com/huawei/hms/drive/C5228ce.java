package com.huawei.hms.drive;

import com.huawei.hms.drive.C5182ao;
import com.huawei.hms.drive.C5232ci;
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

/* renamed from: com.huawei.hms.drive.ce */
/* loaded from: classes8.dex */
public final class C5228ce {

    /* renamed from: c */
    static final /* synthetic */ boolean f24157c = true;

    /* renamed from: d */
    private static final Executor f24158d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C5210bo.m31188a("OkHttp ConnectionPool", true));

    /* renamed from: b */
    boolean f24160b;

    /* renamed from: e */
    private final int f24161e;

    /* renamed from: f */
    private final long f24162f;

    /* renamed from: g */
    private final Runnable f24163g = new Runnable() { // from class: com.huawei.hms.drive.g0
        @Override // java.lang.Runnable
        public final void run() throws IOException {
            this.f24508a.m31333a();
        }
    };

    /* renamed from: h */
    private final Deque<C5227cd> f24164h = new ArrayDeque();

    /* renamed from: a */
    final C5229cf f24159a = new C5229cf();

    /* renamed from: i */
    private final Deque<C5192ay> f24165i = new ArrayDeque();

    /* renamed from: j */
    private final Deque<WeakReference<C5182ao.a>> f24166j = new ArrayDeque();

    public C5228ce(int i10, long j10, TimeUnit timeUnit) {
        this.f24161e = i10;
        this.f24162f = timeUnit.toNanos(j10);
        if (j10 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j10);
    }

    /* renamed from: b */
    private C5192ay m31335b(C5173af c5173af) {
        for (C5192ay c5192ay : this.f24165i) {
            if (c5173af.equals(c5192ay.m30945a())) {
                return c5192ay;
            }
        }
        return null;
    }

    /* renamed from: c */
    private C5227cd m31336c(C5173af c5173af) {
        C5192ay c5192ayM31335b = m31335b(c5173af);
        if (c5192ayM31335b != null) {
            return c5192ayM31335b.m30949c();
        }
        return null;
    }

    /* renamed from: d */
    private void m31338d(C5227cd c5227cd) {
        C5192ay c5192ayM31335b;
        if (c5227cd == null || !c5227cd.m31331g() || (c5192ayM31335b = m31335b(c5227cd.m31327c().m31162a())) == null) {
            return;
        }
        c5192ayM31335b.m30947b(c5227cd);
        if (c5192ayM31335b.m30948b()) {
            this.f24165i.remove(c5192ayM31335b);
            m31337d(c5227cd.m31327c().m31162a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31333a() throws IOException {
        while (true) {
            long jM31341a = m31341a(System.nanoTime());
            if (jM31341a == -1) {
                return;
            }
            if (jM31341a > 0) {
                long j10 = jM31341a / 1000000;
                long j11 = jM31341a - (1000000 * j10);
                synchronized (this) {
                    try {
                        wait(j10, (int) j11);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void m31346b(C5227cd c5227cd) {
        if (!f24157c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f24160b) {
            this.f24160b = true;
            f24158d.execute(this.f24163g);
        }
        this.f24164h.add(c5227cd);
        if (c5227cd.m31331g()) {
            m31344a(c5227cd);
        }
    }

    /* renamed from: c */
    public boolean m31347c(C5227cd c5227cd) {
        if (!f24157c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!c5227cd.f24135b && this.f24161e != 0) {
            notifyAll();
            return false;
        }
        this.f24164h.remove(c5227cd);
        m31338d(c5227cd);
        return true;
    }

    /* renamed from: d */
    private void m31337d(C5173af c5173af) {
        C5193az c5193azM30808b = c5173af.m30808b();
        Iterator<WeakReference<C5182ao.a>> it = this.f24166j.iterator();
        while (it.hasNext()) {
            C5182ao.a aVar = it.next().get();
            if (aVar != null) {
                aVar.mo30854a(c5193azM30808b.m30970f(), c5193azM30808b.m30971g(), c5193azM30808b.m30964b());
            } else {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public synchronized int m31340a(String str, int i10, String str2) {
        int i11;
        i11 = 0;
        for (C5227cd c5227cd : this.f24164h) {
            if (c5227cd.m31331g() && str.equals(c5227cd.m31327c().m31162a().m30808b().m30970f()) && i10 == c5227cd.m31327c().m31162a().m30808b().m30971g() && str2.equals(c5227cd.m31327c().m31162a().m30808b().m30964b()) && !c5227cd.f24135b && (c5227cd.f24137d == 0 || c5227cd.m31325a(true))) {
                i11++;
            }
        }
        return i11;
    }

    /* renamed from: a */
    public synchronized int m31339a(C5173af c5173af) {
        int i10;
        i10 = 0;
        for (C5227cd c5227cd : this.f24164h) {
            if (c5173af.equals(c5227cd.m31327c().m31162a()) && !c5227cd.f24135b && c5227cd.m31331g() && (c5227cd.f24137d == 0 || c5227cd.m31325a(true))) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: a */
    public synchronized void m31344a(C5227cd c5227cd) {
        try {
            C5192ay c5192ayM31335b = m31335b(c5227cd.m31327c().m31162a());
            if (c5192ayM31335b == null) {
                c5192ayM31335b = new C5192ay(c5227cd.m31327c().m31162a());
                this.f24165i.push(c5192ayM31335b);
            }
            c5192ayM31335b.m30946a(c5227cd);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: a */
    public synchronized void m31342a(C5182ao.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f24166j.add(new WeakReference<>(aVar));
    }

    /* renamed from: a */
    public boolean m31345a(C5173af c5173af, C5232ci c5232ci, List<C5205bj> list, boolean z10) {
        if (!f24157c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        C5227cd c5227cdM31336c = m31336c(c5173af);
        if (c5227cdM31336c != null) {
            c5232ci.m31383a(c5227cdM31336c);
            return true;
        }
        for (C5227cd c5227cd : this.f24164h) {
            if (!z10 || c5227cd.m31331g()) {
                if (c5227cd.m31323a(c5173af, list)) {
                    c5232ci.m31383a(c5227cd);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public long m31341a(long j10) throws IOException {
        synchronized (this) {
            try {
                C5227cd c5227cd = null;
                long j11 = Long.MIN_VALUE;
                int i10 = 0;
                int i11 = 0;
                for (C5227cd c5227cd2 : this.f24164h) {
                    if (m31332a(c5227cd2, j10) <= 0 && (!c5227cd2.m31331g() || j10 - c5227cd2.f24144k >= 1000000000)) {
                        i10++;
                        long j12 = j10 - c5227cd2.f24140g;
                        if (j12 > j11) {
                            c5227cd = c5227cd2;
                            j11 = j12;
                        }
                    }
                    i11++;
                }
                long j13 = this.f24162f;
                if (j11 < j13 && i10 <= this.f24161e) {
                    if (i10 > 0) {
                        return j13 - j11;
                    }
                    if (i11 > 0) {
                        return j13;
                    }
                    this.f24160b = false;
                    return -1L;
                }
                this.f24164h.remove(c5227cd);
                m31338d(c5227cd);
                C5210bo.m31193a(c5227cd.m31329e());
                return 0L;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private int m31332a(C5227cd c5227cd, long j10) {
        List<Reference<C5232ci>> list = c5227cd.f24139f;
        int i10 = 0;
        while (i10 < list.size()) {
            Reference<C5232ci> reference = list.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                C5269dr.m31692e().mo31657a("A connection to " + c5227cd.m31327c().m31162a().m30808b() + " was leaked. Did you forget to close a response body?", ((C5232ci.a) reference).f24206a);
                list.remove(i10);
                c5227cd.f24135b = true;
                if (list.isEmpty()) {
                    c5227cd.f24140g = j10 - this.f24162f;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* renamed from: a */
    public void m31343a(C5205bj c5205bj, IOException iOException) {
        if (c5205bj.m31163b().type() != Proxy.Type.DIRECT) {
            C5173af c5173afM31162a = c5205bj.m31162a();
            c5173afM31162a.m30814h().connectFailed(c5173afM31162a.m30808b().m30963a(), c5205bj.m31163b().address(), iOException);
        }
        this.f24159a.m31348a(c5205bj);
    }
}
