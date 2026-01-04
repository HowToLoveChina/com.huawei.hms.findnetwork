package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6088s7;
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

/* renamed from: com.huawei.hms.network.embedded.e7 */
/* loaded from: classes8.dex */
public class C5906e7 extends AbstractC6035o6 {

    /* renamed from: h */
    public static final int f26692h = 1;

    /* renamed from: i */
    public static final /* synthetic */ boolean f26693i = true;

    /* renamed from: c */
    public Runnable f26696c;

    /* renamed from: d */
    public ExecutorService f26697d;

    /* renamed from: a */
    public int f26694a = 64;

    /* renamed from: b */
    public int f26695b = 5;

    /* renamed from: e */
    public final Deque<C6088s7.a> f26698e = new ArrayDeque();

    /* renamed from: f */
    public final Deque<C6088s7.a> f26699f = new ArrayDeque();

    /* renamed from: g */
    public final Deque<C6088s7> f26700g = new ArrayDeque();

    public C5906e7() {
    }

    /* renamed from: j */
    private boolean m34122j() {
        int i10;
        boolean z10;
        if (!f26693i && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<C6088s7.a> it = this.f26698e.iterator();
                while (it.hasNext()) {
                    C6088s7.a next = it.next();
                    if (this.f26699f.size() >= this.f26694a) {
                        break;
                    }
                    if (next.m35286c().get() < this.f26695b) {
                        it.remove();
                        next.m35286c().incrementAndGet();
                        arrayList.add(next);
                        this.f26699f.add(next);
                    }
                }
                z10 = mo33897d() > 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((C6088s7.a) arrayList.get(i10)).m35285a(m34131i());
        }
        return z10;
    }

    /* renamed from: a */
    public C6088s7.a m34123a(String str) {
        for (C6088s7.a aVar : this.f26699f) {
            if (aVar.m35290g().equals(str)) {
                return aVar;
            }
        }
        for (C6088s7.a aVar2 : this.f26698e) {
            if (aVar2.m35290g().equals(str)) {
                return aVar2;
            }
        }
        return null;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5865b8
    /* renamed from: b */
    public synchronized void mo33894b() {
        try {
            Iterator<C6088s7.a> it = this.f26698e.iterator();
            while (it.hasNext()) {
                it.next().m35289f().cancel();
            }
            Iterator<C6088s7.a> it2 = this.f26699f.iterator();
            while (it2.hasNext()) {
                it2.next().m35289f().cancel();
            }
            Iterator<C6088s7> it3 = this.f26700g.iterator();
            while (it3.hasNext()) {
                it3.next().cancel();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5865b8
    /* renamed from: c */
    public synchronized List<InterfaceC6100t6> mo33896c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            arrayList.addAll(this.f26700g);
            Iterator<C6088s7.a> it = this.f26699f.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m35289f());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5865b8
    /* renamed from: d */
    public synchronized int mo33897d() {
        return this.f26699f.size() + this.f26700g.size();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5865b8
    /* renamed from: e */
    public synchronized int mo33898e() {
        return this.f26694a;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5865b8
    /* renamed from: f */
    public synchronized int mo33899f() {
        return this.f26695b;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5865b8
    /* renamed from: g */
    public synchronized int mo33900g() {
        return this.f26698e.size();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: h */
    public int mo34130h() {
        return 1;
    }

    /* renamed from: i */
    public synchronized ExecutorService m34131i() {
        try {
            if (this.f26697d == null) {
                this.f26697d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), C5920f8.m34245a("OkHttp Dispatcher", false));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f26697d;
    }

    public C5906e7(ExecutorService executorService) {
        this.f26697d = executorService;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5865b8
    /* renamed from: a */
    public synchronized List<InterfaceC6100t6> mo33891a() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator<C6088s7.a> it = this.f26698e.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m35289f());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5865b8
    /* renamed from: b */
    public void mo33895b(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.f26694a = i10;
            }
            m34122j();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5865b8
    /* renamed from: a */
    public void mo33892a(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.f26695b = i10;
            }
            m34122j();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: b */
    public void mo34127b(C6088s7.a aVar) {
        aVar.m35286c().decrementAndGet();
        m34121a(this.f26699f, aVar);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: a */
    public void mo34124a(C6088s7.a aVar) {
        C6088s7.a aVarM34123a;
        synchronized (this) {
            try {
                this.f26698e.add(aVar);
                if (!aVar.m35289f().f28208d && (aVarM34123a = m34123a(aVar.m35290g())) != null) {
                    aVar.m35284a(aVarM34123a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m34122j();
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: b */
    public void mo34128b(C6088s7 c6088s7) {
        m34121a(this.f26700g, c6088s7);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: a */
    public synchronized void mo34125a(C6088s7 c6088s7) {
        this.f26700g.add(c6088s7);
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: b */
    public void mo34129b(String str, int i10, String str2) {
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5865b8
    /* renamed from: a */
    public synchronized void mo33893a(Runnable runnable) {
        this.f26696c = runnable;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6035o6
    /* renamed from: a */
    public void mo34126a(String str, int i10, String str2) {
    }

    /* renamed from: a */
    private <T> void m34121a(Deque<T> deque, T t10) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t10)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f26696c;
        }
        if (m34122j() || runnable == null) {
            return;
        }
        runnable.run();
    }
}
