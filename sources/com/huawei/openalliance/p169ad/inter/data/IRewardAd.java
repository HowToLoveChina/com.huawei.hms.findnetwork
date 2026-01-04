package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import java.io.Serializable;

@OuterVisible
/* loaded from: classes2.dex */
public interface IRewardAd extends IAd, Serializable {
    RewardItem getRewardItem();

    boolean hasShown();

    boolean isValid();

    void setAudioFocusType(int i10);

    void setCustomData(String str);

    void setMobileDataAlertSwitch(boolean z10);

    void setMute(boolean z10);

    void setNonwifiActionListener(INonwifiActionListener iNonwifiActionListener);

    void setUserId(String str);

    void setVideoConfiguration(VideoConfiguration videoConfiguration);

    void show(Context context, IRewardAdStatusListener iRewardAdStatusListener);
}
