package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.uiengine.common.MediaStateApi;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7323ix;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7324iy;
import com.huawei.openalliance.p169ad.C7327ja;
import com.huawei.openalliance.p169ad.C7339jm;
import com.huawei.openalliance.p169ad.C7340jn;
import com.huawei.openalliance.p169ad.C7341jo;
import com.huawei.openalliance.p169ad.C7344jr;
import com.huawei.openalliance.p169ad.C7494nb;
import com.huawei.openalliance.p169ad.C7526nu;
import com.huawei.openalliance.p169ad.C7560ou;
import com.huawei.openalliance.p169ad.C7668sq;
import com.huawei.openalliance.p169ad.C7695tq;
import com.huawei.openalliance.p169ad.InterfaceC6998co;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.InterfaceC7182hl;
import com.huawei.openalliance.p169ad.InterfaceC7328jb;
import com.huawei.openalliance.p169ad.InterfaceC7342jp;
import com.huawei.openalliance.p169ad.InterfaceC7540oh;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.constant.AdLoadMode;
import com.huawei.openalliance.p169ad.constant.AdLoadState;
import com.huawei.openalliance.p169ad.constant.ApiNames;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.exception.C7110b;
import com.huawei.openalliance.p169ad.inter.C7288c;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.HiAdSplash;
import com.huawei.openalliance.p169ad.inter.IHiAdSplash;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.RewardVerifyConfig;
import com.huawei.openalliance.p169ad.inter.listeners.AdActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.AdListener;
import com.huawei.openalliance.p169ad.inter.listeners.AdShowListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8121n;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSSplashView extends AbstractC8151u implements IViewLifeCycle, InterfaceC8119l {

    /* renamed from: A */
    private View f37146A;

    /* renamed from: B */
    private boolean f37147B;

    /* renamed from: C */
    private long f37148C;

    /* renamed from: D */
    private int f37149D;

    /* renamed from: E */
    private final String f37150E;

    /* renamed from: F */
    private int f37151F;

    /* renamed from: G */
    private RewardVerifyConfig f37152G;

    /* renamed from: H */
    private PPSSplashProView f37153H;

    /* renamed from: I */
    private PPSSplashSwipeView f37154I;

    /* renamed from: J */
    private PPSSplashTwistView f37155J;

    /* renamed from: K */
    private PPSSplashSwipeClickView f37156K;

    /* renamed from: L */
    private PPSSplashTwistClickView f37157L;

    /* renamed from: M */
    private C8032b f37158M;

    /* renamed from: N */
    private ContentRecord f37159N;

    /* renamed from: O */
    private InterfaceC7342jp f37160O;

    /* renamed from: P */
    private boolean f37161P;

    /* renamed from: Q */
    private C7560ou f37162Q;

    /* renamed from: a */
    C8070ae f37163a;

    /* renamed from: b */
    RelativeLayout f37164b;

    /* renamed from: c */
    RelativeLayout f37165c;

    /* renamed from: d */
    C8152v f37166d;

    /* renamed from: e */
    protected InterfaceC7146gc f37167e;

    /* renamed from: f */
    private AdSlotParam f37168f;

    /* renamed from: g */
    private View f37169g;

    /* renamed from: h */
    private int f37170h;

    /* renamed from: i */
    private PPSWLSView f37171i;

    /* renamed from: j */
    private PPSSplashAdSourceView f37172j;

    /* renamed from: k */
    private InterfaceC7328jb f37173k;

    /* renamed from: l */
    private InterfaceC7540oh f37174l;

    /* renamed from: m */
    private AdListener f37175m;

    /* renamed from: n */
    private AdActionListener f37176n;

    /* renamed from: o */
    private AdShowListener f37177o;

    /* renamed from: p */
    private boolean f37178p;

    /* renamed from: q */
    private int f37179q;

    /* renamed from: r */
    private View f37180r;

    /* renamed from: s */
    private InterfaceC8121n f37181s;

    /* renamed from: t */
    private int f37182t;

    /* renamed from: u */
    private int f37183u;

    /* renamed from: v */
    private int f37184v;

    /* renamed from: w */
    private int f37185w;

    /* renamed from: x */
    private int f37186x;

    /* renamed from: y */
    private int f37187y;

    /* renamed from: z */
    private int f37188z;

    /* renamed from: com.huawei.openalliance.ad.views.PPSSplashView$1 */
    public class RunnableC80301 implements Runnable {
        public RunnableC80301() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PPSSplashView.this.f37166d != null) {
                AbstractC7185ho.m43817a("PPSSplashView", "skip btn show");
                PPSSplashView.this.f37166d.setVisibility(0);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSSplashView$a */
    public static class ViewOnClickListenerC8031a implements View.OnClickListener {

        /* renamed from: a */
        private WeakReference<PPSSplashView> f37190a;

        /* renamed from: b */
        private ContentRecord f37191b;

        /* renamed from: com.huawei.openalliance.ad.views.PPSSplashView$a$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ PPSSplashView f37192a;

            /* renamed from: b */
            final /* synthetic */ int[] f37193b;

            /* renamed from: c */
            final /* synthetic */ int[] f37194c;

            public AnonymousClass1(PPSSplashView pPSSplashView, int[] iArr, int[] iArr2) {
                pPSSplashView = pPSSplashView;
                iArr = iArr;
                iArr = iArr2;
            }

            @Override // java.lang.Runnable
            public void run() {
                pPSSplashView.m49679a(ViewOnClickListenerC8031a.this.f37191b, iArr, iArr);
            }
        }

        public ViewOnClickListenerC8031a(PPSSplashView pPSSplashView, ContentRecord contentRecord) {
            this.f37190a = new WeakReference<>(pPSSplashView);
            this.f37191b = contentRecord;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PPSSplashView pPSSplashView = this.f37190a.get();
            if (pPSSplashView != null) {
                int[] choiceViewLoc = pPSSplashView.f37171i.getChoiceViewLoc();
                int[] choiceViewSize = pPSSplashView.f37171i.getChoiceViewSize();
                if (AbstractC7741ao.m47556a(choiceViewLoc, 2) && AbstractC7741ao.m47556a(choiceViewSize, 2)) {
                    AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.a.1

                        /* renamed from: a */
                        final /* synthetic */ PPSSplashView f37192a;

                        /* renamed from: b */
                        final /* synthetic */ int[] f37193b;

                        /* renamed from: c */
                        final /* synthetic */ int[] f37194c;

                        public AnonymousClass1(PPSSplashView pPSSplashView2, int[] choiceViewLoc2, int[] choiceViewSize2) {
                            pPSSplashView = pPSSplashView2;
                            iArr = choiceViewLoc2;
                            iArr = choiceViewSize2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            pPSSplashView.m49679a(ViewOnClickListenerC8031a.this.f37191b, iArr, iArr);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSSplashView$b */
    public class C8032b implements C7288c.b {
        private C8032b() {
        }

        @Override // com.huawei.openalliance.p169ad.inter.C7288c.b
        /* renamed from: a */
        public void mo44234a() {
            AbstractC7185ho.m43820b("PPSSplashView", "onStart");
            PPSSplashView.this.m49704m();
        }

        public /* synthetic */ C8032b(PPSSplashView pPSSplashView, RunnableC80301 runnableC80301) {
            this();
        }
    }

    @OuterVisible
    public PPSSplashView(Context context) {
        super(context);
        this.f37170h = 8;
        this.f37178p = false;
        this.f37182t = 0;
        this.f37183u = 0;
        this.f37184v = 1;
        this.f37185w = 0;
        this.f37186x = 0;
        this.f37187y = 0;
        this.f37188z = 0;
        this.f37147B = true;
        this.f37149D = 0;
        this.f37150E = "skip_btn_delay_id_" + hashCode();
        m49677a(context);
    }

    /* renamed from: c */
    private int m49689c(ContentRecord contentRecord) {
        return (contentRecord.m41459aK() == null || contentRecord.m41459aK().m40198a() == null) ? this.f37167e.mo43028F() : contentRecord.m41459aK().m40198a().intValue();
    }

    /* renamed from: d */
    private String m49692d(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.m40220k();
        }
        return null;
    }

    /* renamed from: e */
    private void m49696e(ContentRecord contentRecord) {
        int i10;
        boolean z10;
        PPSSplashAdSourceView pPSSplashAdSourceView;
        boolean z11;
        ContentRecord contentRecord2;
        boolean z12;
        int i11;
        boolean z13;
        PPSWLSView pPSWLSView;
        boolean z14;
        ContentRecord contentRecord3;
        boolean z15;
        if (contentRecord != null) {
            int iM40639b = this.f37168f.m40639b();
            Integer numMo49715b = mo49715b(contentRecord);
            InteractCfg interactCfgM41459aK = contentRecord.m41459aK();
            Integer numM40213f = interactCfgM41459aK == null ? null : interactCfgM41459aK.m40213f();
            m49702k();
            if (this.f37147B) {
                this.f37172j.m49618a(this, numMo49715b, numM40213f, AbstractC7741ao.m47555a(true, contentRecord.m41517bd(), contentRecord.m41516bc()));
                this.f37172j.setVisibility(0);
                if (1 == iM40639b) {
                    pPSSplashAdSourceView = this.f37172j;
                    z11 = contentRecord.m41594p() == 1;
                    i10 = this.f37185w;
                    z12 = false;
                    contentRecord2 = contentRecord;
                } else {
                    AbstractC7185ho.m43821b("PPSSplashView", "showAdLabel, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(iM40639b), Integer.valueOf(this.f37186x), Integer.valueOf(this.f37187y));
                    int i12 = this.f37186x;
                    if (i12 > 0) {
                        i10 = i12;
                        z10 = true;
                    } else {
                        i10 = this.f37187y;
                        z10 = false;
                    }
                    pPSSplashAdSourceView = this.f37172j;
                    z11 = contentRecord.m41594p() == 1;
                    contentRecord2 = contentRecord;
                    z12 = z10;
                }
                pPSSplashAdSourceView.m49617a(contentRecord2, z11, i10, iM40639b, z12);
                return;
            }
            this.f37171i.setAdMediator(this.f37173k);
            this.f37171i.m49732a(numMo49715b, numM40213f);
            this.f37171i.setVisibility(0);
            if (1 == iM40639b) {
                pPSWLSView = this.f37171i;
                z14 = contentRecord.m41594p() == 1;
                i11 = this.f37185w;
                z15 = false;
                contentRecord3 = contentRecord;
            } else {
                AbstractC7185ho.m43821b("PPSSplashView", "showAdLabel, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(iM40639b), Integer.valueOf(this.f37186x), Integer.valueOf(this.f37187y));
                int i13 = this.f37186x;
                if (i13 > 0) {
                    i11 = i13;
                    z13 = true;
                } else {
                    i11 = this.f37187y;
                    z13 = false;
                }
                pPSWLSView = this.f37171i;
                z14 = contentRecord.m41594p() == 1;
                contentRecord3 = contentRecord;
                z15 = z13;
            }
            pPSWLSView.m49731a(contentRecord3, z14, i11, iM40639b, z15);
            if (AbstractC7760bg.m47767a(contentRecord.m41468aT())) {
                return;
            }
            this.f37171i.setChoiceViewOnClickListener(new ViewOnClickListenerC8031a(this, contentRecord));
        }
    }

    /* renamed from: f */
    private void m49698f() {
        int iMo43030H = this.f37167e.mo43030H();
        if (iMo43030H > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37153H.getLayoutParams();
            int iM47535a = AbstractC7741ao.m47535a(getContext(), iMo43030H);
            this.f37153H.setPadding(iM47535a, iM47535a, iM47535a, iM47535a);
            if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin - iM47535a);
                layoutParams.setMarginEnd(layoutParams.rightMargin - iM47535a);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin - iM47535a, layoutParams.topMargin, layoutParams.rightMargin - iM47535a, layoutParams.bottomMargin);
            }
            this.f37153H.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: g */
    private void m49699g() {
        String str;
        try {
            if (this.f37180r == null) {
                View viewInflate = ((ViewStub) findViewById(C6849R.id.hiad_logo_stub)).inflate();
                this.f37180r = viewInflate;
                viewInflate.setId(C6849R.id.hiad_full_logo_region);
            }
            m49678a((RelativeLayout.LayoutParams) this.f37180r.getLayoutParams());
            m49701j();
            m49700h();
        } catch (Resources.NotFoundException unused) {
            str = "showFullModeLogo res not found";
            AbstractC7185ho.m43823c("PPSSplashView", str);
        } catch (Exception e10) {
            str = "showFullModeLogo " + e10.getClass().getSimpleName();
            AbstractC7185ho.m43823c("PPSSplashView", str);
        }
    }

    /* renamed from: h */
    private void m49700h() {
        int i10;
        TextView textView = (TextView) this.f37180r.findViewById(C6849R.id.hiad_media_name);
        int i11 = this.f37182t;
        if (i11 > 0) {
            textView.setText(i11);
            i10 = 0;
        } else {
            i10 = 8;
        }
        textView.setVisibility(i10);
    }

    /* renamed from: j */
    private void m49701j() {
        int i10;
        ImageView imageView = (ImageView) this.f37180r.findViewById(C6849R.id.hiad_full_mode_logo);
        int i11 = this.f37179q;
        if (i11 > 0) {
            imageView.setImageResource(i11);
            i10 = 0;
        } else {
            i10 = 8;
        }
        imageView.setVisibility(i10);
    }

    /* renamed from: k */
    private void m49702k() {
        Context applicationContext = getContext().getApplicationContext();
        InterfaceC6998co interfaceC6998coM41148a = C6982bz.m41148a(applicationContext);
        boolean zMo41171a = interfaceC6998coM41148a.mo41171a(applicationContext);
        if (this.f37185w <= 0) {
            this.f37185w = zMo41171a ? interfaceC6998coM41148a.mo41169a(this) : AbstractC7741ao.m47583h(getContext().getApplicationContext());
        }
    }

    /* renamed from: l */
    private void m49703l() {
        if (this.f37166d != null) {
            AbstractC7185ho.m43818a("PPSSplashView", "%d delay, skip btn show", Integer.valueOf(this.f37149D));
            if (this.f37149D > 0) {
                AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.1
                    public RunnableC80301() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSSplashView.this.f37166d != null) {
                            AbstractC7185ho.m43817a("PPSSplashView", "skip btn show");
                            PPSSplashView.this.f37166d.setVisibility(0);
                        }
                    }
                }, this.f37150E, this.f37149D);
            } else {
                AbstractC7185ho.m43817a("PPSSplashView", "skip btn show");
                this.f37166d.setVisibility(0);
            }
        }
    }

    /* renamed from: m */
    public void m49704m() {
        if (!this.f37178p || this.f37168f == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSSplashView", " exsplash start, dismiss");
        m49693d();
    }

    private void setSkipBtnDelayTime(ContentRecord contentRecord) {
        if (contentRecord == null || contentRecord.m41499au() <= 0) {
            return;
        }
        this.f37149D = contentRecord.m41499au();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: b */
    public Integer mo49715b(ContentRecord contentRecord) {
        int iM46475n = AbstractC7558os.m46475n(contentRecord.m41427W());
        if (iM46475n == 0) {
            return null;
        }
        int iM49689c = m49689c(contentRecord);
        AbstractC7185ho.m43821b("PPSSplashView", "initial mode: %s", Integer.valueOf(iM49689c));
        if (iM49689c == 0) {
            return Integer.valueOf(iM49689c);
        }
        Map<String, String> mapM47729a = AbstractC7758be.m47729a(C7124fh.m43316b(getContext()).mo43430ca());
        if (mapM47729a != null) {
            if (m49691c(iM49689c)) {
                boolean zM48275B = AbstractC7811dd.m48275B(getContext());
                if (m49683a(AbstractC7806cz.m48180i(mapM47729a.get(Constants.TWIST_TYPE))) || !zM48275B) {
                    iM49689c = 4;
                }
            }
            if (m49694d(iM49689c) && m49683a(AbstractC7806cz.m48180i(mapM47729a.get(Constants.SWIPE_TYPE)))) {
                return 0;
            }
        }
        int i10 = (!m49691c(iM49689c) || AbstractC7811dd.m48275B(getContext())) ? iM49689c : 4;
        if (1 != this.f37168f.m40639b() || 2 != iM46475n) {
            AbstractC7185ho.m43821b("PPSSplashView", "proMode: %s", Integer.valueOf(iM46475n));
        } else {
            if (!m49691c(i10) || !m49697e()) {
                return Integer.valueOf(i10);
            }
            AbstractC7185ho.m43821b("PPSSplashView", "can't use twist, enable : %s", Boolean.valueOf(this.f37167e.mo43345aL()));
        }
        return 0;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void destroyView() {
        AbstractC7185ho.m43820b("PPSSplashView", "destroyView ");
        InterfaceC8121n interfaceC8121n = this.f37181s;
        if (interfaceC8121n != null) {
            interfaceC8121n.destroyView();
        }
        try {
            PPSSplashProView pPSSplashProView = this.f37153H;
            if (pPSSplashProView != null) {
                pPSSplashProView.m49665a();
            }
            C7288c.m44224a(getContext().getApplicationContext()).m44232b(this.f37158M);
            C7288c.m44224a(getContext().getApplicationContext()).m44229a(false);
            PPSSplashSwipeView pPSSplashSwipeView = this.f37154I;
            if (pPSSplashSwipeView != null) {
                pPSSplashSwipeView.m50329b();
            }
            PPSSplashSwipeClickView pPSSplashSwipeClickView = this.f37156K;
            if (pPSSplashSwipeClickView != null) {
                pPSSplashSwipeClickView.m50329b();
            }
            RelativeLayout relativeLayout = this.f37164b;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("PPSSplashView", "destroy err: %s", th2.getClass().getSimpleName());
        }
        this.f37178p = false;
    }

    public AdListener getAdListener() {
        return this.f37175m;
    }

    public InterfaceC7328jb getAdMediator() {
        return this.f37173k;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    public AdSlotParam getAdSlotParam() {
        AdSlotParam adSlotParam = this.f37168f;
        if (adSlotParam != null) {
            adSlotParam.m40648d(1);
        }
        return this.f37168f;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    public int getAdType() {
        return 1;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    public int getAudioFocusType() {
        return this.f37184v;
    }

    public BiddingInfo getBiddingInfo() {
        InterfaceC7328jb interfaceC7328jb = this.f37173k;
        return (interfaceC7328jb == null || interfaceC7328jb.mo45197x() == null) ? new BiddingInfo() : this.f37173k.mo45197x();
    }

    public View getLogo() {
        return this.f37169g;
    }

    public int getLogoResId() {
        return this.f37179q;
    }

    public int getMediaNameResId() {
        return this.f37182t;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    public MediaStateApi getMediaProxy() {
        InterfaceC7342jp interfaceC7342jp = this.f37160O;
        if (interfaceC7342jp instanceof C7344jr) {
            return new C7339jm((C7344jr) interfaceC7342jp);
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    public C7560ou getMonitorEp() {
        if (this.f37160O instanceof C7341jo) {
            return null;
        }
        return this.f37162Q;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    public RewardVerifyConfig getRewardVerifyConfig() {
        return this.f37152G;
    }

    public View getSloganView() {
        return this.f37146A;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8151u
    public String getTAG() {
        return "PPSSplashView_" + hashCode();
    }

    public String getUniqueId() {
        InterfaceC7328jb interfaceC7328jb = this.f37173k;
        if (interfaceC7328jb != null) {
            return interfaceC7328jb.mo45196w();
        }
        return null;
    }

    @OuterVisible
    public boolean isLoaded() {
        InterfaceC7328jb interfaceC7328jb = this.f37173k;
        return interfaceC7328jb != null && interfaceC7328jb.mo45163b() == AdLoadState.LOADED;
    }

    @OuterVisible
    public boolean isLoading() {
        InterfaceC7328jb interfaceC7328jb = this.f37173k;
        return interfaceC7328jb == null ? this.f37178p : interfaceC7328jb.mo45163b() == AdLoadState.LOADING;
    }

    @OuterVisible
    public void loadAd() {
        AdSlotParam adSlotParam;
        this.f37148C = System.currentTimeMillis();
        AbstractC7185ho.m43820b("PPSSplashView", ApiNames.LOAD_AD);
        if (this.f37174l.mo46218b()) {
            if (this.f37174l.mo46219c() && (adSlotParam = this.f37168f) != null) {
                Integer numM40665r = adSlotParam.m40665r();
                boolean zM44230a = C7288c.m44224a(getContext()).m44230a();
                AbstractC7185ho.m43821b("PPSSplashView", "startMode: %s, isExSplashStart: %s", numM40665r, Boolean.valueOf(zM44230a));
                if ((numM40665r != null && numM40665r.intValue() == 0) || (numM40665r.intValue() == 1 && zM44230a)) {
                    m49693d();
                    return;
                }
            }
            if (this.f37168f != null) {
                C7762bi.m47788b(getContext().getApplicationContext(), this.f37168f.m40659l());
            }
            this.f37178p = true;
            this.f37174l.mo46215a();
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        String str;
        AbstractC7185ho.m43821b("PPSSplashView", "onApplyWindowInsets, sdk: %s", Integer.valueOf(Build.VERSION.SDK_INT));
        if (AbstractC7811dd.m48308b() && windowInsets != null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                List<Rect> boundingRects = displayCutout.getBoundingRects();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("boundingRects:");
                sb2.append(boundingRects == null);
                AbstractC7185ho.m43820b("PPSSplashView", sb2.toString());
                if (!AbstractC7760bg.m47767a(boundingRects)) {
                    this.f37185w = boundingRects.get(0).height();
                }
                this.f37186x = displayCutout.getSafeInsetLeft();
                AbstractC7185ho.m43820b("PPSSplashView", "notchHeight left:" + this.f37186x);
                this.f37187y = displayCutout.getSafeInsetRight();
                str = "notchHeight right:" + this.f37187y;
            } else {
                str = "DisplayCutout is null";
            }
            AbstractC7185ho.m43820b("PPSSplashView", str);
        }
        if (this.f37185w <= 0 && C6982bz.m41148a(getContext()).mo41171a(getContext())) {
            this.f37185w = Math.max(this.f37185w, C6982bz.m41148a(getContext()).mo41169a(this));
        }
        AbstractC7185ho.m43820b("PPSSplashView", "notchHeight:" + this.f37185w);
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC7185ho.m43820b("PPSSplashView", "onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC7817dj.m48366a(this.f37150E);
        PPSSplashProView pPSSplashProView = this.f37153H;
        if (pPSSplashProView != null) {
            pPSSplashProView.m49665a();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.f37154I;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.m50329b();
        }
        PPSSplashSwipeClickView pPSSplashSwipeClickView = this.f37156K;
        if (pPSSplashSwipeClickView != null) {
            pPSSplashSwipeClickView.m50329b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void pauseView() {
        AbstractC7185ho.m43820b("PPSSplashView", "pauseView ");
        InterfaceC8121n interfaceC8121n = this.f37181s;
        if (interfaceC8121n != null) {
            interfaceC8121n.pauseView();
        }
        PPSSplashProView pPSSplashProView = this.f37153H;
        if (pPSSplashProView != null) {
            pPSSplashProView.m49665a();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.f37154I;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.m50329b();
        }
        PPSSplashSwipeClickView pPSSplashSwipeClickView = this.f37156K;
        if (pPSSplashSwipeClickView != null) {
            pPSSplashSwipeClickView.m50329b();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IViewLifeCycle
    public void resumeView() {
        AbstractC7185ho.m43820b("PPSSplashView", "resumeView ");
        InterfaceC8121n interfaceC8121n = this.f37181s;
        if (interfaceC8121n != null) {
            interfaceC8121n.resumeView();
        }
    }

    @OuterVisible
    public void setAdActionListener(AdActionListener adActionListener) {
        this.f37176n = adActionListener;
        InterfaceC7328jb interfaceC7328jb = this.f37173k;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45155a(adActionListener);
        }
    }

    @OuterVisible
    public void setAdListener(AdListener adListener) {
        this.f37175m = adListener;
        this.f37174l.mo46216a(adListener);
        InterfaceC7328jb interfaceC7328jb = this.f37173k;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45156a(adListener);
        }
    }

    @OuterVisible
    public void setAdShowListener(AdShowListener adShowListener) {
        this.f37177o = adShowListener;
        InterfaceC7328jb interfaceC7328jb = this.f37173k;
        if (interfaceC7328jb != null) {
            interfaceC7328jb.mo45157a(adShowListener);
        }
    }

    @OuterVisible
    public void setAdSlotParam(AdSlotParam adSlotParam) {
        if (AbstractC7741ao.m47562b(getContext())) {
            int iM48203a = AbstractC7807d.m48203a(getContext(), adSlotParam.m40639b());
            int iM48216b = AbstractC7807d.m48216b(getContext(), adSlotParam.m40639b());
            adSlotParam.m40640b(iM48203a);
            adSlotParam.m40643c(iM48216b);
            adSlotParam.m40628a(this.f37151F);
            adSlotParam.m40641b(Integer.valueOf(this.f37188z));
            adSlotParam.m40644c((Integer) 0);
            boolean zMo44052e = HiAd.m44014a(getContext()).mo44052e();
            this.f37161P = zMo44052e;
            adSlotParam.m40649d(Integer.valueOf((zMo44052e && AbstractC7807d.m48257t(getContext())) ? 0 : 1));
            AbstractC7014dc.m41876b(!this.f37161P ? 1 : 0);
            this.f37168f = adSlotParam;
            IHiAdSplash hiAdSplash = HiAdSplash.getInstance(getContext());
            if (hiAdSplash instanceof HiAdSplash) {
                ((HiAdSplash) hiAdSplash).m44089a(adSlotParam);
            }
        }
    }

    @OuterVisible
    public void setAudioFocusType(int i10) {
        this.f37184v = i10;
        InterfaceC8121n interfaceC8121n = this.f37181s;
        if (interfaceC8121n != null) {
            interfaceC8121n.setAudioFocusType(i10);
        }
    }

    @OuterVisible
    public void setLinkedSupportMode(int i10) {
        this.f37188z = i10;
    }

    @OuterVisible
    public void setLogo(View view) {
        setLogo(view, 8);
    }

    @OuterVisible
    public void setLogoResId(int i10) {
        this.f37179q = i10;
    }

    @OuterVisible
    public void setMediaNameResId(int i10) {
        this.f37182t = i10;
    }

    @OuterVisible
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.f37152G = rewardVerifyConfig;
    }

    @OuterVisible
    public void setSloganResId(int i10) {
        if (AbstractC7741ao.m47562b(getContext())) {
            if (AbstractC7811dd.m48317c(getContext())) {
                AbstractC7185ho.m43823c("PPSSplashView", "setSloganResId - activity finished, not add view");
                return;
            }
            if (this.f37168f == null) {
                throw new C7110b("Must invoke SplashAdView's setAdSlotParam method before invoke setSloganResId method");
            }
            if (this.f37163a == null) {
                C8070ae c8070ae = new C8070ae(getContext(), this.f37168f.m40639b(), i10, 1);
                this.f37163a = c8070ae;
                int i11 = this.f37183u;
                if (i11 > 0) {
                    c8070ae.setWideSloganResId(i11);
                }
                this.f37164b.addView(this.f37163a, new RelativeLayout.LayoutParams(-1, -1));
                this.f37163a.m49993b();
            }
        }
    }

    @OuterVisible
    public void setSloganView(View view) {
        if (view != null) {
            this.f37146A = view;
            view.setVisibility(8);
        }
    }

    public void setStartMaxVol(float f10) {
    }

    @OuterVisible
    public void setWideSloganResId(int i10) {
        C8070ae c8070ae = this.f37163a;
        if (c8070ae != null) {
            c8070ae.setWideSloganResId(i10);
        } else {
            this.f37183u = i10;
        }
    }

    @OuterVisible
    public void startShowAd() {
        C7327ja c7327ja;
        AbstractC7185ho.m43820b("PPSSplashView", "startShowAd. ");
        InterfaceC7328jb interfaceC7328jb = this.f37173k;
        if (interfaceC7328jb instanceof C7327ja) {
            c7327ja = (C7327ja) interfaceC7328jb;
            if (c7327ja.m45245C()) {
                AbstractC7185ho.m43820b("PPSSplashView", "startShowAd, adHadShown.");
                return;
            }
        } else {
            c7327ja = null;
        }
        ContentRecord contentRecordM41884g = AbstractC7014dc.m41884g();
        if (contentRecordM41884g == null || TextUtils.isEmpty(contentRecordM41884g.m41619z())) {
            return;
        }
        AbstractC7185ho.m43820b("PPSSplashView", "startShowAd, find normal ad. ");
        if (this.f37173k == null) {
            AbstractC7185ho.m43823c("PPSSplashView", "startShowAd, adMediator is null, can't show");
            return;
        }
        if (c7327ja != null) {
            c7327ja.m45246b(true);
        }
        boolean zMo45169c = this.f37173k.mo45169c(contentRecordM41884g);
        this.f37173k.mo45174e(1201);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSSplashView", "startShowAd, showResult: %s", Boolean.valueOf(zMo45169c));
        }
        AbstractC7014dc.m41868a((ContentRecord) null);
    }

    @OuterVisible
    public PPSSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37170h = 8;
        this.f37178p = false;
        this.f37182t = 0;
        this.f37183u = 0;
        this.f37184v = 1;
        this.f37185w = 0;
        this.f37186x = 0;
        this.f37187y = 0;
        this.f37188z = 0;
        this.f37147B = true;
        this.f37149D = 0;
        this.f37150E = "skip_btn_delay_id_" + hashCode();
        m49677a(context);
    }

    /* renamed from: b */
    private String m49684b(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.m40218i();
        }
        return null;
    }

    /* renamed from: c */
    private String m49690c(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.m40219j();
        }
        return null;
    }

    /* renamed from: d */
    private void m49693d() {
        List<String> listM40627a = this.f37168f.m40627a();
        this.f37174l.mo46217a(!AbstractC7760bg.m47767a(listM40627a) ? listM40627a.get(0) : null, 1);
        this.f37174l.mo46220h();
        InterfaceC7342jp interfaceC7342jp = this.f37160O;
        if (interfaceC7342jp != null) {
            interfaceC7342jp.mo45354b();
        }
        C7288c.m44224a(getContext().getApplicationContext()).m44229a(false);
    }

    /* renamed from: e */
    private boolean m49697e() {
        if (this.f37167e.mo43345aL()) {
            return !C7845x.m48582l(getContext().getApplicationContext());
        }
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public InterfaceC8121n mo49705a(int i10) {
        if (i10 == 2) {
            return new C8147q(getContext(), 1);
        }
        if (i10 != 9) {
            return null;
        }
        Context context = getContext();
        int iM40639b = this.f37168f.m40639b();
        int i11 = this.f37187y;
        if (i11 <= 0) {
            i11 = 0;
        }
        return new C8166w(context, iM40639b, i11, this.f37168f.m40647d(), 1);
    }

    @OuterVisible
    public void setLogo(View view, int i10) {
        this.f37169g = view;
        view.setVisibility(i10);
        this.f37170h = i10;
    }

    @OuterVisible
    public PPSSplashView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37170h = 8;
        this.f37178p = false;
        this.f37182t = 0;
        this.f37183u = 0;
        this.f37184v = 1;
        this.f37185w = 0;
        this.f37186x = 0;
        this.f37187y = 0;
        this.f37188z = 0;
        this.f37147B = true;
        this.f37149D = 0;
        this.f37150E = "skip_btn_delay_id_" + hashCode();
        m49677a(context);
    }

    /* renamed from: a */
    private C8152v m49672a(String str, int i10, String str2, boolean z10, float f10, int i11) {
        int i12;
        boolean z11;
        C8152v c8152v;
        int iM40639b = this.f37168f.m40639b();
        int iM40647d = this.f37168f.m40647d();
        m49702k();
        if (1 == iM40639b) {
            c8152v = new C8152v(getContext(), str, iM40639b, iM40647d, i10, str2, z10, this.f37185w, f10, i11, false);
        } else {
            AbstractC7185ho.m43821b("PPSSplashView", "createSkipAdButton, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(iM40639b), Integer.valueOf(this.f37186x), Integer.valueOf(this.f37187y));
            int i13 = this.f37186x;
            if (i13 > 0) {
                z11 = true;
                i12 = i13;
            } else {
                i12 = this.f37187y;
                z11 = false;
            }
            c8152v = new C8152v(getContext(), str, iM40639b, iM40647d, i10, str2, z10, i12, f10, i11, z11);
        }
        c8152v.setAdMediator(this.f37173k);
        return c8152v;
    }

    /* renamed from: b */
    private String m49685b(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.m40221l() == null) ? this.f37167e.mo43031I() : interactCfg.m40221l();
    }

    /* renamed from: d */
    private boolean m49694d(int i10) {
        return 1 == i10 || 4 == i10;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: c */
    public void mo49718c() {
        C8070ae c8070ae = this.f37163a;
        if (c8070ae != null) {
            c8070ae.m49993b();
        }
        View view = this.f37146A;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: a */
    private String m49673a(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.m40217h();
        }
        return null;
    }

    /* renamed from: c */
    private boolean m49691c(int i10) {
        return 2 == i10 || 3 == i10;
    }

    /* renamed from: d */
    private boolean m49695d(ContentRecord contentRecord) {
        if (contentRecord.m41464aP() == 2 && contentRecord.m41419S() != null) {
            return false;
        }
        if (contentRecord.m41464aP() != 3 || AbstractC7760bg.m47767a(contentRecord.m41471aW())) {
            return true;
        }
        Iterator<Asset> it = contentRecord.m41471aW().iterator();
        while (it.hasNext()) {
            if (it.next().m40517e() != null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: b */
    public void mo49716b() {
        InterfaceC7342jp interfaceC7342jp = this.f37160O;
        if (interfaceC7342jp != null) {
            interfaceC7342jp.mo45354b();
            this.f37160O = null;
        }
    }

    /* renamed from: a */
    private String m49674a(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.m40221l() == null) ? this.f37167e.mo43033K() : interactCfg.m40221l();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: b */
    public void mo49717b(int i10) {
        C8152v c8152v = this.f37166d;
        if (c8152v != null) {
            c8152v.m50526a(i10);
        }
    }

    /* renamed from: a */
    private String m49675a(String str) throws Resources.NotFoundException {
        String strM47856a = C7780c.m47856a(getContext(), this.f37159N, 0);
        return !TextUtils.isEmpty(strM47856a) ? strM47856a : !TextUtils.isEmpty(this.f37167e.mo43029G()) ? this.f37167e.mo43029G() : str;
    }

    /* renamed from: b */
    private void m49686b(Context context) {
        View.inflate(context, C6849R.layout.hiad_view_splash_ad, this);
        this.f37164b = (RelativeLayout) findViewById(C6849R.id.rl_splash_container);
        this.f37165c = (RelativeLayout) findViewById(C6849R.id.ar_install_container);
        this.f37171i = (PPSWLSView) findViewById(C6849R.id.splash_wls_view);
        this.f37172j = (PPSSplashAdSourceView) findViewById(C6849R.id.splash_ad_source_view);
        this.f37147B = C6982bz.m41148a(context).mo41175d();
        this.f37153H = (PPSSplashProView) findViewById(C6849R.id.hiad_splash_pro_view);
        this.f37154I = (PPSSplashSwipeView) findViewById(C6849R.id.hiad_splash_swipe_view);
        this.f37155J = (PPSSplashTwistView) findViewById(C6849R.id.hiad_splash_twist_view);
        this.f37157L = (PPSSplashTwistClickView) findViewById(C6849R.id.hiad_splash_twist_click_view);
        this.f37156K = (PPSSplashSwipeClickView) findViewById(C6849R.id.hiad_splash_swipe_click_view);
    }

    /* renamed from: b */
    private void m49687b(ContentRecord contentRecord, int i10) {
        float fM41488aj;
        boolean z10;
        int iM41489ak;
        String str;
        String str2;
        if (AbstractC7811dd.m48317c(getContext())) {
            AbstractC7185ho.m43823c("PPSSplashView", "addSkipAdButton - activity finished, not add view");
            return;
        }
        if (contentRecord != null) {
            boolean z11 = contentRecord.m41594p() == 1;
            String strM41558g = contentRecord.m41558g();
            String strM41407M = contentRecord.m41407M();
            fM41488aj = contentRecord.m41488aj();
            iM41489ak = contentRecord.m41489ak();
            z10 = z11;
            str = strM41558g;
            str2 = strM41407M;
        } else {
            fM41488aj = 0.0f;
            z10 = false;
            iM41489ak = 0;
            str = null;
            str2 = null;
        }
        C8152v c8152vM49672a = m49672a(str, i10, str2, z10, fM41488aj, iM41489ak);
        this.f37166d = c8152vM49672a;
        c8152vM49672a.setId(C6849R.id.hiad_btn_skip);
        addView(this.f37166d);
        this.f37166d.setVisibility(4);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49706a() {
        InterfaceC7342jp interfaceC7342jp = this.f37160O;
        if (interfaceC7342jp != null) {
            interfaceC7342jp.mo45351a();
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49707a(int i10, int i11, String str, boolean z10, Integer num) throws Resources.NotFoundException {
        if (this.f37153H == null) {
            return;
        }
        AbstractC7185ho.m43821b("PPSSplashView", "set splashpro mode: %d", Integer.valueOf(i10));
        AbstractC7185ho.m43821b("PPSSplashView", "interactCfg = %s", num);
        if (num == null) {
            this.f37153H.setVisibility(8);
        } else if (num.intValue() == 0) {
            m49676a(i11, str, z10);
        } else {
            m49681a(z10, num.intValue());
        }
        this.f37153H.setMode(i10);
    }

    /* renamed from: a */
    private void m49676a(int i10, String str, boolean z10) {
        AbstractC7185ho.m43820b("PPSSplashView", "showClickButton");
        m49698f();
        this.f37153H.setVisibility(4);
        this.f37153H.setDesc(m49675a(str));
        this.f37153H.setOrientation(this.f37168f.m40639b());
        this.f37153H.m49666a(z10, i10);
        if (i10 != 0) {
            this.f37153H.setVisibility(0);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49708a(int i10, boolean z10) {
        View view = this.f37169g;
        if (view == null) {
            return;
        }
        if (1 == i10) {
            view.setVisibility(0);
            return;
        }
        view.setVisibility(8);
        if (z10) {
            m49699g();
        }
    }

    /* renamed from: a */
    private void m49677a(Context context) {
        m49686b(context);
        this.f37174l = new C7526nu(context.getApplicationContext(), this);
        this.f37167e = C7124fh.m43316b(context.getApplicationContext());
        this.f37162Q = new C7560ou(context, new C7668sq(context, 1));
        this.f37151F = C7845x.m48577k(context.getApplicationContext());
        this.f37158M = new C8032b();
        C7288c.m44224a(context.getApplicationContext()).m44228a(this.f37158M);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49709a(View view, ContentRecord contentRecord) {
        AbstractC7185ho.m43820b("PPSSplashView", "showTemplateView");
        if (AbstractC7811dd.m48317c(getContext())) {
            AbstractC7185ho.m43823c("PPSSplashView", "showAdView - activity finished, not add view");
            return;
        }
        m49682a(true, view, contentRecord);
        this.f37164b.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
    }

    /* renamed from: a */
    private void m49678a(RelativeLayout.LayoutParams layoutParams) {
        int iM48326f;
        int iM48326f2;
        if (1 == this.f37168f.m40639b()) {
            m49702k();
            if (this.f37185w <= 0) {
                return;
            }
            AbstractC7185ho.m43817a("PPSSplashView", "left:" + layoutParams.leftMargin + ", top:" + layoutParams.topMargin + ", right:" + layoutParams.rightMargin);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + this.f37185w, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            AbstractC7185ho.m43821b("PPSSplashView", "showFullModeLogo, orientation: %s, leftNotchHeight: %s", Integer.valueOf(this.f37168f.m40639b()), Integer.valueOf(this.f37186x));
            AbstractC7185ho.m43818a("PPSSplashView", "left:%d, top:%d, right:%d, leftNotchHeight:%d", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin), Integer.valueOf(this.f37186x));
            if (!C6982bz.m41152b(getContext()) || this.f37186x <= 0) {
                if (!C6982bz.m41152b(getContext()) || (C6982bz.m41152b(getContext()) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 && !C7845x.m48587n(getContext()))) {
                    if (layoutParams.isMarginRelative()) {
                        iM48326f2 = AbstractC7811dd.m48326f(getContext());
                        layoutParams.setMarginStart(iM48326f2);
                    } else {
                        iM48326f = AbstractC7811dd.m48326f(getContext());
                        layoutParams.setMargins(iM48326f, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                    }
                }
                layoutParams.topMargin += AbstractC7741ao.m47535a(getContext(), 12.0f);
            } else if (layoutParams.isMarginRelative()) {
                iM48326f2 = layoutParams.leftMargin + this.f37186x;
                layoutParams.setMarginStart(iM48326f2);
            } else {
                iM48326f = layoutParams.leftMargin + this.f37186x;
                layoutParams.setMargins(iM48326f, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
            this.f37180r.setLayoutParams(layoutParams);
            layoutParams.topMargin += AbstractC7741ao.m47535a(getContext(), 12.0f);
        }
        this.f37180r.setLayoutParams(layoutParams);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49710a(AdLoadMode adLoadMode) {
        AbstractC7323ix abstractC7323ixM45202a = C7324iy.m45202a(adLoadMode, this);
        this.f37173k = abstractC7323ixM45202a;
        abstractC7323ixM45202a.mo45156a(this.f37175m);
        this.f37173k.mo45155a(this.f37176n);
        this.f37173k.mo45157a(this.f37177o);
        this.f37173k.mo45149a(this.f37188z);
        this.f37173k.mo45165b(this.f37148C);
        this.f37173k.mo45154a(this.f37152G);
        this.f37173k.mo45208A();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49711a(ContentRecord contentRecord) {
        super.setAdData(contentRecord);
        super.m50516i();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49712a(ContentRecord contentRecord, int i10) {
        this.f37159N = contentRecord;
        setSkipBtnDelayTime(contentRecord);
        if (this.f37166d == null) {
            m49687b(contentRecord, i10);
        }
        C8152v c8152v = this.f37166d;
        if (c8152v != null) {
            InterfaceC8121n interfaceC8121n = this.f37181s;
            if (interfaceC8121n != null) {
                c8152v.setShowLeftTime(interfaceC8121n.mo50317e());
            }
            if (contentRecord != null && contentRecord.m41568i() != null && contentRecord.m41392E() == 9) {
                this.f37166d.m50526a((int) ((contentRecord.m41568i().m40345y() * 1.0f) / 1000.0f));
            }
            m49703l();
        }
        m49696e(contentRecord);
    }

    /* renamed from: a */
    public void m49679a(ContentRecord contentRecord, int[] iArr, int[] iArr2) {
        if (AbstractC7741ao.m47556a(iArr, 2) && AbstractC7741ao.m47556a(iArr2, 2) && contentRecord != null) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSSplashView", "addComplianceDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                AbstractC7185ho.m43818a("PPSSplashView", "addComplianceDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            C7695tq c7695tq = new C7695tq(getContext(), iArr, iArr2);
            addView(c7695tq, layoutParams);
            contentRecord.m41610u(AbstractC7806cz.m48168c(contentRecord.m41476aa()));
            c7695tq.setScreenHeight(getMeasuredHeight());
            c7695tq.setScreenWidth(getMeasuredWidth());
            c7695tq.setAdContent(contentRecord);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49713a(InterfaceC7182hl interfaceC7182hl) {
        View view = this.f37169g;
        if (view != null) {
            view.setVisibility(this.f37170h);
        }
        View view2 = this.f37146A;
        if (view2 != null) {
            view2.setVisibility(0);
            new C7494nb(this.f37167e, interfaceC7182hl).mo45920a();
            return;
        }
        C8070ae c8070ae = this.f37163a;
        if (c8070ae == null) {
            AbstractC7185ho.m43820b("PPSSplashView", "create default slogan");
            setSloganResId(C6849R.drawable.hiad_default_slogan);
            c8070ae = this.f37163a;
            if (c8070ae == null) {
                return;
            }
        }
        c8070ae.setSloganShowListener(interfaceC7182hl);
        this.f37163a.m49991a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8119l
    /* renamed from: a */
    public void mo49714a(InterfaceC8121n interfaceC8121n, ContentRecord contentRecord) {
        Integer numMo49715b = mo49715b(contentRecord);
        if (AbstractC7811dd.m48317c(getContext())) {
            AbstractC7185ho.m43823c("PPSSplashView", "showAdView - activity finished, not add view");
            return;
        }
        if (interfaceC8121n == 0 || !(interfaceC8121n instanceof View)) {
            return;
        }
        View view = (View) interfaceC8121n;
        this.f37181s = interfaceC8121n;
        m49682a(false, view, contentRecord);
        AbstractC7185ho.m43821b("PPSSplashView", "showAdView %s,", contentRecord.toString());
        ViewParent parent = view.getParent();
        if (parent == this.f37164b) {
            view.setVisibility(0);
            return;
        }
        if (parent != null && (parent instanceof ViewGroup)) {
            AbstractC7185ho.m43820b("PPSSplashView", "showAdView, remove adView.");
            ((ViewGroup) parent).removeView(view);
        } else if (parent != null) {
            return;
        }
        this.f37164b.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
        interfaceC8121n.setAudioFocusType(this.f37184v);
        AbstractC7185ho.m43820b("PPSSplashView", "set splashpro view to adview");
        if (numMo49715b != null && numMo49715b.intValue() == 4) {
            interfaceC8121n.mo50311a(this.f37156K.getClickAreaView(), numMo49715b);
        } else if (numMo49715b == null || numMo49715b.intValue() != 3) {
            interfaceC8121n.mo50311a(this.f37153H, numMo49715b);
        } else {
            interfaceC8121n.mo50311a(this.f37157L.getClickAreaView(), numMo49715b);
        }
    }

    /* renamed from: a */
    private void m49681a(boolean z10, int i10) throws Resources.NotFoundException {
        PPSSplashSwipeClickView pPSSplashSwipeClickView;
        View view;
        AbstractC7185ho.m43821b("PPSSplashView", "showNewStyle, cfg= %s", Integer.valueOf(i10));
        String strM47856a = C7780c.m47856a(getContext(), this.f37159N, i10);
        ContentRecord contentRecord = this.f37159N;
        InteractCfg interactCfgM41459aK = contentRecord != null ? contentRecord.m41459aK() : null;
        if (1 == i10) {
            PPSSplashSwipeView pPSSplashSwipeView = this.f37154I;
            if (pPSSplashSwipeView == null) {
                return;
            }
            pPSSplashSwipeView.setVisibility(4);
            this.f37154I.m50326a(m49673a(interactCfgM41459aK), m49685b(interactCfgM41459aK, strM47856a));
            this.f37154I.setOrientation(this.f37168f.m40639b());
            this.f37154I.setShowLogo(z10);
            view = this.f37154I;
        } else if (2 == i10) {
            PPSSplashTwistView pPSSplashTwistView = this.f37155J;
            if (pPSSplashTwistView == null) {
                return;
            }
            pPSSplashTwistView.setVisibility(4);
            this.f37155J.m50326a(m49684b(interactCfgM41459aK), m49674a(interactCfgM41459aK, strM47856a));
            this.f37155J.setOrientation(this.f37168f.m40639b());
            this.f37155J.setShowLogo(z10);
            view = this.f37155J;
        } else if (3 == i10) {
            PPSSplashTwistClickView pPSSplashTwistClickView = this.f37157L;
            if (pPSSplashTwistClickView == null) {
                return;
            }
            pPSSplashTwistClickView.setVisibility(4);
            this.f37157L.m50326a(m49692d(interactCfgM41459aK), m49674a(interactCfgM41459aK, strM47856a));
            this.f37157L.setOrientation(this.f37168f.m40639b());
            this.f37157L.setShowLogo(z10);
            view = this.f37157L;
        } else {
            if (4 != i10 || (pPSSplashSwipeClickView = this.f37156K) == null) {
                return;
            }
            pPSSplashSwipeClickView.setVisibility(4);
            this.f37156K.m50326a(m49690c(interactCfgM41459aK), m49685b(interactCfgM41459aK, strM47856a));
            this.f37156K.setOrientation(this.f37168f.m40639b());
            this.f37156K.setShowLogo(z10);
            view = this.f37156K;
        }
        view.setVisibility(0);
    }

    /* renamed from: a */
    private void m49682a(boolean z10, View view, ContentRecord contentRecord) {
        if (contentRecord == null) {
            AbstractC7185ho.m43820b("PPSSplashView", "getMonitor, contentRecord is null.");
            return;
        }
        AbstractC7185ho.m43821b("PPSSplashView", "getMonitor, sdkMonitor is %s", Integer.valueOf(contentRecord.m41505b()));
        this.f37162Q.m46575a(contentRecord.m41505b());
        this.f37162Q.mo46590a(contentRecord);
        InterfaceC7342jp interfaceC7342jpM45339a = C7340jn.m45339a(getContext(), m49695d(contentRecord), this.f37162Q, contentRecord, z10);
        this.f37160O = interfaceC7342jpM45339a;
        interfaceC7342jpM45339a.mo45352a(this);
        if (view instanceof C8166w) {
            this.f37160O.mo45353a(((C8166w) view).getVideoView());
        }
        C7340jn.m45343a(contentRecord.m41588n(), this.f37160O);
    }

    /* renamed from: a */
    private boolean m49683a(Long l10) {
        return C7124fh.m43316b(getContext()).mo43333a(l10);
    }
}
