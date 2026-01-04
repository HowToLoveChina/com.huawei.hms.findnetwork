package com.huawei.hms.network.embedded;

import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.huawei.hms.network.embedded.ja */
/* loaded from: classes8.dex */
public class C5974ja extends C6013ma {

    /* renamed from: e */
    public final Method f27139e;

    /* renamed from: f */
    public final Method f27140f;

    /* renamed from: g */
    public final Method f27141g;

    /* renamed from: h */
    public final Class<?> f27142h;

    /* renamed from: i */
    public final Class<?> f27143i;

    /* renamed from: com.huawei.hms.network.embedded.ja$a */
    public static class a implements InvocationHandler {

        /* renamed from: a */
        public final List<String> f27144a;

        /* renamed from: b */
        public boolean f27145b;

        /* renamed from: c */
        public String f27146c;

        public a(List<String> list) {
            this.f27144a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C5920f8.f26770b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f27145b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f27144a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        String str = (String) list.get(i10);
                        if (this.f27144a.contains(str)) {
                            this.f27146c = str;
                            return str;
                        }
                    }
                    String str2 = this.f27144a.get(0);
                    this.f27146c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f27146c = (String) objArr[0];
            return null;
        }
    }

    public C5974ja(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f27139e = method;
        this.f27140f = method2;
        this.f27141g = method3;
        this.f27142h = cls;
        this.f27143i = cls2;
    }

    /* renamed from: i */
    public static C6013ma m34550i() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
            return new C5974ja(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod(SyncProtocol.Constant.REMOVE, SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public void mo34551a(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f27141g.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: b */
    public String mo34272b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f27140f.invoke(null, sSLSocket));
            boolean z10 = aVar.f27145b;
            if (!z10 && aVar.f27146c == null) {
                C6013ma.m34863f().mo34331a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (z10) {
                return null;
            }
            return aVar.f27146c;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public void mo34271a(SSLSocket sSLSocket, String str, List<EnumC6075r7> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f27139e.invoke(null, sSLSocket, Proxy.newProxyInstance(C6013ma.class.getClassLoader(), new Class[]{this.f27142h, this.f27143i}, new a(C6013ma.m34858a(list))));
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        }
    }
}
