package p435ku;

import android.net.http.SslCertificate;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;

/* renamed from: ku.d */
/* loaded from: classes5.dex */
public class C11158d {

    /* renamed from: a */
    public static final String f52500a = "b";

    /* renamed from: a */
    public static X509Certificate m67084a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e10) {
                C11160f.m67094c(f52500a, TrackConstants$Events.EXCEPTION, e10);
            }
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m67085b(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    /* renamed from: c */
    public static boolean m67086c(X509Certificate x509Certificate, X509Certificate x509Certificate2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (m67089f(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            C11160f.m67095d(f52500a, "verify: date not right");
            return false;
        } catch (InvalidKeyException e10) {
            C11160f.m67095d(f52500a, "verify: publickey InvalidKeyException " + e10.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e11) {
            C11160f.m67095d(f52500a, "verify: publickey NoSuchAlgorithmException " + e11.getMessage());
            return false;
        } catch (NoSuchProviderException e12) {
            C11160f.m67095d(f52500a, "verify: publickey NoSuchProviderException " + e12.getMessage());
            return false;
        } catch (SignatureException e13) {
            C11160f.m67095d(f52500a, "verify: publickey SignatureException " + e13.getMessage());
            return false;
        } catch (CertificateException e14) {
            C11160f.m67095d(f52500a, "verify: publickey CertificateException " + e14.getMessage());
            return false;
        } catch (Exception e15) {
            C11160f.m67095d(f52500a, "verify: Exception " + e15.getMessage());
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m67087d(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        Principal principal = null;
        int i10 = 0;
        while (i10 < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i10];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (!issuerDN.equals(principal)) {
                    C11160f.m67095d(f52500a, "verify: principalIssuer not match");
                    return false;
                }
                x509CertificateArr[i10].verify(x509CertificateArr[i10 - 1].getPublicKey());
            }
            i10++;
            principal = subjectDN;
        }
        return m67086c(x509Certificate, x509CertificateArr[0]) && m67089f(x509CertificateArr) && m67085b(x509Certificate) && m67088e(x509CertificateArr);
    }

    /* renamed from: e */
    public static boolean m67088e(X509Certificate[] x509CertificateArr) {
        for (int i10 = 0; i10 < x509CertificateArr.length - 1; i10++) {
            if (!m67085b(x509CertificateArr[i10])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public static boolean m67089f(X509Certificate[] x509CertificateArr) throws CertificateNotYetValidException, CertificateExpiredException {
        Date date = new Date();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (CertificateExpiredException | CertificateNotYetValidException e10) {
                C11160f.m67095d(f52500a, "verifyCertificateDate: exception : " + e10.getMessage());
                return false;
            } catch (Exception e11) {
                C11160f.m67095d(f52500a, "verifyCertificateDate : exception : " + e11.getMessage());
                return false;
            }
        }
        return true;
    }
}
