package p482n2;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p438l.C11207a;
import p630s2.C12675j;

/* renamed from: n2.d */
/* loaded from: classes.dex */
public class C11607d {

    /* renamed from: a */
    public final AtomicReference<C12675j> f53898a = new AtomicReference<>();

    /* renamed from: b */
    public final C11207a<C12675j, List<Class<?>>> f53899b = new C11207a<>();

    /* renamed from: a */
    public List<Class<?>> m69347a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        C12675j andSet = this.f53898a.getAndSet(null);
        if (andSet == null) {
            andSet = new C12675j(cls, cls2, cls3);
        } else {
            andSet.m76272a(cls, cls2, cls3);
        }
        synchronized (this.f53899b) {
            list = this.f53899b.get(andSet);
        }
        this.f53898a.set(andSet);
        return list;
    }

    /* renamed from: b */
    public void m69348b(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f53899b) {
            this.f53899b.put(new C12675j(cls, cls2, cls3), list);
        }
    }
}
