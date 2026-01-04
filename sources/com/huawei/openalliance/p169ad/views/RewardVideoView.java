package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7333jg;
import com.huawei.openalliance.p169ad.C7405lo;
import com.huawei.openalliance.p169ad.C7482mq;
import com.huawei.openalliance.p169ad.C7522nq;
import com.huawei.openalliance.p169ad.EnumC7481mp;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.InterfaceC7538of;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener;
import com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.views.interfaces.IRewardVideoView;

/* loaded from: classes2.dex */
public class RewardVideoView extends RewardMediaView implements InterfaceC7403lm, IRewardVideoView {

    /* renamed from: A */
    private final ReportVideoTimeListener f37327A;

    /* renamed from: B */
    private MediaStateListener f37328B;

    /* renamed from: C */
    private MuteListener f37329C;

    /* renamed from: D */
    private MediaErrorListener f37330D;

    /* renamed from: e */
    private InterfaceC7416lz f37331e;

    /* renamed from: f */
    private InterfaceC7538of f37332f;

    /* renamed from: g */
    private VideoView f37333g;

    /* renamed from: h */
    private boolean f37334h;

    /* renamed from: i */
    private VideoInfo f37335i;

    /* renamed from: j */
    private boolean f37336j;

    /* renamed from: k */
    private boolean f37337k;

    /* renamed from: l */
    private long f37338l;

    /* renamed from: m */
    private long f37339m;

    /* renamed from: n */
    private boolean f37340n;

    /* renamed from: o */
    private boolean f37341o;

    /* renamed from: p */
    private int f37342p;

    /* renamed from: q */
    private boolean f37343q;

    /* renamed from: r */
    private ImageView f37344r;

    /* renamed from: s */
    private C7333jg f37345s;

    /* renamed from: t */
    private boolean f37346t;

    /* renamed from: u */
    private int f37347u;

    /* renamed from: v */
    private int f37348v;

    /* renamed from: w */
    private int f37349w;

    /* renamed from: x */
    private long f37350x;

    /* renamed from: y */
    private boolean f37351y;

    /* renamed from: z */
    private MediaBufferListener f37352z;

