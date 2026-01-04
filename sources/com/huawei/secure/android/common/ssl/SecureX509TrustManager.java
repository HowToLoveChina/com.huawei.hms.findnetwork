package com.huawei.secure.android.common.ssl;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p435ku.AbstractC11159e;
import p435ku.C11156b;
import p435ku.C11160f;

/* loaded from: classes5.dex */
public class SecureX509TrustManager implements X509TrustManager {

    /* renamed from: c */
    public static final List<String> f40666c = Arrays.asList("7116473896668257942", "5339133492510690512");

    /* renamed from: a */
    public List<X509TrustManager> f40667a;

    /* renamed from: b */
    public X509Certificate[] f40668b;

    public SecureX509TrustManager(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    /* renamed from: e */
    public static void m53583e(KeyStore keyStore) throws KeyStoreException {
        Enumeration<String> enumerationAliases = keyStore.aliases();
        while (enumerationAliases.hasMoreElements()) {
            String strNextElement = enumerationAliases.nextElement();
            Certificate certificate = keyStore.getCertificate(strNextElement);
            if (certificate instanceof X509Certificate) {
                if (f40666c.contains(((X509Certificate) certificate).getSerialNumber().toString(10))) {
                    C11160f.m67096e("SX509TM", "filter serial number.");
                    keyStore.deleteEntry(strNextElement);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m53584a() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        C11160f.m67096e("SX509TM", "loadSystemCA");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.f40667a.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
            C11160f.m67095d("SX509TM", "loadSystemCA: exception : " + e10.getMessage());
        }
        C11160f.m67093b("SX509TM", "loadSystemCA: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m53585b(android.content.Context r7) throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.KeyStoreException, java.security.cert.CertificateException {
        /*
            r6 = this;
            java.lang.String r0 = "loadBksCA"
            java.lang.String r1 = "SX509TM"
            p435ku.C11160f.m67096e(r1, r0)
            long r2 = java.lang.System.currentTimeMillis()
            java.io.InputStream r0 = p435ku.C11155a.m67081d(r7)
            if (r0 == 0) goto L34
            java.lang.String r4 = "get bks not from assets"
            p435ku.C11160f.m67096e(r1, r4)     // Catch: java.lang.Throwable -> L1a
            r6.m53586c(r0)     // Catch: java.lang.Throwable -> L1a
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
            p435ku.C11160f.m67095d(r1, r0)
            goto L36
        L34:
            if (r0 != 0) goto L48
        L36:
            java.lang.String r0 = " get bks from assets "
            p435ku.C11160f.m67096e(r1, r0)
            android.content.res.AssetManager r7 = r7.getAssets()
            java.lang.String r0 = "hmsrootcas.bks"
            java.io.InputStream r7 = r7.open(r0)
            r6.m53586c(r7)
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
            p435ku.C11160f.m67093b(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.SecureX509TrustManager.m53585b(android.content.Context):void");
    }

    /* renamed from: c */
    public final void m53586c(InputStream inputStream) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, "".toCharArray());
            m53583e(keyStore);
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.f40667a.add((X509TrustManager) trustManager);
                }
            }
        } finally {
            AbstractC11159e.m67091b(inputStream);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C11160f.m67096e("SX509TM", "checkClientTrusted: ");
        Iterator<X509TrustManager> it = this.f40667a.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e10) {
                C11160f.m67095d("SX509TM", "checkServerTrusted CertificateException" + e10.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        m53588f(x509CertificateArr);
        C11160f.m67096e("SX509TM", "checkServerTrusted begin,size=" + x509CertificateArr.length + ",authType=" + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int size = this.f40667a.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                C11160f.m67096e("SX509TM", "check server i=" + i10);
                X509TrustManager x509TrustManager = this.f40667a.get(i10);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    C11160f.m67096e("SX509TM", "client root ca size=" + acceptedIssuers.length);
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                C11160f.m67096e("SX509TM", "checkServerTrusted end, " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e10) {
                C11160f.m67095d("SX509TM", "checkServerTrusted error :" + e10.getMessage() + " , time : " + i10);
                if (i10 == size - 1) {
                    if (x509CertificateArr.length > 0) {
                        C11160f.m67095d("SX509TM", "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e10;
                }
            }
        }
        C11160f.m67093b("SX509TM", "checkServerTrusted: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    /* renamed from: d */
    public final void m53587d(InputStream inputStream, String str) throws IOException {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException("inputstream or trustPwd is null");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, str.toCharArray());
            m53583e(keyStore);
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.f40667a.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e10) {
            C11160f.m67095d("SX509TM", "loadInputStream: exception : " + e10.getMessage());
        } finally {
            AbstractC11159e.m67091b(inputStream);
        }
        C11160f.m67093b("SX509TM", "loadInputStream: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    /* renamed from: f */
    public void m53588f(X509Certificate[] x509CertificateArr) {
        this.f40668b = x509CertificateArr;
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f40667a.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e10) {
            C11160f.m67095d("SX509TM", "getAcceptedIssuers exception : " + e10.getMessage());
            return new X509Certificate[0];
        }
    }

    public SecureX509TrustManager(Context context, boolean z10) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, IllegalArgumentException {
        this.f40667a = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        C11156b.m67082a(context);
        m53585b(context);
        if (z10) {
            m53584a();
        }
        if (this.f40667a.isEmpty()) {
            throw new CertificateException("X509TrustManager is empty");
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IOException, IllegalArgumentException {
        this.f40667a = new ArrayList();
        m53587d(inputStream, str);
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z10) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, IllegalArgumentException {
        this.f40667a = new ArrayList();
        m53587d(inputStream, str);
        if (z10) {
            m53584a();
        }
    }
}
