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
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import p435ku.C11156b;
import p435ku.C11157c;
import p435ku.C11160f;

@Deprecated
/* renamed from: iu.e */
/* loaded from: classes5.dex */
public class C10617e extends SSLSocketFactory {

    /* renamed from: i */
    @Deprecated
    public static final X509HostnameVerifier f51041i = new BrowserCompatHostnameVerifier();

    /* renamed from: j */
    @Deprecated
    public static final X509HostnameVerifier f51042j = new StrictHostnameVerifier();

    /* renamed from: k */
    public static final String f51043k = C10617e.class.getSimpleName();

    /* renamed from: l */
    public static volatile C10617e f51044l = null;

    /* renamed from: a */
    public SSLContext f51045a = null;

    /* renamed from: b */
    public SSLSocket f51046b = null;

    /* renamed from: c */
    public Context f51047c;

    /* renamed from: d */
    public String[] f51048d;

    /* renamed from: e */
    public X509TrustManager f51049e;

    /* renamed from: f */
    public String[] f51050f;

    /* renamed from: g */
    public String[] f51051g;

    /* renamed from: h */
    public String[] f51052h;

    public C10617e(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, NullPointerException {
        m65073c(context);
        m65074d(AbstractC10615c.m65067f());
        SecureX509TrustManager secureX509TrustManagerM65081a = C10619g.m65081a(context);
        this.f51049e = secureX509TrustManagerM65081a;
        this.f51045a.init(null, new X509TrustManager[]{secureX509TrustManagerM65081a}, secureRandom);
    }

    @Deprecated
    /* renamed from: b */
    public static C10617e m65071b(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C11156b.m67082a(context);
        if (f51044l == null) {
            synchronized (C10617e.class) {
                try {
                    if (f51044l == null) {
                        f51044l = new C10617e(context, null);
                    }
                } finally {
                }
            }
        }
        if (f51044l.f51047c == null && context != null) {
            f51044l.m65073c(context);
        }
        C11160f.m67093b(f51043k, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f51044l;
    }

    /* renamed from: a */
    public final void m65072a(Socket socket) {
        boolean z10;
        boolean zM65069h = false;
        if (C11157c.m67083a(this.f51052h)) {
            z10 = false;
        } else {
            C11160f.m67096e(f51043k, "set protocols");
            AbstractC10615c.m65066e((SSLSocket) socket, this.f51052h);
            z10 = true;
        }
        if (!C11157c.m67083a(this.f51051g) || !C11157c.m67083a(this.f51050f)) {
            C11160f.m67096e(f51043k, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            AbstractC10615c.m65065d(sSLSocket);
            zM65069h = !C11157c.m67083a(this.f51051g) ? AbstractC10615c.m65069h(sSLSocket, this.f51051g) : AbstractC10615c.m65063b(sSLSocket, this.f51050f);
        }
        if (!z10) {
            C11160f.m67096e(f51043k, "set default protocols");
            AbstractC10615c.m65065d((SSLSocket) socket);
        }
        if (zM65069h) {
            return;
        }
        C11160f.m67096e(f51043k, "set default cipher suites");
        AbstractC10615c.m65064c((SSLSocket) socket);
    }

    /* renamed from: c */
    public void m65073c(Context context) {
        this.f51047c = context.getApplicationContext();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        C11160f.m67096e(f51043k, "createSocket: host , port");
        Socket socketCreateSocket = this.f51045a.getSocketFactory().createSocket(str, i10);
        if (socketCreateSocket instanceof SSLSocket) {
            m65072a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f51046b = sSLSocket;
            this.f51048d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    /* renamed from: d */
    public void m65074d(SSLContext sSLContext) {
        this.f51045a = sSLContext;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f51048d;
        return strArr != null ? strArr : new String[0];
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

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        C11160f.m67096e(f51043k, "createSocket s host port autoClose");
        Socket socketCreateSocket = this.f51045a.getSocketFactory().createSocket(socket, str, i10, z10);
        if (socketCreateSocket instanceof SSLSocket) {
            m65072a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f51046b = sSLSocket;
            this.f51048d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }
}
