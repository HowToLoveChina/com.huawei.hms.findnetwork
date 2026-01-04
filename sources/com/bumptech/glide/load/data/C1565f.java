package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.InterfaceC1564e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p630s2.C12676k;

/* renamed from: com.bumptech.glide.load.data.f */
/* loaded from: classes.dex */
public class C1565f {

    /* renamed from: b */
    public static final InterfaceC1564e.a<?> f6946b = new a();

    /* renamed from: a */
    public final Map<Class<?>, InterfaceC1564e.a<?>> f6947a = new HashMap();

    /* renamed from: com.bumptech.glide.load.data.f$a */
    public class a implements InterfaceC1564e.a<Object> {
        @Override // com.bumptech.glide.load.data.InterfaceC1564e.a
        /* renamed from: a */
        public Class<Object> mo9014a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1564e.a
        /* renamed from: b */
        public InterfaceC1564e<Object> mo9015b(Object obj) {
            return new b(obj);
        }
    }

    /* renamed from: com.bumptech.glide.load.data.f$b */
    public static final class b implements InterfaceC1564e<Object> {

        /* renamed from: a */
        public final Object f6948a;

        public b(Object obj) {
            this.f6948a = obj;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1564e
        /* renamed from: a */
        public Object mo9011a() {
            return this.f6948a;
        }

        @Override // com.bumptech.glide.load.data.InterfaceC1564e
        /* renamed from: b */
        public void mo9012b() {
        }
    }

    /* renamed from: a */
    public synchronized <T> InterfaceC1564e<T> m9032a(T t10) {
        InterfaceC1564e.a<?> aVar;
        try {
            C12676k.m76276d(t10);
            aVar = this.f6947a.get(t10.getClass());
            if (aVar == null) {
                Iterator<InterfaceC1564e.a<?>> it = this.f6947a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    InterfaceC1564e.a<?> next = it.next();
                    if (next.mo9014a().isAssignableFrom(t10.getClass())) {
                        aVar = next;
                        break;
                    }
                }
            }
            if (aVar == null) {
                aVar = f6946b;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return (InterfaceC1564e<T>) aVar.mo9015b(t10);
    }

    /* renamed from: b */
    public synchronized void m9033b(InterfaceC1564e.a<?> aVar) {
        this.f6947a.put(aVar.mo9014a(), aVar);
    }
}
