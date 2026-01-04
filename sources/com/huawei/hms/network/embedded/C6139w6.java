package com.huawei.hms.network.embedded;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.huawei.hms.network.embedded.w6 */
/* loaded from: classes8.dex */
public final class C6139w6 {

    /* renamed from: a */
    public final String f28844a;

    /* renamed from: b */
    public final Map<String, String> f28845b;

    public C6139w6(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (str2 == null) {
            throw new NullPointerException("realm == null");
        }
        this.f28844a = str;
        this.f28845b = Collections.singletonMap("realm", str2);
    }

    /* renamed from: a */
    public C6139w6 m35726a(Charset charset) {
        if (charset == null) {
            throw new NullPointerException("charset == null");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f28845b);
        linkedHashMap.put("charset", charset.name());
        return new C6139w6(this.f28844a, linkedHashMap);
    }

    /* renamed from: b */
    public Charset m35728b() {
        String str = this.f28845b.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return StandardCharsets.ISO_8859_1;
    }

    /* renamed from: c */
    public String m35729c() {
        return this.f28845b.get("realm");
    }

    /* renamed from: d */
    public String m35730d() {
        return this.f28844a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C6139w6) {
            C6139w6 c6139w6 = (C6139w6) obj;
            if (c6139w6.f28844a.equals(this.f28844a) && c6139w6.f28845b.equals(this.f28845b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f28844a.hashCode() + 899) * 31) + this.f28845b.hashCode();
    }

    public String toString() {
        return this.f28844a + " authParams=" + this.f28845b;
    }

    public C6139w6(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (map == null) {
            throw new NullPointerException("authParams == null");
        }
        this.f28844a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(Locale.US), entry.getValue());
        }
        this.f28845b = Collections.unmodifiableMap(linkedHashMap);
    }

    /* renamed from: a */
    public Map<String, String> m35727a() {
        return this.f28845b;
    }
}
