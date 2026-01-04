package com.huawei.openalliance.p169ad;

import android.content.Context;

/* renamed from: com.huawei.openalliance.ad.gu */
/* loaded from: classes8.dex */
public class C7164gu {
    /* renamed from: a */
    public static AbstractC7659sh m43632a(Context context, InterfaceC7163gt interfaceC7163gt) {
        AbstractC7659sh c7668sq;
        AbstractC7185ho.m43820b("LinkedEventStrategyFactory", "createBaseEventStrategy");
        int iMo43628j = interfaceC7163gt != null ? interfaceC7163gt.mo43628j() : -1;
        if (iMo43628j == 1) {
            c7668sq = new C7668sq(context, iMo43628j);
        } else if (iMo43628j != 3) {
            if (iMo43628j != 18) {
                return new C7661sj(context);
            }
            c7668sq = new C7668sq(context, iMo43628j);
        } else {
            c7668sq = new C7665sn(context, iMo43628j);
        }
        return c7668sq;
    }
}
