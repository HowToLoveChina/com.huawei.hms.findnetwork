package com.huawei.android.p069cg.request.threadpool;

import java.util.HashMap;

/* renamed from: com.huawei.android.cg.request.threadpool.h */
/* loaded from: classes2.dex */
public class C2327h extends HashMap<String, Object> {
    private static final long serialVersionUID = 1;

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ((AbstractCallableC2320a) ((C2327h) obj).get("FIXED_BASECALLABLE_KEY")).equals((AbstractCallableC2320a) get("FIXED_BASECALLABLE_KEY"));
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return super.hashCode();
    }
}
