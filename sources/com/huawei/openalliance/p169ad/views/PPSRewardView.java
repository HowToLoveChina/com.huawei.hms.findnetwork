package com.huawei.openalliance.p169ad.views;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.AbstractC7572pf;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7331je;
import com.huawei.openalliance.p169ad.C7517nl;
import com.huawei.openalliance.p169ad.C7521np;
import com.huawei.openalliance.p169ad.C7580pn;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.C7722uq;
import com.huawei.openalliance.p169ad.C7725ut;
import com.huawei.openalliance.p169ad.C7848uu;
import com.huawei.openalliance.p169ad.C7849uv;
import com.huawei.openalliance.p169ad.C7851ux;
import com.huawei.openalliance.p169ad.C7853uz;
import com.huawei.openalliance.p169ad.C7855va;
import com.huawei.openalliance.p169ad.C7859ve;
import com.huawei.openalliance.p169ad.C7860vf;
import com.huawei.openalliance.p169ad.C7861vg;
import com.huawei.openalliance.p169ad.C7862vh;
import com.huawei.openalliance.p169ad.C8188vj;
import com.huawei.openalliance.p169ad.DialogInterfaceOnCancelListenerC7717ul;
import com.huawei.openalliance.p169ad.DialogInterfaceOnCancelListenerC7850uw;
import com.huawei.openalliance.p169ad.DialogInterfaceOnCancelListenerC7863vi;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.InterfaceC7537oe;
import com.huawei.openalliance.p169ad.RunnableC7718um;
import com.huawei.openalliance.p169ad.RunnableC7857vc;
import com.huawei.openalliance.p169ad.ViewOnClickListenerC7719un;
import com.huawei.openalliance.p169ad.ViewOnClickListenerC7852uy;
import com.huawei.openalliance.p169ad.ViewOnClickListenerC7858vd;
import com.huawei.openalliance.p169ad.ViewOnTouchListenerC7720uo;
import com.huawei.openalliance.p169ad.activity.PPSRewardActivity;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.constant.AdConfigMapKey;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.DialogClickType;
import com.huawei.openalliance.p169ad.constant.RewardMethods;
import com.huawei.openalliance.p169ad.download.InterfaceC7069l;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.download.app.C7046e;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.C7305h;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.RewardEvent;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7731ae;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.AbstractC7846y;
import com.huawei.openalliance.p169ad.utils.C7747au;
import com.huawei.openalliance.p169ad.utils.C7748av;
import com.huawei.openalliance.p169ad.utils.C7749aw;
import com.huawei.openalliance.p169ad.utils.C7756bc;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.utils.C7818dk;
import com.huawei.openalliance.p169ad.utils.C7822do;
import com.huawei.openalliance.p169ad.views.gif.C8101b;
import com.huawei.openalliance.p169ad.views.interfaces.C8109b;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8108ab;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k;
import java.util.Map;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSRewardView extends AutoScaleSizeRelativeLayout implements C7331je.a, InterfaceC7403lm, SegmentMediaStateListener, IViewLifeCycle, InterfaceC8118k {

    /* renamed from: A */
    private int f36985A;

    /* renamed from: B */
    private ViewGroup f36986B;

    /* renamed from: C */
    private PPSAppDetailTemplateView f36987C;

    /* renamed from: D */
    private TextView f36988D;

    /* renamed from: E */
    private MaterialClickInfo f36989E;

    /* renamed from: F */
    private boolean f36990F;

    /* renamed from: G */
    private boolean f36991G;

    /* renamed from: H */
    private MuteListener f36992H;

    /* renamed from: I */
    private NetworkChangeListener f36993I;

    /* renamed from: J */
    private InterfaceC7069l f36994J;

    /* renamed from: K */
    private boolean f36995K;

    /* renamed from: L */
    private boolean f36996L;

    /* renamed from: M */
    private int f36997M;

    /* renamed from: N */
    private long f36998N;

    /* renamed from: O */
    private PPSWebView f36999O;

    /* renamed from: P */
    private Dialog f37000P;

    /* renamed from: Q */
    private Dialog f37001Q;

    /* renamed from: R */
    private IRewardAdStatusListener f37002R;

    /* renamed from: S */
    private INonwifiActionListener f37003S;

    /* renamed from: T */
    private PPSAppDetailView f37004T;

    /* renamed from: U */
    private PPSAppDetailView f37005U;

    /* renamed from: V */
    private PPSExpandButtonDetailView f37006V;

    /* renamed from: W */
    private C8149s f37007W;

    /* renamed from: a */
    private final C7722uq f37008a;

    /* renamed from: aa */
    private TextView f37009aa;

    /* renamed from: ab */
    private AdLandingPageData f37010ab;

    /* renamed from: ac */
    private C7748av f37011ac;

    /* renamed from: ad */
    private boolean f37012ad;

    /* renamed from: ae */
    private ChoicesView f37013ae;

    /* renamed from: af */
    private boolean f37014af;

    /* renamed from: ag */
    private boolean f37015ag;

    /* renamed from: ah */
    private boolean f37016ah;

    /* renamed from: ai */
    private boolean f37017ai;

    /* renamed from: aj */
    private boolean f37018aj;

    /* renamed from: ak */
    private boolean f37019ak;

    /* renamed from: al */
    private C8150t f37020al;

    /* renamed from: am */
    private boolean f37021am;

    /* renamed from: an */
    private C8085f f37022an;

    /* renamed from: ao */
    private boolean f37023ao;

    /* renamed from: ap */
    private boolean f37024ap;

    /* renamed from: aq */
    private RelativeLayout f37025aq;

    /* renamed from: ar */
    private LinearLayout f37026ar;

    /* renamed from: as */
    private C7749aw f37027as;

    /* renamed from: at */
    private View.OnClickListener f37028at;

    /* renamed from: au */
    private VideoInfo f37029au;

    /* renamed from: av */
    private TextView f37030av;

    /* renamed from: aw */
    private int f37031aw;

    /* renamed from: ax */
    private String f37032ax;

    /* renamed from: b */
    private InterfaceC7537oe f37033b;

    /* renamed from: c */
    private C7331je f37034c;

    /* renamed from: d */
    private C7305h f37035d;

    /* renamed from: e */
    private boolean f37036e;

    /* renamed from: f */
    private boolean f37037f;

    /* renamed from: g */
    private RewardVideoView f37038g;

    /* renamed from: h */
    private int f37039h;

    /* renamed from: i */
    private int f37040i;

    /* renamed from: j */
    private int f37041j;

    /* renamed from: k */
    private TextView f37042k;

    /* renamed from: l */
    private ImageView f37043l;

    /* renamed from: m */
    private ImageView f37044m;

    /* renamed from: n */
    private boolean f37045n;

    /* renamed from: o */
    private int f37046o;

    /* renamed from: p */
    private boolean f37047p;

    /* renamed from: q */
    private Context f37048q;

    /* renamed from: r */
    private ContentRecord f37049r;

    /* renamed from: s */
    private ProgressBar f37050s;

    /* renamed from: t */
    private PPSLabelSourceView f37051t;

    /* renamed from: u */
    private PPSLabelView f37052u;

    /* renamed from: v */
    private boolean f37053v;

    /* renamed from: w */
    private boolean f37054w;

    /* renamed from: x */
    private C7022dk f37055x;

    /* renamed from: y */
    private AlertDialog f37056y;

    /* renamed from: z */
    private C8150t f37057z;

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$1 */
    public class RunnableC80041 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ IRewardAd f37058a;

        /* renamed from: b */
        final /* synthetic */ boolean f37059b;

        public RunnableC80041(IRewardAd iRewardAd, boolean z10) {
            iRewardAd = iRewardAd;
            z = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            IRewardAd iRewardAd;
            try {
                iRewardAd = iRewardAd;
            } catch (Throwable th2) {
                AbstractC7185ho.m43826d("PPSRewardView", "refresh ui error " + th2.getClass().getSimpleName());
            }
            if (!(iRewardAd instanceof C7305h)) {
                PPSRewardView.this.mo49489c();
                AbstractC7185ho.m43823c("PPSRewardView", "there is no reward ad");
                return;
            }
            PPSRewardView.this.f37035d = (C7305h) iRewardAd;
            PPSRewardView pPSRewardView = PPSRewardView.this;
            pPSRewardView.setContentRecord(C7580pn.m46793a(pPSRewardView.f37035d));
            PPSRewardView pPSRewardView2 = PPSRewardView.this;
            pPSRewardView2.m49535a(pPSRewardView2.getContext(), PPSRewardView.this.f37049r);
            if (PPSRewardView.this.f37035d.m44947ab()) {
                PPSRewardView.this.mo49489c();
            }
            PPSRewardView pPSRewardView3 = PPSRewardView.this;
            pPSRewardView3.f37029au = pPSRewardView3.f37035d.m44918K();
            if (PPSRewardView.this.f37029au == null) {
                AbstractC7185ho.m43823c("PPSRewardView", "there is no video");
                return;
            }
            AbstractC7185ho.m43820b("PPSRewardView", "register:" + iRewardAd.getContentId());
            PPSRewardView.this.m49588w();
            PPSRewardView.this.m49582t();
            PPSRewardView.this.m49564f(z);
            PPSRewardView.this.m49523V();
            PPSRewardView.this.m49587v();
            if (!PPSRewardView.this.f37014af) {
                String adChoiceUrl = iRewardAd.getAdChoiceUrl();
                String adChoiceIcon = iRewardAd.getAdChoiceIcon();
                if (!TextUtils.isEmpty(adChoiceUrl)) {
                    if (TextUtils.isEmpty(adChoiceIcon)) {
                        PPSRewardView.this.f37013ae.m30230b();
                    } else {
                        PPSRewardView.this.f37013ae.setAdChoiceIcon(adChoiceIcon);
                    }
                }
                PPSRewardView.this.f37013ae.setOnClickListener(new ViewOnClickListenerC7719un(PPSRewardView.this, iRewardAd));
            }
            if (PPSRewardView.this.f37002R != null) {
                PPSRewardView.this.f37002R.onAdShown();
            }
            PPSRewardView.this.f37035d.m44965f(true);
            C7722uq c7722uq = PPSRewardView.this.f37008a;
            PPSRewardView pPSRewardView4 = PPSRewardView.this;
            c7722uq.m47414a(pPSRewardView4, iRewardAd, pPSRewardView4.f37038g);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$10 */
    public class RunnableC800510 implements Runnable {
        public RunnableC800510() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            AbstractC7185ho.m43820b("PPSRewardView", RewardMethods.RESUME_VIEW);
            if (RunnableC7857vc.m48635a(PPSRewardView.this.f37000P) || RunnableC7857vc.m48635a(PPSRewardView.this.getNonwifiDialog()) || RunnableC7857vc.m48635a(PPSRewardView.this.getAdDialog())) {
                str = "do not resume when dialog is showing";
            } else {
                if (PPSRewardView.this.f36999O == null || PPSRewardView.this.f36999O.getVisibility() != 0) {
                    if (PPSRewardView.this.f37038g == null || PPSRewardView.this.m49608r()) {
                        return;
                    }
                    PPSRewardView.this.f37038g.resumeView();
                    if (PPSRewardView.this.f37047p) {
                        PPSRewardView.this.f37038g.mo49873a(true, PPSRewardView.this.f36995K);
                        return;
                    }
                    return;
                }
                str = "do not resume landing page is showing";
            }
            AbstractC7185ho.m43820b("PPSRewardView", str);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$11 */
    public class RunnableC800611 implements Runnable {
        public RunnableC800611() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43820b("PPSRewardView", RewardMethods.PAUSE_VIEW);
            if (PPSRewardView.this.f37038g != null) {
                PPSRewardView.this.f37038g.pauseView();
                PPSRewardView.this.f37038g.mo49869a();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$12 */
    public class RunnableC800712 implements Runnable {
        public RunnableC800712() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43820b("PPSRewardView", RewardMethods.STOP_VIEW);
            if (PPSRewardView.this.f36999O != null && C7756bc.m47710e(PPSRewardView.this.f37035d.m44904D()) && PPSRewardView.this.f37024ap) {
                PPSRewardView.this.f36999O.onStop();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$2 */
    public class RunnableC80082 implements Runnable {
        public RunnableC80082() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43820b("PPSRewardView", RewardMethods.DESTROY_VIEW);
            if (PPSRewardView.this.f37035d != null && PPSRewardView.this.f37035d.getAppInfo() != null) {
                C7046e.m42377h().m42399b(PPSRewardView.this.f37035d.getAppInfo(), PPSRewardView.this.f36994J);
            }
            if (PPSRewardView.this.f37038g != null) {
                PPSRewardView.this.f37038g.mo49874b();
                PPSRewardView.this.f37038g.destroyView();
            }
            if (PPSRewardView.this.f36999O != null) {
                PPSRewardView.this.f36999O.destroy();
            }
            if (PPSRewardView.this.f37000P != null) {
                if (PPSRewardView.this.f37000P.isShowing()) {
                    PPSRewardView.this.f37000P.dismiss();
                }
                PPSRewardView.this.f37000P = null;
            }
            if (PPSRewardView.this.getAdDialog() != null) {
                if (PPSRewardView.this.getAdDialog().isShowing() && PPSRewardView.this.getPopUpView() != null) {
                    PPSRewardView.this.getPopUpView().m50512b();
                }
                PPSRewardView.this.setAdDialog(null);
            }
            PPSRewardView.this.f37008a.m47415b();
            if (PPSRewardView.this.f37057z != null) {
                PPSRewardView.this.f37057z.m50513c();
                PPSRewardView.this.f37057z = null;
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$3 */
    public class RunnableC80093 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RewardEvent f37065a;

        /* renamed from: b */
        final /* synthetic */ boolean f37066b;

        public RunnableC80093(RewardEvent rewardEvent, boolean z10) {
            rewardEvent = rewardEvent;
            z = z10;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            AbstractC7185ho.m43821b("PPSRewardView", "onEvent: %s", rewardEvent.m44553a());
            RewardEvent rewardEvent = RewardEvent.CLOSE;
            RewardEvent rewardEvent2 = rewardEvent;
            if (rewardEvent != rewardEvent2 && (RewardEvent.BACKPRESSED != rewardEvent2 || PPSRewardView.this.m49526Y())) {
                return;
            }
            PPSRewardView.this.m49600d(z);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$4 */
    public class RunnableC80104 implements Runnable {
        public RunnableC80104() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PPSRewardView.this.mo49489c();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$5 */
    public class RunnableC80115 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ VideoInfo f37069a;

        /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$5$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PPSRewardView.this.f37047p = true;
                PPSRewardView.this.f37012ad = false;
                if (PPSRewardView.this.f37038g != null) {
                    PPSRewardView.this.f37038g.mo49873a(true, PPSRewardView.this.f36995K);
                }
            }
        }

        public RunnableC80115(VideoInfo videoInfo) {
            videoInfo = videoInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((PPSRewardView.this.f37003S == null || !PPSRewardView.this.f37003S.onVideoPlay(videoInfo.getVideoFileSize())) && (PPSRewardView.this.f37035d == null || PPSRewardView.this.f37035d.m44951af())) {
                PPSRewardView.this.m49505D();
            } else {
                AbstractC7185ho.m43820b("PPSRewardView", "app has handled, do not pop up dialog");
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.5.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        PPSRewardView.this.f37047p = true;
                        PPSRewardView.this.f37012ad = false;
                        if (PPSRewardView.this.f37038g != null) {
                            PPSRewardView.this.f37038g.mo49873a(true, PPSRewardView.this.f36995K);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$6 */
    public class RunnableC80126 implements Runnable {
        public RunnableC80126() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43820b("PPSRewardView", "onClose");
            if (PPSRewardView.this.f37033b != null) {
                PPSRewardView.this.f37033b.mo46180a();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$7 */
    public class RunnableC80137 implements Runnable {
        public RunnableC80137() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            AbstractC7185ho.m43820b("PPSRewardView", "manual play()");
            if (PPSRewardView.this.f37035d != null) {
                PPSRewardView pPSRewardView = PPSRewardView.this;
                pPSRewardView.m49538a(pPSRewardView.f37035d.m44918K());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$8 */
    public class RunnableC80148 implements Runnable {
        public RunnableC80148() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43820b("PPSRewardView", "muteSound");
            PPSRewardView.this.f36995K = true;
            if (PPSRewardView.this.f37038g != null) {
                PPSRewardView.this.f37038g.mo49875c();
                if (PPSRewardView.this.f37033b != null) {
                    PPSRewardView.this.f37033b.mo46185a(true);
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$9 */
    public class RunnableC80159 implements Runnable {
        public RunnableC80159() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43820b("PPSRewardView", "unmuteSound");
            PPSRewardView.this.f36995K = false;
            if (PPSRewardView.this.f37038g != null) {
                PPSRewardView.this.f37038g.mo49876d();
                if (PPSRewardView.this.f37033b != null) {
                    PPSRewardView.this.f37033b.mo46185a(false);
                }
            }
        }
    }

    @OuterVisible
    public PPSRewardView(Context context) {
        super(context);
        this.f37008a = new C7722uq();
        this.f37036e = false;
        this.f37037f = false;
        this.f37045n = false;
        this.f37046o = 1;
        this.f37047p = true;
        this.f37053v = false;
        this.f37054w = false;
        this.f37056y = null;
        this.f36990F = false;
        this.f36991G = false;
        this.f36992H = new C7853uz(this);
        this.f36993I = new C7855va(this);
        this.f36994J = new C7860vf(this);
        this.f36995K = true;
        this.f36996L = false;
        this.f36997M = -1;
        this.f36998N = -1L;
        this.f37012ad = true;
        this.f37014af = true;
        this.f37015ag = false;
        this.f37016ah = true;
        this.f37017ai = false;
        this.f37018aj = true;
        this.f37019ak = false;
        this.f37021am = false;
        this.f37023ao = true;
        this.f37024ap = false;
        this.f37028at = new ViewOnClickListenerC7858vd(this);
        m49533a(context);
    }

    /* renamed from: A */
    private void m49502A() {
        C7749aw c7749aw = new C7749aw(getContext(), this.f37010ab, getAppDetailView().getAppDownloadButton(), this.f36999O, new C8188vj(this));
        this.f37027as = c7749aw;
        c7749aw.m47669a(1);
        this.f36999O.addJavascriptInterface(this.f37027as, Constants.PPS_JS_NAME);
        this.f36999O.addJavascriptInterface(new C7747au(getContext(), AbstractC7572pf.m46743a(this.f37010ab)), Constants.LANDING_JS_NAME);
        C7748av c7748av = new C7748av(getContext(), AbstractC7572pf.m46743a(this.f37010ab), this.f36999O);
        this.f37011ac = c7748av;
        this.f36999O.addJavascriptInterface(c7748av, Constants.APPOINT_JS_NAME);
    }

    /* renamed from: B */
    private void m49503B() {
        TextView textView;
        if (m49504C() && (textView = this.f36988D) != null && this.f36985A == 3) {
            textView.setVisibility(8);
        }
    }

    /* renamed from: C */
    private boolean m49504C() {
        return AbstractC7558os.m46467f(this.f37035d.getCtrlSwitchs()) == 2 || AbstractC7741ao.m47592n(this.f37048q);
    }

    /* renamed from: D */
    public void m49505D() {
        AbstractC7817dj.m48363a(new RunnableC7857vc(this));
    }

    /* renamed from: E */
    private boolean m49506E() {
        VideoInfo videoInfo = this.f37029au;
        if (videoInfo == null) {
            return false;
        }
        String videoDownloadUrl = videoInfo.getVideoDownloadUrl();
        return (AbstractC7806cz.m48181j(videoDownloadUrl) && TextUtils.isEmpty(this.f37055x.m41970e(videoDownloadUrl))) ? false : true;
    }

    /* renamed from: F */
    private void m49507F() throws Resources.NotFoundException {
        Toast toastMakeText = Toast.makeText(getContext(), C6849R.string.hiad_network_error, 0);
        toastMakeText.setGravity(17, 0, 0);
        toastMakeText.show();
    }

    /* renamed from: G */
    private void m49508G() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.6
            public RunnableC80126() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSRewardView", "onClose");
                if (PPSRewardView.this.f37033b != null) {
                    PPSRewardView.this.f37033b.mo46180a();
                }
            }
        });
        this.f37008a.m47415b();
    }

    /* renamed from: H */
    private void m49509H() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.8
            public RunnableC80148() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSRewardView", "muteSound");
                PPSRewardView.this.f36995K = true;
                if (PPSRewardView.this.f37038g != null) {
                    PPSRewardView.this.f37038g.mo49875c();
                    if (PPSRewardView.this.f37033b != null) {
                        PPSRewardView.this.f37033b.mo46185a(true);
                    }
                }
            }
        });
    }

    /* renamed from: I */
    private void m49510I() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.9
            public RunnableC80159() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSRewardView", "unmuteSound");
                PPSRewardView.this.f36995K = false;
                if (PPSRewardView.this.f37038g != null) {
                    PPSRewardView.this.f37038g.mo49876d();
                    if (PPSRewardView.this.f37033b != null) {
                        PPSRewardView.this.f37033b.mo46185a(false);
                    }
                }
            }
        });
    }

    /* renamed from: J */
    private void m49511J() throws Resources.NotFoundException {
        if (this.f37000P == null) {
            Resources resources = getResources();
            int i10 = C6849R.plurals.hiad_reward_close_dialog_message;
            int i11 = this.f37040i;
            Dialog dialogM48620a = AbstractC7846y.m48620a(getContext(), (String) null, resources.getQuantityString(i10, i11, Integer.valueOf(i11)), getResources().getString(C6849R.string.hiad_reward_close_dialog_continue), getResources().getString(C6849R.string.hiad_reward_close_dialog_close), new C7849uv(this));
            this.f37000P = dialogM48620a;
            dialogM48620a.setOnCancelListener(new DialogInterfaceOnCancelListenerC7850uw(this));
        }
    }

    /* renamed from: K */
    private void m49512K() {
        m49508G();
        IRewardAdStatusListener iRewardAdStatusListener = this.f37002R;
        if (iRewardAdStatusListener != null) {
            iRewardAdStatusListener.onAdClosed();
        }
    }

    /* renamed from: L */
    private void m49513L() {
        ImageView imageView = this.f37044m;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* renamed from: M */
    private void m49514M() {
        if (this.f37043l == null) {
            return;
        }
        this.f37043l.setImageResource(AbstractC7811dd.m48283a(this.f36985A, this.f36995K));
    }

    /* renamed from: N */
    private void m49515N() {
        m49597b("-1");
        m49522U();
    }

    /* renamed from: O */
    private void m49516O() {
        m49597b("1");
    }

    /* renamed from: P */
    private boolean m49517P() {
        m49526Y();
        if (!this.f37016ah) {
            if (!m49521T()) {
                return false;
            }
            m49519R();
            return true;
        }
        setBottomViewVisibility(8);
        if (getEndCardView() != null) {
            getEndCardView().m50496a();
        }
        m49518Q();
        this.f37053v = true;
        return true;
    }

    /* renamed from: Q */
    private void m49518Q() {
        if (!this.f37017ai || TextUtils.isEmpty(this.f37035d.m44912H())) {
            return;
        }
        this.f37022an = new C8085f(this.f37048q);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = this.f37025aq;
        if (relativeLayout != null) {
            relativeLayout.addView(this.f37022an, layoutParams);
        }
        LinearLayout linearLayout = this.f37026ar;
        if (linearLayout != null) {
            linearLayout.bringToFront();
        }
        this.f37022an.setOnClickListener(new ViewOnClickListenerC7852uy(this));
    }

    /* renamed from: R */
    private void m49519R() {
        ProgressBar progressBar;
        setAppDetailViewType(1);
        PPSWebView pPSWebView = this.f36999O;
        if (pPSWebView != null) {
            if (!this.f37023ao) {
                pPSWebView.loadPage();
                this.f37024ap = true;
                this.f36999O.onResume();
            }
            if (!this.f36996L && (progressBar = this.f37050s) != null) {
                progressBar.setVisibility(8);
            }
            m49597b("2");
            RewardVideoView rewardVideoView = this.f37038g;
            if (rewardVideoView != null) {
                rewardVideoView.setVisibility(4);
            }
            m49520S();
            this.f36999O.setVisibility(0);
            C7749aw c7749aw = this.f37027as;
            if (c7749aw != null) {
                c7749aw.m47670a(false);
            }
            this.f36999O.setRealOpenTime(System.currentTimeMillis());
        }
        if ("1".equals(this.f37035d.m44949ad()) && AbstractC7558os.m46470i(this.f37035d.getCtrlSwitchs())) {
            getAppDetailView().setVisibility(8);
        }
        if (C7521np.m46174a(this.f37049r)) {
            ((PPSRewardActivity) getContext()).setRequestedOrientation(1);
        }
        if (this.f36990F) {
            this.f36990F = false;
            Toast.makeText(getContext(), C6849R.string.hiad_third_party_page_hint, 0).show();
        }
        m49525X();
    }

    /* renamed from: S */
    private void m49520S() {
        PPSAppDetailTemplateView pPSAppDetailTemplateView = this.f36987C;
        if (pPSAppDetailTemplateView != null) {
            pPSAppDetailTemplateView.setVisibility(4);
        }
        TextView textView = this.f36988D;
        if (textView != null) {
            textView.setVisibility(4);
        }
        if (this.f37006V == null || !this.f37033b.mo46192b(this.f37049r)) {
            return;
        }
        int i10 = this.f36985A;
        if (i10 == 4 || i10 == 5) {
            this.f37006V.setExtraViewVisibility(0);
        }
    }

    /* renamed from: T */
    private boolean m49521T() {
        return this.f37033b.mo46193b(this.f37035d) && !TextUtils.isEmpty(this.f37035d.m44912H());
    }

    /* renamed from: U */
    private void m49522U() {
        if (!this.f37054w && m49517P()) {
            this.f37054w = true;
        }
        TextView textView = this.f37042k;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f37043l;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        RewardVideoView rewardVideoView = this.f37038g;
        if (rewardVideoView != null) {
            rewardVideoView.m49906f();
        }
        if (this.f37002R == null || !m49608r()) {
            return;
        }
        this.f37002R.onAdCompleted();
    }

    /* renamed from: V */
    public void m49523V() {
        boolean zM46473l = AbstractC7558os.m46473l(this.f37035d.getCtrlSwitchs());
        this.f37016ah = zM46473l;
        if (!zM46473l) {
            AbstractC7185ho.m43820b("PPSRewardView", "switch is off, skip init endCard.");
            return;
        }
        if (this.f37035d.m44904D() == 0) {
            this.f37016ah = false;
            AbstractC7185ho.m43820b("PPSRewardView", "display type, skip init endCard.");
            return;
        }
        if (!C7756bc.m47711f(this.f37035d.m44904D()) && this.f37035d.getAppInfo() == null) {
            this.f37016ah = false;
            AbstractC7185ho.m43820b("PPSRewardView", "appInfo is null, skip init endCard.");
            return;
        }
        boolean zMo43045W = C7124fh.m43316b(this.f37048q).mo43045W();
        this.f37017ai = zMo43045W;
        AbstractC7185ho.m43821b("PPSRewardView", "init endCard, showMasking: %s", Boolean.valueOf(zMo43045W));
        this.f37007W = new C8149s(getContext(), getOrientation(), this.f37049r);
        if (C7756bc.m47711f(this.f37035d.m44904D())) {
            getEndCardView().setAppRelated(false);
        }
        getEndCardView().setInterType(this.f37035d.m44904D());
        getEndCardView().setAdLandingPageData(this.f37010ab);
        getEndCardView().setEndCardClickListener(new C7851ux(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f37025aq.addView(getEndCardView(), layoutParams);
        getEndCardView().m50499b();
    }

    /* renamed from: W */
    private void m49524W() {
        if (getWebPopUpView() == null) {
            setWebPopUpView(new C8150t(getContext(), 0));
            getWebPopUpView().setPopUpClickListener(new C7862vh(this));
            getWebPopUpView().getDialog().setOnCancelListener(new DialogInterfaceOnCancelListenerC7863vi(this));
        }
    }

    /* renamed from: X */
    private void m49525X() {
        AdLandingPageData adLandingPageData = this.f37010ab;
        if (adLandingPageData == null) {
            return;
        }
        if (AbstractC7558os.m46454B(adLandingPageData.m44290f()) != 2) {
            AbstractC7185ho.m43818a("PPSRewardView", "no need popup strategy %s.", Integer.valueOf(AbstractC7558os.m46454B(this.f37010ab.m44290f())));
            return;
        }
        if (this.f37010ab.getAppInfo() == null || this.f37010ab.m44307n() == null) {
            AbstractC7185ho.m43817a("PPSRewardView", "app or pageType para error.");
            return;
        }
        if (!"1".equals(this.f37010ab.m44307n()) && !"2".equals(this.f37010ab.m44307n())) {
            AbstractC7185ho.m43817a("PPSRewardView", "landing type no need pop.");
            return;
        }
        if (!this.f37033b.mo46193b(this.f37035d)) {
            AbstractC7185ho.m43817a("PPSRewardView", "not download related no need pop.");
            return;
        }
        long jM44346D = this.f37010ab.getAppInfo().m44346D();
        if (jM44346D < 0) {
            AbstractC7185ho.m43824c("PPSRewardView", "delay time error:%s", Long.valueOf(jM44346D));
        } else {
            AbstractC7185ho.m43821b("PPSRewardView", "show app download dialog start delayTime %s", Long.valueOf(jM44346D));
            AbstractC7817dj.m48364a(new RunnableC7718um(this), jM44346D);
        }
    }

    /* renamed from: Y */
    public boolean m49526Y() {
        PPSLabelView pPSLabelView = this.f37052u;
        if (pPSLabelView == null || !pPSLabelView.m49218c()) {
            return false;
        }
        this.f37052u.m49216b();
        return true;
    }

    /* renamed from: a */
    private int m49527a(int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 < 0) {
            return 0;
        }
        return i12;
    }

    /* renamed from: b */
    private int m49544b(int i10) {
        String str;
        int iM49560e;
        setContentRecord(C7580pn.m46793a(this.f37035d));
        Map<String, String> mapM41458aJ = this.f37049r.m41458aJ();
        if (mapM41458aJ != null) {
            str = mapM41458aJ.get(AdConfigMapKey.MAPKEY_RWDCLOSTBTN);
            iM49560e = m49560e(str);
        } else {
            str = "";
            iM49560e = 90;
        }
        AbstractC7185ho.m43820b("PPSRewardView", "Reward close button input string is " + str);
        return Math.min((i10 * iM49560e) / 100000, 27);
    }

    /* renamed from: d */
    private int m49555d(int i10) {
        return m49527a(i10, this.f37040i);
    }

    /* renamed from: e */
    private int m49559e(int i10) {
        return m49527a(i10, this.f37039h / 1000);
    }

    /* renamed from: h */
    private void m49568h(int i10) {
        if (this.f37035d.m44947ab()) {
            return;
        }
        int i11 = this.f37040i;
        int i12 = i11 - i10;
        if ((i12 >= 0 && i12 != 0) || i11 <= 0) {
            return;
        }
        m49516O();
    }

    /* renamed from: s */
    private void m49580s() {
        this.f37042k.setMaxWidth((int) (AbstractC7807d.m48203a(getContext(), AbstractC7811dd.m48335k(getContext())) * 0.5d));
    }

    private void setAppDetailViewType(int i10) {
        if (getAppDetailView() != null) {
            getAppDetailView().setDetailViewType(i10);
        }
    }

    private void setBottomViewVisibility(int i10) {
        if (this.f37019ak || this.f37035d.getAppInfo() != null) {
            getAppDetailView().setVisibility(i10);
        }
        this.f37052u.setVisibility(i10);
        if (this.f37009aa != null && !AbstractC7806cz.m48165b(this.f37035d.getLabel())) {
            this.f37009aa.setVisibility(i10);
        }
        TextView textView = this.f37030av;
        if (textView != null) {
            textView.setVisibility(i10);
        }
        C7822do.m48380a(this.f37051t);
    }

    /* renamed from: t */
    public void m49582t() {
        PPSAppDetailTemplateView pPSAppDetailTemplateView;
        AbstractC7185ho.m43820b("PPSRewardView", "initTemplateView");
        if (this.f37033b.mo46192b(this.f37049r)) {
            int i10 = this.f36985A;
            if ((i10 != 3 && i10 != 4 && i10 != 5) || (pPSAppDetailTemplateView = this.f36987C) == null || this.f36988D == null) {
                return;
            }
            pPSAppDetailTemplateView.setVisibility(0);
            this.f36987C.setAdLandingData(this.f37010ab);
            C7305h c7305h = this.f37035d;
            if (c7305h == null || c7305h.getAppInfo() == null || TextUtils.isEmpty(this.f37035d.getAppInfo().getAppDesc())) {
                this.f36988D.setVisibility(4);
            } else {
                this.f36988D.setVisibility(0);
                this.f36988D.setText(this.f37035d.getAppInfo().getAppDesc());
            }
            m49546b(this.f37048q);
            m49503B();
        }
    }

    /* renamed from: w */
    public void m49588w() {
        int i10;
        AbstractC7185ho.m43820b("PPSRewardView", "initContentView");
        this.f37052u.setDataAndRefreshUi(this.f37049r);
        if (this.f37033b.mo46192b(this.f37049r) && ((i10 = this.f36985A) == 4 || i10 == 5)) {
            PPSExpandButtonDetailView pPSExpandButtonDetailView = this.f37006V;
            this.f37004T = pPSExpandButtonDetailView;
            pPSExpandButtonDetailView.setExtraViewVisibility(8);
        } else {
            this.f37004T = m49504C() ? this.f37006V : this.f37005U;
            getAppDetailView().setBackgroundColor(getResources().getColor(C6849R.color.hiad_90_percent_white));
        }
        getAppDetailView().setVisibility(0);
        this.f36995K = this.f37035d.m44939Y();
        this.f37023ao = C7124fh.m43316b(this.f37048q).mo43047Y();
        if (C7521np.m46174a(this.f37049r)) {
            this.f37023ao = false;
            ((RelativeLayout.LayoutParams) this.f37025aq.getLayoutParams()).addRule(2, C6849R.id.reward_download_container);
        }
        this.f37010ab = new AdLandingPageData(C7580pn.m46793a(this.f37035d), getContext(), true);
        m49514M();
        this.f37010ab.m44289e(this.f37035d.m44951af());
        m49592z();
        if (this.f37033b.mo46187a(this.f37035d)) {
            this.f37010ab.m44282c(true);
            C7046e.m42377h().m42388a(this.f37035d.getAppInfo(), this.f36994J);
        } else {
            m49591y();
        }
        getAppDetailView().setAppDetailClickListener(new C7848uu(this));
        getAppDetailView().setNeedPerBeforDownload(true);
        if (m49590x()) {
            getAppDetailView().setLoadAppIconSelf(false);
        }
        getAppDetailView().setAdLandingData(this.f37010ab);
        getAppDetailView().setInteractedListener(new C7725ut(this));
        getAppDetailView().setInterType(this.f37035d.m44904D());
        m49537a(this.f37049r.m41484af());
        this.f37052u.m49210a(AdSource.m39547a(this.f37035d.m44665t()), this.f37035d.m44667u());
        String strM47859a = C7780c.m47859a(this.f37049r, getContext(), true);
        this.f37032ax = strM47859a;
        m49557d(strM47859a);
        C7822do.m48380a(this.f37051t);
        this.f36990F = this.f37033b.mo46195c();
    }

    /* renamed from: x */
    private boolean m49590x() {
        int i10 = this.f36985A;
        return i10 == 1 || i10 == 3 || i10 == 4 || i10 == 5;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002b A[PHI: r1
  0x002b: PHI (r1v7 java.util.List<com.huawei.openalliance.ad.inter.data.ImageInfo>) = 
  (r1v5 java.util.List<com.huawei.openalliance.ad.inter.data.ImageInfo>)
  (r1v3 java.util.List<com.huawei.openalliance.ad.inter.data.ImageInfo>)
 binds: [B:23:0x0043, B:20:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m49591y() {
        /*
            r4 = this;
            com.huawei.openalliance.ad.inter.data.AppInfo r0 = new com.huawei.openalliance.ad.inter.data.AppInfo
            r0.<init>()
            com.huawei.openalliance.ad.inter.data.h r1 = r4.f37035d
            java.lang.String r1 = r1.m44906E()
            r0.m44419o(r1)
            com.huawei.openalliance.ad.inter.data.h r1 = r4.f37035d
            java.util.List r1 = r1.m44910G()
            boolean r2 = com.huawei.openalliance.p169ad.utils.AbstractC7760bg.m47767a(r1)
            r3 = 0
            if (r2 != 0) goto L39
            java.lang.Object r2 = r1.get(r3)
            com.huawei.openalliance.ad.inter.data.ImageInfo r2 = (com.huawei.openalliance.p169ad.inter.data.ImageInfo) r2
            java.lang.String r2 = r2.getUrl()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L39
        L2b:
            java.lang.Object r1 = r1.get(r3)
            com.huawei.openalliance.ad.inter.data.ImageInfo r1 = (com.huawei.openalliance.p169ad.inter.data.ImageInfo) r1
            java.lang.String r1 = r1.getUrl()
            r0.m44390d(r1)
            goto L46
        L39:
            com.huawei.openalliance.ad.inter.data.h r1 = r4.f37035d
            java.util.List r1 = r1.m44908F()
            boolean r2 = com.huawei.openalliance.p169ad.utils.AbstractC7760bg.m47767a(r1)
            if (r2 != 0) goto L46
            goto L2b
        L46:
            com.huawei.openalliance.ad.inter.data.AdLandingPageData r1 = r4.f37010ab
            r1.m44266a(r0)
            r0 = 1
            r4.f37019ak = r0
            com.huawei.openalliance.ad.views.PPSAppDetailView r0 = r4.getAppDetailView()
            r0.setAppRelated(r3)
            com.huawei.openalliance.ad.inter.data.h r0 = r4.f37035d
            int r0 = r0.m44904D()
            if (r0 != 0) goto L64
            com.huawei.openalliance.ad.views.PPSAppDetailView r4 = r4.getAppDetailView()
            r4.m48963b()
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.PPSRewardView.m49591y():void");
    }

    /* renamed from: z */
    private void m49592z() {
        PPSWebView pPSWebView = this.f36999O;
        if (pPSWebView != null) {
            pPSWebView.setVisibility(8);
            this.f36999O.setAdLandingPageData(this.f37010ab);
            m49502A();
            if (this.f37033b.mo46193b(this.f37035d) && this.f37023ao) {
                this.f36999O.loadPage();
                this.f37024ap = true;
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    @OuterVisible
    public void addNonwifiActionListener(INonwifiActionListener iNonwifiActionListener) {
        if (iNonwifiActionListener == null) {
            return;
        }
        this.f37003S = iNonwifiActionListener;
        if (getAppDetailView() != null) {
            getAppDetailView().setOnNonWifiDownloadListener(iNonwifiActionListener);
        }
        if (getEndCardView() != null) {
            getEndCardView().setOnNonWifiDownloadListener(iNonwifiActionListener);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    @OuterVisible
    public void addRewardAdStatusListener(IRewardAdStatusListener iRewardAdStatusListener) {
        if (iRewardAdStatusListener == null) {
            return;
        }
        this.f37002R = iRewardAdStatusListener;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    @OuterVisible
    public void destroyView() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.2
            public RunnableC80082() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSRewardView", RewardMethods.DESTROY_VIEW);
                if (PPSRewardView.this.f37035d != null && PPSRewardView.this.f37035d.getAppInfo() != null) {
                    C7046e.m42377h().m42399b(PPSRewardView.this.f37035d.getAppInfo(), PPSRewardView.this.f36994J);
                }
                if (PPSRewardView.this.f37038g != null) {
                    PPSRewardView.this.f37038g.mo49874b();
                    PPSRewardView.this.f37038g.destroyView();
                }
                if (PPSRewardView.this.f36999O != null) {
                    PPSRewardView.this.f36999O.destroy();
                }
                if (PPSRewardView.this.f37000P != null) {
                    if (PPSRewardView.this.f37000P.isShowing()) {
                        PPSRewardView.this.f37000P.dismiss();
                    }
                    PPSRewardView.this.f37000P = null;
                }
                if (PPSRewardView.this.getAdDialog() != null) {
                    if (PPSRewardView.this.getAdDialog().isShowing() && PPSRewardView.this.getPopUpView() != null) {
                        PPSRewardView.this.getPopUpView().m50512b();
                    }
                    PPSRewardView.this.setAdDialog(null);
                }
                PPSRewardView.this.f37008a.m47415b();
                if (PPSRewardView.this.f37057z != null) {
                    PPSRewardView.this.f37057z.m50513c();
                    PPSRewardView.this.f37057z = null;
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int iM47282a = C7694tp.m47282a(motionEvent);
            if (iM47282a == 0) {
                setClickInfo(C7694tp.m47283a(this, motionEvent));
                if (getEndCardView() != null && getEndCardView().getVisibility() == 0) {
                    getEndCardView().setButtonAndSixElementsClickInfo(getClickInfo());
                }
            }
            if (1 == iM47282a) {
                C7694tp.m47284a(this, motionEvent, null, getClickInfo());
                if (getEndCardView() != null && getEndCardView().getVisibility() == 0) {
                    getEndCardView().setButtonAndSixElementsClickInfo(getClickInfo());
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSRewardView", "dispatchTouchEvent exception : %s", th2.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: f */
    public void mo49494f() {
        setNonwifiDialog(null);
        this.f37047p = true;
        m49512K();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: g */
    public void mo49495g() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.12
            public RunnableC800712() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSRewardView", RewardMethods.STOP_VIEW);
                if (PPSRewardView.this.f36999O != null && C7756bc.m47710e(PPSRewardView.this.f37035d.m44904D()) && PPSRewardView.this.f37024ap) {
                    PPSRewardView.this.f36999O.onStop();
                }
            }
        });
    }

    public AlertDialog getAdDialog() {
        return this.f37056y;
    }

    public PPSAppDetailView getAppDetailView() {
        return this.f37004T;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public AppDownloadButton getAppDownloadButton() {
        if (getAppDetailView() == null) {
            return null;
        }
        return getAppDetailView().getAppDownloadButton();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public C7748av getAppointJs() {
        return this.f37011ac;
    }

    public MaterialClickInfo getClickInfo() {
        return this.f36989E;
    }

    public C8149s getEndCardView() {
        return this.f37007W;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public Dialog getNonwifiDialog() {
        return this.f37001Q;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    public int getOrientation() {
        return this.f37046o;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public C8150t getPopUpView() {
        return this.f37057z;
    }

    public C8150t getWebPopUpView() {
        return this.f37020al;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public WebSettings getWebViewSettings() {
        PPSWebView pPSWebView = this.f36999O;
        if (pPSWebView != null) {
            return pPSWebView.getSettings();
        }
        return null;
    }

    public int getmInsreTemplate() {
        return this.f36985A;
    }

    /* renamed from: n */
    public void m49605n() {
        AbstractC7185ho.m43821b("PPSRewardView", "handleMaskingClick, isDownloadAd: %s", Boolean.valueOf(this.f37033b.mo46193b(this.f37035d)));
        mo49481a((Integer) 14);
        this.f37033b.mo46186a(22, getClickInfo());
        C8085f c8085f = this.f37022an;
        if (c8085f != null) {
            c8085f.m50122a();
            removeView(this.f37022an);
        }
        if (getEndCardView() != null) {
            getEndCardView().m50499b();
        }
        setBottomViewVisibility(0);
        m49557d(this.f37032ax);
        this.f37053v = false;
        this.f37016ah = false;
        setClickInfo(null);
    }

    /* renamed from: o */
    public void m49606o() {
        getWebPopUpView().m50512b();
        setWebPopUpView(null);
        this.f37021am = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC7185ho.m43817a("PPSRewardView", "onAttachedToWindow");
        C7331je c7331je = this.f37034c;
        if (c7331je != null) {
            c7331je.m45301h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC7185ho.m43820b("PPSRewardView", "onDetechedFromWindow");
        C7331je c7331je = this.f37034c;
        if (c7331je != null) {
            c7331je.m45302i();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    @OuterVisible
    public void onEvent(RewardEvent rewardEvent) {
        onEvent(rewardEvent, false);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaCompletion(String str, String str2, int i10) {
        AbstractC7185ho.m43820b("PPSRewardView", "onSegmentMediaCompletion:" + AbstractC7819dl.m48375a(str2));
        if (m49608r()) {
            return;
        }
        this.f37045n = true;
        m49562f(i10);
        m49515N();
        InterfaceC7537oe interfaceC7537oe = this.f37033b;
        if (interfaceC7537oe != null) {
            interfaceC7537oe.m46271a(i10, this.f37039h);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaError(String str, String str2, int i10, int i11, int i12) throws Resources.NotFoundException {
        AbstractC7185ho.m43823c("PPSRewardView", "onSegmentMediaError:" + AbstractC7819dl.m48375a(str2) + ", playTime:" + i10 + ",errorCode:" + i11 + ",extra:" + i12);
        if (m49543a(str2, i10, i11)) {
            AbstractC7185ho.m43820b("PPSRewardView", "switch to online play.");
            this.f37033b.mo46190b(str2);
            return;
        }
        TextView textView = this.f37042k;
        if (textView != null) {
            textView.setVisibility(8);
        }
        mo49489c();
        m49562f(i10);
        IRewardAdStatusListener iRewardAdStatusListener = this.f37002R;
        if (iRewardAdStatusListener != null) {
            iRewardAdStatusListener.onAdError(i11, i12);
        }
        if (C7775bv.m47831e(getContext())) {
            return;
        }
        m49507F();
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaPause(String str, String str2, int i10) {
        AbstractC7185ho.m43820b("PPSRewardView", "onSegmentMediaPause:" + AbstractC7819dl.m48375a(str2));
        m49562f(i10);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaStart(String str, String str2, int i10) {
        AbstractC7185ho.m43820b("PPSRewardView", "onSegmentMediaStart:" + AbstractC7819dl.m48375a(str2));
        this.f36996L = true;
        this.f37015ag = true;
        this.f36997M = i10;
        ProgressBar progressBar = this.f37050s;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentMediaStop(String str, String str2, int i10) {
        AbstractC7185ho.m43820b("PPSRewardView", "onSegmentMediaStop:" + AbstractC7819dl.m48375a(str2));
        if (m49608r()) {
            return;
        }
        m49562f(i10);
    }

    @Override // com.huawei.openalliance.p169ad.media.listener.SegmentMediaStateListener
    public void onSegmentProgress(String str, String str2, int i10, int i11) throws Resources.NotFoundException {
        int i12;
        if (m49608r()) {
            return;
        }
        boolean z10 = this.f36996L;
        if (!z10 && this.f36997M < 0) {
            this.f36997M = i11;
            this.f36996L = true;
        } else if (z10 && (i12 = this.f36997M) >= 0) {
            long j10 = i11 - i12;
            this.f36998N = j10;
            C7331je c7331je = this.f37034c;
            if (c7331je != null) {
                m49553c(j10, c7331je.m45277c());
            }
            InterfaceC7537oe interfaceC7537oe = this.f37033b;
            if (interfaceC7537oe != null) {
                interfaceC7537oe.m46271a(i11, this.f37039h);
            }
        }
        InterfaceC7537oe interfaceC7537oe2 = this.f37033b;
        if (interfaceC7537oe2 != null && interfaceC7537oe2.mo46188a(str2, i11)) {
            AbstractC7185ho.m43823c("PPSRewardView", "play localFile timeout.");
            onSegmentMediaError(str, str2, i11, -5, -1);
            return;
        }
        int i13 = this.f37039h;
        if (i11 > i13 && i13 > 0) {
            i11 = i13;
        }
        int i14 = i11 / 1000;
        AbstractC7185ho.m43818a("PPSRewardView", "onSegmentProgress: %d, originTime: %d", Integer.valueOf(i14), Integer.valueOf(i11));
        m49565g(i14);
        m49568h(i14);
        m49552c(i14);
        if (i11 >= this.f37039h) {
            AbstractC7185ho.m43820b("PPSRewardView", "time countdown finish, manually stop");
            RewardVideoView rewardVideoView = this.f37038g;
            if (rewardVideoView != null) {
                rewardVideoView.setVideoFinish(true);
                onSegmentMediaCompletion(null, str2, i11);
                this.f37038g.mo49874b();
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        C7331je c7331je = this.f37034c;
        if (c7331je != null) {
            c7331je.m45303j();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    @OuterVisible
    public void pauseView() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.11
            public RunnableC800611() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("PPSRewardView", RewardMethods.PAUSE_VIEW);
                if (PPSRewardView.this.f37038g != null) {
                    PPSRewardView.this.f37038g.pauseView();
                    PPSRewardView.this.f37038g.mo49869a();
                }
            }
        });
    }

    @OuterVisible
    public void play() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.7
            public RunnableC80137() {
            }

            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                AbstractC7185ho.m43820b("PPSRewardView", "manual play()");
                if (PPSRewardView.this.f37035d != null) {
                    PPSRewardView pPSRewardView = PPSRewardView.this;
                    pPSRewardView.m49538a(pPSRewardView.f37035d.m44918K());
                }
            }
        });
    }

    @OuterVisible
    public void removeNonwifiActionListener() {
        this.f37003S = null;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    @OuterVisible
    public void removeRewardAdStatusListener() {
        this.f37002R = null;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    @OuterVisible
    public void resumeView() {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.10
            public RunnableC800510() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                AbstractC7185ho.m43820b("PPSRewardView", RewardMethods.RESUME_VIEW);
                if (RunnableC7857vc.m48635a(PPSRewardView.this.f37000P) || RunnableC7857vc.m48635a(PPSRewardView.this.getNonwifiDialog()) || RunnableC7857vc.m48635a(PPSRewardView.this.getAdDialog())) {
                    str = "do not resume when dialog is showing";
                } else {
                    if (PPSRewardView.this.f36999O == null || PPSRewardView.this.f36999O.getVisibility() != 0) {
                        if (PPSRewardView.this.f37038g == null || PPSRewardView.this.m49608r()) {
                            return;
                        }
                        PPSRewardView.this.f37038g.resumeView();
                        if (PPSRewardView.this.f37047p) {
                            PPSRewardView.this.f37038g.mo49873a(true, PPSRewardView.this.f36995K);
                            return;
                        }
                        return;
                    }
                    str = "do not resume landing page is showing";
                }
                AbstractC7185ho.m43820b("PPSRewardView", str);
            }
        });
    }

    public void setAdDialog(AlertDialog alertDialog) {
        this.f37056y = alertDialog;
    }

    public void setClickInfo(MaterialClickInfo materialClickInfo) {
        this.f36989E = materialClickInfo;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void setContentRecord(ContentRecord contentRecord) {
        this.f37049r = contentRecord;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void setNonwifiDialog(Dialog dialog) {
        this.f37001Q = dialog;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void setOrientation(int i10) {
        if (i10 == 0 || 1 == i10) {
            this.f37046o = i10;
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    public void setTemplateErrorListener(InterfaceC8108ab interfaceC8108ab) {
    }

    public void setWebPopUpView(C8150t c8150t) {
        this.f37020al = c8150t;
    }

    @OuterVisible
    public PPSRewardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37008a = new C7722uq();
        this.f37036e = false;
        this.f37037f = false;
        this.f37045n = false;
        this.f37046o = 1;
        this.f37047p = true;
        this.f37053v = false;
        this.f37054w = false;
        this.f37056y = null;
        this.f36990F = false;
        this.f36991G = false;
        this.f36992H = new C7853uz(this);
        this.f36993I = new C7855va(this);
        this.f36994J = new C7860vf(this);
        this.f36995K = true;
        this.f36996L = false;
        this.f36997M = -1;
        this.f36998N = -1L;
        this.f37012ad = true;
        this.f37014af = true;
        this.f37015ag = false;
        this.f37016ah = true;
        this.f37017ai = false;
        this.f37018aj = true;
        this.f37019ak = false;
        this.f37021am = false;
        this.f37023ao = true;
        this.f37024ap = false;
        this.f37028at = new ViewOnClickListenerC7858vd(this);
        m49533a(context);
    }

    /* renamed from: e */
    private int m49560e(String str) {
        Integer numM48178h;
        if (str == null || str.trim().length() == 0 || (numM48178h = AbstractC7806cz.m48178h(str)) == null || numM48178h.intValue() < 0 || numM48178h.intValue() > 100) {
            return 90;
        }
        return numM48178h.intValue();
    }

    /* renamed from: f */
    private void m49562f(int i10) {
        int i11;
        if (this.f36996L && (i11 = this.f36997M) >= 0) {
            this.f36998N = i10 - i11;
            this.f36996L = false;
        }
        this.f36997M = -1;
    }

    /* renamed from: g */
    private void m49565g(int i10) {
        if (this.f37035d.m44947ab()) {
            return;
        }
        int i11 = this.f37041j;
        int i12 = i11 - i10;
        if ((i12 >= 0 && i12 != 0) || i11 < 0) {
            return;
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.4
            public RunnableC80104() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PPSRewardView.this.mo49489c();
            }
        });
    }

    /* renamed from: u */
    private void m49585u() {
        View viewFindViewById = findViewById(C6849R.id.reward_content_area);
        viewFindViewById.setClickable(true);
        viewFindViewById.setOnTouchListener(new ViewOnTouchListenerC7720uo(this));
        PPSAppDetailTemplateView pPSAppDetailTemplateView = this.f36987C;
        if (pPSAppDetailTemplateView != null) {
            pPSAppDetailTemplateView.setEnabled(false);
        }
    }

    /* renamed from: v */
    public void m49587v() {
        AbstractC7185ho.m43820b("PPSRewardView", "init pop-up");
        this.f37018aj = AbstractC7558os.m46480s(this.f37035d.getCtrlSwitchs());
        boolean zMo43043U = C7124fh.m43316b(this.f37048q).mo43043U();
        if (!this.f37018aj) {
            AbstractC7185ho.m43820b("PPSRewardView", "switch is off, skip init popup.");
            return;
        }
        if (C7756bc.m47711f(this.f37035d.m44904D()) || this.f37035d.getAppInfo() == null) {
            AbstractC7185ho.m43820b("PPSRewardView", "appInfo is null or web, skip init popup");
            return;
        }
        this.f37057z = new C8150t(getContext(), getOrientation());
        getPopUpView().setAdPopupData(this.f37010ab);
        getPopUpView().setPopUpClickListener(new C7861vg(this, zMo43043U));
        m49585u();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: c */
    public void mo49489c() {
        ImageView imageView = this.f37044m;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* renamed from: d */
    public void m49599d() {
        if (this.f37053v || getAppDetailView() == null) {
            return;
        }
        getAppDetailView().setVisibility(0);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: h */
    public boolean mo49496h() {
        return getAppDetailView() instanceof PPSExpandButtonDetailView;
    }

    /* renamed from: i */
    public void m49602i() {
        if (this.f36995K) {
            m49510I();
        } else {
            m49509H();
        }
    }

    /* renamed from: j */
    public boolean m49603j() {
        return this.f37033b.mo46193b(this.f37035d) && getAppDetailView() != null && this.f37004T.getAppDownloadButton().getStatus() == AppStatus.DOWNLOAD;
    }

    /* renamed from: k */
    public void m49604k() {
        if (getAdDialog() != null || getPopUpView() == null || this.f37035d.m44947ab()) {
            return;
        }
        setAdDialog(getPopUpView().getDialog());
        boolean zM50511a = getPopUpView().m50511a();
        AbstractC7185ho.m43821b("PPSRewardView", "show ad dialog, ret: %s", Boolean.valueOf(zM50511a));
        if (zM50511a) {
            mo49482a("127");
            pauseView();
            getAdDialog().setOnCancelListener(new DialogInterfaceOnCancelListenerC7717ul(this));
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: l */
    public void mo49500l() {
        this.f37000P = null;
        if (this.f37015ag) {
            mo49481a((Integer) 3);
        }
        this.f37008a.m47413a();
        m49512K();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: m */
    public void mo49501m() {
        this.f37000P = null;
        resumeView();
    }

    @OuterVisible
    public void onEvent(RewardEvent rewardEvent, boolean z10) {
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.3

            /* renamed from: a */
            final /* synthetic */ RewardEvent f37065a;

            /* renamed from: b */
            final /* synthetic */ boolean f37066b;

            public RunnableC80093(RewardEvent rewardEvent2, boolean z102) {
                rewardEvent = rewardEvent2;
                z = z102;
            }

            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                AbstractC7185ho.m43821b("PPSRewardView", "onEvent: %s", rewardEvent.m44553a());
                RewardEvent rewardEvent2 = RewardEvent.CLOSE;
                RewardEvent rewardEvent22 = rewardEvent;
                if (rewardEvent2 != rewardEvent22 && (RewardEvent.BACKPRESSED != rewardEvent22 || PPSRewardView.this.m49526Y())) {
                    return;
                }
                PPSRewardView.this.m49600d(z);
            }
        });
    }

    /* renamed from: q */
    public void m49607q() {
        this.f37021am = false;
        setWebPopUpView(null);
        m49598c("130");
    }

    /* renamed from: r */
    public boolean m49608r() {
        return this.f37045n;
    }

    @OuterVisible
    public PPSRewardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37008a = new C7722uq();
        this.f37036e = false;
        this.f37037f = false;
        this.f37045n = false;
        this.f37046o = 1;
        this.f37047p = true;
        this.f37053v = false;
        this.f37054w = false;
        this.f37056y = null;
        this.f36990F = false;
        this.f36991G = false;
        this.f36992H = new C7853uz(this);
        this.f36993I = new C7855va(this);
        this.f36994J = new C7860vf(this);
        this.f36995K = true;
        this.f36996L = false;
        this.f36997M = -1;
        this.f36998N = -1L;
        this.f37012ad = true;
        this.f37014af = true;
        this.f37015ag = false;
        this.f37016ah = true;
        this.f37017ai = false;
        this.f37018aj = true;
        this.f37019ak = false;
        this.f37021am = false;
        this.f37023ao = true;
        this.f37024ap = false;
        this.f37028at = new ViewOnClickListenerC7858vd(this);
        m49533a(context);
    }

    /* renamed from: c */
    private void m49552c(int i10) {
        if (this.f37042k == null) {
            return;
        }
        this.f37042k.setText(this.f37033b.mo46179a(m49559e(i10), m49555d(i10), this.f37035d));
        if (this.f37042k.getVisibility() != 0) {
            this.f37042k.setVisibility(0);
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: b */
    public void mo45281b() {
        this.f37036e = false;
        this.f37037f = false;
        long jM47566c = AbstractC7741ao.m47566c();
        AbstractC7185ho.m43818a("PPSRewardView", "onViewPhysicalShowStart: %s", Long.valueOf(jM47566c));
        String strValueOf = String.valueOf(jM47566c);
        C7305h c7305h = this.f37035d;
        if (c7305h != null) {
            c7305h.m44968g(false);
            this.f37035d.m44612a(false);
            this.f37035d.m44642h(strValueOf);
            this.f37035d.m44622c(jM47566c);
        }
        InterfaceC7537oe interfaceC7537oe = this.f37033b;
        if (interfaceC7537oe != null) {
            interfaceC7537oe.m46272a(strValueOf);
            this.f37033b.m46269a(jM47566c);
        }
        RewardVideoView rewardVideoView = this.f37038g;
        if (rewardVideoView != null) {
            rewardVideoView.mo49872a(strValueOf);
            this.f37038g.mo49870a(jM47566c);
        }
        AdLandingPageData adLandingPageData = this.f37010ab;
        if (adLandingPageData != null && this.f36999O != null) {
            adLandingPageData.m44280c(strValueOf);
            this.f37010ab.m44264a(jM47566c);
            this.f36999O.setAdLandingPageData(this.f37010ab);
        }
        if (this.f37010ab != null && getAppDetailView() != null) {
            this.f37010ab.m44280c(strValueOf);
            this.f37010ab.m44264a(jM47566c);
            getAppDetailView().m48962a(strValueOf);
            getAppDetailView().m48959a(jM47566c);
        }
        if (getEndCardView() != null) {
            getEndCardView().m50498a(strValueOf);
            getEndCardView().m50497a(jM47566c);
        }
        InterfaceC7537oe interfaceC7537oe2 = this.f37033b;
        if (interfaceC7537oe2 != null) {
            interfaceC7537oe2.mo46189b();
        }
        if (this.f36999O != null && this.f37033b.mo46193b(this.f37035d) && this.f37024ap) {
            this.f36999O.onResume();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: e */
    public void mo49493e() {
        setNonwifiDialog(null);
        this.f37047p = true;
        this.f37012ad = false;
        RewardVideoView rewardVideoView = this.f37038g;
        if (rewardVideoView != null) {
            rewardVideoView.resumeView();
            this.f37038g.mo49873a(true, this.f36995K);
        }
    }

    @OuterVisible
    @TargetApi(21)
    public PPSRewardView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f37008a = new C7722uq();
        this.f37036e = false;
        this.f37037f = false;
        this.f37045n = false;
        this.f37046o = 1;
        this.f37047p = true;
        this.f37053v = false;
        this.f37054w = false;
        this.f37056y = null;
        this.f36990F = false;
        this.f36991G = false;
        this.f36992H = new C7853uz(this);
        this.f36993I = new C7855va(this);
        this.f36994J = new C7860vf(this);
        this.f36995K = true;
        this.f36996L = false;
        this.f36997M = -1;
        this.f36998N = -1L;
        this.f37012ad = true;
        this.f37014af = true;
        this.f37015ag = false;
        this.f37016ah = true;
        this.f37017ai = false;
        this.f37018aj = true;
        this.f37019ak = false;
        this.f37021am = false;
        this.f37023ao = true;
        this.f37024ap = false;
        this.f37028at = new ViewOnClickListenerC7858vd(this);
        m49533a(context);
    }

    /* renamed from: c */
    private void m49553c(long j10, int i10) {
        C7305h c7305h = this.f37035d;
        if (c7305h == null || this.f37036e || j10 <= c7305h.getMinEffectiveShowTime()) {
            return;
        }
        this.f37036e = true;
        m49541a(Long.valueOf(j10), Integer.valueOf(i10), (Integer) null);
    }

    /* renamed from: d */
    private void m49557d(String str) {
        if (!this.f37014af || TextUtils.isEmpty(str)) {
            this.f37030av.setVisibility(8);
            m49536a(this.f37009aa, this.f37035d.getLabel());
        } else {
            this.f37030av.setText(str);
            this.f37009aa.setVisibility(8);
            this.f37030av.setVisibility(0);
        }
    }

    /* renamed from: f */
    public void m49564f(boolean z10) throws Resources.NotFoundException {
        AbstractC7185ho.m43820b("PPSRewardView", "initVideoView");
        C7022dk c7022dk = this.f37055x;
        String strM41968c = c7022dk.m41968c(c7022dk.m41970e(this.f37029au.getVideoDownloadUrl()));
        if (AbstractC7731ae.m47458b(strM41968c)) {
            AbstractC7185ho.m43820b("PPSRewardView", "change path to local");
            this.f37029au.m44563a(strM41968c);
        }
        C7331je c7331je = this.f37034c;
        if (c7331je != null) {
            c7331je.m45276b(this.f37035d.getMinEffectiveShowTime(), this.f37035d.getMinEffectiveShowRatio());
        }
        InterfaceC7537oe interfaceC7537oe = this.f37033b;
        if (interfaceC7537oe != null) {
            interfaceC7537oe.mo46194c(this.f37035d);
        }
        RewardVideoView rewardVideoView = this.f37038g;
        if (rewardVideoView != null) {
            rewardVideoView.setAudioFocusType(this.f37035d.m44952ag());
            this.f37038g.mo49871a(this);
            this.f37038g.m49903a(this.f36992H);
            this.f37038g.m49901a(this.f36985A, this.f37033b.mo46192b(this.f37049r));
            this.f37038g.setRewardAd(this.f37035d);
            this.f37038g.setVisibility(0);
            this.f37038g.m49904a(this.f36993I);
        }
        int iM44950ae = (int) this.f37035d.m44950ae();
        this.f37039h = iM44950ae;
        this.f37040i = C7521np.m46171a(this.f37048q, iM44950ae);
        this.f37041j = m49544b(this.f37039h);
        if (z10) {
            m49538a(this.f37029au);
        }
    }

    /* renamed from: g */
    private void m49567g(boolean z10) throws Resources.NotFoundException {
        if (C7775bv.m47831e(getContext()) || m49506E()) {
            if (!this.f37035d.m44947ab()) {
                pauseView();
                m49511J();
                return;
            } else if (z10) {
                if (this.f37015ag) {
                    mo49481a((Integer) 3);
                }
                m49512K();
                return;
            } else if (!this.f37054w && (this.f37016ah || m49521T())) {
                pauseView();
                m49522U();
                return;
            }
        }
        m49512K();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x002e  */
    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo45282b(long r9, int r11) {
        /*
            r8 = this;
            boolean r0 = r8.f37037f
            if (r0 != 0) goto L3e
            r0 = 1
            r8.f37037f = r0
            com.huawei.openalliance.ad.oe r0 = r8.f37033b
            if (r0 == 0) goto L3e
            boolean r0 = r8.m49608r()
            r1 = 0
            if (r0 == 0) goto L1a
            com.huawei.openalliance.ad.inter.data.VideoInfo r0 = r8.f37029au
            int r0 = r0.getVideoDuration()
        L18:
            r6 = r0
            goto L24
        L1a:
            com.huawei.openalliance.ad.views.RewardVideoView r0 = r8.f37038g
            if (r0 == 0) goto L23
            int r0 = r0.getPlayedTime()
            goto L18
        L23:
            r6 = r1
        L24:
            boolean r0 = r8.m49608r()
            if (r0 == 0) goto L2e
            r1 = 100
        L2c:
            r7 = r1
            goto L37
        L2e:
            com.huawei.openalliance.ad.views.RewardVideoView r0 = r8.f37038g
            if (r0 == 0) goto L2c
            int r1 = r0.getPlayedProgress()
            goto L2c
        L37:
            com.huawei.openalliance.ad.oe r2 = r8.f37033b
            r3 = r9
            r5 = r11
            r2.m46270a(r3, r5, r6, r7)
        L3e:
            r8.m49526Y()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.PPSRewardView.mo45282b(long, int):void");
    }

    /* renamed from: b */
    private void m49546b(Context context) {
        RelativeLayout.LayoutParams layoutParams;
        if (AbstractC7741ao.m47592n(context)) {
            this.f36988D.setTextSize(1, 21.0f);
            int i10 = this.f36985A;
            if (i10 == 3) {
                this.f36988D.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f36987C.getLayoutParams();
                layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin - ((int) C7818dk.m48367a(context, 14)));
                this.f36987C.setLayoutParams(layoutParams2);
                return;
            }
            if (i10 == 4) {
                layoutParams = (RelativeLayout.LayoutParams) this.f36987C.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin - ((int) C7818dk.m48367a(context, 8)), layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                layoutParams = (RelativeLayout.LayoutParams) this.f36987C.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin + ((int) C7818dk.m48367a(context, 2)));
            }
            this.f36987C.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f36988D.getLayoutParams();
            layoutParams3.setMargins(layoutParams3.leftMargin, layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            this.f36988D.setLayoutParams(layoutParams3);
        }
    }

    /* renamed from: c */
    public void m49598c(String str) {
        this.f37033b.mo46182a(str, this.f37049r);
    }

    /* renamed from: d */
    public void m49600d(boolean z10) throws Resources.NotFoundException {
        ((PPSRewardActivity) getContext()).setRequestedOrientation(getOrientation());
        setAppDetailViewType(0);
        boolean zMo43046X = C7124fh.m43316b(this.f37048q).mo43046X();
        AbstractC7185ho.m43821b("PPSRewardView", "handleCloseClick, closeBtnClicked: %s, showDialogForCloseBtn: %s", Boolean.valueOf(z10), Boolean.valueOf(zMo43046X));
        if (!z10 || zMo43046X) {
            m49567g(z10);
            return;
        }
        if (this.f37015ag) {
            mo49481a((Integer) 3);
        }
        m49512K();
    }

    /* renamed from: e */
    public void m49601e(boolean z10) {
        this.f36995K = z10;
        m49514M();
    }

    /* renamed from: b */
    private void m49547b(Context context, ContentRecord contentRecord) {
        int i10;
        int i11;
        int i12;
        int i13;
        int iMo46177a = this.f37033b.mo46177a(contentRecord, getOrientation());
        this.f36985A = iMo46177a;
        AbstractC7185ho.m43821b("PPSRewardView", "insreTemplate %s", Integer.valueOf(iMo46177a));
        int i14 = this.f36985A;
        if (i14 != 1) {
            if (i14 == 3) {
                i13 = C6849R.layout.hiad_reward_layout3;
            } else if (i14 == 4) {
                m49534a(context, C6849R.layout.hiad_reward_layout4, C6849R.id.reward_layout, C6849R.color.hiad_emui_color_subbg);
                this.f36987C = (PPSAppDetailTemplateView) findViewById(C6849R.id.reward_app_detail_template);
                this.f36988D = (TextView) findViewById(C6849R.id.reward_app_detail_appdesc_template);
                return;
            } else if (i14 != 5) {
                i10 = C6849R.layout.hiad_reward_layout;
                i11 = C6849R.id.reward_layout;
                i12 = C6849R.color.hiad_black;
            } else {
                i13 = C6849R.layout.hiad_reward_layout5;
            }
            m49534a(context, i13, C6849R.id.reward_layout, C6849R.color.hiad_emui_color_subbg);
            PPSAppDetailTemplateView pPSAppDetailTemplateView = (PPSAppDetailTemplateView) findViewById(C6849R.id.reward_app_detail_template);
            this.f36987C = pPSAppDetailTemplateView;
            pPSAppDetailTemplateView.setLoadAppIconSelf(false);
            this.f36988D = (TextView) findViewById(C6849R.id.reward_app_detail_appdesc_template);
            return;
        }
        i10 = C6849R.layout.hiad_reward_layout;
        i11 = C6849R.id.reward_layout;
        i12 = C6849R.color.hiad_emui_color_subbg;
        m49534a(context, i10, i11, i12);
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: a */
    public void mo45279a() {
        this.f36997M = -1;
        this.f36996L = false;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: c */
    public boolean mo49491c(boolean z10) {
        AppDownloadButton appDownloadButton;
        C7749aw c7749aw;
        boolean zM50511a = false;
        if ((z10 && !AbstractC7558os.m46483v(this.f37010ab.m44290f())) || this.f36991G || (appDownloadButton = getAppDetailView().getAppDownloadButton()) == null || appDownloadButton.m48708d()) {
            return false;
        }
        if (!this.f37021am && appDownloadButton.getStatus() == AppStatus.DOWNLOAD) {
            this.f37021am = true;
            if (!z10 && (c7749aw = this.f37027as) != null) {
                if (c7749aw.m47671a()) {
                    return false;
                }
                this.f37027as.m47670a(true);
                this.f36991G = true;
            }
            m49524W();
            getWebPopUpView().setAdPopupData(this.f37010ab);
            zM50511a = getWebPopUpView().m50511a();
            if (zM50511a) {
                m49598c("127");
            }
        }
        return zM50511a;
    }

    @Override // com.huawei.openalliance.p169ad.C7331je.a
    /* renamed from: a */
    public void mo45280a(long j10, int i10) {
        m49553c(this.f36998N, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m49596b(com.huawei.openalliance.p169ad.views.interfaces.C8109b r4) {
        /*
            r3 = this;
            boolean r0 = r4.m50302a()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r1 = r4.m50303b()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r2 = r4.m50304c()
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r1, r2}
            java.lang.String r1 = "PPSRewardView"
            java.lang.String r2 = "onClick, isAppRelated: %s, isHandled: %s, destination:%s"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43821b(r1, r2, r0)
            com.huawei.openalliance.ad.inter.data.h r0 = r3.f37035d
            r1 = 1
            r0.m44962e(r1)
            com.huawei.openalliance.p169ad.utils.C7730ad.m47436b()
            java.lang.String r0 = "web"
            java.lang.String r2 = r4.m50304c()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L42
            com.huawei.openalliance.ad.inter.data.h r0 = r3.f37035d
            int r0 = r0.m44904D()
            if (r0 == 0) goto L42
            java.lang.String r0 = "2"
        L3e:
            r3.m49597b(r0)
            goto L5d
        L42:
            java.lang.String r0 = "app"
            java.lang.String r2 = r4.m50304c()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L5a
            java.lang.String r0 = "harmonyService"
            java.lang.String r2 = r4.m50304c()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L5d
        L5a:
            java.lang.String r0 = "4"
            goto L3e
        L5d:
            com.huawei.openalliance.ad.inter.listeners.IRewardAdStatusListener r0 = r3.f37002R
            if (r0 == 0) goto L64
            r0.onAdClicked()
        L64:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r3.mo49481a(r0)
            com.huawei.openalliance.ad.uq r0 = r3.f37008a
            r0.m47417d()
            boolean r0 = r4.m50303b()
            if (r0 != 0) goto L7d
            java.lang.Integer r4 = r4.m50305d()
            r3.m49549b(r4)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.PPSRewardView.m49596b(com.huawei.openalliance.ad.views.interfaces.b):void");
    }

    /* renamed from: a */
    private void m49533a(Context context) {
        this.f37048q = context;
        try {
            this.f37033b = new C7521np(context, this);
            this.f37034c = new C7331je(this, this);
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("PPSRewardView", "init error " + th2.getClass().getSimpleName());
        }
    }

    /* renamed from: b */
    private void m49549b(Integer num) {
        if (this.f37033b != null) {
            if (num == null) {
                num = 7;
            }
            this.f37033b.mo46186a(num.intValue(), getClickInfo());
        }
    }

    /* renamed from: a */
    private void m49534a(Context context, int i10, int i11, int i12) {
        View.inflate(context, i10, this);
        this.f37031aw = i10;
        ViewGroup viewGroup = (ViewGroup) findViewById(i11);
        this.f36986B = viewGroup;
        viewGroup.setBackgroundColor(getResources().getColor(i12));
    }

    /* renamed from: b */
    public void m49597b(String str) {
        this.f37033b.mo46184a(str, this.f37035d, this.f37002R);
    }

    /* renamed from: a */
    public void m49535a(Context context, ContentRecord contentRecord) {
        m49547b(context, contentRecord);
        this.f37025aq = (RelativeLayout) findViewById(C6849R.id.reward_content_area);
        this.f37026ar = (LinearLayout) findViewById(C6849R.id.reward_close_container);
        TextView textView = (TextView) findViewById(C6849R.id.reward_count_down);
        this.f37042k = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this.f37043l = (ImageView) findViewById(C6849R.id.reward_mute_icon);
        this.f37044m = (ImageView) findViewById(C6849R.id.reward_close);
        C7305h c7305h = this.f37035d;
        if (c7305h == null || !c7305h.m44947ab()) {
            m49513L();
        }
        this.f37038g = (RewardVideoView) findViewById(C6849R.id.reward_video_view);
        this.f37005U = (PPSAppDetailView) findViewById(C6849R.id.reward_download_area);
        this.f37006V = (PPSExpandButtonDetailView) findViewById(C6849R.id.reward_expand_button_download_area);
        this.f37013ae = (ChoicesView) findViewById(C6849R.id.reward_why_this_ad);
        boolean zMo41175d = C6982bz.m41148a(context).mo41175d();
        this.f37014af = zMo41175d;
        if (zMo41175d) {
            this.f37013ae.setVisibility(8);
        }
        setBackgroundColor(-16777216);
        setUseRatioInMatchParentMode(false);
        this.f37043l.setImageResource(AbstractC7811dd.m48283a(this.f36985A, true));
        this.f37043l.setOnClickListener(this.f37028at);
        AbstractC7811dd.m48296a(this.f37043l);
        this.f37044m.setOnClickListener(this.f37028at);
        this.f36999O = (PPSWebView) findViewById(C6849R.id.reward_webview);
        this.f37050s = (ProgressBar) findViewById(C6849R.id.reward_progress);
        this.f37051t = (PPSLabelSourceView) findViewById(C6849R.id.custom_ad_bg_layout);
        boolean zM47555a = AbstractC7741ao.m47555a(this.f37014af, contentRecord.m41517bd(), contentRecord.m41516bc());
        this.f37051t.m49198b(context, zM47555a);
        this.f37051t.m49197a(this, contentRecord, zM47555a);
        this.f37009aa = this.f37051t.getAdSource();
        this.f37052u = this.f37051t.getAdLabel();
        this.f37030av = this.f37051t.getAdJumpText();
        if (!zM47555a || m49542a(this.f36985A) || C7756bc.m47708c(contentRecord.m41388C())) {
            if (zM47555a) {
                this.f37030av.setBackground(getResources().getDrawable(C6849R.drawable.hiad_bg_ad_source));
                TextView textView2 = this.f37030av;
                Context context2 = getContext();
                Resources resources = getResources();
                int i10 = C6849R.dimen.hiad_2_dp;
                textView2.setPadding(AbstractC7741ao.m47535a(context2, resources.getDimension(i10)), 0, AbstractC7741ao.m47535a(getContext(), getResources().getDimension(i10)), 0);
            }
            this.f37030av.setTextColor(getResources().getColor(C6849R.color.hiad_ad_source_color));
            this.f37030av.setTextSize(1, 10.0f);
        }
        m49580s();
        if (C7521np.m46174a(contentRecord)) {
            this.f36999O.setWebViewBackgroundColor(getResources().getColor(C6849R.color.hiad_black));
            this.f36999O.m49765d();
        }
        this.f36999O.setPPSWebEventCallback(C7517nl.m46150a());
        this.f37055x = C7019dh.m41937a(context, Constants.NORMAL_CACHE);
        AbstractC7811dd.m48293a(context, getOrientation(), findViewById(C6849R.id.reward_layout));
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: b */
    public void mo49488b(boolean z10) {
    }

    /* renamed from: a */
    public void m49593a(Drawable drawable, Drawable drawable2) {
        ViewGroup viewGroup;
        getAppDetailView().setAppIconImageDrawable(drawable);
        PPSAppDetailTemplateView pPSAppDetailTemplateView = this.f36987C;
        if (pPSAppDetailTemplateView != null) {
            pPSAppDetailTemplateView.setAppIconImageDrawable(drawable);
        }
        if (!(drawable instanceof C8101b) && (viewGroup = this.f36986B) != null && drawable2 != null && this.f36985A != 3) {
            viewGroup.setBackground(drawable2);
            View viewM48374d = C7818dk.m48374d(this.f37048q);
            if (viewM48374d != null) {
                this.f36986B.addView(viewM48374d, 0);
            }
        }
        AbstractC7185ho.m43817a("PPSRewardView", "get icon suucess");
    }

    /* renamed from: a */
    private static void m49536a(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str)) {
            return;
        }
        textView.setText(str);
        textView.setVisibility(0);
    }

    /* renamed from: a */
    private void m49537a(AppInfo appInfo) {
        if (appInfo == null || TextUtils.isEmpty(appInfo.getIconUrl()) || !this.f37033b.mo46192b(this.f37049r)) {
            return;
        }
        int i10 = this.f36985A;
        if (i10 == 1 || i10 == 3 || i10 == 5) {
            getAppDetailView().m48960a(new ImageView(getContext()), appInfo.getIconUrl(), new C7859ve(this));
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: a */
    public void mo49479a(IRewardAd iRewardAd, boolean z10) {
        if (this.f37035d != null) {
            AbstractC7185ho.m43823c("PPSRewardView", "has been registered");
        } else {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.1

                /* renamed from: a */
                final /* synthetic */ IRewardAd f37058a;

                /* renamed from: b */
                final /* synthetic */ boolean f37059b;

                public RunnableC80041(IRewardAd iRewardAd2, boolean z102) {
                    iRewardAd = iRewardAd2;
                    z = z102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    IRewardAd iRewardAd2;
                    try {
                        iRewardAd2 = iRewardAd;
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43826d("PPSRewardView", "refresh ui error " + th2.getClass().getSimpleName());
                    }
                    if (!(iRewardAd2 instanceof C7305h)) {
                        PPSRewardView.this.mo49489c();
                        AbstractC7185ho.m43823c("PPSRewardView", "there is no reward ad");
                        return;
                    }
                    PPSRewardView.this.f37035d = (C7305h) iRewardAd2;
                    PPSRewardView pPSRewardView = PPSRewardView.this;
                    pPSRewardView.setContentRecord(C7580pn.m46793a(pPSRewardView.f37035d));
                    PPSRewardView pPSRewardView2 = PPSRewardView.this;
                    pPSRewardView2.m49535a(pPSRewardView2.getContext(), PPSRewardView.this.f37049r);
                    if (PPSRewardView.this.f37035d.m44947ab()) {
                        PPSRewardView.this.mo49489c();
                    }
                    PPSRewardView pPSRewardView3 = PPSRewardView.this;
                    pPSRewardView3.f37029au = pPSRewardView3.f37035d.m44918K();
                    if (PPSRewardView.this.f37029au == null) {
                        AbstractC7185ho.m43823c("PPSRewardView", "there is no video");
                        return;
                    }
                    AbstractC7185ho.m43820b("PPSRewardView", "register:" + iRewardAd.getContentId());
                    PPSRewardView.this.m49588w();
                    PPSRewardView.this.m49582t();
                    PPSRewardView.this.m49564f(z);
                    PPSRewardView.this.m49523V();
                    PPSRewardView.this.m49587v();
                    if (!PPSRewardView.this.f37014af) {
                        String adChoiceUrl = iRewardAd.getAdChoiceUrl();
                        String adChoiceIcon = iRewardAd.getAdChoiceIcon();
                        if (!TextUtils.isEmpty(adChoiceUrl)) {
                            if (TextUtils.isEmpty(adChoiceIcon)) {
                                PPSRewardView.this.f37013ae.m30230b();
                            } else {
                                PPSRewardView.this.f37013ae.setAdChoiceIcon(adChoiceIcon);
                            }
                        }
                        PPSRewardView.this.f37013ae.setOnClickListener(new ViewOnClickListenerC7719un(PPSRewardView.this, iRewardAd));
                    }
                    if (PPSRewardView.this.f37002R != null) {
                        PPSRewardView.this.f37002R.onAdShown();
                    }
                    PPSRewardView.this.f37035d.m44965f(true);
                    C7722uq c7722uq = PPSRewardView.this.f37008a;
                    PPSRewardView pPSRewardView4 = PPSRewardView.this;
                    c7722uq.m47414a(pPSRewardView4, iRewardAd, pPSRewardView4.f37038g);
                }
            });
        }
    }

    /* renamed from: a */
    public void m49594a(MaterialClickInfo materialClickInfo) {
        C7305h c7305h = this.f37035d;
        if (c7305h == null || TextUtils.isEmpty(c7305h.m44912H())) {
            AbstractC7185ho.m43820b("PPSRewardView", "on download dialog clicked, landing page url is empty.");
            return;
        }
        InterfaceC7537oe interfaceC7537oe = this.f37033b;
        if (interfaceC7537oe != null && interfaceC7537oe.mo46186a(21, materialClickInfo)) {
            AbstractC7185ho.m43820b("PPSRewardView", "click dialog to landing page.");
            m49597b("2");
        }
        if (!this.f37036e) {
            m49541a(Long.valueOf(this.f37035d.getMinEffectiveShowTime()), Integer.valueOf(this.f37035d.getMinEffectiveShowRatio()), (Integer) 1);
        }
        mo49485a(false, DialogClickType.NO_BUTTON_AREA);
    }

    /* renamed from: a */
    public void m49538a(VideoInfo videoInfo) throws Resources.NotFoundException {
        if (videoInfo == null) {
            return;
        }
        boolean zM49506E = m49506E();
        if (zM49506E || C7775bv.m47829c(getContext())) {
            AbstractC7185ho.m43820b("PPSRewardView", "video is cached or is wifi network");
            if (zM49506E) {
                this.f37012ad = false;
            }
            RewardVideoView rewardVideoView = this.f37038g;
            if (rewardVideoView != null) {
                rewardVideoView.mo49873a(true, this.f36995K);
                return;
            }
            return;
        }
        if (!C7775bv.m47831e(getContext())) {
            m49507F();
            return;
        }
        AbstractC7185ho.m43820b("PPSRewardView", "video not cached, stop");
        this.f37047p = false;
        RewardVideoView rewardVideoView2 = this.f37038g;
        if (rewardVideoView2 != null) {
            rewardVideoView2.mo49874b();
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.5

            /* renamed from: a */
            final /* synthetic */ VideoInfo f37069a;

            /* renamed from: com.huawei.openalliance.ad.views.PPSRewardView$5$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSRewardView.this.f37047p = true;
                    PPSRewardView.this.f37012ad = false;
                    if (PPSRewardView.this.f37038g != null) {
                        PPSRewardView.this.f37038g.mo49873a(true, PPSRewardView.this.f36995K);
                    }
                }
            }

            public RunnableC80115(VideoInfo videoInfo2) {
                videoInfo = videoInfo2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if ((PPSRewardView.this.f37003S == null || !PPSRewardView.this.f37003S.onVideoPlay(videoInfo.getVideoFileSize())) && (PPSRewardView.this.f37035d == null || PPSRewardView.this.f37035d.m44951af())) {
                    PPSRewardView.this.m49505D();
                } else {
                    AbstractC7185ho.m43820b("PPSRewardView", "app has handled, do not pop up dialog");
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSRewardView.5.1
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            PPSRewardView.this.f37047p = true;
                            PPSRewardView.this.f37012ad = false;
                            if (PPSRewardView.this.f37038g != null) {
                                PPSRewardView.this.f37038g.mo49873a(true, PPSRewardView.this.f36995K);
                            }
                        }
                    });
                }
            }
        });
    }

    /* renamed from: a */
    public void m49595a(C8109b c8109b) {
        if (c8109b == null || c8109b.m50306e() == null) {
            AbstractC7185ho.m43823c("PPSRewardView", "invalid click");
            return;
        }
        Integer numM50306e = c8109b.m50306e();
        int iIntValue = numM50306e.intValue();
        AbstractC7185ho.m43821b("PPSRewardView", "click action: %d", numM50306e);
        if (iIntValue == 0) {
            m49596b(c8109b);
        } else if (iIntValue == 1 && m49603j()) {
            this.f36991G = true;
            m49604k();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: a */
    public void mo49481a(Integer num) {
        if (this.f37034c != null) {
            m49541a(Long.valueOf(System.currentTimeMillis() - this.f37034c.m45278d()), Integer.valueOf(this.f37034c.m45277c()), num);
        }
    }

    /* renamed from: a */
    private void m49541a(Long l10, Integer num, Integer num2) {
        C7305h c7305h = this.f37035d;
        if (c7305h == null) {
            return;
        }
        boolean zM47867a = C7780c.m47867a(c7305h.m44627d(), num2);
        if (!this.f37035d.m44933S() || (zM47867a && !this.f37035d.m44619b())) {
            InterfaceC7537oe interfaceC7537oe = this.f37033b;
            if (interfaceC7537oe != null) {
                interfaceC7537oe.mo46181a(l10.longValue(), num.intValue(), num2);
            }
            if (zM47867a) {
                this.f37035d.m44612a(true);
            }
            if (this.f37035d.m44933S()) {
                return;
            }
            this.f37035d.m44968g(true);
            this.f37008a.m47416c();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: a */
    public void mo49482a(String str) {
        if (this.f37035d == null || this.f37048q == null || getPopUpView() == null || TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43823c("PPSRewardView", "invalid parameter");
            return;
        }
        setContentRecord(C7580pn.m46793a(this.f37035d));
        getPopUpView();
        C8150t.m50504a(this.f37048q, str, this.f37049r);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: a */
    public void mo49484a(boolean z10) {
        C7305h c7305h;
        if (z10 || !this.f37012ad || (c7305h = this.f37035d) == null || !c7305h.m44951af()) {
            return;
        }
        pauseView();
        m49505D();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8118k
    /* renamed from: a */
    public void mo49485a(boolean z10, String str) {
        if (getAdDialog() != null) {
            getAdDialog().dismiss();
            if (z10) {
                resumeView();
            }
            setAdDialog(null);
        }
    }

    /* renamed from: a */
    private boolean m49542a(int i10) {
        return (i10 == 4 || i10 == 3) ? false : true;
    }

    /* renamed from: a */
    private boolean m49543a(String str, int i10, int i11) {
        return (this.f37038g == null || AbstractC7806cz.m48181j(str) || !this.f37038g.m49905a(i10, this.f36995K, i11)) ? false : true;
    }
}
