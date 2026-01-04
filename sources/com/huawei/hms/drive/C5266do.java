package com.huawei.hms.drive;

import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.huawei.hms.drive.do */
/* loaded from: classes8.dex */
class C5266do extends C5269dr {

    /* renamed from: a */
    private final Method f24478a;

    /* renamed from: b */
    private final Method f24479b;

    /* renamed from: c */
    private final Method f24480c;

    /* renamed from: d */
    private final Class<?> f24481d;

    /* renamed from: e */
    private final Class<?> f24482e;

    /* renamed from: com.huawei.hms.drive.do$a */
    public static class a implements InvocationHandler {

        /* renamed from: a */
        boolean f24483a;

        /* renamed from: b */
        String f24484b;

        /* renamed from: c */
        private final List<String> f24485c;

        public a(List<String> list) {
            this.f24485c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C5210bo.f23989b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f24483a = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f24485c;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        String str = (String) list.get(i10);
                        if (this.f24485c.contains(str)) {
                            this.f24484b = str;
                            return str;
                        }
                    }
                    String str2 = this.f24485c.get(0);
                    this.f24484b = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f24484b = (String) objArr[0];
            return null;
        }
    }

    public C5266do(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f24478a = method;
        this.f24479b = method2;
        this.f24480c = method3;
        this.f24481d = cls;
        this.f24482e = cls2;
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public void mo31648a(SSLSocket sSLSocket, String str, List<EnumC5199bd> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f24478a.invoke(null, sSLSocket, Proxy.newProxyInstance(C5269dr.class.getClassLoader(), new Class[]{this.f24481d, this.f24482e}, new a(C5269dr.m31688a(list))));
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: b */
    public void mo31678b(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f24480c.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public String mo31647a(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f24479b.invoke(null, sSLSocket));
            boolean z10 = aVar.f24483a;
            if (!z10 && aVar.f24484b == null) {
                C5269dr.m31692e().mo31656a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (z10) {
                return null;
            }
            return aVar.f24484b;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        }
    }

    /* renamed from: a */
    public static C5269dr m31677a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
            return new C5266do(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod(SyncProtocol.Constant.REMOVE, SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
