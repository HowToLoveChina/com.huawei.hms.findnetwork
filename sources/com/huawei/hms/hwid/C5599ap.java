package com.huawei.hms.hwid;

import java.util.Collection;

/* renamed from: com.huawei.hms.hwid.ap */
/* loaded from: classes8.dex */
public class C5599ap {
    /* renamed from: a */
    public static Boolean m32900a(Collection collection) {
        return (collection == null || collection.size() == 0) ? Boolean.TRUE : Boolean.FALSE;
    }

    /* renamed from: b */
    public static Boolean m32901b(Collection collection) {
        return Boolean.valueOf(!m32900a(collection).booleanValue());
    }
}
