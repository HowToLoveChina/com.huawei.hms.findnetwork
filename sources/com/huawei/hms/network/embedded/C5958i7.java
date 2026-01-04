package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* renamed from: com.huawei.hms.network.embedded.i7 */
/* loaded from: classes8.dex */
public final class C5958i7 {

    /* renamed from: a */
    public final EnumC6166y7 f27026a;

    /* renamed from: b */
    public final C6152x6 f27027b;

    /* renamed from: c */
    public final List<Certificate> f27028c;

    /* renamed from: d */
    public final List<Certificate> f27029d;

    public C5958i7(EnumC6166y7 enumC6166y7, C6152x6 c6152x6, List<Certificate> list, List<Certificate> list2) {
        this.f27026a = enumC6166y7;
        this.f27027b = c6152x6;
        this.f27028c = list;
        this.f27029d = list2;
    }

    /* renamed from: a */
    public static C5958i7 m34385a(EnumC6166y7 enumC6166y7, C6152x6 c6152x6, List<Certificate> list, List<Certificate> list2) {
        if (enumC6166y7 == null) {
            throw new NullPointerException("tlsVersion == null");
        }
        if (c6152x6 != null) {
            return new C5958i7(enumC6166y7, c6152x6, C5920f8.m34242a(list), C5920f8.m34242a(list2));
        }
        throw new NullPointerException("cipherSuite == null");
    }

    /* renamed from: b */
    public List<Certificate> m34389b() {
        return this.f27029d;
    }

    /* renamed from: c */
    public Principal m34390c() {
        if (this.f27029d.isEmpty()) {
            return null;
        }
        return ((X509Certificate) this.f27029d.get(0)).getSubjectX500Principal();
    }

    /* renamed from: d */
    public List<Certificate> m34391d() {
        return this.f27028c;
    }

    /* renamed from: e */
    public Principal m34392e() {
        if (this.f27028c.isEmpty()) {
            return null;
        }
        return ((X509Certificate) this.f27028c.get(0)).getSubjectX500Principal();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5958i7)) {
            return false;
        }
        C5958i7 c5958i7 = (C5958i7) obj;
        return this.f27026a.equals(c5958i7.f27026a) && this.f27027b.equals(c5958i7.f27027b) && this.f27028c.equals(c5958i7.f27028c) && this.f27029d.equals(c5958i7.f27029d);
    }

    /* renamed from: f */
    public EnumC6166y7 m34393f() {
        return this.f27026a;
    }

    public int hashCode() {
        return ((((((this.f27026a.hashCode() + 527) * 31) + this.f27027b.hashCode()) * 31) + this.f27028c.hashCode()) * 31) + this.f27029d.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.f27026a + " cipherSuite=" + this.f27027b + " peerCertificates=" + m34387a(this.f27028c) + " localCertificates=" + m34387a(this.f27029d) + '}';
    }

    /* renamed from: a */
    public static C5958i7 m34386a(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        C6152x6 c6152x6M35782a = C6152x6.m35782a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        EnumC6166y7 enumC6166y7M35840a = EnumC6166y7.m35840a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listM34243a = peerCertificates != null ? C5920f8.m34243a(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new C5958i7(enumC6166y7M35840a, c6152x6M35782a, listM34243a, localCertificates != null ? C5920f8.m34243a(localCertificates) : Collections.emptyList());
    }

    /* renamed from: a */
    public C6152x6 m34388a() {
        return this.f27027b;
    }

    /* renamed from: a */
    private List<String> m34387a(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            arrayList.add(certificate instanceof X509Certificate ? String.valueOf(((X509Certificate) certificate).getSubjectDN()) : certificate.getType());
        }
        return arrayList;
    }
}
