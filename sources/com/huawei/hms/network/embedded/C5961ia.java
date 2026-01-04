package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

/* renamed from: com.huawei.hms.network.embedded.ia */
/* loaded from: classes8.dex */
public class C5961ia extends C6013ma {
    /* renamed from: i */
    public static C5961ia m34421i() throws ClassNotFoundException {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new C5961ia();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: j */
    private Provider m34422j() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: a */
    public void mo34271a(SSLSocket sSLSocket, String str, List<EnumC6075r7> list) throws IOException {
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.mo34271a(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setHostname(sSLSocket, str);
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) C6013ma.m34858a(list).toArray(new String[0]));
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: b */
    public String mo34272b(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.mo34272b(sSLSocket);
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: c */
    public X509TrustManager mo34337c(SSLSocketFactory sSLSocketFactory) {
        if (!Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.mo34337c(sSLSocketFactory);
        }
        try {
            Object objM34857a = C6013ma.m34857a(sSLSocketFactory, (Class<Object>) Object.class, "sslParameters");
            if (objM34857a != null) {
                return (X509TrustManager) C6013ma.m34857a(objM34857a, X509TrustManager.class, "x509TrustManager");
            }
            return null;
        } catch (Exception e10) {
            throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: b */
    public SSLContext mo34335b() {
        try {
            return SSLContext.getInstance("TLSv1.3", m34422j());
        } catch (NoSuchAlgorithmException e10) {
            try {
                return SSLContext.getInstance("TLS", this.m34422j());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e10);
            }
        }
    }

    @Override // com.huawei.hms.network.embedded.C6013ma
    /* renamed from: b */
    public void mo34423b(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }
}
