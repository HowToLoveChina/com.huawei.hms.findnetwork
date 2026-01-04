package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.inter.C7309g;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.p169ad.inter.listeners.InterstitialAdListener;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public class InterstitialAd {

    /* renamed from: a */
    private final C7309g f33627a;

    @OuterVisible
    public InterstitialAd(Context context) {
        this.f33627a = new C7309g(context);
    }

    /* renamed from: a */
    public void m44481a(List<InterfaceC7299b> list) {
        this.f33627a.m45012a(list);
    }

    @OuterVisible
    public final String getAdId() {
        return this.f33627a.m45014b();
    }

    @OuterVisible
    public final InterstitialAdListener getAdListener() {
        return this.f33627a.m45000a();
    }

    @OuterVisible
    public final Bundle getAdMetadata() {
        return this.f33627a.m45018e();
    }

    @OuterVisible
    public BiddingInfo getBiddingInfo() {
        return this.f33627a.m45020g() == null ? new BiddingInfo() : this.f33627a.m45020g();
    }

    @OuterVisible
    public final boolean isLoaded() {
        return this.f33627a.m45016c();
    }

    @OuterVisible
    public final boolean isLoading() {
        return this.f33627a.m45017d();
    }

    @OuterVisible
    public final void loadAd(RequestOptions requestOptions) {
        this.f33627a.m45004a(requestOptions);
    }

    @OuterVisible
    public final void setAdId(String str) {
        this.f33627a.m45011a(str);
    }

    @OuterVisible
    public final void setAdListener(InterstitialAdListener interstitialAdListener) {
        this.f33627a.m45008a(interstitialAdListener);
    }

    @OuterVisible
    public final void setContentBundle(String str) {
        this.f33627a.m45015b(str);
    }

    @OuterVisible
    public final void setLocation(Location location) {
        this.f33627a.m45002a(location);
    }

    @OuterVisible
    public final void setRewardAdStatusListener(IRewardAdStatusListener iRewardAdStatusListener) {
        this.f33627a.m45007a(iRewardAdStatusListener);
    }

    @OuterVisible
    public final void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.f33627a.m45006a(rewardVerifyConfig);
    }

    @OuterVisible
    public void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        this.f33627a.m45003a(videoConfiguration);
    }

    @OuterVisible
    public final void show() {
        this.f33627a.m45019f();
    }
}
