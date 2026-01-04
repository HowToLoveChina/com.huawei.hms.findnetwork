package com.huawei.openalliance.p169ad.net.http;

import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.exception.C7112d;
import java.net.HttpURLConnection;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.C11912b0;

@OuterVisible
/* loaded from: classes2.dex */
public abstract class HttpsConfig {

    /* renamed from: a */
    private static SSLSocketFactory f34786a;

    /* renamed from: b */
    private static X509TrustManager f34787b;

    /* renamed from: a */
    public static HttpClient.Builder m45963a(HttpClient.Builder builder, boolean z10, boolean z11) throws NoSuchAlgorithmException, KeyStoreException, C7112d {
        SSLSocketFactory sSLSocketFactoryM46086a;
        X509TrustManager x509TrustManagerM45969b;
        if (!z10) {
            sSLSocketFactoryM46086a = f34786a;
            X509TrustManager x509TrustManager = f34787b;
            if (sSLSocketFactoryM46086a == null) {
                sSLSocketFactoryM46086a = C7510m.m46086a(z11);
            }
            if (x509TrustManager != null) {
                x509TrustManagerM45969b = x509TrustManager;
            }
            if (sSLSocketFactoryM46086a != null || x509TrustManagerM45969b == null) {
                throw new C7112d("No ssl socket factory or trust manager set");
            }
            builder.sslSocketFactory(sSLSocketFactoryM46086a, x509TrustManagerM45969b);
            return builder;
        }
        sSLSocketFactoryM46086a = C7510m.m46086a(z11);
        x509TrustManagerM45969b = m45969b();
        if (sSLSocketFactoryM46086a != null) {
        }
        throw new C7112d("No ssl socket factory or trust manager set");
    }

    /* renamed from: b */
    private static X509TrustManager m45969b() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(KeyStore.getInstance(KeyStore.getDefaultType()));
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m45964a(HttpURLConnection httpURLConnection, boolean z10, boolean z11) throws C7112d {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLSocketFactory sSLSocketFactoryM46086a = f34786a;
            if (z10 || sSLSocketFactoryM46086a == null) {
                sSLSocketFactoryM46086a = C7510m.m46086a(z11);
            }
            if (sSLSocketFactoryM46086a == null) {
                throw new C7112d("No ssl socket factory set");
            }
            httpsURLConnection.setSSLSocketFactory(sSLSocketFactoryM46086a);
        }
    }

    /* renamed from: a */
    public static void m45965a(SSLSocketFactory sSLSocketFactory) {
        f34786a = sSLSocketFactory;
    }

    /* renamed from: a */
    public static void m45966a(X509TrustManager x509TrustManager) {
        f34787b = x509TrustManager;
    }

    /* renamed from: a */
    public static void m45967a(C11912b0.c cVar, boolean z10, boolean z11) throws NoSuchAlgorithmException, KeyStoreException, C7112d {
        SSLSocketFactory sSLSocketFactoryM46086a;
        X509TrustManager x509TrustManagerM45969b;
        if (!z10) {
            sSLSocketFactoryM46086a = f34786a;
            X509TrustManager x509TrustManager = f34787b;
            if (sSLSocketFactoryM46086a == null) {
                sSLSocketFactoryM46086a = C7510m.m46086a(z11);
            }
            if (x509TrustManager != null) {
                x509TrustManagerM45969b = x509TrustManager;
            }
            if (sSLSocketFactoryM46086a != null || x509TrustManagerM45969b == null) {
                throw new C7112d("No ssl socket factory or trust manager set");
            }
            cVar.m71521r(sSLSocketFactoryM46086a, x509TrustManagerM45969b);
            return;
        }
        sSLSocketFactoryM46086a = C7510m.m46086a(z11);
        x509TrustManagerM45969b = m45969b();
        if (sSLSocketFactoryM46086a != null) {
        }
        throw new C7112d("No ssl socket factory or trust manager set");
    }

    /* renamed from: a */
    public static TrustManager[] m45968a() {
        return new TrustManager[0];
    }
}
