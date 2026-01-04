package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7333jg;
import com.huawei.openalliance.p169ad.C7405lo;
import com.huawei.openalliance.p169ad.C7520no;
import com.huawei.openalliance.p169ad.InterfaceC7316iq;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.InterfaceC7536od;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.data.PlacementMediaFile;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.media.C7469b;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaPlayerReleaseListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener;
import com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener;
import com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.views.interfaces.IPlacementVideoView;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.openalliance.ad.views.aa */
/* loaded from: classes2.dex */
public class C8066aa extends PlacementMediaView implements InterfaceC7403lm, IPlacementVideoView {

    /* renamed from: g */
    private InterfaceC7416lz f37468g;

    /* renamed from: h */
    private InterfaceC7536od f37469h;

    /* renamed from: i */
    private VideoView f37470i;

    /* renamed from: j */
    private boolean f37471j;

    /* renamed from: k */
    private PlacementMediaFile f37472k;

    /* renamed from: l */
    private boolean f37473l;

    /* renamed from: m */
    private boolean f37474m;

    /* renamed from: n */
    private long f37475n;

    /* renamed from: o */
    private long f37476o;

    /* renamed from: p */
    private long f37477p;

    /* renamed from: q */
    private boolean f37478q;

    /* renamed from: r */
    private boolean f37479r;

    /* renamed from: s */
    private int f37480s;

    /* renamed from: t */
    private C7333jg f37481t;

    /* renamed from: u */
    private C7469b f37482u;

    /* renamed from: v */
    private MediaBufferListener f37483v;

    /* renamed from: w */
    private MediaStateListener f37484w;

    /* renamed from: x */
    private MuteListener f37485x;

    /* renamed from: y */
    private MediaErrorListener f37486y;

    /* renamed from: com.huawei.openalliance.ad.views.aa$a */
    public static class a implements InterfaceC7316iq {

        /* renamed from: a */
        private WeakReference<C8066aa> f37492a;

        public a(C8066aa c8066aa) {
            this.f37492a = new WeakReference<>(c8066aa);
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7316iq
        /* renamed from: a */
        public void mo30558a(int i10) {
            C8066aa c8066aa = this.f37492a.get();
            if (c8066aa == null) {
                return;
            }
            AbstractC7185ho.m43821b("PlacementVideoView", "placementStreamListener onError: %s", Integer.valueOf(i10));
            c8066aa.m49828h();
            c8066aa.mo49824d(i10);
        }
    }

