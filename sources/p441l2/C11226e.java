package p441l2;

import java.util.ArrayList;
import java.util.List;

/* renamed from: l2.e */
/* loaded from: classes.dex */
public class C11226e {

    /* renamed from: a */
    public final List<a<?, ?>> f52714a = new ArrayList();

    /* renamed from: l2.e$a */
    public static final class a<Z, R> {

        /* renamed from: a */
        public final Class<Z> f52715a;

        /* renamed from: b */
        public final Class<R> f52716b;

        /* renamed from: c */
        public final InterfaceC11225d<Z, R> f52717c;

        public a(Class<Z> cls, Class<R> cls2, InterfaceC11225d<Z, R> interfaceC11225d) {
            this.f52715a = cls;
            this.f52716b = cls2;
            this.f52717c = interfaceC11225d;
        }

        /* renamed from: a */
        public boolean m67419a(Class<?> cls, Class<?> cls2) {
            return this.f52715a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f52716b);
        }
    }

    /* renamed from: a */
    public synchronized <Z, R> InterfaceC11225d<Z, R> m67416a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return C11227f.m67420b();
        }
        for (a<?, ?> aVar : this.f52714a) {
            if (aVar.m67419a(cls, cls2)) {
                return (InterfaceC11225d<Z, R>) aVar.f52717c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    /* renamed from: b */
    public synchronized <Z, R> List<Class<R>> m67417b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.f52714a) {
            if (aVar.m67419a(cls, cls2) && !arrayList.contains(aVar.f52716b)) {
                arrayList.add(aVar.f52716b);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public synchronized <Z, R> void m67418c(Class<Z> cls, Class<R> cls2, InterfaceC11225d<Z, R> interfaceC11225d) {
        this.f52714a.add(new a<>(cls, cls2, interfaceC11225d));
    }
}
