package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6980bx;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.beans.metadata.AdSource;
import com.huawei.openalliance.p169ad.beans.metadata.C6957Om;
import com.huawei.openalliance.p169ad.beans.metadata.CtrlExt;
import com.huawei.openalliance.p169ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.WhiteListPkgList;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.InterfaceC7308f;
import com.huawei.openalliance.p169ad.inter.data.RewardVerifyConfig;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7830i;
import java.util.List;
import java.util.UUID;

/* renamed from: com.huawei.openalliance.ad.inter.data.a */
/* loaded from: classes2.dex */
public abstract class AbstractC7298a implements IAd {

    /* renamed from: A */
    private List<C6957Om> f33698A;

    /* renamed from: B */
    private String f33699B;

    /* renamed from: D */
    private int f33701D;

    /* renamed from: E */
    private long f33702E;

    /* renamed from: F */
    private Integer f33703F;

    /* renamed from: G */
    private Integer f33704G;

    /* renamed from: H */
    private boolean f33705H;

    /* renamed from: I */
    private List<AdSource> f33706I;

    /* renamed from: J */
    private String f33707J;

    /* renamed from: K */
    private String f33708K;

    /* renamed from: L */
    private String f33709L;

    /* renamed from: M */
    private List<AdvertiserInfo> f33710M;

    /* renamed from: O */
    private String f33712O;

    /* renamed from: P */
    private Integer f33713P;

    /* renamed from: Q */
    private transient CtrlExt f33714Q;

    /* renamed from: S */
    private String f33716S;

    /* renamed from: U */
    private String f33718U;

    /* renamed from: V */
    private PromoteInfo f33719V;

    /* renamed from: W */
    private BiddingInfo f33720W;

    /* renamed from: Y */
    private String f33722Y;

    /* renamed from: a */
    protected String f33723a;

    /* renamed from: b */
    protected String f33724b;

    /* renamed from: c */
    protected long f33725c;

    /* renamed from: d */
    protected String f33726d;

    /* renamed from: e */
    protected String f33727e;

    /* renamed from: f */
    protected String f33728f;

    /* renamed from: g */
    private transient AdContentData f33729g;

    /* renamed from: i */
    private String f33731i;

    /* renamed from: k */
    private String f33733k;

    /* renamed from: m */
    private int f33735m;

    /* renamed from: n */
    private int f33736n;

    /* renamed from: o */
    private String f33737o;

    /* renamed from: p */
    private String f33738p;

    /* renamed from: q */
    private long f33739q;

    /* renamed from: r */
    private int f33740r;

    /* renamed from: s */
    private String f33741s;

    /* renamed from: u */
    private String f33743u;

    /* renamed from: v */
    private String f33744v;

    /* renamed from: w */
    private String f33745w;

    /* renamed from: x */
    private Integer f33746x;

    /* renamed from: y */
    private String f33747y;

    /* renamed from: z */
    private String f33748z;

    /* renamed from: h */
    private String f33730h = String.valueOf(AbstractC7741ao.m47566c());

    /* renamed from: j */
    private boolean f33732j = false;

    /* renamed from: l */
    private String f33734l = "2";

    /* renamed from: t */
    private int f33742t = 0;

    /* renamed from: C */
    private String f33700C = UUID.randomUUID().toString();

    /* renamed from: N */
    private int f33711N = 0;

    /* renamed from: R */
    private boolean f33715R = false;

    /* renamed from: T */
    private boolean f33717T = false;

    /* renamed from: X */
    private Integer f33721X = 0;

    /* renamed from: A */
    public String m44598A() {
        return this.f33718U;
    }

    /* renamed from: B */
    public String m44599B() {
        return this.f33722Y;
    }

    /* renamed from: C */
    public String m44600C() {
        return this.f33731i;
    }

    /* renamed from: a */
    public Integer m44601a() {
        return this.f33721X;
    }

    /* renamed from: b */
    public void m44613b(int i10) {
        this.f33740r = i10;
    }

