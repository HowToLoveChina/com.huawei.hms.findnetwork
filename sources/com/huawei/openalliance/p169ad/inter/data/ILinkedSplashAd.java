package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.listeners.LinkedAdListener;

@OuterVisible
/* loaded from: classes2.dex */
public interface ILinkedSplashAd extends INativeAd {
    LinkedAdListener getListener();

    String getSoundSwitch();

    boolean isFromExsplash();

    void setListener(LinkedAdListener linkedAdListener);
}
