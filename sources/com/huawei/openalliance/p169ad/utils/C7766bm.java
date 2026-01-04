package com.huawei.openalliance.p169ad.utils;

import java.math.BigDecimal;

/* renamed from: com.huawei.openalliance.ad.utils.bm */
/* loaded from: classes2.dex */
public class C7766bm {
    /* renamed from: a */
    public static Double m47803a(Double d10, int i10, int i11) {
        if (d10 == null || Double.isInfinite(d10.doubleValue()) || Double.isNaN(d10.doubleValue())) {
            return null;
        }
        return Double.valueOf(new BigDecimal(d10.doubleValue()).setScale(i10, i11).doubleValue());
    }

    /* renamed from: a */
    public static boolean m47804a(float f10, float f11) {
        return Math.abs(f10 - f11) < 1.0E-6f;
    }
}
