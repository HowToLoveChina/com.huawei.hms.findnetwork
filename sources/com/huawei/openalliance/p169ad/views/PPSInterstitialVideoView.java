package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7333jg;
import com.huawei.openalliance.p169ad.C7405lo;
import com.huawei.openalliance.p169ad.C7482mq;
import com.huawei.openalliance.p169ad.C7496nd;
import com.huawei.openalliance.p169ad.EnumC7481mp;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.C7301d;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener;
import com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7775bv;

/* loaded from: classes2.dex */
public class PPSInterstitialVideoView extends AutoScaleSizeRelativeLayout implements InterfaceC7337jk, MediaErrorListener, MediaStateListener, InterfaceC7470a {

    /* renamed from: a */
    private InterfaceC7416lz f36663a;

    /* renamed from: b */
    private boolean f36664b;

    /* renamed from: c */
    private boolean f36665c;

    /* renamed from: d */
    private boolean f36666d;

    /* renamed from: e */
    private C7301d f36667e;

    /* renamed from: f */
    private VideoView f36668f;

    /* renamed from: g */
    private long f36669g;

    /* renamed from: h */
    private long f36670h;

    /* renamed from: i */
    private C7496nd f36671i;

    /* renamed from: j */
    private C7333jg f36672j;

    /* renamed from: k */
    private MuteListener f36673k;

    /* renamed from: l */
    private Context f36674l;

    /* renamed from: m */
    private int f36675m;

    /* renamed from: n */
    private boolean f36676n;

    /* renamed from: o */
    private boolean f36677o;

    /* renamed from: p */
    private final ReportVideoTimeListener f36678p;

    /* renamed from: q */
    private MediaBufferListener f36679q;

    /* renamed from: r */
    private final MuteListener f36680r;

