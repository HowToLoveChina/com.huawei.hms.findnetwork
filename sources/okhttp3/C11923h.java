package okhttp3;

import com.huawei.hms.network.embedded.C6126v6;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import p022ay.C1057g;
import p858zx.AbstractC14402c;

/* renamed from: okhttp3.h */
/* loaded from: classes9.dex */
public final class C11923h {

    /* renamed from: c */
    public static final C11923h f55319c = new a().m71628a();

    /* renamed from: a */
    public final Set<b> f55320a;

    /* renamed from: b */
    public final AbstractC14402c f55321b;

    /* renamed from: okhttp3.h$a */
    public static final class a {

        /* renamed from: a */
        public final List<b> f55322a = new ArrayList();

        /* renamed from: a */
        public C11923h m71628a() {
            return new C11923h(new LinkedHashSet(this.f55322a), null);
        }
    }

    /* renamed from: okhttp3.h$b */
    public static final class b {

        /* renamed from: a */
        public final String f55323a;

        /* renamed from: b */
        public final String f55324b;

        /* renamed from: c */
        public final String f55325c;

        /* renamed from: d */
        public final C1057g f55326d;

        /* renamed from: a */
        public boolean m71629a(String str) {
            if (!this.f55323a.startsWith(C6126v6.b.f28650e)) {
                return str.equals(this.f55324b);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 == this.f55324b.length()) {
                String str2 = this.f55324b;
                if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f55323a.equals(bVar.f55323a) && this.f55325c.equals(bVar.f55325c) && this.f55326d.equals(bVar.f55326d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f55323a.hashCode()) * 31) + this.f55325c.hashCode()) * 31) + this.f55326d.hashCode();
        }

        public String toString() {
            return this.f55325c + this.f55326d.mo6376b();
        }
    }

    public C11923h(Set<b> set, AbstractC14402c abstractC14402c) {
        this.f55320a = set;
        this.f55321b = abstractC14402c;
    }

    /* renamed from: c */
    public static String m71622c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + m71624e((X509Certificate) certificate).mo6376b();
    }

    /* renamed from: d */
    public static C1057g m71623d(X509Certificate x509Certificate) {
        return C1057g.m6365x(x509Certificate.getPublicKey().getEncoded()).m6368C();
    }

    /* renamed from: e */
    public static C1057g m71624e(X509Certificate x509Certificate) {
        return C1057g.m6365x(x509Certificate.getPublicKey().getEncoded()).m6369D();
    }

    /* renamed from: a */
    public void m71625a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> listM71626b = m71626b(str);
        if (listM71626b.isEmpty()) {
            return;
        }
        AbstractC14402c abstractC14402c = this.f55321b;
        if (abstractC14402c != null) {
            list = abstractC14402c.mo83261a(list, str);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i10);
            int size2 = listM71626b.size();
            C1057g c1057gM71624e = null;
            C1057g c1057gM71623d = null;
            for (int i11 = 0; i11 < size2; i11++) {
                b bVar = listM71626b.get(i11);
                if (bVar.f55325c.equals("sha256/")) {
                    if (c1057gM71624e == null) {
                        c1057gM71624e = m71624e(x509Certificate);
                    }
                    if (bVar.f55326d.equals(c1057gM71624e)) {
                        return;
                    }
                } else {
                    if (!bVar.f55325c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f55325c);
                    }
                    if (c1057gM71623d == null) {
                        c1057gM71623d = m71623d(x509Certificate);
                    }
                    if (bVar.f55326d.equals(c1057gM71623d)) {
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
            sb2.append(m71622c(x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(str);
        sb2.append(":");
        int size4 = listM71626b.size();
        for (int i13 = 0; i13 < size4; i13++) {
            b bVar2 = listM71626b.get(i13);
            sb2.append("\n    ");
            sb2.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb2.toString());
    }

    /* renamed from: b */
    public List<b> m71626b(String str) {
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.f55320a) {
            if (bVar.m71629a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C11923h) {
            C11923h c11923h = (C11923h) obj;
            if (Objects.equals(this.f55321b, c11923h.f55321b) && this.f55320a.equals(c11923h.f55320a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public C11923h m71627f(AbstractC14402c abstractC14402c) {
        return Objects.equals(this.f55321b, abstractC14402c) ? this : new C11923h(this.f55320a, abstractC14402c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f55321b) * 31) + this.f55320a.hashCode();
    }
}
