package p631s3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import p631s3.C12693p;
import p831z3.C14090a0;
import p831z3.C14094c0;
import p831z3.C14125y;
import p831z3.EnumC14126z;

/* renamed from: s3.r */
/* loaded from: classes.dex */
public final class C12695r {

    /* renamed from: a */
    public static final Logger f58222a = Logger.getLogger(C12695r.class.getName());

    /* renamed from: b */
    public static final ConcurrentMap<String, d> f58223b = new ConcurrentHashMap();

    /* renamed from: c */
    public static final ConcurrentMap<String, c> f58224c = new ConcurrentHashMap();

    /* renamed from: d */
    public static final ConcurrentMap<String, Boolean> f58225d = new ConcurrentHashMap();

    /* renamed from: e */
    public static final ConcurrentMap<String, Object> f58226e = new ConcurrentHashMap();

    /* renamed from: f */
    public static final ConcurrentMap<Class<?>, InterfaceC12694q<?, ?>> f58227f = new ConcurrentHashMap();

    /* renamed from: s3.r$a */
    public class a implements d {

        /* renamed from: a */
        public final /* synthetic */ AbstractC12685h f58228a;

        public a(AbstractC12685h abstractC12685h) {
            this.f58228a = abstractC12685h;
        }

        @Override // p631s3.C12695r.d
        /* renamed from: a */
        public <Q> InterfaceC12682e<Q> mo76392a(Class<Q> cls) throws GeneralSecurityException {
            try {
                return new C12683f(this.f58228a, cls);
            } catch (IllegalArgumentException e10) {
                throw new GeneralSecurityException("Primitive type not supported", e10);
            }
        }

        @Override // p631s3.C12695r.d
        /* renamed from: b */
        public InterfaceC12682e<?> mo76393b() {
            AbstractC12685h abstractC12685h = this.f58228a;
            return new C12683f(abstractC12685h, abstractC12685h.m76315a());
        }

        @Override // p631s3.C12695r.d
        /* renamed from: c */
        public Class<?> mo76394c() {
            return this.f58228a.getClass();
        }

        @Override // p631s3.C12695r.d
        /* renamed from: d */
        public Set<Class<?>> mo76395d() {
            return this.f58228a.m76322h();
        }
    }

    /* renamed from: s3.r$b */
    public class b implements c {

        /* renamed from: a */
        public final /* synthetic */ AbstractC12685h f58229a;

        public b(AbstractC12685h abstractC12685h) {
            this.f58229a = abstractC12685h;
        }
    }

    /* renamed from: s3.r$c */
    public interface c {
    }

    /* renamed from: s3.r$d */
    public interface d {
        /* renamed from: a */
        <P> InterfaceC12682e<P> mo76392a(Class<P> cls) throws GeneralSecurityException;

        /* renamed from: b */
        InterfaceC12682e<?> mo76393b();

        /* renamed from: c */
        Class<?> mo76394c();

        /* renamed from: d */
        Set<Class<?>> mo76395d();
    }

    /* renamed from: a */
    public static <T> T m76372a(T t10) {
        t10.getClass();
        return t10;
    }

    /* renamed from: b */
    public static <KeyProtoT extends InterfaceC1951s0> d m76373b(AbstractC12685h<KeyProtoT> abstractC12685h) {
        return new a(abstractC12685h);
    }

    /* renamed from: c */
    public static <KeyProtoT extends InterfaceC1951s0> c m76374c(AbstractC12685h<KeyProtoT> abstractC12685h) {
        return new b(abstractC12685h);
    }

