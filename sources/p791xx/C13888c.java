package p791xx;

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
import okhttp3.EnumC11914c0;
import p858zx.AbstractC14402c;
import p858zx.InterfaceC14404e;
import sx.C12873c;
import sx.C12875e;

/* renamed from: xx.c */
/* loaded from: classes9.dex */
public class C13888c extends C13893h {

    /* renamed from: c */
    public final Class<?> f62203c;

    /* renamed from: d */
    public final Class<?> f62204d;

    /* renamed from: e */
    public final Method f62205e;

    /* renamed from: f */
    public final Method f62206f;

    /* renamed from: g */
    public final Method f62207g;

    /* renamed from: h */
    public final Method f62208h;

    /* renamed from: i */
    public final b f62209i = b.m83270b();

    /* renamed from: xx.c$a */
    public static final class a extends AbstractC14402c {

        /* renamed from: a */
        public final Object f62210a;

        /* renamed from: b */
        public final Method f62211b;

        public a(Object obj, Method method) {
            this.f62210a = obj;
            this.f62211b = method;
        }

        @Override // p858zx.AbstractC14402c
        /* renamed from: a */
        public List<Certificate> mo83261a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f62211b.invoke(this.f62210a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
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

    /* renamed from: xx.c$b */
    public static final class b {

        /* renamed from: a */
        public final Method f62212a;

        /* renamed from: b */
        public final Method f62213b;

        /* renamed from: c */
        public final Method f62214c;

        public b(Method method, Method method2, Method method3) {
            this.f62212a = method;
            this.f62213b = method2;
            this.f62214c = method3;
        }

        /* renamed from: b */
        public static b m83270b() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
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
        public Object m83271a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.f62212a;
            if (method != null) {
                try {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    this.f62213b.invoke(objInvoke, str);
                    return objInvoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: c */
        public boolean m83272c(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (obj == null) {
                return false;
            }
            try {
                this.f62214c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* renamed from: xx.c$c */
    public static final class c implements InterfaceC14404e {

        /* renamed from: a */
        public final X509TrustManager f62215a;

        /* renamed from: b */
        public final Method f62216b;

        public c(X509TrustManager x509TrustManager, Method method) {
            this.f62216b = method;
            this.f62215a = x509TrustManager;
        }

        @Override // p858zx.InterfaceC14404e
        /* renamed from: a */
        public X509Certificate mo83262a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f62216b.invoke(this.f62215a, x509Certificate);
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
            return this.f62215a.equals(cVar.f62215a) && this.f62216b.equals(cVar.f62216b);
        }

        public int hashCode() {
            return this.f62215a.hashCode() + (this.f62216b.hashCode() * 31);
        }
    }

    public C13888c(Class<?> cls, Class<?> cls2, Method method, Method method2, Method method3, Method method4) {
        this.f62203c = cls;
        this.f62204d = cls2;
        this.f62205e = method;
        this.f62206f = method2;
        this.f62207g = method3;
        this.f62208h = method4;
    }

    /* renamed from: u */
    private boolean m83266u(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo83256q(str);
        }
    }

    /* renamed from: v */
    private boolean m83267v(String str, Class<?> cls, Object obj) throws IllegalAccessException, InvocationTargetException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return this.m83266u(str, cls, obj);
        }
    }

    /* renamed from: w */
    public static C13893h m83268w() {
        if (!C13893h.m83292p()) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            try {
                return new C13888c(cls, cls2, cls2.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE), cls2.getMethod("setHostname", String.class), cls2.getMethod("getAlpnSelectedProtocol", new Class[0]), cls2.getMethod("setAlpnProtocols", byte[].class));
            } catch (NoSuchMethodException unused) {
                throw new IllegalStateException("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT);
            }
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    /* renamed from: x */
    public static int m83269x() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
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
            return new c(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo83252d(x509TrustManager);
        }
    }

    @Override // p791xx.C13893h
    /* renamed from: g */
    public void mo83244g(SSLSocket sSLSocket, String str, List<EnumC11914c0> list) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (this.f62204d.isInstance(sSLSocket)) {
            if (str != null) {
                try {
                    this.f62205e.invoke(sSLSocket, Boolean.TRUE);
                    this.f62206f.invoke(sSLSocket, str);
                } catch (IllegalAccessException | InvocationTargetException e10) {
                    throw new AssertionError(e10);
                }
            }
            this.f62208h.invoke(sSLSocket, C13893h.m83287e(list));
        }
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
        if (!this.f62204d.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f62207g.invoke(sSLSocket, new Object[0]);
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

    @Override // p791xx.C13893h
    /* renamed from: o */
    public Object mo83255o(String str) {
        return this.f62209i.m83271a(str);
    }

    @Override // p791xx.C13893h
    /* renamed from: q */
    public boolean mo83256q(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m83267v(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
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
        if (this.f62209i.m83272c(obj)) {
            return;
        }
        mo83257s(5, str, null);
    }
}
