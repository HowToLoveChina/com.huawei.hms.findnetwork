package com.huawei.openalliance.p169ad.net.http;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.InterfaceC7359kf;
import com.huawei.openalliance.p169ad.InterfaceC7365kl;
import com.huawei.openalliance.p169ad.InterfaceC7368ko;
import com.huawei.openalliance.p169ad.net.http.C7498a;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: com.huawei.openalliance.ad.net.http.e */
/* loaded from: classes2.dex */
public class C7502e {

    /* renamed from: a */
    final C7503f f34829a;

    /* renamed from: b */
    final int f34830b;

    /* renamed from: c */
    final int f34831c;

    /* renamed from: d */
    final InterfaceC7505h f34832d;

    /* renamed from: e */
    final InterfaceC7368ko f34833e;

    /* renamed from: f */
    final InterfaceC7368ko f34834f;

    /* renamed from: g */
    final boolean f34835g;

    /* renamed from: h */
    final Context f34836h;

    /* renamed from: i */
    final boolean f34837i;

    /* renamed from: j */
    final boolean f34838j;

    /* renamed from: com.huawei.openalliance.ad.net.http.e$a */
    public static class a {

        /* renamed from: a */
        Context f34841a;

        /* renamed from: b */
        C7503f f34842b;

        /* renamed from: e */
        InterfaceC7505h f34845e;

        /* renamed from: f */
        InterfaceC7368ko f34846f;

        /* renamed from: g */
        InterfaceC7368ko f34847g;

        /* renamed from: i */
        boolean f34849i;

        /* renamed from: k */
        boolean f34851k;

        /* renamed from: c */
        int f34843c = 10000;

        /* renamed from: d */
        int f34844d = 10000;

        /* renamed from: h */
        int f34848h = 1;

        /* renamed from: j */
        boolean f34850j = true;

        public a(Context context) {
            this.f34841a = context.getApplicationContext();
        }

        /* renamed from: a */
        public a m46060a(int i10) {
            this.f34843c = i10;
            return this;
        }

        /* renamed from: b */
        public a m46064b(int i10) {
            this.f34844d = i10;
            return this;
        }

        /* renamed from: c */
        public a m46067c(int i10) {
            this.f34848h = i10;
            return this;
        }

        /* renamed from: a */
        public a m46061a(InterfaceC7368ko interfaceC7368ko) {
            this.f34846f = interfaceC7368ko;
            return this;
        }

        /* renamed from: b */
        public a m46065b(InterfaceC7368ko interfaceC7368ko) {
            this.f34847g = interfaceC7368ko;
            return this;
        }

        /* renamed from: c */
        public a m46068c(boolean z10) {
            this.f34851k = z10;
            return this;
        }

        /* renamed from: a */
        public a m46062a(boolean z10) {
            this.f34849i = z10;
            return this;
        }

        /* renamed from: b */
        public a m46066b(boolean z10) {
            this.f34850j = z10;
            return this;
        }

        /* renamed from: a */
        public C7502e m46063a() {
            return new C7502e(this);
        }
    }

    public C7502e(a aVar) {
        this.f34829a = aVar.f34842b;
        this.f34830b = aVar.f34843c;
        this.f34831c = aVar.f34844d;
        InterfaceC7505h interfaceC7505h = aVar.f34845e;
        this.f34832d = interfaceC7505h == null ? HttpCallerFactory.m45961a(aVar.f34841a, aVar.f34848h) : interfaceC7505h;
        this.f34833e = aVar.f34846f;
        this.f34834f = aVar.f34847g;
        this.f34835g = aVar.f34849i;
        this.f34836h = aVar.f34841a;
        this.f34837i = aVar.f34850j;
        this.f34838j = aVar.f34851k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public <T> InterfaceC7365kl m46055b(Class<T> cls) {
        return (InterfaceC7365kl) cls.getAnnotation(InterfaceC7365kl.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public <T> C7500c m46057c(Class<T> cls) {
        return m46058a((InterfaceC7359kf) cls.getAnnotation(InterfaceC7359kf.class));
    }

    /* renamed from: a */
    public C7500c m46058a(InterfaceC7359kf interfaceC7359kf) {
        C7500c c7500c = new C7500c();
        if (interfaceC7359kf != null) {
            for (String str : interfaceC7359kf.m45447a()) {
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length >= 2) {
                    c7500c.m46051a(strArrSplit[0].trim(), strArrSplit[1].trim());
                }
            }
        }
        return c7500c;
    }

    /* renamed from: a */
    public <T> T m46059a(final Class<T> cls) {
        if (cls == null) {
            throw new NullPointerException("service class cannot be null");
        }
        if (cls.isInterface()) {
            return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.huawei.openalliance.ad.net.http.e.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws UnsupportedEncodingException {
                    if (method.getDeclaringClass() == Object.class) {
                        return method.invoke(this, objArr);
                    }
                    InterfaceC7365kl interfaceC7365klM46055b = C7502e.this.m46055b(cls);
                    C7498a c7498aM46042a = new C7498a.a(C7502e.this, method, objArr, C7502e.this.m46057c(cls), interfaceC7365klM46055b).m46042a();
                    Response response = new Response();
                    try {
                        C7502e c7502e = C7502e.this;
                        response = c7502e.f34832d.mo45976b(c7502e, c7498aM46042a);
                    } catch (IllegalStateException | Exception e10) {
                        response.m45985a(e10);
                    }
                    AbstractC7185ho.m43821b("HttpCall", "response http code: %d", Integer.valueOf(response.m45977a()));
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("HttpCall", "response exception: %s", response.m45995d());
                    }
                    return response;
                }
            });
        }
        throw new IllegalArgumentException("Service must be interface.");
    }
}
