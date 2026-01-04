package com.huawei.hms.hwid;

import java.util.HashSet;
import java.util.Set;

/* renamed from: com.huawei.hms.hwid.ar */
/* loaded from: classes8.dex */
public class C5601ar {

    /* renamed from: a */
    private static final Set<Integer> f25354a;

    static {
        HashSet hashSet = new HashSet();
        f25354a = hashSet;
        hashSet.add(0);
    }

    /* renamed from: a */
    public static int m32908a(int i10) {
        return f25354a.contains(Integer.valueOf(i10)) ? 0 : 1;
    }
}
