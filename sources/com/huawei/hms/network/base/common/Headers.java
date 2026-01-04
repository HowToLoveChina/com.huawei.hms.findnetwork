package com.huawei.hms.network.base.common;

import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes8.dex */
public final class Headers {

    /* renamed from: b */
    private static final String f26178b = "\n";

    /* renamed from: a */
    private final String[] f26179a;

    public static final class Builder {

        /* renamed from: a */
        final List<String> f26180a = new ArrayList(20);

        /* renamed from: a */
        private void m33638a(String str, String str2) {
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
                    throw new IllegalArgumentException(StringUtils.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i11 = 0; i11 < length2; i11++) {
                char cCharAt2 = str2.charAt(i11);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(StringUtils.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i11), str, str2));
                }
            }
        }

        public Builder add(String str) {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf != -1) {
                return add(str.substring(0, iIndexOf).trim(), str.substring(iIndexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        public Builder addLenient(String str) {
            int iIndexOf = str.indexOf(":", 1);
            return -1 != iIndexOf ? addLenient(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(":") ? addLenient("", str.substring(1)) : addLenient("", str);
        }

        public Headers build() {
            return new Headers(this);
        }

        public String get(String str) {
            for (int size = this.f26180a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f26180a.get(size))) {
                    return this.f26180a.get(size + 1);
                }
            }
            return null;
        }

        public Builder removeAll(String str) {
            int i10 = 0;
            while (i10 < this.f26180a.size()) {
                if (str.equalsIgnoreCase(this.f26180a.get(i10))) {
                    this.f26180a.remove(i10);
                    this.f26180a.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public Builder set(String str, String str2) {
            m33638a(str, str2);
            removeAll(str);
            addLenient(str, str2);
            return this;
        }

        public Builder add(String str, String str2) {
            m33638a(str, str2);
            return addLenient(str, str2);
        }

        public Builder addLenient(String str, String str2) {
            this.f26180a.add(str);
            this.f26180a.add(str2.trim());
            return this;
        }
    }

    private Headers(Builder builder) {
        List<String> list = builder.f26180a;
        this.f26179a = (String[]) list.toArray(new String[list.size()]);
    }

    /* renamed from: a */
    private static String m33635a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: of */
    public static Headers m33636of(Map<String, List<String>> map) {
        if (map == null) {
            throw new NullPointerException("headers == null");
        }
        ArrayList arrayList = new ArrayList(map.size() * 2);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String strTrim = entry.getKey().trim();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                String strTrim2 = it.next().trim();
                if (strTrim.length() == 0 || strTrim.indexOf(0) != -1 || strTrim2.indexOf(0) != -1) {
                    throw new IllegalArgumentException("Unexpected header: " + strTrim + ": " + strTrim2);
                }
                arrayList.add(strTrim);
                arrayList.add(strTrim2);
            }
        }
        return new Headers((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public long byteCount() {
        String[] strArr = this.f26179a;
        long length = strArr.length * 2;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            length += this.f26179a[i10].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(((Headers) obj).f26179a, this.f26179a);
    }

    public String get(String str) {
        return m33635a(this.f26179a, str);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f26179a);
    }

    public String name(int i10) {
        return this.f26179a[i10 * 2];
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            treeSet.add(name(i10));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.f26180a, this.f26179a);
        return builder;
    }

    public int size() {
        return this.f26179a.length / 2;
    }

    public Map<String, List<String>> toMultimap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            String strName = name(i10);
            List arrayList = (List) linkedHashMap.get(strName);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                linkedHashMap.put(strName, arrayList);
            }
            arrayList.add(value(i10));
        }
        return linkedHashMap;
    }

    public String toString() {
        return super.toString();
    }

    public String value(int i10) {
        return this.f26179a[(i10 * 2) + 1];
    }

    public List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(name(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i10));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    /* renamed from: of */
    public static Headers m33637of(String... strArr) {
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
                throw new IllegalArgumentException("header mustn't be null");
            }
            strArr2[i10] = str.trim();
        }
        for (int i11 = 0; i11 < strArr2.length; i11 += 2) {
            String str2 = strArr2[i11];
            String str3 = strArr2[i11 + 1];
            if (str2.length() == 0 || str2.indexOf(0) != -1 || str3.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str2 + ": " + str3);
            }
        }
        return new Headers(strArr2);
    }

    private Headers(String[] strArr) {
        this.f26179a = strArr;
    }
}
