package com.huawei.hms.drive;

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
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.drive.dm */
/* loaded from: classes8.dex */
class C5264dm extends C5269dr {

    /* renamed from: a */
    private final Class<?> f24464a;

    /* renamed from: b */
    private final Class<?> f24465b;

    /* renamed from: c */
    private final Method f24466c;

    /* renamed from: d */
    private final Method f24467d;

    /* renamed from: e */
    private final Method f24468e;

    /* renamed from: f */
    private final Method f24469f;

    /* renamed from: g */
    private final b f24470g = b.m31671a();

    /* renamed from: com.huawei.hms.drive.dm$a */
    public static final class a extends AbstractC5274dw {

        /* renamed from: a */
        private final Object f24471a;

        /* renamed from: b */
        private final Method f24472b;

        public a(Object obj, Method method) {
            this.f24471a = obj;
            this.f24472b = method;
        }

        @Override // com.huawei.hms.drive.AbstractC5274dw
        /* renamed from: a */
        public List<Certificate> mo31662a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f24472b.invoke(this.f24471a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
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

    /* renamed from: com.huawei.hms.drive.dm$c */
    public static final class c implements InterfaceC5276dy {

        /* renamed from: a */
        private final X509TrustManager f24476a;

        /* renamed from: b */
        private final Method f24477b;

        public c(X509TrustManager x509TrustManager, Method method) {
            this.f24477b = method;
            this.f24476a = x509TrustManager;
        }

        @Override // com.huawei.hms.drive.InterfaceC5276dy
        /* renamed from: a */
        public X509Certificate mo31663a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f24477b.invoke(this.f24476a, x509Certificate);
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
            return this.f24476a.equals(cVar.f24476a) && this.f24477b.equals(cVar.f24477b);
        }

        public int hashCode() {
            return this.f24476a.hashCode() + (this.f24477b.hashCode() * 31);
        }
    }

    public C5264dm(Class<?> cls, Class<?> cls2, Method method, Method method2, Method method3, Method method4) {
        this.f24464a = cls;
        this.f24465b = cls2;
        this.f24466c = method;
        this.f24467d = method2;
        this.f24468e = method3;
        this.f24469f = method4;
    }

    /* renamed from: c */
    public static C5269dr m31669c() {
        if (!C5269dr.m31694g()) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            try {
                return new C5264dm(cls, cls2, cls2.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE), cls2.getMethod("setHostname", String.class), cls2.getMethod("getAlpnSelectedProtocol", new Class[0]), cls2.getMethod("setAlpnProtocols", byte[].class));
            } catch (NoSuchMethodException unused) {
                throw new IllegalStateException("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT);
            }
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    /* renamed from: d */
    public static int m31670d() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public void mo31658a(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        try {
            socket.connect(inetSocketAddress, i10);
        } catch (AssertionError e10) {
            if (!C5210bo.m31196a(e10)) {
                throw e10;
            }
            throw new IOException(e10);
        } catch (ClassCastException e11) {
            throw e11;
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: b */
    public boolean mo31661b(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m31667a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo31661b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
            throw new AssertionError("unable to determine cleartext support", e10);
        }
    }

    /* renamed from: com.huawei.hms.drive.dm$b */
    public static final class b {

        /* renamed from: a */
        private final Method f24473a;

        /* renamed from: b */
        private final Method f24474b;

        /* renamed from: c */
        private final Method f24475c;

        public b(Method method, Method method2, Method method3) {
            this.f24473a = method;
            this.f24474b = method2;
            this.f24475c = method3;
        }

        /* renamed from: a */
        public Object m31672a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f24473a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.f24474b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: a */
        public boolean m31673a(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj == null) {
                return false;
            }
            try {
                this.f24475c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: a */
        public static b m31671a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
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
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public void mo31648a(SSLSocket sSLSocket, String str, List<EnumC5199bd> list) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (this.f24465b.isInstance(sSLSocket)) {
            if (str != null) {
                try {
                    this.f24466c.invoke(sSLSocket, Boolean.TRUE);
                    this.f24467d.invoke(sSLSocket, str);
                } catch (IllegalAccessException | InvocationTargetException e10) {
                    throw new AssertionError(e10);
                }
            }
            this.f24469f.invoke(sSLSocket, C5269dr.m31689b(list));
        }
    }

    /* renamed from: b */
    private boolean m31668b(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo31661b(str);
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public String mo31647a(SSLSocket sSLSocket) {
        if (!this.f24465b.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f24468e.invoke(sSLSocket, new Object[0]);
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

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: b */
    public InterfaceC5276dy mo31659b(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new c(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo31659b(x509TrustManager);
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: b */
    public SSLContext mo31660b() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("No TLS provider", e10);
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public void mo31656a(int i10, String str, Throwable th2) {
        int iMin;
        int i11 = i10 != 5 ? 3 : 5;
        if (th2 != null) {
            str = str + '\n' + Log.getStackTraceString(C5209bn.m31168a(th2));
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

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public Object mo31655a(String str) {
        return this.f24470g.m31672a(str);
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public void mo31657a(String str, Object obj) {
        if (this.f24470g.m31673a(obj)) {
            return;
        }
        mo31656a(5, str, (Throwable) null);
    }

    /* renamed from: a */
    private boolean m31667a(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return this.m31668b(str, cls, obj);
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public AbstractC5274dw mo31654a(X509TrustManager x509TrustManager) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.mo31654a(x509TrustManager);
        }
    }
}
