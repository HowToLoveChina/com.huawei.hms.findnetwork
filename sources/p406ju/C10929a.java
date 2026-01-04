package p406ju;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import p435ku.C11160f;

/* renamed from: ju.a */
/* loaded from: classes5.dex */
public class C10929a implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) throws CertificateParsingException {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            C11160f.m67096e("", "verify: certificate is : " + x509Certificate.getSubjectDN().getName());
            C10931c.m66042a(str, x509Certificate, true);
            return true;
        } catch (SSLException e10) {
            C11160f.m67095d("", "SSLException : " + e10.getMessage());
            return false;
        }
    }
}
