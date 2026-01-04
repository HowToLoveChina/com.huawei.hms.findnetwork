package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import sx.C12875e;

/* renamed from: okhttp3.u */
/* loaded from: classes9.dex */
public final class C11954u {

    /* renamed from: a */
    public final EnumC11943j0 f55645a;

    /* renamed from: b */
    public final C11942j f55646b;

    /* renamed from: c */
    public final List<Certificate> f55647c;

    /* renamed from: d */
    public final List<Certificate> f55648d;

    public C11954u(EnumC11943j0 enumC11943j0, C11942j c11942j, List<Certificate> list, List<Certificate> list2) {
        this.f55645a = enumC11943j0;
        this.f55646b = c11942j;
        this.f55647c = list;
        this.f55648d = list2;
    }

    /* renamed from: b */
    public static C11954u m71843b(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        C11942j c11942jM71786b = C11942j.m71786b(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        EnumC11943j0 enumC11943j0M71792b = EnumC11943j0.m71792b(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listM77264u = peerCertificates != null ? C12875e.m77264u(peerCertificates) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new C11954u(enumC11943j0M71792b, c11942jM71786b, listM77264u, localCertificates != null ? C12875e.m77264u(localCertificates) : Collections.emptyList());
    }

    /* renamed from: a */
    public C11942j m71844a() {
        return this.f55646b;
    }

    /* renamed from: c */
    public final List<String> m71845c(List<Certificate> list) {
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

    /* renamed from: d */
    public List<Certificate> m71846d() {
        return this.f55647c;
    }

    /* renamed from: e */
    public EnumC11943j0 m71847e() {
        return this.f55645a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C11954u)) {
            return false;
        }
        C11954u c11954u = (C11954u) obj;
        return this.f55645a.equals(c11954u.f55645a) && this.f55646b.equals(c11954u.f55646b) && this.f55647c.equals(c11954u.f55647c) && this.f55648d.equals(c11954u.f55648d);
    }

    public int hashCode() {
        return ((((((527 + this.f55645a.hashCode()) * 31) + this.f55646b.hashCode()) * 31) + this.f55647c.hashCode()) * 31) + this.f55648d.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.f55645a + " cipherSuite=" + this.f55646b + " peerCertificates=" + m71845c(this.f55647c) + " localCertificates=" + m71845c(this.f55648d) + '}';
    }
}
