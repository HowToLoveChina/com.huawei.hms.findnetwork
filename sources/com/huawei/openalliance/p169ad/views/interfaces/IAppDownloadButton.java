package com.huawei.openalliance.p169ad.views.interfaces;

import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.views.AppDownloadButton;
import com.huawei.openalliance.p169ad.views.AppDownloadButtonStyle;
import com.huawei.openalliance.p169ad.views.PPSAppDetailView;

@OuterVisible
/* loaded from: classes2.dex */
public interface IAppDownloadButton extends InterfaceC7337jk {
    void cancel();

    AppStatus refreshStatus();

    void refreshStatusAsync(AppDownloadButton.OnStatusRefreshedListener onStatusRefreshedListener);

    void setAdLandingPageData(AdLandingPageData adLandingPageData);

    void setAppDetailView(PPSAppDetailView pPSAppDetailView);

    void setAppDownloadButtonStyle(AppDownloadButtonStyle appDownloadButtonStyle);

    boolean setNativeAd(INativeAd iNativeAd);

    boolean setPlacementAd(IPlacementAd iPlacementAd);

    void setPpsLinkedView(IPPSLinkedView iPPSLinkedView);

    void setPpsNativeView(IPPSNativeView iPPSNativeView);

    void setPpsPlacementView(IPPSPlacementView iPPSPlacementView);

    void updateContent(String str);

    void updateStartShowTime(long j10);
}
