package com.huawei.hms.drive;

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

/* renamed from: com.huawei.hms.drive.al */
/* loaded from: classes8.dex */
public final class C5179al {

    /* renamed from: a */
    public static final C5179al f23607a = new a().m30844a();

    /* renamed from: b */
    private final Set<b> f23608b;

    /* renamed from: c */
    private final AbstractC5274dw f23609c;

    /* renamed from: com.huawei.hms.drive.al$a */
    public static final class a {

        /* renamed from: a */
        private final List<b> f23610a = new ArrayList();

        /* renamed from: a */
        public C5179al m30844a() {
            return new C5179al(new LinkedHashSet(this.f23610a), null);
        }
    }

    /* renamed from: com.huawei.hms.drive.al$b */
    public static final class b {

        /* renamed from: a */
        final String f23611a;

        /* renamed from: b */
        final String f23612b;

        /* renamed from: c */
        final String f23613c;

        /* renamed from: d */
        final C1057g f23614d;

        /* renamed from: a */
        public boolean m30845a(String str) {
            if (!this.f23611a.startsWith(C6126v6.b.f28650e)) {
                return str.equals(this.f23612b);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 == this.f23612b.length()) {
                String str2 = this.f23612b;
                if (str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f23611a.equals(bVar.f23611a) && this.f23613c.equals(bVar.f23613c) && this.f23614d.equals(bVar.f23614d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f23611a.hashCode()) * 31) + this.f23613c.hashCode()) * 31) + this.f23614d.hashCode();
        }

        public String toString() {
            return this.f23613c + this.f23614d.mo6376b();
        }
    }

    public C5179al(Set<b> set, AbstractC5274dw abstractC5274dw) {
        this.f23608b = set;
        this.f23609c = abstractC5274dw;
    }

    /* renamed from: b */
    public static C1057g m30840b(X509Certificate x509Certificate) {
        return C1057g.m6365x(x509Certificate.getPublicKey().getEncoded()).m6369D();
    }

    /* renamed from: a */
    public void m30843a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> listM30842a = m30842a(str);
        if (listM30842a.isEmpty()) {
            return;
        }
        AbstractC5274dw abstractC5274dw = this.f23609c;
        if (abstractC5274dw != null) {
            list = abstractC5274dw.mo31662a(list, str);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i10);
            int size2 = listM30842a.size();
            C1057g c1057gM30840b = null;
            C1057g c1057gM30838a = null;
            for (int i11 = 0; i11 < size2; i11++) {
                b bVar = listM30842a.get(i11);
                if (bVar.f23613c.equals("sha256/")) {
                    if (c1057gM30840b == null) {
                        c1057gM30840b = m30840b(x509Certificate);
                    }
                    if (bVar.f23614d.equals(c1057gM30840b)) {
                        return;
                    }
                } else {
                    if (!bVar.f23613c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f23613c);
                    }
                    if (c1057gM30838a == null) {
                        c1057gM30838a = m30838a(x509Certificate);
                    }
                    if (bVar.f23614d.equals(c1057gM30838a)) {
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
            sb2.append(m30839a((Certificate) x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(str);
        sb2.append(":");
        int size4 = listM30842a.size();
        for (int i13 = 0; i13 < size4; i13++) {
            b bVar2 = listM30842a.get(i13);
            sb2.append("\n    ");
            sb2.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb2.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5179al) {
            C5179al c5179al = (C5179al) obj;
            if (Objects.equals(this.f23609c, c5179al.f23609c) && this.f23608b.equals(c5179al.f23608b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Objects.hashCode(this.f23609c) * 31) + this.f23608b.hashCode();
    }

    /* renamed from: a */
    public List<b> m30842a(String str) {
        List<b> listEmptyList = Collections.emptyList();
        for (b bVar : this.f23608b) {
            if (bVar.m30845a(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(bVar);
            }
        }
        return listEmptyList;
    }

    /* renamed from: a */
    public C5179al m30841a(AbstractC5274dw abstractC5274dw) {
        return Objects.equals(this.f23609c, abstractC5274dw) ? this : new C5179al(this.f23608b, abstractC5274dw);
    }

    /* renamed from: a */
    public static String m30839a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + m30840b((X509Certificate) certificate).mo6376b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    public static C1057g m30838a(X509Certificate x509Certificate) {
        return C1057g.m6365x(x509Certificate.getPublicKey().getEncoded()).m6368C();
    }
}
