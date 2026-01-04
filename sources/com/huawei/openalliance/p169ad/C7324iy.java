package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.AdLoadMode;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l;

/* renamed from: com.huawei.openalliance.ad.iy */
/* loaded from: classes8.dex */
public class C7324iy {

    /* renamed from: a */
    private static final String f34106a = "iy";

    /* renamed from: a */
    public static AbstractC7323ix m45202a(AdLoadMode adLoadMode, InterfaceC8119l interfaceC8119l) {
        AbstractC7185ho.m43821b(f34106a, "create ad mediator: %s", adLoadMode);
        return (adLoadMode == AdLoadMode.REAL || adLoadMode == AdLoadMode.REAL_NEW) ? new C7327ja(interfaceC8119l) : new C7325iz(interfaceC8119l);
    }
}
