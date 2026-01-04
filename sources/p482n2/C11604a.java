package p482n2;

import java.util.ArrayList;
import java.util.List;
import p759x1.InterfaceC13679d;

/* renamed from: n2.a */
/* loaded from: classes.dex */
public class C11604a {

    /* renamed from: a */
    public final List<a<?>> f53891a = new ArrayList();

    /* renamed from: n2.a$a */
    public static final class a<T> {

        /* renamed from: a */
        public final Class<T> f53892a;

        /* renamed from: b */
        public final InterfaceC13679d<T> f53893b;

        public a(Class<T> cls, InterfaceC13679d<T> interfaceC13679d) {
            this.f53892a = cls;
            this.f53893b = interfaceC13679d;
        }

        /* renamed from: a */
        public boolean m69340a(Class<?> cls) {
            return this.f53892a.isAssignableFrom(cls);
        }
    }

    /* renamed from: a */
    public synchronized <T> void m69338a(Class<T> cls, InterfaceC13679d<T> interfaceC13679d) {
        this.f53891a.add(new a<>(cls, interfaceC13679d));
    }

    /* renamed from: b */
    public synchronized <T> InterfaceC13679d<T> m69339b(Class<T> cls) {
        for (a<?> aVar : this.f53891a) {
            if (aVar.m69340a(cls)) {
                return (InterfaceC13679d<T>) aVar.f53893b;
            }
        }
        return null;
    }
}
