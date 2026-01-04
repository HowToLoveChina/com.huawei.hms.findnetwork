package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6980bx;
import com.huawei.openalliance.p169ad.C7556oq;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.inter.data.h */
/* loaded from: classes2.dex */
public class C7305h extends AbstractC7298a implements IRewardAd {

    /* renamed from: A */
    private String f33885A;

    /* renamed from: B */
    private String f33886B;

    /* renamed from: C */
    private String f33887C;

    /* renamed from: D */
    private List<String> f33888D;

    /* renamed from: E */
    private String f33889E;

    /* renamed from: G */
    private String f33891G;

    /* renamed from: H */
    private String f33892H;

    /* renamed from: I */
    private transient IRewardAdStatusListener f33893I;

    /* renamed from: J */
    private transient INonwifiActionListener f33894J;

    /* renamed from: K */
    private String f33895K;

    /* renamed from: M */
    private String f33897M;

    /* renamed from: N */
    private String f33898N;

    /* renamed from: O */
    private long f33899O;

    /* renamed from: Q */
    private RewardItem f33901Q;

    /* renamed from: R */
    private String f33902R;

    /* renamed from: U */
    private String f33905U;

    /* renamed from: V */
    private List<Asset> f33906V;

    /* renamed from: W */
    private TemplateData f33907W;

    /* renamed from: X */
    private Integer f33908X;

    /* renamed from: h */
    private int f33910h;

    /* renamed from: i */
    private String f33911i;

    /* renamed from: j */
    private String f33912j;

    /* renamed from: k */
    private String f33913k;

    /* renamed from: l */
    private List<ImageInfo> f33914l;

    /* renamed from: m */
    private List<ImageInfo> f33915m;

    /* renamed from: n */
    private String f33916n;

    /* renamed from: o */
    private long f33917o;

    /* renamed from: p */
    private int f33918p;

    /* renamed from: q */
    private String f33919q;

    /* renamed from: r */
    private String f33920r;

    /* renamed from: s */
    private VideoInfo f33921s;

    /* renamed from: t */
    private List<String> f33922t;

    /* renamed from: u */
    private AppInfo f33923u;

    /* renamed from: v */
    private String f33924v;

    /* renamed from: w */
    private String f33925w;

    /* renamed from: x */
    private int f33926x;

    /* renamed from: y */
    private List<Integer> f33927y;

    /* renamed from: g */
    private boolean f33909g = false;

    /* renamed from: z */
    private boolean f33928z = false;

    /* renamed from: F */
    private boolean f33890F = false;

    /* renamed from: L */
    private boolean f33896L = false;

    /* renamed from: P */
    private boolean f33900P = true;

    /* renamed from: S */
    private int f33903S = 1;

    /* renamed from: T */
    private boolean f33904T = true;

    /* renamed from: A */
    public void m44901A(String str) {
        this.f33919q = str;
    }

    /* renamed from: B */
    public void m44902B(String str) {
        this.f33920r = str;
    }

    /* renamed from: C */
    public void m44903C(String str) {
        this.f33924v = str;
    }

    /* renamed from: D */
    public int m44904D() {
        return this.f33910h;
    }

    /* renamed from: E */
    public String m44906E() {
        return this.f33912j;
    }

    /* renamed from: F */
    public List<ImageInfo> m44908F() {
        return this.f33914l;
    }

    /* renamed from: G */
    public List<ImageInfo> m44910G() {
        return this.f33915m;
    }

    /* renamed from: H */
    public String m44912H() {
        return this.f33916n;
    }

    /* renamed from: I */
    public String m44914I() {
        return this.f33919q;
    }

    /* renamed from: J */
    public String m44916J() {
        return this.f33920r;
    }

    /* renamed from: K */
    public VideoInfo m44918K() {
        return this.f33921s;
    }

    /* renamed from: L */
    public String m44920L() {
        return this.f33924v;
    }

    /* renamed from: M */
    public List<Integer> m44922M() {
        return this.f33927y;
    }

    /* renamed from: N */
    public int m44924N() {
        return this.f33926x;
    }

    /* renamed from: O */
    public void m44926O(String str) {
        this.f33902R = str;
    }

    /* renamed from: P */
    public String m44928P() {
        return this.f33886B;
    }

