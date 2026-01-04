package com.huawei.openalliance.p169ad.inter;

import android.location.Location;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.inter.listeners.ContentIdListener;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public interface INativeAdLoader {
    void enableDirectCacheVideo(boolean z10);

    void enableDirectReturnVideoAd(boolean z10);

    void loadAds(int i10, String str, boolean z10);

    void loadAds(int i10, boolean z10);

    void setAdHeight(Integer num);

    void setAdWidth(Integer num);

    void setAdsReturnedFromThread(boolean z10);

    void setAudioTotalDuration(Integer num);

    void setContentBundle(String str);

    void setContentIdListener(ContentIdListener contentIdListener);

    void setDetailedCreativeType(List<Integer> list);

    void setExtraInfo(String str);

    void setIsSmart(Integer num);

    void setJssdkVersion(String str);

    void setListener(NativeAdListener nativeAdListener);

    void setLocation(Location location);

    void setMaxAdNumbers(int i10);

    void setRequestOptions(RequestOptions requestOptions);

    void setSupportTptAd(boolean z10);
}
