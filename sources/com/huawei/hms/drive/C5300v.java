package com.huawei.hms.drive;

import android.content.Context;
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

@Deprecated
/* renamed from: com.huawei.hms.drive.v */
/* loaded from: classes8.dex */
public class C5300v extends SSLSocketFactory {

    /* renamed from: a */
    @Deprecated
    public static final X509HostnameVerifier f24570a = new BrowserCompatHostnameVerifier();

    /* renamed from: b */
    @Deprecated
    public static final X509HostnameVerifier f24571b = new StrictHostnameVerifier();

    /* renamed from: c */
    private static final String f24572c = C5300v.class.getSimpleName();

    /* renamed from: d */
    private static volatile C5300v f24573d = null;

    /* renamed from: e */
    private SSLContext f24574e = null;

    /* renamed from: f */
    private SSLSocket f24575f = null;

    /* renamed from: g */
    private Context f24576g;

    /* renamed from: h */
    private String[] f24577h;

    /* renamed from: i */
    private X509TrustManager f24578i;

    /* renamed from: j */
    private String[] f24579j;

    /* renamed from: k */
    private String[] f24580k;

    /* renamed from: l */
    private String[] f24581l;

    private C5300v(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        if (context == null) {
            C5170ac.m30796c(f24572c, "SecureSSLSocketFactory: context is null");
            return;
        }
        m31828b(context);
        m31827a(AbstractC5299u.m31817a());
        C5302x c5302xM31829a = C5301w.m31829a(context);
        this.f24578i = c5302xM31829a;
        this.f24574e.init(null, new X509TrustManager[]{c5302xM31829a}, secureRandom);
    }

    @Deprecated
    /* renamed from: a */
    public static C5300v m31825a(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C5304z.m31839a(context);
        if (f24573d == null) {
            synchronized (C5300v.class) {
                try {
                    if (f24573d == null) {
                        f24573d = new C5300v(context, null);
                    }
                } finally {
                }
            }
        }
        if (f24573d.f24576g == null && context != null) {
            f24573d.m31828b(context);
        }
        C5170ac.m30794a(f24572c, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f24573d;
    }

    /* renamed from: b */
    public void m31828b(Context context) {
        this.f24576g = context.getApplicationContext();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        C5170ac.m30795b(f24572c, "createSocket: host , port");
        Socket socketCreateSocket = this.f24574e.getSocketFactory().createSocket(str, i10);
        if (socketCreateSocket instanceof SSLSocket) {
            m31826a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f24575f = sSLSocket;
            this.f24577h = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f24577h;
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
        C5170ac.m30795b(f24572c, "createSocket s host port autoClose");
        Socket socketCreateSocket = this.f24574e.getSocketFactory().createSocket(socket, str, i10, z10);
        if (socketCreateSocket instanceof SSLSocket) {
            m31826a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.f24575f = sSLSocket;
            this.f24577h = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    /* renamed from: a */
    public void m31827a(SSLContext sSLContext) {
        this.f24574e = sSLContext;
    }

    /* renamed from: a */
    private void m31826a(Socket socket) {
        boolean z10;
        boolean zM31821b = false;
        if (C5168aa.m30790a(this.f24581l)) {
            z10 = false;
        } else {
            C5170ac.m30795b(f24572c, "set protocols");
            AbstractC5299u.m31823c((SSLSocket) socket, this.f24581l);
            z10 = true;
        }
        if (!C5168aa.m30790a(this.f24580k) || !C5168aa.m30790a(this.f24579j)) {
            C5170ac.m30795b(f24572c, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            AbstractC5299u.m31824d(sSLSocket);
            if (!C5168aa.m30790a(this.f24580k)) {
                zM31821b = AbstractC5299u.m31819a(sSLSocket, this.f24580k);
            } else {
                zM31821b = AbstractC5299u.m31821b(sSLSocket, this.f24579j);
            }
        }
        if (!z10) {
            C5170ac.m30795b(f24572c, "set default protocols");
            AbstractC5299u.m31824d((SSLSocket) socket);
        }
        if (zM31821b) {
            return;
        }
        C5170ac.m30795b(f24572c, "set default cipher suites");
        AbstractC5299u.m31818a((SSLSocket) socket);
    }
}
