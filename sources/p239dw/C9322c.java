package p239dw;

import cw.C8958c;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import p857zv.Exception_C14389c;

/* renamed from: dw.c */
/* loaded from: classes9.dex */
public class C9322c {
    /* renamed from: a */
    public static boolean m58657a(Certificate[] certificateArr) throws Exception_C14389c {
        String strSubstring;
        if (certificateArr == null || certificateArr.length <= 0) {
            throw new Exception_C14389c(1022L, "isRootCertSupport params certificates is null!");
        }
        Certificate certificate = certificateArr[certificateArr.length - 1];
        if (certificate == null) {
            throw new Exception_C14389c(1022L, "params certificate is null!");
        }
        try {
            int i10 = 0;
            String[] strArrSplit = C9340l.m58695b(C8958c.m56711c(certificate.getEncoded(), 0)).getSubjectDN().getName().split(",");
            String str = "CN=";
            int length = strArrSplit.length;
            while (true) {
                if (i10 >= length) {
                    strSubstring = null;
                    break;
                }
                String str2 = strArrSplit[i10];
                if (str2.startsWith(str)) {
                    strSubstring = str2.substring(str.length());
                    break;
                }
                i10++;
            }
            return "Android Keystore Software Attestation Root".equals(strSubstring);
        } catch (CertificateEncodingException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("get certificate param fail: ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14389c(1022L, sbM58651a.toString());
        }
    }
}
