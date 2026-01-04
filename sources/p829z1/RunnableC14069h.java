package p829z1;

import android.util.Log;
import com.bumptech.glide.C1548d;
import com.bumptech.glide.C1552h;
import com.bumptech.glide.EnumC1551g;
import com.bumptech.glide.load.data.InterfaceC1563d;
import com.bumptech.glide.load.data.InterfaceC1564e;
import com.bumptech.glide.load.engine.cache.InterfaceC1579a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p243e0.InterfaceC9370e;
import p306g2.C9862n;
import p630s2.C12672g;
import p645t2.AbstractC12922c;
import p645t2.C12920a;
import p645t2.C12921b;
import p759x1.C13683h;
import p759x1.C13684i;
import p759x1.EnumC13676a;
import p759x1.EnumC13678c;
import p759x1.InterfaceC13681f;
import p759x1.InterfaceC13687l;
import p759x1.InterfaceC13688m;
import p829z1.C14070i;
import p829z1.InterfaceC14067f;

/* renamed from: z1.h */
/* loaded from: classes.dex */
public class RunnableC14069h<R> implements InterfaceC14067f.a, Runnable, Comparable<RunnableC14069h<?>>, C12920a.f {

    /* renamed from: A */
    public EnumC13676a f62895A;

    /* renamed from: B */
    public InterfaceC1563d<?> f62896B;

    /* renamed from: C */
    public volatile InterfaceC14067f f62897C;

    /* renamed from: D */
    public volatile boolean f62898D;

    /* renamed from: E */
    public volatile boolean f62899E;

    /* renamed from: F */
    public boolean f62900F;

    /* renamed from: d */
    public final e f62904d;

    /* renamed from: e */
    public final InterfaceC9370e<RunnableC14069h<?>> f62905e;

    /* renamed from: h */
    public C1548d f62908h;

    /* renamed from: i */
    public InterfaceC13681f f62909i;

    /* renamed from: j */
    public EnumC1551g f62910j;

    /* renamed from: k */
    public C14075n f62911k;

    /* renamed from: l */
    public int f62912l;

    /* renamed from: m */
    public int f62913m;

    /* renamed from: n */
    public AbstractC14071j f62914n;

    /* renamed from: o */
    public C13684i f62915o;

    /* renamed from: p */
    public b<R> f62916p;

    /* renamed from: q */
    public int f62917q;

    /* renamed from: r */
    public h f62918r;

    /* renamed from: s */
    public g f62919s;

    /* renamed from: t */
    public long f62920t;

    /* renamed from: u */
    public boolean f62921u;

    /* renamed from: v */
    public Object f62922v;

    /* renamed from: w */
    public Thread f62923w;

    /* renamed from: x */
    public InterfaceC13681f f62924x;

    /* renamed from: y */
    public InterfaceC13681f f62925y;

    /* renamed from: z */
    public Object f62926z;

    /* renamed from: a */
    public final C14068g<R> f62901a = new C14068g<>();

    /* renamed from: b */
    public final List<Throwable> f62902b = new ArrayList();

    /* renamed from: c */
    public final AbstractC12922c f62903c = AbstractC12922c.m77581a();

    /* renamed from: f */
    public final d<?> f62906f = new d<>();

    /* renamed from: g */
    public final f f62907g = new f();

    /* renamed from: z1.h$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f62927a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f62928b;

        /* renamed from: c */
        public static final /* synthetic */ int[] f62929c;

