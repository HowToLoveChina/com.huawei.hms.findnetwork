package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.crypto.tink.shaded.protobuf.d1 */
/* loaded from: classes.dex */
public final class C1907d1 {

    /* renamed from: c */
    public static final C1907d1 f9111c = new C1907d1();

    /* renamed from: b */
    public final ConcurrentMap<Class<?>, InterfaceC1919h1<?>> f9113b = new ConcurrentHashMap();

    /* renamed from: a */
    public final InterfaceC1922i1 f9112a = new C1927k0();

    /* renamed from: a */
    public static C1907d1 m11516a() {
        return f9111c;
    }

    /* renamed from: b */
    public <T> void m11517b(T t10, InterfaceC1916g1 interfaceC1916g1, C1944q c1944q) throws IOException {
        m11520e(t10).mo11672f(t10, interfaceC1916g1, c1944q);
    }

    /* renamed from: c */
    public InterfaceC1919h1<?> m11518c(Class<?> cls, InterfaceC1919h1<?> interfaceC1919h1) {
        C1900b0.m11487b(cls, "messageType");
        C1900b0.m11487b(interfaceC1919h1, "schema");
        return this.f9113b.putIfAbsent(cls, interfaceC1919h1);
    }

    /* renamed from: d */
    public <T> InterfaceC1919h1<T> m11519d(Class<T> cls) {
        C1900b0.m11487b(cls, "messageType");
        InterfaceC1919h1<T> interfaceC1919h1 = (InterfaceC1919h1) this.f9113b.get(cls);
        if (interfaceC1919h1 != null) {
            return interfaceC1919h1;
        }
        InterfaceC1919h1<T> interfaceC1919h1Mo11718a = this.f9112a.mo11718a(cls);
        InterfaceC1919h1<T> interfaceC1919h12 = (InterfaceC1919h1<T>) m11518c(cls, interfaceC1919h1Mo11718a);
        return interfaceC1919h12 != null ? interfaceC1919h12 : interfaceC1919h1Mo11718a;
    }

    /* renamed from: e */
    public <T> InterfaceC1919h1<T> m11520e(T t10) {
        return m11519d(t10.getClass());
    }
}
