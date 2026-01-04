package p791xx;

import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.EnumC11914c0;
import sx.C12875e;

/* renamed from: xx.e */
/* loaded from: classes9.dex */
public class C13890e extends C13893h {

    /* renamed from: c */
    public final Method f62217c;

    /* renamed from: d */
    public final Method f62218d;

    /* renamed from: e */
    public final Method f62219e;

    /* renamed from: f */
    public final Class<?> f62220f;

    /* renamed from: g */
    public final Class<?> f62221g;

    /* renamed from: xx.e$a */
    public static class a implements InvocationHandler {

        /* renamed from: a */
        public final List<String> f62222a;

        /* renamed from: b */
        public boolean f62223b;

        /* renamed from: c */
        public String f62224c;

        public a(List<String> list) {
            this.f62222a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C12875e.f58641b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f62223b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f62222a;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        String str = (String) list.get(i10);
                        if (this.f62222a.contains(str)) {
                            this.f62224c = str;
                            return str;
                        }
                    }
                    String str2 = this.f62222a.get(0);
                    this.f62224c = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.f62224c = (String) objArr[0];
            return null;
        }
    }

    public C13890e(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f62217c = method;
        this.f62218d = method2;
        this.f62219e = method3;
        this.f62220f = cls;
        this.f62221g = cls2;
    }

    /* renamed from: u */
    public static C13893h m83276u() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
            return new C13890e(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod(SyncProtocol.Constant.REMOVE, SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: a */
    public void mo83277a(SSLSocket sSLSocket) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f62219e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: g */
    public void mo83244g(SSLSocket sSLSocket, String str, List<EnumC11914c0> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f62217c.invoke(null, sSLSocket, Proxy.newProxyInstance(C13893h.class.getClassLoader(), new Class[]{this.f62220f, this.f62221g}, new a(C13893h.m83286b(list))));
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: n */
    public String mo83245n(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f62218d.invoke(null, sSLSocket));
            boolean z10 = aVar.f62223b;
            if (!z10 && aVar.f62224c == null) {
                C13893h.m83291l().mo83257s(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z10) {
                return null;
            }
            return aVar.f62224c;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        }
    }
}
