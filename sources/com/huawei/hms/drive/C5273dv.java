package com.huawei.hms.drive;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.huawei.hms.drive.dv */
/* loaded from: classes8.dex */
public final class C5273dv implements InterfaceC5276dy {

    /* renamed from: a */
    private final Map<X500Principal, Set<X509Certificate>> f24502a = new LinkedHashMap();

    public C5273dv(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> linkedHashSet = this.f24502a.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>(1);
                this.f24502a.put(subjectX500Principal, linkedHashSet);
            }
            linkedHashSet.add(x509Certificate);
        }
    }

    @Override // com.huawei.hms.drive.InterfaceC5276dy
    /* renamed from: a */
    public X509Certificate mo31663a(X509Certificate x509Certificate) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        Set<X509Certificate> set = this.f24502a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C5273dv) && ((C5273dv) obj).f24502a.equals(this.f24502a);
    }

    public int hashCode() {
        return this.f24502a.hashCode();
    }
}
