package com.huawei.openalliance.p169ad.views.web;

import android.net.http.SslCertificate;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
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

/* renamed from: com.huawei.openalliance.ad.views.web.a */
/* loaded from: classes2.dex */
public class C8178a {
    /* renamed from: a */
    public static X509Certificate m50670a(SslCertificate sslCertificate) {
        try {
            byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
            if (byteArray == null) {
                return null;
            }
            try {
                return (X509Certificate) CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException unused) {
                AbstractC7185ho.m43826d("CertificateChainVerify", "generate cert exception");
                return null;
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("CertificateChainVerify", "convertSSL err: %s", th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m50671a(X509Certificate x509Certificate, X509Certificate x509Certificate2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        StringBuilder sb2;
        String str;
        String string;
        if (x509Certificate == null || x509Certificate2 == null) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
        } catch (InvalidKeyException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "verify: publickey InvalidKeyException";
            sb2.append(str);
            sb2.append(e.getMessage());
            string = sb2.toString();
            AbstractC7185ho.m43826d("CertificateChainVerify", string);
            return false;
        } catch (NoSuchAlgorithmException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "verify: publickey NoSuchAlgorithmException";
            sb2.append(str);
            sb2.append(e.getMessage());
            string = sb2.toString();
            AbstractC7185ho.m43826d("CertificateChainVerify", string);
            return false;
        } catch (NoSuchProviderException e12) {
            e = e12;
            sb2 = new StringBuilder();
            str = "verify: publickey NoSuchProviderException";
            sb2.append(str);
            sb2.append(e.getMessage());
            string = sb2.toString();
            AbstractC7185ho.m43826d("CertificateChainVerify", string);
            return false;
        } catch (SignatureException e13) {
            e = e13;
            sb2 = new StringBuilder();
            str = "verify: publickey SignatureException";
            sb2.append(str);
            sb2.append(e.getMessage());
            string = sb2.toString();
            AbstractC7185ho.m43826d("CertificateChainVerify", string);
            return false;
        } catch (CertificateException e14) {
            e = e14;
            sb2 = new StringBuilder();
            str = "verify: publickey CertificateException";
            sb2.append(str);
            sb2.append(e.getMessage());
            string = sb2.toString();
            AbstractC7185ho.m43826d("CertificateChainVerify", string);
            return false;
        }
        if (!m50672a(new X509Certificate[]{x509Certificate, x509Certificate2})) {
            string = "verify: date not right";
            AbstractC7185ho.m43826d("CertificateChainVerify", string);
            return false;
        }
        Principal subjectDN = x509Certificate.getSubjectDN();
        Principal issuerDN = x509Certificate2.getIssuerDN();
        if (subjectDN.equals(issuerDN)) {
            return true;
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43826d("CertificateChainVerify", "verify: first principal is : " + subjectDN.getName());
            AbstractC7185ho.m43826d("CertificateChainVerify", "verify: seconde principal is : " + issuerDN.getName());
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m50672a(X509Certificate[] x509CertificateArr) throws CertificateNotYetValidException, CertificateExpiredException {
        Date date = new Date();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (CertificateExpiredException | CertificateNotYetValidException e10) {
                AbstractC7185ho.m43826d("CertificateChainVerify", "verifyCertificateDate: exception : " + e10.getMessage());
                return false;
            }
        }
        return true;
    }
}
