package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7333jg;
import com.huawei.openalliance.p169ad.C7516nk;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.InterfaceC7533oa;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener;
import com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8120m;

/* renamed from: com.huawei.openalliance.ad.views.w */
/* loaded from: classes2.dex */
public class C8166w extends AbstractC8143m<InterfaceC7533oa> implements InterfaceC8120m {

    /* renamed from: A */
    private C7333jg f38260A;

    /* renamed from: B */
    private View.OnClickListener f38261B;

    /* renamed from: C */
    private PPSVideoRenderListener f38262C;

    /* renamed from: D */
    private final ReportVideoTimeListener f38263D;

    /* renamed from: E */
    private MediaStateListener f38264E;

    /* renamed from: F */
    private MediaErrorListener f38265F;

    /* renamed from: G */
    private final MediaBufferListener f38266G;

    /* renamed from: H */
    private MuteListener f38267H;

    /* renamed from: f */
    private VideoView f38268f;

    /* renamed from: g */
    private ImageView f38269g;

    /* renamed from: h */
    private boolean f38270h;

    /* renamed from: i */
    private VideoInfo f38271i;

    /* renamed from: j */
    private int f38272j;

    /* renamed from: k */
    private int f38273k;

    /* renamed from: l */
    private long f38274l;

    /* renamed from: m */
    private long f38275m;

    /* renamed from: n */
    private boolean f38276n;

    /* renamed from: o */
    private boolean f38277o;

    /* renamed from: p */
    private int f38278p;

    /* renamed from: q */
    private int f38279q;

    /* renamed from: r */
    private int f38280r;

    /* renamed from: s */
    private int f38281s;

    /* renamed from: t */
    private boolean f38282t;

    /* renamed from: u */
    private boolean f38283u;

    /* renamed from: v */
    private boolean f38284v;

    /* renamed from: w */
    private boolean f38285w;

    /* renamed from: x */
    private boolean f38286x;

    /* renamed from: y */
    private float f38287y;

    /* renamed from: z */
    private boolean f38288z;

