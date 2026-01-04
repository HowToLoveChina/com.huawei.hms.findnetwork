package com.huawei.openalliance.p169ad.inter;

import android.location.Location;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.inter.listeners.RewardAdListener;

@OuterVisible
/* loaded from: classes2.dex */
public interface IRewardAdLoader {
    void loadAds(int i10, boolean z10);

    void setContentBundle(String str);

    void setListener(RewardAdListener rewardAdListener);

    void setLocation(Location location);

    void setRequestOptions(RequestOptions requestOptions);
}
