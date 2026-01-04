package com.bumptech.glide.load.model;

import com.bumptech.glide.C1552h;
import com.bumptech.glide.load.model.InterfaceC1589f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p214d2.InterfaceC8994h;
import p243e0.InterfaceC9370e;
import p630s2.C12676k;
import p759x1.C13684i;

/* renamed from: com.bumptech.glide.load.model.h */
/* loaded from: classes.dex */
public class C1591h {

    /* renamed from: e */
    public static final c f7033e = new c();

    /* renamed from: f */
    public static final InterfaceC1589f<Object, Object> f7034f = new a();

    /* renamed from: a */
    public final List<b<?, ?>> f7035a;

    /* renamed from: b */
    public final c f7036b;

    /* renamed from: c */
    public final Set<b<?, ?>> f7037c;

    /* renamed from: d */
    public final InterfaceC9370e<List<Throwable>> f7038d;

    /* renamed from: com.bumptech.glide.load.model.h$a */
    public static class a implements InterfaceC1589f<Object, Object> {
        @Override // com.bumptech.glide.load.model.InterfaceC1589f
        /* renamed from: a */
        public boolean mo9070a(Object obj) {
            return false;
        }

        @Override // com.bumptech.glide.load.model.InterfaceC1589f
        /* renamed from: b */
        public InterfaceC1589f.a<Object> mo9071b(Object obj, int i10, int i11, C13684i c13684i) {
            return null;
        }
    }

    /* renamed from: com.bumptech.glide.load.model.h$b */
    public static class b<Model, Data> {

        /* renamed from: a */
        public final Class<Model> f7039a;

        /* renamed from: b */
        public final Class<Data> f7040b;

        /* renamed from: c */
        public final InterfaceC8994h<? extends Model, ? extends Data> f7041c;

        public b(Class<Model> cls, Class<Data> cls2, InterfaceC8994h<? extends Model, ? extends Data> interfaceC8994h) {
            this.f7039a = cls;
            this.f7040b = cls2;
            this.f7041c = interfaceC8994h;
        }

        /* renamed from: a */
        public boolean m9108a(Class<?> cls) {
            return this.f7039a.isAssignableFrom(cls);
        }

        /* renamed from: b */
        public boolean m9109b(Class<?> cls, Class<?> cls2) {
            return m9108a(cls) && this.f7040b.isAssignableFrom(cls2);
        }
    }

    /* renamed from: com.bumptech.glide.load.model.h$c */
    public static class c {
        /* renamed from: a */
        public <Model, Data> C1590g<Model, Data> m9110a(List<InterfaceC1589f<Model, Data>> list, InterfaceC9370e<List<Throwable>> interfaceC9370e) {
            return new C1590g<>(list, interfaceC9370e);
        }
    }

    public C1591h(InterfaceC9370e<List<Throwable>> interfaceC9370e) {
        this(interfaceC9370e, f7033e);
    }

    /* renamed from: f */
    public static <Model, Data> InterfaceC1589f<Model, Data> m9101f() {
        return (InterfaceC1589f<Model, Data>) f7034f;
    }

    /* renamed from: a */
    public final <Model, Data> void m9102a(Class<Model> cls, Class<Data> cls2, InterfaceC8994h<? extends Model, ? extends Data> interfaceC8994h, boolean z10) {
        b<?, ?> bVar = new b<>(cls, cls2, interfaceC8994h);
        List<b<?, ?>> list = this.f7035a;
        list.add(z10 ? list.size() : 0, bVar);
    }

    /* renamed from: b */
    public synchronized <Model, Data> void m9103b(Class<Model> cls, Class<Data> cls2, InterfaceC8994h<? extends Model, ? extends Data> interfaceC8994h) {
        m9102a(cls, cls2, interfaceC8994h, true);
    }

    /* renamed from: c */
    public final <Model, Data> InterfaceC1589f<Model, Data> m9104c(b<?, ?> bVar) {
        return (InterfaceC1589f) C12676k.m76276d(bVar.f7041c.mo9074b(this));
    }

    /* renamed from: d */
    public synchronized <Model, Data> InterfaceC1589f<Model, Data> m9105d(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (b<?, ?> bVar : this.f7035a) {
                if (this.f7037c.contains(bVar)) {
                    z10 = true;
                } else if (bVar.m9109b(cls, cls2)) {
                    this.f7037c.add(bVar);
                    arrayList.add(m9104c(bVar));
                    this.f7037c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f7036b.m9110a(arrayList, this.f7038d);
            }
            if (arrayList.size() == 1) {
                return (InterfaceC1589f) arrayList.get(0);
            }
            if (!z10) {
                throw new C1552h.c((Class<?>) cls, (Class<?>) cls2);
            }
            return m9101f();
        } catch (Throwable th2) {
            this.f7037c.clear();
            throw th2;
        }
    }

    /* renamed from: e */
    public synchronized <Model> List<InterfaceC1589f<Model, ?>> m9106e(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f7035a) {
                if (!this.f7037c.contains(bVar) && bVar.m9108a(cls)) {
                    this.f7037c.add(bVar);
                    arrayList.add(m9104c(bVar));
                    this.f7037c.remove(bVar);
                }
            }
        } catch (Throwable th2) {
            this.f7037c.clear();
            throw th2;
        }
        return arrayList;
    }

    /* renamed from: g */
    public synchronized List<Class<?>> m9107g(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f7035a) {
            if (!arrayList.contains(bVar.f7040b) && bVar.m9108a(cls)) {
                arrayList.add(bVar.f7040b);
            }
        }
        return arrayList;
    }

    public C1591h(InterfaceC9370e<List<Throwable>> interfaceC9370e, c cVar) {
        this.f7035a = new ArrayList();
        this.f7037c = new HashSet();
        this.f7038d = interfaceC9370e;
        this.f7036b = cVar;
    }
}
