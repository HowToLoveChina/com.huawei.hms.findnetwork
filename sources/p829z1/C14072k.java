package p829z1;

import android.util.Log;
import com.bumptech.glide.C1548d;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.engine.cache.C1580b;
import com.bumptech.glide.load.engine.cache.InterfaceC1579a;
import java.util.Map;
import java.util.concurrent.Executor;
import p026b2.InterfaceC1101c;
import p044c2.ExecutorServiceC1380a;
import p243e0.InterfaceC9370e;
import p507o2.InterfaceC11793f;
import p630s2.C12672g;
import p630s2.C12676k;
import p645t2.C12920a;
import p759x1.C13684i;
import p759x1.EnumC13676a;
import p759x1.InterfaceC13681f;
import p759x1.InterfaceC13688m;
import p829z1.C14077p;
import p829z1.RunnableC14069h;

/* renamed from: z1.k */
/* loaded from: classes.dex */
public class C14072k implements InterfaceC14074m, InterfaceC1101c.a, C14077p.a {

    /* renamed from: i */
    public static final boolean f62959i = Log.isLoggable("Engine", 2);

    /* renamed from: a */
    public final C14080s f62960a;

    /* renamed from: b */
    public final C14076o f62961b;

    /* renamed from: c */
    public final InterfaceC1101c f62962c;

    /* renamed from: d */
    public final b f62963d;

    /* renamed from: e */
    public final C14086y f62964e;

    /* renamed from: f */
    public final c f62965f;

    /* renamed from: g */
    public final a f62966g;

    /* renamed from: h */
    public final C14062a f62967h;

    /* renamed from: z1.k$a */
    public static class a {

        /* renamed from: a */
        public final RunnableC14069h.e f62968a;

        /* renamed from: b */
        public final InterfaceC9370e<RunnableC14069h<?>> f62969b = C12920a.m77569d(150, new C14516a());

        /* renamed from: c */
        public int f62970c;

        /* renamed from: z1.k$a$a, reason: collision with other inner class name */
        public class C14516a implements C12920a.d<RunnableC14069h<?>> {
            public C14516a() {
            }

            @Override // p645t2.C12920a.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public RunnableC14069h<?> mo6551a() {
                a aVar = a.this;
                return new RunnableC14069h<>(aVar.f62968a, aVar.f62969b);
            }
        }

        public a(RunnableC14069h.e eVar) {
            this.f62968a = eVar;
        }