    public RewardVideoView(Context context) {
        super(context);
        this.f37331e = new C7405lo();
        this.f37337k = true;
        this.f37343q = false;
        this.f37346t = true;
        this.f37347u = 0;
        this.f37348v = 0;
        this.f37349w = 5000;
        this.f37350x = -1L;
        this.f37351y = false;
        this.f37352z = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                RewardVideoView.this.f37331e.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("RewardVideoView", "onBufferingStart");
                }
                RewardVideoView.this.f37345s.m45289b();
                RewardVideoView.this.f37331e.mo45621h();
            }
        };
        this.f37327A = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.2
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("RewardVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (RewardVideoView.this.f37332f != null) {
                    RewardVideoView.this.f37332f.m46275b(j10);
                }
            }
        };
        this.f37328B = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                RewardVideoView.this.m49888b(i10, true);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                RewardVideoView.this.m49888b(i10, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("RewardVideoView", "onMediaStart: %d", Integer.valueOf(i10));
                }
                RewardVideoView.this.setTryPlayStartTime(-1L);
                RewardVideoView.this.f37340n = true;
                RewardVideoView.this.f37339m = i10;
                RewardVideoView.this.f37338l = System.currentTimeMillis();
                RewardVideoView rewardVideoView = RewardVideoView.this;
                if (i10 > 0) {
                    rewardVideoView.f37332f.mo45919i();
                    if (RewardVideoView.this.f37331e != null) {
                        RewardVideoView.this.f37331e.mo45625l();
                        return;
                    }
                    return;
                }
                if (rewardVideoView.f37331e != null && RewardVideoView.this.f37335i != null) {
                    AbstractC7185ho.m43820b("RewardVideoView", "om start");
                    RewardVideoView.this.f37331e.mo45606a(RewardVideoView.this.f37335i.getVideoDuration(), !"y".equals(RewardVideoView.this.f37335i.getSoundSwitch()));
                }
                RewardVideoView.this.f37332f.mo45918h();
                RewardVideoView.this.f37332f.mo45915a(RewardVideoView.this.f37345s.m45292e(), RewardVideoView.this.f37345s.m45291d(), RewardVideoView.this.f37338l);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                RewardVideoView.this.m49888b(i10, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                RewardVideoView.this.f37348v = i11;
                if (RewardVideoView.this.f37331e == null || !RewardVideoView.this.f37340n) {
                    return;
                }
                RewardVideoView.this.f37331e.mo45605a(i10);
            }
        };
        this.f37329C = new MuteListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                RewardVideoView.this.m49884a(true);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                RewardVideoView.this.m49884a(false);
            }
        };
        this.f37330D = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.5
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                RewardVideoView.this.m49888b(i10, false);
            }
        };
        m49881a(context);
    }

    /* renamed from: g */
    private void m49896g() {
        if (((RewardMediaView) this).f37312a == null) {
            return;
        }
        AbstractC7185ho.m43820b("RewardVideoView", "loadVideoInfo");
        VideoInfo videoInfoM44918K = ((RewardMediaView) this).f37312a.m44918K();
        if (videoInfoM44918K != null) {
            this.f37335i = videoInfoM44918K;
            Float videoRatio = videoInfoM44918K.getVideoRatio();
            if (videoRatio != null && this.f37346t) {
                setRatio(videoRatio);
                this.f37333g.setRatio(videoRatio);
            }
            this.f37333g.setDefaultDuration(this.f37335i.getVideoDuration());
            this.f37332f.mo46198a(this.f37335i);
            this.f37336j = false;
            this.f37337k = true;
        }
    }

    /* renamed from: h */
    private void m49897h() {
        AbstractC7185ho.m43820b("RewardVideoView", "resetVideoView");
        setPreferStartPlayTime(0);
        this.f37334h = false;
        this.f37336j = false;
        this.f37337k = true;
        this.f37351y = false;
    }

    /* renamed from: i */
    private boolean m49898i() {
        if (this.f37335i == null || !C7775bv.m47831e(getContext())) {
            return false;
        }
        if (C7775bv.m47826a(getContext())) {
            return true;
        }
        return (AbstractC7806cz.m48181j(this.f37335i.getVideoDownloadUrl()) && TextUtils.isEmpty(C7019dh.m41937a(getContext(), Constants.NORMAL_CACHE).m41970e(this.f37335i.getVideoDownloadUrl()))) ? false : true;
    }

    /* renamed from: j */
    private void m49899j() {
        VideoView videoView;
        if (this.f37332f == null || this.f37345s == null || (videoView = this.f37333g) == null || this.f37351y) {
            return;
        }
        MediaState currentState = videoView.getCurrentState();
        MediaState.State state = MediaState.State.ERROR;
        Integer num = currentState.isState(state) ? -2 : m49900k() ? -1 : null;
        if (currentState.isState(state)) {
            num = -2;
        }
        if (num != null) {
            this.f37351y = true;
            AbstractC7185ho.m43821b("RewardVideoView", "video error: %s", num);
            long jM47566c = this.f37350x > 0 ? AbstractC7741ao.m47566c() - this.f37350x : 0L;
            AbstractC7185ho.m43818a("RewardVideoView", "do play time: %s", Long.valueOf(jM47566c));
            this.f37332f.mo46197a(getContext().getApplicationContext(), jM47566c, this.f37348v, num.intValue());
        }
    }

    /* renamed from: k */
    private boolean m49900k() {
        return this.f37350x > 0 && !this.f37340n && AbstractC7741ao.m47566c() - this.f37350x > ((long) this.f37349w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTryPlayStartTime(long j10) {
        this.f37350x = j10;
    }

    @Override // com.huawei.openalliance.p169ad.views.RewardMediaView
    /* renamed from: d */
    public void mo49876d() {
        this.f37333g.unmute();
    }

    @Override // com.huawei.openalliance.p169ad.views.RewardMediaView, com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        AbstractC7185ho.m43820b("RewardVideoView", RewardMethods.DESTROY_VIEW);
        this.f37351y = false;
        this.f37333g.destroyView();
    }

    public MediaState getCurrentState() {
        return this.f37333g.getCurrentState();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    public int getPlayedProgress() {
        VideoInfo videoInfo = this.f37335i;
        if (videoInfo != null && videoInfo.getVideoDuration() > 0) {
            this.f37347u = (int) ((getPlayedTime() / this.f37335i.getVideoDuration()) * 100.0f);
        }
        return this.f37347u;
    }

    public int getPlayedTime() {
        return this.f37348v;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IRewardVideoView
    public void onCheckVideoHashResult(VideoInfo videoInfo, boolean z10) {
        AbstractC7185ho.m43821b("RewardVideoView", "onCheckVideoHashResult success: %s", Boolean.valueOf(z10));
        if (!z10 || this.f37335i == null || videoInfo == null) {
            return;
        }
        this.f37335i = videoInfo;
        this.f37334h = true;
        String videoDownloadUrl = videoInfo.getVideoDownloadUrl();
        ((RewardMediaView) this).f37313b = videoDownloadUrl;
        int videoPlayMode = videoInfo.getVideoPlayMode();
        if (AbstractC7806cz.m48181j(videoDownloadUrl)) {
            videoPlayMode = 2;
        }
        m49880a(videoInfo.getVideoPlayMode(), videoPlayMode);
        this.f37333g.setVideoFileUrl(videoDownloadUrl);
        if (this.f37336j) {
            AbstractC7185ho.m43820b("RewardVideoView", "play when hash check success");
            m49890b(true, this.f37341o);
        }
        if (this.f37337k) {
            AbstractC7185ho.m43820b("RewardVideoView", "prefect when hash check success");
            this.f37333g.prefetch();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        AbstractC7185ho.m43820b("RewardVideoView", RewardMethods.PAUSE_VIEW);
        m49899j();
        setTryPlayStartTime(-1L);
        this.f37333g.pauseView();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
        AbstractC7185ho.m43820b("RewardVideoView", RewardMethods.RESUME_VIEW);
        this.f37333g.resumeView();
        this.f37333g.setNeedPauseOnSurfaceDestory(true);
    }

    public void setAudioFocusType(int i10) {
        this.f37333g.setAudioFocusType(i10);
    }

    public void setAutoScaleResizeLayoutOnVideoSizeChange(boolean z10) {
        VideoView videoView = this.f37333g;
        if (videoView != null) {
            videoView.setAutoScaleResizeLayoutOnVideoSizeChange(z10);
        }
    }

    public void setPreferStartPlayTime(int i10) {
        this.f37342p = i10;
        this.f37333g.setPreferStartPlayTime(i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.RewardMediaView
    public void setRewardAd(IRewardAd iRewardAd) {
        MediaState currentState = this.f37333g.getCurrentState();
        if (((RewardMediaView) this).f37312a == iRewardAd && currentState.isNotState(MediaState.State.IDLE) && currentState.isNotState(MediaState.State.ERROR)) {
            AbstractC7185ho.m43820b("RewardVideoView", "setRewardVideoAd - has the same ad");
            return;
        }
        super.setRewardAd(iRewardAd);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("set reward ad:");
        sb2.append(iRewardAd == null ? "null" : iRewardAd.getContentId());
        AbstractC7185ho.m43820b("RewardVideoView", sb2.toString());
        m49897h();
        this.f37332f.mo46199a(((RewardMediaView) this).f37312a);
        if (((RewardMediaView) this).f37312a == null) {
            this.f37335i = null;
        } else {
            m49896g();
            this.f37349w = C7124fh.m43316b(getContext()).mo43074h();
        }
    }

    public void setUnUseDefault(boolean z10) {
        this.f37346t = z10;
    }

    public void setVideoBackgroundColor(int i10) {
        VideoView videoView = this.f37333g;
        if (videoView != null) {
            videoView.setBackgroundColor(i10);
        }
    }

    public void setVideoFinish(boolean z10) {
        this.f37343q = z10;
    }

    public void setVideoScaleMode(int i10) {
        VideoView videoView = this.f37333g;
        if (videoView != null) {
            videoView.setVideoScaleMode(i10);
        }
    }

    public RewardVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37331e = new C7405lo();
        this.f37337k = true;
        this.f37343q = false;
        this.f37346t = true;
        this.f37347u = 0;
        this.f37348v = 0;
        this.f37349w = 5000;
        this.f37350x = -1L;
        this.f37351y = false;
        this.f37352z = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                RewardVideoView.this.f37331e.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("RewardVideoView", "onBufferingStart");
                }
                RewardVideoView.this.f37345s.m45289b();
                RewardVideoView.this.f37331e.mo45621h();
            }
        };
        this.f37327A = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.2
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("RewardVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (RewardVideoView.this.f37332f != null) {
                    RewardVideoView.this.f37332f.m46275b(j10);
                }
            }
        };
        this.f37328B = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                RewardVideoView.this.m49888b(i10, true);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                RewardVideoView.this.m49888b(i10, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("RewardVideoView", "onMediaStart: %d", Integer.valueOf(i10));
                }
                RewardVideoView.this.setTryPlayStartTime(-1L);
                RewardVideoView.this.f37340n = true;
                RewardVideoView.this.f37339m = i10;
                RewardVideoView.this.f37338l = System.currentTimeMillis();
                RewardVideoView rewardVideoView = RewardVideoView.this;
                if (i10 > 0) {
                    rewardVideoView.f37332f.mo45919i();
                    if (RewardVideoView.this.f37331e != null) {
                        RewardVideoView.this.f37331e.mo45625l();
                        return;
                    }
                    return;
                }
                if (rewardVideoView.f37331e != null && RewardVideoView.this.f37335i != null) {
                    AbstractC7185ho.m43820b("RewardVideoView", "om start");
                    RewardVideoView.this.f37331e.mo45606a(RewardVideoView.this.f37335i.getVideoDuration(), !"y".equals(RewardVideoView.this.f37335i.getSoundSwitch()));
                }
                RewardVideoView.this.f37332f.mo45918h();
                RewardVideoView.this.f37332f.mo45915a(RewardVideoView.this.f37345s.m45292e(), RewardVideoView.this.f37345s.m45291d(), RewardVideoView.this.f37338l);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                RewardVideoView.this.m49888b(i10, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                RewardVideoView.this.f37348v = i11;
                if (RewardVideoView.this.f37331e == null || !RewardVideoView.this.f37340n) {
                    return;
                }
                RewardVideoView.this.f37331e.mo45605a(i10);
            }
        };
        this.f37329C = new MuteListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                RewardVideoView.this.m49884a(true);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                RewardVideoView.this.m49884a(false);
            }
        };
        this.f37330D = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.5
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                RewardVideoView.this.m49888b(i10, false);
            }
        };
        m49881a(context);
    }

    /* renamed from: f */
    public void m49906f() {
        Bitmap surfaceBitmap = this.f37333g.getSurfaceBitmap();
        if (surfaceBitmap != null) {
            if (this.f37344r == null) {
                ImageView imageView = new ImageView(getContext());
                this.f37344r = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                addView(this.f37344r, layoutParams);
            }
            this.f37344r.setImageBitmap(surfaceBitmap);
            this.f37333g.setVisibility(4);
        }
    }

    public RewardVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37331e = new C7405lo();
        this.f37337k = true;
        this.f37343q = false;
        this.f37346t = true;
        this.f37347u = 0;
        this.f37348v = 0;
        this.f37349w = 5000;
        this.f37350x = -1L;
        this.f37351y = false;
        this.f37352z = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i102) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                RewardVideoView.this.f37331e.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("RewardVideoView", "onBufferingStart");
                }
                RewardVideoView.this.f37345s.m45289b();
                RewardVideoView.this.f37331e.mo45621h();
            }
        };
        this.f37327A = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.2
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("RewardVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (RewardVideoView.this.f37332f != null) {
                    RewardVideoView.this.f37332f.m46275b(j10);
                }
            }
        };
        this.f37328B = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i102) {
                RewardVideoView.this.m49888b(i102, true);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i102) {
                RewardVideoView.this.m49888b(i102, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i102) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("RewardVideoView", "onMediaStart: %d", Integer.valueOf(i102));
                }
                RewardVideoView.this.setTryPlayStartTime(-1L);
                RewardVideoView.this.f37340n = true;
                RewardVideoView.this.f37339m = i102;
                RewardVideoView.this.f37338l = System.currentTimeMillis();
                RewardVideoView rewardVideoView = RewardVideoView.this;
                if (i102 > 0) {
                    rewardVideoView.f37332f.mo45919i();
                    if (RewardVideoView.this.f37331e != null) {
                        RewardVideoView.this.f37331e.mo45625l();
                        return;
                    }
                    return;
                }
                if (rewardVideoView.f37331e != null && RewardVideoView.this.f37335i != null) {
                    AbstractC7185ho.m43820b("RewardVideoView", "om start");
                    RewardVideoView.this.f37331e.mo45606a(RewardVideoView.this.f37335i.getVideoDuration(), !"y".equals(RewardVideoView.this.f37335i.getSoundSwitch()));
                }
                RewardVideoView.this.f37332f.mo45918h();
                RewardVideoView.this.f37332f.mo45915a(RewardVideoView.this.f37345s.m45292e(), RewardVideoView.this.f37345s.m45291d(), RewardVideoView.this.f37338l);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i102) {
                RewardVideoView.this.m49888b(i102, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i102, int i11) {
                RewardVideoView.this.f37348v = i11;
                if (RewardVideoView.this.f37331e == null || !RewardVideoView.this.f37340n) {
                    return;
                }
                RewardVideoView.this.f37331e.mo45605a(i102);
            }
        };
        this.f37329C = new MuteListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                RewardVideoView.this.m49884a(true);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                RewardVideoView.this.m49884a(false);
            }
        };
        this.f37330D = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.RewardVideoView.5
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i102, int i11, int i12) {
                RewardVideoView.this.m49888b(i102, false);
            }
        };
        m49881a(context);
    }

    @Override // com.huawei.openalliance.p169ad.views.RewardMediaView
    /* renamed from: a */
    public void mo49869a() {
        this.f37333g.pause();
    }

    @Override // com.huawei.openalliance.p169ad.views.RewardMediaView
    /* renamed from: b */
    public void mo49874b() {
        this.f37333g.stop();
    }

    @Override // com.huawei.openalliance.p169ad.views.RewardMediaView
    /* renamed from: c */
    public void mo49875c() {
        this.f37333g.mute();
    }

    /* renamed from: a */
    private void m49880a(int i10, int i11) {
        InterfaceC7538of interfaceC7538of = this.f37332f;
        if (interfaceC7538of == null || i10 != 1 || i10 == i11) {
            return;
        }
        interfaceC7538of.mo46196a(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m49888b(int i10, boolean z10) {
        this.f37345s.m45290c();
        if (this.f37340n) {
            this.f37340n = false;
            setPreferStartPlayTime(i10);
            if (z10 || this.f37343q) {
                this.f37332f.mo45916b(this.f37338l, System.currentTimeMillis(), this.f37339m, i10);
                this.f37331e.mo45620g();
            } else {
                this.f37332f.mo45917c(this.f37338l, System.currentTimeMillis(), this.f37339m, i10);
                this.f37331e.mo45624k();
            }
        }
    }

    /* renamed from: a */
    public void m49901a(int i10, boolean z10) {
        setVideoScaleMode(1);
        Resources resources = getResources();
        int i11 = C6849R.color.hiad_black;
        setVideoBackgroundColor(resources.getColor(i11));
        setBackgroundColor(getResources().getColor(i11));
        if (!z10 || i10 == 1 || i10 == 2 || !(i10 == 3 || i10 == 4 || i10 == 5)) {
            setAutoScaleResizeLayoutOnVideoSizeChange(false);
        } else {
            setUnUseDefault(false);
            setAutoScaleResizeLayoutOnVideoSizeChange(true);
        }
    }

    /* renamed from: b */
    private void m49890b(boolean z10, boolean z11) {
        AbstractC7185ho.m43820b("RewardVideoView", "doRealPlay, auto:" + z10 + ", isMute:" + z11);
        this.f37345s.m45288a();
        if (z11) {
            this.f37333g.mute();
        } else {
            this.f37333g.unmute();
        }
        if (this.f37333g.getCurrentState().isState(MediaState.State.PLAYBACK_COMPLETED)) {
            this.f37333g.m48789c(this.f37342p, 1);
        } else {
            this.f37333g.setPreferStartPlayTime(this.f37342p);
        }
        this.f37333g.play(z10);
        setTryPlayStartTime(AbstractC7741ao.m47566c());
    }

    @Override // com.huawei.openalliance.p169ad.views.RewardMediaView
    /* renamed from: a */
    public void mo49870a(long j10) {
        this.f37332f.m46273a(j10);
    }

    /* renamed from: a */
    private void m49881a(Context context) {
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_placement_pure_video_view, this);
        this.f37332f = new C7522nq(context, this);
        this.f37345s = new C7333jg("RewardVideoView");
        VideoView videoView = (VideoView) findViewById(C6849R.id.hiad_id_video_view);
        this.f37333g = videoView;
        videoView.setScreenOnWhilePlaying(true);
        this.f37333g.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.f37333g.addMediaStateListener(this.f37328B);
        this.f37333g.addMediaBufferListener(this.f37352z);
        this.f37333g.addMediaErrorListener(this.f37330D);
        this.f37333g.addMuteListener(this.f37329C);
        this.f37333g.addReportVideoTimeListenersSet(this.f37327A);
        this.f37333g.setMuteOnlyOnLostAudioFocus(true);
    }

    /* renamed from: a */
    public void m49902a(InterfaceC7416lz interfaceC7416lz) {
        this.f37331e = interfaceC7416lz;
        this.f37331e.mo45611a(C7482mq.m45849a(0.0f, m49898i(), EnumC7481mp.STANDALONE));
    }

    /* renamed from: a */
    public void m49903a(MuteListener muteListener) {
        this.f37333g.addMuteListener(muteListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.RewardMediaView
    /* renamed from: a */
    public void mo49871a(SegmentMediaStateListener segmentMediaStateListener) {
        this.f37333g.addSegmentMediaStateListener(segmentMediaStateListener);
    }

    /* renamed from: a */
    public void m49904a(NetworkChangeListener networkChangeListener) {
        this.f37333g.addNetworkChangeListener(networkChangeListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.RewardMediaView
    /* renamed from: a */
    public void mo49872a(String str) {
        this.f37332f.m46274a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49884a(boolean z10) {
        VideoInfo videoInfo = this.f37335i;
        if (videoInfo != null) {
            videoInfo.m44580e(z10 ? "n" : "y");
            this.f37331e.mo45614b(z10 ? 0.0f : 1.0f);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.RewardMediaView
    /* renamed from: a */
    public void mo49873a(boolean z10, boolean z11) {
        AbstractC7185ho.m43820b("RewardVideoView", "play, auto:" + z10 + ", isMute:" + z11);
        if (this.f37334h) {
            m49890b(z10, z11);
        } else {
            this.f37336j = true;
            this.f37341o = z11;
        }
    }

    /* renamed from: a */
    public boolean m49905a(int i10, boolean z10, int i11) {
        VideoInfo videoInfo;
        if (this.f37333g == null || (videoInfo = this.f37335i) == null || TextUtils.isEmpty(videoInfo.m44586g())) {
            AbstractC7185ho.m43823c("RewardVideoView", "switch to online play, videoView or videoInfo is null");
            return false;
        }
        this.f37333g.m48788a(this.f37335i.m44586g(), false);
        this.f37342p = i10;
        m49890b(true, z10);
        m49880a(this.f37335i.getVideoPlayMode(), i11 == -5 ? 102 : 101);
        return true;
    }
}
