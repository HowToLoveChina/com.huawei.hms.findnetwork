package com.huawei.openalliance.p169ad.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7169gz;
import com.huawei.openalliance.p169ad.C7171ha;
import com.huawei.openalliance.p169ad.C7172hb;
import com.huawei.openalliance.p169ad.C7219im;
import com.huawei.openalliance.p169ad.C7333jg;
import com.huawei.openalliance.p169ad.C7405lo;
import com.huawei.openalliance.p169ad.C7482mq;
import com.huawei.openalliance.p169ad.C7511nf;
import com.huawei.openalliance.p169ad.EnumC7481mp;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.InterfaceC7529nx;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.ImageInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
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
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.views.C8077al;
import com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSNativeView;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public class NativeVideoView extends NativeMediaView implements InterfaceC7403lm, INativeVideoView, IViewLifeCycle {

    /* renamed from: A */
    private final ReportVideoTimeListener f36449A;

    /* renamed from: B */
    private MediaStateListener f36450B;

    /* renamed from: C */
    private MediaErrorListener f36451C;

    /* renamed from: D */
    private InterfaceC7470a f36452D;

    /* renamed from: E */
    private MuteListener f36453E;

    /* renamed from: F */
    private C8077al.a f36454F;

    /* renamed from: g */
    private InterfaceC7416lz f36455g;

    /* renamed from: h */
    private VideoEventListener f36456h;

    /* renamed from: i */
    private boolean f36457i;

    /* renamed from: j */
    private C8077al f36458j;

    /* renamed from: k */
    private InterfaceC7529nx f36459k;

    /* renamed from: l */
    private VideoInfo f36460l;

    /* renamed from: m */
    private ImageInfo f36461m;

    /* renamed from: n */
    private boolean f36462n;

    /* renamed from: o */
    private long f36463o;

    /* renamed from: p */
    private NativeVideoControlPanel f36464p;

    /* renamed from: q */
    private VideoView f36465q;

    /* renamed from: r */
    private IPPSNativeView f36466r;

    /* renamed from: s */
    private long f36467s;

    /* renamed from: t */
    private long f36468t;

    /* renamed from: u */
    private boolean f36469u;

    /* renamed from: v */
    private C7333jg f36470v;

    /* renamed from: w */
    private C7219im f36471w;

    /* renamed from: x */
    private boolean f36472x;

    /* renamed from: y */
    private boolean f36473y;

    /* renamed from: z */
    private MediaBufferListener f36474z;

    /* renamed from: com.huawei.openalliance.ad.views.NativeVideoView$1 */
    public class C79061 implements MediaBufferListener {
        public C79061() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
        public void onBufferUpdate(int i10) {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
        public void onBufferingEnd() {
            NativeVideoView.this.f36455g.mo45622i();
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
        public void onBufferingStart() {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43817a("NativeVideoView", "onBufferingStart");
            }
            NativeVideoView.this.f36470v.m45289b();
            NativeVideoView.this.f36455g.mo45621h();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.NativeVideoView$2 */
    public class C79072 implements ReportVideoTimeListener {
        public C79072() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
        public void reportVideoTime(long j10) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("NativeVideoView", "reportVideoTime: %s", Long.valueOf(j10));
            }
            if (NativeVideoView.this.f36459k != null) {
                NativeVideoView.this.f36459k.m46275b(j10);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.NativeVideoView$3 */
    public class C79083 implements MediaStateListener {
        public C79083() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
            if (NativeVideoView.this.f36460l != null) {
                NativeVideoView.this.f36460l.m44569b(true);
            }
            NativeVideoView.this.m48849a(i10, true);
            NativeVideoView.this.m48888s();
            if (NativeVideoView.this.f36459k != null) {
                long j10 = i10;
                NativeVideoView.this.f36459k.mo46257a(j10, j10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
            NativeVideoView.this.m48849a(i10, false);
            NativeVideoView.this.m48887r();
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("NativeVideoView", "onMediaStart: %s", Integer.valueOf(i10));
            }
            if (NativeVideoView.this.f36457i) {
                return;
            }
            NativeVideoView.this.f36457i = true;
            NativeVideoView.this.f36468t = i10;
            NativeVideoView.this.f36467s = System.currentTimeMillis();
            NativeVideoView.this.m48883o();
            InterfaceC7416lz interfaceC7416lz = NativeVideoView.this.f36455g;
            if (i10 > 0) {
                interfaceC7416lz.mo45625l();
                NativeVideoView.this.f36459k.mo45919i();
                return;
            }
            if (interfaceC7416lz != null && NativeVideoView.this.f36460l != null) {
                NativeVideoView.this.f36455g.mo45606a(NativeVideoView.this.f36460l.getVideoDuration(), !"y".equals(NativeVideoView.this.f36460l.getSoundSwitch()));
            }
            NativeVideoView.this.f36459k.mo45918h();
            NativeVideoView.this.f36459k.mo45915a(NativeVideoView.this.f36470v.m45292e(), NativeVideoView.this.f36470v.m45291d(), NativeVideoView.this.f36467s);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
            NativeVideoView.this.m48849a(i10, false);
            NativeVideoView.this.m48886q();
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
        public void onProgress(int i10, int i11) {
            NativeVideoView nativeVideoView = NativeVideoView.this;
            ((NativeMediaView) nativeVideoView).f36413e = i11;
            if (nativeVideoView.f36457i) {
                NativeVideoView.this.f36455g.mo45605a(i10);
                NativeVideoView.this.f36459k.mo46094a(i10, i11, NativeVideoView.this.f36468t, NativeVideoView.this.f36466r, ((NativeMediaView) NativeVideoView.this).f36411c);
                NativeVideoView.this.f36459k.mo46257a(i11, NativeVideoView.this.f36460l == null ? 0 : NativeVideoView.this.f36460l.getVideoDuration());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.NativeVideoView$4 */
    public class C79094 implements MediaErrorListener {
        public C79094() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
        public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) throws Resources.NotFoundException {
            NativeVideoView.this.m48849a(i10, false);
            NativeVideoView nativeVideoView = NativeVideoView.this;
            if (((NativeMediaView) nativeVideoView).f36410b || C7775bv.m47831e(nativeVideoView.getContext())) {
                return;
            }
            Toast toastMakeText = Toast.makeText(NativeVideoView.this.getContext(), C6849R.string.hiad_network_error, 0);
            toastMakeText.setGravity(17, 0, 0);
            toastMakeText.show();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.NativeVideoView$5 */
    public class C79105 implements InterfaceC7470a {
        public C79105() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
        /* renamed from: a */
        public void mo45566a(int i10) {
            NativeVideoView.this.f36458j.m50056b(i10);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
        /* renamed from: b */
        public void mo45567b(int i10) {
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.NativeVideoView$6 */
    public class C79116 implements MuteListener {
        public C79116() {
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
        public void onMute() {
            AbstractC7185ho.m43820b("NativeVideoView", "onMute");
            if (NativeVideoView.this.f36460l != null) {
                NativeVideoView.this.f36460l.m44580e("n");
                if (NativeVideoView.this.f36469u || !NativeVideoView.this.f36457i) {
                    NativeVideoView.this.f36469u = false;
                } else {
                    NativeVideoView.this.f36459k.mo46099a(true);
                }
                NativeVideoView.this.f36455g.mo45614b(0.0f);
            }
            NativeVideoView.this.f36458j.m50064e(true);
        }

        @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
        public void onUnmute() {
            AbstractC7185ho.m43820b("NativeVideoView", "onUnmute");
            if (NativeVideoView.this.f36460l != null) {
                NativeVideoView.this.f36469u = false;
                NativeVideoView.this.f36460l.m44580e("y");
                NativeVideoView.this.f36459k.mo46099a(false);
                NativeVideoView.this.f36455g.mo45614b(1.0f);
            }
            NativeVideoView.this.f36458j.m50064e(false);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.NativeVideoView$7 */
    public class C79127 implements C8077al.a {
        public C79127() {
        }

        @Override // com.huawei.openalliance.p169ad.views.C8077al.a
        /* renamed from: a */
        public void mo48893a() {
            if (NativeVideoView.this.f36466r != null) {
                NativeVideoView.this.f36466r.mo49347a(5);
            }
        }

        @Override // com.huawei.openalliance.p169ad.views.C8077al.a
        /* renamed from: b */
        public void mo48896b(boolean z10) {
            AbstractC7185ho.m43820b("NativeVideoView", "doRealPlay, auto:" + z10);
            NativeVideoView.this.f36470v.m45288a();
        }

        @Override // com.huawei.openalliance.p169ad.views.C8077al.a
        /* renamed from: a */
        public void mo48894a(boolean z10) {
            if (NativeVideoView.this.f36460l != null) {
                NativeVideoView.this.f36460l.m44569b(!z10);
            }
        }

        @Override // com.huawei.openalliance.p169ad.views.C8077al.a
        /* renamed from: b */
        public void mo48897b(boolean z10, int i10) {
            NativeVideoView.this.m48860b(z10, i10);
        }

        @Override // com.huawei.openalliance.p169ad.views.C8077al.a
        /* renamed from: a */
        public void mo48895a(boolean z10, int i10) {
            NativeVideoView.this.m48855a(z10, i10);
        }

        @Override // com.huawei.openalliance.p169ad.views.C8077al.a
        /* renamed from: b */
        public boolean mo48898b() {
            return NativeVideoView.this.m48880m() && !NativeVideoView.this.f36473y;
        }
    }

    @OuterVisible
    public interface VideoEventListener {
        void onControlPanelHide(boolean z10, int i10);

        void onControlPanelShow(boolean z10, int i10);

        void onVideoComplete();

        void onVideoPause();

        void onVideoStart();

        void onVideoStop();
    }

    @OuterVisible
    public NativeVideoView(Context context) {
        super(context);
        this.f36455g = new C7405lo();
        this.f36457i = false;
        this.f36462n = false;
        this.f36472x = false;
        this.f36473y = false;
        this.f36474z = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            public C79061() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                NativeVideoView.this.f36455g.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("NativeVideoView", "onBufferingStart");
                }
                NativeVideoView.this.f36470v.m45289b();
                NativeVideoView.this.f36455g.mo45621h();
            }
        };
        this.f36449A = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            public C79072() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("NativeVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (NativeVideoView.this.f36459k != null) {
                    NativeVideoView.this.f36459k.m46275b(j10);
                }
            }
        };
        this.f36450B = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            public C79083() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44569b(true);
                }
                NativeVideoView.this.m48849a(i10, true);
                NativeVideoView.this.m48888s();
                if (NativeVideoView.this.f36459k != null) {
                    long j10 = i10;
                    NativeVideoView.this.f36459k.mo46257a(j10, j10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                NativeVideoView.this.m48849a(i10, false);
                NativeVideoView.this.m48887r();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("NativeVideoView", "onMediaStart: %s", Integer.valueOf(i10));
                }
                if (NativeVideoView.this.f36457i) {
                    return;
                }
                NativeVideoView.this.f36457i = true;
                NativeVideoView.this.f36468t = i10;
                NativeVideoView.this.f36467s = System.currentTimeMillis();
                NativeVideoView.this.m48883o();
                InterfaceC7416lz interfaceC7416lz = NativeVideoView.this.f36455g;
                if (i10 > 0) {
                    interfaceC7416lz.mo45625l();
                    NativeVideoView.this.f36459k.mo45919i();
                    return;
                }
                if (interfaceC7416lz != null && NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36455g.mo45606a(NativeVideoView.this.f36460l.getVideoDuration(), !"y".equals(NativeVideoView.this.f36460l.getSoundSwitch()));
                }
                NativeVideoView.this.f36459k.mo45918h();
                NativeVideoView.this.f36459k.mo45915a(NativeVideoView.this.f36470v.m45292e(), NativeVideoView.this.f36470v.m45291d(), NativeVideoView.this.f36467s);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                NativeVideoView.this.m48849a(i10, false);
                NativeVideoView.this.m48886q();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                NativeVideoView nativeVideoView = NativeVideoView.this;
                ((NativeMediaView) nativeVideoView).f36413e = i11;
                if (nativeVideoView.f36457i) {
                    NativeVideoView.this.f36455g.mo45605a(i10);
                    NativeVideoView.this.f36459k.mo46094a(i10, i11, NativeVideoView.this.f36468t, NativeVideoView.this.f36466r, ((NativeMediaView) NativeVideoView.this).f36411c);
                    NativeVideoView.this.f36459k.mo46257a(i11, NativeVideoView.this.f36460l == null ? 0 : NativeVideoView.this.f36460l.getVideoDuration());
                }
            }
        };
        this.f36451C = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            public C79094() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) throws Resources.NotFoundException {
                NativeVideoView.this.m48849a(i10, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).f36410b || C7775bv.m47831e(nativeVideoView.getContext())) {
                    return;
                }
                Toast toastMakeText = Toast.makeText(NativeVideoView.this.getContext(), C6849R.string.hiad_network_error, 0);
                toastMakeText.setGravity(17, 0, 0);
                toastMakeText.show();
            }
        };
        this.f36452D = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            public C79105() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i10) {
                NativeVideoView.this.f36458j.m50056b(i10);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i10) {
            }
        };
        this.f36453E = new MuteListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            public C79116() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                AbstractC7185ho.m43820b("NativeVideoView", "onMute");
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44580e("n");
                    if (NativeVideoView.this.f36469u || !NativeVideoView.this.f36457i) {
                        NativeVideoView.this.f36469u = false;
                    } else {
                        NativeVideoView.this.f36459k.mo46099a(true);
                    }
                    NativeVideoView.this.f36455g.mo45614b(0.0f);
                }
                NativeVideoView.this.f36458j.m50064e(true);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                AbstractC7185ho.m43820b("NativeVideoView", "onUnmute");
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36469u = false;
                    NativeVideoView.this.f36460l.m44580e("y");
                    NativeVideoView.this.f36459k.mo46099a(false);
                    NativeVideoView.this.f36455g.mo45614b(1.0f);
                }
                NativeVideoView.this.f36458j.m50064e(false);
            }
        };
        this.f36454F = new C8077al.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.7
            public C79127() {
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48893a() {
                if (NativeVideoView.this.f36466r != null) {
                    NativeVideoView.this.f36466r.mo49347a(5);
                }
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public void mo48896b(boolean z10) {
                AbstractC7185ho.m43820b("NativeVideoView", "doRealPlay, auto:" + z10);
                NativeVideoView.this.f36470v.m45288a();
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48894a(boolean z10) {
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44569b(!z10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public void mo48897b(boolean z10, int i10) {
                NativeVideoView.this.m48860b(z10, i10);
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48895a(boolean z10, int i10) {
                NativeVideoView.this.m48855a(z10, i10);
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public boolean mo48898b() {
                return NativeVideoView.this.m48880m() && !NativeVideoView.this.f36473y;
            }
        };
        m48850a(context);
    }

    private int getAutoPlayNetForVideoCtrlBridge() {
        C7302e c7302e = ((NativeMediaView) this).f36411c;
        if (c7302e == null) {
            return 0;
        }
        return (c7302e.getVideoConfiguration() == null || (AbstractC7558os.m46459G(((NativeMediaView) this).f36411c.getCtrlSwitchs()) && this.f36460l != null)) ? this.f36460l.getAutoPlayNetwork() : ((NativeMediaView) this).f36411c.getVideoConfiguration().getAutoPlayNetwork();
    }

    private int getContinuePlayTime() {
        VideoInfo videoInfo = this.f36460l;
        if (videoInfo == null) {
            AbstractC7185ho.m43817a("NativeVideoView", "getContinuePlayTime other");
            return 0;
        }
        int iM44566b = videoInfo.m44566b();
        if (iM44566b >= 5000) {
            return iM44566b;
        }
        return 0;
    }

    private String getTAG() {
        return "NativeVideoView_" + hashCode();
    }

    /* renamed from: h */
    private void m48869h() {
        VideoInfo videoInfo = this.f36460l;
        if (videoInfo == null) {
            return;
        }
        this.f36458j.m50051a(videoInfo);
        Float videoRatio = this.f36460l.getVideoRatio();
        if (videoRatio == null) {
            videoRatio = Float.valueOf(1.7777778f);
        }
        setRatio(videoRatio);
        this.f36458j.m50062d(!m48876k());
        this.f36458j.m50047a(getContinuePlayTime());
        this.f36458j.m50056b(this.f36460l.getVideoDuration());
        this.f36458j.m50059c(getAutoPlayNetForVideoCtrlBridge());
        this.f36459k.mo46096a(this.f36460l);
        this.f36464p.setNonWifiAlertMsg(this.f36460l.getVideoFileSize() > 0 ? getResources().getString(C6849R.string.hiad_consume_data_to_play_video, AbstractC7731ae.m47438a(getContext(), this.f36460l.getVideoFileSize())) : getResources().getString(C6849R.string.hiad_consume_data_to_play_video_no_data_size));
    }

    /* renamed from: j */
    private void m48873j() {
        this.f36462n = false;
        this.f36458j.m50068g(true);
    }

    /* renamed from: n */
    private boolean m48881n() {
        C7302e c7302e = ((NativeMediaView) this).f36411c;
        return (c7302e == null || c7302e.getVideoConfiguration() == null) ? false : true;
    }

    /* renamed from: o */
    public void m48883o() {
        VideoEventListener videoEventListener = this.f36456h;
        if (videoEventListener != null) {
            videoEventListener.onVideoStart();
        }
    }

    /* renamed from: q */
    public void m48886q() {
        VideoEventListener videoEventListener = this.f36456h;
        if (videoEventListener != null) {
            videoEventListener.onVideoStop();
        }
    }

    /* renamed from: r */
    public void m48887r() {
        VideoEventListener videoEventListener = this.f36456h;
        if (videoEventListener != null) {
            videoEventListener.onVideoPause();
        }
    }

    /* renamed from: s */
    public void m48888s() {
        VideoEventListener videoEventListener = this.f36456h;
        if (videoEventListener != null) {
            videoEventListener.onVideoComplete();
        }
    }

    /* renamed from: t */
    private void m48889t() {
        this.f36460l.m44573c(false);
        boolean zM44574c = this.f36460l.m44574c();
        C8077al c8077al = this.f36458j;
        if (zM44574c) {
            c8077al.m50058c();
        } else {
            c8077al.m50055b();
        }
    }

    /* renamed from: u */
    private boolean m48890u() {
        if (this.f36460l == null || !C7775bv.m47831e(getContext()) || !m48880m()) {
            return false;
        }
        if (m48881n() && !AbstractC7558os.m46459G(((NativeMediaView) this).f36411c.getCtrlSwitchs())) {
            int autoPlayNetwork = ((NativeMediaView) this).f36411c.getVideoConfiguration().getAutoPlayNetwork();
            if (autoPlayNetwork == 2) {
                return false;
            }
            if (autoPlayNetwork == 1 || (autoPlayNetwork == 0 && C7775bv.m47829c(getContext()))) {
                return true;
            }
            if (autoPlayNetwork == 0 && !C7775bv.m47829c(getContext())) {
                return false;
            }
        }
        if (this.f36460l.getAutoPlayNetwork() == 1) {
            return true;
        }
        return this.f36460l.getAutoPlayNetwork() == 0 && C7775bv.m47829c(getContext());
    }

    /* renamed from: v */
    private void m48891v() {
        C7171ha.m43673a((C7169gz) null);
        C7172hb.m43677a(getContext()).m43682b();
    }

    @OuterVisible
    public void autoPlay() {
        if (this.f36460l == null) {
            return;
        }
        this.f36458j.m50054a(true);
        this.f36458j.m50048a(this.f36460l.getTimeBeforeVideoAutoPlay());
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView
    /* renamed from: d */
    public void mo48809d() {
        this.f36465q.removeMediaErrorListener(this.f36451C);
        this.f36465q.removeMuteListener(this.f36453E);
        AbstractC7185ho.m43820b("NativeVideoView", "onViewPartialHidden");
        this.f36458j.m50066f(false);
        this.f36458j.m50060c(false);
        this.f36473y = true;
        this.f36458j.m50046a();
        this.f36458j.m50055b();
        VideoInfo videoInfo = this.f36460l;
        if (videoInfo != null) {
            videoInfo.m44569b(true);
            this.f36460l.m44573c(false);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        this.f36465q.destroyView();
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView
    public int getAutoPlayAreaPercentageThresshold() {
        VideoInfo videoInfo = this.f36460l;
        return videoInfo != null ? videoInfo.getAutoPlayAreaRatio() : super.getAutoPlayAreaPercentageThresshold();
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView
    public int getHiddenAreaPercentageThreshhold() {
        VideoInfo videoInfo = this.f36460l;
        return videoInfo != null ? Math.max(100 - videoInfo.getAutoStopPlayAreaRatio(), 0) : super.getHiddenAreaPercentageThreshhold();
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView
    public int getPlayedProgress() {
        VideoInfo videoInfo = this.f36460l;
        if (videoInfo != null && videoInfo.getVideoDuration() > 0) {
            ((NativeMediaView) this).f36412d = (int) ((getPlayedTime() / this.f36460l.getVideoDuration()) * 100.0f);
        }
        return ((NativeMediaView) this).f36412d;
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView
    public int getPlayedTime() {
        return ((NativeMediaView) this).f36413e;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public ImageView getPreviewImageView() {
        return this.f36464p.mo48843f();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public VideoView getVideoView() {
        return this.f36465q;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void notifyStreamError(int i10) {
        MediaErrorListener mediaErrorListener = this.f36451C;
        if (mediaErrorListener != null && i10 != -3) {
            mediaErrorListener.onError(null, ((NativeMediaView) this).f36413e, i10, -1);
        }
        InterfaceC7529nx interfaceC7529nx = this.f36459k;
        if (interfaceC7529nx != null) {
            interfaceC7529nx.mo46093a(((NativeMediaView) this).f36413e, i10);
        }
        if (((NativeMediaView) this).f36411c == null || this.f36472x) {
            return;
        }
        this.f36472x = true;
        AbstractC7185ho.m43820b("NativeVideoView", "reInject videoInfo.");
        VideoInfo videoInfo = ((NativeMediaView) this).f36411c.getVideoInfo();
        this.f36460l = videoInfo;
        videoInfo.m44576d(2);
        m48869h();
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void onCheckVideoHashResult(VideoInfo videoInfo, boolean z10) {
        VideoInfo videoInfo2;
        AbstractC7185ho.m43821b("NativeVideoView", "onCheckVideoHashResult sucess: %s", Boolean.valueOf(z10));
        if (!z10 || (videoInfo2 = this.f36460l) == null || videoInfo == null || !TextUtils.equals(videoInfo2.getVideoDownloadUrl(), videoInfo.getVideoDownloadUrl())) {
            return;
        }
        this.f36462n = true;
        String strM47540a = AbstractC7741ao.m47540a(getContext().getApplicationContext(), videoInfo);
        if (TextUtils.isEmpty(strM47540a)) {
            strM47540a = videoInfo.getVideoDownloadUrl();
        }
        if (AbstractC7806cz.m48181j(strM47540a) && AbstractC7741ao.m47553a(videoInfo)) {
            String strM47541a = AbstractC7741ao.m47541a(getContext(), videoInfo, this.f36471w);
            AbstractC7185ho.m43818a("NativeVideoView", "proxyUrl: %s", strM47541a);
            if (!TextUtils.isEmpty(strM47541a)) {
                strM47540a = strM47541a;
            }
        }
        this.f36458j.m50053a(strM47540a);
        if (((NativeMediaView) this).f36409a) {
            this.f36458j.m50047a(getContinuePlayTime());
            boolean zM48880m = m48880m();
            AbstractC7185ho.m43821b("NativeVideoView", "onCheckVideoHashResult - has full shown, autoPlay: %s", Boolean.valueOf(zM48880m));
            this.f36458j.m50060c(zM48880m);
            if (this.f36460l.isBackFromFullScreen()) {
                m48889t();
            } else if (m48890u()) {
                long timeBeforeVideoAutoPlay = videoInfo.getTimeBeforeVideoAutoPlay() - (System.currentTimeMillis() - this.f36463o);
                if (timeBeforeVideoAutoPlay < 0) {
                    timeBeforeVideoAutoPlay = 0;
                }
                this.f36458j.m50048a(timeBeforeVideoAutoPlay);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f36455g.mo45613b();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void onPreviewImageLoaded(ImageInfo imageInfo, Drawable drawable) {
        ImageInfo imageInfo2 = this.f36461m;
        if (imageInfo2 == null || imageInfo == null || !TextUtils.equals(imageInfo2.getUrl(), imageInfo.getUrl())) {
            return;
        }
        this.f36458j.m50049a(drawable);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    @OuterVisible
    public void pause() {
        this.f36458j.m50067g();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        this.f36458j.m50063e();
    }

    @OuterVisible
    public void play() {
        this.f36458j.m50057b(false);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
        this.f36458j.m50065f();
        m48866f();
        ((NativeMediaView) this).f36409a = false;
        this.f36414f.onGlobalLayout();
        this.f36465q.setNeedPauseOnSurfaceDestory(true);
    }

    @OuterVisible
    public void setAudioFocusType(int i10) {
        this.f36465q.setAudioFocusType(i10);
    }

    @OuterVisible
    public void setAutoPlayOnFirstShow(boolean z10) {
        this.f36458j.m50054a(z10);
    }

    public void setCoverClickListener(View.OnClickListener onClickListener) {
        this.f36458j.m50050a(onClickListener);
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView, com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void setNativeAd(INativeAd iNativeAd) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setNativeAd ");
        sb2.append(iNativeAd != null ? iNativeAd.getContentId() : "null");
        AbstractC7185ho.m43820b("NativeVideoView", sb2.toString());
        MediaState currentState = this.f36465q.getCurrentState();
        if (((NativeMediaView) this).f36411c == iNativeAd && currentState.isNotState(MediaState.State.IDLE) && currentState.isNotState(MediaState.State.ERROR)) {
            AbstractC7185ho.m43820b("NativeVideoView", "setNativeAd - has the same ad");
            return;
        }
        super.setNativeAd(iNativeAd);
        m48873j();
        this.f36459k.mo46097a(((NativeMediaView) this).f36411c);
        if (((NativeMediaView) this).f36411c != null) {
            m48872i();
            m48868g();
        } else {
            this.f36458j.m50062d(true);
            this.f36460l = null;
        }
        if (!m48880m() || m48876k()) {
            return;
        }
        AbstractC7185ho.m43820b("NativeVideoView", "video auto play without sound.");
        this.f36469u = true;
    }

    @OuterVisible
    @Deprecated
    public void setNotShowDataUsageAlert(boolean z10) {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void setPpsNativeView(IPPSNativeView iPPSNativeView) {
        this.f36466r = iPPSNativeView;
    }

    @OuterVisible
    public void setVideoEventListener(VideoEventListener videoEventListener) {
        this.f36456h = videoEventListener;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    @Deprecated
    public void showFullScreenSwitchButton(boolean z10) {
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    @OuterVisible
    public void stop() {
        this.f36458j.m50055b();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void updateContent(String str) {
        this.f36459k.m46274a(str);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.INativeVideoView
    public void updateStartShowTime(long j10) {
        this.f36459k.m46273a(j10);
    }

    @OuterVisible
    public NativeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36455g = new C7405lo();
        this.f36457i = false;
        this.f36462n = false;
        this.f36472x = false;
        this.f36473y = false;
        this.f36474z = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            public C79061() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                NativeVideoView.this.f36455g.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("NativeVideoView", "onBufferingStart");
                }
                NativeVideoView.this.f36470v.m45289b();
                NativeVideoView.this.f36455g.mo45621h();
            }
        };
        this.f36449A = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            public C79072() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("NativeVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (NativeVideoView.this.f36459k != null) {
                    NativeVideoView.this.f36459k.m46275b(j10);
                }
            }
        };
        this.f36450B = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            public C79083() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44569b(true);
                }
                NativeVideoView.this.m48849a(i10, true);
                NativeVideoView.this.m48888s();
                if (NativeVideoView.this.f36459k != null) {
                    long j10 = i10;
                    NativeVideoView.this.f36459k.mo46257a(j10, j10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                NativeVideoView.this.m48849a(i10, false);
                NativeVideoView.this.m48887r();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("NativeVideoView", "onMediaStart: %s", Integer.valueOf(i10));
                }
                if (NativeVideoView.this.f36457i) {
                    return;
                }
                NativeVideoView.this.f36457i = true;
                NativeVideoView.this.f36468t = i10;
                NativeVideoView.this.f36467s = System.currentTimeMillis();
                NativeVideoView.this.m48883o();
                InterfaceC7416lz interfaceC7416lz = NativeVideoView.this.f36455g;
                if (i10 > 0) {
                    interfaceC7416lz.mo45625l();
                    NativeVideoView.this.f36459k.mo45919i();
                    return;
                }
                if (interfaceC7416lz != null && NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36455g.mo45606a(NativeVideoView.this.f36460l.getVideoDuration(), !"y".equals(NativeVideoView.this.f36460l.getSoundSwitch()));
                }
                NativeVideoView.this.f36459k.mo45918h();
                NativeVideoView.this.f36459k.mo45915a(NativeVideoView.this.f36470v.m45292e(), NativeVideoView.this.f36470v.m45291d(), NativeVideoView.this.f36467s);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                NativeVideoView.this.m48849a(i10, false);
                NativeVideoView.this.m48886q();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                NativeVideoView nativeVideoView = NativeVideoView.this;
                ((NativeMediaView) nativeVideoView).f36413e = i11;
                if (nativeVideoView.f36457i) {
                    NativeVideoView.this.f36455g.mo45605a(i10);
                    NativeVideoView.this.f36459k.mo46094a(i10, i11, NativeVideoView.this.f36468t, NativeVideoView.this.f36466r, ((NativeMediaView) NativeVideoView.this).f36411c);
                    NativeVideoView.this.f36459k.mo46257a(i11, NativeVideoView.this.f36460l == null ? 0 : NativeVideoView.this.f36460l.getVideoDuration());
                }
            }
        };
        this.f36451C = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            public C79094() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) throws Resources.NotFoundException {
                NativeVideoView.this.m48849a(i10, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).f36410b || C7775bv.m47831e(nativeVideoView.getContext())) {
                    return;
                }
                Toast toastMakeText = Toast.makeText(NativeVideoView.this.getContext(), C6849R.string.hiad_network_error, 0);
                toastMakeText.setGravity(17, 0, 0);
                toastMakeText.show();
            }
        };
        this.f36452D = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            public C79105() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i10) {
                NativeVideoView.this.f36458j.m50056b(i10);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i10) {
            }
        };
        this.f36453E = new MuteListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            public C79116() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                AbstractC7185ho.m43820b("NativeVideoView", "onMute");
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44580e("n");
                    if (NativeVideoView.this.f36469u || !NativeVideoView.this.f36457i) {
                        NativeVideoView.this.f36469u = false;
                    } else {
                        NativeVideoView.this.f36459k.mo46099a(true);
                    }
                    NativeVideoView.this.f36455g.mo45614b(0.0f);
                }
                NativeVideoView.this.f36458j.m50064e(true);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                AbstractC7185ho.m43820b("NativeVideoView", "onUnmute");
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36469u = false;
                    NativeVideoView.this.f36460l.m44580e("y");
                    NativeVideoView.this.f36459k.mo46099a(false);
                    NativeVideoView.this.f36455g.mo45614b(1.0f);
                }
                NativeVideoView.this.f36458j.m50064e(false);
            }
        };
        this.f36454F = new C8077al.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.7
            public C79127() {
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48893a() {
                if (NativeVideoView.this.f36466r != null) {
                    NativeVideoView.this.f36466r.mo49347a(5);
                }
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public void mo48896b(boolean z10) {
                AbstractC7185ho.m43820b("NativeVideoView", "doRealPlay, auto:" + z10);
                NativeVideoView.this.f36470v.m45288a();
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48894a(boolean z10) {
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44569b(!z10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public void mo48897b(boolean z10, int i10) {
                NativeVideoView.this.m48860b(z10, i10);
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48895a(boolean z10, int i10) {
                NativeVideoView.this.m48855a(z10, i10);
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public boolean mo48898b() {
                return NativeVideoView.this.m48880m() && !NativeVideoView.this.f36473y;
            }
        };
        m48850a(context);
    }

    /* renamed from: f */
    private void m48866f() {
        this.f36465q.addMediaErrorListener(this.f36451C);
        this.f36465q.addMuteListener(this.f36453E);
        this.f36458j.m50062d(!m48876k());
    }

    /* renamed from: g */
    private void m48868g() {
        C7302e c7302e = ((NativeMediaView) this).f36411c;
        if (c7302e == null) {
            return;
        }
        this.f36460l = c7302e.getVideoInfo();
        m48869h();
    }

    /* renamed from: i */
    private void m48872i() {
        List<ImageInfo> imageInfos;
        C7302e c7302e = ((NativeMediaView) this).f36411c;
        if (c7302e == null || (imageInfos = c7302e.getImageInfos()) == null || imageInfos.size() <= 0) {
            return;
        }
        ImageInfo imageInfo = imageInfos.get(0);
        this.f36461m = imageInfo;
        if (imageInfo != null) {
            if (AbstractC7806cz.m48181j(imageInfo.getUrl())) {
                AbstractC7185ho.m43820b("NativeVideoView", "don't load preview image with http url");
                return;
            }
            if (this.f36461m.getHeight() > 0) {
                setRatio(Float.valueOf((this.f36461m.getWidth() * 1.0f) / this.f36461m.getHeight()));
            }
            this.f36459k.mo46095a(this.f36461m);
        }
    }

    /* renamed from: k */
    private boolean m48876k() {
        if (!m48881n() || AbstractC7558os.m46460H(((NativeMediaView) this).f36411c.getCtrlSwitchs()) || m48878l()) {
            VideoInfo videoInfo = this.f36460l;
            return videoInfo != null && TextUtils.equals(videoInfo.getSoundSwitch(), "y");
        }
        boolean zIsMute = ((NativeMediaView) this).f36411c.getVideoConfiguration().isMute();
        AbstractC7185ho.m43821b("NativeVideoView", "videoCfg, isMute: %s", Boolean.valueOf(zIsMute));
        return !zIsMute;
    }

    /* renamed from: l */
    private boolean m48878l() {
        C8077al c8077al = this.f36458j;
        return c8077al != null && c8077al.m50069h();
    }

    /* renamed from: m */
    public boolean m48880m() {
        VideoInfo videoInfo = this.f36460l;
        if (videoInfo == null) {
            return false;
        }
        if (videoInfo.m44566b() >= this.f36460l.getVideoDuration()) {
            this.f36460l.m44579e(0);
            AbstractC7185ho.m43820b("NativeVideoView", "play progress bigger than video duration, skip autoPlay.");
            return false;
        }
        if (m48881n() && !AbstractC7558os.m46459G(((NativeMediaView) this).f36411c.getCtrlSwitchs())) {
            int autoPlayNetwork = ((NativeMediaView) this).f36411c.getVideoConfiguration().getAutoPlayNetwork();
            AbstractC7185ho.m43821b("NativeVideoView", "videoCfg, auto play net: %s.", Integer.valueOf(autoPlayNetwork));
            if (autoPlayNetwork == 2) {
                return false;
            }
            if (autoPlayNetwork == 1 || (autoPlayNetwork == 0 && C7775bv.m47829c(getContext()))) {
                return true;
            }
            if (autoPlayNetwork == 0 && !C7775bv.m47829c(getContext())) {
                return false;
            }
        }
        return TextUtils.equals(this.f36460l.getVideoAutoPlay(), "y");
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView
    /* renamed from: c */
    public void mo48808c() {
        this.f36463o = System.currentTimeMillis();
        this.f36458j.m50066f(true);
        m48851a(this.f36460l);
        m48866f();
        AbstractC7185ho.m43821b("NativeVideoView", "onViewFullShown hashCheckSuccess: %s", Boolean.valueOf(this.f36462n));
        if (this.f36462n) {
            boolean zM48880m = m48880m();
            this.f36473y = false;
            AbstractC7185ho.m43821b("NativeVideoView", "onViewFullShown autoplay: %s", Boolean.valueOf(zM48880m));
            this.f36458j.m50060c(zM48880m);
            this.f36458j.m50047a(getContinuePlayTime());
            VideoInfo videoInfo = this.f36460l;
            if (videoInfo != null && videoInfo.isBackFromFullScreen()) {
                m48889t();
            } else if (m48890u()) {
                this.f36458j.m50048a(this.f36460l.getTimeBeforeVideoAutoPlay());
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView
    /* renamed from: e */
    public void mo48810e() {
        AbstractC7185ho.m43820b("NativeVideoView", "onViewShownBetweenFullAndPartial");
        this.f36458j.m50066f(true);
        m48866f();
    }

    @OuterVisible
    public NativeVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36455g = new C7405lo();
        this.f36457i = false;
        this.f36462n = false;
        this.f36472x = false;
        this.f36473y = false;
        this.f36474z = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            public C79061() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i102) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                NativeVideoView.this.f36455g.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("NativeVideoView", "onBufferingStart");
                }
                NativeVideoView.this.f36470v.m45289b();
                NativeVideoView.this.f36455g.mo45621h();
            }
        };
        this.f36449A = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            public C79072() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("NativeVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (NativeVideoView.this.f36459k != null) {
                    NativeVideoView.this.f36459k.m46275b(j10);
                }
            }
        };
        this.f36450B = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            public C79083() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i102) {
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44569b(true);
                }
                NativeVideoView.this.m48849a(i102, true);
                NativeVideoView.this.m48888s();
                if (NativeVideoView.this.f36459k != null) {
                    long j10 = i102;
                    NativeVideoView.this.f36459k.mo46257a(j10, j10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i102) {
                NativeVideoView.this.m48849a(i102, false);
                NativeVideoView.this.m48887r();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i102) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("NativeVideoView", "onMediaStart: %s", Integer.valueOf(i102));
                }
                if (NativeVideoView.this.f36457i) {
                    return;
                }
                NativeVideoView.this.f36457i = true;
                NativeVideoView.this.f36468t = i102;
                NativeVideoView.this.f36467s = System.currentTimeMillis();
                NativeVideoView.this.m48883o();
                InterfaceC7416lz interfaceC7416lz = NativeVideoView.this.f36455g;
                if (i102 > 0) {
                    interfaceC7416lz.mo45625l();
                    NativeVideoView.this.f36459k.mo45919i();
                    return;
                }
                if (interfaceC7416lz != null && NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36455g.mo45606a(NativeVideoView.this.f36460l.getVideoDuration(), !"y".equals(NativeVideoView.this.f36460l.getSoundSwitch()));
                }
                NativeVideoView.this.f36459k.mo45918h();
                NativeVideoView.this.f36459k.mo45915a(NativeVideoView.this.f36470v.m45292e(), NativeVideoView.this.f36470v.m45291d(), NativeVideoView.this.f36467s);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i102) {
                NativeVideoView.this.m48849a(i102, false);
                NativeVideoView.this.m48886q();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i102, int i11) {
                NativeVideoView nativeVideoView = NativeVideoView.this;
                ((NativeMediaView) nativeVideoView).f36413e = i11;
                if (nativeVideoView.f36457i) {
                    NativeVideoView.this.f36455g.mo45605a(i102);
                    NativeVideoView.this.f36459k.mo46094a(i102, i11, NativeVideoView.this.f36468t, NativeVideoView.this.f36466r, ((NativeMediaView) NativeVideoView.this).f36411c);
                    NativeVideoView.this.f36459k.mo46257a(i11, NativeVideoView.this.f36460l == null ? 0 : NativeVideoView.this.f36460l.getVideoDuration());
                }
            }
        };
        this.f36451C = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            public C79094() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i102, int i11, int i12) throws Resources.NotFoundException {
                NativeVideoView.this.m48849a(i102, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).f36410b || C7775bv.m47831e(nativeVideoView.getContext())) {
                    return;
                }
                Toast toastMakeText = Toast.makeText(NativeVideoView.this.getContext(), C6849R.string.hiad_network_error, 0);
                toastMakeText.setGravity(17, 0, 0);
                toastMakeText.show();
            }
        };
        this.f36452D = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            public C79105() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i102) {
                NativeVideoView.this.f36458j.m50056b(i102);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i102) {
            }
        };
        this.f36453E = new MuteListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            public C79116() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                AbstractC7185ho.m43820b("NativeVideoView", "onMute");
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44580e("n");
                    if (NativeVideoView.this.f36469u || !NativeVideoView.this.f36457i) {
                        NativeVideoView.this.f36469u = false;
                    } else {
                        NativeVideoView.this.f36459k.mo46099a(true);
                    }
                    NativeVideoView.this.f36455g.mo45614b(0.0f);
                }
                NativeVideoView.this.f36458j.m50064e(true);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                AbstractC7185ho.m43820b("NativeVideoView", "onUnmute");
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36469u = false;
                    NativeVideoView.this.f36460l.m44580e("y");
                    NativeVideoView.this.f36459k.mo46099a(false);
                    NativeVideoView.this.f36455g.mo45614b(1.0f);
                }
                NativeVideoView.this.f36458j.m50064e(false);
            }
        };
        this.f36454F = new C8077al.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.7
            public C79127() {
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48893a() {
                if (NativeVideoView.this.f36466r != null) {
                    NativeVideoView.this.f36466r.mo49347a(5);
                }
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public void mo48896b(boolean z10) {
                AbstractC7185ho.m43820b("NativeVideoView", "doRealPlay, auto:" + z10);
                NativeVideoView.this.f36470v.m45288a();
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48894a(boolean z10) {
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44569b(!z10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public void mo48897b(boolean z10, int i102) {
                NativeVideoView.this.m48860b(z10, i102);
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48895a(boolean z10, int i102) {
                NativeVideoView.this.m48855a(z10, i102);
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public boolean mo48898b() {
                return NativeVideoView.this.m48880m() && !NativeVideoView.this.f36473y;
            }
        };
        m48850a(context);
    }

    /* renamed from: a */
    public void m48849a(int i10, boolean z10) {
        VideoInfo videoInfo = this.f36460l;
        if (videoInfo != null) {
            videoInfo.m44579e(z10 ? 0 : i10);
        }
        this.f36470v.m45290c();
        if (this.f36457i) {
            this.f36457i = false;
            if (!z10) {
                this.f36459k.mo45917c(this.f36467s, System.currentTimeMillis(), this.f36468t, i10);
                this.f36455g.mo45624k();
            } else {
                this.f36459k.mo45916b(this.f36467s, System.currentTimeMillis(), this.f36468t, i10);
                this.f36459k.mo46098a(this.f36466r, ((NativeMediaView) this).f36411c);
                this.f36455g.mo45620g();
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.NativeMediaView
    /* renamed from: b */
    public void mo48807b() {
        super.mo48807b();
        this.f36465q.setNeedPauseOnSurfaceDestory(true);
    }

    @OuterVisible
    @TargetApi(21)
    public NativeVideoView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f36455g = new C7405lo();
        this.f36457i = false;
        this.f36462n = false;
        this.f36472x = false;
        this.f36473y = false;
        this.f36474z = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            public C79061() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i102) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                NativeVideoView.this.f36455g.mo45622i();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("NativeVideoView", "onBufferingStart");
                }
                NativeVideoView.this.f36470v.m45289b();
                NativeVideoView.this.f36455g.mo45621h();
            }
        };
        this.f36449A = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            public C79072() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("NativeVideoView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                if (NativeVideoView.this.f36459k != null) {
                    NativeVideoView.this.f36459k.m46275b(j10);
                }
            }
        };
        this.f36450B = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            public C79083() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i102) {
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44569b(true);
                }
                NativeVideoView.this.m48849a(i102, true);
                NativeVideoView.this.m48888s();
                if (NativeVideoView.this.f36459k != null) {
                    long j10 = i102;
                    NativeVideoView.this.f36459k.mo46257a(j10, j10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i102) {
                NativeVideoView.this.m48849a(i102, false);
                NativeVideoView.this.m48887r();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i102) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("NativeVideoView", "onMediaStart: %s", Integer.valueOf(i102));
                }
                if (NativeVideoView.this.f36457i) {
                    return;
                }
                NativeVideoView.this.f36457i = true;
                NativeVideoView.this.f36468t = i102;
                NativeVideoView.this.f36467s = System.currentTimeMillis();
                NativeVideoView.this.m48883o();
                InterfaceC7416lz interfaceC7416lz = NativeVideoView.this.f36455g;
                if (i102 > 0) {
                    interfaceC7416lz.mo45625l();
                    NativeVideoView.this.f36459k.mo45919i();
                    return;
                }
                if (interfaceC7416lz != null && NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36455g.mo45606a(NativeVideoView.this.f36460l.getVideoDuration(), !"y".equals(NativeVideoView.this.f36460l.getSoundSwitch()));
                }
                NativeVideoView.this.f36459k.mo45918h();
                NativeVideoView.this.f36459k.mo45915a(NativeVideoView.this.f36470v.m45292e(), NativeVideoView.this.f36470v.m45291d(), NativeVideoView.this.f36467s);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i102) {
                NativeVideoView.this.m48849a(i102, false);
                NativeVideoView.this.m48886q();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i102, int i112) {
                NativeVideoView nativeVideoView = NativeVideoView.this;
                ((NativeMediaView) nativeVideoView).f36413e = i112;
                if (nativeVideoView.f36457i) {
                    NativeVideoView.this.f36455g.mo45605a(i102);
                    NativeVideoView.this.f36459k.mo46094a(i102, i112, NativeVideoView.this.f36468t, NativeVideoView.this.f36466r, ((NativeMediaView) NativeVideoView.this).f36411c);
                    NativeVideoView.this.f36459k.mo46257a(i112, NativeVideoView.this.f36460l == null ? 0 : NativeVideoView.this.f36460l.getVideoDuration());
                }
            }
        };
        this.f36451C = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            public C79094() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i102, int i112, int i12) throws Resources.NotFoundException {
                NativeVideoView.this.m48849a(i102, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).f36410b || C7775bv.m47831e(nativeVideoView.getContext())) {
                    return;
                }
                Toast toastMakeText = Toast.makeText(NativeVideoView.this.getContext(), C6849R.string.hiad_network_error, 0);
                toastMakeText.setGravity(17, 0, 0);
                toastMakeText.show();
            }
        };
        this.f36452D = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            public C79105() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i102) {
                NativeVideoView.this.f36458j.m50056b(i102);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i102) {
            }
        };
        this.f36453E = new MuteListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            public C79116() {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                AbstractC7185ho.m43820b("NativeVideoView", "onMute");
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44580e("n");
                    if (NativeVideoView.this.f36469u || !NativeVideoView.this.f36457i) {
                        NativeVideoView.this.f36469u = false;
                    } else {
                        NativeVideoView.this.f36459k.mo46099a(true);
                    }
                    NativeVideoView.this.f36455g.mo45614b(0.0f);
                }
                NativeVideoView.this.f36458j.m50064e(true);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                AbstractC7185ho.m43820b("NativeVideoView", "onUnmute");
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36469u = false;
                    NativeVideoView.this.f36460l.m44580e("y");
                    NativeVideoView.this.f36459k.mo46099a(false);
                    NativeVideoView.this.f36455g.mo45614b(1.0f);
                }
                NativeVideoView.this.f36458j.m50064e(false);
            }
        };
        this.f36454F = new C8077al.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.7
            public C79127() {
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48893a() {
                if (NativeVideoView.this.f36466r != null) {
                    NativeVideoView.this.f36466r.mo49347a(5);
                }
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public void mo48896b(boolean z10) {
                AbstractC7185ho.m43820b("NativeVideoView", "doRealPlay, auto:" + z10);
                NativeVideoView.this.f36470v.m45288a();
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48894a(boolean z10) {
                if (NativeVideoView.this.f36460l != null) {
                    NativeVideoView.this.f36460l.m44569b(!z10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public void mo48897b(boolean z10, int i102) {
                NativeVideoView.this.m48860b(z10, i102);
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: a */
            public void mo48895a(boolean z10, int i102) {
                NativeVideoView.this.m48855a(z10, i102);
            }

            @Override // com.huawei.openalliance.p169ad.views.C8077al.a
            /* renamed from: b */
            public boolean mo48898b() {
                return NativeVideoView.this.m48880m() && !NativeVideoView.this.f36473y;
            }
        };
        m48850a(context);
    }

    /* renamed from: a */
    private void m48850a(Context context) {
        this.f36459k = new C7511nf(context, this);
        LayoutInflater.from(context).inflate(C6849R.layout.hiad_native_video_view, this);
        this.f36465q = (VideoView) findViewById(C6849R.id.hiad_id_video_view);
        this.f36464p = (NativeVideoControlPanel) findViewById(C6849R.id.hiad_native_video_ctrl_panel);
        this.f36465q.setStandalone(false);
        this.f36465q.setScreenOnWhilePlaying(true);
        this.f36465q.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        C8077al c8077al = new C8077al(this.f36465q, this.f36464p);
        this.f36458j = c8077al;
        c8077al.m50052a(this.f36454F);
        this.f36465q.addMediaStateListener(this.f36450B);
        this.f36465q.addMediaBufferListener(this.f36474z);
        this.f36465q.addMediaErrorListener(this.f36451C);
        this.f36465q.addMuteListener(this.f36453E);
        this.f36465q.addMediaInfoListener(this.f36452D);
        this.f36465q.addReportVideoTimeListenersSet(this.f36449A);
        this.f36471w = new C7219im(this);
        this.f36470v = new C7333jg(getTAG());
    }

    /* renamed from: a */
    private void m48851a(VideoInfo videoInfo) {
        C7169gz c7169gzM43672a = C7171ha.m43672a();
        if (c7169gzM43672a == null || videoInfo == null) {
            return;
        }
        int iM43662c = c7169gzM43672a.m43662c();
        videoInfo.m44579e(iM43662c);
        AbstractC7185ho.m43820b("NativeVideoView", "obtain progress from linked view " + iM43662c);
        m48891v();
    }

    /* renamed from: b */
    public void m48860b(boolean z10, int i10) {
        VideoEventListener videoEventListener = this.f36456h;
        if (videoEventListener != null) {
            videoEventListener.onControlPanelHide(z10, i10);
        }
    }

    /* renamed from: a */
    private void m48852a(C7302e c7302e) {
        if (c7302e.getVideoInfo() != null) {
            this.f36455g.mo45611a(C7482mq.m45849a(0.0f, m48890u(), EnumC7481mp.STANDALONE));
        }
    }

    /* renamed from: a */
    public void m48892a(InterfaceC7416lz interfaceC7416lz, C7302e c7302e) {
        this.f36455g = interfaceC7416lz;
        m48852a(c7302e);
    }

    /* renamed from: a */
    public void m48855a(boolean z10, int i10) {
        VideoEventListener videoEventListener = this.f36456h;
        if (videoEventListener != null) {
            videoEventListener.onControlPanelShow(z10, i10);
        }
    }
}
