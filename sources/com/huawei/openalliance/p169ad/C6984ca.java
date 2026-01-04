package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.utils.C7736aj;

/* renamed from: com.huawei.openalliance.ad.ca */
/* loaded from: classes8.dex */
public class C6984ca {

    /* renamed from: a */
    private static volatile InterfaceC6999cp f32102a;

    /* renamed from: b */
    private static final byte[] f32103b = new byte[0];

    /* renamed from: a */
    public static InterfaceC6999cp m41165a(Context context) {
        if (f32102a == null) {
            synchronized (f32103b) {
                try {
                    if (f32102a == null) {
                        f32102a = (C6982bz.m41156f(context) && C7736aj.m47497b()) ? new C6992ci(context) : C7736aj.m47496a() ? new C6994ck(context) : new C6996cm(context);
                    }
                } finally {
                }
            }
        }
        return f32102a;
    }
}
