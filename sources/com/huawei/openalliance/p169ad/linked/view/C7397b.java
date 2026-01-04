package com.huawei.openalliance.p169ad.linked.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7162gs;
import com.huawei.openalliance.p169ad.C7165gv;
import com.huawei.openalliance.p169ad.C7167gx;
import com.huawei.openalliance.p169ad.C7173hc;
import com.huawei.openalliance.p169ad.C7174hd;
import com.huawei.openalliance.p169ad.C7216ij;
import com.huawei.openalliance.p169ad.C7333jg;
import com.huawei.openalliance.p169ad.InterfaceC7163gt;
import com.huawei.openalliance.p169ad.InterfaceC7166gw;
import com.huawei.openalliance.p169ad.InterfaceC7175he;
import com.huawei.openalliance.p169ad.InterfaceC7176hf;
import com.huawei.openalliance.p169ad.activity.PPSActivity;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.linked.view.C7398c;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.views.VideoView;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;

/* renamed from: com.huawei.openalliance.ad.linked.view.b */
/* loaded from: classes2.dex */
public class C7397b extends AbstractC7399d implements InterfaceC7176hf, IViewLifeCycle {

    /* renamed from: A */
    private final MediaStateListener f34359A;

    /* renamed from: B */
    private MediaBufferListener f34360B;

    /* renamed from: C */
    private final MediaErrorListener f34361C;

    /* renamed from: D */
    private C7173hc f34362D;

    /* renamed from: E */
    private LinkedAppDetailView f34363E;

    /* renamed from: F */
    private Context f34364F;

    /* renamed from: G */
    private boolean f34365G;

    /* renamed from: a */
    public View f34366a;

    /* renamed from: f */
    private a f34367f;

    /* renamed from: g */
    private C7398c.a f34368g;

    /* renamed from: h */
    private boolean f34369h;

    /* renamed from: i */
    private C7174hd f34370i;

    /* renamed from: j */
    private C7162gs f34371j;

    /* renamed from: k */
    private InterfaceC7166gw f34372k;

    /* renamed from: l */
    private VideoInfo f34373l;

    /* renamed from: m */
    private ImageInfo f34374m;

    /* renamed from: n */
    private boolean f34375n;

    /* renamed from: o */
    private long f34376o;

    /* renamed from: p */
    private LinkedNativeViewControlPanel f34377p;

    /* renamed from: q */
    private VideoView f34378q;

    /* renamed from: r */
    private C7333jg f34379r;

    /* renamed from: s */
    private boolean f34380s;

    /* renamed from: t */
    private int f34381t;

    /* renamed from: u */
    private final InterfaceC7470a f34382u;

    /* renamed from: v */
    private final MuteListener f34383v;

    /* renamed from: w */
    private final C7174hd.a f34384w;

    /* renamed from: x */
    private long f34385x;

    /* renamed from: y */
    private long f34386y;

    /* renamed from: z */
    private final ReportVideoTimeListener f34387z;

    /* renamed from: com.huawei.openalliance.ad.linked.view.b$a */
    public interface a {
        /* renamed from: a */
        void m45568a();

        /* renamed from: a */
        void m45569a(boolean z10);

        /* renamed from: b */
        void m45570b();

        /* renamed from: c */
        void m45571c();

        /* renamed from: d */
        void m45572d();
    }

