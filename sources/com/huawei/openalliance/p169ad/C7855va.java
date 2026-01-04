package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.views.NetworkChangeListener;
import com.huawei.openalliance.p169ad.views.PPSRewardView;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k;

/* renamed from: com.huawei.openalliance.ad.va */
/* loaded from: classes8.dex */
public class C7855va implements NetworkChangeListener {

    /* renamed from: a */
    private final InterfaceC8118k f36236a;

    public C7855va(PPSRewardView pPSRewardView) {
        this.f36236a = pPSRewardView;
    }

    @Override // com.huawei.openalliance.p169ad.views.NetworkChangeListener
    public void onNetworkConnectedOrChanged(boolean z10) {
        this.f36236a.mo49484a(z10);
    }

    @Override // com.huawei.openalliance.p169ad.views.NetworkChangeListener
    public void onNetworkDisconnected() {
    }
}
