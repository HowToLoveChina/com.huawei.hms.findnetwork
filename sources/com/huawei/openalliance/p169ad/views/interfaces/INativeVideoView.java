package com.huawei.openalliance.p169ad.views.interfaces;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.views.VideoView;

@OuterVisible
/* loaded from: classes2.dex */
public interface INativeVideoView extends InterfaceC7337jk {
    ImageView getPreviewImageView();

    VideoView getVideoView();

    void notifyStreamError(int i10);

    void onCheckVideoHashResult(VideoInfo videoInfo, boolean z10);

    void onPreviewImageLoaded(ImageInfo imageInfo, Drawable drawable);

    @OuterVisible
    void pause();

    void setNativeAd(INativeAd iNativeAd);

    void setPpsNativeView(IPPSNativeView iPPSNativeView);

    void showFullScreenSwitchButton(boolean z10);

    @OuterVisible
    void stop();

    void updateContent(String str);

    void updateStartShowTime(long j10);
}
