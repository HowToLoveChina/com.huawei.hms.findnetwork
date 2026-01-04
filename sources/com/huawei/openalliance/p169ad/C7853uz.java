package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.views.PPSRewardView;

/* renamed from: com.huawei.openalliance.ad.uz */
/* loaded from: classes8.dex */
public class C7853uz implements MuteListener {

    /* renamed from: a */
    private final PPSRewardView f36224a;

    public C7853uz(PPSRewardView pPSRewardView) {
        this.f36224a = pPSRewardView;
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
    public void onMute() {
        this.f36224a.m49601e(true);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
    public void onUnmute() {
        this.f36224a.m49601e(false);
    }
}
