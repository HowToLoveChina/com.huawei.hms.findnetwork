package com.huawei.hms.network.embedded;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: com.huawei.hms.network.embedded.v6 */
/* loaded from: classes8.dex */
public final class C6126v6 {

    /* renamed from: c */
    public static final C6126v6 f28646c = new a().m35569a();

    /* renamed from: a */
    public final Set<b> f28647a;

    /* renamed from: b */
    public final AbstractC6065qa f28648b;

    /* renamed from: com.huawei.hms.network.embedded.v6$a */
    public static final class a {

        /* renamed from: a */
        public final List<b> f28649a = new ArrayList();

        /* renamed from: a */
        public a m35568a(String str, String... strArr) {
            if (str == null) {
                throw new NullPointerException("pattern == null");
            }
            for (String str2 : strArr) {
                this.f28649a.add(new b(str, str2));
            }
            return this;
        }

        /* renamed from: a */
        public C6126v6 m35569a() {
            return new C6126v6(new LinkedHashSet(this.f28649a), null);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v6$b */
    public static final class b {

        /* renamed from: e */
        public static final String f28650e = "*.";

        /* renamed from: a */
        public final String f28651a;

        /* renamed from: b */
        public final String f28652b;

        /* renamed from: c */
        public final String f28653c;

        /* renamed from: d */
        public final C5910eb f28654d;

        public b(String str, String str2) {
            StringBuilder sb2;
            int i10;
            this.f28651a = str;
            if (str.startsWith(f28650e)) {
                sb2 = new StringBuilder();
                sb2.append("http://");
                str = str.substring(2);
            } else {
                sb2 = new StringBuilder();
                sb2.append("http://");
            }
            sb2.append(str);
            this.f28652b = C6010m7.m34781f(sb2.toString()).m34797h();
            if (str2.startsWith("sha1/")) {
                this.f28653c = "sha1/";
                i10 = 5;
            } else {
                if (!str2.startsWith("sha256/")) {
                    throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
                }
                this.f28653c = "sha256/";
                i10 = 7;
            }
            this.f28654d = C5910eb.m34148a(str2.substring(i10));
            if (this.f28654d != null) {
                return;
            }
            throw new IllegalArgumentException("pins must be base64: " + str2);
        }

        /* renamed from: a */
        public boolean m35570a(String str) {
            if (!this.f28651a.startsWith(f28650e)) {
                return str.equals(this.f28652b);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 == this.f28652b.length()) {
                String str2 = this.f28652b;
                if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f28651a.equals(bVar.f28651a) && this.f28653c.equals(bVar.f28653c) && this.f28654d.equals(bVar.f28654d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f28651a.hashCode() + 527) * 31) + this.f28653c.hashCode()) * 31) + this.f28654d.hashCode();
        }

        public String toString() {
            return this.f28653c + this.f28654d.mo34175b();
        }
    }

    public C6126v6(Set<b> set, AbstractC6065qa abstractC6065qa) {
        this.f28647a = set;
        this.f28648b = abstractC6065qa;
    }

    /* renamed from: a */
    public static C5910eb m35561a(X509Certificate x509Certificate) {
        return C5910eb.m34158e(x509Certificate.getPublicKey().getEncoded()).mo34188g();
    }

    /* renamed from: b */
    public static C5910eb m35563b(X509Certificate x509Certificate) {
        return C5910eb.m34158e(x509Certificate.getPublicKey().getEncoded()).mo34189h();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C6126v6) {
            C6126v6 c6126v6 = (C6126v6) obj;
            if (Objects.equals(this.f28648b, c6126v6.f28648b) && this.f28647a.equals(c6126v6.f28647a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Objects.hashCode(this.f28648b) * 31) + this.f28647a.hashCode();
    }

    /* renamed from: a */
    public C6126v6 m35564a(AbstractC6065qa abstractC6065qa) {
        return Objects.equals(this.f28648b, abstractC6065qa) ? this : new C6126v6(this.f28647a, abstractC6065qa);
    }

    /* renamed from: a */
    public static String m35562a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + m35563b((X509Certificate) certificate).mo34175b();
    }

    /* renamed from: a */
    public List<b> m35565a(String str) {
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.f28647a) {
            if (bVar.m35570a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    /* renamed from: a */
    public void m35566a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> listM35565a = m35565a(str);
        if (listM35565a.isEmpty()) {
            return;
        }
        AbstractC6065qa abstractC6065qa = this.f28648b;
        if (abstractC6065qa != null) {
            list = abstractC6065qa.mo34338a(list, str);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i10);
            int size2 = listM35565a.size();
            C5910eb c5910ebM35563b = null;
            C5910eb c5910ebM35561a = null;
            for (int i11 = 0; i11 < size2; i11++) {
                b bVar = listM35565a.get(i11);
                if (bVar.f28653c.equals("sha256/")) {
                    if (c5910ebM35563b == null) {
                        c5910ebM35563b = m35563b(x509Certificate);
                    }
                    if (bVar.f28654d.equals(c5910ebM35563b)) {
                        return;
                    }
                } else {
                    if (!bVar.f28653c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f28653c);
                    }
                    if (c5910ebM35561a == null) {
                        c5910ebM35561a = m35561a(x509Certificate);
                    }
                    if (bVar.f28654d.equals(c5910ebM35561a)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate pinning failure!");
        sb2.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i12 = 0; i12 < size3; i12++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i12);
            sb2.append("\n    ");
            sb2.append(m35562a((Certificate) x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(str);
        sb2.append(":");
        int size4 = listM35565a.size();
        for (int i13 = 0; i13 < size4; i13++) {
            b bVar2 = listM35565a.get(i13);
            sb2.append("\n    ");
            sb2.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb2.toString());
    }

    /* renamed from: a */
    public void m35567a(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        m35566a(str, Arrays.asList(certificateArr));
    }
}
