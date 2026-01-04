package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6980bx;
import com.huawei.openalliance.p169ad.C7556oq;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.Asset;
import com.huawei.openalliance.p169ad.beans.metadata.p170v3.TemplateData;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.inter.data.d */
/* loaded from: classes2.dex */
public class C7301d extends AbstractC7298a implements InterfaceC7299b {

    /* renamed from: A */
    private String f33749A;

    /* renamed from: B */
    private List<String> f33750B;

    /* renamed from: C */
    private String f33751C;

    /* renamed from: E */
    private String f33753E;

    /* renamed from: F */
    private String f33754F;

    /* renamed from: H */
    private InterfaceC7311a f33756H;

    /* renamed from: I */
    private RewardItem f33757I;

    /* renamed from: J */
    private String f33758J;

    /* renamed from: L */
    private String f33760L;

    /* renamed from: M */
    private String f33761M;

    /* renamed from: N */
    private long f33762N;

    /* renamed from: O */
    private String f33763O;

    /* renamed from: P */
    private VideoConfiguration f33764P;

    /* renamed from: R */
    private Integer f33766R;

    /* renamed from: S */
    private String f33767S;

    /* renamed from: T */
    private List<Asset> f33768T;

    /* renamed from: U */
    private TemplateData f33769U;

    /* renamed from: h */
    private int f33771h;

    /* renamed from: i */
    private String f33772i;

    /* renamed from: j */
    private String f33773j;

    /* renamed from: k */
    private String f33774k;

    /* renamed from: l */
    private List<ImageInfo> f33775l;

    /* renamed from: m */
    private String f33776m;

    /* renamed from: n */
    private long f33777n;

    /* renamed from: o */
    private int f33778o;

    /* renamed from: p */
    private String f33779p;

    /* renamed from: q */
    private String f33780q;

    /* renamed from: r */
    private VideoInfo f33781r;

    /* renamed from: s */
    private List<String> f33782s;

    /* renamed from: t */
    private AppInfo f33783t;

    /* renamed from: u */
    private String f33784u;

    /* renamed from: v */
    private String f33785v;

    /* renamed from: w */
    private int f33786w;

    /* renamed from: x */
    private List<Integer> f33787x;

    /* renamed from: z */
    private String f33789z;

    /* renamed from: g */
    private boolean f33770g = false;

    /* renamed from: y */
    private boolean f33788y = false;

    /* renamed from: D */
    private boolean f33752D = false;

    /* renamed from: G */
    private boolean f33755G = true;

    /* renamed from: K */
    private boolean f33759K = false;

    /* renamed from: Q */
    private boolean f33765Q = true;

    /* renamed from: A */
    public void m44681A(String str) {
        this.f33776m = str;
    }

    /* renamed from: B */
    public void m44682B(String str) {
        this.f33779p = str;
    }

    /* renamed from: C */
    public void m44683C(String str) {
        this.f33780q = str;
    }

    /* renamed from: D */
    public RewardItem m44684D() {
        return this.f33757I;
    }

    /* renamed from: E */
    public int m44686E() {
        return this.f33771h;
    }

    /* renamed from: F */
    public String m44688F() {
        return this.f33772i;
    }

    /* renamed from: G */
    public String m44690G() {
        return this.f33773j;
    }

    /* renamed from: H */
    public String m44692H() {
        return this.f33776m;
    }

    /* renamed from: I */
    public String m44694I() {
        return this.f33779p;
    }

    /* renamed from: J */
    public String m44696J() {
        return this.f33780q;
    }

    /* renamed from: K */
    public VideoInfo m44698K() {
        return this.f33781r;
    }

    /* renamed from: L */
    public String m44700L() {
        return this.f33784u;
    }

    /* renamed from: M */
    public String m44702M() {
        return this.f33785v;
    }

    /* renamed from: N */
    public int m44704N() {
        return this.f33786w;
    }

    /* renamed from: O */
    public String m44706O() {
        return this.f33789z;
    }

