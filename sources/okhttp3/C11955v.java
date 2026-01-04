package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import sx.C12875e;

/* renamed from: okhttp3.v */
/* loaded from: classes9.dex */
public final class C11955v {

    /* renamed from: a */
    public final String[] f55649a;

    /* renamed from: okhttp3.v$a */
    public static final class a {

        /* renamed from: a */
        public final List<String> f55650a = new ArrayList(20);

        /* renamed from: a */
        public a m71861a(String str, String str2) {
            C11955v.m71848a(str);
            C11955v.m71849b(str2, str);
            return m71863c(str, str2);
        }

        /* renamed from: b */
        public a m71862b(String str) {
            int iIndexOf = str.indexOf(":", 1);
            return iIndexOf != -1 ? m71863c(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(":") ? m71863c("", str.substring(1)) : m71863c("", str);
        }

        /* renamed from: c */
        public a m71863c(String str, String str2) {
            this.f55650a.add(str);
            this.f55650a.add(str2.trim());
            return this;
        }

        /* renamed from: d */
        public C11955v m71864d() {
            return new C11955v(this);
        }

        /* renamed from: e */
        public a m71865e(String str) {
            int i10 = 0;
            while (i10 < this.f55650a.size()) {
                if (str.equalsIgnoreCase(this.f55650a.get(i10))) {
                    this.f55650a.remove(i10);
                    this.f55650a.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        /* renamed from: f */
        public a m71866f(String str, String str2) {
            C11955v.m71848a(str);
            C11955v.m71849b(str2, str);
            m71865e(str);
            m71863c(str, str2);
            return this;
        }
    }

    public C11955v(a aVar) {
        List<String> list = aVar.f55650a;
        this.f55649a = (String[]) list.toArray(new String[list.size()]);
    }

    /* renamed from: a */
    public static void m71848a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(C12875e.m77260q("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str));
            }
        }
    }

    /* renamed from: b */
    public static void m71849b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(cCharAt);
                objArr[1] = Integer.valueOf(i10);
                objArr[2] = str2;
                if (C12875e.m77231B(str2)) {
                    str = "";
                }
                objArr[3] = str;
                throw new IllegalArgumentException(C12875e.m77260q("Unexpected char %#04x at %d in %s value: %s", objArr));
            }
        }
    }

    /* renamed from: d */
    public static String m71850d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: h */
    public static C11955v m71851h(Map<String, String> map) {
        if (map == null) {
            throw new NullPointerException("headers == null");
        }
        String[] strArr = new String[map.size() * 2];
        int i10 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String strTrim = entry.getKey().trim();
            String strTrim2 = entry.getValue().trim();
            m71848a(strTrim);
            m71849b(strTrim2, strTrim);
            strArr[i10] = strTrim;
            strArr[i10 + 1] = strTrim2;
            i10 += 2;
        }
        return new C11955v(strArr);
    }

    /* renamed from: i */
    public static C11955v m71852i(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i10 = 0; i10 < strArr2.length; i10++) {
            String str = strArr2[i10];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i10] = str.trim();
        }
        for (int i11 = 0; i11 < strArr2.length; i11 += 2) {
            String str2 = strArr2[i11];
            String str3 = strArr2[i11 + 1];
            m71848a(str2);
            m71849b(str3, str2);
        }
        return new C11955v(strArr2);
    }

    /* renamed from: c */
    public String m71853c(String str) {
        return m71850d(this.f55649a, str);
    }

    /* renamed from: e */
    public String m71854e(int i10) {
        return this.f55649a[i10 * 2];
    }

    public boolean equals(Object obj) {
        return (obj instanceof C11955v) && Arrays.equals(((C11955v) obj).f55649a, this.f55649a);
    }

    /* renamed from: f */
    public Set<String> m71855f() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int iM71857j = m71857j();
        for (int i10 = 0; i10 < iM71857j; i10++) {
            treeSet.add(m71854e(i10));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    /* renamed from: g */
    public a m71856g() {
        a aVar = new a();
        Collections.addAll(aVar.f55650a, this.f55649a);
        return aVar;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f55649a);
    }

    /* renamed from: j */
    public int m71857j() {
        return this.f55649a.length / 2;
    }

    /* renamed from: k */
    public Map<String, List<String>> m71858k() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iM71857j = m71857j();
        for (int i10 = 0; i10 < iM71857j; i10++) {
            String lowerCase = m71854e(i10).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(m71859l(i10));
        }
        return treeMap;
    }

    /* renamed from: l */
    public String m71859l(int i10) {
        return this.f55649a[(i10 * 2) + 1];
    }

    /* renamed from: m */
    public List<String> m71860m(String str) {
        int iM71857j = m71857j();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < iM71857j; i10++) {
            if (str.equalsIgnoreCase(m71854e(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m71859l(i10));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int iM71857j = m71857j();
        for (int i10 = 0; i10 < iM71857j; i10++) {
            String strM71854e = m71854e(i10);
            String strM71859l = m71859l(i10);
            sb2.append(strM71854e);
            sb2.append(": ");
            if (C12875e.m77231B(strM71854e)) {
                strM71859l = "";
            }
            sb2.append(strM71859l);
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public C11955v(String[] strArr) {
        this.f55649a = strArr;
    }
}
