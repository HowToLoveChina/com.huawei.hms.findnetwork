package com.huawei.hms.videokit.player;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import com.huawei.hms.videokit.player.bean.PreviewPicture;
import com.huawei.hms.videokit.player.bean.Proxy;
import com.huawei.hms.videokit.player.bean.recommend.RecommendOptions;
import com.huawei.hms.videokit.player.bean.recommend.RecommendVideo;
import java.util.List;

/* loaded from: classes8.dex */
public interface WisePlayer {

    public interface ErrorListener {
        boolean onError(WisePlayer wisePlayer, int i10, int i11);
    }

    public interface EventListener {
        boolean onEvent(WisePlayer wisePlayer, int i10, int i11, Object obj);
    }

    public interface IRecommendVideoCallback {
        void onFailed(int i10, int i11, Object obj);

        void onSuccess(List<RecommendVideo> list);
    }

    public interface LoadingListener {
        void onLoadingUpdate(WisePlayer wisePlayer, int i10);

        void onStartPlaying(WisePlayer wisePlayer);
    }

    public interface PlayEndListener {
        void onPlayEnd(WisePlayer wisePlayer);
    }

    public interface PreviewPicListener {
        void onPreviewPicNotify(WisePlayer wisePlayer, PreviewPicture previewPicture);
    }

    public interface ReadyListener {
        void onReady(WisePlayer wisePlayer);
    }

    public interface ResolutionUpdatedListener {
        void onResolutionUpdated(WisePlayer wisePlayer, int i10, int i11);
    }

    public interface SeekEndListener {
        void onSeekEnd(WisePlayer wisePlayer);
    }

    public interface SubtitleUpdateListener {
        void onSubtitleUpdate(WisePlayer wisePlayer, Parcelable[] parcelableArr);
    }

    void closeLogo();

    void deselectSubtitleTrack();

    AudioTrackInfo[] getAudioTracks();

    int getBufferTime();

    long getBufferingSpeed();

    StreamInfo getCurrentStreamInfo();

    int getCurrentTime();

    int getCycleMode();

    int getDuration();

    int getPlayMode();

    float getPlaySpeed();

    void getRecommendVideoList(String str, RecommendOptions recommendOptions, String str2, IRecommendVideoCallback iRecommendVideoCallback);

    AudioTrackInfo getSelectedAudioTrack();

    SubtitleTrackInfo getSelectedSubtitleTrack();

    SubtitleTrackInfo[] getSubtitleTracks();

    int getVideoHeight();

    VideoInfo getVideoInfo();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void presetAudioLanguage(String str);

    void presetSubtitleLanguage(String str);

    void ready();

    void refreshPlayUrl(String str);

    void release();

    void reset();

    void resume(int i10);

    void seek(int i10);

    void seek(int i10, int i11);

    void selectAudioTrack(int i10);

    void selectSubtitleTrack(int i10);

    int setBandwidthSwitchMode(int i10);

    void setBitrateRange(int i10, int i11);

    void setBookmark(int i10);

    void setBufferingStatus(boolean z10);

    void setCycleMode(int i10);

    void setErrorListener(ErrorListener errorListener);

    void setEventListener(EventListener eventListener);

    void setInitBitrate(InitBitrateParam initBitrateParam);

    void setInitBufferTimeStrategy(InitBufferTimeStrategy initBufferTimeStrategy);

    void setLoadingListener(LoadingListener loadingListener);

    void setMute(boolean z10);

    void setPlayEndListener(PlayEndListener playEndListener);

    void setPlayMode(int i10);

    void setPlaySpeed(float f10);

    void setPlayUrl(String str);

    void setPlayUrl(String str, String str2, int i10);

    void setPlayUrl(String str, String str2, int i10, int i11);

    void setPlayUrl(String[] strArr);

    void setPreviewPicListener(PreviewPicListener previewPicListener);

    int setProperties(int i10, Object... objArr);

    void setProxy(Proxy proxy);

    void setReadyListener(ReadyListener readyListener);

    void setResolutionUpdatedListener(ResolutionUpdatedListener resolutionUpdatedListener);

    void setSeekEndListener(SeekEndListener seekEndListener);

    void setSubtitleUpdateListener(SubtitleUpdateListener subtitleUpdateListener);

    void setSurfaceChange();

    void setVideoType(int i10);

    void setView(View view);

    void setVolume(float f10);

    void setWakeMode(Context context, int i10);

    void start();

    void stop();

    void suspend();

    void switchBitrateDesignated(int i10);

    void switchBitrateSmooth(int i10);
}