    /* renamed from: P */
    public List<String> m44708P() {
        return this.f33750B;
    }

    /* renamed from: Q */
    public String m44710Q() {
        return this.f33751C;
    }

    /* renamed from: R */
    public boolean m44711R() {
        return this.f33752D;
    }

    /* renamed from: S */
    public String m44712S() {
        return this.f33753E;
    }

    /* renamed from: T */
    public String m44713T() {
        return this.f33754F;
    }

    /* renamed from: U */
    public boolean m44714U() {
        if (!AbstractC7558os.m46460H(getCtrlSwitchs())) {
            return this.f33755G;
        }
        AbstractC7185ho.m43820b("InnerInterstitialAd", "server switch first, mute.");
        return true;
    }

    /* renamed from: V */
    public String m44715V() {
        return this.f33761M;
    }

    /* renamed from: W */
    public long m44716W() {
        return this.f33762N;
    }

    /* renamed from: X */
    public Integer m44717X() {
        return this.f33766R;
    }

    /* renamed from: Y */
    public String m44718Y() {
        return this.f33767S;
    }

    /* renamed from: Z */
    public TemplateData m44719Z() {
        return this.f33769U;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b
    /* renamed from: a */
    public void mo44676a(Context context, InterfaceC7311a interfaceC7311a) {
        if (context == null) {
            return;
        }
        m44734e(true);
        m44724a(interfaceC7311a);
        AppInfo appInfo = getAppInfo();
        if (appInfo != null) {
            AbstractC7185ho.m43818a("InnerInterstitialAd", "appName:%s, uniqueId:%s, appuniqueId:%s", appInfo.getAppName(), getUniqueId(), appInfo.getUniqueId());
        }
        C6980bx.m41142a(context, this);
        C7556oq.m46397a(context).m46409b(context);
    }

    /* renamed from: aa */
    public List<Asset> m44725aa() {
        return this.f33768T;
    }

    /* renamed from: ab */
    public List<Integer> m44726ab() {
        return this.f33787x;
    }

    /* renamed from: ac */
    public String m44727ac() {
        return this.f33763O;
    }

    /* renamed from: ad */
    public InterfaceC7311a m44728ad() {
        return this.f33756H;
    }

    /* renamed from: ae */
    public boolean m44729ae() {
        if (!AbstractC7558os.m46459G(getCtrlSwitchs())) {
            return this.f33765Q;
        }
        AbstractC7185ho.m43820b("InnerInterstitialAd", "server switch first, need data alert.");
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b
    /* renamed from: b_ */
    public boolean mo44678b_() {
        return this.f33788y;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b
    /* renamed from: c_ */
    public boolean mo44679c_() {
        if (mo44680d_()) {
            return true;
        }
        int creativeType = getCreativeType();
        return (creativeType == 2 || creativeType == 4) ? !AbstractC7760bg.m47767a(this.f33775l) : creativeType == 9 && this.f33781r != null;
    }

    /* renamed from: d */
    public void m44730d(long j10) {
        this.f33777n = j10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b
    /* renamed from: d_ */
    public boolean mo44680d_() {
        Integer num;
        return (this.f33768T == null || (num = this.f33766R) == null || num.intValue() != 3) ? false : true;
    }

    /* renamed from: e */
    public void m44732e(long j10) {
        this.f33762N = j10;
    }

    /* renamed from: f */
    public void m44735f(Integer num) {
        this.f33766R = num;
    }

    /* renamed from: g */
    public void m44738g(int i10) {
        this.f33771h = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public AppInfo getAppInfo() {
        return this.f33783t;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getCtrlSwitchs() {
        return this.f33749A;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getMaxEffectiveShowTime() {
        return 0L;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public int getMinEffectiveShowRatio() {
        return this.f33778o;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getMinEffectiveShowTime() {
        return this.f33777n;
    }

    /* renamed from: h */
    public void m44741h(int i10) {
        this.f33778o = i10;
    }

    /* renamed from: i */
    public void m44744i(int i10) {
        this.f33786w = i10;
    }

    /* renamed from: x */
    public void m44745x(String str) {
        this.f33772i = str;
    }

    /* renamed from: y */
    public void m44746y(String str) {
        this.f33773j = str;
    }

    /* renamed from: z */
    public void m44747z(String str) {
        this.f33774k = str;
    }

    /* renamed from: D */
    public void m44685D(String str) {
        this.f33784u = str;
    }

    /* renamed from: E */
    public void m44687E(String str) {
        this.f33785v = str;
    }

    /* renamed from: F */
    public void m44689F(String str) {
        this.f33789z = str;
    }

    /* renamed from: G */
    public void m44691G(String str) {
        this.f33749A = str;
    }

    /* renamed from: H */
    public void m44693H(String str) {
        this.f33751C = str;
    }

    /* renamed from: I */
    public void m44695I(String str) {
        this.f33753E = str;
    }

    /* renamed from: J */
    public void m44697J(String str) {
        this.f33754F = str;
    }

    /* renamed from: K */
    public void m44699K(String str) {
        this.f33758J = str;
    }

    /* renamed from: L */
    public void m44701L(String str) {
        this.f33760L = str;
    }

    /* renamed from: M */
    public void m44703M(String str) {
        this.f33761M = str;
    }

    /* renamed from: N */
    public void m44705N(String str) {
        this.f33767S = str;
    }

    /* renamed from: O */
    public void m44707O(String str) {
        this.f33763O = str;
    }

    /* renamed from: P */
    public void m44709P(String str) {
        this.f33723a = str;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b
    /* renamed from: a */
    public void mo44677a(VideoConfiguration videoConfiguration) {
        if (videoConfiguration == null) {
            return;
        }
        this.f33764P = videoConfiguration;
        if (HiAd.m44013a() != null) {
            HiAd.m44013a().mo44044a(videoConfiguration, AbstractC7558os.m46459G(getCtrlSwitchs()), AbstractC7558os.m46460H(getCtrlSwitchs()), 12);
        }
        if (videoConfiguration.getAutoPlayNetwork() == 1) {
            m44743h(false);
        } else {
            m44743h(true);
        }
        m44737f(videoConfiguration.isMute());
    }

    /* renamed from: d */
    public void m44731d(List<ImageInfo> list) {
        this.f33775l = list;
    }

    /* renamed from: e */
    public void m44733e(List<String> list) {
        this.f33782s = list;
    }

    /* renamed from: f */
    public void m44736f(List<String> list) {
        this.f33750B = list;
    }

    /* renamed from: g */
    public void m44739g(List<Asset> list) {
        this.f33768T = list;
    }

    /* renamed from: h */
    public void m44742h(List<Integer> list) {
        this.f33787x = list;
    }

    /* renamed from: a */
    public void m44720a(TemplateData templateData) {
        this.f33769U = templateData;
    }

    /* renamed from: e */
    public void m44734e(boolean z10) {
        this.f33788y = z10;
    }

    /* renamed from: f */
    public void m44737f(boolean z10) {
        this.f33755G = z10;
    }

    /* renamed from: g */
    public void m44740g(boolean z10) {
        this.f33752D = z10;
    }

    /* renamed from: h */
    public void m44743h(boolean z10) {
        this.f33765Q = z10;
    }

    /* renamed from: a */
    public void m44721a(AppInfo appInfo) {
        this.f33783t = appInfo;
    }

    /* renamed from: a */
    public void m44722a(RewardItem rewardItem) {
        this.f33757I = rewardItem;
    }

    /* renamed from: a */
    public void m44723a(VideoInfo videoInfo) {
        this.f33781r = videoInfo;
    }

    /* renamed from: a */
    public void m44724a(InterfaceC7311a interfaceC7311a) {
        this.f33756H = interfaceC7311a;
    }
}
