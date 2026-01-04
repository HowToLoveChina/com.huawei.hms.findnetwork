package com.huawei.openalliance.p169ad.net.http;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.C7795co;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: com.huawei.openalliance.ad.net.http.m */
/* loaded from: classes2.dex */
public final class C7510m extends SSLSocketFactory {

    /* renamed from: a */
    private static final String f34874a = "m";

    /* renamed from: c */
    private static SSLSocketFactory f34875c;

    /* renamed from: d */
    private static final byte[] f34876d = new byte[0];

    /* renamed from: b */
    private final SSLContext f34877b;

    /* renamed from: e */
    private boolean f34878e;

    private C7510m(boolean z10) throws NoSuchAlgorithmException, KeyManagementException {
        SecureRandom secureRandom;
        this.f34878e = true;
        this.f34877b = z10 ? C7795co.m48076a() : SSLContext.getInstance("TLS");
        this.f34878e = z10;
        TrustManager[] trustManagerArrM45968a = HttpsConfig.m45968a();
        trustManagerArrM45968a = trustManagerArrM45968a.length == 0 ? null : trustManagerArrM45968a;
        try {
            secureRandom = SecureRandom.getInstanceStrong();
        } catch (Exception unused) {
            secureRandom = new SecureRandom();
        }
        this.f34877b.init(null, trustManagerArrM45968a, secureRandom);
    }

    /* renamed from: a */
    public static SSLSocketFactory m46086a(boolean z10) {
        String str;
        String str2;
        synchronized (f34876d) {
            try {
                try {
                    try {
                        if (f34875c == null) {
                            f34875c = new C7510m(z10);
                        }
                        return f34875c;
                    } catch (KeyManagementException unused) {
                        str = f34874a;
                        str2 = "Failed to new SSLSocketFactory instance. KeyManagementException";
                        AbstractC7185ho.m43823c(str, str2);
                        return null;
                    } catch (KeyStoreException unused2) {
                        str = f34874a;
                        str2 = "Failed to new SSLSocketFactory instance. KeyStoreException";
                        AbstractC7185ho.m43823c(str, str2);
                        return null;
                    } catch (NoSuchAlgorithmException unused3) {
                        str = f34874a;
                        str2 = "Failed to new SSLSocketFactory instance. NoSuchAlgorithmException";
                        AbstractC7185ho.m43823c(str, str2);
                        return null;
                    }
                } catch (GeneralSecurityException unused4) {
                    str = f34874a;
                    str2 = "Failed to new SSLSocketFactory instance. GeneralSecurityException";
                    AbstractC7185ho.m43823c(str, str2);
                    return null;
                } catch (Exception unused5) {
                    str = f34874a;
                    str2 = "Failed to new SSLSocketFactory instance. Exception";
                    AbstractC7185ho.m43823c(str, str2);
                    return null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    private static void m46089b(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        if (enabledCipherSuites == null || enabledCipherSuites.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            if (!AbstractC7796cp.m48079a(str)) {
                arrayList.add(str);
            }
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        Socket socketCreateSocket = this.f34877b.getSocketFactory().createSocket(str, i10);
        m46087a(socketCreateSocket);
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

    /* renamed from: a */
    private void m46087a(Socket socket) {
        if ((socket instanceof SSLSocket) && this.f34878e) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            m46088a(sSLSocket);
            m46089b(sSLSocket);
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException {
        Socket socketCreateSocket = this.f34877b.getSocketFactory().createSocket(str, i10, inetAddress, i11);
        m46087a(socketCreateSocket);
        return socketCreateSocket;
    }

    /* renamed from: a */
    private void m46088a(SSLSocket sSLSocket) {
        if (sSLSocket != null) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) throws IOException {
        Socket socketCreateSocket = this.f34877b.getSocketFactory().createSocket(inetAddress, i10);
        m46087a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
        Socket socketCreateSocket = this.f34877b.getSocketFactory().createSocket(inetAddress, i10, inetAddress2, i11);
        m46087a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        Socket socketCreateSocket = this.f34877b.getSocketFactory().createSocket(socket, str, i10, z10);
        m46087a(socketCreateSocket);
        return socketCreateSocket;
    }
}
