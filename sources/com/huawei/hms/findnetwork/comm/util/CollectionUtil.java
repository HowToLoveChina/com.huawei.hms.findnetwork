package com.huawei.hms.findnetwork.comm.util;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes8.dex */
public class CollectionUtil {
    public static <T extends Collection<?>> boolean isEmpty(T t10) {
        return t10 == null || t10.size() == 0;
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static <T> boolean isEmpty(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }
}