    public C8166w(Context context, int i10, int i11, int i12, int i13) {
        super(context);
        this.f38270h = true;
        this.f38272j = 0;
        this.f38273k = Integer.MAX_VALUE;
        this.f38276n = false;
        this.f38277o = false;
        this.f38278p = 1;
        this.f38282t = false;
        this.f38283u = true;
        this.f38284v = false;
        this.f38285w = true;
        this.f38286x = false;
        this.f38287y = 0.0f;
        this.f38288z = false;
        this.f38261B = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.w.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C8166w.this.m50612a(!view.isSelected());
            }
        };
        this.f38262C = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.w.3
            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() throws Resources.NotFoundException {
                AbstractC7185ho.m43818a("PPSVideoView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(C8166w.this.f38282t));
                if (C8166w.this.f38282t) {
                    return;
                }
                C8166w.this.f38282t = true;
                if (C8166w.this.f38268f != null) {
                    C8166w.this.f38268f.setAlpha(1.0f);
                }
                C8166w.this.mo50314c();
                if (C8166w.this.f38284v) {
                    C8166w.this.f38270h = false;
                }
                C8166w.this.m50630l();
            }
        };
        this.f38263D = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.w.4
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                P p10 = C8166w.this.f37980a;
                if (p10 != 0) {
                    ((InterfaceC7533oa) p10).m46268b(j10);
                }
            }
        };
        this.f38264E = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.w.5
            /* renamed from: a */
            private void m50635a(int i14) {
                if (C8166w.this.f38277o) {
                    AbstractC7185ho.m43820b("PPSVideoView", "has reported play end event");
                    return;
                }
                C8166w.this.f38277o = true;
                C8166w c8166w = C8166w.this;
                ((InterfaceC7533oa) c8166w.f37980a).mo46147a(c8166w.f38274l, AbstractC7741ao.m47566c(), C8166w.this.f38275m, i14);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i14) {
                if (C8166w.this.f38268f != null) {
                    AbstractC7014dc.m41866a(C8166w.this.f38268f.getSurfaceBitmap());
                }
                AbstractC7014dc.m41867a((Drawable) null);
                m50636a(i14, true);
                P p10 = C8166w.this.f37980a;
                if (p10 != 0) {
                    long j10 = i14;
                    ((InterfaceC7533oa) p10).m46267a(j10, j10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, final int i14) {
                AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.w.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        m50636a(i14, false);
                    }
                }, 1000L);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i14) {
                if (C8166w.this.f38276n) {
                    return;
                }
                C8166w.this.m50631m();
                C8166w.this.f38276n = true;
                C8166w.this.f38275m = i14;
                C8166w.this.f38274l = AbstractC7741ao.m47566c();
                C8166w c8166w = C8166w.this;
                if (i14 > 0) {
                    c8166w.f37981b.mo45625l();
                } else {
                    if (c8166w.f38271i != null) {
                        C8166w.this.f37981b.mo45606a(r8.f38271i.m40477b(), C8166w.this.f38283u);
                    }
                    C8166w c8166w2 = C8166w.this;
                    ((InterfaceC7533oa) c8166w2.f37980a).mo46146a(c8166w2.f38260A.m45292e(), C8166w.this.f38260A.m45291d(), C8166w.this.f38274l);
                }
                ((InterfaceC7533oa) C8166w.this.f37980a).mo46149i();
                C8166w c8166w3 = C8166w.this;
                c8166w3.f37984e.mo45151a(c8166w3.f38274l);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i14) {
                m50636a(i14, false);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i14, int i15) throws Resources.NotFoundException {
                AbstractC7185ho.m43818a("PPSVideoView", "onProgress, playTime: %d, alreadyNotified: %s", Integer.valueOf(i15), Boolean.valueOf(C8166w.this.f38282t));
                if (i15 > 0 && !C8166w.this.f38282t) {
                    C8166w.this.f38282t = true;
                    if (C8166w.this.f38268f != null) {
                        C8166w.this.f38268f.setAlpha(1.0f);
                    }
                    C8166w.this.mo50314c();
                    C8166w.this.m50630l();
                }
                if (C8166w.this.f38268f != null && C8166w.this.f38268f.getCurrentState().m45811a() && C8166w.this.f38272j > 0) {
                    int i16 = C8166w.this.f38272j - i15;
                    if (i16 < 0) {
                        i16 = 0;
                    }
                    int iMax = Math.max(1, (int) Math.ceil((i16 * 1.0f) / 1000.0f));
                    AbstractC7185ho.m43818a("PPSVideoView", "left seconds: %d", Integer.valueOf(iMax));
                    if (iMax < C8166w.this.f38273k) {
                        C8166w.this.f38273k = iMax;
                        C8166w.this.mo50315c(iMax);
                    }
                }
                if (C8166w.this.f38276n) {
                    C8166w.this.f37981b.mo45605a(i14);
                    P p10 = C8166w.this.f37980a;
                    if (p10 != 0) {
                        ((InterfaceC7533oa) p10).m46267a(i15, r5.f38272j);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public void m50636a(int i14, boolean z10) {
                if (C8166w.this.f38276n) {
                    C8166w.this.f38276n = false;
                    if (C8166w.this.f38260A != null) {
                        C8166w.this.f38260A.m45290c();
                    }
                    m50635a(i14);
                    ((InterfaceC7533oa) C8166w.this.f37980a).mo46116b();
                    InterfaceC7416lz interfaceC7416lz = C8166w.this.f37981b;
                    if (z10) {
                        interfaceC7416lz.mo45620g();
                    } else {
                        interfaceC7416lz.mo45624k();
                    }
                }
            }
        };
        this.f38265F = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.w.6
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i14, int i15, int i16) {
                C8166w.this.m50429b(ErrorCode.ERROR_CODE_FAIL_TO_DISPLAY_VIDEO_AD);
                C8166w.this.m50428a();
            }
        };
        this.f38266G = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.w.7
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i14) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                C8166w.this.f37981b.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                C8166w.this.f37981b.mo45621h();
                if (C8166w.this.f38260A != null) {
                    C8166w.this.f38260A.m45289b();
                }
            }
        };
        this.f38267H = new MuteListener() { // from class: com.huawei.openalliance.ad.views.w.8
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                C8166w.this.setMuteButtonState(true);
                C8166w.this.f37981b.mo45614b(0.0f);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                C8166w.this.setMuteButtonState(false);
                C8166w.this.f37981b.mo45614b(1.0f);
            }
        };
        this.f38280r = i11;
        this.f38279q = i10;
        this.f38281s = i12;
        this.f37980a = new C7516nk(context, this, i13);
        this.f38260A = new C7333jg("PPSVideoView");
        m50628k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m50631m() {
        VideoView videoView = this.f38268f;
        if (videoView == null || this.f38285w || !this.f38286x) {
            return;
        }
        float f10 = this.f38287y;
        if (f10 > 0.0f) {
            videoView.setSoundVolume(f10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8143m, com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: g */
    public void mo50318g() {
        super.mo50318g();
        VideoView videoView = this.f38268f;
        if (videoView != null) {
            videoView.stop();
        }
    }

    public VideoView getVideoView() {
        return this.f38268f;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8143m, com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: h */
    public void mo50319h() {
        super.mo50319h();
        VideoView videoView = this.f38268f;
        if (videoView != null) {
            videoView.stop();
        }
    }

    /* renamed from: j */
    public void m50634j() {
        AbstractC7185ho.m43820b("PPSVideoView", "unMuteCustomized");
        this.f38288z = true;
        VideoView videoView = this.f38268f;
        if (videoView != null) {
            float f10 = this.f38287y;
            if (f10 > 0.0f) {
                videoView.m48784a(f10);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8143m, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoView videoView = this.f38268f;
        if (videoView != null) {
            removeView(videoView);
            this.f38268f.destroyView();
            this.f38268f = null;
        }
        this.f38273k = Integer.MAX_VALUE;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8143m, com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        VideoView videoView = this.f38268f;
        if (videoView != null) {
            videoView.pauseView();
            this.f38268f.pause();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8143m, com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    public void setAudioFocusType(int i10) {
        this.f38278p = i10;
        VideoView videoView = this.f38268f;
        if (videoView != null) {
            videoView.setAudioFocusType(i10);
        }
    }

    public void setHideSoundIcon(boolean z10) {
        this.f38284v = z10;
    }

    public void setIgnoreSoundCtrl(boolean z10) {
        this.f38285w = z10;
    }

    public void setMuteButtonState(boolean z10) {
        this.f38283u = z10;
        if (this.f38269g != null) {
            this.f38269g.setImageResource(AbstractC7811dd.m48286a(z10));
            this.f38269g.setSelected(!z10);
        }
    }

    public void setStartVol(float f10) {
        this.f38287y = f10;
    }

    /* renamed from: k */
    private void m50628k() {
        if (this.f38268f == null) {
            VideoView videoView = new VideoView(getContext());
            this.f38268f = videoView;
            videoView.setBackgroundColor(0);
            this.f38268f.setScreenOnWhilePlaying(true);
            this.f38268f.setStandalone(true);
            this.f38268f.setAutoScaleResizeLayoutOnVideoSizeChange(false);
            this.f38268f.setVideoScaleMode(2);
            this.f38268f.setMuteOnlyOnLostAudioFocus(true);
            this.f38268f.addPPSVideoRenderListener(this.f38262C);
            this.f38268f.addMediaStateListener(this.f38264E);
            this.f38268f.addMediaErrorListener(this.f38265F);
            this.f38268f.addMuteListener(this.f38267H);
            this.f38268f.addMediaBufferListener(this.f38266G);
            this.f38268f.addReportVideoTimeListenersSet(this.f38263D);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.f38268f, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bf  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m50630l() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.C8166w.m50630l():void");
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8143m, com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: e */
    public boolean mo50317e() {
        return this.f38272j > 0;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8143m
    /* renamed from: f */
    public void mo50430f() {
        pauseView();
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8143m, com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n
    /* renamed from: a */
    public void mo50310a(int i10, int i11) {
        super.mo50310a(i10, i11);
        VideoView videoView = this.f38268f;
        if (videoView != null) {
            videoView.stop();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8120m
    /* renamed from: a */
    public void mo50308a(String str) {
        this.f38271i = this.f37982c.m41419S();
        C7333jg c7333jg = this.f38260A;
        if (c7333jg != null) {
            c7333jg.m45288a();
        }
        VideoInfo videoInfo = this.f38271i;
        if (videoInfo != null) {
            if (TextUtils.equals("n", videoInfo.m40501n()) || this.f38284v) {
                this.f38270h = false;
            }
            this.f38272j = this.f38271i.m40477b();
            this.f38286x = TextUtils.equals("y", this.f38271i.m40487e());
        }
        MetaData metaDataM41568i = this.f37982c.m41568i();
        if (metaDataM41568i != null && metaDataM41568i.m40345y() > 0) {
            this.f38272j = (int) metaDataM41568i.m40345y();
        }
        m50628k();
        this.f38268f.setAudioFocusType(this.f38278p);
        this.f38268f.setAlpha(0.0f);
        this.f38268f.setVideoFileUrl(str);
        if (this.f38285w || !this.f38286x) {
            this.f38268f.mute();
        } else {
            this.f38268f.unmute();
        }
        if (this.f37984e.mo45170d() == 1) {
            AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.w.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C8166w.this.f38268f != null) {
                        C8166w.this.f38268f.play(true);
                    }
                }
            }, 200L);
        } else {
            this.f38268f.play(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50612a(boolean z10) {
        AbstractC7185ho.m43820b("PPSVideoView", "switchSound enableSound: " + z10);
        VideoView videoView = this.f38268f;
        if (videoView == null) {
            return;
        }
        if (z10) {
            videoView.unmute();
        } else {
            videoView.mute();
        }
        ((InterfaceC7533oa) this.f37980a).mo46148a(!z10);
    }
}
