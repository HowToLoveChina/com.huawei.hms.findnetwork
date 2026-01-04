package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7690tl;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;

/* renamed from: com.huawei.openalliance.ad.utils.dp */
/* loaded from: classes2.dex */
public class C7823dp {
    /* renamed from: a */
    public static void m48385a(final AdSlotParam adSlotParam) {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.dp.1
            @Override // java.lang.Runnable
            public void run() {
                Integer numValueOf;
                try {
                    numValueOf = Integer.valueOf(new C7690tl().m47255a());
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("WLACManagerUtils", "getWlacStatus ex: %s", th2.getClass().getSimpleName());
                    numValueOf = null;
                }
                AdSlotParam adSlotParam2 = adSlotParam;
                if (adSlotParam2 != null) {
                    adSlotParam2.m40652e(numValueOf);
                }
            }
        });
    }
}
