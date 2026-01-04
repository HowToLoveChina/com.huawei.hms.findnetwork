package p751wt;

import android.content.Context;
import com.huawei.secure.android.common.SecureX509TrustManager;
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
import p373iu.AbstractC10615c;

@Deprecated
/* renamed from: wt.a */
/* loaded from: classes5.dex */
public class C13638a extends SSLSocketFactory {

    /* renamed from: c */
    public static final X509HostnameVerifier f61326c = new BrowserCompatHostnameVerifier();

    /* renamed from: d */
    public static final X509HostnameVerifier f61327d = new StrictHostnameVerifier();

    /* renamed from: e */
    public static volatile C13638a f61328e = null;

    /* renamed from: a */
    public SSLContext f61329a;

    /* renamed from: b */
    public Context f61330b;

    public C13638a(Context context, SecureRandom secureRandom) throws IllegalAccessException, NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException {
        this.f61329a = null;
        this.f61330b = context;
        this.f61329a = AbstractC10615c.m65067f();
        this.f61329a.init(null, new X509TrustManager[]{new SecureX509TrustManager(this.f61330b)}, secureRandom);
    }

    @Deprecated
    /* renamed from: b */
    public static C13638a m82005b(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        if (f61328e == null) {
            synchronized (C13638a.class) {
                try {
                    if (f61328e == null) {
                        f61328e = new C13638a(context, null);
                    }
                } finally {
                }
            }
        }
        return f61328e;
    }

    /* renamed from: a */
    public final void m82006a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        AbstractC10615c.m65065d(sSLSocket);
        AbstractC10615c.m65064c(sSLSocket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        Socket socketCreateSocket = this.f61329a.getSocketFactory().createSocket(str, i10);
        if (socketCreateSocket instanceof SSLSocket) {
            m82006a(socketCreateSocket);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
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
        Socket socketCreateSocket = this.f61329a.getSocketFactory().createSocket(socket, str, i10, z10);
        if (socketCreateSocket instanceof SSLSocket) {
            m82006a(socketCreateSocket);
        }
        return socketCreateSocket;
    }
}