    public C7397b(Context context) {
        super(context);
        this.f34369h = false;
        this.f34375n = false;
        this.f34380s = false;
        this.f34381t = -1;
        this.f34382u = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.linked.view.b.1
            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i10) {
                C7397b.this.f34370i.m43756c(i10);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i10) {
            }
        };
        this.f34383v = new MuteListener() { // from class: com.huawei.openalliance.ad.linked.view.b.2
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                AbstractC7185ho.m43820b("LinkedLandVideoView", "onMute");
                if (C7397b.this.f34373l != null) {
                    C7397b.this.f34373l.m44580e("n");
                    C7397b.this.f34372k.mo43640a(true);
                }
                C7397b.this.f34370i.m43763e(true);
                if (C7397b.this.f34367f != null) {
                    C7397b.this.f34367f.m45569a(true);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                AbstractC7185ho.m43820b("LinkedLandVideoView", "onUnmute");
                if (C7397b.this.f34373l != null) {
                    C7397b.this.f34373l.m44580e("y");
                    C7397b.this.f34372k.mo43640a(false);
                }
                C7397b.this.f34370i.m43763e(false);
            }
        };
        this.f34384w = new C7174hd.a() { // from class: com.huawei.openalliance.ad.linked.view.b.3
            @Override // com.huawei.openalliance.p169ad.C7174hd.a
            /* renamed from: a */
            public void mo43788a() {
                if (C7397b.this.f34372k != null) {
                    C7397b.this.f34372k.mo43634a();
                }
            }

            @Override // com.huawei.openalliance.p169ad.C7174hd.a
            /* renamed from: b */
            public void mo43790b() {
                if (C7397b.this.f34372k != null) {
                    C7397b.this.f34372k.mo43641b();
                }
            }

            @Override // com.huawei.openalliance.p169ad.C7174hd.a
            /* renamed from: c */
            public void mo43791c() {
                if (C7397b.this.f34372k != null) {
                    AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.linked.view.b.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C7397b.this.f34372k.mo43636a(C7397b.this.f34385x, System.currentTimeMillis(), C7397b.this.f34386y, C7397b.this.f34378q.getCurrentPosition());
                        }
                    });
                }
            }

            @Override // com.huawei.openalliance.p169ad.C7174hd.a
            /* renamed from: d */
            public void mo43792d() {
                if (C7397b.this.f34372k != null) {
                    C7397b.this.f34372k.mo43642c();
                }
            }

            @Override // com.huawei.openalliance.p169ad.C7174hd.a
            /* renamed from: a */
            public void mo43789a(boolean z10) {
                AbstractC7185ho.m43820b("LinkedLandVideoView", "doRealPlay, auto:" + z10);
                C7397b.this.f34379r.m45288a();
            }
        };
        this.f34387z = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.linked.view.b.4
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("LinkedLandVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (C7397b.this.f34372k != null) {
                    C7397b.this.f34372k.m46275b(j10);
                }
            }
        };
        this.f34359A = new MediaStateListener() { // from class: com.huawei.openalliance.ad.linked.view.b.5
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                C7397b.this.m45524a(i10, true);
                C7397b.this.m45556u();
                if (C7397b.this.f34372k != null) {
                    long j10 = i10;
                    C7397b.this.f34372k.mo46257a(j10, j10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                C7397b.this.m45524a(i10, false);
                C7397b.this.m45554s();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                C7397b.this.f34365G = true;
                if (C7397b.this.f34369h) {
                    return;
                }
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("LinkedLandVideoView", "onMediaStart: %d", Integer.valueOf(i10));
                }
                C7397b.this.f34369h = true;
                C7397b.this.f34386y = i10;
                C7397b.this.f34385x = System.currentTimeMillis();
                C7397b.this.m45553r();
                if (i10 > 0) {
                    C7397b.this.f34372k.mo45919i();
                } else {
                    C7397b.this.f34372k.mo45918h();
                    C7397b.this.f34372k.mo45915a(C7397b.this.f34379r.m45292e(), C7397b.this.f34379r.m45291d(), C7397b.this.f34385x);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                C7397b.this.m45524a(i10, false);
                C7397b.this.m45555t();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                C7397b.this.f34381t = i11;
                if (C7397b.this.f34372k != null) {
                    C7397b.this.f34372k.mo46257a(i11, C7397b.this.f34373l == null ? 0L : C7397b.this.f34373l.getVideoDuration());
                }
            }
        };
        this.f34360B = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.linked.view.b.6
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("LinkedLandVideoView", "onBufferingStart");
                }
                C7397b.this.f34379r.m45289b();
            }
        };
        this.f34361C = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.linked.view.b.7
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                C7397b.this.m45524a(i10, false);
                if (C7397b.this.f34368g != null) {
                    C7397b.this.f34368g.mo45593a(mediaPlayerAgent, i10, i11, i12);
                }
                C7397b c7397b = C7397b.this;
                if (((AbstractC7399d) c7397b).f34413d || C7775bv.m47831e(c7397b.getContext())) {
                    return;
                }
                C7397b.this.f34370i.m43770i();
            }
        };
        this.f34362D = new C7173hc();
        this.f34365G = false;
        m45525a(context);
    }

    /* renamed from: j */
    private void m45541j() {
        AbstractC7185ho.m43820b("LinkedLandVideoView", "setInnerListener");
        this.f34378q.addMediaErrorListener(this.f34361C);
        this.f34378q.addMuteListener(this.f34383v);
        this.f34370i.m43760d(!m45550n());
    }

    /* renamed from: k */
    private void m45543k() {
        ImageInfo imageInfoM43627i;
        C7162gs c7162gs = this.f34371j;
        if (c7162gs == null || (imageInfoM43627i = c7162gs.m43627i()) == null) {
            return;
        }
        this.f34374m = imageInfoM43627i;
        if (imageInfoM43627i != null) {
            m45526a(imageInfoM43627i);
        }
    }

    /* renamed from: l */
    private void m45545l() {
        C7162gs c7162gs = this.f34371j;
        if (c7162gs == null) {
            return;
        }
        VideoInfo videoInfoM43624f = c7162gs.m43624f();
        this.f34373l = videoInfoM43624f;
        if (videoInfoM43624f == null) {
            this.f34370i.m43737a();
            return;
        }
        if (this.f34371j.mo43628j() == 1) {
            this.f34373l.m44563a(this.f34371j.m43626h());
        }
        m45560a(this.f34373l.getSoundSwitch());
        Float videoRatio = this.f34373l.getVideoRatio();
        if (videoRatio == null) {
            videoRatio = Float.valueOf(1.7777778f);
        }
        if (videoRatio.floatValue() < 1.0f) {
            videoRatio = Float.valueOf(1.7777778f);
        }
        setRatio(videoRatio);
        this.f34370i.m43746a(new C7167gx(this.f34364F, this.f34378q, this.f34373l, this.f34371j));
        this.f34370i.m43760d(!m45550n());
        this.f34370i.m43738a(getContinuePlayTime());
        this.f34370i.m43752b(this.f34373l.getVideoDuration());
        this.f34370i.m43771i(true);
        int videoFileSize = this.f34373l.getVideoFileSize();
        this.f34370i.m43759d(videoFileSize);
        this.f34370i.m43750a(Boolean.TRUE.toString().equals(this.f34373l.m44592i()));
        this.f34377p.setNonWifiAlertMsg(videoFileSize > 0 ? getResources().getString(C6849R.string.hiad_consume_data_to_play_video, AbstractC7731ae.m47438a(getContext(), this.f34373l.getVideoFileSize())) : getResources().getString(C6849R.string.hiad_consume_data_to_play_video_no_data_size));
        this.f34372k.mo43639a(this.f34373l);
    }

    /* renamed from: m */
    private void m45547m() {
        this.f34375n = false;
        this.f34370i.m43767g(true);
    }

    /* renamed from: o */
    private boolean m45551o() {
        if (m45552q() && !AbstractC7558os.m46459G(this.f34371j.mo43625g())) {
            int autoPlayNetwork = this.f34371j.mo43631m().getAutoPlayNetwork();
            AbstractC7185ho.m43821b("LinkedLandVideoView", "videoCfg landPage, can auto play net: %s.", Integer.valueOf(autoPlayNetwork));
            if (autoPlayNetwork == 2) {
                return false;
            }
            if (autoPlayNetwork == 1 || (autoPlayNetwork == 0 && C7775bv.m47829c(this.f34364F))) {
                return true;
            }
        }
        VideoInfo videoInfo = this.f34373l;
        return videoInfo != null && TextUtils.equals(videoInfo.getVideoAutoPlay(), "y");
    }

    /* renamed from: q */
    private boolean m45552q() {
        C7162gs c7162gs = this.f34371j;
        return (c7162gs == null || c7162gs.mo43631m() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m45553r() {
        a aVar = this.f34367f;
        if (aVar != null) {
            aVar.m45568a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m45554s() {
        a aVar = this.f34367f;
        if (aVar != null) {
            aVar.m45570b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m45555t() {
        a aVar = this.f34367f;
        if (aVar != null) {
            aVar.m45572d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m45556u() {
        a aVar = this.f34367f;
        if (aVar != null) {
            aVar.m45571c();
        }
        C7398c.a aVar2 = this.f34368g;
        if (aVar2 != null) {
            aVar2.mo45592a();
        }
    }

    /* renamed from: v */
    private boolean m45557v() {
        C7162gs c7162gs = this.f34371j;
        if (c7162gs == null || c7162gs.m43621c() == null) {
            return false;
        }
        int iM44321u = this.f34371j.m43621c().m44321u();
        return iM44321u == 1 || iM44321u == 3;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        this.f34378q.removeMediaErrorListener(this.f34361C);
        this.f34378q.removeMuteListener(this.f34383v);
        this.f34378q.destroyView();
    }

    public float getAspectRatio() {
        Float videoRatio;
        VideoInfo videoInfo = this.f34373l;
        if (videoInfo == null || (videoRatio = videoInfo.getVideoRatio()) == null) {
            return 0.0f;
        }
        return videoRatio.floatValue();
    }

    @Override // com.huawei.openalliance.p169ad.linked.view.AbstractC7399d
    public int getAutoPlayAreaPercentageThresshold() {
        VideoInfo videoInfo = this.f34373l;
        return videoInfo != null ? videoInfo.getAutoPlayAreaRatio() : super.getAutoPlayAreaPercentageThresshold();
    }

    public int getContinuePlayTime() {
        VideoInfo videoInfo = this.f34373l;
        if (videoInfo == null) {
            return 0;
        }
        int iM44566b = videoInfo.m44566b();
        AbstractC7185ho.m43818a("LinkedLandVideoView", "getContinuePlayTime %d", Integer.valueOf(iM44566b));
        return iM44566b;
    }

    @Override // com.huawei.openalliance.p169ad.linked.view.AbstractC7399d
    public int getHiddenAreaPercentageThreshhold() {
        VideoInfo videoInfo = this.f34373l;
        return videoInfo != null ? Math.max(100 - videoInfo.getAutoStopPlayAreaRatio(), 0) : super.getHiddenAreaPercentageThreshhold();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    public InterfaceC7163gt getLinkedNativeAd() {
        return this.f34371j;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    public C7174hd getLinkedVideoControlBridge() {
        return this.f34370i;
    }

    public ImageView getPreviewImageView() {
        return this.f34377p.m45515m();
    }

    public String getSoundSwtich() {
        VideoInfo videoInfo = this.f34373l;
        return videoInfo != null ? videoInfo.getSoundSwitch() : "n";
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    public VideoView getVideoView() {
        return this.f34378q;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    /* renamed from: i */
    public void mo43798i() {
        View view = this.f34366a;
        if (view == null) {
            return;
        }
        if (view.getParent() != null) {
            AbstractC7185ho.m43817a("LinkedLandVideoView", "removeSelf removeView");
            ((ViewGroup) this.f34366a.getParent()).removeView(this.f34366a);
        } else {
            AbstractC7185ho.m43817a("LinkedLandVideoView", "removeSelf gone");
            this.f34366a.setVisibility(8);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (((AbstractC7399d) this).f34414e == null) {
            return;
        }
        AbstractC7185ho.m43818a("LinkedLandVideoView", "on window focus changed, has window focus: %s, is playing: %s", Boolean.valueOf(z10), Boolean.valueOf(this.f34378q.isPlaying()));
        if (this.f34378q.isPlaying()) {
            return;
        }
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = ((AbstractC7399d) this).f34414e;
        if (z10) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45303j();
        } else {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45306m();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        this.f34370i.m43773k();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
        this.f34370i.m43774l();
        AbstractC7185ho.m43820b("LinkedLandVideoView", RewardMethods.RESUME_VIEW);
        m45541j();
        ((AbstractC7399d) this).f34412c = false;
        ((AbstractC7399d) this).f34414e.onGlobalLayout();
        this.f34378q.setNeedPauseOnSurfaceDestory(true);
    }

    public void setAudioFocusType(int i10) {
        this.f34378q.setAudioFocusType(i10);
    }

    public void setCoverClickListener(View.OnClickListener onClickListener) {
        this.f34370i.m43742a(onClickListener);
        this.f34363E.setVideoCoverClickListener(onClickListener);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    public void setLinkedLandView(InterfaceC7175he interfaceC7175he) {
        this.f34362D.m43685a(this.f34363E);
    }

    @Override // com.huawei.openalliance.p169ad.linked.view.AbstractC7399d, com.huawei.openalliance.p169ad.InterfaceC7176hf
    public void setLinkedNativeAd(C7162gs c7162gs) {
        this.f34371j = c7162gs;
        this.f34362D.m43684a(c7162gs);
        MediaState currentState = this.f34378q.getCurrentState();
        if (this.f34371j == c7162gs && currentState.isNotState(MediaState.State.IDLE) && currentState.isNotState(MediaState.State.ERROR)) {
            AbstractC7185ho.m43817a("LinkedLandVideoView", "setLinkedNativeAd - has the same ad");
            return;
        }
        super.setLinkedNativeAd(c7162gs);
        m45547m();
        if (this.f34371j == null) {
            this.f34370i.m43760d(true);
            this.f34373l = null;
        } else {
            m45543k();
            m45545l();
            this.f34370i.m43765f(false);
            this.f34372k.mo43637a(this.f34371j);
        }
    }

    public void setNotShowDataUsageAlert(boolean z10) {
        this.f34370i.m43769h(z10);
    }

    public void setPlayModeChangeListener(PPSActivity.InterfaceC6882b interfaceC6882b) {
        C7174hd c7174hd = this.f34370i;
        if (c7174hd != null) {
            c7174hd.m43745a(interfaceC6882b);
        }
    }

    public void setVideoEventListener(a aVar) {
        this.f34367f = aVar;
    }

    public void setVideoReleaseListener(C7398c.a aVar) {
        this.f34368g = aVar;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    public void setVideoView(VideoView videoView) {
        this.f34378q = videoView;
    }

    /* renamed from: n */
    private boolean m45550n() {
        VideoInfo videoInfo = this.f34373l;
        return videoInfo != null && TextUtils.equals(videoInfo.getSoundSwitch(), "y");
    }

    @Override // com.huawei.openalliance.p169ad.linked.view.AbstractC7399d
    /* renamed from: c */
    public void mo45562c() {
        if (this.f34362D.m43688d()) {
            this.f34370i.m43765f(false);
            return;
        }
        AbstractC7185ho.m43820b("LinkedLandVideoView", "onViewShownBetweenFullAndPartial");
        this.f34370i.m43738a(getContinuePlayTime());
        this.f34370i.m43765f(true);
        m45541j();
    }

    @Override // com.huawei.openalliance.p169ad.linked.view.AbstractC7399d
    /* renamed from: d */
    public void mo45563d() {
        super.mo45563d();
        this.f34378q.setNeedPauseOnSurfaceDestory(true);
    }

    /* renamed from: e */
    public void m45564e() {
        VideoInfo videoInfo;
        if (this.f34362D == null || (videoInfo = this.f34373l) == null || !((AbstractC7399d) this).f34412c) {
            return;
        }
        this.f34370i.m43739a(videoInfo.getTimeBeforeVideoAutoPlay());
    }

    /* renamed from: f */
    public void m45565f() {
        this.f34380s = true;
        this.f34370i.m43772j();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    /* renamed from: g */
    public void mo43796g() {
        this.f34370i.m43761e();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    /* renamed from: h */
    public LinkedAppDetailView mo43797h() {
        return this.f34363E;
    }

    /* renamed from: b */
    private String m45532b(VideoInfo videoInfo) {
        if (videoInfo != null && AbstractC7806cz.m48181j(videoInfo.m44586g()) && AbstractC7741ao.m47553a(videoInfo)) {
            return AbstractC7741ao.m47541a(this.f34364F, videoInfo, new C7216ij(this));
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.linked.view.AbstractC7399d
    /* renamed from: a */
    public void mo45558a() {
        if (this.f34362D.m43688d()) {
            this.f34370i.m43784v();
            return;
        }
        this.f34376o = System.currentTimeMillis();
        this.f34370i.m43765f(true);
        m45541j();
        AbstractC7185ho.m43821b("LinkedLandVideoView", "onViewFullShown hashCheckSuccess: %s hasPaused: %s", Boolean.valueOf(this.f34375n), Boolean.valueOf(this.f34380s));
        if (!this.f34375n || this.f34380s) {
            return;
        }
        boolean zM45551o = m45551o();
        AbstractC7185ho.m43821b("LinkedLandVideoView", "onViewFullShown autoplay: %s", Boolean.valueOf(zM45551o));
        this.f34370i.m43757c(zM45551o);
        this.f34370i.m43738a(getContinuePlayTime());
        this.f34370i.m43739a(this.f34373l.getTimeBeforeVideoAutoPlay());
    }

    @Override // com.huawei.openalliance.p169ad.linked.view.AbstractC7399d
    /* renamed from: b */
    public void mo45561b() {
        AbstractC7185ho.m43820b("LinkedLandVideoView", "onViewPartialHidden");
        if (this.f34373l != null) {
            this.f34370i.m43765f(false);
            this.f34370i.m43757c(false);
            this.f34370i.m43758d();
            this.f34370i.m43772j();
            this.f34370i.m43738a(getContinuePlayTime());
        }
    }

    /* renamed from: a */
    public void m45559a(int i10) {
        MediaErrorListener mediaErrorListener = this.f34361C;
        if (mediaErrorListener != null) {
            mediaErrorListener.onError(null, this.f34381t, i10, -1);
        }
        InterfaceC7166gw interfaceC7166gw = this.f34372k;
        if (interfaceC7166gw != null) {
            interfaceC7166gw.mo43635a(this.f34381t, i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    /* renamed from: b */
    public void mo43795b(String str) {
        this.f34372k.m46274a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m45524a(int i10, boolean z10) {
        VideoInfo videoInfo = this.f34373l;
        if (videoInfo != null) {
            videoInfo.m44579e(z10 ? 0 : i10);
        }
        this.f34379r.m45290c();
        if (this.f34369h) {
            this.f34369h = false;
            if (z10) {
                this.f34372k.mo45916b(this.f34385x, System.currentTimeMillis(), this.f34386y, i10);
            } else {
                this.f34372k.mo45917c(this.f34385x, System.currentTimeMillis(), this.f34386y, i10);
            }
        }
    }

    /* renamed from: a */
    private void m45525a(Context context) {
        String str;
        try {
            AbstractC7185ho.m43817a("LinkedLandVideoView", "init nativeVideoView");
            this.f34364F = context;
            this.f34379r = new C7333jg("LinkedLandVideoView");
            this.f34372k = new C7165gv(context, this);
            this.f34366a = LayoutInflater.from(context).inflate(C6849R.layout.hiad_linked_native_video_view, this);
            this.f34378q = (VideoView) findViewById(C6849R.id.hiad_id_video_view);
            this.f34377p = (LinkedNativeViewControlPanel) findViewById(C6849R.id.hiad_link_native_video_ctrl_panel);
            this.f34363E = (LinkedAppDetailView) findViewById(C6849R.id.hiad_link_app_detail);
            this.f34378q.setStandalone(true);
            this.f34378q.setScreenOnWhilePlaying(true);
            this.f34378q.setAutoScaleResizeLayoutOnVideoSizeChange(false);
            C7174hd c7174hd = new C7174hd(context, this.f34378q, this.f34377p);
            this.f34370i = c7174hd;
            c7174hd.m43747a(this.f34362D);
            this.f34370i.m43748a(this.f34384w);
            this.f34378q.addMediaStateListener(this.f34359A);
            this.f34378q.addReportVideoTimeListenersSet(this.f34387z);
            this.f34378q.addMediaBufferListener(this.f34360B);
            this.f34378q.addMediaErrorListener(this.f34361C);
            this.f34378q.addMuteListener(this.f34383v);
            this.f34378q.addMediaInfoListener(this.f34382u);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            AbstractC7185ho.m43823c("LinkedLandVideoView", str);
        } catch (Exception unused2) {
            str = "init error";
            AbstractC7185ho.m43823c("LinkedLandVideoView", str);
        }
    }

    /* renamed from: a */
    private void m45526a(ImageInfo imageInfo) {
        if (imageInfo.getHeight() > 0) {
            setRatio(Float.valueOf((imageInfo.getWidth() * 1.0f) / imageInfo.getHeight()));
        }
        this.f34372k.mo43638a(imageInfo);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    /* renamed from: a */
    public void mo43793a(ImageInfo imageInfo, Drawable drawable) {
        ImageInfo imageInfo2 = this.f34374m;
        if (imageInfo2 == null || imageInfo == null || !TextUtils.equals(imageInfo2.getUrl(), imageInfo.getUrl())) {
            return;
        }
        this.f34370i.m43741a(drawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // com.huawei.openalliance.p169ad.InterfaceC7176hf
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo43794a(com.huawei.openalliance.p169ad.inter.data.VideoInfo r5, boolean r6) {
        /*
            r4 = this;
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r6)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r1 = "LinkedLandVideoView"
            java.lang.String r2 = "onCheckVideoResult: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r1, r2, r0)
            if (r6 != 0) goto L23
            boolean r0 = r4.m45557v()
            if (r0 == 0) goto L23
            boolean r0 = r4.m45528a(r5)
            if (r0 == 0) goto L23
            java.lang.String r6 = "jssdk or api request type allow play http link video url when video mode is CACHE_MODE"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43817a(r1, r6)
            goto L25
        L23:
            if (r6 == 0) goto Lba
        L25:
            com.huawei.openalliance.ad.inter.data.VideoInfo r6 = r4.f34373l
            if (r6 == 0) goto Lba
            if (r5 == 0) goto Lba
            java.lang.String r6 = r6.getVideoDownloadUrl()
            java.lang.String r0 = r5.getVideoDownloadUrl()
            boolean r6 = android.text.TextUtils.equals(r6, r0)
            if (r6 == 0) goto Lba
            r6 = 1
            r4.f34375n = r6
            android.content.Context r6 = r4.getContext()
            android.content.Context r6 = r6.getApplicationContext()
            java.lang.String r6 = com.huawei.openalliance.p169ad.utils.AbstractC7741ao.m47540a(r6, r5)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L52
            java.lang.String r6 = r5.getVideoDownloadUrl()
        L52:
            boolean r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48181j(r6)
            if (r0 == 0) goto L6b
            java.lang.String r0 = r4.m45532b(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L6b
            java.lang.String r6 = "play mode 3, cache while playing."
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r1, r6)
            java.lang.String r6 = r4.m45532b(r5)
        L6b:
            java.lang.String r0 = com.huawei.openalliance.p169ad.utils.AbstractC7806cz.m48174f(r6)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r2 = "downloadurl: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r1, r2, r0)
            com.huawei.openalliance.ad.hd r0 = r4.f34370i
            r0.m43749a(r6)
            boolean r6 = r4.f34412c
            if (r6 == 0) goto Lc3
            com.huawei.openalliance.ad.hd r6 = r4.f34370i
            int r0 = r4.getContinuePlayTime()
            r6.m43738a(r0)
            boolean r6 = r4.m45551o()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r6)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r2 = "onCheckVideoResult - full shown, autoPlay: %s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r1, r2, r0)
            com.huawei.openalliance.ad.hd r0 = r4.f34370i
            r0.m43757c(r6)
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r4.f34376o
            long r0 = r0 - r2
            int r5 = r5.getTimeBeforeVideoAutoPlay()
            long r5 = (long) r5
            long r5 = r5 - r0
            r0 = 0
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 >= 0) goto Lb4
            r5 = r0
        Lb4:
            com.huawei.openalliance.ad.hd r4 = r4.f34370i
            r4.m43739a(r5)
            goto Lc3
        Lba:
            com.huawei.openalliance.ad.linked.view.c$a r4 = r4.f34368g
            if (r4 == 0) goto Lc3
            r5 = 0
            r6 = 0
            r4.mo45593a(r5, r6, r6, r6)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.linked.view.C7397b.mo43794a(com.huawei.openalliance.ad.inter.data.VideoInfo, boolean):void");
    }

    /* renamed from: a */
    public void m45560a(String str) {
        AbstractC7185ho.m43818a("LinkedLandVideoView", "customToggleVideoMute %s", str);
        VideoInfo videoInfo = this.f34373l;
        if (videoInfo != null) {
            videoInfo.m44580e(str);
        }
    }

    /* renamed from: a */
    private boolean m45528a(VideoInfo videoInfo) {
        return videoInfo != null && AbstractC7806cz.m48181j(videoInfo.getVideoDownloadUrl());
    }
}
