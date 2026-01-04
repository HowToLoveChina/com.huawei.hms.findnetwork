package com.huawei.hianalytics;

/* renamed from: com.huawei.hianalytics.k0 */
/* loaded from: classes5.dex */
public class C4789k0 {

    /* renamed from: a */
    public static volatile InterfaceC4783i0 f21843a;

    /* renamed from: a */
    public static InterfaceC4783i0 m28957a() {
        if (f21843a == null) {
            synchronized (C4789k0.class) {
                try {
                    if (f21843a == null) {
                        f21843a = C4785j.m28947e() ? new C4752f0() : new C4777g0();
                    }
                } finally {
                }
            }
        }
        return f21843a;
    }
}
