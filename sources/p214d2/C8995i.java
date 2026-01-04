package p214d2;

import com.bumptech.glide.C1552h;
import com.bumptech.glide.load.model.C1591h;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p243e0.InterfaceC9370e;

/* renamed from: d2.i */
/* loaded from: classes.dex */
public class C8995i {

    /* renamed from: a */
    public final C1591h f45610a;

    /* renamed from: b */
    public final a f45611b;

    /* renamed from: d2.i$a */
    public static class a {

        /* renamed from: a */
        public final Map<Class<?>, C14502a<?>> f45612a = new HashMap();

        /* renamed from: d2.i$a$a, reason: collision with other inner class name */
        public static class C14502a<Model> {

            /* renamed from: a */
            public final List<InterfaceC1589f<Model, ?>> f45613a;

            public C14502a(List<InterfaceC1589f<Model, ?>> list) {
                this.f45613a = list;
            }
        }

        /* renamed from: a */
        public void m56848a() {
            this.f45612a.clear();
        }

        /* renamed from: b */
        public <Model> List<InterfaceC1589f<Model, ?>> m56849b(Class<Model> cls) {
            C14502a<?> c14502a = this.f45612a.get(cls);
            if (c14502a == null) {
                return null;
            }
            return (List<InterfaceC1589f<Model, ?>>) c14502a.f45613a;
        }

        /* renamed from: c */
        public <Model> void m56850c(Class<Model> cls, List<InterfaceC1589f<Model, ?>> list) {
            if (this.f45612a.put(cls, new C14502a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public C8995i(InterfaceC9370e<List<Throwable>> interfaceC9370e) {
        this(new C1591h(interfaceC9370e));
    }

    /* renamed from: b */
    public static <A> Class<A> m56843b(A a10) {
        return (Class<A>) a10.getClass();
    }

    /* renamed from: a */
    public synchronized <Model, Data> void m56844a(Class<Model> cls, Class<Data> cls2, InterfaceC8994h<? extends Model, ? extends Data> interfaceC8994h) {
        this.f45610a.m9103b(cls, cls2, interfaceC8994h);
        this.f45611b.m56848a();
    }

    /* renamed from: c */
    public synchronized List<Class<?>> m56845c(Class<?> cls) {
        return this.f45610a.m9107g(cls);
    }

    /* renamed from: d */
    public <A> List<InterfaceC1589f<A, ?>> m56846d(A a10) {
        List<InterfaceC1589f<A, ?>> listM56847e = m56847e(m56843b(a10));
        if (listM56847e.isEmpty()) {
            throw new C1552h.c(a10);
        }
        int size = listM56847e.size();
        List<InterfaceC1589f<A, ?>> listEmptyList = Collections.emptyList();
        boolean z10 = true;
        for (int i10 = 0; i10 < size; i10++) {
            InterfaceC1589f<A, ?> interfaceC1589f = listM56847e.get(i10);
            if (interfaceC1589f.mo9070a(a10)) {
                if (z10) {
                    listEmptyList = new ArrayList<>(size - i10);
                    z10 = false;
                }
                listEmptyList.add(interfaceC1589f);
            }
        }
        if (listEmptyList.isEmpty()) {
            throw new C1552h.c(a10, listM56847e);
        }
        return listEmptyList;
    }

    /* renamed from: e */
    public final synchronized <A> List<InterfaceC1589f<A, ?>> m56847e(Class<A> cls) {
        List<InterfaceC1589f<A, ?>> listM56849b;
        listM56849b = this.f45611b.m56849b(cls);
        if (listM56849b == null) {
            listM56849b = Collections.unmodifiableList(this.f45610a.m9106e(cls));
            this.f45611b.m56850c(cls, listM56849b);
        }
        return listM56849b;
    }

    public C8995i(C1591h c1591h) {
        this.f45611b = new a();
        this.f45610a = c1591h;
    }
}
