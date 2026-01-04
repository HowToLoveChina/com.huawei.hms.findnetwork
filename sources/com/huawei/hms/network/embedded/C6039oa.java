package com.huawei.hms.network.embedded;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: com.huawei.hms.network.embedded.oa */
/* loaded from: classes8.dex */
public final class C6039oa extends AbstractC6065qa {

    /* renamed from: b */
    public static final int f27631b = 9;

    /* renamed from: a */
    public final InterfaceC6104ta f27632a;

    public C6039oa(InterfaceC6104ta interfaceC6104ta) {
        this.f27632a = interfaceC6104ta;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6065qa
    /* renamed from: a */
    public List<Certificate> mo34338a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((Certificate) arrayDeque.removeFirst());
        boolean z10 = false;
        for (int i10 = 0; i10 < 9; i10++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate x509CertificateMo34339a = this.f27632a.mo34339a(x509Certificate);
            if (x509CertificateMo34339a == null) {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (m34932a(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z10) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(x509CertificateMo34339a)) {
                arrayList.add(x509CertificateMo34339a);
            }
            if (m34932a(x509CertificateMo34339a, x509CertificateMo34339a)) {
                return arrayList;
            }
            z10 = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C6039oa) && ((C6039oa) obj).f27632a.equals(this.f27632a);
    }

    public int hashCode() {
        return this.f27632a.hashCode();
    }

    /* renamed from: a */
    private boolean m34932a(X509Certificate x509Certificate, X509Certificate x509Certificate2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
