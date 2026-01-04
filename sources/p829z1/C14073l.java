package p829z1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import p044c2.ExecutorServiceC1380a;
import p243e0.InterfaceC9370e;
import p507o2.InterfaceC11793f;
import p630s2.C12670e;
import p630s2.C12676k;
import p645t2.AbstractC12922c;
import p645t2.C12920a;
import p759x1.EnumC13676a;
import p759x1.InterfaceC13681f;
import p829z1.C14077p;
import p829z1.RunnableC14069h;

/* renamed from: z1.l */
/* loaded from: classes.dex */
public class C14073l<R> implements RunnableC14069h.b<R>, C12920a.f {

    /* renamed from: z */
    public static final c f62985z = new c();

    /* renamed from: a */
    public final e f62986a;

    /* renamed from: b */
    public final AbstractC12922c f62987b;

    /* renamed from: c */
    public final C14077p.a f62988c;

    /* renamed from: d */
    public final InterfaceC9370e<C14073l<?>> f62989d;

    /* renamed from: e */
    public final c f62990e;

    /* renamed from: f */
    public final InterfaceC14074m f62991f;

    /* renamed from: g */
    public final ExecutorServiceC1380a f62992g;

    /* renamed from: h */
    public final ExecutorServiceC1380a f62993h;

    /* renamed from: i */
    public final ExecutorServiceC1380a f62994i;

    /* renamed from: j */
    public final ExecutorServiceC1380a f62995j;

    /* renamed from: k */
    public final AtomicInteger f62996k;

    /* renamed from: l */
    public InterfaceC13681f f62997l;

    /* renamed from: m */
    public boolean f62998m;

    /* renamed from: n */
    public boolean f62999n;

    /* renamed from: o */
    public boolean f63000o;

    /* renamed from: p */
    public boolean f63001p;

    /* renamed from: q */
    public InterfaceC14083v<?> f63002q;

    /* renamed from: r */
    public EnumC13676a f63003r;

    /* renamed from: s */
    public boolean f63004s;

    /* renamed from: t */
    public C14078q f63005t;

    /* renamed from: u */
    public boolean f63006u;

    /* renamed from: v */
    public C14077p<?> f63007v;

    /* renamed from: w */
    public RunnableC14069h<R> f63008w;

    /* renamed from: x */
    public volatile boolean f63009x;

    /* renamed from: y */
    public boolean f63010y;

    /* renamed from: z1.l$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final InterfaceC11793f f63011a;

        public a(InterfaceC11793f interfaceC11793f) {
            this.f63011a = interfaceC11793f;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f63011a.mo70284e()) {
                synchronized (C14073l.this) {
                    try {
                        if (C14073l.this.f62986a.m84390b(this.f63011a)) {
                            C14073l.this.m84374e(this.f63011a);
                        }
                        C14073l.this.m84377h();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    /* renamed from: z1.l$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final InterfaceC11793f f63013a;

        public b(InterfaceC11793f interfaceC11793f) {
            this.f63013a = interfaceC11793f;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f63013a.mo70284e()) {
                synchronized (C14073l.this) {
                    try {
                        if (C14073l.this.f62986a.m84390b(this.f63013a)) {
                            C14073l.this.f63007v.m84394b();
                            C14073l.this.m84375f(this.f63013a);
                            C14073l.this.m84385r(this.f63013a);
                        }
                        C14073l.this.m84377h();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    /* renamed from: z1.l$c */
    public static class c {
        /* renamed from: a */
        public <R> C14077p<R> m84387a(InterfaceC14083v<R> interfaceC14083v, boolean z10, InterfaceC13681f interfaceC13681f, C14077p.a aVar) {
            return new C14077p<>(interfaceC14083v, z10, true, interfaceC13681f, aVar);
        }
    }

    /* renamed from: z1.l$d */
    public static final class d {

        /* renamed from: a */
        public final InterfaceC11793f f63015a;

        /* renamed from: b */
        public final Executor f63016b;

        public d(InterfaceC11793f interfaceC11793f, Executor executor) {
            this.f63015a = interfaceC11793f;
            this.f63016b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f63015a.equals(((d) obj).f63015a);
            }
            return false;
        }

