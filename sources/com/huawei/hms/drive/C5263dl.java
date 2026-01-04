package com.huawei.hms.drive;

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
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.drive.dl */
/* loaded from: classes8.dex */
class C5263dl extends C5269dr {

    /* renamed from: a */
    private final Class<?> f24451a;

    /* renamed from: b */
    private final C5268dq<Socket> f24452b;

    /* renamed from: c */
    private final C5268dq<Socket> f24453c;

    /* renamed from: d */
    private final C5268dq<Socket> f24454d;

    /* renamed from: e */
    private final C5268dq<Socket> f24455e;

    /* renamed from: f */
    private final c f24456f = c.m31664a();

    /* renamed from: com.huawei.hms.drive.dl$a */
    public static final class a extends AbstractC5274dw {

        /* renamed from: a */
        private final Object f24457a;

        /* renamed from: b */
        private final Method f24458b;

        public a(Object obj, Method method) {
            this.f24457a = obj;
            this.f24458b = method;
        }

        @Override // com.huawei.hms.drive.AbstractC5274dw
        /* renamed from: a */
        public List<Certificate> mo31662a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f24458b.invoke(this.f24457a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
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

    /* renamed from: com.huawei.hms.drive.dl$b */
    public static final class b implements InterfaceC5276dy {

        /* renamed from: a */
        private final X509TrustManager f24459a;

        /* renamed from: b */
        private final Method f24460b;

        public b(X509TrustManager x509TrustManager, Method method) {
            this.f24460b = method;
            this.f24459a = x509TrustManager;
        }

        @Override // com.huawei.hms.drive.InterfaceC5276dy
        /* renamed from: a */
        public X509Certificate mo31663a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f24460b.invoke(this.f24459a, x509Certificate);
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
            return this.f24459a.equals(bVar.f24459a) && this.f24460b.equals(bVar.f24460b);
        }

        public int hashCode() {
            return this.f24459a.hashCode() + (this.f24460b.hashCode() * 31);
        }
    }

    public C5263dl(Class<?> cls, C5268dq<Socket> c5268dq, C5268dq<Socket> c5268dq2, C5268dq<Socket> c5268dq3, C5268dq<Socket> c5268dq4) {
        this.f24451a = cls;
        this.f24452b = c5268dq;
        this.f24453c = c5268dq2;
        this.f24454d = c5268dq3;
        this.f24455e = c5268dq4;
    }

    /* renamed from: c */
    public static int m31652c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    /* renamed from: d */
    private static boolean m31653d() throws ClassNotFoundException {
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
        } catch (SecurityException e12) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e12);
            throw iOException;
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: b */
    public boolean mo31661b(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m31650a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo31661b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
            throw new AssertionError("unable to determine cleartext support", e10);
        }
    }

    /* renamed from: com.huawei.hms.drive.dl$c */
    public static final class c {

        /* renamed from: a */
        private final Method f24461a;

        /* renamed from: b */
        private final Method f24462b;

        /* renamed from: c */
        private final Method f24463c;

        public c(Method method, Method method2, Method method3) {
            this.f24461a = method;
            this.f24462b = method2;
            this.f24463c = method3;
        }

        /* renamed from: a */
        public Object m31665a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f24461a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.f24462b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: a */
        public boolean m31666a(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj == null) {
                return false;
            }
            try {
                this.f24463c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: a */
        public static c m31664a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
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
    }

    /* renamed from: b */
    private boolean m31651b(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo31661b(str);
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public void mo31648a(SSLSocket sSLSocket, String str, List<EnumC5199bd> list) {
        if (str != null) {
            this.f24452b.m31684b(sSLSocket, Boolean.TRUE);
            this.f24453c.m31684b(sSLSocket, str);
        }
        C5268dq<Socket> c5268dq = this.f24455e;
        if (c5268dq == null || !c5268dq.m31683a((C5268dq<Socket>) sSLSocket)) {
            return;
        }
        this.f24455e.m31686d(sSLSocket, C5269dr.m31689b(list));
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: b */
    public InterfaceC5276dy mo31659b(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo31659b(x509TrustManager);
        }
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public String mo31647a(SSLSocket sSLSocket) {
        byte[] bArr;
        C5268dq<Socket> c5268dq = this.f24454d;
        if (c5268dq == null || !c5268dq.m31683a((C5268dq<Socket>) sSLSocket) || (bArr = (byte[]) this.f24454d.m31686d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Charset.forName(Constants.UTF_8));
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
        return this.f24456f.m31665a(str);
    }

    @Override // com.huawei.hms.drive.C5269dr
    /* renamed from: a */
    public void mo31657a(String str, Object obj) {
        if (this.f24456f.m31666a(obj)) {
            return;
        }
        mo31656a(5, str, (Throwable) null);
    }

    /* renamed from: a */
    private boolean m31650a(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return this.m31651b(str, cls, obj);
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

    /* renamed from: a */
    public static C5269dr m31649a() {
        Class<?> cls;
        C5268dq c5268dq;
        C5268dq c5268dq2;
        if (m31652c() == 0) {
            return null;
        }
        try {
            if (m31652c() >= 21) {
                return null;
            }
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            C5268dq c5268dq3 = new C5268dq(null, "setUseSessionTickets", Boolean.TYPE);
            C5268dq c5268dq4 = new C5268dq(null, "setHostname", String.class);
            if (m31653d()) {
                C5268dq c5268dq5 = new C5268dq(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                c5268dq2 = new C5268dq(null, "setAlpnProtocols", byte[].class);
                c5268dq = c5268dq5;
            } else {
                c5268dq = null;
                c5268dq2 = null;
            }
            return new C5263dl(cls2, c5268dq3, c5268dq4, c5268dq, c5268dq2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }
}
