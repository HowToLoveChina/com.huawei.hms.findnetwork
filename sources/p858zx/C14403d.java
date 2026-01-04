package p858zx;

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
import sx.C12875e;

/* renamed from: zx.d */
/* loaded from: classes9.dex */
public final class C14403d implements HostnameVerifier {

    /* renamed from: a */
    public static final C14403d f63771a = new C14403d();

    /* renamed from: a */
    public static List<String> m85632a(X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listM85633b = m85633b(x509Certificate, 7);
        List<String> listM85633b2 = m85633b(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listM85633b.size() + listM85633b2.size());
        arrayList.addAll(listM85633b);
        arrayList.addAll(listM85633b2);
        return arrayList;
    }

    /* renamed from: b */
    public static List<String> m85633b(X509Certificate x509Certificate, int i10) throws CertificateParsingException {
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

    /* renamed from: c */
    public boolean m85634c(String str, X509Certificate x509Certificate) {
        return C12875e.m77243N(str) ? m85637f(str, x509Certificate) : m85636e(str, x509Certificate);
    }

    /* renamed from: d */
    public boolean m85635d(String str, String str2) {
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

    /* renamed from: e */
    public final boolean m85636e(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        Iterator<String> it = m85633b(x509Certificate, 2).iterator();
        while (it.hasNext()) {
            if (m85635d(lowerCase, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public final boolean m85637f(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listM85633b = m85633b(x509Certificate, 7);
        int size = listM85633b.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(listM85633b.get(i10))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m85634c(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