    /* renamed from: Q */
    public List<String> m44930Q() {
        return this.f33888D;
    }

    /* renamed from: R */
    public String m44932R() {
        return this.f33889E;
    }

    /* renamed from: S */
    public boolean m44933S() {
        return this.f33890F;
    }

    /* renamed from: T */
    public String m44934T() {
        return this.f33891G;
    }

    /* renamed from: U */
    public String m44935U() {
        return this.f33911i;
    }

    /* renamed from: V */
    public String m44936V() {
        return this.f33925w;
    }

    /* renamed from: W */
    public String m44937W() {
        return this.f33892H;
    }

    /* renamed from: X */
    public INonwifiActionListener m44938X() {
        return this.f33894J;
    }

    /* renamed from: Y */
    public boolean m44939Y() {
        if (!AbstractC7558os.m46460H(getCtrlSwitchs())) {
            return this.f33900P;
        }
        AbstractC7185ho.m43820b("RewardAd", "server switch first, mute.");
        return true;
    }

    /* renamed from: Z */
    public IRewardAdStatusListener m44940Z() {
        return this.f33893I;
    }

    /* renamed from: a */
    public void m44941a(TemplateData templateData) {
        this.f33907W = templateData;
    }

    /* renamed from: aa */
    public String m44946aa() {
        return this.f33895K;
    }

    /* renamed from: ab */
    public boolean m44947ab() {
        return this.f33896L;
    }

    /* renamed from: ac */
    public String m44948ac() {
        return this.f33897M;
    }

    /* renamed from: ad */
    public String m44949ad() {
        return this.f33898N;
    }

    /* renamed from: ae */
    public long m44950ae() {
        return this.f33899O;
    }

    /* renamed from: af */
    public boolean m44951af() {
        if (!AbstractC7558os.m46459G(getCtrlSwitchs())) {
            return this.f33904T;
        }
        AbstractC7185ho.m43820b("RewardAd", "server switch first, need data alert.");
        return true;
    }

    /* renamed from: ag */
    public int m44952ag() {
        return this.f33903S;
    }

    /* renamed from: ah */
    public String m44953ah() {
        return this.f33902R;
    }

    /* renamed from: ai */
    public String m44954ai() {
        return this.f33905U;
    }

    /* renamed from: aj */
    public List<Asset> m44955aj() {
        return this.f33906V;
    }

    /* renamed from: ak */
    public TemplateData m44956ak() {
        return this.f33907W;
    }

    /* renamed from: al */
    public Integer m44957al() {
        return this.f33908X;
    }

    /* renamed from: d */
    public void m44958d(long j10) {
        this.f33917o = j10;
    }

    /* renamed from: e */
    public void m44960e(long j10) {
        this.f33899O = j10;
    }

    /* renamed from: f */
    public void m44963f(Integer num) {
        this.f33908X = num;
    }

