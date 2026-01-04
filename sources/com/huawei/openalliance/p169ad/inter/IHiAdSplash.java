package com.huawei.openalliance.p169ad.inter;

import android.content.Context;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;

@OuterVisible
/* loaded from: classes2.dex */
public interface IHiAdSplash {
    void dismissExSplash();

    void dismissExSplashSlogan();

    void enableLinkedVideo(boolean z10);

    Integer getAllowMobileTraffic();

    boolean isAvailable(AdSlotParam adSlotParam);

    boolean isExSplashEnable(Context context);

    boolean isSmartSplashAvailable(AdSlotParam adSlotParam);

    void preloadAd();

    void preloadAd(AdSlotParam adSlotParam);

    void preloadSmartScreenAd();

    void preloadSmartScreenAd(AdSlotParam adSlotParam);

    void setAllowMobileTraffic(int i10);

    void setDefaultSplashMode(int i10);

    void setExSplashShowTime(int i10);

    void setSloganDefTime(int i10);

    void setSloganShowTimeWhenNoAd(int i10);

    void setSmartScreenSloganTime(int i10);

    void setUsePostAtFront(boolean z10);
}
