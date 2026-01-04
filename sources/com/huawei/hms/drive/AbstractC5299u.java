package com.huawei.hms.drive;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* renamed from: com.huawei.hms.drive.u */
/* loaded from: classes8.dex */
public abstract class AbstractC5299u {

    /* renamed from: a */
    private static final String[] f24567a = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: b */
    private static final String[] f24568b = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* renamed from: c */
    private static final String[] f24569c = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    /* renamed from: a */
    public static SSLContext m31817a() throws NoSuchAlgorithmException {
        return SSLContext.getInstance("TLSv1.3");
    }

    /* renamed from: b */
    public static boolean m31820b(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return m31819a(sSLSocket, f24568b);
    }

    /* renamed from: c */
    public static boolean m31822c(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return m31821b(sSLSocket, f24569c);
    }

    /* renamed from: d */
    public static void m31824d(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
    }

    /* renamed from: b */
    public static boolean m31821b(SSLSocket sSLSocket, String[] strArr) {
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
    public static boolean m31823c(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket != null && strArr != null) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e10) {
                C5170ac.m30796c("SSLUtil", "setEnabledProtocols: exception : " + e10.getMessage());
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m31818a(SSLSocket sSLSocket) {
        if (sSLSocket == null || m31820b(sSLSocket)) {
            return;
        }
        m31822c(sSLSocket);
    }

    /* renamed from: a */
    public static boolean m31819a(SSLSocket sSLSocket, String[] strArr) {
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
