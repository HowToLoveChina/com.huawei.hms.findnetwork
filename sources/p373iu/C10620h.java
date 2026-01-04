package p373iu;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.C8686g;
import java.security.cert.X509Certificate;
import p435ku.C11158d;
import p435ku.C11160f;

/* renamed from: iu.h */
/* loaded from: classes5.dex */
public class C10620h {

    /* renamed from: a */
    public static final String f51064a = "WebViewSSLCheck";

    /* renamed from: a */
    public static void m65082a(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        m65083b(sslErrorHandler, sslError, null, context, null);
    }

    /* renamed from: b */
    public static void m65083b(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, InterfaceC10621i interfaceC10621i) {
        String str2 = f51064a;
        C11160f.m67096e(str2, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        X509Certificate x509CertificateM67084a = C11158d.m67084a(sslError.getCertificate());
        X509Certificate x509CertificateM53589a = new C8686g(context).m53589a();
        C11160f.m67093b(str2, "checkServerCertificateNew: error certificate is : " + x509CertificateM67084a);
        if (C11158d.m67086c(x509CertificateM53589a, x509CertificateM67084a)) {
            C11160f.m67096e(str2, "checkServerCertificateNew: proceed");
            if (interfaceC10621i != null) {
                interfaceC10621i.m65084a(context, str);
                return;
            } else {
                sslErrorHandler.proceed();
                return;
            }
        }
        C11160f.m67095d(str2, "checkServerCertificateNew: cancel");
        if (interfaceC10621i != null) {
            interfaceC10621i.m65085b(context, str);
        } else {
            sslErrorHandler.cancel();
        }
    }
}
