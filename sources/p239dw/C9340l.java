package p239dw;

import android.content.Context;
import aw.C1029b;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import cw.C8958c;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import p857zv.C14389c;

/* renamed from: dw.l */
/* loaded from: classes9.dex */
public class C9340l {

    /* renamed from: a */
    public static volatile X509Certificate f46746a;

    /* renamed from: a */
    public static X509Certificate m58694a(Context context, String str) throws C14389c, IOException {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return x509Certificate;
            } catch (Throwable th2) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (IOException | CertificateException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Read root cert error ");
            sbM58651a.append(e10.getMessage());
            String string = sbM58651a.toString();
            throw C9344n.m58700a("CertVerifier", string, new Object[0], 1012L, string);
        }
    }

    /* renamed from: b */
    public static X509Certificate m58695b(String str) throws C14389c, IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(C8958c.m56709a(str, 0));
            try {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(byteArrayInputStream);
                byteArrayInputStream.close();
                return x509Certificate;
            } catch (Throwable th2) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException | CertificateException e10) {
            throw new C14389c(1012L, e10.getMessage());
        }
    }

    /* renamed from: c */
    public static void m58696c(Context context, C9337j0 c9337j0) throws NoSuchAlgorithmException, SignatureException, C14389c, InvalidKeyException, CertificateException, NoSuchProviderException {
        int i10;
        if (f46746a == null) {
            synchronized (C9340l.class) {
                try {
                    if (f46746a == null) {
                        f46746a = m58694a(context, "cbg_root.cer");
                    }
                } finally {
                }
            }
        }
        String[] strArr = c9337j0.f46738a.f46743b;
        if (strArr == null || strArr.length == 0) {
            throw new C14389c(1012L, "verify cert chain failed , certs is empty..");
        }
        int length = strArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            x509CertificateArr[i11] = m58695b(strArr[i11]);
        }
        StringBuilder sbM58651a = C9320b.m58651a("Start verify cert chain using root ca: ");
        sbM58651a.append(f46746a.getSubjectDN().getName());
        C1029b.m6234e("CertVerifier", sbM58651a.toString(), new Object[0]);
        int i12 = 0;
        while (true) {
            i10 = length - 1;
            if (i12 >= i10) {
                break;
            }
            try {
                C1029b.m6234e("CertVerifier", "verify cert " + x509CertificateArr[i12].getSubjectDN().getName(), new Object[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("using ");
                int i13 = i12 + 1;
                sb2.append(x509CertificateArr[i13].getSubjectDN().getName());
                C1029b.m6234e("CertVerifier", sb2.toString(), new Object[0]);
                x509CertificateArr[i12].checkValidity();
                x509CertificateArr[i12].verify(x509CertificateArr[i13].getPublicKey());
                i12 = i13;
            } catch (RuntimeException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e10) {
                StringBuilder sbM58651a2 = C9320b.m58651a("verify cert chain failed , exception ");
                sbM58651a2.append(e10.getMessage());
                String string = sbM58651a2.toString();
                throw C9344n.m58700a("CertVerifier", string, new Object[0], 1012L, string);
            }
            StringBuilder sbM58651a22 = C9320b.m58651a("verify cert chain failed , exception ");
            sbM58651a22.append(e10.getMessage());
            String string2 = sbM58651a22.toString();
            throw C9344n.m58700a("CertVerifier", string2, new Object[0], 1012L, string2);
        }
        x509CertificateArr[i10].verify(f46746a.getPublicKey());
        for (String str : x509CertificateArr[0].getSubjectDN().getName().split(",")) {
            if (str.startsWith("OU=") && "Huawei CBG Cloud Security Signer".equals(str.substring(3))) {
                X509Certificate x509Certificate = x509CertificateArr[0];
                try {
                    Signature signature = Signature.getInstance(CommonPickerConstant.IdTokenSupportAlg.RS_256.equals(c9337j0.f46738a.f46742a) ? "SHA256WithRSA" : "SHA256WithRSA/PSS");
                    signature.initVerify(x509Certificate.getPublicKey());
                    signature.update(c9337j0.f46741d.getBytes(StandardCharsets.UTF_8));
                    if (signature.verify(c9337j0.f46740c)) {
                        return;
                    } else {
                        throw new C14389c(1012L, "signature not verify");
                    }
                } catch (RuntimeException | InvalidKeyException | NoSuchAlgorithmException | SignatureException e11) {
                    StringBuilder sbM58651a3 = C9320b.m58651a("verify signature of c1 failed, exception ");
                    sbM58651a3.append(e11.getMessage());
                    String string3 = sbM58651a3.toString();
                    throw C9344n.m58700a("CertVerifier", string3, new Object[0], 1012L, string3);
                }
            }
        }
        throw new C14389c(1012L, "Subject OU not verify");
    }
}
