package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7219im;
import com.huawei.openalliance.p169ad.C7333jg;
import com.huawei.openalliance.p169ad.C7511nf;
import com.huawei.openalliance.p169ad.InterfaceC7529nx;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.C7822do;
import com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public class NativePureVideoView extends NativeMediaView implements INativeVideoView, IViewLifeCycle {

    /* renamed from: g */
    private static final String f36417g = "NativePureVideoView";

    /* renamed from: h */
    private InterfaceC7529nx f36418h;

    /* renamed from: i */
    private VideoView f36419i;

    /* renamed from: j */
    private ImageView f36420j;

    /* renamed from: k */
    private boolean f36421k;

    /* renamed from: l */
    private VideoInfo f36422l;

    /* renamed from: m */
    private ImageInfo f36423m;

    /* renamed from: n */
    private boolean f36424n;

    /* renamed from: o */
    private long f36425o;

    /* renamed from: p */
    private long f36426p;

    /* renamed from: q */
    private boolean f36427q;

    /* renamed from: r */
    private IPPSNativeView f36428r;

    /* renamed from: s */
    private C7333jg f36429s;

    /* renamed from: t */
    private Context f36430t;

    /* renamed from: u */
    private MediaBufferListener f36431u;

    /* renamed from: v */
    private final ReportVideoTimeListener f36432v;

    /* renamed from: w */
    private MediaStateListener f36433w;

    /* renamed from: x */
    private MediaErrorListener f36434x;

    /* renamed from: y */
    private MuteListener f36435y;

    @OuterVisible
    public NativePureVideoView(Context context) {
        super(context);
        this.f36427q = false;
        this.f36431u = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a(NativePureVideoView.f36417g, "onBufferingStart");
                }
                NativePureVideoView.this.f36429s.m45289b();
            }
        };
        this.f36432v = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(NativePureVideoView.f36417g, "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (NativePureVideoView.this.f36418h != null) {
                    NativePureVideoView.this.f36418h.m46275b(j10);
                }
            }
        };
        this.f36433w = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i10, true);
                if (NativePureVideoView.this.f36418h != null) {
                    long j10 = i10;
                    NativePureVideoView.this.f36418h.mo46257a(j10, j10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                NativePureVideoView.this.m48813a(i10, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(NativePureVideoView.f36417g, "onMediaStart: %s", Integer.valueOf(i10));
                }
                NativePureVideoView.this.m48835k();
                if (NativePureVideoView.this.f36427q) {
                    return;
                }
                NativePureVideoView.this.f36427q = true;
                NativePureVideoView.this.f36426p = i10;
                NativePureVideoView.this.f36425o = System.currentTimeMillis();
                if (i10 > 0) {
                    NativePureVideoView.this.f36418h.mo45919i();
                } else {
                    NativePureVideoView.this.f36418h.mo45918h();
                    NativePureVideoView.this.f36418h.mo45915a(NativePureVideoView.this.f36429s.m45292e(), NativePureVideoView.this.f36429s.m45291d(), NativePureVideoView.this.f36425o);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i10, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                if (NativePureVideoView.this.f36427q) {
                    NativePureVideoView.this.f36418h.mo46094a(i10, i11, NativePureVideoView.this.f36426p, NativePureVideoView.this.f36428r, ((NativeMediaView) NativePureVideoView.this).f36411c);
                    NativePureVideoView.this.f36418h.mo46257a(i11, NativePureVideoView.this.f36422l == null ? 0 : NativePureVideoView.this.f36422l.getVideoDuration());
                }
                ((NativeMediaView) NativePureVideoView.this).f36413e = i11;
            }
        };
        this.f36434x = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i10, false);
            }
        };
        this.f36435y = new MuteListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.5
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                if (NativePureVideoView.this.f36422l != null) {
                    NativePureVideoView.this.f36422l.m44580e("n");
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                if (NativePureVideoView.this.f36422l != null) {
                    NativePureVideoView.this.f36422l.m44580e("y");
                }
            }
        };
        m48814a(context);
    }

    /* renamed from: g */
    private void m48828g() {
        List<ImageInfo> imageInfos;
        C7302e c7302e = ((NativeMediaView) this).f36411c;
        if (c7302e == null || (imageInfos = c7302e.getImageInfos()) == null || imageInfos.size() <= 0) {
            return;
        }
        ImageInfo imageInfo = imageInfos.get(0);
        this.f36423m = imageInfo;
        if (imageInfo != null) {
            if (AbstractC7806cz.m48181j(imageInfo.getUrl())) {
                AbstractC7185ho.m43820b(f36417g, "don't load preview image with http url");
                return;
            }
            if (this.f36423m.getHeight() > 0) {
                setRatio(Float.valueOf((this.f36423m.getWidth() * 1.0f) / this.f36423m.getHeight()));
            }
            this.f36418h.mo46095a(this.f36423m);
        }
    }

    private String getTAG() {
        return f36417g + "_" + hashCode();
    }

    /* renamed from: i */
    private void m48832i() {
        m48834j();
        this.f36421k = false;
        this.f36424n = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m48834j() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(f36417g, "showPreviewView");
        }
        Animation animation = this.f36420j.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        AbstractC7811dd.m48304a((View) this.f36420j, true);
        this.f36419i.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m48835k() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a(f36417g, "hidePreviewView");
        }
        C7822do.m48383a(this.f36420j, 8, 300, 300);
        this.f36419i.setAlpha(1.0f);
    }

    @OuterVisible
    public void addMediaBufferListener(MediaBufferListener mediaBufferListener) {
        this.f36419i.addMediaBufferListener(mediaBufferListener);
    }

    @OuterVisible
    public void addMediaErrorListener(MediaErrorListener mediaErrorListener) {
        this.f36419i.addMediaErrorListener(mediaErrorListener);
    }

    @OuterVisible
    public void addMediaStateListener(MediaStateListener mediaStateListener) {
        this.f36419i.addMediaStateListener(mediaStateListener);
    }

    @OuterVisible
    public void addMuteListener(MuteListener muteListener) {
        this.f36419i.addMuteListener(muteListener);
    }

    @OuterVisible
    public void addNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        this.f36419i.addNetworkChangeListener(networkChangeListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        this.f36419i.destroyView();
    }

    @OuterVisible
    public MediaState getCurrentState() {
        return this.f36419i.getCurrentState();
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView
    public int getPlayedProgress() {
        VideoInfo videoInfo = this.f36422l;
        if (videoInfo != null && videoInfo.getVideoDuration() > 0) {
            ((NativeMediaView) this).f36412d = (int) ((getPlayedTime() / this.f36422l.getVideoDuration()) * 100.0f);
        }
        return ((NativeMediaView) this).f36412d;
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView
    public int getPlayedTime() {
        return ((NativeMediaView) this).f36413e;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public ImageView getPreviewImageView() {
        return this.f36420j;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public VideoView getVideoView() {
        return this.f36419i;
    }

    @OuterVisible
    public boolean isPlaying() {
        return this.f36419i.isPlaying();
    }

    @OuterVisible
    public void muteSound() {
        this.f36419i.mute();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void notifyStreamError(int i10) {
        MediaErrorListener mediaErrorListener = this.f36434x;
        if (mediaErrorListener != null) {
            mediaErrorListener.onError(null, ((NativeMediaView) this).f36413e, i10, -1);
        }
        InterfaceC7529nx interfaceC7529nx = this.f36418h;
        if (interfaceC7529nx != null) {
            interfaceC7529nx.mo46093a(((NativeMediaView) this).f36413e, i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void onCheckVideoHashResult(VideoInfo videoInfo, boolean z10) {
        VideoInfo videoInfo2;
        AbstractC7185ho.m43821b(f36417g, "onCheckVideoHashResult sucess: %s", Boolean.valueOf(z10));
        if (!z10 || (videoInfo2 = this.f36422l) == null || videoInfo == null || !TextUtils.equals(videoInfo2.getVideoDownloadUrl(), videoInfo.getVideoDownloadUrl())) {
            return;
        }
        this.f36421k = true;
        m48815a(videoInfo);
        if (this.f36424n) {
            m48817a(false);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void onPreviewImageLoaded(ImageInfo imageInfo, Drawable drawable) {
        ImageInfo imageInfo2 = this.f36423m;
        if (imageInfo2 == null || imageInfo == null || !TextUtils.equals(imageInfo2.getUrl(), imageInfo.getUrl())) {
            return;
        }
        this.f36420j.setImageDrawable(drawable);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    @OuterVisible
    public void pause() {
        this.f36419i.pause();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        this.f36419i.pauseView();
    }

    @OuterVisible
    public void play(boolean z10) {
        if (this.f36421k) {
            m48817a(z10);
        } else {
            this.f36424n = true;
        }
    }

    @OuterVisible
    public void removeMediaBufferListener(MediaBufferListener mediaBufferListener) {
        this.f36419i.removeMediaBufferListener(mediaBufferListener);
    }

    @OuterVisible
    public void removeMediaErrorListener(MediaErrorListener mediaErrorListener) {
        this.f36419i.removeMediaErrorListener(mediaErrorListener);
    }

    @OuterVisible
    public void removeMediaStateListener(MediaStateListener mediaStateListener) {
        this.f36419i.removeMediaStateListener(mediaStateListener);
    }

    @OuterVisible
    public void removeMuteListener(MuteListener muteListener) {
        this.f36419i.removeMuteListener(muteListener);
    }

    @OuterVisible
    public void removeNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        this.f36419i.removeNetworkChangeListener(networkChangeListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
        ((NativeMediaView) this).f36409a = false;
        this.f36419i.resumeView();
        this.f36419i.setNeedPauseOnSurfaceDestory(true);
        this.f36414f.onGlobalLayout();
    }

    @OuterVisible
    public void seekTo(int i10) {
        this.f36419i.seekTo(i10);
    }

    @OuterVisible
    public void setAudioFocusType(int i10) {
        this.f36419i.setAudioFocusType(i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView, com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void setNativeAd(INativeAd iNativeAd) {
        MediaState currentState = this.f36419i.getCurrentState();
        if (((NativeMediaView) this).f36411c == iNativeAd && currentState.isNotState(MediaState.State.IDLE) && currentState.isNotState(MediaState.State.ERROR)) {
            AbstractC7185ho.m43820b(f36417g, "setNativeAd - has the same ad");
            return;
        }
        super.setNativeAd(iNativeAd);
        m48832i();
        this.f36418h.mo46097a(((NativeMediaView) this).f36411c);
        if (((NativeMediaView) this).f36411c == null) {
            this.f36422l = null;
        } else {
            m48828g();
            m48831h();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void setPpsNativeView(IPPSNativeView iPPSNativeView) {
        this.f36428r = iPPSNativeView;
    }

    @OuterVisible
    public void setPreferStartPlayTime(int i10) {
        this.f36419i.setPreferStartPlayTime(i10);
    }

    @OuterVisible
    public void setStandalone(boolean z10) {
        this.f36419i.setStandalone(z10);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void showFullScreenSwitchButton(boolean z10) {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    @OuterVisible
    public void stop() {
        this.f36419i.stop();
    }

    @OuterVisible
    public boolean switchToFullScreen() {
        m48822b(4);
        VideoInfo videoInfo = this.f36422l;
        if (videoInfo != null) {
            videoInfo.m44569b(true);
        }
        this.f36419i.setNeedPauseOnSurfaceDestory(false);
        return this.f36418h.mo46100a(this.f36419i.getMediaPlayerAgent(), ((NativeMediaView) this).f36411c);
    }

    @OuterVisible
    public void unmuteSound() {
        this.f36419i.unmute();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void updateContent(String str) {
        this.f36418h.m46274a(str);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void updateStartShowTime(long j10) {
        this.f36418h.m46273a(j10);
    }

    @OuterVisible
    public NativePureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36427q = false;
        this.f36431u = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a(NativePureVideoView.f36417g, "onBufferingStart");
                }
                NativePureVideoView.this.f36429s.m45289b();
            }
        };
        this.f36432v = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(NativePureVideoView.f36417g, "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (NativePureVideoView.this.f36418h != null) {
                    NativePureVideoView.this.f36418h.m46275b(j10);
                }
            }
        };
        this.f36433w = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i10, true);
                if (NativePureVideoView.this.f36418h != null) {
                    long j10 = i10;
                    NativePureVideoView.this.f36418h.mo46257a(j10, j10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                NativePureVideoView.this.m48813a(i10, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(NativePureVideoView.f36417g, "onMediaStart: %s", Integer.valueOf(i10));
                }
                NativePureVideoView.this.m48835k();
                if (NativePureVideoView.this.f36427q) {
                    return;
                }
                NativePureVideoView.this.f36427q = true;
                NativePureVideoView.this.f36426p = i10;
                NativePureVideoView.this.f36425o = System.currentTimeMillis();
                if (i10 > 0) {
                    NativePureVideoView.this.f36418h.mo45919i();
                } else {
                    NativePureVideoView.this.f36418h.mo45918h();
                    NativePureVideoView.this.f36418h.mo45915a(NativePureVideoView.this.f36429s.m45292e(), NativePureVideoView.this.f36429s.m45291d(), NativePureVideoView.this.f36425o);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i10, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                if (NativePureVideoView.this.f36427q) {
                    NativePureVideoView.this.f36418h.mo46094a(i10, i11, NativePureVideoView.this.f36426p, NativePureVideoView.this.f36428r, ((NativeMediaView) NativePureVideoView.this).f36411c);
                    NativePureVideoView.this.f36418h.mo46257a(i11, NativePureVideoView.this.f36422l == null ? 0 : NativePureVideoView.this.f36422l.getVideoDuration());
                }
                ((NativeMediaView) NativePureVideoView.this).f36413e = i11;
            }
        };
        this.f36434x = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i10, false);
            }
        };
        this.f36435y = new MuteListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.5
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                if (NativePureVideoView.this.f36422l != null) {
                    NativePureVideoView.this.f36422l.m44580e("n");
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                if (NativePureVideoView.this.f36422l != null) {
                    NativePureVideoView.this.f36422l.m44580e("y");
                }
            }
        };
        m48814a(context);
    }

    /* renamed from: h */
    private void m48831h() {
        C7302e c7302e = ((NativeMediaView) this).f36411c;
        if (c7302e == null) {
            return;
        }
        VideoInfo videoInfo = c7302e.getVideoInfo();
        this.f36422l = videoInfo;
        if (videoInfo != null) {
            Float videoRatio = videoInfo.getVideoRatio();
            if (videoRatio == null) {
                videoRatio = Float.valueOf(1.7777778f);
            }
            setRatio(videoRatio);
            this.f36419i.setDefaultDuration(this.f36422l.getVideoDuration());
            this.f36418h.mo46096a(this.f36422l);
        }
    }

    @OuterVisible
    public void seekTo(int i10, int i11) {
        this.f36419i.m48789c(i10, i11);
    }

    @OuterVisible
    public NativePureVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36427q = false;
        this.f36431u = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i102) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a(NativePureVideoView.f36417g, "onBufferingStart");
                }
                NativePureVideoView.this.f36429s.m45289b();
            }
        };
        this.f36432v = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(NativePureVideoView.f36417g, "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (NativePureVideoView.this.f36418h != null) {
                    NativePureVideoView.this.f36418h.m46275b(j10);
                }
            }
        };
        this.f36433w = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i102) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i102, true);
                if (NativePureVideoView.this.f36418h != null) {
                    long j10 = i102;
                    NativePureVideoView.this.f36418h.mo46257a(j10, j10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i102) {
                NativePureVideoView.this.m48813a(i102, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i102) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(NativePureVideoView.f36417g, "onMediaStart: %s", Integer.valueOf(i102));
                }
                NativePureVideoView.this.m48835k();
                if (NativePureVideoView.this.f36427q) {
                    return;
                }
                NativePureVideoView.this.f36427q = true;
                NativePureVideoView.this.f36426p = i102;
                NativePureVideoView.this.f36425o = System.currentTimeMillis();
                if (i102 > 0) {
                    NativePureVideoView.this.f36418h.mo45919i();
                } else {
                    NativePureVideoView.this.f36418h.mo45918h();
                    NativePureVideoView.this.f36418h.mo45915a(NativePureVideoView.this.f36429s.m45292e(), NativePureVideoView.this.f36429s.m45291d(), NativePureVideoView.this.f36425o);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i102) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i102, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i102, int i11) {
                if (NativePureVideoView.this.f36427q) {
                    NativePureVideoView.this.f36418h.mo46094a(i102, i11, NativePureVideoView.this.f36426p, NativePureVideoView.this.f36428r, ((NativeMediaView) NativePureVideoView.this).f36411c);
                    NativePureVideoView.this.f36418h.mo46257a(i11, NativePureVideoView.this.f36422l == null ? 0 : NativePureVideoView.this.f36422l.getVideoDuration());
                }
                ((NativeMediaView) NativePureVideoView.this).f36413e = i11;
            }
        };
        this.f36434x = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i102, int i11, int i12) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i102, false);
            }
        };
        this.f36435y = new MuteListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.5
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                if (NativePureVideoView.this.f36422l != null) {
                    NativePureVideoView.this.f36422l.m44580e("n");
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                if (NativePureVideoView.this.f36422l != null) {
                    NativePureVideoView.this.f36422l.m44580e("y");
                }
            }
        };
        m48814a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48813a(int i10, boolean z10) {
        this.f36429s.m45290c();
        if (this.f36427q) {
            this.f36427q = false;
            if (!z10) {
                this.f36418h.mo45917c(this.f36425o, System.currentTimeMillis(), this.f36426p, i10);
            } else {
                this.f36418h.mo45916b(this.f36425o, System.currentTimeMillis(), this.f36426p, i10);
                this.f36418h.mo46098a(this.f36428r, ((NativeMediaView) this).f36411c);
            }
        }
    }

    /* renamed from: b */
    private String m48821b(VideoInfo videoInfo) {
        if (videoInfo != null && AbstractC7806cz.m48181j(videoInfo.m44586g()) && AbstractC7741ao.m47553a(videoInfo)) {
            return AbstractC7741ao.m47541a(this.f36430t, videoInfo, new C7219im(this));
        }
        return null;
    }

    @OuterVisible
    public NativePureVideoView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f36427q = false;
        this.f36431u = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i102) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a(NativePureVideoView.f36417g, "onBufferingStart");
                }
                NativePureVideoView.this.f36429s.m45289b();
            }
        };
        this.f36432v = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(NativePureVideoView.f36417g, "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (NativePureVideoView.this.f36418h != null) {
                    NativePureVideoView.this.f36418h.m46275b(j10);
                }
            }
        };
        this.f36433w = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i102) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i102, true);
                if (NativePureVideoView.this.f36418h != null) {
                    long j10 = i102;
                    NativePureVideoView.this.f36418h.mo46257a(j10, j10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i102) {
                NativePureVideoView.this.m48813a(i102, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i102) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(NativePureVideoView.f36417g, "onMediaStart: %s", Integer.valueOf(i102));
                }
                NativePureVideoView.this.m48835k();
                if (NativePureVideoView.this.f36427q) {
                    return;
                }
                NativePureVideoView.this.f36427q = true;
                NativePureVideoView.this.f36426p = i102;
                NativePureVideoView.this.f36425o = System.currentTimeMillis();
                if (i102 > 0) {
                    NativePureVideoView.this.f36418h.mo45919i();
                } else {
                    NativePureVideoView.this.f36418h.mo45918h();
                    NativePureVideoView.this.f36418h.mo45915a(NativePureVideoView.this.f36429s.m45292e(), NativePureVideoView.this.f36429s.m45291d(), NativePureVideoView.this.f36425o);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i102) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i102, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i102, int i112) {
                if (NativePureVideoView.this.f36427q) {
                    NativePureVideoView.this.f36418h.mo46094a(i102, i112, NativePureVideoView.this.f36426p, NativePureVideoView.this.f36428r, ((NativeMediaView) NativePureVideoView.this).f36411c);
                    NativePureVideoView.this.f36418h.mo46257a(i112, NativePureVideoView.this.f36422l == null ? 0 : NativePureVideoView.this.f36422l.getVideoDuration());
                }
                ((NativeMediaView) NativePureVideoView.this).f36413e = i112;
            }
        };
        this.f36434x = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i102, int i112, int i12) {
                NativePureVideoView.this.m48834j();
                NativePureVideoView.this.m48813a(i102, false);
            }
        };
        this.f36435y = new MuteListener() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.5
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                if (NativePureVideoView.this.f36422l != null) {
                    NativePureVideoView.this.f36422l.m44580e("n");
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                if (NativePureVideoView.this.f36422l != null) {
                    NativePureVideoView.this.f36422l.m44580e("y");
                }
            }
        };
        m48814a(context);
    }

    /* renamed from: a */
    private void m48814a(Context context) {
        this.f36430t = context;
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_native_pure_video_view, this);
        this.f36418h = new C7511nf(context, this);
        this.f36419i = (VideoView) findViewById(C6849R.id.hiad_id_video_view);
        this.f36420j = (ImageView) findViewById(C6849R.id.hiad_iv_preview_video);
        this.f36419i.setScreenOnWhilePlaying(true);
        this.f36419i.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.f36419i.addMediaStateListener(this.f36433w);
        this.f36419i.addMediaBufferListener(this.f36431u);
        this.f36419i.addMediaErrorListener(this.f36434x);
        this.f36419i.addMuteListener(this.f36435y);
        this.f36419i.addReportVideoTimeListenersSet(this.f36432v);
        this.f36429s = new C7333jg(getTAG());
    }

    /* renamed from: b */
    private void m48822b(int i10) {
        IPPSNativeView iPPSNativeView = this.f36428r;
        if (iPPSNativeView != null) {
            iPPSNativeView.mo49347a(Integer.valueOf(i10));
        }
    }

    /* renamed from: a */
    private void m48815a(VideoInfo videoInfo) {
        String videoDownloadUrl = videoInfo.getVideoDownloadUrl();
        if (videoDownloadUrl.startsWith(Scheme.DISKCACHE.toString())) {
            AbstractC7185ho.m43820b(f36417g, "video cached, play from local.");
        } else {
            String strM41968c = C7019dh.m41937a(this.f36430t, Constants.NORMAL_CACHE).m41968c(C7022dk.m41953d(videoDownloadUrl));
            if (!TextUtils.isEmpty(strM41968c) && AbstractC7731ae.m47456b(this.f36430t, strM41968c)) {
                AbstractC7185ho.m43820b(f36417g, "video cached, play from local.");
                this.f36419i.setVideoFileUrl(strM41968c);
                return;
            }
            String str = f36417g;
            AbstractC7185ho.m43820b(str, "video not cached, play from net.");
            String strM48821b = m48821b(videoInfo);
            if (!TextUtils.isEmpty(strM48821b)) {
                AbstractC7185ho.m43820b(str, "play mode 3, cache while playing.");
                videoDownloadUrl = strM48821b;
            }
        }
        this.f36419i.setVideoFileUrl(videoDownloadUrl);
    }

    /* renamed from: a */
    private void m48817a(boolean z10) {
        AbstractC7185ho.m43820b(f36417g, "doRealPlay, auto:" + z10);
        this.f36429s.m45288a();
        this.f36419i.play(z10);
    }
}
