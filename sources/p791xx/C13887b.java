package p791xx;

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
import okhttp3.EnumC11914c0;
import p858zx.AbstractC14402c;
import p858zx.InterfaceC14404e;
import sx.C12873c;
import sx.C12875e;

/* renamed from: xx.b */
/* loaded from: classes9.dex */
public class C13887b extends C13893h {

    /* renamed from: c */
    public final Class<?> f62190c;

    /* renamed from: d */
    public final C13892g<Socket> f62191d;

    /* renamed from: e */
    public final C13892g<Socket> f62192e;

    /* renamed from: f */
    public final C13892g<Socket> f62193f;

    /* renamed from: g */
    public final C13892g<Socket> f62194g;

    /* renamed from: h */
    public final c f62195h = c.m83263b();

    /* renamed from: xx.b$a */
    public static final class a extends AbstractC14402c {

        /* renamed from: a */
        public final Object f62196a;

        /* renamed from: b */
        public final Method f62197b;

        public a(Object obj, Method method) {
            this.f62196a = obj;
            this.f62197b = method;
        }

        @Override // p858zx.AbstractC14402c
        /* renamed from: a */
        public List<Certificate> mo83261a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f62197b.invoke(this.f62196a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
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

    /* renamed from: xx.b$b */
    public static final class b implements InterfaceC14404e {

        /* renamed from: a */
        public final X509TrustManager f62198a;

        /* renamed from: b */
        public final Method f62199b;

        public b(X509TrustManager x509TrustManager, Method method) {
            this.f62199b = method;
            this.f62198a = x509TrustManager;
        }

        @Override // p858zx.InterfaceC14404e
        /* renamed from: a */
        public X509Certificate mo83262a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f62199b.invoke(this.f62198a, x509Certificate);
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
            return this.f62198a.equals(bVar.f62198a) && this.f62199b.equals(bVar.f62199b);
        }

        public int hashCode() {
            return this.f62198a.hashCode() + (this.f62199b.hashCode() * 31);
        }
    }

    /* renamed from: xx.b$c */
    public static final class c {

        /* renamed from: a */
        public final Method f62200a;

        /* renamed from: b */
        public final Method f62201b;

        /* renamed from: c */
        public final Method f62202c;

        public c(Method method, Method method2, Method method3) {
            this.f62200a = method;
            this.f62201b = method2;
            this.f62202c = method3;
        }

        /* renamed from: b */
        public static c m83263b() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
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
        public Object m83264a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f62200a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.f62201b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: c */
        public boolean m83265c(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj == null) {
                return false;
            }
            try {
                this.f62202c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public C13887b(Class<?> cls, C13892g<Socket> c13892g, C13892g<Socket> c13892g2, C13892g<Socket> c13892g3, C13892g<Socket> c13892g4) {
        this.f62190c = cls;
        this.f62191d = c13892g;
        this.f62192e = c13892g2;
        this.f62193f = c13892g3;
        this.f62194g = c13892g4;
    }

    /* renamed from: w */
    public static C13893h m83248w() {
        Class<?> cls;
        C13892g c13892g;
        C13892g c13892g2;
        if (m83249x() == 0) {
            return null;
        }
        try {
            if (m83249x() >= 21) {
                return null;
            }
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            C13892g c13892g3 = new C13892g(null, "setUseSessionTickets", Boolean.TYPE);
            C13892g c13892g4 = new C13892g(null, "setHostname", String.class);
            if (m83250y()) {
                C13892g c13892g5 = new C13892g(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                c13892g2 = new C13892g(null, "setAlpnProtocols", byte[].class);
                c13892g = c13892g5;
            } else {
                c13892g = null;
                c13892g2 = null;
            }
            return new C13887b(cls2, c13892g3, c13892g4, c13892g, c13892g2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    /* renamed from: x */
    public static int m83249x() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    /* renamed from: y */
    public static boolean m83250y() throws ClassNotFoundException {
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

    @Override // p791xx.C13893h
    /* renamed from: c */
    public AbstractC14402c mo83251c(X509TrustManager x509TrustManager) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.mo83251c(x509TrustManager);
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: d */
    public InterfaceC14404e mo83252d(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo83252d(x509TrustManager);
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: g */
    public void mo83244g(SSLSocket sSLSocket, String str, List<EnumC11914c0> list) {
        if (str != null) {
            this.f62191d.m83283e(sSLSocket, Boolean.TRUE);
            this.f62192e.m83283e(sSLSocket, str);
        }
        C13892g<Socket> c13892g = this.f62194g;
        if (c13892g == null || !c13892g.m83285g(sSLSocket)) {
            return;
        }
        this.f62194g.m83284f(sSLSocket, C13893h.m83287e(list));
    }

    @Override // p791xx.C13893h
    /* renamed from: h */
    public void mo83253h(Socket socket, InetSocketAddress inetSocketAddress, int i10) throws IOException {
        try {
            socket.connect(inetSocketAddress, i10);
        } catch (AssertionError e10) {
            if (!C12875e.m77230A(e10)) {
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

    @Override // p791xx.C13893h
    /* renamed from: m */
    public SSLContext mo83254m() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("No TLS provider", e10);
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: n */
    public String mo83245n(SSLSocket sSLSocket) {
        byte[] bArr;
        C13892g<Socket> c13892g = this.f62193f;
        if (c13892g == null || !c13892g.m83285g(sSLSocket) || (bArr = (byte[]) this.f62193f.m83284f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Charset.forName(Constants.UTF_8));
    }

    @Override // p791xx.C13893h
    /* renamed from: o */
    public Object mo83255o(String str) {
        return this.f62195h.m83264a(str);
    }

    @Override // p791xx.C13893h
    /* renamed from: q */
    public boolean mo83256q(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m83260v(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo83256q(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e10) {
            throw new AssertionError("unable to determine cleartext support", e10);
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: s */
    public void mo83257s(int i10, String str, Throwable th2) {
        int iMin;
        int i11 = i10 != 5 ? 3 : 5;
        if (th2 != null) {
            str = str + '\n' + Log.getStackTraceString(C12873c.m77226c(th2));
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

    @Override // p791xx.C13893h
    /* renamed from: t */
    public void mo83258t(String str, Object obj) {
        if (this.f62195h.m83265c(obj)) {
            return;
        }
        mo83257s(5, str, null);
    }

    /* renamed from: u */
    public final boolean m83259u(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo83256q(str);
        }
    }

    /* renamed from: v */
    public final boolean m83260v(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return this.m83259u(str, cls, obj);
        }
    }
}
