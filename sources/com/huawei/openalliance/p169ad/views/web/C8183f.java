package com.huawei.openalliance.p169ad.views.web;

import android.content.Context;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import com.huawei.openalliance.p169ad.views.web.C8184g;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.openalliance.ad.views.web.f */
/* loaded from: classes2.dex */
public class C8183f {
    /* renamed from: a */
    private static List<X509TrustManager> m50694a(Context context) {
        ArrayList arrayList = new ArrayList();
        InputStream inputStreamOpen = null;
        try {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                KeyStore keyStore = KeyStore.getInstance("bks");
                inputStreamOpen = context.getAssets().open("hiadincas.bks");
                inputStreamOpen.reset();
                keyStore.load(inputStreamOpen, "".toCharArray());
                trustManagerFactory.init(keyStore);
                for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                    if (trustManager instanceof X509TrustManager) {
                        arrayList.add((X509TrustManager) trustManager);
                    }
                }
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
                Log.e("WebViewSSLCheck", "loadBksCA: exception : " + e10.getMessage());
            }
            return arrayList;
        } finally {
            AbstractC7805cy.m48142a((Closeable) inputStreamOpen);
        }
    }

    /* renamed from: a */
    public static void m50695a(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, C8184g.a aVar) {
        X509Certificate x509CertificateM50670a = C8178a.m50670a(sslError.getCertificate());
        Iterator<X509TrustManager> it = m50694a(context).iterator();
        while (it.hasNext()) {
            for (X509Certificate x509Certificate : m50696a(it.next())) {
                if (C8178a.m50671a(x509Certificate, x509CertificateM50670a)) {
                    Log.e("WebViewSSLCheck", "checkServerCertificateNew: proceed");
                    if (aVar != null) {
                        aVar.mo50687a(context, str);
                        return;
                    } else {
                        sslErrorHandler.proceed();
                        return;
                    }
                }
            }
        }
        Log.e("WebViewSSLCheck", "checkServerCertificateNew: cancel");
        if (aVar != null) {
            aVar.mo50688b(context, str);
        } else {
            sslErrorHandler.cancel();
        }
    }

    /* renamed from: a */
    private static X509Certificate[] m50696a(X509TrustManager x509TrustManager) {
        return x509TrustManager == null ? new X509Certificate[0] : x509TrustManager.getAcceptedIssuers();
    }
}
