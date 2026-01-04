package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.C7799cs;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@OuterVisible
/* loaded from: classes2.dex */
public interface INativeAd extends IAd, IAdEx, Serializable {

    @OuterVisible
    public static class Converter {
        /* renamed from: a */
        private static C7302e m44469a(C7302e c7302e) {
            VideoInfo videoInfo = c7302e.getVideoInfo();
            if (videoInfo != null) {
                videoInfo.m44579e(0);
                videoInfo.m44580e(videoInfo.getVideoAutoPlayWithSound());
            }
            c7302e.m44799a(videoInfo);
            return c7302e;
        }

        @OuterVisible
        public static INativeAd deserialization(String str) {
            Serializable serializableM48113b = C7799cs.m48113b(str);
            if (serializableM48113b instanceof C7302e) {
                return m44469a((C7302e) serializableM48113b);
            }
            return null;
        }

        @OuterVisible
        public static String serialization(INativeAd iNativeAd) {
            return C7799cs.m48111a(iNativeAd);
        }
    }

    List<String> getAdCloseKeyWords();

    List<AdvertiserInfo> getAdvertiserInfo();

    AudioInfo getAudioInfo();

    String getDescription();

    Map<String, String> getExt();

    List<FeedbackInfo> getFeedbackInfoList();

    ImageInfo getIcon();

    List<ImageInfo> getImageInfos();

    String getIntentUri();

    int getInterActionType();

    List<String> getInvalidContentIds();

    String getJumpText(Context context);

    String getLandWebUrl();

    @OuterVisible
    String getPrivacyLink();

    List<ImageInfo> getRawImageInfos();

    String getSlotId();

    List<String> getSubDescription();

    String getTitle();

    VideoConfiguration getVideoConfiguration();

    VideoInfo getVideoInfo();

    @OuterVisible
    boolean hasAdvertiserInfo();

    boolean isAutoDownloadApp();

    boolean isClicked();

    boolean isUseGaussianBlur();

    boolean isValid(Context context);

    boolean isVideoAd();

    void onAdClose(Context context, List<String> list);

    boolean onFeedback(Context context, int i10, List<FeedbackInfo> list);

    boolean recordClickEvent(Context context, Bundle bundle);

    boolean recordImpressionEvent(Context context, Bundle bundle);

    boolean recordShowStartEvent(Context context, Bundle bundle);

    void setAutoDownloadApp(boolean z10);

    void setVideoConfiguration(VideoConfiguration videoConfiguration);

    boolean showFeedback(Context context, View view, AdFeedbackListener adFeedbackListener);

    boolean triggerClick(Context context, Bundle bundle);
}
