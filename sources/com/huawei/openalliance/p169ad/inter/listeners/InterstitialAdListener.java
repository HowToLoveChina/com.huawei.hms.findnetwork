package com.huawei.openalliance.p169ad.inter.listeners;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface InterstitialAdListener {
    void onAdClicked();

    void onAdClosed();

    void onAdFailed(int i10);

    void onAdImpression();

    void onAdLeave();

    void onAdLoaded();

    void onAdOpened();

    void onVideoStarted();
}
