package p858zx;

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

/* renamed from: zx.a */
/* loaded from: classes9.dex */
public final class C14400a extends AbstractC14402c {

    /* renamed from: a */
    public final InterfaceC14404e f63769a;

    public C14400a(InterfaceC14404e interfaceC14404e) {
        this.f63769a = interfaceC14404e;
    }

    @Override // p858zx.AbstractC14402c
    /* renamed from: a */
    public List<Certificate> mo83261a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((Certificate) arrayDeque.removeFirst());
        boolean z10 = false;
        for (int i10 = 0; i10 < 9; i10++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate x509CertificateMo83262a = this.f63769a.mo83262a(x509Certificate);
            if (x509CertificateMo83262a == null) {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (m85630c(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z10) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(x509CertificateMo83262a)) {
                arrayList.add(x509CertificateMo83262a);
            }
            if (m85630c(x509CertificateMo83262a, x509CertificateMo83262a)) {
                return arrayList;
            }
            z10 = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    /* renamed from: c */
    public final boolean m85630c(X509Certificate x509Certificate, X509Certificate x509Certificate2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
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

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C14400a) && ((C14400a) obj).f63769a.equals(this.f63769a);
    }

    public int hashCode() {
        return this.f63769a.hashCode();
    }
}