    /* renamed from: g */
    public void m44966g(int i10) {
        this.f33910h = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public AppInfo getAppInfo() {
        return this.f33923u;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getCtrlSwitchs() {
        return this.f33887C;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getMaxEffectiveShowTime() {
        return 0L;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public int getMinEffectiveShowRatio() {
        return this.f33918p;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getMinEffectiveShowTime() {
        return this.f33917o;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IRewardAd
    public RewardItem getRewardItem() {
        return this.f33901Q;
    }

    /* renamed from: h */
    public void m44969h(int i10) {
        this.f33918p = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IRewardAd
    public boolean hasShown() {
        return m44927O();
    }

    /* renamed from: i */
    public void m44972i(int i10) {
        this.f33926x = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IRewardAd
    public boolean isValid() {
        return (m44957al() != null && m44957al().intValue() == 3) || this.f33921s != null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IRewardAd
    public void setAudioFocusType(int i10) {
        this.f33903S = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IRewardAd
    public void setMobileDataAlertSwitch(boolean z10) {
        this.f33904T = z10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IRewardAd
    public void setMute(boolean z10) {
        this.f33900P = z10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IRewardAd
    public void setNonwifiActionListener(INonwifiActionListener iNonwifiActionListener) {
        this.f33894J = iNonwifiActionListener;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IRewardAd
    public void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        if (videoConfiguration == null) {
            return;
        }
        if (HiAd.m44013a() != null) {
            HiAd.m44013a().mo44044a(videoConfiguration, AbstractC7558os.m46459G(getCtrlSwitchs()), AbstractC7558os.m46460H(getCtrlSwitchs()), 7);
        }
        if (videoConfiguration.getAutoPlayNetwork() == 1) {
            setMobileDataAlertSwitch(false);
        } else {
            setMobileDataAlertSwitch(true);
        }
        setMute(videoConfiguration.isMute());
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IRewardAd
    public void show(Context context, IRewardAdStatusListener iRewardAdStatusListener) {
        AbstractC7185ho.m43820b("RewardAd", ParamConstants.CallbackMethod.ON_SHOW);
        m44945a(iRewardAdStatusListener);
        if (this.f33923u != null) {
            AbstractC7185ho.m43817a("RewardAd", "appName:" + this.f33923u.getAppName() + ", uniqueId:" + getUniqueId() + ", appuniqueId:" + this.f33923u.getUniqueId());
        }
        C6980bx.m41143a(context, this);
        C7556oq.m46397a(context).m46409b(context);
    }

    /* renamed from: x */
    public void m44974x(String str) {
        this.f33912j = str;
    }

    /* renamed from: y */
    public void m44975y(String str) {
        this.f33913k = str;
    }

    /* renamed from: z */
    public void m44976z(String str) {
        this.f33916n = str;
    }

    /* renamed from: D */
    public void m44905D(String str) {
        this.f33886B = str;
    }

    /* renamed from: E */
    public void m44907E(String str) {
        this.f33887C = str;
    }

    /* renamed from: F */
    public void m44909F(String str) {
        this.f33889E = str;
    }

    /* renamed from: G */
    public void m44911G(String str) {
        this.f33891G = str;
    }

    /* renamed from: H */
    public void m44913H(String str) {
        this.f33911i = str;
    }

    /* renamed from: I */
    public void m44915I(String str) {
        this.f33925w = str;
    }

    /* renamed from: J */
    public void m44917J(String str) {
        this.f33892H = str;
    }

    /* renamed from: K */
    public void m44919K(String str) {
        this.f33895K = str;
    }

    /* renamed from: L */
    public void m44921L(String str) {
        this.f33885A = str;
    }

    /* renamed from: M */
    public void m44923M(String str) {
        this.f33897M = str;
    }

    /* renamed from: N */
    public void m44925N(String str) {
        this.f33898N = str;
    }

    /* renamed from: O */
    public boolean m44927O() {
        return this.f33928z;
    }

    /* renamed from: P */
    public void m44929P(String str) {
        this.f33905U = str;
    }

    /* renamed from: Q */
    public void m44931Q(String str) {
        this.f33723a = str;
    }

    /* renamed from: a */
    public void m44942a(AppInfo appInfo) {
        this.f33923u = appInfo;
    }

    /* renamed from: d */
    public void m44959d(List<ImageInfo> list) {
        this.f33914l = list;
    }

    /* renamed from: e */
    public void m44961e(List<ImageInfo> list) {
        this.f33915m = list;
    }

    /* renamed from: f */
    public void m44964f(List<String> list) {
        this.f33922t = list;
    }

    /* renamed from: g */
    public void m44967g(List<Integer> list) {
        this.f33927y = list;
    }

    /* renamed from: h */
    public void m44970h(List<String> list) {
        this.f33888D = list;
    }

    /* renamed from: i */
    public void m44973i(List<Asset> list) {
        this.f33906V = list;
    }

    /* renamed from: a */
    public void m44943a(RewardItem rewardItem) {
        this.f33901Q = rewardItem;
    }

    /* renamed from: e */
    public void m44962e(boolean z10) {
        this.f33909g = z10;
    }

    /* renamed from: f */
    public void m44965f(boolean z10) {
        this.f33928z = z10;
    }

    /* renamed from: g */
    public void m44968g(boolean z10) {
        this.f33890F = z10;
    }

    /* renamed from: h */
    public void m44971h(boolean z10) {
        this.f33896L = z10;
    }

    /* renamed from: a */
    public void m44944a(VideoInfo videoInfo) {
        this.f33921s = videoInfo;
    }

    /* renamed from: a */
    public void m44945a(IRewardAdStatusListener iRewardAdStatusListener) {
        this.f33893I = iRewardAdStatusListener;
    }
}
