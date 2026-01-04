package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C8686g;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import p435ku.C11156b;
import p435ku.C11158d;
import p435ku.C11160f;

/* renamed from: com.huawei.secure.android.common.ssl.c */
/* loaded from: classes5.dex */
public class C8685c implements X509TrustManager {

    /* renamed from: a */
    public X509Certificate f40669a;

    /* renamed from: b */
    public List<X509TrustManager> f40670b = new ArrayList();

    public C8685c(Context context) {
        if (context == null) {
            throw new NullPointerException("WebViewX509TrustManger context is null");
        }
        C11156b.m67082a(context);
        X509Certificate x509CertificateM53591c = new C8686g(context).m53591c();
        this.f40669a = x509CertificateM53591c;
        if (x509CertificateM53591c == null) {
            throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C11160f.m67096e("WebViewX509TrustManger", "checkClientTrusted");
        if (this.f40670b.isEmpty()) {
            throw new CertificateException("checkClientTrusted CertificateException");
        }
        this.f40670b.get(0).checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C11160f.m67096e("WebViewX509TrustManger", "checkServerTrusted");
        boolean zM67087d = false;
        for (int i10 = 0; i10 < x509CertificateArr.length; i10++) {
            C11160f.m67093b("WebViewX509TrustManger", "checkServerTrusted " + i10 + " : " + x509CertificateArr[i10].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i11 = 0; i11 < x509CertificateArr.length; i11++) {
            x509CertificateArr2[i11] = x509CertificateArr[(x509CertificateArr.length - 1) - i11];
        }
        CertificateException certificateException = new CertificateException("CBG root CA CertificateException");
        try {
            zM67087d = C11158d.m67087d(this.f40669a, x509CertificateArr2);
        } catch (InvalidKeyException e10) {
            C11160f.m67095d("WebViewX509TrustManger", "checkServerTrusted InvalidKeyException: " + e10.getMessage());
        } catch (NoSuchAlgorithmException e11) {
            C11160f.m67095d("WebViewX509TrustManger", "checkServerTrusted NoSuchAlgorithmException: " + e11.getMessage());
        } catch (NoSuchProviderException e12) {
            C11160f.m67095d("WebViewX509TrustManger", "checkServerTrusted NoSuchProviderException: " + e12.getMessage());
        } catch (SignatureException e13) {
            C11160f.m67095d("WebViewX509TrustManger", "checkServerTrusted SignatureException: " + e13.getMessage());
        } catch (CertificateException e14) {
            certificateException = e14;
            C11160f.m67095d("WebViewX509TrustManger", "checkServerTrusted CertificateException: " + certificateException.getMessage());
        }
        if (!zM67087d) {
            throw certificateException;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f40670b.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e10) {
            C11160f.m67095d("WebViewX509TrustManger", "getAcceptedIssuers exception : " + e10.getMessage());
            return new X509Certificate[0];
        }
    }
}
