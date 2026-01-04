package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.utils.dh */
/* loaded from: classes2.dex */
public abstract class AbstractC7815dh {

    /* renamed from: a */
    private static final Map<String, Long> f36092a = new ConcurrentHashMap();

    /* renamed from: a */
    public static boolean m48358a(String str) {
        return m48359a(str, 60000);
    }

    /* renamed from: a */
    public static boolean m48359a(String str, int i10) {
        if (str == null) {
            return true;
        }
        Map<String, Long> map = f36092a;
        Long l10 = map.get(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (l10 != null) {
            z = jCurrentTimeMillis - l10.longValue() > ((long) i10);
            if (!z) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("TimeIntervalControl", "tag: %s isExpired %s", str, Boolean.valueOf(z));
                }
                return z;
            }
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("TimeIntervalControl", "tag: %s isExpired %s", str, Boolean.valueOf(z));
        }
        map.put(str, Long.valueOf(jCurrentTimeMillis));
        return z;
    }
}
