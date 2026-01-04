package com.huawei.hms.drive;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* renamed from: com.huawei.hms.drive.av */
/* loaded from: classes8.dex */
public final class C5189av {

    /* renamed from: a */
    private final EnumC5206bk f23776a;

    /* renamed from: b */
    private final C5180am f23777b;

    /* renamed from: c */
    private final List<Certificate> f23778c;

    /* renamed from: d */
    private final List<Certificate> f23779d;

    private C5189av(EnumC5206bk enumC5206bk, C5180am c5180am, List<Certificate> list, List<Certificate> list2) {
        this.f23776a = enumC5206bk;
        this.f23777b = c5180am;
        this.f23778c = list;
        this.f23779d = list2;
    }

    /* renamed from: a */
    public static C5189av m30913a(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        C5180am c5180amM30847a = C5180am.m30847a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        EnumC5206bk enumC5206bkM31166a = EnumC5206bk.m31166a(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listM31186a = peerCertificates != null ? C5210bo.m31186a(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new C5189av(enumC5206bkM31166a, c5180amM30847a, listM31186a, localCertificates != null ? C5210bo.m31186a(localCertificates) : Collections.emptyList());
    }

    /* renamed from: b */
    public List<Certificate> m30916b() {
        return this.f23778c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5189av)) {
            return false;
        }
        C5189av c5189av = (C5189av) obj;
        return this.f23776a.equals(c5189av.f23776a) && this.f23777b.equals(c5189av.f23777b) && this.f23778c.equals(c5189av.f23778c) && this.f23779d.equals(c5189av.f23779d);
    }

    public int hashCode() {
        return ((((((527 + this.f23776a.hashCode()) * 31) + this.f23777b.hashCode()) * 31) + this.f23778c.hashCode()) * 31) + this.f23779d.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.f23776a + " cipherSuite=" + this.f23777b + " peerCertificates=" + m30914a(this.f23778c) + " localCertificates=" + m30914a(this.f23779d) + '}';
    }

    /* renamed from: a */
    public C5180am m30915a() {
        return this.f23777b;
    }

    /* renamed from: a */
    private List<String> m30914a(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }
}
