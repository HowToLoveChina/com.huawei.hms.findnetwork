package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.views.C8150t;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8117j;

/* renamed from: com.huawei.openalliance.ad.ur */
/* loaded from: classes8.dex */
public class C7723ur implements C8150t.a {

    /* renamed from: a */
    InterfaceC8117j f35789a;

    public C7723ur(InterfaceC8117j interfaceC8117j) {
        this.f35789a = interfaceC8117j;
    }

    @Override // com.huawei.openalliance.p169ad.views.C8150t.a
    /* renamed from: a */
    public void mo47418a() {
        this.f35789a.mo49487b(RewardMethods.SHOW_DOWNLOAD_CONFIRM);
    }
}