    public PPSInterstitialVideoView(Context context) {
        super(context);
        this.f36663a = new C7405lo();
        this.f36664b = false;
        this.f36665c = false;
        this.f36666d = false;
        this.f36676n = true;
        this.f36677o = true;
        this.f36678p = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSInterstitialVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (PPSInterstitialVideoView.this.f36671i != null) {
                    PPSInterstitialVideoView.this.f36671i.m45319b(j10);
                }
            }
        };
        this.f36679q = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.2
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                PPSInterstitialVideoView.this.f36663a.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSInterstitialVideoView", "onBufferingStart");
                }
                PPSInterstitialVideoView.this.f36672j.m45289b();
                PPSInterstitialVideoView.this.f36663a.mo45621h();
            }
        };
        this.f36680r = new MuteListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                if (PPSInterstitialVideoView.this.f36673k != null) {
                    PPSInterstitialVideoView.this.f36673k.onMute();
                    PPSInterstitialVideoView.this.f36663a.mo45614b(0.0f);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                if (PPSInterstitialVideoView.this.f36673k != null) {
                    PPSInterstitialVideoView.this.f36673k.onUnmute();
                    PPSInterstitialVideoView.this.f36663a.mo45614b(1.0f);
                }
            }
        };
        m49067a(context);
    }

    private int getMediaDuration() {
        if (this.f36675m <= 0 && this.f36667e.m44698K() != null) {
            this.f36675m = this.f36667e.m44698K().getVideoDuration();
        }
        return this.f36675m;
    }

    /* renamed from: i */
    private void m49078i() {
        if (this.f36667e == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSInterstitialVideoView", "loadVideoInfo");
        VideoInfo videoInfoM44698K = this.f36667e.m44698K();
        if (videoInfoM44698K != null) {
            C7022dk c7022dkM41937a = C7019dh.m41937a(this.f36674l, Constants.NORMAL_CACHE);
            String strM41968c = c7022dkM41937a.m41968c(c7022dkM41937a.m41970e(videoInfoM44698K.getVideoDownloadUrl()));
            if (AbstractC7731ae.m47458b(strM41968c)) {
                AbstractC7185ho.m43820b("PPSInterstitialVideoView", "change path to local");
                videoInfoM44698K.m44563a(strM41968c);
            }
            this.f36664b = false;
            Float videoRatio = videoInfoM44698K.getVideoRatio();
            if (videoRatio != null && this.f36676n) {
                setRatio(videoRatio);
                this.f36668f.setRatio(videoRatio);
            }
            this.f36668f.setDefaultDuration(videoInfoM44698K.getVideoDuration());
            m49068a(videoInfoM44698K);
        }
    }

    /* renamed from: j */
    private boolean m49079j() {
        C7301d c7301d = this.f36667e;
        if (c7301d == null || c7301d.m44698K() == null || !C7775bv.m47831e(getContext())) {
            return false;
        }
        if (C7775bv.m47826a(getContext())) {
            return true;
        }
        return (AbstractC7806cz.m48181j(this.f36667e.m44698K().getVideoDownloadUrl()) && TextUtils.isEmpty(C7019dh.m41937a(getContext(), Constants.NORMAL_CACHE).m41970e(this.f36667e.m44698K().getVideoDownloadUrl()))) ? false : true;
    }

    /* renamed from: g */
    public void m49096g() {
        this.f36668f.mute();
    }

    /* renamed from: h */
    public void m49097h() {
        this.f36668f.unmute();
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
    public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
        m49066a(i10, false);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
        m49066a(i10, true);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
        m49066a(i10, false);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSInterstitialVideoView", "onMediaStart: %d", Integer.valueOf(i10));
        }
        this.f36670h = i10;
        this.f36669g = System.currentTimeMillis();
        if (i10 > 0) {
            this.f36671i.m45941c();
            this.f36663a.mo45625l();
        } else {
            if (this.f36663a != null && this.f36667e.m44698K() != null) {
                this.f36663a.mo45606a(getMediaDuration(), !"y".equals(this.f36667e.m44698K().getSoundSwitch()));
            }
            if (!this.f36666d) {
                this.f36671i.m45939b();
                this.f36671i.m45935a(this.f36672j.m45292e(), this.f36672j.m45291d(), this.f36669g);
            }
        }
        this.f36666d = true;
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
        m49066a(i10, false);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
    public void onProgress(int i10, int i11) {
        if (this.f36666d) {
            this.f36663a.mo45605a(i10);
        }
    }

    public void setAutoScaleResizeLayoutOnVideoSizeChange(boolean z10) {
        VideoView videoView = this.f36668f;
        if (videoView != null) {
            videoView.setAutoScaleResizeLayoutOnVideoSizeChange(z10);
        }
    }

    public void setUnUseDefault(boolean z10) {
        this.f36676n = z10;
    }

    public void setVideoBackgroundColor(int i10) {
        VideoView videoView = this.f36668f;
        if (videoView != null) {
            videoView.setBackgroundColor(i10);
        }
    }

    public void setVideoScaleMode(int i10) {
        VideoView videoView = this.f36668f;
        if (videoView != null) {
            videoView.setVideoScaleMode(i10);
        }
    }

    public PPSInterstitialVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36663a = new C7405lo();
        this.f36664b = false;
        this.f36665c = false;
        this.f36666d = false;
        this.f36676n = true;
        this.f36677o = true;
        this.f36678p = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSInterstitialVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (PPSInterstitialVideoView.this.f36671i != null) {
                    PPSInterstitialVideoView.this.f36671i.m45319b(j10);
                }
            }
        };
        this.f36679q = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.2
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                PPSInterstitialVideoView.this.f36663a.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSInterstitialVideoView", "onBufferingStart");
                }
                PPSInterstitialVideoView.this.f36672j.m45289b();
                PPSInterstitialVideoView.this.f36663a.mo45621h();
            }
        };
        this.f36680r = new MuteListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                if (PPSInterstitialVideoView.this.f36673k != null) {
                    PPSInterstitialVideoView.this.f36673k.onMute();
                    PPSInterstitialVideoView.this.f36663a.mo45614b(0.0f);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                if (PPSInterstitialVideoView.this.f36673k != null) {
                    PPSInterstitialVideoView.this.f36673k.onUnmute();
                    PPSInterstitialVideoView.this.f36663a.mo45614b(1.0f);
                }
            }
        };
        m49067a(context);
    }

    /* renamed from: a */
    public void m49080a() {
        this.f36668f.pause();
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
    /* renamed from: b */
    public void mo45567b(int i10) {
    }

    /* renamed from: c */
    public void m49091c() {
        this.f36668f.resumeView();
        this.f36668f.setNeedPauseOnSurfaceDestory(true);
    }

    /* renamed from: d */
    public void m49093d() {
        this.f36668f.pauseView();
    }

    /* renamed from: e */
    public void m49094e() {
        this.f36668f.destroyView();
    }

    /* renamed from: f */
    public void m49095f() {
        this.f36668f.stop();
    }

    public PPSInterstitialVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36663a = new C7405lo();
        this.f36664b = false;
        this.f36665c = false;
        this.f36666d = false;
        this.f36676n = true;
        this.f36677o = true;
        this.f36678p = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSInterstitialVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (PPSInterstitialVideoView.this.f36671i != null) {
                    PPSInterstitialVideoView.this.f36671i.m45319b(j10);
                }
            }
        };
        this.f36679q = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.2
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i102) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                PPSInterstitialVideoView.this.f36663a.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSInterstitialVideoView", "onBufferingStart");
                }
                PPSInterstitialVideoView.this.f36672j.m45289b();
                PPSInterstitialVideoView.this.f36663a.mo45621h();
            }
        };
        this.f36680r = new MuteListener() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                if (PPSInterstitialVideoView.this.f36673k != null) {
                    PPSInterstitialVideoView.this.f36673k.onMute();
                    PPSInterstitialVideoView.this.f36663a.mo45614b(0.0f);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                if (PPSInterstitialVideoView.this.f36673k != null) {
                    PPSInterstitialVideoView.this.f36673k.onUnmute();
                    PPSInterstitialVideoView.this.f36663a.mo45614b(1.0f);
                }
            }
        };
        m49067a(context);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
    /* renamed from: a */
    public void mo45566a(int i10) {
        AbstractC7185ho.m43818a("PPSInterstitialVideoView", "onDurationReady %s", Integer.valueOf(i10));
        if (i10 > 0) {
            this.f36675m = i10;
        }
    }

    /* renamed from: b */
    public boolean m49090b() {
        return this.f36668f.isPlaying();
    }

    /* renamed from: c */
    public void m49092c(int i10) {
        this.f36668f.seekTo(0);
        m49066a(i10, true);
    }

    /* renamed from: a */
    private void m49066a(int i10, boolean z10) {
        this.f36672j.m45290c();
        if (this.f36666d) {
            this.f36666d = false;
            if (z10) {
                this.f36671i.m45936a(this.f36669g, System.currentTimeMillis(), this.f36670h, i10);
                this.f36663a.mo45620g();
            } else {
                this.f36671i.m45940b(this.f36669g, System.currentTimeMillis(), this.f36670h, i10);
                this.f36663a.mo45624k();
            }
        }
    }

    /* renamed from: a */
    public void m49081a(long j10) {
        this.f36671i.m45313a(j10);
    }

    /* renamed from: a */
    private void m49067a(Context context) {
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_placement_pure_video_view, this);
        this.f36671i = new C7496nd(context, this);
        this.f36672j = new C7333jg("PPSInterstitialVideoView");
        this.f36674l = context;
        VideoView videoView = (VideoView) findViewById(C6849R.id.hiad_id_video_view);
        this.f36668f = videoView;
        videoView.addMediaInfoListener(this);
        this.f36668f.setScreenOnWhilePlaying(true);
        this.f36668f.setAudioFocusType(1);
        this.f36668f.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.f36668f.setMuteOnlyOnLostAudioFocus(true);
        this.f36668f.addMediaStateListener(this);
        this.f36668f.addMediaErrorListener(this);
        this.f36668f.addMediaBufferListener(this.f36679q);
        this.f36668f.addReportVideoTimeListenersSet(this.f36678p);
        this.f36668f.setRemediate(true);
    }

    /* renamed from: a */
    private void m49068a(final VideoInfo videoInfo) {
        if (videoInfo == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSInterstitialVideoView", "checkVideoHash");
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC7806cz.m48181j(videoInfo.getVideoDownloadUrl()) || videoInfo.m44570b(PPSInterstitialVideoView.this.f36674l)) {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSInterstitialVideoView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSInterstitialVideoView.this.f36668f.setVideoFileUrl(videoInfo.getVideoDownloadUrl());
                            PPSInterstitialVideoView.this.f36664b = true;
                            if (PPSInterstitialVideoView.this.f36665c) {
                                PPSInterstitialVideoView.this.f36665c = false;
                                PPSInterstitialVideoView pPSInterstitialVideoView = PPSInterstitialVideoView.this;
                                pPSInterstitialVideoView.m49089a(true, pPSInterstitialVideoView.f36677o);
                            }
                            PPSInterstitialVideoView.this.f36668f.prefetch();
                        }
                    });
                }
            }
        });
    }

    /* renamed from: a */
    public void m49082a(C7301d c7301d, ContentRecord contentRecord) {
        this.f36667e = c7301d;
        this.f36668f.setPreferStartPlayTime(0);
        this.f36671i.m45937a(contentRecord);
        if (!AbstractC7558os.m46460H(c7301d.getCtrlSwitchs())) {
            this.f36677o = c7301d.m44714U();
        }
        m49078i();
    }

    /* renamed from: a */
    public void m49083a(InterfaceC7416lz interfaceC7416lz) {
        this.f36663a = interfaceC7416lz;
        this.f36663a.mo45611a(C7482mq.m45849a(0.0f, m49079j(), EnumC7481mp.STANDALONE));
    }

    /* renamed from: a */
    public void m49084a(MuteListener muteListener) {
        this.f36673k = muteListener;
        this.f36668f.addMuteListener(this.f36680r);
    }

    /* renamed from: a */
    public void m49085a(SegmentMediaStateListener segmentMediaStateListener) {
        this.f36668f.addSegmentMediaStateListener(segmentMediaStateListener);
    }

    /* renamed from: a */
    public void m49086a(InterfaceC7470a interfaceC7470a) {
        this.f36668f.addMediaInfoListener(interfaceC7470a);
    }

    /* renamed from: a */
    public void m49087a(NetworkChangeListener networkChangeListener) {
        this.f36668f.addNetworkChangeListener(networkChangeListener);
    }

    /* renamed from: a */
    public void m49088a(String str) {
        this.f36671i.mo45318a(str);
    }

    /* renamed from: a */
    public void m49089a(boolean z10, boolean z11) {
        if (!this.f36664b || this.f36668f.isPlaying()) {
            this.f36665c = true;
            return;
        }
        AbstractC7185ho.m43820b("PPSInterstitialVideoView", "play, auto:" + z10 + ", isMute:" + z11);
        this.f36672j.m45288a();
        if (z11) {
            this.f36668f.mute();
        } else {
            this.f36668f.unmute();
        }
        this.f36668f.play(z10);
    }
}
