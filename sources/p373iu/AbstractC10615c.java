package p373iu;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import p435ku.C11160f;

/* renamed from: iu.c */
/* loaded from: classes5.dex */
public abstract class AbstractC10615c {

    /* renamed from: a */
    public static final String[] f51028a = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: b */
    public static final String[] f51029b = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* renamed from: c */
    public static final String[] f51030c = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    /* renamed from: a */
    public static boolean m65062a(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return m65063b(sSLSocket, f51030c);
    }

    /* renamed from: b */
    public static boolean m65063b(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length = strArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    arrayList.add(str);
                    break;
                }
                if (upperCase.contains(strArr[i10].toUpperCase(Locale.ENGLISH))) {
                    break;
                }
                i10++;
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    /* renamed from: c */
    public static void m65064c(SSLSocket sSLSocket) {
        if (sSLSocket == null || m65068g(sSLSocket)) {
            return;
        }
        m65062a(sSLSocket);
    }

    /* renamed from: d */
    public static void m65065d(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
    }

    /* renamed from: e */
    public static boolean m65066e(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket != null && strArr != null) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e10) {
                C11160f.m67095d("SSLUtil", "setEnabledProtocols: exception : " + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: f */
    public static SSLContext m65067f() throws NoSuchAlgorithmException {
        return SSLContext.getInstance("TLSv1.3");
    }

    /* renamed from: g */
    public static boolean m65068g(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return m65069h(sSLSocket, f51029b);
    }

    /* renamed from: h */
    public static boolean m65069h(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List listAsList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (listAsList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }
}
