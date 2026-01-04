package com.huawei.hms.support.hwid.common.p146e;

import java.util.HashSet;
import java.util.Set;

/* renamed from: com.huawei.hms.support.hwid.common.e.b */
/* loaded from: classes8.dex */
public class C6472b {

    /* renamed from: a */
    private static final Set<Integer> f30047a;

    static {
        HashSet hashSet = new HashSet();
        f30047a = hashSet;
        hashSet.add(0);
    }

    /* renamed from: a */
    public static int m36869a(int i10) {
        return f30047a.contains(Integer.valueOf(i10)) ? 0 : 1;
    }
}
