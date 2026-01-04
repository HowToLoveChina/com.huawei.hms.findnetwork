package com.huawei.hms.network.embedded;

import android.os.Build;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.network.embedded.ha */
/* loaded from: classes8.dex */
public class C5948ha extends C6013ma {

    /* renamed from: l */
    public static final int f26964l = 4000;

    /* renamed from: e */
    public final Class<?> f26965e;

    /* renamed from: f */
    public final Class<?> f26966f;

    /* renamed from: g */
    public final Method f26967g;

    /* renamed from: h */
    public final Method f26968h;

    /* renamed from: i */
    public final Method f26969i;

    /* renamed from: j */
    public final Method f26970j;

    /* renamed from: k */
    public final b f26971k = b.m34371a();

    /* renamed from: com.huawei.hms.network.embedded.ha$a */
    public static final class a extends AbstractC6065qa {

        /* renamed from: a */
        public final Object f26972a;

        /* renamed from: b */
        public final Method f26973b;

        public a(Object obj, Method method) {
            this.f26972a = obj;
            this.f26973b = method;
        }

        @Override // com.huawei.hms.network.embedded.AbstractC6065qa
        /* renamed from: a */
        public List<Certificate> mo34338a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f26973b.invoke(this.f26972a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
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

    /* renamed from: com.huawei.hms.network.embedded.ha$b */
    public static final class b {

        /* renamed from: a */
        public final Method f26974a;

        /* renamed from: b */
        public final Method f26975b;

        /* renamed from: c */
        public final Method f26976c;

        public b(Method method, Method method2, Method method3) {
            this.f26974a = method;
            this.f26975b = method2;
            this.f26976c = method3;
        }

        /* renamed from: a */
        public static b m34371a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
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
            return new b(method, method3, method2);
        }

        /* renamed from: a */
        public Object m34372a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f26974a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.f26975b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: a */
        public boolean m34373a(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj != null) {
                try {
                    this.f26976c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.ha$c */
    public static final class c implements InterfaceC6104ta {

        /* renamed from: a */
        public final X509TrustManager f26977a;

        /* renamed from: b */
        public final Method f26978b;

        public c(X509TrustManager x509TrustManager, Method method) {
            this.f26978b = method;
            this.f26977a = x509TrustManager;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6104ta
        /* renamed from: a */
        public X509Certificate mo34339a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f26978b.invoke(this.f26977a, x509Certificate);
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
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f26977a.equals(cVar.f26977a) && this.f26978b.equals(cVar.f26978b);
        }

        public int hashCode() {
            return this.f26977a.hashCode() + (this.f26978b.hashCode() * 31);
        }
    }

    public C5948ha(Class<?> cls, Class<?> cls2, Method method, Method method2, Method method3, Method method4) {
        this.f26965e = cls;
        this.f26966f = cls2;
        this.f26967g = method;
        this.f26968h = method2;
        this.f26969i = method3;
        this.f26970j = method4;
    }

    /* renamed from: i */
    public static C6013ma m34369i() {
        if (!C6013ma.m34864g()) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            try {
                return new C5948ha(cls, cls2, cls2.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE), cls2.getMethod("setHostname", String.class), cls2.getMethod("getAlpnSelectedProtocol", new Class[0]), cls2.getMethod("setAlpnProtocols", byte[].class));
            } catch (NoSuchMethodException unused) {
                throw new IllegalStateException("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT);
            }
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    /* renamed from: j */
    public static int m34370j() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
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
            return new c(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo34334b(x509TrustManager);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: c */
    public X509TrustManager mo34337c(SSLSocketFactory sSLSocketFactory) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Object objM34857a = C6013ma.m34857a(sSLSocketFactory, this.f26965e, "sslParameters");
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
        return this.f26971k.m34372a(str);
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: b */
    public String mo34272b(SSLSocket sSLSocket) {
        if (!this.f26966f.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f26969i.invoke(sSLSocket, new Object[0]);
            if (bArr != null) {
                return new String(bArr, StandardCharsets.UTF_8);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new AssertionError(e10);
        } catch (NullPointerException e11) {
            if ("ssl == null".equals(e11.getMessage())) {
                return null;
            }
            throw e11;
        }
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
        if (this.f26971k.m34373a(obj)) {
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
                return m34368b(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                return super.mo34336b(str);
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
            throw new AssertionError("unable to determine cleartext support", e10);
        }
    }

    /* renamed from: b */
    private boolean m34368b(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return this.m34367a(str, cls, obj);
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
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public void mo34271a(SSLSocket sSLSocket, String str, List<EnumC6075r7> list) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (this.f26966f.isInstance(sSLSocket)) {
            if (str != null) {
                try {
                    this.f26967g.invoke(sSLSocket, Boolean.TRUE);
                    this.f26968h.invoke(sSLSocket, str);
                } catch (IllegalAccessException | InvocationTargetException e10) {
                    throw new AssertionError(e10);
                }
            }
            this.f26970j.invoke(sSLSocket, C6013ma.m34859b(list));
        }
    }

    /* renamed from: a */
    private boolean m34367a(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo34336b(str);
        }
    }
}
