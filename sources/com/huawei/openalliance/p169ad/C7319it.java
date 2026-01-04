package com.huawei.openalliance.p169ad;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.it */
/* loaded from: classes8.dex */
public class C7319it {

    /* renamed from: a */
    private final Map<String, String> f34021a = new HashMap();

    /* renamed from: b */
    private String m45097b(String str) {
        return str.toLowerCase(Locale.ENGLISH);
    }

    /* renamed from: a */
    public Iterable<? extends String> m45098a() {
        return this.f34021a.keySet();
    }

    /* renamed from: a */
    public String m45099a(String str) {
        if (str != null) {
            return this.f34021a.get(m45097b(str));
        }
        return null;
    }

    /* renamed from: a */
    public void m45100a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f34021a.put(m45097b(str), str2);
    }
}