    /* renamed from: c */
    public String m44620c() {
        return this.f33712O;
    }

    /* renamed from: d */
    public CtrlExt m44627d() {
        if (this.f33714Q == null) {
            this.f33714Q = (CtrlExt) AbstractC7758be.m47739b(this.f33712O, CtrlExt.class, new Class[0]);
        }
        return this.f33714Q;
    }

    /* renamed from: e */
    public int m44632e() {
        return this.f33740r;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC7298a) || (str = this.f33724b) == null) {
            return false;
        }
        return TextUtils.equals(str, ((AbstractC7298a) obj).f33724b);
    }

    /* renamed from: f */
    public String m44636f() {
        return this.f33741s;
    }

    /* renamed from: g */
    public int m44639g() {
        return this.f33742t;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getAbilityDetailInfo() {
        return this.f33708K;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getAdChoiceIcon() {
        return this.f33745w;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getAdChoiceUrl() {
        return this.f33744v;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getAdSign() {
        return this.f33734l;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public BiddingInfo getBiddingInfo() {
        BiddingInfo biddingInfo = this.f33720W;
        return biddingInfo == null ? new BiddingInfo() : biddingInfo;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public List<AdvertiserInfo> getCompliance() {
        return this.f33710M;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getContentId() {
        return this.f33724b;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public int getCreativeType() {
        return this.f33735m;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getCta() {
        return this.f33733k;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getDspLogo() {
        AdSource adSourceM39547a = AdSource.m39547a(this.f33706I);
        if (adSourceM39547a != null) {
            return adSourceM39547a.m39554b();
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getDspName() {
        AdSource adSourceM39547a = AdSource.m39547a(this.f33706I);
        if (adSourceM39547a != null) {
            return AbstractC7806cz.m48168c(adSourceM39547a.m39551a());
        }
        return null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getEndTime() {
        return this.f33725c;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getHwChannelId() {
        return this.f33709L;
    }

    public String getIntent() {
        return this.f33726d;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public int getInterfaceDownloadConfig() {
        return AbstractC7558os.m46457E(getCtrlSwitchs());
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getLabel() {
        return this.f33738p;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public PromoteInfo getPromoteInfo() {
        return this.f33719V;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public RewardVerifyConfig getRewardVerifyConfig() {
        RewardVerifyConfig.Builder builder = new RewardVerifyConfig.Builder();
        builder.setData(m44647k());
        builder.setUserId(m44649l());
        return builder.build();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getShowId() {
        return this.f33730h;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public long getStartTime() {
        return this.f33739q;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getTaskId() {
        return this.f33737o;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getTransparencyTplUrl() {
        return this.f33716S;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getUniqueId() {
        return this.f33700C;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public String getWhyThisAd() {
        return TextUtils.isEmpty(this.f33743u) ? Constants.WHY_THIS_AD_DEFAULT_URL : this.f33743u;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public void gotoWhyThisAdPage(Context context) {
        m44604a(context);
    }

    /* renamed from: h */
    public Integer m44641h() {
        return this.f33746x;
    }

    public int hashCode() {
        String str = this.f33724b;
        return super.hashCode() & (str != null ? str.hashCode() : -1);
    }

    /* renamed from: i */
    public String m44643i() {
        return this.f33747y;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public boolean isAdIdInWhiteList() {
        Context contextMo44051d;
        if (AbstractC7558os.m46472k(getCtrlSwitchs())) {
            return true;
        }
        InterfaceC7308f interfaceC7308fM44013a = HiAd.m44013a();
        if (interfaceC7308fM44013a == null || (contextMo44051d = interfaceC7308fM44013a.mo44051d()) == null) {
            return false;
        }
        String packageName = contextMo44051d.getPackageName();
        return WhiteListPkgList.inWhiteList(packageName, C7830i.m48435e(contextMo44051d, packageName));
    }

    public boolean isAutoDownloadApp() {
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public boolean isExpired() {
        return this.f33725c < System.currentTimeMillis();
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public boolean isShowAppElement() {
        Integer num = this.f33713P;
        return num != null && num.intValue() == 1;
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public boolean isTransparencyOpen() {
        return this.f33717T && !TextUtils.isEmpty(this.f33716S);
    }

    /* renamed from: j */
    public String m44645j() {
        return this.f33748z;
    }

    /* renamed from: k */
    public String m44647k() {
        return this.f33727e;
    }

    /* renamed from: l */
    public String m44649l() {
        return this.f33728f;
    }

    /* renamed from: m */
    public List<C6957Om> m44651m() {
        return this.f33698A;
    }

    /* renamed from: n */
    public String m44653n() {
        return this.f33699B;
    }

    /* renamed from: o */
    public int m44655o() {
        return this.f33701D;
    }

    /* renamed from: p */
    public long m44657p() {
        return this.f33702E;
    }

    /* renamed from: q */
    public Integer m44659q() {
        return this.f33703F;
    }

    /* renamed from: r */
    public Integer m44661r() {
        return this.f33704G;
    }

    /* renamed from: s */
    public void m44663s(String str) {
        this.f33709L = str;
    }

    public void setAutoDownloadApp(boolean z10) {
        this.f33732j = z10;
    }

    public void setCustomData(String str) {
        this.f33727e = AbstractC7806cz.m48170d(str);
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        if (rewardVerifyConfig != null) {
            setCustomData(rewardVerifyConfig.getData());
            setUserId(rewardVerifyConfig.getUserId());
        }
    }

    public void setUserId(String str) {
        this.f33728f = AbstractC7806cz.m48170d(str);
    }

    @Override // com.huawei.openalliance.p169ad.inter.data.IAd
    @OuterVisible
    public void showAppDetailPage(Context context) {
        C6980bx.m41137a(context, this, (MaterialClickInfo) null);
    }

    /* renamed from: t */
    public List<AdSource> m44665t() {
        return this.f33706I;
    }

    /* renamed from: u */
    public String m44667u() {
        return this.f33707J;
    }

    /* renamed from: v */
    public AdContentData m44669v() {
        return this.f33729g;
    }

    /* renamed from: w */
    public int m44671w() {
        return this.f33736n;
    }

    /* renamed from: x */
    public int m44673x() {
        return this.f33711N;
    }

    /* renamed from: y */
    public Integer m44674y() {
        return this.f33713P;
    }

    /* renamed from: z */
    public boolean m44675z() {
        return this.f33717T;
    }

    /* renamed from: a */
    public void m44602a(int i10) {
        this.f33735m = i10;
        AdContentData adContentData = this.f33729g;
        if (adContentData != null) {
            adContentData.m39288c(i10);
        }
    }

    /* renamed from: b */
    public void m44614b(long j10) {
        this.f33725c = j10;
    }

    /* renamed from: c */
    public void m44621c(int i10) {
        this.f33742t = i10;
    }

    /* renamed from: d */
    public void m44628d(int i10) {
        this.f33701D = i10;
    }

    /* renamed from: e */
    public void m44633e(int i10) {
        this.f33736n = i10;
    }

    /* renamed from: f */
    public void m44637f(int i10) {
        this.f33711N = i10;
    }

    /* renamed from: g */
    public void m44640g(String str) {
        this.f33726d = str;
    }

    /* renamed from: h */
    public void m44642h(String str) {
        this.f33730h = str;
    }

    /* renamed from: i */
    public void m44644i(String str) {
        this.f33741s = str;
    }

    /* renamed from: j */
    public void m44646j(String str) {
        this.f33743u = str;
    }

    /* renamed from: k */
    public void m44648k(String str) {
        this.f33744v = str;
    }

    /* renamed from: l */
    public void m44650l(String str) {
        this.f33745w = str;
    }

    /* renamed from: m */
    public void m44652m(String str) {
        this.f33700C = str;
    }

    /* renamed from: n */
    public void m44654n(String str) {
        this.f33747y = str;
    }

    /* renamed from: o */
    public void m44656o(String str) {
        this.f33748z = str;
    }

    /* renamed from: p */
    public void m44658p(String str) {
        this.f33699B = str;
    }

    /* renamed from: q */
    public void m44660q(String str) {
        this.f33707J = str;
    }

    /* renamed from: r */
    public void m44662r(String str) {
        this.f33708K = str;
    }

    /* renamed from: s */
    public boolean m44664s() {
        return this.f33705H;
    }

    /* renamed from: t */
    public void m44666t(String str) {
        this.f33716S = str;
    }

    /* renamed from: u */
    public void m44668u(String str) {
        this.f33718U = str;
    }

    /* renamed from: v */
    public void m44670v(String str) {
        this.f33722Y = str;
    }

    /* renamed from: w */
    public void m44672w(String str) {
        this.f33731i = str;
    }

    /* renamed from: a */
    public void m44603a(long j10) {
        this.f33739q = j10;
    }

    /* renamed from: b */
    public void m44615b(Integer num) {
        this.f33746x = num;
    }

    /* renamed from: c */
    public void m44622c(long j10) {
        this.f33702E = j10;
    }

    /* renamed from: d */
    public void m44629d(Integer num) {
        this.f33704G = num;
    }

    /* renamed from: e */
    public void m44634e(Integer num) {
        this.f33713P = num;
    }

    /* renamed from: f */
    public void m44638f(String str) {
        this.f33738p = str;
    }

    /* renamed from: a */
    public void m44604a(Context context) {
        if (context == null) {
            AbstractC7185ho.m43823c("BaseAd", "context is null not call gotoWhyThisAdPage method");
        } else {
            AbstractC7741ao.m47549a(context, this);
        }
    }

    /* renamed from: b */
    public void m44616b(String str) {
        this.f33733k = str;
    }

    /* renamed from: c */
    public void m44623c(Integer num) {
        this.f33703F = num;
    }

    /* renamed from: d */
    public void m44630d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f33734l = str;
    }

    /* renamed from: e */
    public void m44635e(String str) {
        this.f33737o = str;
    }

    /* renamed from: a */
    public void m44605a(Context context, MaterialClickInfo materialClickInfo) {
        C6980bx.m41137a(context, this, materialClickInfo);
    }

    /* renamed from: b */
    public void m44617b(List<AdSource> list) {
        this.f33706I = list;
    }

    /* renamed from: c */
    public void m44624c(String str) {
        this.f33724b = str;
    }

    /* renamed from: d */
    public void m44631d(boolean z10) {
        this.f33717T = z10;
    }

    /* renamed from: a */
    public void m44606a(AdContentData adContentData) {
        this.f33729g = adContentData;
    }

    /* renamed from: b */
    public void m44618b(boolean z10) {
        AdContentData adContentData = this.f33729g;
        if (adContentData != null) {
            adContentData.m39282a(z10);
        }
    }

    /* renamed from: c */
    public void m44625c(List<AdvertiserInfo> list) {
        this.f33710M = list;
    }

    /* renamed from: a */
    public void m44607a(PromoteInfo promoteInfo) {
        this.f33719V = promoteInfo;
    }

    /* renamed from: b */
    public boolean m44619b() {
        return this.f33715R;
    }

    /* renamed from: c */
    public void m44626c(boolean z10) {
        this.f33705H = z10;
    }

    /* renamed from: a */
    public void m44608a(BiddingInfo biddingInfo) {
        this.f33720W = biddingInfo;
    }

    /* renamed from: a */
    public void m44609a(Integer num) {
        this.f33721X = num;
    }

    /* renamed from: a */
    public void m44610a(String str) {
        this.f33712O = str;
    }

    /* renamed from: a */
    public void m44611a(List<C6957Om> list) {
        this.f33698A = list;
    }

    /* renamed from: a */
    public void m44612a(boolean z10) {
        this.f33715R = z10;
    }
}
