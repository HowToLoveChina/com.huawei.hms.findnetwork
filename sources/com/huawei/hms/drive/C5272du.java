package com.huawei.hms.drive;

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

/* renamed from: com.huawei.hms.drive.du */
/* loaded from: classes8.dex */
public final class C5272du extends AbstractC5274dw {

    /* renamed from: a */
    private final InterfaceC5276dy f24501a;

    public C5272du(InterfaceC5276dy interfaceC5276dy) {
        this.f24501a = interfaceC5276dy;
    }

    @Override // com.huawei.hms.drive.AbstractC5274dw
    /* renamed from: a */
    public List<Certificate> mo31662a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((Certificate) arrayDeque.removeFirst());
        boolean z10 = false;
        for (int i10 = 0; i10 < 9; i10++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate x509CertificateMo31663a = this.f24501a.mo31663a(x509Certificate);
            if (x509CertificateMo31663a == null) {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (m31701a(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z10) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(x509CertificateMo31663a)) {
                arrayList.add(x509CertificateMo31663a);
            }
            if (m31701a(x509CertificateMo31663a, x509CertificateMo31663a)) {
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
        return (obj instanceof C5272du) && ((C5272du) obj).f24501a.equals(this.f24501a);
    }

    public int hashCode() {
        return this.f24501a.hashCode();
    }

    /* renamed from: a */
    private boolean m31701a(X509Certificate x509Certificate, X509Certificate x509Certificate2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
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
