package com.huawei.hms.drive;

import com.huawei.hms.network.embedded.C6126v6;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* renamed from: com.huawei.hms.drive.dx */
/* loaded from: classes8.dex */
public final class C5275dx implements HostnameVerifier {

    /* renamed from: a */
    public static final C5275dx f24503a = new C5275dx();

    private C5275dx() {
    }

    /* renamed from: b */
    private boolean m31705b(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listM31704a = m31704a(x509Certificate, 7);
        int size = listM31704a.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(listM31704a.get(i10))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m31706c(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        Iterator<String> it = m31704a(x509Certificate, 2).iterator();
        while (it.hasNext()) {
            if (m31707a(lowerCase, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m31708a(String str, X509Certificate x509Certificate) {
        return C5210bo.m31207c(str) ? m31705b(str, x509Certificate) : m31706c(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m31708a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static List<String> m31703a(X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listM31704a = m31704a(x509Certificate, 7);
        List<String> listM31704a2 = m31704a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listM31704a.size() + listM31704a2.size());
        arrayList.addAll(listM31704a);
        arrayList.addAll(listM31704a2);
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m31704a(X509Certificate x509Certificate, int i10) throws CertificateParsingException {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i10 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public boolean m31707a(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith(C6126v6.b.f28650e) || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || C6126v6.b.f28650e.equals(lowerCase)) {
                return false;
            }
            String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