    /* renamed from: d */
    public static synchronized void m76375d(String str, Class<?> cls, boolean z10) throws GeneralSecurityException {
        ConcurrentMap<String, d> concurrentMap = f58223b;
        if (concurrentMap.containsKey(str)) {
            d dVar = concurrentMap.get(str);
            if (!dVar.mo76394c().equals(cls)) {
                f58222a.warning("Attempted overwrite of a registered key manager for key type " + str);
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, dVar.mo76394c().getName(), cls.getName()));
            }
            if (z10 && !f58225d.get(str).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type " + str);
            }
        }
    }

    /* renamed from: e */
    public static Class<?> m76376e(Class<?> cls) {
        InterfaceC12694q<?, ?> interfaceC12694q = f58227f.get(cls);
        if (interfaceC12694q == null) {
            return null;
        }
        return interfaceC12694q.mo76369a();
    }

    /* renamed from: f */
    public static synchronized d m76377f(String str) throws GeneralSecurityException {
        ConcurrentMap<String, d> concurrentMap;
        concurrentMap = f58223b;
        if (!concurrentMap.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return concurrentMap.get(str);
    }

    /* renamed from: g */
    public static <P> InterfaceC12682e<P> m76378g(String str, Class<P> cls) throws GeneralSecurityException {
        d dVarM76377f = m76377f(str);
        if (cls == null) {
            return (InterfaceC12682e<P>) dVarM76377f.mo76393b();
        }
        if (dVarM76377f.mo76395d().contains(cls)) {
            return dVarM76377f.mo76392a(cls);
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + dVarM76377f.mo76394c() + ", supported primitives: " + m76390s(dVarM76377f.mo76395d()));
    }

    /* renamed from: h */
    public static <P> P m76379h(String str, AbstractC1920i abstractC1920i, Class<P> cls) throws GeneralSecurityException {
        return (P) m76381j(str, abstractC1920i, (Class) m76372a(cls));
    }

    /* renamed from: i */
    public static <P> P m76380i(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) m76379h(str, AbstractC1920i.m11682f(bArr), cls);
    }

    /* renamed from: j */
    public static <P> P m76381j(String str, AbstractC1920i abstractC1920i, Class<P> cls) throws GeneralSecurityException {
        return (P) m76378g(str, cls).mo76306d(abstractC1920i);
    }

    /* renamed from: k */
    public static <P> C12693p<P> m76382k(C12686i c12686i, Class<P> cls) throws GeneralSecurityException {
        return m76383l(c12686i, null, cls);
    }

    /* renamed from: l */
    public static <P> C12693p<P> m76383l(C12686i c12686i, InterfaceC12682e<P> interfaceC12682e, Class<P> cls) throws GeneralSecurityException {
        return m76384m(c12686i, interfaceC12682e, (Class) m76372a(cls));
    }

    /* renamed from: m */
    public static <P> C12693p<P> m76384m(C12686i c12686i, InterfaceC12682e<P> interfaceC12682e, Class<P> cls) throws GeneralSecurityException {
        C12696s.m76399d(c12686i.m76336f());
        C12693p<P> c12693pM76357f = C12693p.m76357f(cls);
        for (C14094c0.c cVar : c12686i.m76336f().m84480T()) {
            if (cVar.m84498U() == EnumC14126z.ENABLED) {
                C12693p.b<P> bVarM76358a = c12693pM76357f.m76358a((interfaceC12682e == null || !interfaceC12682e.mo76303a(cVar.m84495R().m84752S())) ? (P) m76381j(cVar.m84495R().m84752S(), cVar.m84495R().m84753T(), cls) : interfaceC12682e.mo76306d(cVar.m84495R().m84753T()), cVar);
                if (cVar.m84496S() == c12686i.m76336f().m84481U()) {
                    c12693pM76357f.m76363g(bVarM76358a);
                }
            }
        }
        return c12693pM76357f;
    }

    /* renamed from: n */
    public static InterfaceC12682e<?> m76385n(String str) throws GeneralSecurityException {
        return m76377f(str).mo76393b();
    }

    /* renamed from: o */
    public static synchronized InterfaceC1951s0 m76386o(C14090a0 c14090a0) throws GeneralSecurityException {
        InterfaceC12682e<?> interfaceC12682eM76385n;
        interfaceC12682eM76385n = m76385n(c14090a0.m84457S());
        if (!f58225d.get(c14090a0.m84457S()).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + c14090a0.m84457S());
        }
        return interfaceC12682eM76385n.mo76304b(c14090a0.m84458T());
    }

    /* renamed from: p */
    public static synchronized C14125y m76387p(C14090a0 c14090a0) throws GeneralSecurityException {
        InterfaceC12682e<?> interfaceC12682eM76385n;
        interfaceC12682eM76385n = m76385n(c14090a0.m84457S());
        if (!f58225d.get(c14090a0.m84457S()).booleanValue()) {
            throw new GeneralSecurityException("newKey-operation not permitted for key type " + c14090a0.m84457S());
        }
        return interfaceC12682eM76385n.mo76305c(c14090a0.m84458T());
    }

    /* renamed from: q */
    public static synchronized <KeyProtoT extends InterfaceC1951s0> void m76388q(AbstractC12685h<KeyProtoT> abstractC12685h, boolean z10) throws GeneralSecurityException {
        try {
            if (abstractC12685h == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            String strMo76317c = abstractC12685h.mo76317c();
            m76375d(strMo76317c, abstractC12685h.getClass(), z10);
            ConcurrentMap<String, d> concurrentMap = f58223b;
            if (!concurrentMap.containsKey(strMo76317c)) {
                concurrentMap.put(strMo76317c, m76373b(abstractC12685h));
                f58224c.put(strMo76317c, m76374c(abstractC12685h));
            }
            f58225d.put(strMo76317c, Boolean.valueOf(z10));
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: r */
    public static synchronized <B, P> void m76389r(InterfaceC12694q<B, P> interfaceC12694q) throws GeneralSecurityException {
        try {
            if (interfaceC12694q == null) {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
            Class<P> clsMo76370b = interfaceC12694q.mo76370b();
            ConcurrentMap<Class<?>, InterfaceC12694q<?, ?>> concurrentMap = f58227f;
            if (concurrentMap.containsKey(clsMo76370b)) {
                InterfaceC12694q<?, ?> interfaceC12694q2 = concurrentMap.get(clsMo76370b);
                if (!interfaceC12694q.getClass().equals(interfaceC12694q2.getClass())) {
                    f58222a.warning("Attempted overwrite of a registered SetWrapper for type " + clsMo76370b);
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", clsMo76370b.getName(), interfaceC12694q2.getClass().getName(), interfaceC12694q.getClass().getName()));
                }
            }
            concurrentMap.put(clsMo76370b, interfaceC12694q);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: s */
    public static String m76390s(Set<Class<?>> set) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (Class<?> cls : set) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(cls.getCanonicalName());
            z10 = false;
        }
        return sb2.toString();
    }

    /* renamed from: t */
    public static <B, P> P m76391t(C12693p<B> c12693p, Class<P> cls) throws GeneralSecurityException {
        InterfaceC12694q<?, ?> interfaceC12694q = f58227f.get(cls);
        if (interfaceC12694q == null) {
            throw new GeneralSecurityException("No wrapper found for " + c12693p.m76361d().getName());
        }
        if (interfaceC12694q.mo76369a().equals(c12693p.m76361d())) {
            return (P) interfaceC12694q.mo76371c(c12693p);
        }
        throw new GeneralSecurityException("Wrong input primitive class, expected " + interfaceC12694q.mo76369a() + ", got " + c12693p.m76361d());
    }
}
