package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;

/* renamed from: com.huawei.openalliance.ad.utils.bd */
/* loaded from: classes2.dex */
public class C7757bd {
    /* renamed from: a */
    public static boolean m47712a(int i10) {
        return i10 == 1;
    }

    /* renamed from: b */
    public static boolean m47715b(int i10) {
        return 3 == i10 || 9 == i10 || 8 == i10 || 13 == i10;
    }

    /* renamed from: a */
    public static boolean m47713a(AdSlotParam adSlotParam) {
        return adSlotParam.m40617A() && m47714a(adSlotParam.m40619C());
    }

    /* renamed from: a */
    public static boolean m47714a(Integer num) {
        return num != null && num.intValue() == 3;
    }
}