    public C8066aa(Context context) {
        super(context);
        this.f37468g = new C7405lo();
        this.f37474m = true;
        this.f37477p = 0L;
        this.f37483v = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.aa.2
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                C8066aa.this.f37468g.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(C8066aa.this.getTAG(), "contentId: %s onBufferingStart", ((PlacementMediaView) C8066aa.this).f37260c);
                }
                C8066aa.this.f37481t.m45289b();
                C8066aa.this.f37468g.mo45621h();
            }
        };
        this.f37484w = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.aa.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                C8066aa.this.m49972a(i10, true);
                C8066aa.this.m49987l();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                C8066aa.this.m49972a(i10, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(C8066aa.this.getTAG(), "onMediaStart: %d", Integer.valueOf(i10));
                }
                C8066aa.this.f37478q = true;
                long j10 = i10;
                C8066aa.this.f37476o = j10;
                C8066aa.this.f37477p = j10;
                C8066aa.this.f37475n = System.currentTimeMillis();
                if (mediaPlayerAgent != null) {
                    C8066aa.this.f37469h.mo46170b(mediaPlayerAgent.m45793a());
                }
                if (i10 > 0) {
                    C8066aa.this.f37469h.mo45919i();
                } else {
                    C8066aa.this.f37469h.mo45918h();
                    C8066aa.this.f37469h.mo45915a(C8066aa.this.f37481t.m45292e(), C8066aa.this.f37481t.m45291d(), C8066aa.this.f37475n);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                C8066aa.this.m49972a(i10, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                C8066aa.this.f37477p = i11;
            }
        };
        this.f37485x = new MuteListener() { // from class: com.huawei.openalliance.ad.views.aa.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                if (C8066aa.this.f37472k != null) {
                    C8066aa.this.f37472k.m44547a("n");
                    C8066aa.this.f37468g.mo45614b(0.0f);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                if (C8066aa.this.f37472k != null) {
                    C8066aa.this.f37472k.m44547a("y");
                    C8066aa.this.f37468g.mo45614b(1.0f);
                }
            }
        };
        this.f37486y = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.aa.5
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                C8066aa.this.m49972a(i10, false);
            }
        };
        m49973a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTAG() {
        return "PlacementVideoView_" + hashCode();
    }

    /* renamed from: j */
    private void m49985j() {
        if (((PlacementMediaView) this).f37258a == null) {
            return;
        }
        AbstractC7185ho.m43820b(getTAG(), "loadVideoInfo");
        PlacementMediaFile mediaFile = ((PlacementMediaView) this).f37258a.getMediaFile();
        if (mediaFile == null || !mediaFile.isVideo()) {
            return;
        }
        this.f37472k = mediaFile;
        Float fM44552d = mediaFile.m44552d();
        if (fM44552d != null) {
            setRatio(fM44552d);
            this.f37470i.setRatio(fM44552d);
        }
        this.f37470i.setDefaultDuration((int) this.f37472k.getDuration());
        this.f37469h.mo46168a(this.f37472k);
        this.f37473l = false;
        this.f37474m = true;
    }

    /* renamed from: k */
    private void m49986k() {
        AbstractC7185ho.m43820b(getTAG(), "resetVideoView");
        setPreferStartPlayTime(0);
        this.f37471j = false;
        this.f37473l = false;
        this.f37474m = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public boolean m49987l() {
        String str;
        if (!HiAd.getInstance(getContext().getApplicationContext()).isVideoCacheWhenPlay(60)) {
            return false;
        }
        if (!TextUtils.isEmpty(m49971a(this.f37472k))) {
            str = "local file exists.";
        } else {
            if (AbstractC7806cz.m48181j(m49970a(getContext().getApplicationContext(), this.f37472k))) {
                AbstractC7185ho.m43820b("PlacementVideoView", "enable video cache when play, checkAndDown mediaFile.");
                InterfaceC7536od interfaceC7536od = this.f37469h;
                if (interfaceC7536od == null) {
                    return true;
                }
                interfaceC7536od.mo46166a();
                return true;
            }
            str = "local proxy file exists.";
        }
        AbstractC7185ho.m43820b("PlacementVideoView", str);
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView, com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        AbstractC7185ho.m43820b(getTAG(), RewardMethods.DESTROY_VIEW);
        this.f37470i.destroyView();
        this.f37468g.mo45613b();
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: f */
    public void mo49826f() {
        this.f37470i.pause();
    }

    public MediaState getCurrentState() {
        return this.f37470i.getCurrentState();
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    public ImageView getLastFrame() {
        if (this.f37470i == null) {
            return null;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(this.f37470i.getSurfaceBitmap());
        return imageView;
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    public MediaState getMediaState() {
        VideoView videoView = this.f37470i;
        if (videoView != null) {
            return videoView.getMediaState();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView, com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8123p
    public VideoView getVideoView() {
        return this.f37470i;
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: i */
    public boolean mo49829i() {
        return this.f37470i.isPlaying();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IPlacementVideoView
    public void onCheckVideoHashResult(PlacementMediaFile placementMediaFile, boolean z10) {
        AbstractC7185ho.m43821b(getTAG(), "onCheckVideoHashResult sucess: %s", Boolean.valueOf(z10));
        if (!z10 || this.f37472k == null || placementMediaFile == null) {
            return;
        }
        this.f37472k = placementMediaFile;
        this.f37471j = true;
        String strM49971a = m49971a(placementMediaFile);
        if (TextUtils.isEmpty(strM49971a)) {
            strM49971a = m49970a(getContext(), placementMediaFile);
            if (TextUtils.isEmpty(strM49971a)) {
                strM49971a = placementMediaFile.getUrl();
            }
        }
        ((PlacementMediaView) this).f37259b = strM49971a;
        this.f37470i.setVideoFileUrl(strM49971a);
        VideoView videoView = this.f37470i;
        C7304g c7304g = ((PlacementMediaView) this).f37258a;
        videoView.setContentId(c7304g == null ? null : c7304g.getContentId());
        if (this.f37473l) {
            AbstractC7185ho.m43820b(getTAG(), "play when hash check success");
            m49978b(true, this.f37479r);
        }
        if (this.f37474m) {
            AbstractC7185ho.m43820b(getTAG(), "prefect when hash check success");
            this.f37470i.prefetch();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView, com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        AbstractC7185ho.m43820b(getTAG(), RewardMethods.PAUSE_VIEW);
        this.f37470i.pauseView();
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView, com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
        AbstractC7185ho.m43820b(getTAG(), RewardMethods.RESUME_VIEW);
        this.f37470i.resumeView();
        this.f37470i.setNeedPauseOnSurfaceDestory(true);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    public void setAudioFocusType(int i10) {
        this.f37470i.setAudioFocusType(i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    public void setMediaPlayerReleaseListener(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
        VideoView videoView = this.f37470i;
        if (videoView != null) {
            videoView.setMediaPlayerReleaseListener(mediaPlayerReleaseListener);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    public void setPlacementAd(IPlacementAd iPlacementAd) {
        MediaState currentState = this.f37470i.getCurrentState();
        if (((PlacementMediaView) this).f37258a == iPlacementAd && currentState.isNotState(MediaState.State.IDLE) && currentState.isNotState(MediaState.State.ERROR)) {
            AbstractC7185ho.m43820b(getTAG(), "setPlacementVideoAd - has the same ad");
            return;
        }
        super.setPlacementAd(iPlacementAd);
        String tag = getTAG();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("set placement ad:");
        sb2.append(iPlacementAd == null ? "null" : iPlacementAd.getContentId());
        AbstractC7185ho.m43820b(tag, sb2.toString());
        m49986k();
        this.f37469h.mo46169a(((PlacementMediaView) this).f37258a);
        if (((PlacementMediaView) this).f37258a != null) {
            m49985j();
        } else {
            this.f37472k = null;
        }
    }

    public void setPreferStartPlayTime(int i10) {
        this.f37480s = i10;
        this.f37470i.setPreferStartPlayTime(i10);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    public void setSoundVolume(float f10) {
        this.f37470i.setSoundVolume(f10);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: d */
    public void mo49823d() {
        this.f37479r = false;
        this.f37470i.unmute();
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: e */
    public void mo49825e() {
        C7469b c7469b = this.f37482u;
        if (c7469b != null) {
            c7469b.m45827a();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: g */
    public void mo49827g() {
        this.f37470i.stop();
    }

    /* renamed from: a */
    private String m49970a(Context context, PlacementMediaFile placementMediaFile) {
        if (context == null || placementMediaFile == null || !HiAd.getInstance(context).isVideoCacheWhenPlay(60)) {
            return null;
        }
        return AbstractC7741ao.m47542a(getContext(), new VideoInfo(placementMediaFile), new a(this), "placement");
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: b */
    public void mo49814b() {
        if (this.f37470i != null) {
            AbstractC7185ho.m43820b("PlacementVideoView", "release player");
            this.f37470i.m48794i();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: c */
    public void mo49821c() {
        this.f37479r = true;
        this.f37470i.mute();
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: d */
    public void mo49824d(int i10) {
        InterfaceC7536od interfaceC7536od = this.f37469h;
        if (interfaceC7536od != null) {
            interfaceC7536od.mo46167a(this.f37477p, i10);
            this.f37469h.mo46166a();
        }
    }

    /* renamed from: a */
    private String m49971a(PlacementMediaFile placementMediaFile) {
        if (placementMediaFile == null) {
            return null;
        }
        String strM44549b = placementMediaFile.m44549b();
        if (!TextUtils.isEmpty(strM44549b)) {
            return strM44549b;
        }
        C7022dk c7022dkM41937a = C7019dh.m41937a(getContext(), Constants.NORMAL_CACHE);
        return c7022dkM41937a.m41968c(c7022dkM41937a.m41970e(placementMediaFile.getUrl()));
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: b */
    public void mo49815b(int i10) {
        C7469b c7469b = this.f37482u;
        if (c7469b != null) {
            c7469b.m45828a(i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: c */
    public void mo49822c(int i10) {
        C7469b c7469b = this.f37482u;
        if (c7469b != null) {
            c7469b.m45831b(i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49803a() {
        this.f37470i.mo48790d();
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: b */
    public void mo49816b(long j10) {
        C7469b c7469b = this.f37482u;
        if (c7469b != null) {
            c7469b.m45829a(j10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49804a(int i10) {
        m49972a(i10, true);
        mo49803a();
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: b */
    public void mo49817b(MediaBufferListener mediaBufferListener) {
        this.f37470i.removeMediaBufferListener(mediaBufferListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49972a(int i10, boolean z10) {
        this.f37481t.m45290c();
        long j10 = i10;
        this.f37477p = j10;
        if (this.f37478q) {
            this.f37478q = false;
            setPreferStartPlayTime(i10);
            InterfaceC7536od interfaceC7536od = this.f37469h;
            long j11 = this.f37475n;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j12 = this.f37476o;
            if (z10) {
                interfaceC7536od.mo45916b(j11, jCurrentTimeMillis, j12, j10);
            } else {
                interfaceC7536od.mo45917c(j11, jCurrentTimeMillis, j12, j10);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: b */
    public void mo49818b(MediaErrorListener mediaErrorListener) {
        this.f37470i.removeMediaErrorListener(mediaErrorListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49805a(long j10) {
        this.f37469h.m46273a(j10);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: b */
    public void mo49819b(MuteListener muteListener) {
        this.f37470i.removeMuteListener(muteListener);
    }

    /* renamed from: a */
    private void m49973a(Context context) {
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_placement_pure_video_view, this);
        this.f37469h = new C7520no(context, this);
        this.f37481t = new C7333jg(getTAG());
        VideoView videoView = (VideoView) findViewById(C6849R.id.hiad_id_video_view);
        this.f37470i = videoView;
        videoView.setScreenOnWhilePlaying(true);
        this.f37470i.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.f37470i.addMediaBufferListener(this.f37483v);
        this.f37470i.addMediaStateListener(this.f37484w);
        this.f37470i.addMediaErrorListener(this.f37486y);
        this.f37470i.addMuteListener(this.f37485x);
        this.f37470i.setMuteOnlyOnLostAudioFocus(true);
        this.f37470i.setRemediate(true);
        C7469b c7469b = new C7469b(context);
        this.f37482u = c7469b;
        c7469b.m45830a(new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.aa.1
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PlacementVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (C8066aa.this.f37469h != null) {
                    C8066aa.this.f37469h.m46275b(j10);
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: b */
    public void mo49820b(SegmentMediaStateListener segmentMediaStateListener) {
        this.f37470i.addSegmentMediaStateListener(segmentMediaStateListener);
    }

    /* renamed from: b */
    private void m49978b(boolean z10, boolean z11) {
        AbstractC7185ho.m43820b(getTAG(), "doRealPlay, auto:" + z10 + ", isMute:" + z11);
        this.f37481t.m45288a();
        if (z11) {
            this.f37470i.mute();
        } else {
            this.f37470i.unmute();
        }
        if (this.f37470i.getCurrentState().isState(MediaState.State.PLAYBACK_COMPLETED)) {
            this.f37470i.m48789c(this.f37480s, 1);
        } else {
            this.f37470i.setPreferStartPlayTime(this.f37480s);
        }
        this.f37470i.play(z10);
    }

    /* renamed from: a */
    public void m49988a(InterfaceC7416lz interfaceC7416lz) {
        this.f37468g = interfaceC7416lz;
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49806a(MediaBufferListener mediaBufferListener) {
        this.f37470i.addMediaBufferListener(mediaBufferListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49807a(MediaErrorListener mediaErrorListener) {
        this.f37470i.addMediaErrorListener(mediaErrorListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49808a(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
        VideoView videoView = this.f37470i;
        if (videoView != null) {
            videoView.m48787a(mediaPlayerReleaseListener);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49809a(MuteListener muteListener) {
        this.f37470i.addMuteListener(muteListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49810a(PPSVideoRenderListener pPSVideoRenderListener) {
        this.f37470i.addPPSVideoRenderListener(pPSVideoRenderListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49811a(SegmentMediaStateListener segmentMediaStateListener) {
        this.f37470i.addOmSegmentMediaStateListener(segmentMediaStateListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49812a(String str) {
        this.f37469h.m46274a(str);
    }

    @Override // com.huawei.openalliance.p169ad.views.PlacementMediaView
    /* renamed from: a */
    public void mo49813a(boolean z10, boolean z11) {
        AbstractC7185ho.m43820b(getTAG(), "play, auto:" + z10 + ", isMute:" + z11);
        if (this.f37471j) {
            m49978b(z10, z11);
        } else {
            this.f37473l = true;
            this.f37479r = z11;
        }
    }
}
