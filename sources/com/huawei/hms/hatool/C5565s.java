package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.hms.hatool.s */
/* loaded from: classes8.dex */
public final class C5565s {

    /* renamed from: b */
    static Map<String, C5548l1> f25287b = new HashMap();

    /* renamed from: c */
    private static C5565s f25288c;

    /* renamed from: a */
    private C5533g1 f25289a = new C5533g1();

    private C5565s() {
    }

    /* renamed from: c */
    public static C5565s m32733c() {
        if (f25288c == null) {
            m32734d();
        }
        return f25288c;
    }

    /* renamed from: d */
    private static synchronized void m32734d() {
        if (f25288c == null) {
            f25288c = new C5565s();
        }
    }

    /* renamed from: a */
    public C5548l1 m32735a(String str) {
        return f25287b.get(str);
    }

    /* renamed from: b */
    public C5533g1 m32738b() {
        return this.f25289a;
    }

    /* renamed from: a */
    public Set<String> m32736a() {
        return f25287b.keySet();
    }

    /* renamed from: a */
    public void m32737a(String str, C5548l1 c5548l1) {
        f25287b.put(str, c5548l1);
    }
}
