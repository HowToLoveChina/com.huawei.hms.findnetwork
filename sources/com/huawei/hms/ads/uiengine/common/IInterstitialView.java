package com.huawei.hms.ads.uiengine.common;

import android.os.Bundle;
import android.view.ViewGroup;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes8.dex */
public interface IInterstitialView extends InterfaceC7337jk {
    void bindData(String str);

    void destroyView();

    ViewGroup getContentContainer();

    void onAppStatusChanged(String str);

    void onBtnClick(Bundle bundle);

    void onCallBack(String str, Bundle bundle);

    void pauseView();

    void resumeVideoView();

    void setIsNeedRemindData(boolean z10);

    void setProxy(InterstitialApi interstitialApi);
}
