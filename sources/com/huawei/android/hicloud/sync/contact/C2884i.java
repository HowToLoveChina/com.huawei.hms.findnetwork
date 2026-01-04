package com.huawei.android.hicloud.sync.contact;

import ad.C0100a;
import java.util.HashMap;
import java.util.Map;
import p514o9.C11839m;
import p517oc.C11847b;

/* renamed from: com.huawei.android.hicloud.sync.contact.i */
/* loaded from: classes3.dex */
public class C2884i {
    /* renamed from: a */
    public static void m17564a(HashMap<String, C11847b> map, Map<String, C11847b> map2) {
        if (map != null) {
            for (Map.Entry<String, C11847b> entry : map.entrySet()) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /* renamed from: b */
    public static HashMap<String, Map<String, C11847b>> m17565b(HashMap<String, C11847b> map) {
        C11839m.m70688i("ContactFilter", "[filterContact] start ");
        HashMap map2 = new HashMap(1024);
        HashMap map3 = new HashMap(1024);
        HashMap map4 = new HashMap(1024);
        HashMap map5 = new HashMap(1024);
        HashMap<String, Map<String, C11847b>> map6 = new HashMap<>();
        Map<String, C11847b> mapM706f = C0100a.m706f();
        if (mapM706f.size() == 0) {
            m17564a(map, map2);
        } else if (map != null) {
            m17566c(map, mapM706f, map2, map3, map4, map5);
        } else {
            for (Map.Entry<String, C11847b> entry : mapM706f.entrySet()) {
                map4.put(entry.getKey(), entry.getValue());
                C0100a.m716p(entry.getKey(), 1);
            }
        }
        map6.put("0", map2);
        map6.put("1", map3);
        map6.put("2", map4);
        map6.put("3", map5);
        return map6;
    }

    /* renamed from: c */
    public static void m17566c(HashMap<String, C11847b> map, Map<String, C11847b> map2, Map<String, C11847b> map3, Map<String, C11847b> map4, Map<String, C11847b> map5, Map<String, C11847b> map6) {
        for (Map.Entry<String, C11847b> entry : map.entrySet()) {
            String key = entry.getKey();
            C2882g c2882gM70940a = entry.getValue().m70940a();
            if (map2.containsKey(key)) {
                C11847b c11847b = new C11847b();
                c11847b.setLuid(key);
                c11847b.setUuid(c2882gM70940a.m17418L0());
                c11847b.m70941b(c2882gM70940a);
                c11847b.setGuid(map2.get(key).getGuid());
                if (c2882gM70940a.m17454X0()) {
                    map4.put(key, c11847b);
                    C0100a.m716p(key, 2);
                } else {
                    map6.put(key, c11847b);
                    C0100a.m716p(key, 0);
                }
            } else {
                C11847b c11847b2 = new C11847b();
                c11847b2.setLuid(key);
                c11847b2.setUuid(c2882gM70940a.m17418L0());
                c11847b2.m70941b(c2882gM70940a);
                map3.put(key, entry.getValue());
            }
        }
        for (Map.Entry<String, C11847b> entry2 : map2.entrySet()) {
            String key2 = entry2.getKey();
            if (!map.containsKey(key2)) {
                map5.put(key2, entry2.getValue());
                C0100a.m716p(key2, 1);
            }
        }
    }
}
