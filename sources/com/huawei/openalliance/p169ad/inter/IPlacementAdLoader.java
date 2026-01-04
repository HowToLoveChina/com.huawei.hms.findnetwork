package com.huawei.openalliance.p169ad.inter;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.listeners.PlacementAdListener;

@OuterVisible
/* loaded from: classes2.dex */
public interface IPlacementAdLoader {
    void loadAds(PlacementAdListener placementAdListener);

    void loadAds(PlacementAdListener placementAdListener, int i10);

    void loadAds(PlacementAdListener placementAdListener, int i10, int i11);

    void preLoadAds();

    void startCache(int i10);

    void stopCache();
}
