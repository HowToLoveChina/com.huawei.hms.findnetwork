package p373iu;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import p435ku.C11156b;
import p435ku.C11157c;
import p435ku.C11160f;

/* renamed from: iu.f */
/* loaded from: classes5.dex */
public class C10618f extends SSLSocketFactory {

    /* renamed from: i */
    public static volatile C10618f f51053i;

    /* renamed from: a */
    public SSLContext f51054a;

    /* renamed from: b */
    public SSLSocket f51055b;

    /* renamed from: c */
    public Context f51056c;

    /* renamed from: d */
    public String[] f51057d;

    /* renamed from: e */
    public X509TrustManager f51058e;

    /* renamed from: f */
    public String[] f51059f;

    /* renamed from: g */
    public String[] f51060g;

    /* renamed from: h */
    public String[] f51061h;

    public C10618f(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, NullPointerException {
        this.f51054a = null;
        this.f51055b = null;
        m65078d(context);
        m65079e(AbstractC10615c.m65067f());
        SecureX509TrustManager secureX509TrustManagerM65081a = C10619g.m65081a(context);
        this.f51058e = secureX509TrustManagerM65081a;
        this.f51054a.init(null, new X509TrustManager[]{secureX509TrustManagerM65081a}, secureRandom);
    }

    @Deprecated
    /* renamed from: b */
    public static C10618f m65075b(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11156b.m67082a(context);
        if (f51053i == null) {
            synchronized (C10618f.class) {
                try {
                    if (f51053i == null) {
                        f51053i = new C10618f(context, (SecureRandom) null);
                    }
                } finally {
                }
            }
        }
        if (f51053i.f51056c == null && context != null) {
            f51053i.m65078d(context);
        }
        C11160f.m67093b("SSLFNew", "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f51053i;
    }

    /* renamed from: c */
    public static C10618f m65076c(Context context, SecureRandom secureRandom) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11156b.m67082a(context);
        if (f51053i == null) {
            synchronized (C10618f.class) {
                try {
                    if (f51053i == null) {
                        f51053i = new C10618f(context, secureRandom);
                    }
                } finally {
                }
            }
        }
        if (f51053i.f51056c == null && context != null) {
            f51053i.m65078d(context);
        }
        C11160f.m67093b("SSLFNew", "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f51053i;
    }

    /* renamed from: a */
    public final void m65077a(Socket socket) {
        boolean zM65066e;
        boolean zM65069h = false;
        if (C11157c.m67083a(this.f51061h)) {
            zM65066e = false;
        } else {
            C11160f.m67096e("SSLFNew", "set protocols");
            zM65066e = AbstractC10615c.m65066e((SSLSocket) socket, this.f51061h);
        }
        if (!C11157c.m67083a(this.f51060g) || !C11157c.m67083a(this.f51059f)) {
            C11160f.m67096e("SSLFNew", "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            AbstractC10615c.m65065d(sSLSocket);
            zM65069h = !C11157c.m67083a(this.f51060g) ? AbstractC10615c.m65069h(sSLSocket, this.f51060g) : AbstractC10615c.m65063b(sSLSocket, this.f51059f);
        }
        if (!zM65066e) {
            C11160f.m67096e("SSLFNew", "set default protocols");
            AbstractC10615c.m65065d((SSLSocket) socket);
        }
        if (zM65069h) {
            return;
        }
        C11160f.m67096e("SSLFNew", "set default cipher");
        AbstractC10615c.m65064c((SSLSocket) socket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        C11160f.m67096e("SSLFNew", "createSocket: host , port");
        Socket socketCreateSocket = this.f51054a.getSocketFactory().createSocket(str, i10);
        if (socketCreateSocket instanceof SSLSocket) {
            m65077a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f51055b = sSLSocket;
            this.f51057d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    /* renamed from: d */
    public void m65078d(Context context) {
        this.f51056c = context.getApplicationContext();
    }

    /* renamed from: e */
    public void m65079e(SSLContext sSLContext) {
        this.f51054a = sSLContext;
    }

    /* renamed from: f */
    public void m65080f(X509TrustManager x509TrustManager) {
        this.f51058e = x509TrustManager;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f51057d;
        return strArr != null ? strArr : new String[0];
    }

    public C10618f(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f51054a = null;
        this.f51055b = null;
        this.f51054a = AbstractC10615c.m65067f();
        m65080f(x509TrustManager);
        this.f51054a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        C11160f.m67096e("SSLFNew", "createSocket");
        Socket socketCreateSocket = this.f51054a.getSocketFactory().createSocket(socket, str, i10, z10);
        if (socketCreateSocket instanceof SSLSocket) {
            m65077a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f51055b = sSLSocket;
            this.f51057d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i10);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException {
        return createSocket(str, i10);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i10);
    }
}
