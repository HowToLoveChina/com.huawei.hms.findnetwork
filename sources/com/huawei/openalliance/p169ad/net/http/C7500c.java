package com.huawei.openalliance.p169ad.net.http;

import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.net.http.c */
/* loaded from: classes2.dex */
public class C7500c {

    /* renamed from: a */
    private final Map<String, String> f34827a = new HashMap();

    /* renamed from: b */
    public static String m46048b(Map<String, List<String>> map) {
        if (map == null || map.size() <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            sb2.append("{");
            sb2.append(entry.getKey());
            sb2.append(":");
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append("|");
            }
            AbstractC7806cz.m48159a(sb2, '|');
            sb2.append("}");
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public Map<String, String> m46049a() {
        return new HashMap(this.f34827a);
    }

    /* renamed from: a */
    public void m46050a(C7500c c7500c) {
        this.f34827a.putAll(c7500c.f34827a);
    }

    /* renamed from: a */
    public void m46051a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f34827a.put(str, str2);
    }
}
