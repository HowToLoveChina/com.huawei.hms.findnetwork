package com.huawei.openalliance.p169ad.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.huawei.openalliance.ad.utils.bg */
/* loaded from: classes2.dex */
public abstract class AbstractC7760bg {
    /* renamed from: a */
    public static String m47765a(List<String> list, String str) {
        if (m47767a(list)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            sb2.append(str);
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public static Set<String> m47766a(List<String> list, boolean z10) {
        if (m47767a(list)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        if (z10) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().toUpperCase(Locale.ENGLISH));
            }
        } else {
            hashSet.addAll(list);
        }
        return hashSet;
    }

    /* renamed from: a */
    public static <T> boolean m47767a(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    /* renamed from: a */
    public static boolean m47768a(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    /* renamed from: a */
    public static <T> boolean m47769a(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }
}
