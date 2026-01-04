package com.huawei.openalliance.p169ad.inter.listeners;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import java.util.List;
import java.util.Map;

@OuterVisible
/* loaded from: classes2.dex */
public interface PlacementAdListener {
    void onAdFailed(int i10);

    void onAdsLoaded(Map<String, List<IPlacementAd>> map);
}
