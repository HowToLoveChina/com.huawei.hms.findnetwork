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

/* renamed from: iu.a */
/* loaded from: classes5.dex */
public class C10613a extends SSLSocketFactory {

    /* renamed from: i */
    public static final String f51016i = "a";

    /* renamed from: j */
    public static volatile C10613a f51017j;

    /* renamed from: a */
    public SSLContext f51018a = null;

    /* renamed from: b */
    public SSLSocket f51019b = null;

    /* renamed from: c */
    public Context f51020c;

    /* renamed from: d */
    public String[] f51021d;

    /* renamed from: e */
    public X509TrustManager f51022e;

    /* renamed from: f */
    public String[] f51023f;

    /* renamed from: g */
    public String[] f51024g;

    /* renamed from: h */
    public String[] f51025h;

    public C10613a(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, NullPointerException {
        m65059c(context);
        m65060d(AbstractC10615c.m65067f());
        SecureX509TrustManager secureX509TrustManagerM65061a = C10614b.m65061a(context);
        this.f51022e = secureX509TrustManagerM65061a;
        this.f51018a.init(null, new X509TrustManager[]{secureX509TrustManagerM65061a}, secureRandom);
    }

    /* renamed from: b */
    public static C10613a m65057b(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        C11156b.m67082a(context);
        if (f51017j == null) {
            synchronized (C10613a.class) {
                try {
                    if (f51017j == null) {
                        f51017j = new C10613a(context, secureRandom);
                    }
                } finally {
                }
            }
        }
        if (f51017j.f51020c == null && context != null) {
            f51017j.m65059c(context);
        }
        return f51017j;
    }

    /* renamed from: a */
    public final void m65058a(Socket socket) {
        boolean zM65066e;
        boolean zM65069h = false;
        if (C11157c.m67083a(this.f51025h)) {
            zM65066e = false;
        } else {
            C11160f.m67096e(f51016i, "set protocols");
            zM65066e = AbstractC10615c.m65066e((SSLSocket) socket, this.f51025h);
        }
        if (!C11157c.m67083a(this.f51024g) || !C11157c.m67083a(this.f51023f)) {
            C11160f.m67096e(f51016i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            AbstractC10615c.m65065d(sSLSocket);
            zM65069h = !C11157c.m67083a(this.f51024g) ? AbstractC10615c.m65069h(sSLSocket, this.f51024g) : AbstractC10615c.m65063b(sSLSocket, this.f51023f);
        }
        if (!zM65066e) {
            C11160f.m67096e(f51016i, "set default protocols");
            AbstractC10615c.m65065d((SSLSocket) socket);
        }
        if (zM65069h) {
            return;
        }
        C11160f.m67096e(f51016i, "set default cipher suites");
        AbstractC10615c.m65064c((SSLSocket) socket);
    }

    /* renamed from: c */
    public void m65059c(Context context) {
        this.f51020c = context.getApplicationContext();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        C11160f.m67096e(f51016i, "createSocket: host , port");
        Socket socketCreateSocket = this.f51018a.getSocketFactory().createSocket(str, i10);
        if (socketCreateSocket instanceof SSLSocket) {
            m65058a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f51019b = sSLSocket;
            this.f51021d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    /* renamed from: d */
    public void m65060d(SSLContext sSLContext) {
        this.f51018a = sSLContext;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f51021d;
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
        C11160f.m67096e(f51016i, "createSocket: s , host , port , autoClose");
        Socket socketCreateSocket = this.f51018a.getSocketFactory().createSocket(socket, str, i10, z10);
        if (socketCreateSocket instanceof SSLSocket) {
            m65058a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f51019b = sSLSocket;
            this.f51021d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }
}
