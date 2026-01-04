package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.y */
/* loaded from: classes8.dex */
public final class C5577y {

    /* renamed from: b */
    private static C5577y f25323b;

    /* renamed from: a */
    private volatile Map<String, C5559p0> f25324a = new HashMap();

    private C5577y() {
    }

    /* renamed from: a */
    private C5559p0 m32821a(String str) {
        if (!this.f25324a.containsKey(str)) {
            this.f25324a.put(str, new C5559p0());
        }
        return this.f25324a.get(str);
    }

    /* renamed from: b */
    private static synchronized void m32823b() {
        if (f25323b == null) {
            f25323b = new C5577y();
        }
    }

    /* renamed from: a */
    public C5559p0 m32824a(String str, long j10) {
        C5559p0 c5559p0M32821a = m32821a(str);
        c5559p0M32821a.m32688a(j10);
        return c5559p0M32821a;
    }

    /* renamed from: a */
    public static C5577y m32822a() {
        if (f25323b == null) {
            m32823b();
        }
        return f25323b;
    }
}