        /* renamed from: a */
        public <R> RunnableC14069h<R> m84367a(C1548d c1548d, Object obj, C14075n c14075n, InterfaceC13681f interfaceC13681f, int i10, int i11, Class<?> cls, Class<R> cls2, EnumC1551g enumC1551g, AbstractC14071j abstractC14071j, Map<Class<?>, InterfaceC13688m<?>> map, boolean z10, boolean z11, boolean z12, C13684i c13684i, RunnableC14069h.b<R> bVar) {
            RunnableC14069h runnableC14069h = (RunnableC14069h) C12676k.m76276d(this.f62969b.mo58738b());
            int i12 = this.f62970c;
            this.f62970c = i12 + 1;
            return runnableC14069h.m84333y(c1548d, obj, c14075n, interfaceC13681f, i10, i11, cls, cls2, enumC1551g, abstractC14071j, map, z10, z11, z12, c13684i, bVar, i12);
        }
    }

    /* renamed from: z1.k$b */
    public static class b {

        /* renamed from: a */
        public final ExecutorServiceC1380a f62972a;

        /* renamed from: b */
        public final ExecutorServiceC1380a f62973b;

        /* renamed from: c */
        public final ExecutorServiceC1380a f62974c;

        /* renamed from: d */
        public final ExecutorServiceC1380a f62975d;

        /* renamed from: e */
        public final InterfaceC14074m f62976e;

        /* renamed from: f */
        public final C14077p.a f62977f;

        /* renamed from: g */
        public final InterfaceC9370e<C14073l<?>> f62978g = C12920a.m77569d(150, new a());

        /* renamed from: z1.k$b$a */
        public class a implements C12920a.d<C14073l<?>> {
            public a() {
            }

            @Override // p645t2.C12920a.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public C14073l<?> mo6551a() {
                b bVar = b.this;
                return new C14073l<>(bVar.f62972a, bVar.f62973b, bVar.f62974c, bVar.f62975d, bVar.f62976e, bVar.f62977f, bVar.f62978g);
            }
        }

        public b(ExecutorServiceC1380a executorServiceC1380a, ExecutorServiceC1380a executorServiceC1380a2, ExecutorServiceC1380a executorServiceC1380a3, ExecutorServiceC1380a executorServiceC1380a4, InterfaceC14074m interfaceC14074m, C14077p.a aVar) {
            this.f62972a = executorServiceC1380a;
            this.f62973b = executorServiceC1380a2;
            this.f62974c = executorServiceC1380a3;
            this.f62975d = executorServiceC1380a4;
            this.f62976e = interfaceC14074m;
            this.f62977f = aVar;
        }

        /* renamed from: a */
        public <R> C14073l<R> m84369a(InterfaceC13681f interfaceC13681f, boolean z10, boolean z11, boolean z12, boolean z13) {
            return ((C14073l) C12676k.m76276d(this.f62978g.mo58738b())).m84380l(interfaceC13681f, z10, z11, z12, z13);
        }
    }

    /* renamed from: z1.k$c */
    public static class c implements RunnableC14069h.e {

        /* renamed from: a */
        public final InterfaceC1579a.a f62980a;

        /* renamed from: b */
        public volatile InterfaceC1579a f62981b;

        public c(InterfaceC1579a.a aVar) {
            this.f62980a = aVar;
        }

        @Override // p829z1.RunnableC14069h.e
        /* renamed from: a */
        public InterfaceC1579a mo84343a() {
            if (this.f62981b == null) {
                synchronized (this) {
                    try {
                        if (this.f62981b == null) {
                            this.f62981b = this.f62980a.build();
                        }
                        if (this.f62981b == null) {
                            this.f62981b = new C1580b();
                        }
                    } finally {
                    }
                }
            }
            return this.f62981b;
        }
    }

    /* renamed from: z1.k$d */
    public class d {

        /* renamed from: a */
        public final C14073l<?> f62982a;

        /* renamed from: b */
        public final InterfaceC11793f f62983b;

        public d(InterfaceC11793f interfaceC11793f, C14073l<?> c14073l) {
            this.f62983b = interfaceC11793f;
            this.f62982a = c14073l;
        }

        /* renamed from: a */
        public void m84371a() {
            synchronized (C14072k.this) {
                this.f62982a.m84385r(this.f62983b);
            }
        }
    }

    public C14072k(InterfaceC1101c interfaceC1101c, InterfaceC1579a.a aVar, ExecutorServiceC1380a executorServiceC1380a, ExecutorServiceC1380a executorServiceC1380a2, ExecutorServiceC1380a executorServiceC1380a3, ExecutorServiceC1380a executorServiceC1380a4, C14080s c14080s, C14076o c14076o, C14062a c14062a, b bVar, a aVar2, C14086y c14086y, boolean z10) {
        this.f62962c = interfaceC1101c;
        c cVar = new c(aVar);
        this.f62965f = cVar;
        C14062a c14062a2 = c14062a == null ? new C14062a(z10) : c14062a;
        this.f62967h = c14062a2;
        c14062a2.m84277f(this);
        this.f62961b = c14076o == null ? new C14076o() : c14076o;
        this.f62960a = c14080s == null ? new C14080s() : c14080s;
        this.f62963d = bVar == null ? new b(executorServiceC1380a, executorServiceC1380a2, executorServiceC1380a3, executorServiceC1380a4, this, this) : bVar;
        this.f62966g = aVar2 == null ? new a(cVar) : aVar2;
        this.f62964e = c14086y == null ? new C14086y() : c14086y;
        interfaceC1101c.mo6543d(this);
    }

    /* renamed from: j */
    public static void m84356j(String str, long j10, InterfaceC13681f interfaceC13681f) {
        Log.v("Engine", str + " in " + C12672g.m76262a(j10) + "ms, key: " + interfaceC13681f);
    }

    @Override // p829z1.InterfaceC14074m
    /* renamed from: a */
    public synchronized void mo84357a(C14073l<?> c14073l, InterfaceC13681f interfaceC13681f) {
        this.f62960a.m84413d(interfaceC13681f, c14073l);
    }

    @Override // p026b2.InterfaceC1101c.a
    /* renamed from: b */
    public void mo6548b(InterfaceC14083v<?> interfaceC14083v) {
        this.f62964e.m84423a(interfaceC14083v, true);
    }

    @Override // p829z1.C14077p.a
    /* renamed from: c */
    public void mo84358c(InterfaceC13681f interfaceC13681f, C14077p<?> c14077p) {
        this.f62967h.m84275d(interfaceC13681f);
        if (c14077p.m84396e()) {
            this.f62962c.mo6541b(interfaceC13681f, c14077p);
        } else {
            this.f62964e.m84423a(c14077p, false);
        }
    }

    @Override // p829z1.InterfaceC14074m
    /* renamed from: d */
    public synchronized void mo84359d(C14073l<?> c14073l, InterfaceC13681f interfaceC13681f, C14077p<?> c14077p) {
        if (c14077p != null) {
            try {
                if (c14077p.m84396e()) {
                    this.f62967h.m84272a(interfaceC13681f, c14077p);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f62960a.m84413d(interfaceC13681f, c14073l);
    }

    /* renamed from: e */
    public final C14077p<?> m84360e(InterfaceC13681f interfaceC13681f) {
        InterfaceC14083v<?> interfaceC14083vMo6542c = this.f62962c.mo6542c(interfaceC13681f);
        if (interfaceC14083vMo6542c == null) {
            return null;
        }
        return interfaceC14083vMo6542c instanceof C14077p ? (C14077p) interfaceC14083vMo6542c : new C14077p<>(interfaceC14083vMo6542c, true, true, interfaceC13681f, this);
    }

    /* renamed from: f */
    public <R> d m84361f(C1548d c1548d, Object obj, InterfaceC13681f interfaceC13681f, int i10, int i11, Class<?> cls, Class<R> cls2, EnumC1551g enumC1551g, AbstractC14071j abstractC14071j, Map<Class<?>, InterfaceC13688m<?>> map, boolean z10, boolean z11, C13684i c13684i, boolean z12, boolean z13, boolean z14, boolean z15, InterfaceC11793f interfaceC11793f, Executor executor) {
        long jM76263b = f62959i ? C12672g.m76263b() : 0L;
        C14075n c14075nM84393a = this.f62961b.m84393a(obj, interfaceC13681f, i10, i11, map, cls, cls2, c13684i);
        synchronized (this) {
            try {
                C14077p<?> c14077pM84364i = m84364i(c14075nM84393a, z12, jM76263b);
                if (c14077pM84364i == null) {
                    return m84366l(c1548d, obj, interfaceC13681f, i10, i11, cls, cls2, enumC1551g, abstractC14071j, map, z10, z11, c13684i, z12, z13, z14, z15, interfaceC11793f, executor, c14075nM84393a, jM76263b);
                }
                interfaceC11793f.mo70282a(c14077pM84364i, EnumC13676a.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g */
    public final C14077p<?> m84362g(InterfaceC13681f interfaceC13681f) {
        C14077p<?> c14077pM84276e = this.f62967h.m84276e(interfaceC13681f);
        if (c14077pM84276e != null) {
            c14077pM84276e.m84394b();
        }
        return c14077pM84276e;
    }

    /* renamed from: h */
    public final C14077p<?> m84363h(InterfaceC13681f interfaceC13681f) {
        C14077p<?> c14077pM84360e = m84360e(interfaceC13681f);
        if (c14077pM84360e != null) {
            c14077pM84360e.m84394b();
            this.f62967h.m84272a(interfaceC13681f, c14077pM84360e);
        }
        return c14077pM84360e;
    }

    /* renamed from: i */
    public final C14077p<?> m84364i(C14075n c14075n, boolean z10, long j10) {
        if (!z10) {
            return null;
        }
        C14077p<?> c14077pM84362g = m84362g(c14075n);
        if (c14077pM84362g != null) {
            if (f62959i) {
                m84356j("Loaded resource from active resources", j10, c14075n);
            }
            return c14077pM84362g;
        }
        C14077p<?> c14077pM84363h = m84363h(c14075n);
        if (c14077pM84363h == null) {
            return null;
        }
        if (f62959i) {
            m84356j("Loaded resource from cache", j10, c14075n);
        }
        return c14077pM84363h;
    }

    /* renamed from: k */
    public void m84365k(InterfaceC14083v<?> interfaceC14083v) {
        if (!(interfaceC14083v instanceof C14077p)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((C14077p) interfaceC14083v).m84397f();
    }

    /* renamed from: l */
    public final <R> d m84366l(C1548d c1548d, Object obj, InterfaceC13681f interfaceC13681f, int i10, int i11, Class<?> cls, Class<R> cls2, EnumC1551g enumC1551g, AbstractC14071j abstractC14071j, Map<Class<?>, InterfaceC13688m<?>> map, boolean z10, boolean z11, C13684i c13684i, boolean z12, boolean z13, boolean z14, boolean z15, InterfaceC11793f interfaceC11793f, Executor executor, C14075n c14075n, long j10) {
        C14073l<?> c14073lM84410a = this.f62960a.m84410a(c14075n, z15);
        if (c14073lM84410a != null) {
            c14073lM84410a.m84373d(interfaceC11793f, executor);
            if (f62959i) {
                m84356j("Added to existing load", j10, c14075n);
            }
            return new d(interfaceC11793f, c14073lM84410a);
        }
        C14073l<R> c14073lM84369a = this.f62963d.m84369a(c14075n, z12, z13, z14, z15);
        RunnableC14069h<R> runnableC14069hM84367a = this.f62966g.m84367a(c1548d, obj, c14075n, interfaceC13681f, i10, i11, cls, cls2, enumC1551g, abstractC14071j, map, z10, z11, z15, c13684i, c14073lM84369a);
        this.f62960a.m84412c(c14075n, c14073lM84369a);
        c14073lM84369a.m84373d(interfaceC11793f, executor);
        c14073lM84369a.m84386s(runnableC14069hM84367a);
        if (f62959i) {
            m84356j("Started new load", j10, c14075n);
        }
        return new d(interfaceC11793f, c14073lM84369a);
    }

    public C14072k(InterfaceC1101c interfaceC1101c, InterfaceC1579a.a aVar, ExecutorServiceC1380a executorServiceC1380a, ExecutorServiceC1380a executorServiceC1380a2, ExecutorServiceC1380a executorServiceC1380a3, ExecutorServiceC1380a executorServiceC1380a4, boolean z10) {
        this(interfaceC1101c, aVar, executorServiceC1380a, executorServiceC1380a2, executorServiceC1380a3, executorServiceC1380a4, null, null, null, null, null, null, z10);
    }
}
