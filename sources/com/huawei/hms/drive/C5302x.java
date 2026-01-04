package com.huawei.hms.drive;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.drive.x */
/* loaded from: classes8.dex */
public class C5302x implements X509TrustManager {

    /* renamed from: a */
    protected List<X509TrustManager> f24584a;

    /* renamed from: b */
    private X509Certificate[] f24585b;

    public C5302x(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    /* renamed from: a */
    private void m31830a() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        C5170ac.m30795b("SX509TM", "loadSystemCA");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.f24584a.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
            C5170ac.m30796c("SX509TM", "loadSystemCA: exception : " + e10.getMessage());
        }
        C5170ac.m30794a("SX509TM", "loadSystemCA: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C5170ac.m30795b("SX509TM", "checkClientTrusted: ");
        Iterator<X509TrustManager> it = this.f24584a.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e10) {
                C5170ac.m30796c("SX509TM", "checkServerTrusted CertificateException" + e10.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        m31834a(x509CertificateArr);
        C5170ac.m30795b("SX509TM", "checkServerTrusted begin,size=" + x509CertificateArr.length + ",authType=" + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int length = x509CertificateArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            X509Certificate x509Certificate = x509CertificateArr[i10];
            C5170ac.m30794a("SX509TM", "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            C5170ac.m30794a("SX509TM", "IssuerDN :" + x509Certificate.getIssuerDN());
            C5170ac.m30794a("SX509TM", "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.f24584a.size();
        for (int i11 = 0; i11 < size; i11++) {
            try {
                C5170ac.m30795b("SX509TM", "check server i=" + i11);
                X509TrustManager x509TrustManager = this.f24584a.get(i11);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    C5170ac.m30795b("SX509TM", "client root ca size=" + acceptedIssuers.length);
                    for (int i12 = 0; i12 < acceptedIssuers.length; i12++) {
                        C5170ac.m30794a("SX509TM", "client root ca getIssuerDN :" + acceptedIssuers[i12].getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                C5170ac.m30795b("SX509TM", "checkServerTrusted end, " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e10) {
                C5170ac.m30796c("SX509TM", "checkServerTrusted error :" + e10.getMessage() + " , time : " + i11);
                if (i11 == size - 1) {
                    if (x509CertificateArr.length > 0) {
                        C5170ac.m30796c("SX509TM", "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e10;
                }
            }
        }
        C5170ac.m30794a("SX509TM", "checkServerTrusted: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f24584a.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e10) {
            C5170ac.m30796c("SX509TM", "getAcceptedIssuers exception : " + e10.getMessage());
            return new X509Certificate[0];
        }
    }

    public C5302x(Context context, boolean z10) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, IllegalArgumentException {
        this.f24584a = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        C5304z.m31839a(context);
        if (z10) {
            m31830a();
        }
        m31831a(context);
        if (this.f24584a.isEmpty()) {
            throw new CertificateException("X509TrustManager is empty");
        }
    }

    public C5302x(InputStream inputStream, String str) throws IOException, IllegalArgumentException {
        this.f24584a = new ArrayList();
        m31833a(inputStream, str);
    }

    /* renamed from: a */
    public void m31834a(X509Certificate[] x509CertificateArr) {
        this.f24585b = x509CertificateArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m31831a(android.content.Context r7) throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.KeyStoreException, java.security.cert.CertificateException {
        /*
            r6 = this;
            java.lang.String r0 = "loadBksCA"
            java.lang.String r1 = "SX509TM"
            com.huawei.hms.drive.C5170ac.m30795b(r1, r0)
            long r2 = java.lang.System.currentTimeMillis()
            java.io.InputStream r0 = com.huawei.hms.drive.C5303y.m31835a(r7)
            if (r0 == 0) goto L34
            java.lang.String r4 = "get bks not from assets"
            com.huawei.hms.drive.C5170ac.m30795b(r1, r4)     // Catch: java.lang.Throwable -> L1a
            r6.m31832a(r0)     // Catch: java.lang.Throwable -> L1a
            goto L34
        L1a:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "loadBksCA: exception : "
            r4.append(r5)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.huawei.hms.drive.C5170ac.m30796c(r1, r0)
            goto L36
        L34:
            if (r0 != 0) goto L48
        L36:
            java.lang.String r0 = " get bks from assets "
            com.huawei.hms.drive.C5170ac.m30795b(r1, r0)
            android.content.res.AssetManager r7 = r7.getAssets()
            java.lang.String r0 = "hmsrootcas.bks"
            java.io.InputStream r7 = r7.open(r0)
            r6.m31832a(r7)
        L48:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "loadBksCA: cost : "
            r6.append(r7)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            r6.append(r4)
            java.lang.String r7 = " ms"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.huawei.hms.drive.C5170ac.m30794a(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5302x.m31831a(android.content.Context):void");
    }

    /* renamed from: a */
    private void m31832a(InputStream inputStream) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, "".toCharArray());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.f24584a.add((X509TrustManager) trustManager);
                }
            }
        } finally {
            AbstractC5169ab.m30792a(inputStream);
        }
    }

    /* renamed from: a */
    private void m31833a(InputStream inputStream, String str) throws IOException {
        if (inputStream != null && str != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                KeyStore keyStore = KeyStore.getInstance("bks");
                keyStore.load(inputStream, str.toCharArray());
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                for (TrustManager trustManager : trustManagers) {
                    if (trustManager instanceof X509TrustManager) {
                        this.f24584a.add((X509TrustManager) trustManager);
                    }
                }
            } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
                C5170ac.m30796c("SX509TM", "loadInputStream: exception : " + e10.getMessage());
            } finally {
                AbstractC5169ab.m30792a(inputStream);
            }
            C5170ac.m30794a("SX509TM", "loadInputStream: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            return;
        }
        throw new IllegalArgumentException("inputstream or trustPwd is null");
    }
}
