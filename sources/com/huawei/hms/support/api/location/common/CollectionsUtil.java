package com.huawei.hms.support.api.location.common;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes8.dex */
public class CollectionsUtil {
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.size() == 0;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }
}
