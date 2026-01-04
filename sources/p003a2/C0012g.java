package p003a2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p003a2.InterfaceC0017l;

/* renamed from: a2.g */
/* loaded from: classes.dex */
public class C0012g<K extends InterfaceC0017l, V> {

    /* renamed from: a */
    public final a<K, V> f1a = new a<>();

    /* renamed from: b */
    public final Map<K, a<K, V>> f2b = new HashMap();

    /* renamed from: e */
    public static <K, V> void m20e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f6d;
        aVar2.f5c = aVar.f5c;
        aVar.f5c.f6d = aVar2;
    }

    /* renamed from: g */
    public static <K, V> void m21g(a<K, V> aVar) {
        aVar.f5c.f6d = aVar;
        aVar.f6d.f5c = aVar;
    }

    /* renamed from: a */
    public V m22a(K k10) {
        a<K, V> aVar = this.f2b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            this.f2b.put(k10, aVar);
        } else {
            k10.mo43a();
        }
        m23b(aVar);
        return aVar.m28b();
    }

    /* renamed from: b */
    public final void m23b(a<K, V> aVar) {
        m20e(aVar);
        a<K, V> aVar2 = this.f1a;
        aVar.f6d = aVar2;
        aVar.f5c = aVar2.f5c;
        m21g(aVar);
    }

    /* renamed from: c */
    public final void m24c(a<K, V> aVar) {
        m20e(aVar);
        a<K, V> aVar2 = this.f1a;
        aVar.f6d = aVar2.f6d;
        aVar.f5c = aVar2;
        m21g(aVar);
    }

    /* renamed from: d */
    public void m25d(K k10, V v10) {
        a<K, V> aVar = this.f2b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            m24c(aVar);
            this.f2b.put(k10, aVar);
        } else {
            k10.mo43a();
        }
        aVar.m27a(v10);
    }

    /* renamed from: f */
    public V m26f() {
        for (a aVar = this.f1a.f6d; !aVar.equals(this.f1a); aVar = aVar.f6d) {
            V v10 = (V) aVar.m28b();
            if (v10 != null) {
                return v10;
            }
            m20e(aVar);
            this.f2b.remove(aVar.f3a);
            ((InterfaceC0017l) aVar.f3a).mo43a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f1a.f5c;
        boolean z10 = false;
        while (!aVar.equals(this.f1a)) {
            sb2.append('{');
            sb2.append(aVar.f3a);
            sb2.append(':');
            sb2.append(aVar.m29c());
            sb2.append("}, ");
            aVar = aVar.f5c;
            z10 = true;
        }
        if (z10) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        sb2.append(" )");
        return sb2.toString();
    }

    /* renamed from: a2.g$a */
    public static class a<K, V> {

        /* renamed from: a */
        public final K f3a;

        /* renamed from: b */
        public List<V> f4b;

        /* renamed from: c */
        public a<K, V> f5c;

        /* renamed from: d */
        public a<K, V> f6d;

        public a() {
            this(null);
        }

        /* renamed from: a */
        public void m27a(V v10) {
            if (this.f4b == null) {
                this.f4b = new ArrayList();
            }
            this.f4b.add(v10);
        }

        /* renamed from: b */
        public V m28b() {
            int iM29c = m29c();
            if (iM29c > 0) {
                return this.f4b.remove(iM29c - 1);
            }
            return null;
        }

        /* renamed from: c */
        public int m29c() {
            List<V> list = this.f4b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(K k10) {
            this.f6d = this;
            this.f5c = this;
            this.f3a = k10;
        }
    }
}