        static {
            int[] iArr = new int[EnumC13678c.values().length];
            f62929c = iArr;
            try {
                iArr[EnumC13678c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f62929c[EnumC13678c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[h.values().length];
            f62928b = iArr2;
            try {
                iArr2[h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f62928b[h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f62928b[h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f62928b[h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f62928b[h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            f62927a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f62927a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f62927a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: z1.h$b */
    public interface b<R> {
        /* renamed from: a */
        void mo84335a(InterfaceC14083v<R> interfaceC14083v, EnumC13676a enumC13676a, boolean z10);

        /* renamed from: b */
        void mo84336b(RunnableC14069h<?> runnableC14069h);

        /* renamed from: c */
        void mo84337c(C14078q c14078q);
    }

    /* renamed from: z1.h$c */
    public final class c<Z> implements C14070i.a<Z> {

        /* renamed from: a */
        public final EnumC13676a f62930a;

        public c(EnumC13676a enumC13676a) {
            this.f62930a = enumC13676a;
        }

        @Override // p829z1.C14070i.a
        /* renamed from: a */
        public InterfaceC14083v<Z> mo84338a(InterfaceC14083v<Z> interfaceC14083v) {
            return RunnableC14069h.this.m84315G(this.f62930a, interfaceC14083v);
        }
    }

    /* renamed from: z1.h$d */
    public static class d<Z> {

        /* renamed from: a */
        public InterfaceC13681f f62932a;

        /* renamed from: b */
        public InterfaceC13687l<Z> f62933b;

        /* renamed from: c */
        public C14082u<Z> f62934c;

        /* renamed from: a */
        public void m84339a() {
            this.f62932a = null;
            this.f62933b = null;
            this.f62934c = null;
        }

        /* renamed from: b */
        public void m84340b(e eVar, C13684i c13684i) {
            C12921b.m77575a("DecodeJob.encode");
            try {
                eVar.mo84343a().mo9066b(this.f62932a, new C14066e(this.f62933b, this.f62934c, c13684i));
            } finally {
                this.f62934c.m84419f();
                C12921b.m77579e();
            }
        }

        /* renamed from: c */
        public boolean m84341c() {
            return this.f62934c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: d */
        public <X> void m84342d(InterfaceC13681f interfaceC13681f, InterfaceC13687l<X> interfaceC13687l, C14082u<X> c14082u) {
            this.f62932a = interfaceC13681f;
            this.f62933b = interfaceC13687l;
            this.f62934c = c14082u;
        }
    }

    /* renamed from: z1.h$e */
    public interface e {
        /* renamed from: a */
        InterfaceC1579a mo84343a();
    }

    /* renamed from: z1.h$f */
    public static class f {

        /* renamed from: a */
        public boolean f62935a;

        /* renamed from: b */
        public boolean f62936b;

        /* renamed from: c */
        public boolean f62937c;

        /* renamed from: a */
        public final boolean m84344a(boolean z10) {
            return (this.f62937c || z10 || this.f62936b) && this.f62935a;
        }

        /* renamed from: b */
        public synchronized boolean m84345b() {
            this.f62936b = true;
            return m84344a(false);
        }

        /* renamed from: c */
        public synchronized boolean m84346c() {
            this.f62937c = true;
            return m84344a(false);
        }

        /* renamed from: d */
        public synchronized boolean m84347d(boolean z10) {
            this.f62935a = true;
            return m84344a(z10);
        }

        /* renamed from: e */
        public synchronized void m84348e() {
            this.f62936b = false;
            this.f62935a = false;
            this.f62937c = false;
        }
    }

    /* renamed from: z1.h$g */
    public enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* renamed from: z1.h$h */
    public enum h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public RunnableC14069h(e eVar, InterfaceC9370e<RunnableC14069h<?>> interfaceC9370e) {
        this.f62904d = eVar;
        this.f62905e = interfaceC9370e;
    }

    /* renamed from: A */
    public final void m84309A(String str, long j10, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(C12672g.m76262a(j10));
        sb2.append(", load key: ");
        sb2.append(this.f62911k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb2.append(str3);
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb2.toString());
    }

    /* renamed from: B */
    public final void m84310B(InterfaceC14083v<R> interfaceC14083v, EnumC13676a enumC13676a, boolean z10) {
        m84322N();
        this.f62916p.mo84335a(interfaceC14083v, enumC13676a, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C */
    public final void m84311C(InterfaceC14083v<R> interfaceC14083v, EnumC13676a enumC13676a, boolean z10) {
        C14082u c14082u;
        C12921b.m77575a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (interfaceC14083v instanceof InterfaceC14079r) {
                ((InterfaceC14079r) interfaceC14083v).mo61233b();
            }
            if (this.f62906f.m84341c()) {
                interfaceC14083v = C14082u.m84416d(interfaceC14083v);
                c14082u = interfaceC14083v;
            } else {
                c14082u = 0;
            }
            m84310B(interfaceC14083v, enumC13676a, z10);
            this.f62918r = h.ENCODE;
            try {
                if (this.f62906f.m84341c()) {
                    this.f62906f.m84340b(this.f62904d, this.f62915o);
                }
                m84313E();
                C12921b.m77579e();
            } finally {
                if (c14082u != 0) {
                    c14082u.m84419f();
                }
            }
        } catch (Throwable th2) {
            C12921b.m77579e();
            throw th2;
        }
    }

    /* renamed from: D */
    public final void m84312D() {
        m84322N();
        this.f62916p.mo84337c(new C14078q("Failed to load resource", new ArrayList(this.f62902b)));
        m84314F();
    }

    /* renamed from: E */
    public final void m84313E() {
        if (this.f62907g.m84345b()) {
            m84317I();
        }
    }

    /* renamed from: F */
    public final void m84314F() {
        if (this.f62907g.m84346c()) {
            m84317I();
        }
    }

    /* renamed from: G */
    public <Z> InterfaceC14083v<Z> m84315G(EnumC13676a enumC13676a, InterfaceC14083v<Z> interfaceC14083v) {
        InterfaceC14083v<Z> interfaceC14083vMo60257b;
        InterfaceC13688m<Z> interfaceC13688m;
        EnumC13678c enumC13678cMo61223a;
        InterfaceC13681f c14065d;
        Class<?> cls = interfaceC14083v.get().getClass();
        InterfaceC13687l<Z> interfaceC13687lM84297n = null;
        if (enumC13676a != EnumC13676a.RESOURCE_DISK_CACHE) {
            InterfaceC13688m<Z> interfaceC13688mM84302s = this.f62901a.m84302s(cls);
            interfaceC13688m = interfaceC13688mM84302s;
            interfaceC14083vMo60257b = interfaceC13688mM84302s.mo60257b(this.f62908h, interfaceC14083v, this.f62912l, this.f62913m);
        } else {
            interfaceC14083vMo60257b = interfaceC14083v;
            interfaceC13688m = null;
        }
        if (!interfaceC14083v.equals(interfaceC14083vMo60257b)) {
            interfaceC14083v.mo60254a();
        }
        if (this.f62901a.m84306w(interfaceC14083vMo60257b)) {
            interfaceC13687lM84297n = this.f62901a.m84297n(interfaceC14083vMo60257b);
            enumC13678cMo61223a = interfaceC13687lM84297n.mo61223a(this.f62915o);
        } else {
            enumC13678cMo61223a = EnumC13678c.NONE;
        }
        InterfaceC13687l interfaceC13687l = interfaceC13687lM84297n;
        if (!this.f62914n.mo84355d(!this.f62901a.m84308y(this.f62924x), enumC13676a, enumC13678cMo61223a)) {
            return interfaceC14083vMo60257b;
        }
        if (interfaceC13687l == null) {
            throw new C1552h.d(interfaceC14083vMo60257b.get().getClass());
        }
        int i10 = a.f62929c[enumC13678cMo61223a.ordinal()];
        if (i10 == 1) {
            c14065d = new C14065d(this.f62924x, this.f62909i);
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + enumC13678cMo61223a);
            }
            c14065d = new C14085x(this.f62901a.m84285b(), this.f62924x, this.f62909i, this.f62912l, this.f62913m, interfaceC13688m, cls, this.f62915o);
        }
        C14082u c14082uM84416d = C14082u.m84416d(interfaceC14083vMo60257b);
        this.f62906f.m84342d(c14065d, interfaceC13687l, c14082uM84416d);
        return c14082uM84416d;
    }

    /* renamed from: H */
    public void m84316H(boolean z10) {
        if (this.f62907g.m84347d(z10)) {
            m84317I();
        }
    }

    /* renamed from: I */
    public final void m84317I() {
        this.f62907g.m84348e();
        this.f62906f.m84339a();
        this.f62901a.m84284a();
        this.f62898D = false;
        this.f62908h = null;
        this.f62909i = null;
        this.f62915o = null;
        this.f62910j = null;
        this.f62911k = null;
        this.f62916p = null;
        this.f62918r = null;
        this.f62897C = null;
        this.f62923w = null;
        this.f62924x = null;
        this.f62926z = null;
        this.f62895A = null;
        this.f62896B = null;
        this.f62920t = 0L;
        this.f62899E = false;
        this.f62922v = null;
        this.f62902b.clear();
        this.f62905e.mo58737a(this);
    }

    /* renamed from: J */
    public final void m84318J(g gVar) {
        this.f62919s = gVar;
        this.f62916p.mo84336b(this);
    }

    /* renamed from: K */
    public final void m84319K() {
        this.f62923w = Thread.currentThread();
        this.f62920t = C12672g.m76263b();
        boolean zMo84280a = false;
        while (!this.f62899E && this.f62897C != null && !(zMo84280a = this.f62897C.mo84280a())) {
            this.f62918r = m84330t(this.f62918r);
            this.f62897C = m84329s();
            if (this.f62918r == h.SOURCE) {
                m84318J(g.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.f62918r == h.FINISHED || this.f62899E) && !zMo84280a) {
            m84312D();
        }
    }

    /* renamed from: L */
    public final <Data, ResourceType> InterfaceC14083v<R> m84320L(Data data, EnumC13676a enumC13676a, C14081t<Data, ResourceType, R> c14081t) throws C14078q {
        C13684i c13684iM84331u = m84331u(enumC13676a);
        InterfaceC1564e<Data> interfaceC1564eM8942l = this.f62908h.m8927i().m8942l(data);
        try {
            return c14081t.m84414a(interfaceC1564eM8942l, c13684iM84331u, this.f62912l, this.f62913m, new c(enumC13676a));
        } finally {
            interfaceC1564eM8942l.mo9012b();
        }
    }

    /* renamed from: M */
    public final void m84321M() {
        int i10 = a.f62927a[this.f62919s.ordinal()];
        if (i10 == 1) {
            this.f62918r = m84330t(h.INITIALIZE);
            this.f62897C = m84329s();
            m84319K();
        } else if (i10 == 2) {
            m84319K();
        } else {
            if (i10 == 3) {
                m84328r();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f62919s);
        }
    }

    /* renamed from: N */
    public final void m84322N() {
        Throwable th2;
        this.f62903c.mo77583c();
        if (!this.f62898D) {
            this.f62898D = true;
            return;
        }
        if (this.f62902b.isEmpty()) {
            th2 = null;
        } else {
            List<Throwable> list = this.f62902b;
            th2 = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th2);
    }

    /* renamed from: O */
    public boolean m84323O() {
        h hVarM84330t = m84330t(h.INITIALIZE);
        return hVarM84330t == h.RESOURCE_CACHE || hVarM84330t == h.DATA_CACHE;
    }

    /* renamed from: a */
    public void m84324a() {
        this.f62899E = true;
        InterfaceC14067f interfaceC14067f = this.f62897C;
        if (interfaceC14067f != null) {
            interfaceC14067f.cancel();
        }
    }

    @Override // p829z1.InterfaceC14067f.a
    /* renamed from: e */
    public void mo84281e(InterfaceC13681f interfaceC13681f, Object obj, InterfaceC1563d<?> interfaceC1563d, EnumC13676a enumC13676a, InterfaceC13681f interfaceC13681f2) {
        this.f62924x = interfaceC13681f;
        this.f62926z = obj;
        this.f62896B = interfaceC1563d;
        this.f62895A = enumC13676a;
        this.f62925y = interfaceC13681f2;
        this.f62900F = interfaceC13681f != this.f62901a.m84286c().get(0);
        if (Thread.currentThread() != this.f62923w) {
            m84318J(g.DECODE_DATA);
            return;
        }
        C12921b.m77575a("DecodeJob.decodeFromRetrievedData");
        try {
            m84328r();
        } finally {
            C12921b.m77579e();
        }
    }

    @Override // p829z1.InterfaceC14067f.a
    /* renamed from: f */
    public void mo84282f(InterfaceC13681f interfaceC13681f, Exception exc, InterfaceC1563d<?> interfaceC1563d, EnumC13676a enumC13676a) {
        interfaceC1563d.mo9022b();
        C14078q c14078q = new C14078q("Fetching data failed", exc);
        c14078q.m84407l(interfaceC13681f, enumC13676a, interfaceC1563d.mo9017a());
        this.f62902b.add(c14078q);
        if (Thread.currentThread() != this.f62923w) {
            m84318J(g.SWITCH_TO_SOURCE_SERVICE);
        } else {
            m84319K();
        }
    }

    @Override // p829z1.InterfaceC14067f.a
    /* renamed from: h */
    public void mo84283h() {
        m84318J(g.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override // p645t2.C12920a.f
    /* renamed from: i */
    public AbstractC12922c mo6553i() {
        return this.f62903c;
    }

    @Override // java.lang.Comparable
    /* renamed from: k */
    public int compareTo(RunnableC14069h<?> runnableC14069h) {
        int iM84332v = m84332v() - runnableC14069h.m84332v();
        return iM84332v == 0 ? this.f62917q - runnableC14069h.f62917q : iM84332v;
    }

    /* renamed from: p */
    public final <Data> InterfaceC14083v<R> m84326p(InterfaceC1563d<?> interfaceC1563d, Data data, EnumC13676a enumC13676a) throws C14078q {
        if (data == null) {
            interfaceC1563d.mo9022b();
            return null;
        }
        try {
            long jM76263b = C12672g.m76263b();
            InterfaceC14083v<R> interfaceC14083vM84327q = m84327q(data, enumC13676a);
            if (Log.isLoggable("DecodeJob", 2)) {
                m84334z("Decoded result " + interfaceC14083vM84327q, jM76263b);
            }
            return interfaceC14083vM84327q;
        } finally {
            interfaceC1563d.mo9022b();
        }
    }

    /* renamed from: q */
    public final <Data> InterfaceC14083v<R> m84327q(Data data, EnumC13676a enumC13676a) throws C14078q {
        return m84320L(data, enumC13676a, this.f62901a.m84291h(data.getClass()));
    }

    /* renamed from: r */
    public final void m84328r() {
        InterfaceC14083v<R> interfaceC14083vM84326p;
        if (Log.isLoggable("DecodeJob", 2)) {
            m84309A("Retrieved data", this.f62920t, "data: " + this.f62926z + ", cache key: " + this.f62924x + ", fetcher: " + this.f62896B);
        }
        try {
            interfaceC14083vM84326p = m84326p(this.f62896B, this.f62926z, this.f62895A);
        } catch (C14078q e10) {
            e10.m84406k(this.f62925y, this.f62895A);
            this.f62902b.add(e10);
            interfaceC14083vM84326p = null;
        }
        if (interfaceC14083vM84326p != null) {
            m84311C(interfaceC14083vM84326p, this.f62895A, this.f62900F);
        } else {
            m84319K();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        C12921b.m77577c("DecodeJob#run(reason=%s, model=%s)", this.f62919s, this.f62922v);
        InterfaceC1563d<?> interfaceC1563d = this.f62896B;
        try {
            try {
                try {
                    if (this.f62899E) {
                        m84312D();
                        if (interfaceC1563d != null) {
                            interfaceC1563d.mo9022b();
                        }
                        C12921b.m77579e();
                        return;
                    }
                    m84321M();
                    if (interfaceC1563d != null) {
                        interfaceC1563d.mo9022b();
                    }
                    C12921b.m77579e();
                } catch (Throwable th2) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.f62899E + ", stage: " + this.f62918r, th2);
                    }
                    if (this.f62918r != h.ENCODE) {
                        this.f62902b.add(th2);
                        m84312D();
                    }
                    if (!this.f62899E) {
                        throw th2;
                    }
                    throw th2;
                }
            } catch (C14063b e10) {
                throw e10;
            }
        } catch (Throwable th3) {
            if (interfaceC1563d != null) {
                interfaceC1563d.mo9022b();
            }
            C12921b.m77579e();
            throw th3;
        }
    }

    /* renamed from: s */
    public final InterfaceC14067f m84329s() {
        int i10 = a.f62928b[this.f62918r.ordinal()];
        if (i10 == 1) {
            return new C14084w(this.f62901a, this);
        }
        if (i10 == 2) {
            return new C14064c(this.f62901a, this);
        }
        if (i10 == 3) {
            return new C14087z(this.f62901a, this);
        }
        if (i10 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f62918r);
    }

    /* renamed from: t */
    public final h m84330t(h hVar) {
        int i10 = a.f62928b[hVar.ordinal()];
        if (i10 == 1) {
            return this.f62914n.mo84352a() ? h.DATA_CACHE : m84330t(h.DATA_CACHE);
        }
        if (i10 == 2) {
            return this.f62921u ? h.FINISHED : h.SOURCE;
        }
        if (i10 == 3 || i10 == 4) {
            return h.FINISHED;
        }
        if (i10 == 5) {
            return this.f62914n.mo84353b() ? h.RESOURCE_CACHE : m84330t(h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + hVar);
    }

    /* renamed from: u */
    public final C13684i m84331u(EnumC13676a enumC13676a) {
        C13684i c13684i = this.f62915o;
        boolean z10 = enumC13676a == EnumC13676a.RESOURCE_DISK_CACHE || this.f62901a.m84307x();
        C13683h<Boolean> c13683h = C9862n.f48446j;
        Boolean bool = (Boolean) c13684i.m82284c(c13683h);
        if (bool != null && (!bool.booleanValue() || z10)) {
            return c13684i;
        }
        C13684i c13684i2 = new C13684i();
        c13684i2.m82285d(this.f62915o);
        c13684i2.m82286e(c13683h, Boolean.valueOf(z10));
        return c13684i2;
    }

    /* renamed from: v */
    public final int m84332v() {
        return this.f62910j.ordinal();
    }

    /* renamed from: y */
    public RunnableC14069h<R> m84333y(C1548d c1548d, Object obj, C14075n c14075n, InterfaceC13681f interfaceC13681f, int i10, int i11, Class<?> cls, Class<R> cls2, EnumC1551g enumC1551g, AbstractC14071j abstractC14071j, Map<Class<?>, InterfaceC13688m<?>> map, boolean z10, boolean z11, boolean z12, C13684i c13684i, b<R> bVar, int i12) {
        this.f62901a.m84305v(c1548d, obj, interfaceC13681f, i10, i11, abstractC14071j, cls, cls2, enumC1551g, c13684i, map, z10, z11, this.f62904d);
        this.f62908h = c1548d;
        this.f62909i = interfaceC13681f;
        this.f62910j = enumC1551g;
        this.f62911k = c14075n;
        this.f62912l = i10;
        this.f62913m = i11;
        this.f62914n = abstractC14071j;
        this.f62921u = z12;
        this.f62915o = c13684i;
        this.f62916p = bVar;
        this.f62917q = i12;
        this.f62919s = g.INITIALIZE;
        this.f62922v = obj;
        return this;
    }

    /* renamed from: z */
    public final void m84334z(String str, long j10) {
        m84309A(str, j10, null);
    }
}
