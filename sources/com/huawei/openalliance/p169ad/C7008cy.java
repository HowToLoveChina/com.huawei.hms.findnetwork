package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;

/* renamed from: com.huawei.openalliance.ad.cy */
/* loaded from: classes8.dex */
public class C7008cy extends AbstractC7009cz {

    /* renamed from: a */
    private InterfaceC7146gc f32151a;

    public C7008cy(Context context) {
        this.f32151a = C7124fh.m43316b(context);
    }

    @Override // com.huawei.openalliance.p169ad.AbstractC7009cz
    /* renamed from: a */
    public boolean mo41237a() {
        String strM47561b = AbstractC7741ao.m47561b("yyyy-MM-dd");
        int iMo43342aI = this.f32151a.mo43342aI();
        if (!strM47561b.equals(this.f32151a.mo43344aK()) || iMo43342aI <= 0 || this.f32151a.mo43343aJ() < iMo43342aI) {
            return m41239b();
        }
        AbstractC7185ho.m43820b("AppDayFcRule", "isTriggerDisturb true");
        return true;
    }
}
