package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.da */
/* loaded from: classes8.dex */
public class C7011da extends AbstractC7009cz {

    /* renamed from: a */
    private InterfaceC7146gc f32155a;

    public C7011da(Context context) {
        this.f32155a = C7124fh.m43316b(context);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7009cz
    /* renamed from: a */
    public boolean mo41237a() {
        if (this.f32155a.mo43348aO() < AbstractC7741ao.m47566c()) {
            return m41239b();
        }
        AbstractC7185ho.m43820b("UserCloseRule", "isTriggerDisturb true");
        return true;
    }
}
