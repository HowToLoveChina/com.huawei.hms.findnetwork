package com.huawei.hms.videokit.player;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.videokit.player.internal.InterfaceC6566a;
import com.huawei.hms.videokit.player.internal.InterfaceC6567b;
import com.huawei.hms.videokit.player.internal.InterfaceC6568c;
import com.huawei.hms.videokit.player.internal.InterfaceC6570e;
import com.huawei.hms.videokit.player.internal.InterfaceC6571f;
import com.huawei.hms.videokit.player.internal.InterfaceC6573h;
import com.huawei.hms.videokit.player.internal.InterfaceC6574i;
import com.huawei.hms.videokit.player.internal.InterfaceC6575j;
import com.huawei.hms.videokit.player.internal.InterfaceC6577l;
import com.huawei.openalliance.p169ad.constant.VastAttribute;

/* renamed from: com.huawei.hms.videokit.player.d */
/* loaded from: classes8.dex */
class C6551d implements InterfaceC6571f {
    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public long mo37166a() throws RemoteException {
        return 0L;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: b */
    public String mo37182b() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getOMCdnUrl");
        return "";
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: c */
    public int mo37185c() throws RemoteException {
        return 0;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void closeLogo() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "closeLogo");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: d */
    public void mo37190d(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setCloseIPV6");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void deselectSubtitleTrack() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "deselectSubtitleTrack");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: e */
    public void mo37192e(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "seekPrecisely");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public AudioTrackInfo[] getAudioTracks() throws RemoteException {
        C6550c1.m37256a("DummyMediaPlayer", "getAudioTracks");
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getBufferTime() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getBufferTime");
        return 0;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public long getBufferingSpeed() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getBufferingSpeed");
        return 0L;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public StreamInfo getCurrentStreamInfo() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getCurrentStreamInfo");
        return new StreamInfo();
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getCurrentTime() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getCurrentTime");
        return 0;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getDuration() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getDuration");
        return 0;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getPlayMode() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getPlayMode");
        return 0;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public float getPlaySpeed() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getPlaySpeed");
        return 0.0f;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public AudioTrackInfo getSelectedAudioTrack() throws RemoteException {
        C6550c1.m37256a("DummyMediaPlayer", "getSelectedAudioTrack");
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public SubtitleTrackInfo getSelectedSubtitleTrack() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getSelectedSubtitleTrack");
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public SubtitleTrackInfo[] getSubtitleTracks() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getSubtitleTracks");
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getVideoHeight() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getVideoHeight");
        return 0;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public VideoInfo getVideoInfo() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getVideoInfo");
        return new VideoInfo();
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int getVideoWidth() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getVideoWidth");
        return 0;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public boolean isPlaying() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "isPlaying");
        return false;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void pause() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", VastAttribute.PAUSE);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void presetAudioLanguage(String str) throws RemoteException {
        C6550c1.m37256a("DummyMediaPlayer", "presetAudioLanguage");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void presetSubtitleLanguage(String str) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "presetSubtitleLanguage language:" + str);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void ready() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "ready");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void refreshPlayUrl(String str) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "refreshPlayUrl");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void release() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "release");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void reset() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "reset");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void resume(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "resume");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void seek(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "seek");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void selectAudioTrack(int i10) throws RemoteException {
        C6550c1.m37256a("DummyMediaPlayer", "selectAudioTrack");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void selectSubtitleTrack(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "selectSubtitleTrack id:" + i10);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public int setBandwidthSwitchMode(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setBandwidthSwitchMode");
        return 0;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setBitrateRange(int i10, int i11) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setBitrateRange");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setBookmark(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setBookmark");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setBufferingStatus(boolean z10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setBufferingStatus");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setCycleMode(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setCycleMode");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setInitBitrate(InitBitrateParam initBitrateParam) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setInitBitrate");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setMute(boolean z10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setMute");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setPlayMode(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setPlayMode");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setPlaySpeed(float f10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setPlaySpeed");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setSurfaceChange() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setSurfaceChange");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setVideoType(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setVideoType");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void setVolume(float f10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setVolume");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void start() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "start");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void stop() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "stop");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void suspend() throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "suspend");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void switchBitrateDesignated(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "switchBitrateDesignated");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    public void switchBitrateSmooth(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "switchBitrateSmooth");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37167a(int i10) throws RemoteException {
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: b */
    public void mo37183b(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setDeviceType");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: c */
    public IObjectWrapper mo37186c(int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "getProperties");
        return null;
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: d */
    public void mo37191d(String str) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setVodInfo");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: e */
    public void mo37193e(boolean z10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setSingleLinkDownload");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37168a(IObjectWrapper iObjectWrapper, int i10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setWakeMode : " + i10);
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: b */
    public void mo37184b(boolean z10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setSwitchEnable");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: c */
    public void mo37187c(IObjectWrapper iObjectWrapper) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setView");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37169a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "create");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: c */
    public void mo37188c(String str) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setInitBufferTimeStrategy");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37170a(InterfaceC6566a interfaceC6566a) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setErrorListener");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: c */
    public void mo37189c(boolean z10) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setPreciseSeeking");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37171a(InterfaceC6567b interfaceC6567b) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setEventListener");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37172a(InterfaceC6568c interfaceC6568c) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setLoadingListener");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37173a(InterfaceC6570e interfaceC6570e) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setPlayEndListener");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37174a(InterfaceC6573h interfaceC6573h) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setReadyListener");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37175a(InterfaceC6574i interfaceC6574i) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setResolutionUpdatedListener");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37176a(InterfaceC6575j interfaceC6575j) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setSeekEndListener");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37177a(InterfaceC6577l interfaceC6577l) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setSubtitleUpdateListener");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37178a(String str) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setMediaUrl");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37179a(String str, String str2, String str3, String str4) throws RemoteException {
        C6550c1.m37256a("DummyMediaPlayer", "setProxy");
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37180a(boolean z10) throws RemoteException {
    }

    @Override // com.huawei.hms.videokit.player.internal.InterfaceC6571f
    /* renamed from: a */
    public void mo37181a(String[] strArr) throws RemoteException {
        C6550c1.m37264c("DummyMediaPlayer", "setMediaUrlArray");
    }
}
