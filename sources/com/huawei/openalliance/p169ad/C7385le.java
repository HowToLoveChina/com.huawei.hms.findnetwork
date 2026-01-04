package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.utils.AbstractC7805cy;
import java.io.Closeable;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.openalliance.ad.le */
/* loaded from: classes8.dex */
public class C7385le implements X509TrustManager {

    /* renamed from: a */
    protected List<X509TrustManager> f34308a = new ArrayList();

    public C7385le(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        InputStream inputStreamOpen = null;
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            KeyStore keyStore = KeyStore.getInstance("bks");
            inputStreamOpen = context.getAssets().open("hiadrootcas.bks");
            inputStreamOpen.reset();
            keyStore.load(inputStreamOpen, "".toCharArray());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.f34308a.add((X509TrustManager) trustManager);
                }
            }
            if (this.f34308a.isEmpty()) {
                throw new CertificateException("X509TrustManager is empty");
            }
            AbstractC7805cy.m48142a((Closeable) inputStreamOpen);
        } catch (Throwable th2) {
            AbstractC7805cy.m48142a((Closeable) inputStreamOpen);
            throw th2;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (this.f34308a.isEmpty()) {
            throw new CertificateException("checkClientTrusted CertificateException");
        }
        this.f34308a.get(0).checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (this.f34308a.isEmpty()) {
            throw new CertificateException("checkServerTrusted CertificateException");
        }
        this.f34308a.get(0).checkServerTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f34308a.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e10) {
            AbstractC7185ho.m43826d("SecureX509TrustManager", "getAcceptedIssuers exception : " + e10.getClass().getSimpleName());
            return new X509Certificate[0];
        }
    }
}
