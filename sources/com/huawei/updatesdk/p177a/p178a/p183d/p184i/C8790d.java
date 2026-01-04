package com.huawei.updatesdk.p177a.p178a.p183d.p184i;

import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;

/* renamed from: com.huawei.updatesdk.a.a.d.i.d */
/* loaded from: classes9.dex */
public class C8790d {

    /* renamed from: a */
    private static int f45098a = -1;

    /* renamed from: a */
    public static int m56123a() {
        if (f45098a == -1) {
            f45098a = ("zh".equals(C8789c.m56089a("ro.product.locale.language", "")) && "CN".equals(C8789c.m56089a(CountryCodeBean.LOCALE_REGION_COUNTRYSYSTEMPROP, ""))) ? 0 : 1;
        }
        return f45098a;
    }
}
