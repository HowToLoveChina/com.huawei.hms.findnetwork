package com.huawei.hms.common.utils;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes8.dex */
public class PickerHiAnalyticsUtil {

    /* renamed from: a */
    private static final Set<Integer> f23558a;

    static {
        HashSet hashSet = new HashSet();
        f23558a = hashSet;
        hashSet.add(0);
    }

    public static int getHiAnalyticsStatus(int i10) {
        return f23558a.contains(Integer.valueOf(i10)) ? 0 : 1;
    }
}
