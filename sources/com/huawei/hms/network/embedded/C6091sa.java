package com.huawei.hms.network.embedded;

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

/* renamed from: com.huawei.hms.network.embedded.sa */
/* loaded from: classes8.dex */
public final class C6091sa implements HostnameVerifier {

    /* renamed from: a */
    public static final C6091sa f28246a = new C6091sa();

    /* renamed from: b */
    public static final int f28247b = 2;

    /* renamed from: c */
    public static final int f28248c = 7;

    /* renamed from: a */
    public static List<String> m35305a(X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listM35306a = m35306a(x509Certificate, 7);
        List<String> listM35306a2 = m35306a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listM35306a.size() + listM35306a2.size());
        arrayList.addAll(listM35306a);
        arrayList.addAll(listM35306a2);
        return arrayList;
    }

    /* renamed from: b */
    private boolean m35307b(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        Iterator<String> it = m35306a(x509Certificate, 2).iterator();
        while (it.hasNext()) {
            if (m35309a(lowerCase, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m35308c(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listM35306a = m35306a(x509Certificate, 7);
        int size = listM35306a.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(listM35306a.get(i10))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m35310a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static List<String> m35306a(X509Certificate x509Certificate, int i10) throws CertificateParsingException {
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
    public boolean m35309a(String str, String str2) {
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

    /* renamed from: a */
    public boolean m35310a(String str, X509Certificate x509Certificate) {
        return C5920f8.m34267e(str) ? m35308c(str, x509Certificate) : m35307b(str, x509Certificate);
    }
}
