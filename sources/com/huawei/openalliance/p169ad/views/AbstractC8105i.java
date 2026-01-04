package com.huawei.openalliance.p169ad.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7330jd;
import com.huawei.openalliance.p169ad.C7515nj;
import com.huawei.openalliance.p169ad.C7639ro;
import com.huawei.openalliance.p169ad.C7640rp;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.C7695tq;
import com.huawei.openalliance.p169ad.C7715uj;
import com.huawei.openalliance.p169ad.C7716uk;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.InterfaceC7328jb;
import com.huawei.openalliance.p169ad.InterfaceC7531nz;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.analysis.C6927h;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.LinkedSplashAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.inter.listeners.LinkedAdListener;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.listener.ILinkedMediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a;
import com.huawei.openalliance.p169ad.media.listener.MediaBufferListener;
import com.huawei.openalliance.p169ad.media.listener.MediaErrorListener;
import com.huawei.openalliance.p169ad.media.listener.MediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener;
import com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7822do;
import com.huawei.openalliance.p169ad.views.PPSLinkedView;
import com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton;
import com.huawei.openalliance.p169ad.views.interfaces.IPPSLinkedView;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.views.i */
/* loaded from: classes2.dex */
abstract class AbstractC8105i extends RelativeLayout implements C7330jd.a, IPPSLinkedView {

