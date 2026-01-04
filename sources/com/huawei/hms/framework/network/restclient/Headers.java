package com.huawei.hms.framework.network.restclient;

import com.huawei.hms.network.base.common.Headers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: classes8.dex */
public final class Headers {
    private com.huawei.hms.network.base.common.Headers headers;

    @Deprecated
    public static final class Builder {
        private Headers.Builder builder;

        public Builder() {
            this.builder = new Headers.Builder();
        }

        public Builder add(String str) {
            this.builder.add(str);
            return this;
        }

        public Builder addLenient(String str) {
            this.builder.addLenient(str);
            return this;
        }

        public Headers build() {
            return new Headers(this.builder.build());
        }

        public String get(String str) {
            return this.builder.get(str);
        }

        public Builder removeAll(String str) {
            this.builder.removeAll(str);
            return this;
        }

        public Builder set(String str, String str2) {
            this.builder.set(str, str2);
            return this;
        }

        public Builder add(String str, String str2) {
            this.builder.add(str, str2);
            return this;
        }

        public Builder addLenient(String str, String str2) {
            this.builder.addLenient(str, str2);
            return this;
        }

        public Builder(Headers.Builder builder) {
            new Headers.Builder();
            this.builder = builder;
        }
    }

    /* renamed from: of */
    public static Headers m32364of(String... strArr) {
        return new Headers(com.huawei.hms.network.base.common.Headers.m33637of(strArr));
    }

    public static String[] toArray(Map<String, List<String>> map) {
        if (map == null) {
            throw new IllegalArgumentException("Headers cannot be null");
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
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public long byteCount() {
        return this.headers.byteCount();
    }

    public boolean equals(Object obj) {
        return this.headers.equals(obj);
    }

    public String get(String str) {
        return this.headers.get(str);
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public String name(int i10) {
        return this.headers.name(i10);
    }

    public Set<String> names() {
        return this.headers.names();
    }

    public Builder newBuilder() {
        return new Builder(this.headers.newBuilder());
    }

    public int size() {
        return this.headers.size();
    }

    public Map<String, List<String>> toMultimap() {
        return this.headers.toMultimap();
    }

    public String toString() {
        return this.headers.toString();
    }

    public String value(int i10) {
        return this.headers.value(i10);
    }

    public List<String> values(String str) {
        return this.headers.values(str);
    }

    private Headers(com.huawei.hms.network.base.common.Headers headers) {
        this.headers = headers;
    }

    /* renamed from: of */
    public static Headers m32363of(Map<String, String> map) {
        if (map != null) {
            String[] strArr = new String[map.size() * 2];
            int i10 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                strArr[i10] = entry.getKey().trim();
                strArr[i10 + 1] = entry.getValue().trim();
                i10 += 2;
            }
            return new Headers(com.huawei.hms.network.base.common.Headers.m33637of(strArr));
        }
        throw new NullPointerException("headers == null");
    }
}
