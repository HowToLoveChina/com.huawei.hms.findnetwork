package com.huawei.hms.drive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.huawei.hms.drive.aw */
/* loaded from: classes8.dex */
public final class C5190aw {

    /* renamed from: a */
    private final String[] f23780a;

    public C5190aw(a aVar) {
        List<String> list = aVar.f23781a;
        this.f23780a = (String[]) list.toArray(new String[list.size()]);
    }

    /* renamed from: a */
    public String m30923a(String str) {
        return m30918a(this.f23780a, str);
    }

    /* renamed from: b */
    public String m30925b(int i10) {
        return this.f23780a[(i10 * 2) + 1];
    }

    /* renamed from: c */
    public Map<String, List<String>> m30927c() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iM30921a = m30921a();
        for (int i10 = 0; i10 < iM30921a; i10++) {
            String lowerCase = m30922a(i10).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(m30925b(i10));
        }
        return treeMap;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C5190aw) && Arrays.equals(((C5190aw) obj).f23780a, this.f23780a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f23780a);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int iM30921a = m30921a();
        for (int i10 = 0; i10 < iM30921a; i10++) {
            String strM30922a = m30922a(i10);
            String strM30925b = m30925b(i10);
            sb2.append(strM30922a);
            sb2.append(": ");
            if (C5210bo.m31209d(strM30922a)) {
                strM30925b = "";
            }
            sb2.append(strM30925b);
            sb2.append("\n");
        }
        return sb2.toString();
    }

    /* renamed from: com.huawei.hms.drive.aw$a */
    public static final class a {

        /* renamed from: a */
        final List<String> f23781a = new ArrayList(20);

        /* renamed from: a */
        public a m30928a(String str) {
            int iIndexOf = str.indexOf(":", 1);
            return iIndexOf != -1 ? m30932b(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(":") ? m30932b("", str.substring(1)) : m30932b("", str);
        }

        /* renamed from: b */
        public a m30932b(String str, String str2) {
            this.f23781a.add(str);
            this.f23781a.add(str2.trim());
            return this;
        }

        /* renamed from: c */
        public a m30933c(String str, String str2) {
            C5190aw.m30920c(str);
            C5190aw.m30919a(str2, str);
            m30931b(str);
            m30932b(str, str2);
            return this;
        }

        /* renamed from: b */
        public a m30931b(String str) {
            int i10 = 0;
            while (i10 < this.f23781a.size()) {
                if (str.equalsIgnoreCase(this.f23781a.get(i10))) {
                    this.f23781a.remove(i10);
                    this.f23781a.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        /* renamed from: a */
        public a m30929a(String str, String str2) {
            C5190aw.m30920c(str);
            C5190aw.m30919a(str2, str);
            return m30932b(str, str2);
        }

        /* renamed from: a */
        public C5190aw m30930a() {
            return new C5190aw(this);
        }
    }

    /* renamed from: a */
    public int m30921a() {
        return this.f23780a.length / 2;
    }

    /* renamed from: b */
    public List<String> m30926b(String str) {
        int iM30921a = m30921a();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < iM30921a; i10++) {
            if (str.equalsIgnoreCase(m30922a(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m30925b(i10));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private C5190aw(String[] strArr) {
        this.f23780a = strArr;
    }

    /* renamed from: a */
    public String m30922a(int i10) {
        return this.f23780a[i10 * 2];
    }

    /* renamed from: a */
    private static String m30918a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C5190aw m30917a(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i10 = 0; i10 < strArr2.length; i10++) {
                    String str = strArr2[i10];
                    if (str != null) {
                        strArr2[i10] = str.trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i11 = 0; i11 < strArr2.length; i11 += 2) {
                    String str2 = strArr2[i11];
                    String str3 = strArr2[i11 + 1];
                    m30920c(str2);
                    m30919a(str3, str2);
                }
                return new C5190aw(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }

    /* renamed from: c */
    public static void m30920c(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                int length = str.length();
                for (int i10 = 0; i10 < length; i10++) {
                    char cCharAt = str.charAt(i10);
                    if (cCharAt <= ' ' || cCharAt >= 127) {
                        throw new IllegalArgumentException(C5210bo.m31181a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str));
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }
        throw new NullPointerException("name == null");
    }

    /* renamed from: b */
    public a m30924b() {
        a aVar = new a();
        Collections.addAll(aVar.f23781a, this.f23780a);
        return aVar;
    }

    /* renamed from: a */
    public static void m30919a(String str, String str2) {
        if (str != null) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = str.charAt(i10);
                if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(cCharAt);
                    objArr[1] = Integer.valueOf(i10);
                    objArr[2] = str2;
                    if (C5210bo.m31209d(str2)) {
                        str = "";
                    }
                    objArr[3] = str;
                    throw new IllegalArgumentException(C5210bo.m31181a("Unexpected char %#04x at %d in %s value: %s", objArr));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }
}
