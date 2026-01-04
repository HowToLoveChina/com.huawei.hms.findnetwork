package p003a2;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import p630s2.C12676k;

/* renamed from: a2.i */
/* loaded from: classes.dex */
public final class C0014i implements InterfaceC0007b {

    /* renamed from: a */
    public final C0012g<a, Object> f7a = new C0012g<>();

    /* renamed from: b */
    public final b f8b = new b();

    /* renamed from: c */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f9c = new HashMap();

    /* renamed from: d */
    public final Map<Class<?>, InterfaceC0006a<?>> f10d = new HashMap();

    /* renamed from: e */
    public final int f11e;

    /* renamed from: f */
    public int f12f;

    /* renamed from: a2.i$a */
    public static final class a implements InterfaceC0017l {

        /* renamed from: a */
        public final b f13a;

        /* renamed from: b */
        public int f14b;

        /* renamed from: c */
        public Class<?> f15c;

        public a(b bVar) {
            this.f13a = bVar;
        }

        @Override // p003a2.InterfaceC0017l
        /* renamed from: a */
        public void mo43a() {
            this.f13a.m13c(this);
        }

        /* renamed from: b */
        public void m44b(int i10, Class<?> cls) {
            this.f14b = i10;
            this.f15c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f14b == aVar.f14b && this.f15c == aVar.f15c;
        }

        public int hashCode() {
            int i10 = this.f14b * 31;
            Class<?> cls = this.f15c;
            return i10 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f14b + "array=" + this.f15c + '}';
        }
    }

    /* renamed from: a2.i$b */
    public static final class b extends AbstractC0008c<a> {
        @Override // p003a2.AbstractC0008c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a mo11a() {
            return new a(this);
        }

        /* renamed from: e */
        public a m46e(int i10, Class<?> cls) {
            a aVarM12b = m12b();
            aVarM12b.m44b(i10, cls);
            return aVarM12b;
        }
    }

    public C0014i(int i10) {
        this.f11e = i10;
    }

    @Override // p003a2.InterfaceC0007b
    /* renamed from: a */
    public synchronized void mo8a(int i10) {
        try {
            if (i10 >= 40) {
                clearMemory();
            } else if (i10 >= 20 || i10 == 15) {
                m34f(this.f11e / 2);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // p003a2.InterfaceC0007b
    /* renamed from: b */
    public synchronized <T> T mo9b(int i10, Class<T> cls) {
        return (T) m38j(this.f8b.m46e(i10, cls), cls);
    }

    @Override // p003a2.InterfaceC0007b
    /* renamed from: c */
    public synchronized <T> T mo10c(int i10, Class<T> cls) {
        Integer numCeilingKey;
        try {
            numCeilingKey = m39k(cls).ceilingKey(Integer.valueOf(i10));
        } catch (Throwable th2) {
            throw th2;
        }
        return (T) m38j(m42n(i10, numCeilingKey) ? this.f8b.m46e(numCeilingKey.intValue(), cls) : this.f8b.m46e(i10, cls), cls);
    }

    @Override // p003a2.InterfaceC0007b
    public synchronized void clearMemory() {
        m34f(0);
    }

    /* renamed from: d */
    public final void m32d(int i10, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapM39k = m39k(cls);
        Integer num = navigableMapM39k.get(Integer.valueOf(i10));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapM39k.remove(Integer.valueOf(i10));
                return;
            } else {
                navigableMapM39k.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
    }

    /* renamed from: e */
    public final void m33e() {
        m34f(this.f11e);
    }

    /* renamed from: f */
    public final void m34f(int i10) {
        while (this.f12f > i10) {
            Object objM26f = this.f7a.m26f();
            C12676k.m76276d(objM26f);
            InterfaceC0006a interfaceC0006aM35g = m35g(objM26f);
            this.f12f -= interfaceC0006aM35g.mo7c(objM26f) * interfaceC0006aM35g.mo6b();
            m32d(interfaceC0006aM35g.mo7c(objM26f), objM26f.getClass());
            if (Log.isLoggable(interfaceC0006aM35g.mo5a(), 2)) {
                Log.v(interfaceC0006aM35g.mo5a(), "evicted: " + interfaceC0006aM35g.mo7c(objM26f));
            }
        }
    }

    /* renamed from: g */
    public final <T> InterfaceC0006a<T> m35g(T t10) {
        return m36h(t10.getClass());
    }

    /* renamed from: h */
    public final <T> InterfaceC0006a<T> m36h(Class<T> cls) {
        InterfaceC0006a<T> c0011f = (InterfaceC0006a) this.f10d.get(cls);
        if (c0011f == null) {
            if (cls.equals(int[].class)) {
                c0011f = new C0013h();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                c0011f = new C0011f();
            }
            this.f10d.put(cls, c0011f);
        }
        return c0011f;
    }

    /* renamed from: i */
    public final <T> T m37i(a aVar) {
        return (T) this.f7a.m22a(aVar);
    }

    /* renamed from: j */
    public final <T> T m38j(a aVar, Class<T> cls) {
        InterfaceC0006a<T> interfaceC0006aM36h = m36h(cls);
        T t10 = (T) m37i(aVar);
        if (t10 != null) {
            this.f12f -= interfaceC0006aM36h.mo7c(t10) * interfaceC0006aM36h.mo6b();
            m32d(interfaceC0006aM36h.mo7c(t10), cls);
        }
        if (t10 != null) {
            return t10;
        }
        if (Log.isLoggable(interfaceC0006aM36h.mo5a(), 2)) {
            Log.v(interfaceC0006aM36h.mo5a(), "Allocated " + aVar.f14b + " bytes");
        }
        return interfaceC0006aM36h.newArray(aVar.f14b);
    }

    /* renamed from: k */
    public final NavigableMap<Integer, Integer> m39k(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f9c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f9c.put(cls, treeMap);
        return treeMap;
    }

    /* renamed from: l */
    public final boolean m40l() {
        int i10 = this.f12f;
        return i10 == 0 || this.f11e / i10 >= 2;
    }

    /* renamed from: m */
    public final boolean m41m(int i10) {
        return i10 <= this.f11e / 2;
    }

    /* renamed from: n */
    public final boolean m42n(int i10, Integer num) {
        return num != null && (m40l() || num.intValue() <= i10 * 8);
    }

    @Override // p003a2.InterfaceC0007b
    public synchronized <T> void put(T t10) {
        Class<?> cls = t10.getClass();
        InterfaceC0006a<T> interfaceC0006aM36h = m36h(cls);
        int iMo7c = interfaceC0006aM36h.mo7c(t10);
        int iMo6b = interfaceC0006aM36h.mo6b() * iMo7c;
        if (m41m(iMo6b)) {
            a aVarM46e = this.f8b.m46e(iMo7c, cls);
            this.f7a.m25d(aVarM46e, t10);
            NavigableMap<Integer, Integer> navigableMapM39k = m39k(cls);
            Integer num = navigableMapM39k.get(Integer.valueOf(aVarM46e.f14b));
            Integer numValueOf = Integer.valueOf(aVarM46e.f14b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapM39k.put(numValueOf, Integer.valueOf(iIntValue));
            this.f12f += iMo6b;
            m33e();
        }
    }
}
