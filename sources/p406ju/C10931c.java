package p406ju;

import com.huawei.hms.network.embedded.C6126v6;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import p435ku.C11160f;

/* renamed from: ju.c */
/* loaded from: classes5.dex */
public class C10931c {

    /* renamed from: a */
    public static final Pattern f51839a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b */
    public static final String[] f51840b;

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        f51840b = strArr;
        Arrays.sort(strArr);
    }

    /* renamed from: a */
    public static final void m66042a(String str, X509Certificate x509Certificate, boolean z10) throws SSLException, CertificateParsingException {
        String[] strArrM66045d = m66045d(x509Certificate);
        String[] strArrM66047f = m66047f(x509Certificate);
        C11160f.m67093b("", "cn is : " + Arrays.toString(strArrM66045d));
        C11160f.m67093b("", "san is : " + Arrays.toString(strArrM66047f));
        m66043b(str, strArrM66045d, strArrM66047f, z10);
    }

    /* renamed from: b */
    public static final void m66043b(String str, String[] strArr, String[] strArr2, boolean z10) throws SSLException {
        String str2;
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && (str2 = strArr[0]) != null) {
            linkedList.add(str2);
        }
        if (strArr2 != null) {
            for (String str3 : strArr2) {
                if (str3 != null) {
                    linkedList.add(str3);
                }
            }
        }
        if (linkedList.isEmpty()) {
            throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
        }
        StringBuffer stringBuffer = new StringBuffer();
        String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        Iterator it = linkedList.iterator();
        boolean zEquals = false;
        while (it.hasNext()) {
            String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
            stringBuffer.append(" <");
            stringBuffer.append(lowerCase2);
            stringBuffer.append('>');
            if (it.hasNext()) {
                stringBuffer.append(" OR");
            }
            if (!lowerCase2.startsWith(C6126v6.b.f28650e) || lowerCase2.indexOf(46, 2) == -1 || !m66044c(lowerCase2) || m66048g(str)) {
                zEquals = lowerCase.equals(lowerCase2);
            } else {
                boolean zEndsWith = lowerCase.endsWith(lowerCase2.substring(1));
                zEquals = (zEndsWith && z10) ? m66046e(lowerCase) == m66046e(lowerCase2) : zEndsWith;
            }
            if (zEquals) {
                break;
            }
        }
        if (zEquals) {
            return;
        }
        throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) stringBuffer));
    }

    /* renamed from: c */
    public static boolean m66044c(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i10 = length - 3;
        if (str.charAt(i10) == '.') {
            return Arrays.binarySearch(f51840b, str.substring(2, i10)) < 0;
        }
        return true;
    }

    /* renamed from: d */
    public static String[] m66045d(X509Certificate x509Certificate) {
        List<String> listM66037d = new C10930b(x509Certificate.getSubjectX500Principal()).m66037d("cn");
        if (listM66037d.isEmpty()) {
            return null;
        }
        String[] strArr = new String[listM66037d.size()];
        listM66037d.toArray(strArr);
        return strArr;
    }

    /* renamed from: e */
    public static int m66046e(String str) {
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (str.charAt(i11) == '.') {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: f */
    public static String[] m66047f(X509Certificate x509Certificate) throws CertificateParsingException {
        Collection<List<?>> subjectAlternativeNames;
        LinkedList linkedList = new LinkedList();
        try {
            subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e10) {
            C11160f.m67094c("", "Error parsing certificate.", e10);
            subjectAlternativeNames = null;
        }
        if (subjectAlternativeNames != null) {
            for (List<?> list : subjectAlternativeNames) {
                if (((Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    /* renamed from: g */
    public static boolean m66048g(String str) {
        return f51839a.matcher(str).matches();
    }
}
