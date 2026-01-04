package com.huawei.openalliance.p169ad.inter.listeners;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface AdListener {
    void onAdDismissed();

    void onAdFailedToLoad(int i10);

    void onAdLoaded();
}
