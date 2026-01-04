package com.huawei.hms.network.embedded;

import android.os.Build;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.network.embedded.ga */
/* loaded from: classes8.dex */
public class C5935ga extends C6013ma {

    /* renamed from: k */
    public static final int f26874k = 4000;

    /* renamed from: e */
    public final Class<?> f26875e;

    /* renamed from: f */
    public final C6000la<Socket> f26876f;

    /* renamed from: g */
    public final C6000la<Socket> f26877g;

    /* renamed from: h */
    public final C6000la<Socket> f26878h;

    /* renamed from: i */
    public final C6000la<Socket> f26879i;

    /* renamed from: j */
    public final c f26880j = c.m34340a();

    /* renamed from: com.huawei.hms.network.embedded.ga$a */
    public static final class a extends AbstractC6065qa {

        /* renamed from: a */
        public final Object f26881a;

        /* renamed from: b */
        public final Method f26882b;

        public a(Object obj, Method method) {
            this.f26881a = obj;
            this.f26882b = method;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6065qa
        /* renamed from: a */
        public List<Certificate> mo34338a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f26882b.invoke(this.f26881a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InvocationTargetException e11) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e11.getMessage());
                sSLPeerUnverifiedException.initCause(e11);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ga$b */
    public static final class b implements InterfaceC6104ta {

        /* renamed from: a */
        public final X509TrustManager f26883a;

        /* renamed from: b */
        public final Method f26884b;

        public b(X509TrustManager x509TrustManager, Method method) {
            this.f26884b = method;
            this.f26883a = x509TrustManager;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6104ta
        /* renamed from: a */
        public X509Certificate mo34339a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f26884b.invoke(this.f26883a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e10) {
                throw new AssertionError("unable to get issues and signature", e10);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f26883a.equals(bVar.f26883a) && this.f26884b.equals(bVar.f26884b);
        }

        public int hashCode() {
            return this.f26883a.hashCode() + (this.f26884b.hashCode() * 31);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ga$c */
    public static final class c {

        /* renamed from: a */
        public final Method f26885a;

        /* renamed from: b */
        public final Method f26886b;

        /* renamed from: c */
        public final Method f26887c;

        public c(Method method, Method method2, Method method3) {
            this.f26885a = method;
            this.f26886b = method2;
            this.f26887c = method3;
        }

        /* renamed from: a */
        public static c m34340a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod(JsbMapKeyNames.H5_TEXT_DOWNLOAD_OPEN, String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new c(method, method3, method2);
        }

        /* renamed from: a */
        public Object m34341a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f26885a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.f26886b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: a */
        public boolean m34342a(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj != null) {
                try {
                    this.f26887c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
    }

    public C5935ga(Class<?> cls, C6000la<Socket> c6000la, C6000la<Socket> c6000la2, C6000la<Socket> c6000la3, C6000la<Socket> c6000la4) {
        this.f26875e = cls;
        this.f26876f = c6000la;
        this.f26877g = c6000la2;
        this.f26878h = c6000la3;
        this.f26879i = c6000la4;
    }

    /* renamed from: i */
    public static C6013ma m34326i() {
        Class<?> cls;
        C6000la c6000la;
        C6000la c6000la2;
        if (m34327j() == 0 || m34327j() >= 21) {
            return null;
        }
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            C6000la c6000la3 = new C6000la(null, "setUseSessionTickets", Boolean.TYPE);
            C6000la c6000la4 = new C6000la(null, "setHostname", String.class);
            if (m34328k()) {
                C6000la c6000la5 = new C6000la(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                c6000la2 = new C6000la(null, "setAlpnProtocols", byte[].class);
                c6000la = c6000la5;
            } else {
                c6000la = null;
                c6000la2 = null;
            }
            return new C5935ga(cls2, c6000la3, c6000la4, c6000la, c6000la2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    /* renamed from: j */
    public static int m34327j() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    /* renamed from: k */
    public static boolean m34328k() throws ClassNotFoundException {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public AbstractC6065qa mo34329a(X509TrustManager x509TrustManager) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.mo34329a(x509TrustManager);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: b */
    public InterfaceC6104ta mo34334b(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo34334b(x509TrustManager);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: c */
    public X509TrustManager mo34337c(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object objM34857a = C6013ma.m34857a(sSLSocketFactory, this.f26875e, "sslParameters");
        if (objM34857a == null) {
            try {
                objM34857a = C6013ma.m34857a(sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException unused) {
                return super.mo34337c(sSLSocketFactory);
            }
        }
        X509TrustManager x509TrustManager = (X509TrustManager) C6013ma.m34857a(objM34857a, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) C6013ma.m34857a(objM34857a, X509TrustManager.class, "trustManager");
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public Object mo34330a(String str) {
        return this.f26880j.m34341a(str);
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: b */
    public String mo34272b(SSLSocket sSLSocket) {
        byte[] bArr;
        C6000la<Socket> c6000la = this.f26878h;
        if (c6000la == null || !c6000la.m34716a((C6000la<Socket>) sSLSocket) || (bArr = (byte[]) this.f26878h.m34719d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Charset.forName(Constants.UTF_8));
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public void mo34331a(int i10, String str, Throwable th2) {
        int iMin;
        int i11 = i10 != 5 ? 3 : 5;
        if (th2 != null) {
            str = str + '\n' + Log.getStackTraceString(C5907e8.m34132a(th2));
        }
        int length = str.length();
        int i12 = 0;
        while (i12 < length) {
            int iIndexOf = str.indexOf(10, i12);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i12 + 4000);
                Log.println(i11, "OkHttp", str.substring(i12, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i12 = iMin;
                }
            }
            i12 = iMin + 1;
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: b */
    public SSLContext mo34335b() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("No TLS provider", e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public void mo34332a(String str, Object obj) {
        if (this.f26880j.m34342a(obj)) {
            return;
        }
        mo34331a(5, str, (Throwable) null);
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: b */
    public boolean mo34336b(String str) throws ClassNotFoundException {
        try {
            try {
                Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
                return m34325b(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                return super.mo34336b(str);
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
            throw new AssertionError("unable to determine cleartext support", e10);
        }
    }

    /* renamed from: b */
    private boolean m34325b(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return this.m34324a(str, cls, obj);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public void mo34333a(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        try {
            socket.connect(inetSocketAddress, i10);
        } catch (AssertionError e10) {
            if (!C5920f8.m34254a(e10)) {
                throw e10;
            }
            throw new IOException(e10);
        } catch (ClassCastException e11) {
            throw e11;
        } catch (SecurityException e12) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e12);
            throw iOException;
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public void mo34271a(SSLSocket sSLSocket, String str, List<EnumC6075r7> list) {
        if (str != null) {
            this.f26876f.m34718c(sSLSocket, Boolean.TRUE);
            this.f26877g.m34718c(sSLSocket, str);
        }
        C6000la<Socket> c6000la = this.f26879i;
        if (c6000la == null || !c6000la.m34716a((C6000la<Socket>) sSLSocket)) {
            return;
        }
        this.f26879i.m34719d(sSLSocket, C6013ma.m34859b(list));
    }

    /* renamed from: a */
    private boolean m34324a(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo34336b(str);
        }
    }
}
