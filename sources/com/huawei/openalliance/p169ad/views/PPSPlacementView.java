package com.huawei.openalliance.p169ad.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6980bx;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7331je;
import com.huawei.openalliance.p169ad.C7335ji;
import com.huawei.openalliance.p169ad.C7340jn;
import com.huawei.openalliance.p169ad.C7341jo;
import com.huawei.openalliance.p169ad.C7405lo;
import com.huawei.openalliance.p169ad.C7482mq;
import com.huawei.openalliance.p169ad.C7518nm;
import com.huawei.openalliance.p169ad.C7556oq;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7575pi;
import com.huawei.openalliance.p169ad.C7666so;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.C7699tu;
import com.huawei.openalliance.p169ad.C8190vl;
import com.huawei.openalliance.p169ad.EnumC7473mh;
import com.huawei.openalliance.p169ad.EnumC7480mo;
import com.huawei.openalliance.p169ad.EnumC7481mp;
import com.huawei.openalliance.p169ad.InterfaceC7342jp;
import com.huawei.openalliance.p169ad.InterfaceC7416lz;
import com.huawei.openalliance.p169ad.InterfaceC7474mi;
import com.huawei.openalliance.p169ad.InterfaceC7615qq;
import com.huawei.openalliance.p169ad.activity.ComplianceActivity;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.NotifyMessageNames;
import com.huawei.openalliance.p169ad.constant.PlacementPlayState;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.inter.data.C7304g;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.PlacementEvent;
import com.huawei.openalliance.p169ad.inter.data.PlacementMediaFile;
import com.huawei.openalliance.p169ad.media.MediaState;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaPlayerReleaseListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener;
import com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.C7730ad;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSPlacementView;
import com.huawei.openalliance.p169ad.views.interfaces.IPlacementMediaChangeListener;
import com.huawei.openalliance.p169ad.views.interfaces.IPlacementMediaStateListener;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSPlacementView extends AutoScaleSizeRelativeLayout implements C7331je.a, MuteListener, SegmentMediaStateListener, IPPSPlacementView, IViewLifeCycle {

    /* renamed from: A */
    private int[] f36858A;

    /* renamed from: B */
    private PlacementMediaView f36859B;

    /* renamed from: C */
    private List<View> f36860C;

    /* renamed from: D */
    private boolean f36861D;

    /* renamed from: E */
    private C6922c f36862E;

    /* renamed from: F */
    private boolean f36863F;

    /* renamed from: G */
    private int f36864G;

    /* renamed from: H */
    private int f36865H;

    /* renamed from: I */
    private long f36866I;

    /* renamed from: J */
    private boolean f36867J;

    /* renamed from: K */
    private boolean f36868K;

    /* renamed from: L */
    private int f36869L;

    /* renamed from: M */
    private ImageView f36870M;

    /* renamed from: N */
    private boolean f36871N;

    /* renamed from: O */
    private boolean f36872O;

    /* renamed from: P */
    private boolean f36873P;

    /* renamed from: Q */
    private boolean f36874Q;

    /* renamed from: R */
    private MaterialClickInfo f36875R;

    /* renamed from: S */
    private C7022dk f36876S;

    /* renamed from: T */
    private boolean f36877T;

    /* renamed from: U */
    private long f36878U;

    /* renamed from: V */
    private MediaPlayerReleaseListener f36879V;

    /* renamed from: W */
    private int f36880W;

    /* renamed from: a */
    protected InterfaceC7416lz f36881a;

    /* renamed from: aa */
    private boolean f36882aa;

    /* renamed from: ab */
    private AudioManager f36883ab;

    /* renamed from: ac */
    private Object f36884ac;

    /* renamed from: ad */
    private PlacementPlayState f36885ad;

    /* renamed from: ae */
    private C7699tu f36886ae;

    /* renamed from: af */
    private List<InterfaceC7342jp> f36887af;

    /* renamed from: ag */
    private AtomicBoolean f36888ag;

    /* renamed from: ah */
    private List<C7560ou> f36889ah;

    /* renamed from: ai */
    private int f36890ai;

    /* renamed from: aj */
    private PPSVideoRenderListener f36891aj;

    /* renamed from: ak */
    private Handler f36892ak;

    /* renamed from: al */
    private SegmentMediaStateListener f36893al;

    /* renamed from: am */
    private View.OnTouchListener f36894am;

    /* renamed from: an */
    private View.OnClickListener f36895an;

    /* renamed from: ao */
    private AudioManager.OnAudioFocusChangeListener f36896ao;

    /* renamed from: b */
    protected InterfaceC7416lz f36897b;

    /* renamed from: c */
    protected InterfaceC7416lz f36898c;

    /* renamed from: d */
    int f36899d;

    /* renamed from: e */
    int f36900e;

    /* renamed from: f */
    private MaterialClickInfo f36901f;

    /* renamed from: g */
    private String f36902g;

    /* renamed from: h */
    private boolean f36903h;

    /* renamed from: i */
    private C7518nm f36904i;

    /* renamed from: j */
    private C7331je f36905j;

    /* renamed from: k */
    private List<C7304g> f36906k;

    /* renamed from: l */
    private C7304g f36907l;

    /* renamed from: m */
    private C7304g f36908m;

    /* renamed from: n */
    private int f36909n;

    /* renamed from: o */
    private OnPlacementAdClickListener f36910o;

    /* renamed from: p */
    private List<View> f36911p;

    /* renamed from: q */
    private boolean f36912q;

    /* renamed from: r */
    private boolean f36913r;

    /* renamed from: s */
    private PlacementMediaView f36914s;

    /* renamed from: t */
    private PlacementMediaView f36915t;

    /* renamed from: u */
    private PlacementMediaView f36916u;

    /* renamed from: v */
    private MediaBufferListener f36917v;

    /* renamed from: w */
    private MuteListener f36918w;

    /* renamed from: x */
    private MediaErrorListener f36919x;

    /* renamed from: y */
    private IPlacementMediaStateListener f36920y;

    /* renamed from: z */
    private IPlacementMediaChangeListener f36921z;

    @OuterVisible
    public interface OnPlacementAdClickListener {
        void onClick();
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSPlacementView$a */
    public static class C8003a implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a */
        private WeakReference<PPSPlacementView> f36957a;

        public C8003a(PPSPlacementView pPSPlacementView) {
            this.f36957a = new WeakReference<>(pPSPlacementView);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i10) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    PPSPlacementView pPSPlacementView = (PPSPlacementView) C8003a.this.f36957a.get();
                    if (pPSPlacementView == null) {
                        return;
                    }
                    AbstractC7185ho.m43821b("PPSPlacementView", "onAudioFocusChange %d previous: %d", Integer.valueOf(i10), Integer.valueOf(pPSPlacementView.f36880W));
                    int i11 = i10;
                    if (i11 == -3) {
                        C8003a.this.m49463b(pPSPlacementView);
                    } else if (i11 == -2 || i11 == -1) {
                        C8003a.this.m49461a(pPSPlacementView);
                    } else if (i11 == 1 || i11 == 2) {
                        C8003a.this.m49465c(pPSPlacementView);
                    }
                    pPSPlacementView.f36880W = i10;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m49463b(PPSPlacementView pPSPlacementView) {
            AbstractC7185ho.m43820b("PPSPlacementView", "handleAudioFocusLossTransientCanDuck soundMuted: " + pPSPlacementView.f36861D);
            if (pPSPlacementView.f36861D || pPSPlacementView.f36859B == null) {
                return;
            }
            pPSPlacementView.f36859B.mo49821c();
            pPSPlacementView.f36882aa = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m49465c(PPSPlacementView pPSPlacementView) {
            AbstractC7185ho.m43820b("PPSPlacementView", "handleAudioFocusGain.");
            if (!pPSPlacementView.f36882aa || pPSPlacementView.f36859B == null) {
                return;
            }
            pPSPlacementView.f36859B.mo49823d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m49461a(PPSPlacementView pPSPlacementView) {
            m49463b(pPSPlacementView);
        }
    }

    @OuterVisible
    public PPSPlacementView(Context context) {
        super(context);
        this.f36881a = new C7405lo();
        this.f36897b = new C7405lo();
        this.f36898c = new C7405lo();
        this.f36903h = true;
        this.f36906k = new ArrayList(4);
        this.f36909n = 0;
        this.f36912q = false;
        this.f36913r = false;
        this.f36917v = null;
        this.f36918w = null;
        this.f36919x = null;
        this.f36920y = null;
        this.f36921z = null;
        this.f36858A = null;
        this.f36861D = false;
        this.f36863F = false;
        this.f36864G = -1;
        this.f36865H = -1;
        this.f36866I = -1L;
        this.f36867J = false;
        this.f36868K = false;
        this.f36869L = -1;
        this.f36870M = null;
        this.f36871N = false;
        this.f36872O = false;
        this.f36873P = false;
        this.f36874Q = false;
        this.f36899d = -1;
        this.f36900e = -1;
        this.f36880W = 0;
        this.f36882aa = false;
        this.f36885ad = new PlacementPlayState();
        this.f36888ag = new AtomicBoolean();
        this.f36889ah = new ArrayList();
        this.f36890ai = 0;
        this.f36891aj = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                AbstractC7185ho.m43820b("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.m49445r();
                if (!PPSPlacementView.this.f36872O || PPSPlacementView.this.f36920y == null) {
                    return;
                }
                PPSPlacementView.this.f36872O = false;
                PPSPlacementView.this.f36873P = true;
                AbstractC7185ho.m43821b("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.f36865H));
                PPSPlacementView.this.f36920y.onMediaStart(PPSPlacementView.this.f36865H);
                PPSPlacementView.this.m49446s();
            }
        };
        this.f36892ak = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int duration;
                C7304g currentAd = PPSPlacementView.this.getCurrentAd();
                PlacementMediaFile currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String url = "";
                String contentId = currentAd != null ? currentAd.getContentId() : "";
                if (currentMediaFile != null) {
                    url = currentMediaFile.getUrl();
                    duration = (int) currentMediaFile.getDuration();
                } else {
                    duration = 0;
                }
                AbstractC7185ho.m43821b("PPSPlacementView", "callback timeout: %s", contentId);
                if (PPSPlacementView.this.f36859B == null) {
                    return true;
                }
                AbstractC7185ho.m43820b("PPSPlacementView", "notify Error");
                PPSPlacementView.this.m49391a(contentId, url, duration);
                return true;
            }
        });
        this.f36893al = new SegmentMediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaCompletion(String str, String str2, int i10) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    AbstractC7185ho.m43820b("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                    return;
                }
                if (PPSPlacementView.this.f36877T) {
                    return;
                }
                PPSPlacementView.this.f36877T = true;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45620g();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaError(String str, String str2, int i10, int i11, int i12) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaPause(String str, String str2, int i10) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.f36859B instanceof C8066aa)) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45624k();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaStart(String str, String str2, int i10) {
                PPSPlacementView pPSPlacementView;
                InterfaceC7416lz interfaceC7416lz;
                InterfaceC7416lz interfaceC7416lz2;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.f36877T = false;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST);
                    if (i10 > 0) {
                        if (zIsState) {
                            interfaceC7416lz2 = PPSPlacementView.this.f36898c;
                        } else {
                            boolean zIsState2 = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                            PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                            interfaceC7416lz2 = zIsState2 ? pPSPlacementView2.f36881a : pPSPlacementView2.f36897b;
                        }
                        interfaceC7416lz2.mo45625l();
                        return;
                    }
                    if (zIsState) {
                        pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = pPSPlacementView.f36898c;
                    } else {
                        boolean zIsState3 = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState3 ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    pPSPlacementView.m49379a(interfaceC7416lz);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaStop(String str, String str2, int i10) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    AbstractC7185ho.m43820b("PPSPlacementView", "OM onSegmentMediaStop not equals");
                    return;
                }
                if (PPSPlacementView.this.f36877T) {
                    return;
                }
                PPSPlacementView.this.f36877T = true;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45620g();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentProgress(String str, String str2, int i10, int i11) {
                InterfaceC7416lz interfaceC7416lz;
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.f36877T && (PPSPlacementView.this.f36859B instanceof C8066aa)) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45605a(i10);
                }
            }
        };
        this.f36894am = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AbstractC7185ho.m43817a("PPSPlacementView", "clickable.OnTouchListener.ontouch");
                try {
                    int iM47282a = C7694tp.m47282a(motionEvent);
                    if (iM47282a == 0) {
                        PPSPlacementView.this.f36901f = C7694tp.m47283a(view, motionEvent);
                        PPSPlacementView.this.f36901f.m44505a(C8190vl.m50727b(PPSPlacementView.this));
                    }
                    if (1 != iM47282a) {
                        return false;
                    }
                    C7694tp.m47284a(view, motionEvent, null, PPSPlacementView.this.f36901f);
                    return false;
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("PPSPlacementView", "clickable.OnTouchListener.ontouch exception : %s", th2.getClass().getSimpleName());
                    return false;
                }
            }
        };
        this.f36895an = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.m49423g();
                    }
                });
            }
        };
        this.f36896ao = new C8003a(this);
        m49375a(context);
    }

    /* renamed from: a */
    private int m49366a(int i10, C7304g c7304g, long j10) {
        if (this.f36920y != null || this.f36863F || i10 > 0) {
            if (i10 > j10 && j10 > 0) {
                i10 = (int) j10;
            }
            int currentPlayTime = getCurrentPlayTime() + i10;
            int[] iArr = this.f36858A;
            int i11 = (iArr == null || iArr.length <= 0 || iArr[iArr.length + (-1)] <= 0) ? -1 : (int) ((currentPlayTime / iArr[iArr.length - 1]) * 100.0f);
            if (c7304g != null) {
                this.f36899d = currentPlayTime;
                this.f36900e = i11;
            }
            IPlacementMediaStateListener iPlacementMediaStateListener = this.f36920y;
            if (iPlacementMediaStateListener != null) {
                iPlacementMediaStateListener.onMediaProgress(i11, currentPlayTime);
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m49416e() {
        PlacementPlayState placementPlayState;
        C7304g c7304g;
        PlacementMediaView placementMediaView;
        PlacementPlayState placementPlayState2 = this.f36885ad;
        PlacementPlayState.State state = PlacementPlayState.State.SINGLE_INST;
        AbstractC7185ho.m43818a("PPSPlacementView", "initPlacementView, singlePlayerInst: %s", Boolean.valueOf(placementPlayState2.isState(state)));
        this.f36905j.m45276b(this.f36907l.getMinEffectiveShowTime(), this.f36907l.getMinEffectiveShowRatio());
        this.f36904i.m46158a(this.f36907l);
        if (this.f36885ad.isState(state)) {
            PlacementMediaView placementMediaViewM49400b = m49400b(this.f36916u, this.f36907l);
            this.f36916u = placementMediaViewM49400b;
            placementMediaViewM49400b.setMediaPlayerReleaseListener(this.f36879V);
            placementPlayState = new PlacementPlayState(state);
            c7304g = this.f36907l;
            placementMediaView = this.f36916u;
        } else {
            this.f36914s = m49400b(this.f36914s, this.f36907l);
            m49377a(new PlacementPlayState(PlacementPlayState.State.MAIN_VIEW), this.f36907l, this.f36914s);
            this.f36915t = m49400b(this.f36915t, this.f36908m);
            placementPlayState = new PlacementPlayState(PlacementPlayState.State.BACKUP_VIEW);
            c7304g = this.f36908m;
            placementMediaView = this.f36915t;
        }
        m49377a(placementPlayState, c7304g, placementMediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C7304g getCurrentAd() {
        if (this.f36909n < this.f36906k.size()) {
            return this.f36906k.get(this.f36909n);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getCurrentAdDuration() {
        PlacementMediaFile mediaFile;
        C7304g currentAd = getCurrentAd();
        if (currentAd == null || (mediaFile = currentAd.getMediaFile()) == null) {
            return 0L;
        }
        return mediaFile.getDuration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentContentId() {
        C7304g currentAd = getCurrentAd();
        if (currentAd == null) {
            return null;
        }
        return currentAd.getContentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlacementMediaFile getCurrentMediaFile() {
        if (getCurrentAd() != null) {
            return getCurrentAd().getMediaFile();
        }
        return null;
    }

    private MediaState getCurrentMediaState() {
        PlacementMediaView placementMediaView = this.f36859B;
        if (placementMediaView == null) {
            return null;
        }
        return placementMediaView.getMediaState();
    }

    private int getCurrentPlayTime() {
        int i10 = this.f36909n;
        if (i10 < 1) {
            return 0;
        }
        return this.f36858A[i10 - 1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMonitor() {
        if (this.f36888ag.get()) {
            return;
        }
        this.f36888ag.set(true);
        this.f36887af = new ArrayList(this.f36906k.size());
        for (C7304g c7304g : this.f36906k) {
            ContentRecord contentRecordM46766a = C7575pi.m46766a(c7304g);
            C7560ou c7560ou = new C7560ou(getContext(), new C7666so(getContext()));
            c7560ou.m46575a(contentRecordM46766a.m41505b());
            c7560ou.mo46590a(contentRecordM46766a);
            this.f36889ah.add(c7560ou);
            InterfaceC7342jp interfaceC7342jpM45339a = C7340jn.m45339a(getContext(), c7304g.isImageAd(), c7560ou, contentRecordM46766a, false);
            C7340jn.m45343a(contentRecordM46766a.m41588n(), interfaceC7342jpM45339a);
            this.f36887af.add(interfaceC7342jpM45339a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C7304g getNextAd() {
        if (this.f36909n < this.f36906k.size() - 1) {
            return this.f36906k.get(this.f36909n + 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m49429j() {
        List<InterfaceC7342jp> list = this.f36887af;
        if (list != null) {
            for (InterfaceC7342jp interfaceC7342jp : list) {
                if (interfaceC7342jp != null) {
                    interfaceC7342jp.mo45354b();
                }
            }
        }
    }

    /* renamed from: m */
    private void m49435m() {
        PlacementPlayState placementPlayState;
        C7304g c7304g;
        PlacementMediaView placementMediaView;
        this.f36909n++;
        AbstractC7185ho.m43820b("PPSPlacementView", "load " + this.f36909n + " ad");
        if (getNextAd() == null || this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
            return;
        }
        if (Math.abs(this.f36914s.getAlpha() - 1.0f) < 0.01f) {
            C7304g nextAd = getNextAd();
            this.f36908m = nextAd;
            this.f36915t = m49400b(this.f36915t, nextAd);
            placementPlayState = new PlacementPlayState(PlacementPlayState.State.BACKUP_VIEW);
            c7304g = this.f36908m;
            placementMediaView = this.f36915t;
        } else {
            C7304g nextAd2 = getNextAd();
            this.f36907l = nextAd2;
            this.f36914s = m49400b(this.f36914s, nextAd2);
            placementPlayState = new PlacementPlayState(PlacementPlayState.State.MAIN_VIEW);
            c7304g = this.f36907l;
            placementMediaView = this.f36914s;
        }
        m49377a(placementPlayState, c7304g, placementMediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m49439o() {
        this.f36874Q = false;
        AbstractC7185ho.m43820b("PPSPlacementView", "timeout, cancel.");
        this.f36892ak.removeMessages(1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m49446s() {
        String str;
        if (!m49451u()) {
            AbstractC7185ho.m43823c("PPSPlacementView", "audio focus is not needed");
            return;
        }
        try {
            AbstractC7185ho.m43820b("PPSPlacementView", "requestAudioFocus");
            AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(2).setOnAudioFocusChangeListener(this.f36896ao).build();
            this.f36884ac = audioFocusRequestBuild;
            this.f36883ab.requestAudioFocus(audioFocusRequestBuild);
        } catch (IllegalStateException unused) {
            str = "requestAudioFocus IllegalStateException";
            AbstractC7185ho.m43823c("PPSPlacementView", str);
        } catch (Exception e10) {
            str = "requestAudioFocus " + e10.getClass().getSimpleName();
            AbstractC7185ho.m43823c("PPSPlacementView", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m49448t() {
        String str;
        try {
            try {
                AbstractC7185ho.m43820b("PPSPlacementView", "abandonAudioFocus");
                Object obj = this.f36884ac;
                if (obj instanceof AudioFocusRequest) {
                    this.f36883ab.abandonAudioFocusRequest((AudioFocusRequest) obj);
                }
                this.f36884ac = null;
            } catch (IllegalStateException unused) {
                str = "abandonAudioFocus IllegalStateException";
                AbstractC7185ho.m43823c("PPSPlacementView", str);
                this.f36882aa = false;
                this.f36880W = 0;
            } catch (Exception e10) {
                str = "abandonAudioFocus " + e10.getClass().getSimpleName();
                AbstractC7185ho.m43823c("PPSPlacementView", str);
                this.f36882aa = false;
                this.f36880W = 0;
            }
            this.f36882aa = false;
            this.f36880W = 0;
        } catch (Throwable th2) {
            this.f36882aa = false;
            this.f36880W = 0;
            throw th2;
        }
    }

    @OuterVisible
    public void addMediaBufferListener(MediaBufferListener mediaBufferListener) {
        if (mediaBufferListener == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.f36914s;
        if (placementMediaView != null) {
            placementMediaView.mo49806a(mediaBufferListener);
        } else {
            this.f36917v = mediaBufferListener;
        }
    }

    @OuterVisible
    public void addMediaChangeListener(IPlacementMediaChangeListener iPlacementMediaChangeListener) {
        if (iPlacementMediaChangeListener == null) {
            return;
        }
        this.f36921z = iPlacementMediaChangeListener;
    }

    @OuterVisible
    public void addMediaErrorListener(MediaErrorListener mediaErrorListener) {
        if (mediaErrorListener == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.f36914s;
        if (placementMediaView != null) {
            placementMediaView.mo49807a(mediaErrorListener);
        } else {
            this.f36919x = mediaErrorListener;
        }
    }

    @OuterVisible
    public void addMuteListener(MuteListener muteListener) {
        if (muteListener == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.f36914s;
        if (placementMediaView != null) {
            placementMediaView.mo49809a(muteListener);
        } else {
            this.f36918w = muteListener;
        }
    }

    @OuterVisible
    public void addPlacementMediaStateListener(IPlacementMediaStateListener iPlacementMediaStateListener) {
        if (iPlacementMediaStateListener == null) {
            return;
        }
        this.f36920y = iPlacementMediaStateListener;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.13
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSPlacementView", RewardMethods.DESTROY_VIEW);
                if (PPSPlacementView.this.f36859B != null) {
                    PPSPlacementView.this.f36859B.mo49827g();
                    PPSPlacementView.this.f36859B.destroyView();
                }
                PPSPlacementView.this.removeMediaChangeListener();
                PPSPlacementView.this.removePlacementMediaStateListener();
                PPSPlacementView.this.m49439o();
                PPSPlacementView.this.f36881a.mo45613b();
                PPSPlacementView.this.f36897b.mo45613b();
                PPSPlacementView.this.f36898c.mo45613b();
                PPSPlacementView.this.m49429j();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!C7845x.m48605t(getContext())) {
            return super.dispatchKeyEvent(keyEvent);
        }
        try {
            AbstractC7185ho.m43817a("PPSPlacementView", "keyCode:" + keyEvent.getKeyCode());
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 4) {
                if (keyCode == 23 || keyCode == 66) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "enter--->");
                    if (isTransparencyDialogVisible()) {
                        if (keyEvent.getAction() == 0) {
                            AbstractC7185ho.m43817a("PPSPlacementView", "enter---> ACTION_DOWN: pressWhyThisAdClickBtn");
                            this.f36886ae.m47331l();
                        } else if (keyEvent.getAction() == 1) {
                            AbstractC7185ho.m43817a("PPSPlacementView", "enter---> ACTION_UP: outerProcessWhyEventUnified");
                            m49453v();
                            C7699tu c7699tu = this.f36886ae;
                            if (c7699tu != null) {
                                removeView(c7699tu);
                            }
                            this.f36886ae = null;
                            return true;
                        }
                    }
                }
            } else {
                if (keyEvent.getAction() == 0) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                AbstractC7185ho.m43817a("PPSPlacementView", "back--->");
                C7699tu c7699tu2 = this.f36886ae;
                if (c7699tu2 != null) {
                    removeView(c7699tu2);
                    this.f36886ae = null;
                    return true;
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("PPSPlacementView", "dispatchKeyEvent() exception:" + th2.toString());
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int iM47282a = C7694tp.m47282a(motionEvent);
            if (iM47282a == 0) {
                this.f36875R = C7694tp.m47283a(this, motionEvent);
            }
            if (1 == iM47282a) {
                C7694tp.m47284a(this, motionEvent, null, this.f36875R);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSPlacementView", "dispatchTouchEvent exception : %s", th2.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8113f
    public IAd getAd() {
        return getCurrentAd();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IPPSPlacementView
    public String getShowId() {
        return this.f36902g;
    }

    @OuterVisible
    public void hideAdvertiserInfoDialog() {
        C7335ji.m45308a().m45309a(NotifyMessageNames.FEEDBACK_RECEIVE, new Intent("com.huawei.ads.feedback.action.FINISH_FEEDBACK_ACTIVITY"));
    }

    @OuterVisible
    public void hideTransparencyDialog() {
        C7335ji.m45308a().m45309a(NotifyMessageNames.FEEDBACK_RECEIVE, new Intent("com.huawei.ads.feedback.action.FINISH_FEEDBACK_ACTIVITY"));
    }

    @OuterVisible
    public boolean isPlaying() {
        PlacementMediaView placementMediaView = this.f36859B;
        if (placementMediaView != null) {
            return placementMediaView.mo49829i();
        }
        return false;
    }

    @OuterVisible
    public boolean isTransparencyDialogVisible() {
        C7699tu c7699tu = this.f36886ae;
        return c7699tu != null && c7699tu.getVisibility() == 0 && this.f36886ae.getLocalVisibleRect(new Rect());
    }

    @OuterVisible
    public void muteSound() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.7
            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                AbstractC7185ho.m43820b("PPSPlacementView", "muteSound");
                boolean z11 = true;
                if (PPSPlacementView.this.f36869L == 1) {
                    PPSPlacementView.this.m49448t();
                }
                PPSPlacementView.this.f36861D = true;
                if (PPSPlacementView.this.f36914s != null) {
                    PPSPlacementView.this.f36914s.mo49821c();
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (PPSPlacementView.this.f36915t != null) {
                    PPSPlacementView.this.f36915t.mo49821c();
                } else {
                    z11 = z10;
                }
                if (PPSPlacementView.this.f36916u != null) {
                    PPSPlacementView.this.f36916u.mo49821c();
                } else if (!z11) {
                    return;
                }
                PPSPlacementView.this.f36904i.m46159a(PPSPlacementView.this.f36861D);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC7185ho.m43817a("PPSPlacementView", "onAttachedToWindow");
        this.f36905j.m45301h();
        C7556oq.m46397a(getContext()).m46409b(getContext());
    }

    @OuterVisible
    public void onClose() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.3
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSPlacementView", "onClose");
                PPSPlacementView.this.f36904i.m46155a();
                (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST) ? PPSPlacementView.this.f36898c : PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW) ? PPSPlacementView.this.f36881a : PPSPlacementView.this.f36897b).mo45623j();
                PPSPlacementView.this.m49429j();
                PPSPlacementView.this.f36881a.mo45613b();
                PPSPlacementView.this.f36897b.mo45613b();
                PPSPlacementView.this.f36898c.mo45613b();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC7185ho.m43820b("PPSPlacementView", "onDetechedFromWindow");
        this.f36905j.m45302i();
        this.f36881a.mo45613b();
        this.f36897b.mo45613b();
        this.f36898c.mo45613b();
    }

    @OuterVisible
    public void onEvent(final PlacementEvent placementEvent) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.14
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSPlacementView", "onEvent:" + placementEvent.m44544a());
                if (PlacementEvent.CLOSE == placementEvent) {
                    PPSPlacementView.this.mo49458a((Integer) 3);
                    PPSPlacementView.this.onClose();
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
    public void onMute() {
        AbstractC7185ho.m43820b("PPSPlacementView", "onMute");
        this.f36861D = true;
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaCompletion(String str, String str2, int i10) {
        PlacementMediaView placementMediaView;
        String currentContentId = getCurrentContentId();
        if (str != null && !str.equalsIgnoreCase(currentContentId)) {
            AbstractC7185ho.m43821b("PPSPlacementView", "onCompletion, %s not match current content id: %s", str, currentContentId);
            return;
        }
        boolean zM49432k = m49432k();
        if (!zM49432k) {
            PlacementMediaView placementMediaView2 = this.f36859B;
            if (placementMediaView2 instanceof C8066aa) {
                this.f36870M = placementMediaView2.getLastFrame();
                m49443q();
            }
        }
        PlacementMediaView placementMediaView3 = this.f36859B;
        if (placementMediaView3 instanceof C8066aa) {
            placementMediaView3.mo49816b(i10);
        }
        m49439o();
        AbstractC7185ho.m43821b("PPSPlacementView", "onSegmentMediaCompletion, contentId: %s, url: %s", str, AbstractC7819dl.m48375a(str2));
        m49402b(i10);
        this.f36905j.m45306m();
        this.f36859B.mo49804a(i10);
        m49394a(zM49432k);
        if (this.f36920y == null || !zM49432k) {
            return;
        }
        int currentPlayTime = getCurrentPlayTime() + i10;
        AbstractC7185ho.m43821b("PPSPlacementView", "onCompletion callback, playedTime: %s", Integer.valueOf(currentPlayTime));
        this.f36920y.onMediaCompletion(currentPlayTime);
        if (this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST) && (placementMediaView = this.f36916u) != null) {
            placementMediaView.mo49814b();
        }
        m49448t();
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaError(String str, String str2, int i10, int i11, int i12) {
        PlacementMediaView placementMediaView;
        PlacementMediaFile mediaFile;
        AbstractC7185ho.m43821b("PPSPlacementView", "onMediaError, contentId: %s, url: %s", str, AbstractC7819dl.m48375a(str2));
        String currentContentId = getCurrentContentId();
        if (str != null && !str.equalsIgnoreCase(currentContentId)) {
            AbstractC7185ho.m43821b("PPSPlacementView", "onError, contentId not match, currentConentId: %s", currentContentId);
            return;
        }
        m49445r();
        m49439o();
        AbstractC7185ho.m43823c("PPSPlacementView", "onSegmentMediaError:" + AbstractC7819dl.m48375a(str2) + ", playTime:" + i10 + ",errorCode:" + i11 + ",extra:" + i12);
        m49402b(i10);
        if (this.f36920y != null) {
            int currentPlayTime = getCurrentPlayTime() + i10;
            AbstractC7185ho.m43821b("PPSPlacementView", "meidaError callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.f36920y.onMediaError(currentPlayTime, i11, i12);
            this.f36920y.onErrorWithContentId(i10, i11, i12, str);
        }
        if (!this.f36873P) {
            AbstractC7185ho.m43820b("PPSPlacementView", "error before start callback.");
            this.f36872O = true;
        }
        this.f36905j.m45306m();
        this.f36859B.mo49804a(i10);
        C7304g currentAd = getCurrentAd();
        if (currentAd != null && (mediaFile = currentAd.getMediaFile()) != null) {
            this.f36862E.m39089a(mediaFile.getUrl(), i11, i12, C7575pi.m46766a(currentAd));
        }
        boolean zM49432k = m49432k();
        m49394a(zM49432k);
        if (this.f36920y == null || !zM49432k || this.f36858A.length <= 0) {
            return;
        }
        AbstractC7185ho.m43820b("PPSPlacementView", "last ad play error");
        IPlacementMediaStateListener iPlacementMediaStateListener = this.f36920y;
        int[] iArr = this.f36858A;
        iPlacementMediaStateListener.onMediaCompletion(iArr[iArr.length - 1]);
        if (!this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST) || (placementMediaView = this.f36916u) == null) {
            return;
        }
        placementMediaView.mo49814b();
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaPause(String str, String str2, int i10) {
        AbstractC7185ho.m43820b("PPSPlacementView", "onSegmentMediaPause:" + AbstractC7819dl.m48375a(str2));
        if (str != null && str.equalsIgnoreCase(getCurrentContentId())) {
            m49402b(i10);
            PlacementMediaView placementMediaView = this.f36859B;
            if (placementMediaView instanceof C8066aa) {
                placementMediaView.mo49822c(i10);
            }
        }
        if (this.f36920y != null) {
            int currentPlayTime = getCurrentPlayTime() + i10;
            int[] iArr = this.f36858A;
            int i11 = (iArr == null || iArr.length <= 0 || iArr[iArr.length + (-1)] <= 0) ? -1 : (int) ((currentPlayTime / iArr[iArr.length - 1]) * 100.0f);
            C7304g currentAd = getCurrentAd();
            if (currentAd != null && currentAd.isVideoAd()) {
                this.f36899d = currentPlayTime;
                this.f36900e = i11;
            }
            AbstractC7185ho.m43821b("PPSPlacementView", "meidaPause callback, playedTime: %s.", Integer.valueOf(currentPlayTime));
            this.f36920y.onMediaPause(currentPlayTime);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaStart(String str, String str2, int i10) {
        C7304g currentAd;
        AbstractC7185ho.m43821b("PPSPlacementView", "onSegmentMediaStart, contentId: %s, url: %s", str, AbstractC7819dl.m48375a(str2));
        this.f36863F = true;
        this.f36865H = i10;
        PlacementMediaView placementMediaView = this.f36859B;
        if (placementMediaView != null) {
            placementMediaView.setAlpha(1.0f);
        }
        if (AbstractC7185ho.m43819a() && (currentAd = getCurrentAd()) != null) {
            AbstractC7185ho.m43818a("PPSPlacementView", "customExposureType: %s , getMinEffectiveShowTime %s , getMinEffectiveVideoPlayProgress %s", currentAd.m44659q(), Long.valueOf(currentAd.getMinEffectiveShowTime()), currentAd.m44661r());
        }
        if (this.f36920y != null && this.f36909n == 0) {
            AbstractC7185ho.m43820b("PPSPlacementView", "need notify media start.");
            this.f36872O = true;
        }
        if (this.f36921z != null && this.f36859B != null) {
            AbstractC7185ho.m43820b("PPSPlacementView", "mediaChange callback.");
            this.f36921z.onSegmentMediaChange(this.f36859B.getPlacementAd());
        }
        PlacementMediaView placementMediaView2 = this.f36859B;
        if (placementMediaView2 instanceof C8066aa) {
            placementMediaView2.mo49825e();
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaStop(String str, String str2, int i10) {
        AbstractC7185ho.m43821b("PPSPlacementView", "onSegmentMediaStop, contentId: %s, url: %s", str, AbstractC7819dl.m48375a(str2));
        if (str != null && str.equalsIgnoreCase(getCurrentContentId())) {
            m49402b(i10);
        }
        if (this.f36920y == null || !str.equalsIgnoreCase(getCurrentContentId())) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.f36920y == null);
            objArr[1] = getCurrentContentId();
            AbstractC7185ho.m43821b("PPSPlacementView", "skip mediaStop callback, isListener null ? %s, currentContentId: %s", objArr);
            return;
        }
        PlacementMediaView placementMediaView = this.f36859B;
        if (placementMediaView instanceof C8066aa) {
            placementMediaView.mo49815b(i10);
        }
        int currentPlayTime = getCurrentPlayTime() + i10;
        int[] iArr = this.f36858A;
        int i11 = (iArr == null || iArr.length <= 0 || iArr[iArr.length - 1] <= 0) ? -1 : (int) ((currentPlayTime / iArr[iArr.length - 1]) * 100.0f);
        C7304g currentAd = getCurrentAd();
        if (currentAd != null && currentAd.isVideoAd()) {
            this.f36899d = currentPlayTime;
            this.f36900e = i11;
        }
        AbstractC7185ho.m43821b("PPSPlacementView", "meidaStop callback, playedTime: %s", Integer.valueOf(currentPlayTime));
        this.f36920y.onMediaStop(currentPlayTime);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSegmentProgress(java.lang.String r8, java.lang.String r9, int r10, int r11) {
        /*
            r7 = this;
            com.huawei.openalliance.ad.media.MediaState r0 = r7.getCurrentMediaState()
            java.lang.String r1 = "PPSPlacementView"
            if (r0 == 0) goto L16
            com.huawei.openalliance.ad.media.MediaState$State r2 = com.huawei.openalliance.ad.media.MediaState.State.PLAYING
            boolean r0 = r0.isNotState(r2)
            if (r0 == 0) goto L16
            java.lang.String r7 = "progress callback on nonPlaying state."
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c(r1, r7)
            return
        L16:
            java.lang.String r0 = r7.getCurrentContentId()
            if (r8 == 0) goto L23
            boolean r0 = r8.equalsIgnoreCase(r0)
            if (r0 != 0) goto L23
            return
        L23:
            r7.f36864G = r10
            com.huawei.openalliance.ad.inter.data.g r10 = r7.getCurrentAd()
            long r2 = r7.getCurrentAdDuration()
            boolean r0 = r7.f36863F
            r4 = 1
            if (r0 != 0) goto L3b
            int r5 = r7.f36865H
            if (r5 >= 0) goto L3b
            r7.f36865H = r11
            r7.f36863F = r4
            goto L5e
        L3b:
            if (r0 == 0) goto L5e
            int r0 = r7.f36865H
            if (r0 < 0) goto L5e
            int r0 = r11 - r0
            long r5 = (long) r0
            r7.f36866I = r5
            com.huawei.openalliance.ad.je r0 = r7.f36905j
            int r0 = r0.m45277c()
            r7.m49409c(r5, r0)
            com.huawei.openalliance.ad.nm r0 = r7.f36904i
            if (r0 == 0) goto L57
            long r5 = (long) r11
            r0.m45315a(r5, r2)
        L57:
            long r5 = r7.f36866I
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 < 0) goto L5e
            goto L5f
        L5e:
            r4 = 0
        L5f:
            int r11 = r7.m49366a(r11, r10, r2)
            r7.m49373a(r11)
            if (r4 == 0) goto L70
            java.lang.String r0 = "time countdown finish, manual stop."
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43820b(r1, r0)
            r7.m49392a(r8, r9, r11, r10)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.PPSPlacementView.onSegmentProgress(java.lang.String, java.lang.String, int, int):void");
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
    public void onUnmute() {
        AbstractC7185ho.m43820b("PPSPlacementView", "onUnmute");
        this.f36861D = false;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        this.f36905j.m45303j();
    }

    @OuterVisible
    public void pause() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.5
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSPlacementView", VastAttribute.PAUSE);
                if (PPSPlacementView.this.f36859B != null) {
                    PPSPlacementView.this.f36859B.mo49826f();
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.11
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSPlacementView", RewardMethods.PAUSE_VIEW);
                if (PPSPlacementView.this.f36859B != null) {
                    PPSPlacementView.this.f36859B.pauseView();
                    PPSPlacementView.this.f36859B.mo49826f();
                    PPSPlacementView.this.m49439o();
                }
            }
        });
    }

    @OuterVisible
    public void play(final boolean z10) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.4
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSPlacementView", "play, auto:" + z10);
                if (PPSPlacementView.this.f36859B != null) {
                    PPSPlacementView.this.f36859B.mo49813a(z10, PPSPlacementView.this.f36861D);
                }
            }
        });
    }

    @OuterVisible
    public void register(final List<IPlacementAd> list) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.18
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("register:");
                List list2 = list;
                sb2.append(list2 == null ? 0 : list2.size());
                AbstractC7185ho.m43820b("PPSPlacementView", sb2.toString());
                PPSPlacementView.this.m49393a((List<IPlacementAd>) list);
                if (AbstractC7760bg.m47767a(list) || AbstractC7760bg.m47767a(PPSPlacementView.this.f36906k)) {
                    return;
                }
                PPSPlacementView.this.getMonitor();
                PPSPlacementView.this.f36909n = 0;
                PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                pPSPlacementView.f36907l = pPSPlacementView.getCurrentAd();
                PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                pPSPlacementView2.f36908m = pPSPlacementView2.getNextAd();
                PPSPlacementView.this.m49416e();
                PPSPlacementView.this.m49428i();
                PlacementMediaView placementMediaView = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST) ? PPSPlacementView.this.f36916u : PPSPlacementView.this.f36914s;
                PPSPlacementView.this.m49420f();
                PPSPlacementView.this.m49388a(placementMediaView);
                if (PPSPlacementView.this.f36868K) {
                    PPSPlacementView.this.m49408c();
                }
            }
        });
    }

    @OuterVisible
    public void removeMediaBufferListener(MediaBufferListener mediaBufferListener) {
        if (mediaBufferListener == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.f36914s;
        if (placementMediaView != null) {
            placementMediaView.mo49817b(mediaBufferListener);
        } else {
            this.f36917v = null;
        }
    }

    @OuterVisible
    public void removeMediaChangeListener() {
        this.f36921z = null;
    }

    @OuterVisible
    public void removeMediaErrorListener(MediaErrorListener mediaErrorListener) {
        if (mediaErrorListener == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.f36914s;
        if (placementMediaView != null) {
            placementMediaView.mo49818b(mediaErrorListener);
        } else {
            this.f36919x = null;
        }
    }

    @OuterVisible
    public void removeMediaPlayerReleaseListener(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
        PlacementMediaView placementMediaView = this.f36916u;
        if (placementMediaView != null) {
            placementMediaView.mo49808a(mediaPlayerReleaseListener);
        }
        this.f36879V = null;
    }

    @OuterVisible
    public void removeMuteListener(MuteListener muteListener) {
        if (muteListener == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.f36914s;
        if (placementMediaView != null) {
            placementMediaView.mo49819b(muteListener);
        } else {
            this.f36918w = null;
        }
    }

    @OuterVisible
    public void removePlacementMediaStateListener() {
        this.f36920y = null;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.10
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSPlacementView", RewardMethods.RESUME_VIEW);
                if (PPSPlacementView.this.f36859B != null) {
                    PPSPlacementView.this.f36859B.resumeView();
                    PPSPlacementView.this.f36859B.mo49813a(true, PPSPlacementView.this.f36861D);
                    PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                    pPSPlacementView.m49374a(pPSPlacementView.getCurrentAdDuration() * 2);
                }
            }
        });
    }

    @OuterVisible
    public void setAudioFocusType(int i10) {
        this.f36869L = i10;
    }

    @OuterVisible
    public void setMediaPlayerReleaseListener(MediaPlayerReleaseListener mediaPlayerReleaseListener) {
        if (mediaPlayerReleaseListener == null) {
            return;
        }
        this.f36879V = mediaPlayerReleaseListener;
    }

    @OuterVisible
    public void setOnPlacementAdClickListener(OnPlacementAdClickListener onPlacementAdClickListener) {
        this.f36910o = onPlacementAdClickListener;
    }

    public void setOverlays(List<View> list) {
        this.f36860C = list;
    }

    @OuterVisible
    public void setSoundVolume(final float f10) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.8
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43821b("PPSPlacementView", "set sound volume: %s", Float.valueOf(f10));
                if (PPSPlacementView.this.f36859B != null) {
                    PPSPlacementView.this.f36859B.setSoundVolume(f10);
                    (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST) ? PPSPlacementView.this.f36898c : PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW) ? PPSPlacementView.this.f36881a : PPSPlacementView.this.f36897b).mo45614b(f10);
                }
            }
        });
    }

    @OuterVisible
    public void showAdvertiserInfoDialog(View view, boolean z10) {
        if (view == null) {
            AbstractC7185ho.m43823c("PPSPlacementView", "anchorView is null");
        }
        try {
            C7304g currentAd = getCurrentAd();
            if (currentAd == null) {
                AbstractC7185ho.m43823c("PPSPlacementView", "adInfo is null");
                return;
            }
            ContentRecord contentRecordM46766a = C7575pi.m46766a(currentAd);
            if (AbstractC7760bg.m47767a(contentRecordM46766a.m41468aT())) {
                AbstractC7185ho.m43823c("PPSPlacementView", "advertiser Info is null");
            } else {
                ComplianceActivity.m38595a(getContext(), view, contentRecordM46766a, z10);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSPlacementView", "showAdvertiserInfoDialog has exception %s", th2.getClass().getSimpleName());
        }
    }

    @OuterVisible
    public void showTransparencyDialog(View view) {
        showTransparencyDialog(view, null);
    }

    @OuterVisible
    public void stop() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.6
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSPlacementView", "stop");
                if (PPSPlacementView.this.f36859B != null) {
                    PPSPlacementView.this.f36859B.mo49827g();
                }
            }
        });
    }

    @OuterVisible
    public void unmuteSound() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.9
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSPlacementView", "unmuteSound");
                boolean z10 = true;
                if (PPSPlacementView.this.f36869L == 1) {
                    PPSPlacementView.this.m49446s();
                }
                boolean z11 = false;
                PPSPlacementView.this.f36861D = false;
                if (PPSPlacementView.this.f36914s != null) {
                    PPSPlacementView.this.f36914s.mo49823d();
                    z11 = true;
                }
                if (PPSPlacementView.this.f36915t != null) {
                    PPSPlacementView.this.f36915t.mo49823d();
                } else {
                    z10 = z11;
                }
                if (PPSPlacementView.this.f36916u != null) {
                    PPSPlacementView.this.f36916u.mo49823d();
                } else if (!z10) {
                    return;
                }
                PPSPlacementView.this.f36904i.m46159a(PPSPlacementView.this.f36861D);
            }
        });
    }

    @OuterVisible
    public void unregister() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSPlacementView", "unregister");
                PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                pPSPlacementView.m49389a(pPSPlacementView.f36914s, true);
                PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                pPSPlacementView2.m49389a(pPSPlacementView2.f36915t, true);
                PPSPlacementView.this.f36907l = null;
                PPSPlacementView.this.f36908m = null;
                PPSPlacementView.this.f36906k.clear();
                PPSPlacementView.this.f36905j.m45275b();
                PPSPlacementView.this.f36904i.m46158a((C7304g) null);
                PPSPlacementView.this.m49429j();
                PPSPlacementView.this.m49426h();
                PPSPlacementView.this.f36881a.mo45613b();
                PPSPlacementView.this.f36897b.mo45613b();
                PPSPlacementView.this.f36898c.mo45613b();
            }
        });
    }

    @OuterVisible
    public PPSPlacementView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36881a = new C7405lo();
        this.f36897b = new C7405lo();
        this.f36898c = new C7405lo();
        this.f36903h = true;
        this.f36906k = new ArrayList(4);
        this.f36909n = 0;
        this.f36912q = false;
        this.f36913r = false;
        this.f36917v = null;
        this.f36918w = null;
        this.f36919x = null;
        this.f36920y = null;
        this.f36921z = null;
        this.f36858A = null;
        this.f36861D = false;
        this.f36863F = false;
        this.f36864G = -1;
        this.f36865H = -1;
        this.f36866I = -1L;
        this.f36867J = false;
        this.f36868K = false;
        this.f36869L = -1;
        this.f36870M = null;
        this.f36871N = false;
        this.f36872O = false;
        this.f36873P = false;
        this.f36874Q = false;
        this.f36899d = -1;
        this.f36900e = -1;
        this.f36880W = 0;
        this.f36882aa = false;
        this.f36885ad = new PlacementPlayState();
        this.f36888ag = new AtomicBoolean();
        this.f36889ah = new ArrayList();
        this.f36890ai = 0;
        this.f36891aj = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                AbstractC7185ho.m43820b("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.m49445r();
                if (!PPSPlacementView.this.f36872O || PPSPlacementView.this.f36920y == null) {
                    return;
                }
                PPSPlacementView.this.f36872O = false;
                PPSPlacementView.this.f36873P = true;
                AbstractC7185ho.m43821b("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.f36865H));
                PPSPlacementView.this.f36920y.onMediaStart(PPSPlacementView.this.f36865H);
                PPSPlacementView.this.m49446s();
            }
        };
        this.f36892ak = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int duration;
                C7304g currentAd = PPSPlacementView.this.getCurrentAd();
                PlacementMediaFile currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String url = "";
                String contentId = currentAd != null ? currentAd.getContentId() : "";
                if (currentMediaFile != null) {
                    url = currentMediaFile.getUrl();
                    duration = (int) currentMediaFile.getDuration();
                } else {
                    duration = 0;
                }
                AbstractC7185ho.m43821b("PPSPlacementView", "callback timeout: %s", contentId);
                if (PPSPlacementView.this.f36859B == null) {
                    return true;
                }
                AbstractC7185ho.m43820b("PPSPlacementView", "notify Error");
                PPSPlacementView.this.m49391a(contentId, url, duration);
                return true;
            }
        });
        this.f36893al = new SegmentMediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaCompletion(String str, String str2, int i10) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    AbstractC7185ho.m43820b("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                    return;
                }
                if (PPSPlacementView.this.f36877T) {
                    return;
                }
                PPSPlacementView.this.f36877T = true;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45620g();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaError(String str, String str2, int i10, int i11, int i12) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaPause(String str, String str2, int i10) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.f36859B instanceof C8066aa)) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45624k();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaStart(String str, String str2, int i10) {
                PPSPlacementView pPSPlacementView;
                InterfaceC7416lz interfaceC7416lz;
                InterfaceC7416lz interfaceC7416lz2;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.f36877T = false;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST);
                    if (i10 > 0) {
                        if (zIsState) {
                            interfaceC7416lz2 = PPSPlacementView.this.f36898c;
                        } else {
                            boolean zIsState2 = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                            PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                            interfaceC7416lz2 = zIsState2 ? pPSPlacementView2.f36881a : pPSPlacementView2.f36897b;
                        }
                        interfaceC7416lz2.mo45625l();
                        return;
                    }
                    if (zIsState) {
                        pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = pPSPlacementView.f36898c;
                    } else {
                        boolean zIsState3 = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState3 ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    pPSPlacementView.m49379a(interfaceC7416lz);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaStop(String str, String str2, int i10) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    AbstractC7185ho.m43820b("PPSPlacementView", "OM onSegmentMediaStop not equals");
                    return;
                }
                if (PPSPlacementView.this.f36877T) {
                    return;
                }
                PPSPlacementView.this.f36877T = true;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45620g();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentProgress(String str, String str2, int i10, int i11) {
                InterfaceC7416lz interfaceC7416lz;
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.f36877T && (PPSPlacementView.this.f36859B instanceof C8066aa)) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45605a(i10);
                }
            }
        };
        this.f36894am = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AbstractC7185ho.m43817a("PPSPlacementView", "clickable.OnTouchListener.ontouch");
                try {
                    int iM47282a = C7694tp.m47282a(motionEvent);
                    if (iM47282a == 0) {
                        PPSPlacementView.this.f36901f = C7694tp.m47283a(view, motionEvent);
                        PPSPlacementView.this.f36901f.m44505a(C8190vl.m50727b(PPSPlacementView.this));
                    }
                    if (1 != iM47282a) {
                        return false;
                    }
                    C7694tp.m47284a(view, motionEvent, null, PPSPlacementView.this.f36901f);
                    return false;
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("PPSPlacementView", "clickable.OnTouchListener.ontouch exception : %s", th2.getClass().getSimpleName());
                    return false;
                }
            }
        };
        this.f36895an = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.m49423g();
                    }
                });
            }
        };
        this.f36896ao = new C8003a(this);
        m49375a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m49408c() {
        if (this.f36867J) {
            return;
        }
        this.f36867J = true;
        this.f36904i.m46160b();
    }

    /* renamed from: d */
    private void m49414d(InterfaceC7416lz interfaceC7416lz) {
        List<View> list;
        InterfaceC7474mi interfaceC7474miMo45604a = interfaceC7416lz.mo45604a();
        if (interfaceC7474miMo45604a == null || (list = this.f36860C) == null || list.size() <= 0) {
            return;
        }
        Iterator<View> it = this.f36860C.iterator();
        while (it.hasNext()) {
            interfaceC7474miMo45604a.mo45609a(it.next(), EnumC7473mh.OTHER, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m49420f() {
        String strValueOf = String.valueOf(this.f36878U);
        this.f36902g = strValueOf;
        this.f36904i.mo45318a(strValueOf);
        this.f36904i.m45313a(this.f36878U);
        PlacementMediaView placementMediaView = this.f36916u;
        if (placementMediaView != null) {
            placementMediaView.mo49812a(this.f36902g);
            this.f36916u.mo49805a(this.f36878U);
        }
        PlacementMediaView placementMediaView2 = this.f36914s;
        if (placementMediaView2 != null) {
            placementMediaView2.mo49812a(this.f36902g);
            this.f36914s.mo49805a(this.f36878U);
        }
        PlacementMediaView placementMediaView3 = this.f36915t;
        if (placementMediaView3 != null) {
            placementMediaView3.mo49812a(this.f36902g);
            this.f36915t.mo49805a(this.f36878U);
        }
        List<C7304g> list = this.f36906k;
        if (list != null) {
            Iterator<C7304g> it = list.iterator();
            while (it.hasNext()) {
                it.next().m44642h(this.f36902g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m49423g() {
        if (this.f36903h) {
            C7730ad.m47436b();
            this.f36903h = false;
            AbstractC7185ho.m43820b("PPSPlacementView", "onClick");
            mo49458a((Integer) 1);
            if (this.f36875R == null) {
                this.f36875R = this.f36901f;
            }
            if (this.f36887af != null) {
                AbstractC7185ho.m43818a("PPSPlacementView", "actualIndex %s", Integer.valueOf(this.f36890ai));
                InterfaceC7342jp interfaceC7342jp = this.f36887af.get(this.f36890ai - 1);
                if (interfaceC7342jp != null) {
                    interfaceC7342jp.mo45351a();
                }
                if (interfaceC7342jp instanceof C7341jo) {
                    this.f36904i.m45317a((InterfaceC7615qq) null);
                } else {
                    this.f36904i.m45317a(this.f36889ah.get(this.f36890ai - 1));
                }
            }
            this.f36904i.m46157a(this.f36875R);
            this.f36901f = null;
            this.f36875R = null;
            m49403b(this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST) ? this.f36898c : this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW) ? this.f36881a : this.f36897b);
            OnPlacementAdClickListener onPlacementAdClickListener = this.f36910o;
            if (onPlacementAdClickListener != null) {
                onPlacementAdClickListener.onClick();
            }
            AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.2
                @Override // java.lang.Runnable
                public void run() {
                    PPSPlacementView.this.f36903h = true;
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m49426h() {
        List<View> list = this.f36911p;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<View> it = this.f36911p.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(null);
        }
        setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m49428i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.f36911p = arrayList;
        m49404b(arrayList);
    }

    /* renamed from: k */
    private boolean m49432k() {
        return this.f36909n == this.f36906k.size() - 1;
    }

    /* renamed from: l */
    private void m49434l() {
        C7699tu c7699tu = this.f36886ae;
        if (c7699tu != null) {
            removeView(c7699tu);
            this.f36886ae = null;
        }
    }

    /* renamed from: n */
    private void m49438n() {
        PlacementMediaView placementMediaView;
        AbstractC7185ho.m43820b("PPSPlacementView", "showNextAd");
        C7304g nextAd = getNextAd();
        if (nextAd != null) {
            this.f36905j.m45276b(nextAd.getMinEffectiveShowTime(), nextAd.getMinEffectiveShowRatio());
        }
        this.f36904i.m46158a(nextAd);
        this.f36904i.m45321e();
        PlacementPlayState placementPlayState = this.f36885ad;
        PlacementPlayState.State state = PlacementPlayState.State.SINGLE_INST;
        if (placementPlayState.isState(state)) {
            this.f36916u = m49400b(this.f36916u, nextAd);
            m49377a(new PlacementPlayState(state), nextAd, this.f36916u);
            m49388a(this.f36916u);
        } else {
            if (Math.abs(this.f36914s.getAlpha() - 1.0f) < 0.01f) {
                this.f36885ad.switchToState(PlacementPlayState.State.BACKUP_VIEW);
                m49388a(this.f36915t);
                placementMediaView = this.f36914s;
            } else {
                this.f36885ad.switchToState(PlacementPlayState.State.MAIN_VIEW);
                m49388a(this.f36914s);
                placementMediaView = this.f36915t;
            }
            m49389a(placementMediaView, false);
        }
        this.f36905j.m45305l();
        AbstractC7185ho.m43820b("PPSPlacementView", "show " + this.f36909n + " ad");
    }

    /* renamed from: q */
    private void m49443q() {
        if (this.f36870M == null) {
            return;
        }
        try {
            AbstractC7185ho.m43820b("PPSPlacementView", "showLastFrame");
            this.f36871N = false;
            this.f36870M.setVisibility(0);
            this.f36870M.setScaleType(ImageView.ScaleType.FIT_CENTER);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.f36870M, layoutParams);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("PPSPlacementView", "showLastFrame error.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m49445r() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.15
            @Override // java.lang.Runnable
            public void run() {
                if (PPSPlacementView.this.f36870M == null) {
                    return;
                }
                try {
                    AbstractC7185ho.m43820b("PPSPlacementView", "hide last frame.");
                    PPSPlacementView.this.f36870M.setVisibility(8);
                    PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                    pPSPlacementView.removeView(pPSPlacementView.f36870M);
                    PPSPlacementView.this.f36870M = null;
                    PPSPlacementView.this.f36871N = true;
                } catch (Throwable unused) {
                    AbstractC7185ho.m43823c("PPSPlacementView", "hideLastFrame error.");
                }
            }
        });
    }

    /* renamed from: u */
    private boolean m49451u() {
        AbstractC7185ho.m43821b("PPSPlacementView", "isNeedAudioFocus type: %s soundMute: %s", Integer.valueOf(this.f36869L), Boolean.valueOf(this.f36861D));
        int i10 = this.f36869L;
        if (i10 == 0) {
            return true;
        }
        if (i10 == 2) {
            return false;
        }
        return (i10 == 1 && this.f36861D) ? false : true;
    }

    /* renamed from: v */
    private void m49453v() {
        if (isTransparencyDialogVisible()) {
            this.f36886ae.m47330k();
        }
    }

    @OuterVisible
    public void register(final List<IPlacementAd> list, final List<View> list2) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.19
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("register:");
                List list3 = list;
                sb2.append(list3 == null ? 0 : list3.size());
                AbstractC7185ho.m43820b("PPSPlacementView", sb2.toString());
                PPSPlacementView.this.m49393a((List<IPlacementAd>) list);
                if (AbstractC7760bg.m47767a(list) || AbstractC7760bg.m47767a(PPSPlacementView.this.f36906k)) {
                    return;
                }
                PPSPlacementView.this.getMonitor();
                PPSPlacementView.this.f36909n = 0;
                PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                pPSPlacementView.f36907l = pPSPlacementView.getCurrentAd();
                PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                pPSPlacementView2.f36908m = pPSPlacementView2.getNextAd();
                PPSPlacementView.this.m49416e();
                PPSPlacementView.this.f36911p = list2;
                PPSPlacementView.this.m49404b((List<View>) list2);
                PlacementMediaView placementMediaView = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST) ? PPSPlacementView.this.f36916u : PPSPlacementView.this.f36914s;
                PPSPlacementView.this.m49420f();
                PPSPlacementView.this.m49388a(placementMediaView);
                if (PPSPlacementView.this.f36868K) {
                    PPSPlacementView.this.m49408c();
                }
            }
        });
    }

    @OuterVisible
    public void showTransparencyDialog(View view, int[] iArr) {
        if (view == null) {
            AbstractC7185ho.m43823c("PPSPlacementView", "anchorView is null");
        }
        try {
            C7304g currentAd = getCurrentAd();
            if (currentAd == null) {
                AbstractC7185ho.m43823c("PPSPlacementView", "adInfo is null");
                return;
            }
            ContentRecord contentRecordM46766a = C7575pi.m46766a(currentAd);
            if (C7845x.m48605t(getContext())) {
                m49376a(view, contentRecordM46766a, iArr);
            } else if (m49397a(iArr)) {
                C6980bx.m41133a(getContext(), view, iArr, contentRecordM46766a);
            } else {
                C6980bx.m41131a(getContext(), view, contentRecordM46766a);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSPlacementView", "showTransparencyDialog has exception %s", th2.getClass().getSimpleName());
        }
    }

    @OuterVisible
    public PPSPlacementView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36881a = new C7405lo();
        this.f36897b = new C7405lo();
        this.f36898c = new C7405lo();
        this.f36903h = true;
        this.f36906k = new ArrayList(4);
        this.f36909n = 0;
        this.f36912q = false;
        this.f36913r = false;
        this.f36917v = null;
        this.f36918w = null;
        this.f36919x = null;
        this.f36920y = null;
        this.f36921z = null;
        this.f36858A = null;
        this.f36861D = false;
        this.f36863F = false;
        this.f36864G = -1;
        this.f36865H = -1;
        this.f36866I = -1L;
        this.f36867J = false;
        this.f36868K = false;
        this.f36869L = -1;
        this.f36870M = null;
        this.f36871N = false;
        this.f36872O = false;
        this.f36873P = false;
        this.f36874Q = false;
        this.f36899d = -1;
        this.f36900e = -1;
        this.f36880W = 0;
        this.f36882aa = false;
        this.f36885ad = new PlacementPlayState();
        this.f36888ag = new AtomicBoolean();
        this.f36889ah = new ArrayList();
        this.f36890ai = 0;
        this.f36891aj = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                AbstractC7185ho.m43820b("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.m49445r();
                if (!PPSPlacementView.this.f36872O || PPSPlacementView.this.f36920y == null) {
                    return;
                }
                PPSPlacementView.this.f36872O = false;
                PPSPlacementView.this.f36873P = true;
                AbstractC7185ho.m43821b("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.f36865H));
                PPSPlacementView.this.f36920y.onMediaStart(PPSPlacementView.this.f36865H);
                PPSPlacementView.this.m49446s();
            }
        };
        this.f36892ak = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int duration;
                C7304g currentAd = PPSPlacementView.this.getCurrentAd();
                PlacementMediaFile currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String url = "";
                String contentId = currentAd != null ? currentAd.getContentId() : "";
                if (currentMediaFile != null) {
                    url = currentMediaFile.getUrl();
                    duration = (int) currentMediaFile.getDuration();
                } else {
                    duration = 0;
                }
                AbstractC7185ho.m43821b("PPSPlacementView", "callback timeout: %s", contentId);
                if (PPSPlacementView.this.f36859B == null) {
                    return true;
                }
                AbstractC7185ho.m43820b("PPSPlacementView", "notify Error");
                PPSPlacementView.this.m49391a(contentId, url, duration);
                return true;
            }
        });
        this.f36893al = new SegmentMediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaCompletion(String str, String str2, int i102) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    AbstractC7185ho.m43820b("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                    return;
                }
                if (PPSPlacementView.this.f36877T) {
                    return;
                }
                PPSPlacementView.this.f36877T = true;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45620g();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaError(String str, String str2, int i102, int i11, int i12) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaPause(String str, String str2, int i102) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.f36859B instanceof C8066aa)) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45624k();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaStart(String str, String str2, int i102) {
                PPSPlacementView pPSPlacementView;
                InterfaceC7416lz interfaceC7416lz;
                InterfaceC7416lz interfaceC7416lz2;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.f36877T = false;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST);
                    if (i102 > 0) {
                        if (zIsState) {
                            interfaceC7416lz2 = PPSPlacementView.this.f36898c;
                        } else {
                            boolean zIsState2 = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                            PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                            interfaceC7416lz2 = zIsState2 ? pPSPlacementView2.f36881a : pPSPlacementView2.f36897b;
                        }
                        interfaceC7416lz2.mo45625l();
                        return;
                    }
                    if (zIsState) {
                        pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = pPSPlacementView.f36898c;
                    } else {
                        boolean zIsState3 = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState3 ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    pPSPlacementView.m49379a(interfaceC7416lz);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaStop(String str, String str2, int i102) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    AbstractC7185ho.m43820b("PPSPlacementView", "OM onSegmentMediaStop not equals");
                    return;
                }
                if (PPSPlacementView.this.f36877T) {
                    return;
                }
                PPSPlacementView.this.f36877T = true;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45620g();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentProgress(String str, String str2, int i102, int i11) {
                InterfaceC7416lz interfaceC7416lz;
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.f36877T && (PPSPlacementView.this.f36859B instanceof C8066aa)) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45605a(i102);
                }
            }
        };
        this.f36894am = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AbstractC7185ho.m43817a("PPSPlacementView", "clickable.OnTouchListener.ontouch");
                try {
                    int iM47282a = C7694tp.m47282a(motionEvent);
                    if (iM47282a == 0) {
                        PPSPlacementView.this.f36901f = C7694tp.m47283a(view, motionEvent);
                        PPSPlacementView.this.f36901f.m44505a(C8190vl.m50727b(PPSPlacementView.this));
                    }
                    if (1 != iM47282a) {
                        return false;
                    }
                    C7694tp.m47284a(view, motionEvent, null, PPSPlacementView.this.f36901f);
                    return false;
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("PPSPlacementView", "clickable.OnTouchListener.ontouch exception : %s", th2.getClass().getSimpleName());
                    return false;
                }
            }
        };
        this.f36895an = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.m49423g();
                    }
                });
            }
        };
        this.f36896ao = new C8003a(this);
        m49375a(context);
    }

    /* renamed from: b */
    private PlacementMediaView m49400b(PlacementMediaView placementMediaView, C7304g c7304g) {
        if (c7304g == null) {
            return null;
        }
        AbstractC7185ho.m43818a("PPSPlacementView", "init media view for content:%s", c7304g.getContentId());
        boolean z10 = false;
        if (m49396a(placementMediaView, c7304g)) {
            m49389a(placementMediaView, false);
        } else {
            m49389a(placementMediaView, true);
            placementMediaView = null;
        }
        if (placementMediaView == null) {
            placementMediaView = m49372a(c7304g);
            z10 = true;
        }
        if (placementMediaView != null) {
            AbstractC7185ho.m43820b("PPSPlacementView", "meida view created");
            placementMediaView.mo49820b((SegmentMediaStateListener) this);
            MediaBufferListener mediaBufferListener = this.f36917v;
            if (mediaBufferListener != null) {
                placementMediaView.mo49806a(mediaBufferListener);
            }
            PPSVideoRenderListener pPSVideoRenderListener = this.f36891aj;
            if (pPSVideoRenderListener != null) {
                placementMediaView.mo49810a(pPSVideoRenderListener);
            }
            MuteListener muteListener = this.f36918w;
            if (muteListener != null) {
                placementMediaView.mo49809a(muteListener);
            }
            placementMediaView.mo49809a((MuteListener) this);
            MediaErrorListener mediaErrorListener = this.f36919x;
            if (mediaErrorListener != null) {
                placementMediaView.mo49807a(mediaErrorListener);
            }
            SegmentMediaStateListener segmentMediaStateListener = this.f36893al;
            if (segmentMediaStateListener != null) {
                placementMediaView.mo49811a(segmentMediaStateListener);
            }
            if (z10) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                addView(placementMediaView, layoutParams);
            }
            placementMediaView.setAlpha(0.0f);
            placementMediaView.setPlacementAd(c7304g);
            placementMediaView.setAudioFocusType(2);
        }
        return placementMediaView;
    }

    /* renamed from: c */
    private void m49409c(long j10, int i10) {
        C7304g currentAd = getCurrentAd();
        if (currentAd != null) {
            Integer numM44659q = currentAd.m44659q();
            if (currentAd.isVideoAd()) {
                if (numM44659q == null || numM44659q.intValue() == 0 || 1 == numM44659q.intValue()) {
                    if (this.f36912q || j10 <= currentAd.getMinEffectiveShowTime()) {
                        return;
                    }
                    this.f36912q = true;
                    AbstractC7185ho.m43821b("PPSPlacementView", "reportAdShowEvent, customExposureType： %s", numM44659q);
                } else {
                    if (2 != numM44659q.intValue() || currentAd.m44661r() == null || this.f36912q || this.f36864G < currentAd.m44661r().intValue()) {
                        return;
                    }
                    this.f36912q = true;
                    AbstractC7185ho.m43821b("PPSPlacementView", "reportAdShowEvent, customExposureType： %s", numM44659q);
                }
            } else if (this.f36912q || j10 <= currentAd.getMinEffectiveShowTime()) {
                return;
            } else {
                this.f36912q = true;
            }
            m49390a(Long.valueOf(j10), Integer.valueOf(i10), (Integer) null);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8113f
    /* renamed from: d */
    public boolean mo49351d() {
        C7331je c7331je = this.f36905j;
        if (c7331je != null) {
            return c7331je.m45307n();
        }
        return false;
    }

    @OuterVisible
    @TargetApi(21)
    public PPSPlacementView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f36881a = new C7405lo();
        this.f36897b = new C7405lo();
        this.f36898c = new C7405lo();
        this.f36903h = true;
        this.f36906k = new ArrayList(4);
        this.f36909n = 0;
        this.f36912q = false;
        this.f36913r = false;
        this.f36917v = null;
        this.f36918w = null;
        this.f36919x = null;
        this.f36920y = null;
        this.f36921z = null;
        this.f36858A = null;
        this.f36861D = false;
        this.f36863F = false;
        this.f36864G = -1;
        this.f36865H = -1;
        this.f36866I = -1L;
        this.f36867J = false;
        this.f36868K = false;
        this.f36869L = -1;
        this.f36870M = null;
        this.f36871N = false;
        this.f36872O = false;
        this.f36873P = false;
        this.f36874Q = false;
        this.f36899d = -1;
        this.f36900e = -1;
        this.f36880W = 0;
        this.f36882aa = false;
        this.f36885ad = new PlacementPlayState();
        this.f36888ag = new AtomicBoolean();
        this.f36889ah = new ArrayList();
        this.f36890ai = 0;
        this.f36891aj = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                AbstractC7185ho.m43820b("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.m49445r();
                if (!PPSPlacementView.this.f36872O || PPSPlacementView.this.f36920y == null) {
                    return;
                }
                PPSPlacementView.this.f36872O = false;
                PPSPlacementView.this.f36873P = true;
                AbstractC7185ho.m43821b("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.f36865H));
                PPSPlacementView.this.f36920y.onMediaStart(PPSPlacementView.this.f36865H);
                PPSPlacementView.this.m49446s();
            }
        };
        this.f36892ak = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int duration;
                C7304g currentAd = PPSPlacementView.this.getCurrentAd();
                PlacementMediaFile currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String url = "";
                String contentId = currentAd != null ? currentAd.getContentId() : "";
                if (currentMediaFile != null) {
                    url = currentMediaFile.getUrl();
                    duration = (int) currentMediaFile.getDuration();
                } else {
                    duration = 0;
                }
                AbstractC7185ho.m43821b("PPSPlacementView", "callback timeout: %s", contentId);
                if (PPSPlacementView.this.f36859B == null) {
                    return true;
                }
                AbstractC7185ho.m43820b("PPSPlacementView", "notify Error");
                PPSPlacementView.this.m49391a(contentId, url, duration);
                return true;
            }
        });
        this.f36893al = new SegmentMediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaCompletion(String str, String str2, int i102) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    AbstractC7185ho.m43820b("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                    return;
                }
                if (PPSPlacementView.this.f36877T) {
                    return;
                }
                PPSPlacementView.this.f36877T = true;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45620g();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaError(String str, String str2, int i102, int i112, int i12) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaPause(String str, String str2, int i102) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.f36859B instanceof C8066aa)) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45624k();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaStart(String str, String str2, int i102) {
                PPSPlacementView pPSPlacementView;
                InterfaceC7416lz interfaceC7416lz;
                InterfaceC7416lz interfaceC7416lz2;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.f36877T = false;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST);
                    if (i102 > 0) {
                        if (zIsState) {
                            interfaceC7416lz2 = PPSPlacementView.this.f36898c;
                        } else {
                            boolean zIsState2 = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                            PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                            interfaceC7416lz2 = zIsState2 ? pPSPlacementView2.f36881a : pPSPlacementView2.f36897b;
                        }
                        interfaceC7416lz2.mo45625l();
                        return;
                    }
                    if (zIsState) {
                        pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = pPSPlacementView.f36898c;
                    } else {
                        boolean zIsState3 = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState3 ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    pPSPlacementView.m49379a(interfaceC7416lz);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentMediaStop(String str, String str2, int i102) {
                InterfaceC7416lz interfaceC7416lz;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43817a("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    AbstractC7185ho.m43820b("PPSPlacementView", "OM onSegmentMediaStop not equals");
                    return;
                }
                if (PPSPlacementView.this.f36877T) {
                    return;
                }
                PPSPlacementView.this.f36877T = true;
                if (PPSPlacementView.this.f36859B instanceof C8066aa) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45620g();
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
            public void onSegmentProgress(String str, String str2, int i102, int i112) {
                InterfaceC7416lz interfaceC7416lz;
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.f36877T && (PPSPlacementView.this.f36859B instanceof C8066aa)) {
                    if (PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST)) {
                        interfaceC7416lz = PPSPlacementView.this.f36898c;
                    } else {
                        boolean zIsState = PPSPlacementView.this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW);
                        PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                        interfaceC7416lz = zIsState ? pPSPlacementView.f36881a : pPSPlacementView.f36897b;
                    }
                    interfaceC7416lz.mo45605a(i102);
                }
            }
        };
        this.f36894am = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AbstractC7185ho.m43817a("PPSPlacementView", "clickable.OnTouchListener.ontouch");
                try {
                    int iM47282a = C7694tp.m47282a(motionEvent);
                    if (iM47282a == 0) {
                        PPSPlacementView.this.f36901f = C7694tp.m47283a(view, motionEvent);
                        PPSPlacementView.this.f36901f.m44505a(C8190vl.m50727b(PPSPlacementView.this));
                    }
                    if (1 != iM47282a) {
                        return false;
                    }
                    C7694tp.m47284a(view, motionEvent, null, PPSPlacementView.this.f36901f);
                    return false;
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("PPSPlacementView", "clickable.OnTouchListener.ontouch exception : %s", th2.getClass().getSimpleName());
                    return false;
                }
            }
        };
        this.f36895an = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.m49423g();
                    }
                });
            }
        };
        this.f36896ao = new C8003a(this);
        m49375a(context);
    }

    /* renamed from: c */
    private void m49410c(InterfaceC7416lz interfaceC7416lz) {
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45618e();
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: b */
    public void mo45281b() {
        this.f36868K = true;
        this.f36912q = false;
        this.f36913r = false;
        long jM47566c = AbstractC7741ao.m47566c();
        this.f36878U = jM47566c;
        AbstractC7185ho.m43818a("PPSPlacementView", "onViewPhysicalShowStart: %s", Long.valueOf(jM47566c));
        C7304g currentAd = getCurrentAd();
        if (currentAd != null && (!currentAd.isVideoAd() || currentAd.m44659q() == null || currentAd.m44659q().intValue() == 0)) {
            currentAd.m44894g(false);
            currentAd.m44612a(false);
        }
        m49420f();
        if (this.f36907l != null) {
            m49408c();
            (this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST) ? this.f36898c : this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW) ? this.f36881a : this.f36897b).mo45619f();
        }
    }

    /* renamed from: a */
    private InterfaceC7416lz m49371a(PlacementPlayState placementPlayState) {
        if (placementPlayState.isState(PlacementPlayState.State.SINGLE_INST)) {
            this.f36898c.mo45613b();
            C7405lo c7405lo = new C7405lo();
            this.f36898c = c7405lo;
            return c7405lo;
        }
        if (placementPlayState.isState(PlacementPlayState.State.MAIN_VIEW)) {
            this.f36881a.mo45613b();
            C7405lo c7405lo2 = new C7405lo();
            this.f36881a = c7405lo2;
            return c7405lo2;
        }
        this.f36897b.mo45613b();
        C7405lo c7405lo3 = new C7405lo();
        this.f36897b = c7405lo3;
        return c7405lo3;
    }

    /* renamed from: b */
    private void m49402b(int i10) {
        int i11;
        if (this.f36863F && (i11 = this.f36865H) >= 0) {
            this.f36866I = i10 - i11;
            this.f36863F = false;
        }
        this.f36865H = -1;
    }

    /* renamed from: a */
    private PlacementMediaView m49372a(C7304g c7304g) {
        if (c7304g == null) {
            AbstractC7185ho.m43823c("PPSPlacementView", "create media view with null ad");
            return null;
        }
        AbstractC7185ho.m43818a("PPSPlacementView", "create media view for content:%s", c7304g.getContentId());
        if (c7304g.isVideoAd()) {
            AbstractC7185ho.m43820b("PPSPlacementView", "create video view");
            return new C8066aa(getContext());
        }
        if (c7304g.isImageAd()) {
            AbstractC7185ho.m43820b("PPSPlacementView", "create image view");
            return new C8187z(getContext());
        }
        AbstractC7185ho.m43820b("PPSPlacementView", "return image view for default");
        return new C8187z(getContext());
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: b */
    public void mo45282b(long j10, int i10) {
        if (!this.f36913r) {
            this.f36913r = true;
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSPlacementView", "onAdPhyShow  duration: %s  maxShowRatio: %s  playedTime: %s  playedProgress: %s", Long.valueOf(j10), Integer.valueOf(i10), Integer.valueOf(this.f36899d), Integer.valueOf(this.f36900e));
            }
            C7304g currentAd = getCurrentAd();
            if (currentAd != null && currentAd.isVideoAd() && this.f36899d <= 0) {
                this.f36899d = 0;
                this.f36900e = 0;
            }
            this.f36904i.m45314a(j10, i10, this.f36899d, this.f36900e);
        }
        this.f36868K = false;
        this.f36867J = false;
    }

    /* renamed from: b */
    private void m49403b(InterfaceC7416lz interfaceC7416lz) {
        if (interfaceC7416lz != null) {
            interfaceC7416lz.mo45610a(EnumC7480mo.CLICK);
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: a */
    public void mo45279a() {
        this.f36865H = -1;
        this.f36864G = -1;
        this.f36863F = false;
    }

    /* renamed from: a */
    private void m49373a(int i10) {
        IPlacementMediaStateListener iPlacementMediaStateListener;
        if (i10 > 0 && !this.f36871N) {
            m49445r();
        }
        if (i10 <= 0 || !this.f36872O || (iPlacementMediaStateListener = this.f36920y) == null) {
            return;
        }
        this.f36872O = false;
        this.f36873P = true;
        iPlacementMediaStateListener.onMediaStart(this.f36865H);
        m49446s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m49404b(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof C8066aa) {
                ((C8066aa) view).setOnClickListener(this.f36895an);
            } else {
                view.setOnClickListener(this.f36895an);
                view.setOnTouchListener(this.f36894am);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49374a(long j10) {
        if (this.f36874Q) {
            return;
        }
        this.f36874Q = true;
        AbstractC7185ho.m43821b("PPSPlacementView", "timeout, submit: %s", Long.valueOf(j10));
        this.f36892ak.sendEmptyMessageDelayed(1001, j10);
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: a */
    public void mo45280a(long j10, int i10) {
        C7304g currentAd = getCurrentAd();
        if (currentAd != null) {
            Integer numM44659q = currentAd.m44659q();
            if (!currentAd.isVideoAd() || numM44659q == null || numM44659q.intValue() == 0) {
                m49409c(this.f36866I, i10);
            }
        }
    }

    /* renamed from: a */
    private void m49375a(Context context) {
        setBackgroundColor(-16777216);
        setUseRatioInMatchParentMode(false);
        this.f36904i = new C7518nm(context, this);
        this.f36905j = new C7331je(this, this);
        this.f36862E = new C6922c(context);
        this.f36876S = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        this.f36883ab = (AudioManager) context.getSystemService("audio");
        this.f36885ad.switchToState(C7124fh.m43316b(context).mo43434ce() ? PlacementPlayState.State.SINGLE_INST : PlacementPlayState.State.MAIN_VIEW);
    }

    /* renamed from: a */
    private void m49376a(View view, ContentRecord contentRecord, int[] iArr) {
        int[] iArrM48312b = AbstractC7811dd.m48312b(view);
        int[] iArrM48318c = AbstractC7811dd.m48318c(view);
        if (!m49397a(iArr)) {
            iArr = iArrM48312b;
        }
        C7699tu c7699tu = new C7699tu(getContext(), iArr, iArrM48318c, Boolean.TRUE);
        this.f36886ae = c7699tu;
        m49378a(contentRecord, c7699tu, iArr, iArrM48318c);
    }

    /* renamed from: a */
    private void m49377a(PlacementPlayState placementPlayState, IAd iAd, PlacementMediaView placementMediaView) {
        if (iAd instanceof C7304g) {
            ContentRecord contentRecordM46766a = C7575pi.m46766a((C7304g) iAd);
            InterfaceC7416lz interfaceC7416lzM49371a = m49371a(placementPlayState);
            interfaceC7416lzM49371a.mo45607a(getContext(), contentRecordM46766a, placementMediaView, true);
            m49414d(interfaceC7416lzM49371a);
            interfaceC7416lzM49371a.mo45616c();
            m49380a(interfaceC7416lzM49371a, placementMediaView);
        }
    }

    /* renamed from: a */
    private void m49378a(ContentRecord contentRecord, C7699tu c7699tu, int[] iArr, int[] iArr2) {
        if (contentRecord == null || !contentRecord.m41517bd() || AbstractC7806cz.m48165b(contentRecord.m41516bc())) {
            AbstractC7185ho.m43820b("PPSPlacementView", "addTransparencyDialog failed, switch close or empty url.");
            return;
        }
        if (AbstractC7741ao.m47556a(iArr, 2) && AbstractC7741ao.m47556a(iArr2, 2)) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSPlacementView", "addTransparencyDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                AbstractC7185ho.m43818a("PPSPlacementView", "addTransparencyDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            AbstractC7185ho.m43820b("PPSPlacementView", "添加弹框view");
            addView(c7699tu, layoutParams);
            contentRecord.m41610u(AbstractC7806cz.m48168c(contentRecord.m41476aa()));
            c7699tu.setScreenWidth(getMeasuredWidth());
            c7699tu.setScreenHeight(getMeasuredHeight());
            c7699tu.setAdContent(contentRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49379a(InterfaceC7416lz interfaceC7416lz) {
        if (interfaceC7416lz == null || getCurrentAd() == null || getCurrentAd().getMediaFile() == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSPlacementView", "om start");
        interfaceC7416lz.mo45606a(getCurrentAd().getMediaFile().getDuration(), !"y".equals(getCurrentAd().getMediaFile().getSoundSwitch()));
    }

    /* renamed from: a */
    private void m49380a(InterfaceC7416lz interfaceC7416lz, PlacementMediaView placementMediaView) {
        if (placementMediaView instanceof C8066aa) {
            interfaceC7416lz.mo45611a(C7482mq.m45849a(0.0f, true, EnumC7481mp.STANDALONE));
            ((C8066aa) placementMediaView).m49988a(interfaceC7416lz);
        } else if (placementMediaView instanceof C8187z) {
            interfaceC7416lz.mo45619f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49388a(PlacementMediaView placementMediaView) {
        if (placementMediaView == null) {
            AbstractC7185ho.m43823c("PPSPlacementView", "show ad with null media view");
            return;
        }
        InterfaceC7342jp interfaceC7342jp = this.f36887af.get(this.f36890ai);
        int i10 = this.f36890ai;
        if (i10 > 0 && i10 < this.f36887af.size()) {
            this.f36887af.get(this.f36890ai - 1).mo45354b();
        }
        interfaceC7342jp.mo45352a(placementMediaView);
        if (placementMediaView instanceof C8066aa) {
            interfaceC7342jp.mo45353a(placementMediaView.getVideoView());
        }
        this.f36890ai++;
        this.f36866I = -1L;
        AbstractC7185ho.m43818a("PPSPlacementView", "showAd:%d", Integer.valueOf(this.f36909n));
        this.f36859B = placementMediaView;
        placementMediaView.setAlpha(1.0f);
        placementMediaView.mo49813a(true, this.f36861D);
        if (!isShown()) {
            AbstractC7185ho.m43823c("PPSPlacementView", "view not visible, pause.");
            pauseView();
        }
        m49374a(placementMediaView.getDuration() * 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49389a(final PlacementMediaView placementMediaView, boolean z10) {
        if (placementMediaView != null) {
            IPlacementAd placementAd = placementMediaView.getPlacementAd();
            AbstractC7185ho.m43821b("PPSPlacementView", "unloadMediaView, contentId: %s, remove: %s", placementAd != null ? placementAd.getContentId() : null, Boolean.valueOf(z10));
            placementMediaView.mo49827g();
            placementMediaView.setPlacementAd(null);
            final ViewParent parent = placementMediaView.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                return;
            }
            placementMediaView.setAlpha(0.0f);
            if (z10) {
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.20
                    @Override // java.lang.Runnable
                    public void run() {
                        PlacementMediaView placementMediaView2 = placementMediaView;
                        if (placementMediaView2 != null) {
                            placementMediaView2.mo49803a();
                        }
                        ViewParent viewParent = parent;
                        if (viewParent != null) {
                            ((ViewGroup) viewParent).removeView(placementMediaView);
                        }
                    }
                });
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IPPSPlacementView
    /* renamed from: a */
    public void mo49458a(Integer num) {
        m49390a(Long.valueOf(System.currentTimeMillis() - this.f36905j.m45278d()), Integer.valueOf(this.f36905j.m45277c()), num);
    }

    /* renamed from: a */
    private void m49390a(Long l10, Integer num, Integer num2) {
        C7304g currentAd = getCurrentAd();
        this.f36904i.mo45318a(AbstractC7806cz.m48153a(Long.valueOf(this.f36878U)));
        this.f36904i.m45313a(this.f36878U);
        if (currentAd == null) {
            return;
        }
        boolean zM47867a = C7780c.m47867a(currentAd.m44627d(), num2);
        if (!currentAd.m44876F() || (zM47867a && !currentAd.m44619b())) {
            AbstractC7185ho.m43820b("PPSPlacementView", "reportAdShowEvent, customExposureType： real onAdShow");
            this.f36904i.m46156a(l10.longValue(), num.intValue(), num2);
            if (zM47867a) {
                currentAd.m44612a(true);
            }
            if (currentAd.m44876F()) {
                return;
            }
            currentAd.m44894g(true);
            m49410c(this.f36885ad.isState(PlacementPlayState.State.SINGLE_INST) ? this.f36898c : this.f36885ad.isState(PlacementPlayState.State.MAIN_VIEW) ? this.f36881a : this.f36897b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49391a(final String str, final String str2, final int i10) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.16
            @Override // java.lang.Runnable
            public void run() {
                PPSPlacementView.this.onSegmentMediaError(str, str2, i10, -1, -1);
            }
        });
    }

    /* renamed from: a */
    private void m49392a(String str, String str2, int i10, C7304g c7304g) {
        if (c7304g != null && c7304g.m44659q() != null) {
            Integer numM44659q = c7304g.m44659q();
            if (c7304g.isVideoAd() && !c7304g.m44876F() && (numM44659q.intValue() == 1 || numM44659q.intValue() == 2)) {
                AbstractC7185ho.m43821b("PPSPlacementView", "reportAdShowEvent Media Over Completion reportAdShowEvent by customExposureType: %s", numM44659q);
                mo49458a((Integer) null);
            }
        }
        this.f36859B.mo49827g();
        SegmentMediaStateListener segmentMediaStateListener = this.f36893al;
        if (segmentMediaStateListener != null) {
            segmentMediaStateListener.onSegmentMediaCompletion(str, str2, i10);
        }
        onSegmentMediaCompletion(str, str2, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49393a(List<IPlacementAd> list) {
        PlacementMediaFile mediaFile;
        PlacementMediaFile mediaFile2;
        if (AbstractC7760bg.m47767a(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        this.f36906k.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            IPlacementAd iPlacementAd = (IPlacementAd) arrayList.get(i10);
            if ((iPlacementAd instanceof C7304g) && (mediaFile2 = iPlacementAd.getMediaFile()) != null) {
                C7022dk c7022dk = this.f36876S;
                String strM41968c = c7022dk.m41968c(c7022dk.m41970e(mediaFile2.getUrl()));
                mediaFile2.m44550b(strM41968c);
                if (2 == mediaFile2.getPlayMode() || AbstractC7731ae.m47458b(strM41968c)) {
                    this.f36906k.add((C7304g) iPlacementAd);
                } else {
                    AbstractC7185ho.m43820b("PPSPlacementView", "has no cache, discard " + iPlacementAd.getContentId());
                }
            }
        }
        int size2 = this.f36906k.size();
        this.f36858A = new int[size2];
        if (AbstractC7760bg.m47767a(this.f36906k)) {
            return;
        }
        Collections.sort(this.f36906k);
        for (int i11 = 0; i11 < size2; i11++) {
            C7304g c7304g = this.f36906k.get(i11);
            int duration = (c7304g == null || (mediaFile = c7304g.getMediaFile()) == null) ? 0 : (int) mediaFile.getDuration();
            int[] iArr = this.f36858A;
            if (i11 == 0) {
                iArr[i11] = duration;
            } else {
                iArr[i11] = duration + iArr[i11 - 1];
            }
        }
    }

    /* renamed from: a */
    private void m49394a(boolean z10) {
        if (this.f36909n < this.f36906k.size() - 1) {
            m49434l();
            m49438n();
            if (z10) {
                return;
            }
            m49435m();
        }
    }

    /* renamed from: a */
    private boolean m49396a(PlacementMediaView placementMediaView, C7304g c7304g) {
        return ((placementMediaView instanceof C8066aa) && c7304g.isVideoAd()) || ((placementMediaView instanceof C8187z) && c7304g.isImageAd());
    }

    /* renamed from: a */
    private boolean m49397a(int[] iArr) {
        return iArr != null && iArr.length == 2;
    }
}