        public int hashCode() {
            return this.f63015a.hashCode();
        }
    }

    /* renamed from: z1.l$e */
    public static final class e implements Iterable<d> {

        /* renamed from: a */
        public final List<d> f63017a;

        public e() {
            this(new ArrayList(2));
        }

        /* renamed from: d */
        public static d m84388d(InterfaceC11793f interfaceC11793f) {
            return new d(interfaceC11793f, C12670e.m76259a());
        }

        /* renamed from: a */
        public void m84389a(InterfaceC11793f interfaceC11793f, Executor executor) {
            this.f63017a.add(new d(interfaceC11793f, executor));
        }

        /* renamed from: b */
        public boolean m84390b(InterfaceC11793f interfaceC11793f) {
            return this.f63017a.contains(m84388d(interfaceC11793f));
        }

        /* renamed from: c */
        public e m84391c() {
            return new e(new ArrayList(this.f63017a));
        }

        public void clear() {
            this.f63017a.clear();
        }

        /* renamed from: e */
        public void m84392e(InterfaceC11793f interfaceC11793f) {
            this.f63017a.remove(m84388d(interfaceC11793f));
        }

        public boolean isEmpty() {
            return this.f63017a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f63017a.iterator();
        }

        public int size() {
            return this.f63017a.size();
        }

        public e(List<d> list) {
            this.f63017a = list;
        }
    }

    public C14073l(ExecutorServiceC1380a executorServiceC1380a, ExecutorServiceC1380a executorServiceC1380a2, ExecutorServiceC1380a executorServiceC1380a3, ExecutorServiceC1380a executorServiceC1380a4, InterfaceC14074m interfaceC14074m, C14077p.a aVar, InterfaceC9370e<C14073l<?>> interfaceC9370e) {
        this(executorServiceC1380a, executorServiceC1380a2, executorServiceC1380a3, executorServiceC1380a4, interfaceC14074m, aVar, interfaceC9370e, f62985z);
    }

    /* renamed from: q */
    private synchronized void m84372q() {
        if (this.f62997l == null) {
            throw new IllegalArgumentException();
        }
        this.f62986a.clear();
        this.f62997l = null;
        this.f63007v = null;
        this.f63002q = null;
        this.f63006u = false;
        this.f63009x = false;
        this.f63004s = false;
        this.f63010y = false;
        this.f63008w.m84316H(false);
        this.f63008w = null;
        this.f63005t = null;
        this.f63003r = null;
        this.f62989d.mo58737a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p829z1.RunnableC14069h.b
    /* renamed from: a */
    public void mo84335a(InterfaceC14083v<R> interfaceC14083v, EnumC13676a enumC13676a, boolean z10) {
        synchronized (this) {
            this.f63002q = interfaceC14083v;
            this.f63003r = enumC13676a;
            this.f63010y = z10;
        }
        m84383o();
    }

    @Override // p829z1.RunnableC14069h.b
    /* renamed from: b */
    public void mo84336b(RunnableC14069h<?> runnableC14069h) {
        m84378j().execute(runnableC14069h);
    }

    @Override // p829z1.RunnableC14069h.b
    /* renamed from: c */
    public void mo84337c(C14078q c14078q) {
        synchronized (this) {
            this.f63005t = c14078q;
        }
        m84382n();
    }

    /* renamed from: d */
    public synchronized void m84373d(InterfaceC11793f interfaceC11793f, Executor executor) {
        try {
            this.f62987b.mo77583c();
            this.f62986a.m84389a(interfaceC11793f, executor);
            if (this.f63004s) {
                m84379k(1);
                executor.execute(new b(interfaceC11793f));
            } else if (this.f63006u) {
                m84379k(1);
                executor.execute(new a(interfaceC11793f));
            } else {
                C12676k.m76273a(!this.f63009x, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: e */
    public void m84374e(InterfaceC11793f interfaceC11793f) {
        try {
            interfaceC11793f.mo70283c(this.f63005t);
        } catch (Throwable th2) {
            throw new C14063b(th2);
        }
    }

    /* renamed from: f */
    public void m84375f(InterfaceC11793f interfaceC11793f) {
        try {
            interfaceC11793f.mo70282a(this.f63007v, this.f63003r, this.f63010y);
        } catch (Throwable th2) {
            throw new C14063b(th2);
        }
    }

    /* renamed from: g */
    public void m84376g() {
        if (m84381m()) {
            return;
        }
        this.f63009x = true;
        this.f63008w.m84324a();
        this.f62991f.mo84357a(this, this.f62997l);
    }

    /* renamed from: h */
    public void m84377h() {
        C14077p<?> c14077p;
        synchronized (this) {
            try {
                this.f62987b.mo77583c();
                C12676k.m76273a(m84381m(), "Not yet complete!");
                int iDecrementAndGet = this.f62996k.decrementAndGet();
                C12676k.m76273a(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    c14077p = this.f63007v;
                    m84372q();
                } else {
                    c14077p = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (c14077p != null) {
            c14077p.m84397f();
        }
    }

    @Override // p645t2.C12920a.f
    /* renamed from: i */
    public AbstractC12922c mo6553i() {
        return this.f62987b;
    }

    /* renamed from: j */
    public final ExecutorServiceC1380a m84378j() {
        return this.f62999n ? this.f62994i : this.f63000o ? this.f62995j : this.f62993h;
    }

    /* renamed from: k */
    public synchronized void m84379k(int i10) {
        C14077p<?> c14077p;
        C12676k.m76273a(m84381m(), "Not yet complete!");
        if (this.f62996k.getAndAdd(i10) == 0 && (c14077p = this.f63007v) != null) {
            c14077p.m84394b();
        }
    }

    /* renamed from: l */
    public synchronized C14073l<R> m84380l(InterfaceC13681f interfaceC13681f, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f62997l = interfaceC13681f;
        this.f62998m = z10;
        this.f62999n = z11;
        this.f63000o = z12;
        this.f63001p = z13;
        return this;
    }

    /* renamed from: m */
    public final boolean m84381m() {
        return this.f63006u || this.f63004s || this.f63009x;
    }

    /* renamed from: n */
    public void m84382n() {
        synchronized (this) {
            try {
                this.f62987b.mo77583c();
                if (this.f63009x) {
                    m84372q();
                    return;
                }
                if (this.f62986a.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.f63006u) {
                    throw new IllegalStateException("Already failed once");
                }
                this.f63006u = true;
                InterfaceC13681f interfaceC13681f = this.f62997l;
                e eVarM84391c = this.f62986a.m84391c();
                m84379k(eVarM84391c.size() + 1);
                this.f62991f.mo84359d(this, interfaceC13681f, null);
                Iterator<d> it = eVarM84391c.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f63016b.execute(new a(next.f63015a));
                }
                m84377h();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: o */
    public void m84383o() {
        synchronized (this) {
            try {
                this.f62987b.mo77583c();
                if (this.f63009x) {
                    this.f63002q.mo60254a();
                    m84372q();
                    return;
                }
                if (this.f62986a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.f63004s) {
                    throw new IllegalStateException("Already have resource");
                }
                this.f63007v = this.f62990e.m84387a(this.f63002q, this.f62998m, this.f62997l, this.f62988c);
                this.f63004s = true;
                e eVarM84391c = this.f62986a.m84391c();
                m84379k(eVarM84391c.size() + 1);
                this.f62991f.mo84359d(this, this.f62997l, this.f63007v);
                Iterator<d> it = eVarM84391c.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f63016b.execute(new b(next.f63015a));
                }
                m84377h();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: p */
    public boolean m84384p() {
        return this.f63001p;
    }

    /* renamed from: r */
    public synchronized void m84385r(InterfaceC11793f interfaceC11793f) {
        try {
            this.f62987b.mo77583c();
            this.f62986a.m84392e(interfaceC11793f);
            if (this.f62986a.isEmpty()) {
                m84376g();
                if (this.f63004s || this.f63006u) {
                    if (this.f62996k.get() == 0) {
                        m84372q();
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: s */
    public synchronized void m84386s(RunnableC14069h<R> runnableC14069h) {
        try {
            this.f63008w = runnableC14069h;
            (runnableC14069h.m84323O() ? this.f62992g : m84378j()).execute(runnableC14069h);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public C14073l(ExecutorServiceC1380a executorServiceC1380a, ExecutorServiceC1380a executorServiceC1380a2, ExecutorServiceC1380a executorServiceC1380a3, ExecutorServiceC1380a executorServiceC1380a4, InterfaceC14074m interfaceC14074m, C14077p.a aVar, InterfaceC9370e<C14073l<?>> interfaceC9370e, c cVar) {
        this.f62986a = new e();
        this.f62987b = AbstractC12922c.m77581a();
        this.f62996k = new AtomicInteger();
        this.f62992g = executorServiceC1380a;
        this.f62993h = executorServiceC1380a2;
        this.f62994i = executorServiceC1380a3;
        this.f62995j = executorServiceC1380a4;
        this.f62991f = interfaceC14074m;
        this.f62988c = aVar;
        this.f62989d = interfaceC9370e;
        this.f62990e = cVar;
    }
}
