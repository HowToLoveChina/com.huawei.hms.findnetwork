package com.huawei.openalliance.p169ad.inter.listeners;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.data.InterstitialAd;

@OuterVisible
/* loaded from: classes2.dex */
public abstract class InterstitialAdCallback {

    /* renamed from: a */
    private InterstitialAdListener f33966a;

    @OuterVisible
    public InterstitialAdCallback(InterstitialAdListener interstitialAdListener) {
        this.f33966a = interstitialAdListener;
    }

    @OuterVisible
    public InterstitialAdListener getInterstitialAdListener() {
        return this.f33966a;
    }

    @OuterVisible
    public abstract void onAdsLoaded(InterstitialAd interstitialAd);

    @OuterVisible
    public void setInterstitialAdListener(InterstitialAdListener interstitialAdListener) {
        this.f33966a = interstitialAdListener;
    }
}
