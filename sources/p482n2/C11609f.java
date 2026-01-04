package p482n2;

import java.util.ArrayList;
import java.util.List;
import p759x1.InterfaceC13687l;

/* renamed from: n2.f */
/* loaded from: classes.dex */
public class C11609f {

    /* renamed from: a */
    public final List<a<?>> f53905a = new ArrayList();

    /* renamed from: n2.f$a */
    public static final class a<T> {

        /* renamed from: a */
        public final Class<T> f53906a;

        /* renamed from: b */
        public final InterfaceC13687l<T> f53907b;

        public a(Class<T> cls, InterfaceC13687l<T> interfaceC13687l) {
            this.f53906a = cls;
            this.f53907b = interfaceC13687l;
        }

        /* renamed from: a */
        public boolean m69357a(Class<?> cls) {
            return this.f53906a.isAssignableFrom(cls);
        }
    }

    /* renamed from: a */
    public synchronized <Z> void m69355a(Class<Z> cls, InterfaceC13687l<Z> interfaceC13687l) {
        this.f53905a.add(new a<>(cls, interfaceC13687l));
    }

    /* renamed from: b */
    public synchronized <Z> InterfaceC13687l<Z> m69356b(Class<Z> cls) {
        int size = this.f53905a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a<?> aVar = this.f53905a.get(i10);
            if (aVar.m69357a(cls)) {
                return (InterfaceC13687l<Z>) aVar.f53907b;
            }
        }
        return null;
    }
}
