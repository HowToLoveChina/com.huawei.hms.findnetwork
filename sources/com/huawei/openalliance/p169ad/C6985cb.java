package com.huawei.openalliance.p169ad;

import android.content.Context;

/* renamed from: com.huawei.openalliance.ad.cb */
/* loaded from: classes8.dex */
public class C6985cb {

    /* renamed from: a */
    private static volatile InterfaceC7000cq f32104a;

    /* renamed from: b */
    private static final byte[] f32105b = new byte[0];

    /* renamed from: a */
    public static InterfaceC7000cq m41166a(Context context) {
        if (f32104a == null) {
            synchronized (f32105b) {
                try {
                    if (f32104a == null) {
                        f32104a = C6982bz.m41155e(context) ? C6991ch.m41215b(context) : C6995cl.m41224b(context);
                    }
                } finally {
                }
            }
        }
        return f32104a;
    }
}
