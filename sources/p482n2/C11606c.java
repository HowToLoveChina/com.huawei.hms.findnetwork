package p482n2;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import p438l.C11207a;
import p441l2.C11227f;
import p630s2.C12675j;
import p829z1.C14070i;
import p829z1.C14081t;

/* renamed from: n2.c */
/* loaded from: classes.dex */
public class C11606c {

    /* renamed from: c */
    public static final C14081t<?, ?, ?> f53895c = new C14081t<>(Object.class, Object.class, Object.class, Collections.singletonList(new C14070i(Object.class, Object.class, Object.class, Collections.emptyList(), new C11227f(), null)), null);

    /* renamed from: a */
    public final C11207a<C12675j, C14081t<?, ?, ?>> f53896a = new C11207a<>();

    /* renamed from: b */
    public final AtomicReference<C12675j> f53897b = new AtomicReference<>();

    /* renamed from: a */
    public <Data, TResource, Transcode> C14081t<Data, TResource, Transcode> m69343a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        C14081t<Data, TResource, Transcode> c14081t;
        C12675j c12675jM69344b = m69344b(cls, cls2, cls3);
        synchronized (this.f53896a) {
            c14081t = (C14081t) this.f53896a.get(c12675jM69344b);
        }
        this.f53897b.set(c12675jM69344b);
        return c14081t;
    }

    /* renamed from: b */
    public final C12675j m69344b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        C12675j andSet = this.f53897b.getAndSet(null);
        if (andSet == null) {
            andSet = new C12675j();
        }
        andSet.m76272a(cls, cls2, cls3);
        return andSet;
    }

    /* renamed from: c */
    public boolean m69345c(C14081t<?, ?, ?> c14081t) {
        return f53895c.equals(c14081t);
    }

    /* renamed from: d */
    public void m69346d(Class<?> cls, Class<?> cls2, Class<?> cls3, C14081t<?, ?, ?> c14081t) {
        synchronized (this.f53896a) {
            C11207a<C12675j, C14081t<?, ?, ?>> c11207a = this.f53896a;
            C12675j c12675j = new C12675j(cls, cls2, cls3);
            if (c14081t == null) {
                c14081t = f53895c;
            }
            c11207a.put(c12675j, c14081t);
        }
    }
}