    /* renamed from: a */
    protected static View.OnTouchListener f37767a = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };

    /* renamed from: A */
    protected List<View> f37768A;

    /* renamed from: B */
    protected PPSSplashView f37769B;

    /* renamed from: C */
    protected WindowManager f37770C;

    /* renamed from: D */
    protected C8152v f37771D;

    /* renamed from: E */
    protected ImageView f37772E;

    /* renamed from: F */
    protected boolean f37773F;

    /* renamed from: G */
    protected d f37774G;

    /* renamed from: H */
    protected View f37775H;

    /* renamed from: I */
    protected int f37776I;

    /* renamed from: J */
    protected ViewStub f37777J;

    /* renamed from: K */
    protected View f37778K;

    /* renamed from: L */
    protected View f37779L;

    /* renamed from: M */
    protected int f37780M;

    /* renamed from: N */
    protected boolean f37781N;

    /* renamed from: O */
    protected long f37782O;

    /* renamed from: P */
    protected long f37783P;

    /* renamed from: Q */
    protected long f37784Q;

    /* renamed from: R */
    protected long f37785R;

    /* renamed from: S */
    protected boolean f37786S;

    /* renamed from: T */
    protected boolean f37787T;

    /* renamed from: U */
    protected int f37788U;

    /* renamed from: V */
    protected int f37789V;

    /* renamed from: W */
    protected float f37790W;

    /* renamed from: aA */
    protected boolean f37791aA;

    /* renamed from: aB */
    protected boolean f37792aB;

    /* renamed from: aC */
    protected String f37793aC;

    /* renamed from: aD */
    protected C6922c f37794aD;

    /* renamed from: aE */
    protected C6927h f37795aE;

    /* renamed from: aF */
    protected float f37796aF;

    /* renamed from: aG */
    protected boolean f37797aG;

    /* renamed from: aH */
    protected int f37798aH;

    /* renamed from: aI */
    protected PPSSplashProView f37799aI;

    /* renamed from: aJ */
    protected PPSSplashSwipeView f37800aJ;

    /* renamed from: aK */
    protected PPSSplashTwistView f37801aK;

    /* renamed from: aL */
    protected C7640rp f37802aL;

    /* renamed from: aM */
    protected C7639ro f37803aM;

    /* renamed from: aN */
    protected double f37804aN;

    /* renamed from: aO */
    protected int f37805aO;

    /* renamed from: aP */
    protected int f37806aP;

    /* renamed from: aQ */
    protected int f37807aQ;

    /* renamed from: aR */
    protected int f37808aR;

    /* renamed from: aS */
    protected WeakReference<Context> f37809aS;

    /* renamed from: aT */
    protected int f37810aT;

    /* renamed from: aU */
    protected PPSSplashSwipeClickView f37811aU;

    /* renamed from: aV */
    protected PPSSplashTwistClickView f37812aV;

    /* renamed from: aW */
    protected boolean f37813aW;

    /* renamed from: aX */
    protected C7695tq f37814aX;

    /* renamed from: aY */
    protected PPSVideoRenderListener f37815aY;

    /* renamed from: aZ */
    protected final ReportVideoTimeListener f37816aZ;

    /* renamed from: aa */
    protected float f37817aa;

    /* renamed from: ab */
    protected int f37818ab;

    /* renamed from: ac */
    protected int f37819ac;

    /* renamed from: ad */
    protected int f37820ad;

    /* renamed from: ae */
    protected int f37821ae;

    /* renamed from: af */
    protected float f37822af;

    /* renamed from: ag */
    protected float f37823ag;

    /* renamed from: ah */
    protected float f37824ah;

    /* renamed from: ai */
    protected int[] f37825ai;

    /* renamed from: aj */
    protected boolean f37826aj;

    /* renamed from: ak */
    protected boolean f37827ak;

    /* renamed from: al */
    protected LinkedAdListener f37828al;

    /* renamed from: am */
    protected boolean f37829am;

    /* renamed from: an */
    protected boolean f37830an;

    /* renamed from: ao */
    protected boolean f37831ao;

    /* renamed from: ap */
    protected boolean f37832ap;

    /* renamed from: aq */
    protected boolean f37833aq;

    /* renamed from: ar */
    protected boolean f37834ar;

    /* renamed from: as */
    protected boolean f37835as;

    /* renamed from: at */
    protected boolean f37836at;

    /* renamed from: au */
    protected boolean f37837au;

    /* renamed from: av */
    protected ValueAnimator f37838av;

    /* renamed from: aw */
    protected boolean f37839aw;

    /* renamed from: ax */
    protected int f37840ax;

    /* renamed from: ay */
    protected boolean f37841ay;

    /* renamed from: az */
    protected Integer f37842az;

    /* renamed from: b */
    protected final String f37843b;

    /* renamed from: ba */
    protected MediaStateListener f37844ba;

    /* renamed from: bb */
    protected InterfaceC7470a f37845bb;

    /* renamed from: bc */
    protected View.OnClickListener f37846bc;

    /* renamed from: bd */
    protected View.OnTouchListener f37847bd;

    /* renamed from: be */
    protected View.OnTouchListener f37848be;

    /* renamed from: bf */
    protected View.OnTouchListener f37849bf;

    /* renamed from: bg */
    protected MediaErrorListener f37850bg;

    /* renamed from: bh */
    protected MuteListener f37851bh;

    /* renamed from: bi */
    protected MediaBufferListener f37852bi;

    /* renamed from: bj */
    protected View.OnClickListener f37853bj;

    /* renamed from: bk */
    private double f37854bk;

    /* renamed from: bl */
    private double f37855bl;

    /* renamed from: bm */
    private double f37856bm;

    /* renamed from: bn */
    private double f37857bn;

    /* renamed from: bo */
    private double f37858bo;

    /* renamed from: bp */
    private double f37859bp;

    /* renamed from: bq */
    private double f37860bq;

    /* renamed from: br */
    private double f37861br;

    /* renamed from: bs */
    private double f37862bs;

    /* renamed from: bt */
    private float f37863bt;

    /* renamed from: bu */
    private Integer f37864bu;

    /* renamed from: bv */
    private Integer f37865bv;

    /* renamed from: bw */
    private Integer f37866bw;

    /* renamed from: bx */
    private boolean f37867bx;

    /* renamed from: by */
    private boolean f37868by;

    /* renamed from: bz */
    private boolean f37869bz;

    /* renamed from: c */
    protected final String f37870c;

    /* renamed from: d */
    protected final C7715uj f37871d;

    /* renamed from: e */
    protected final C7716uk f37872e;

    /* renamed from: f */
    protected MaterialClickInfo f37873f;

    /* renamed from: g */
    protected Context f37874g;

    /* renamed from: h */
    protected InterfaceC7146gc f37875h;

    /* renamed from: i */
    protected PPSWLSView f37876i;

    /* renamed from: j */
    protected PPSSplashAdSourceView f37877j;

    /* renamed from: k */
    protected C7330jd f37878k;

    /* renamed from: l */
    protected LinkedSplashAd f37879l;

    /* renamed from: m */
    protected InterfaceC7328jb f37880m;

    /* renamed from: n */
    protected int f37881n;

    /* renamed from: o */
    protected VideoInfo f37882o;

    /* renamed from: p */
    protected InterfaceC7531nz f37883p;

    /* renamed from: q */
    protected PPSLinkedView.OnLinkedAdSwitchListener f37884q;

    /* renamed from: r */
    protected PPSLinkedView.OnLinkedAdClickListener f37885r;

    /* renamed from: s */
    protected PPSLinkedView.OnLinkedAdPreparedListener f37886s;

    /* renamed from: t */
    protected ILinkedMediaStateListener f37887t;

    /* renamed from: u */
    protected MuteListener f37888u;

    /* renamed from: v */
    protected C8074ai f37889v;

    /* renamed from: w */
    protected IAppDownloadButton f37890w;

    /* renamed from: x */
    protected C8099g f37891x;

    /* renamed from: y */
    protected LinkedSurfaceView f37892y;

    /* renamed from: z */
    protected PPSDestView f37893z;

    /* renamed from: com.huawei.openalliance.ad.views.i$a */
    public static class a implements View.OnClickListener {

        /* renamed from: a */
        private WeakReference<PPSLinkedView> f37909a;

        /* renamed from: b */
        private ContentRecord f37910b;

        public a(PPSLinkedView pPSLinkedView, ContentRecord contentRecord) {
            this.f37909a = new WeakReference<>(pPSLinkedView);
            this.f37910b = contentRecord;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final PPSLinkedView pPSLinkedView = this.f37909a.get();
            if (pPSLinkedView != null) {
                final int[] choiceViewLoc = pPSLinkedView.f37876i.getChoiceViewLoc();
                final int[] choiceViewSize = pPSLinkedView.f37876i.getChoiceViewSize();
                if (AbstractC7741ao.m47556a(choiceViewLoc, 2) && AbstractC7741ao.m47556a(choiceViewSize, 2)) {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.i.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pPSLinkedView.m49290a(a.this.f37910b, choiceViewLoc, choiceViewSize);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.i$b */
    public class b implements C7639ro.a {
        public b() {
        }

        @Override // com.huawei.openalliance.p169ad.C7639ro.a
        /* renamed from: a */
        public void mo47106a(float f10, float f11, float f12) {
            String str;
            AbstractC8105i.this.f37863bt = (float) Math.sqrt((f10 * f10) + (f11 * f11) + (f12 * f12));
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSBaseLinkedView", "accLimitNew: %s, xAcc: %s yAcc: %s zAcc: %s, sqrtAcc: %s", Integer.valueOf(AbstractC8105i.this.f37808aR), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(AbstractC8105i.this.f37863bt));
            }
            if (AbstractC8105i.this.m50294r()) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "meet, diffX: %s, diffY: %s, diffZ: %s, limit: %s", Double.valueOf(AbstractC8105i.this.f37854bk), Double.valueOf(AbstractC8105i.this.f37857bn), Double.valueOf(AbstractC8105i.this.f37860bq), Integer.valueOf(AbstractC8105i.this.f37807aQ));
                AbstractC8105i.this.m50288o();
                if (AbstractC8105i.this.f37889v != null) {
                    str = AbstractC8105i.this.f37889v.getWidth() + "*" + AbstractC8105i.this.f37889v.getHeight();
                } else {
                    str = null;
                }
                AbstractC8105i.this.f37873f = new MaterialClickInfo.C7296a().m44531a(Float.valueOf(AbstractC8105i.this.f37796aF)).m44538b(str).m44539c((Integer) 2).m44535a();
                AbstractC8105i.this.mo49288a(19);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.i$c */
    public class c implements C7640rp.a {
        public c() {
        }

        @Override // com.huawei.openalliance.p169ad.C7640rp.a
        /* renamed from: a */
        public void mo47110a(double d10, double d11, double d12) {
            String str;
            AbstractC7185ho.m43821b("PPSBaseLinkedView", "xDegree=%s, yDegree=%s, zDegree=%s", Double.valueOf(d10), Double.valueOf(d11), Double.valueOf(d12));
            if (AbstractC8105i.this.f37864bu == null) {
                AbstractC8105i.this.f37864bu = Integer.valueOf((int) d10);
            }
            if (AbstractC8105i.this.f37865bv == null) {
                AbstractC8105i.this.f37865bv = Integer.valueOf((int) d11);
            }
            if (AbstractC8105i.this.f37866bw == null) {
                AbstractC8105i.this.f37866bw = Integer.valueOf((int) d12);
            }
            AbstractC8105i.this.m50262a(d10, d11, d12);
            AbstractC8105i abstractC8105i = AbstractC8105i.this;
            abstractC8105i.f37854bk = abstractC8105i.m50267b(abstractC8105i.f37855bl, AbstractC8105i.this.f37856bm);
            AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
            abstractC8105i2.f37857bn = abstractC8105i2.m50267b(abstractC8105i2.f37858bo, AbstractC8105i.this.f37859bp);
            AbstractC8105i abstractC8105i3 = AbstractC8105i.this;
            abstractC8105i3.f37860bq = abstractC8105i3.m50267b(abstractC8105i3.f37861br, AbstractC8105i.this.f37862bs);
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSBaseLinkedView", "diffDegreeX: %s diffDegreeY: %s diffDegreeZ: %s", Double.valueOf(AbstractC8105i.this.f37854bk), Double.valueOf(AbstractC8105i.this.f37857bn), Double.valueOf(AbstractC8105i.this.f37860bq));
                AbstractC7185ho.m43818a("PPSBaseLinkedView", "diffLeftDegreeX: %s diffRightDegreeX: %s ", Double.valueOf(AbstractC8105i.this.f37855bl), Double.valueOf(AbstractC8105i.this.f37856bm));
                AbstractC7185ho.m43818a("PPSBaseLinkedView", "diffLeftDegreeY: %s diffRightDegreeY: %s ", Double.valueOf(AbstractC8105i.this.f37858bo), Double.valueOf(AbstractC8105i.this.f37859bp));
                AbstractC7185ho.m43818a("PPSBaseLinkedView", "diffLeftDegreeZ: %s diffRightDegreeZ: %s ", Double.valueOf(AbstractC8105i.this.f37861br), Double.valueOf(AbstractC8105i.this.f37862bs));
            }
            if (AbstractC8105i.this.m50294r()) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "meet, diffX: %s, diffY: %s, diffZ: %s, limit: %s", Double.valueOf(AbstractC8105i.this.f37854bk), Double.valueOf(AbstractC8105i.this.f37857bn), Double.valueOf(AbstractC8105i.this.f37860bq), Integer.valueOf(AbstractC8105i.this.f37807aQ));
                AbstractC8105i.this.m50288o();
                if (AbstractC8105i.this.f37889v != null) {
                    str = AbstractC8105i.this.f37889v.getWidth() + "*" + AbstractC8105i.this.f37889v.getHeight();
                } else {
                    str = null;
                }
                AbstractC8105i.this.f37873f = new MaterialClickInfo.C7296a().m44531a(Float.valueOf(AbstractC8105i.this.f37796aF)).m44538b(str).m44539c((Integer) 2).m44535a();
                AbstractC8105i.this.mo49288a(19);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.i$d */
    public class d extends CountDownTimer {
        public d(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AbstractC7185ho.m43820b("PPSBaseLinkedView", "CountDownTimer onFinish");
            AbstractC8105i abstractC8105i = AbstractC8105i.this;
            if (abstractC8105i.f37820ad == 1) {
                abstractC8105i.mo49292a((Integer) 8, false);
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                abstractC8105i2.f37840ax = 2;
                AbstractC7817dj.m48366a(abstractC8105i2.f37870c);
                AbstractC8105i abstractC8105i3 = AbstractC8105i.this;
                if (abstractC8105i3.f37836at) {
                    return;
                }
                abstractC8105i3.mo49299j();
                AbstractC8105i.this.f37836at = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            AbstractC7185ho.m43818a("PPSBaseLinkedView", "onTick: %d", Long.valueOf(j10));
        }
    }

    public AbstractC8105i(Context context) {
        super(context);
        this.f37843b = Constants.IMP_EVENT_MONITOR_ID + hashCode();
        this.f37870c = "skip_btn_delay_id_" + hashCode();
        this.f37871d = new C7715uj();
        this.f37872e = new C7716uk();
        this.f37881n = 1;
        this.f37773F = true;
        this.f37780M = 0;
        this.f37781N = false;
        this.f37784Q = -1L;
        this.f37786S = false;
        this.f37787T = false;
        this.f37788U = 0;
        this.f37789V = 0;
        this.f37821ae = 3500;
        this.f37825ai = new int[2];
        this.f37826aj = false;
        this.f37827ak = false;
        this.f37829am = false;
        this.f37830an = false;
        this.f37831ao = false;
        this.f37832ap = false;
        this.f37833aq = false;
        this.f37834ar = false;
        this.f37835as = false;
        this.f37836at = false;
        this.f37837au = false;
        this.f37839aw = false;
        this.f37841ay = true;
        this.f37791aA = true;
        this.f37792aB = true;
        this.f37797aG = false;
        this.f37798aH = 0;
        this.f37813aW = false;
        this.f37815aY = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.i.6
            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                AbstractC7185ho.m43818a("PPSBaseLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(AbstractC8105i.this.f37868by));
                if (AbstractC8105i.this.f37868by) {
                    return;
                }
                AbstractC8105i.this.f37868by = true;
                AbstractC8105i.this.mo49295f();
            }
        };
        this.f37816aZ = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.i.7
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSBaseLinkedView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                InterfaceC7531nz interfaceC7531nz = AbstractC8105i.this.f37883p;
                if (interfaceC7531nz != null) {
                    interfaceC7531nz.m46260b(j10);
                }
            }
        };
        this.f37844ba = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.i.8
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                C7330jd c7330jd;
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaCompletion: %s", Integer.valueOf(i10));
                AbstractC8105i.this.mo49289a(i10, true);
                AbstractC8105i.this.f37869bz = true;
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (abstractC8105i.f37820ad == 2 && (c7330jd = abstractC8105i.f37878k) != null && c7330jd.m45264g()) {
                    AbstractC7185ho.m43820b("PPSBaseLinkedView", "onMediaCompletion, start play");
                    AbstractC8105i.this.f37872e.m47388a();
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaCompletion(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaPause: %s", Integer.valueOf(i10));
                AbstractC8105i.this.mo49289a(i10, false);
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaPause(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaStart: %s", Integer.valueOf(i10));
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                abstractC8105i.f37781N = true;
                abstractC8105i.f37872e.m47398b(true);
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                abstractC8105i2.f37785R = i10;
                abstractC8105i2.f37783P = System.currentTimeMillis();
                AbstractC8105i abstractC8105i3 = AbstractC8105i.this;
                if (!abstractC8105i3.f37826aj) {
                    abstractC8105i3.m50299l();
                    AbstractC8105i.this.m50298k();
                }
                InterfaceC7531nz interfaceC7531nz = AbstractC8105i.this.f37883p;
                if (i10 > 0) {
                    interfaceC7531nz.mo46142j();
                    AbstractC8105i.this.f37871d.m47383e();
                } else {
                    interfaceC7531nz.mo46141i();
                    AbstractC8105i abstractC8105i4 = AbstractC8105i.this;
                    abstractC8105i4.f37871d.m47377a(abstractC8105i4.f37882o);
                }
                LinkedSplashAd linkedSplashAd = AbstractC8105i.this.f37879l;
                if (linkedSplashAd != null && linkedSplashAd.isFromExsplash()) {
                    long jCurrentTimeMillis = (System.currentTimeMillis() - AbstractC8105i.this.f37875h.mo43375bB().longValue()) - AbstractC8105i.this.f37875h.mo43376bC();
                    AbstractC8105i abstractC8105i5 = AbstractC8105i.this;
                    abstractC8105i5.f37794aD.m39117b(abstractC8105i5.f37793aC, 1, abstractC8105i5.f37879l.getSlotId(), AbstractC8105i.this.f37879l.getContentId(), jCurrentTimeMillis);
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaStart(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaStop: %s", Integer.valueOf(i10));
                AbstractC8105i.this.mo49289a(i10, false);
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaStop(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                if (i11 > 0 && !AbstractC8105i.this.f37868by) {
                    AbstractC7185ho.m43818a("PPSBaseLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i11));
                    AbstractC8105i.this.f37868by = true;
                    AbstractC8105i.this.mo49295f();
                }
                if (i11 > 0) {
                    AbstractC8105i.this.f37882o.m44579e(i11);
                    AbstractC8105i.this.f37872e.m47398b(true);
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaProgress(i10, i11);
                }
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (abstractC8105i.f37781N) {
                    abstractC8105i.f37871d.m47376a(i10);
                }
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                if (abstractC8105i2.f37883p != null) {
                    AbstractC8105i.this.f37883p.m46259a(i11, abstractC8105i2.f37882o == null ? 0L : r5.getVideoDuration());
                }
            }
        };
        this.f37845bb = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.i.9
            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i10) {
                PPSLinkedView.OnLinkedAdPreparedListener onLinkedAdPreparedListener;
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onDurationReady:");
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (!abstractC8105i.f37839aw && (onLinkedAdPreparedListener = abstractC8105i.f37886s) != null) {
                    abstractC8105i.f37839aw = true;
                    onLinkedAdPreparedListener.onPrepared();
                }
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                if (abstractC8105i2.f37842az == null) {
                    abstractC8105i2.f37842az = Integer.valueOf(i10);
                    LinkedSplashAd linkedSplashAd = AbstractC8105i.this.f37879l;
                    if (linkedSplashAd == null || linkedSplashAd.getVideoInfo() == null) {
                        return;
                    }
                    AbstractC8105i.this.f37879l.getVideoInfo().m44561a(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i10) {
            }
        };
        this.f37846bc = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.i.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i10;
                if (AbstractC8105i.this.f37867bx) {
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    if (abstractC8105i.f37820ad != 1 || abstractC8105i.mo49294a(abstractC8105i.f37873f)) {
                        AbstractC8105i.this.f37867bx = false;
                        AbstractC7185ho.m43820b("PPSBaseLinkedView", "onClick");
                        AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                        if (abstractC8105i2.f37820ad == 2) {
                            i10 = 10;
                        } else {
                            i10 = 2 == abstractC8105i2.f37799aI.getMode() ? 17 : 9;
                            AbstractC8105i.this.mo49296g();
                        }
                        AbstractC8105i.this.mo49288a(i10);
                        AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.i.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractC8105i.this.f37867bx = true;
                            }
                        }, 500L);
                    }
                }
            }
        };
        this.f37847bd = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.11

            /* renamed from: b */
            private float f37897b;

            /* renamed from: c */
            private float f37898c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.f37897b = motionEvent.getX();
                    this.f37898c = motionEvent.getY();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("PPSBaseLinkedView", "startX = %s, startY = %s", Float.valueOf(this.f37897b), Float.valueOf(this.f37898c));
                    }
                    AbstractC8105i.this.f37873f = C7694tp.m47283a(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("PPSBaseLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x10), Float.valueOf(y10), Float.valueOf(this.f37897b - x10), Float.valueOf(this.f37898c - y10));
                    }
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    if (C7822do.m48382a(abstractC8105i.f37810aT, abstractC8105i.f37806aP, this.f37897b - x10, this.f37898c - y10)) {
                        AbstractC8105i.this.f37889v.setOnTouchListener(null);
                        C7694tp.m47284a(view, motionEvent, 1, AbstractC8105i.this.f37873f);
                        AbstractC8105i.this.mo49288a(18);
                    }
                }
                if (1 == motionEvent.getAction()) {
                    C7694tp.m47284a(view, motionEvent, null, AbstractC8105i.this.f37873f);
                }
                return true;
            }
        };
        this.f37848be = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                AbstractC8105i.this.f37889v.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                AbstractC8105i.this.f37873f = C7694tp.m47286b(view, motionEvent);
                MaterialClickInfo materialClickInfo = AbstractC8105i.this.f37873f;
                if (materialClickInfo != null) {
                    materialClickInfo.m44509c(0);
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    abstractC8105i.f37873f.m44502a(Float.valueOf(AbstractC7807d.m48245j(abstractC8105i.f37874g)));
                }
                AbstractC8105i.this.mo49288a(17);
                return true;
            }
        };
        this.f37849bf = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AbstractC8105i.this.f37873f = C7694tp.m47283a(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                C7694tp.m47284a(view, motionEvent, null, AbstractC8105i.this.f37873f);
                return false;
            }
        };
        this.f37850bg = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.i.2
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                AbstractC7185ho.m43824c("PPSBaseLinkedView", "media play error, isMoved: %s", Boolean.valueOf(AbstractC8105i.this.f37826aj));
                AbstractC8105i.this.mo49297h();
                AbstractC8105i.this.mo49298i();
                AbstractC8105i.this.f37872e.m47398b(false);
                if (AbstractC8105i.this.f37887t != null) {
                    AbstractC7185ho.m43820b("PPSBaseLinkedView", "call onMediaError. ");
                    AbstractC8105i.this.f37887t.onMediaError(i10, i11, i12);
                }
            }
        };
        this.f37851bh = new MuteListener() { // from class: com.huawei.openalliance.ad.views.i.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onMute");
                MuteListener muteListener = AbstractC8105i.this.f37888u;
                if (muteListener != null) {
                    muteListener.onMute();
                }
                AbstractC8105i.this.f37871d.m47380b(0);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onUnmute");
                MuteListener muteListener = AbstractC8105i.this.f37888u;
                if (muteListener != null) {
                    muteListener.onUnmute();
                }
                AbstractC8105i.this.f37871d.m47380b(1);
            }
        };
        this.f37852bi = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.i.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                AbstractC8105i.this.f37871d.m47384f();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                AbstractC8105i.this.f37871d.m47385g();
            }
        };
        this.f37853bj = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractC8105i.this.mo49293a(!view.isSelected());
            }
        };
        this.f37867bx = true;
        this.f37868by = false;
        this.f37869bz = false;
        m50270b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public double m50267b(double d10, double d11) {
        if (Math.abs(d10) < this.f37807aQ || Math.abs(d11) < this.f37807aQ) {
            return 0.0d;
        }
        return Math.abs(d10) + Math.abs(d11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m50288o() {
        m50290p();
        m50293q();
    }

    /* renamed from: p */
    private void m50290p() {
        AbstractC7185ho.m43820b("PPSBaseLinkedView", "resetDegree");
        this.f37864bu = null;
        this.f37865bv = null;
        this.f37866bw = null;
        this.f37854bk = 0.0d;
        this.f37855bl = 0.0d;
        this.f37856bm = 0.0d;
        this.f37857bn = 0.0d;
        this.f37858bo = 0.0d;
        this.f37859bp = 0.0d;
        this.f37860bq = 0.0d;
        this.f37861br = 0.0d;
        this.f37862bs = 0.0d;
        this.f37863bt = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public boolean m50294r() {
        AbstractC7185ho.m43818a("PPSBaseLinkedView", "interactiveLogic is %s", Integer.valueOf(this.f37805aO));
        return this.f37805aO == 1 ? m50295s() && m50296t() : m50295s() || m50296t();
    }

    /* renamed from: s */
    private boolean m50295s() {
        AbstractC7185ho.m43818a("PPSBaseLinkedView", "acceptableAcceleration: sqrtAcc: %s, limitAcc: %s", Float.valueOf(this.f37863bt), Integer.valueOf(this.f37808aR));
        return this.f37863bt >= ((float) this.f37808aR);
    }

    /* renamed from: t */
    private boolean m50296t() {
        AbstractC7185ho.m43818a("PPSBaseLinkedView", "acceptableAngle: diffDegreeX: %s, diffDegreeY: %s, diffDegreeZ: %s, limitDegree: %s", Double.valueOf(this.f37854bk), Double.valueOf(this.f37857bn), Double.valueOf(this.f37860bq), Integer.valueOf(this.f37807aQ));
        double d10 = this.f37854bk;
        double d11 = this.f37804aN;
        return d10 >= d11 || this.f37857bn >= d11 || this.f37860bq >= d11;
    }

    /* renamed from: a */
    public abstract void mo49288a(int i10);

    /* renamed from: a */
    public abstract void mo49289a(int i10, boolean z10);

    /* renamed from: a */
    public abstract void mo49292a(Integer num, boolean z10);

    /* renamed from: a */
    public abstract void mo49293a(boolean z10);

    /* renamed from: a */
    public abstract boolean mo49294a(MaterialClickInfo materialClickInfo);

    /* renamed from: f */
    public abstract void mo49295f();

    /* renamed from: g */
    public abstract void mo49296g();

    /* renamed from: h */
    public abstract void mo49297h();

    /* renamed from: i */
    public abstract void mo49298i();

    /* renamed from: j */
    public abstract void mo49299j();

    public AbstractC8105i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37843b = Constants.IMP_EVENT_MONITOR_ID + hashCode();
        this.f37870c = "skip_btn_delay_id_" + hashCode();
        this.f37871d = new C7715uj();
        this.f37872e = new C7716uk();
        this.f37881n = 1;
        this.f37773F = true;
        this.f37780M = 0;
        this.f37781N = false;
        this.f37784Q = -1L;
        this.f37786S = false;
        this.f37787T = false;
        this.f37788U = 0;
        this.f37789V = 0;
        this.f37821ae = 3500;
        this.f37825ai = new int[2];
        this.f37826aj = false;
        this.f37827ak = false;
        this.f37829am = false;
        this.f37830an = false;
        this.f37831ao = false;
        this.f37832ap = false;
        this.f37833aq = false;
        this.f37834ar = false;
        this.f37835as = false;
        this.f37836at = false;
        this.f37837au = false;
        this.f37839aw = false;
        this.f37841ay = true;
        this.f37791aA = true;
        this.f37792aB = true;
        this.f37797aG = false;
        this.f37798aH = 0;
        this.f37813aW = false;
        this.f37815aY = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.i.6
            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                AbstractC7185ho.m43818a("PPSBaseLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(AbstractC8105i.this.f37868by));
                if (AbstractC8105i.this.f37868by) {
                    return;
                }
                AbstractC8105i.this.f37868by = true;
                AbstractC8105i.this.mo49295f();
            }
        };
        this.f37816aZ = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.i.7
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSBaseLinkedView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                InterfaceC7531nz interfaceC7531nz = AbstractC8105i.this.f37883p;
                if (interfaceC7531nz != null) {
                    interfaceC7531nz.m46260b(j10);
                }
            }
        };
        this.f37844ba = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.i.8
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i10) {
                C7330jd c7330jd;
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaCompletion: %s", Integer.valueOf(i10));
                AbstractC8105i.this.mo49289a(i10, true);
                AbstractC8105i.this.f37869bz = true;
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (abstractC8105i.f37820ad == 2 && (c7330jd = abstractC8105i.f37878k) != null && c7330jd.m45264g()) {
                    AbstractC7185ho.m43820b("PPSBaseLinkedView", "onMediaCompletion, start play");
                    AbstractC8105i.this.f37872e.m47388a();
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaCompletion(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i10) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaPause: %s", Integer.valueOf(i10));
                AbstractC8105i.this.mo49289a(i10, false);
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaPause(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i10) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaStart: %s", Integer.valueOf(i10));
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                abstractC8105i.f37781N = true;
                abstractC8105i.f37872e.m47398b(true);
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                abstractC8105i2.f37785R = i10;
                abstractC8105i2.f37783P = System.currentTimeMillis();
                AbstractC8105i abstractC8105i3 = AbstractC8105i.this;
                if (!abstractC8105i3.f37826aj) {
                    abstractC8105i3.m50299l();
                    AbstractC8105i.this.m50298k();
                }
                InterfaceC7531nz interfaceC7531nz = AbstractC8105i.this.f37883p;
                if (i10 > 0) {
                    interfaceC7531nz.mo46142j();
                    AbstractC8105i.this.f37871d.m47383e();
                } else {
                    interfaceC7531nz.mo46141i();
                    AbstractC8105i abstractC8105i4 = AbstractC8105i.this;
                    abstractC8105i4.f37871d.m47377a(abstractC8105i4.f37882o);
                }
                LinkedSplashAd linkedSplashAd = AbstractC8105i.this.f37879l;
                if (linkedSplashAd != null && linkedSplashAd.isFromExsplash()) {
                    long jCurrentTimeMillis = (System.currentTimeMillis() - AbstractC8105i.this.f37875h.mo43375bB().longValue()) - AbstractC8105i.this.f37875h.mo43376bC();
                    AbstractC8105i abstractC8105i5 = AbstractC8105i.this;
                    abstractC8105i5.f37794aD.m39117b(abstractC8105i5.f37793aC, 1, abstractC8105i5.f37879l.getSlotId(), AbstractC8105i.this.f37879l.getContentId(), jCurrentTimeMillis);
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaStart(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i10) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaStop: %s", Integer.valueOf(i10));
                AbstractC8105i.this.mo49289a(i10, false);
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaStop(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i10, int i11) {
                if (i11 > 0 && !AbstractC8105i.this.f37868by) {
                    AbstractC7185ho.m43818a("PPSBaseLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i11));
                    AbstractC8105i.this.f37868by = true;
                    AbstractC8105i.this.mo49295f();
                }
                if (i11 > 0) {
                    AbstractC8105i.this.f37882o.m44579e(i11);
                    AbstractC8105i.this.f37872e.m47398b(true);
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaProgress(i10, i11);
                }
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (abstractC8105i.f37781N) {
                    abstractC8105i.f37871d.m47376a(i10);
                }
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                if (abstractC8105i2.f37883p != null) {
                    AbstractC8105i.this.f37883p.m46259a(i11, abstractC8105i2.f37882o == null ? 0L : r5.getVideoDuration());
                }
            }
        };
        this.f37845bb = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.i.9
            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i10) {
                PPSLinkedView.OnLinkedAdPreparedListener onLinkedAdPreparedListener;
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onDurationReady:");
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (!abstractC8105i.f37839aw && (onLinkedAdPreparedListener = abstractC8105i.f37886s) != null) {
                    abstractC8105i.f37839aw = true;
                    onLinkedAdPreparedListener.onPrepared();
                }
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                if (abstractC8105i2.f37842az == null) {
                    abstractC8105i2.f37842az = Integer.valueOf(i10);
                    LinkedSplashAd linkedSplashAd = AbstractC8105i.this.f37879l;
                    if (linkedSplashAd == null || linkedSplashAd.getVideoInfo() == null) {
                        return;
                    }
                    AbstractC8105i.this.f37879l.getVideoInfo().m44561a(i10);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i10) {
            }
        };
        this.f37846bc = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.i.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i10;
                if (AbstractC8105i.this.f37867bx) {
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    if (abstractC8105i.f37820ad != 1 || abstractC8105i.mo49294a(abstractC8105i.f37873f)) {
                        AbstractC8105i.this.f37867bx = false;
                        AbstractC7185ho.m43820b("PPSBaseLinkedView", "onClick");
                        AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                        if (abstractC8105i2.f37820ad == 2) {
                            i10 = 10;
                        } else {
                            i10 = 2 == abstractC8105i2.f37799aI.getMode() ? 17 : 9;
                            AbstractC8105i.this.mo49296g();
                        }
                        AbstractC8105i.this.mo49288a(i10);
                        AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.i.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractC8105i.this.f37867bx = true;
                            }
                        }, 500L);
                    }
                }
            }
        };
        this.f37847bd = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.11

            /* renamed from: b */
            private float f37897b;

            /* renamed from: c */
            private float f37898c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.f37897b = motionEvent.getX();
                    this.f37898c = motionEvent.getY();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("PPSBaseLinkedView", "startX = %s, startY = %s", Float.valueOf(this.f37897b), Float.valueOf(this.f37898c));
                    }
                    AbstractC8105i.this.f37873f = C7694tp.m47283a(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("PPSBaseLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x10), Float.valueOf(y10), Float.valueOf(this.f37897b - x10), Float.valueOf(this.f37898c - y10));
                    }
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    if (C7822do.m48382a(abstractC8105i.f37810aT, abstractC8105i.f37806aP, this.f37897b - x10, this.f37898c - y10)) {
                        AbstractC8105i.this.f37889v.setOnTouchListener(null);
                        C7694tp.m47284a(view, motionEvent, 1, AbstractC8105i.this.f37873f);
                        AbstractC8105i.this.mo49288a(18);
                    }
                }
                if (1 == motionEvent.getAction()) {
                    C7694tp.m47284a(view, motionEvent, null, AbstractC8105i.this.f37873f);
                }
                return true;
            }
        };
        this.f37848be = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                AbstractC8105i.this.f37889v.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                AbstractC8105i.this.f37873f = C7694tp.m47286b(view, motionEvent);
                MaterialClickInfo materialClickInfo = AbstractC8105i.this.f37873f;
                if (materialClickInfo != null) {
                    materialClickInfo.m44509c(0);
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    abstractC8105i.f37873f.m44502a(Float.valueOf(AbstractC7807d.m48245j(abstractC8105i.f37874g)));
                }
                AbstractC8105i.this.mo49288a(17);
                return true;
            }
        };
        this.f37849bf = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AbstractC8105i.this.f37873f = C7694tp.m47283a(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                C7694tp.m47284a(view, motionEvent, null, AbstractC8105i.this.f37873f);
                return false;
            }
        };
        this.f37850bg = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.i.2
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i10, int i11, int i12) {
                AbstractC7185ho.m43824c("PPSBaseLinkedView", "media play error, isMoved: %s", Boolean.valueOf(AbstractC8105i.this.f37826aj));
                AbstractC8105i.this.mo49297h();
                AbstractC8105i.this.mo49298i();
                AbstractC8105i.this.f37872e.m47398b(false);
                if (AbstractC8105i.this.f37887t != null) {
                    AbstractC7185ho.m43820b("PPSBaseLinkedView", "call onMediaError. ");
                    AbstractC8105i.this.f37887t.onMediaError(i10, i11, i12);
                }
            }
        };
        this.f37851bh = new MuteListener() { // from class: com.huawei.openalliance.ad.views.i.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onMute");
                MuteListener muteListener = AbstractC8105i.this.f37888u;
                if (muteListener != null) {
                    muteListener.onMute();
                }
                AbstractC8105i.this.f37871d.m47380b(0);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onUnmute");
                MuteListener muteListener = AbstractC8105i.this.f37888u;
                if (muteListener != null) {
                    muteListener.onUnmute();
                }
                AbstractC8105i.this.f37871d.m47380b(1);
            }
        };
        this.f37852bi = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.i.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i10) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                AbstractC8105i.this.f37871d.m47384f();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                AbstractC8105i.this.f37871d.m47385g();
            }
        };
        this.f37853bj = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractC8105i.this.mo49293a(!view.isSelected());
            }
        };
        this.f37867bx = true;
        this.f37868by = false;
        this.f37869bz = false;
        m50270b(context);
    }

    /* renamed from: q */
    private void m50293q() {
        AbstractC7185ho.m43817a("PPSBaseLinkedView", "releaseSensor");
        C7639ro c7639ro = this.f37803aM;
        if (c7639ro != null) {
            c7639ro.m47105b();
        }
        C7640rp c7640rp = this.f37802aL;
        if (c7640rp != null) {
            c7640rp.m47109b();
        }
    }

    /* renamed from: k */
    public void m50298k() {
        AbstractC7185ho.m43821b("PPSBaseLinkedView", "reportAdShowStartEvent, showStartTime: %s", Long.valueOf(this.f37782O));
        this.f37787T = false;
        String strValueOf = String.valueOf(this.f37782O);
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd == null) {
            AbstractC7185ho.m43823c("PPSBaseLinkedView", "linkedSplashAd is null! please register first");
            return;
        }
        linkedSplashAd.m44642h(strValueOf);
        this.f37879l.m44622c(this.f37782O);
        this.f37879l.m44842h(false);
        this.f37879l.m44612a(false);
        this.f37879l.m44847j(true);
        if (!this.f37879l.m44784V()) {
            this.f37879l.m44840g(true);
        }
        this.f37883p.mo45318a(strValueOf);
        this.f37883p.m46258a(this.f37782O);
        IAppDownloadButton iAppDownloadButton = this.f37890w;
        if (iAppDownloadButton != null) {
            iAppDownloadButton.updateContent(strValueOf);
            this.f37890w.updateStartShowTime(this.f37782O);
        }
        AbstractC7185ho.m43817a("PPSBaseLinkedView", "report showStart. ");
        this.f37883p.mo46136b();
    }

    /* renamed from: l */
    public void m50299l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f37782O = jCurrentTimeMillis;
        InterfaceC7328jb interfaceC7328jb = this.f37880m;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45151a(jCurrentTimeMillis);
        }
    }

    /* renamed from: m */
    public InterfaceC7328jb mo49300m() {
        return this.f37880m;
    }

    /* renamed from: n */
    public C8074ai mo49301n() {
        return this.f37889v;
    }

    public AbstractC8105i(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37843b = Constants.IMP_EVENT_MONITOR_ID + hashCode();
        this.f37870c = "skip_btn_delay_id_" + hashCode();
        this.f37871d = new C7715uj();
        this.f37872e = new C7716uk();
        this.f37881n = 1;
        this.f37773F = true;
        this.f37780M = 0;
        this.f37781N = false;
        this.f37784Q = -1L;
        this.f37786S = false;
        this.f37787T = false;
        this.f37788U = 0;
        this.f37789V = 0;
        this.f37821ae = 3500;
        this.f37825ai = new int[2];
        this.f37826aj = false;
        this.f37827ak = false;
        this.f37829am = false;
        this.f37830an = false;
        this.f37831ao = false;
        this.f37832ap = false;
        this.f37833aq = false;
        this.f37834ar = false;
        this.f37835as = false;
        this.f37836at = false;
        this.f37837au = false;
        this.f37839aw = false;
        this.f37841ay = true;
        this.f37791aA = true;
        this.f37792aB = true;
        this.f37797aG = false;
        this.f37798aH = 0;
        this.f37813aW = false;
        this.f37815aY = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.i.6
            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                AbstractC7185ho.m43818a("PPSBaseLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(AbstractC8105i.this.f37868by));
                if (AbstractC8105i.this.f37868by) {
                    return;
                }
                AbstractC8105i.this.f37868by = true;
                AbstractC8105i.this.mo49295f();
            }
        };
        this.f37816aZ = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.i.7
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSBaseLinkedView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                InterfaceC7531nz interfaceC7531nz = AbstractC8105i.this.f37883p;
                if (interfaceC7531nz != null) {
                    interfaceC7531nz.m46260b(j10);
                }
            }
        };
        this.f37844ba = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.i.8
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i102) {
                C7330jd c7330jd;
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaCompletion: %s", Integer.valueOf(i102));
                AbstractC8105i.this.mo49289a(i102, true);
                AbstractC8105i.this.f37869bz = true;
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (abstractC8105i.f37820ad == 2 && (c7330jd = abstractC8105i.f37878k) != null && c7330jd.m45264g()) {
                    AbstractC7185ho.m43820b("PPSBaseLinkedView", "onMediaCompletion, start play");
                    AbstractC8105i.this.f37872e.m47388a();
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaCompletion(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i102) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaPause: %s", Integer.valueOf(i102));
                AbstractC8105i.this.mo49289a(i102, false);
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaPause(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i102) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaStart: %s", Integer.valueOf(i102));
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                abstractC8105i.f37781N = true;
                abstractC8105i.f37872e.m47398b(true);
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                abstractC8105i2.f37785R = i102;
                abstractC8105i2.f37783P = System.currentTimeMillis();
                AbstractC8105i abstractC8105i3 = AbstractC8105i.this;
                if (!abstractC8105i3.f37826aj) {
                    abstractC8105i3.m50299l();
                    AbstractC8105i.this.m50298k();
                }
                InterfaceC7531nz interfaceC7531nz = AbstractC8105i.this.f37883p;
                if (i102 > 0) {
                    interfaceC7531nz.mo46142j();
                    AbstractC8105i.this.f37871d.m47383e();
                } else {
                    interfaceC7531nz.mo46141i();
                    AbstractC8105i abstractC8105i4 = AbstractC8105i.this;
                    abstractC8105i4.f37871d.m47377a(abstractC8105i4.f37882o);
                }
                LinkedSplashAd linkedSplashAd = AbstractC8105i.this.f37879l;
                if (linkedSplashAd != null && linkedSplashAd.isFromExsplash()) {
                    long jCurrentTimeMillis = (System.currentTimeMillis() - AbstractC8105i.this.f37875h.mo43375bB().longValue()) - AbstractC8105i.this.f37875h.mo43376bC();
                    AbstractC8105i abstractC8105i5 = AbstractC8105i.this;
                    abstractC8105i5.f37794aD.m39117b(abstractC8105i5.f37793aC, 1, abstractC8105i5.f37879l.getSlotId(), AbstractC8105i.this.f37879l.getContentId(), jCurrentTimeMillis);
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaStart(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i102) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaStop: %s", Integer.valueOf(i102));
                AbstractC8105i.this.mo49289a(i102, false);
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaStop(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i102, int i11) {
                if (i11 > 0 && !AbstractC8105i.this.f37868by) {
                    AbstractC7185ho.m43818a("PPSBaseLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i11));
                    AbstractC8105i.this.f37868by = true;
                    AbstractC8105i.this.mo49295f();
                }
                if (i11 > 0) {
                    AbstractC8105i.this.f37882o.m44579e(i11);
                    AbstractC8105i.this.f37872e.m47398b(true);
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaProgress(i102, i11);
                }
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (abstractC8105i.f37781N) {
                    abstractC8105i.f37871d.m47376a(i102);
                }
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                if (abstractC8105i2.f37883p != null) {
                    AbstractC8105i.this.f37883p.m46259a(i11, abstractC8105i2.f37882o == null ? 0L : r5.getVideoDuration());
                }
            }
        };
        this.f37845bb = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.i.9
            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i102) {
                PPSLinkedView.OnLinkedAdPreparedListener onLinkedAdPreparedListener;
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onDurationReady:");
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (!abstractC8105i.f37839aw && (onLinkedAdPreparedListener = abstractC8105i.f37886s) != null) {
                    abstractC8105i.f37839aw = true;
                    onLinkedAdPreparedListener.onPrepared();
                }
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                if (abstractC8105i2.f37842az == null) {
                    abstractC8105i2.f37842az = Integer.valueOf(i102);
                    LinkedSplashAd linkedSplashAd = AbstractC8105i.this.f37879l;
                    if (linkedSplashAd == null || linkedSplashAd.getVideoInfo() == null) {
                        return;
                    }
                    AbstractC8105i.this.f37879l.getVideoInfo().m44561a(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i102) {
            }
        };
        this.f37846bc = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.i.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i102;
                if (AbstractC8105i.this.f37867bx) {
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    if (abstractC8105i.f37820ad != 1 || abstractC8105i.mo49294a(abstractC8105i.f37873f)) {
                        AbstractC8105i.this.f37867bx = false;
                        AbstractC7185ho.m43820b("PPSBaseLinkedView", "onClick");
                        AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                        if (abstractC8105i2.f37820ad == 2) {
                            i102 = 10;
                        } else {
                            i102 = 2 == abstractC8105i2.f37799aI.getMode() ? 17 : 9;
                            AbstractC8105i.this.mo49296g();
                        }
                        AbstractC8105i.this.mo49288a(i102);
                        AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.i.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractC8105i.this.f37867bx = true;
                            }
                        }, 500L);
                    }
                }
            }
        };
        this.f37847bd = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.11

            /* renamed from: b */
            private float f37897b;

            /* renamed from: c */
            private float f37898c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.f37897b = motionEvent.getX();
                    this.f37898c = motionEvent.getY();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("PPSBaseLinkedView", "startX = %s, startY = %s", Float.valueOf(this.f37897b), Float.valueOf(this.f37898c));
                    }
                    AbstractC8105i.this.f37873f = C7694tp.m47283a(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("PPSBaseLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x10), Float.valueOf(y10), Float.valueOf(this.f37897b - x10), Float.valueOf(this.f37898c - y10));
                    }
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    if (C7822do.m48382a(abstractC8105i.f37810aT, abstractC8105i.f37806aP, this.f37897b - x10, this.f37898c - y10)) {
                        AbstractC8105i.this.f37889v.setOnTouchListener(null);
                        C7694tp.m47284a(view, motionEvent, 1, AbstractC8105i.this.f37873f);
                        AbstractC8105i.this.mo49288a(18);
                    }
                }
                if (1 == motionEvent.getAction()) {
                    C7694tp.m47284a(view, motionEvent, null, AbstractC8105i.this.f37873f);
                }
                return true;
            }
        };
        this.f37848be = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                AbstractC8105i.this.f37889v.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                AbstractC8105i.this.f37873f = C7694tp.m47286b(view, motionEvent);
                MaterialClickInfo materialClickInfo = AbstractC8105i.this.f37873f;
                if (materialClickInfo != null) {
                    materialClickInfo.m44509c(0);
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    abstractC8105i.f37873f.m44502a(Float.valueOf(AbstractC7807d.m48245j(abstractC8105i.f37874g)));
                }
                AbstractC8105i.this.mo49288a(17);
                return true;
            }
        };
        this.f37849bf = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AbstractC8105i.this.f37873f = C7694tp.m47283a(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                C7694tp.m47284a(view, motionEvent, null, AbstractC8105i.this.f37873f);
                return false;
            }
        };
        this.f37850bg = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.i.2
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i102, int i11, int i12) {
                AbstractC7185ho.m43824c("PPSBaseLinkedView", "media play error, isMoved: %s", Boolean.valueOf(AbstractC8105i.this.f37826aj));
                AbstractC8105i.this.mo49297h();
                AbstractC8105i.this.mo49298i();
                AbstractC8105i.this.f37872e.m47398b(false);
                if (AbstractC8105i.this.f37887t != null) {
                    AbstractC7185ho.m43820b("PPSBaseLinkedView", "call onMediaError. ");
                    AbstractC8105i.this.f37887t.onMediaError(i102, i11, i12);
                }
            }
        };
        this.f37851bh = new MuteListener() { // from class: com.huawei.openalliance.ad.views.i.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onMute");
                MuteListener muteListener = AbstractC8105i.this.f37888u;
                if (muteListener != null) {
                    muteListener.onMute();
                }
                AbstractC8105i.this.f37871d.m47380b(0);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onUnmute");
                MuteListener muteListener = AbstractC8105i.this.f37888u;
                if (muteListener != null) {
                    muteListener.onUnmute();
                }
                AbstractC8105i.this.f37871d.m47380b(1);
            }
        };
        this.f37852bi = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.i.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i102) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                AbstractC8105i.this.f37871d.m47384f();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                AbstractC8105i.this.f37871d.m47385g();
            }
        };
        this.f37853bj = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractC8105i.this.mo49293a(!view.isSelected());
            }
        };
        this.f37867bx = true;
        this.f37868by = false;
        this.f37869bz = false;
        m50270b(context);
    }

    public AbstractC8105i(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f37843b = Constants.IMP_EVENT_MONITOR_ID + hashCode();
        this.f37870c = "skip_btn_delay_id_" + hashCode();
        this.f37871d = new C7715uj();
        this.f37872e = new C7716uk();
        this.f37881n = 1;
        this.f37773F = true;
        this.f37780M = 0;
        this.f37781N = false;
        this.f37784Q = -1L;
        this.f37786S = false;
        this.f37787T = false;
        this.f37788U = 0;
        this.f37789V = 0;
        this.f37821ae = 3500;
        this.f37825ai = new int[2];
        this.f37826aj = false;
        this.f37827ak = false;
        this.f37829am = false;
        this.f37830an = false;
        this.f37831ao = false;
        this.f37832ap = false;
        this.f37833aq = false;
        this.f37834ar = false;
        this.f37835as = false;
        this.f37836at = false;
        this.f37837au = false;
        this.f37839aw = false;
        this.f37841ay = true;
        this.f37791aA = true;
        this.f37792aB = true;
        this.f37797aG = false;
        this.f37798aH = 0;
        this.f37813aW = false;
        this.f37815aY = new PPSVideoRenderListener() { // from class: com.huawei.openalliance.ad.views.i.6
            @Override // com.huawei.openalliance.p169ad.media.listener.PPSVideoRenderListener
            public void onVideoRenderStart() {
                AbstractC7185ho.m43818a("PPSBaseLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(AbstractC8105i.this.f37868by));
                if (AbstractC8105i.this.f37868by) {
                    return;
                }
                AbstractC8105i.this.f37868by = true;
                AbstractC8105i.this.mo49295f();
            }
        };
        this.f37816aZ = new ReportVideoTimeListener() { // from class: com.huawei.openalliance.ad.views.i.7
            @Override // com.huawei.openalliance.p169ad.media.listener.ReportVideoTimeListener
            public void reportVideoTime(long j10) {
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a("PPSBaseLinkedView", "reportVideoTime: %s", Long.valueOf(j10));
                }
                InterfaceC7531nz interfaceC7531nz = AbstractC8105i.this.f37883p;
                if (interfaceC7531nz != null) {
                    interfaceC7531nz.m46260b(j10);
                }
            }
        };
        this.f37844ba = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.i.8
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i102) {
                C7330jd c7330jd;
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaCompletion: %s", Integer.valueOf(i102));
                AbstractC8105i.this.mo49289a(i102, true);
                AbstractC8105i.this.f37869bz = true;
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (abstractC8105i.f37820ad == 2 && (c7330jd = abstractC8105i.f37878k) != null && c7330jd.m45264g()) {
                    AbstractC7185ho.m43820b("PPSBaseLinkedView", "onMediaCompletion, start play");
                    AbstractC8105i.this.f37872e.m47388a();
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaCompletion(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i102) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaPause: %s", Integer.valueOf(i102));
                AbstractC8105i.this.mo49289a(i102, false);
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaPause(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i102) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaStart: %s", Integer.valueOf(i102));
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                abstractC8105i.f37781N = true;
                abstractC8105i.f37872e.m47398b(true);
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                abstractC8105i2.f37785R = i102;
                abstractC8105i2.f37783P = System.currentTimeMillis();
                AbstractC8105i abstractC8105i3 = AbstractC8105i.this;
                if (!abstractC8105i3.f37826aj) {
                    abstractC8105i3.m50299l();
                    AbstractC8105i.this.m50298k();
                }
                InterfaceC7531nz interfaceC7531nz = AbstractC8105i.this.f37883p;
                if (i102 > 0) {
                    interfaceC7531nz.mo46142j();
                    AbstractC8105i.this.f37871d.m47383e();
                } else {
                    interfaceC7531nz.mo46141i();
                    AbstractC8105i abstractC8105i4 = AbstractC8105i.this;
                    abstractC8105i4.f37871d.m47377a(abstractC8105i4.f37882o);
                }
                LinkedSplashAd linkedSplashAd = AbstractC8105i.this.f37879l;
                if (linkedSplashAd != null && linkedSplashAd.isFromExsplash()) {
                    long jCurrentTimeMillis = (System.currentTimeMillis() - AbstractC8105i.this.f37875h.mo43375bB().longValue()) - AbstractC8105i.this.f37875h.mo43376bC();
                    AbstractC8105i abstractC8105i5 = AbstractC8105i.this;
                    abstractC8105i5.f37794aD.m39117b(abstractC8105i5.f37793aC, 1, abstractC8105i5.f37879l.getSlotId(), AbstractC8105i.this.f37879l.getContentId(), jCurrentTimeMillis);
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaStart(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i102) {
                AbstractC7185ho.m43821b("PPSBaseLinkedView", "onMediaStop: %s", Integer.valueOf(i102));
                AbstractC8105i.this.mo49289a(i102, false);
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaStop(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaStateListener
            public void onProgress(int i102, int i112) {
                if (i112 > 0 && !AbstractC8105i.this.f37868by) {
                    AbstractC7185ho.m43818a("PPSBaseLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i112));
                    AbstractC8105i.this.f37868by = true;
                    AbstractC8105i.this.mo49295f();
                }
                if (i112 > 0) {
                    AbstractC8105i.this.f37882o.m44579e(i112);
                    AbstractC8105i.this.f37872e.m47398b(true);
                }
                ILinkedMediaStateListener iLinkedMediaStateListener = AbstractC8105i.this.f37887t;
                if (iLinkedMediaStateListener != null) {
                    iLinkedMediaStateListener.onMediaProgress(i102, i112);
                }
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (abstractC8105i.f37781N) {
                    abstractC8105i.f37871d.m47376a(i102);
                }
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                if (abstractC8105i2.f37883p != null) {
                    AbstractC8105i.this.f37883p.m46259a(i112, abstractC8105i2.f37882o == null ? 0L : r5.getVideoDuration());
                }
            }
        };
        this.f37845bb = new InterfaceC7470a() { // from class: com.huawei.openalliance.ad.views.i.9
            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: a */
            public void mo45566a(int i102) {
                PPSLinkedView.OnLinkedAdPreparedListener onLinkedAdPreparedListener;
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onDurationReady:");
                AbstractC8105i abstractC8105i = AbstractC8105i.this;
                if (!abstractC8105i.f37839aw && (onLinkedAdPreparedListener = abstractC8105i.f37886s) != null) {
                    abstractC8105i.f37839aw = true;
                    onLinkedAdPreparedListener.onPrepared();
                }
                AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                if (abstractC8105i2.f37842az == null) {
                    abstractC8105i2.f37842az = Integer.valueOf(i102);
                    LinkedSplashAd linkedSplashAd = AbstractC8105i.this.f37879l;
                    if (linkedSplashAd == null || linkedSplashAd.getVideoInfo() == null) {
                        return;
                    }
                    AbstractC8105i.this.f37879l.getVideoInfo().m44561a(i102);
                }
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.InterfaceC7470a
            /* renamed from: b */
            public void mo45567b(int i102) {
            }
        };
        this.f37846bc = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.i.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i102;
                if (AbstractC8105i.this.f37867bx) {
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    if (abstractC8105i.f37820ad != 1 || abstractC8105i.mo49294a(abstractC8105i.f37873f)) {
                        AbstractC8105i.this.f37867bx = false;
                        AbstractC7185ho.m43820b("PPSBaseLinkedView", "onClick");
                        AbstractC8105i abstractC8105i2 = AbstractC8105i.this;
                        if (abstractC8105i2.f37820ad == 2) {
                            i102 = 10;
                        } else {
                            i102 = 2 == abstractC8105i2.f37799aI.getMode() ? 17 : 9;
                            AbstractC8105i.this.mo49296g();
                        }
                        AbstractC8105i.this.mo49288a(i102);
                        AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.i.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AbstractC8105i.this.f37867bx = true;
                            }
                        }, 500L);
                    }
                }
            }
        };
        this.f37847bd = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.11

            /* renamed from: b */
            private float f37897b;

            /* renamed from: c */
            private float f37898c;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.f37897b = motionEvent.getX();
                    this.f37898c = motionEvent.getY();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("PPSBaseLinkedView", "startX = %s, startY = %s", Float.valueOf(this.f37897b), Float.valueOf(this.f37898c));
                    }
                    AbstractC8105i.this.f37873f = C7694tp.m47283a(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    if (AbstractC7185ho.m43819a()) {
                        AbstractC7185ho.m43818a("PPSBaseLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x10), Float.valueOf(y10), Float.valueOf(this.f37897b - x10), Float.valueOf(this.f37898c - y10));
                    }
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    if (C7822do.m48382a(abstractC8105i.f37810aT, abstractC8105i.f37806aP, this.f37897b - x10, this.f37898c - y10)) {
                        AbstractC8105i.this.f37889v.setOnTouchListener(null);
                        C7694tp.m47284a(view, motionEvent, 1, AbstractC8105i.this.f37873f);
                        AbstractC8105i.this.mo49288a(18);
                    }
                }
                if (1 == motionEvent.getAction()) {
                    C7694tp.m47284a(view, motionEvent, null, AbstractC8105i.this.f37873f);
                }
                return true;
            }
        };
        this.f37848be = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.12
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                AbstractC8105i.this.f37889v.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                AbstractC8105i.this.f37873f = C7694tp.m47286b(view, motionEvent);
                MaterialClickInfo materialClickInfo = AbstractC8105i.this.f37873f;
                if (materialClickInfo != null) {
                    materialClickInfo.m44509c(0);
                    AbstractC8105i abstractC8105i = AbstractC8105i.this;
                    abstractC8105i.f37873f.m44502a(Float.valueOf(AbstractC7807d.m48245j(abstractC8105i.f37874g)));
                }
                AbstractC8105i.this.mo49288a(17);
                return true;
            }
        };
        this.f37849bf = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.i.13
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AbstractC8105i.this.f37873f = C7694tp.m47283a(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                C7694tp.m47284a(view, motionEvent, null, AbstractC8105i.this.f37873f);
                return false;
            }
        };
        this.f37850bg = new MediaErrorListener() { // from class: com.huawei.openalliance.ad.views.i.2
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaErrorListener
            public void onError(MediaPlayerAgent mediaPlayerAgent, int i102, int i112, int i12) {
                AbstractC7185ho.m43824c("PPSBaseLinkedView", "media play error, isMoved: %s", Boolean.valueOf(AbstractC8105i.this.f37826aj));
                AbstractC8105i.this.mo49297h();
                AbstractC8105i.this.mo49298i();
                AbstractC8105i.this.f37872e.m47398b(false);
                if (AbstractC8105i.this.f37887t != null) {
                    AbstractC7185ho.m43820b("PPSBaseLinkedView", "call onMediaError. ");
                    AbstractC8105i.this.f37887t.onMediaError(i102, i112, i12);
                }
            }
        };
        this.f37851bh = new MuteListener() { // from class: com.huawei.openalliance.ad.views.i.3
            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onMute() {
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onMute");
                MuteListener muteListener = AbstractC8105i.this.f37888u;
                if (muteListener != null) {
                    muteListener.onMute();
                }
                AbstractC8105i.this.f37871d.m47380b(0);
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MuteListener
            public void onUnmute() {
                AbstractC7185ho.m43820b("PPSBaseLinkedView", "onUnmute");
                MuteListener muteListener = AbstractC8105i.this.f37888u;
                if (muteListener != null) {
                    muteListener.onUnmute();
                }
                AbstractC8105i.this.f37871d.m47380b(1);
            }
        };
        this.f37852bi = new MediaBufferListener() { // from class: com.huawei.openalliance.ad.views.i.4
            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferUpdate(int i102) {
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingEnd() {
                AbstractC8105i.this.f37871d.m47384f();
            }

            @Override // com.huawei.openalliance.p169ad.media.listener.MediaBufferListener
            public void onBufferingStart() {
                AbstractC8105i.this.f37871d.m47385g();
            }
        };
        this.f37853bj = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractC8105i.this.mo49293a(!view.isSelected());
            }
        };
        this.f37867bx = true;
        this.f37868by = false;
        this.f37869bz = false;
        m50270b(context);
    }

    /* renamed from: b */
    private void m50270b(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f37874g = applicationContext;
        this.f37875h = C7124fh.m43316b(applicationContext);
        this.f37883p = new C7515nj(this.f37874g, this);
        this.f37770C = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        this.f37792aB = C6982bz.m41148a(this.f37874g).mo41175d();
        this.f37793aC = this.f37874g.getPackageName();
        this.f37794aD = new C6922c(this.f37874g);
        this.f37795aE = new C6927h(this.f37874g);
        this.f37796aF = AbstractC7807d.m48245j(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50262a(double d10, double d11, double d12) {
        if (d10 - this.f37864bu.intValue() < 0.0d && m50264a(this.f37855bl, d10 - this.f37864bu.intValue())) {
            this.f37855bl = Math.min(this.f37855bl, d10 - this.f37864bu.intValue());
        } else if (m50264a(this.f37856bm, d10 - this.f37864bu.intValue())) {
            this.f37856bm = Math.max(this.f37856bm, d10 - this.f37864bu.intValue());
        }
        if (d11 - this.f37865bv.intValue() < 0.0d && m50264a(this.f37858bo, d11 - this.f37865bv.intValue())) {
            this.f37858bo = Math.min(this.f37858bo, d11 - this.f37865bv.intValue());
        } else if (m50264a(this.f37859bp, d11 - this.f37865bv.intValue())) {
            this.f37859bp = Math.max(this.f37859bp, d11 - this.f37865bv.intValue());
        }
        if (d12 - this.f37866bw.intValue() < 0.0d && m50264a(this.f37861br, d12 - this.f37866bw.intValue())) {
            this.f37861br = Math.min(this.f37861br, d12 - this.f37866bw.intValue());
        } else if (m50264a(this.f37862bs, d12 - this.f37866bw.intValue())) {
            this.f37862bs = Math.max(this.f37862bs, d12 - this.f37866bw.intValue());
        }
    }

    /* renamed from: a */
    public void m50297a(Context context) {
        int iM47583h;
        if (this.f37788U <= 0 && C6982bz.m41148a(context).mo41171a(context)) {
            iM47583h = Math.max(this.f37788U, C6982bz.m41148a(context).mo41169a(this));
        } else if (this.f37788U > 0 || C6982bz.m41148a(context).mo41171a(context)) {
            return;
        } else {
            iM47583h = AbstractC7741ao.m47583h(context);
        }
        this.f37788U = iM47583h;
    }

    /* renamed from: a */
    private boolean m50264a(double d10, double d11) {
        return ((double) this.f37807aQ) > Math.abs(d11) || Math.abs(d10) > Math.abs(d11) / 2.0d;
    }
}
