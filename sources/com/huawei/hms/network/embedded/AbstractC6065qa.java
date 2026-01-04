package com.huawei.hms.network.embedded;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.hms.network.embedded.qa */
/* loaded from: classes8.dex */
public abstract class AbstractC6065qa {
    /* renamed from: a */
    public static AbstractC6065qa m35163a(X509TrustManager x509TrustManager) {
        return C6013ma.m34863f().mo34329a(x509TrustManager);
    }

    /* renamed from: a */
    public abstract List<Certificate> mo34338a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    /* renamed from: a */
    public static AbstractC6065qa m35164a(X509Certificate... x509CertificateArr) {
        return new C6039oa(new C6052pa(x509CertificateArr));
    }
}
