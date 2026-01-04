package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.C5063a;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.InterfaceC5064b;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7335ji;
import com.huawei.openalliance.p169ad.C7491mz;
import com.huawei.openalliance.p169ad.C7556oq;
import com.huawei.openalliance.p169ad.C7570pd;
import com.huawei.openalliance.p169ad.EnumC7473mh;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.InterfaceC7403lm;
import com.huawei.openalliance.p169ad.InterfaceC7474mi;
import com.huawei.openalliance.p169ad.InterfaceC7528nw;
import com.huawei.openalliance.p169ad.activity.ComplianceActivity;
import com.huawei.openalliance.p169ad.analysis.C6927h;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.constant.NotifyMessageNames;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.inter.data.BannerSize;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.RewardVerifyConfig;
import com.huawei.openalliance.p169ad.inter.listeners.BannerAdListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.views.PPSNativeView;
import com.huawei.openalliance.p169ad.views.gif.C8101b;
import com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8115h;
import java.util.ArrayList;
import java.util.List;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSBannerView extends AbstractC8151u implements InterfaceC7403lm, InterfaceC8115h {

    /* renamed from: B */
    private static final byte[] f36554B = new byte[0];

    /* renamed from: A */
    private ImageView f36555A;

    /* renamed from: C */
    private float f36556C;

    /* renamed from: D */
    private EnumC7934b f36557D;

    /* renamed from: E */
    private EnumC7933a f36558E;

    /* renamed from: F */
    private int f36559F;

    /* renamed from: G */
    private List<String> f36560G;

    /* renamed from: H */
    private String f36561H;

    /* renamed from: I */
    private String f36562I;

    /* renamed from: J */
    private C6927h f36563J;

    /* renamed from: K */
    private RequestOptions f36564K;

    /* renamed from: L */
    private Location f36565L;

    /* renamed from: M */
    private String f36566M;

    /* renamed from: N */
    private RewardVerifyConfig f36567N;

    /* renamed from: O */
    private TextView f36568O;

    /* renamed from: P */
    private int f36569P;

    /* renamed from: Q */
    private AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh f36570Q;

    /* renamed from: a */
    Handler f36571a;

    /* renamed from: b */
    private InterfaceC7528nw f36572b;

    /* renamed from: c */
    private long f36573c;

    /* renamed from: d */
    private long f36574d;

    /* renamed from: e */
    private String f36575e;

    /* renamed from: f */
    private BannerAdListener f36576f;

    /* renamed from: g */
    private BannerSize f36577g;

    /* renamed from: h */
    private ChoicesView f36578h;

    /* renamed from: i */
    private ImageView f36579i;

    /* renamed from: j */
    private C5063a f36580j;

    /* renamed from: k */
    private boolean f36581k;

    /* renamed from: l */
    private PPSNativeView f36582l;

    /* renamed from: m */
    private PPSNativeView f36583m;

    /* renamed from: n */
    private ImageView f36584n;

    /* renamed from: o */
    private ImageView f36585o;

    /* renamed from: p */
    private LinearLayout f36586p;

    /* renamed from: q */
    private PPSLabelSourceView f36587q;

    /* renamed from: r */
    private PPSLabelView f36588r;

    /* renamed from: s */
    private TextView f36589s;

    /* renamed from: t */
    private AutoScaleSizeRelativeLayout f36590t;

    /* renamed from: u */
    private INativeAd f36591u;

    /* renamed from: v */
    private INativeAd f36592v;

    /* renamed from: w */
    private int f36593w;

    /* renamed from: x */
    private InterfaceC7146gc f36594x;

    /* renamed from: y */
    private boolean f36595y;

    /* renamed from: z */
    private String f36596z;

    /* renamed from: com.huawei.openalliance.ad.views.PPSBannerView$a */
    public enum EnumC7933a {
        STARTED,
        PAUSED,
        RESUMED,
        DESTROYED
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSBannerView$b */
    public enum EnumC7934b {
        IDLE,
        LOADING
    }

    @OuterVisible
    public PPSBannerView(Context context) {
        super(context);
        this.f36577g = BannerSize.BANNER;
        this.f36581k = true;
        this.f36593w = 0;
        this.f36595y = true;
        this.f36556C = 0.05f;
        this.f36557D = EnumC7934b.IDLE;
        this.f36558E = EnumC7933a.STARTED;
        this.f36559F = 0;
        this.f36570Q = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                AbstractC7185ho.m43817a("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.m49006j();
                PPSBannerView.this.m49014n();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i10) {
                AbstractC7185ho.m43817a("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.m49008k();
                PPSBannerView.this.m49016o();
            }
        };
        this.f36571a = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 1000) {
                    PPSBannerView.this.loadAd();
                } else {
                    if (i10 != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.m48971a(1, pPSBannerView.f36591u, (List<String>) null);
                }
            }
        };
        m48972a(context);
    }

    /* renamed from: a */
    private long m48969a(INativeAd iNativeAd) {
        if (iNativeAd != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long endTime = iNativeAd.getEndTime();
            j = jCurrentTimeMillis < endTime ? endTime - jCurrentTimeMillis : 0L;
            AbstractC7185ho.m43817a("PPSBannerView", "calcAdLeftTime,currentTime:" + jCurrentTimeMillis + ",expireTime:" + endTime + ",leftTime:" + j);
        }
        return j;
    }

    /* renamed from: b */
    private long m48984b(long j10) {
        InterfaceC7146gc interfaceC7146gc;
        if (0 == j10 || (interfaceC7146gc = this.f36594x) == null) {
            return 0L;
        }
        long jMo43415bp = interfaceC7146gc.mo43415bp();
        long jMo43417br = this.f36594x.mo43417br();
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSBannerView", "setBannerRefresh,minInterval:%d,maxInterval:%d", Long.valueOf(jMo43415bp), Long.valueOf(jMo43417br));
        }
        if (jMo43415bp > jMo43417br) {
            return 0L;
        }
        return j10 < jMo43415bp ? jMo43415bp : Math.min(j10, jMo43417br);
    }

    /* renamed from: c */
    private void m48989c() {
        if (this.f36555A == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSBannerView", "init compliance activity");
        this.f36555A.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSBannerView.this.f36591u == null || !(PPSBannerView.this.f36591u instanceof C7302e)) {
                    return;
                }
                ComplianceActivity.m38595a(PPSBannerView.this.getContext(), view, C7570pd.m46698a((C7302e) PPSBannerView.this.f36591u), false);
            }
        });
    }

    /* renamed from: d */
    private ContentRecord m48993d(INativeAd iNativeAd) {
        if (iNativeAd == null) {
            AbstractC7185ho.m43823c("PPSBannerView", "nativeAd is null when convert");
            return null;
        }
        if (iNativeAd instanceof C7302e) {
            return C7570pd.m46698a((C7302e) iNativeAd);
        }
        AbstractC7185ho.m43823c("PPSBannerView", "ad is not native ad when convert");
        return null;
    }

    /* renamed from: f */
    private void m48998f() {
        if (this.f36580j == null) {
            C5063a c5063a = new C5063a(getContext(), this.f36590t);
            this.f36580j = c5063a;
            c5063a.setOnCloseCallBack(new InterfaceC5064b() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.8
                @Override // com.huawei.hms.ads.InterfaceC5064b
                /* renamed from: a */
                public void mo30240a() {
                    if (PPSBannerView.this.f36582l != null) {
                        PPSBannerView.this.f36582l.setVisibility(8);
                    }
                    if (PPSBannerView.this.f36583m != null) {
                        PPSBannerView.this.f36583m.setVisibility(8);
                    }
                }

                @Override // com.huawei.hms.ads.InterfaceC5064b
                /* renamed from: b */
                public void mo30242b() {
                    if (PPSBannerView.this.f36591u instanceof C7302e) {
                        AbstractC7807d.m48214a(PPSBannerView.this.getContext(), (C7302e) PPSBannerView.this.f36591u);
                    }
                }

                @Override // com.huawei.hms.ads.InterfaceC5064b
                /* renamed from: c */
                public List<String> mo30243c() {
                    if (PPSBannerView.this.f36591u == null) {
                        return null;
                    }
                    return PPSBannerView.this.f36591u.getAdCloseKeyWords();
                }

                @Override // com.huawei.hms.ads.InterfaceC5064b
                /* renamed from: a */
                public void mo30241a(String str) {
                    if (PPSBannerView.this.f36582l != null) {
                        PPSBannerView.this.f36582l.setVisibility(8);
                    }
                    if (PPSBannerView.this.f36583m != null) {
                        PPSBannerView.this.f36583m.setVisibility(8);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (str == null || str.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList.add(str);
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.m48971a(0, pPSBannerView.f36591u, arrayList);
                    PPSBannerView pPSBannerView2 = PPSBannerView.this;
                    pPSBannerView2.m48982a(pPSBannerView2.m49010l(), 2, 0);
                }
            });
            AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.f36590t;
            if (autoScaleSizeRelativeLayout != null) {
                autoScaleSizeRelativeLayout.addView(this.f36580j);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f36580j.getLayoutParams());
            layoutParams.addRule(13);
            this.f36580j.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: g */
    private void m49000g() {
        TextView textView;
        int i10;
        String str = this.f36596z;
        if (str == null || str.isEmpty()) {
            textView = this.f36589s;
            i10 = 8;
        } else {
            this.f36589s.setText(this.f36596z);
            textView = this.f36589s;
            i10 = 0;
        }
        textView.setVisibility(i10);
    }

    private EnumC7934b getAdLoadState() {
        EnumC7934b enumC7934b;
        synchronized (f36554B) {
            enumC7934b = this.f36557D;
        }
        return enumC7934b;
    }

    private int getBannerVisibility() {
        int i10;
        synchronized (f36554B) {
            i10 = this.f36559F;
        }
        return i10;
    }

    private void setAdLoadState(EnumC7934b enumC7934b) {
        synchronized (f36554B) {
            this.f36557D = enumC7934b;
        }
    }

    private void setAdViewParam(Context context) {
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.f36590t;
        if (autoScaleSizeRelativeLayout == null || this.f36577g == null || context == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) autoScaleSizeRelativeLayout.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f36590t.setLayoutParams(layoutParams);
        this.f36590t.setRatio(Float.valueOf((this.f36577g.m44447a() * 1.0f) / this.f36577g.m44448b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBannerVisibility(int i10) {
        synchronized (f36554B) {
            this.f36559F = i10;
        }
    }

    private void setChildrenViewsInVisible(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                viewGroup.getChildAt(i10).setVisibility(4);
            }
        }
    }

    private void setChoiceViewPosition(int i10) throws Resources.NotFoundException {
        AbstractC7185ho.m43818a("PPSBannerView", "bannerView option = %d", Integer.valueOf(i10));
        if (this.f36578h == null) {
            AbstractC7185ho.m43817a("PPSBannerView", "choicesView is null, error");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f36578h.getLayoutParams());
        Resources resources = getResources();
        int i11 = C6849R.dimen.hiad_banner_choice_custom_margin;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i11);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(i11);
        if (i10 != 0) {
            if (i10 == 2) {
                layoutParams.addRule(12);
                layoutParams.addRule(21);
                layoutParams.setMargins(0, 0, dimensionPixelOffset, dimensionPixelOffset2);
            } else if (i10 == 3) {
                layoutParams.addRule(12);
                layoutParams.addRule(20);
                layoutParams.setMargins(dimensionPixelOffset, 0, 0, dimensionPixelOffset2);
            } else if (i10 == 4) {
                this.f36578h.setVisibility(8);
                this.f36578h.setLayoutParams(layoutParams);
                this.f36578h.bringToFront();
            } else {
                layoutParams.addRule(10);
                layoutParams.addRule(21);
                layoutParams.setMargins(0, dimensionPixelOffset2, dimensionPixelOffset, 0);
            }
            layoutParams.setMarginEnd(dimensionPixelOffset);
            this.f36578h.setLayoutParams(layoutParams);
            this.f36578h.bringToFront();
        }
        layoutParams.addRule(10);
        layoutParams.addRule(20);
        layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset2, 0, 0);
        layoutParams.setMarginStart(dimensionPixelOffset);
        this.f36578h.setLayoutParams(layoutParams);
        this.f36578h.bringToFront();
    }

    @OuterVisible
    public void destroy() {
        AbstractC7185ho.m43820b("PPSBannerView", "destroy");
        setBannerState(EnumC7933a.DESTROYED);
        m49008k();
        m49016o();
        this.f36571a = null;
        this.f36572b = null;
    }

    @OuterVisible
    public String getAdId() {
        return this.f36575e;
    }

    @OuterVisible
    public long getBannerRefresh() {
        return this.f36573c;
    }

    @OuterVisible
    public BannerSize getBannerSize() {
        return this.f36577g;
    }

    public EnumC7933a getBannerState() {
        EnumC7933a enumC7933a;
        synchronized (f36554B) {
            enumC7933a = this.f36558E;
        }
        return enumC7933a;
    }

    public BiddingInfo getBiddingInfo() {
        INativeAd iNativeAd = this.f36591u;
        return (iNativeAd == null || iNativeAd.getBiddingInfo() == null) ? new BiddingInfo() : this.f36591u.getBiddingInfo();
    }

    public Location getLocation() {
        return this.f36565L;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7403lm
    public View getOpenMeasureView() {
        return this;
    }

    public RequestOptions getRequestOptions() {
        return this.f36564K;
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8151u
    public String getTAG() {
        return "PPSBannerView_" + hashCode();
    }

    @OuterVisible
    public void loadAd() {
        if (m49003h()) {
            return;
        }
        if (!this.f36572b.mo45909a()) {
            m48982a(m49010l(), 1, 1001);
            return;
        }
        if (getAdLoadState() != EnumC7934b.IDLE) {
            AbstractC7185ho.m43823c("PPSBannerView", "ad is loading now!");
            m48982a(m49010l(), 1, 701);
            return;
        }
        setAdLoadState(EnumC7934b.LOADING);
        ArrayList arrayList = new ArrayList();
        String str = this.f36561H;
        if (str == null || str.isEmpty()) {
            arrayList = null;
        } else {
            arrayList.add(this.f36561H);
        }
        AbstractC7185ho.m43818a("PPSBannerView", "load ad cacheContentIds is %s", this.f36561H);
        this.f36572b.mo45904a(this.f36565L);
        this.f36572b.mo45905a(this.f36564K);
        this.f36572b.mo45912b(this.f36566M);
        this.f36572b.mo45907a(Integer.valueOf(this.f36577g.m44447a()));
        this.f36572b.mo45911b(Integer.valueOf(this.f36577g.m44448b()));
        this.f36572b.mo45908a(this.f36575e, 8, arrayList, this.f36573c == 0 ? 0 : 1);
        m49006j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f36570Q;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45301h();
        }
        C7556oq.m46397a(getContext()).m46409b(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f36570Q;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45302i();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f36570Q;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45303j();
        }
    }

    @OuterVisible
    public void pause() {
        if (getBannerState() == EnumC7933a.DESTROYED) {
            AbstractC7185ho.m43820b("PPSBannerView", "hasDestroyed");
            return;
        }
        AbstractC7185ho.m43820b("PPSBannerView", VastAttribute.PAUSE);
        setBannerState(EnumC7933a.PAUSED);
        m49008k();
    }

    @OuterVisible
    public void resume() {
        if (getBannerState() == EnumC7933a.DESTROYED) {
            AbstractC7185ho.m43820b("PPSBannerView", "hasDestroyed");
            return;
        }
        AbstractC7185ho.m43820b("PPSBannerView", "resume");
        setBannerState(EnumC7933a.RESUMED);
        m49006j();
    }

    @OuterVisible
    public void setAdId(String str) {
        this.f36575e = str;
    }

    @OuterVisible
    public void setAdListener(BannerAdListener bannerAdListener) {
        this.f36576f = bannerAdListener;
    }

    @OuterVisible
    public void setBannerRefresh(long j10) {
        long jM48984b = m48984b(j10);
        this.f36573c = jM48984b;
        AbstractC7185ho.m43821b("PPSBannerView", "setBannerRefresh:%s", Long.valueOf(jM48984b));
    }

    @OuterVisible
    public void setBannerSize(BannerSize bannerSize) {
        this.f36577g = bannerSize;
        setAdViewParam(getContext());
    }

    public void setBannerState(EnumC7933a enumC7933a) {
        synchronized (f36554B) {
            this.f36558E = enumC7933a;
        }
    }

    public void setContentBundle(String str) {
        this.f36566M = str;
    }

    public void setLocation(Location location) {
        this.f36565L = location;
    }

    @OuterVisible
    public void setRequestOptions(RequestOptions requestOptions) {
        this.f36564K = requestOptions;
    }

    @OuterVisible
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.f36567N = rewardVerifyConfig;
    }

    @OuterVisible
    public PPSBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36577g = BannerSize.BANNER;
        this.f36581k = true;
        this.f36593w = 0;
        this.f36595y = true;
        this.f36556C = 0.05f;
        this.f36557D = EnumC7934b.IDLE;
        this.f36558E = EnumC7933a.STARTED;
        this.f36559F = 0;
        this.f36570Q = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                AbstractC7185ho.m43817a("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.m49006j();
                PPSBannerView.this.m49014n();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i10) {
                AbstractC7185ho.m43817a("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.m49008k();
                PPSBannerView.this.m49016o();
            }
        };
        this.f36571a = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 1000) {
                    PPSBannerView.this.loadAd();
                } else {
                    if (i10 != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.m48971a(1, pPSBannerView.f36591u, (List<String>) null);
                }
            }
        };
        m48975a(attributeSet);
        m48972a(context);
    }

    /* renamed from: c */
    private void m48990c(long j10) {
        Handler handler = this.f36571a;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f36571a.removeMessages(1000);
        }
        if (getBannerVisibility() == 4 || getBannerState() == EnumC7933a.PAUSED || getBannerState() == EnumC7933a.DESTROYED) {
            AbstractC7185ho.m43820b("PPSBannerView", "stopRefreshAd");
        } else if (0 != j10) {
            AbstractC7185ho.m43821b("PPSBannerView", "start refreshAd ad will be refreshed in %d s", Long.valueOf(j10));
            this.f36571a.sendEmptyMessageDelayed(1000, j10 * 1000);
        }
    }

    /* renamed from: d */
    private void m48994d() {
        AbstractC7185ho.m43817a("PPSBannerView", "initChoicesView start");
        if (this.f36578h == null) {
            ChoicesView choicesView = new ChoicesView(getContext());
            this.f36578h = choicesView;
            choicesView.setId(C6849R.id.hiad_choice_view);
            this.f36590t.addView(this.f36578h);
        }
        this.f36578h.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSBannerView.this.f36580j != null) {
                    PPSBannerView.this.m48997e();
                    PPSBannerView.this.f36580j.m30236b();
                } else if (PPSBannerView.this.f36591u instanceof C7302e) {
                    AbstractC7807d.m48214a(PPSBannerView.this.getContext(), (C7302e) PPSBannerView.this.f36591u);
                }
                PPSBannerView.this.f36578h.setVisibility(8);
            }
        });
        if (BannerSize.BANNER == getBannerSize()) {
            this.f36578h.m30228a();
            this.f36578h.m30229a(C6849R.dimen.hiad_banner_choice_view_size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m48997e() {
        C5063a c5063a = this.f36580j;
        if (c5063a != null) {
            ViewGroup viewGroup = (ViewGroup) c5063a.getParent();
            if (viewGroup != null) {
                setChildrenViewsInVisible(viewGroup);
            }
            this.f36580j.setVisibility(0);
        }
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.f36590t;
        if (autoScaleSizeRelativeLayout != null) {
            autoScaleSizeRelativeLayout.setBackgroundColor(getResources().getColor(C6849R.color.hiad_whythisad_root_bg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m49003h() {
        if (this.f36571a != null && this.f36572b != null) {
            return false;
        }
        AbstractC7185ho.m43820b("PPSBannerView", "view has been destroyed, need re init");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m49006j() {
        long j10 = this.f36573c;
        if (j10 == 0) {
            j10 = this.f36574d;
        }
        m48990c(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m49008k() {
        Handler handler = this.f36571a;
        if (handler == null || !handler.hasMessages(1000)) {
            return;
        }
        AbstractC7185ho.m43820b("PPSBannerView", "stopRefreshAd");
        this.f36571a.removeMessages(1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public boolean m49010l() {
        return this.f36573c > 0 || this.f36574d > 0;
    }

    /* renamed from: m */
    private void m49012m() {
        AbstractC7185ho.m43820b("PPSBannerView", "hide activity");
        C7335ji.m45308a().m45309a(NotifyMessageNames.FEEDBACK_RECEIVE, new Intent("com.huawei.ads.feedback.action.FINISH_FEEDBACK_ACTIVITY"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m49014n() {
        if (this.f36571a == null || this.f36591u == null || m49010l()) {
            return;
        }
        if (this.f36571a.hasMessages(1001)) {
            this.f36571a.removeMessages(1001);
        }
        AbstractC7185ho.m43817a("PPSBannerView", "start closeAdWhenExpire");
        this.f36571a.sendEmptyMessageDelayed(1001, m48969a(this.f36591u));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m49016o() {
        Handler handler = this.f36571a;
        if (handler == null || !handler.hasMessages(1001)) {
            return;
        }
        AbstractC7185ho.m43817a("PPSBannerView", "stopCloseAdWhenExpire");
        this.f36571a.removeMessages(1001);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8115h
    /* renamed from: a */
    public void mo49019a() {
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // java.lang.Runnable
            public void run() {
                PPSBannerView.this.f36563J.m39191a(PPSBannerView.this.f36591u instanceof C7302e ? ((C7302e) PPSBannerView.this.f36591u).m44636f() : "", PPSBannerView.this.f36575e, 8, ErrorCode.ERROR_CODE_OTHER, (String) null, (String) null);
            }
        });
    }

    /* renamed from: b */
    public void m49024b() {
        PPSNativeView pPSNativeView = this.f36582l;
        if (pPSNativeView != null) {
            pPSNativeView.m49352e();
        }
        PPSNativeView pPSNativeView2 = this.f36583m;
        if (pPSNativeView2 != null) {
            pPSNativeView2.m49352e();
        }
    }

    @OuterVisible
    public PPSBannerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36577g = BannerSize.BANNER;
        this.f36581k = true;
        this.f36593w = 0;
        this.f36595y = true;
        this.f36556C = 0.05f;
        this.f36557D = EnumC7934b.IDLE;
        this.f36558E = EnumC7933a.STARTED;
        this.f36559F = 0;
        this.f36570Q = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                AbstractC7185ho.m43817a("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.m49006j();
                PPSBannerView.this.m49014n();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i102) {
                AbstractC7185ho.m43817a("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.m49008k();
                PPSBannerView.this.m49016o();
            }
        };
        this.f36571a = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i102 = message.what;
                if (i102 == 1000) {
                    PPSBannerView.this.loadAd();
                } else {
                    if (i102 != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.m48971a(1, pPSBannerView.f36591u, (List<String>) null);
                }
            }
        };
        m48975a(attributeSet);
        m48972a(context);
    }

    /* renamed from: b */
    private void m48985b(Context context) {
        View.inflate(context, C6849R.layout.hiad_view_banner_ad, this);
        this.f36582l = (PPSNativeView) findViewById(C6849R.id.hiad_banner_layout_1);
        this.f36583m = (PPSNativeView) findViewById(C6849R.id.hiad_banner_layout_2);
        this.f36584n = (ImageView) findViewById(C6849R.id.hiad_banner_image_1);
        this.f36585o = (ImageView) findViewById(C6849R.id.hiad_banner_image_2);
        this.f36586p = (LinearLayout) findViewById(C6849R.id.custom_ad_bg_layout_container);
        this.f36587q = (PPSLabelSourceView) findViewById(C6849R.id.custom_ad_bg_layout);
        this.f36555A = (ImageView) findViewById(C6849R.id.compliance_icon_banner);
        this.f36590t = (AutoScaleSizeRelativeLayout) findViewById(C6849R.id.hiad_banner_ad);
        setAdViewParam(context);
        this.f36590t.setVisibility(8);
        this.f36581k = C6982bz.m41148a(context).mo41175d();
        AbstractC7185ho.m43820b("PPSBannerView", "isChinaRom = " + this.f36581k);
        if (this.f36581k) {
            ImageView imageView = (ImageView) findViewById(C6849R.id.hiad_banner_close_button);
            this.f36579i = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.m48971a(0, pPSBannerView.f36591u, (List<String>) null);
                    PPSBannerView pPSBannerView2 = PPSBannerView.this;
                    pPSBannerView2.m48982a(pPSBannerView2.m49010l(), 2, 0);
                }
            });
        } else {
            m48998f();
            m48994d();
            m48989c();
        }
        m48980a(this.f36582l);
        m48980a(this.f36583m);
    }

    /* renamed from: c */
    private void m48991c(INativeAd iNativeAd) {
        if (this.f36563J == null || iNativeAd == null) {
            return;
        }
        AbstractC7185ho.m43817a("PPSBannerView", "reportAdCancelled");
        this.f36563J.m39187a("49", m48993d(iNativeAd), 0L);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8115h
    /* renamed from: a */
    public void mo49020a(int i10) {
        AbstractC7185ho.m43817a("PPSBannerView", "onReqAdFail ");
        if (m48983a(this.f36561H, this.f36560G)) {
            m48971a(2, this.f36591u, (List<String>) null);
            m48982a(false, 1, 705);
        } else {
            m48982a(m49010l(), 1, i10);
        }
        setAdLoadState(EnumC7934b.IDLE);
    }

    @OuterVisible
    public PPSBannerView(Context context, BannerSize bannerSize, String str) {
        super(context);
        this.f36577g = BannerSize.BANNER;
        this.f36581k = true;
        this.f36593w = 0;
        this.f36595y = true;
        this.f36556C = 0.05f;
        this.f36557D = EnumC7934b.IDLE;
        this.f36558E = EnumC7933a.STARTED;
        this.f36559F = 0;
        this.f36570Q = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                AbstractC7185ho.m43817a("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.m49006j();
                PPSBannerView.this.m49014n();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i102) {
                AbstractC7185ho.m43817a("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.m49008k();
                PPSBannerView.this.m49016o();
            }
        };
        this.f36571a = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i102 = message.what;
                if (i102 == 1000) {
                    PPSBannerView.this.loadAd();
                } else {
                    if (i102 != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.m48971a(1, pPSBannerView.f36591u, (List<String>) null);
                }
            }
        };
        this.f36577g = bannerSize;
        this.f36575e = str;
        m48972a(context);
    }

    /* renamed from: a */
    private void m48970a(int i10, int i11) {
        BannerAdListener bannerAdListener = this.f36576f;
        if (bannerAdListener == null) {
            return;
        }
        if (i10 == 0) {
            bannerAdListener.onAdLoaded();
        } else if (i10 == 1) {
            bannerAdListener.onAdFailedToLoad(i11);
        } else {
            if (i10 != 2) {
                return;
            }
            bannerAdListener.onAdClosed();
        }
    }

    /* renamed from: b */
    private void m48986b(INativeAd iNativeAd) {
        if (this.f36563J == null || iNativeAd == null) {
            return;
        }
        AbstractC7185ho.m43817a("PPSBannerView", "reportAdExpire");
        this.f36563J.m39187a("48", m48993d(iNativeAd), iNativeAd.getEndTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        r4.onClose(r6);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m48971a(int r4, com.huawei.openalliance.p169ad.inter.data.INativeAd r5, java.util.List<java.lang.String> r6) {
        /*
            r3 = this;
            com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout r0 = r3.f36590t
            if (r0 == 0) goto L4a
            r1 = 2
            r2 = 1
            if (r4 == 0) goto L1b
            if (r4 == r2) goto L11
            if (r4 == r1) goto Ld
            goto L2e
        Ld:
            r3.m48991c(r5)
            goto L2e
        L11:
            int r4 = r0.getVisibility()
            if (r4 != 0) goto L2e
            r3.m48986b(r5)
            goto L2e
        L1b:
            int r4 = r3.f36593w
            int r4 = r4 - r2
            int r4 = r4 % r1
            if (r4 != 0) goto L29
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.f36582l
            if (r4 == 0) goto L2e
        L25:
            r4.onClose(r6)
            goto L2e
        L29:
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.f36583m
            if (r4 == 0) goto L2e
            goto L25
        L2e:
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.f36582l
            r5 = 8
            if (r4 == 0) goto L37
            r4.setVisibility(r5)
        L37:
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.f36583m
            if (r4 == 0) goto L3e
            r4.setVisibility(r5)
        L3e:
            com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout r4 = r3.f36590t
            r4.setVisibility(r5)
            com.huawei.openalliance.ad.jh r3 = r3.f36570Q
            if (r3 == 0) goto L4a
            r3.onGlobalLayout()
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.PPSBannerView.m48971a(int, com.huawei.openalliance.ad.inter.data.INativeAd, java.util.List):void");
    }

    /* renamed from: b */
    private void m48988b(PPSNativeView pPSNativeView) {
        InterfaceC7474mi adSessionAgent = pPSNativeView.getAdSessionAgent();
        if (adSessionAgent != null) {
            adSessionAgent.mo45609a(this.f36579i, EnumC7473mh.CLOSE_AD, null);
            PPSLabelView pPSLabelView = this.f36588r;
            EnumC7473mh enumC7473mh = EnumC7473mh.OTHER;
            adSessionAgent.mo45609a(pPSLabelView, enumC7473mh, null);
            adSessionAgent.mo45609a(this.f36589s, enumC7473mh, null);
            adSessionAgent.mo45609a(this.f36568O, enumC7473mh, null);
            adSessionAgent.mo45609a(this.f36578h, enumC7473mh, null);
            adSessionAgent.mo45609a(this.f36580j, enumC7473mh, null);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8115h
    /* renamed from: a */
    public void mo49021a(long j10) {
        this.f36574d = m48984b(j10);
        m49006j();
    }

    /* renamed from: a */
    private void m48972a(Context context) {
        this.f36572b = new C7491mz(context, this);
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(context);
        this.f36594x = interfaceC7146gcM43316b;
        this.f36556C = interfaceC7146gcM43316b.mo43423bx();
        this.f36563J = new C6927h(context);
        this.f36569P = AbstractC7741ao.m47535a(getContext(), getResources().getDimension(C6849R.dimen.hiad_2_dp));
        m48985b(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m48973a(android.graphics.drawable.Drawable r7) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.PPSBannerView.m48973a(android.graphics.drawable.Drawable):void");
    }

    /* renamed from: a */
    private void m48974a(Drawable drawable, final ImageView imageView) {
        if (drawable instanceof C8101b) {
            ((C8101b) drawable).m50248a(new InterfaceC8103d() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.10
                @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
                /* renamed from: a */
                public void mo48916a() {
                    imageView.requestLayout();
                }

                @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
                /* renamed from: b */
                public void mo48917b() {
                }

                @Override // com.huawei.openalliance.p169ad.views.gif.InterfaceC8103d
                /* renamed from: c */
                public void mo48918c() {
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8115h
    /* renamed from: a */
    public void mo49022a(Drawable drawable, INativeAd iNativeAd) throws Resources.NotFoundException {
        if (drawable == null || iNativeAd == null) {
            m48982a(m49010l(), 1, ErrorCode.ERROR_CODE_OTHER);
            AbstractC7185ho.m43823c("PPSBannerView", "onAdContentLoaded,content is null");
        } else {
            this.f36591u = iNativeAd;
            this.f36596z = iNativeAd.getLabel();
            this.f36561H = iNativeAd.getContentId();
            if (0 == m48969a(iNativeAd)) {
                m48986b(iNativeAd);
                AbstractC7185ho.m43817a("PPSBannerView", "do not show ad due to ad expired");
                m48982a(false, 1, ErrorCode.ERROR_BANNER_AD_EXPIRE);
                if (m48983a(this.f36562I, this.f36560G)) {
                    m48971a(2, this.f36592v, (List<String>) null);
                }
            } else if (m48983a(this.f36561H, this.f36560G)) {
                AbstractC7185ho.m43817a("PPSBannerView", "do not show ad due to ad cancelled");
                m48991c(iNativeAd);
                m48982a(false, 1, 705);
            } else {
                m49012m();
                m48973a(drawable);
                m48982a(m49010l(), 0, 0);
                m49014n();
            }
            this.f36562I = this.f36561H;
            this.f36592v = iNativeAd;
        }
        setAdLoadState(EnumC7934b.IDLE);
    }

    /* renamed from: a */
    private void m48975a(AttributeSet attributeSet) {
        String str;
        BannerSize bannerSize;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C6849R.styleable.PPSBannerView);
        try {
            if (typedArrayObtainStyledAttributes != null) {
                try {
                    String string = typedArrayObtainStyledAttributes.getString(C6849R.styleable.PPSBannerView_hiad_adId);
                    if (string != null && !string.isEmpty()) {
                        this.f36575e = string;
                    }
                    String string2 = typedArrayObtainStyledAttributes.getString(C6849R.styleable.PPSBannerView_hiad_bannerSize);
                    if (string2 != null && !string2.isEmpty()) {
                        if (string2.equals(BannerSize.BANNER_STR)) {
                            bannerSize = BannerSize.BANNER;
                        } else if (string2.equals(BannerSize.LARGE_BANNER_STR)) {
                            bannerSize = BannerSize.LARGE_BANNER;
                        }
                        this.f36577g = bannerSize;
                    }
                } catch (RuntimeException e10) {
                    str = "initDefAttr " + e10.getClass().getSimpleName();
                    AbstractC7185ho.m43823c("PPSBannerView", str);
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable th2) {
                    str = "initDefAttr " + th2.getClass().getSimpleName();
                    AbstractC7185ho.m43823c("PPSBannerView", str);
                    typedArrayObtainStyledAttributes.recycle();
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        } catch (Throwable th3) {
            typedArrayObtainStyledAttributes.recycle();
            throw th3;
        }
    }

    /* renamed from: a */
    private void m48980a(final PPSNativeView pPSNativeView) {
        pPSNativeView.setOnNativeAdImpressionListener(new PPSNativeView.InterfaceC7979b() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.5
            @Override // com.huawei.openalliance.p169ad.views.PPSNativeView.InterfaceC7979b
            /* renamed from: a */
            public void mo49025a() {
                if (PPSBannerView.this.m49003h()) {
                    return;
                }
                pPSNativeView.setAdContainerSizeMatched(PPSBannerView.this.f36572b.mo45910a(PPSBannerView.this.f36577g, PPSBannerView.this.f36556C) ? "1" : "0");
            }
        });
    }

    /* renamed from: a */
    private void m48981a(String str) {
        if (!this.f36581k || TextUtils.isEmpty(str)) {
            this.f36568O.setVisibility(8);
            m49000g();
        } else {
            this.f36568O.setText(str);
            this.f36589s.setVisibility(8);
            this.f36568O.setVisibility(0);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8115h
    /* renamed from: a */
    public void mo49023a(List<String> list) {
        this.f36560G = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48982a(boolean z10, int i10, int i11) {
        AbstractC7185ho.m43818a("PPSBannerView", "notifyResult isRefreshAd:%s,resultType:%d", Boolean.valueOf(z10), Integer.valueOf(i10));
        if (!z10) {
            m49008k();
            m48970a(i10, i11);
        } else if (2 == i10) {
            m48970a(i10, i11);
        } else if (this.f36595y) {
            m48970a(i10, i11);
            this.f36595y = false;
        }
    }

    /* renamed from: a */
    private boolean m48983a(String str, List<String> list) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            AbstractC7185ho.m43818a("PPSBannerView", "invalidcontentIds is %s", list);
            AbstractC7185ho.m43818a("PPSBannerView", "currentContentId is %s", str);
            if (list.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
