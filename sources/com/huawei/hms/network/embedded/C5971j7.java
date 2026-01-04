package com.huawei.hms.network.embedded;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* renamed from: com.huawei.hms.network.embedded.j7 */
/* loaded from: classes8.dex */
public final class C5971j7 {

    /* renamed from: a */
    public final String[] f27137a;

    /* renamed from: com.huawei.hms.network.embedded.j7$a */
    public static final class a {

        /* renamed from: a */
        public final List<String> f27138a = new ArrayList(20);

        /* renamed from: a */
        public a m34530a(C5971j7 c5971j7) {
            int iM34527d = c5971j7.m34527d();
            for (int i10 = 0; i10 < iM34527d; i10++) {
                m34537b(c5971j7.m34520a(i10), c5971j7.m34522b(i10));
            }
            return this;
        }

        /* renamed from: b */
        public a m34536b(String str) {
            int iIndexOf = str.indexOf(":", 1);
            return iIndexOf != -1 ? m34537b(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(":") ? m34537b("", str.substring(1)) : m34537b("", str);
        }

        /* renamed from: c */
        public a m34540c(String str, String str2) {
            C5971j7.m34518e(str);
            return m34537b(str, str2);
        }

        /* renamed from: d */
        public a m34542d(String str) {
            int i10 = 0;
            while (i10 < this.f27138a.size()) {
                if (str.equalsIgnoreCase(this.f27138a.get(i10))) {
                    this.f27138a.remove(i10);
                    this.f27138a.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        /* renamed from: a */
        public a m34531a(String str) {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf != -1) {
                return m34532a(str.substring(0, iIndexOf).trim(), str.substring(iIndexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        /* renamed from: b */
        public a m34537b(String str, String str2) {
            this.f27138a.add(str);
            this.f27138a.add(str2.trim());
            return this;
        }

        /* renamed from: c */
        public String m34541c(String str) {
            for (int size = this.f27138a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f27138a.get(size))) {
                    return this.f27138a.get(size + 1);
                }
            }
            return null;
        }

        /* renamed from: d */
        public a m34543d(String str, String str2) {
            C5971j7.m34518e(str);
            C5971j7.m34517a(str2, str);
            m34542d(str);
            m34537b(str, str2);
            return this;
        }

        /* renamed from: a */
        public a m34532a(String str, String str2) {
            C5971j7.m34518e(str);
            C5971j7.m34517a(str2, str);
            return m34537b(str, str2);
        }

        @IgnoreJRERequirement
        /* renamed from: b */
        public a m34538b(String str, Instant instant) {
            if (instant != null) {
                return m34539b(str, new Date(instant.toEpochMilli()));
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        @IgnoreJRERequirement
        /* renamed from: a */
        public a m34533a(String str, Instant instant) {
            if (instant != null) {
                return m34534a(str, new Date(instant.toEpochMilli()));
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        /* renamed from: b */
        public a m34539b(String str, Date date) {
            if (date != null) {
                m34543d(str, C5947h9.m34365a(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        /* renamed from: a */
        public a m34534a(String str, Date date) {
            if (date != null) {
                m34532a(str, C5947h9.m34365a(date));
                return this;
            }
            throw new NullPointerException("value for name " + str + " == null");
        }

        /* renamed from: a */
        public C5971j7 m34535a() {
            return new C5971j7(this);
        }
    }

    public C5971j7(a aVar) {
        List<String> list = aVar.f27138a;
        this.f27137a = (String[]) list.toArray(new String[list.size()]);
    }

    /* renamed from: a */
    public long m34519a() {
        String[] strArr = this.f27137a;
        long length = strArr.length * 2;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            length += this.f27137a[i10].length();
        }
        return length;
    }

    /* renamed from: b */
    public String m34522b(int i10) {
        return this.f27137a[(i10 * 2) + 1];
    }

    /* renamed from: c */
    public a m34525c() {
        a aVar = new a();
        Collections.addAll(aVar.f27138a, this.f27137a);
        return aVar;
    }

    /* renamed from: d */
    public int m34527d() {
        return this.f27137a.length / 2;
    }

    /* renamed from: e */
    public Map<String, List<String>> m34529e() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iM34527d = m34527d();
        for (int i10 = 0; i10 < iM34527d; i10++) {
            String lowerCase = m34520a(i10).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(m34522b(i10));
        }
        return treeMap;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C5971j7) && Arrays.equals(((C5971j7) obj).f27137a, this.f27137a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f27137a);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int iM34527d = m34527d();
        for (int i10 = 0; i10 < iM34527d; i10++) {
            String strM34520a = m34520a(i10);
            String strM34522b = m34522b(i10);
            sb2.append(strM34520a);
            sb2.append(": ");
            if (C5920f8.m34266d(strM34520a)) {
                strM34522b = "";
            }
            sb2.append(strM34522b);
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public C5971j7(String[] strArr) {
        this.f27137a = strArr;
    }

    /* renamed from: a */
    public static C5971j7 m34514a(Map<String, String> map) {
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
            m34518e(strTrim);
            m34517a(strTrim2, strTrim);
            strArr[i10] = strTrim;
            strArr[i10 + 1] = strTrim2;
            i10 += 2;
        }
        return new C5971j7(strArr);
    }

    /* renamed from: e */
    public static void m34518e(String str) {
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
                throw new IllegalArgumentException(C5920f8.m34236a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str));
            }
        }
    }

    /* renamed from: b */
    public Date m34523b(String str) {
        String strM34521a = m34521a(str);
        if (strM34521a != null) {
            return C5947h9.m34366a(strM34521a);
        }
        return null;
    }

    @IgnoreJRERequirement
    /* renamed from: c */
    public Instant m34526c(String str) {
        Date dateM34523b = m34523b(str);
        if (dateM34523b != null) {
            return dateM34523b.toInstant();
        }
        return null;
    }

    /* renamed from: d */
    public List<String> m34528d(String str) {
        int iM34527d = m34527d();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < iM34527d; i10++) {
            if (str.equalsIgnoreCase(m34520a(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m34522b(i10));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    /* renamed from: a */
    public static C5971j7 m34515a(String... strArr) {
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
            m34518e(str2);
            m34517a(str3, str2);
        }
        return new C5971j7(strArr2);
    }

    /* renamed from: b */
    public Set<String> m34524b() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int iM34527d = m34527d();
        for (int i10 = 0; i10 < iM34527d; i10++) {
            treeSet.add(m34520a(i10));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    /* renamed from: a */
    public String m34520a(int i10) {
        return this.f27137a[i10 * 2];
    }

    /* renamed from: a */
    public String m34521a(String str) {
        return m34516a(this.f27137a, str);
    }

    /* renamed from: a */
    public static String m34516a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m34517a(String str, String str2) {
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
                if (C5920f8.m34266d(str2)) {
                    str = "";
                }
                objArr[3] = str;
                throw new IllegalArgumentException(C5920f8.m34236a("Unexpected char %#04x at %d in %s value: %s", objArr));
            }
        }
    }
}
