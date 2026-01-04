package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.C11916d0;
import sx.C12875e;

/* renamed from: okhttp3.p */
/* loaded from: classes9.dex */
public class C11949p extends AbstractC11909a {

    /* renamed from: c */
    public Runnable f55638c;

    /* renamed from: d */
    public ExecutorService f55639d;

    /* renamed from: a */
    public int f55636a = 64;

    /* renamed from: b */
    public int f55637b = 5;

    /* renamed from: e */
    public final Deque<C11916d0.a> f55640e = new ArrayDeque();

    /* renamed from: f */
    public final Deque<C11916d0.a> f55641f = new ArrayDeque();

    /* renamed from: g */
    public final Deque<C11916d0> f55642g = new ArrayDeque();

    /* renamed from: f */
    private <T> void m71824f(Deque<T> deque, T t10) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t10)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f55638c;
        }
        if (m71825i() || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* renamed from: i */
    private boolean m71825i() {
        int i10;
        boolean z10;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<C11916d0.a> it = this.f55640e.iterator();
                while (it.hasNext()) {
                    C11916d0.a next = it.next();
                    if (this.f55641f.size() >= this.f55636a) {
                        break;
                    }
                    if (next.m71537m().get() < this.f55637b) {
                        it.remove();
                        next.m71537m().incrementAndGet();
                        arrayList.add(next);
                        this.f55641f.add(next);
                    }
                }
                z10 = m71837n() > 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((C11916d0.a) arrayList.get(i10)).m71539o(m71829d());
        }
        return z10;
    }

    /* renamed from: a */
    public void mo71826a(String str, int i10, String str2) {
    }

    /* renamed from: b */
    public void mo71827b(C11916d0.a aVar) {
        C11916d0.a aVarM71830e;
        synchronized (this) {
            try {
                this.f55640e.add(aVar);
                if (!aVar.m71541q().f55240d && (aVarM71830e = m71830e(aVar.m71542r())) != null) {
                    aVar.m71544t(aVarM71830e);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m71825i();
    }

    /* renamed from: c */
    public synchronized void m71828c(C11916d0 c11916d0) {
        this.f55642g.add(c11916d0);
    }

    /* renamed from: d */
    public synchronized ExecutorService m71829d() {
        try {
            if (this.f55639d == null) {
                this.f55639d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), C12875e.m77239J("OkHttp Dispatcher", false));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f55639d;
    }

    /* renamed from: e */
    public C11916d0.a m71830e(String str) {
        for (C11916d0.a aVar : this.f55641f) {
            if (aVar.m71542r().equals(str)) {
                return aVar;
            }
        }
        for (C11916d0.a aVar2 : this.f55640e) {
            if (aVar2.m71542r().equals(str)) {
                return aVar2;
            }
        }
        return null;
    }

    /* renamed from: g */
    public void mo71831g(C11916d0.a aVar) {
        aVar.m71537m().decrementAndGet();
        m71824f(this.f55641f, aVar);
    }

    /* renamed from: h */
    public void mo71832h(C11916d0 c11916d0) {
        m71824f(this.f55642g, c11916d0);
    }

    /* renamed from: j */
    public synchronized List<InterfaceC11919f> m71833j() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator<C11916d0.a> it = this.f55640e.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m71541q());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: k */
    public synchronized int m71834k() {
        return this.f55640e.size();
    }

    /* renamed from: l */
    public void mo71835l(String str, int i10, String str2) {
    }

    /* renamed from: m */
    public synchronized List<InterfaceC11919f> m71836m() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            arrayList.addAll(this.f55642g);
            Iterator<C11916d0.a> it = this.f55641f.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m71541q());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: n */
    public synchronized int m71837n() {
        return this.f55641f.size() + this.f55642g.size();
    }

    /* renamed from: o */
    public void m71838o(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.f55636a = i10;
            }
            m71825i();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }
}
