package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.utils.C7795co;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* renamed from: com.huawei.openalliance.ad.ld */
/* loaded from: classes8.dex */
public class C7384ld extends SSLSocketFactory {

    /* renamed from: a */
    public static final X509HostnameVerifier f34300a = new BrowserCompatHostnameVerifier();

    /* renamed from: b */
    public static final X509HostnameVerifier f34301b = new StrictHostnameVerifier();

    /* renamed from: c */
    private static final String[] f34302c = {"TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_RSA", "aNULL", "eNULL", "CBC"};

    /* renamed from: d */
    private static final String[] f34303d = {"TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_RSA", "aNULL", "eNULL"};

    /* renamed from: e */
    private static volatile C7384ld f34304e = null;

    /* renamed from: f */
    private static String[] f34305f = null;

    /* renamed from: g */
    private SSLContext f34306g;

    /* renamed from: h */
    private Context f34307h;

    private C7384ld(Context context) throws NoSuchAlgorithmException, KeyManagementException {
        SecureRandom secureRandom;
        this.f34306g = null;
        this.f34307h = context;
        this.f34306g = C7795co.m48076a();
        C7385le c7385le = new C7385le(this.f34307h);
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (Exception unused) {
            secureRandom = new SecureRandom();
        }
        this.f34306g.init(null, new X509TrustManager[]{c7385le}, secureRandom);
    }

    /* renamed from: a */
    public static C7384ld m45468a(Context context) {
        if (f34304e == null) {
            synchronized (C7384ld.class) {
                try {
                    if (f34304e == null) {
                        f34304e = new C7384ld(context);
                    }
                } finally {
                }
            }
        }
        return f34304e;
    }

    /* renamed from: b */
    private void m45471b(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        Socket socketCreateSocket = this.f34306g.getSocketFactory().createSocket(str, i10);
        m45469a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        String[] strArr = f34305f;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    /* renamed from: a */
    private void m45469a(Socket socket) {
        if (socket == null || !(socket instanceof SSLSocket)) {
            return;
        }
        SSLSocket sSLSocket = (SSLSocket) socket;
        m45471b(sSLSocket);
        m45470a(sSLSocket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return createSocket(str, i10);
    }

    /* renamed from: a */
    private static void m45470a(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            String[] strArr = f34302c;
            int length = strArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    arrayList.add(str);
                    break;
                } else if (upperCase.contains(strArr[i10].toUpperCase(Locale.ENGLISH))) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        f34305f = strArr2;
        sSLSocket.setEnabledCipherSuites(strArr2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) {
        return createSocket(inetAddress.getHostAddress(), i10);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return createSocket(inetAddress.getHostAddress(), i10);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        Socket socketCreateSocket = this.f34306g.getSocketFactory().createSocket(socket, str, i10, z10);
        m45469a(socketCreateSocket);
        return socketCreateSocket;
    }
}
